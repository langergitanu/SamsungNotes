package com.samsung.android.sdk.composer.view.zoomScroller;

import android.graphics.PointF;
import android.graphics.RectF;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010'\u001a\u00020(H\u0016J\u0012\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020(H\u0016J\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0016J\u0012\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u00010\u001fH\u0016J \u0010\u0012\u001a\u00020(2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000eH\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000207H\u0016J\u0014\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010;\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010<\u001a\u0004\u0018\u00010\u001f2\b\u00103\u001a\u0004\u0018\u00010\u001fH\u0016J\u0014\u0010=\u001a\u0004\u0018\u00010\u001f2\b\u00103\u001a\u0004\u0018\u00010\u001fH\u0016R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R(\u0010#\u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010&¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScrollerNoOp;", "Lcom/samsung/android/sdk/composer/view/zoomScroller/ISpenNoteZoomScroller;", "<init>", "()V", "position", "Landroid/graphics/PointF;", "pan", "getPan", "()Landroid/graphics/PointF;", "setPan", "(Landroid/graphics/PointF;)V", "delta", "getDelta", WiggleAnimationConfig.KEY_SCALE, "", "zoomScale", "getZoomScale", "()F", "setZoomScale", "(F)V", "contentScale", "getContentScale", "minZoomScale", "getMinZoomScale", "maxZoomScale", "getMaxZoomScale", "contentWidth", "getContentWidth", "contentHeight", "getContentHeight", "contentRectInView", "Landroid/graphics/RectF;", "getContentRectInView", "()Landroid/graphics/RectF;", "value", "contentMargin", "getContentMargin", "setContentMargin", "(Landroid/graphics/RectF;)V", "close", "", "setNoteZoomScrollerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScrollerListener;", "setZoomListener", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenZoomListener;", "smoothScrollToFitPage", "scrollToPage", "pageIndex", "", "scrollToContentRect", "rect", "pivotX", "pivotY", "startContinuousChange", "", "endContinuousChange", "convertViewPointIntoContentPoint", "point", "convertContentPointIntoViewPoint", "convertViewRectIntoContentRect", "convertContentRectIntoViewRect", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNoteZoomScrollerNoOp implements ISpenNoteZoomScroller {
    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void close() {
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public PointF convertContentPointIntoViewPoint(@Nullable PointF point) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public RectF convertContentRectIntoViewRect(@Nullable RectF rect) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public PointF convertViewPointIntoContentPoint(@Nullable PointF point) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public RectF convertViewRectIntoContentRect(@Nullable RectF rect) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public boolean endContinuousChange() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public float getContentHeight() {
        return 0.0f;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public RectF getContentMargin() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public RectF getContentRectInView() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public float getContentScale() {
        return 0.0f;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public float getContentWidth() {
        return 0.0f;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public PointF getDelta() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public float getMaxZoomScale() {
        return 0.0f;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public float getMinZoomScale() {
        return 0.0f;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public PointF getPan() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public float getZoomScale() {
        return 0.0f;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void scrollToContentRect(@Nullable RectF rect) {
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void scrollToPage(int pageIndex) {
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void setContentMargin(@Nullable RectF rectF) {
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void setNoteZoomScrollerListener(@Nullable SpenNoteZoomScrollerListener listener) {
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void setPan(@Nullable PointF pointF) {
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void setZoomListener(@Nullable SpenZoomListener listener) {
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void setZoomScale(float f) {
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void smoothScrollToFitPage() {
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public boolean startContinuousChange() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void setZoomScale(float scale, float pivotX, float pivotY) {
    }
}
