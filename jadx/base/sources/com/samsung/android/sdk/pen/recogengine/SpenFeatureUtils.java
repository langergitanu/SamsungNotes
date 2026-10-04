package com.samsung.android.sdk.pen.recogengine;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0011\u0010\u0010\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenFeatureUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mIsSamsungDevice", "", "HWRSDK_PACKAGE_NAME", SpenFeatureUtils.SEC_FLOATING_FEATURE_COMMON_DISABLE_NATIVE_AI, "isSamsungDevice", "", "()Z", "isHandwritingRecognitionAvailable", "context", "Landroid/content/Context;", "isGalaxyAiDevice", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenFeatureUtils {

    @NotNull
    private static final String HWRSDK_PACKAGE_NAME = "com.samsung.android.sdk.handwriting";

    @NotNull
    private static final String SEC_FLOATING_FEATURE_COMMON_DISABLE_NATIVE_AI = "SEC_FLOATING_FEATURE_COMMON_DISABLE_NATIVE_AI";

    @NotNull
    private static final String TAG = "SpenFeatureUtils";

    @NotNull
    public static final SpenFeatureUtils INSTANCE = new SpenFeatureUtils();
    private static int mIsSamsungDevice = -1;

    private SpenFeatureUtils() {
    }

    public final boolean isGalaxyAiDevice() {
        if (!isSamsungDevice() || Build.VERSION.SDK_INT < 35) {
            return false;
        }
        try {
            return !SemFloatingFeature.getInstance().getBoolean(SEC_FLOATING_FEATURE_COMMON_DISABLE_NATIVE_AI);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean isHandwritingRecognitionAvailable(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.samsung.android.sdk.handwriting", 128);
            Log.i(TAG, "APK Version = " + packageInfo.versionName + " : " + packageInfo.packageName);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.i(TAG, "There is no HandwritingService!");
            return false;
        } catch (Exception unused2) {
            Log.i(TAG, "No authority to handwriting provider");
            return false;
        }
    }

    public final boolean isSamsungDevice() {
        if (mIsSamsungDevice == -1) {
            mIsSamsungDevice = 0;
            if (Intrinsics.areEqual("samsung", Build.MANUFACTURER)) {
                String MODEL = Build.MODEL;
                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                if (!StringsKt.m14145S(MODEL, "Nexus")) {
                    mIsSamsungDevice = 1;
                }
            }
        }
        return mIsSamsungDevice == 1;
    }
}
