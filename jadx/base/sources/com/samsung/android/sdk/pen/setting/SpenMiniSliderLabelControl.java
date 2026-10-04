package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.SpenMiniPenAttributeControl;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0001\u0018\u0000 E2\u00020\u0001:\u0001EB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\u0006\u0010$\u001a\u00020\u001dJ\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0007J\b\u00102\u001a\u00020\u001dH\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u00104\u001a\u00020\u001dH\u0002J\b\u00105\u001a\u00020\u001dH\u0002J\u0012\u00106\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010;\u001a\u00020\u000bH\u0002J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\"H\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0007H\u0002J\u0010\u0010B\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0010\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00109\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010/R\u0014\u0010<\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010)¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniSliderLabelControl;", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenAttributeControl$OnSliderListener;", "context", "Landroid/content/Context;", "parent", "Landroid/widget/FrameLayout;", "parentOrientation", "", "<init>", "(Landroid/content/Context;Landroid/widget/FrameLayout;I)V", "mDisallowLabel", "", "mParent", "mLabelView", "Landroid/widget/TextView;", "mSlider", "Landroid/view/View;", "mSliderWidth", "mSliderOffset", "mLabelGravity", "mLabelMargin", "mIsAnimating", "mIsRTL", "mIsFixPositionLabel", "mParentOrientation", "mShowAnimationListener", "Landroid/view/animation/Animation$AnimationListener;", "mHideAnimationListener", "onLabelStateChanged", "", "slider", "state", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$OnSliderListener$LabelState;", "text", "", "onLabelChanged", "close", "setParentOrientation", "orientation", "disallowLabel", "isDisallowLabel", "()Z", "setDisallowLabel", "(Z)V", "gravity", "labelGravity", "getLabelGravity", "()I", "setLabelGravity", "(I)V", "cancelLabelAnimation", "updateLabel", "initLabelView", "destroyLabelView", "initLabelPosition", "getAddPositionValue", "view", "labelPositionOffset", "getLabelPositionOffset", "decideFixedPositionLabel", "isHorizontalSlider", "setLabelPosition", "label", "getPositionValue", "", "value", "adjustLabelGravity", "setLabelAnimation", "isShow", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag", "RtlHardcoded"})
public final class SpenMiniSliderLabelControl implements SpenMiniPenAttributeControl.OnSliderListener {
    private static final int HIDE_LABEL_DURATION = 100;
    private static final int SHOW_LABEL_DURATION = 200;

    @NotNull
    private static final String TAG = "SpenMiniSliderLabelControl";
    private boolean mDisallowLabel;

    @NotNull
    private final Animation.AnimationListener mHideAnimationListener;
    private boolean mIsAnimating;
    private boolean mIsFixPositionLabel;
    private final boolean mIsRTL;
    private int mLabelGravity;
    private final int mLabelMargin;

    @Nullable
    private TextView mLabelView;

    @Nullable
    private FrameLayout mParent;
    private int mParentOrientation;

    @NotNull
    private final Animation.AnimationListener mShowAnimationListener;

    @Nullable
    private View mSlider;
    private int mSliderOffset;
    private int mSliderWidth;

