package com.hbmcc.wangsen.netsupport.database;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class LteBasestationCell extends LitePalSupport implements Parcelable {

    public static final int COVERAGE_OUTSIDE = 0;
    public static final int COVERAGE_INDOOR = 1;
    @Column(unique = true, defaultValue = "0")
    private long eci;
    @Column(defaultValue = "基站数据库未定义")
    private String name;
    @Column(defaultValue = "基站数据库未定义")
    private String city;
    @Column(defaultValue = "9999")
    private float lng;
    @Column(defaultValue = "9999")
    private float lat;
    @Column(defaultValue = "9999")
    private float antennaHeight;
    @Column(defaultValue = "9999")
    private float altitude;
    @Column(defaultValue = "9999")
    private int indoorOrOutdoor;
    @Column(defaultValue = "9999")
    private int coverageType;
    @Column(defaultValue = "9999")
    private int coverageScene;
    @Column(defaultValue = "9999")
    private float enbCellAzimuth;
    @Column(defaultValue = "9999")
    private float mechanicalDipAngle;
    @Column(defaultValue = "9999")
    private float electronicDipAngle;
    @Column(defaultValue = "基站数据库未定义")
    private String county;
    @Column(defaultValue = "基站数据库未定义")
    private String manufactoryName;
    @Column(defaultValue = "9999")
    private int tac;
    @Column(defaultValue = "9999")
    private int pci;
    @Column(defaultValue = "9999")
    private int lteEarFcn;
    @Column(defaultValue = "9999")
    private int enbId;
    @Column(defaultValue = "9999")
    private int enbCellId;

    public LteBasestationCell(long eci, String name, String city, float lng, float lat, float antennaHeight, float altitude, int indoorOrOutdoor, int coverageType, int coverageScene, float enbCellAzimuth, float mechanicalDipAngle, float electronicDipAngle, String county, String manufactoryName, int tac, int pci, int lteEarFcn) {
        this.eci = eci;
        this.name = name;
        this.city = city;
        this.lng = lng;
        this.lat = lat;
        this.antennaHeight = antennaHeight;
        this.altitude = altitude;
        this.indoorOrOutdoor = indoorOrOutdoor;
        this.coverageType = coverageType;
        this.coverageScene = coverageScene;
        this.enbCellAzimuth = enbCellAzimuth;
        this.mechanicalDipAngle = mechanicalDipAngle;
        this.electronicDipAngle = electronicDipAngle;
        this.county = county;
        this.manufactoryName = manufactoryName;
        this.tac = tac;
        this.pci = pci;
        this.lteEarFcn = lteEarFcn;
        this.enbId = (int) eci / 256;
        this.enbCellId = (int) eci % 256;
    }

    public LteBasestationCell() {

    }

    public long getEci() {
        return eci;
    }

    public void setEci(long eci) {
        this.eci = eci;
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

    public float getAntennaHeight() {
        return antennaHeight;
    }

    public void setAntennaHeight(float antennaHeight) {
        this.antennaHeight = antennaHeight;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public int getIndoorOrOutdoor() {
        return indoorOrOutdoor;
    }

    public void setIndoorOrOutdoor(int indoorOrOutdoor) {
        this.indoorOrOutdoor = indoorOrOutdoor;
    }

    public int getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(int coverageType) {
        this.coverageType = coverageType;
    }

    public int getCoverageScene() {
        return coverageScene;
    }

    public void setCoverageScene(int coverageScene) {
        this.coverageScene = coverageScene;
    }

    public float getEnbCellAzimuth() {
        return enbCellAzimuth;
    }

    public void setEnbCellAzimuth(float enbCellAzimuth) {
        this.enbCellAzimuth = enbCellAzimuth;
    }

    public float getMechanicalDipAngle() {
        return mechanicalDipAngle;
    }

    public void setMechanicalDipAngle(float mechanicalDipAngle) {
        this.mechanicalDipAngle = mechanicalDipAngle;
    }

    public float getElectronicDipAngle() {
        return electronicDipAngle;
    }

    public void setElectronicDipAngle(float electronicDipAngle) {
        this.electronicDipAngle = electronicDipAngle;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getManufactoryName() {
        return manufactoryName;
    }

    public void setManufactoryName(String manufactoryName) {
        this.manufactoryName = manufactoryName;
    }

    public int getTac() {
        return tac;
    }

    public void setTac(int tac) {
        this.tac = tac;
    }

    public int getPci() {
        return pci;
    }

    public void setPci(int pci) {
        this.pci = pci;
    }

    public int getLteEarFcn() {
        return lteEarFcn;
    }

    public void setLteEarFcn(int lteEarFcn) {
        this.lteEarFcn = lteEarFcn;
    }

    public int getEnbId() {
        return enbId;
    }

    public void setEnbId(int enbId) {
        this.enbId = enbId;
    }

    public int getEnbCellId() {
        return enbCellId;
    }

    public void setEnbCellId(int enbCellId) {
        this.enbCellId = enbCellId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(eci);
        dest.writeString(name);
        dest.writeString(city);
        dest.writeFloat(lng);
        dest.writeFloat(lat);
        dest.writeFloat(antennaHeight);
        dest.writeFloat(altitude);
        dest.writeInt(indoorOrOutdoor);
        dest.writeInt(coverageType);
        dest.writeInt(coverageScene);
        dest.writeFloat(enbCellAzimuth);
        dest.writeFloat(mechanicalDipAngle);
        dest.writeFloat(electronicDipAngle);
        dest.writeString(county);
        dest.writeString(manufactoryName);
        dest.writeInt(tac);
        dest.writeInt(pci);
        dest.writeInt(lteEarFcn);
        dest.writeInt(enbId);
        dest.writeInt(enbCellId);
    }

    public static final Creator<LteBasestationCell> CREATOR = new Creator<LteBasestationCell>() {
        @Override
        public LteBasestationCell createFromParcel(Parcel source) {
            LteBasestationCell lteBasestationCell = new LteBasestationCell();
            lteBasestationCell.eci = source.readLong();
            lteBasestationCell.name = source.readString();
            lteBasestationCell.city = source.readString();
            lteBasestationCell.lng = source.readFloat();
            lteBasestationCell.lat = source.readFloat();
            lteBasestationCell.antennaHeight = source.readFloat();
            lteBasestationCell.altitude = source.readFloat();
            lteBasestationCell.indoorOrOutdoor = source.readInt();
            lteBasestationCell.coverageType = source.readInt();
            lteBasestationCell.coverageScene = source.readInt();
            lteBasestationCell.enbCellAzimuth = source.readFloat();
            lteBasestationCell.mechanicalDipAngle = source.readFloat();
            lteBasestationCell.electronicDipAngle = source.readFloat();
            lteBasestationCell.county = source.readString();
            lteBasestationCell.manufactoryName = source.readString();
            lteBasestationCell.tac = source.readInt();
            lteBasestationCell.pci = source.readInt();
            lteBasestationCell.lteEarFcn = source.readInt();
            lteBasestationCell.enbId = source.readInt();
            lteBasestationCell.enbCellId = source.readInt();
            return lteBasestationCell;
        }

        @Override
        public LteBasestationCell[] newArray(int size) {
            return new LteBasestationCell[size];
        }
    };

}
