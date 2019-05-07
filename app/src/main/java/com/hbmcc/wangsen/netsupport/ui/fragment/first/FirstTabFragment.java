package com.hbmcc.wangsen.netsupport.ui.fragment.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hbmcc.wangsen.netsupport.R;
import com.hbmcc.wangsen.netsupport.adapter.NeighbourCellAdapter;
import com.hbmcc.wangsen.netsupport.adapter.RecentRecordAdapter;
import com.hbmcc.wangsen.netsupport.base.BaseMainFragment;
import com.hbmcc.wangsen.netsupport.database.LteBasestationCell;
import com.hbmcc.wangsen.netsupport.event.TabSelectedEvent;
import com.hbmcc.wangsen.netsupport.event.UpdateUeStatusEvent;
import com.hbmcc.wangsen.netsupport.telephony.LteBand;
import com.hbmcc.wangsen.netsupport.telephony.NetworkStatus;
import com.hbmcc.wangsen.netsupport.telephony.cellinfo.LteCellInfo;
import com.hbmcc.wangsen.netsupport.ui.fragment.MainFragment;
import com.hbmcc.wangsen.netsupport.util.NumberFormat;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;

public class FirstTabFragment extends BaseMainFragment {
    private static final String TAG = "FirstTabFragment";
    ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
    RecentRecordAdapter recentRecordAdapter;
    NeighbourCellAdapter neighbourCellAdapter;
    long recentNetworkStatusCnt;
    long recentSumSignalStrength;
    double recentAvgSignalStrength;
    private Toolbar toolbarMain;
    private TextView textViewFragmentFirstTabOperator;
    private TextView textViewFragmentFirstTabIMSI;
    private TextView textViewFragmentFirstTabIMEI;
    private TextView textViewFragmentFirstTabUEModel;
    private TextView textViewFragmentFirstTabAndroidVersion;
    private TextView textViewFragmentFirstTabCurrentLocName;
    private TextView textViewFragmentFirstTabLongitude;
    private TextView textViewFragmentFirstTabLatitude;
    private TextView textViewFragmentFirstTabTAC;
    private TextView textViewFragmentFirstTabPCI;
    private TextView textViewFragmentFirstTabCGI;
    private TextView textViewFragmentFirstTabEarFcn;
    private TextView textViewFragmentFirstTabBand;
    private TextView textViewFragmentFirstTabFrequency;
    private TextView textViewFragmentFirstTabRSRP;
    private TextView textViewFragmentFirstTabRSRQ;
    private TextView textViewFragmentFirstTabSINR;
    private TextView textViewFragmentFirstTabAltitude;
    private TextView textViewFragmentFirstTabCellChsName;
    private TextView textViewFragmentFirstTabRecentAvgSignalStrength;
    private TextView textViewFragmentFirstTabNeighbourCell;
    private RecyclerView recyclerViewFragmentFirstTabRecentRecord;
    private RecyclerView recyclerViewFragmentFirstTabNeighbourCellInfo;
    private List<NetworkStatus> recentNetworkStatusRecordList;
    private List<LteCellInfo> neighbourCellList;
    private Button btnFragmentFirstTabConvert;
    private LinearLayout linearlayoutFragmentFirstTabRecentRecord;
    private LinearLayout linearlayoutFragmentFirstTabNeighbourCell;
    private List<LteBasestationCell> litepalLteBasestationCellList;


