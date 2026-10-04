package androidx.appsearch.platformstorage.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AppSearchVersionUtil {
    private static final String APPSEARCH_MODULE_NAME = "com.android.appsearch";
    private static volatile long sAppSearchVersionCode = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(29)
    public static class ApiHelperForQ {
        private ApiHelperForQ() {
        }

        @DoNotInline
        public static String getAppSearchPackageName(PackageManager packageManager) {
            return packageManager.getModuleInfo("com.android.appsearch", 1).getPackageName();
        }

        @DoNotInline
        public static long getPackageInfoLongVersionCode(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MainlineVersions {
        public static final long M2023_11 = 341113000;
        public static final long M2024_11 = 351112060;
        public static final long U_BASE = 340800000;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TExtensionVersions {
        public static final int U_BASE = 7;
    }

    private AppSearchVersionUtil() {
    }

    @RequiresApi(29)
    public static long getAppSearchVersionCode(Context context) {
        Preconditions.checkNotNull(context);
        if (sAppSearchVersionCode != -1) {
            return sAppSearchVersionCode;
        }
        synchronized (AppSearchVersionUtil.class) {
            if (sAppSearchVersionCode == -1) {
                long packageInfoLongVersionCode = 0;
                try {
                    PackageManager packageManager = context.getPackageManager();
                    String appSearchPackageName = ApiHelperForQ.getAppSearchPackageName(packageManager);
                    if (appSearchPackageName != null) {
                        packageInfoLongVersionCode = ApiHelperForQ.getPackageInfoLongVersionCode(packageManager.getPackageInfo(appSearchPackageName, 1073741824));
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                sAppSearchVersionCode = packageInfoLongVersionCode;
            }
        }
        return sAppSearchVersionCode;
    }
}
