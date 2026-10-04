package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPreviewHelper;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J*\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPreviewController;", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenUIPreviewControl;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPenPreview", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPreview;", "mPreviewHelper", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreviewHelper;", "release", "", "setPenInfo", "penType", "", "strokeSize", "", "color", "", "particleDensity", "setSize", "setAlpha", "alpha", "setParticleDensity", "density", "hasAdaptiveBackgroundColor", "", "makePreview", "Landroid/view/View;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushPreviewController implements SpenUIPreviewControl {

    @Nullable
    private SpenBrushPreview mPenPreview;

    @NotNull
    private SpenPreviewHelper mPreviewHelper;

    public SpenBrushPreviewController(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPreviewHelper = new SpenPreviewHelper(context);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenUIPreviewControl
    public boolean hasAdaptiveBackgroundColor() {
        SpenBrushPreview spenBrushPreview = this.mPenPreview;
        return spenBrushPreview != null && spenBrushPreview.getMHasAdaptiveBackgroundColor();
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenUIPreviewControl
    @NotNull
    public View makePreview(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        SpenBrushPreview spenBrushPreview = new SpenBrushPreview(context);
        this.mPenPreview = spenBrushPreview;
        spenBrushPreview.setPreviewHelper(this.mPreviewHelper);
        SpenBrushPreview spenBrushPreview2 = this.mPenPreview;
        if (spenBrushPreview2 != null) {
            spenBrushPreview2.setRadius(resources.getDimensionPixelSize(C7932R.dimen.drawing_brush_preview_pen_preview_radius));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, resources.getDimensionPixelSize(C7932R.dimen.drawing_brush_preview_height_pen));
        layoutParams.gravity = 17;
        layoutParams.setMarginStart(resources.getDimensionPixelSize(C7932R.dimen.drawing_brush_preview_pen_preview_margin));
        layoutParams.setMarginEnd(resources.getDimensionPixelSize(C7932R.dimen.drawing_brush_preview_pen_preview_margin));
        SpenBrushPreview spenBrushPreview3 = this.mPenPreview;
        if (spenBrushPreview3 != null) {
            spenBrushPreview3.setPadding(resources.getDimensionPixelSize(C7932R.dimen.drawing_brush_preview_pen_preview_padding), 0, resources.getDimensionPixelSize(C7932R.dimen.drawing_brush_preview_pen_preview_padding), 0);
        }
        SpenBrushPreview spenBrushPreview4 = this.mPenPreview;
        if (spenBrushPreview4 != null) {
            spenBrushPreview4.setLayoutParams(layoutParams);
        }
        SpenBrushPreview spenBrushPreview5 = this.mPenPreview;
        Intrinsics.checkNotNull(spenBrushPreview5);
        return spenBrushPreview5;
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenUIPreviewControl
    public void release() {
        SpenBrushPreview spenBrushPreview = this.mPenPreview;
        if (spenBrushPreview != null) {
            spenBrushPreview.close();
        }
        this.mPenPreview = null;
        this.mPreviewHelper.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenUIPreviewControl
    public void setAlpha(int alpha) {
        SpenBrushPreview spenBrushPreview = this.mPenPreview;
        if (spenBrushPreview != null) {
            spenBrushPreview.setStrokeAlpha(alpha);
        }
        SpenBrushPreview spenBrushPreview2 = this.mPenPreview;
        if (spenBrushPreview2 != null) {
            spenBrushPreview2.invalidate();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenUIPreviewControl
    public void setParticleDensity(int density) {
        SpenBrushPreview spenBrushPreview = this.mPenPreview;
        if (spenBrushPreview != null) {
            spenBrushPreview.setParticleDensity(density);
        }
        SpenBrushPreview spenBrushPreview2 = this.mPenPreview;
        if (spenBrushPreview2 != null) {
            spenBrushPreview2.invalidate();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenUIPreviewControl
    public void setPenInfo(@Nullable String penType, float strokeSize, int color, int particleDensity) {
        SpenBrushPreview spenBrushPreview = this.mPenPreview;
        if (spenBrushPreview != null) {
            spenBrushPreview.setPenInfo(penType, strokeSize, color, particleDensity);
        }
        SpenBrushPreview spenBrushPreview2 = this.mPenPreview;
        if (spenBrushPreview2 != null) {
            spenBrushPreview2.invalidate();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenUIPreviewControl
    public void setSize(float strokeSize) {
        SpenBrushPreview spenBrushPreview = this.mPenPreview;
        if (spenBrushPreview != null) {
            spenBrushPreview.setStrokeSize(strokeSize);
        }
        SpenBrushPreview spenBrushPreview2 = this.mPenPreview;
        if (spenBrushPreview2 != null) {
            spenBrushPreview2.invalidate();
        }
    }
}
