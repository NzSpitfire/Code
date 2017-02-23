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

import com.bumptech.glide.Glide;
import au.com.foxsports.sydneyfc.R;
import au.com.foxsports.sydneyfc.adapter.StatAdapter;
import au.com.foxsports.sydneyfc.controller.DetailController;
import au.com.foxsports.sydneyfc.model.Player;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bclark on 23/02/17.
 */

public class DetailActivity extends AppCompatActivity {

    private DetailController controller;
    private Toolbar toolbar;
    private TextView title;
    private TextView positionTitle;
    private ImageView imageView;

    public static final String TAG = DetailActivity.class.getSimpleName();
    private ProgressDialog loadingDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        showLoadiDialog();
        setupUI();

        Callback callback = new Callback<Player>() {
            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                setUpPlayerStats(response);
            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {
                Log.e(DetailActivity.TAG, t.toString());
            }
        };
        controller = new DetailController(bundle,callback);

    }


    private void setUpPlayerStats(Response<Player> response) {
        loadingDialog.dismiss();
        if(response.body() != null) {
            controller.setUpPlayerStats(response);
            title.setText(controller.getPlayer().getFullName());
            positionTitle.setText(controller.getPlayer().getDefaultPosition());
            setImageView(imageView);
            setupRecyclerView();
        }
        else{
            showErrorMessage();
        }
    }

    private void setupUI(){
        setContentView(R.layout.detail_activity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) findViewById(R.id.toolbarTitle);
        positionTitle = (TextView) findViewById(R.id.positionTitle);
        imageView = (ImageView) findViewById(R.id.imageView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    private void setupRecyclerView(){
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.stats_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (controller.getPlayer().getPlayerStatistics() != null) {
            StatAdapter statAdapter = new StatAdapter(controller.getPlayer().getPlayerStatistics(), R.layout.list_item_stat, getApplicationContext());
            recyclerView.setAdapter(statAdapter);
        }
    }


    private void setImageView(ImageView imageView){
        Glide.with(this)
                .load(DetailController.URL + controller.getPlayer().getId() + ".jpg")
                .placeholder(R.drawable.headshot_blank)
                .into(imageView);
    }

    private void showLoadiDialog(){
        loadingDialog = new ProgressDialog(this);
        loadingDialog.setMessage("Loading..");
        loadingDialog.setTitle("Getting Player PlayerStatistics");
        loadingDialog.setIndeterminate(false);
        loadingDialog.setCancelable(true);
        loadingDialog.show();
    }

    private void showErrorMessage(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Missing Player PlayerStatistics");
        alertDialog.setMessage("No PlayerStatistics were found for this player.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}