package com.samsung.android.sdk.handwriting.resources.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.handwriting.resources.impl.HWRVersion;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HwrTools {
    private static final String TAG = "HwrTools";

    public static int compareTwoVersions(String str, String str2) {
        return new HWRVersion(str).compareTo(new HWRVersion(str2));
    }

    public static String getVersionNameOf(Context context, String str) {
        AbstractC6670b.m4756q("input package name : ", str, TAG);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
            if (packageInfo == null) {
                Log.e(TAG, "package info is null!");
                return "";
            }
            Log.i(TAG, "APK Version = " + packageInfo.versionName);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "No HandwritingService");
            return "";
        } catch (Exception unused2) {
            Logger.getLogger(TAG).log(Level.INFO, "No authority to handwriting provider");
            return "";
        }
    }
}
