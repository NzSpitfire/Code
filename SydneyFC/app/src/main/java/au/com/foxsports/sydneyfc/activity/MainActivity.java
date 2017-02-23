package au.com.foxsports.sydneyfc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import au.com.foxsports.sydneyfc.R;
import au.com.foxsports.sydneyfc.adapter.ViewPagerAdapter;
import au.com.foxsports.sydneyfc.fragment.ViewFragment;
import au.com.foxsports.sydneyfc.model.Player;
import au.com.foxsports.sydneyfc.model.Team;
import au.com.foxsports.sydneyfc.rest.ApiClient;
import au.com.foxsports.sydneyfc.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bclark on 22/02/17.
 */

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static final String TAG = MainActivity.class.getSimpleName();
    private final static String API_KEY = "aaf6c0ce-a364-4e20-bc34-003a722274dc";
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("");
        TextView title = (TextView) findViewById(R.id.appTitle);
        title.setText("Sydney FC");
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Player>> call = apiService.getPlayers(API_KEY);
        call.enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                setupViewPager(viewPager, response);
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void setupViewPager(ViewPager viewPager, Response<List<Player>> response) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        List<Player> players = response.body();
        Team team = new Team(players);
        addFragmenToAdapter(team, "Forward");
        addFragmenToAdapter(team, "Midfielder");
        addFragmenToAdapter(team, "Defender");
        addFragmenToAdapter(team, "Goalkeeper");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void addFragmenToAdapter(Team team, String position){
        ViewFragment viewFragment = new ViewFragment();
        viewFragment.setPlayers(team.getPlayerByPosition().get(position));
        adapter.addFragment(viewFragment, position);
    }

    public void showDetail(Player player){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("playerID", player.getId());
        intent.putExtra("playerPosition", player.getDefaultPosition());
        startActivity(intent);
    }


}
