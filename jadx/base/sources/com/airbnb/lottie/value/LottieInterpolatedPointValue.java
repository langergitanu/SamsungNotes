package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class LottieInterpolatedPointValue extends LottieInterpolatedValue<PointF> {
    private final PointF point;

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.point = new PointF();
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    public PointF interpolateValue(PointF pointF, PointF pointF2, float f) {
        this.point.set(MiscUtils.lerp(pointF.x, pointF2.x, f), MiscUtils.lerp(pointF.y, pointF2.y, f));
        return this.point;
    }

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.point = new PointF();
    }
}
