package com.example.dokterapps.mainscreen.home.patienlist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dokterapps.R;

import java.util.ArrayList;


public class PatientListFragment extends Fragment {
    private RecyclerView patientListRecyclerView;
    //private RecyclerView.Adapter produkAdapter;
    private PatientListAdapter adapter;
    private ArrayList<PatientListModel> patientListModels = new ArrayList<>();
    private View view;
    private static PatientListFragment patientListFragment;

    public static PatientListFragment getInstance() {
        return patientListFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_patient_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        patientListRecyclerView = view.findViewById(R.id.rv_patient_list);

        patientListRecyclerView.setHasFixedSize(true);
        patientListModels.addAll(PatienListData.getListData());

        patientListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        adapter = new PatientListAdapter(patientListModels,R.layout.item_patient_list,getActivity());

        patientListRecyclerView.setAdapter(adapter);


    }
}
