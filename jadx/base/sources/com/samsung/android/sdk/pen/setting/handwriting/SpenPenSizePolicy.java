package com.samsung.android.sdk.pen.setting.handwriting;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0007H\u0007J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0007H\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0007H\u0007J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0016H\u0007J(\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0016H\u0007J0\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenSizePolicy;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "UX_PEN_SIZE_STEP", "", "mPenSizeBoundary", "", "mInkSizeBoundary", "mPenSizeLevel", "mInkSizeLevel", "mPenSizeRatio", "", "mInkSizeRatio", "getLevelIndex", "name", "sizeLevel", "getRepresentativeLevel", "index", "getRatio", "", "setPenSizeDp", "", "info", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "minValue", "maxValue", "getSizeDp", "levelIndex", "getSizePx", "densityDpi", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenSizePolicy {

    @NotNull
    private static final String TAG = "SpenPenSizePolicy";
    public static final int UX_PEN_SIZE_STEP = 5;

    @NotNull
    public static final SpenPenSizePolicy INSTANCE = new SpenPenSizePolicy();

    @NotNull
    private static final int[] mPenSizeBoundary = {13, 38, 63, 88};

    @NotNull
    private static final int[] mInkSizeBoundary = {5, 17, 39, 77};

    @NotNull
    private static final int[] mPenSizeLevel = {1, 25, 50, 75, 100};

    @NotNull
    private static final int[] mInkSizeLevel = {1, 9, 24, 53, 100};

    @NotNull
    private static final float[] mPenSizeRatio = {0.0f, 0.25f, 0.5f, 0.75f, 1.0f};

    @NotNull
    private static final float[] mInkSizeRatio = {0.0f, 0.09f, 0.24f, 0.53f, 1.0f};

    private SpenPenSizePolicy() {
    }

    @JvmStatic
    public static final int getLevelIndex(@NotNull String name, int sizeLevel) {
        Intrinsics.checkNotNullParameter(name, "name");
        int[] iArr = mPenSizeBoundary;
        int length = iArr.length;
        int i = 0;
        if (StringsKt.m14162r(name, "InkPen")) {
            int length2 = mInkSizeBoundary.length;
            while (i < length2) {
                if (sizeLevel < mInkSizeBoundary[i]) {
                    return i;
                }
                i++;
            }
        } else {
            int length3 = iArr.length;
            while (i < length3) {
                if (sizeLevel < mPenSizeBoundary[i]) {
                    return i;
                }
                i++;
            }
        }
        return length;
    }

    @JvmStatic
    public static final float getRatio(@NotNull String name, int index) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (index < 0 || index >= mPenSizeLevel.length) {
            return -1.0f;
        }
        return !StringsKt.m14162r(name, "InkPen") ? mPenSizeRatio[index] : mInkSizeRatio[index];
    }

    @JvmStatic
    public static final int getRepresentativeLevel(@NotNull String name, int index) {
        Intrinsics.checkNotNullParameter(name, "name");
        return !StringsKt.m14162r(name, "InkPen") ? mPenSizeLevel[index] : mInkSizeLevel[index];
    }

    @JvmStatic
    public static final float getSizeDp(@NotNull String name, int levelIndex, float minValue, float maxValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (getRatio(name, levelIndex) * (maxValue - minValue)) + minValue;
    }

    @JvmStatic
    public static final float getSizePx(@NotNull String name, int levelIndex, float minValue, float maxValue, int densityDpi) {
        Intrinsics.checkNotNullParameter(name, "name");
        float sizeDp = getSizeDp(name, levelIndex, minValue, maxValue);
        float f = (densityDpi * sizeDp) / 160.0f;
        StringBuilder sbM780v = AbstractC0541b.m780v("## name=", levelIndex, name, " index=", " min=");
        AbstractC11014a.m12337v(sbM780v, minValue, " max=", maxValue, " dp=");
        sbM780v.append(sizeDp);
        sbM780v.append(" densityDpi=");
        sbM780v.append(densityDpi);
        sbM780v.append(" changeToPx=");
        AbstractC2821a.m2206A(sbM780v, TAG, f);
        return f;
    }

    @JvmStatic
    public static final void setPenSizeDp(@NotNull SpenSettingPenInfo info, float minValue, float maxValue) {
        Intrinsics.checkNotNullParameter(info, "info");
        int levelIndex = getLevelIndex(info.name, info.sizeLevel);
        if (levelIndex < 0 || levelIndex >= mPenSizeLevel.length || minValue == 0.0f || maxValue == 0.0f) {
            return;
        }
        info.sizeLevel = getRepresentativeLevel(info.name, levelIndex);
        info.size = getSizeDp(info.name, levelIndex, minValue, maxValue);
    }
}
