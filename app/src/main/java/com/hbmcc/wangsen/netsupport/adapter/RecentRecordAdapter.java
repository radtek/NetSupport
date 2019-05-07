package com.hbmcc.wangsen.netsupport.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hbmcc.wangsen.netsupport.R;
import com.hbmcc.wangsen.netsupport.telephony.NetworkStatus;

import java.util.List;

public class RecentRecordAdapter extends RecyclerView.Adapter<RecentRecordAdapter.ViewHolder> {

    private List<NetworkStatus> recentNetworkStatusRecordList;

    public RecentRecordAdapter(List<NetworkStatus> recentNetworkStatusRecordList) {
        this.recentNetworkStatusRecordList = recentNetworkStatusRecordList;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NetworkStatus networkStatus = recentNetworkStatusRecordList.get(position);
        holder.textViewTime.setText(networkStatus.time + "");
        holder.textViewTAC.setText(networkStatus.lteServingCellTower.tac + "");
        holder.textViewPCI.setText(networkStatus.lteServingCellTower.pci + "");
        holder.textViewEnb.setText(networkStatus.lteServingCellTower.enbId + "");
        holder.textViewEnbCellId.setText(networkStatus.lteServingCellTower.enbCellId + "");
        holder.textViewRSRP.setText(networkStatus.lteServingCellTower.signalStrength + "");
        holder.textViewSINR.setText(networkStatus.lteServingCellTower.sinr + "");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .recyclerview_item_recent_record, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return recentNetworkStatusRecordList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTime;
        TextView textViewTAC;
        TextView textViewPCI;
        TextView textViewEnb;
        TextView textViewEnbCellId;
        TextView textViewRSRP;
        TextView textViewSINR;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewTime = itemView.findViewById(R.id.textview_recyclerview_item_recent_record_time);
            textViewTAC = itemView.findViewById(R.id.textview_recyclerview_item_recent_record_tac);
            textViewPCI = itemView.findViewById(R.id.textview_recyclerview_item_recent_record_pci);
            textViewEnb = itemView.findViewById(R.id.textview_recyclerview_item_recent_record_enbid);
            textViewEnbCellId = itemView.findViewById(R.id
                    .textview_recyclerview_item_recent_record_enbcellid);
            textViewRSRP = itemView.findViewById(R.id.textview_recyclerview_item_recent_record_rsrp);
            textViewSINR = itemView.findViewById(R.id.textview_recyclerview_item_recent_record_sinr);
        }
    }
}
