package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout;
import com.samsung.android.sdk.pen.setting.SpenPaletteActionListener;
import com.samsung.android.sdk.pen.setting.SpenPopupLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingChangeStyleLayout;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingChangeStyleLayout extends HwSettingLayout {
    private static final String TAG = Logger.createTag("HwSettingChangeStyleLayout");
    protected SpenSettingUIChangeStyleInfo mChangeStyleInfo;
    protected boolean mIsSupportEyedropper = true;
    protected SpenSettingChangeStyleLayout mSpenSettingChangeStyleLayout;

    private boolean internalHide(boolean z) {
        SpenSettingChangeStyleLayout spenSettingChangeStyleLayout = this.mSpenSettingChangeStyleLayout;
        if (spenSettingChangeStyleLayout == null) {
            return false;
        }
        inOutVI(spenSettingChangeStyleLayout, z);
        this.mSpenSettingChangeStyleLayout.setVisibility(8);
        if (this.mSpenSettingChangeStyleLayout.isColorPickerPopupVisible()) {
            this.mSpenSettingChangeStyleLayout.closeColorPickerPopup();
        }
        if (this.mSpenSettingChangeStyleLayout.isColorSettingPopupVisible()) {
            this.mSpenSettingChangeStyleLayout.closeColorSettingPopup();
        }
        this.mChangeStyleInfo = null;
        return true;
    }

    private boolean isColorPickerPopupVisible() {
        SpenSettingChangeStyleLayout spenSettingChangeStyleLayout = this.mSpenSettingChangeStyleLayout;
        return spenSettingChangeStyleLayout != null && spenSettingChangeStyleLayout.isColorPickerPopupVisible();
    }

    private boolean isColorSettingPopupVisible() {
        SpenSettingChangeStyleLayout spenSettingChangeStyleLayout = this.mSpenSettingChangeStyleLayout;
        return spenSettingChangeStyleLayout != null && spenSettingChangeStyleLayout.isColorSettingPopupVisible();
    }

    private void restorePalette() {
        if (this.mSettingViewManager.getHWToolbarState().getPaletteId(getViewId()) > -1) {
            this.mSpenSettingChangeStyleLayout.setCurrentPalette(this.mSettingViewManager.getHWToolbarState().getPaletteId(getViewId()));
        }
    }

    private void setLoggingListener() {
        this.mSpenSettingChangeStyleLayout.setLoggingListener(new SpenSettingChangeStyleLayout.LoggingListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleLayout.9
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingChangeStyleLayout.LoggingListener
            public void onClosed() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_CHANGE_STYLE_CLOSE);
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorCirclePressed() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_SELECT_COLOR_SETS_TO_SHOW);
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorPickerCancel() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorPickerDone() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorPickerSelected() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorSelected(int i) {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_PEN_COLOR);
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorSettingsLoggingListener
            public void onColorSettingCancel() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorSettingsLoggingListener
            public void onColorSettingDone(int i) {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorSettingSelected() {
            }

            @Override // com.samsung.android.sdk.pen.setting.EyedropperLoggingListener
            public void onEyedropperClosed() {
            }

            @Override // com.samsung.android.sdk.pen.setting.EyedropperLoggingListener
            public void onEyedropperHandlerTapped() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onEyedropperSelected() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onPaletteSwiped(int i) {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onRecentColorSelected() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onSeekbarChanged() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_PEN_SIZE);
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        SpenSettingChangeStyleLayout spenSettingChangeStyleLayout = this.mSpenSettingChangeStyleLayout;
        if (spenSettingChangeStyleLayout != null) {
            spenSettingChangeStyleLayout.close();
            this.mSpenSettingChangeStyleLayout = null;
        }
        getSettingInstance().setFocusSelectedObjects(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        internalHide(z);
    }

    public void hideEyedropper() {
        SpenSettingChangeStyleLayout spenSettingChangeStyleLayout = this.mSpenSettingChangeStyleLayout;
        if (spenSettingChangeStyleLayout != null && spenSettingChangeStyleLayout.isEyedropperVisible() && this.mSettingViewManager.getHWToolbarState().isColorSpoidEnable(getViewId())) {
            this.mSpenSettingChangeStyleLayout.hideEyedropper();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mSpenSettingChangeStyleLayout != null) {
            restoreChangeStyleInfo();
            return;
        }
        SpenSettingChangeStyleLayout spenSettingChangeStyleLayout = new SpenSettingChangeStyleLayout(this.mFloatingContainer.getContext(), this.mFloatingContainer, this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getSelectList(), this.mSettingViewManager.getSettingInfoManager().getColorRecentData().getRecentColors(), this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getColorSettingInfo(), this.mIsSupportEyedropper);
        this.mSpenSettingChangeStyleLayout = spenSettingChangeStyleLayout;
        spenSettingChangeStyleLayout.setTitle(this.mFloatingContainer.getContext().getResources().getString(C9086R.string.hw_toolbar_quick_highlighter));
        this.mSpenSettingChangeStyleLayout.setColorTheme(this.mSettingViewManager.getColorTheme());
        this.mSettingViewManager.getHWToolbarState().setColorSettingState(getViewId());
        restoreChangeStyleInfo();
        setInfoChangeListener();
        setVisibilityChangeListener();
        setLoggingListener();
        this.mFloatingContainer.addView(this.mSpenSettingChangeStyleLayout);
        this.mSpenSettingChangeStyleLayout.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        SpenSettingChangeStyleLayout spenSettingChangeStyleLayout = this.mSpenSettingChangeStyleLayout;
        return spenSettingChangeStyleLayout != null && spenSettingChangeStyleLayout.getVisibility() == 0;
    }

    public void restoreChangeStyleInfo() {
        SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo = new SpenSettingUIChangeStyleInfo(this.mSettingViewManager.getSettingInfoManager().getChangeStyleData().getChangeStyleInfo());
        this.mChangeStyleInfo = spenSettingUIChangeStyleInfo;
        SpenSettingChangeStyleLayout spenSettingChangeStyleLayout = this.mSpenSettingChangeStyleLayout;
        if (spenSettingChangeStyleLayout != null) {
            spenSettingChangeStyleLayout.setInfo(spenSettingUIChangeStyleInfo);
            this.mSpenSettingChangeStyleLayout.setRecentColor(this.mSettingViewManager.getSettingInfoManager().getColorRecentData().getRecentColors());
            this.mSpenSettingChangeStyleLayout.setPalette(this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getSelectList());
        }
        restorePalette();
    }

    public void setEyedropperColor(int i) {
        SpenSettingChangeStyleLayout spenSettingChangeStyleLayout = this.mSpenSettingChangeStyleLayout;
        if (spenSettingChangeStyleLayout == null) {
            return;
        }
        spenSettingChangeStyleLayout.setEyedropperColor(i);
    }

    public void setInfoChangeListener() {
        this.mSpenSettingChangeStyleLayout.setChangeStyleInfoChangedListener(new SpenSettingChangeStyleLayout.ChangeStyleInfoChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleLayout.1
            @Override // com.samsung.android.sdk.pen.setting.changestyle.SpenSettingChangeStyleManager.ChangeStyleInfoChangedListener
            public void onChangeStyleInfoChanged(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
                HwSettingChangeStyleLayout.this.mSettingViewManager.getSettingInstance().setStyleSettingInfo(spenSettingUIChangeStyleInfo);
                HwSettingChangeStyleLayout.this.mChangeStyleInfo = null;
            }
        });
        this.mSpenSettingChangeStyleLayout.setPaletteChangedListener(new SpenSettingChangeStyleLayout.SpenPaletteChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleLayout.2
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.PaletteChangedListener
            public void onPaletteChanged(List<Integer> list) {
                HwSettingChangeStyleLayout.this.mSettingViewManager.getSettingInstance().onPaletteChanged(list);
            }
        });
        this.mSpenSettingChangeStyleLayout.setPaletteActionListener(new SpenPaletteActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleLayout.3
            @Override // com.samsung.android.sdk.pen.setting.SpenPaletteActionListener
            public void onPageChanged(int i) {
                HwSettingChangeStyleLayout.this.mSettingViewManager.getHWToolbarState().setPaletteId(HwSettingChangeStyleLayout.this.getViewId(), i);
            }
        });
        this.mSpenSettingChangeStyleLayout.setColorPickerViewModeChangedListener(new SpenColorControlPopupLayout.ColorPickerModeChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleLayout.4
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.ColorPickerModeChangedListener
            public void onViewModeChanged(int i) {
                HwSettingChangeStyleLayout.this.mSettingViewManager.getSettingInfoManager().getColorPickerData().setColorPickerViewMode(i);
            }
        });
        this.mSpenSettingChangeStyleLayout.setColorSettingSelectItemEventListener(ToolbarUtil.getColorSetRestrictToastListener(this.mFloatingContainer.getContext(), this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getMaxSelectCount()));
    }

    public void setItemChangeStyleInfo(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        if (isVisible()) {
            this.mSpenSettingChangeStyleLayout.setInfo(spenSettingUIChangeStyleInfo);
        }
    }

    public void setPalette(List<Integer> list) {
        if (isVisible()) {
            this.mSpenSettingChangeStyleLayout.setPalette(list);
        }
    }

    public void setVisibilityChangeListener() {
        this.mSpenSettingChangeStyleLayout.setVisibilityChangedListener(new SpenPopupLayout.ViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleLayout.5
            @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout.ViewListener
            public void onVisibilityChanged(int i) {
                boolean z = i == 0;
                HwSettingChangeStyleLayout hwSettingChangeStyleLayout = HwSettingChangeStyleLayout.this;
                hwSettingChangeStyleLayout.mSettingViewManager.updateShowState(hwSettingChangeStyleLayout.getCallerType(), HwSettingChangeStyleLayout.this.getViewId(), z);
                HwSettingChangeStyleLayout.this.getSettingInstance().setFocusSelectedObjects(z);
            }
        });
        this.mSpenSettingChangeStyleLayout.setColorPickerVisibilityChangeListener(new SpenSettingChangeStyleLayout.SpenColorPickerViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleLayout.6
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.SettingViewListener
            public void onVisibilityChanged(int i) {
                HwSettingChangeStyleLayout.this.mSettingViewManager.getHWToolbarState().setColorPickerEnable(HwSettingChangeStyleLayout.this.getViewId(), i == 0);
            }
        });
        this.mSpenSettingChangeStyleLayout.setColorSettingVisibilityChangeListener(new SpenSettingChangeStyleLayout.SpenColorSettingViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleLayout.7
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.SettingViewListener
            public void onVisibilityChanged(int i) {
                HwSettingChangeStyleLayout.this.mSettingViewManager.getHWToolbarState().setColorSettingEnable(HwSettingChangeStyleLayout.this.getViewId(), i == 0);
            }
        });
        this.mSpenSettingChangeStyleLayout.setEyedropperVisibilityChangedListener(new SpenColorControlPopupLayout.SettingViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleLayout.8
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.SettingViewListener
            public void onVisibilityChanged(int i) {
                AbstractC0000a.m3D(i, "setEyedropperVisibilityChangedListener onVisibilityChanged visibility = ", HwSettingChangeStyleLayout.TAG);
                boolean z = i == 0;
                if (z) {
                    HwSettingChangeStyleLayout.this.mSettingViewManager.getHWToolbarState().setEyedropperColor(HwSettingChangeStyleLayout.this.mSettingViewManager.getSelectedPenInfo().color);
                }
                HwSettingChangeStyleLayout.this.mSettingViewManager.getHWToolbarState().setColorSpoidEnable(HwSettingChangeStyleLayout.this.getViewId(), z);
                HwSettingChangeStyleLayout.this.mSettingViewManager.getSettingInstance().setEyedropperMode(z);
            }
        });
    }

    public void settingVisible() {
        if (this.mSettingViewManager.getHWToolbarState().isColorPickerEnable(getViewId()) && !isColorPickerPopupVisible()) {
            this.mSpenSettingChangeStyleLayout.setColorPickerViewMode(this.mSettingViewManager.getSettingInfoManager().getColorPickerData().getColorPickerViewMode());
            this.mSpenSettingChangeStyleLayout.showColorPickerPopup();
        }
        if (!this.mSettingViewManager.getHWToolbarState().isColorSettingEnable(getViewId()) || isColorSettingPopupVisible()) {
            return;
        }
        this.mSpenSettingChangeStyleLayout.showColorSettingPopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        setCallerType(i);
        init();
        if (this.mSpenSettingChangeStyleLayout.getVisibility() == 0) {
            return;
        }
        inOutVI(this.mSpenSettingChangeStyleLayout, z);
        if (this.mIsSupportEyedropper) {
            this.mSpenSettingChangeStyleLayout.setEyedropperEnabled(this.mSettingViewManager.getSettingInfoManager().isEyeDropperEnabled());
        }
        this.mSpenSettingChangeStyleLayout.setVisibility(0);
        this.mSpenSettingChangeStyleLayout.requestFocus();
        settingVisible();
        updatePosition(i, view, z);
    }

    public void updateChangeStyleInfo() {
        if (this.mSpenSettingChangeStyleLayout == null) {
            return;
        }
        this.mSettingViewManager.getSettingInstance().setStyleSettingInfo(this.mSpenSettingChangeStyleLayout.getInfo());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        this.mSettingViewManager.updateLayoutParam(i, view, this.mSpenSettingChangeStyleLayout);
    }
}
