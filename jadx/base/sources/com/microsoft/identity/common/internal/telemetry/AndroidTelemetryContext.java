package com.microsoft.identity.common.internal.telemetry;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.collection.AbstractC0622a;
import androidx.core.content.p110pm.PackageInfoCompat;
import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import com.microsoft.identity.common.java.telemetry.AbstractTelemetryContext;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.logging.Logger;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class AndroidTelemetryContext extends AbstractTelemetryContext {
    private static final String TAG = "AndroidTelemetryContext";

    @SuppressFBWarnings(justification = "Lombok inserts nullchecks", value = {SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE})
    public AndroidTelemetryContext(@NonNull Context context) {
        super(new AndroidTelemetryPropertiesCache(context));
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        addApplicationInfo(context);
        addDeviceInfo(Build.MANUFACTURER, Build.MODEL, Build.DEVICE);
        addOsInfo();
    }

    private void addApplicationInfo(@NonNull Context context) {
        String str;
        String string;
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":addApplicationInfo", new StringBuilder());
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            long longVersionCode = PackageInfoCompat.getLongVersionCode(packageInfo);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                str = applicationInfo.packageName;
                int i = applicationInfo.labelRes;
                if (i == 0) {
                    CharSequence charSequence = applicationInfo.nonLocalizedLabel;
                    if (charSequence != null) {
                        string = charSequence.toString();
                    }
                } else {
                    string = context.getString(i);
                }
                super.addApplicationInfo(str, string, packageInfo.versionName, String.valueOf(longVersionCode));
            }
            str = "";
            string = str;
            super.addApplicationInfo(str, string, packageInfo.versionName, String.valueOf(longVersionCode));
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.warn(strM1170p, "Unable to find the app's package name from PackageManager.");
        }
    }

    private void addOsInfo() {
        super.addOsInfo(TelemetryEventStrings.C6439Os.OS_NAME, Build.VERSION.RELEASE);
        put(TelemetryEventStrings.C6439Os.SECURITY_PATCH, Build.VERSION.SECURITY_PATCH);
    }

    public void isNetworkConnected(boolean z) {
        put(TelemetryEventStrings.Key.NETWORK_CONNECTION, String.valueOf(z));
    }

    public void isNetworkDisabledFromOptimizations(boolean z) {
        put(TelemetryEventStrings.Key.POWER_OPTIMIZATION, String.valueOf(z));
    }
}
