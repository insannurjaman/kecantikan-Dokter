package com.example.dokterapps.mainscreen.home.suspendlist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dokterapps.R;
import com.example.dokterapps.mainscreen.home.patienlist.PatientListAdapter;
import com.example.dokterapps.mainscreen.home.patienlist.PatientListModel;

import java.util.ArrayList;

public class SuspendListFragment extends Fragment {
    private RecyclerView suspendListRecyclerView;
    //private RecyclerView.Adapter produkAdapter;
    private SuspendListAdapter adapter;
    private ArrayList<SuspendListModel> events = new ArrayList<>();
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_suspend_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        suspendListRecyclerView = view.findViewById(R.id.rv_suspend_list);
        suspendListRecyclerView.setHasFixedSize(true);
        events.addAll(SuspendListData.getListData());
        suspendListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new SuspendListAdapter(events,R.layout.item_suspend_list,getActivity());
        suspendListRecyclerView.setAdapter(adapter);

    }
}
