package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.setting.common.SpenConsumedListener;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 J2\u00020\u0001:\u0001JB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u0018J\u0010\u0010)\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010J\u001a\u0010*\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010+\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020$H\u0016J\b\u0010.\u001a\u00020$H\u0016J\u000e\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u0018J\u000e\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u0018J\u0012\u00103\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0004J\u001a\u00103\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u000104J\u0012\u00105\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0004J\u0010\u00106\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010J\u000e\u00107\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u0018J&\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020$J\b\u0010=\u001a\u00020\u0018H\u0016J\u000e\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u0018J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u0018H\u0016J\u0010\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020\u0018H\u0016J\u0018\u0010F\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\u0018\u0010G\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u0018H\u0002J\b\u0010I\u001a\u00020\u001aH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPopupMiniLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "layoutInterface", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPopupLayoutInterface;", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/SpenMiniPopupLayoutInterface;)V", "mHeaderGroup", "Landroid/widget/LinearLayout;", "mFooterGroup", "mContentView", "mRootView", "Landroid/view/ViewGroup;", "mHeaderDivider", "Landroid/view/View;", "mFooterDivider", "mConsumedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenConsumedListener;", "mLayoutInterface", "mBgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "mBgColor", "", "close", "", "setLayoutInterface", "addDefaultHeaderView", "view", "addHeaderView", ActionHandler.PARAMS, "Landroid/widget/LinearLayout$LayoutParams;", "removeHeaderView", "setHeaderDividerEnabled", "headerDividerEnabled", "", "isHeaderDividerEnabled", "getHeaderDivider", "setHeaderGroupVisibility", "visibility", "addDefaultFooterView", "addFooterView", "removeFooterView", "setFooterDividerEnabled", "footerDividerEnabled", "isFooterDividerEnabled", "setFooterOverlapMargin", "margin", "setFooterTopToBottom", "topToBottom", "setContentView", "Landroid/widget/FrameLayout$LayoutParams;", "removeContentView", "addPopupView", "setContentVisibility", "changeBgRound", "roundedLeftTop", "roundedRightTop", "roundedRightBottom", "roundedLeftBottom", "getDefaultBgColor", "setBgColor", "color", "setBackgroundColor", "setBackground", "background", "Landroid/graphics/drawable/Drawable;", BaseWidgetConstant.SET_BACKGROUND_RESOURCE, "resid", "initBackground", "initView", "childLayoutId", "clearView", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenPopupMiniLayout extends FrameLayout {

    @NotNull
    private static final String TAG = "SpenMiniPopupLayout";
    private int mBgColor;

    @Nullable
    private GradientDrawable mBgDrawable;

    @Nullable
    private SpenConsumedListener mConsumedListener;

    @Nullable
    private FrameLayout mContentView;

    @Nullable
    private View mFooterDivider;

    @Nullable
    private LinearLayout mFooterGroup;

    @Nullable
    private View mHeaderDivider;

    @Nullable
    private LinearLayout mHeaderGroup;

    @Nullable
    private SpenMiniPopupLayoutInterface mLayoutInterface;

    @Nullable
    private ViewGroup mRootView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPopupMiniLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void clearView() {
        SpenConsumedListener spenConsumedListener = this.mConsumedListener;
        if (spenConsumedListener != null) {
            spenConsumedListener.close();
        }
        this.mConsumedListener = null;
        this.mBgDrawable = null;
        FrameLayout frameLayout = this.mContentView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.mContentView = null;
        this.mFooterDivider = null;
        this.mFooterGroup = null;
        this.mHeaderDivider = null;
        this.mHeaderGroup = null;
        this.mRootView = null;
    }

    private final void initBackground(Context context, ViewGroup view) {
        Resources resources = context.getResources();
        view.setElevation(resources.getDimensionPixelSize(C7932R.dimen.setting_popup_bg_elevation));
        int dimensionPixelSize = resources.getDimensionPixelSize(C7932R.dimen.setting_favorite_pen_layout_stroke_border);
        int color = SpenSettingUtil.getColor(context, C7932R.color.setting_favorite_stroke_border_color);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C7932R.dimen.mini_popup_radius);
        this.mBgColor = SpenSettingUtil.getColor(context, C7932R.color.setting_bg_color);
        SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
        spenGradientDrawableHelper.setDrawableInfo(0, this.mBgColor, dimensionPixelSize, color);
        float f = dimensionPixelSize2;
        spenGradientDrawableHelper.setRectRadius(f, f, f, f);
        GradientDrawable gradientDrawableMakeDrawable = spenGradientDrawableHelper.makeDrawable();
        this.mBgDrawable = gradientDrawableMakeDrawable;
        view.setBackground(gradientDrawableMakeDrawable);
        SpenSettingUtil.setShadowAlpha(view, 0.5f);
    }

    private final void initView(Context context, int childLayoutId) {
        LayoutInflater.from(context).inflate(childLayoutId, (ViewGroup) this, true);
        initBackground(context, this);
        this.mHeaderGroup = (LinearLayout) findViewById(C7932R.id.header_area);
        this.mHeaderDivider = findViewById(C7932R.id.header_divider);
        this.mFooterGroup = (LinearLayout) findViewById(C7932R.id.footer_area);
        this.mFooterDivider = findViewById(C7932R.id.footer_divider);
        this.mContentView = (FrameLayout) findViewById(C7932R.id.content_area);
        this.mRootView = (ViewGroup) findViewById(C7932R.id.root_layout);
        SpenConsumedListener spenConsumedListener = new SpenConsumedListener();
        this.mConsumedListener = spenConsumedListener;
        spenConsumedListener.setConsumedListener(this, this.mRootView);
    }

    public final void addDefaultFooterView(@Nullable View view) {
        SpenMiniPopupLayoutInterface spenMiniPopupLayoutInterface = this.mLayoutInterface;
        if (spenMiniPopupLayoutInterface != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            addFooterView(view, spenMiniPopupLayoutInterface.getDefaultButtonParams(context));
        }
    }

    public final void addDefaultHeaderView(@Nullable View view) {
        SpenMiniPopupLayoutInterface spenMiniPopupLayoutInterface = this.mLayoutInterface;
        if (spenMiniPopupLayoutInterface != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            addHeaderView(view, spenMiniPopupLayoutInterface.getDefaultButtonParams(context));
        }
    }

    public final void addFooterView(@Nullable View view, @Nullable LinearLayout.LayoutParams params) {
        LinearLayout linearLayout = this.mFooterGroup;
        if (linearLayout != null) {
            if (params != null) {
                linearLayout.addView(view, params);
            } else {
                linearLayout.addView(view);
            }
        }
    }

    public final void addHeaderView(@Nullable View view, @Nullable LinearLayout.LayoutParams params) {
        LinearLayout linearLayout = this.mHeaderGroup;
        if (linearLayout != null) {
            if (params != null) {
                linearLayout.addView(view, linearLayout.getChildCount() - 1, params);
            } else {
                linearLayout.addView(view, linearLayout.getChildCount() - 1);
            }
        }
    }

    public final void addPopupView(@Nullable View view) {
        SpenMiniPopupLayoutInterface spenMiniPopupLayoutInterface = this.mLayoutInterface;
        if (spenMiniPopupLayoutInterface != null) {
            spenMiniPopupLayoutInterface.addView(this.mRootView, view);
        }
    }

    public final void changeBgRound(boolean roundedLeftTop, boolean roundedRightTop, boolean roundedRightBottom, boolean roundedLeftBottom) {
        int i = roundedLeftTop ? 50 : 0;
        float f = i;
        float f4 = roundedRightTop ? 50 : 0;
        float f5 = roundedRightBottom ? 50 : 0;
        float f6 = roundedLeftBottom ? 50 : 0;
        float[] fArr = {f, f, f4, f4, f5, f5, f6, f6};
        GradientDrawable gradientDrawable = this.mBgDrawable;
        if (gradientDrawable != null) {
            gradientDrawable.setCornerRadii(fArr);
            setBackground(gradientDrawable);
        }
    }

    public void close() {
        clearView();
        this.mLayoutInterface = null;
    }

    /* JADX INFO: renamed from: getDefaultBgColor, reason: from getter */
    public int getMBgColor() {
        return this.mBgColor;
    }

    @Nullable
    /* JADX INFO: renamed from: getHeaderDivider, reason: from getter */
    public View getMHeaderDivider() {
        return this.mHeaderDivider;
    }

    public boolean isFooterDividerEnabled() {
        View view = this.mFooterDivider;
        return view != null && view.getVisibility() == 0;
    }

    public boolean isHeaderDividerEnabled() {
        View view = this.mHeaderDivider;
        return view != null && view.getVisibility() == 0;
    }

    public final void removeContentView(@Nullable View view) {
        FrameLayout frameLayout = this.mContentView;
        if (frameLayout != null) {
            frameLayout.removeView(view);
        }
    }

    public final void removeFooterView(@Nullable View view) {
        LinearLayout linearLayout = this.mFooterGroup;
        if (linearLayout != null) {
            linearLayout.removeView(view);
        }
    }

    public final void removeHeaderView(@Nullable View view) {
        LinearLayout linearLayout = this.mHeaderGroup;
        if (linearLayout != null) {
            linearLayout.removeView(view);
        }
    }

    @Override // android.view.View
    public void setBackground(@NotNull Drawable background) {
        Intrinsics.checkNotNullParameter(background, "background");
        super.setBackground(background);
        GradientDrawable gradientDrawable = this.mBgDrawable;
        if (gradientDrawable == null || Intrinsics.areEqual(gradientDrawable, background)) {
            return;
        }
        this.mBgDrawable = null;
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        this.mBgDrawable = null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int resid) {
        super.setBackgroundResource(resid);
        this.mBgDrawable = null;
    }

    public final void setBgColor(int color) {
        GradientDrawable gradientDrawable = this.mBgDrawable;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(color);
        }
    }

    public final void setContentView(@Nullable View view) {
        FrameLayout frameLayout = this.mContentView;
        if (frameLayout != null) {
            frameLayout.addView(view);
        }
    }

    public final void setContentVisibility(int visibility) {
        FrameLayout frameLayout = this.mContentView;
        if (frameLayout != null) {
            frameLayout.setVisibility(visibility);
        }
    }

    public void setFooterDividerEnabled(boolean footerDividerEnabled) {
        View view = this.mFooterDivider;
        if (view != null) {
            view.setVisibility(footerDividerEnabled ? 0 : 8);
        }
    }

    public final void setFooterOverlapMargin(int margin) {
        AbstractC2322a.m1631u(margin, "setOverlapMargin() margin=", TAG);
        SpenMiniPopupLayoutInterface spenMiniPopupLayoutInterface = this.mLayoutInterface;
        if (spenMiniPopupLayoutInterface != null) {
            spenMiniPopupLayoutInterface.adjustOverlapMargin(margin, this.mContentView, this.mFooterGroup);
        }
    }

    public final void setFooterTopToBottom(int topToBottom) {
        SpenMiniPopupLayoutInterface spenMiniPopupLayoutInterface = this.mLayoutInterface;
        if (spenMiniPopupLayoutInterface != null) {
            spenMiniPopupLayoutInterface.adjustFront(this.mFooterGroup, topToBottom);
        }
    }

    public void setHeaderDividerEnabled(boolean headerDividerEnabled) {
        View view = this.mHeaderDivider;
        if (view != null) {
            view.setVisibility(headerDividerEnabled ? 0 : 8);
        }
    }

    public final void setHeaderGroupVisibility(int visibility) {
        LinearLayout linearLayout = this.mHeaderGroup;
        if (linearLayout != null) {
            linearLayout.setVisibility(visibility);
        }
    }

    public final void setLayoutInterface(@Nullable SpenMiniPopupLayoutInterface layoutInterface) {
        ViewGroup viewGroup;
        Log.i(TAG, "setLayoutInterface()");
        if (this.mLayoutInterface != null && (viewGroup = this.mRootView) != null) {
            Intrinsics.checkNotNull(viewGroup, "null cannot be cast to non-null type android.view.ViewGroup");
            clearView();
            removeView(viewGroup);
        }
        this.mLayoutInterface = layoutInterface;
        if (layoutInterface == null) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context, layoutInterface.getMLayoutId());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPopupMiniLayout(@NotNull Context context, @Nullable SpenMiniPopupLayoutInterface spenMiniPopupLayoutInterface) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutInterface(spenMiniPopupLayoutInterface);
    }

    public final void setContentView(@Nullable View view, @Nullable FrameLayout.LayoutParams params) {
        FrameLayout frameLayout = this.mContentView;
        if (frameLayout != null) {
            frameLayout.addView(view, params);
        }
    }
}
