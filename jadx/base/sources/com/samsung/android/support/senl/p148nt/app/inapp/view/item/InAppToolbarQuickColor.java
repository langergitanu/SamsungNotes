package com.samsung.android.support.senl.p148nt.app.inapp.view.item;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppColorPickerLayout;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppSettingViewManager;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/item/InAppToolbarQuickColor;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItem;", "view", "Landroid/view/View;", "mInAppToolbarItemManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemContract;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemContract;)V", "mColorPickerChangedListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$ColorPickerChangedListener;", "mInAppSettingViewManager", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingViewManager;", "onClick", "", "showColorPicker", "callerType", "", "hsvColor", "", "setSelected", "", "selected", "functionEnable", "enable", "updateUIColor", "color", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppToolbarQuickColor extends HwToolbarItem {

    @NotNull
    private static final String TAG = "InAppToolbarQuickColor";

    @NotNull
    private final SpenColorPickerPopup.ColorPickerChangedListener mColorPickerChangedListener;

    @NotNull
    private final InAppSettingViewManager mInAppSettingViewManager;

    @NotNull
    private final HwToolbarItemContract mInAppToolbarItemManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppToolbarQuickColor(@Nullable View view, @NotNull HwToolbarItemContract mInAppToolbarItemManager) {
        super(view, mInAppToolbarItemManager);
        Intrinsics.checkNotNullParameter(mInAppToolbarItemManager, "mInAppToolbarItemManager");
        this.mInAppToolbarItemManager = mInAppToolbarItemManager;
        HwSettingViewManager mInAppSettingViewManager = mInAppToolbarItemManager.getMInAppSettingViewManager();
        Intrinsics.checkNotNull(mInAppSettingViewManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingViewManager");
        this.mInAppSettingViewManager = (InAppSettingViewManager) mInAppSettingViewManager;
        this.mColorPickerChangedListener = new SpenColorPickerPopup.ColorPickerChangedListener() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.item.InAppToolbarQuickColor.1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.ColorPickerChangedListener, com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener
            public void onColorChanged(int color, float[] hsvColor) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                int ordinal = HwToolbarConstants.QUICK_COLOR.getOrdinal(InAppToolbarQuickColor.this.getViewId());
                float f = hsvColor[0];
                float f4 = hsvColor[1];
                float f5 = hsvColor[2];
                StringBuilder sbM1628r = AbstractC2322a.m1628r("onColorChanged ", ordinal, " ", f, " / ");
                sbM1628r.append(f4);
                sbM1628r.append(" / ");
                sbM1628r.append(f5);
                InAppLogger.m8598i(InAppToolbarQuickColor.TAG, sbM1628r.toString());
                InAppToolbarQuickColor.this.mInAppToolbarItemManager.getSettingInstance().setQuickColorInfo(ordinal, hsvColor);
                InAppToolbarQuickColor.this.mInAppToolbarItemManager.getSettingInstance().applyQuickColor(hsvColor);
                InAppToolbarQuickColor.this.mInAppSettingViewManager.updateToolbarSelectionState();
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.ColorPickerChangedListener, com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerViewModeChangedListener
            public void onViewModeChanged(int viewMode) {
            }
        };
    }

    private final void showColorPicker(int callerType, float[] hsvColor) {
        this.mInAppSettingViewManager.init(512);
        HwSettingLayout hwSettingLayout = this.mInAppSettingViewManager.getHwSettingLayout(512);
        if (hwSettingLayout instanceof InAppColorPickerLayout) {
            InAppColorPickerLayout inAppColorPickerLayout = (InAppColorPickerLayout) hwSettingLayout;
            inAppColorPickerLayout.setPickerColorChangedListener(this.mColorPickerChangedListener);
            inAppColorPickerLayout.setCurrentColor(hsvColor);
        }
        this.mInAppSettingViewManager.show(callerType, 512);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean enable) {
        InAppLogger.m8598i(TAG, "functionEnable " + enable);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        InAppLogger.m8595d(TAG, "onClick# ");
        if (!this.mView.isSelected()) {
            if (!this.mInAppToolbarItemManager.isSelected(2) && !this.mInAppToolbarItemManager.isSelected(2048)) {
                this.mInAppToolbarItemManager.onSelected(2);
            }
            this.mInAppSettingViewManager.hide();
            this.mInAppToolbarItemManager.onSelected(getViewId());
            this.mInAppSettingViewManager.updateToolbarSelectionState();
            return;
        }
        if (this.mInAppSettingViewManager.isShownSettingViews(512)) {
            this.mInAppSettingViewManager.hide();
            return;
        }
        float[] quickHSVColor = this.mInAppToolbarItemManager.getSettingInstance().getSettingInfoManager().getQuickColorData().getQuickHSVColor(HwToolbarConstants.QUICK_COLOR.getOrdinal(getViewId()));
        int viewId = getViewId();
        Intrinsics.checkNotNull(quickHSVColor);
        showColorPicker(viewId, quickHSVColor);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean selected) {
        if (!super.setSelected(selected)) {
            return false;
        }
        if (!selected) {
            return true;
        }
        this.mInAppToolbarItemManager.updateQuickColor(getViewId());
        return true;
    }

    public final void updateUIColor(int color) {
        int colorTheme = this.mInAppToolbarItemManager.getColorTheme(color);
        View view = this.mView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt = ((ViewGroup) view).getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
        Drawable background = ((ImageView) childAt).getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        gradientDrawable.setColor(ColorStateList.valueOf(colorTheme));
        Context context = this.mView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (SpenSettingUtil.isAdaptiveColor(context, colorTheme)) {
            gradientDrawable.setStroke(1, this.mView.getContext().getResources().getColor(C8003R.color.composer_quick_color_stroke, null));
        } else {
            gradientDrawable.setStroke(1, colorTheme);
        }
    }
}
