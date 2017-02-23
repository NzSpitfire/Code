package au.com.foxsports.sydneyfc.controller;

import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

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

    public final static String API_KEY = "aaf6c0ce-a364-4e20-bc34-003a722274dc";
    private ViewPagerAdapter adapter;

    public MainController(Callback<List<Player>> callback) {
        doAPICall(callback);
    }

    private void doAPICall(Callback<List<Player>> callback){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Player>> call = apiService.getPlayers(API_KEY);
        call.enqueue(callback);
    }

    public ViewPager setupViewPager(ViewPagerAdapter adapter, ViewPager viewPager, Response<List<Player>> response) {
        this.adapter = adapter;
        List<Player> players = response.body();
        Team team = new Team(players);
        team = teamSort(team);
        addFragmentToAdapter(team, "Forward");
        addFragmentToAdapter(team, "Midfielder");
        addFragmentToAdapter(team, "Defender");
        addFragmentToAdapter(team, "Goalkeeper");
        viewPager.setAdapter(adapter);
        return viewPager;
    }

    private Team teamSort(Team team){
        Team newTeam = team;
        newTeam.setPlayerByPosition(new HashMap<String, List<Player>>());

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
            List<Player> list = newTeam.getPlayerByPosition().get(player.getDefaultPosition());
            if(list == null){
                list = new ArrayList<>();
            }
            if (!player.getDefaultPosition().equals("")){
                list.add(player);
                newTeam.getPlayerByPosition().put(player.getDefaultPosition(),list);
            }

        }
        return team;
    }

    private void addFragmentToAdapter(Team team, String position){
        PositionFragment positionFragment = new PositionFragment();
        positionFragment.getController().setPlayers(team.getPlayerByPosition().get(position));
        adapter.addFragment(positionFragment, position);
    }

}
