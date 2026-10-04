package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class LottieInterpolatedFloatValue extends LottieInterpolatedValue<Float> {
    public LottieInterpolatedFloatValue(Float f, Float f4) {
        super(f, f4);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }

    public LottieInterpolatedFloatValue(Float f, Float f4, Interpolator interpolator) {
        super(f, f4, interpolator);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    public Float interpolateValue(Float f, Float f4, float f5) {
        return Float.valueOf(MiscUtils.lerp(f.floatValue(), f4.floatValue(), f5));
    }
}
