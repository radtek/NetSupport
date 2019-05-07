package com.loveplusplus.update;

import android.content.Context;
import android.util.Log;

public class UpdateChecker {


    public static void checkForDialog(Context context, String newVersionCheckUrl) {
        if (context != null) {
            new CheckUpdateTask(context, Constants.TYPE_DIALOG, true, newVersionCheckUrl).execute();
        } else {
            Log.e(Constants.TAG, "The arg context is null");
        }
    }


    public static void checkForNotification(Context context, String newVersionCheckUrl) {
        if (context != null) {
            new CheckUpdateTask(context, Constants.TYPE_NOTIFICATION, false, newVersionCheckUrl).execute();
        } else {
            Log.e(Constants.TAG, "The arg context is null");
        }

    }


}
