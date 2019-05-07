package com.hbmcc.wangsen.netsupport.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hbmcc.wangsen.netsupport.R;
import com.hbmcc.wangsen.netsupport.telephony.LteBand;
import com.hbmcc.wangsen.netsupport.telephony.cellinfo.LteCellInfo;

import java.util.List;

public class NeighbourCellAdapter extends RecyclerView.Adapter<NeighbourCellAdapter.ViewHolder> {
    private List<LteCellInfo> neighbourCellList;

    public NeighbourCellAdapter(List<LteCellInfo> neighbourCellList) {
        this.neighbourCellList = neighbourCellList;
    }

    @Override
    public void onBindViewHolder(NeighbourCellAdapter.ViewHolder holder, int position) {
        LteCellInfo neighbourCell = neighbourCellList.get(position);
        holder.textViewType.setText(neighbourCell.cellType + "");
        holder.textViewEarfcn.setText(neighbourCell.lteEarFcn + "");
        holder.textViewPCI.setText(neighbourCell.pci + "");
        holder.textViewRSRP.setText(neighbourCell.signalStrength + "");
        holder.textViewBand.setText(LteBand.getBand(neighbourCell.lteEarFcn) + "");
        if (LteBand.getDuplexMode(neighbourCell.lteEarFcn) == LteBand.TDD) {
            holder.textViewFreq.setText(LteBand.getDlCenterFreq(
                    neighbourCell.lteEarFcn) + "");
        } else if (LteBand.getDuplexMode(neighbourCell.lteEarFcn) == LteBand.FDD) {
            holder.textViewFreq.setText(LteBand.getDlCenterFreq(
                    neighbourCell.lteEarFcn) + "/" + LteBand
                    .getUlCenterFreq(
                            neighbourCell.lteEarFcn));
        }
    }

    @Override
    public NeighbourCellAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .recyclerview_item_neighbourcellinfo, parent, false);
        return new NeighbourCellAdapter.ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return neighbourCellList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewType;
        TextView textViewPCI;
        TextView textViewRSRP;
        TextView textViewEarfcn;
        TextView textViewBand;
        TextView textViewFreq;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewType = itemView.findViewById(R.id.textview_recyclerview_item_neighbourcellinfo_type);
            textViewEarfcn = itemView.findViewById(R.id
                    .textview_recyclerview_item_ltebasestationcell_earfcn);
            textViewPCI = itemView.findViewById(R.id.textview_recyclerview_item_ltebasestationcell_pci);
            textViewRSRP = itemView.findViewById(R.id.textview_recyclerview_item_neighbourcellinfo_rsrp);
            textViewBand = itemView.findViewById(R.id
                    .textview_recyclerview_item_neighbourcellinfo_band);
            textViewFreq = itemView.findViewById(R.id
                    .textview_recyclerview_item_neighbourcellinfo_freq);
        }
    }
}
