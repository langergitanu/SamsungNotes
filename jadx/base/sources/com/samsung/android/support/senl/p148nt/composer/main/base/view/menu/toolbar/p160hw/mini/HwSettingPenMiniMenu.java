package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.mini;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.mini.HwSettingFavoritePenMiniView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.mini.HwSettingPenMiniContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.mini.HwSettingPenMiniView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingPenMiniMenu implements HwSettingContract.ISettingMiniView, HwSettingPenMiniView.IPenMiniContract, HwSettingFavoritePenMiniView.IFavoritePenMiniContract {
    private static final int HORIZONTAL_MINI_TOOLBAR = 0;
    private static final String PREF_KEY_MINI_TOOLBAR_ROTATE = "pref_key_mini_toolbar_rotate";
    private static final String TAG = Logger.createTag("HwSettingPenMiniMenu");
    private static final int VERTICAL_MINI_TOOLBAR = 1;
    private final View mBottomDocker;
    private final View mEndDocker;
    private final FloaterContainer mFloatingArea;
    private HwSettingPenMiniContainer mHwSettingPenMiniContainer;
    private final HwToolbarPresenter mHwToolbarPresenter;
    private final View mStartDocker;
    private View.OnClickListener mToggleModeClickListener;
    private final View mTopDocker;
    private HwSettingPenMiniView mSettingPenMiniView = null;
    private HwSettingFavoritePenMiniView mSettingFavoritePenMiniView = null;
    private boolean mIsTouchDownConsumed = false;

    public HwSettingPenMiniMenu(ViewGroup viewGroup, HwToolbarPresenter hwToolbarPresenter) {
        this.mHwToolbarPresenter = hwToolbarPresenter;
        hwToolbarPresenter.getMRemoteHwSettingPresenter().setSettingMiniView(this);
        this.mFloatingArea = (FloaterContainer) viewGroup.findViewById(C9086R.id.floating_layout_container);
        this.mTopDocker = viewGroup.findViewById(C9086R.id.top_docker);
        this.mBottomDocker = viewGroup.findViewById(C9086R.id.bottom_docker);
        this.mStartDocker = viewGroup.findViewById(C9086R.id.start_docker);
        this.mEndDocker = viewGroup.findViewById(C9086R.id.end_docker);
    }

    private int getOrientation() {
        return SharedPreferencesCompat.getInstance("Composer").getInt(PREF_KEY_MINI_TOOLBAR_ROTATE, 1);
    }

    private View getViewBy(boolean z) {
        return z ? this.mSettingFavoritePenMiniView : this.mSettingPenMiniView;
    }

    private void initSettingFavoritePenMiniLayout() {
        if (this.mSettingFavoritePenMiniView != null) {
            return;
        }
        HwSettingFavoritePenMiniView hwSettingFavoritePenMiniView = new HwSettingFavoritePenMiniView(this.mFloatingArea.getContext(), 1, this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getFavoritePenData().getFavoriteMaxCount(), getOrientation());
        this.mSettingFavoritePenMiniView = hwSettingFavoritePenMiniView;
        hwSettingFavoritePenMiniView.initialize(this.mHwSettingPenMiniContainer, this);
        this.mHwSettingPenMiniContainer.addView(this.mSettingFavoritePenMiniView);
    }

    private void initSettingPenMiniLayout() {
        if (this.mSettingPenMiniView != null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(Default.Pen.getNames()));
        arrayList.addAll(Arrays.asList(Default.Highlighter.getNames()));
        HwSettingPenMiniView hwSettingPenMiniView = new HwSettingPenMiniView(this.mFloatingArea.getContext(), this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getColorPaletteData().getSelectList(), this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getColorRecentData().getRecentColors(), true, arrayList, getOrientation());
        this.mSettingPenMiniView = hwSettingPenMiniView;
        hwSettingPenMiniView.initialize(this.mHwSettingPenMiniContainer, this);
        this.mHwSettingPenMiniContainer.addView(this.mSettingPenMiniView);
    }

    private boolean isFavoriteMode() {
        return this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getPenMiniMenuData().isFavoriteMode();
    }

    private void setOrientation(int i) {
        SharedPreferencesCompat.getInstance("Composer").putInt(PREF_KEY_MINI_TOOLBAR_ROTATE, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewModeBy(boolean z) {
        setViewModeBy(z, true);
        if (!z) {
            ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_MINI_PEN_DEPTH, "a");
        } else {
            ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_MINI_FAVORITE);
            ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_MINI_PEN_DEPTH, "b");
        }
    }

    private void setViewOrientation(int i) {
        if (isFavoriteMode()) {
            this.mSettingFavoritePenMiniView.setLayoutOrientation(i);
        } else {
            this.mSettingPenMiniView.setLayoutOrientation(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncViewOrientation(boolean z) {
        if (this.mSettingPenMiniView.getLayoutOrientation() == this.mSettingFavoritePenMiniView.getLayoutOrientation()) {
            return;
        }
        AbstractC8014b.m7224z("syncViewOrientation() isFavorite=", TAG, z);
        if (z) {
            this.mSettingFavoritePenMiniView.setLayoutOrientation(this.mSettingPenMiniView.getLayoutOrientation());
        } else {
            this.mSettingPenMiniView.setLayoutOrientation(this.mSettingFavoritePenMiniView.getLayoutOrientation());
        }
    }

    private void updatePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (isPenMiniVisible()) {
            this.mSettingPenMiniView.setInfo(spenSettingUIPenInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSliderLabelGravity() {
        HwSettingPenMiniContainer hwSettingPenMiniContainer = this.mHwSettingPenMiniContainer;
        if (hwSettingPenMiniContainer == null || this.mSettingPenMiniView == null) {
            return;
        }
        ViewAnchorUtil.Area areaRecommendDirection = ViewAnchorUtil.recommendDirection(hwSettingPenMiniContainer);
        if (ViewAnchorUtil.Area.LEFT.equals(areaRecommendDirection)) {
            this.mSettingPenMiniView.setSliderLabelGravity(3);
        } else if (ViewAnchorUtil.Area.TOP.equals(areaRecommendDirection)) {
            this.mSettingPenMiniView.setSliderLabelGravity(48);
        } else if (ViewAnchorUtil.Area.RIGHT.equals(areaRecommendDirection)) {
            this.mSettingPenMiniView.setSliderLabelGravity(5);
        } else if (ViewAnchorUtil.Area.BOTTOM.equals(areaRecommendDirection)) {
            this.mSettingPenMiniView.setSliderLabelGravity(80);
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder("updateSliderLabelGravity# gravity : ");
        sb.append(areaRecommendDirection.name());
        sb.append(" orientation : ");
        AbstractC8014b.m7195A(sb, str, getOrientation());
    }

    private void updateViewModeByPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (this.mSettingFavoritePenMiniView == null || !isFavoriteMode() || this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getFavoritePenData().isThereFavoriteInfo(spenSettingUIPenInfo) || this.mSettingFavoritePenMiniView.getMode() == 2) {
            return;
        }
        this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getPenMiniMenuData().setFavoriteMode(false);
        syncViewOrientation(false);
        setViewModeBy(false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
    public void addFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (isFavoriteMiniVisible()) {
            this.mHwSettingPenMiniContainer.beginDelayedRestrictOutOfBounds();
            this.mSettingFavoritePenMiniView.addFavorite(spenSettingUIPenInfo);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.IPenMiniContract, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.IFavoritePenMiniContract
    public void applyPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        boolean zIsSelectedSelectionTypeButtons = isSelectedSelectionTypeButtons();
        Logger.m11003i(TAG, "applyPenInfo " + spenSettingUIPenInfo.name + ", isSelectedSelectionTypeButtons: " + zIsSelectedSelectionTypeButtons);
        this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().setAllTypePenSettingInfo(spenSettingUIPenInfo);
        if (zIsSelectedSelectionTypeButtons) {
            return;
        }
        this.mHwToolbarPresenter.releaseAssistPopup();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.IPenMiniContract
    public void beginDelayedRestrictOutOfBounds() {
        HwSettingPenMiniContainer hwSettingPenMiniContainer = this.mHwSettingPenMiniContainer;
        if (hwSettingPenMiniContainer == null) {
            return;
        }
        hwSettingPenMiniContainer.beginDelayedRestrictOutOfBounds();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.IPenMiniContract, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.IFavoritePenMiniContract
    public HwSettingPresenter getSettingInstance() {
        return this.mHwToolbarPresenter.getMRemoteHwSettingPresenter();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.IPenMiniContract, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.IFavoritePenMiniContract
    public View.OnClickListener getToggleModeClickListener() {
        View.OnClickListener onClickListener = this.mToggleModeClickListener;
        if (onClickListener != null) {
            return onClickListener;
        }
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniMenu.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m11003i(HwSettingPenMiniMenu.TAG, "onChangeViewMode");
                boolean toggledFavoriteMode = HwSettingPenMiniMenu.this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getPenMiniMenuData().getToggledFavoriteMode();
                HwSettingPenMiniMenu.this.syncViewOrientation(toggledFavoriteMode);
                HwSettingPenMiniMenu.this.mHwSettingPenMiniContainer.beginDelayedRestrictOutOfBounds();
                HwSettingPenMiniMenu.this.setViewModeBy(toggledFavoriteMode);
            }
        };
        this.mToggleModeClickListener = onClickListener2;
        return onClickListener2;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
    public View getView() {
        return this.mSettingPenMiniView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.IFavoritePenMiniContract
    public void hide() {
        HwSettingPenMiniContainer hwSettingPenMiniContainer = this.mHwSettingPenMiniContainer;
        if (hwSettingPenMiniContainer == null) {
            return;
        }
        hwSettingPenMiniContainer.hide();
        this.mSettingFavoritePenMiniView.cancelEditMode();
        this.mHwToolbarPresenter.removePreTouchListener(this.mHwSettingPenMiniContainer.getPreTouchListener());
        hideMorePopup();
    }

    public boolean hideMorePopup() {
        HwSettingFavoritePenMiniView hwSettingFavoritePenMiniView = this.mSettingFavoritePenMiniView;
        if (hwSettingFavoritePenMiniView == null) {
            return false;
        }
        return hwSettingFavoritePenMiniView.hideMorePopup();
    }

    public void init() {
        initFloaterLayout();
        initSettingPenMiniLayout();
        initSettingFavoritePenMiniLayout();
        setColorTheme(this.mHwToolbarPresenter.getColorTheme());
    }

    public void initFloaterLayout() {
        HwSettingPenMiniContainer hwSettingPenMiniContainer = (HwSettingPenMiniContainer) LayoutInflater.from(this.mFloatingArea.getContext()).inflate(C9086R.layout.comp_hw_setting_pen_mini, this.mFloatingArea).findViewById(C9086R.id.hw_setting_pen_mini_root);
        this.mHwSettingPenMiniContainer = hwSettingPenMiniContainer;
        this.mFloatingArea.addFloater(hwSettingPenMiniContainer);
        this.mFloatingArea.setClipChildren(false);
        this.mHwSettingPenMiniContainer.setView(new HwSettingPenMiniContainer.IView() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniMenu.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.IView
            public View getBottomDocker() {
                return HwSettingPenMiniMenu.this.mBottomDocker;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.IView
            public View getEndDocker() {
                return HwSettingPenMiniMenu.this.mEndDocker;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.IView
            public View getStartDocker() {
                return HwSettingPenMiniMenu.this.mStartDocker;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.IView
            public View getTopDocker() {
                return HwSettingPenMiniMenu.this.mTopDocker;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.IView
            public void hideView() {
                HwSettingPenMiniMenu.this.hide();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.IView
            public void onActionEnd() {
                HwSettingPenMiniMenu.this.updateSliderLabelGravity();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.IView
            public void onReadyToRotate() {
                HwSettingPenMiniMenu.this.toggleRotate();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.IView
            public void onTouchDown() {
                HwSettingPenMiniMenu hwSettingPenMiniMenu = HwSettingPenMiniMenu.this;
                hwSettingPenMiniMenu.mIsTouchDownConsumed = hwSettingPenMiniMenu.mHwToolbarPresenter.getMRemoteHwSettingPresenter().onTouchOutside();
                if (HwSettingPenMiniMenu.this.mIsTouchDownConsumed) {
                    return;
                }
                if (HwSettingPenMiniMenu.this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getHwToolbarState().isColorSpoidEnable() && HwSettingPenMiniMenu.this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().hideColorSpoid()) {
                    HwSettingPenMiniMenu.this.mIsTouchDownConsumed = true;
                }
                if (HwSettingPenMiniMenu.this.hideMorePopup()) {
                    HwSettingPenMiniMenu.this.mIsTouchDownConsumed = true;
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.IView
            public void onVisibleAnimationEnd() {
                HwSettingPenMiniMenu.this.mSettingFavoritePenMiniView.onVisibleAnimationEnd();
            }
        });
    }

    public boolean isFavoriteMiniVisible() {
        HwSettingFavoritePenMiniView hwSettingFavoritePenMiniView = this.mSettingFavoritePenMiniView;
        return hwSettingFavoritePenMiniView != null && hwSettingFavoritePenMiniView.isShown();
    }

    public boolean isPenMiniMode() {
        return this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getPenMiniMenuData().isEnable();
    }

    public boolean isPenMiniVisible() {
        return this.mSettingPenMiniView != null && this.mHwSettingPenMiniContainer.isShowing();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.IFavoritePenMiniContract
    public boolean isSelectedPenTypeButtons() {
        List<Integer> selectedMenu = this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getHwToolbarState().getSelectedMenu();
        if (selectedMenu != null && !selectedMenu.isEmpty()) {
            for (Integer num : selectedMenu) {
                if (num.intValue() == 2 || num.intValue() == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSelectedSelectionTypeButtons() {
        List<Integer> selectedMenu = this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getHwToolbarState().getSelectedMenu();
        if (selectedMenu != null && !selectedMenu.isEmpty()) {
            Iterator<Integer> it = selectedMenu.iterator();
            while (it.hasNext()) {
                if (it.next().intValue() == 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.IPenMiniContract, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.IFavoritePenMiniContract
    public boolean isTouchDownConsumed() {
        return this.mIsTouchDownConsumed;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
    public void onPickerColorChanged(int i, float[] fArr) {
        if (4096 == i) {
            this.mSettingPenMiniView.setViewMode(1);
        }
        SpenSettingUIPenInfo info = this.mSettingPenMiniView.getInfo();
        if (info != null) {
            info.hsv = fArr;
            info.color = ColorCompat.HSVToColor(fArr);
            this.mSettingPenMiniView.setInfo(info);
        }
    }

    public boolean onTouchOutside() {
        return hideMorePopup();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.IFavoritePenMiniContract
    public void rotate() {
        this.mHwSettingPenMiniContainer.rotateVI();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.IPenMiniContract
    public void runHidingVI() {
        HwSettingPenMiniContainer hwSettingPenMiniContainer = this.mHwSettingPenMiniContainer;
        if (hwSettingPenMiniContainer == null) {
            return;
        }
        hwSettingPenMiniContainer.runHidingVI();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.IPenMiniContract
    public void runReboundVI() {
        HwSettingPenMiniContainer hwSettingPenMiniContainer = this.mHwSettingPenMiniContainer;
        if (hwSettingPenMiniContainer == null || !hwSettingPenMiniContainer.isShowing()) {
            return;
        }
        this.mHwSettingPenMiniContainer.runReboundVI();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
    public void setColorTheme(int i) {
        HwSettingPenMiniView hwSettingPenMiniView = this.mSettingPenMiniView;
        if (hwSettingPenMiniView == null || this.mSettingFavoritePenMiniView == null) {
            return;
        }
        hwSettingPenMiniView.setColorTheme(i);
        this.mSettingFavoritePenMiniView.setColorTheme(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
    public void setFavoriteList(List<SpenSettingUIPenInfo> list) {
        if (isFavoriteMiniVisible()) {
            this.mHwSettingPenMiniContainer.beginDelayedRestrictOutOfBounds();
            this.mSettingFavoritePenMiniView.setFavoriteList(list);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
    public void setPaletteList(List<Integer> list) {
        if (isPenMiniVisible()) {
            this.mSettingPenMiniView.setPalette(list);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
    public void setPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        Logger.m11003i(TAG, "setPenInfo " + spenSettingUIPenInfo.name);
        updateViewModeByPenInfo(spenSettingUIPenInfo);
        updatePenInfo(spenSettingUIPenInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
    public void setRecentColor(List<SpenHSVColor> list) {
        if (isPenMiniVisible()) {
            this.mSettingPenMiniView.setRecentColor(list);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.IFavoritePenMiniContract
    public void setSelectLastPenTypeButton(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().updateToolbarSelectionState(spenSettingUIPenInfo);
    }

    public void show() {
        if (this.mHwSettingPenMiniContainer == null) {
            init();
        }
        if (isPenMiniVisible() || isFavoriteMiniVisible()) {
            return;
        }
        setViewModeBy(isFavoriteMode(), false);
        this.mHwSettingPenMiniContainer.show();
        this.mHwSettingPenMiniContainer.bringToFront();
        this.mHwToolbarPresenter.addPreTouchListener(this.mHwSettingPenMiniContainer.getPreTouchListener());
        updateCurrentPenInfo();
        updateSliderLabelGravity();
        HwSettingPenMiniView hwSettingPenMiniView = this.mSettingPenMiniView;
        if (hwSettingPenMiniView != null) {
            hwSettingPenMiniView.setAllPenInfo();
        }
        this.mIsTouchDownConsumed = false;
    }

    public void toggleRotate() {
        int i = getOrientation() == 1 ? 0 : 1;
        setOrientation(i);
        setViewOrientation(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingFavoritePenMiniView.IFavoritePenMiniContract
    public void updateCurrentPenInfo() {
        updatePenInfo(this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSelectedPenInfo());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.IPenMiniContract
    public void updatePenMode() {
        if (!isPenMiniVisible() || isSelectedPenTypeButtons()) {
            return;
        }
        setSelectLastPenTypeButton(getSettingInstance().getSelectedPenInfo());
    }

    private void setViewModeBy(boolean z, boolean z2) {
        if (this.mHwSettingPenMiniContainer == null) {
            return;
        }
        this.mHwSettingPenMiniContainer.replaceView(getViewBy(!z), getViewBy(z), z2);
    }
}
