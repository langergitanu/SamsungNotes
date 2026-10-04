package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class HeroCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {0, 1};

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredWidth = view.getMeasuredWidth() * 2;
        if (carousel.isHorizontal()) {
            f = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredWidth = view.getMeasuredHeight() * 2;
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f;
        float fMax = Math.max(getSmallItemSizeMax() + f, smallItemSizeMin);
        float f4 = containerHeight;
        float fMin = Math.min(measuredWidth + f, f4);
        float fClamp = MathUtils.clamp((measuredWidth / 3.0f) + f, smallItemSizeMin + f, fMax + f);
        float f5 = (fMin + fClamp) / 2.0f;
        int i = 0;
        int[] iArr = f4 < 2.0f * smallItemSizeMin ? new int[]{0} : SMALL_COUNTS;
        int iMax = (int) Math.max(1.0d, Math.floor(AbstractC0000a.m6c(fMax, CarouselStrategyHelper.maxValue(r0), f4, fMin)));
        int iCeil = (((int) Math.ceil(f4 / fMin)) - iMax) + 1;
        int[] iArr2 = new int[iCeil];
        for (int i2 = 0; i2 < iCeil; i2++) {
            iArr2[i2] = iMax + i2;
        }
        int i4 = carousel.getCarouselAlignment() == 1 ? 1 : 0;
        Arrangement arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f4, fClamp, smallItemSizeMin, fMax, i4 != 0 ? CarouselStrategy.doubleCounts(iArr) : iArr, f5, i4 != 0 ? CarouselStrategy.doubleCounts(MEDIUM_COUNTS) : MEDIUM_COUNTS, fMin, iArr2);
        this.keylineCount = arrangementFindLowestCostArrangement.getItemCount();
        if (arrangementFindLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f4, fClamp, smallItemSizeMin, fMax, iArr, f5, MEDIUM_COUNTS, fMin, iArr2);
        } else {
            i = i4;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f, f4, arrangementFindLowestCostArrangement, i);
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i) {
        if (carousel.getCarouselAlignment() == 1) {
            return (i < this.keylineCount && carousel.getItemCount() >= this.keylineCount) || (i >= this.keylineCount && carousel.getItemCount() < this.keylineCount);
        }
        return false;
    }
}
