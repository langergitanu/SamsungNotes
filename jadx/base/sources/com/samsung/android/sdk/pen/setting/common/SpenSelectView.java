package com.samsung.android.sdk.pen.setting.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0001\u0018\u0000 -2\u00020\u0001:\u0001-B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u0018J&\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u000eJ\u0016\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001aJ\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J(\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000eH\u0002J\u001a\u0010,\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSelectView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mChip", "Lcom/samsung/android/sdk/pen/setting/common/SpenRoundLayout;", "mCheckView", "Landroid/view/View;", "mSelectedMargin", "", "mUnSelectedMargin", "mSelectedElevation", "mUnSelectedElevation", "mTopLeftRadius", "", "mTopRightRadius", "mBottomLeftRadius", "mBottomRightRadius", "setSelected", "", "selected", "", "close", "setRadius", "topLeftRadius", "topRightRadius", "bottomRightRadius", "bottomLeftRadius", "setCheckColor", "color", "animation", "initView", "applyRadius", "updateCurrentLayout", "adjustMargin", "top", "bottom", "start", "end", "getAttributes", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"AppCompatCustomView"})
public final class SpenSelectView extends FrameLayout {
    public static final boolean APPLY_ONE_UI_70 = false;

    @NotNull
    private static final String TAG = "SpenSelectView";
    private float mBottomLeftRadius;
    private float mBottomRightRadius;

    @Nullable
    private View mCheckView;

    @Nullable
    private SpenRoundLayout mChip;
    private int mSelectedElevation;
    private int mSelectedMargin;
    private float mTopLeftRadius;
    private float mTopRightRadius;
    private int mUnSelectedElevation;
    private int mUnSelectedMargin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSelectView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }

    private final void adjustMargin(int top, int bottom, int start, int end) {
        SpenRoundLayout spenRoundLayout = this.mChip;
        ViewGroup.LayoutParams layoutParams = spenRoundLayout != null ? spenRoundLayout.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(start);
        layoutParams2.setMarginEnd(end);
        layoutParams2.topMargin = top;
        layoutParams2.bottomMargin = bottom;
        SpenRoundLayout spenRoundLayout2 = this.mChip;
        if (spenRoundLayout2 != null) {
            spenRoundLayout2.setLayoutParams(layoutParams2);
        }
    }

    private final void applyRadius() {
        SpenRoundLayout spenRoundLayout = this.mChip;
        if (spenRoundLayout != null) {
            spenRoundLayout.setRadius(this.mTopLeftRadius, this.mTopRightRadius, this.mBottomRightRadius, this.mBottomLeftRadius);
        }
    }

    private final void getAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C7932R.styleable.SpenSelectView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenSelectView_radius, -1);
            if (dimensionPixelOffset > -1.0f) {
                setRadius(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            } else {
                setRadius(typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenSelectView_topLeftRadius, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenSelectView_topRightRadius, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenSelectView_bottomRightRadius, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenSelectView_bottomLeftRadius, 0));
            }
            this.mSelectedMargin = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenSelectView_selectedMargin, 0);
            this.mUnSelectedMargin = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenSelectView_unselectedMargin, 0);
            this.mSelectedElevation = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenSelectView_selectedElevation, 0);
            this.mUnSelectedElevation = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenSelectView_unselectedElevation, 0);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private final void initView(Context context) {
        View.inflate(getContext(), C7932R.layout.setting_select_view, this);
        this.mChip = (SpenRoundLayout) findViewById(C7932R.id.chip);
        View viewFindViewById = findViewById(C7932R.id.select_icon);
        this.mCheckView = viewFindViewById;
        if (this.mChip == null || viewFindViewById == null) {
            return;
        }
        SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
        spenGradientDrawableHelper.setDrawableInfo(0, SpenSettingUtil.getColor(context, C7932R.color.setting_bg_color), 0, 0);
        spenGradientDrawableHelper.setRectRadius(this.mTopLeftRadius, this.mTopRightRadius, this.mBottomRightRadius, this.mBottomLeftRadius);
        SpenRoundLayout spenRoundLayout = this.mChip;
        if (spenRoundLayout != null) {
            spenRoundLayout.setBackground(spenGradientDrawableHelper.makeDrawable());
        }
        applyRadius();
        setSelected(false);
    }

    private final void updateCurrentLayout(boolean selected) {
        SpenRoundLayout spenRoundLayout = this.mChip;
        if (spenRoundLayout != null) {
            if (selected) {
                int i = this.mSelectedMargin;
                adjustMargin(i, i, i, i);
                spenRoundLayout.setElevation(this.mSelectedElevation);
            } else {
                spenRoundLayout.setElevation(this.mUnSelectedElevation);
                int i2 = this.mUnSelectedMargin;
                adjustMargin(i2, i2, i2, i2);
            }
        }
    }

    public final void close() {
        this.mChip = null;
        this.mCheckView = null;
    }

    public final void setCheckColor(int color) {
        View view = this.mCheckView;
        if (view != null) {
            view.setBackgroundTintList(ColorStateList.valueOf(color));
        }
    }

    public final void setRadius(float topLeftRadius, float topRightRadius, float bottomRightRadius, float bottomLeftRadius) {
        this.mTopLeftRadius = topLeftRadius;
        this.mTopRightRadius = topRightRadius;
        this.mBottomRightRadius = bottomRightRadius;
        this.mBottomLeftRadius = bottomLeftRadius;
        applyRadius();
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        setSelected(selected, false);
    }

    public final boolean setSelected(boolean selected, boolean animation) {
        boolean z = selected != isSelected();
        super.setSelected(selected);
        View view = this.mCheckView;
        if (view == null) {
            return z;
        }
        if (selected) {
            if (view != null) {
                view.setVisibility(0);
            }
            if (animation) {
                SpenSettingUtilAnimation.colorSelectAnimation(this.mCheckView);
            }
        } else if (view != null) {
            view.setVisibility(8);
        }
        updateCurrentLayout(selected);
        return z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        getAttributes(context, attributeSet);
        initView(context);
    }
}
