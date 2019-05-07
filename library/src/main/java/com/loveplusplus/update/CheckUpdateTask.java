package com.loveplusplus.update;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import static com.loveplusplus.update.Constants.TAG;


/**
 * @author feicien (ithcheng@gmail.com)
 * @since 2016-07-05 19:21
 */
class CheckUpdateTask extends AsyncTask<Void, Void, String> {

    private ProgressDialog dialog;
    private Context mContext;
    private int mType;
    private boolean mShowProgressDialog;
    private String newVersionCheckUrl;

    CheckUpdateTask(Context context, int type, boolean showProgressDialog, String
            newVersionCheckUrl) {

        this.mContext = context;
        this.mType = type;
        this.mShowProgressDialog = showProgressDialog;
        this.newVersionCheckUrl = newVersionCheckUrl;
    }


    protected void onPreExecute() {
        if (mShowProgressDialog) {
            dialog = new ProgressDialog(mContext);
            dialog.setMessage(mContext.getString(R.string.android_auto_update_dialog_checking));
            dialog.show();
        }
    }


    @Override
    protected void onPostExecute(String result) {

        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }

        if (!TextUtils.isEmpty(result)) {
            parseJson(result);
        }
    }

    private void parseJson(String result) {
        try {

            JSONObject obj = new JSONObject(result);
            String updateMessage = obj.getString(Constants.APK_UPDATE_CONTENT);
            String apkUrl = obj.getString(Constants.APK_DOWNLOAD_URL);
            int apkCode = obj.getInt(Constants.APK_VERSION_CODE);
            int apkForceUpdate = obj.getInt(Constants.APK_FORCE_UPDATE_FLAG);
            String[] apkForceUpdateVersions = obj.getString(Constants.APK_FORCE_UPDATE_VERSIONS)
                    .split("\\|");

            int versionCode = AppUtils.getVersionCode(mContext);

            if (apkCode > versionCode) {
                if (mType == Constants.TYPE_NOTIFICATION) {
                    new NotificationHelper(mContext).showNotification(updateMessage, apkUrl);
                } else if (mType == Constants.TYPE_DIALOG) {
                    boolean isForceUpdateVerion = false;
                    for (String apkForceUpdateVersion : apkForceUpdateVersions
                            ) {
                        if (apkForceUpdateVersion.equals(versionCode + "")) {
                            isForceUpdateVerion = true;
                            break;
                        }
                    }
                    if (apkForceUpdate == 1 && isForceUpdateVerion) {
                        Log.d(TAG, "force");
                        showDialog(mContext, updateMessage, apkUrl, true);
                    } else {
                        Log.d(TAG, "unforce");
                        showDialog(mContext, updateMessage, apkUrl, false);
                    }
                }
            } else if (mShowProgressDialog) {
                Toast.makeText(mContext, mContext.getString(R.string.android_auto_update_toast_no_new_update), Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            Log.e(TAG, "parse json error");
        }
    }

    /**
     * Show dialog
     */
    private void showDialog(Context context, String content, String apkUrl, boolean isForceUpdate) {
        UpdateDialog.show(context, content, apkUrl, isForceUpdate);
    }


    @Override
    protected String doInBackground(Void... args) {
        return HttpUtils.get(newVersionCheckUrl);
    }
}
