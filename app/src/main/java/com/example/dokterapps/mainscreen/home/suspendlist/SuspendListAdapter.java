package com.example.dokterapps.mainscreen.home.suspendlist;

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
import com.example.dokterapps.mainscreen.home.patienlist.PatientListAdapter;
import com.example.dokterapps.mainscreen.home.patienlist.PatientListModel;

import java.util.ArrayList;

public class SuspendListAdapter extends RecyclerView.Adapter<SuspendListAdapter.SuspendListItemViewHolder> {

    private Context context;
    private ArrayList<SuspendListModel> suspendListModels;
    private View view;

    public SuspendListAdapter(ArrayList<SuspendListModel> suspendListModels, int item_suspend_list, FragmentActivity activity) {
        this.suspendListModels = suspendListModels;
    }

    @NonNull
    @Override
    public SuspendListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_suspend_list, parent, false);

        return new SuspendListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuspendListItemViewHolder suspendListItemViewHolder, int i) {
        final SuspendListModel suspendListModel = suspendListModels.get(i);
        Glide.with(MainScreenActivity.getInstance())
                .load(suspendListModel.getsImage_url())
                .apply(new RequestOptions().override(300, 200))
                .into(suspendListItemViewHolder.sImage);

        suspendListItemViewHolder.sNama.setText(suspendListModel.getsNama());
        suspendListItemViewHolder.snoTelp.setText(suspendListModel.getsNoTelepon());
        suspendListItemViewHolder.sNoKonsul.setText(suspendListModel.getsNoKonsultasi());

    }

    @Override
    public int getItemCount() {
        return suspendListModels.size();
    }

    public class SuspendListItemViewHolder extends RecyclerView.ViewHolder {

        TextView sNama, snoTelp, sNoKonsul;
        ImageView sImage;
        public SuspendListItemViewHolder(@NonNull View itemView) {
            super(itemView);
            sNama = itemView.findViewById(R.id.tv_name_suspend_list);
            snoTelp = itemView.findViewById(R.id.tv_noTelp_suspend_list);
            sNoKonsul = itemView.findViewById(R.id.tv_no_konsultasi_suspend_list);
            sImage = itemView.findViewById(R.id.img_suspend_list);
        }
    }
}
