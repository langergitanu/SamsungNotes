package com.samsung.android.sdk.composer.view.zoomScroller;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p180f2.RunnableC11989a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 K2\u00020\u0001:\u0001KB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u00101\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010\tH\u0016J\b\u00102\u001a\u00020.H\u0016J\u0010\u00103\u001a\u00020.2\u0006\u00104\u001a\u000205H\u0016J\u0012\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u00010%H\u0016J \u0010\u0018\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u0014H\u0016J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\u0014\u0010=\u001a\u0004\u0018\u00010\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010?\u001a\u0004\u0018\u00010\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010@\u001a\u0004\u0018\u00010%2\b\u00107\u001a\u0004\u0018\u00010%H\u0016J\u0014\u0010A\u001a\u0004\u0018\u00010%2\b\u00107\u001a\u0004\u0018\u00010%H\u0016J0\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020;H\u0002J\u0010\u0010I\u001a\u00020.2\u0006\u0010J\u001a\u00020;H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u0014\u0010 \u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0017R\u0014\u0010\"\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0017R\u0016\u0010$\u001a\u0004\u0018\u00010%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R(\u0010)\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010%8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b*\u0010'\"\u0004\b+\u0010,¨\u0006L"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScroller;", "Lcom/samsung/android/sdk/composer/view/zoomScroller/ISpenNoteZoomScroller;", "mNativeNoteZoomScroller", "", "<init>", "(J)V", "mNoteZoomScrollerListener", "Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScrollerListener;", "mZoomListener", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenZoomListener;", "position", "Landroid/graphics/PointF;", "pan", "getPan", "()Landroid/graphics/PointF;", "setPan", "(Landroid/graphics/PointF;)V", "delta", "getDelta", WiggleAnimationConfig.KEY_SCALE, "", "zoomScale", "getZoomScale", "()F", "setZoomScale", "(F)V", "contentScale", "getContentScale", "minZoomScale", "getMinZoomScale", "maxZoomScale", "getMaxZoomScale", "contentWidth", "getContentWidth", "contentHeight", "getContentHeight", "contentRectInView", "Landroid/graphics/RectF;", "getContentRectInView", "()Landroid/graphics/RectF;", "value", "contentMargin", "getContentMargin", "setContentMargin", "(Landroid/graphics/RectF;)V", "close", "", "setNoteZoomScrollerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setZoomListener", "smoothScrollToFitPage", "scrollToPage", "pageIndex", "", "scrollToContentRect", "rect", "pivotX", "pivotY", "startContinuousChange", "", "endContinuousChange", "convertViewPointIntoContentPoint", "point", "convertContentPointIntoViewPoint", "convertViewRectIntoContentRect", "convertContentRectIntoViewRect", "onZoomChanged", "panX", "panY", "scaleX", "scaleY", "onZoomLockChanged", "isZoomLocked", "onScrollLockChanged", "isScrollLocked", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNoteZoomScroller implements ISpenNoteZoomScroller {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenNoteZoomScroller";
    private long mNativeNoteZoomScroller;

    @Nullable
    private SpenNoteZoomScrollerListener mNoteZoomScrollerListener;

    @Nullable
    private SpenZoomListener mZoomListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0083 J)\u0010\u0010\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0083 J\u0011\u0010\u0013\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u001b\u0010\u0014\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0083 J!\u0010\u0017\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0083 J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010 \u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010!\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0083 J\u0011\u0010$\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010%\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0013\u0010&\u001a\u0004\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010(\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J\u001d\u0010)\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\b\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u001bH\u0083 J\u001d\u0010+\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\b\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u001bH\u0083 J\u001d\u0010,\u001a\u0004\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0083 J\u001d\u0010-\u001a\u0004\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0083 J\u0013\u0010.\u001a\u0004\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\tH\u0083 J\u001b\u0010/\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScroller$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "nativeHandle", "", "noteZoomScroller", "Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScroller;", "Native_setZoomScale", "", WiggleAnimationConfig.KEY_SCALE, "", "Native_setZoomScaleWithPivot", "pivotX", "pivotY", "Native_smoothScrollToFitPage", "Native_scrollToContentRect", "rect", "Landroid/graphics/RectF;", "Native_setPan", "panX", "panY", "Native_getPan", "Landroid/graphics/PointF;", "Native_getDelta", "Native_getZoomScale", "Native_getContentScale", "Native_getMinZoomScale", "Native_getMaxZoomScale", "Native_goToPage", "pageIndex", "", "Native_getContentWidth", "Native_getContentHeight", "Native_getContentRectInView", "Native_startContinuousChange", "Native_endContinuousChange", "Native_convertViewPointIntoContentPoint", "point", "Native_convertContentPointIntoViewPoint", "Native_convertViewRectIntoContentRect", "Native_convertContentRectIntoViewRect", "Native_getContentMargin", "Native_setContentMargin", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final PointF Native_convertContentPointIntoViewPoint(long nativeHandle, PointF point) {
            return SpenNoteZoomScroller.Native_convertContentPointIntoViewPoint(nativeHandle, point);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_convertContentRectIntoViewRect(long nativeHandle, RectF rect) {
            return SpenNoteZoomScroller.Native_convertContentRectIntoViewRect(nativeHandle, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final PointF Native_convertViewPointIntoContentPoint(long nativeHandle, PointF point) {
            return SpenNoteZoomScroller.Native_convertViewPointIntoContentPoint(nativeHandle, point);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_convertViewRectIntoContentRect(long nativeHandle, RectF rect) {
            return SpenNoteZoomScroller.Native_convertViewRectIntoContentRect(nativeHandle, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_endContinuousChange(long nativeHandle) {
            return SpenNoteZoomScroller.Native_endContinuousChange(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getContentHeight(long nativeHandle) {
            return SpenNoteZoomScroller.Native_getContentHeight(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getContentMargin(long nativeHandle) {
            return SpenNoteZoomScroller.Native_getContentMargin(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getContentRectInView(long nativeHandle) {
            return SpenNoteZoomScroller.Native_getContentRectInView(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getContentScale(long nativeHandle) {
            return SpenNoteZoomScroller.Native_getContentScale(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getContentWidth(long nativeHandle) {
            return SpenNoteZoomScroller.Native_getContentWidth(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final PointF Native_getDelta(long nativeHandle) {
            return SpenNoteZoomScroller.Native_getDelta(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getMaxZoomScale(long nativeHandle) {
            return SpenNoteZoomScroller.Native_getMaxZoomScale(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getMinZoomScale(long nativeHandle) {
            return SpenNoteZoomScroller.Native_getMinZoomScale(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final PointF Native_getPan(long nativeHandle) {
            return SpenNoteZoomScroller.Native_getPan(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getZoomScale(long nativeHandle) {
            return SpenNoteZoomScroller.Native_getZoomScale(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_goToPage(long nativeHandle, int pageIndex) {
            SpenNoteZoomScroller.Native_goToPage(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_init(long nativeHandle, SpenNoteZoomScroller noteZoomScroller) {
            return SpenNoteZoomScroller.Native_init(nativeHandle, noteZoomScroller);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_scrollToContentRect(long nativeHandle, RectF rect) {
            SpenNoteZoomScroller.Native_scrollToContentRect(nativeHandle, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setContentMargin(long nativeHandle, RectF rect) {
            SpenNoteZoomScroller.Native_setContentMargin(nativeHandle, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setPan(long nativeHandle, float panX, float panY) {
            SpenNoteZoomScroller.Native_setPan(nativeHandle, panX, panY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setZoomScale(long nativeHandle, float scale) {
            SpenNoteZoomScroller.Native_setZoomScale(nativeHandle, scale);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setZoomScaleWithPivot(long nativeHandle, float scale, float pivotX, float pivotY) {
            SpenNoteZoomScroller.Native_setZoomScaleWithPivot(nativeHandle, scale, pivotX, pivotY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_smoothScrollToFitPage(long nativeHandle) {
            SpenNoteZoomScroller.Native_smoothScrollToFitPage(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_startContinuousChange(long nativeHandle) {
            return SpenNoteZoomScroller.Native_startContinuousChange(nativeHandle);
        }

        private Companion() {
        }
    }

    public SpenNoteZoomScroller(long j) {
        this.mNativeNoteZoomScroller = j;
        INSTANCE.Native_init(j, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native PointF Native_convertContentPointIntoViewPoint(long j, PointF pointF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_convertContentRectIntoViewRect(long j, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native PointF Native_convertViewPointIntoContentPoint(long j, PointF pointF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_convertViewRectIntoContentRect(long j, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_endContinuousChange(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getContentHeight(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getContentMargin(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getContentRectInView(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getContentScale(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getContentWidth(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native PointF Native_getDelta(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getMaxZoomScale(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getMinZoomScale(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native PointF Native_getPan(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getZoomScale(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_goToPage(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_init(long j, SpenNoteZoomScroller spenNoteZoomScroller);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_scrollToContentRect(long j, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setContentMargin(long j, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPan(long j, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setZoomScale(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setZoomScaleWithPivot(long j, float f, float f4, float f5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_smoothScrollToFitPage(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_startContinuousChange(long j);

    private final void onScrollLockChanged(boolean isScrollLocked) {
        Log.i(TAG, "onScrollLockChanged isScrollLocked=" + isScrollLocked);
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC11989a(this, isScrollLocked, 0), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScrollLockChanged$lambda$1(SpenNoteZoomScroller spenNoteZoomScroller, boolean z) {
        SpenNoteZoomScrollerListener spenNoteZoomScrollerListener = spenNoteZoomScroller.mNoteZoomScrollerListener;
        if (spenNoteZoomScrollerListener != null) {
            spenNoteZoomScrollerListener.onScrollLockChanged(z);
        }
    }

    private final void onZoomChanged(float panX, float panY, float scaleX, float scaleY, float zoomScale) {
        SpenZoomListener spenZoomListener;
        if (this.mNativeNoteZoomScroller == 0 || (spenZoomListener = this.mZoomListener) == null) {
            return;
        }
        spenZoomListener.onZoom(panX, panY, scaleX, scaleY, zoomScale);
    }

    private final void onZoomLockChanged(boolean isZoomLocked) {
        Log.i(TAG, "onZoomLockChanged isZoomLocked=" + isZoomLocked);
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC11989a(this, isZoomLocked, 1), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onZoomLockChanged$lambda$0(SpenNoteZoomScroller spenNoteZoomScroller, boolean z) {
        SpenNoteZoomScrollerListener spenNoteZoomScrollerListener = spenNoteZoomScroller.mNoteZoomScrollerListener;
        if (spenNoteZoomScrollerListener != null) {
            spenNoteZoomScrollerListener.onZoomLockChanged(z);
        }
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void close() {
        this.mNativeNoteZoomScroller = 0L;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public PointF convertContentPointIntoViewPoint(@Nullable PointF point) {
        long j = this.mNativeNoteZoomScroller;
        return j == 0 ? new PointF() : INSTANCE.Native_convertContentPointIntoViewPoint(j, point);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public RectF convertContentRectIntoViewRect(@Nullable RectF rect) {
        long j = this.mNativeNoteZoomScroller;
        return j == 0 ? new RectF() : INSTANCE.Native_convertContentRectIntoViewRect(j, rect);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public PointF convertViewPointIntoContentPoint(@Nullable PointF point) {
        long j = this.mNativeNoteZoomScroller;
        return j == 0 ? new PointF() : INSTANCE.Native_convertViewPointIntoContentPoint(j, point);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public RectF convertViewRectIntoContentRect(@Nullable RectF rect) {
        long j = this.mNativeNoteZoomScroller;
        return j == 0 ? new RectF() : INSTANCE.Native_convertViewRectIntoContentRect(j, rect);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public boolean endContinuousChange() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_endContinuousChange(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public float getContentHeight() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getContentHeight(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public RectF getContentMargin() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getContentMargin(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public RectF getContentRectInView() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getContentRectInView(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public float getContentScale() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getContentScale(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public float getContentWidth() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getContentWidth(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public PointF getDelta() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getDelta(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public float getMaxZoomScale() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getMaxZoomScale(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public float getMinZoomScale() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getMinZoomScale(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    @Nullable
    public PointF getPan() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPan(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public float getZoomScale() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getZoomScale(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void scrollToContentRect(@Nullable RectF rect) {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_scrollToContentRect(j, rect);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void scrollToPage(int pageIndex) {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_goToPage(j, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void setContentMargin(@Nullable RectF rectF) {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setContentMargin(j, rectF);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void setNoteZoomScrollerListener(@Nullable SpenNoteZoomScrollerListener listener) {
        this.mNoteZoomScrollerListener = listener;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void setPan(@Nullable PointF pointF) {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0 || pointF == null) {
            return;
        }
        INSTANCE.Native_setPan(j, pointF.x, pointF.y);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void setZoomListener(@Nullable SpenZoomListener listener) {
        this.mZoomListener = listener;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void setZoomScale(float f) {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setZoomScale(j, f);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void smoothScrollToFitPage() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_smoothScrollToFitPage(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public boolean startContinuousChange() {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_startContinuousChange(j);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller
    public void setZoomScale(float scale, float pivotX, float pivotY) {
        long j = this.mNativeNoteZoomScroller;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setZoomScaleWithPivot(j, scale, pivotX, pivotY);
    }
}
