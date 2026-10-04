package com.samsung.android.support.senl.p148nt.base.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001d\u0010\r\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010J%\u0010\r\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\b\u0010\u001f\u001a\u00020\u0005H\u0007J\b\u0010 \u001a\u00020\u0005H\u0007J\b\u0010!\u001a\u00020\u0005H\u0007J\b\u0010\"\u001a\u00020\u0005H\u0007J\b\u0010#\u001a\u00020\u0005H\u0007J\u001a\u0010$\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010%\u001a\u00020\u0005H\u0007J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u000e\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020'J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020'J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0007J\b\u00105\u001a\u00020\u0007H\u0007J\u0012\u0010:\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J\u0012\u0010;\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010)H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\u0006\u0010\tR\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0003\u001a\u0004\b6\u0010\tR\u001a\u00108\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0003\u001a\u0004\b8\u0010\t¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/CommonUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isOnMainUIThread", "", "isOnMainUIThread$annotations", "()Z", "makeSimpleClassName", "element", "Ljava/lang/StackTraceElement;", "getCallee", "stackTrace", "", "([Ljava/lang/StackTraceElement;)Ljava/lang/String;", "dumpFullBacktrace", "([Ljava/lang/StackTraceElement;Z)Ljava/lang/String;", "isCurrentUserStorageDevice", "path", "hasSamsungAccountPackage", "context", "Landroid/content/Context;", "hasCloudSetting", "isSamsungCloudUpper505", "hasSaSetting", "notesAppId", "notesxAppId", "notesxB2BAppId", "notesxAppIdForStageAccount", "getAppServiceId", "getAppB2BServiceId", "getOldNotesServiceId", "getNewNotesServiceId", "getAppServiceIdForStageAccount", "isPackageInstalledAndEnabled", "packageName", "getDeviceScreenRatio", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "ASPECT_RATIO_TOLERANCE", "", "isSubLcdRatio", "ratio", "isMainLcdRatio", "nextLayoutChanged", "", "view", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnLayoutChangeListener;", "needToClearAppData", "isSupportHideNavigationOption", "isSupportHideNavigationOption$annotations", "isDefaultHideNavigationOptionEnabled", "isDefaultHideNavigationOptionEnabled$annotations", "isAvailableActivity", "isNotAvailableActivity", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCommonUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/CommonUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,300:1\n1#2:301\n*E\n"})
public final class CommonUtils {
    private static final double ASPECT_RATIO_TOLERANCE = 0.016d;

    @NotNull
    public static final CommonUtils INSTANCE = new CommonUtils();

    @NotNull
    private static final String TAG = "CommonUtils";

    @NotNull
    private static final String notesAppId = "xz99ihf893";

    @NotNull
    private static final String notesxAppId = "n9s985jz7n";

    @NotNull
    private static final String notesxAppIdForStageAccount = "b38dfdt1rb";

    @NotNull
    private static final String notesxB2BAppId = "aplmj8qh0c";

    private CommonUtils() {
    }

    @JvmStatic
    @NotNull
    public static final String getAppB2BServiceId() {
        return notesxB2BAppId;
    }

    @JvmStatic
    @NotNull
    public static final String getAppServiceId() {
        return notesxAppId;
    }

    @JvmStatic
    @NotNull
    public static final String getAppServiceIdForStageAccount() {
        return notesxAppIdForStageAccount;
    }

    @JvmStatic
    @NotNull
    public static final String getCallee(@Nullable StackTraceElement[] stackTrace) {
        return getCallee(stackTrace, false);
    }

    @JvmStatic
    @NotNull
    public static final String getNewNotesServiceId() {
        return notesxAppId;
    }

    @JvmStatic
    @NotNull
    public static final String getOldNotesServiceId() {
        return notesAppId;
    }

    @JvmStatic
    public static final boolean hasCloudSetting(@Nullable Context context) {
        if (context == null) {
            Debugger.INSTANCE.m8619d(TAG, "hasCloudSetting: false <- context is null");
            return false;
        }
        if (!PackageManagerCompat.INSTANCE.getInstance().isPackageEnabled(context, "com.samsung.android.scloud", true, "1.9")) {
            Debugger.INSTANCE.m8619d(TAG, "hasCloudSetting: false <- package is not enabled");
            return false;
        }
        SystemPropertiesCompat companion = SystemPropertiesCompat.INSTANCE.getInstance();
        if (companion.isVZWModel()) {
            if (!companion.isOmcByod()) {
                Debugger.INSTANCE.m8619d(TAG, "hasCloudSetting: false <- only VZW");
                return false;
            }
            Debugger.INSTANCE.m8619d(TAG, "hasCloudSetting: true <- VZW & OmcByod");
        }
        return true;
    }

    @JvmStatic
    public static final boolean hasSaSetting(@Nullable Context context) {
        if (!TextUtils.equals(CscFeature.INSTANCE.getInstance().getSamsungCloudBrandType(), "NA_NOBRAND") || SystemPropertiesCompat.INSTANCE.getInstance().isOmcByod()) {
            return !hasCloudSetting(context);
        }
        Debugger.INSTANCE.m8619d(TAG, "hasSaSetting: SamsungCloudBrandType = NO_NOBRAND");
        return true;
    }

