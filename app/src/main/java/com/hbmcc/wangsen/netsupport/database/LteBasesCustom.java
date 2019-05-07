package com.hbmcc.wangsen.netsupport.database;

import org.litepal.crud.LitePalSupport;
import org.litepal.annotation.Column;

import android.os.Parcel;
import android.os.Parcelable;

public class LteBasesCustom extends LitePalSupport implements Parcelable {

    @Column(defaultValue = "基站数据库未定义")
    private String name;
    @Column(defaultValue = "基站数据库未定义")
    private String city;
    @Column(defaultValue = "9999")
    private float lng;
    @Column(defaultValue = "9999")
    private float lat;
    @Column(defaultValue = "无")
    private String remark;

    public LteBasesCustom(){}

    public LteBasesCustom(String name, String city, float lng, float lat, String remark) {
        this.name = name;
        this.city = city;
        this.lng = lng;
        this.lat = lat;
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(city);
        dest.writeFloat(lng);
        dest.writeFloat(lat);
        dest.writeString(remark);
    }
    public static final Creator<LteBasesCustom> CREATOR = new Creator<LteBasesCustom>() {
        @Override
        public LteBasesCustom createFromParcel(Parcel source) {
            LteBasesCustom lteBasesCustom = new LteBasesCustom();
            lteBasesCustom.name = source.readString();
            lteBasesCustom.city = source.readString();
            lteBasesCustom.lng = source.readFloat();
            lteBasesCustom.lat = source.readFloat();
            lteBasesCustom.remark = source.readString();
            return lteBasesCustom;
        }
        @Override
        public LteBasesCustom[] newArray(int size) {
            return new LteBasesCustom[size];
        }
    };

}
