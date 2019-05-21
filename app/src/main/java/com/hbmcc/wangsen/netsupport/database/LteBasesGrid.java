package com.hbmcc.wangsen.netsupport.database;

import org.litepal.crud.LitePalSupport;
import org.litepal.annotation.Column;

import android.os.Parcel;
import android.os.Parcelable;

public class LteBasesGrid extends LitePalSupport implements Parcelable {
    @Column(defaultValue = "1")
    private String grid_name;
    @Column(defaultValue = "1")
    private String grid_id;
    @Column(defaultValue = "1")
    private float lng;
    @Column(defaultValue = "1")
    private float lat;
    @Column(defaultValue = "1")
    private float lng1;
    @Column(defaultValue = "1")
    private float lat1;
    @Column(defaultValue = "1")
    private float lng2;
    @Column(defaultValue = "1")
    private float lat2;
    @Column(defaultValue = "1")
    private float lng3;
    @Column(defaultValue = "1")
    private float lat3;
    @Column(defaultValue = "1")
    private float lng4;
    @Column(defaultValue = "1")
    private float lat4;
    @Column(defaultValue = "1")
    private float rsrp;
    @Column(defaultValue = "1")
    private int gridcount;
    @Column(defaultValue = "1")
    private String grid_call;

    public LteBasesGrid(){

    }



    public String getGrid_name() {
        return grid_name;
    }

    public void setGrid_name(String grid_name) {
        this.grid_name = grid_name;
    }

    public String getGrid_id() {
        return grid_id;
    }

    public void setGrid_id(String grid_id) {
        this.grid_id = grid_id;
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

    public float getLng1() {
        return lng1;
    }

    public void setLng1(float lng1) {
        this.lng1 = lng1;
    }

    public float getLat1() {
        return lat1;
    }

    public void setLat1(float lat1) {
        this.lat1 = lat1;
    }

    public float getLng2() {
        return lng2;
    }

    public void setLng2(float lng2) {
        this.lng2 = lng2;
    }

    public float getLat2() {
        return lat2;
    }

    public void setLat2(float lat2) {
        this.lat2 = lat2;
    }

    public float getLng3() {
        return lng3;
    }

    public void setLng3(float lng3) {
        this.lng3 = lng3;
    }

    public float getLat3() {
        return lat3;
    }

    public void setLat3(float lat3) {
        this.lat3 = lat3;
    }

    public float getLng4() {
        return lng4;
    }

    public void setLng4(float lng4) {
        this.lng4 = lng4;
    }

    public float getLat4() {
        return lat4;
    }

    public void setLat4(float lat4) {
        this.lat4 = lat4;
    }

    public float getRsrp() {
        return rsrp;
    }

    public void setRsrp(float rsrp) {
        this.rsrp = rsrp;
    }

    public int getGridcount() {
        return gridcount;
    }

    public void setGridcount(int gridcount) {
        this.gridcount = gridcount;
    }

    public String getGrid_call() {
        return grid_call;
    }

    public void setGrid_call(String grid_call) {
        this.grid_call = grid_call;
    }

    public LteBasesGrid(String grid_name, String grid_id, float lng, float lat, float lng1, float lat1, float lng2, float lat2, float lng3, float lat3, float lng4, float lat4, float rsrp, int gridcount, String grid_call) {
        this.grid_name = grid_name;
        this.grid_id = grid_id;
        this.lng = lng;
        this.lat = lat;
        this.lng1 = lng1;
        this.lat1 = lat1;
        this.lng2 = lng2;
        this.lat2 = lat2;
        this.lng3 = lng3;
        this.lat3 = lat3;
        this.lng4 = lng4;
        this.lat4 = lat4;
        this.rsrp = rsrp;
        this.gridcount = gridcount;
        this.grid_call = grid_call;
    }

    public static final Creator<LteBasesGrid> CREATOR = new Creator<LteBasesGrid>() {
        @Override
        public LteBasesGrid createFromParcel(Parcel source) {
            LteBasesGrid lteBasesGrid = new LteBasesGrid();
            lteBasesGrid.grid_name = source.readString();
            lteBasesGrid.grid_id = source.readString();
            lteBasesGrid.lng = source.readFloat();
            lteBasesGrid.lat = source.readFloat();
            lteBasesGrid.lng1 = source.readFloat();
            lteBasesGrid.lat1 = source.readFloat();
            lteBasesGrid.lng2 = source.readFloat();
            lteBasesGrid.lat2 = source.readFloat();
            lteBasesGrid.lng3 = source.readFloat();
            lteBasesGrid.lat3 = source.readFloat();
            lteBasesGrid.lng4 = source.readFloat();
            lteBasesGrid.lat4 = source.readFloat();
            lteBasesGrid.rsrp = source.readFloat();
            lteBasesGrid.gridcount = source.readInt();
            lteBasesGrid.grid_call = source.readString();
            return lteBasesGrid;
        }

        @Override
        public LteBasesGrid[] newArray(int size) {
            return new LteBasesGrid[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(grid_name);
        dest.writeString(grid_id);
        dest.writeFloat(lng);
        dest.writeFloat(lat);
        dest.writeFloat(lng1);
        dest.writeFloat(lat1);
        dest.writeFloat(lng2);
        dest.writeFloat(lat2);
        dest.writeFloat(lng3);
        dest.writeFloat(lat3);
        dest.writeFloat(lng4);
        dest.writeFloat(lat4);
        dest.writeFloat(rsrp);
        dest.writeInt(gridcount);
        dest.writeString(grid_call);
    }


}
