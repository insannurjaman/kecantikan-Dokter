package com.example.dokterapps.mainscreen.home.suspendlist;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.dokterapps.mainscreen.home.patienlist.PatientListModel;

public class SuspendListModel implements Parcelable {
    private String sNama;
    private String sNoTelepon;
    private String sNoKonsultasi;
    private String sImage_url;
    private int sIndex;

    public String getsNama() {
        return sNama;
    }

    public void setsNama(String sNama) {
        this.sNama = sNama;
    }

    public String getsNoTelepon() {
        return sNoTelepon;
    }

    public void setsNoTelepon(String sNoTelepon) {
        this.sNoTelepon = sNoTelepon;
    }

    public String getsNoKonsultasi() {
        return sNoKonsultasi;
    }

    public void setsNoKonsultasi(String sNoKonsultasi) {
        this.sNoKonsultasi = sNoKonsultasi;
    }

    public String getsImage_url() {
        return sImage_url;
    }

    public void setsImage_url(String sImage_url) {
        this.sImage_url = sImage_url;
    }

    public int getsIndex() {
        return sIndex;
    }

    public void setsIndex(int sIndex) {
        this.sIndex = sIndex;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sNama);
        dest.writeString(this.sNoTelepon);
        dest.writeString(this.sNoKonsultasi);
        dest.writeString(this.sImage_url);
        dest.writeInt(this.sIndex);
    }

    public SuspendListModel() {
    }

    protected SuspendListModel(Parcel in) {
        this.sNama = in.readString();
        this.sNoTelepon = in.readString();
        this.sNoKonsultasi = in.readString();
        this.sImage_url = in.readString();
        this.sIndex = in.readInt();
    }

    public static final Parcelable.Creator<SuspendListModel> CREATOR = new Parcelable.Creator<SuspendListModel>() {
        @Override
        public SuspendListModel createFromParcel(Parcel source) {
            return new SuspendListModel(source);
        }

        @Override
        public SuspendListModel[] newArray(int size) {
            return new SuspendListModel[size];
        }
    };
}
