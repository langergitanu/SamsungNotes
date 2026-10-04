package com.airbnb.lottie.configurations.reducemotion;

import android.content.Context;
import androidx.annotation.Nullable;
import com.airbnb.lottie.utils.Utils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class SystemReducedMotionOption implements ReducedMotionOption {
    @Override // com.airbnb.lottie.configurations.reducemotion.ReducedMotionOption
    public ReducedMotionMode getCurrentReducedMotionMode(@Nullable Context context) {
        return (context == null || Utils.getAnimationScale(context) != 0.0f) ? ReducedMotionMode.STANDARD_MOTION : ReducedMotionMode.REDUCED_MOTION;
    }
}
