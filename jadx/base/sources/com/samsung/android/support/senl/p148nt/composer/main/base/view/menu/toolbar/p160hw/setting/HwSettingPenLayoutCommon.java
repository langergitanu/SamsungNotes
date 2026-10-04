package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenPenLayoutInfo;
import com.samsung.android.sdk.pen.setting.SpenSettingPenLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.pencommon.PenInfoChangedListener;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.LazyUpdateHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class HwSettingPenLayoutCommon extends HwSettingLayout {
    protected static final String TAG = Logger.createTag("HwSettingPenLayoutCommon");
    protected HwSettingSALog mHwSettingSALog;
    protected SpenSettingPenLayout mSpenSettingLayout = null;
    protected boolean mSupportFixedOpacity = true;
    protected boolean mSupportDynamicPenWeightByTextSize = true;
    protected boolean mIsSupportEyedropper = true;
    private LazyUpdateHelper mLazyUpdateHelper = new LazyUpdateHelper(new LazyUpdateHelper.Callback<SpenSettingUIPenInfo>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayoutCommon.1
        @Override // com.samsung.android.support.senl.nt.composer.main.base.util.LazyUpdateHelper.Callback
        public void onLazyUpdate(SpenSettingUIPenInfo spenSettingUIPenInfo) {
            String str = HwSettingPenLayoutCommon.TAG;
            StringBuilder sb = new StringBuilder("LazyUpdate pen info ");
            sb.append(spenSettingUIPenInfo.name);
            sb.append(" ");
            AbstractC8014b.m7195A(sb, str, spenSettingUIPenInfo.sizeLevel);
            HwSettingPenLayoutCommon.this.onPenInfoChanged(spenSettingUIPenInfo);
        }
    });

    public void addFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (spenSettingUIPenInfo == null) {
            Logger.m10999d(TAG, "addFavoritePenInfo # penInfo is null. ");
            return;
        }
        if (this.mSettingViewManager.getSettingInfoManager().getFavoritePenData().isThereFavoriteInfo(spenSettingUIPenInfo)) {
            ToastHandler.showDirectly(this.mFloatingContainer.getContext(), C9086R.string.hw_toolbar_already_saved_favorite_pen, 0);
        } else if (this.mSettingViewManager.getSettingInfoManager().getFavoritePenData().canAddFavoriteInfo()) {
            this.mSettingViewManager.getSettingInstance().addFavoritePenInfo(spenSettingUIPenInfo);
        } else {
            ToastHandler.showDirectly(this.mFloatingContainer.getContext(), C9086R.string.hw_toolbar_list_full_favorite_pen, 0);
        }
    }

    public boolean canHide() {
        return isVisible();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        if (spenSettingPenLayout != null) {
            spenSettingPenLayout.close();
            this.mSpenSettingLayout = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        internalHide(z);
    }

    public void hideColorSpoid() {
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        if (spenSettingPenLayout != null) {
            spenSettingPenLayout.hideColorSpoid();
        }
    }

    public void hideSettingCommon() {
        if (this.mSettingViewManager.getHWToolbarState().isColorSpoidEnable(getViewId()) && isColorSpoidVisible()) {
            this.mSpenSettingLayout.hideColorSpoid();
        }
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        if (spenSettingPenLayout != null) {
            if (spenSettingPenLayout.isColorPickerPopupVisible()) {
                this.mSpenSettingLayout.closeColorPickerPopup();
            }
            if (this.mSpenSettingLayout.isColorSettingPopupVisible()) {
                this.mSpenSettingLayout.closeColorSettingPopup();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mSpenSettingLayout == null) {
            SpenPenLayoutInfo spenPenLayoutInfo = new SpenPenLayoutInfo(this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getSelectList(), this.mSettingViewManager.getSettingInfoManager().getColorRecentData().getRecentColors(), this.mIsSupportEyedropper);
            spenPenLayoutInfo.supportFixedOpacity = this.mSupportFixedOpacity;
            spenPenLayoutInfo.supportDynamicPenWeightByTextSize = this.mSupportDynamicPenWeightByTextSize;
            this.mSpenSettingLayout = new SpenSettingPenLayout(this.mFloatingContainer.getContext(), this.mFloatingContainer, spenPenLayoutInfo, this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getColorSettingInfo());
        }
        initSettingLayout();
    }

    public void initSettingLayout() {
        this.mHwSettingSALog = new HwSettingSALog(this.mSpenSettingLayout.getContext(), this.mSettingViewManager.getSettingInfoManager().getPenInfoData());
        this.mSettingViewManager.getHWToolbarState().setColorSettingState(getViewId());
        setVisibilityChangeListener();
        setCommonChangedListener();
        setColorTheme(this.mSettingViewManager.getColorTheme());
    }

    public boolean internalHide(boolean z) {
        if (!canHide()) {
            return false;
        }
        hideSettingCommon();
        inOutVI(this.mSpenSettingLayout, z);
        this.mSpenSettingLayout.setVisibility(8);
        return true;
    }

    public boolean isColorPickerPopupVisible() {
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        return spenSettingPenLayout != null && spenSettingPenLayout.isColorPickerPopupVisible();
    }

    public boolean isColorSettingPopupVisible() {
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        return spenSettingPenLayout != null && spenSettingPenLayout.isColorSettingPopupVisible();
    }

    public boolean isColorSpoidVisible() {
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        return spenSettingPenLayout != null && spenSettingPenLayout.isColorSpoidVisible();
    }

    public boolean isSettingViewVisible() {
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        return spenSettingPenLayout != null && spenSettingPenLayout.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        return spenSettingPenLayout != null && spenSettingPenLayout.getVisibility() == 0;
    }

    public abstract void onPenInfoChanged(SpenSettingUIPenInfo spenSettingUIPenInfo);

    public void restoreData() {
        if (this.mSettingViewManager.getHWToolbarState().getPaletteId(getViewId()) > -1) {
            this.mSpenSettingLayout.setCurrentPalette(this.mSettingViewManager.getHWToolbarState().getPaletteId(getViewId()));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void setColorTheme(int i) {
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        if (spenSettingPenLayout != null) {
            spenSettingPenLayout.setColorTheme(i);
        }
    }

    public void setCommonChangedListener() {
        this.mSpenSettingLayout.setPenInfoChangedListener(new PenInfoChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayoutCommon.2
            @Override // com.samsung.android.sdk.pen.setting.pencommon.PenInfoChangedListener
            public void onPenInfoChanged(SpenSettingUIPenInfo spenSettingUIPenInfo) {
                HwSettingPenLayoutCommon.this.mLazyUpdateHelper.updateValue(spenSettingUIPenInfo);
            }
        });
        this.mSpenSettingLayout.setPaletteChangedListener(new SpenSettingPenLayout.SpenPaletteChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayoutCommon.3
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.PaletteChangedListener
            public void onPaletteChanged(List<Integer> list) {
                HwSettingPenLayoutCommon.this.mSettingViewManager.getSettingInstance().onPaletteChanged(list);
            }
        });
        this.mSpenSettingLayout.setPaletteActionListener(new SpenSettingPenLayout.PaletteActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayoutCommon.4
            @Override // com.samsung.android.sdk.pen.setting.SpenPaletteActionListener
            public void onPageChanged(int i) {
                HwSettingPenLayoutCommon.this.mSettingViewManager.getHWToolbarState().setPaletteId(HwSettingPenLayoutCommon.this.getViewId(), i);
            }
        });
        this.mSpenSettingLayout.setColorPickerChangedListener(new SpenSettingPenLayout.ColorPickerChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayoutCommon.5
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.ColorPickerModeChangedListener
            public void onViewModeChanged(int i) {
                HwSettingPenLayoutCommon.this.mSettingViewManager.getSettingInfoManager().getColorPickerData().setColorPickerViewMode(i);
            }
        });
        this.mSpenSettingLayout.setColorSettingSelectItemEventListener(ToolbarUtil.getColorSetRestrictToastListener(this.mFloatingContainer.getContext(), this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getMaxSelectCount()));
    }

    public void setEyedropperColor(int i) {
        this.mSpenSettingLayout.setEyedropperColor(i);
    }

    public void setLayoutOrientation() {
        if (this.mSettingViewManager.isTabletLayout() || this.mSpenSettingLayout.getResources().getConfiguration().orientation != 2) {
            this.mSpenSettingLayout.setLayoutOrientation(1);
        } else {
            this.mSpenSettingLayout.setLayoutOrientation(2);
        }
    }

    public void setLoggingListener(SpenSettingPenLayout.LoggingListener loggingListener) {
        this.mSpenSettingLayout.setLoggingListener(loggingListener);
    }

    public void setPalette(List<Integer> list) {
        if (isVisible()) {
            this.mSpenSettingLayout.setPalette(list);
        }
    }

    public void setRecentColor(List<SpenHSVColor> list) {
        if (isVisible()) {
            this.mSpenSettingLayout.setRecentColor(list);
        }
    }

    public void setTitleButtonListener() {
        if (this.mSettingViewManager.isTabletLayout()) {
            this.mSpenSettingLayout.setChangeUIModeButtonListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayoutCommon.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.m11003i(HwSettingPenLayoutCommon.TAG, "ChangeUIModeButton");
                    HwSettingPenLayoutCommon.this.mSettingViewManager.getSettingInfoManager().getPenMiniMenuData().setEnable(true);
                    HwSettingPenLayoutCommon.this.mSettingViewManager.hide();
                    HwSettingPenLayoutCommon.this.mSettingViewManager.onShowSettingPenMini();
                    ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_SHRINK_PEN_SETTINGS);
                }
            });
        }
        this.mSpenSettingLayout.setChangeViewModeButtonListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayoutCommon.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m11003i(HwSettingPenLayoutCommon.TAG, "setChangeViewModeButtonListener");
                HwSettingPenLayoutCommon.this.hide(false);
                HwSettingPenLayoutCommon hwSettingPenLayoutCommon = HwSettingPenLayoutCommon.this;
                hwSettingPenLayoutCommon.mSettingViewManager.setSelectedToolbarItem(hwSettingPenLayoutCommon.getViewId());
                HwSettingPenLayoutCommon hwSettingPenLayoutCommon2 = HwSettingPenLayoutCommon.this;
                hwSettingPenLayoutCommon2.mSettingViewManager.show(hwSettingPenLayoutCommon2.getCallerType(), 1, null, false);
                HwSettingPenLayoutCommon hwSettingPenLayoutCommon3 = HwSettingPenLayoutCommon.this;
                hwSettingPenLayoutCommon3.mHwSettingSALog.insertFavoritePenSetting(ResourceUtils.isTabletLayout(hwSettingPenLayoutCommon3.mSpenSettingLayout.getContext()));
            }
        });
        this.mSpenSettingLayout.setFavoriteButton(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayoutCommon.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = HwSettingPenLayoutCommon.TAG;
                Logger.m11003i(str, "setFavoriteButton onClick");
                SpenSettingUIPenInfo info = HwSettingPenLayoutCommon.this.mSpenSettingLayout.getInfo();
                if (info == null) {
                    Logger.m10999d(str, "penInfo is null");
                    return;
                }
                HwSettingPenLayoutCommon hwSettingPenLayoutCommon = HwSettingPenLayoutCommon.this;
                hwSettingPenLayoutCommon.mHwSettingSALog.insertAddFavorite(ResourceUtils.isTabletLayout(hwSettingPenLayoutCommon.mSpenSettingLayout.getContext()), HwSettingPenLayoutCommon.this.mSettingViewManager.getSettingInstance().isHighlighterType(info));
                if (HwSettingPenLayoutCommon.this.mSettingViewManager.getSettingInfoManager().getFavoritePenData().isThereFavoriteInfo(info)) {
                    HwSettingPenLayoutCommon.this.mSettingViewManager.getSettingInstance().removeFavoritePenInfo(info);
                } else {
                    HwSettingPenLayoutCommon.this.addFavoritePenInfo(info);
                }
            }
        }, this.mSettingViewManager.isTabletLayout());
    }

    public void setVisibilityChangeListener() {
        this.mSpenSettingLayout.setVisibilityChangedListener(new SpenSettingPenLayout.ViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayoutCommon.9
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingPenLayout.ViewListener
            public void onVisibilityChanged(int i) {
                HwSettingPenLayoutCommon hwSettingPenLayoutCommon = HwSettingPenLayoutCommon.this;
                hwSettingPenLayoutCommon.mSettingViewManager.updateShowState(hwSettingPenLayoutCommon.getCallerType(), HwSettingPenLayoutCommon.this.getViewId(), i == 0, HwSettingPenLayoutCommon.this.mSpenSettingLayout.isEyedropperVisible());
            }
        });
        this.mSpenSettingLayout.setColorPickerVisibilityChangeListener(new SpenSettingPenLayout.SpenColorPickerViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayoutCommon.10
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.SettingViewListener
            public void onVisibilityChanged(int i) {
                HwSettingPenLayoutCommon.this.mSettingViewManager.getHWToolbarState().setColorPickerEnable(HwSettingPenLayoutCommon.this.getViewId(), i == 0);
            }
        });
        this.mSpenSettingLayout.setColorSettingVisibilityChangeListener(new SpenSettingPenLayout.SpenColorSettingViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayoutCommon.11
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.SettingViewListener
            public void onVisibilityChanged(int i) {
                HwSettingPenLayoutCommon.this.mSettingViewManager.getHWToolbarState().setColorSettingEnable(HwSettingPenLayoutCommon.this.getViewId(), i == 0);
            }
        });
        this.mSpenSettingLayout.setPenSpuitVisibilityChangedListener(new SpenSettingPenLayout.SpenPenSpuitViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayoutCommon.12
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.SettingViewListener
            public void onVisibilityChanged(int i) {
                AbstractC0000a.m3D(i, "setPenSpuitVisibilityChangedListener onVisibilityChanged visibility = ", HwSettingPenLayoutCommon.TAG);
                boolean z = i == 0;
                if (z) {
                    HwSettingPenLayoutCommon.this.mSettingViewManager.getHWToolbarState().setEyedropperColor(HwSettingPenLayoutCommon.this.mSettingViewManager.getSelectedPenInfo().color);
                } else {
                    HwSettingPenLayoutCommon.this.mSettingViewManager.requestFocusToComposerView();
                }
                HwSettingPenLayoutCommon.this.mSettingViewManager.getHWToolbarState().setColorSpoidEnable(HwSettingPenLayoutCommon.this.getViewId(), z);
                HwSettingPenLayoutCommon.this.mSettingViewManager.getSettingInstance().setEyedropperMode(z);
            }
        });
    }

    public void settingVisible() {
        if (this.mSettingViewManager.getHWToolbarState().isColorPickerEnable(getViewId()) && !isColorPickerPopupVisible()) {
            this.mSpenSettingLayout.setColorPickerViewMode(this.mSettingViewManager.getSettingInfoManager().getColorPickerData().getColorPickerViewMode());
            this.mSpenSettingLayout.showColorPickerPopup();
        }
        if (!this.mSettingViewManager.getHWToolbarState().isColorSettingEnable(getViewId()) || isColorSettingPopupVisible()) {
            return;
        }
        this.mSpenSettingLayout.showColorSettingPopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        setCallerType(i);
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        if (spenSettingPenLayout != null) {
            spenSettingPenLayout.setRecentColor(this.mSettingViewManager.getSettingInfoManager().getColorRecentData().getRecentColors());
            this.mSpenSettingLayout.setPalette(this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getSelectList());
        }
    }

    public void showColorSpoid() {
        this.mSpenSettingLayout.showColorSpoid();
    }

    public void updateFavoriteButton(boolean z) {
        if (!isSettingViewVisible()) {
            Logger.m10999d(TAG, "mSpenSettingLayout is null");
            return;
        }
        SpenSettingUIPenInfo info = this.mSpenSettingLayout.getInfo();
        if (info == null) {
            Logger.m10999d(TAG, "penInfo is null");
        } else {
            this.mSpenSettingLayout.setFavoriteButtonChecked(this.mSettingViewManager.getSettingInfoManager().getFavoritePenData().isThereFavoriteInfo(info), z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        this.mSettingViewManager.updateLayoutParam(i, view, this.mSpenSettingLayout);
        setLayoutOrientation();
        settingVisible();
    }

    public void init(ArrayList<String> arrayList) {
        if (this.mSpenSettingLayout == null) {
            SpenPenLayoutInfo spenPenLayoutInfo = new SpenPenLayoutInfo(this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getSelectList(), this.mSettingViewManager.getSettingInfoManager().getColorRecentData().getRecentColors(), this.mIsSupportEyedropper, (List<String>) arrayList, false);
            spenPenLayoutInfo.supportFixedOpacity = this.mSupportFixedOpacity;
            spenPenLayoutInfo.supportDynamicPenWeightByTextSize = this.mSupportDynamicPenWeightByTextSize;
            this.mSpenSettingLayout = new SpenSettingPenLayout(this.mFloatingContainer.getContext(), this.mFloatingContainer, spenPenLayoutInfo, this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getColorSettingInfo());
        }
        initSettingLayout();
    }
}
