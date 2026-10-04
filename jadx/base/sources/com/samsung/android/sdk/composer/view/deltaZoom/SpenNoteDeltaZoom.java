package com.samsung.android.sdk.composer.view.deltaZoom;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.composer.listener.SpenNoteDeltaZoomListener;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenDeltaZoom;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p035H2.RunnableC0116a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "")
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\tJ \u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J \u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0013H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/deltaZoom/SpenNoteDeltaZoom;", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenDeltaZoom;", "nativeDeltaZoom", "", "view", "Landroid/view/View;", "<init>", "(JLandroid/view/View;)V", "mNoteDeltaZoomListener", "Lcom/samsung/android/sdk/composer/listener/SpenNoteDeltaZoomListener;", "mView", "position", "Landroid/graphics/PointF;", "pan", "getPan", "()Landroid/graphics/PointF;", "setPan", "(Landroid/graphics/PointF;)V", "enable", "", "isZoomable", "()Z", "setZoomable", "(Z)V", "close", "", "setListener", "l", "zoom", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "", "pivotX", "pivotY", "setZoomScale", WiggleAnimationConfig.KEY_SCALE, "scrollToContentRect", "rect", "Landroid/graphics/RectF;", "alignmentMode", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenDeltaZoom$ScrollAlignmentMode;", "onZoomableChanged", "onMovementLockedChanged", "isMovementLocked", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNoteDeltaZoom extends SpenDeltaZoom {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenNoteDeltaZoom";

    @Nullable
    private SpenNoteDeltaZoomListener mNoteDeltaZoomListener;

    @Nullable
    private View mView;

    @Nullable
    private PointF pan;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J)\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0083 J)\u0010\u0012\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0083 J!\u0010\u0014\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0083 J!\u0010\u0019\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0083 J\u0019\u0010\u001c\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0007H\u0083 J\u0011\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/deltaZoom/SpenNoteDeltaZoom$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_construct", "", "nativeHandle", "", "noteDeltaZoom", "Lcom/samsung/android/sdk/composer/view/deltaZoom/SpenNoteDeltaZoom;", "Native_zoom", "", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "", "pivotX", "pivotY", "Native_setZoomScale", WiggleAnimationConfig.KEY_SCALE, "Native_scrollToContentRect", "rect", "Landroid/graphics/RectF;", "alignmentMode", "", "Native_setPan", "panX", "panY", "Native_setZoomable", "enabled", "Native_isZoomable", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_construct(long nativeHandle, SpenNoteDeltaZoom noteDeltaZoom) {
            return SpenNoteDeltaZoom.Native_construct(nativeHandle, noteDeltaZoom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isZoomable(long nativeHandle) {
            return SpenNoteDeltaZoom.Native_isZoomable(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_scrollToContentRect(long nativeHandle, RectF rect, int alignmentMode) {
            SpenNoteDeltaZoom.Native_scrollToContentRect(nativeHandle, rect, alignmentMode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setPan(long nativeHandle, float panX, float panY) {
            SpenNoteDeltaZoom.Native_setPan(nativeHandle, panX, panY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setZoomScale(long nativeHandle, float scale, float pivotX, float pivotY) {
            SpenNoteDeltaZoom.Native_setZoomScale(nativeHandle, scale, pivotX, pivotY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setZoomable(long nativeHandle, boolean enabled) {
            SpenNoteDeltaZoom.Native_setZoomable(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_zoom(long nativeHandle, float scaleFactor, float pivotX, float pivotY) {
            SpenNoteDeltaZoom.Native_zoom(nativeHandle, scaleFactor, pivotX, pivotY);
        }

        private Companion() {
        }
    }

    public SpenNoteDeltaZoom(long j, @Nullable View view) {
        super(j);
        this.pan = new PointF();
        INSTANCE.Native_construct(j, this);
        this.mView = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_construct(long j, SpenNoteDeltaZoom spenNoteDeltaZoom);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isZoomable(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_scrollToContentRect(long j, RectF rectF, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPan(long j, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setZoomScale(long j, float f, float f4, float f5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setZoomable(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_zoom(long j, float f, float f4, float f5);

    private final void onMovementLockedChanged(boolean isMovementLocked) {
        AbstractC4539a.m3208r("onMovementLockedChanged isMovementLocked=", TAG, isMovementLocked);
        View view = this.mView;
        if (view != null) {
            view.post(new RunnableC0116a(19, this, isMovementLocked));
            return;
        }
        SpenNoteDeltaZoomListener spenNoteDeltaZoomListener = this.mNoteDeltaZoomListener;
        if (spenNoteDeltaZoomListener != null) {
            spenNoteDeltaZoomListener.onMovementLockedChanged(isMovementLocked);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMovementLockedChanged$lambda$0(SpenNoteDeltaZoom spenNoteDeltaZoom, boolean z) {
        SpenNoteDeltaZoomListener spenNoteDeltaZoomListener = spenNoteDeltaZoom.mNoteDeltaZoomListener;
        if (spenNoteDeltaZoomListener != null) {
            spenNoteDeltaZoomListener.onMovementLockedChanged(z);
        }
    }

    private final void onZoomableChanged(boolean isZoomable) {
        AbstractC4539a.m3208r("onZoomableChanged isZoomable=", TAG, isZoomable);
        SpenNoteDeltaZoomListener spenNoteDeltaZoomListener = this.mNoteDeltaZoomListener;
        if (spenNoteDeltaZoomListener != null) {
            spenNoteDeltaZoomListener.onZoomableChanged(isZoomable);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.deltaZoom.SpenDeltaZoom
    public void close() {
        super.close();
        this.mView = null;
    }

    @Override // com.samsung.android.sdk.pen.engine.deltaZoom.SpenDeltaZoom
    @Nullable
    public PointF getPan() {
        return this.pan;
    }

    @Override // com.samsung.android.sdk.pen.engine.deltaZoom.SpenDeltaZoom
    public boolean isZoomable() {
        if (getNativeDeltaZoom() == 0) {
            return false;
        }
        return INSTANCE.Native_isZoomable(getNativeDeltaZoom());
    }

    @Override // com.samsung.android.sdk.pen.engine.deltaZoom.SpenDeltaZoom
    public void scrollToContentRect(@NotNull RectF rect, @NotNull SpenDeltaZoom.ScrollAlignmentMode alignmentMode) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(alignmentMode, "alignmentMode");
        if (getNativeDeltaZoom() == 0) {
            return;
        }
        INSTANCE.Native_scrollToContentRect(getNativeDeltaZoom(), rect, alignmentMode.getIntValue());
    }

    public final void setListener(@Nullable SpenNoteDeltaZoomListener l) {
        this.mNoteDeltaZoomListener = l;
    }

    @Override // com.samsung.android.sdk.pen.engine.deltaZoom.SpenDeltaZoom
    public void setPan(@Nullable PointF pointF) {
        if (getNativeDeltaZoom() == 0 || pointF == null) {
            return;
        }
        INSTANCE.Native_setPan(getNativeDeltaZoom(), pointF.x, pointF.y);
    }

    @Override // com.samsung.android.sdk.pen.engine.deltaZoom.SpenDeltaZoom
    public void setZoomScale(float scale, float pivotX, float pivotY) {
        if (getNativeDeltaZoom() == 0) {
            return;
        }
        INSTANCE.Native_setZoomScale(getNativeDeltaZoom(), scale, pivotX, pivotY);
    }

    @Override // com.samsung.android.sdk.pen.engine.deltaZoom.SpenDeltaZoom
    public void setZoomable(boolean z) {
        if (getNativeDeltaZoom() == 0) {
            return;
        }
        INSTANCE.Native_setZoomable(getNativeDeltaZoom(), z);
    }

    @Override // com.samsung.android.sdk.pen.engine.deltaZoom.SpenDeltaZoom
    public void zoom(float scaleFactor, float pivotX, float pivotY) {
        if (getNativeDeltaZoom() == 0) {
            return;
        }
        INSTANCE.Native_zoom(getNativeDeltaZoom(), scaleFactor, pivotX, pivotY);
    }
}
