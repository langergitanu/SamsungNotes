package com.samsung.android.sdk.pen.setting.pencommon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.pen.SpenPen;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\u00020\u0001:\u00017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u000fJ\u0010\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&J&\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0012J\u0016\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u00020\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\"\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\"\u0010#R$\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00068"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreviewManager;", "", "context", "Landroid/content/Context;", "penName", "", "dataManager", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreviewHelper;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreviewHelper;)V", "getPenName", "()Ljava/lang/String;", "mSpenPreviewPen", "Lcom/samsung/android/sdk/pen/pen/SpenPen;", "mScreenWidth", "", "mScreenHeight", "mEraserEnabled", "", "mColor", "mOverlappingResourceId", "mDensity", "mIsSupportParticleDensity", VElementFormulasCmd.FMAX, "", "getMax", "()F", "setMax", "(F)V", "setColor", "", "color", "setDensity", "density", "isReady", "()Z", "updatePenBitmap", "bitmap", "Landroid/graphics/Bitmap;", "value", "overlappingBgResource", "getOverlappingBgResource", "()I", "setOverlappingBgResource", "(I)V", "startDraw", "strokeSize", "isFixedWidth", "isFixedOpacity", "updateDraw", "event", "Landroid/view/MotionEvent;", "rect", "Landroid/graphics/RectF;", "endDraw", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPreviewManager {

    @NotNull
    private static final String TAG = "SpenPreviewManager";
    private int mColor;
    private int mDensity;
    private boolean mEraserEnabled;
    private boolean mIsSupportParticleDensity;
    private int mOverlappingResourceId;
    private final int mScreenHeight;
    private final int mScreenWidth;

    @Nullable
    private final SpenPen mSpenPreviewPen;
    private float max;

    @NotNull
    private final String penName;

    public SpenPreviewManager(@NotNull Context context, @NotNull String penName, @NotNull SpenPreviewHelper dataManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(penName, "penName");
        Intrinsics.checkNotNullParameter(dataManager, "dataManager");
        this.penName = penName;
        this.mColor = 255;
        SpenPen previewObject = dataManager.getPreviewObject(penName);
        this.mSpenPreviewPen = previewObject;
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        if (previewObject != null) {
            this.max = (previewObject.getMaxSettingValue() * context.getApplicationContext().getResources().getDisplayMetrics().densityDpi) / 160.0f;
            boolean penAttribute = previewObject.getPenAttribute(5);
            this.mIsSupportParticleDensity = penAttribute;
            Log.i(TAG, "pen=" + penName + " isSupportParticleDensity=" + penAttribute);
        }
    }

    public final void endDraw() {
        Log.i(TAG, "endDraw()");
        SpenPen spenPen = this.mSpenPreviewPen;
        if (spenPen == null) {
            return;
        }
        spenPen.setBitmap(null);
        boolean z = this.mEraserEnabled;
        if (z) {
            this.mSpenPreviewPen.setEraserEnabled(z);
        }
    }

    public final float getMax() {
        return this.max;
    }

    /* JADX INFO: renamed from: getOverlappingBgResource, reason: from getter */
    public final int getMOverlappingResourceId() {
        return this.mOverlappingResourceId;
    }

    @NotNull
    public final String getPenName() {
        return this.penName;
    }

    public final boolean isReady() {
        return this.mSpenPreviewPen != null;
    }

    public final void setColor(int color) {
        this.mColor = color;
    }

    public final void setDensity(int density) {
        this.mDensity = density;
    }

    public final void setMax(float f) {
        this.max = f;
    }

    public final void setOverlappingBgResource(int i) {
        this.mOverlappingResourceId = i;
    }

    public final void startDraw(float strokeSize, @NotNull Bitmap bitmap, boolean isFixedWidth, boolean isFixedOpacity) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int i = this.mScreenWidth;
        int i2 = this.mScreenHeight;
        AbstractC0000a.m26w(AbstractC0622a.m1173s(i, i2, "startDraw() cavasWidth=", " canvasHeight=", " color="), TAG, this.mColor);
        SpenPen spenPen = this.mSpenPreviewPen;
        if (spenPen == null) {
            return;
        }
        spenPen.setBitmap(bitmap);
        this.mSpenPreviewPen.setSize(strokeSize);
        this.mSpenPreviewPen.setScreenResolution(this.mScreenWidth, this.mScreenHeight);
        this.mSpenPreviewPen.setColor(this.mColor);
        this.mSpenPreviewPen.setFixedWidthEnabled(isFixedWidth);
        this.mSpenPreviewPen.setFixedWidth(strokeSize);
        this.mSpenPreviewPen.setFixedOpacityEnabled(isFixedOpacity);
        boolean zIsEraserEnabled = this.mSpenPreviewPen.isEraserEnabled();
        this.mEraserEnabled = zIsEraserEnabled;
        if (zIsEraserEnabled) {
            this.mSpenPreviewPen.setEraserEnabled(false);
        }
        if (this.mIsSupportParticleDensity) {
            this.mSpenPreviewPen.setParticleDensity(this.mDensity);
        }
    }

    public final void updateDraw(@NotNull MotionEvent event, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Log.i(TAG, "updateDraw()");
        SpenPen spenPen = this.mSpenPreviewPen;
        if (spenPen != null) {
            spenPen.draw(event, rect);
        }
    }

    public final void updatePenBitmap(@Nullable Bitmap bitmap) {
        SpenPen spenPen = this.mSpenPreviewPen;
        if (spenPen != null) {
            spenPen.setBitmap(bitmap);
        }
    }
}
