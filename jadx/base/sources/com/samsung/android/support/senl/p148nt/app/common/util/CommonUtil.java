package com.samsung.android.support.senl.p148nt.app.common.util;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import p186h1.AbstractC12031l;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CommonUtil {
    private static final String SSM_PACKAGE_NAME = "com.sec.android.easyMover";
    private static final int SSM_STANDARD_VERSION = 372100000;
    private static final String TAG = "CommonUtil";

    public static boolean isAvailableActivity(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static boolean isNeedPermissionGrantedForSSM(Context context) {
        int i = Settings.Global.getInt(context.getContentResolver(), "smartswitch_data_exist_samsungnote", 0);
        return i > 0 ? !AbstractC12031l.m13719i() : i < 0 && !AbstractC12031l.m13719i() && needPermissionAccordingToSSMVersion(context);
    }

    public static boolean isNotAvailableActivity(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }

    private static boolean needPermissionAccordingToSSMVersion(Context context) {
        int versionCode = PackageManagerCompat.INSTANCE.getInstance().getVersionCode(context, SSM_PACKAGE_NAME);
        AbstractC6670b.m4736A(versionCode, "needPermissionAccordingToSSMVersion# versionCode : ", TAG);
        return versionCode < SSM_STANDARD_VERSION;
    }
}
