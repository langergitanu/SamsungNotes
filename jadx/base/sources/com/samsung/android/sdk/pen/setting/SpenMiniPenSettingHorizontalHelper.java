package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniPenSettingHorizontalHelper;", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenSettingVerticalHelper;", "<init>", "()V", "defaultWidth", "", "getDefaultWidth", "()I", "defaultHeight", "getDefaultHeight", "createPenParam", "Landroid/view/ViewGroup$LayoutParams;", "context", "Landroid/content/Context;", "createColorParam", "createSizeParam", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenMiniPenSettingHorizontalHelper extends SpenMiniPenSettingVerticalHelper {

    @NotNull
    private static final String TAG = "SpenMiniPenSettingHorizontalHelper";

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingVerticalHelper, com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    @NotNull
    public ViewGroup.LayoutParams createColorParam(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.i(TAG, "createColorParam()");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(getDefaultWidth(), getDefaultHeight());
        layoutParams.startToEnd = getPenId();
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.setMarginStart(context.getResources().getDimensionPixelSize(C7932R.dimen.mini_pen_setting_color_item_land_margin_start));
        return layoutParams;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingVerticalHelper, com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    @NotNull
    public ViewGroup.LayoutParams createPenParam(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.i(TAG, "createPenParam()");
        Resources resources = context.getResources();
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(context.getResources().getDimensionPixelSize(C7932R.dimen.mini_pen_setting_pen_item_land_width), context.getResources().getDimensionPixelSize(C7932R.dimen.mini_pen_setting_pen_item_land_height));
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.startToStart = 0;
        layoutParams.setMarginStart(resources.getDimensionPixelSize(C7932R.dimen.mini_pen_setting_pen_item_land_margin_start));
        return layoutParams;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingVerticalHelper, com.samsung.android.sdk.pen.setting.SpenMiniPenSettingLayoutInterface
    @NotNull
    public ViewGroup.LayoutParams createSizeParam(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.i(TAG, "createSizeParam()");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.startToEnd = getColorGroupId();
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.endToEnd = 0;
        layoutParams.setMarginStart(context.getResources().getDimensionPixelSize(C7932R.dimen.mini_pen_setting_attr_item_margin_top));
        layoutParams.setMarginEnd(context.getResources().getDimensionPixelSize(C7932R.dimen.mini_pen_setting_attr_item_margin_bottom));
        return layoutParams;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingVerticalHelper
    public int getDefaultHeight() {
        return -1;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenSettingVerticalHelper
    public int getDefaultWidth() {
        return -2;
    }
}
