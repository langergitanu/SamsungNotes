package com.samsung.android.support.senl.docscan.common.util;

import android.os.Build;
import camera.samsung.smartscan.SmartScanRectify;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/common/util/FeatureUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "supportSmartScanLib", "", "isIncompatibleModel", "hasDetectLib", "hasRectifyLib", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FeatureUtils {

    @NotNull
    public static final FeatureUtils INSTANCE = new FeatureUtils();

    @NotNull
    private static final String TAG = "FeatureUtils";

    private FeatureUtils() {
    }

    private final boolean hasDetectLib() {
        boolean zM14162r = StringsKt.m14162r(FloatingFeature.INSTANCE.getInstance().getString("SEC_FLOATING_FEATURE_CAMERA_CONFIG_VENDOR_LIB_INFO"), "smart_scan.samsung.v2");
        Logger.m7148i(TAG, "hasDetectLib# hasLib : " + zM14162r);
        return zM14162r;
    }

    private final boolean hasRectifyLib() {
        boolean z;
        try {
            int i = SmartScanRectify.IMAGE_FORMAT_BGR;
            z = true;
        } catch (ClassNotFoundException unused) {
            Logger.m7146e(TAG, "hasRectifyLib# ClassNotFoundException");
            z = false;
        }
        Logger.m7148i(TAG, "hasRectifyLib# hasLib : " + z);
        return z;
    }

    private final boolean isIncompatibleModel() {
        if (Build.VERSION.SDK_INT <= 30) {
            return StringsKt.m14145S(DeviceUtils.getSubModelName(), "T73") || StringsKt.m14145S(DeviceUtils.getSubModelName(), "T97");
        }
        return false;
    }

    @JvmStatic
    public static final boolean supportSmartScanLib() {
        int oneUIVersion = SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion();
        FeatureUtils featureUtils = INSTANCE;
        if (featureUtils.isIncompatibleModel()) {
            Logger.m7145d(TAG, "supportSmartScanLib# isIncompatibleModel");
            return false;
        }
        if (oneUIVersion < 40100) {
            Logger.m7145d(TAG, "supportSmartScanLib# oneUIVersion : " + oneUIVersion);
            if (!ModelFeature.getFeature().getIsSupportDocumentScan()) {
                Logger.m7146e(TAG, "supportSmartScanLib# unsupported device");
                return false;
            }
        }
        return featureUtils.hasDetectLib() && featureUtils.hasRectifyLib();
    }
}
