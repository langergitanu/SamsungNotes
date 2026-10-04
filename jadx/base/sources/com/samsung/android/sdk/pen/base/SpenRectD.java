package com.samsung.android.sdk.pen.base;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0002\u0010\u000eR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/base/SpenRectD;", "", "<init>", "()V", "left", "", "top", "right", "bottom", "(DDDD)V", "rectD", "(Lcom/samsung/android/sdk/pen/base/SpenRectD;)V", "rectF", "Landroid/graphics/RectF;", "(Landroid/graphics/RectF;)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRectD {

    @JvmField
    public double bottom;

    @JvmField
    public double left;

    @JvmField
    public double right;

    @JvmField
    public double top;

    public SpenRectD() {
    }

    public SpenRectD(double d, double d2, double d3, double d4) {
        this.left = d;
        this.top = d2;
        this.right = d3;
        this.bottom = d4;
    }

    public SpenRectD(@NotNull SpenRectD rectD) {
        Intrinsics.checkNotNullParameter(rectD, "rectD");
        this.left = rectD.left;
        this.top = rectD.top;
        this.right = rectD.right;
        this.bottom = rectD.bottom;
    }

    public SpenRectD(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        this.left = rectF.left;
        this.top = rectF.top;
        this.right = rectF.right;
        this.bottom = rectF.bottom;
    }
}
