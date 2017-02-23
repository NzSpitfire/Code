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

    private PlayerStatistics mPlayerStatistics;
    private int mRowLayoutId;
    private Context mCtx;


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
        this.mRowLayoutId = rowLayout;
        this.mCtx = context;
        this.mPlayerStatistics = playerStatistics;
    }

    @Override
    public StatAdapter.StatViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mRowLayoutId, parent, false);
        StatViewHolder statViewHolder = new StatViewHolder(view);
        return statViewHolder;
    }


    @Override
    public void onBindViewHolder(StatViewHolder holder, final int position) {
        holder.statType.setText(mPlayerStatistics.getStatisticModelList().get(position).getType());
        holder.statValue.setText(mPlayerStatistics.getStatisticModelList().get(position).getValue());
    }



    @Override
    public int getItemCount() {
        return mPlayerStatistics.getStatisticModelList().size();
    }
}