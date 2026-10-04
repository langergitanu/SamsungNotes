package com.airbnb.lottie.model.content;

import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.graphics.BlendModeCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public enum LBlendMode {
    NORMAL,
    MULTIPLY,
    SCREEN,
    OVERLAY,
    DARKEN,
    LIGHTEN,
    COLOR_DODGE,
    COLOR_BURN,
    HARD_LIGHT,
    SOFT_LIGHT,
    DIFFERENCE,
    EXCLUSION,
    HUE,
    SATURATION,
    COLOR,
    LUMINOSITY,
    ADD,
    HARD_MIX;

    @Nullable
    public BlendModeCompat toNativeBlendMode() {
        int iOrdinal = ordinal();
        if (iOrdinal == 1) {
            return Build.VERSION.SDK_INT >= 29 ? BlendModeCompat.MULTIPLY : BlendModeCompat.MODULATE;
        }
        if (iOrdinal == 2) {
            return BlendModeCompat.SCREEN;
        }
        if (iOrdinal == 3) {
            return BlendModeCompat.OVERLAY;
        }
        if (iOrdinal == 4) {
            return BlendModeCompat.DARKEN;
        }
        if (iOrdinal == 5) {
            return BlendModeCompat.LIGHTEN;
        }
        if (iOrdinal != 16) {
            return null;
        }
        return BlendModeCompat.PLUS;
    }
}
