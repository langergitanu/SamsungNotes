package com.samsung.android.sdk.pen.setting.pencommon;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0003R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenHSVColor;", "", "hsvColor", "", "<init>", "([F)V", "mHsvColor", "getMHsvColor", "()[F", "setMHsvColor", "getHSV", "", "hsv", "setColor", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHSVColor {

    @NotNull
    private float[] mHsvColor = {0.0f, 0.0f, 0.0f};

    public SpenHSVColor(@Nullable float[] fArr) {
        setColor(fArr);
    }

    public final boolean getHSV(@Nullable float[] hsv) {
        if (hsv == null || hsv.length < 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            hsv[i] = this.mHsvColor[i];
        }
        return true;
    }

    @NotNull
    public final float[] getMHsvColor() {
        return this.mHsvColor;
    }

    public final boolean setColor(@Nullable float[] hsv) {
        if (hsv == null || hsv.length < 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            this.mHsvColor[i] = hsv[i];
        }
        return true;
    }

    public final void setMHsvColor(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.mHsvColor = fArr;
    }
}
