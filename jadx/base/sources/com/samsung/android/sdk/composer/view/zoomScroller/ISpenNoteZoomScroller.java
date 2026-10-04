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
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\"\u001a\u00020#H&J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H&J\u0012\u0010'\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010(H&J\b\u0010)\u001a\u00020#H&J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,H&J\u0012\u0010-\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010\u001bH&J \u0010\u000e\u001a\u00020#2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000bH&J\b\u00102\u001a\u000203H&J\b\u00104\u001a\u000203H&J\u0014\u00105\u001a\u0004\u0018\u00010\u00032\b\u00106\u001a\u0004\u0018\u00010\u0003H&J\u0014\u00107\u001a\u0004\u0018\u00010\u00032\b\u00106\u001a\u0004\u0018\u00010\u0003H&J\u0014\u00108\u001a\u0004\u0018\u00010\u001b2\b\u0010.\u001a\u0004\u0018\u00010\u001bH&J\u0014\u00109\u001a\u0004\u0018\u00010\u001b2\b\u0010.\u001a\u0004\u0018\u00010\u001bH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0018\u0010\n\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0012\u0010\u0012\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0012\u0010\u0014\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0012\u0010\u0018\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001bX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001d\"\u0004\b \u0010!¨\u0006:"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/zoomScroller/ISpenNoteZoomScroller;", "", "pan", "Landroid/graphics/PointF;", "getPan", "()Landroid/graphics/PointF;", "setPan", "(Landroid/graphics/PointF;)V", "delta", "getDelta", "zoomScale", "", "getZoomScale", "()F", "setZoomScale", "(F)V", "contentScale", "getContentScale", "minZoomScale", "getMinZoomScale", "maxZoomScale", "getMaxZoomScale", "contentWidth", "getContentWidth", "contentHeight", "getContentHeight", "contentRectInView", "Landroid/graphics/RectF;", "getContentRectInView", "()Landroid/graphics/RectF;", "contentMargin", "getContentMargin", "setContentMargin", "(Landroid/graphics/RectF;)V", "close", "", "setNoteZoomScrollerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScrollerListener;", "setZoomListener", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenZoomListener;", "smoothScrollToFitPage", "scrollToPage", "pageIndex", "", "scrollToContentRect", "rect", WiggleAnimationConfig.KEY_SCALE, "pivotX", "pivotY", "startContinuousChange", "", "endContinuousChange", "convertViewPointIntoContentPoint", "point", "convertContentPointIntoViewPoint", "convertViewRectIntoContentRect", "convertContentRectIntoViewRect", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface ISpenNoteZoomScroller {
    void close();

    @Nullable
    PointF convertContentPointIntoViewPoint(@Nullable PointF point);

    @Nullable
    RectF convertContentRectIntoViewRect(@Nullable RectF rect);

    @Nullable
    PointF convertViewPointIntoContentPoint(@Nullable PointF point);

    @Nullable
    RectF convertViewRectIntoContentRect(@Nullable RectF rect);

    boolean endContinuousChange();

    float getContentHeight();

    @Nullable
    RectF getContentMargin();

    @Nullable
    RectF getContentRectInView();

    float getContentScale();

    float getContentWidth();

    @Nullable
    PointF getDelta();

    float getMaxZoomScale();

    float getMinZoomScale();

    @Nullable
    PointF getPan();

    float getZoomScale();

    void scrollToContentRect(@Nullable RectF rect);

    void scrollToPage(int pageIndex);

    void setContentMargin(@Nullable RectF rectF);

    void setNoteZoomScrollerListener(@Nullable SpenNoteZoomScrollerListener listener);

    void setPan(@Nullable PointF pointF);

    void setZoomListener(@Nullable SpenZoomListener listener);

    void setZoomScale(float f);

    void setZoomScale(float scale, float pivotX, float pivotY);

    void smoothScrollToFitPage();

    boolean startContinuousChange();
}
