package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.collection.AbstractC0622a;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSimpleChipView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.util.color.SpenColorThemeUtil;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerViewCore;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorPickerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.animation.QTAnimationKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017*\u0002\u001b\u001e\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010J\u001e\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u0005J\u0010\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\u0015J\u0010\u0010.\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\u0017J\u0010\u0010/\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\u0019J\u000e\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020#J\u0010\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\u0010H\u0002J\u0018\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0002J\b\u00107\u001a\u00020!H\u0002J\u0010\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0002J\u0018\u0010:\u001a\u00020!2\u0006\u00109\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005H\u0002J\b\u0010<\u001a\u00020!H\u0002J\b\u0010=\u001a\u00020!H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerViewCore;", "", "context", "Landroid/content/Context;", "hsvColor", "", "<init>", "(Landroid/content/Context;[F)V", "mColorTheme", "Lcom/samsung/android/sdk/pen/util/color/SpenColorThemeUtil;", "mHsv", "mPickerView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView;", "mCurrentColorView", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSimpleChipView;", "mCenterRadius", "", "mScaleXAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mScaleYAnimator", "mActionListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorPickerLayout$ActionListener;", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerDataChangedListener;", "mAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerViewCore$AnimationListener;", "mOnColorChangedListener", "com/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerViewCore$mOnColorChangedListener$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerViewCore$mOnColorChangedListener$1;", "mOnPickerViewActionListener", "com/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerViewCore$mOnPickerViewActionListener$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerViewCore$mOnPickerViewActionListener$1;", "close", "", "setColorTheme", "", BaseWidgetConstant.WIDGET_THEME, "initPickerView", "pickerView", "currentColorView", "colorPreviewContainer", "Landroid/view/View;", "setCurrentColor", "hsv", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDataChangedListener", "setAnimationListener", "startAnimation", "isShow", "updateView", "target", "copyToColor", "src", "dest", "notifyColorChanged", "getThemeColor", "color", "colorToThemeColor", "themeColor", "startAnimationShow", "startAnimationHide", "Companion", "AnimationListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nQTColorPickerViewCore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QTColorPickerViewCore.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerViewCore\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n1#2:226\n*E\n"})
public final class QTColorPickerViewCore {
    public static final long ANIMATION_DELAY = 200;
    private static final float DAMPING_RATIO = 0.75f;
    private static final int HSV_COLOR_SIZE = 3;
    private static final float STIFFNESS = 300.0f;

    @NotNull
    private static final String TAG = "QTColorPickerViewCore";
    private static final int UPDATE_ALL = 7;
    private static final int UPDATE_NEW_COLOR = 2;
    private static final int UPDATE_OLD_COLOR = 1;
    private static final int UPDATE_PICKER = 4;

    @Nullable
    private SettingQTColorPickerLayout.ActionListener mActionListener;

    @Nullable
    private AnimationListener mAnimationListener;
    private int mCenterRadius;

    @NotNull
    private SpenColorThemeUtil mColorTheme;
    private SpenSimpleChipView mCurrentColorView;

    @Nullable
    private SpenColorPickerDataChangedListener mDataChangedListener;

    @NotNull
    private float[] mHsv;

    @NotNull
    private final QTColorPickerViewCore$mOnColorChangedListener$1 mOnColorChangedListener;

    @NotNull
    private final QTColorPickerViewCore$mOnPickerViewActionListener$1 mOnPickerViewActionListener;

    @Nullable
    private QTColorPickerView mPickerView;

    @Nullable
    private SpringAnimation mScaleXAnimator;

