package com.samsung.android.support.senl.p148nt.app.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6875b;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6880g;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.io.File;
import p033H0.C0112b;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class AppUpdateUtil {
    private static final String TAG = "AppUpdateUtil";

    public static String getAbiType() {
        return Build.SUPPORTED_64_BIT_ABIS.length > 0 ? "64" : Build.SUPPORTED_32_BIT_ABIS.length > 0 ? "32" : "ex";
    }

    public static String getAccountToken() {
        return C13541h.m14287e().m14291d();
    }

    public static String getAccountUrl() {
        ((C6880g) ((C0112b) C13541h.m14287e().f9589b).f363b).getClass();
        return C6875b.m5062c().f4382h;
    }

    public static String getCsc() {
        String salesCode;
        try {
            salesCode = SystemPropertiesCompat.INSTANCE.getInstance().getSalesCode();
        } catch (Exception unused) {
            salesCode = "FAIL";
        }
        return (salesCode == null || salesCode.isEmpty()) ? CoverStickerConstants.Category.NONE.NAME : salesCode;
    }

    public static String getDeviceId() {
        return Build.MODEL.replaceFirst("SAMSUNG-", "");
    }

    public static String getISO3Country() {
        if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            return CoverStickerConstants.Category.NONE.NAME;
        }
        ((C6880g) ((C0112b) C13541h.m14287e().f9589b).f363b).getClass();
        String str = C6875b.m5062c().f4383i;
        return TextUtils.isEmpty(str) ? "FAIL" : str;
    }

    public static String getMcc() {
        String simOperator;
        TelephonyManager telephonyManager = (TelephonyManager) ApplicationManager.getInstance().getAppContext().getSystemService("phone");
        return (telephonyManager == null || (simOperator = telephonyManager.getSimOperator()) == null || simOperator.length() <= 3) ? "" : simOperator.substring(0, 3);
    }

    public static String getMnc() {
        String simOperator;
        TelephonyManager telephonyManager = (TelephonyManager) ApplicationManager.getInstance().getAppContext().getSystemService("phone");
        return (telephonyManager == null || (simOperator = telephonyManager.getSimOperator()) == null || simOperator.length() <= 3) ? "" : simOperator.substring(3);
    }

    public static String getPackageName() {
        return ApplicationManager.getInstance().getAppContext().getPackageName();
    }

    public static String getPd() {
        if (isQaServerEnabled()) {
            MainLogger.m7258i(TAG, "getPd# in Pre-deployed or Pre-distributed status");
            return "1";
        }
        MainLogger.m7258i(TAG, "getPd# in Deployed or For sale status");
        return "0";
    }

    public static String getSdkVer() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String getSystemId() {
        return String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
    }

    private static boolean isChina() {
        String mcc = getMcc();
        return "460".equals(mcc) || "461".equals(mcc);
    }

    public static boolean isDataNetworkConnected(Context context) {
        boolean zIsConnected;
        try {
            zIsConnected = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        } catch (RuntimeException e) {
            MainLogger.m7255e(TAG, "isDataNetworkConnected # " + e.getMessage());
            zIsConnected = false;
        }
        AbstractC6670b.m4739D("isDataNetworkConnected() isConnected : ", TAG, zIsConnected);
        return zIsConnected;
    }

    public static boolean isDeviceIdServiceSupported() {
        return isChina() && PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(ApplicationManager.getInstance().getAppContext(), "com.samsung.android.deviceidservice") && Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isQaServerEnabled() {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getPath());
        String str = File.separator;
        AbstractC2821a.m2207B(sb, str, TelemetryEventStrings.C6439Os.OS_NAME, str, "obb");
        sb.append(str);
        sb.append("go_to_andromeda.test");
        return FileUtils.exists(sb.toString());
    }

    public static boolean isWifiNetworkConnected(Context context) {
        boolean z = false;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                if (activeNetworkInfo.isConnected()) {
                    z = true;
                }
            }
        } catch (RuntimeException e) {
            MainLogger.m7255e(TAG, "isWifiNetworkConnected # " + e.getMessage());
        }
        AbstractC6670b.m4739D("isWifiNetworkConnected() isConnected : ", TAG, z);
        return z;
    }
}
