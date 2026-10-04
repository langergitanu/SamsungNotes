package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0016\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniPenSettingVerticalHelper;", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenSettingLayoutInterface;", "<init>", "()V", "getPenId", "", "getPenPopupId", "getColorId", "getColorGroupId", "getColorPopupId", "getSizeId", "getSizePopupId", "getPatternId", "getPatternPopupId", "createContentParam", "Landroid/widget/FrameLayout$LayoutParams;", "createPenParam", "Landroid/view/ViewGroup$LayoutParams;", "context", "Landroid/content/Context;", "createColorParam", "createSizeParam", "defaultWidth", "getDefaultWidth", "()I", "defaultHeight", "getDefaultHeight", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenMiniPenSettingVerticalHelper implements SpenMiniPenSettingLayoutInterface {
    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    @NotNull
    public ViewGroup.LayoutParams createColorParam(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(getDefaultWidth(), getDefaultHeight());
        layoutParams.topToBottom = getPenId();
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.mini_pen_setting_color_item_margin_top);
        return layoutParams;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    @NotNull
    public FrameLayout.LayoutParams createContentParam() {
        return new FrameLayout.LayoutParams(getDefaultWidth(), getDefaultHeight());
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    @NotNull
    public ViewGroup.LayoutParams createPenParam(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(getDefaultWidth(), getDefaultHeight());
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.mini_pen_setting_pen_item_margin_top);
        return layoutParams;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    @NotNull
    public ViewGroup.LayoutParams createSizeParam(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToBottom = getColorGroupId();
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.mini_pen_setting_attr_item_margin_top);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.mini_pen_setting_attr_item_margin_bottom);
        return layoutParams;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    public int getColorGroupId() {
        return C7932R.id.mini_pen_color_view_group;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    public int getColorId() {
        return C7932R.id.mini_pen_color_view;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    public int getColorPopupId() {
        return C7932R.id.mini_pen_color_popup_view;
    }

    public int getDefaultHeight() {
        return -2;
    }

    public int getDefaultWidth() {
        return -1;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    public int getPatternId() {
        return C7932R.id.mini_pen_pattern_view;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    public int getPatternPopupId() {
        return C7932R.id.mini_pen_pattern_popup_view;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    public int getPenId() {
        return C7932R.id.mini_pen_view;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    public int getPenPopupId() {
        return C7932R.id.mini_pen_list_popup_view;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    public int getSizeId() {
        return C7932R.id.mini_pen_size_view;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    public int getSizePopupId() {
        return C7932R.id.mini_pen_size_popup_view;
    }
}
