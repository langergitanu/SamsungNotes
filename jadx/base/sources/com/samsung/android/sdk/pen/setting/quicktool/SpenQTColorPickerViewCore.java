package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerViewCore;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorPickerLayout;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilColor;
import com.samsung.android.sdk.pen.util.color.SpenColorThemeUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018*\u0002'*\b\u0010\u0018\u0000 ]2\u00020\u0001:\u0002]^B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0015J&\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u0013J\u000e\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020\u0005J\u000e\u00108\u001a\u00020/2\u0006\u00107\u001a\u00020\u0005J\u0010\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010!J\u0010\u0010;\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010#J\u0010\u0010<\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010%J\u000e\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020/J0\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020B2\u0006\u0010E\u001a\u00020BH\u0002J\u001a\u0010I\u001a\u00020-2\b\u0010J\u001a\u0004\u0018\u00010G2\b\u0010K\u001a\u0004\u0018\u00010GJ\u0018\u0010L\u001a\u00020-2\b\u0010M\u001a\u0004\u0018\u00010G2\u0006\u0010N\u001a\u00020\u0015J\u0010\u0010O\u001a\u00020-2\u0006\u0010P\u001a\u00020\u0015H\u0002J\u001a\u0010Q\u001a\u00020-2\b\u0010@\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010R\u001a\u00020-2\u0006\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\u0005H\u0002J\b\u0010U\u001a\u00020-H\u0002J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u0005H\u0002J\u0018\u0010W\u001a\u00020-2\u0006\u0010N\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u0005H\u0002J\b\u0010Y\u001a\u00020-H\u0002J\b\u0010Z\u001a\u00020-H\u0002J\"\u0010[\u001a\u00020-2\b\u0010@\u001a\u0004\u0018\u00010\u00102\u0006\u0010N\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u0019H\u0002R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerViewCore;", "", "context", "Landroid/content/Context;", "hsvColor", "", "<init>", "(Landroid/content/Context;[F)V", "mContext", "mColorTheme", "Lcom/samsung/android/sdk/pen/util/color/SpenColorThemeUtil;", "mOldHsv", "mHsv", "mPickerView", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerView;", "mOldColorView", "Landroid/view/View;", "mCurrentColorView", "mColorViewGroup", "Landroid/widget/LinearLayout;", "mCenterRadius", "", "mColorNameHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilColor;", "mOldColorString", "", "mCurrentColorString", "mUndefinedColorName", "mSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mSpringForce", "Landroidx/dynamicanimation/animation/SpringForce;", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorPickerLayout$ActionListener;", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerDataChangedListener;", "mAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerViewCore$AnimationListener;", "mOnColorChangedListener", "com/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerViewCore$mOnColorChangedListener$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerViewCore$mOnColorChangedListener$1;", "mOnPickerViewActionListener", "com/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerViewCore$mOnPickerViewActionListener$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerViewCore$mOnPickerViewActionListener$1;", "close", "", "setColorTheme", "", BaseWidgetConstant.WIDGET_THEME, "initPickerView", "pickerView", "oldColorView", "currentColorView", "colorViewGroup", "setCurrentColor", "hsv", "getCurrentColor", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDataChangedListener", "setAnimationListener", "startAnimation", "isShow", "initColorView", "view", "leftTop", "", "rightTop", "rightBottom", "leftBottom", "mContentColorTextView", "Landroid/widget/TextView;", "mVisibleColorTextView", "setTextView", "contentColorTv", "visibleColorTv", "updateText", "tv", "color", "updateView", "target", "setColorViewBackground", "copyToColor", "src", "dest", "notifyColorChanged", "getThemeColor", "colorToThemeColor", "themeColor", "startAnimationShow", "startAnimationHide", "setColorAccessibility", "description", "Companion", "AnimationListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenQTColorPickerViewCore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenQTColorPickerViewCore.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerViewCore\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,285:1\n1#2:286\n*E\n"})
public class SpenQTColorPickerViewCore {
    public static final long ANIMATION_DELAY = 200;
    private static final float DAMPING_RATIO = 0.75f;
    private static final int HSV_COLOR_SIZE = 3;
    private static final float STIFFNESS = 300.0f;

