package com.hbmcc.wangsen.netsupport.database;

import org.litepal.crud.LitePalSupport;
import org.litepal.annotation.Column;

import android.os.Parcel;
import android.os.Parcelable;

public class LteBasesTrack extends LitePalSupport implements Parcelable {

    @Column(defaultValue = "基站数据库未定义")
    private String name;
    @Column(defaultValue = "9999")
    private float lng;
    @Column(defaultValue = "9999")
    private float lat;
    @Column(defaultValue = "无")
    private float rsrp;

    public LteBasesTrack(){}

    public LteBasesTrack(String name,float lng, float lat, float rsrp) {
        this.name = name;
        this.lng = lng;
        this.lat = lat;
        this.rsrp = rsrp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getRsrp() {
        return rsrp;
    }

    public void setRsrp(float rsrp) {
        this.rsrp = rsrp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeFloat(lng);
        dest.writeFloat(lat);
        dest.writeFloat(rsrp);
    }
    public static final Creator<LteBasesTrack> CREATOR = new Creator<LteBasesTrack>() {
        @Override
        public LteBasesTrack createFromParcel(Parcel source) {
            LteBasesTrack lteBasesTrack = new LteBasesTrack();
            lteBasesTrack.name = source.readString();
            lteBasesTrack.lng = source.readFloat();
            lteBasesTrack.lat = source.readFloat();
            lteBasesTrack.rsrp = source.readFloat();
            return lteBasesTrack;
        }
        @Override
        public LteBasesTrack[] newArray(int size) {
            return new LteBasesTrack[size];
        }
    };

}
