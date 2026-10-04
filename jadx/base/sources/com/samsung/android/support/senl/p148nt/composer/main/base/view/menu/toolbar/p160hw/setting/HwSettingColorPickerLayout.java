package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayoutV2;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingColorPickerLayout extends HwSettingLayout {
    private static final String TAG = Logger.createTag("HwSettingColorPickerLayout");
    private View mContainer;
    private View.OnLayoutChangeListener mOnLayoutChangeListener;
    private SpenColorPickerLayoutV2.PickerColorChangedListener mPickerColorChangedListener;
    private ViewGroup mSettingContainer;
    private SpenColorPickerLayoutV2 mSpenColorPickerLayout = null;

    private boolean internalHide(boolean z) {
        if (!isVisible()) {
            return false;
        }
        inOutVI(this.mSettingContainer, z);
        this.mSettingContainer.setVisibility(8);
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), false);
        this.mSettingContainer.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        this.mSpenColorPickerLayout = null;
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), false);
        SpenColorPickerLayoutV2 spenColorPickerLayoutV2 = this.mSpenColorPickerLayout;
        if (spenColorPickerLayoutV2 != null) {
            spenColorPickerLayoutV2.close();
            this.mSpenColorPickerLayout = null;
        }
        this.mSettingContainer = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        internalHide(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mSpenColorPickerLayout != null) {
            return;
        }
        SpenColorPickerLayoutV2 spenColorPickerLayoutV2 = new SpenColorPickerLayoutV2(this.mFloatingContainer.getContext(), this.mSettingViewManager.getSettingInfoManager().getColorPickerData().getColorPickerViewMode(), new float[3], this.mSettingViewManager.getSettingInfoManager().isEyeDropperEnabled());
        this.mSpenColorPickerLayout = spenColorPickerLayoutV2;
        spenColorPickerLayoutV2.setActionButtonListener(new SpenColorPickerLayoutV2.ActionButtonListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingColorPickerLayout.1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayoutV2.ActionButtonListener
            public void onCancelButtonClick() {
                Logger.m11003i(HwSettingColorPickerLayout.TAG, "onCancelButtonClick");
                HwSettingColorPickerLayout.this.hide(true);
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayoutV2.ActionButtonListener
            public void onDoneButtonClick() {
                Logger.m11003i(HwSettingColorPickerLayout.TAG, "onDoneButtonClick");
                HwSettingColorPickerLayout.this.hide(true);
            }
        });
        this.mSpenColorPickerLayout.setPickerEyedropperActionListener(new SpenColorPickerLayoutV2.PickerEyedropperActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingColorPickerLayout.2
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerEyedropperListener
            public void onEyedropperButtonClicked() {
                if (HwSettingColorPickerLayout.this.mPickerColorChangedListener == null || HwSettingColorPickerLayout.this.mSpenColorPickerLayout == null) {
                    HwSettingColorPickerLayout.this.mSettingViewManager.getSettingInstance().showSettingView(0, 4096, HwSettingColorPickerLayout.this.mFloatingContainer);
                    return;
                }
                float[] fArr = new float[3];
                HwSettingColorPickerLayout.this.mSpenColorPickerLayout.getCurrentColor(fArr);
                HwSettingPresenter settingInstance = HwSettingColorPickerLayout.this.mSettingViewManager.getSettingInstance();
                HwSettingColorPickerLayout hwSettingColorPickerLayout = HwSettingColorPickerLayout.this;
                settingInstance.showEyedropper(0, hwSettingColorPickerLayout.mFloatingContainer, fArr, hwSettingColorPickerLayout.mPickerColorChangedListener);
                HwSettingColorPickerLayout.this.mPickerColorChangedListener.onColorChanged(4096, fArr);
            }
        });
        this.mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingColorPickerLayout.3
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (i == i6 && i4 == i8 && i2 == i7 && i5 == i9) {
                    return;
                }
                HwSettingColorPickerLayout hwSettingColorPickerLayout = HwSettingColorPickerLayout.this;
                hwSettingColorPickerLayout.mSettingViewManager.updateLayoutParam(hwSettingColorPickerLayout.getCallerType(), HwSettingColorPickerLayout.this.mContainer, HwSettingColorPickerLayout.this.mSettingContainer);
            }
        };
        SpenColorPickerLayoutV2.PickerColorChangedListener pickerColorChangedListener = new SpenColorPickerLayoutV2.PickerColorChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingColorPickerLayout.4
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener
            public void onColorChanged(int i, float[] fArr) {
                int ordinal = HwToolbarConstants.QUICK_COLOR.getOrdinal(HwSettingColorPickerLayout.this.getCallerType());
                String str = HwSettingColorPickerLayout.TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(ordinal, "onColorChanged ", " ");
                sbM778t.append(fArr[0]);
                sbM778t.append(" / ");
                sbM778t.append(fArr[1]);
                sbM778t.append(" / ");
                sbM778t.append(fArr[2]);
                Logger.m11003i(str, sbM778t.toString());
                HwSettingColorPickerLayout.this.mSettingViewManager.getSettingInstance().onPickerColorChanged(HwSettingColorPickerLayout.this.getCallerType(), i, fArr);
            }
        };
        this.mPickerColorChangedListener = pickerColorChangedListener;
        this.mSpenColorPickerLayout.setPickerColorChangedListener(pickerColorChangedListener);
        ViewGroup viewGroupAddWrappingViewGroup = addWrappingViewGroup(this.mSpenColorPickerLayout);
        this.mSettingContainer = viewGroupAddWrappingViewGroup;
        viewGroupAddWrappingViewGroup.setVisibility(8);
        setColorTheme(this.mSettingViewManager.getColorTheme());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        ViewGroup viewGroup = this.mSettingContainer;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void setColorTheme(int i) {
        SpenColorPickerLayoutV2 spenColorPickerLayoutV2 = this.mSpenColorPickerLayout;
        if (spenColorPickerLayoutV2 != null) {
            spenColorPickerLayoutV2.setColorTheme(i);
        }
    }

    public void setCurrentColor(float[] fArr) {
        if (isVisible()) {
            this.mSpenColorPickerLayout.setCurrentColor(fArr);
            this.mSpenColorPickerLayout.setColor(fArr, fArr);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        setCallerType(i);
        init();
        if (this.mSettingContainer.getVisibility() == 0) {
            return;
        }
        this.mContainer = view;
        inOutVI(this.mSettingContainer, z);
        this.mSettingContainer.setVisibility(0);
        this.mSettingContainer.requestFocus();
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), true);
        this.mSettingContainer.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        updatePosition(i, view, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        this.mSettingViewManager.updateLayoutParam(i, view, this.mSettingContainer);
    }
}
