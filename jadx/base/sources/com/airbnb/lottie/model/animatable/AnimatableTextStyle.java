package com.airbnb.lottie.model.animatable;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class AnimatableTextStyle {

    @Nullable
    public final AnimatableColorValue color;

    @Nullable
    public final AnimatableIntegerValue opacity;

    @Nullable
    public final AnimatableColorValue stroke;

    @Nullable
    public final AnimatableFloatValue strokeWidth;

    @Nullable
    public final AnimatableFloatValue tracking;

    public AnimatableTextStyle(@Nullable AnimatableColorValue animatableColorValue, @Nullable AnimatableColorValue animatableColorValue2, @Nullable AnimatableFloatValue animatableFloatValue, @Nullable AnimatableFloatValue animatableFloatValue2, @Nullable AnimatableIntegerValue animatableIntegerValue) {
        this.color = animatableColorValue;
        this.stroke = animatableColorValue2;
        this.strokeWidth = animatableFloatValue;
        this.tracking = animatableFloatValue2;
        this.opacity = animatableIntegerValue;
    }
}
