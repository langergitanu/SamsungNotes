package com.airbnb.lottie.model.animatable;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.TextRangeUnits;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class AnimatableTextRangeSelector {

    @Nullable
    public final AnimatableIntegerValue end;

    @Nullable
    public final AnimatableIntegerValue offset;

    @Nullable
    public final AnimatableIntegerValue start;
    public final TextRangeUnits units;

    public AnimatableTextRangeSelector(@Nullable AnimatableIntegerValue animatableIntegerValue, @Nullable AnimatableIntegerValue animatableIntegerValue2, @Nullable AnimatableIntegerValue animatableIntegerValue3, TextRangeUnits textRangeUnits) {
        this.start = animatableIntegerValue;
        this.end = animatableIntegerValue2;
        this.offset = animatableIntegerValue3;
        this.units = textRangeUnits;
    }
}
