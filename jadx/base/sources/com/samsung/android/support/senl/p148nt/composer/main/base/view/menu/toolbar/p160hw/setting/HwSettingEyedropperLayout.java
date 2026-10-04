package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.content.Context;
import android.view.View;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayoutV2;
import com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingEyedropperLayout extends HwSettingLayout {
    private static final String TAG = Logger.createTag("HwSettingEyedropperLayout");
    private View mContainer;
    private SpenColorPickerLayoutV2.PickerColorChangedListener mPickerColorChangedListener;
    protected SpenColorSpoidLayout mSpenColorSpoidLayout = null;

    private boolean internalHide() {
        if (!isVisible()) {
            return false;
        }
        this.mSpenColorSpoidLayout.hide();
        setEyedropperMode(false);
        return true;
    }

    private void setEyedropperMode(boolean z) {
        this.mSettingViewManager.getHWToolbarState().setColorSpoidEnable(getViewId(), z);
        this.mSettingViewManager.getSettingInstance().setEyedropperMode(z);
    }

    public void applySpoidColorToPenInfo(float[] fArr) {
        this.mSettingViewManager.getSettingInstance().applyQuickColor(fArr);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        internalHide();
        SpenColorSpoidLayout spenColorSpoidLayout = this.mSpenColorSpoidLayout;
        if (spenColorSpoidLayout != null) {
            spenColorSpoidLayout.close();
            this.mSpenColorSpoidLayout = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        internalHide();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mSpenColorSpoidLayout != null) {
            return;
        }
        Context context = this.mFloatingContainer.getContext();
        FloaterContainer floaterContainer = this.mFloatingContainer;
        SpenColorSpoidLayout spenColorSpoidLayout = new SpenColorSpoidLayout(context, floaterContainer, (int) floaterContainer.getContext().getResources().getDimension(C9086R.dimen.comp_hw_color_spoid_default_margin), (int) this.mFloatingContainer.getContext().getResources().getDimension(C9086R.dimen.comp_hw_color_spoid_default_margin_y));
        this.mSpenColorSpoidLayout = spenColorSpoidLayout;
        spenColorSpoidLayout.setSpoidListener(new SpenColorSpoidLayout.ActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingEyedropperLayout.1
            @Override // com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout.ActionListener
            public void onHandlerTapped() {
                Logger.m11003i(HwSettingEyedropperLayout.TAG, "onHandlerTapped");
            }

            @Override // com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout.ActionListener
            public void onSpoidClosed() {
                Logger.m11003i(HwSettingEyedropperLayout.TAG, "onSpoidClosed");
                HwSettingEyedropperLayout.this.hide(false);
            }
        });
        this.mSpenColorSpoidLayout.hide();
        this.mSettingViewManager.getHWToolbarState().setColorSettingState(getViewId());
        setColorTheme(this.mSettingViewManager.getColorTheme());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        SpenColorSpoidLayout spenColorSpoidLayout = this.mSpenColorSpoidLayout;
        return spenColorSpoidLayout != null && spenColorSpoidLayout.getColorSpoidSettingVisible() == 0;
    }

    public void movePosition(int i, int i2) {
        View view;
        if (isVisible() && (view = this.mContainer) != null && view.getId() == C9086R.id.qt_container) {
            this.mSpenColorSpoidLayout.movePosition(i, i2);
        }
    }

    public void setColorSpoidColor(int i) {
        SpenColorSpoidLayout spenColorSpoidLayout = this.mSpenColorSpoidLayout;
        if (spenColorSpoidLayout == null) {
            Logger.m11003i(TAG, "setColorSpoidColor# mSpenColorSpoidLayout is null");
            return;
        }
        spenColorSpoidLayout.setColorSpoidColor(i);
        float[] fArr = new float[3];
        ColorCompat.colorToHSV(i, fArr);
        SpenColorPickerLayoutV2.PickerColorChangedListener pickerColorChangedListener = this.mPickerColorChangedListener;
        if (pickerColorChangedListener != null) {
            pickerColorChangedListener.onColorChanged(0, fArr);
        } else {
            applySpoidColorToPenInfo(fArr);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void setColorTheme(int i) {
        SpenColorSpoidLayout spenColorSpoidLayout = this.mSpenColorSpoidLayout;
        if (spenColorSpoidLayout != null) {
            spenColorSpoidLayout.setColorTheme(i);
        }
    }

    public void setPickerColorChangedListener(SpenColorPickerLayoutV2.PickerColorChangedListener pickerColorChangedListener) {
        this.mPickerColorChangedListener = pickerColorChangedListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        this.mContainer = view;
        setCallerType(i);
        init();
        if (isVisible()) {
            return;
        }
        int i2 = this.mSettingViewManager.getSelectedPenInfo().color;
        this.mSettingViewManager.getHWToolbarState().setEyedropperColor(i2);
        this.mSpenColorSpoidLayout.setColorSpoidColor(i2);
        this.mSpenColorSpoidLayout.show();
        this.mSpenColorSpoidLayout.requestFocus();
        setEyedropperMode(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        if (isVisible()) {
            this.mSpenColorSpoidLayout.hide();
            this.mSpenColorSpoidLayout.show();
        }
    }
}
