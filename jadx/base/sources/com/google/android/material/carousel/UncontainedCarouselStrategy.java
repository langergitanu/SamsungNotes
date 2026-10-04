package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.KeylineState;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class UncontainedCarouselStrategy extends CarouselStrategy {
    private static final float MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD = 0.85f;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UncontainedCarouselStrategy() {
    }

    private float calculateMediumChildSize(float f, float f4, float f5) {
        float fMax = Math.max(1.5f * f5, f);
        float f6 = MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD * f4;
        if (fMax > f6) {
            fMax = Math.max(f6, f5 * 1.2f);
        }
        return Math.min(f4, fMax);
    }

    private KeylineState createCenterAlignedKeylineState(float f, float f4, float f5, int i, float f6, float f7, float f8) {
        float fMin = Math.min(f7, f5);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMin, f5, f4);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(f6, f5, f4);
        float f9 = f6 / 2.0f;
        float f10 = (f8 + 0.0f) - f9;
        float f11 = f10 + f9;
        float f12 = fMin / 2.0f;
        float f13 = (i * f5) + f11;
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(f5, f).addAnchorKeyline((f10 - f9) - f12, childMaskPercentage, fMin).addKeyline(f10, childMaskPercentage2, f6, false).addKeylineRange((f5 / 2.0f) + f11, 0.0f, f5, i, true);
        builderAddKeylineRange.addKeyline(f9 + f13, childMaskPercentage2, f6, false);
        builderAddKeylineRange.addAnchorKeyline(f13 + f6 + f12, childMaskPercentage, fMin);
        return builderAddKeylineRange.build();
    }

    private KeylineState createLeftAlignedKeylineState(Context context, float f, float f4, float f5, int i, float f6, int i2, float f7) {
        float fMin = Math.min(f7, f5);
        float fMax = Math.max(fMin, 0.5f * f6);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMax, f5, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(fMin, f5, f);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(f6, f5, f);
        float f8 = (i * f5) + 0.0f;
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(f5, f4).addAnchorKeyline(0.0f - (fMax / 2.0f), childMaskPercentage, fMax).addKeylineRange(f5 / 2.0f, 0.0f, f5, i, true);
        if (i2 > 0) {
            float f9 = (f6 / 2.0f) + f8;
            f8 += f6;
            builderAddKeylineRange.addKeyline(f9, childMaskPercentage3, f6, false);
        }
        builderAddKeylineRange.addAnchorKeyline((CarouselStrategyHelper.getExtraSmallSize(context) / 2.0f) + f8, childMaskPercentage2, fMin);
        return builderAddKeylineRange.build();
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean isContained() {
        return false;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        float containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f4 = measuredHeight;
        float f5 = f;
        float f6 = f4 + f5;
        float extraSmallSize = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f5;
        float extraSmallSize2 = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f5;
        int iMax = Math.max(1, (int) Math.floor(containerWidth / f6));
        float f7 = containerWidth - (iMax * f6);
        if (carousel.getCarouselAlignment() == 1) {
            float f8 = f7 / 2.0f;
            return createCenterAlignedKeylineState(containerWidth, f5, f6, iMax, Math.max(Math.min(3.0f * f8, f6), getSmallItemSizeMin() + f5), extraSmallSize2, f8);
        }
        int i = 1;
        if (f7 <= 0.0f) {
            i = 0;
        }
        return createLeftAlignedKeylineState(view.getContext(), f5, containerWidth, f6, iMax, calculateMediumChildSize(extraSmallSize, f6, f7), i, extraSmallSize2);
    }
}
