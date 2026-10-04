package com.airbnb.lottie;

import android.annotation.SuppressLint;
import android.os.Build;
import com.airbnb.lottie.utils.Logger;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class LottieFeatureFlags {
    private final HashSet<LottieFeatureFlag> enabledFlags = new HashSet<>();

    @SuppressLint({"DefaultLocale"})
    public boolean enableFlag(LottieFeatureFlag lottieFeatureFlag, boolean z) {
        if (!z) {
            return this.enabledFlags.remove(lottieFeatureFlag);
        }
        if (Build.VERSION.SDK_INT >= lottieFeatureFlag.minRequiredSdkVersion) {
            return this.enabledFlags.add(lottieFeatureFlag);
        }
        Logger.warning(String.format("%s is not supported pre SDK %d", lottieFeatureFlag.name(), Integer.valueOf(lottieFeatureFlag.minRequiredSdkVersion)));
        return false;
    }

    public boolean isFlagEnabled(LottieFeatureFlag lottieFeatureFlag) {
        return this.enabledFlags.contains(lottieFeatureFlag);
    }
}
