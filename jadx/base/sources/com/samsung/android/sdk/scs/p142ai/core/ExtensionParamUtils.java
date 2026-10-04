package com.samsung.android.sdk.scs.p142ai.core;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.core.p139ai.sdkcommon.ExtensionConst;
import com.samsung.android.sdk.scs.base.utils.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class ExtensionParamUtils {
    private static final String TAG = "ExtensionParamUtils";

    private static Bitmap asSharedCompat(@NonNull Bitmap bitmap) {
        if (!bitmap.isMutable()) {
            return bitmap;
        }
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return bitmap.copy(config, false);
    }

    public static String getGenericInferenceMethod(@NonNull Bundle bundle) {
        return bundle.getString(ExtensionConst.KEY_PARAM_GENERIC_INFERENCE_METHOD);
    }

    public static void setBundleFeature(@NonNull Bundle bundle, @NonNull String str) {
        bundle.putString(ExtensionConst.KEY_PARAM_FEATURE, str);
    }

    public static void setBundleInputArg(@NonNull Bundle bundle, @NonNull String str) {
        bundle.putString(ExtensionConst.KEY_PARAM_INPUT_ARG, str);
    }

    public static void setBundleTaskId(@NonNull Bundle bundle, @NonNull String str) {
        bundle.putString("taskId", str);
    }

    public static void transformBitmapsInBundle(@NonNull Bundle bundle) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bitmap) {
                Bitmap bitmap = (Bitmap) obj;
                try {
                    bundle.putParcelable(str, Build.VERSION.SDK_INT >= 31 ? bitmap.asShared() : asSharedCompat(bitmap));
                } catch (Exception e) {
                    Log.m6488e(TAG, "Failed to create shared Bitmap", e);
                }
            }
        }
    }
}
