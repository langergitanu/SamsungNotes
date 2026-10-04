package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.setting.common.SpenRoundLayout;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAdaptiveColor;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilDrawable;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 m2\u00020\u0001:\u0001mB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010,\u001a\u00020(H\u0016J\u001a\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001c\u0010-\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u00010\"2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J$\u0010-\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u00010\"2\u0006\u00102\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\nH\u0016J\u0010\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u001fH\u0016J\u0018\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001fH\u0016J\u0012\u00108\u001a\u00020(2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J&\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nJ&\u0010@\u001a\u00020(2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nJ\u0016\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nJ\u000e\u0010D\u001a\u00020(2\u0006\u0010E\u001a\u00020\nJ&\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020H2\u0006\u0010K\u001a\u00020HJ.\u0010F\u001a\u00020(2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020H2\u0006\u0010N\u001a\u00020H2\u0006\u0010O\u001a\u00020H2\u0006\u0010P\u001a\u00020HJ\u0012\u0010Q\u001a\u00020(2\b\u0010R\u001a\u0004\u0018\u00010SH\u0002J\b\u0010T\u001a\u00020(H\u0002J\u0010\u0010U\u001a\u00020(2\u0006\u00106\u001a\u00020\u001fH\u0002J\u0010\u0010X\u001a\u00020(2\u0006\u00106\u001a\u00020\u001fH\u0002J(\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010]\u001a\u00020\nH\u0002J\u0010\u0010^\u001a\u00020(2\u0006\u0010_\u001a\u00020\u001fH\u0002J\u0010\u0010`\u001a\u00020(2\u0006\u0010.\u001a\u00020\nH\u0002J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\nH\u0002J\u0010\u0010b\u001a\u00020(2\u0006\u0010c\u001a\u00020\u001fH\u0002J\u0018\u0010d\u001a\u00020(2\u0006\u0010.\u001a\u00020\n2\u0006\u00106\u001a\u00020\u001fH\u0002J(\u0010d\u001a\u00020(2\u0006\u0010e\u001a\u00020H2\u0006\u0010f\u001a\u00020H2\u0006\u0010\f\u001a\u00020H2\u0006\u00106\u001a\u00020\u001fH\u0002J(\u0010g\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020H2\u0006\u0010f\u001a\u00020H2\u0006\u0010\f\u001a\u00020H2\u0006\u0010h\u001a\u00020\u001fH\u0002R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@RX\u0096.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0010R\u0014\u0010V\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0016\u0010i\u001a\u0004\u0018\u00010j8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010l¨\u0006n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenRectColorView;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenBaseColorView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "selectedCornerRadius", "", "(Landroid/content/Context;I)V", "value", "Landroid/view/View;", "selectView", "getSelectView", "()Landroid/view/View;", "mUnselectedMarginTop", "mUnselectedMarginBottom", "mUnselectedMarginStart", "mUnselectedMarginEnd", "mSelectedMarginTop", "mSelectedMarginBottom", "mSelectedMarginStart", "mSelectedMarginEnd", "mSelectedElevation", "mResView", "mSelectViewNormalColor", "mSelectViewAdaptiveColor", "mFixedSelectViewColor", "mIsFixedSelectViewColor", "", "mCornerRadius", "mCornerRadii", "", "mColorView", "Lcom/samsung/android/sdk/pen/setting/common/SpenRoundLayout;", "mBgDrawableHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenGradientDrawableHelper;", "close", "", "initView", "colorView", "getColorView", "setInit", "setColor", "color", "colorName", "", "hsv", "opacity", "setColorRes", "drawableId", "setSelected", "selected", "animation", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "setSelectedMargin", "marginTop", "marginStart", "marginEnd", "marginBottom", "setUnselectedMargin", "setSelectorSize", "width", "height", "setFixedSelectorColor", "fixedColor", "setRadius", "topLeft", "", "topRight", "bottomRight", "bottomLeft", "selectedRadius", "unselectedTopLeft", "unselectedTopRight", "unselectedBottomRight", "unselectedBottomLeft", "updateTransparentBackground", "backgroundDrawable", "Landroid/graphics/drawable/LayerDrawable;", "setRectInit", "updateCornerRadius", "isTransparentColor", "()Z", "updateCurrentLayout", "adjustMargin", "top", "bottom", "start", "end", "updateRes", "visible", "updateSelector", "needAdaptiveColorInSelector", "updateStrokeIfNeedOutline", "isSelected", "updateStroke", "hue", "saturation", "needOutline", "isDarkMode", "colorBackground", "Landroid/graphics/drawable/GradientDrawable;", "getColorBackground", "()Landroid/graphics/drawable/GradientDrawable;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRectColorView extends SpenBaseColorView {

    @NotNull
    private static final String TAG = "SpenRectColorView";
    private SpenGradientDrawableHelper mBgDrawableHelper;
    private SpenRoundLayout mColorView;

    @NotNull
    private final float[] mCornerRadii;
    private int mCornerRadius;
    private int mFixedSelectViewColor;
    private boolean mIsFixedSelectViewColor;

    @Nullable
    private View mResView;
    private int mSelectViewAdaptiveColor;
    private int mSelectViewNormalColor;
    private int mSelectedElevation;
    private int mSelectedMarginBottom;
    private int mSelectedMarginEnd;
    private int mSelectedMarginStart;
    private int mSelectedMarginTop;
    private int mUnselectedMarginBottom;
    private int mUnselectedMarginEnd;
    private int mUnselectedMarginStart;
    private int mUnselectedMarginTop;
    private View selectView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRectColorView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCornerRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mIsFixedSelectViewColor = false;
        this.mFixedSelectViewColor = -1;
        this.mCornerRadius = 0;
    }

    private final void adjustMargin(int top, int bottom, int start, int end) {
        SpenRoundLayout spenRoundLayout = this.mColorView;
        SpenRoundLayout spenRoundLayout2 = null;
        if (spenRoundLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            spenRoundLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = spenRoundLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(start);
        layoutParams2.setMarginEnd(end);
        layoutParams2.topMargin = top;
        layoutParams2.bottomMargin = bottom;
        SpenRoundLayout spenRoundLayout3 = this.mColorView;
        if (spenRoundLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
        } else {
            spenRoundLayout2 = spenRoundLayout3;
        }
        spenRoundLayout2.setLayoutParams(layoutParams2);
    }

    private final GradientDrawable getColorBackground() {
        SpenRoundLayout spenRoundLayout = this.mColorView;
        if (spenRoundLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            spenRoundLayout = null;
        }
        Drawable background = spenRoundLayout.getBackground();
        if (background instanceof GradientDrawable) {
            return (GradientDrawable) background;
        }
        return null;
    }

    private final boolean isTransparentColor() {
        return (getColorType() == 1 || getColorType() == 2) && getOpacity() == 0;
    }

    private final boolean needAdaptiveColorInSelector(int color) {
        if (color != 0) {
            return SpenSettingUtilAdaptiveColor.isAdaptiveColor(color, SpenSettingUtilAdaptiveColor.UseType.DECISION_FG_COLOR);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return !SpenSettingUtil.isNightMode(context);
    }

    private final boolean needOutline(float hue, float saturation, float value, boolean isDarkMode) {
        if (!isDarkMode) {
            if (hue != 0.0f || saturation != 0.0f || value < 0.96f) {
                return false;
            }
            AbstractC2821a.m2234y(AbstractC0622a.m1176v("[LIGH TMODE] needOutline() is true. HSV[", hue, SQLKeyword.COMMA, saturation, SQLKeyword.COMMA), value, "]", TAG);
            return true;
        }
        if (hue != 0.0f || saturation != 0.0f || 0.1f > value || value >= 0.2f) {
            return false;
        }
        AbstractC2821a.m2234y(AbstractC0622a.m1176v("[DARK MODE] needOutline() is true. HSV[", hue, SQLKeyword.COMMA, saturation, SQLKeyword.COMMA), value, "]", TAG);
        return true;
    }

    private final void setRectInit() {
        updateRes(true);
        View view = this.mResView;
        if (view != null) {
            view.setBackgroundResource(C7932R.drawable.empty);
        }
        View view2 = this.mResView;
        SpenGradientDrawableHelper spenGradientDrawableHelper = null;
        if (view2 != null) {
            SpenGradientDrawableHelper spenGradientDrawableHelper2 = this.mBgDrawableHelper;
            if (spenGradientDrawableHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgDrawableHelper");
                spenGradientDrawableHelper2 = null;
            }
            view2.setBackgroundTintList(ColorStateList.valueOf(spenGradientDrawableHelper2.getStrokeColor()));
        }
        updateSelector(-1);
        GradientDrawable colorBackground = getColorBackground();
        SpenGradientDrawableHelper.Companion companion = SpenGradientDrawableHelper.INSTANCE;
        SpenGradientDrawableHelper spenGradientDrawableHelper3 = this.mBgDrawableHelper;
        if (spenGradientDrawableHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBgDrawableHelper");
            spenGradientDrawableHelper3 = null;
        }
        companion.setColor(colorBackground, spenGradientDrawableHelper3.getColor());
        SpenGradientDrawableHelper spenGradientDrawableHelper4 = this.mBgDrawableHelper;
        if (spenGradientDrawableHelper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBgDrawableHelper");
        } else {
            spenGradientDrawableHelper = spenGradientDrawableHelper4;
        }
        spenGradientDrawableHelper.setStroke(colorBackground, true);
    }

    private final void updateCornerRadius(boolean selected) {
        if (selected) {
            SpenGradientDrawableHelper.INSTANCE.setRadius(getColorBackground(), this.mCornerRadius);
            SpenRoundLayout spenRoundLayout = this.mColorView;
            if (spenRoundLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorView");
                spenRoundLayout = null;
            }
            spenRoundLayout.setRadius(this.mCornerRadius);
        } else {
            SpenGradientDrawableHelper.INSTANCE.setRadii(getColorBackground(), this.mCornerRadii);
            SpenRoundLayout spenRoundLayout2 = this.mColorView;
            if (spenRoundLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorView");
                spenRoundLayout2 = null;
            }
            float[] fArr = this.mCornerRadii;
            spenRoundLayout2.setRadius(fArr[0], fArr[2], fArr[4], fArr[6]);
        }
        SpenRoundLayout spenRoundLayout3 = this.mColorView;
        if (spenRoundLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            spenRoundLayout3 = null;
        }
        spenRoundLayout3.invalidate();
        if (isTransparentColor()) {
            View view = this.mResView;
            Drawable background = view != null ? view.getBackground() : null;
            updateTransparentBackground(background instanceof LayerDrawable ? (LayerDrawable) background : null);
        }
    }

    private final void updateCurrentLayout(boolean selected) {
        SpenRoundLayout spenRoundLayout = null;
        if (!selected) {
            SpenRoundLayout spenRoundLayout2 = this.mColorView;
            if (spenRoundLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            } else {
                spenRoundLayout = spenRoundLayout2;
            }
            spenRoundLayout.setElevation(0.0f);
            adjustMargin(this.mUnselectedMarginTop, this.mUnselectedMarginBottom, this.mUnselectedMarginStart, this.mUnselectedMarginEnd);
            return;
        }
        adjustMargin(this.mSelectedMarginTop, this.mSelectedMarginBottom, this.mSelectedMarginStart, this.mSelectedMarginEnd);
        SpenRoundLayout spenRoundLayout3 = this.mColorView;
        if (spenRoundLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
        } else {
            spenRoundLayout = spenRoundLayout3;
        }
        spenRoundLayout.setElevation(this.mSelectedElevation);
        if (getParent() != null) {
            getParent().bringChildToFront(this);
        }
    }

    private final void updateRes(boolean visible) {
        View view;
        SpenRoundLayout spenRoundLayout = null;
        if (!visible) {
            View view2 = this.mResView;
            if (view2 == null || view2 == null || view2.getVisibility() != 0) {
                return;
            }
            View view3 = this.mResView;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            SpenRoundLayout spenRoundLayout2 = this.mColorView;
            if (spenRoundLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorView");
                spenRoundLayout2 = null;
            }
            spenRoundLayout2.removeView(this.mResView);
            this.mResView = null;
            return;
        }
        if (this.mResView == null) {
            View view4 = new View(getContext());
            this.mResView = view4;
            view4.setId(C7932R.id.resource_view);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            SpenRoundLayout spenRoundLayout3 = this.mColorView;
            if (spenRoundLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            } else {
                spenRoundLayout = spenRoundLayout3;
            }
            spenRoundLayout.addView(this.mResView, 0, layoutParams);
        }
        View view5 = this.mResView;
        if ((view5 == null || view5.getVisibility() != 0) && (view = this.mResView) != null) {
            view.setVisibility(0);
        }
    }

    private final void updateSelector(int color) {
        View selectView = getSelectView();
        if (this.mIsFixedSelectViewColor) {
            selectView.setBackgroundTintList(ColorStateList.valueOf(this.mFixedSelectViewColor));
            return;
        }
        if (getColorType() == 0 || getColorType() == 3) {
            selectView.setBackgroundTintList(ColorStateList.valueOf(this.mSelectViewNormalColor));
        } else if (needAdaptiveColorInSelector(color)) {
            selectView.setBackgroundTintList(ColorStateList.valueOf(this.mSelectViewAdaptiveColor));
        } else {
            selectView.setBackgroundTintList(ColorStateList.valueOf(this.mSelectViewNormalColor));
        }
    }

    private final void updateStroke(int color, boolean selected) {
        float[] fArr = new float[3];
        Color.colorToHSV(color, fArr);
        updateStroke(fArr[0], fArr[1], fArr[2], selected);
    }

    private final void updateStrokeIfNeedOutline(boolean isSelected) {
        if (getColorType() == 3) {
            return;
        }
        float[] fArr = new float[3];
        if (getColor(fArr)) {
            float f = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[2];
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (needOutline(f, f4, f5, SpenSettingUtil.isNightMode(context))) {
                updateStroke(fArr[0], fArr[1], fArr[2], isSelected);
            }
        }
    }

    private final void updateTransparentBackground(LayerDrawable backgroundDrawable) {
        if (backgroundDrawable == null) {
            return;
        }
        Drawable drawableFindDrawableByLayerId = backgroundDrawable.findDrawableByLayerId(C7932R.id.stroke_drawable);
        SpenGradientDrawableHelper spenGradientDrawableHelper = null;
        GradientDrawable gradientDrawable = drawableFindDrawableByLayerId instanceof GradientDrawable ? (GradientDrawable) drawableFindDrawableByLayerId : null;
        if (gradientDrawable == null) {
            return;
        }
        if (isSelected()) {
            SpenGradientDrawableHelper.INSTANCE.setRadius(gradientDrawable, this.mCornerRadius);
        } else {
            SpenGradientDrawableHelper.INSTANCE.setRadii(gradientDrawable, this.mCornerRadii);
        }
        SpenGradientDrawableHelper spenGradientDrawableHelper2 = this.mBgDrawableHelper;
        if (spenGradientDrawableHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBgDrawableHelper");
        } else {
            spenGradientDrawableHelper = spenGradientDrawableHelper2;
        }
        spenGradientDrawableHelper.setStroke(gradientDrawable, true);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenBaseColorView
    public void close() {
        this.mResView = null;
        this.mIsFixedSelectViewColor = false;
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenBaseColorView
    @NotNull
    public View getColorView() {
        SpenRoundLayout spenRoundLayout = this.mColorView;
        if (spenRoundLayout != null) {
            return spenRoundLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mColorView");
        return null;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenBaseColorView
    @NotNull
    public View getSelectView() {
        View view = this.selectView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("selectView");
        return null;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenBaseColorView
    public void initView(@NotNull Context context, @Nullable AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), C7932R.layout.setting_rect_color_view, this);
        this.mUnselectedMarginTop = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_unselected_margin_top);
        this.mUnselectedMarginBottom = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_unselected_margin_bottom);
        this.mUnselectedMarginStart = context.getResources().getDimensionPixelOffset(C7932R.dimen.setting_color_rect_chip_unselected_margin_start);
        this.mUnselectedMarginEnd = context.getResources().getDimensionPixelOffset(C7932R.dimen.setting_color_rect_chip_unselected_margin_end);
        this.mSelectedMarginTop = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_selected_margin_top);
        this.mSelectedMarginBottom = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_selected_margin_bottom);
        this.mSelectedMarginStart = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_selected_margin_start);
        this.mSelectedMarginEnd = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_selected_margin_end);
        this.mSelectedElevation = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_selected_elevation);
        this.mColorView = (SpenRoundLayout) findViewById(C7932R.id.color);
        this.selectView = findViewById(C7932R.id.select_icon);
        getSelectView().setBackground(context.getDrawable(C7932R.drawable.selected_white));
        this.mSelectViewNormalColor = SpenSettingUtil.getColor(context, C7932R.color.setting_selection_tint_color);
        this.mSelectViewAdaptiveColor = SpenSettingUtil.getColor(context, C7932R.color.setting_selection_adaptive_tint_color);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_unselected_outline_size);
        int color = SpenSettingUtil.getColor(context, C7932R.color.setting_color_rect_chip_unselected_outline_color);
        int color2 = SpenSettingUtil.getColor(context, C7932R.color.setting_color_rect_chip_default_color);
        SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
        this.mBgDrawableHelper = spenGradientDrawableHelper;
        spenGradientDrawableHelper.setDrawableInfo(0, color2, dimensionPixelSize, color);
        SpenRoundLayout spenRoundLayout = this.mColorView;
        SpenGradientDrawableHelper spenGradientDrawableHelper2 = null;
        if (spenRoundLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            spenRoundLayout = null;
        }
        SpenGradientDrawableHelper spenGradientDrawableHelper3 = this.mBgDrawableHelper;
        if (spenGradientDrawableHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBgDrawableHelper");
        } else {
            spenGradientDrawableHelper2 = spenGradientDrawableHelper3;
        }
        spenRoundLayout.setBackground(spenGradientDrawableHelper2.makeDrawable());
        setRectInit();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenBaseColorView
    public void setColor(int color, @Nullable String colorName) {
        updateRes(false);
        super.setColor(color, colorName);
        updateSelector(color);
        updateStroke(color, isSelected());
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenBaseColorView
    public void setColorRes(int drawableId) {
        AbstractC2322a.m1631u(drawableId, "SetColorRes() drawableId=", TAG);
        super.setColorRes(0);
        updateRes(true);
        View view = this.mResView;
        if (view != null) {
            view.setBackgroundResource(drawableId);
        }
        View view2 = this.mResView;
        if (view2 != null) {
            view2.setBackgroundTintList(null);
        }
        updateSelector(-1);
    }

    public final void setFixedSelectorColor(int fixedColor) {
        this.mFixedSelectViewColor = fixedColor;
        this.mIsFixedSelectViewColor = true;
        updateSelector(-1);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenBaseColorView
    public void setInit() {
        int colorType = getColorType();
        super.setInit();
        if (colorType != getColorType()) {
            setRectInit();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener l) {
        super.setOnClickListener(l);
        if (l != null) {
            SpenRoundLayout spenRoundLayout = this.mColorView;
            if (spenRoundLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorView");
                spenRoundLayout = null;
            }
            SpenSettingUtilDrawable.setForeground(spenRoundLayout, getContext().getDrawable(C7932R.drawable.spen_rect_ripple), null);
            return;
        }
        if (getColorType() != 0) {
            SpenRoundLayout spenRoundLayout2 = this.mColorView;
            if (spenRoundLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorView");
                spenRoundLayout2 = null;
            }
            SpenSettingUtilDrawable.setForeground(spenRoundLayout2, null, null);
        }
    }

    public final void setRadius(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        float[] fArr = this.mCornerRadii;
        fArr[1] = topLeft;
        fArr[0] = topLeft;
        fArr[3] = topRight;
        fArr[2] = topRight;
        fArr[5] = bottomRight;
        fArr[4] = bottomRight;
        fArr[7] = bottomLeft;
        fArr[6] = bottomLeft;
        SpenGradientDrawableHelper spenGradientDrawableHelper = this.mBgDrawableHelper;
        SpenGradientDrawableHelper spenGradientDrawableHelper2 = null;
        if (spenGradientDrawableHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBgDrawableHelper");
            spenGradientDrawableHelper = null;
        }
        spenGradientDrawableHelper.setRectRadius(topLeft, topRight, bottomRight, bottomLeft);
        if (getColorType() == 3) {
            GradientDrawable colorBackground = getColorBackground();
            SpenGradientDrawableHelper.INSTANCE.setColor(colorBackground, SpenSettingUtil.getColor(getContext(), C7932R.color.setting_bg_color));
            SpenGradientDrawableHelper spenGradientDrawableHelper3 = this.mBgDrawableHelper;
            if (spenGradientDrawableHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgDrawableHelper");
            } else {
                spenGradientDrawableHelper2 = spenGradientDrawableHelper3;
            }
            spenGradientDrawableHelper2.setStroke(colorBackground, false);
        }
        updateCornerRadius(isSelected());
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        setSelected(selected, true);
    }

    public final void setSelectedMargin(int marginTop, int marginStart, int marginEnd, int marginBottom) {
        this.mSelectedMarginTop = marginTop;
        this.mSelectedMarginStart = marginStart;
        this.mSelectedMarginEnd = marginEnd;
        this.mSelectedMarginBottom = marginBottom;
        updateCurrentLayout(isSelected());
    }

    public final void setSelectorSize(int width, int height) {
        ViewGroup.LayoutParams layoutParams = getSelectView().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = width;
        layoutParams2.height = height;
        layoutParams2.gravity = 17;
        getSelectView().setLayoutParams(layoutParams2);
    }

    public final void setUnselectedMargin(int marginTop, int marginStart, int marginEnd, int marginBottom) {
        this.mUnselectedMarginStart = marginStart;
        this.mUnselectedMarginEnd = marginEnd;
        this.mUnselectedMarginTop = marginTop;
        this.mUnselectedMarginBottom = marginBottom;
        updateCurrentLayout(isSelected());
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenBaseColorView
    public boolean setSelected(boolean selected, boolean animation) {
        if (selected != isSelected()) {
            updateStrokeIfNeedOutline(selected);
        }
        if (!super.setSelected(selected, animation)) {
            return false;
        }
        updateCornerRadius(selected);
        updateCurrentLayout(selected);
        return true;
    }

    private final void updateStroke(float hue, float saturation, float value, boolean selected) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        boolean z = needOutline(hue, saturation, value, SpenSettingUtil.isNightMode(context)) && !selected;
        SpenGradientDrawableHelper spenGradientDrawableHelper = this.mBgDrawableHelper;
        if (spenGradientDrawableHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBgDrawableHelper");
            spenGradientDrawableHelper = null;
        }
        spenGradientDrawableHelper.setStroke(getColorBackground(), z);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenBaseColorView
    public boolean setColor(@Nullable float[] hsv, @Nullable String colorName) {
        return setColor(hsv, SpenBaseColorView.getOPACITY_100(), colorName);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRectColorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCornerRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mIsFixedSelectViewColor = false;
        this.mFixedSelectViewColor = -1;
        this.mCornerRadius = 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenBaseColorView
    public boolean setColor(@Nullable float[] hsv, int opacity, @Nullable String colorName) {
        if (hsv == null || hsv.length != 3) {
            return false;
        }
        if (opacity != 0) {
            updateRes(false);
        } else {
            updateRes(true);
            View view = this.mResView;
            if (view != null) {
                view.setBackgroundResource(C7932R.drawable.blank_with_stroke);
            }
            View view2 = this.mResView;
            Drawable background = view2 != null ? view2.getBackground() : null;
            updateTransparentBackground(background instanceof LayerDrawable ? (LayerDrawable) background : null);
            View view3 = this.mResView;
            if (view3 != null) {
                view3.setBackgroundTintList(null);
            }
        }
        super.setColor(hsv, opacity, colorName);
        updateSelector(SpenSettingUtil.HSVToColor(opacity, hsv));
        updateStroke(hsv[0], hsv[1], hsv[2], isSelected());
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRectColorView(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCornerRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mIsFixedSelectViewColor = false;
        this.mFixedSelectViewColor = -1;
        this.mCornerRadius = i;
        AbstractC2322a.m1631u(i, "### SelectedCornerRadius=", TAG);
    }

    public final void setRadius(int selectedRadius, float unselectedTopLeft, float unselectedTopRight, float unselectedBottomRight, float unselectedBottomLeft) {
        this.mCornerRadius = selectedRadius;
        setRadius(unselectedTopLeft, unselectedTopRight, unselectedBottomRight, unselectedBottomLeft);
    }
}
