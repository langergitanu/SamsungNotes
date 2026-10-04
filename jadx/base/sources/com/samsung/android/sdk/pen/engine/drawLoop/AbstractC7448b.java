package com.samsung.android.sdk.pen.engine.drawLoop;

import android.graphics.HardwareRenderer;
import android.graphics.LinearGradient;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.view.SurfaceControl;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.engine.drawLoop.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC7448b {
    /* JADX INFO: renamed from: A */
    public static /* synthetic */ LinearGradient m5852A(float f, float f4, long[] jArr, float[] fArr) {
        return new LinearGradient(0.0f, f, 0.0f, f4, jArr, fArr, Shader.TileMode.CLAMP);
    }

    /* JADX INFO: renamed from: B */
    public static /* synthetic */ RenderNode m5853B() {
        return new RenderNode("ExpandableDrawable");
    }

    /* JADX INFO: renamed from: C */
    public static /* bridge */ /* synthetic */ Class m5854C() {
        return SurfaceControl.class;
    }

    /* JADX INFO: renamed from: D */
    public static /* synthetic */ void m5855D() {
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ HardwareRenderer m5860e() {
        return new HardwareRenderer();
    }

    /* JADX INFO: renamed from: f */
    public static /* synthetic */ LinearGradient m5861f(float f, float f4, long[] jArr, float[] fArr) {
        return new LinearGradient(f, 0.0f, f4, 0.0f, jArr, fArr, Shader.TileMode.CLAMP);
    }

    /* JADX INFO: renamed from: g */
    public static /* synthetic */ RenderNode m5862g() {
        return new RenderNode("ExpandableDrawableBlurEffect");
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ SurfaceControl.Transaction m5864i() {
        return new SurfaceControl.Transaction();
    }

    /* JADX INFO: renamed from: j */
    public static /* bridge */ /* synthetic */ SurfaceControl.Transaction m5865j(Object obj) {
        return (SurfaceControl.Transaction) obj;
    }

    /* JADX INFO: renamed from: m */
    public static /* bridge */ /* synthetic */ Class m5868m() {
        return SurfaceControl.Transaction.class;
    }

    /* JADX INFO: renamed from: n */
    public static /* synthetic */ void m5869n() {
    }
}
