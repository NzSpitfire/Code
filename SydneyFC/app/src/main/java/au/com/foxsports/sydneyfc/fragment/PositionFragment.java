package au.com.foxsports.sydneyfc.fragment;

import android.content.Intent;
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
import au.com.foxsports.sydneyfc.activity.DetailActivity;
import au.com.foxsports.sydneyfc.adapter.PlayerAdapter;
import au.com.foxsports.sydneyfc.controller.PositionController;
import au.com.foxsports.sydneyfc.model.Player;


/**
 * Created by bclark on 23/02/17.
 */

public class PositionFragment extends Fragment {
    private PositionController controller;

    public PositionFragment() {
        controller = new PositionController();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (controller.getPlayers() != null){
            setupRecyclerView().setAdapter(setupPlayerAdapter());
        }
    }

    private RecyclerView setupRecyclerView(){
        final RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.players_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return recyclerView;
    }

    private PlayerAdapter setupPlayerAdapter(){
        PlayerAdapter playerAdapter = new PlayerAdapter(new ArrayList<Player>(controller.getPlayers()), R.layout.list_item_player, getActivity());
        playerAdapter.SetOnItemClickListener(new PlayerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position, String id) {
                System.out.println("onItemClick" + id);
            }
        });
        return playerAdapter;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    public void showDetail(Player player){
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("playerID", player.getId());
        intent.putExtra("playerPosition", player.getDefaultPosition());
        startActivity(intent);
    }

    public PositionController getController() {
        return controller;
    }
}