package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.pen.setting.common.SpenConsumedListener;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.sdk.pen.setting.common.SpenTouchDelegate;
import com.samsung.android.sdk.pen.setting.common.SpenVoiceAssistantAsButton;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilDrawable;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 12\u00020\u0001:\u00011B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u001f\u001a\u00020\u0013J\u0018\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020\u0016J\u0018\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0013J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0016J2\u0010\u0014\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020%H\u0002J\u0018\u0010-\u001a\u00020\u00132\u0006\u0010,\u001a\u00020%2\u0006\u0010.\u001a\u00020/H\u0002J \u00100\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%2\u0006\u0010,\u001a\u00020%2\u0006\u0010.\u001a\u00020/H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenSettingChild;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mConsumedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenConsumedListener;", "mTotalLayout", "Landroid/view/ViewGroup;", "mTotalBg", "Landroid/view/View;", "mPreviewParent", "mSliderGroup", "Landroid/widget/LinearLayout;", "mDivider", "close", "", "setRoundedBackground", "radius", "", "bgColor", "strokeSize", "strokeColor", "makeBottomButton", "text", "", "setPreview", "preview", "clearSliderGroup", "addSliderView", "child", "topMargin", "initView", "parent", "Landroid/widget/FrameLayout;", "resource", "rearrange", "setDividerVisibility", "visibility", "view", "initBase", "totalLayoutContainer", "initChild", "res", "Landroid/content/res/Resources;", "initBackground", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenBrushPenSettingChild {

    @NotNull
    private static final String TAG = "SpenBrushSettingLayout";

    @Nullable
    private final Context context;

    @Nullable
    private SpenConsumedListener mConsumedListener;

    @Nullable
    private View mDivider;

    @Nullable
    private ViewGroup mPreviewParent;

    @Nullable
    private LinearLayout mSliderGroup;

    @Nullable
    private View mTotalBg;

    @Nullable
    private ViewGroup mTotalLayout;

    public SpenBrushPenSettingChild(@Nullable Context context) {
        this.context = context;
    }

    private final void initBackground(FrameLayout parent, FrameLayout totalLayoutContainer, Resources res) {
        this.mTotalBg = totalLayoutContainer.findViewById(C7932R.id.drawing_brush_setting_popup_view_body);
        SpenConsumedListener spenConsumedListener = new SpenConsumedListener();
        this.mConsumedListener = spenConsumedListener;
        spenConsumedListener.setConsumedListener(parent, this.mTotalBg);
        setRoundedBackground(this.mTotalBg, res.getDimensionPixelSize(C7932R.dimen.setting_brush_radius_default), SpenSettingUtil.getColor(this.context, C7932R.color.setting_brush_bg_color), res.getDimensionPixelSize(C7932R.dimen.setting_brush_stroke_default), SpenSettingUtil.getColor(this.context, C7932R.color.setting_brush_bg_stroke_color));
    }

    private final void initBase(FrameLayout totalLayoutContainer) {
        View viewFindViewById = totalLayoutContainer.findViewById(C7932R.id.drawing_brush_setting_popup_view);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) viewFindViewById;
        viewGroup.setImportantForAccessibility(2);
        this.mTotalLayout = viewGroup;
    }

    private final void initChild(FrameLayout totalLayoutContainer, Resources res) {
        this.mPreviewParent = (ViewGroup) totalLayoutContainer.findViewById(C7932R.id.drawing_brush_setting_popup_preview);
        View viewFindViewById = totalLayoutContainer.findViewById(C7932R.id.drawing_brush_setting_popup_seekbar);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        LinearLayout linearLayout = new LinearLayout(this.context);
        this.mSliderGroup = linearLayout;
        linearLayout.setOrientation(1);
        ((RelativeLayout) viewFindViewById).addView(this.mSliderGroup, new LinearLayout.LayoutParams(-1, -2));
    }

    public final void addSliderView(@Nullable View child, int topMargin) {
        if (child == null || this.mSliderGroup == null) {
            return;
        }
        child.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = topMargin;
        LinearLayout linearLayout = this.mSliderGroup;
        if (linearLayout != null) {
            linearLayout.addView(child, layoutParams);
        }
    }

    public final void clearSliderGroup() {
        LinearLayout linearLayout = this.mSliderGroup;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    public void close() {
        if (this.context == null) {
            return;
        }
        SpenConsumedListener spenConsumedListener = this.mConsumedListener;
        if (spenConsumedListener != null) {
            spenConsumedListener.close();
        }
        this.mConsumedListener = null;
        this.mDivider = null;
    }

    @Nullable
    public final Context getContext() {
        return this.context;
    }

    public final void initView(@Nullable FrameLayout parent, int resource) {
        Log.i(TAG, "initView");
        Context context = this.context;
        if (context == null || parent == null) {
            return;
        }
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(resource, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) viewInflate;
        parent.addView(frameLayout);
        Resources resources = this.context.getResources();
        initBase(frameLayout);
        if (resource == C7932R.layout.setting_brush_setting_popup_layout) {
            ((HorizontalScrollView) frameLayout.findViewById(C7932R.id.drawing_brush_setting_popup_horizontal_view)).setFocusable(false);
            this.mDivider = frameLayout.findViewById(C7932R.id.drawing_brush_setting_divider);
            Intrinsics.checkNotNull(resources);
            initBackground(parent, frameLayout, resources);
        }
        Intrinsics.checkNotNull(resources);
        initChild(frameLayout, resources);
    }

    @Nullable
    public final View makeBottomButton(@Nullable CharSequence text) {
        Context context = this.context;
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        ViewGroup viewGroup = this.mTotalLayout;
        View viewFindViewById = viewGroup != null ? viewGroup.findViewById(C7932R.id.drawing_brush_setting_popup_item_content) : null;
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById;
        View view = new View(this.context);
        view.setBackgroundResource(C7932R.drawable.spen_color_picker_recent_used_color_divider_shape);
        int dimensionPixelSize = resources.getDimensionPixelSize(C7932R.dimen.drawing_brush_setting_popup_clear_button_divider_side_margin);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(C7932R.dimen.drawing_brush_setting_popup_clear_button_divider_height));
        layoutParams.setMarginStart(dimensionPixelSize);
        layoutParams.setMarginEnd(dimensionPixelSize);
        linearLayout.addView(view, layoutParams);
        Object systemService = this.context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C7932R.layout.setting_brush_setting_popup_eraseall, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(C7932R.dimen.drawing_brush_setting_popup_clear_button_height));
        layoutParams2.topMargin = resources.getDimensionPixelSize(C7932R.dimen.drawing_brush_setting_popup_clear_button_top_margin);
        linearLayout.addView(relativeLayout, layoutParams2);
        View childAt = relativeLayout.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText");
        SpenShowButtonShapeText spenShowButtonShapeText = (SpenShowButtonShapeText) childAt;
        spenShowButtonShapeText.setText(text);
        SpenSettingUtilText.setDefaultButtonTextStyle(this.context, spenShowButtonShapeText);
        SpenSettingUtilText.applyUpToLargeLevel(this.context, 16.0f, spenShowButtonShapeText);
        spenShowButtonShapeText.setButtonShapeEnabled(true);
        SpenTouchDelegate.setDelegateToParent(relativeLayout, spenShowButtonShapeText);
        spenShowButtonShapeText.setAccessibilityDelegate(new SpenVoiceAssistantAsButton());
        return spenShowButtonShapeText;
    }

    public final void rearrange() {
        ViewGroup viewGroup = this.mTotalLayout;
        if (viewGroup != null) {
            viewGroup.getLayoutParams().height = -2;
            viewGroup.requestLayout();
        }
    }

    public final void setDividerVisibility(int visibility) {
        View view = this.mDivider;
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    public final void setPreview(@Nullable View preview) {
        ViewGroup viewGroup = this.mPreviewParent;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ViewGroup viewGroup2 = this.mPreviewParent;
        if (viewGroup2 != null) {
            viewGroup2.addView(preview);
        }
    }

    public final void setRoundedBackground(int radius, int bgColor, int strokeSize, int strokeColor) {
        setRoundedBackground(this.mTotalBg, radius, bgColor, strokeSize, strokeColor);
    }

    private final void setRoundedBackground(View view, int radius, int bgColor, int strokeSize, int strokeColor) {
        if (view == null) {
            return;
        }
        SpenSettingUtilDrawable.setRoundedCornerBackground(view, radius, bgColor, strokeSize, strokeColor);
        view.setClipToOutline(true);
    }
}
