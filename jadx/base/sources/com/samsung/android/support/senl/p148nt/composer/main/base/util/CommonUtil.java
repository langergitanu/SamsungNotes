package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingUILaserPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.document.SpenObjectShapeBase;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CommonUtil {
    public static final int INVALID_VALUE = -1;
    private static final String TAG = Logger.createTag("CommonUtil");

    public static boolean compare(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        return i == i6 && i4 == i8 && i2 == i7 && i5 == i9;
    }

    public static boolean compareLaserPenInfo(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo, SpenSettingUILaserPenInfo spenSettingUILaserPenInfo2) {
        return spenSettingUILaserPenInfo.equals(spenSettingUILaserPenInfo2);
    }

    public static boolean comparePenInfo(@NonNull SpenSettingUIPenInfo spenSettingUIPenInfo, SpenSettingUIPenInfo spenSettingUIPenInfo2) {
        return spenSettingUIPenInfo.equals(spenSettingUIPenInfo2);
    }

    public static boolean compareRemoverInfo(SpenSettingRemoverInfo spenSettingRemoverInfo, SpenSettingRemoverInfo spenSettingRemoverInfo2) {
        return spenSettingRemoverInfo.size == spenSettingRemoverInfo2.size && spenSettingRemoverInfo.type == spenSettingRemoverInfo2.type && spenSettingRemoverInfo.target == spenSettingRemoverInfo2.target;
    }

    public static boolean compareSelectionInfo(SpenSettingSelectionInfo spenSettingSelectionInfo, SpenSettingSelectionInfo spenSettingSelectionInfo2) {
        return spenSettingSelectionInfo.type == spenSettingSelectionInfo2.type && spenSettingSelectionInfo.includePartiallySelected == spenSettingSelectionInfo2.includePartiallySelected;
    }

    public static int convertLinePixelToSizeLevel(Context context, float f) {
        float minLineWidth = SpenObjectShapeBase.getMinLineWidth();
        float maxLineWidth = SpenObjectShapeBase.getMaxLineWidth();
        double d = ((double) f) / ((double) (context.getResources().getDisplayMetrics().densityDpi / 160.0f));
        double d2 = minLineWidth;
        return Math.max((int) Math.round(((Math.min(Math.max(d, d2), maxLineWidth) - d2) / ((double) (maxLineWidth - minLineWidth))) * 100.0d), 1);
    }

    public static void convertPenInfoSize(Context context, int i, int i2, ArrayList<SpenSettingUIPenInfo> arrayList) {
        AbstractC14516b.m15114b(i, i2, "convertPenInfoSize note width ", " height ", TAG);
        for (SpenSettingUIPenInfo spenSettingUIPenInfo : arrayList) {
            String str = TAG;
            Logger.m11003i(str, "previous penInfo " + spenSettingUIPenInfo.size + " , " + spenSettingUIPenInfo.sizeLevel + " , " + spenSettingUIPenInfo.name);
            spenSettingUIPenInfo.sizeLevel = SpenPenUtil.convertSizeToSizeLevel(context, spenSettingUIPenInfo.name, spenSettingUIPenInfo.size, i, i2);
            Logger.m11003i(str, "converted penInfo " + spenSettingUIPenInfo.size + " , " + spenSettingUIPenInfo.sizeLevel + " , " + spenSettingUIPenInfo.name);
        }
    }

    public static float getFontSizeByPx(Resources resources, @DimenRes int i, @DimenRes int i2) {
        int dimensionPixelSize = resources.getDimensionPixelSize(i);
        if (dimensionPixelSize < resources.getDimensionPixelSize(i2)) {
            return dimensionPixelSize * 0.7f;
        }
        return -1.0f;
    }

    public static boolean initSpenSdk(Context context) {
        Logger.m10999d(TAG, "initSpenSdk");
        return SpenSdkInitializer.initialize(context);
    }

    public static boolean isAutoTypeForDefaultEditingMode() {
        return SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE_AUTO.equals(SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE, SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE_AUTO));
    }

    public static boolean isAvailableActivity(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static final boolean isConfirmKey(int i) {
        return i == 23 || i == 62 || i == 66 || i == 160;
    }

    public static boolean isInitializedSpenSdk(Context context) {
        return SpenSdkInitializer.initialized(context);
    }

    public static boolean isLaunchedPen(Intent intent) {
        String string = SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE, SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE_AUTO);
        return SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE_AUTO.equals(string) ? intent.getIntExtra("tool_type", 0) == 2 : SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE_HANDWRITING.equals(string);
    }

    public static boolean isLockTaskMode(Context context) {
        boolean zIsInLockTaskMode = ((ActivityManager) context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY)).isInLockTaskMode();
        AbstractC8014b.m7220v("isLockTaskMode, isLockTaskMode: ", TAG, zIsInLockTaskMode);
        return zIsInLockTaskMode;
    }

    public static boolean isNotAvailableActivity(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }

    public static boolean isSos() {
        return Build.VERSION.SDK_INT > 30 || DeviceInfo.getSemPlatformVersionInt(0) >= 130000;
    }

    public static boolean isTaskRootAndLockTaskMode(Activity activity) {
        boolean z = isLockTaskMode(activity) && activity.isTaskRoot();
        AbstractC8014b.m7220v("isTaskRootAndLockTaskMode, ret: ", TAG, z);
        return z;
    }

    public static TypedValue resolveAttribute(Activity activity, @AttrRes int i) {
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue;
    }

    public static float getFontSizeByPx(Resources resources, Paint paint, @DimenRes int i, @DimenRes int i2) {
        int dimensionPixelSize = resources.getDimensionPixelSize(i);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i2);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = fontMetrics.bottom - fontMetrics.top;
        if (dimensionPixelSize < dimensionPixelSize2 || dimensionPixelSize < f) {
            return dimensionPixelSize * 0.8f;
        }
        return -1.0f;
    }
}
