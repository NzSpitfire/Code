package au.com.foxsports.sydneyfc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import au.com.foxsports.sydneyfc.R;
import au.com.foxsports.sydneyfc.activity.MainActivity;
import au.com.foxsports.sydneyfc.model.Player;

/**
 * Created by bclark on 22/02/17.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    private List<Player> players;
    private int rowLayout;
    private static Context context;
    OnItemClickListener mItemClickListener;
    private static final String URL = "http://media.foxsports.com.au/match-centre/includes/images/headshots/landscape/hal/";


    public static class PlayerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        LinearLayout teamLayout;
        TextView playerName;
        ImageView playerImage;
        Player player;

        public PlayerViewHolder(View view) {
            super(view);
            teamLayout = (LinearLayout) view.findViewById(R.id.layout);
            playerName = (TextView) view.findViewById(R.id.playerName);
            playerImage = (ImageView) view.findViewById(R.id.playerImage);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ((MainActivity)context).showDetail(player);
        }
    }

    public PlayerAdapter(List<Player> players, int rowLayout, Context context) {
        this.players = players;
        this.rowLayout = rowLayout;
        this.context = context;

    }

    @Override
    public PlayerAdapter.PlayerViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        PlayerViewHolder playerViewHolder = new PlayerViewHolder(view);
        return playerViewHolder;
    }


    @Override
    public void onBindViewHolder(PlayerViewHolder holder, final int position) {
        holder.playerName.setText(players.get(position).getFullName());
        holder.player = players.get(position);
        Glide.with(context)
                .load(URL + players.get(position).getId() + ".jpg")
                .placeholder(R.drawable.headshot_blank)
                .into(holder.playerImage);



    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position, String id);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public int getItemCount() {
        return players.size();
    }
}