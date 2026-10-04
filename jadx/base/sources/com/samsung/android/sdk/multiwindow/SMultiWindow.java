package com.samsung.android.sdk.multiwindow;

import android.app.ActivityThread;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.core.p139ai.sdkcommon.ExtensionConst;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.SsdkVendorCheck;
import com.samsung.android.sdk.multiwindow.SMultiWindowReflator;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class SMultiWindow implements SsdkInterface {
    public static final int FREE_STYLE = 2;
    public static final int MULTIWINDOW = 1;
    private static final String TAG = "SMultiWindow";
    private static boolean enableQueried = false;
    private static boolean isFreeStyleEnabled = false;
    private static boolean isMultiWindowEnabled = false;
    private static int mVersionCode = 5;
    private static String mVersionName = "1.3.1";
    private boolean mInsertLog = false;
    private SMultiWindowReflator mMultiWindowReflator = new SMultiWindowReflator();

    public SMultiWindow() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            ActivityThread activityThreadCurrentActivityThread = ActivityThread.currentActivityThread();
            this.mMultiWindowReflator.putMethod(cls, activityThreadCurrentActivityThread, "getApplication", null);
            this.mMultiWindowReflator.putMethod(cls, activityThreadCurrentActivityThread, "getSystemContext", null);
        } catch (Exception unused) {
        }
        initMultiWindowFeature();
    }

    private void initMultiWindowFeature() {
        PackageManager packageManager;
        try {
            if (enableQueried) {
                return;
            }
            enableQueried = true;
            Context context = this.mMultiWindowReflator.checkMethod("getApplication") ? (Context) this.mMultiWindowReflator.invoke("getApplication", null) : null;
            if (context == null && this.mMultiWindowReflator.checkMethod("getSystemContext")) {
                context = (Context) this.mMultiWindowReflator.invoke("getSystemContext", null);
            }
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                return;
            }
            isMultiWindowEnabled = packageManager.hasSystemFeature(SMultiWindowReflator.PackageManager.FEATURE_MULTIWINDOW);
            isFreeStyleEnabled = packageManager.hasSystemFeature(SMultiWindowReflator.PackageManager.FEATURE_MULTIWINDOW_FREESTYLE);
        } catch (Exception unused) {
        }
    }

    private void insertLog(Context context) {
        int i;
        try {
            i = context.getPackageManager().getPackageInfo("com.samsung.android.providers.context", 128).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.d(TAG, "Could not find ContextProvider");
            i = -1;
        }
        AbstractC0541b.m755A(i, "versionCode: ", TAG);
        if (i <= 1) {
            Log.d(TAG, "Add com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission");
            return;
        }
        if (context.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
            throw new SecurityException();
        }
        ContentValues contentValues = new ContentValues();
        String name = SMultiWindow.class.getPackage().getName();
        String str = context.getPackageName() + ContentUtils.HASH_SYMBOL + getVersionCode();
        contentValues.put("app_id", name);
        contentValues.put(ExtensionConst.KEY_PARAM_FEATURE, str);
        Intent intent = new Intent();
        intent.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
        intent.putExtra("data", contentValues);
        intent.setPackage("com.samsung.android.providers.context");
        context.sendBroadcast(intent);
        this.mInsertLog = true;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public int getVersionCode() {
        return mVersionCode;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public String getVersionName() {
        return mVersionName;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public void initialize(Context context) throws SsdkUnsupportedException {
        if (!SsdkVendorCheck.isSamsungDevice()) {
            throw new SsdkUnsupportedException(AbstractC0622a.m1170p(Build.BRAND, " is not supported.", new StringBuilder()), 0);
        }
        if (!isMultiWindowEnabled) {
            throw new SsdkUnsupportedException("The device is not supported.", 1);
        }
        try {
            if (this.mInsertLog) {
                return;
            }
            insertLog(context);
        } catch (SecurityException unused) {
            throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
        }
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public boolean isFeatureEnabled(int i) {
        if (i == 1) {
            return isMultiWindowEnabled;
        }
        if (i != 2) {
            return false;
        }
        return isFreeStyleEnabled;
    }
}
