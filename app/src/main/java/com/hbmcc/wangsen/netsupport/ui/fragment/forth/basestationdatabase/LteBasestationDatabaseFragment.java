package com.hbmcc.wangsen.netsupport.ui.fragment.forth.basestationdatabase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hbmcc.wangsen.netsupport.R;
import com.hbmcc.wangsen.netsupport.adapter.LteBasestationDatabaseAdapter;
import com.hbmcc.wangsen.netsupport.database.LteBasestationCell;
import com.hbmcc.wangsen.netsupport.listener.OnItemClickListener;
import com.hbmcc.wangsen.netsupport.ui.fragment.other.LteBasestationcellDetailInfoFragment;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;


public class LteBasestationDatabaseFragment extends SupportFragment {
    private static final String TAG = "LteBasestationDatabaseF";
    private EditText editTextFragmentLteBasestionDatabaseSearch;
    private Button btnFragmentLteBasestionDatabaseSearch;
    private RecyclerView recyclerviewFragmentLteBasestationDatabase;
    private List<LteBasestationCell> lteBasestationCellList;
    private LteBasestationDatabaseAdapter lteBasestationDatabaseAdapter;


    public static LteBasestationDatabaseFragment newInstance() {
        Bundle args = new Bundle();
        LteBasestationDatabaseFragment fragment = new LteBasestationDatabaseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lte_basestation_database, container,
                false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        editTextFragmentLteBasestionDatabaseSearch = view.findViewById(R.id.editText_fragment_lte_basestion_database_search);
        btnFragmentLteBasestionDatabaseSearch = view.findViewById(R.id.btn_fragment_lte_basestion_database_search);
        recyclerviewFragmentLteBasestationDatabase = view.findViewById(R.id.recyclerview_fragment_lte_basestation_database);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        lteBasestationCellList = new ArrayList<>();
        initRecyclerView();
        btnFragmentLteBasestionDatabaseSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextFragmentLteBasestionDatabaseSearch.getText().toString();
                if (!input.trim().isEmpty()) {
                    lteBasestationCellList.clear();
                    lteBasestationCellList.addAll(LitePal.where("enbId = ? or tac = ? or name like ?", input, input, "%" + input + "%")
                            .order("enbId").find
                                    (LteBasestationCell
                                            .class));
                    lteBasestationDatabaseAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        recyclerviewFragmentLteBasestationDatabase.setLayoutManager(layoutManager1);
        lteBasestationDatabaseAdapter = new LteBasestationDatabaseAdapter
                (lteBasestationCellList);
        lteBasestationDatabaseAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                ((BasestationDatabaseFragment)getParentFragment()).extraTransaction().startDontHideSelf((LteBasestationcellDetailInfoFragment
                        .newInstance
                                (lteBasestationDatabaseAdapter.getCell(position))));
            }
        });
        recyclerviewFragmentLteBasestationDatabase.setAdapter(lteBasestationDatabaseAdapter);
    }

}
