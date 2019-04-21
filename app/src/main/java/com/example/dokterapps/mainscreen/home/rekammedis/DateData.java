package com.example.dokterapps.mainscreen.home.rekammedis;

import java.util.ArrayList;

public class DateData {
    public static String[] data = new String[]
            {"01 Januari 2019 ", "02 Januari 2019", "03 Januari 2019", "04 Januari 2019"};


    public static ArrayList<DateModel> getListData(){
        DateModel eventModel = null;
        ArrayList<DateModel> list = new ArrayList<>();

        for (int i = 0; i < data.length;  i++) {
            eventModel = new DateModel();
            eventModel.setTanggal(data[i]);
            list.add(eventModel);
        }
        return list;
    }
}
