package com.samsung.android.mcf.continuity.common;

import androidx.annotation.VisibleForTesting;
import com.samsung.android.feature.SemFloatingFeature;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class FeatureUtil {

    @VisibleForTesting
    public static final String SEC_FLOATING_FEATURE_MCF_SUPPORT_CONTINUITY = "SEC_FLOATING_FEATURE_MCF_SUPPORT_CONTINUITY";
    private static final int sContinuityFeature = getContinuityFeature();

    private static int getContinuityFeature() {
        return Math.max(SemFloatingFeature.getInstance().getInt(SEC_FLOATING_FEATURE_MCF_SUPPORT_CONTINUITY), 0);
    }

    public static boolean isContinuityFeatureEnabled() {
        return sContinuityFeature > 0;
    }
}
