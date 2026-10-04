package com.airbnb.lottie.model.animatable;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class AnimatableTextProperties {

    @Nullable
    public final AnimatableTextRangeSelector rangeSelector;

    @Nullable
    public final AnimatableTextStyle textStyle;

    public AnimatableTextProperties(@Nullable AnimatableTextStyle animatableTextStyle, @Nullable AnimatableTextRangeSelector animatableTextRangeSelector) {
        this.textStyle = animatableTextStyle;
        this.rangeSelector = animatableTextRangeSelector;
    }
}
