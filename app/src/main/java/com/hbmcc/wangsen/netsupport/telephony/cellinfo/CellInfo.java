package com.hbmcc.wangsen.netsupport.telephony.cellinfo;

public class CellInfo {
    public static final int TYPE_GSM = 0;
    public static final int TYPE_CDMA = 1;
    public static final int TYPE_WCDMA = 2;
    public static final int TYPE_LTE = 3;
    public static final int TYPE_TDSCDMA = 4;
    public static final int TYPE_UNKNOWN = 9;
    public static final String STRING_TYPE_GSM = "GSM";
    public static final String STRING_TYPE_LTE = "LTE";
    public static final String STRING_TYPE_CDMA = "CDMA";
    public static final String STRING_TYPE_WCDMA = "WCDMA";
    public static final String STRING_TYPE_TDSCDMA = "TDSCDMA";

    public String cellType;
    public int cellId;

    //（必填）：GSM 和 WCDMA 网络的位置区域代码 (LAC)。CDMA 网络的网络 ID (NID)。
    public int locationAreaCode;

    //（必填）：移动电话基站的移动国家代码 (MCC)。
    public int mobileCountryCode;

    //（必填）：移动电话基站的移动网络代码。对于 GSM \ WCDMA\LTE，这就是 MNC；CDMA 使用的是系统 ID(SID)。
    public int mobileNetworkCode;

    //测量到的无线信号强度（以 dBm 为单位）。
    public int signalStrength;

    //自从此小区成为主小区后经过的毫秒数。如果 age 为 0，cellId 就表示当前的测量值。
    public int age;

    //时间提前值。
    public int timingAdvance;

    //是否是服务小区
    public Boolean isRegitered;

}
