package au.com.foxsports.sydneyfc.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import au.com.foxsports.sydneyfc.R;
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

public class DetailActivity extends AppCompatActivity {
    private Player player;
    private String playerPosition;
    private Toolbar toolbar;
    private TextView title;
    private TextView positionTitle;
    private ImageView imageView;
    private final static String API_KEY = "aaf6c0ce-a364-4e20-bc34-003a722274dc";
    private final static String URL = "http://media.foxsports.com.au/match-centre/includes/images/headshots/landscape/hal/";
    private static final String TAG = DetailActivity.class.getSimpleName();
    private ProgressDialog loadingDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingDialog = new ProgressDialog(this);
        loadingDialog.setMessage("Loading..");
        loadingDialog.setTitle("Getting Player Stats");
        loadingDialog.setIndeterminate(false);
        loadingDialog.setCancelable(true);
        loadingDialog.show();

        Bundle bundle = getIntent().getExtras();
        int playerID = bundle.getInt("playerID");
        playerPosition = bundle.getString("playerPosition");
        player = new Player(playerID);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Player> call = apiService.getPlayerStats(player.getId(),API_KEY);
        call.enqueue(new Callback<Player>() {
            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                setUpPlayerStats(response);
            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void setUpPlayerStats(Response<Player> response) {
        loadingDialog.dismiss();
        setContentView(R.layout.detail_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) findViewById(R.id.toolbarTitle);
        positionTitle = (TextView) findViewById(R.id.positionTitle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        imageView = (ImageView) findViewById(R.id.imageView);
        if(response.body() != null) {
            player = response.body();
            player.setDefaultPosition(playerPosition);
            title.setText(player.getFullName());
            positionTitle.setText(player.getDefaultPosition());

            Glide.with(this)
                    .load(URL + player.getId() + ".jpg")
                    .placeholder(R.drawable.headshot_blank)
                    .into(imageView);

            final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.stats_recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            if (player.getStats() != null) {
                StatAdapter statAdapter = new StatAdapter(player.getStats(), R.layout.list_item_stat, getApplicationContext());
                recyclerView.setAdapter(statAdapter);
            }
        }
        else{
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Missing Player Stats");
            alertDialog.setMessage("No Stats were found for this player.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    });
            alertDialog.show();
        }
    }
}