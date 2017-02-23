package au.com.foxsports.sydneyfc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import au.com.foxsports.sydneyfc.R;
import au.com.foxsports.sydneyfc.model.PlayerStatistics;

/**
 * Created by bclark on 22/02/17.
 */


public class StatAdapter extends RecyclerView.Adapter<StatAdapter.StatViewHolder> {

    private PlayerStatistics playerStatistics;
    private int rowLayout;
    private Context context;


    public static class StatViewHolder extends RecyclerView.ViewHolder{
        TextView statType;
        TextView statValue;

        public StatViewHolder(View view) {
            super(view);
            statType = (TextView) view.findViewById(R.id.statType);
            statValue = (TextView) view.findViewById(R.id.statValue);
        }

    }

    public StatAdapter(PlayerStatistics playerStatistics, int rowLayout, Context context) {
        this.rowLayout = rowLayout;
        this.context = context;
        this.playerStatistics = playerStatistics;
    }

    @Override
    public StatAdapter.StatViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        StatViewHolder statViewHolder = new StatViewHolder(view);
        return statViewHolder;
    }


    @Override
    public void onBindViewHolder(StatViewHolder holder, final int position) {
        holder.statType.setText(playerStatistics.getStatisticModelList().get(position).getType());
        holder.statValue.setText(playerStatistics.getStatisticModelList().get(position).getValue());
    }



    @Override
    public int getItemCount() {
        return playerStatistics.getStatisticModelList().size();
    }
}