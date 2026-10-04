package com.samsung.android.sdk.scs.p142ai.visual;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorFactory;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageEditorConst;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ImageEditorParamUtils {
    private static final EnumMap<AiServiceExecutorFactory.ServiceType, Map<Integer, String>> FEATURE_MAP;
    private static final String TAG = "ImageEditorParamUtils";

    static {
        EnumMap<AiServiceExecutorFactory.ServiceType, Map<Integer, String>> enumMap = new EnumMap<>(AiServiceExecutorFactory.ServiceType.class);
        FEATURE_MAP = enumMap;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map.put(0, "FEATURE_PORTRAIT");
        map.put(1, "FEATURE_SKETCH_TO_IMAGE");
        map.put(2, "FEATURE_SKETCH_GUIDE_EDITING");
        map.put(6, "FEATURE_GEN_STICKER");
        map.put(7, "FEATURE_IMAGE_CONVERSION");
        map.put(8, "FEATURE_PET_PORTRAIT");
        map.put(9, "FEATURE_RESTYLING");
        map.put(12, "FEATURE_DESIGN_IMAGE");
        map.put(13, "FEATURE_DESIGN_STICKER");
        map2.put(4, "FEATURE_WALLPAPER");
        map2.put(0, "FEATURE_PORTRAIT_ON_DEVICE");
        map2.put(1, "FEATURE_SKETCH_TO_IMAGE_ON_DEVICE");
        map2.put(2, "FEATURE_SKETCH_GUIDE_EDITING_ON_DEVICE");
        map2.put(3, "FEATURE_GEN_EDIT_ON_DEVICE");
        map2.put(5, "FEATURE_PORTRAIT_RELIGHT_ON_DEVICE");
        map2.put(7, "FEATURE_IMAGE_CONVERSION_ON_DEVICE");
        map2.put(11, "FEATURE_AI_ERASER_ON_DEVICE");
        map2.put(10, "FEATURE_HARMONIZATION_ON_DEVICE");
        map2.put(8, "FEATURE_PET_PORTRAIT_ON_DEVICE");
        enumMap.put(AiServiceExecutorFactory.ServiceType.CLOUD_CORE, map);
        enumMap.put(AiServiceExecutorFactory.ServiceType.AI_CORE, map2);
    }

    private ImageEditorParamUtils() {
    }

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

    public static String getFeatureName(int i, @NonNull AiServiceExecutorFactory.ServiceType serviceType) {
        return getFeatureName(i, serviceType, null);
    }

    public static void toBundle(@NonNull Bundle bundle, @NonNull VisualAppInfo visualAppInfo) {
        bundle.putString("api-key", visualAppInfo.getApiKey());
        bundle.putString("package-signing-key", visualAppInfo.getSigningKey());
        bundle.putString("ssp-app-id", visualAppInfo.getAppId());
        bundle.putString("package-name", visualAppInfo.getPackageName());
        bundle.putString("ssp-access-token", visualAppInfo.getAccessToken());
        bundle.putString("ssp-user-id", visualAppInfo.getUserId());
        bundle.putString("ssp-server-url", visualAppInfo.getServerUrl());
        bundle.putString("ssp-account-type", visualAppInfo.getAccountType());
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

    public static String getFeatureName(int i, @NonNull AiServiceExecutorFactory.ServiceType serviceType, @Nullable Bundle bundle) {
        Map<Integer, String> map = FEATURE_MAP.get(serviceType);
        Objects.requireNonNull(map);
        String orDefault = map.getOrDefault(Integer.valueOf(i), null);
        if (orDefault != null) {
            return ("FEATURE_SKETCH_GUIDE_EDITING".equals(orDefault) && bundle != null && bundle.containsKey(ImageEditorConst.KEY_PARAM_ALPHA_RECT_LIST)) ? "FEATURE_SKETCH_GUIDE_EDITING_CROPPING_RECT" : orDefault;
        }
        throw new IllegalStateException(AbstractC0000a.m11h(i, "Unexpected value: "));
    }
}
