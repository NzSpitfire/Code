package au.com.foxsports.sydneyfc.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import java.util.List;
import au.com.foxsports.sydneyfc.R;
import au.com.foxsports.sydneyfc.Utils;
import au.com.foxsports.sydneyfc.adapter.ViewPagerAdapter;
import au.com.foxsports.sydneyfc.controller.MainController;
import au.com.foxsports.sydneyfc.model.Player;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bclark on 22/02/17.
 */

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mtTbLayout;
    private ViewPager mViewPager;
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainController mMainController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUI();
        requestPlayers();
    }

    private void requestPlayers(){
        Callback<List<Player>> callback = new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                setupViewPager(mViewPager, response);
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                Log.e(TAG, t.toString());
                showErrorMessage("Error",t.toString());

            }
        };

        mMainController = new MainController(this);
        if(Utils.isNetworkAvailable(this)){
            mMainController.doAPICall(callback);
        }
        else{
            showErrorMessage(getString(R.string.network_error_title),getString(R.string.network_error_message));
        }
    }

    private void setupUI(){
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mtTbLayout = (TabLayout) findViewById(R.id.tabs);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("");

        TextView title = (TextView) findViewById(R.id.appTitle);
        title.setText(R.string.app_name);

    }

    private void setupViewPager(ViewPager viewPager, Response<List<Player>> response) {
        ViewPager pager = mMainController.setupViewPager(new ViewPagerAdapter(getSupportFragmentManager()),viewPager,response);
        mtTbLayout.setupWithViewPager(pager);
    }


    public void showDetail(Player player){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(getString(R.string.playerId), player.getId());
        intent.putExtra(getString(R.string.player_position), player.getDefaultPosition());
        startActivity(intent);
    }

    private void showErrorMessage(String title, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
        alertDialog.show();
    }


}