    @Nullable
    private SpringAnimation mScaleYAnimator;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerViewCore$AnimationListener;", "", "onAnimationEnd", "", "isShowAnimation", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface AnimationListener {
        void onAnimationEnd(boolean isShowAnimation);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerViewCore$mOnColorChangedListener$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerViewCore$mOnPickerViewActionListener$1] */
    public QTColorPickerViewCore(@NotNull Context context, @NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        this.mColorTheme = new SpenColorThemeUtil(context);
        this.mHsv = new float[3];
        this.mOnColorChangedListener = new QTColorPickerView.OnColorChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerViewCore$mOnColorChangedListener$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView.OnColorChangedListener
            public void onColorChanged(float[] hsvColor2) {
                Intrinsics.checkNotNullParameter(hsvColor2, "hsvColor");
                float[] themeColor = this.this$0.getThemeColor(hsvColor2);
                QTColorPickerViewCore qTColorPickerViewCore = this.this$0;
                qTColorPickerViewCore.copyToColor(themeColor, qTColorPickerViewCore.mHsv);
                this.this$0.updateView(2);
            }
        };
        this.mOnPickerViewActionListener = new QTColorPickerView.OnActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerViewCore$mOnPickerViewActionListener$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView.OnActionListener
            public void onBrightnessPressed() {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView.OnActionListener
            public void onBrightnessReleased() {
                this.this$0.notifyColorChanged();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView.OnActionListener
            public void onHuePressed() {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView.OnActionListener
            public void onHueReleased() {
                this.this$0.notifyColorChanged();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView.OnActionListener
            public void onSaturationPressed() {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView.OnActionListener
            public void onSaturationReleased() {
                this.this$0.notifyColorChanged();
            }
        };
        copyToColor(hsvColor, this.mHsv);
        this.mCenterRadius = context.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_color_picker_current_color_size);
    }

    private final void colorToThemeColor(float[] color, float[] themeColor) {
        if (this.mColorTheme.getColorTheme() != 1) {
            copyToColor(color, themeColor);
        } else {
            Color.colorToHSV(this.mColorTheme.getColor(SpenSettingUtil.HSVToColor(color)), themeColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void copyToColor(float[] src, float[] dest) {
        AbstractC14516b.m15114b(src.length, dest.length, "src=", " dest=", TAG);
        System.arraycopy(src, 0, dest, 0, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float[] getThemeColor(float[] color) {
        float[] fArr = new float[3];
        colorToThemeColor(color, fArr);
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPickerView$lambda$0(QTColorPickerViewCore qTColorPickerViewCore, View view) {
        SettingQTColorPickerLayout.ActionListener actionListener = qTColorPickerViewCore.mActionListener;
        if (actionListener != null) {
            actionListener.onColorTap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyColorChanged() {
        SpenColorPickerDataChangedListener spenColorPickerDataChangedListener = this.mDataChangedListener;
        if (spenColorPickerDataChangedListener != null) {
            spenColorPickerDataChangedListener.onColorChanged(SpenSettingUtil.HSVToColor(this.mHsv), this.mHsv);
        }
    }

    private final void startAnimationHide() {
        final SpringAnimation springAnimation = this.mScaleXAnimator;
        if (springAnimation != null) {
            springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerViewCore$startAnimationHide$1$1
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                public void onAnimationEnd(DynamicAnimation<?> animation, boolean canceled, float value, float velocity) {
                    QTColorPickerViewCore.AnimationListener animationListener = this.this$0.mAnimationListener;
                    if (animationListener != null) {
                        animationListener.onAnimationEnd(false);
                    }
                    springAnimation.removeEndListener(this);
                }
            });
            springAnimation.animateToFinalPosition(0.8f);
        }
        SpringAnimation springAnimation2 = this.mScaleYAnimator;
        if (springAnimation2 != null) {
            springAnimation2.animateToFinalPosition(0.8f);
        }
        SpenSimpleChipView spenSimpleChipView = this.mCurrentColorView;
        SpenSimpleChipView spenSimpleChipView2 = null;
        if (spenSimpleChipView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
            spenSimpleChipView = null;
        }
        spenSimpleChipView.animate().cancel();
        SpenSimpleChipView spenSimpleChipView3 = this.mCurrentColorView;
        if (spenSimpleChipView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
        } else {
            spenSimpleChipView2 = spenSimpleChipView3;
        }
        spenSimpleChipView2.animate().alpha(0.0f).setDuration(100L).setInterpolator(new LinearInterpolator()).start();
    }

    private final void startAnimationShow() {
        SpenSimpleChipView spenSimpleChipView = this.mCurrentColorView;
        SpenSimpleChipView spenSimpleChipView2 = null;
        if (spenSimpleChipView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
            spenSimpleChipView = null;
        }
        spenSimpleChipView.animate().cancel();
        SpenSimpleChipView spenSimpleChipView3 = this.mCurrentColorView;
        if (spenSimpleChipView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
            spenSimpleChipView3 = null;
        }
        spenSimpleChipView3.setAlpha(0.0f);
        SpenSimpleChipView spenSimpleChipView4 = this.mCurrentColorView;
        if (spenSimpleChipView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
            spenSimpleChipView4 = null;
        }
        spenSimpleChipView4.setScaleX(0.0f);
        SpenSimpleChipView spenSimpleChipView5 = this.mCurrentColorView;
        if (spenSimpleChipView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
            spenSimpleChipView5 = null;
        }
        spenSimpleChipView5.setScaleY(0.0f);
        SpenSimpleChipView spenSimpleChipView6 = this.mCurrentColorView;
        if (spenSimpleChipView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
            spenSimpleChipView6 = null;
        }
        spenSimpleChipView6.animate().alpha(1.0f).setDuration(200L).setInterpolator(new LinearInterpolator()).start();
        SpenSimpleChipView spenSimpleChipView7 = this.mCurrentColorView;
        if (spenSimpleChipView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
        } else {
            spenSimpleChipView2 = spenSimpleChipView7;
        }
        spenSimpleChipView2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(QTAnimationKt.getOneEasing()).start();
        SpringAnimation springAnimation = this.mScaleXAnimator;
        if (springAnimation != null) {
            springAnimation.animateToFinalPosition(1.0f);
        }
        SpringAnimation springAnimation2 = this.mScaleYAnimator;
        if (springAnimation2 != null) {
            springAnimation2.animateToFinalPosition(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateView(int target) {
        QTColorPickerView qTColorPickerView;
        float[] themeColor = getThemeColor(this.mHsv);
        if ((target & 2) == 2) {
            SpenSimpleChipView spenSimpleChipView = this.mCurrentColorView;
            if (spenSimpleChipView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
                spenSimpleChipView = null;
            }
            spenSimpleChipView.setColor(SpenSettingUtil.HSVToColor(themeColor));
        }
        if ((target & 4) != 4 || (qTColorPickerView = this.mPickerView) == null) {
            return;
        }
        qTColorPickerView.setPositionByColor(themeColor);
    }

    public final void close() {
        Logger.m11003i(TAG, "close()");
        this.mPickerView = null;
        this.mActionListener = null;
        this.mDataChangedListener = null;
        this.mColorTheme.close();
        this.mAnimationListener = null;
    }

    public final void initPickerView(@NotNull QTColorPickerView pickerView, @NotNull SpenSimpleChipView currentColorView, @NotNull View colorPreviewContainer) {
        Intrinsics.checkNotNullParameter(pickerView, "pickerView");
        Intrinsics.checkNotNullParameter(currentColorView, "currentColorView");
        Intrinsics.checkNotNullParameter(colorPreviewContainer, "colorPreviewContainer");
        pickerView.setOnColorChangedListener(this.mOnColorChangedListener);
        pickerView.setOnPickerActionListener(this.mOnPickerViewActionListener);
        this.mPickerView = pickerView;
        pickerView.setAnimationListener(new QTColorPickerView.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerViewCore.initPickerView.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView.AnimationListener
            public void onAnimationEnd(boolean isShowAnimation) {
                AnimationListener animationListener;
                if (!isShowAnimation || (animationListener = QTColorPickerViewCore.this.mAnimationListener) == null) {
                    return;
                }
                animationListener.onAnimationEnd(true);
            }
        });
        colorPreviewContainer.setScaleX(0.8f);
        colorPreviewContainer.setScaleY(0.8f);
        SpringForce stiffness = new SpringForce().setDampingRatio(0.75f).setStiffness(300.0f);
        this.mScaleXAnimator = new SpringAnimation(colorPreviewContainer, DynamicAnimation.SCALE_X).setSpring(stiffness);
        this.mScaleYAnimator = new SpringAnimation(colorPreviewContainer, DynamicAnimation.SCALE_Y).setSpring(stiffness);
        this.mCurrentColorView = currentColorView;
        if (currentColorView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentColorView");
            currentColorView = null;
        }
        currentColorView.setOnClickListener(new ViewOnClickListenerC8556a(this, 20));
        updateView(7);
    }

    public final void setActionListener(@Nullable SettingQTColorPickerLayout.ActionListener listener) {
        this.mActionListener = listener;
    }

    public final void setAnimationListener(@Nullable AnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final boolean setColorTheme(int theme) {
        AbstractC8014b.m7217s(theme, "setColorTheme() theme=", TAG);
        if (this.mColorTheme.getColorTheme() == theme) {
            return false;
        }
        this.mColorTheme.setColorTheme(theme);
        updateView(7);
        return true;
    }

    public final void setCurrentColor(@NotNull float[] hsv) {
        Intrinsics.checkNotNullParameter(hsv, "hsv");
        if (hsv.length != 3) {
            throw new IllegalArgumentException("hsv should be length = 3");
        }
        float f = hsv[0];
        float f4 = hsv[1];
        float f5 = hsv[2];
        StringBuilder sbM1176v = AbstractC0622a.m1176v("setCurrentColor() h=", f, ", s=", f4, ", v=");
        sbM1176v.append(f5);
        Logger.m11003i(TAG, sbM1176v.toString());
        copyToColor(hsv, this.mHsv);
        updateView(7);
    }

    public final void setDataChangedListener(@Nullable SpenColorPickerDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    public final void startAnimation(boolean isShow) {
        if (isShow) {
            startAnimationShow();
        } else {
            startAnimationHide();
        }
        QTColorPickerView qTColorPickerView = this.mPickerView;
        if (qTColorPickerView != null) {
            qTColorPickerView.startAnimation(isShow);
        }
    }
}