    public SpenMiniSliderLabelControl(@NotNull Context context, @Nullable FrameLayout frameLayout, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDisallowLabel = true;
        this.mLabelGravity = 5;
        this.mShowAnimationListener = new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.SpenMiniSliderLabelControl$mShowAnimationListener$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.mIsAnimating = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        };
        this.mHideAnimationListener = new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.SpenMiniSliderLabelControl$mHideAnimationListener$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Log.i("SpenMiniSliderLabelControl", "hideLabel::onAnimationEnd()");
                this.this$0.mIsAnimating = false;
                TextView textView = this.this$0.mLabelView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                TextView textView2 = this.this$0.mLabelView;
                if (textView2 != null) {
                    textView2.setAlpha(1.0f);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        };
        this.mParent = frameLayout;
        this.mParentOrientation = i;
        this.mLabelMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.mini_pen_setting_slider_big_label_margin);
        this.mIsRTL = AbstractC0541b.m759a(context) == 1;
    }

    private final void adjustLabelGravity(int gravity) {
        TextView textView = this.mLabelView;
        if (textView == null || this.mParent == null) {
            return;
        }
        int i = gravity == 3 ? this.mLabelMargin : 0;
        int i2 = gravity == 5 ? this.mLabelMargin : 0;
        int i4 = gravity == 48 ? this.mLabelMargin : 0;
        int i5 = gravity == 80 ? this.mLabelMargin : 0;
        ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = gravity;
        layoutParams2.setMargins(i, i4, i2, i5);
        TextView textView2 = this.mLabelView;
        if (textView2 != null) {
            textView2.setLayoutParams(layoutParams2);
        }
    }

    private final void cancelLabelAnimation() {
        Animation animation;
        TextView textView = this.mLabelView;
        if (textView == null || !this.mIsAnimating) {
            return;
        }
        if (textView != null && (animation = textView.getAnimation()) != null) {
            animation.cancel();
        }
        TextView textView2 = this.mLabelView;
        if (textView2 != null) {
            textView2.clearAnimation();
        }
    }

    private final boolean decideFixedPositionLabel() {
        if (isHorizontalSlider()) {
            int i = this.mLabelGravity;
            return i == 3 || i == 5;
        }
        int i2 = this.mLabelGravity;
        return i2 == 48 || i2 == 80;
    }

    private final void destroyLabelView() {
        TextView textView = this.mLabelView;
        if (textView == null) {
            return;
        }
        FrameLayout frameLayout = this.mParent;
        if (frameLayout != null) {
            frameLayout.removeView(textView);
        }
        this.mLabelView = null;
    }

    private final int getAddPositionValue(View view) {
        if (view == null) {
            return 0;
        }
        int i = this.mLabelGravity;
        return (i == 3 || i == 5) ? view.getTop() : view.getLeft();
    }

    private final int getLabelPositionOffset() {
        TextView textView = this.mLabelView;
        if (textView == null) {
            return 0;
        }
        int i = this.mLabelGravity;
        if (i == 48 || i == 80) {
            return (textView.getWidth() / 2) * (-1);
        }
        return 0;
    }

    private final float getPositionValue(int value) {
        if (this.mIsFixPositionLabel) {
            return 1.0f;
        }
        if (!isHorizontalSlider() || this.mIsRTL) {
            value = 100 - value;
        }
        return ((this.mSliderWidth * value) / 100) + this.mSliderOffset;
    }

    private final void initLabelPosition(View slider) {
        if (slider == null || this.mLabelView == null) {
            return;
        }
        View viewFindViewById = slider.findViewById(C7932R.id.seek_bar);
        this.mSlider = viewFindViewById;
        if (viewFindViewById == null) {
            this.mSlider = slider;
        }
        View view = this.mSlider;
        if (view != null) {
            this.mSliderWidth = view.getWidth() - (view.getPaddingRight() + view.getPaddingLeft());
            this.mSliderOffset = view.getPaddingLeft() + view.getLeft();
            while (slider != this.mParent) {
                this.mSliderOffset += getAddPositionValue(slider);
                Object parent = slider.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                slider = (View) parent;
            }
            this.mSliderOffset += getLabelPositionOffset();
            this.mIsFixPositionLabel = decideFixedPositionLabel();
        }
    }

    private final void initLabelView() {
        if (this.mLabelView != null) {
            return;
        }
        FrameLayout frameLayout = this.mParent;
        Context context = frameLayout != null ? frameLayout.getContext() : null;
        View viewInflate = LayoutInflater.from(context).inflate(C7932R.layout.setting_mini_slider_big_label, (ViewGroup) this.mParent, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewInflate;
        this.mLabelView = textView;
        SpenSettingUtilText.setTypeFace(context, SpenSettingUtilText.FontName.REGULAR, textView);
        FrameLayout frameLayout2 = this.mParent;
        if (frameLayout2 != null) {
            frameLayout2.addView(this.mLabelView);
        }
    }

    private final boolean isHorizontalSlider() {
        View view = this.mSlider;
        return view != null && view.getWidth() > view.getHeight() && (((int) view.getRotation()) / 90) % 2 == 0;
    }

    private final void setLabelAnimation(boolean isShow) {
        TextView textView;
        AbstractC4539a.m3208r("setLabelAnimation() isShow=", TAG, isShow);
        if (!isShow && (textView = this.mLabelView) != null && textView.getVisibility() == 8) {
            this.mIsAnimating = false;
            return;
        }
        TextView textView2 = this.mLabelView;
        if (textView2 != null) {
            textView2.setAlpha(1.0f);
        }
        this.mIsAnimating = true;
        if (!isShow) {
            SpenSettingUtilAnimation.alphaGoneAnimation(this.mLabelView, 15, 100L, this.mHideAnimationListener);
            return;
        }
        TextView textView3 = this.mLabelView;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        SpenSettingUtilAnimation.alphaVisibleAnimation(this.mLabelView, 15, 200L, this.mShowAnimationListener);
    }

    private final void setLabelPosition(String label) {
        try {
            if (StringsKt.m14167w(label, "%")) {
                label = label.substring(0, label.length() - 1);
                Intrinsics.checkNotNullExpressionValue(label, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            float positionValue = getPositionValue(Integer.parseInt(label));
            if (getMLabelGravity() == 3 || getMLabelGravity() == 5) {
                TextView textView = this.mLabelView;
                if (textView != null) {
                    textView.setY(positionValue);
                    return;
                }
                return;
            }
            TextView textView2 = this.mLabelView;
            if (textView2 != null) {
                textView2.setX(positionValue);
            }
        } catch (NumberFormatException unused) {
            Log.e(TAG, "setLabelPosition cannot get value from label");
        }
    }

    private final void updateLabel(String text) {
        TextView textView = this.mLabelView;
        if (textView == null) {
            return;
        }
        if (textView != null) {
            textView.setText(text);
        }
        setLabelPosition(text);
    }

    public final void close() {
        cancelLabelAnimation();
        this.mIsAnimating = false;
        this.mParent = null;
        this.mLabelView = null;
        this.mSlider = null;
    }

    /* JADX INFO: renamed from: getLabelGravity, reason: from getter */
    public final int getMLabelGravity() {
        return this.mLabelGravity;
    }

    /* JADX INFO: renamed from: isDisallowLabel, reason: from getter */
    public final boolean getMDisallowLabel() {
        return this.mDisallowLabel;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnSliderListener
    public void onLabelChanged(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (this.mDisallowLabel || this.mLabelView == null) {
            return;
        }
        updateLabel(text);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnSliderListener
    public void onLabelStateChanged(@Nullable View slider, @Nullable SpenPenAttrMiniLayout.OnSliderListener.LabelState state, @NotNull String text) {
        boolean z;
        Intrinsics.checkNotNullParameter(text, "text");
        if (this.mDisallowLabel || this.mLabelView == null) {
            return;
        }
        Log.i(TAG, "onLabelStateChanged() state=" + state);
        if (state == SpenPenAttrMiniLayout.OnSliderListener.LabelState.SHOW) {
            adjustLabelGravity(this.mLabelGravity);
            initLabelPosition(slider);
            updateLabel(text);
            z = true;
        } else {
            z = false;
        }
        setLabelAnimation(z);
    }

    public final void setDisallowLabel(boolean z) {
        AbstractC4539a.m3208r("setDisallowLabel() ", TAG, z);
        this.mDisallowLabel = z;
        if (z) {
            destroyLabelView();
        } else {
            initLabelView();
            adjustLabelGravity(this.mLabelGravity);
        }
    }

    public final void setLabelGravity(int i) {
        Log.i(TAG, AbstractC0622a.m1164j(this.mLabelGravity, i, "setLabelGravity() [", "->", "]"));
        if (this.mLabelGravity == i) {
            return;
        }
        if (i != 48 && i != 80 && i != 3 && i != 5) {
            AbstractC2322a.m1631u(i, "Not support gravity=", TAG);
        } else {
            this.mLabelGravity = i;
            adjustLabelGravity(i);
        }
    }

    public final void setParentOrientation(int orientation) {
        AbstractC6670b.m4744e(this.mParentOrientation, orientation, "setParentOrientation() [", " -> ", TAG);
        if (this.mParentOrientation == orientation) {
            return;
        }
        this.mParentOrientation = orientation;
        if (this.mDisallowLabel) {
            return;
        }
        cancelLabelAnimation();
        destroyLabelView();
        initLabelView();
        adjustLabelGravity(this.mLabelGravity);
    }
}
