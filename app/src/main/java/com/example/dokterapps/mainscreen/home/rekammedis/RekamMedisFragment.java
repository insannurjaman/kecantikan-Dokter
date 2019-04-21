package com.example.dokterapps.mainscreen.home.rekammedis;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.dokterapps.R;
import com.example.dokterapps.mainscreen.home.rekammedisdetail.RekamMedisDetailFragment;
import com.example.dokterapps.mainscreen.home.suspendlist.SuspendListFragment;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;


public class RekamMedisFragment extends Fragment {

    private RecyclerView dateRecyclerView;
    //private RecyclerView.Adapter produkAdapter;
    private DateAdapter adapter;
    private ArrayList<DateModel> dates = new ArrayList<>();
    private View view;
    private CardView cv;

    String[] Bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli",
            "Agustus", "September", "Oktober", "November", "Desember"};
    String[] Tahun = {"2019", "2020","2021", "2022", "2023"};




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_rekam_medis, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showDropList();

        dateRecyclerView = view.findViewById(R.id.rv_dateHistory);
        cv = view.findViewById(R.id.cv_date_rekam_medis);

        dateRecyclerView.setHasFixedSize(true);
        dates.addAll(DateData.getListData());
        dateRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new DateAdapter(dates, R.layout.item_date_rekam_medis, getContext());
        dateRecyclerView.setAdapter(adapter);

       /* cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction t = getFragmentManager().beginTransaction();
                Fragment mFrag = new RekamMedisDetailFragment();
                t.replace(R.id.container_home, mFrag);
                t.commit();
            }
        });*/

    }


    public void showDropList(){
        ArrayAdapter<String> arrayAdapterBulan =  new ArrayAdapter<String>(getContext(),
                R.layout.support_simple_spinner_dropdown_item, Bulan);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner)
                view.findViewById(R.id.spinner_bulan);
        materialDesignSpinner.setAdapter(arrayAdapterBulan);


        ArrayAdapter<String> arrayAdapterTahun = new ArrayAdapter<String>(getContext(),
                R.layout.support_simple_spinner_dropdown_item, Tahun);
        MaterialBetterSpinner materialBetterSpinner = view.findViewById(R.id.spinner_tahun);
        materialBetterSpinner.setAdapter(arrayAdapterTahun);

    }
}
