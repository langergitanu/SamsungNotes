package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    private final GradientColor gradientColor;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        int iMax = 0;
        for (int i = 0; i < list.size(); i++) {
            GradientColor gradientColor = list.get(i).startValue;
            if (gradientColor != null) {
                iMax = Math.max(iMax, gradientColor.getSize());
            }
        }
        this.gradientColor = new GradientColor(new float[iMax], new int[iMax]);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f) {
        return getValue((Keyframe<GradientColor>) keyframe, f);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public GradientColor getValue(Keyframe<GradientColor> keyframe, float f) {
        this.gradientColor.lerp(keyframe.startValue, keyframe.endValue, f);
        return this.gradientColor;
    }
}