    @NotNull
    private static final String TAG = "SpenQTColorPickerViewCore";
    private static final int UPDATE_ALL = 7;
    private static final int UPDATE_NEW_COLOR = 2;
    private static final int UPDATE_OLD_COLOR = 1;
    private static final int UPDATE_PICKER = 4;

    @Nullable
    private SpenSettingQTColorPickerLayout.ActionListener mActionListener;

    @Nullable
    private AnimationListener mAnimationListener;
    private int mCenterRadius;

    @NotNull
    private SpenSettingUtilColor mColorNameHelper;

    @NotNull
    private SpenColorThemeUtil mColorTheme;

    @Nullable
    private LinearLayout mColorViewGroup;

    @Nullable
    private TextView mContentColorTextView;

    @NotNull
    private Context mContext;

    @NotNull
    private final String mCurrentColorString;

    @Nullable
    private View mCurrentColorView;

    @Nullable
    private SpenColorPickerDataChangedListener mDataChangedListener;

    @NotNull
    private float[] mHsv;

    @NotNull
    private final String mOldColorString;

    @Nullable
    private View mOldColorView;

    @NotNull
    private final float[] mOldHsv;

    @NotNull
    private final SpenQTColorPickerViewCore$mOnColorChangedListener$1 mOnColorChangedListener;

    @NotNull
    private final SpenQTColorPickerViewCore$mOnPickerViewActionListener$1 mOnPickerViewActionListener;

    @Nullable
    private SpenQTColorPickerView mPickerView;

    @Nullable
    private SpringAnimation mSpringAnimation;

    @NotNull
    private SpringForce mSpringForce;

    @NotNull
    private String mUndefinedColorName;

