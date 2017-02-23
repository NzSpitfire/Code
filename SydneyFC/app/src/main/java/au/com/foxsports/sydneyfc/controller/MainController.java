package au.com.foxsports.sydneyfc.controller;

import android.content.Context;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import au.com.foxsports.sydneyfc.R;
import au.com.foxsports.sydneyfc.adapter.ViewPagerAdapter;
import au.com.foxsports.sydneyfc.fragment.PositionFragment;
import au.com.foxsports.sydneyfc.model.Player;
import au.com.foxsports.sydneyfc.model.Team;
import au.com.foxsports.sydneyfc.rest.ApiClient;
import au.com.foxsports.sydneyfc.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bclark on 24/02/17.
 */

public class MainController {

    private ViewPagerAdapter mAdapter;
    private Context mCtx;

    public MainController(Context context)
    {
        this.mCtx = context;
    }

    public void doAPICall(Callback<List<Player>> callback){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Player>> call = apiService.getPlayers(mCtx.getString(R.string.api_key));
        call.enqueue(callback);
    }

    public ViewPager setupViewPager(ViewPagerAdapter adapter, ViewPager viewPager, Response<List<Player>> response) {
        this.mAdapter = adapter;
        List<Player> players = response.body();
        Team team = new Team(players);
        team = teamSort(team);
        addFragmentToAdapter(team, mCtx.getString(R.string.position_forward));
        addFragmentToAdapter(team, mCtx.getString(R.string.position_midfielder));
        addFragmentToAdapter(team, mCtx.getString(R.string.position_defender));
        addFragmentToAdapter(team, mCtx.getString(R.string.position_goalkeeper));
        viewPager.setAdapter(adapter);
        return viewPager;
    }

    private Team teamSort(Team team){
        team.setPlayerByPosition(new HashMap<String, List<Player>>());

        List<Player> playersList = team.getPlayersList();
        Collections.sort(playersList, new Comparator<Player>()
        {
            @Override
            public int compare(Player player1, Player player2)
            {
                return player1.getSurname().compareToIgnoreCase(player2.getSurname());
            }
        });

        for (Player player:playersList) {
            List<Player> list = team.getPlayerByPosition().get(player.getDefaultPosition());
            if(list == null){
                list = new ArrayList<>();
            }
            if (!player.getDefaultPosition().equals("")){
                list.add(player);
                team.getPlayerByPosition().put(player.getDefaultPosition(),list);
            }

        }
        return team;
    }

    private void addFragmentToAdapter(Team team, String position){
        PositionFragment positionFragment = new PositionFragment();
        positionFragment.getController().setPlayers(team.getPlayerByPosition().get(position));
        mAdapter.addFragment(positionFragment, position);
    }

}
