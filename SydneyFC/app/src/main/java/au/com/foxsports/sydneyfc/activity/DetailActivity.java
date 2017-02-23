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
import au.com.foxsports.sydneyfc.Utils;
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

    private DetailController mDetailController;
    private Toolbar mToolbar;
    private TextView mTitleTextView;
    private TextView mPositionTitleTextView;
    private ImageView mImageView;

    public static final String TAG = DetailActivity.class.getSimpleName();
    private ProgressDialog loadingDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLoadiDialog();
        setupUI();
        requestPlayerDetails();
    }

    private void requestPlayerDetails(){
        Bundle bundle = getIntent().getExtras();
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
        mDetailController = new DetailController(this, bundle);
        if(Utils.isNetworkAvailable(this)){
            mDetailController.doApiCall(callback);
        }
        else{
            showErrorMessage(getString(R.string.network_error_title),getString(R.string.network_error_message));
        }
    }


    private void setUpPlayerStats(Response<Player> response) {
        loadingDialog.dismiss();
        if(response.body() != null) {
            mDetailController.setUpPlayerStats(response);
            mTitleTextView.setText(mDetailController.getmPlayer().getFullName());
            mPositionTitleTextView.setText(mDetailController.getmPlayer().getDefaultPosition());
            setImageView(mImageView);
            setupRecyclerView();
        }
        else{
            showErrorMessage(getString(R.string.missing_player_stats_title), getString(R.string.missing_player_stats_msg));
        }
    }

    private void setupUI(){
        setContentView(R.layout.detail_activity);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitleTextView = (TextView) findViewById(R.id.toolbarTitle);
        mPositionTitleTextView = (TextView) findViewById(R.id.positionTitle);
        mImageView = (ImageView) findViewById(R.id.imageView);

        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }
    }

    private void setupRecyclerView(){
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.stats_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (mDetailController.getmPlayer().getPlayerStatistics() != null) {
            StatAdapter statAdapter = new StatAdapter(mDetailController.getmPlayer().getPlayerStatistics(),
                    R.layout.list_item_stat, getApplicationContext());
            recyclerView.setAdapter(statAdapter);
        }
    }


    private void setImageView(ImageView imageView){
        Glide.with(this)
                .load(getString(R.string.image_url) + mDetailController.getmPlayer().getId() + ".jpg")
                .placeholder(R.drawable.headshot_blank)
                .into(imageView);
    }

    private void showLoadiDialog(){
        loadingDialog = new ProgressDialog(this);
        loadingDialog.setMessage(getString(R.string.loading_msg));
        loadingDialog.setTitle(getString(R.string.loading_title));
        loadingDialog.setIndeterminate(false);
        loadingDialog.setCancelable(true);
        loadingDialog.show();
    }

    private void showErrorMessage(String title, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.btn_ok),
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