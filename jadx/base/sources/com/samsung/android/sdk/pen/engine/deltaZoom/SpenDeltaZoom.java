package com.samsung.android.sdk.pen.engine.deltaZoom;

import android.graphics.PointF;
import android.graphics.RectF;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 e2\u00020\u0001:\u0002deB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010A\u001a\u00020BH\u0016J\u0016\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u000eJ&\u0010F\u001a\u00020B2\u0006\u0010G\u001a\u00020\u00142\u0006\u0010H\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u0014J \u0010K\u001a\u00020B2\u0006\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u0014H\u0016J\u0016\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u0014J\u0018\u0010R\u001a\u00020B2\u0006\u0010S\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020UH\u0016J \u0010V\u001a\u00020B2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u0014H\u0016J\u000e\u0010W\u001a\u00020)2\u0006\u0010#\u001a\u00020\u0014J\u000e\u0010X\u001a\u00020)2\u0006\u0010#\u001a\u00020\u0014J\u001e\u0010Y\u001a\u00020B2\u0006\u0010(\u001a\u00020)2\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u0014J&\u0010Z\u001a\u00020B2\u0006\u0010G\u001a\u00020\u00142\u0006\u0010H\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u0014J\u0016\u0010[\u001a\u00020B2\u0006\u0010\\\u001a\u00020\u00142\u0006\u0010]\u001a\u00020\u0014J\u0010\u0010^\u001a\u00020B2\b\u0010_\u001a\u0004\u0018\u00010\nJ\u0010\u0010`\u001a\u00020B2\b\u0010_\u001a\u0004\u0018\u00010\fJ0\u0010a\u001a\u00020B2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u0010\\\u001a\u00020\u00142\u0006\u0010]\u001a\u00020\u0014H\u0002J\u0018\u0010b\u001a\u00020B2\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u0014H\u0002J(\u0010c\u001a\u00020B2\u0006\u0010G\u001a\u00020\u00142\u0006\u0010H\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u0014H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b \u0010\u0016R\u0011\u0010!\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0016R$\u0010$\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010'R$\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u00020)2\u0006\u0010(\u001a\u00020)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R\u0011\u00100\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b1\u0010\u0016R\u0011\u00102\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b3\u0010\u0016R\u0011\u00104\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b5\u0010\u0016R(\u00108\u001a\u0004\u0018\u0001072\b\u00106\u001a\u0004\u0018\u0001078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0013\u0010=\u001a\u0004\u0018\u0001078F¢\u0006\u0006\u001a\u0004\b>\u0010:R\u0013\u0010?\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b@\u0010\u001c¨\u0006f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenDeltaZoom;", "", "nativeDeltaZoom", "", "<init>", "(J)V", "getNativeDeltaZoom", "()J", "setNativeDeltaZoom", "mZoomListener", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenZoomListener;", "mDeltaZoomListener", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenDeltaZoomListener;", "viewWidth", "", "getViewWidth", "()I", "viewHeight", "getViewHeight", "contentWidth", "", "getContentWidth", "()F", "contentHeight", "getContentHeight", "contentRectInView", "Landroid/graphics/RectF;", "getContentRectInView", "()Landroid/graphics/RectF;", "viewRectOfContentInView", "getViewRectOfContentInView", "scaleX", "getScaleX", "scaleY", "getScaleY", WiggleAnimationConfig.KEY_SCALE, "contentScale", "getContentScale", "setContentScale", "(F)V", "enable", "", "isZoomable", "()Z", "setZoomable", "(Z)V", "isScrollable", "setScrollable", "zoomScale", "getZoomScale", "maxZoomScale", "getMaxZoomScale", "minZoomScale", "getMinZoomScale", "position", "Landroid/graphics/PointF;", "pan", "getPan", "()Landroid/graphics/PointF;", "setPan", "(Landroid/graphics/PointF;)V", "delta", "getDelta", "deltaRange", "getDeltaRange", "close", "", "setViewSize", "width", "height", "setContentRect", "left", "top", "right", "bottom", "zoom", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "pivotX", "pivotY", "scroll", "distanceX", "distanceY", "scrollToContentRect", "rect", "alignmentMode", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenDeltaZoom$ScrollAlignmentMode;", "setZoomScale", "setMaxZoomScale", "setMinZoomScale", "setStretchMode", "setMargin", "setDelta", "deltaX", "deltaY", "setZoomListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDeltaZoomListener", "onDeltaZoomUpdated", "onViewSizeUpdated", "onContentRectUpdated", "ScrollAlignmentMode", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenDeltaZoom {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenDeltaZoom";

    @Nullable
    private SpenDeltaZoomListener mDeltaZoomListener;

    @Nullable
    private SpenZoomListener mZoomListener;
    private long nativeDeltaZoom;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0083 J!\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0083 J\u0011\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0083 J1\u0010\u0013\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0083 J\u0011\u0010\u0019\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u001a\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\b\u001a\u00020\tH\u0083 J)\u0010\u001e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0083 J!\u0010\"\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015H\u0083 J\u0011\u0010%\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010&\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010'\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0015H\u0083 J\u0011\u0010)\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0083 J!\u0010*\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u000fH\u0083 J\u0019\u0010-\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0007H\u0083 J\u0011\u0010/\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J)\u00100\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0083 J\u0011\u00101\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u00102\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0015H\u0083 J\u0011\u00103\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u00104\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0015H\u0083 J\u0011\u00105\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u00106\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0007H\u0083 J\u0011\u00107\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J)\u00108\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015H\u0083 J1\u00109\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0083 J!\u0010:\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\u0015H\u0083 J\u0013\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0013\u0010?\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\b\u001a\u00020\tH\u0083 J!\u0010@\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015H\u0083 J\u0013\u0010C\u001a\u0004\u0018\u00010>2\u0006\u0010\b\u001a\u00020\tH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006D"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenDeltaZoom$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_construct", "", "nativeDeltaZoom", "", "deltaZoom", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenDeltaZoom;", "Native_setViewSize", "", "width", "", "height", "Native_getViewWidth", "Native_getViewHeight", "Native_setContentRect", "left", "", "top", "right", "bottom", "Native_getContentWidth", "Native_getContentHeight", "Native_getContentRectInView", "Landroid/graphics/RectF;", "Native_getViewRectOfContentInView", "Native_zoom", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "pivotX", "pivotY", "Native_scroll", "distanceX", "distanceY", "Native_getScaleX", "Native_getScaleY", "Native_setContentScale", WiggleAnimationConfig.KEY_SCALE, "Native_getContentScale", "Native_scrollToContentRect", "rect", "alignmentMode", "Native_setZoomable", "enable", "Native_isZoomable", "Native_setZoomScale", "Native_getZoomScale", "Native_setMaxZoomScale", "Native_getMaxZoomScale", "Native_setMinZoomScale", "Native_getMinZoomScale", "Native_setScrollable", "Native_isScrollable", "Native_setStretchMode", "Native_setMargin", "Native_setDelta", "deltaX", "deltaY", "Native_getDelta", "Landroid/graphics/PointF;", "Native_getDeltaRange", "Native_setPan", "panX", "panY", "Native_getPan", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_construct(long nativeDeltaZoom, SpenDeltaZoom deltaZoom) {
            return SpenDeltaZoom.Native_construct(nativeDeltaZoom, deltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getContentHeight(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getContentHeight(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getContentRectInView(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getContentRectInView(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getContentScale(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getContentScale(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getContentWidth(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getContentWidth(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final PointF Native_getDelta(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getDelta(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getDeltaRange(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getDeltaRange(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getMaxZoomScale(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getMaxZoomScale(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getMinZoomScale(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getMinZoomScale(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final PointF Native_getPan(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getPan(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getScaleX(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getScaleX(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getScaleY(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getScaleY(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getViewHeight(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getViewHeight(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getViewRectOfContentInView(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getViewRectOfContentInView(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getViewWidth(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getViewWidth(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getZoomScale(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_getZoomScale(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isScrollable(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_isScrollable(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isZoomable(long nativeDeltaZoom) {
            return SpenDeltaZoom.Native_isZoomable(nativeDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_scroll(long nativeDeltaZoom, float distanceX, float distanceY) {
            SpenDeltaZoom.Native_scroll(nativeDeltaZoom, distanceX, distanceY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_scrollToContentRect(long nativeDeltaZoom, RectF rect, int alignmentMode) {
            SpenDeltaZoom.Native_scrollToContentRect(nativeDeltaZoom, rect, alignmentMode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setContentRect(long nativeDeltaZoom, float left, float top, float right, float bottom) {
            SpenDeltaZoom.Native_setContentRect(nativeDeltaZoom, left, top, right, bottom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setContentScale(long nativeDeltaZoom, float scale) {
            SpenDeltaZoom.Native_setContentScale(nativeDeltaZoom, scale);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setDelta(long nativeDeltaZoom, float deltaX, float deltaY) {
            SpenDeltaZoom.Native_setDelta(nativeDeltaZoom, deltaX, deltaY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setMargin(long nativeDeltaZoom, float left, float top, float right, float bottom) {
            SpenDeltaZoom.Native_setMargin(nativeDeltaZoom, left, top, right, bottom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setMaxZoomScale(long nativeDeltaZoom, float scale) {
            return SpenDeltaZoom.Native_setMaxZoomScale(nativeDeltaZoom, scale);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setMinZoomScale(long nativeDeltaZoom, float scale) {
            return SpenDeltaZoom.Native_setMinZoomScale(nativeDeltaZoom, scale);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setPan(long nativeDeltaZoom, float panX, float panY) {
            SpenDeltaZoom.Native_setPan(nativeDeltaZoom, panX, panY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setScrollable(long nativeDeltaZoom, boolean enable) {
            SpenDeltaZoom.Native_setScrollable(nativeDeltaZoom, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setStretchMode(long nativeDeltaZoom, boolean enable, float width, float height) {
            SpenDeltaZoom.Native_setStretchMode(nativeDeltaZoom, enable, width, height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setViewSize(long nativeDeltaZoom, int width, int height) {
            SpenDeltaZoom.Native_setViewSize(nativeDeltaZoom, width, height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setZoomScale(long nativeDeltaZoom, float scale, float pivotX, float pivotY) {
            SpenDeltaZoom.Native_setZoomScale(nativeDeltaZoom, scale, pivotX, pivotY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setZoomable(long nativeDeltaZoom, boolean enable) {
            SpenDeltaZoom.Native_setZoomable(nativeDeltaZoom, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_zoom(long nativeDeltaZoom, float scaleFactor, float pivotX, float pivotY) {
            SpenDeltaZoom.Native_zoom(nativeDeltaZoom, scaleFactor, pivotX, pivotY);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenDeltaZoom$ScrollAlignmentMode;", "", "intValue", "", "<init>", "(Ljava/lang/String;II)V", "getIntValue", "()I", "ALIGNMENT_MODE_LEFT_TOP", "ALIGNMENT_MODE_MID_TOP", "ALIGNMENT_MODE_RIGHT_TOP", "ALIGNMENT_MODE_LEFT_MID", "ALIGNMENT_MODE_MID", "ALIGNMENT_MODE_RIGHT_MID", "ALIGNMENT_MODE_LEFT_BOTTOM", "ALIGNMENT_MODE_MID_BOTTOM", "ALIGNMENT_MODE_RIGHT_BOTTOM", "ALIGNMENT_MODE_OPTIMAL", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ScrollAlignmentMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScrollAlignmentMode[] $VALUES;
        private final int intValue;
        public static final ScrollAlignmentMode ALIGNMENT_MODE_LEFT_TOP = new ScrollAlignmentMode("ALIGNMENT_MODE_LEFT_TOP", 0, 0);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_MID_TOP = new ScrollAlignmentMode("ALIGNMENT_MODE_MID_TOP", 1, 1);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_RIGHT_TOP = new ScrollAlignmentMode("ALIGNMENT_MODE_RIGHT_TOP", 2, 2);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_LEFT_MID = new ScrollAlignmentMode("ALIGNMENT_MODE_LEFT_MID", 3, 3);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_MID = new ScrollAlignmentMode("ALIGNMENT_MODE_MID", 4, 4);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_RIGHT_MID = new ScrollAlignmentMode("ALIGNMENT_MODE_RIGHT_MID", 5, 5);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_LEFT_BOTTOM = new ScrollAlignmentMode("ALIGNMENT_MODE_LEFT_BOTTOM", 6, 6);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_MID_BOTTOM = new ScrollAlignmentMode("ALIGNMENT_MODE_MID_BOTTOM", 7, 7);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_RIGHT_BOTTOM = new ScrollAlignmentMode("ALIGNMENT_MODE_RIGHT_BOTTOM", 8, 8);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_OPTIMAL = new ScrollAlignmentMode("ALIGNMENT_MODE_OPTIMAL", 9, 9);

        private static final /* synthetic */ ScrollAlignmentMode[] $values() {
            return new ScrollAlignmentMode[]{ALIGNMENT_MODE_LEFT_TOP, ALIGNMENT_MODE_MID_TOP, ALIGNMENT_MODE_RIGHT_TOP, ALIGNMENT_MODE_LEFT_MID, ALIGNMENT_MODE_MID, ALIGNMENT_MODE_RIGHT_MID, ALIGNMENT_MODE_LEFT_BOTTOM, ALIGNMENT_MODE_MID_BOTTOM, ALIGNMENT_MODE_RIGHT_BOTTOM, ALIGNMENT_MODE_OPTIMAL};
        }

        static {
            ScrollAlignmentMode[] scrollAlignmentModeArr$values = $values();
            $VALUES = scrollAlignmentModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scrollAlignmentModeArr$values);
        }

        private ScrollAlignmentMode(String str, int i, int i2) {
            this.intValue = i2;
        }

        @NotNull
        public static EnumEntries<ScrollAlignmentMode> getEntries() {
            return $ENTRIES;
        }

        public static ScrollAlignmentMode valueOf(String str) {
            return (ScrollAlignmentMode) Enum.valueOf(ScrollAlignmentMode.class, str);
        }

        public static ScrollAlignmentMode[] values() {
            return (ScrollAlignmentMode[]) $VALUES.clone();
        }

        public final int getIntValue() {
            return this.intValue;
        }
    }

    public SpenDeltaZoom(long j) {
        this.nativeDeltaZoom = j;
        if (j == 0) {
            throw new NullPointerException("nativeDeltaZoom is null");
        }
        INSTANCE.Native_construct(j, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_construct(long j, SpenDeltaZoom spenDeltaZoom);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getContentHeight(long j);

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
    public static final native RectF Native_getDeltaRange(long j);

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
    public static final native float Native_getScaleX(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getScaleY(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getViewHeight(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getViewRectOfContentInView(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getViewWidth(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getZoomScale(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isScrollable(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isZoomable(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_scroll(long j, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_scrollToContentRect(long j, RectF rectF, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setContentRect(long j, float f, float f4, float f5, float f6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setContentScale(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setDelta(long j, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setMargin(long j, float f, float f4, float f5, float f6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setMaxZoomScale(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setMinZoomScale(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPan(long j, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setScrollable(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setStretchMode(long j, boolean z, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setViewSize(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setZoomScale(long j, float f, float f4, float f5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setZoomable(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_zoom(long j, float f, float f4, float f5);

    private final void onContentRectUpdated(float left, float top, float right, float bottom) {
        SpenDeltaZoomListener spenDeltaZoomListener = this.mDeltaZoomListener;
        if (spenDeltaZoomListener != null) {
            spenDeltaZoomListener.onContentRectUpdated(left, top, right, bottom);
        }
    }

    private final void onDeltaZoomUpdated(float scaleX, float scaleY, float zoomScale, float deltaX, float deltaY) {
        float f = (-deltaX) / scaleX;
        float f4 = (-deltaY) / scaleY;
        SpenZoomListener spenZoomListener = this.mZoomListener;
        if (spenZoomListener != null) {
            spenZoomListener.onZoom(f, f4, scaleX, scaleY, zoomScale);
        }
        SpenDeltaZoomListener spenDeltaZoomListener = this.mDeltaZoomListener;
        if (spenDeltaZoomListener != null) {
            spenDeltaZoomListener.onZoom(f, f4, scaleX, scaleY, zoomScale);
        }
    }

    private final void onViewSizeUpdated(float width, float height) {
        SpenDeltaZoomListener spenDeltaZoomListener = this.mDeltaZoomListener;
        if (spenDeltaZoomListener != null) {
            spenDeltaZoomListener.onViewSizeUpdated(width, height);
        }
    }

    public void close() {
        this.mZoomListener = null;
        this.nativeDeltaZoom = 0L;
    }

    public final float getContentHeight() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getContentHeight(j);
    }

    @Nullable
    public final RectF getContentRectInView() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getContentRectInView(j);
    }

    public final float getContentScale() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getContentScale(j);
    }

    public final float getContentWidth() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getContentWidth(j);
    }

    @Nullable
    public final PointF getDelta() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getDelta(j);
    }

    @Nullable
    public final RectF getDeltaRange() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getDeltaRange(j);
    }

    public final float getMaxZoomScale() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getMaxZoomScale(j);
    }

    public final float getMinZoomScale() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getMinZoomScale(j);
    }

    public final long getNativeDeltaZoom() {
        return this.nativeDeltaZoom;
    }

    @Nullable
    public PointF getPan() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPan(j);
    }

    public final float getScaleX() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getScaleX(j);
    }

    public final float getScaleY() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getScaleY(j);
    }

    public final int getViewHeight() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getViewHeight(j);
    }

    @Nullable
    public final RectF getViewRectOfContentInView() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getViewRectOfContentInView(j);
    }

    public final int getViewWidth() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getViewWidth(j);
    }

    public final float getZoomScale() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getZoomScale(j);
    }

    public final boolean isScrollable() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_isScrollable(j);
    }

    public boolean isZoomable() {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_isZoomable(j);
    }

    public final void scroll(float distanceX, float distanceY) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_scroll(j, distanceX, distanceY);
    }

    public void scrollToContentRect(@NotNull RectF rect, @NotNull ScrollAlignmentMode alignmentMode) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(alignmentMode, "alignmentMode");
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_scrollToContentRect(j, rect, alignmentMode.getIntValue());
    }

    public final void setContentRect(float left, float top, float right, float bottom) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setContentRect(j, left, top, right, bottom);
    }

    public final void setContentScale(float f) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setContentScale(j, f);
    }

    public final void setDelta(float deltaX, float deltaY) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setDelta(j, deltaX, deltaY);
    }

    public final void setDeltaZoomListener(@Nullable SpenDeltaZoomListener listener) {
        this.mDeltaZoomListener = listener;
    }

    public final void setMargin(float left, float top, float right, float bottom) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setMargin(j, left, top, right, bottom);
    }

    public final boolean setMaxZoomScale(float scale) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_setMaxZoomScale(j, scale);
    }

    public final boolean setMinZoomScale(float scale) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_setMinZoomScale(j, scale);
    }

    public final void setNativeDeltaZoom(long j) {
        this.nativeDeltaZoom = j;
    }

    public void setPan(@Nullable PointF pointF) {
        long j = this.nativeDeltaZoom;
        if (j == 0 || pointF == null) {
            return;
        }
        INSTANCE.Native_setPan(j, pointF.x, pointF.y);
    }

    public final void setScrollable(boolean z) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setScrollable(j, z);
    }

    public final void setStretchMode(boolean enable, float width, float height) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setStretchMode(j, enable, width, height);
    }

    public final void setViewSize(int width, int height) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setViewSize(j, width, height);
    }

    public final void setZoomListener(@Nullable SpenZoomListener listener) {
        this.mZoomListener = listener;
    }

    public void setZoomScale(float scale, float pivotX, float pivotY) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setZoomScale(j, scale, pivotX, pivotY);
    }

    public void setZoomable(boolean z) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setZoomable(j, z);
    }

    public void zoom(float scaleFactor, float pivotX, float pivotY) {
        long j = this.nativeDeltaZoom;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_zoom(j, scaleFactor, pivotX, pivotY);
    }
}
