package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreview;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPreviewHelper;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPreviewManager;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenRoundClipHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\rJ\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0007H\u0002J(\u0010\"\u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rJ\u0010\u0010&\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010\tJ\u0006\u0010(\u001a\u00020\u0011J\b\u0010)\u001a\u00020\u0018H\u0002J\u000e\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020$J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPreview;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPreview;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPenType", "", "mPreviewHelper", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreviewHelper;", "mPreviewManager", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreviewManager;", "mAdaptiveBgColor", "", "mColor", "mDensity", "mHasAdaptiveBackgroundColor", "", "mContext", "mRoundClipHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenRoundClipHelper;", "mBgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "construct", "", "close", "setStrokeAlpha", "alpha", "setStrokeColor", "color", "setParticleDensity", "density", "setPenType", "penType", "setPenInfo", "strokeSize", "", "particleDensity", "setPreviewHelper", "previewManager", "hasAdaptiveBackgroundColor", "applyBackgroundColor", "setRadius", "radius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushPreview extends SpenPenPreview {

    @NotNull
    private static final String TAG = "SpenBrushPreview";
    private int mAdaptiveBgColor;
    private GradientDrawable mBgDrawable;
    private int mColor;
    private Context mContext;
    private int mDensity;
    private boolean mHasAdaptiveBackgroundColor;

    @Nullable
    private String mPenType;

    @Nullable
    private SpenPreviewHelper mPreviewHelper;

    @Nullable
    private SpenPreviewManager mPreviewManager;
    private SpenRoundClipHelper mRoundClipHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushPreview(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mColor = -16777216;
        this.mDensity = 1;
        construct(context);
    }

    private final void applyBackgroundColor() {
        Context context = this.mContext;
        GradientDrawable gradientDrawable = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        boolean zIsAdaptiveColor = SpenSettingUtil.isAdaptiveColor(context, this.mColor);
        this.mHasAdaptiveBackgroundColor = zIsAdaptiveColor;
        int i = zIsAdaptiveColor ? this.mAdaptiveBgColor : 0;
        GradientDrawable gradientDrawable2 = this.mBgDrawable;
        if (gradientDrawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBgDrawable");
        } else {
            gradientDrawable = gradientDrawable2;
        }
        gradientDrawable.setColor(i);
    }

    private final void setPenType(String penType) {
        this.mPenType = penType;
        SpenPreviewHelper spenPreviewHelper = this.mPreviewHelper;
        if (spenPreviewHelper != null) {
            SpenPreviewManager spenPreviewManager = this.mPreviewManager;
            Context context = null;
            if (spenPreviewManager != null) {
                if (Intrinsics.areEqual(spenPreviewManager != null ? spenPreviewManager.getPenName() : null, this.mPenType)) {
                    return;
                }
            }
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context2;
            }
            SpenPreviewManager spenPreviewManager2 = new SpenPreviewManager(context, penType, spenPreviewHelper);
            this.mPreviewManager = spenPreviewManager2;
            Intrinsics.checkNotNull(spenPreviewManager2);
            setPreviewManager(spenPreviewManager2);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreview
    public void close() {
        super.close();
        this.mPenType = null;
    }

    public final void construct(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        Drawable drawable = null;
        this.mPreviewHelper = null;
        this.mPreviewManager = null;
        this.mPenType = null;
        this.mAdaptiveBgColor = SpenSettingUtil.getColor(context, C7932R.color.drawing_preview_adaptive_bg_color);
        this.mHasAdaptiveBackgroundColor = false;
        this.mRoundClipHelper = new SpenRoundClipHelper();
        SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
        spenGradientDrawableHelper.setDrawableInfo(0, 0, 0, 0);
        spenGradientDrawableHelper.setRectRadius(0.0f, 0.0f, 0.0f, 0.0f);
        GradientDrawable gradientDrawableMakeDrawable = spenGradientDrawableHelper.makeDrawable();
        this.mBgDrawable = gradientDrawableMakeDrawable;
        if (gradientDrawableMakeDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBgDrawable");
        } else {
            drawable = gradientDrawableMakeDrawable;
        }
        setBackground(drawable);
    }

    /* JADX INFO: renamed from: hasAdaptiveBackgroundColor, reason: from getter */
    public final boolean getMHasAdaptiveBackgroundColor() {
        return this.mHasAdaptiveBackgroundColor;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreview, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        SpenRoundClipHelper spenRoundClipHelper = this.mRoundClipHelper;
        if (spenRoundClipHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoundClipHelper");
            spenRoundClipHelper = null;
        }
        spenRoundClipHelper.applyRoundClip(canvas);
        super.onDraw(canvas);
    }

    public final void setParticleDensity(int density) {
        this.mDensity = density;
        SpenPreviewManager spenPreviewManager = this.mPreviewManager;
        if (spenPreviewManager != null) {
            spenPreviewManager.setDensity(density);
        }
    }

    public final void setPenInfo(@Nullable String penType, float strokeSize, int color, int particleDensity) {
        SpenPreviewManager spenPreviewManager;
        if (penType == null) {
            return;
        }
        setPenType(penType);
        setStrokeSize(strokeSize);
        setStrokeColor(color);
        setParticleDensity(particleDensity);
        if (!StringsKt.m14162r(penType, "Smudge") || (spenPreviewManager = this.mPreviewManager) == null) {
            return;
        }
        spenPreviewManager.setOverlappingBgResource(C7932R.drawable.note_smudge_bg);
    }

    public final void setPreviewHelper(@Nullable SpenPreviewHelper previewManager) {
        this.mPreviewHelper = previewManager;
    }

    public final void setRadius(float radius) {
        SpenRoundClipHelper spenRoundClipHelper = this.mRoundClipHelper;
        GradientDrawable gradientDrawable = null;
        if (spenRoundClipHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoundClipHelper");
            spenRoundClipHelper = null;
        }
        spenRoundClipHelper.setCorner(radius);
        GradientDrawable gradientDrawable2 = this.mBgDrawable;
        if (gradientDrawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBgDrawable");
        } else {
            gradientDrawable = gradientDrawable2;
        }
        gradientDrawable.setCornerRadius(radius);
    }

    public final void setStrokeAlpha(int alpha) {
        int i = (alpha << 24) | (this.mColor & 16777215);
        this.mColor = i;
        SpenPreviewManager spenPreviewManager = this.mPreviewManager;
        if (spenPreviewManager != null) {
            spenPreviewManager.setColor(i);
        }
    }

    public final void setStrokeColor(int color) {
        this.mColor = color;
        applyBackgroundColor();
        SpenPreviewManager spenPreviewManager = this.mPreviewManager;
        if (spenPreviewManager != null) {
            spenPreviewManager.setColor(this.mColor);
        }
    }
}
