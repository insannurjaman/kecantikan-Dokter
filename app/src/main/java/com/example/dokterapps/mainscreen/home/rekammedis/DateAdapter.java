package com.example.dokterapps.mainscreen.home.rekammedis;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dokterapps.R;
import com.example.dokterapps.mainscreen.home.suspendlist.SuspendListFragment;

import java.util.ArrayList;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateItemViewHolder> {
    private Context context;
    private ArrayList<DateModel> dateModels;
    private View view;

    public DateAdapter(ArrayList<DateModel> dates, int item_date_history, Context context) {
        this.context = context;
        this.dateModels = dates;
        this.view = view;

    }

    @NonNull
    @Override
    public DateItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_date_rekam_medis, parent, false);

        return new DateAdapter.DateItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DateItemViewHolder dateItemViewHolder, int position) {
        final DateModel dateModel = dateModels.get(position);
        dateItemViewHolder.tvTgl.setText(dateModel.getTanggal());
        dateItemViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return dateModels.size();
    }

    public class DateItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvTgl;
        CardView cv;
        public DateItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTgl = itemView.findViewById(R.id.tv_tanggal_history);
            cv = itemView.findViewById(R.id.cv_rekam_medis);
        }
    }
}
