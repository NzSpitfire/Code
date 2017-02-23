package au.com.foxsports.sydneyfc.controller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import au.com.foxsports.sydneyfc.R;
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

    private Player mPlayer;
    private String mPlayerPosition;
    private Context mCtx;

    public DetailController(Context context, Bundle bundle) {
        mCtx = context;
        int playerID = bundle.getInt(mCtx.getString(R.string.playerId));
        mPlayerPosition = bundle.getString(mCtx.getString(R.string.player_position));
        mPlayer = new Player(playerID);
    }

    public void doApiCall(Callback<Player> callback) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Player> call = apiService.getPlayerStats(mPlayer.getId(), mCtx.getString(R.string.api_key));
        call.enqueue(callback);
    }

    public void setUpPlayerStats(Response<Player> response) {
        if (response == null || response.body() == null)
            throw new IllegalArgumentException();
        mPlayer = response.body();
        mPlayer.setDefaultPosition(mPlayerPosition);
    }

    public Player getmPlayer() {
        return mPlayer;
    }
}
