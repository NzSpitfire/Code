package au.com.foxsports.sydneyfc.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import au.com.foxsports.sydneyfc.R;
import au.com.foxsports.sydneyfc.adapter.PlayerAdapter;
import au.com.foxsports.sydneyfc.model.Player;


/**
 * Created by bclark on 23/02/17.
 */

public class ViewFragment extends Fragment {
    private List<Player> players;



    public ViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.players_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (players != null){

            PlayerAdapter playerAdapter = new PlayerAdapter(new ArrayList<Player>(players), R.layout.list_item_player, getContext());
            playerAdapter.SetOnItemClickListener(new PlayerAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int position, String id) {
                    System.out.println("onItemClick" + id);
                }
            });
            recyclerView.setAdapter(playerAdapter);

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}