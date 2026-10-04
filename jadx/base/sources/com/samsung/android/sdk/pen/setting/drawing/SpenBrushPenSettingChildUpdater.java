package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.view.View;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 62\u00020\u0001:\u00016B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011J(\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\tJ\u000e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\tJ\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u001a\u0010&\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0002J \u0010+\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u001a\u0010,\u001a\u0004\u0018\u00010\u000b2\u0006\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\tH\u0002J\u0010\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020*H\u0002J\u0010\u00101\u001a\u00020*2\u0006\u00100\u001a\u00020*H\u0002J \u00102\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0012\u0010-\u001a\u00020*2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u00103\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0002J\u001a\u00104\u001a\u0002052\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenSettingChildUpdater;", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenSettingChild;", "context", "Landroid/content/Context;", "mBrushManager", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushManager;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushManager;)V", "mEraserColor", "", "mColorStrategy", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenUIColorStrategy;", "mPreviewControl", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenUIPreviewControl;", "mPenName", "", "mSizeSlider", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;", "mAlphaSlider", "mParticleDensitySlider", "mAlphaSliderTopMargin", "close", "", "setSliderView", "sizeSlider", "alphaSlider", "particleDensitySlider", "setPenInfo", "penName", "sizeLevel", "color", "particleDensity", "setSizeLevel", "setAlpha", "alpha", "setParticleDensity", "density", "updateSliderVisibility", "setSliderVisibility", "slider", "Landroid/view/View;", "isSupport", "", "updateSliderValue", "getColorStrategy", "hasFixedSliderColor", "sliderColor", "updatePreviewType", "isEraser", "needToChangePreviewControl", "updatePreview", "getFixedSliderColor", "getStrokeSize", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushPenSettingChildUpdater extends SpenBrushPenSettingChild {

    @NotNull
    private static final String ERASER = "Eraser";

    @NotNull
    private static final String PENCIL = "Pencil";

    @NotNull
    private static final String SMUDGE = "Smudge";
    private static final long SMUDGE_COLOR = 4285953654L;

    @NotNull
    private static final String TAG = "SpenBrushPenSettingLayoutUpdater";

    @Nullable
    private SpenSlider mAlphaSlider;
    private final int mAlphaSliderTopMargin;

    @Nullable
    private SpenBrushManager mBrushManager;

    @Nullable
    private SpenUIColorStrategy mColorStrategy;
    private final int mEraserColor;

    @Nullable
    private SpenSlider mParticleDensitySlider;

    @Nullable
    private String mPenName;

    @Nullable
    private SpenUIPreviewControl mPreviewControl;

    @Nullable
    private SpenSlider mSizeSlider;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SpenBrushPenSettingChildUpdater(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final SpenUIColorStrategy getColorStrategy(boolean hasFixedSliderColor, int sliderColor) {
        if (this.mSizeSlider == null || this.mAlphaSlider == null || this.mParticleDensitySlider == null) {
            return null;
        }
        if (!hasFixedSliderColor) {
            return new SpenAdaptiveColorStrategy(this.mSizeSlider, this.mAlphaSlider, this.mParticleDensitySlider);
        }
        SpenFixedColorStrategy spenFixedColorStrategy = new SpenFixedColorStrategy(this.mSizeSlider, this.mAlphaSlider, this.mParticleDensitySlider);
        spenFixedColorStrategy.setFixedColor(sliderColor);
        return spenFixedColorStrategy;
    }

    private final int getFixedSliderColor(String penName) {
        if (penName == null) {
            return -1;
        }
        return StringsKt.m14162r(penName, ERASER) ? this.mEraserColor : StringsKt.m14162r(penName, SMUDGE) ? -9013642 : -1;
    }

    private final float getStrokeSize(String penName, int sizeLevel) {
        if (penName == null || getContext() == null) {
            return 0.0f;
        }
        return SpenPenUtil.convertSizeLevelToDpSize(getContext(), penName, sizeLevel);
    }

    private final boolean hasFixedSliderColor(String penName) {
        if (penName != null) {
            return StringsKt.m14162r(penName, ERASER) || StringsKt.m14162r(penName, SMUDGE);
        }
        return false;
    }

    private final boolean needToChangePreviewControl(boolean isEraser) {
        SpenUIPreviewControl spenUIPreviewControl = this.mPreviewControl;
        if (spenUIPreviewControl == null) {
            return true;
        }
        if (isEraser || !(spenUIPreviewControl instanceof SpenBrushPreviewController)) {
            return (isEraser && (spenUIPreviewControl instanceof SpenBrushEraserPreviewController)) ? false : true;
        }
        return false;
    }

    private final void setSliderVisibility(View slider, boolean isSupport) {
        if (slider != null) {
            slider.setVisibility(isSupport ? 0 : 8);
        }
    }

    private final void updatePreview(int sizeLevel, int color, int particleDensity) {
        SpenUIPreviewControl spenUIPreviewControl = this.mPreviewControl;
        if (spenUIPreviewControl != null) {
            String str = this.mPenName;
            spenUIPreviewControl.setPenInfo(str, getStrokeSize(str, sizeLevel), color, particleDensity);
            setDividerVisibility(spenUIPreviewControl.hasAdaptiveBackgroundColor() ? 4 : 0);
        }
    }

    private final void updatePreviewType(boolean isEraser) {
        SpenUIPreviewControl spenBrushEraserPreviewController;
        if (needToChangePreviewControl(isEraser)) {
            SpenUIPreviewControl spenUIPreviewControl = this.mPreviewControl;
            if (spenUIPreviewControl != null) {
                spenUIPreviewControl.release();
            }
            this.mPreviewControl = null;
            if (isEraser) {
                Context context = getContext();
                Intrinsics.checkNotNull(context);
                spenBrushEraserPreviewController = new SpenBrushEraserPreviewController(context);
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNull(context2);
                spenBrushEraserPreviewController = new SpenBrushPreviewController(context2);
            }
            this.mPreviewControl = spenBrushEraserPreviewController;
            setPreview(spenBrushEraserPreviewController.makePreview(getContext()));
        }
    }

    private final void updateSliderValue(int sizeLevel, int color, int particleDensity) {
        SpenUIColorStrategy colorStrategy = getColorStrategy(hasFixedSliderColor(this.mPenName), getFixedSliderColor(this.mPenName));
        this.mColorStrategy = colorStrategy;
        if (colorStrategy != null) {
            colorStrategy.setPenInfo(color, sizeLevel, particleDensity);
        }
    }

    private final void updateSliderVisibility(String penName) {
        SpenBrushManager spenBrushManager = this.mBrushManager;
        if (spenBrushManager != null) {
            setSliderVisibility(this.mSizeSlider, spenBrushManager.isSupportSize(penName));
            setSliderVisibility(this.mAlphaSlider, spenBrushManager.hasAlphaValue(penName) && !StringsKt.m14162r(penName, PENCIL));
            setSliderVisibility(this.mParticleDensitySlider, spenBrushManager.isSupportParticleDensity(penName));
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingChild
    public void close() {
        SpenBrushManager spenBrushManager = this.mBrushManager;
        if (spenBrushManager != null) {
            spenBrushManager.close();
        }
        this.mBrushManager = null;
        SpenUIPreviewControl spenUIPreviewControl = this.mPreviewControl;
        if (spenUIPreviewControl != null) {
            spenUIPreviewControl.release();
        }
        this.mPreviewControl = null;
        super.close();
    }

    public final void setAlpha(int alpha) {
        SpenUIColorStrategy spenUIColorStrategy = this.mColorStrategy;
        if (spenUIColorStrategy != null) {
            spenUIColorStrategy.updateAlpha(alpha);
        }
        SpenUIPreviewControl spenUIPreviewControl = this.mPreviewControl;
        if (spenUIPreviewControl != null) {
            spenUIPreviewControl.setAlpha(alpha);
        }
    }

    public final void setParticleDensity(int density) {
        SpenUIPreviewControl spenUIPreviewControl = this.mPreviewControl;
        if (spenUIPreviewControl != null) {
            spenUIPreviewControl.setParticleDensity(density);
        }
    }

    public final void setPenInfo(@Nullable String penName, int sizeLevel, int color, int particleDensity) {
        if (this.mBrushManager == null || penName == null) {
            return;
        }
        this.mPenName = penName;
        updateSliderVisibility(penName);
        updateSliderValue(sizeLevel, color, particleDensity);
        updatePreviewType(StringsKt.m14162r(penName, ERASER));
        updatePreview(sizeLevel, color, particleDensity);
        rearrange();
    }

    public final void setSizeLevel(int sizeLevel) {
        SpenUIPreviewControl spenUIPreviewControl = this.mPreviewControl;
        if (spenUIPreviewControl != null) {
            spenUIPreviewControl.setSize(getStrokeSize(this.mPenName, sizeLevel));
        }
    }

    public final void setSliderView(@Nullable SpenSlider sizeSlider, @Nullable SpenSlider alphaSlider, @Nullable SpenSlider particleDensitySlider) {
        clearSliderGroup();
        addSliderView(sizeSlider, 0);
        addSliderView(alphaSlider, this.mAlphaSliderTopMargin);
        addSliderView(particleDensitySlider, 0);
        this.mSizeSlider = sizeSlider;
        this.mAlphaSlider = alphaSlider;
        this.mParticleDensitySlider = particleDensitySlider;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenBrushPenSettingChildUpdater(@NotNull Context context, @Nullable SpenBrushManager spenBrushManager) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBrushManager = spenBrushManager;
        this.mEraserColor = SpenSettingUtil.getColor(context, C7932R.color.setting_brush_eraser_color);
        this.mAlphaSliderTopMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.drawing_brush_setting_popup_opacity_top_margin);
    }

    public /* synthetic */ SpenBrushPenSettingChildUpdater(Context context, SpenBrushManager spenBrushManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new SpenBrushManager(context) : spenBrushManager);
    }
}
