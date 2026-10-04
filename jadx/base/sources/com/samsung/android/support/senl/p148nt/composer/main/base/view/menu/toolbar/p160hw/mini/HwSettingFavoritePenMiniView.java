package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.mini;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenFavoriteButtonClickListener;
import com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenMiniLayout;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteDataChangedListener;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewItemClickListener;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingFavoritePenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.mini.HwSettingPenMiniMorePopup;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class HwSettingFavoritePenMiniView extends SpenSettingFavoritePenMiniLayout {
    private static final String TAG = Logger.createTag("HwSettingFavoritePenMiniView");
    private View mContainer;
    private List<SpenSettingUIPenInfo> mCurrentFavoriteList;
    private SettingFavoritePenData.FavoritePenInfoChangeListener mFavoritePenInfoChangeListener;
    private IFavoritePenMiniContract mIContract;
    private HwSettingPenMiniMorePopup mMorePopup;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IFavoritePenMiniContract {
        void applyPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo);

        HwSettingPresenter getSettingInstance();

        View.OnClickListener getToggleModeClickListener();

        void hide();

        boolean isSelectedPenTypeButtons();

        boolean isTouchDownConsumed();

        void rotate();

        void setSelectLastPenTypeButton(SpenSettingUIPenInfo spenSettingUIPenInfo);

        void updateCurrentPenInfo();
    }

    public HwSettingFavoritePenMiniView(Context context, int i, int i2, int i4) {
        super(context, i, i2, i4);
    }

    private void initMorePopup() {
        if (this.mMorePopup != null) {
            return;
        }
        HwSettingPenMiniMorePopup hwSettingPenMiniMorePopup = new HwSettingPenMiniMorePopup((ViewGroup) this.mContainer.getParent());
        this.mMorePopup = hwSettingPenMiniMorePopup;
        hwSettingPenMiniMorePopup.setOnClickListener(new HwSettingPenMiniMorePopup.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.6
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniMorePopup.OnClickListener
            public void onAddClick(View view) {
                HwSettingFavoritePenMiniView.this.showAddFavoritePen();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniMorePopup.OnClickListener
            public void onDeleteClick(View view) {
                HwSettingFavoritePenMiniView.this.setMode(2, true);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniMorePopup.OnClickListener
            public void onRotateClick(View view) {
                HwSettingFavoritePenMiniView.this.mIContract.rotate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFavoriteListIndex(int i) {
        if (getVisibility() != 0 || i == getSelectedItem()) {
            return;
        }
        AbstractC8014b.m7217s(i, "setFavoriteListIndex ", TAG);
        setSelectedItem(i, true);
    }

    private void setFavoriteViewListener() {
        setFavoriteDataChangedListener(new SpenFavoriteDataChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.2
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteDataChangedListener
            public void onFavoriteDataChanged(List<SpenSettingUIPenInfo> list) {
                HwSettingFavoritePenMiniView.this.mCurrentFavoriteList.clear();
                HwSettingFavoritePenMiniView.this.mCurrentFavoriteList.addAll(list);
                HwSettingFavoritePenMiniView.this.mIContract.getSettingInstance().setFavoriteInfoList(list);
            }
        });
        setOnButtonClickListener(new SpenFavoriteButtonClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.3
            @Override // com.samsung.android.sdk.pen.setting.SpenFavoriteButtonClickListener
            public void onButtonClick(int i) {
                AbstractC0000a.m3D(i, "onButtonClick : ", HwSettingFavoritePenMiniView.TAG);
                if (2 == i) {
                    HwSettingFavoritePenMiniView.this.showAddFavoritePen();
                    return;
                }
                if (1 == i) {
                    HwSettingFavoritePenMiniView.this.mIContract.hide();
                } else if (5 == i || 4 == i) {
                    HwSettingFavoritePenMiniView.this.mIContract.updateCurrentPenInfo();
                }
            }
        });
        setMoreButtonClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HwSettingFavoritePenMiniView.this.mIContract.isTouchDownConsumed()) {
                    return;
                }
                HwSettingFavoritePenMiniView.this.showMorePopup(view);
            }
        });
        setOnViewItemClickListener(new SpenFavoriteViewItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.5
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewItemClickListener
            public void onViewItemClick(SpenSettingUIPenInfo spenSettingUIPenInfo) {
                Logger.m11003i(HwSettingFavoritePenMiniView.TAG, "onViewItemClick " + spenSettingUIPenInfo.toString());
                SpenSettingUIPenInfo selectedPenInfo = HwSettingFavoritePenMiniView.this.mIContract.getSettingInstance().getSelectedPenInfo();
                if (selectedPenInfo == null || !CommonUtil.comparePenInfo(selectedPenInfo, spenSettingUIPenInfo)) {
                    HwSettingFavoritePenMiniView.this.mIContract.applyPenInfo(spenSettingUIPenInfo);
                } else if (HwSettingFavoritePenMiniView.this.mIContract.isSelectedPenTypeButtons()) {
                    HwSettingFavoritePenMiniView.this.mIContract.getSettingInstance().showSettingView(0, 128, HwSettingFavoritePenMiniView.this.mContainer);
                } else {
                    HwSettingFavoritePenMiniView.this.mIContract.setSelectLastPenTypeButton(selectedPenInfo);
                }
                HwSettingFavoritePenMiniView.this.hideMorePopup();
            }
        });
        setChangeViewModeButtonListener(this.mIContract.getToggleModeClickListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAddFavoritePen() {
        if (this.mIContract.getSettingInstance().getSettingInfoManager().getFavoritePenData().canAddFavoriteInfo()) {
            this.mIContract.getSettingInstance().showSettingView(0, 2, this.mContainer);
        } else {
            ToastHandler.show(this.mContainer.getContext(), C9086R.string.hw_toolbar_list_full_favorite_pen, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMorePopup(final View view) {
        initMorePopup();
        boolean z = !this.mIContract.getSettingInstance().getSettingInfoManager().getFavoritePenData().getFavoriteList().isEmpty();
        boolean zCanAddFavoriteInfo = this.mIContract.getSettingInstance().getSettingInfoManager().getFavoritePenData().canAddFavoriteInfo();
        this.mMorePopup.getView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                HwSettingFavoritePenMiniView.this.mMorePopup.getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ViewAnchorUtil.updatePosition(view, HwSettingFavoritePenMiniView.this.mContainer, HwSettingFavoritePenMiniView.this.mMorePopup.getView(), 10);
            }
        });
        this.mMorePopup.show(zCanAddFavoriteInfo, z);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenMiniLayout, com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public boolean addFavorite(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        this.mCurrentFavoriteList.add(spenSettingUIPenInfo);
        return super.addFavorite(spenSettingUIPenInfo);
    }

    public void cancelEditMode() {
        if (getMode() != 2) {
            return;
        }
        setMode(1);
    }

    public boolean hideMorePopup() {
        HwSettingPenMiniMorePopup hwSettingPenMiniMorePopup = this.mMorePopup;
        if (hwSettingPenMiniMorePopup != null) {
            return hwSettingPenMiniMorePopup.hide();
        }
        return false;
    }

    public void initialize(View view, IFavoritePenMiniContract iFavoritePenMiniContract) {
        this.mContainer = view;
        this.mIContract = iFavoritePenMiniContract;
        initMorePopup();
        this.mCurrentFavoriteList = new ArrayList();
        setFavoriteList(this.mIContract.getSettingInstance().getSettingInfoManager().getFavoritePenData().getFavoriteList());
        setDisallowMorePopup(true);
        setFavoriteViewListener();
        this.mFavoritePenInfoChangeListener = new SettingFavoritePenData.FavoritePenInfoChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingFavoritePenData.FavoritePenInfoChangeListener
            public void onFavoriteIndexChanged(int i) {
                if (HwSettingFavoritePenMiniView.this.getVisibility() != 0) {
                    return;
                }
                AbstractC8014b.m7217s(i, "onFavoriteIndexChanged ", HwSettingFavoritePenMiniView.TAG);
                HwSettingFavoritePenMiniView.this.cancelEditMode();
                HwSettingFavoritePenMiniView.this.setFavoriteListIndex(i);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingFavoritePenData.FavoritePenInfoChangeListener
            public void onFavoritePenInfoChanged(ArrayList<SpenSettingUIPenInfo> arrayList) {
                if (HwSettingFavoritePenMiniView.this.getVisibility() != 0 || HwSettingFavoritePenMiniView.this.mIContract.getSettingInstance().compareFavoritePenInfoList(HwSettingFavoritePenMiniView.this.mCurrentFavoriteList, arrayList)) {
                    return;
                }
                HwSettingFavoritePenMiniView.this.cancelEditMode();
                HwSettingFavoritePenMiniView.this.setFavoriteList(arrayList);
                HwSettingFavoritePenMiniView.this.updateFavoriteListIndex();
            }
        };
    }

    public void onVisibleAnimationEnd() {
        updateFavoriteList();
        updateFavoriteListIndex();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenMiniLayout, com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public void setFavoriteList(List<SpenSettingUIPenInfo> list) {
        if (!isSameFavoriteList(list)) {
            Logger.m11003i(TAG, "setFavoriteList# Different List. so update.");
            super.setFavoriteList(list);
        }
        this.mCurrentFavoriteList.clear();
        this.mCurrentFavoriteList.addAll(list);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.mIContract.getSettingInstance().getSettingInfoManager().getFavoritePenData().registerFavoriteInfoChangeListener(this.mFavoritePenInfoChangeListener);
        } else {
            this.mIContract.getSettingInstance().getSettingInfoManager().getFavoritePenData().unregisterFavoriteInfoChangeListener(this.mFavoritePenInfoChangeListener);
        }
    }

    public void updateFavoriteList() {
        setFavoriteList(this.mIContract.getSettingInstance().getSettingInfoManager().getFavoritePenData().getFavoriteList());
    }

    public void updateFavoriteListIndex() {
        setFavoriteListIndex(this.mIContract.getSettingInstance().getSelectedFavoritePenIndex());
    }
}
