package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016JX\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001c2\b\u0010!\u001a\u0004\u0018\u00010\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\b\u0010(\u001a\u00020\u0012H\u0016J\b\u0010)\u001a\u00020\u0012H\u0016J\b\u0010*\u001a\u00020\u0012H\u0016J\b\u0010+\u001a\u00020\u0012H\u0016J\u0010\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0012H\u0016J0\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0012H\u0016J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0012H\u0016J\u0014\u00106\u001a\u0004\u0018\u00010\u001c2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020\tH\u0016J\u0010\u0010:\u001a\u00020\u00152\b\u0010;\u001a\u0004\u0018\u00010<R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenSettingLandscapeLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenLayoutInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mLayoutManager", "Lcom/samsung/android/sdk/pen/setting/SpenPenLayoutManager;", "mViewMode", "", "mLandscapeContentParent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mPenGroup", "mAttrRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mAttrAdapter", "Lcom/samsung/android/sdk/pen/setting/SpenPenLandscapeAttrAdapter;", "mIsTopView", "", "mTopViewMargin", "close", "", "setContentView", "contentView", "Landroid/widget/LinearLayout;", "detachChild", "attachChild", "sizeView", "Landroid/view/View;", "penView", "colorView", "patternView", "alphaView", "widthView", "dynamicSizeView", "opacityOptionView", "setViewMode", "mode", "getViewMode", "isVisiblePatternView", "isVisibleAlphaView", "isVisibleWidthView", "isVisibleDynamicSizeView", "isVisibleOpacityOptionView", "setPatternViewVisibility", "isVisible", "setAttributeGroupVisibility", "isAlphaVisible", "isWidthVisible", "isDynamicSizeVisible", "isOpacityOptionVisible", "animation", "setIsTopView", "isTop", "addActionButton", "text", "", "getActionButtonCount", "setChangeBoundRoot", "root", "Landroid/view/ViewGroup;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenPenSettingLandscapeLayout implements SpenLayoutInterface {

    @NotNull
    private static final String TAG = "SpenPenSettingLandscapeLayout";

    @Nullable
    private SpenPenLandscapeAttrAdapter mAttrAdapter;

    @Nullable
    private RecyclerView mAttrRecyclerView;
    private boolean mIsTopView;

    @Nullable
    private ConstraintLayout mLandscapeContentParent;

    @NotNull
    private final SpenPenLayoutManager mLayoutManager;

    @Nullable
    private ConstraintLayout mPenGroup;
    private int mTopViewMargin;
    private int mViewMode;

    public SpenPenSettingLandscapeLayout(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLayoutManager = new SpenPenLayoutManager(context);
        this.mTopViewMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_pen_layout_content_padding_top);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    @Nullable
    public View addActionButton(@Nullable CharSequence text) {
        return this.mLayoutManager.addActionButton(text);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public void attachChild(@Nullable View sizeView, @Nullable View penView, @Nullable View colorView, @Nullable View patternView, @Nullable View alphaView, @Nullable View widthView, @Nullable View dynamicSizeView, @Nullable View opacityOptionView) {
        Log.i(TAG, "attachChild()");
        LinearLayout contentBody = this.mLayoutManager.getContentBody();
        if (contentBody == null) {
            return;
        }
        if (this.mLandscapeContentParent == null) {
            Log.i(TAG, "contentParent is not null. so return.");
        }
        Context context = this.mLayoutManager.getContext();
        this.mLayoutManager.setContentBodyTopPadding(this.mIsTopView ? this.mTopViewMargin : 0);
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C7932R.layout.setting_pen_landscape, (ViewGroup) contentBody, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
        this.mLandscapeContentParent = constraintLayout;
        if (constraintLayout != null) {
            contentBody.addView(constraintLayout, 0);
            this.mPenGroup = (ConstraintLayout) constraintLayout.findViewById(C7932R.id.pen_setting_pen_group);
            this.mAttrRecyclerView = (RecyclerView) constraintLayout.findViewById(C7932R.id.pen_setting_attr_group);
        }
        if (penView != null) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.startToStart = 0;
            layoutParams.setMarginStart(this.mLayoutManager.getPixelSize(C7932R.dimen.setting_pen_layout_landscape_pen_margin_start));
            layoutParams.bottomToBottom = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.mLayoutManager.getPixelSize(C7932R.dimen.setting_pen_layout_landscape_bottom_margin);
            ConstraintLayout constraintLayout2 = this.mPenGroup;
            if (constraintLayout2 != null) {
                constraintLayout2.addView(penView, layoutParams);
            }
            this.mLayoutManager.setPenView(penView);
            this.mViewMode |= 2;
            int color = SpenSettingUtil.getColor(context, C7932R.color.setting_handwriting_pen_divider);
            FrameLayout frameLayout = new FrameLayout(context);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(this.mLayoutManager.getPixelSize(C7932R.dimen.setting_pen_layout_landscape_divider_width), this.mLayoutManager.getPixelSize(C7932R.dimen.setting_pen_layout_divider_height));
            layoutParams2.startToStart = 0;
            layoutParams2.setMarginStart(this.mLayoutManager.getPixelSize(C7932R.dimen.setting_pen_layout_landscape_divider_margin_start));
            layoutParams2.bottomToBottom = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = this.mLayoutManager.getPixelSize(C7932R.dimen.setting_pen_layout_landscape_divider_margin_bottom);
            ConstraintLayout constraintLayout3 = this.mPenGroup;
            if (constraintLayout3 != null) {
                constraintLayout3.addView(frameLayout, layoutParams2);
            }
            View view = new View(context);
            view.setBackgroundColor(color);
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, this.mLayoutManager.getPixelSize(C7932R.dimen.common_setting_divider_stroke)));
        }
        SpenPenLayoutManager spenPenLayoutManager = this.mLayoutManager;
        spenPenLayoutManager.setPenView(penView);
        spenPenLayoutManager.setSizeView(sizeView);
        spenPenLayoutManager.setAlphaView(alphaView);
        spenPenLayoutManager.setWidthView(widthView);
        spenPenLayoutManager.setDynamicSizeView(dynamicSizeView);
        spenPenLayoutManager.setOpacityOptionView(opacityOptionView);
        spenPenLayoutManager.setColorView(colorView);
        spenPenLayoutManager.setPatternView(patternView);
        if (sizeView != null) {
            this.mViewMode |= 1;
        }
        if (colorView != null) {
            this.mViewMode |= 4;
        }
        RecyclerView recyclerView = this.mAttrRecyclerView;
        if (recyclerView != null) {
            SpenPenLandscapeAttrAdapter spenPenLandscapeAttrAdapter = new SpenPenLandscapeAttrAdapter(context);
            this.mAttrAdapter = spenPenLandscapeAttrAdapter;
            spenPenLandscapeAttrAdapter.setLayoutManager(this.mLayoutManager);
            recyclerView.setAdapter(this.mAttrAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        }
        SpenPenLayoutManager spenPenLayoutManager2 = this.mLayoutManager;
        spenPenLayoutManager2.setContentBottomPadding(spenPenLayoutManager2.getPixelSize(C7932R.dimen.setting_pen_layout_landscape_content_padding_bottom));
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public void close() {
        Log.i(TAG, "close()");
        this.mViewMode = 0;
        detachChild();
        this.mLayoutManager.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public void detachChild() {
        Log.i(TAG, "detachChild()");
        SpenPenLandscapeAttrAdapter spenPenLandscapeAttrAdapter = this.mAttrAdapter;
        if (spenPenLandscapeAttrAdapter != null) {
            spenPenLandscapeAttrAdapter.detachChild();
        }
        ConstraintLayout constraintLayout = this.mPenGroup;
        if (constraintLayout != null) {
            constraintLayout.removeAllViews();
        }
        ConstraintLayout constraintLayout2 = this.mLandscapeContentParent;
        if (constraintLayout2 != null) {
            constraintLayout2.removeAllViews();
        }
        this.mLandscapeContentParent = null;
        this.mLayoutManager.resetContentView();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public int getActionButtonCount() {
        return this.mLayoutManager.getActionButtonCount();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    /* JADX INFO: renamed from: getViewMode, reason: from getter */
    public int getMViewMode() {
        return this.mViewMode;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean isVisibleAlphaView() {
        View alphaView = this.mLayoutManager.getAlphaView();
        return alphaView != null && alphaView.getVisibility() == 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean isVisibleDynamicSizeView() {
        View dynamicSizeView = this.mLayoutManager.getDynamicSizeView();
        return dynamicSizeView != null && dynamicSizeView.getVisibility() == 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean isVisibleOpacityOptionView() {
        View opacityOptionView = this.mLayoutManager.getOpacityOptionView();
        return opacityOptionView != null && opacityOptionView.getVisibility() == 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean isVisiblePatternView() {
        View patternView = this.mLayoutManager.getPatternView();
        return patternView != null && patternView.getVisibility() == 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean isVisibleWidthView() {
        View widthView = this.mLayoutManager.getWidthView();
        return widthView != null && widthView.getVisibility() == 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean setAttributeGroupVisibility(boolean isAlphaVisible, boolean isWidthVisible, boolean isDynamicSizeVisible, boolean isOpacityOptionVisible, boolean animation) {
        SpenPenLandscapeAttrAdapter spenPenLandscapeAttrAdapter = this.mAttrAdapter;
        if (spenPenLandscapeAttrAdapter != null) {
            return spenPenLandscapeAttrAdapter.setAttributeVisibility(isAlphaVisible, isWidthVisible, isDynamicSizeVisible, isOpacityOptionVisible, animation);
        }
        return false;
    }

    public final void setChangeBoundRoot(@Nullable ViewGroup root) {
        this.mLayoutManager.setChangeBoundsRoot(root);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public void setContentView(@Nullable LinearLayout contentView) {
        Log.i(TAG, "setContentView()");
        this.mLayoutManager.setContentView(contentView);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public void setIsTopView(boolean isTop) {
        Log.i(TAG, "setTitleVisibilityChanged() visibility=" + isTop + "]");
        if (this.mIsTopView == isTop) {
            return;
        }
        this.mIsTopView = isTop;
        this.mLayoutManager.setContentBodyTopPadding(isTop ? this.mTopViewMargin : 0);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean setPatternViewVisibility(boolean isVisible) {
        return this.mLayoutManager.setPatternViewVisibility(isVisible);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenLayoutInterface
    public boolean setViewMode(int mode) {
        Log.i(TAG, "Not support mode=" + mode);
        if (getMViewMode() == mode) {
            AbstractC2322a.m1631u(mode, "SAME ViewMode=", TAG);
            return true;
        }
        if (mode == 7) {
            return true;
        }
        AbstractC2322a.m1631u(mode, "Not support mode=", TAG);
        return false;
    }
}
