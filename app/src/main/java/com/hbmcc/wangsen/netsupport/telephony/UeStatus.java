package com.hbmcc.wangsen.netsupport.telephony;

public class UeStatus {
    public NetworkStatus networkStatus;
    public LocationStatus locationStatus;
    public DownloadSpeedStatus downloadSpeedStatus;
    public UploadSpeedStatus uploadSpeedStatus;

    public UeStatus(NetworkStatus networkStatus, LocationStatus locationStatus, DownloadSpeedStatus downloadSpeedStatus, UploadSpeedStatus uploadSpeedStatus) {
        this.networkStatus = networkStatus;
        this.locationStatus = locationStatus;
        this.downloadSpeedStatus = downloadSpeedStatus;
        this.uploadSpeedStatus = uploadSpeedStatus;
    }
}
