package com.samsung.android.sdk.pen.setting.drawing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushSliderFactory;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0018\b\u0007\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0012H\u0016J\u0006\u0010&\u001a\u00020\"J\u0018\u0010'\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0006H\u0002J\b\u0010)\u001a\u00020\"H\u0002J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\"H\u0002J\u0010\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020\"H\u0002J\b\u00101\u001a\u00020\"H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushAttrSettingLayout;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushAttrSetting;", "context", "Landroid/content/Context;", "needSeekBarStroke", "", "<init>", "(Landroid/content/Context;Z)V", "mSizeSlider", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;", "mAlphaSlider", "mDensitySlider", "mChildUpdater", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenSettingChildUpdater;", "mAttrChangedListener", "Lcom/samsung/android/sdk/pen/setting/drawing/OnBrushAttrChangedListener;", "mCurrentPen", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "mPenSizeTrackListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnSliderTrackListener;", "mPenSizeButtonListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnSliderButtonListener;", "mPenSizeChangedListener", "com/samsung/android/sdk/pen/setting/drawing/SpenBrushAttrSettingLayout$mPenSizeChangedListener$1", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushAttrSettingLayout$mPenSizeChangedListener$1;", "mPenDensityChangedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnChangedListener;", "mPenDensityButtonListener", "mPenDensityTrackListener", "mPenAlphaChangeListener", "mPenAlphaTrackListener", "mPenAlphaButtonListener", "setAttributeChangedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPenInfo", "info", "close", "initView", "hasStroke", "setListener", "updateCurrentSizeLevel", "progress", "", "notifySizeChanged", "setSizeSliderThumbScaleAnimation", "isScaleDown", "notifyOpacityChanged", "notifyDensityChanged", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag", "ViewConstructor"})
public final class SpenBrushAttrSettingLayout extends FrameLayout implements SpenBrushAttrSetting {

    @NotNull
    private static final String TAG = "SpenBrushAttrSettingLayout";
    private SpenSlider mAlphaSlider;

    @Nullable
    private OnBrushAttrChangedListener mAttrChangedListener;
    private SpenBrushPenSettingChildUpdater mChildUpdater;

    @Nullable
    private SpenSettingUIPenInfo mCurrentPen;
    private SpenSlider mDensitySlider;

    @NotNull
    private final SpenSlider.OnSliderButtonListener mPenAlphaButtonListener;

    @NotNull
    private final SpenSlider.OnChangedListener mPenAlphaChangeListener;

    @NotNull
    private final SpenSlider.OnSliderTrackListener mPenAlphaTrackListener;

    @NotNull
    private final SpenSlider.OnSliderButtonListener mPenDensityButtonListener;

    @NotNull
    private final SpenSlider.OnChangedListener mPenDensityChangedListener;

    @NotNull
    private final SpenSlider.OnSliderTrackListener mPenDensityTrackListener;

    @NotNull
    private final SpenSlider.OnSliderButtonListener mPenSizeButtonListener;

    @NotNull
    private final SpenBrushAttrSettingLayout$mPenSizeChangedListener$1 mPenSizeChangedListener;

