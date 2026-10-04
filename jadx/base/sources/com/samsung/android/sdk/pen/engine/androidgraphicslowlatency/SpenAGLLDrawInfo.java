package com.samsung.android.sdk.pen.engine.androidgraphicslowlatency;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0003H\u0002J\u0018\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010\t\u001a\u00020\nH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/androidgraphicslowlatency/SpenAGLLDrawInfo;", "", "mClipRect", "Landroid/graphics/Rect;", "mScreenWidth", "", "mScreenHeight", "mIsFrontBufferRendering", "", "transform", "", "<init>", "(Landroid/graphics/Rect;IIZ[F)V", "getMClipRect", "()Landroid/graphics/Rect;", "setMClipRect", "(Landroid/graphics/Rect;)V", "getMScreenWidth", "()I", "setMScreenWidth", "(I)V", "getMScreenHeight", "setMScreenHeight", "getMIsFrontBufferRendering", "()Z", "setMIsFrontBufferRendering", "(Z)V", "mTransformMatrix", "getMTransformMatrix", "()[F", "setMTransformMatrix", "([F)V", "setClipRect", "", "clipRect", "setSize", "width", "height", "setMatrix", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenAGLLDrawInfo {

    @NotNull
    private Rect mClipRect;
    private boolean mIsFrontBufferRendering;
    private int mScreenHeight;
    private int mScreenWidth;

    @NotNull
    private float[] mTransformMatrix;

    public SpenAGLLDrawInfo(@NotNull Rect mClipRect, int i, int i2, boolean z, @NotNull float[] transform) {
        Intrinsics.checkNotNullParameter(mClipRect, "mClipRect");
        Intrinsics.checkNotNullParameter(transform, "transform");
        this.mClipRect = mClipRect;
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
        this.mIsFrontBufferRendering = z;
        this.mTransformMatrix = new float[16];
        setMatrix(transform);
    }

    private final void setClipRect(Rect clipRect) {
        this.mClipRect = clipRect;
    }

    private final void setMatrix(float[] transform) {
        int length = transform.length;
        float[] fArr = this.mTransformMatrix;
        if (length == fArr.length) {
            int length2 = fArr.length;
            for (int i = 0; i < length2; i++) {
                this.mTransformMatrix[i] = transform[i];
            }
        }
    }

    private final void setSize(int width, int height) {
        this.mScreenWidth = width;
        this.mScreenHeight = height;
    }

    @NotNull
    public final Rect getMClipRect() {
        return this.mClipRect;
    }

    public final boolean getMIsFrontBufferRendering() {
        return this.mIsFrontBufferRendering;
    }

    public final int getMScreenHeight() {
        return this.mScreenHeight;
    }

    public final int getMScreenWidth() {
        return this.mScreenWidth;
    }

    @NotNull
    public final float[] getMTransformMatrix() {
        return this.mTransformMatrix;
    }

    public final void setMClipRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.mClipRect = rect;
    }

    public final void setMIsFrontBufferRendering(boolean z) {
        this.mIsFrontBufferRendering = z;
    }

    public final void setMScreenHeight(int i) {
        this.mScreenHeight = i;
    }

    public final void setMScreenWidth(int i) {
        this.mScreenWidth = i;
    }

    public final void setMTransformMatrix(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.mTransformMatrix = fArr;
    }
}
