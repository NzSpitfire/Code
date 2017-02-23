package au.com.foxsports.sydneyfc.rest;


import java.util.List;

import au.com.foxsports.sydneyfc.model.Player;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by bclark on 23/02/17.
 */


public interface ApiInterface {
    @GET("teams/60007/players.json")
    Call<List<Player>> getPlayers(@Query("userkey") String apiKey);

    @GET("players/{id}/stats.json")
    Call<Player> getPlayerStats(@Path("id") int id, @Query("userkey") String apiKey);
}
