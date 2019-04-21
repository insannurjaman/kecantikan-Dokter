package com.example.dokterapps.mainscreen.home.rekammedis;

import android.os.Parcel;
import android.os.Parcelable;

public class DateModel implements Parcelable {
    private String tanggal;

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tanggal);
    }

    public DateModel() {
    }

    protected DateModel(Parcel in) {
        this.tanggal = in.readString();
    }

    public static final Parcelable.Creator<DateModel> CREATOR = new Parcelable.Creator<DateModel>() {
        @Override
        public DateModel createFromParcel(Parcel source) {
            return new DateModel(source);
        }

        @Override
        public DateModel[] newArray(int size) {
            return new DateModel[size];
        }
    };
}
