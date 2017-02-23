package au.com.foxsports.sydneyfc.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bclark on 23/02/17.
 */

public class ApiClient {

    public static final String BASE_URL = "http://api.stats.foxsports.com.au/3.0/api/sports/football/series/1/seasons/121/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
