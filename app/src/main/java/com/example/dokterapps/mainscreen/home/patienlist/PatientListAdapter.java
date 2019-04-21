package com.example.dokterapps.mainscreen.home.patienlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dokterapps.R;
import com.example.dokterapps.mainscreen.MainScreenActivity;

import java.util.ArrayList;

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.PatienListItemViewHolder> {
    private Context context;
    private ArrayList<PatientListModel> patientListModels;
    private View view;

    public PatientListAdapter(Context context) {
        this.context = context;
    }

    public PatientListAdapter(ArrayList<PatientListModel> patientListModels, int item_event, FragmentActivity activity) {
        this.context = context;
        this.patientListModels = patientListModels;
        this.view = view;
    }

    @NonNull
    @Override
    public PatienListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_patient_list, parent, false);

        return new PatienListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatienListItemViewHolder holder, int i) {
        final PatientListModel patientListModel = patientListModels.get(i);
        Glide.with(MainScreenActivity.getInstance())
                .load(patientListModel.getpImage_url())
                .apply(new RequestOptions().override(300, 200))
                .into(holder.pImage);

        holder.pNama.setText(patientListModel.getpNama());
        holder.pnoTelp.setText(patientListModel.getpNoTelepon());
        holder.pNoKonsul.setText(patientListModel.getpNoKonsultasi());

    }

    @Override
    public int getItemCount() {
        return patientListModels.size();
    }

    public class PatienListItemViewHolder extends RecyclerView.ViewHolder {
        TextView pNama, pnoTelp, pNoKonsul;
        ImageView pImage;
        public PatienListItemViewHolder(@NonNull View itemView) {
            super(itemView);
            pNama = itemView.findViewById(R.id.tv_name_patient_list);
            pnoTelp = itemView.findViewById(R.id.tv_noTelp_patient_list);
            pNoKonsul = itemView.findViewById(R.id.tv_no_konsultasi_patient_list);
            pImage = itemView.findViewById(R.id.img_patient_list);
        }
    }
}
