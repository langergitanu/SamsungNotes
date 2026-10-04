package com.samsung.android.support.senl.p148nt.app.addons.stub;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.AppUpdateUtil;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0007J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u000e\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u000e\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020(J\u0012\u0010-\u001a\u00020&2\b\u0010.\u001a\u0004\u0018\u00010/H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\u000e¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/stub/StubUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "APK_DOWNLOAD_DIR", "Ljava/io/File;", "getAPK_DOWNLOAD_DIR", "()Ljava/io/File;", "setAPK_DOWNLOAD_DIR", "(Ljava/io/File;)V", "APK_FILE_PREFIX", "getAPK_FILE_PREFIX", "()Ljava/lang/String;", "APK_FILE_SUFFIX", "getAPK_FILE_SUFFIX", "REQUEST_APK_INSTALL_TO_GALAXYAPPS", "", "ADDONS_PAKAGE_NAME", "DIRECTORY_NAME", "versionCode", "getVersionCode", "versionIntCode", "getVersionIntCode$annotations", "getVersionIntCode", "()I", "versionName", "getVersionName$annotations", "getVersionName", "extuk", "getExtuk$annotations", "getExtuk", "callGalaxyAppsClientAppUsingDeepLink", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "isNoMatchingApplication", "", "data", "Lcom/samsung/android/support/senl/nt/app/addons/stub/StubData;", "isUpdateNotNecessary", "isUpdateAvailable", "isError", "stubDate", "isAddonExist", "context", "Landroid/content/Context;", "OnDeviceIdListener", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StubUtil {

    @NotNull
    public static final String ADDONS_PAKAGE_NAME = "com.samsung.android.app.notes.addons";

    @Nullable
    private static File APK_DOWNLOAD_DIR = null;

    @NotNull
    private static final String APK_FILE_PREFIX;

    @NotNull
    private static final String APK_FILE_SUFFIX;

    @NotNull
    public static final String DIRECTORY_NAME = "addonsDownload";

    @NotNull
    public static final StubUtil INSTANCE = new StubUtil();
    public static final int REQUEST_APK_INSTALL_TO_GALAXYAPPS = 1;

    @NotNull
    private static final String TAG = "StubManager$StubUtil";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/stub/StubUtil$OnDeviceIdListener;", "", "success", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnDeviceIdListener {
        void success();
    }

    static {
        Context appContext = ApplicationManager.INSTANCE.getInstance().getAppContext();
        if (appContext != null) {
            String strM757C = AbstractC0541b.m757C(appContext.getFilesDir().getPath(), File.separator, DIRECTORY_NAME);
            if (FileUtils.makeDirectory(strM757C)) {
                APK_DOWNLOAD_DIR = new File(strM757C);
            }
        }
        APK_FILE_PREFIX = "com.samsung.android.app.notes.addons_";
        APK_FILE_SUFFIX = ".apk";
    }

    private StubUtil() {
    }

    @JvmStatic
    public static final void callGalaxyAppsClientAppUsingDeepLink(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (AppUpdateUtil.isQaServerEnabled()) {
            MainLogger.m7258i(TAG, "callGalaxyAppsClientAppUsingDeepLink# in Pre-deployed or Pre-distributed status");
        } else {
            MainLogger.m7258i(TAG, "callGalaxyAppsClientAppUsingDeepLink# in Deployed or For sale status");
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse("samsungapps://ProductDetail/com.samsung.android.app.notes.addons/?source=SamsungNotes&fsOrigin=stubUpdateCheck&fsUpdateType=ond"));
        intent.putExtra("type", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.MAIN_THUMBNAIL_FILE_NAME_COVER);
        intent.addFlags(335544352);
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            try {
                activity.startActivityForResult(intent, 1);
            } catch (ActivityNotFoundException e) {
                AbstractC6670b.m4738C("goToGalaxyAppStore# ", e.getMessage(), TAG);
            }
        }
    }

    @NotNull
    public static final String getExtuk() {
        String androidDeviceId;
        Context applicationContext = BaseUtils.getApplicationContext();
        return (applicationContext == null || (androidDeviceId = SettingsCompat.INSTANCE.getInstance().getAndroidDeviceId(applicationContext)) == null) ? "" : androidDeviceId;
    }

    @JvmStatic
    public static /* synthetic */ void getExtuk$annotations() {
    }

    public static final int getVersionIntCode() {
        PackageManager packageManager;
        try {
            Context appContext = ApplicationManager.INSTANCE.getInstance().getAppContext();
            PackageInfo packageInfo = (appContext == null || (packageManager = appContext.getPackageManager()) == null) ? null : packageManager.getPackageInfo("com.samsung.android.app.notes.addons", 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            MainLogger.m7255e(TAG, e.getMessage());
            return 0;
        }
    }

    @JvmStatic
    public static /* synthetic */ void getVersionIntCode$annotations() {
    }

    @NotNull
    public static final String getVersionName() {
        PackageManager packageManager;
        try {
            Context appContext = ApplicationManager.INSTANCE.getInstance().getAppContext();
            PackageInfo packageInfo = (appContext == null || (packageManager = appContext.getPackageManager()) == null) ? null : packageManager.getPackageInfo("com.samsung.android.app.notes.addons", 0);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                if (str != null) {
                    return str;
                }
            }
            return "";
        } catch (PackageManager.NameNotFoundException e) {
            MainLogger.m7255e(TAG, e.getMessage());
            return "";
        }
    }

    @JvmStatic
    public static /* synthetic */ void getVersionName$annotations() {
    }

    @JvmStatic
    public static final boolean isAddonExist(@Nullable Context context) {
        return PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(context, "com.samsung.android.app.notes.addons");
    }

    @Nullable
    public final File getAPK_DOWNLOAD_DIR() {
        return APK_DOWNLOAD_DIR;
    }

    @NotNull
    public final String getAPK_FILE_PREFIX() {
        return APK_FILE_PREFIX;
    }

    @NotNull
    public final String getAPK_FILE_SUFFIX() {
        return APK_FILE_SUFFIX;
    }

    @NotNull
    public final String getVersionCode() {
        int versionIntCode = getVersionIntCode();
        return versionIntCode > 0 ? String.valueOf(versionIntCode) : "";
    }

    public final boolean isError(@NotNull StubData stubDate) {
        Intrinsics.checkNotNullParameter(stubDate, "stubDate");
        String resultCode = stubDate.getResultCode();
        MainLogger.m7258i(TAG, "resultCode# : " + resultCode + ", resultMsg# " + stubDate.getResultMsg());
        return (Intrinsics.areEqual("0", resultCode) || Intrinsics.areEqual("1", resultCode) || Intrinsics.areEqual("2", resultCode) || Intrinsics.areEqual("0", resultCode) || Intrinsics.areEqual("1", resultCode)) ? false : true;
    }

    public final boolean isNoMatchingApplication(@NotNull StubData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Intrinsics.areEqual("0", data.getResultCode());
    }

    public final boolean isUpdateAvailable(@NotNull StubData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Intrinsics.areEqual("2", data.getResultCode());
    }

    public final boolean isUpdateNotNecessary(@NotNull StubData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Intrinsics.areEqual("1", data.getResultCode());
    }

    public final void setAPK_DOWNLOAD_DIR(@Nullable File file) {
        APK_DOWNLOAD_DIR = file;
    }
}
