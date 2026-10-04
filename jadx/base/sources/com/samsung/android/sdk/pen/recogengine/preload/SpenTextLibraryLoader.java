package com.samsung.android.sdk.pen.recogengine.preload;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0006\u0010\u000f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/SpenTextLibraryLoader;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LIB_PREFIX", "LIB_EXT_SO", "HWR_PROVIDER_PACKAGE_NAME", "HWR_TEXT_LIB_NAME", "HWR_TEXT_LIB_NAME_LEGACY", "loadRemoteLibrary", "", "context", "Landroid/content/Context;", "getTextNativeLibraryName", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTextLibraryLoader {

    @NotNull
    private static final String HWR_PROVIDER_PACKAGE_NAME = "com.samsung.android.sdk.handwriting";

    @NotNull
    private static final String HWR_TEXT_LIB_NAME = "SDKRecognitionText.spensdk.samsung";

    @NotNull
    private static final String HWR_TEXT_LIB_NAME_LEGACY = "SDKRecognitionText";

    @NotNull
    public static final SpenTextLibraryLoader INSTANCE = new SpenTextLibraryLoader();

    @NotNull
    private static final String LIB_EXT_SO = ".so";

    @NotNull
    private static final String LIB_PREFIX = "lib";

    @NotNull
    private static final String TAG = "SpenTextLibraryLoader";

    private SpenTextLibraryLoader() {
    }

    @NotNull
    public final String getTextNativeLibraryName() {
        int i = Build.VERSION.SDK_INT;
        AbstractC0541b.m755A(i, "getTextNativeLibraryName : Android SDK Level is ", TAG);
        return i >= 28 ? HWR_TEXT_LIB_NAME : HWR_TEXT_LIB_NAME_LEGACY;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public final boolean loadRemoteLibrary(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.samsung.android.sdk.handwriting", 0);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            Log.d(TAG, "loadRemoteLibrary : " + applicationInfo.nativeLibraryDir);
            String str = LIB_PREFIX + getTextNativeLibraryName() + LIB_EXT_SO;
            String str2 = applicationInfo.nativeLibraryDir + File.separator + str;
            Log.d(TAG, "loadRemoteLibrary : " + str2);
            if (new File(str2).exists()) {
                System.load(str2);
                return true;
            }
            Log.i(TAG, "loadRemoteLibrary : " + str + " does not exist");
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            AbstractC2322a.m1636z("loadRemoteLibrary : Cannot find remote lib : ", e.getLocalizedMessage(), TAG);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            AbstractC2322a.m1636z("loadRemoteLibrary : Cannot load remote lib : ", e2.getLocalizedMessage(), TAG);
            return false;
        }
    }
}
