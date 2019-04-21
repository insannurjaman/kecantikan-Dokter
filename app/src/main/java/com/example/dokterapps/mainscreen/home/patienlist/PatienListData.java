package com.example.dokterapps.mainscreen.home.patienlist;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;

public class PatienListData {
    public static String[][] data = new String[][]{
            {"Yolanda Vesta", "081234567890", "12", "https://awsimages.detik.net.id/community/media/visual/2017/12/17/6e6283b6-3ded-4996-b3b5-e470780236dc_43.jpg?w=780&q=90"},
            {"Yolanda Vesta", "081234567890", "12", "https://awsimages.detik.net.id/community/media/visual/2017/12/17/6e6283b6-3ded-4996-b3b5-e470780236dc_43.jpg?w=780&q=90"},
            {"Yolanda Vesta", "081234567890", "12", "https://awsimages.detik.net.id/community/media/visual/2017/12/17/6e6283b6-3ded-4996-b3b5-e470780236dc_43.jpg?w=780&q=90"},
            {"Yolanda Vesta", "081234567890", "12", "https://awsimages.detik.net.id/community/media/visual/2017/12/17/6e6283b6-3ded-4996-b3b5-e470780236dc_43.jpg?w=780&q=90"},
    };

    public static ArrayList<PatientListModel> getListData(){
        PatientListModel patientListModel = null;
        ArrayList<PatientListModel> list = new ArrayList<>();

        for (int i = 0; i < data.length;  i++) {
            patientListModel = new PatientListModel();
            patientListModel.setpNama(data[i][0]);
            patientListModel.setpNoTelepon(data[i][1]);
            patientListModel.setpNoKonsultasi(data[i][2]);
            patientListModel.setpImage_url(data[i][3]);
            patientListModel.setpIndex(i);

            list.add(patientListModel);

        }
        return list;
    }
}
