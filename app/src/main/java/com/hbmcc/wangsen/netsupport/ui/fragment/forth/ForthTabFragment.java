package com.hbmcc.wangsen.netsupport.ui.fragment.forth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hbmcc.wangsen.netsupport.R;
import com.hbmcc.wangsen.netsupport.base.BaseMainFragment;
import com.hbmcc.wangsen.netsupport.event.TabSelectedEvent;
import com.hbmcc.wangsen.netsupport.ui.fragment.MainFragment;
import com.hbmcc.wangsen.netsupport.ui.fragment.forth.basestationdatabase.BasestationDatabaseFragment;
import com.hbmcc.wangsen.netsupport.ui.fragment.forth.basestationdatabase.CustomBasestationDatabaseFragment;
import com.hbmcc.wangsen.netsupport.ui.fragment.forth.basestationdatabase.GridBasestationDatabaseFragment;
import com.hbmcc.wangsen.netsupport.ui.fragment.forth.basestationdatabase.TrackBasestationDatabaseFragment;

import org.greenrobot.eventbus.Subscribe;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;

public class ForthTabFragment extends BaseMainFragment {
    private Button btnFragmentForthTabBasestationDatabase;
    private Button btnFragmentForthTabAbout;
    private Button btnFragmentForthTabBasestationDataCustom;
    private Button btnFragmentForthTabBasestationDataTrack;
    private Button btnFragmentForthTabBasestationDataGrid;



    public static ForthTabFragment newInstance() {

        Bundle args = new Bundle();

        ForthTabFragment fragment = new ForthTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forth_tab, container,
                false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        //绑定btn
        EventBusActivityScope.getDefault(_mActivity).register(this);
        btnFragmentForthTabBasestationDatabase = view.findViewById(R.id.btn_fragment_forth_tab_basestation_database);
        btnFragmentForthTabAbout = view.findViewById(R.id.btn_fragment_forth_tab_about);
        btnFragmentForthTabBasestationDataCustom = view.findViewById(R.id.btn_fragment_forth_tab_basestation_data_custom);
        btnFragmentForthTabBasestationDataTrack = view.findViewById(R.id.btn_fragment_forth_tab_basestation_data_track);
        btnFragmentForthTabBasestationDataGrid = view.findViewById(R.id.btn_fragment_forth_tab_basestation_data_area);

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        btnFragmentForthTabBasestationDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainFragment) getParentFragment()).startBrotherFragment
                        (BasestationDatabaseFragment.newInstance("基站数据库"));
            }
        });
        btnFragmentForthTabAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainFragment) getParentFragment()).startBrotherFragment
                        (AboutFragment.newInstance("关于"));
            }
        });
        //第四个碎步内动态加载-规划自定义数据碎片
        btnFragmentForthTabBasestationDataCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainFragment)getParentFragment()).startBrotherFragment
                        (CustomBasestationDatabaseFragment.newInstance("规划自定义数据"));
            }
        });

        btnFragmentForthTabBasestationDataTrack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainFragment)getParentFragment()).startBrotherFragment
                        (TrackBasestationDatabaseFragment.newInstance("测试log轨迹数据"));

            }
        });
        btnFragmentForthTabBasestationDataGrid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainFragment)getParentFragment()).startBrotherFragment
                        (GridBasestationDatabaseFragment.newInstance("栅格数据"));

            }
        });
    }

    /**
     * Reselected Tab
     */
    @Subscribe
    public void onTabSelectedEvent(TabSelectedEvent event) {
        if (event.position != MainFragment.FORTH) {
            return;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusActivityScope.getDefault(_mActivity).unregister(this);
    }
}