    @NotNull
    private final SpenSlider.OnSliderTrackListener mPenSizeTrackListener;
    private SpenSlider mSizeSlider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSettingLayout$mPenSizeChangedListener$1] */
    public SpenBrushAttrSettingLayout(@NotNull Context context, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPenSizeTrackListener = new SpenSlider.OnSliderTrackListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSettingLayout$mPenSizeTrackListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStopTrackingTouch() {
                this.this$0.notifySizeChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStartTrackingTouch() {
            }
        };
        this.mPenSizeButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSettingLayout$mPenSizeButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                this.this$0.notifySizeChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                this.this$0.notifySizeChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
            }
        };
        this.mPenSizeChangedListener = new SpenSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSettingLayout$mPenSizeChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnChangedListener
            public void onChanged(int value, boolean fromUser) {
                if (this.this$0.updateCurrentSizeLevel(value)) {
                    SpenBrushPenSettingChildUpdater spenBrushPenSettingChildUpdater = this.this$0.mChildUpdater;
                    if (spenBrushPenSettingChildUpdater == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChildUpdater");
                        spenBrushPenSettingChildUpdater = null;
                    }
                    SpenSettingUIPenInfo spenSettingUIPenInfo = this.this$0.mCurrentPen;
                    spenBrushPenSettingChildUpdater.setSizeLevel(spenSettingUIPenInfo != null ? spenSettingUIPenInfo.sizeLevel : 0);
                }
            }
        };
        this.mPenDensityChangedListener = new SpenSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSettingLayout$mPenDensityChangedListener$1
            private int beforeProgress = -1;

            public final int getBeforeProgress() {
                return this.beforeProgress;
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnChangedListener
            public void onChanged(int value, boolean fromUser) {
                if (this.this$0.mCurrentPen == null || this.beforeProgress == value) {
                    return;
                }
                this.beforeProgress = value;
                SpenSettingUIPenInfo spenSettingUIPenInfo = this.this$0.mCurrentPen;
                if (spenSettingUIPenInfo != null) {
                    spenSettingUIPenInfo.particleDensity = value;
                }
                SpenBrushPenSettingChildUpdater spenBrushPenSettingChildUpdater = this.this$0.mChildUpdater;
                if (spenBrushPenSettingChildUpdater == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChildUpdater");
                    spenBrushPenSettingChildUpdater = null;
                }
                SpenSettingUIPenInfo spenSettingUIPenInfo2 = this.this$0.mCurrentPen;
                spenBrushPenSettingChildUpdater.setParticleDensity(spenSettingUIPenInfo2 != null ? spenSettingUIPenInfo2.particleDensity : 0);
            }

            public final void setBeforeProgress(int i) {
                this.beforeProgress = i;
            }
        };
        this.mPenDensityButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSettingLayout$mPenDensityButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                this.this$0.notifyDensityChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                this.this$0.notifyDensityChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
            }
        };
        this.mPenDensityTrackListener = new SpenSlider.OnSliderTrackListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSettingLayout$mPenDensityTrackListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStopTrackingTouch() {
                this.this$0.notifyDensityChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStartTrackingTouch() {
            }
        };
        this.mPenAlphaChangeListener = new SpenSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSettingLayout$mPenAlphaChangeListener$1
            private int oldProgress = -1;

            public final int getOldProgress() {
                return this.oldProgress;
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnChangedListener
            public void onChanged(int value, boolean fromUser) {
                SpenSettingUIPenInfo spenSettingUIPenInfo;
                if (this.oldProgress == value || (spenSettingUIPenInfo = this.this$0.mCurrentPen) == null) {
                    return;
                }
                SpenBrushAttrSettingLayout spenBrushAttrSettingLayout = this.this$0;
                this.oldProgress = value;
                int iRoundToInt = MathKt.roundToInt((value * 255.0f) / 100.0f);
                spenSettingUIPenInfo.color = ((iRoundToInt << 24) & (-16777216)) | (spenSettingUIPenInfo.color & 16777215);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                AbstractC6670b.m4765z(new Object[]{Integer.valueOf(value), Integer.valueOf(spenSettingUIPenInfo.color)}, 2, "%d%% - #%08X", "format(format, *args)", "SpenBrushAttrSettingLayout");
                SpenBrushPenSettingChildUpdater spenBrushPenSettingChildUpdater = spenBrushAttrSettingLayout.mChildUpdater;
                if (spenBrushPenSettingChildUpdater == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChildUpdater");
                    spenBrushPenSettingChildUpdater = null;
                }
                spenBrushPenSettingChildUpdater.setAlpha(iRoundToInt);
            }

            public final void setOldProgress(int i) {
                this.oldProgress = i;
            }
        };
        this.mPenAlphaTrackListener = new SpenSlider.OnSliderTrackListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSettingLayout$mPenAlphaTrackListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStartTrackingTouch() {
                this.this$0.setSizeSliderThumbScaleAnimation(true);
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStopTrackingTouch() {
                this.this$0.setSizeSliderThumbScaleAnimation(false);
                this.this$0.notifyOpacityChanged();
            }
        };
        this.mPenAlphaButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSettingLayout$mPenAlphaButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                this.this$0.notifyOpacityChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                this.this$0.notifyOpacityChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
            }
        };
        initView(context, z);
        setListener();
    }

    private final void initView(Context context, boolean hasStroke) {
        Log.i(TAG, "initView");
        SpenSlider spenSlider = null;
        SpenBrushPenSettingChildUpdater spenBrushPenSettingChildUpdater = new SpenBrushPenSettingChildUpdater(context, null, 2, null);
        this.mChildUpdater = spenBrushPenSettingChildUpdater;
        spenBrushPenSettingChildUpdater.initView(this, C7932R.layout.setting_brush_attr_setting_layout);
        this.mSizeSlider = SpenBrushSliderFactory.createSlider(SpenBrushSliderFactory.SliderType.SIZE, context, hasStroke);
        this.mAlphaSlider = SpenBrushSliderFactory.createSlider(SpenBrushSliderFactory.SliderType.OPACITY, context, hasStroke);
        this.mDensitySlider = SpenBrushSliderFactory.createSlider(SpenBrushSliderFactory.SliderType.PARTICLE_DENSITY, context, hasStroke);
        SpenBrushPenSettingChildUpdater spenBrushPenSettingChildUpdater2 = this.mChildUpdater;
        if (spenBrushPenSettingChildUpdater2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChildUpdater");
            spenBrushPenSettingChildUpdater2 = null;
        }
        SpenSlider spenSlider2 = this.mSizeSlider;
        if (spenSlider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            spenSlider2 = null;
        }
        SpenSlider spenSlider3 = this.mAlphaSlider;
        if (spenSlider3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaSlider");
            spenSlider3 = null;
        }
        SpenSlider spenSlider4 = this.mDensitySlider;
        if (spenSlider4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDensitySlider");
        } else {
            spenSlider = spenSlider4;
        }
        spenBrushPenSettingChildUpdater2.setSliderView(spenSlider2, spenSlider3, spenSlider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyDensityChanged() {
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mCurrentPen;
        if (spenSettingUIPenInfo != null) {
            AbstractC2322a.m1631u(spenSettingUIPenInfo.particleDensity, "notifyDensityChanged() density=", TAG);
            OnBrushAttrChangedListener onBrushAttrChangedListener = this.mAttrChangedListener;
            if (onBrushAttrChangedListener != null) {
                onBrushAttrChangedListener.onDensityChanged(spenSettingUIPenInfo.particleDensity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyOpacityChanged() {
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mCurrentPen;
        if (spenSettingUIPenInfo != null) {
            AbstractC2322a.m1631u(spenSettingUIPenInfo.color, "notifyOpacityChanged() color=", TAG);
            OnBrushAttrChangedListener onBrushAttrChangedListener = this.mAttrChangedListener;
            if (onBrushAttrChangedListener != null) {
                onBrushAttrChangedListener.onOpacityChanged(spenSettingUIPenInfo.color);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySizeChanged() {
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mCurrentPen;
        if (spenSettingUIPenInfo != null) {
            Log.i(TAG, "notifySizeChanged() size=" + spenSettingUIPenInfo.size + " sizeLevel=" + spenSettingUIPenInfo.sizeLevel);
            OnBrushAttrChangedListener onBrushAttrChangedListener = this.mAttrChangedListener;
            if (onBrushAttrChangedListener != null) {
                onBrushAttrChangedListener.onSizeChanged(spenSettingUIPenInfo.size, spenSettingUIPenInfo.sizeLevel);
            }
        }
    }

    private final void setListener() {
        SpenSlider spenSlider = this.mSizeSlider;
        SpenSlider spenSlider2 = null;
        if (spenSlider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            spenSlider = null;
        }
        spenSlider.setOnChangedListener(this.mPenSizeChangedListener);
        spenSlider.setOnTrackListener(this.mPenSizeTrackListener);
        spenSlider.setOnMinusButtonActionListener(this.mPenSizeButtonListener);
        spenSlider.setOnPlusButtonActionListener(this.mPenSizeButtonListener);
        SpenSlider spenSlider3 = this.mSizeSlider;
        if (spenSlider3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            spenSlider3 = null;
        }
        spenSlider3.setOnChangedListener(this.mPenSizeChangedListener);
        spenSlider3.setOnTrackListener(this.mPenSizeTrackListener);
        spenSlider3.setOnMinusButtonActionListener(this.mPenSizeButtonListener);
        spenSlider3.setOnPlusButtonActionListener(this.mPenSizeButtonListener);
        SpenSlider spenSlider4 = this.mAlphaSlider;
        if (spenSlider4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaSlider");
            spenSlider4 = null;
        }
        spenSlider4.setOnChangedListener(this.mPenAlphaChangeListener);
        spenSlider4.setOnTrackListener(this.mPenAlphaTrackListener);
        spenSlider4.setOnMinusButtonActionListener(this.mPenAlphaButtonListener);
        spenSlider4.setOnPlusButtonActionListener(this.mPenAlphaButtonListener);
        SpenSlider spenSlider5 = this.mDensitySlider;
        if (spenSlider5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDensitySlider");
        } else {
            spenSlider2 = spenSlider5;
        }
        spenSlider2.setOnChangedListener(this.mPenDensityChangedListener);
        spenSlider2.setOnTrackListener(this.mPenDensityTrackListener);
        spenSlider2.setOnMinusButtonActionListener(this.mPenDensityButtonListener);
        spenSlider2.setOnPlusButtonActionListener(this.mPenDensityButtonListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSizeSliderThumbScaleAnimation(boolean isScaleDown) {
        SpenSlider spenSlider = this.mSizeSlider;
        if (spenSlider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            spenSlider = null;
        }
        spenSlider.setThumbScaleAnimation(isScaleDown);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean updateCurrentSizeLevel(int progress) {
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mCurrentPen;
        if (spenSettingUIPenInfo == null) {
            return false;
        }
        spenSettingUIPenInfo.sizeLevel = RangesKt.coerceAtLeast(1, RangesKt.coerceAtMost(progress, 100));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        float fConvertSizeLevelToDpSize = SpenPenUtil.convertSizeLevelToDpSize(context, spenSettingUIPenInfo.name, spenSettingUIPenInfo.sizeLevel);
        spenSettingUIPenInfo.size = fConvertSizeLevelToDpSize;
        AbstractC2821a.m2206A(AbstractC0622a.m1173s(progress, spenSettingUIPenInfo.sizeLevel, "updateCurrentSizeLevel() progress=", " sizeLevel =", "size="), TAG, fConvertSizeLevelToDpSize);
        return true;
    }

    public final void close() {
        SpenSlider spenSlider = null;
        this.mAttrChangedListener = null;
        SpenBrushPenSettingChildUpdater spenBrushPenSettingChildUpdater = this.mChildUpdater;
        if (spenBrushPenSettingChildUpdater == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChildUpdater");
            spenBrushPenSettingChildUpdater = null;
        }
        spenBrushPenSettingChildUpdater.close();
        SpenSlider spenSlider2 = this.mSizeSlider;
        if (spenSlider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            spenSlider2 = null;
        }
        spenSlider2.close();
        SpenSlider spenSlider3 = this.mAlphaSlider;
        if (spenSlider3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaSlider");
            spenSlider3 = null;
        }
        spenSlider3.close();
        SpenSlider spenSlider4 = this.mDensitySlider;
        if (spenSlider4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDensitySlider");
        } else {
            spenSlider = spenSlider4;
        }
        spenSlider.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSetting
    public void setAttributeChangedListener(@Nullable OnBrushAttrChangedListener listener) {
        this.mAttrChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSetting
    public void setPenInfo(@NotNull SpenSettingUIPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Log.i(TAG, "setPenInfo()");
        AbstractC6670b.m4756q("setPenInfo name=", info.name, TAG);
        int i = info.color;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC11014a.m12328m(i, "setPenInfo color=", AbstractC2322a.m1624n(" %08X", new Object[]{Integer.valueOf(i)}, 1, "format(format, *args)"), TAG);
        AbstractC4539a.m3205o("setPenInfo size=", TAG, info.size);
        AbstractC2322a.m1631u(info.sizeLevel, "setPenInfo sizeLevel=", TAG);
        AbstractC4539a.m3208r("setPenInfo isEraserEnabled=", TAG, info.isEraserEnabled);
        AbstractC2322a.m1631u(info.particleDensity, "setPenInfo particleDensity=", TAG);
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mCurrentPen;
        if (spenSettingUIPenInfo == null) {
            this.mCurrentPen = new SpenSettingUIPenInfo(info);
        } else if (spenSettingUIPenInfo != null) {
            spenSettingUIPenInfo.name = info.name;
            spenSettingUIPenInfo.size = info.size;
            spenSettingUIPenInfo.sizeLevel = info.sizeLevel;
            spenSettingUIPenInfo.color = info.color;
            System.arraycopy(info.hsv, 0, spenSettingUIPenInfo.hsv, 0, 3);
            spenSettingUIPenInfo.colorUIInfo = info.colorUIInfo;
            spenSettingUIPenInfo.isEraserEnabled = info.isEraserEnabled;
            spenSettingUIPenInfo.particleDensity = info.particleDensity;
        }
        SpenSettingUIPenInfo spenSettingUIPenInfo2 = this.mCurrentPen;
        if (spenSettingUIPenInfo2 != null) {
            updateCurrentSizeLevel(spenSettingUIPenInfo2.sizeLevel);
            SpenBrushPenSettingChildUpdater spenBrushPenSettingChildUpdater = this.mChildUpdater;
            if (spenBrushPenSettingChildUpdater == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChildUpdater");
                spenBrushPenSettingChildUpdater = null;
            }
            spenBrushPenSettingChildUpdater.setPenInfo(spenSettingUIPenInfo2.name, spenSettingUIPenInfo2.sizeLevel, spenSettingUIPenInfo2.color, spenSettingUIPenInfo2.particleDensity);
        }
    }
}
