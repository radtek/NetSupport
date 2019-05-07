package com.hbmcc.wangsen.netsupport.ui.fragment.other;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hbmcc.wangsen.netsupport.R;
import com.hbmcc.wangsen.netsupport.base.BaseBackFragment;
import com.hbmcc.wangsen.netsupport.database.LteBasestationCell;


public class LteBasestationcellDetailInfoFragment extends BaseBackFragment {
    private static final String TAG = "LteBasestationcellDetai";
    private static final String ARG_MSG = "arg_msg";
    private TextView textViewFragmentLtebasestationcelldetailinfoEci;
    private TextView textViewFragmentLtebasestationcelldetailinfoCity;
    private TextView textViewFragmentLtebasestationcelldetailinfoLng;
    private TextView textViewFragmentLtebasestationcelldetailinfoLat;
    private TextView textViewFragmentLtebasestationcelldetailinfoAntennaHeight;
    private TextView textViewFragmentLtebasestationcelldetailinfoAltitude;
    private TextView textViewFragmentLtebasestationcelldetailinfoCoverageType;
    private TextView textViewFragmentLtebasestationcelldetailinfoCoverageScene;
    private TextView textViewFragmentLtebasestationcelldetailinfoEnbCellAzimuth;
    private TextView textViewFragmentLtebasestationcelldetailinfoMechanicalDipAngle;
    private TextView textViewFragmentLtebasestationcelldetailinfoElectronicDipAngle;
    private TextView textViewFragmentLtebasestationcelldetailinfoCounty;
    private TextView textViewFragmentLtebasestationcelldetailinfoManufactoryName;
    private TextView textViewFragmentLtebasestationcelldetailinfoTac;
    private TextView textViewFragmentLtebasestationcelldetailinfoPci;
    private TextView textViewFragmentLtebasestationcelldetailinfoLteEarFcn;
    private TextView textViewFragmentLtebasestationcelldetailinfoEnbId;
    private TextView textViewFragmentLtebasestationcelldetailinfoEnbCellId;
    private TextView textViewFragmentLtebasestationcelldetailinfoName;
    private TextView textViewFragmentLtebasestationcelldetailinfoIndoorOrOutdoor;
    private Toolbar mToolbar;
    private String mTitle="小区详情";

    public static LteBasestationcellDetailInfoFragment newInstance(LteBasestationCell lteBasestationCell) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_MSG, lteBasestationCell);
        LteBasestationcellDetailInfoFragment fragment = new LteBasestationcellDetailInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lte_basestationcell_detailinfo, container, false);
        mToolbar = view.findViewById(R.id.toolbar);
        textViewFragmentLtebasestationcelldetailinfoEci = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_eci);
        textViewFragmentLtebasestationcelldetailinfoCity = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_city);
        textViewFragmentLtebasestationcelldetailinfoLng = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_lng);
        textViewFragmentLtebasestationcelldetailinfoLat = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_lat);
        textViewFragmentLtebasestationcelldetailinfoAntennaHeight = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_antennaHeight);
        textViewFragmentLtebasestationcelldetailinfoAltitude = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_altitude);
        textViewFragmentLtebasestationcelldetailinfoCoverageType = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_coverageType);
        textViewFragmentLtebasestationcelldetailinfoCoverageScene = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_coverageScene);
        textViewFragmentLtebasestationcelldetailinfoEnbCellAzimuth = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_enbCellAzimuth);
        textViewFragmentLtebasestationcelldetailinfoMechanicalDipAngle = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_mechanicalDipAngle);
        textViewFragmentLtebasestationcelldetailinfoElectronicDipAngle = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_electronicDipAngle);
        textViewFragmentLtebasestationcelldetailinfoCounty = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_county);
        textViewFragmentLtebasestationcelldetailinfoManufactoryName = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_manufactoryName);
        textViewFragmentLtebasestationcelldetailinfoTac = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_tac);
        textViewFragmentLtebasestationcelldetailinfoPci = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_pci);
        textViewFragmentLtebasestationcelldetailinfoLteEarFcn = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_lteEarFcn);
        textViewFragmentLtebasestationcelldetailinfoEnbId = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_enbId);
        textViewFragmentLtebasestationcelldetailinfoEnbCellId = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_enbCellId);
        textViewFragmentLtebasestationcelldetailinfoName = view.findViewById(R.id.textView_fragment_ltebasestationcelldetailinfo_name);
        textViewFragmentLtebasestationcelldetailinfoIndoorOrOutdoor = view.findViewById(R.id
                .textView_fragment_ltebasestationcelldetailinfo_indoorOrOutdoor);
        mToolbar.setTitle(mTitle);
        initToolbarNav(mToolbar);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        LteBasestationCell lteBasestationCell = getArguments().getParcelable(ARG_MSG);
        textViewFragmentLtebasestationcelldetailinfoEci.setText(lteBasestationCell.getEci() + "");
        textViewFragmentLtebasestationcelldetailinfoName.setText(lteBasestationCell.getName()+"");
        textViewFragmentLtebasestationcelldetailinfoCity.setText(lteBasestationCell.getCity() + "");
        textViewFragmentLtebasestationcelldetailinfoLng.setText(lteBasestationCell.getLng() + "");
        textViewFragmentLtebasestationcelldetailinfoLat.setText(lteBasestationCell.getLat() + "");
        textViewFragmentLtebasestationcelldetailinfoAntennaHeight.setText(lteBasestationCell
                .getAntennaHeight() + "");
        textViewFragmentLtebasestationcelldetailinfoAltitude.setText(lteBasestationCell.getAltitude() + "");
        textViewFragmentLtebasestationcelldetailinfoCoverageType.setText(lteBasestationCell
                .getCoverageType() + "");
        textViewFragmentLtebasestationcelldetailinfoCoverageScene.setText(lteBasestationCell
                .getCoverageScene() + "");
        textViewFragmentLtebasestationcelldetailinfoEnbCellAzimuth.setText(lteBasestationCell
                .getEnbCellAzimuth()+"");
        textViewFragmentLtebasestationcelldetailinfoMechanicalDipAngle.setText(lteBasestationCell
                .getMechanicalDipAngle()+"");
        textViewFragmentLtebasestationcelldetailinfoElectronicDipAngle.setText(lteBasestationCell
                .getElectronicDipAngle()+"");
        textViewFragmentLtebasestationcelldetailinfoCounty.setText(lteBasestationCell.getCounty()+"");
        textViewFragmentLtebasestationcelldetailinfoManufactoryName.setText(lteBasestationCell
                .getManufactoryName()+"");
        textViewFragmentLtebasestationcelldetailinfoTac.setText(lteBasestationCell.getTac()+"");
        textViewFragmentLtebasestationcelldetailinfoPci.setText(lteBasestationCell.getPci()+"");
        textViewFragmentLtebasestationcelldetailinfoLteEarFcn.setText(lteBasestationCell.getLteEarFcn()+"");
        textViewFragmentLtebasestationcelldetailinfoEnbId.setText(lteBasestationCell.getEnbId()+"");
        textViewFragmentLtebasestationcelldetailinfoEnbCellId.setText(lteBasestationCell.getEnbCellId()+"");
        if(lteBasestationCell.getIndoorOrOutdoor() == LteBasestationCell.COVERAGE_OUTSIDE){
            textViewFragmentLtebasestationcelldetailinfoIndoorOrOutdoor.setText("室外");
        }
        else if(lteBasestationCell.getIndoorOrOutdoor() == LteBasestationCell.COVERAGE_INDOOR){
            textViewFragmentLtebasestationcelldetailinfoIndoorOrOutdoor.setText("室内");
        }
    }

}
