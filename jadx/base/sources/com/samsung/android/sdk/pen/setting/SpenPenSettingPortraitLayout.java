package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016JX\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0016J0\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0016J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0006H\u0016J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0006H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenSettingPortraitLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenPenLayoutManager;", "Lcom/samsung/android/sdk/pen/setting/SpenLayoutInterface;", "context", "Landroid/content/Context;", "isTopView", "", "<init>", "(Landroid/content/Context;Z)V", "mDivider", "Landroid/view/View;", "mAttrGroup", "Landroid/widget/LinearLayout;", "mColorGroup", "Landroid/view/ViewGroup;", "mViewMode", "", "mTopViewMargin", "mIsTopView", "close", "", "setContentView", "contentBody", "detachChild", "attachChild", "sizeView", "penView", "colorView", "patternView", "alphaView", "widthView", "dynamicSizeView", "opacityOptionView", "setViewMode", "mode", "getViewMode", "isVisiblePatternView", "isVisibleAlphaView", "isVisibleWidthView", "isVisibleOpacityOptionView", "setPatternViewVisibility", "isVisible", "setAttributeGroupVisibility", "isAlphaVisible", "isWidthVisible", "isDynamicSizeVisible", "isOpacityOptionVisible", "animation", "setIsTopView", "isTop", "getDynamicSizeViewTransition", "Landroid/transition/TransitionSet;", "isNeedExpend", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenPenSettingPortraitLayout extends SpenPenLayoutManager implements SpenLayoutInterface {

    @NotNull
    private static final String TAG = "SpenPenSettingPortraitLayout";

    @Nullable
    private LinearLayout mAttrGroup;

    @Nullable
    private ViewGroup mColorGroup;

    @Nullable
    private View mDivider;
    private boolean mIsTopView;
    private int mTopViewMargin;
    private int mViewMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenSettingPortraitLayout(@NotNull Context context, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsTopView = z;
        this.mTopViewMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_pen_layout_content_padding_top);
    }

    private final TransitionSet getDynamicSizeViewTransition(boolean isNeedExpend) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.excludeChildren((View) this.mAttrGroup, true);
        if (isNeedExpend) {
            transitionSet.addTransition(new ChangeBounds().setDuration(333L).setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.3f, 1.0f)));
            return transitionSet;
        }
        transitionSet.addTransition(new ChangeBounds().setDuration(333L).setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.3f, 1.0f)).setStartDelay(150L));
        return transitionSet;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public void attachChild(@Nullable View sizeView, @Nullable View penView, @Nullable View colorView, @Nullable View patternView, @Nullable View alphaView, @Nullable View widthView, @Nullable View dynamicSizeView, @Nullable View opacityOptionView) {
        int i;
        int i2;
        Log.i(TAG, "attachChild() isTopView=" + this.mTopViewMargin);
        ViewGroup contentBody = getContentBody();
        if (contentBody == null) {
            return;
        }
        Context context = getContext();
        setContentBodyTopPadding(this.mIsTopView ? this.mTopViewMargin : 0);
        if (penView != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = getPixelSize(C7932R.dimen.setting_pen_layout_pen_list_margin_top);
            contentBody.addView(penView, 0, layoutParams);
            setPenView(penView);
            this.mViewMode |= 2;
            int color = SpenSettingUtil.getColor(context, C7932R.color.setting_handwriting_pen_divider);
            FrameLayout frameLayout = new FrameLayout(context);
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getPixelSize(C7932R.dimen.setting_pen_layout_divider_height));
            this.mDivider = frameLayout;
            contentBody.addView(frameLayout, 1, layoutParams2);
            View view = new View(context);
            view.setBackgroundColor(color);
            frameLayout.addView(view, new LinearLayout.LayoutParams(-1, getPixelSize(C7932R.dimen.common_setting_divider_stroke)));
            i = 2;
        } else {
            i = 0;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.mAttrGroup = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = this.mAttrGroup;
        if (linearLayout2 != null) {
            linearLayout2.setMinimumHeight(getPixelSize(C7932R.dimen.setting_pen_layout_popup_attr_group_height));
        }
        int i4 = i + 1;
        contentBody.addView(this.mAttrGroup, i, new LinearLayout.LayoutParams(-2, -2));
        if (sizeView != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = getPixelSize(C7932R.dimen.setting_pen_layout_size_margin_top_default);
            LinearLayout linearLayout3 = this.mAttrGroup;
            if (linearLayout3 != null) {
                linearLayout3.addView(sizeView, layoutParams3);
            }
            setSizeView(sizeView);
            this.mViewMode |= 1;
        }
        if (alphaView != null) {
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = getPixelSize(C7932R.dimen.setting_pen_layout_opacity_margin_top);
            LinearLayout linearLayout4 = this.mAttrGroup;
            if (linearLayout4 != null) {
                linearLayout4.addView(alphaView, layoutParams4);
            }
            setAlphaView(alphaView);
            alphaView.setVisibility(8);
        }
        if (widthView != null) {
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.topMargin = getPixelSize(C7932R.dimen.setting_pen_layout_width_margin_top);
            LinearLayout linearLayout5 = this.mAttrGroup;
            if (linearLayout5 != null) {
                linearLayout5.addView(widthView, layoutParams5);
            }
            setWidthView(widthView);
            widthView.setVisibility(8);
        }
        if (dynamicSizeView != null) {
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
            LinearLayout linearLayout6 = this.mAttrGroup;
            if (linearLayout6 != null) {
                linearLayout6.addView(dynamicSizeView, layoutParams6);
            }
            setDynamicSizeView(dynamicSizeView);
            dynamicSizeView.setVisibility(8);
        }
        if (opacityOptionView != null) {
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
            LinearLayout linearLayout7 = this.mAttrGroup;
            if (linearLayout7 != null) {
                linearLayout7.addView(opacityOptionView, layoutParams7);
            }
            setOpacityOptionView(opacityOptionView);
            opacityOptionView.setVisibility(8);
        }
        if (colorView == null || patternView == null) {
            i2 = i4;
        } else {
            this.mColorGroup = new FrameLayout(context);
            contentBody.addView(this.mColorGroup, i4, new FrameLayout.LayoutParams(-2, -2));
            ViewGroup viewGroup = this.mColorGroup;
            Intrinsics.checkNotNull(viewGroup, "null cannot be cast to non-null type android.widget.FrameLayout");
            contentBody = (FrameLayout) viewGroup;
            i2 = 0;
        }
        if (colorView != null) {
            contentBody.addView(colorView, i2);
            setColorView(colorView);
            this.mViewMode |= 4;
            i2++;
        }
        if (patternView != null) {
            contentBody.addView(patternView, i2);
            setPatternView(patternView);
            patternView.setVisibility(8);
        }
        setContentBottomPadding(getPixelSize(C7932R.dimen.setting_pen_layout_content_padding_bottom));
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenLayoutManager, com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public void close() {
        Log.i(TAG, "close()");
        this.mDivider = null;
        this.mAttrGroup = null;
        this.mViewMode = 0;
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public void detachChild() {
        Log.i(TAG, "detachChild()");
        LinearLayout linearLayout = this.mAttrGroup;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        this.mAttrGroup = null;
        ViewGroup viewGroup = this.mColorGroup;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.mColorGroup = null;
        resetContentView();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    /* JADX INFO: renamed from: getViewMode, reason: from getter */
    public int getMViewMode() {
        return this.mViewMode;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean isVisibleAlphaView() {
        View alphaView = getAlphaView();
        return alphaView != null && alphaView.getVisibility() == 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean isVisibleOpacityOptionView() {
        View opacityOptionView = getOpacityOptionView();
        return opacityOptionView != null && opacityOptionView.getVisibility() == 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean isVisiblePatternView() {
        View patternView = getPatternView();
        return patternView != null && patternView.getVisibility() == 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean isVisibleWidthView() {
        View widthView = getWidthView();
        return widthView != null && widthView.getVisibility() == 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean setAttributeGroupVisibility(boolean isAlphaVisible, boolean isWidthVisible, boolean isDynamicSizeVisible, boolean isOpacityOptionVisible, boolean animation) {
        if (!setAttributeVisibility(isAlphaVisible, isWidthVisible, isDynamicSizeVisible, isOpacityOptionVisible, animation)) {
            return false;
        }
        if (getMViewMode() != 7) {
            return true;
        }
        View sizeView = getSizeView();
        ViewGroup.LayoutParams layoutParams = sizeView != null ? sizeView.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (getVisibleCount(isAlphaVisible, isWidthVisible, isDynamicSizeVisible, isOpacityOptionVisible) == 1) {
            layoutParams2.topMargin = getPixelSize(C7932R.dimen.setting_pen_layout_size_margin_top_default);
        } else {
            layoutParams2.topMargin = getPixelSize(C7932R.dimen.setting_pen_layout_size_margin_top_together);
        }
        View sizeView2 = getSizeView();
        if (sizeView2 != null) {
            sizeView2.setLayoutParams(layoutParams2);
        }
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenLayoutManager, com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public void setContentView(@Nullable LinearLayout contentBody) {
        Log.i(TAG, "setContentView()");
        super.setContentView(contentBody);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public void setIsTopView(boolean isTop) {
        Log.i(TAG, "setIsTopView() isTop=" + isTop + "]");
        if (this.mIsTopView == isTop) {
            return;
        }
        this.mIsTopView = isTop;
        setContentBodyTopPadding(isTop ? this.mTopViewMargin : 0);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenLayoutManager, com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean setPatternViewVisibility(boolean isVisible) {
        return super.setPatternViewVisibility(isVisible);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean setViewMode(int mode) {
        int i = 0;
        if (getMViewMode() == mode) {
            AbstractC2322a.m1631u(mode, "SAME ViewMode=", TAG);
            return false;
        }
        if (mode != 5 && mode != 7) {
            AbstractC2322a.m1631u(mode, "Not support mode=", TAG);
            return false;
        }
        View penView = getPenView();
        View sizeView = getSizeView();
        if (penView == null || sizeView == null) {
            return false;
        }
        this.mViewMode = mode;
        int pixelSize = getPixelSize(C7932R.dimen.setting_pen_layout_attr_group_height_in_no_type);
        int pixelSize2 = getPixelSize(C7932R.dimen.setting_pen_layout_size_margin_top_in_no_type);
        if (isContainMode(mode, 2)) {
            pixelSize = getPixelSize(C7932R.dimen.setting_pen_layout_attr_group_height);
            pixelSize2 = getPixelSize(C7932R.dimen.setting_pen_layout_size_margin_top_default);
        } else {
            i = 8;
        }
        penView.setVisibility(i);
        View view = this.mDivider;
        if (view != null) {
            view.setVisibility(i);
        }
        LinearLayout linearLayout = this.mAttrGroup;
        ViewGroup.LayoutParams layoutParams = linearLayout != null ? linearLayout.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        AbstractC6670b.m4744e(layoutParams2.height, pixelSize, "setViewMode() attrHeight=", " -> containerHeight=", TAG);
        layoutParams2.height = pixelSize;
        LinearLayout linearLayout2 = this.mAttrGroup;
        if (linearLayout2 != null) {
            linearLayout2.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = sizeView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
        layoutParams4.topMargin = pixelSize2;
        sizeView.setLayoutParams(layoutParams4);
        return true;
    }

    public /* synthetic */ SpenPenSettingPortraitLayout(Context context, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? false : z);
    }
}
