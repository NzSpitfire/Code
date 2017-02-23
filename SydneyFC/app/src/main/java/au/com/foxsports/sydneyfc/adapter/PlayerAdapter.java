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

    private List<Player> mPlayers;
    private int mRowLayoutId;
    private Context mCtx;
    OnItemClickListener mItemClickListener;


    public class PlayerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
            ((MainActivity) mCtx).showDetail(player);
        }
    }

    public PlayerAdapter(List<Player> players, int rowLayout, Context context) {
        this.mPlayers = players;
        this.mRowLayoutId = rowLayout;
        this.mCtx = context;

    }

    @Override
    public PlayerAdapter.PlayerViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mRowLayoutId, parent, false);
        PlayerViewHolder playerViewHolder = new PlayerViewHolder(view);
        return playerViewHolder;
    }


    @Override
    public void onBindViewHolder(PlayerViewHolder holder, final int position) {
        holder.playerName.setText(mPlayers.get(position).getFullName());
        holder.player = mPlayers.get(position);
        Glide.with(mCtx)
                .load(mCtx.getString(R.string.image_url) + mPlayers.get(position).getId() + ".jpg")
                .placeholder(R.drawable.headshot_blank)
                .into(holder.playerImage);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, String id);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mPlayers.size();
    }
}