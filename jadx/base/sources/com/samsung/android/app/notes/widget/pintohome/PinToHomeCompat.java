package com.samsung.android.app.notes.widget.pintohome;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ.\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/pintohome/PinToHomeCompat;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LAUNCHER_PACKAGE_NAME", "isPinToHomeSupportedDevice", "", "context", "Landroid/content/Context;", "isSatisfySecModeConditions", "requestPinToHome", "", "uuid", "path", "targetWidgetProvider", "Ljava/lang/Class;", "setSpanXY", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "isKnoxFolderMode", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PinToHomeCompat {
    public static final int $stable = 0;

    @NotNull
    public static final PinToHomeCompat INSTANCE = new PinToHomeCompat();

    @NotNull
    private static final String LAUNCHER_PACKAGE_NAME = "com.sec.android.app.launcher";

    @NotNull
    private static final String TAG = "PinToHomeCompat";

    private PinToHomeCompat() {
    }

    private final boolean isKnoxFolderMode(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), "KNOX_SETTINGS_KNOX_STYLE");
        Logger.m8697d(TAG, "knox mode : " + string);
        return Intrinsics.areEqual("FOLDER", string);
    }

    private final void setSpanXY(Context context, Intent intent) {
        CommonUtils commonUtils = CommonUtils.INSTANCE;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        boolean zIsSubLcdRatio = commonUtils.isSubLcdRatio(commonUtils.getDeviceScreenRatio(activity));
        boolean zIsMainLcdRatio = commonUtils.isMainLcdRatio(commonUtils.getDeviceScreenRatio(activity));
        int i = (zIsSubLcdRatio || zIsMainLcdRatio) ? zIsMainLcdRatio ? 5 : 3 : 10;
        Logger.m8697d(TAG, "setSpanXY, " + i + "x2");
        intent.putExtra(WidgetConstant.WIDGET_SAMSUNG_SPAN_X, i);
        intent.putExtra(WidgetConstant.WIDGET_SAMSUNG_SPAN_Y, 2);
    }

    public final boolean isPinToHomeSupportedDevice(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 29) {
            Logger.m8697d(TAG, "isPinToHomeSupportedDeviceOverQOS()");
            return AppWidgetManager.getInstance(context).isRequestPinAppWidgetSupported();
        }
        Logger.m8697d(TAG, "isPinToHomeSupportedDeviceLessThanQOS()");
        List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new Intent(WidgetConstant.WIDGET_SAMSUNG_LAUNCHER_BIND_WIDGET, (Uri) null), 0);
        Intrinsics.checkNotNullExpressionValue(listQueryBroadcastReceivers, "queryBroadcastReceivers(...)");
        return !listQueryBroadcastReceivers.isEmpty();
    }

    public final boolean isSatisfySecModeConditions(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!DeviceUtils.isPowerManageMode(context)) {
            UserHandleCompat companion = UserHandleCompat.INSTANCE.getInstance();
            if ((!companion.isKnoxMode() && !companion.isSecureFolderMode()) || !isKnoxFolderMode(context)) {
                return true;
            }
        }
        return false;
    }

    public final void requestPinToHome(@NotNull Context context, @Nullable String uuid, @Nullable String path, @NotNull Class<?> targetWidgetProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetWidgetProvider, "targetWidgetProvider");
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Logger.m8697d(TAG, "requestPinToHomeOverQOS()");
            AppWidgetManager appWidgetManager = (AppWidgetManager) context.getSystemService(AppWidgetManager.class);
            if (appWidgetManager == null || !appWidgetManager.isRequestPinAppWidgetSupported()) {
                return;
            }
            try {
                Intent intent = new Intent(context, (Class<?>) WidgetPinnedReceiver.class);
                intent.putExtra(WidgetConstant.WIDGET_PIN_TO_HOME, uuid);
                intent.putExtra(WidgetConstant.WIDGET_PIN_TO_HOME_FILE_PATH, path);
                appWidgetManager.requestPinAppWidget(new ComponentName(context, targetWidgetProvider), null, PendingIntent.getBroadcast(context, 0, intent, 167772160));
                return;
            } catch (Exception e) {
                AbstractC4539a.m3214x("failed to request the pinAppWidget : ", e.getMessage(), TAG);
                return;
            }
        }
        Logger.m8697d(TAG, "requestPinToHomeLessThanPOS()");
        WidgetPreferenceManager.saveDocInfoForPinToHome(String.valueOf(uuid), path);
        Logger.m8697d(TAG, WidgetPreferenceManager.getPinUUID());
        Intent intent2 = new Intent();
        intent2.setAction(WidgetConstant.WIDGET_SAMSUNG_LAUNCHER_BIND_WIDGET);
        intent2.putExtra(WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, context.getPackageName() + "/" + targetWidgetProvider.getName());
        setSpanXY(context, intent2);
        intent2.setPackage("com.sec.android.app.launcher");
        if (i <= 27) {
            Logger.m8697d(TAG, "pinToHme, show a pin toast");
            String string = context.getString(C11391R.string.pin_toast);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ToastHandler.show(context, string, 1);
        }
        context.sendBroadcast(intent2);
    }
}
