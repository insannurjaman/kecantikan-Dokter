package com.example.dokterapps.mainscreen.home.suspendlist;

import com.example.dokterapps.mainscreen.home.patienlist.PatientListModel;

import java.util.ArrayList;

public class SuspendListData {
    public static String[][] data = new String[][]{
            {"Yolanda Vesta", "081234567890", "12", "https://scontent-lhr3-1.cdninstagram.com/vp/e345817bacb43ea1de2f0bce7b6f938e/5CF8E766/t51.2885-15/sh0.08/e35/s750x750/36149088_203477010362473_2417627788019236864_n.jpg?_nc_ht=scontent-lhr3-1.cdninstagram.com&ig_cache_key=MTgxOTUwNDQ1NjA2NTUzNDc3OQ%3D%3D.2"},
            {"Yolanda Vesta", "081234567890", "12", "https://scontent-lhr3-1.cdninstagram.com/vp/e345817bacb43ea1de2f0bce7b6f938e/5CF8E766/t51.2885-15/sh0.08/e35/s750x750/36149088_203477010362473_2417627788019236864_n.jpg?_nc_ht=scontent-lhr3-1.cdninstagram.com&ig_cache_key=MTgxOTUwNDQ1NjA2NTUzNDc3OQ%3D%3D.2"},
            {"Yolanda Vesta", "081234567890", "12", "https://scontent-lhr3-1.cdninstagram.com/vp/e345817bacb43ea1de2f0bce7b6f938e/5CF8E766/t51.2885-15/sh0.08/e35/s750x750/36149088_203477010362473_2417627788019236864_n.jpg?_nc_ht=scontent-lhr3-1.cdninstagram.com&ig_cache_key=MTgxOTUwNDQ1NjA2NTUzNDc3OQ%3D%3D.2"},
            {"Yolanda Vesta", "081234567890", "12", "https://scontent-lhr3-1.cdninstagram.com/vp/e345817bacb43ea1de2f0bce7b6f938e/5CF8E766/t51.2885-15/sh0.08/e35/s750x750/36149088_203477010362473_2417627788019236864_n.jpg?_nc_ht=scontent-lhr3-1.cdninstagram.com&ig_cache_key=MTgxOTUwNDQ1NjA2NTUzNDc3OQ%3D%3D.2"},
            {"Yolanda Vesta", "081234567890", "12", "https://scontent-lhr3-1.cdninstagram.com/vp/e345817bacb43ea1de2f0bce7b6f938e/5CF8E766/t51.2885-15/sh0.08/e35/s750x750/36149088_203477010362473_2417627788019236864_n.jpg?_nc_ht=scontent-lhr3-1.cdninstagram.com&ig_cache_key=MTgxOTUwNDQ1NjA2NTUzNDc3OQ%3D%3D.2"},

    };

    public static ArrayList<SuspendListModel> getListData(){
        SuspendListModel suspendListModel = null;
        ArrayList<SuspendListModel> list = new ArrayList<>();

        for (int i = 0; i < data.length;  i++) {
            suspendListModel = new SuspendListModel();
            suspendListModel.setsNama(data[i][0]);
            suspendListModel.setsNoTelepon(data[i][1]);
            suspendListModel.setsNoKonsultasi(data[i][2]);
            suspendListModel.setsImage_url(data[i][3]);
            suspendListModel.setsIndex(i);

            list.add(suspendListModel);

        }
        return list;
    }
}
