package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAdaptiveColor;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u0018H\u0014J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\rH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialHandler;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mLabelText", "Landroid/widget/TextView;", "mColorView", "Landroid/widget/ImageView;", "mValue", "", "mColor", "mDiffRadius", "mAnimatorSet", "Landroid/animation/AnimatorSet;", "mLayoutSizeAnimator", "Landroid/animation/ValueAnimator;", "mColorAlphaAnimator", "mBgDrawableHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenGradientDrawableHelper;", "close", "", "setValue", "value", "setColor", "color", "startVisibilityAnimation", "isShow", "", "onFinishInflate", "initView", "updateThumbStroke", "updateThumbStrokeColor", "needOutline", "updateLabelText", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenCurvedDialHandler extends ConstraintLayout {
    private static final long COLOR_ALPHA_ANIMATION_DURATION = 200;
    private static final long LAYOUT_SIZE_HIDE_ANIMATION_DURATION = 350;
    private static final long LAYOUT_SIZE_SHOW_ANIMATION_DURATION = 400;

    @NotNull
    private static final String TAG = "SpenCurvedDialHandler";
    private static final long TEXT_ALPHA_HIDE_ANIMATION_DURATION = 100;
    private static final long TEXT_ALPHA_SHOW_ANIMATION_DURATION = 200;

    @Nullable
    private AnimatorSet mAnimatorSet;

    @NotNull
    private final SpenGradientDrawableHelper mBgDrawableHelper;
    private int mColor;

    @Nullable
    private ValueAnimator mColorAlphaAnimator;

    @Nullable
    private ImageView mColorView;
    private final int mDiffRadius;

    @Nullable
    private TextView mLabelText;

    @Nullable
    private ValueAnimator mLayoutSizeAnimator;
    private int mValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenCurvedDialHandler(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDiffRadius = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_attr_dial_handler_color_size_diff_radius);
        this.mBgDrawableHelper = new SpenGradientDrawableHelper();
    }

    private final void initView(Context context) {
        setLayoutDirection(0);
        TextView textView = (TextView) findViewById(C7932R.id.dial_handler_label_text);
        this.mLabelText = textView;
        SpenSettingUtilText.applyUpToLargeLevel(context, 14.0f, textView);
        ImageView imageView = (ImageView) findViewById(C7932R.id.dial_handler_color);
        this.mColorView = imageView;
        if (imageView != null) {
            this.mBgDrawableHelper.setDrawableInfo(1, 0, context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_unselected_outline_size), SpenSettingUtil.getColor(context, C7932R.color.setting_qt_curved_dial_handler_adaptive_outline_color));
            imageView.setBackground(this.mBgDrawableHelper.makeDrawable());
        }
        updateLabelText(this.mValue);
        updateThumbStroke(this.mValue);
        updateThumbStrokeColor(this.mColor);
    }

    private final boolean needOutline(int color) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return SpenSettingUtilAdaptiveColor.isAdaptiveColor(getContext(), color, !SpenSettingUtil.isNightMode(context) ? SpenSettingUtilAdaptiveColor.UseType.DECISION_COLOR_CHIP_OUTLINE : SpenSettingUtilAdaptiveColor.UseType.DECISION_THICKNESS_OUTLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVisibilityAnimation$lambda$0(SpenCurvedDialHandler spenCurvedDialHandler, int i, int i2, int i4, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        ViewGroup.LayoutParams layoutParams = spenCurvedDialHandler.getLayoutParams();
        layoutParams.width = i + ((int) (i2 * fFloatValue));
        spenCurvedDialHandler.setLayoutParams(layoutParams);
        spenCurvedDialHandler.setPadding((int) (i4 * fFloatValue), spenCurvedDialHandler.getPaddingTop(), spenCurvedDialHandler.getPaddingEnd(), spenCurvedDialHandler.getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVisibilityAnimation$lambda$1(SpenCurvedDialHandler spenCurvedDialHandler, ValueAnimator valueAnimator) {
        spenCurvedDialHandler.setBackgroundTintList(ColorStateList.valueOf(((Integer) AbstractC6670b.m4742c(valueAnimator, "animator", "null cannot be cast to non-null type kotlin.Int")).intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVisibilityAnimation$lambda$2(SpenCurvedDialHandler spenCurvedDialHandler, ValueAnimator valueAnimator) {
        spenCurvedDialHandler.updateThumbStrokeColor(((Integer) AbstractC6670b.m4742c(valueAnimator, "animator", "null cannot be cast to non-null type kotlin.Int")).intValue());
    }

    private final void updateLabelText(int value) {
        TextView textView = this.mLabelText;
        if (textView != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            textView.setText(AbstractC11014a.m12323h(new Object[]{Integer.valueOf(value)}, 1, Locale.getDefault(), TimeModel.NUMBER_FORMAT, "format(locale, format, *args)"));
        }
    }

    private final void updateThumbStroke(int value) {
        int i = (int) (((double) ((100 - value) * this.mDiffRadius)) * 0.01d);
        ImageView imageView = this.mColorView;
        if (imageView != null) {
            Intrinsics.checkNotNull(imageView);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(i, i, i, i);
            imageView.setLayoutParams(layoutParams2);
        }
    }

    private final void updateThumbStrokeColor(int color) {
        Drawable background;
        ImageView imageView = this.mColorView;
        if (imageView == null || (background = imageView.getBackground()) == null) {
            return;
        }
        SpenGradientDrawableHelper.INSTANCE.setColor(background, color);
        this.mBgDrawableHelper.setStroke(background, needOutline(color));
    }

    public final void close() {
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.mAnimatorSet = null;
        ValueAnimator valueAnimator = this.mLayoutSizeAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mLayoutSizeAnimator = null;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context);
    }

    public final void setColor(int color) {
        if (color == this.mColor) {
            return;
        }
        this.mColor = color;
    }

    public final void setValue(int value) {
        if (value == this.mValue) {
            return;
        }
        this.mValue = value;
        updateLabelText(value);
        updateThumbStroke(value);
    }

    public final void startVisibilityAnimation(boolean isShow) {
        AnimatorSet animatorSet;
        SpenCurvedDialHandler spenCurvedDialHandler;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        AnimatorSet animatorSet2 = this.mAnimatorSet;
        final int i = 1;
        if (animatorSet2 == null) {
            this.mAnimatorSet = new AnimatorSet();
        } else if (animatorSet2.isRunning() && (animatorSet = this.mAnimatorSet) != null) {
            animatorSet.cancel();
        }
        ValueAnimator valueAnimator3 = this.mLayoutSizeAnimator;
        if (valueAnimator3 != null && valueAnimator3.isRunning() && (valueAnimator2 = this.mLayoutSizeAnimator) != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator4 = this.mColorAlphaAnimator;
        if (valueAnimator4 != null && valueAnimator4.isRunning() && (valueAnimator = this.mColorAlphaAnimator) != null) {
            valueAnimator.cancel();
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C7932R.dimen.qt_curved_dial_handler_height);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C7932R.dimen.qt_curved_dial_handler_width) - dimensionPixelSize;
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(C7932R.dimen.qt_curved_dial_handler_start_padding);
        final int i2 = 0;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(isShow ? 0.0f : 1.0f, isShow ? 1.0f : 0.0f);
        this.mLayoutSizeAnimator = valueAnimatorOfFloat;
        if (valueAnimatorOfFloat != null) {
            valueAnimatorOfFloat.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        }
        ValueAnimator valueAnimator5 = this.mLayoutSizeAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.setDuration(isShow ? 400L : 350L);
        }
        ValueAnimator valueAnimator6 = this.mLayoutSizeAnimator;
        if (valueAnimator6 != null) {
            spenCurvedDialHandler = this;
            valueAnimator6.addUpdateListener(new C7650b(spenCurvedDialHandler, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, 0));
        } else {
            spenCurvedDialHandler = this;
        }
        ValueAnimator valueAnimator7 = spenCurvedDialHandler.mLayoutSizeAnimator;
        if (valueAnimator7 != null) {
            valueAnimator7.start();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(spenCurvedDialHandler.mLabelText, "alpha", isShow ? 0.0f : 1.0f, isShow ? 1.0f : 0.0f);
        int color = getResources().getColor(C7932R.color.setting_qt_swatch_bg_color, null);
        int color2 = getResources().getColor(C7932R.color.setting_qt_mini_btn_bg_color, null);
        ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        Integer numValueOf = Integer.valueOf(isShow ? color : color2);
        if (isShow) {
            color = color2;
        }
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(argbEvaluator, numValueOf, Integer.valueOf(color));
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.sdk.pen.setting.quicktool.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenCurvedDialHandler f5080b;

            {
                this.f5080b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator8) {
                switch (i2) {
                    case 0:
                        SpenCurvedDialHandler.startVisibilityAnimation$lambda$1(this.f5080b, valueAnimator8);
                        break;
                    default:
                        SpenCurvedDialHandler.startVisibilityAnimation$lambda$2(this.f5080b, valueAnimator8);
                        break;
                }
            }
        });
        int i4 = spenCurvedDialHandler.mColor;
        if (!isShow) {
            i4 |= -16777216;
        }
        ValueAnimator valueAnimatorOfObject2 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i4), Integer.valueOf(isShow ? (-16777216) | spenCurvedDialHandler.mColor : spenCurvedDialHandler.mColor));
        spenCurvedDialHandler.mColorAlphaAnimator = valueAnimatorOfObject2;
        if (valueAnimatorOfObject2 != null) {
            valueAnimatorOfObject2.setInterpolator(SpenSettingUtilAnimation.getInterpolator(15));
        }
        ValueAnimator valueAnimator8 = spenCurvedDialHandler.mColorAlphaAnimator;
        if (valueAnimator8 != null) {
            valueAnimator8.setDuration(200L);
        }
        ValueAnimator valueAnimator9 = spenCurvedDialHandler.mColorAlphaAnimator;
        if (valueAnimator9 != null) {
            valueAnimator9.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.sdk.pen.setting.quicktool.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SpenCurvedDialHandler f5080b;

                {
                    this.f5080b = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator82) {
                    switch (i) {
                        case 0:
                            SpenCurvedDialHandler.startVisibilityAnimation$lambda$1(this.f5080b, valueAnimator82);
                            break;
                        default:
                            SpenCurvedDialHandler.startVisibilityAnimation$lambda$2(this.f5080b, valueAnimator82);
                            break;
                    }
                }
            });
        }
        ValueAnimator valueAnimator10 = spenCurvedDialHandler.mColorAlphaAnimator;
        if (valueAnimator10 != null) {
            valueAnimator10.start();
        }
        float dimensionPixelSize4 = getResources().getDimensionPixelSize(C7932R.dimen.qt_curved_dial_handler_elevation);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "elevation", isShow ? 0.0f : dimensionPixelSize4, isShow ? dimensionPixelSize4 : 0.0f);
        AnimatorSet animatorSet3 = spenCurvedDialHandler.mAnimatorSet;
        if (animatorSet3 != null) {
            animatorSet3.setDuration(isShow ? 200L : 100L);
        }
        AnimatorSet animatorSet4 = spenCurvedDialHandler.mAnimatorSet;
        if (animatorSet4 != null) {
            animatorSet4.setInterpolator(SpenSettingUtilAnimation.getInterpolator(15));
        }
        AnimatorSet animatorSet5 = spenCurvedDialHandler.mAnimatorSet;
        if (animatorSet5 != null) {
            animatorSet5.playTogether(objectAnimatorOfFloat, valueAnimatorOfObject, objectAnimatorOfFloat2);
        }
        AnimatorSet animatorSet6 = spenCurvedDialHandler.mAnimatorSet;
        if (animatorSet6 != null) {
            animatorSet6.start();
        }
    }
}
