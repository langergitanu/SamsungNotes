package com.sec.android.diagmonagent.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.sec.android.diagmonagent.common.logger.AppLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CommonUtils {
    public static final String DMA_PKG_NAME = "com.sec.android.diagmonagent";
    private static final int NO_EXIST = 0;
    private static String PKG_VERSION;
    private static PackageInfo SERVICE_PKG_INFO;

    public static int getDMAVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.sec.android.diagmonagent", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            AppLog.m13141e("DMA Client is not exist");
            return 0;
        }
    }

    public static String getPackageVersion(Context context) {
        if (PKG_VERSION == null) {
            PackageInfo servicePkgInfo = getServicePkgInfo(context);
            if (servicePkgInfo != null) {
                PKG_VERSION = servicePkgInfo.versionName;
            } else {
                PKG_VERSION = "";
            }
        }
        return PKG_VERSION;
    }

    public static PackageInfo getServicePkgInfo(Context context) {
        if (SERVICE_PKG_INFO == null) {
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    SERVICE_PKG_INFO = packageManager.getPackageInfo(packageName, 4096);
                } catch (PackageManager.NameNotFoundException unused) {
                    AppLog.m13141e(packageName + " is not found");
                }
            }
        }
        return SERVICE_PKG_INFO;
    }
}