    public static FirstTabFragment newInstance() {
        Bundle args = new Bundle();
        FirstTabFragment fragment = new FirstTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_tab, container,
                false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        EventBusActivityScope.getDefault(_mActivity).register(this);

        toolbarMain = view.findViewById(R.id.toolbar);
        toolbarMain.setTitle(getString(R.string.app_name));
        textViewFragmentFirstTabOperator = view.findViewById(R.id.textView_fragment_first_tab_operator);
        textViewFragmentFirstTabIMSI = view.findViewById(R.id.textView_fragment_first_tab_IMSI);
        textViewFragmentFirstTabIMEI = view.findViewById(R.id.textView_fragment_first_tab_IMEI);
        textViewFragmentFirstTabUEModel = view.findViewById(R.id.textView_fragment_first_tab_uemodel);
        textViewFragmentFirstTabAndroidVersion = view.findViewById(R.id.textView_fragment_first_tab_androidversion);
        textViewFragmentFirstTabCurrentLocName = view.findViewById(R.id.textView_fragment_first_tab_currentlocname);
        textViewFragmentFirstTabLongitude = view.findViewById(R.id.textView_fragment_first_tab_longitude);
        textViewFragmentFirstTabLatitude = view.findViewById(R.id.textView_fragment_first_tab_latitude);
        textViewFragmentFirstTabTAC = view.findViewById(R.id.textView_fragment_first_tab_tac);
        textViewFragmentFirstTabPCI = view.findViewById(R.id.textView_fragment_first_tab_pci);
        textViewFragmentFirstTabCGI = view.findViewById(R.id.textView_fragment_first_tab_cgi);
        textViewFragmentFirstTabEarFcn = view.findViewById(R.id.textView_fragment_first_tab_earfcn);
        textViewFragmentFirstTabBand = view.findViewById(R.id.textView_fragment_first_tab_band);
        textViewFragmentFirstTabFrequency = view.findViewById(R.id.textView_fragment_first_tab_frequency);
        textViewFragmentFirstTabRSRP = view.findViewById(R.id.textView_fragment_first_tab_RSRP);
        textViewFragmentFirstTabRSRQ = view.findViewById(R.id.textView_fragment_first_tab_RSRQ);
        textViewFragmentFirstTabSINR = view.findViewById(R.id.textView_fragment_first_tab_SINR);
        textViewFragmentFirstTabAltitude = view.findViewById(R.id.textView_fragment_first_tab_altitude);
        textViewFragmentFirstTabCellChsName = view.findViewById(R.id.textView_fragment_first_tab_cellchsname);
        btnFragmentFirstTabConvert = view.findViewById(R.id.btn_fragment_first_tab_convert);
        linearlayoutFragmentFirstTabRecentRecord = view.findViewById(R.id
                .linearlayout_fragment_first_tab_recent_record);
        linearlayoutFragmentFirstTabNeighbourCell = view.findViewById(R.id
                .linearlayout_fragment_first_tab_neighbour_cell);
        textViewFragmentFirstTabRecentAvgSignalStrength = view.findViewById(R.id.textView_fragment_first_tab_recent_avg_signal_strength);
        textViewFragmentFirstTabNeighbourCell = view.findViewById(R.id
                .textView_fragment_first_tab_neighbour_cell);
        recyclerViewFragmentFirstTabRecentRecord = view.findViewById(R.id.recyclerView_fragment_first_tab_recent_record);
        recyclerViewFragmentFirstTabNeighbourCellInfo = view.findViewById(R.id.recyclerView_fragment_first_tab_neighbour_cell_info);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        recentNetworkStatusRecordList = new ArrayList<>();
        neighbourCellList = new ArrayList<>();
        initRecyclerView();
        recentNetworkStatusCnt = 0;
        recentAvgSignalStrength = 0;

        btnFragmentFirstTabConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearlayoutFragmentFirstTabRecentRecord.getVisibility() == View.VISIBLE) {
                    linearlayoutFragmentFirstTabRecentRecord.setVisibility(View.GONE);
                    linearlayoutFragmentFirstTabNeighbourCell.setVisibility(View.VISIBLE);
                    textViewFragmentFirstTabRecentAvgSignalStrength.setVisibility(View.GONE);
                    textViewFragmentFirstTabNeighbourCell.setVisibility(View.VISIBLE);
                } else {
                    linearlayoutFragmentFirstTabRecentRecord.setVisibility(View.VISIBLE);
                    linearlayoutFragmentFirstTabNeighbourCell.setVisibility(View.GONE);
                    textViewFragmentFirstTabRecentAvgSignalStrength.setVisibility(View.VISIBLE);
                    textViewFragmentFirstTabNeighbourCell.setVisibility(View.GONE);
                }
            }
        });
    }

    /**
     * Reselected Tab
     */
    @Subscribe
    public void onTabSelectedEvent(TabSelectedEvent event) {
        if (event.position != MainFragment.FIRST) {
            return;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusActivityScope.getDefault(_mActivity).unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateView(final UpdateUeStatusEvent updateUEStatusEvent) {
        newCachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                recentNetworkStatusRecordList.add(0, updateUEStatusEvent.ueStatus.networkStatus);
                neighbourCellList.clear();
                neighbourCellList.addAll(updateUEStatusEvent.ueStatus.networkStatus
                        .lteNeighbourCellTowers);
                litepalLteBasestationCellList = LitePal.where("eci = ?", updateUEStatusEvent.ueStatus
                        .networkStatus
                        .lteServingCellTower.cellId + "").find
                        (LteBasestationCell
                                .class);
                _mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (FirstTabFragment.this.isVisible()) {
                            textViewFragmentFirstTabOperator.setText(updateUEStatusEvent.ueStatus.locationStatus
                                    .operators + "");
                            textViewFragmentFirstTabIMSI.setText(updateUEStatusEvent.ueStatus.networkStatus.imsi + "");
                            textViewFragmentFirstTabIMEI.setText(updateUEStatusEvent.ueStatus.networkStatus.imei + "");
                            textViewFragmentFirstTabUEModel.setText(updateUEStatusEvent.ueStatus.networkStatus.hardwareModel + "");
                            textViewFragmentFirstTabAndroidVersion.setText(updateUEStatusEvent.ueStatus.networkStatus.androidVersion + "");
                            textViewFragmentFirstTabLongitude.setText(NumberFormat.doubleFormat(updateUEStatusEvent.ueStatus.locationStatus
                                    .longitudeWgs84, 5) + "");
                            textViewFragmentFirstTabLatitude.setText(NumberFormat.doubleFormat
                                    (updateUEStatusEvent.ueStatus.locationStatus
                                            .latitudeWgs84, 5) + "");
                            textViewFragmentFirstTabAltitude.setText(updateUEStatusEvent.ueStatus.locationStatus.altitude + "米");
                            textViewFragmentFirstTabCurrentLocName.setText(updateUEStatusEvent.ueStatus.locationStatus
                                    .city + updateUEStatusEvent.ueStatus.locationStatus.district + updateUEStatusEvent
                                    .ueStatus.locationStatus.street + updateUEStatusEvent.ueStatus.locationStatus
                                    .streetNumber);

                            textViewFragmentFirstTabTAC.setText(updateUEStatusEvent.ueStatus.networkStatus
                                    .lteServingCellTower.tac + "");
                            textViewFragmentFirstTabPCI.setText(updateUEStatusEvent.ueStatus.networkStatus
                                    .lteServingCellTower.pci + "");
                            textViewFragmentFirstTabCGI.setText(updateUEStatusEvent.ueStatus.networkStatus
                                    .lteServingCellTower.enbId + "-" + updateUEStatusEvent.ueStatus.networkStatus
                                    .lteServingCellTower.enbCellId);
                            textViewFragmentFirstTabEarFcn.setText(updateUEStatusEvent.ueStatus.networkStatus
                                    .lteServingCellTower.lteEarFcn + "");
                            textViewFragmentFirstTabRSRP.setText(updateUEStatusEvent.ueStatus.networkStatus
                                    .lteServingCellTower.signalStrength + "");
                            textViewFragmentFirstTabRSRQ.setText(updateUEStatusEvent.ueStatus.networkStatus
                                    .lteServingCellTower.rsrq + "");
                            textViewFragmentFirstTabSINR.setText(updateUEStatusEvent.ueStatus.networkStatus
                                    .lteServingCellTower.sinr + "");
                            textViewFragmentFirstTabBand.setText(LteBand.getBand
                                    (updateUEStatusEvent.ueStatus.networkStatus
                                            .lteServingCellTower.lteEarFcn)+"");
                            if (LteBand.getDuplexMode(updateUEStatusEvent.ueStatus.networkStatus
                                    .lteServingCellTower.lteEarFcn) == LteBand.TDD) {
                                textViewFragmentFirstTabFrequency.setText(LteBand.getDlCenterFreq(
                                        updateUEStatusEvent.ueStatus.networkStatus
                                                .lteServingCellTower.lteEarFcn) + "");
                            } else if (LteBand.getDuplexMode(updateUEStatusEvent.ueStatus.networkStatus
                                    .lteServingCellTower.lteEarFcn) == LteBand.FDD) {
                                textViewFragmentFirstTabFrequency.setText(LteBand.getDlCenterFreq(
                                        updateUEStatusEvent.ueStatus.networkStatus
                                                .lteServingCellTower.lteEarFcn) + "/" + LteBand
                                        .getUlCenterFreq(
                                                updateUEStatusEvent.ueStatus.networkStatus
                                                        .lteServingCellTower.lteEarFcn));
                            }
                            if (litepalLteBasestationCellList.isEmpty()) {
                                textViewFragmentFirstTabCellChsName.setText("基站数据库无此小区");
                            } else {
                                textViewFragmentFirstTabCellChsName.setText(litepalLteBasestationCellList.get(0)
                                        .getName() + "");
                            }
                            recentAvgSignalStrength = NumberFormat.doubleFormat((double) recentSumSignalStrength /
                                    (double)
                                            recentNetworkStatusCnt, 1);
                            textViewFragmentFirstTabRecentAvgSignalStrength.setText
                                    ("最近" + recentNetworkStatusCnt + "条记录，平均信号强度" + recentAvgSignalStrength + "dbm");
                            recentRecordAdapter.notifyDataSetChanged();
                            neighbourCellAdapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        });

        recentNetworkStatusCnt = recentNetworkStatusCnt + 1;
        recentSumSignalStrength = recentSumSignalStrength + updateUEStatusEvent.ueStatus
                .networkStatus
                .lteServingCellTower.signalStrength;


    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        recyclerViewFragmentFirstTabRecentRecord.setLayoutManager(layoutManager1);
        recentRecordAdapter = new RecentRecordAdapter(recentNetworkStatusRecordList);
        recyclerViewFragmentFirstTabRecentRecord.setAdapter(recentRecordAdapter);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        recyclerViewFragmentFirstTabNeighbourCellInfo.setLayoutManager(layoutManager2);
        neighbourCellAdapter = new NeighbourCellAdapter(neighbourCellList);
        recyclerViewFragmentFirstTabNeighbourCellInfo.setAdapter(neighbourCellAdapter);
    }
}
