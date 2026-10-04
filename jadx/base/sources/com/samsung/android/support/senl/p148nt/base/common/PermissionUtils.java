package com.samsung.android.support.senl.p148nt.base.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/PermissionUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "hasMemoStoragePermission", "", "context", "Landroid/content/Context;", "isSystemPackage", "showAllFilesAccessPermission", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPermissionUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionUtils.kt\ncom/samsung/android/support/senl/nt/base/common/PermissionUtils\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,79:1\n29#2:80\n*S KotlinDebug\n*F\n+ 1 PermissionUtils.kt\ncom/samsung/android/support/senl/nt/base/common/PermissionUtils\n*L\n73#1:80\n*E\n"})
public final class PermissionUtils {

    @NotNull
    public static final PermissionUtils INSTANCE = new PermissionUtils();

    @NotNull
    private static final String TAG = "PermissionUtils";

    private PermissionUtils() {
    }

    @JvmStatic
    public static final boolean hasMemoStoragePermission(@Nullable Context context) {
        return PackageManagerCompat.INSTANCE.getInstance().checkPackcagePermission(context, com.samsung.android.support.senl.p148nt.base.common.constants.Constants.MEMO_PACKAGE_NAME, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @JvmStatic
    @RequiresApi(30)
    public static final void showAllFilesAccessPermission(@Nullable Activity activity, int requestCode) {
        Logger.m8703w(TAG, "showAllFilesAccessPermission requestCode:" + requestCode);
        if (activity != null) {
            try {
                activity.startActivityForResult(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + activity.getPackageName())), requestCode);
            } catch (Exception e) {
                Logger.m8698e(TAG, e.getMessage());
                activity.startActivityForResult(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"), requestCode);
            }
        }
    }

    public final boolean isSystemPackage(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        String packageName = context.getApplicationContext().getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
            PackageInfo packageInfo2 = packageManager.getPackageInfo(TelemetryEventStrings.C6439Os.OS_NAME, 64);
            if ((packageInfo != null ? packageInfo.signatures : null) == null) {
                return false;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null && (applicationInfo.flags & 129) == 0) {
                return false;
            }
            Signature[] signatureArr = packageInfo.signatures;
            Intrinsics.checkNotNull(signatureArr);
            for (Signature signature : signatureArr) {
                Signature[] signatureArr2 = packageInfo2.signatures;
                Integer numValueOf = signatureArr2 != null ? Integer.valueOf(signatureArr2.length) : null;
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    for (int i = 0; i < iIntValue; i++) {
                        Signature[] signatureArr3 = packageInfo2.signatures;
                        if (Intrinsics.areEqual(signatureArr3 != null ? signatureArr3[i] : null, signature)) {
                            return true;
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            AbstractC4539a.m3214x("isSystemPackage# ", e.getMessage(), TAG);
        }
        return false;
    }
}
