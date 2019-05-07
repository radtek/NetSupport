package com.hbmcc.wangsen.netsupport.telephony;

import com.baidu.location.BDLocation;
import com.hbmcc.wangsen.netsupport.util.LocatonConverter;

public class LocationStatus {
    public BDLocation bdLocation;
    public double latitudeBaidu, longitudeBaidu, latitudeWgs84, longitudeWgs84, altitude;
    public float radius, speed;
    public String coorType, networkLocationType, province, city, district, street, streetNumber,
            addrStr, locationDescribe, buildingName, floor, operators;
    public int errorCode, satelliteNumber, gpsAccuracyStatus, indoorLocationSource,
            indoorLocationSurpport;

    public LocationStatus(BDLocation bdLocation) {
        this.bdLocation = bdLocation;

        //状态部分
        gpsAccuracyStatus = bdLocation.getGpsAccuracyStatus();
        //如果是GPS位置，获得当前由百度自有算法判断的GPS质量, #GPS_ACCURACY_GOOD , #GPS_ACCURACY_MID, #GPS_ACCURACY_UNKNOWN
        coorType = bdLocation.getCoorType();
        //获取所用坐标系，以locationClientOption里设定的坐标系为准(wgs84,gcj02,bd09,bd09ll)
        errorCode = bdLocation.getLocType();//获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
        networkLocationType = bdLocation.getNetworkLocationType();//在网络定位结果的情况下，获取网络定位结果是通过基站定位得到的还是通过wifi定位得到的还是GPS得结果
        // 返回: String : "wf"： wifi定位结果 “cl“； cell定位结果 “ll”：GPS定位结果 ;null 没有获取到定位结果采用的类型
        satelliteNumber = bdLocation.getSatelliteNumber();//gps定位结果时，获取gps锁定用的卫星数

        //基本信息部分
        latitudeBaidu = bdLocation.getLatitude();    //获取纬度信息
        longitudeBaidu = bdLocation.getLongitude();    //获取经度信息
        LocatonConverter.MyLatLng myLatLngBaidu = new LocatonConverter.MyLatLng(latitudeBaidu,
                longitudeBaidu);
        LocatonConverter.MyLatLng myLatLngWgs84 = LocatonConverter.bd09ToWgs84(myLatLngBaidu);
        latitudeWgs84 = myLatLngWgs84.getLatitude();
        longitudeWgs84 = myLatLngWgs84.getLongitude();
        radius = bdLocation.getRadius();    //获取定位精度，默认值为0.0f
        altitude = bdLocation.getAltitude();//获取高度

        operators = getOperators(bdLocation.getOperators());//获取运营商信息
        speed = bdLocation.getSpeed();//获取速度，仅gps定位结果时有速度信息，单位公里/小时，默认值0.0f

        //语义描述部分
        province = bdLocation.getProvince();//省
        city = bdLocation.getCity();//市
        district = bdLocation.getDistrict();//区县
        street = bdLocation.getStreet();//街道
        streetNumber = bdLocation.getStreetNumber();//街道号码
        addrStr = bdLocation.getAddrStr();//详细地址
        locationDescribe = bdLocation.getLocationDescribe();//获取位置语义化信息，没有的话返回NULL

        //室内定位部分
        buildingName = bdLocation.getBuildingName();//获取buildingname信息，目前只在百度支持室内定位的地方有返回，默认null
        floor = bdLocation.getFloor();//获取楼层信息，目前只在百度支持室内定位的地方有返回，默认null
        indoorLocationSource = bdLocation.getIndoorLocationSource();//返回支持的室内定位类型 #INDOOR_LOCATION_SOURCE_WIFI, #INDOOR_LOCATION_SOURCE_BLUETOOTH, #INDOOR_LOCATION_SOURCE_MAGNETIC, #INDOOR_LOCATION_SOURCE_SMALLCELLSTATION, #INDOOR_LOCATION_SOURCE_UNKNOWN
        indoorLocationSurpport = bdLocation.getIndoorLocationSurpport();//返回是否支持室内定位，,#INDOOR_LOCATION_NEARBY_SURPPORT_TRUE,#INDOOR_LOCATION_SURPPORT_FALSE,#INDOOR_LOCATION_SURPPORT_UNKNOWN
    }

    private String getOperators(int op) {
        switch (op) {
            case BDLocation.OPERATORS_TYPE_UNKONW:
                return "未知运营商";
            case BDLocation.OPERATORS_TYPE_MOBILE:
                return "中国移动";
            case BDLocation.OPERATORS_TYPE_UNICOM:
                return "中国联通";
            case BDLocation.OPERATORS_TYPE_TELECOMU:
                return "中国电信";
            default:
                return "未知运营商";
        }
    }

}
