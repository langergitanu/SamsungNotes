package com.samsung.android.support.senl.addons.brush.model.canvas;

import android.graphics.Bitmap;
import android.graphics.PointF;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushPreviewBitmap;", "", "bitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "currentZoom", "", "pointF", "Landroid/graphics/PointF;", "<init>", "(Landroid/graphics/Bitmap;IIFLandroid/graphics/PointF;)V", "mForegroundImage", "mDocWidth", "mDocHeight", "mCurrentZoomRatio", "mPan", "getForegroundImage", "getDocWidth", "getDocHeight", "getZoomRatio", "getPan", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushPreviewBitmap {
    private float mCurrentZoomRatio;
    private int mDocHeight;
    private int mDocWidth;

    @Nullable
    private Bitmap mForegroundImage;

    @Nullable
    private PointF mPan;

    public BrushPreviewBitmap(@Nullable Bitmap bitmap, int i, int i2, float f, @Nullable PointF pointF) {
        this.mForegroundImage = bitmap;
        this.mDocWidth = i;
        this.mDocHeight = i2;
        this.mCurrentZoomRatio = f <= 0.0f ? 1.0f : f;
        this.mPan = pointF;
    }

    /* JADX INFO: renamed from: getDocHeight, reason: from getter */
    public int getMDocHeight() {
        return this.mDocHeight;
    }

    /* JADX INFO: renamed from: getDocWidth, reason: from getter */
    public int getMDocWidth() {
        return this.mDocWidth;
    }

    @Nullable
    /* JADX INFO: renamed from: getForegroundImage, reason: from getter */
    public Bitmap getMForegroundImage() {
        return this.mForegroundImage;
    }

    @Nullable
    /* JADX INFO: renamed from: getPan, reason: from getter */
    public PointF getMPan() {
        return this.mPan;
    }

    /* JADX INFO: renamed from: getZoomRatio, reason: from getter */
    public float getMCurrentZoomRatio() {
        return this.mCurrentZoomRatio;
    }
}
