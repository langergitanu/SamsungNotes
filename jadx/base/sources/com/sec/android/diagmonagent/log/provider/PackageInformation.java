package com.sec.android.diagmonagent.log.provider;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.sec.android.diagmonagent.common.util.CommonUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PackageInformation {
    private static final String PRE_ID = "TWID:";
    private static final String SERIAL_NO = "ro.serialno";
    private static final String TAG_DEVICEINFO = "deviceInfo";
    private static final String TAG_SERVICECLIENT_VERSION = "serviceClientVer";
    public static PackageInformation instance = new PackageInformation();

    public static String getSerialNo() {
        return "";
    }

    public static String getTWID() {
        String serialNo = getSerialNo();
        return "".equals(serialNo) ? "" : AbstractC0541b.m772n(PRE_ID, serialNo);
    }

    public Bundle getDeviceInfoBundle(Context context) {
        Bundle bundle = new Bundle();
        try {
            bundle.putBundle(TAG_DEVICEINFO, new Bundle());
        } catch (Exception unused) {
        }
        try {
            bundle.getBundle(TAG_DEVICEINFO).putString(TAG_SERVICECLIENT_VERSION, getPackageVersion(context));
        } catch (Exception unused2) {
        }
        return bundle;
    }

    public String getPackageVersion(Context context) {
        String packageVersion = CommonUtils.getPackageVersion(context);
        return !TextUtils.isEmpty(packageVersion) ? packageVersion : "unknown";
    }
}
