package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingFavoritePenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingFavoritePenLayout extends HwSettingLayout {
    private static final String TAG = Logger.createTag("HwSettingFavoritePenLayout");
    private SettingFavoritePenData.FavoritePenInfoChangeListener mFavoritePenInfoChangeListener;
    private boolean mFlagSkipHideByPenTypeChanged = false;
    private List<SpenSettingUIPenInfo> mPreviousFavoriteList;
    protected SpenSettingFavoritePenLayout mSpenSettingLayout;

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelEditMode() {
        if (this.mSpenSettingLayout.getMode() == 2) {
            this.mSpenSettingLayout.setMode(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replacePreviousFavoriteListBy(List<SpenSettingUIPenInfo> list) {
        if (list == null) {
            return;
        }
        this.mPreviousFavoriteList.clear();
        this.mPreviousFavoriteList.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnToPrevious() {
        hide(false);
        this.mSettingViewManager.show(getCallerType(), this.mSettingViewManager.getSelectedToolbarItem(), null, false);
    }

    private void setChangeUIModeButtonListener() {
        if (this.mSettingViewManager.isTabletLayout()) {
            this.mSpenSettingLayout.setChangeUIModeButtonListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingFavoritePenLayout.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.m11003i(HwSettingFavoritePenLayout.TAG, "ChangeUIModeButton");
                    HwSettingFavoritePenLayout.this.mSettingViewManager.getSettingInstance().getSettingInfoManager().getPenMiniMenuData().setFavoriteMode(true);
                    HwSettingFavoritePenLayout.this.mSettingViewManager.getSettingInstance().getSettingInfoManager().getPenMiniMenuData().setEnable(true);
                    HwSettingFavoritePenLayout.this.mSettingViewManager.hide();
                    HwSettingFavoritePenLayout.this.mSettingViewManager.onShowSettingPenMini();
                    ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_SHRINK_FAVORITE);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemSelection(int i) {
        if (this.mSpenSettingLayout.getSelectedItem() == i) {
            return;
        }
        AbstractC0000a.m3D(i, "setItemSelection index : ", TAG);
        this.mSpenSettingLayout.setSelectedItem(i);
    }

    private void setLayoutOrientation() {
        if (this.mSettingViewManager.isTabletLayout() || this.mSpenSettingLayout.getResources().getConfiguration().orientation != 2) {
            this.mSpenSettingLayout.setLayoutOrientation(1);
        } else {
            this.mSpenSettingLayout.setLayoutOrientation(2);
        }
    }

    private void setOnButtonClickListener() {
        this.mSpenSettingLayout.setOnButtonClickListener(new SpenSettingFavoritePenLayout.OnButtonClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingFavoritePenLayout.8
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.OnButtonClickListener
            public void onAddButtonClick() {
                HwSettingFavoritePenLayout.this.onAddButtonClick();
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.OnButtonClickListener
            public void onCloseButtonClick() {
                HwSettingFavoritePenLayout.this.onCloseButtonClick();
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.OnButtonClickListener
            public void onDeleteButtonClick() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_FAVORITE_PEN_DELETE);
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.OnButtonClickListener
            public void onEditCancelButtonClick() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_EDIT_FAVORITE_PEN_CANCEL);
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.OnButtonClickListener
            public void onEditDoneButtonClick() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_ADD_FAVORITE_PEN_DONE);
            }
        });
    }

    private void setOnViewItemClickListener() {
        this.mSpenSettingLayout.setOnViewItemClickListener(new SpenSettingFavoritePenLayout.OnViewItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingFavoritePenLayout.7
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.OnViewItemClickListener
            public void onViewItemClick(SpenSettingUIPenInfo spenSettingUIPenInfo) {
                SpenSettingUIPenInfo selectedPenInfo = HwSettingFavoritePenLayout.this.mSettingViewManager.getSettingInstance().getSelectedPenInfo();
                if (spenSettingUIPenInfo != null && CommonUtil.comparePenInfo(spenSettingUIPenInfo, selectedPenInfo)) {
                    HwSettingFavoritePenLayout hwSettingFavoritePenLayout = HwSettingFavoritePenLayout.this;
                    hwSettingFavoritePenLayout.mSettingViewManager.show(hwSettingFavoritePenLayout.getCallerType(), 128);
                    return;
                }
                if (HwSettingFavoritePenLayout.this.mSettingViewManager.getSettingInstance().getPenType(selectedPenInfo) != HwSettingFavoritePenLayout.this.mSettingViewManager.getSettingInstance().getPenType(spenSettingUIPenInfo)) {
                    HwSettingFavoritePenLayout.this.mFlagSkipHideByPenTypeChanged = true;
                }
                String str = spenSettingUIPenInfo != null ? spenSettingUIPenInfo.name : "";
                HwSettingFavoritePenLayout.this.mSettingViewManager.getSettingInstance().setAllTypePenSettingInfo(spenSettingUIPenInfo);
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_FAVORITE_PEN_TYPE, HwSettingSALog.getSADetailPenType(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateItemSelection() {
        setItemSelection(this.mSettingViewManager.getSettingInstance().getSelectedFavoritePenIndex());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        SpenSettingFavoritePenLayout spenSettingFavoritePenLayout = this.mSpenSettingLayout;
        if (spenSettingFavoritePenLayout != null) {
            spenSettingFavoritePenLayout.close();
            this.mSpenSettingLayout = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        if (!isVisible() || this.mFlagSkipHideByPenTypeChanged) {
            this.mFlagSkipHideByPenTypeChanged = false;
            return;
        }
        this.mSettingViewManager.getSettingInfoManager().getFavoritePenData().unregisterFavoriteInfoChangeListener(this.mFavoritePenInfoChangeListener);
        inOutVI(this.mSpenSettingLayout, z);
        this.mSpenSettingLayout.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mSpenSettingLayout != null) {
            return;
        }
        this.mSpenSettingLayout = new SpenSettingFavoritePenLayout(this.mFloatingContainer.getContext(), 1, this.mSettingViewManager.getSettingInfoManager().getFavoritePenData().getFavoriteMaxCount(), this.mSettingViewManager.isTabletLayout());
        this.mFavoritePenInfoChangeListener = new SettingFavoritePenData.FavoritePenInfoChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingFavoritePenLayout.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingFavoritePenData.FavoritePenInfoChangeListener
            public void onFavoriteIndexChanged(int i) {
                if (HwSettingFavoritePenLayout.this.isVisible()) {
                    AbstractC8014b.m7217s(i, "onFavoriteIndexChanged ", HwSettingFavoritePenLayout.TAG);
                    HwSettingFavoritePenLayout.this.cancelEditMode();
                    HwSettingFavoritePenLayout.this.setItemSelection(i);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingFavoritePenData.FavoritePenInfoChangeListener
            public void onFavoritePenInfoChanged(ArrayList<SpenSettingUIPenInfo> arrayList) {
                if (!HwSettingFavoritePenLayout.this.isVisible() || HwSettingFavoritePenLayout.this.mSettingViewManager.getSettingInstance().compareFavoritePenInfoList(HwSettingFavoritePenLayout.this.mPreviousFavoriteList, arrayList)) {
                    return;
                }
                HwSettingFavoritePenLayout.this.cancelEditMode();
                HwSettingFavoritePenLayout.this.mSpenSettingLayout.setFavoriteList(arrayList);
                HwSettingFavoritePenLayout.this.updateItemSelection();
                HwSettingFavoritePenLayout.this.replacePreviousFavoriteListBy(arrayList);
            }
        };
        this.mSpenSettingLayout.setOnFavoriteDataChangedListener(new SpenSettingFavoritePenLayout.OnFavoriteDataChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingFavoritePenLayout.2
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.OnFavoriteDataChangedListener
            public void onFavoriteDataChanged(List<SpenSettingUIPenInfo> list) {
                AbstractC0000a.m3D(list != null ? list.size() : 0, "onFavoriteDataChanged : ", HwSettingFavoritePenLayout.TAG);
                HwSettingFavoritePenLayout.this.replacePreviousFavoriteListBy(list);
                HwSettingFavoritePenLayout.this.mSettingViewManager.getSettingInstance().setFavoriteInfoList(list);
            }
        });
        setOnButtonClickListener();
        setOnViewItemClickListener();
        this.mSpenSettingLayout.setOnEditItemClickListener(new SpenSettingFavoritePenLayout.OnEditItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingFavoritePenLayout.3
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.OnEditItemClickListener
            public void onEditItemClick() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_ADD_FAVORITE_PEN_REMOVE);
            }
        });
        this.mSpenSettingLayout.setPenSettingButton(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingFavoritePenLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingFavoritePenLayout.this.returnToPrevious();
            }
        });
        this.mSpenSettingLayout.setVisibilityChangedListener(new SpenSettingFavoritePenLayout.ViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingFavoritePenLayout.5
            @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout.ViewListener
            public void onVisibilityChanged(int i) {
                HwSettingFavoritePenLayout hwSettingFavoritePenLayout = HwSettingFavoritePenLayout.this;
                hwSettingFavoritePenLayout.mSettingViewManager.updateShowState(hwSettingFavoritePenLayout.getCallerType(), HwSettingFavoritePenLayout.this.getViewId(), i == 0);
            }
        });
        setChangeUIModeButtonListener();
        setColorTheme(this.mSettingViewManager.getColorTheme());
        this.mFloatingContainer.addView(this.mSpenSettingLayout);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        SpenSettingFavoritePenLayout spenSettingFavoritePenLayout = this.mSpenSettingLayout;
        return spenSettingFavoritePenLayout != null && spenSettingFavoritePenLayout.getVisibility() == 0;
    }

    public void onAddButtonClick() {
        if (this.mSettingViewManager.getSettingInfoManager().getFavoritePenData().canAddFavoriteInfo()) {
            this.mSettingViewManager.show(getCallerType(), 2, null, false);
        } else {
            ToastHandler.show(this.mFloatingContainer.getContext(), C9086R.string.hw_toolbar_list_full_favorite_pen, 0);
        }
        ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_FAVORITE_PEN_ADD);
    }

    public void onCloseButtonClick() {
        hide(true);
        ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_FAVORITE_PEN_CLOSE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void setColorTheme(int i) {
        SpenSettingFavoritePenLayout spenSettingFavoritePenLayout = this.mSpenSettingLayout;
        if (spenSettingFavoritePenLayout != null) {
            spenSettingFavoritePenLayout.setColorTheme(i);
        }
    }

    public void setSkipHide(boolean z) {
        this.mFlagSkipHideByPenTypeChanged = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        if (isCalledFromToolbarInPenMiniMode(i)) {
            return;
        }
        setCallerType(i);
        init();
        if (this.mSpenSettingLayout.getVisibility() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mSettingViewManager.getSettingInfoManager().getFavoritePenData().getFavoriteList());
        this.mPreviousFavoriteList = arrayList;
        this.mSpenSettingLayout.setFavoriteList(arrayList);
        cancelEditMode();
        this.mSettingViewManager.getSettingInfoManager().getFavoritePenData().registerFavoriteInfoChangeListener(this.mFavoritePenInfoChangeListener);
        updateItemSelection();
        inOutVI(this.mSpenSettingLayout, z);
        this.mSpenSettingLayout.setVisibility(0);
        this.mSpenSettingLayout.requestFocus();
        updatePosition(i, view, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        setLayoutOrientation();
        this.mSettingViewManager.updateLayoutParam(i, this.mSpenSettingLayout);
    }
}
