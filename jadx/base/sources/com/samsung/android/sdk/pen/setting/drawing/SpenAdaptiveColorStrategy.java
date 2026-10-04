package com.samsung.android.sdk.pen.setting.drawing;

import android.graphics.Color;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenAdaptiveColorStrategy;", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenUIColorStrategy;", "mSizeSeekBar", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;", "mAlphaSeekBar", "mDensitySeekBar", "<init>", "(Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;)V", "mColor", "", "updateAlpha", "", "alpha", "setPenInfo", "color", "sizeLevel", "particleDensity", "alphaToProgress", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenAdaptiveColorStrategy implements SpenUIColorStrategy {

    @NotNull
    private static final String TAG = "SpenAdaptiveColorStrategy";

    @Nullable
    private final SpenSlider mAlphaSeekBar;
    private int mColor;

    @Nullable
    private final SpenSlider mDensitySeekBar;

    @Nullable
    private final SpenSlider mSizeSeekBar;

    public SpenAdaptiveColorStrategy(@Nullable SpenSlider spenSlider, @Nullable SpenSlider spenSlider2, @Nullable SpenSlider spenSlider3) {
        this.mSizeSeekBar = spenSlider;
        this.mAlphaSeekBar = spenSlider2;
        this.mDensitySeekBar = spenSlider3;
    }

    private final int alphaToProgress(int alpha) {
        return MathKt.roundToInt((alpha / 255.0f) * 100.0f);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenUIColorStrategy
    public void setPenInfo(int color, int sizeLevel, int particleDensity) {
        this.mColor = color;
        SpenSlider spenSlider = this.mSizeSeekBar;
        if (spenSlider != null && spenSlider.getVisibility() == 0) {
            this.mSizeSeekBar.setValue(sizeLevel, false);
            this.mSizeSeekBar.setColor((this.mColor & 16777215) | (-16777216));
        }
        SpenSlider spenSlider2 = this.mAlphaSeekBar;
        if (spenSlider2 != null && spenSlider2.getVisibility() == 0) {
            this.mAlphaSeekBar.setValue(alphaToProgress(Color.alpha(this.mColor)), false);
            this.mAlphaSeekBar.setProgressBackgroundColors(Arrays.copyOf(new int[]{color | (-16777216), color & 16777215}, 2));
            this.mAlphaSeekBar.setColor(this.mColor);
        }
        SpenSlider spenSlider3 = this.mDensitySeekBar;
        if (spenSlider3 == null || spenSlider3.getVisibility() != 0) {
            return;
        }
        this.mDensitySeekBar.setValue(particleDensity, false);
        this.mDensitySeekBar.setColor(this.mColor);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenUIColorStrategy
    public void updateAlpha(int alpha) {
        this.mColor = ((alpha << 24) & (-16777216)) | (this.mColor & 16777215);
        int iAlphaToProgress = alphaToProgress(alpha);
        SpenSlider spenSlider = this.mAlphaSeekBar;
        if (spenSlider == null || spenSlider.getVisibility() != 0) {
            return;
        }
        this.mAlphaSeekBar.setValue(iAlphaToProgress, false);
        this.mAlphaSeekBar.setColor(this.mColor);
    }
}
