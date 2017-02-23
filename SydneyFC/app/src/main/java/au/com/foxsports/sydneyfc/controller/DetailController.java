package au.com.foxsports.sydneyfc.controller;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import au.com.foxsports.sydneyfc.R;
import au.com.foxsports.sydneyfc.activity.DetailActivity;
import au.com.foxsports.sydneyfc.adapter.StatAdapter;
import au.com.foxsports.sydneyfc.model.Player;
import au.com.foxsports.sydneyfc.rest.ApiClient;
import au.com.foxsports.sydneyfc.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bclark on 23/02/17.
 */

public class DetailController {

    private Player player;
    private String playerPosition;

    public final static String API_KEY = "aaf6c0ce-a364-4e20-bc34-003a722274dc";
    public final static String URL = "http://media.foxsports.com.au/match-centre/includes/images/headshots/landscape/hal/";

    public DetailController(Bundle bundle, Callback<Player> callback){

        int playerID = bundle.getInt("playerID");
        playerPosition = bundle.getString("playerPosition");
        player = new Player(playerID);
        doApiCall(playerID, callback);

    }

    private void doApiCall(int playerID, Callback<Player> callback){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Player> call = apiService.getPlayerStats(playerID,API_KEY);
        call.enqueue(callback);
    }

    public void setUpPlayerStats(Response<Player> response) {
        if(response.body() != null) {
            player = response.body();
            player.setDefaultPosition(playerPosition);

        }

    }

    public Player getPlayer() {
        return player;
    }
}