    @Nullable
    private TextView mVisibleColorTextView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerViewCore$AnimationListener;", "", "onAnimationEnd", "", "isShowAnimation", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface AnimationListener {
        void onAnimationEnd(boolean isShowAnimation);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerViewCore$mOnColorChangedListener$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerViewCore$mOnPickerViewActionListener$1] */
    public SpenQTColorPickerViewCore(@NotNull Context context, @NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        this.mContext = context;
        this.mColorTheme = new SpenColorThemeUtil(context);
        float[] fArr = new float[3];
        this.mOldHsv = fArr;
        this.mHsv = new float[3];
        this.mSpringForce = new SpringForce();
        this.mOnColorChangedListener = new SpenQTColorPickerView.OnColorChangedListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerViewCore$mOnColorChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView.OnColorChangedListener
            public void onColorChanged(float[] hsvColor2) {
                Intrinsics.checkNotNullParameter(hsvColor2, "hsvColor");
                float[] themeColor = this.this$0.getThemeColor(hsvColor2);
                SpenQTColorPickerViewCore spenQTColorPickerViewCore = this.this$0;
                spenQTColorPickerViewCore.copyToColor(themeColor, spenQTColorPickerViewCore.mHsv);
                this.this$0.updateView(2);
            }
        };
        this.mOnPickerViewActionListener = new SpenQTColorPickerView.OnActionListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerViewCore$mOnPickerViewActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView.OnActionListener
            public void onBrightnessReleased() {
                this.this$0.notifyColorChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView.OnActionListener
            public void onHueReleased() {
                this.this$0.notifyColorChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView.OnActionListener
            public void onSaturationReleased() {
                this.this$0.notifyColorChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView.OnActionListener
            public void onBrightnessPressed() {
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView.OnActionListener
            public void onHuePressed() {
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView.OnActionListener
            public void onSaturationPressed() {
            }
        };
        copyToColor(hsvColor, fArr);
        copyToColor(hsvColor, this.mHsv);
        this.mCenterRadius = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_color_picker_center_color_width);
        this.mSpringForce.setDampingRatio(0.75f);
        this.mSpringForce.setStiffness(300.0f);
        Resources resources = context.getResources();
        this.mColorNameHelper = new SpenSettingUtilColor(context, 2);
        this.mOldColorString = resources.getString(C7932R.string.pen_string_current_any, resources.getString(C7932R.string.pen_string_color));
        this.mCurrentColorString = resources.getString(C7932R.string.pen_string_new_any, resources.getString(C7932R.string.pen_string_color));
        this.mUndefinedColorName = resources.getString(C7932R.string.pen_palette_color_custom);
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
        System.arraycopy(src, 0, dest, 0, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float[] getThemeColor(float[] color) {
        float[] fArr = new float[3];
        colorToThemeColor(color, fArr);
        return fArr;
    }

    private final void initColorView(View view, float leftTop, float rightTop, float rightBottom, float leftBottom) {
        view.setOnClickListener(new ViewOnClickListenerC7538b(this, 16));
        SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
        spenGradientDrawableHelper.setDrawableInfo(0, 0, 0, 0);
        spenGradientDrawableHelper.setRectRadius(leftTop, rightTop, rightBottom, leftBottom);
        view.setBackground(spenGradientDrawableHelper.makeDrawable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initColorView$lambda$1(SpenQTColorPickerViewCore spenQTColorPickerViewCore, View view) {
        SpenSettingQTColorPickerLayout.ActionListener actionListener = spenQTColorPickerViewCore.mActionListener;
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

    private final void setColorAccessibility(View view, float[] color, String description) {
        if (view == null) {
            return;
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(description, " ");
        String colorName = this.mColorNameHelper.getColorName(color);
        if (colorName != null) {
            sbM781w.append(colorName);
        } else {
            sbM781w.append(this.mUndefinedColorName);
        }
        view.setContentDescription(sbM781w);
    }

    private final void setColorViewBackground(View view, float[] hsvColor) {
        if (view == null) {
            return;
        }
        SpenGradientDrawableHelper.INSTANCE.setColor(view.getBackground(), SpenSettingUtil.HSVToColor(hsvColor));
    }

    private final void startAnimationHide() {
        this.mSpringForce.setFinalPosition(this.mContext.getResources().getDimensionPixelSize(C7932R.dimen.qt_color_picker_center_color_translate_y));
        final SpringAnimation springAnimation = this.mSpringAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
            springAnimation.setSpring(this.mSpringForce);
            springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerViewCore$startAnimationHide$1$1
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                public void onAnimationEnd(DynamicAnimation<?> animation, boolean canceled, float value, float velocity) {
                    SpenQTColorPickerViewCore.AnimationListener animationListener = this.this$0.mAnimationListener;
                    if (animationListener != null) {
                        animationListener.onAnimationEnd(false);
                    }
                    springAnimation.removeEndListener(this);
                }
            });
            springAnimation.start();
        }
    }

    private final void startAnimationShow() {
        this.mSpringForce.setFinalPosition(0.0f);
        SpringAnimation springAnimation = this.mSpringAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
            springAnimation.setSpring(this.mSpringForce);
            LinearLayout linearLayout = this.mColorViewGroup;
            if (linearLayout != null) {
                linearLayout.postDelayed(new RunnableC7599e(springAnimation, 1), 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateView(int target) {
        SpenQTColorPickerView spenQTColorPickerView;
        float[] themeColor = getThemeColor(this.mHsv);
        if ((target & 1) == 1) {
            float[] themeColor2 = getThemeColor(this.mOldHsv);
            setColorViewBackground(this.mOldColorView, themeColor2);
            setColorAccessibility(this.mOldColorView, themeColor2, this.mOldColorString);
        }
        if ((target & 2) == 2) {
            setColorViewBackground(this.mCurrentColorView, themeColor);
            setColorAccessibility(this.mCurrentColorView, themeColor, this.mCurrentColorString);
            updateText(this.mContentColorTextView, SpenSettingUtil.HSVToColor(this.mHsv));
            updateText(this.mVisibleColorTextView, SpenSettingUtil.HSVToColor(themeColor));
        }
        if ((target & 4) != 4 || (spenQTColorPickerView = this.mPickerView) == null) {
            return;
        }
        spenQTColorPickerView.setPositionByColor(themeColor);
    }

    public final void close() {
        Log.i(TAG, "close()");
        this.mPickerView = null;
        this.mOldColorView = null;
        this.mCurrentColorView = null;
        this.mColorViewGroup = null;
        this.mActionListener = null;
        this.mDataChangedListener = null;
        this.mColorTheme.close();
        this.mAnimationListener = null;
        this.mColorNameHelper.close();
    }

    public final boolean getCurrentColor(@NotNull float[] hsv) {
        Intrinsics.checkNotNullParameter(hsv, "hsv");
        copyToColor(this.mHsv, hsv);
        return true;
    }

    public final void initPickerView(@NotNull SpenQTColorPickerView pickerView, @NotNull View oldColorView, @NotNull View currentColorView, @NotNull LinearLayout colorViewGroup) {
        Intrinsics.checkNotNullParameter(pickerView, "pickerView");
        Intrinsics.checkNotNullParameter(oldColorView, "oldColorView");
        Intrinsics.checkNotNullParameter(currentColorView, "currentColorView");
        Intrinsics.checkNotNullParameter(colorViewGroup, "colorViewGroup");
        pickerView.setOnColorChangedListener(this.mOnColorChangedListener);
        pickerView.setOnPickerActionListener(this.mOnPickerViewActionListener);
        this.mPickerView = pickerView;
        pickerView.setAnimationListener(new SpenQTColorPickerView.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerViewCore.initPickerView.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView.AnimationListener
            public void onAnimationEnd(boolean isShowAnimation) {
                AnimationListener animationListener;
                if (!isShowAnimation || (animationListener = SpenQTColorPickerViewCore.this.mAnimationListener) == null) {
                    return;
                }
                animationListener.onAnimationEnd(true);
            }
        });
        this.mOldColorView = oldColorView;
        this.mColorViewGroup = colorViewGroup;
        if (colorViewGroup != null) {
            colorViewGroup.setLayoutDirection(0);
        }
        this.mSpringAnimation = new SpringAnimation(this.mColorViewGroup, DynamicAnimation.TRANSLATION_Y);
        View view = this.mOldColorView;
        Intrinsics.checkNotNull(view);
        int i = this.mCenterRadius;
        initColorView(view, i, 0.0f, 0.0f, i);
        View view2 = this.mOldColorView;
        Intrinsics.checkNotNull(view2);
        setColorAccessibility(view2, this.mOldHsv, this.mOldColorString);
        this.mCurrentColorView = currentColorView;
        Intrinsics.checkNotNull(currentColorView);
        int i2 = this.mCenterRadius;
        initColorView(currentColorView, 0.0f, i2, i2, 0.0f);
        View view3 = this.mCurrentColorView;
        Intrinsics.checkNotNull(view3);
        setColorAccessibility(view3, this.mHsv, this.mCurrentColorString);
        updateView(7);
    }

    public final void setActionListener(@Nullable SpenSettingQTColorPickerLayout.ActionListener listener) {
        this.mActionListener = listener;
    }

    public final void setAnimationListener(@Nullable AnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final boolean setColorTheme(int theme) {
        AbstractC2322a.m1631u(theme, "setColorTheme() theme=", TAG);
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
        AbstractC2821a.m2206A(AbstractC0622a.m1176v("setCurrentColor() h=", f, ", s=", f4, ", v="), TAG, hsv[2]);
        copyToColor(hsv, this.mHsv);
        updateView(7);
    }

    public final void setDataChangedListener(@Nullable SpenColorPickerDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    public final void setTextView(@Nullable TextView contentColorTv, @Nullable TextView visibleColorTv) {
        this.mContentColorTextView = contentColorTv;
        this.mVisibleColorTextView = visibleColorTv;
    }

    public final void startAnimation(boolean isShow) {
        if (isShow) {
            startAnimationShow();
        } else {
            startAnimationHide();
        }
        SpenQTColorPickerView spenQTColorPickerView = this.mPickerView;
        if (spenQTColorPickerView != null) {
            spenQTColorPickerView.startAnimation(isShow);
        }
    }

    public final void updateText(@Nullable TextView tv, int color) {
        if (tv != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & color)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            tv.setText(str);
            tv.setTextColor(color);
        }
    }
}
