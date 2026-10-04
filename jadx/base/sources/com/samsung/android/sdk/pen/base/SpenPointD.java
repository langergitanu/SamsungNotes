package com.samsung.android.sdk.pen.base;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/base/SpenPointD;", "", "<init>", "()V", "x", "", "y", "(DD)V", "p", "(Lcom/samsung/android/sdk/pen/base/SpenPointD;)V", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", "pointF", "Landroid/graphics/PointF;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPointD {

    @JvmField
    public double x;

    @JvmField
    public double y;

    public SpenPointD() {
    }

    public final void set(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "pointF");
        this.x = pointF.x;
        this.y = pointF.y;
    }

    public SpenPointD(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public SpenPointD(@NotNull SpenPointD p) {
        Intrinsics.checkNotNullParameter(p, "p");
        this.x = p.x;
        this.y = p.y;
    }
}
