package au.com.foxsports.sydneyfc.controller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
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

    public DetailController(Bundle bundle){

        int playerID = bundle.getInt("playerID");
        playerPosition = bundle.getString("playerPosition");
        player = new Player(playerID);

    }

    public void doApiCall(Callback<Player> callback){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Player> call = apiService.getPlayerStats(player.getId(),API_KEY);
        call.enqueue(callback);
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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
