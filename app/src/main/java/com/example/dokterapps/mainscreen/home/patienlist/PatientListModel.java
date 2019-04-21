package com.example.dokterapps.mainscreen.home.patienlist;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

public class PatientListModel implements Parcelable {
    private String pNama;
    private String pNoTelepon;
    private String pNoKonsultasi;
    private String pImage_url;
    private int pIndex;

    public PatientListModel() {
    }

    public String getpNama() {
        return pNama;
    }

    public void setpNama(String pNama) {
        this.pNama = pNama;
    }

    public String getpNoTelepon() {
        return pNoTelepon;
    }

    public void setpNoTelepon(String pNoTelepon) {
        this.pNoTelepon = pNoTelepon;
    }

    public String getpNoKonsultasi() {
        return pNoKonsultasi;
    }

    public void setpNoKonsultasi(String pNoKonsultasi) {
        this.pNoKonsultasi = pNoKonsultasi;
    }

    public String getpImage_url() {
        return pImage_url;
    }

    public void setpImage_url(String pImage_url) {
        this.pImage_url = pImage_url;
    }

    public int getpIndex() {
        return pIndex;
    }

    public void setpIndex(int pIndex) {
        this.pIndex = pIndex;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.pNama);
        dest.writeString(this.pNoTelepon);
        dest.writeString(this.pNoKonsultasi);
        dest.writeString(this.pImage_url);
        dest.writeInt(this.pIndex);
    }

    protected PatientListModel(Parcel in) {
        this.pNama = in.readString();
        this.pNoTelepon = in.readString();
        this.pNoKonsultasi = in.readString();
        this.pImage_url = in.readString();
        this.pIndex = in.readInt();
    }

    public static final Parcelable.Creator<PatientListModel> CREATOR = new Parcelable.Creator<PatientListModel>() {
        @Override
        public PatientListModel createFromParcel(Parcel source) {
            return new PatientListModel(source);
        }

        @Override
        public PatientListModel[] newArray(int size) {
            return new PatientListModel[size];
        }
    };


}
