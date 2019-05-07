package com.hbmcc.wangsen.netsupport.ui.fragment.forth.basestationdatabase;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.hbmcc.wangsen.netsupport.App;
import com.hbmcc.wangsen.netsupport.R;
import com.hbmcc.wangsen.netsupport.adapter.BasestationDatabaseFragmentAdapter;
import com.hbmcc.wangsen.netsupport.base.BaseBackFragment;
import com.hbmcc.wangsen.netsupport.database.LteBasestationCell;
import com.hbmcc.wangsen.netsupport.util.FileUtils;

import org.litepal.LitePal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasestationDatabaseFragment extends BaseBackFragment {

    private static final String TAG = "BasestationDatabaseFrag";
    ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

    private static final String ARG_TITLE = "arg_title";
    private String mTitle;

    private TabLayout mTab;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private Button btnFragmentBasestionDatabaseImportDatabase;
    ProgressDialog progressDialog;
    AlertDialog.Builder alertDialog;
    private long startTime; //起始时间
    private long endTime;//结束时间

    public static BasestationDatabaseFragment newInstance(String title) {

        BasestationDatabaseFragment fragment = new BasestationDatabaseFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mTitle = bundle.getString(ARG_TITLE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basestation_database, container,
                false);
        initView(view);
        return attachToSwipeBack(view);
    }

    private void initView(View view) {
        mToolbar = view.findViewById(R.id.toolbar);
        mTab = view.findViewById(R.id.tab_fragment_basestastion_database);
        mViewPager = view.findViewById(R.id.viewpager_fragment_basestastion_database);
        btnFragmentBasestionDatabaseImportDatabase = view.findViewById(R.id.btn_fragment_basestion_database_import_database);

        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());

        mToolbar.setTitle(mTitle);
        initToolbarNav(mToolbar);
    }

    /**
     * 这里演示:
     * 比较复杂的Fragment页面会在第一次start时,导致动画卡顿
     * Fragmentation提供了onEnterAnimationEnd()方法,该方法会在 入栈动画 结束时回调
     * 所以在onCreateView进行一些简单的View初始化(比如 toolbar设置标题,返回按钮; 显示加载数据的进度条等),
     * 然后在onEnterAnimationEnd()方法里进行 复杂的耗时的初始化 (比如FragmentPagerAdapter的初始化 加载数据等)
     */
    @Override
    public void onEnterAnimationEnd(Bundle savedInstanceState) {
        initDelayView();
    }

    private void initDelayView() {
        mViewPager.setAdapter(new BasestationDatabaseFragmentAdapter(getChildFragmentManager()
                , "4G", "3G", "2G"));
        mTab.setupWithViewPager(mViewPager);
        btnFragmentBasestionDatabaseImportDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog = new AlertDialog.Builder(_mActivity);
                alertDialog.setTitle("提示")
                        .setMessage("该操作将清空原有基站数据库，是否继续")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                progressDialog = ProgressDialog.show(_mActivity, "提示", "基站数据库导入中，请稍等...",
                                        true, false);
                                importLteDatabase();
                            }
                        });
                alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });
    }
    //导入工参
    public boolean importLteDatabase() {
        startTime = System.currentTimeMillis();
        if (FileUtils.isFileExist(FileUtils.getLteInputFile())) {
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    File lteDatabaseFile = new File(FileUtils.getLteInputFile());//获得文件对象name="lteBasestationDatabaseTemplate">4G工参(模板).csv
                    LteBasestationCell lteBasestationCell;//获取工参实体类的实例
                    List<LteBasestationCell> lteBasestationCellList = new ArrayList<>();//创建实体类列表
                    String inString;
                    int i = 0;
                    try {
                        LitePal.deleteAll(LteBasestationCell.class);//删除LteBasestationCell数据表
                        BufferedReader reader =
                                new BufferedReader(new InputStreamReader(new FileInputStream(lteDatabaseFile), "GBK"));//获得输入流
                        while ((inString = reader.readLine()) != null) {//一行一行读，判断是否为空
                            String[] inStringSplit = inString.split(",");
                            if (inStringSplit.length != 18) {
                                _mActivity.runOnUiThread(new Runnable() {//开启子线程进行提示
                                    @Override
                                    public void run() {
                                        Toast.makeText(App.getContext(), "导入的工参数据格式不对", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                return;
                            }
                            i++;

                            if (i > 2) {
                                lteBasestationCell = new LteBasestationCell();
                                lteBasestationCell.setEci(Long.parseLong(inStringSplit[0]));
                                lteBasestationCell.setName(inStringSplit[1]);
                                lteBasestationCell.setCity(inStringSplit[2]);
                                lteBasestationCell.setLng(Float.parseFloat(inStringSplit[3]));
                                lteBasestationCell.setLat(Float.parseFloat
                                        (inStringSplit[4]));
                                lteBasestationCell.setAntennaHeight(Float.parseFloat(inStringSplit[5]));
                                lteBasestationCell.setAltitude(Float.parseFloat
                                        (inStringSplit[6]));
                                lteBasestationCell.setIndoorOrOutdoor(Integer.parseInt
                                        (inStringSplit[7]));
                                lteBasestationCell.setCoverageType(Integer.parseInt
                                        (inStringSplit[8]));
                                lteBasestationCell.setCoverageScene(Integer.parseInt
                                        (inStringSplit[9]));
                                lteBasestationCell.setEnbCellAzimuth(Float.parseFloat
                                        (inStringSplit[10]));
                                lteBasestationCell.setMechanicalDipAngle(Float.parseFloat
                                        (inStringSplit[11]));
                                lteBasestationCell.setElectronicDipAngle(Float.parseFloat
                                        (inStringSplit[12]));
                                lteBasestationCell.setCounty(inStringSplit[13]);
                                lteBasestationCell.setManufactoryName(inStringSplit[14]);
                                lteBasestationCell.setTac(Integer.parseInt
                                        (inStringSplit[15]));
                                lteBasestationCell.setPci(Integer.parseInt
                                        (inStringSplit[16]));
                                lteBasestationCell.setLteEarFcn(Integer.parseInt
                                        (inStringSplit[17]));
                                lteBasestationCell.setEnbId((int) (lteBasestationCell.getEci() / 256));
                                lteBasestationCell.setEnbCellId((int) (lteBasestationCell.getEci() %
                                        256));
                                lteBasestationCellList.add(lteBasestationCell);
                            }
                        }
                        if (i == 2) {
                            _mActivity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progressDialog.dismiss();//如果文件中没有数据，则取消进度框提示
                                    Toast.makeText(App.getContext(), "文件无数据", Toast.LENGTH_SHORT).show();
                                }
                            });
                            return;
                        }
                        LitePal.saveAll(lteBasestationCellList);
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        final int cellNums = i;
                        _mActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(App.getContext(), "第" + cellNums + "行数据异常，请处理", Toast.LENGTH_LONG)
                                        .show();
                            }
                        });
                    } finally {
                        endTime = System.currentTimeMillis();
                        final long usedTime = (int) ((endTime - startTime) / 1000);
                        final int cellNums = i;
                        _mActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();//导入完成后，取消进度对话框显示
                                Toast.makeText(App.getContext(), "共导入" + cellNums + "行数据，用时" + String.format
                                        ("%d " +
                                                "s", usedTime), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            });
        } else {
            progressDialog.dismiss();//如果找不到文件，则取消进度框提示
            Toast.makeText(getContext(), "4G基站数据库文件不存在", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}
