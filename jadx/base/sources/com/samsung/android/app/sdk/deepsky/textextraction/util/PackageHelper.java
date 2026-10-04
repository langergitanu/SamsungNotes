package com.samsung.android.app.sdk.deepsky.textextraction.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/util/PackageHelper;", "", "()V", SearchConstants.TargetContents.TAG, "", "isPackageExists", "", "context", "Landroid/content/Context;", "targetPackage", "targetActivity", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PackageHelper {

    @NotNull
    public static final PackageHelper INSTANCE = new PackageHelper();

    @NotNull
    private static final String TAG = "PackageHelper";

    private PackageHelper() {
    }

    public final boolean isPackageExists(@NotNull Context context, @NotNull String targetPackage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetPackage, "targetPackage");
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            return packageManager.getPackageInfo(targetPackage, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            LibLogger.m5430e(TAG, targetPackage + " does not exist");
            return false;
        }
    }

    public final boolean isPackageExists(@NotNull Context context, @NotNull String targetPackage, @NotNull String targetActivity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetPackage, "targetPackage");
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(targetPackage, targetActivity), 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            LibLogger.m5430e(TAG, targetActivity + " is not found.");
            return false;
        }
    }
}
