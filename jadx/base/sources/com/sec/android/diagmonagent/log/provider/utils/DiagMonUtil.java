package com.sec.android.diagmonagent.log.provider.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.context.sdk.samsunganalytics.BuildConfig;
import com.sec.android.diagmonagent.common.logger.AppLog;
import com.sec.android.diagmonagent.common.util.CommonUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DiagMonUtil {
    public static final String ACTION_CUSTOM_AGREEMENT_WITHDRAWAL = "com.sec.android.diagmonagent.terms.CUSTOM_AGREEMENT_WITHDRAWAL";
    public static final String AGREE_TYPE_DIAGNOSTIC = "D";
    public static final String AGREE_TYPE_SERVICE = "S";
    public static final String AGREE_TYPE_SERVICE_LEGACY = "Y";
    public static final String DIAGMONAGENT_PACKAGE_NAME = "com.sec.android.diagmonagent";
    private static final int DMA_SUPPORT_VERSION = 600000000;
    public static final int LEGACY_DMA = 1;
    private static final long MAX_USABLE_SIZE = 1073741824;
    private static final long MIN_USABLE_SIZE = 314572800;
    public static final int NEW_DMA = 2;

    /* JADX INFO: renamed from: NO */
    public static final String f8263NO = "No";
    private static final int NOT_INITIALIZED = -1;
    public static final int NO_DMA = 0;
    public static final String SDK_TYPE_DEFAULT = "S";
    private static final int SEP_VER_12_1 = 120100;
    public static final String YES = "Yes";
    public static final String TAG = "DIAGMON_SDK[" + getSdkVersion() + "]";
    public static final Uri URI = Uri.parse("content://com.sec.android.log.diagmonagent/");
    private static int sDiagMonType = -1;

    public static int checkDMA(Context context) {
        if (sDiagMonType == -1) {
            sDiagMonType = initializeDMAType(context);
            AbstractC0000a.m26w(new StringBuilder("DiagMonAgent type: "), TAG, sDiagMonType);
        }
        return sDiagMonType;
    }

    public static String getLegacyAuthority(String str) {
        return AbstractC0541b.m772n("com.sec.android.log.", str);
    }

    public static String getSdkVersion() {
        try {
            return String.valueOf(BuildConfig.VERSION_CODE);
        } catch (Exception unused) {
            return "";
        }
    }

    private static int initializeDMAType(Context context) {
        int dMAVersion = CommonUtils.getDMAVersion(context);
        if (dMAVersion < DMA_SUPPORT_VERSION) {
            return dMAVersion == 0 ? 0 : 1;
        }
        return 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0015 A[PHI: r2
      0x0015: PHI (r2v9 long) = (r2v2 long), (r2v3 long) binds: [B:3:0x0013, B:6:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean insufficientStorage() {
        long totalSpace = (Environment.getDataDirectory().getTotalSpace() * 5) / 100;
        long j = 1073741824;
        if (totalSpace > 1073741824) {
            totalSpace = j;
        } else {
            j = MIN_USABLE_SIZE;
            if (totalSpace < MIN_USABLE_SIZE) {
            }
        }
        AppLog.m13140d("Storage size threshold : " + totalSpace + " bytes");
        long usableSpace = Environment.getDataDirectory().getUsableSpace();
        if (usableSpace >= totalSpace) {
            return false;
        }
        AppLog.m13144w("insufficient storage");
        AppLog.m13144w("usableSpace: " + usableSpace + ", threshold: " + totalSpace);
        return true;
    }

    @SuppressLint({WarningType.NewApi})
    public static String isForeground(Context context) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(ActivityManager.class)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(context.getPackageName())) {
                return YES;
            }
        }
        return f8263NO;
    }

    public static void printResultfromDMA(Bundle bundle) {
        try {
            String string = bundle.getString("result");
            String string2 = bundle.getString("cause");
            if (string2 == null) {
                AppLog.m13142i("Results : " + string);
            } else {
                AppLog.m13142i("Results : " + string + ", Cause : " + string2);
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public static boolean underPalette() {
        return Build.VERSION.SEM_PLATFORM_INT < SEP_VER_12_1;
    }
}