    @JvmStatic
    public static final boolean hasSamsungAccountPackage(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo("com.osp.app.signin", 128);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            AbstractC4539a.m3188B("hasSamsungAccountPackage# NameNotFoundException:", e.getMessage(), TAG);
            return false;
        }
    }

    @JvmStatic
    public static final boolean isAvailableActivity(@Nullable Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    @JvmStatic
    public static final boolean isCurrentUserStorageDevice(@Nullable String path) {
        int userId = UserHandleCompat.INSTANCE.getInstance().getUserId(0);
        if (userId == 0) {
            return (path == null || StringsKt.m14145S(path, "/data/knox/sdcard/")) ? false : true;
        }
        return Intrinsics.areEqual("/data/knox/sdcard/" + userId, path);
    }

    public static final boolean isDefaultHideNavigationOptionEnabled() {
        if (!isSupportHideNavigationOption()) {
            return false;
        }
        if (!DeviceUtils.isTabletModel()) {
            FoldStateCompat.Companion companion = FoldStateCompat.INSTANCE;
            if (!companion.getInstance().isFoldableDevice() || companion.getInstance().getFoldType() != 1) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static /* synthetic */ void isDefaultHideNavigationOptionEnabled$annotations() {
    }

    @JvmStatic
    public static final boolean isNotAvailableActivity(@Nullable Activity activity) {
        return !isAvailableActivity(activity);
    }

    public static final boolean isOnMainUIThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    @JvmStatic
    public static /* synthetic */ void isOnMainUIThread$annotations() {
    }

    @JvmStatic
    public static final boolean isPackageInstalledAndEnabled(@Nullable Context context, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        PackageManagerCompat companion = PackageManagerCompat.INSTANCE.getInstance();
        if (!companion.isPackageInstalled(context, packageName)) {
            Logger.m8702i(TAG, packageName + " not installed");
            return false;
        }
        Logger.m8702i(TAG, packageName + " installed");
        if ((context == null || !SettingsCompat.INSTANCE.getInstance().isUPSM(context)) && !EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(context)) {
            return true;
        }
        if (companion.checkPackageEnabledSetting(context, packageName)) {
            Logger.m8702i(TAG, packageName + " Enabled in UPSM");
            return true;
        }
        Logger.m8702i(TAG, packageName + " Disable in UPSM");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isSamsungCloudUpper505(@Nullable Context context) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo("com.samsung.android.scloud", 128) : null;
                if (packageInfo != null) {
                    return packageInfo.versionCode >= 500500000;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Debugger.INSTANCE.m8627i(TAG, "isSamsungCloudUpper505() : No SCloud Package!");
            } catch (Exception e) {
                Debugger.INSTANCE.m8621e(TAG, "isSamsungCloudUpper505() : " + e);
            }
        }
        return false;
    }

    public static final boolean isSupportHideNavigationOption() {
        return DeviceUtils.isSpenModel() && InputMethodCompat.INSTANCE.hasSoftKey() && Build.VERSION.SDK_INT >= 29;
    }

    @JvmStatic
    public static /* synthetic */ void isSupportHideNavigationOption$annotations() {
    }

    private final String makeSimpleClassName(StackTraceElement element) {
        String className = element.getClassName();
        if (className != null) {
            className = FileUtils.extractFileExtension(className);
        }
        if (className == null) {
            className = "";
        }
        return className + "$" + element.getMethodName() + ", line: " + element.getLineNumber();
    }

    @JvmStatic
    public static final boolean needToClearAppData() {
        return false;
    }

    @JvmStatic
    public static final void nextLayoutChanged(@NotNull View view, @NotNull final View.OnLayoutChangeListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, "listener");
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.base.common.util.CommonUtils.nextLayoutChanged.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                Intrinsics.checkNotNullParameter(v, "v");
                listener.onLayoutChange(v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom);
                v.removeOnLayoutChangeListener(this);
            }
        });
    }

    public final float getDeviceScreenRatio(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getWindowManager().getDefaultDisplay().getRealSize(new Point());
        return r0.y / r0.x;
    }

    public final boolean isMainLcdRatio(float ratio) {
        return Math.abs((double) (1.4010416f - ratio)) < ASPECT_RATIO_TOLERANCE || Math.abs((double) (0.7137546f - ratio)) < ASPECT_RATIO_TOLERANCE;
    }

    public final boolean isSubLcdRatio(float ratio) {
        return ratio == 2.3330357f || Math.abs((double) (2.3333333f - ratio)) < ASPECT_RATIO_TOLERANCE || Math.abs((double) (0.42857143f - ratio)) < ASPECT_RATIO_TOLERANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[PHI: r2
      0x0044: PHI (r2v2 int) = (r2v1 int), (r2v1 int), (r2v4 int) binds: [B:11:0x001c, B:13:0x002d, B:18:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[LOOP:0: B:10:0x0014->B:21:0x0047, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049 A[EDGE_INSN: B:25:0x0049->B:22:0x0049 BREAK  A[LOOP:0: B:10:0x0014->B:21:0x0047], SYNTHETIC] */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String getCallee(@Nullable StackTraceElement[] stackTrace, boolean dumpFullBacktrace) {
        int length;
        int i = dumpFullBacktrace ? Integer.MAX_VALUE : 2;
        StringBuilder sb = new StringBuilder();
        if (stackTrace != null && stackTrace.length - 1 >= 0) {
            int i2 = 0;
            while (true) {
                int i4 = length - 1;
                StackTraceElement stackTraceElement = stackTrace[length];
                if (stackTraceElement.getClassName() != null) {
                    String className = stackTraceElement.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
                    if (StringsKt.m14162r(className, "com.samsung.android")) {
                        int i5 = i2 + 1;
                        if (i2 >= i) {
                            break;
                        }
                        sb.append(INSTANCE.makeSimpleClassName(stackTraceElement));
                        sb.append('/');
                        i2 = i5;
                        if (i4 >= 0) {
                        }
                    } else {
                        if (i4 >= 0) {
                            break;
                        }
                        length = i4;
                    }
                }
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
