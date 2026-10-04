package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingUILaserPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayoutV2;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.handwriting.LaserPenInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingAssistanceData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingStraightenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.LanguageUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingInfoSALog;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.SettingInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AnchorInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwToolbarState;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarConstants;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguage;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingPresenter implements HwSettingContract.IPresenter {
    public static final int LASER_TYPE_OUTLINE = 2;
    private static final String TAG = Logger.createTag("HwSettingPresenter");
    private final SettingInfoManager.ComponentFactory mComponentFactory;
    private final boolean mHandWritingHelpEnabled;
    protected HwColorChangeObserver mHwColorChangeObserver;
    private HwSettingFavoriteInfo mHwSettingFavoriteInfo;
    private HwSettingHighlighterInfo mHwSettingHighlighterInfo;
    private HwSettingInfoSALog mHwSettingInfoSALog;
    private HwSettingPenInfo mHwSettingPenInfo;
    private HwSettingQuickColorInfo mHwSettingQuickColorInfo;
    private HwSettingQuickSizeInfo mHwSettingQuickSizeInfo;
    private HwSettingRemoverInfo mHwSettingRemoverInfo;
    protected HwSettingContract.IItemView mItemView;
    private LaserPenInfo[] mLaserPenInfoList;
    private SpenSettingUIPenInfo mLastPenInfo;
    protected int mPageCount;
    protected int mPageIndex;
    protected HwSettingContract.IQuickToolView mQuickToolView;
    protected SettingInfoManager mSettingInfoManager;
    protected HwSettingContract.ISettingMiniView mSettingMiniView;
    protected HwSettingContract.ISettingView mSettingView;
    protected HwToolbarPresenterImpl mToolbarPresenter;
    protected boolean mTwoPageView;
    protected ComposerViewContract.IPresenter mViewPresenter;
    protected WritingToolManager mWritingToolManager;

    public HwSettingPresenter(@NonNull SettingInfoManager.ComponentFactory componentFactory) {
        this.mHandWritingHelpEnabled = true;
        this.mComponentFactory = componentFactory;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void addSALogForLaserPenSetting(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo, SpenSettingUILaserPenInfo spenSettingUILaserPenInfo2, boolean z) {
        String str;
        String screenID = ComposerSA.getScreenID(true, true, this.mToolbarPresenter.isTabletLayout());
        int i = spenSettingUILaserPenInfo.type;
        int i2 = spenSettingUILaserPenInfo2.type;
        if (i == i2) {
            boolean z2 = spenSettingUILaserPenInfo.fillInside;
            boolean z3 = spenSettingUILaserPenInfo2.fillInside;
            if (z2 != z3) {
                str = i2 == 0 ? z ? HWToolbarSAConstants.EVENT_HW_LASER_APPBAR_PEN_POINT : HWToolbarSAConstants.EVENT_HW_LASER_PEN_POINT : spenSettingUILaserPenInfo2.fillInside ? z ? HWToolbarSAConstants.EVENT_HW_LASER_APPBAR_PEN_LINE_FILLED : HWToolbarSAConstants.EVENT_HW_LASER_PEN_LINE_FILLED : z ? HWToolbarSAConstants.EVENT_HW_LASER_APPBAR_PEN_LINE_UNFILLED : HWToolbarSAConstants.EVENT_HW_LASER_PEN_LINE_UNFILLED;
            } else {
                int i4 = spenSettingUILaserPenInfo.colorOption;
                int i5 = spenSettingUILaserPenInfo2.colorOption;
                str = i4 != i5 ? i5 == 1 ? z3 ? z ? HWToolbarSAConstants.EVENT_HW_LASER_APPBAR_PEN_LINE_FILLED_RAINBOW : HWToolbarSAConstants.EVENT_HW_LASER_PEN_LINE_FILLED_RAINBOW : HWToolbarSAConstants.EVENT_HW_LASER_PEN_LINE_UNFILLED_RAINBOW : z3 ? z ? HWToolbarSAConstants.EVENT_HW_LASER_APPBAR_PEN_LINE_FILLED_SINGLE : HWToolbarSAConstants.EVENT_HW_LASER_PEN_LINE_FILLED_SINGLE : HWToolbarSAConstants.EVENT_HW_LASER_PEN_LINE_UNFILLED_SINGLE : "";
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ComposerSA.insertLog(screenID, str);
    }

    private LaserPenInfo getLastLaserPenInfo() {
        if (this.mLaserPenInfoList == null) {
            initLaserPenInfoList();
        }
        SpenSettingUILaserPenInfo laserPenInfo = getSettingInfoManager().getLaserPenData().getLaserPenInfo();
        LaserPenInfo laserPenInfo2 = laserPenInfo.type == 0 ? this.mLaserPenInfoList[0] : !laserPenInfo.fillInside ? this.mLaserPenInfoList[2] : this.mLaserPenInfoList[1];
        LaserPenInfo laserPenInfo3 = new LaserPenInfo(laserPenInfo2.getType(), laserPenInfo2.getBlurSize(), laserPenInfo2.isFillInside(), laserPenInfo2.getStrokeSize(), laserPenInfo2.getInsideRatio());
        laserPenInfo3.setColor(laserPenInfo.color);
        laserPenInfo3.setColorOption(laserPenInfo.colorOption);
        return laserPenInfo3;
    }

    private void initLaserPenInfoList() {
        this.mLaserPenInfoList = new LaserPenInfo[3];
        if (DeviceUtils.isFoldableModel()) {
            this.mLaserPenInfoList[0] = new LaserPenInfo(0, 21.0f, false, 55, 60);
            this.mLaserPenInfoList[1] = new LaserPenInfo(1, 12.0f, true, 15, 75);
            this.mLaserPenInfoList[2] = new LaserPenInfo(1, 12.0f, false, 20, 75);
        } else if (DeviceUtils.isTabletModel()) {
            this.mLaserPenInfoList[0] = new LaserPenInfo(0, 21.0f, false, 55, 60);
            this.mLaserPenInfoList[1] = new LaserPenInfo(1, 7.0f, true, 8, 75);
            this.mLaserPenInfoList[2] = new LaserPenInfo(1, 7.0f, false, 9, 80);
        } else {
            this.mLaserPenInfoList[0] = new LaserPenInfo(0, 18.0f, false, 80, 60);
            this.mLaserPenInfoList[1] = new LaserPenInfo(1, 8.0f, true, 15, 75);
            this.mLaserPenInfoList[2] = new LaserPenInfo(1, 8.0f, false, 22, 75);
        }
    }

    private boolean shouldUpdatePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        SpenSettingUIPenInfo selectedPenInfo = getSelectedPenInfo();
        if (selectedPenInfo == null) {
            return false;
        }
        return (getHwToolbarState().getSelectedMenu().contains(Integer.valueOf(getSelectedPenType())) && CommonUtil.comparePenInfo(selectedPenInfo, spenSettingUIPenInfo)) ? false : true;
    }

    private void updateItemView(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        this.mItemView.checkValidQuickColorItem(spenSettingUIPenInfo.color);
        this.mItemView.checkValidQuickSizeItem(spenSettingUIPenInfo.sizeLevel);
    }

    private void updateSettingView(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (spenSettingUIPenInfo == null) {
            return;
        }
        this.mHwSettingFavoriteInfo.notifyFavoriteIndexChanged(spenSettingUIPenInfo);
        this.mSettingMiniView.setPenInfo(spenSettingUIPenInfo);
    }

    public void addFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        this.mSettingMiniView.addFavoritePenInfo(spenSettingUIPenInfo);
        this.mHwSettingFavoriteInfo.addFavoritePenInfo(spenSettingUIPenInfo);
        setAllTypePenSettingInfo(spenSettingUIPenInfo);
        this.mSettingView.onUpdateFavoriteButton(true);
    }

    public void addPreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener) {
        this.mToolbarPresenter.addPreTouchListener(preTouchListener);
    }

    public void addRecentColor(int i) {
        getSettingInfoManager().getColorRecentData().addRecentColor(i);
    }

    public void addSelectedMenu(int i) {
        AbstractC8014b.m7217s(i, "addSelectedMenu ", TAG);
    }

    public void applyAlignmentOptions() {
        SettingStraightenData straightenData = getSettingInfoManager().getStraightenData();
        this.mWritingToolManager.setAlignmentOptions(straightenData.getStraightenEnabled(), straightenData.getAlignLettersEnabled(), straightenData.getEvenlySpaceWordsEnabled(), straightenData.getFixShapeLettersEnabled());
    }

    public void applyQuickColor(float[] fArr) {
        this.mHwSettingQuickColorInfo.applyQuickColor(fArr);
    }

    public void applyQuickSize(int i) {
        this.mHwSettingQuickSizeInfo.applyQuickSize(i);
    }

    public void applyToolbarEnabledState(boolean z) {
        this.mItemView.applyToolbarEnabledState(z);
    }

    public boolean canUseAssistanceOptions() {
        SettingAssistanceData settingAssistanceData = getSettingInfoManager().getSettingAssistanceData();
        return (settingAssistanceData.hasEnableOption() && isBeautifierSupportedLanguage()) || settingAssistanceData.getGuidelineEnable();
    }

    public void cancelAlignment() {
        this.mWritingToolManager.cancel();
        this.mWritingToolManager.clearSelection();
    }

    public void cancelConvertToText() {
        if (this.mWritingToolManager.cancelConvertToText()) {
            this.mWritingToolManager.clearSelection();
        }
    }

    public void changeFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo, SpenSettingUIPenInfo spenSettingUIPenInfo2) {
        this.mHwSettingFavoriteInfo.changeFavoritePenInfo(spenSettingUIPenInfo, spenSettingUIPenInfo2);
        this.mSettingMiniView.setFavoriteList(getSettingInfoManager().getFavoritePenData().getFavoriteList());
        setAllTypePenSettingInfo(spenSettingUIPenInfo2);
    }

    public void changeMoveOnlyMode(boolean z) {
        if (this.mViewPresenter.getComposerModel() == null) {
            return;
        }
        this.mViewPresenter.getComposerModel().getModeManager().setMoveOnlyMode(z);
    }

    public void changeTextMode() {
        if (this.mToolbarPresenter.isTextMode()) {
            this.mToolbarPresenter.showSoftInput();
        } else {
            this.mToolbarPresenter.changeTextMode();
            this.mSettingView.hide();
        }
    }

    public void changeWritingMode() {
        if (this.mToolbarPresenter.isTextMode()) {
            this.mToolbarPresenter.changeWritingMode();
        }
    }

    public void clearControl() {
        this.mWritingToolManager.clearControl();
        if (this.mToolbarPresenter.isTextMode()) {
            return;
        }
        this.mWritingToolManager.clearSelection();
    }

    public void clearLastPenInfoInNote() {
        if (this.mViewPresenter.getComposerModel() == null) {
            return;
        }
        this.mViewPresenter.getComposerModel().clearLastPenInfoInNote();
    }

    public boolean compareFavoritePenInfoList(List<SpenSettingUIPenInfo> list, List<SpenSettingUIPenInfo> list2) {
        return this.mHwSettingFavoriteInfo.compareFavoritePenInfoList(list, list2);
    }

    public void confirmAlignment() {
        this.mWritingToolManager.confirm();
    }

    public void executeConvertToText() {
        cancelAlignment();
        try {
            if (this.mWritingToolManager.executeConvertToText(LanguageUtil.getConvertToTextLanguage(getActivity()))) {
                return;
            }
            ToastHandler.show(getActivity(), C9086R.string.composer_could_not_find_any_handwriting, 1);
        } catch (TextRecognitionLanguage.SupportedLanguageException e) {
            Logger.m11000e(TAG, "executeConvertToText " + e.getMessage());
        }
    }

    public void executeEraseAllOnAllPages() {
        clearControl();
        this.mToolbarPresenter.executeEraseAllOnAllPages();
    }

    public void executeEraseAllOnCurrentPage(int i) {
        clearControl();
        this.mToolbarPresenter.executeEraseAllOnCurrentPage(i);
    }

    public boolean executeRemoteFavoritePen(boolean z) {
        this.mSettingView.onTouchOutside();
        try {
            SpenSettingUIPenInfo favoritePenToPenSetting = this.mHwSettingFavoriteInfo.getFavoritePenToPenSetting(z);
            setAllTypePenSettingInfo(favoritePenToPenSetting);
            updateToolbarSelectionState(favoritePenToPenSetting);
            return true;
        } catch (IllegalStateException e) {
            Logger.m11003i(TAG, "executeRemoteFavoritePen " + e.getMessage());
            return false;
        }
    }

    public void executeSelectedChangeStyle(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        this.mToolbarPresenter.executeSelectedChangeStyle(spenSettingUIChangeStyleInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    public Activity getActivity() {
        return this.mViewPresenter.getActivity();
    }

    public String getBeautifierLanguage() {
        return this.mWritingToolManager.getBeautifierLanguage();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    public HwToolbarState getHwToolbarState() {
        return this.mItemView.getHwToolbarState();
    }

    public SpenSettingUIPenInfo getLastPenInfoInNote() {
        if (this.mViewPresenter.getComposerModel() == null) {
            return null;
        }
        return this.mViewPresenter.getComposerModel().getLastPenInfoInNote();
    }

    public int getPageCount() {
        return this.mPageCount;
    }

    public int getPageIndex() {
        return this.mPageIndex;
    }

    public int getPenType(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (spenSettingUIPenInfo == null) {
            return 0;
        }
        if (Default.Highlighter.find(spenSettingUIPenInfo.name) != null) {
            return 2048;
        }
        if (Default.Pen.find(spenSettingUIPenInfo.name) != null) {
            return 2;
        }
        Logger.m11000e(TAG, "updateLastPenInfoInNote : can not find this penInfo = " + spenSettingUIPenInfo.name);
        return 0;
    }

    public int getSelectedFavoritePenIndex() {
        return this.mHwSettingFavoriteInfo.getSelectedFavoritePenIndex();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    public SpenSettingUIPenInfo getSelectedPenInfo() {
        return getHwToolbarState().getLastPenType() == 2048 ? getSettingInfoManager().getHighlighterData().getSettingHighlighterInfoSelected() : getSettingInfoManager().getPenInfoData().getSettingPenInfoSelected();
    }

    public int getSelectedPenType() {
        return getPenType(getSelectedPenInfo());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    public SettingInfoManager getSettingInfoManager() {
        if (this.mSettingInfoManager == null) {
            this.mSettingInfoManager = new SettingInfoManager(this.mViewPresenter.getActivity(), this.mWritingToolManager, this.mComponentFactory);
            if (this.mToolbarPresenter.isCoeditNote()) {
                this.mSettingInfoManager.initSettingDataForCoEdit();
            }
        }
        return this.mSettingInfoManager;
    }

    public HwSettingContract.ISettingMiniView getSettingMiniView() {
        return this.mSettingMiniView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    public HwSettingContract.ISettingView getSettingView() {
        return this.mSettingView;
    }

    public boolean hideColorSpoid() {
        return this.mSettingView.hideColorSpoid();
    }

    public void hideSettingView(int i) {
        this.mSettingView.hideSettingView(i);
    }

    public void hideSettingViews(boolean z) {
        this.mSettingView.hideSettingViews(z);
    }

    public boolean isAlignmentRunning() {
        return this.mWritingToolManager.isAlignmentRunning();
    }

    public boolean isAssistanceSelected() {
        return this.mItemView.isAssistanceSelected();
    }

    public boolean isBeautifierSupportedLanguage() {
        return this.mWritingToolManager.isBeautifierSupportedLanguage();
    }

    public boolean isHighlighterType(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        return getPenType(spenSettingUIPenInfo) == 2048;
    }

    public boolean isNotStickyMemoConnected() {
        return this.mHwSettingRemoverInfo.isNotStickyMemoConnected();
    }

    public boolean isShownSettingViews(int i) {
        return this.mSettingView.isShownSettingViews(i);
    }

    public boolean isTwoPageView() {
        return this.mTwoPageView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    public void notifyRecentColorChanged() {
        List<SpenHSVColor> recentColors = getSettingInfoManager().getColorRecentData().getRecentColors();
        this.mSettingMiniView.setRecentColor(recentColors);
        HwSettingContract.IQuickToolView iQuickToolView = this.mQuickToolView;
        if (iQuickToolView != null) {
            iQuickToolView.onRecentColorsChanged(recentColors);
        }
    }

    public void onBeautifierLanguage(String str, boolean z) {
        applyAlignmentOptions();
        setAssistance(this.mItemView.getHwToolbarState().getSelectedMenu().contains(131072));
        updateAssistanceSelection();
        this.mSettingView.updateBeautifierLanguage(str, z);
    }

    public void onColorThemeChanged(int i) {
        this.mItemView.onUpdateToolbarItem();
        this.mSettingView.setColorTheme(i);
        this.mSettingMiniView.setColorTheme(i);
        HwSettingContract.IQuickToolView iQuickToolView = this.mQuickToolView;
        if (iQuickToolView != null) {
            iQuickToolView.onColorThemeChanged(i);
        }
    }

    public void onObjectChanged() {
        this.mItemView.onObjectChanged();
    }

    public void onPaletteChanged(List<Integer> list) {
        getSettingInfoManager().getColorPaletteData().setSelectList(list);
        this.mSettingMiniView.setPaletteList(list);
        this.mSettingView.notifyPaletteSetChanged(list);
        HwSettingContract.IQuickToolView iQuickToolView = this.mQuickToolView;
        if (iQuickToolView != null) {
            iQuickToolView.onColorPalettesChanged(list);
        }
    }

    public void onPickerColorChanged(int i, int i2, @Size(3) float[] fArr) {
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "onPickerColorChanged callerId ", " mode ", " ");
        sbM1173s.append(fArr[0]);
        sbM1173s.append(" / ");
        sbM1173s.append(fArr[1]);
        sbM1173s.append(" / ");
        sbM1173s.append(fArr[2]);
        Logger.m11003i(str, sbM1173s.toString());
        if (i == 0) {
            this.mSettingMiniView.onPickerColorChanged(i2, fArr);
        } else {
            setQuickColorInfo(HwToolbarConstants.QUICK_COLOR.getOrdinal(i), fArr);
            applyQuickColor(fArr);
        }
    }

    public void onRedoable(boolean z) {
        this.mItemView.updateRedoMenu(z);
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Logger.m11003i(TAG, "onSaveInstanceState#");
        SettingInfoManager settingInfoManager = this.mSettingInfoManager;
        if (settingInfoManager == null) {
            return;
        }
        settingInfoManager.onSaveInstanceState(bundle);
    }

    public boolean onTouchOutside() {
        return this.mSettingView.onTouchOutside();
    }

    public void onUndoable(boolean z) {
        this.mItemView.updateUndoMenu(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    public void onUpdateEyedropperColor() {
        this.mSettingView.onUpdateEyedropperColor();
    }

    public void onUpdatedLaserPen(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
        if (spenSettingUILaserPenInfo == null) {
            return;
        }
        this.mItemView.onUpdatedLaserPen(new Pair<>(Integer.valueOf(spenSettingUILaserPenInfo.color), Integer.valueOf(spenSettingUILaserPenInfo.colorOption)));
        this.mSettingView.setLaserPenSettingInfo(spenSettingUILaserPenInfo);
    }

    public void onZoomLock(boolean z) {
        this.mItemView.updateZoomLockMenu(z);
    }

    public void openSelectionChangeStyle(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo, boolean z, AnchorInfo anchorInfo) {
        this.mSettingView.showSelectionChangeStyle(0, spenSettingUIChangeStyleInfo, z, anchorInfo);
    }

    public void redo() {
        if (this.mToolbarPresenter.isRedoable()) {
            clearControl();
            this.mToolbarPresenter.redo();
        }
    }

    public void release() {
        Logger.m11003i(TAG, "release#");
        this.mSettingInfoManager.close();
        this.mSettingInfoManager = null;
        this.mHwColorChangeObserver.close();
    }

    public void releaseAssistPopup() {
        this.mToolbarPresenter.releaseAssistPopup();
    }

    public void reloadHwToolbarState() {
        HwSettingContract.IItemView iItemView = this.mItemView;
        iItemView.restoreHwToolbarState(iItemView.getHwToolbarState());
    }

    public void removeFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        this.mHwSettingFavoriteInfo.removeFavoritePenInfo(spenSettingUIPenInfo);
        this.mSettingView.onUpdateFavoriteButton(false);
    }

    public void removePreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener) {
        this.mToolbarPresenter.removePreTouchListener(preTouchListener);
    }

    public void removeSelectedMenu(int i) {
        AbstractC8014b.m7217s(i, "removeSelectedMenu ", TAG);
    }

    public void restore(Bundle bundle) {
        Logger.m11003i(TAG, "restore#");
        getSettingInfoManager().restore(bundle);
        this.mHwColorChangeObserver.setRecentColorListener();
    }

    public void restoreHwToolbarState(HwToolbarState hwToolbarState) {
        this.mItemView.restoreHwToolbarState(hwToolbarState);
    }

    public void setAlignment(boolean z) {
        if (this.mWritingToolManager.isAlignmentRunning() && z) {
            AbstractC8014b.m7224z("setAlignment duplicate execution ", TAG, z);
            return;
        }
        if (!z) {
            cancelAlignment();
            return;
        }
        cancelConvertToText();
        applyAlignmentOptions();
        if (FeatureInfo.isBeautifierFeatureEnabled() ? this.mWritingToolManager.executeCleanUp() : this.mWritingToolManager.executeAlignment()) {
            return;
        }
        ToastHandler.show(getActivity(), C9086R.string.composer_could_not_find_any_handwriting, 1);
    }

    public void setAlignmentOptions(boolean z, boolean z2, boolean z3, boolean z4) {
        SettingStraightenData straightenData = getSettingInfoManager().getStraightenData();
        straightenData.setStraightenEnabled(z);
        straightenData.setAlignLettersEnabled(z2);
        straightenData.setEvenlySpaceWordsEnabled(z3);
        straightenData.setFixShapeLettersEnabled(z4);
        this.mWritingToolManager.setAlignmentOptions(z, z2, z3, z4);
        this.mSettingView.setAlignmentOptions(z, z2, z3, z4);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    public void setAllTypePenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (shouldUpdatePenInfo(spenSettingUIPenInfo)) {
            if (isHighlighterType(spenSettingUIPenInfo)) {
                this.mHwSettingHighlighterInfo.setPenInfo(spenSettingUIPenInfo);
                this.mItemView.onUpdatedHighlighter(spenSettingUIPenInfo.name, spenSettingUIPenInfo.color);
            } else {
                this.mHwSettingPenInfo.setPenInfo(spenSettingUIPenInfo);
                this.mItemView.onUpdatedPen(spenSettingUIPenInfo.name, spenSettingUIPenInfo.color);
                updateAssistanceSelection();
            }
            updateItemView(spenSettingUIPenInfo);
            updateToolbarSelectionState(spenSettingUIPenInfo);
            updateSettingView(spenSettingUIPenInfo);
            this.mSettingView.onUpdateFavoriteButton(false);
        }
    }

    public void setAssistance(boolean z) {
        AbstractC8014b.m7224z("setAssistance ", TAG, z);
        if (!z) {
            this.mViewPresenter.setWritingGuideLineEnabled(false);
            this.mWritingToolManager.setAssistanceOptions(false, false);
        } else {
            SettingAssistanceData settingAssistanceData = getSettingInfoManager().getSettingAssistanceData();
            this.mViewPresenter.setWritingGuideLineEnabled(settingAssistanceData.getGuidelineEnable());
            this.mWritingToolManager.setAssistanceOptions(settingAssistanceData.getAlignLettersEnabled(), settingAssistanceData.getFixShapeLettersEnabled());
        }
    }

    public void setAssistanceOptions(boolean z, boolean z2, boolean z3) {
        if (this.mHandWritingHelpEnabled) {
            SettingAssistanceData settingAssistanceData = getSettingInfoManager().getSettingAssistanceData();
            settingAssistanceData.setGuideLineEnable(z);
            settingAssistanceData.setAlignLettersEnabled(z2);
            settingAssistanceData.setFixShapeLettersEnabled(z3);
            this.mSettingView.setAssistanceOptions(z, z2, z3);
            if (this.mItemView.getHwToolbarState().getSelectedMenu().contains(131072)) {
                this.mViewPresenter.setWritingGuideLineEnabled(z);
                this.mWritingToolManager.setAssistanceOptions(z2, z3);
            }
        }
    }

    public void setConnectionStickyMemo(boolean z) {
        this.mHwSettingRemoverInfo.setNotStickyMemoConnected(z);
        this.mSettingView.setHighlighterOnlyEnabled(z);
        this.mSettingView.updateRemoverSettingLayout();
        if (z) {
            return;
        }
        hideColorSpoid();
    }

    public void setDirectWrite(boolean z) {
        this.mItemView.setDirectWrite(z);
        if (!z) {
            this.mItemView.hideDirectWrite();
            return;
        }
        clearControl();
        if (this.mToolbarPresenter.isTextMode()) {
            this.mToolbarPresenter.hideSoftInput();
        }
        this.mItemView.showDirectWrite();
    }

    public void setEasyWritingPad(boolean z) {
        if (this.mToolbarPresenter.isEasyWritingPadEnabled() == z) {
            return;
        }
        if (z) {
            clearControl();
        }
        this.mToolbarPresenter.setEasyWritingPadEnabled(z);
        this.mItemView.updateEasyWritingPad(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    public void setEnableLaserPen(boolean z) {
        this.mViewPresenter.setLaserPen(z, z ? getLastLaserPenInfo() : null);
        String str = TAG;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("setEnableLaserPen enable = ", " / ", z);
        sbM3200j.append(getSettingInfoManager().getLaserPenData().getInfoString());
        Logger.m11003i(str, sbM3200j.toString());
    }

    public void setEnableMenus(boolean z, List<Integer> list) {
        this.mItemView.enableMenus(z, list);
    }

    public void setEnabledSettingView(int i, boolean z) {
        this.mSettingView.setEnabledSettingView(i, z);
    }

    public void setEyedropperMode(boolean z) {
        HwColorChangeObserver hwColorChangeObserver = this.mHwColorChangeObserver;
        if (hwColorChangeObserver == null) {
            return;
        }
        hwColorChangeObserver.setEyedropperMode(z);
    }

    public void setEyedropperPosition(int i, int i2) {
        this.mSettingView.setEyedropperPosition(i, i2);
    }

    public void setFavoriteInfoList(List<SpenSettingUIPenInfo> list) {
        this.mHwSettingFavoriteInfo.setFavoriteInfoList(list);
        this.mSettingMiniView.setFavoriteList(getSettingInfoManager().getFavoritePenData().getFavoriteList());
    }

    public void setFocusSelectedObjects(boolean z) {
        this.mWritingToolManager.setFocusSelectedObjects(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    public boolean setHighlighterSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (!this.mHwSettingHighlighterInfo.setSettingInfo(spenSettingUIPenInfo)) {
            return false;
        }
        this.mItemView.onUpdateToolbarSelectionState(2048);
        this.mItemView.onUpdatedHighlighter(spenSettingUIPenInfo.name, spenSettingUIPenInfo.color);
        updateItemView(spenSettingUIPenInfo);
        updateSettingView(spenSettingUIPenInfo);
        this.mSettingView.onUpdateFavoriteButton(false);
        return true;
    }

    public void setItemView(HwSettingContract.IItemView iItemView) {
        this.mItemView = iItemView;
    }

    public void setLaserPenInfo(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo, boolean z, boolean z2) {
        SpenSettingUILaserPenInfo laserPenInfo = getSettingInfoManager().getLaserPenData().getLaserPenInfo();
        boolean z3 = (laserPenInfo.color == spenSettingUILaserPenInfo.color && laserPenInfo.colorOption == spenSettingUILaserPenInfo.colorOption) ? false : true;
        if (!z2) {
            addSALogForLaserPenSetting(laserPenInfo, spenSettingUILaserPenInfo, z);
        }
        getSettingInfoManager().getLaserPenData().setLaserPenInfo(spenSettingUILaserPenInfo);
        this.mViewPresenter.setLaserPen(!z2 && this.mWritingToolManager.getToolTypeAction(2) == 18, getLastLaserPenInfo());
        if (z3) {
            if (z) {
                this.mViewPresenter.getActivity().invalidateOptionsMenu();
            }
            onUpdatedLaserPen(spenSettingUILaserPenInfo);
        }
        Logger.m11003i(TAG, "setLaserPenInfo " + getSettingInfoManager().getLaserPenData().getInfoString());
    }

    public void setLastStateHandwritingHelp(boolean z) {
        getHwToolbarState().setLastStateHandwritingHelp(z);
    }

    public void setPageCount(int i) {
        this.mPageCount = i;
    }

    public void setPageIndex(int i) {
        this.mPageIndex = i;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    public boolean setPenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (!this.mHwSettingPenInfo.setSettingInfo(spenSettingUIPenInfo)) {
            return false;
        }
        this.mItemView.onUpdateToolbarSelectionState(2);
        this.mItemView.onUpdatedPen(spenSettingUIPenInfo.name, spenSettingUIPenInfo.color);
        updateItemView(spenSettingUIPenInfo);
        updateSettingView(spenSettingUIPenInfo);
        this.mSettingView.onUpdateFavoriteButton(false);
        return true;
    }

    public void setQuickColorInfo(int i, float[] fArr) {
        this.mHwSettingQuickColorInfo.setQuickColorInfo(i, fArr);
        this.mItemView.onUpdatedQuickColor(i, this.mSettingInfoManager.getQuickColorData().getQuickColor(i));
    }

    public void setQuickSizeInfo(int i, int i2) {
        this.mHwSettingQuickSizeInfo.setQuickSizeInfo(i, i2);
        this.mItemView.onUpdatedQuickSize(i, i2);
    }

    public void setQuickToolView(HwSettingContract.IQuickToolView iQuickToolView) {
        this.mQuickToolView = iQuickToolView;
    }

    public void setRemoverSettingInfo(SpenSettingRemoverInfo spenSettingRemoverInfo) {
        this.mHwSettingRemoverInfo.setRemoverInfo(spenSettingRemoverInfo);
        this.mItemView.onUpdateToolbarSelectionState(4);
        this.mSettingView.setSelectedToolbarItem(8);
        this.mHwSettingFavoriteInfo.clearFavoriteIndex();
    }

    public void setSALogForAssistance() {
        SettingAssistanceData settingAssistanceData = getSettingInfoManager().getSettingAssistanceData();
        int i = !settingAssistanceData.getGuidelineEnable() ? 4 : 0;
        if (!settingAssistanceData.getAlignLettersEnabled()) {
            i += 2;
        }
        if (!settingAssistanceData.getFixShapeLettersEnabled()) {
            i++;
        }
        ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, ComposerSAConstants.EVENT_HANDWRITING_HELP_OPTIONS, String.valueOf((char) (i + 97)));
    }

    public void setSelectionSettingInfo(@NonNull SpenSettingSelectionInfo spenSettingSelectionInfo) {
        this.mWritingToolManager.setSelectionSettingInfo(spenSettingSelectionInfo);
        this.mSettingInfoManager.getSelectionInfoData().setSettingSelectionInfo(spenSettingSelectionInfo);
        this.mItemView.onUpdateToolbarSelectionState(8);
        this.mItemView.onUpdatedSelection(spenSettingSelectionInfo.type);
        this.mHwSettingFavoriteInfo.clearFavoriteIndex();
    }

    public void setSettingMiniView(HwSettingContract.ISettingMiniView iSettingMiniView) {
        this.mSettingMiniView = iSettingMiniView;
    }

    public void setSettingView(HwSettingContract.ISettingView iSettingView) {
        this.mSettingView = iSettingView;
    }

    public void setShapeRecognition(boolean z) {
        if (z) {
            this.mWritingToolManager.applySpenAlignmentLanguage();
            this.mWritingToolManager.setToolTypeAction(2, 12);
        } else if (this.mWritingToolManager.getToolTypeAction(2) == 12) {
            updateToolTypeAction();
        }
    }

    public void setSmartPen(int i) {
        int selectedMenuId = this.mSettingInfoManager.getSmartPenData().getSelectedMenuId();
        this.mSettingInfoManager.getSmartPenData().setSelectedMenuId(i);
        this.mItemView.onUpdatedSmartPen(selectedMenuId, i);
    }

    public void setSolveMathEnabled(boolean z) {
        this.mItemView.setSolveMathEnabled(z);
    }

    public void setStyleSettingInfo(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        this.mWritingToolManager.setChangeStyleSettingInfo(spenSettingUIChangeStyleInfo);
        if (spenSettingUIChangeStyleInfo != null) {
            this.mItemView.onUpdatedStyle(spenSettingUIChangeStyleInfo.color);
            getSettingInfoManager().getChangeStyleData().setChangeStyleInfo(spenSettingUIChangeStyleInfo);
        }
    }

    public void setToolTypeAction(int i) {
        if (i == 2) {
            this.mWritingToolManager.setToolTypeAction(2, 2);
            this.mWritingToolManager.setToolTypeAction(6, 8);
        } else if (i == 2048) {
            this.mWritingToolManager.setToolTypeAction(2, Default.isStraightType(getSettingInfoManager().getHighlighterData().getSettingHighlighterInfoSelected().name) ? 4 : 3);
            this.mWritingToolManager.setToolTypeAction(6, 8);
        }
    }

    public void setTwoPageView(boolean z) {
        this.mTwoPageView = z;
    }

    public void setZoomLock(boolean z) {
        this.mToolbarPresenter.setZoomLock(z);
    }

    public void setZoomState(boolean z) {
        this.mToolbarPresenter.setLastStateLockCanvas(z);
        this.mToolbarPresenter.setModelZoomLock(z);
    }

    public void showAddFavoritePen(int i, ViewGroup viewGroup, boolean z) {
        this.mSettingView.showAddFavoritePen(i, viewGroup, z);
    }

    public void showAiAssistMenu(View view) {
        this.mItemView.showAiAssistMenu(view);
    }

    public void showAnchorSettingView(int i, int i2, AnchorInfo anchorInfo) {
        this.mSettingView.showByAnchor(i, i2, anchorInfo);
    }

    public void showCleanUpAndCTT() {
        this.mItemView.showCleanUpAndCTT();
    }

    public void showColorPicker(int i, View view, float[] fArr) {
        this.mSettingView.showColorPicker(i, view, fArr);
    }

    public void showEyedropper(int i, View view, float[] fArr, SpenColorPickerLayoutV2.PickerColorChangedListener pickerColorChangedListener) {
        this.mSettingView.showEyedropper(i, view, fArr, pickerColorChangedListener);
    }

    public void showLanguageSettingDialog() {
        this.mToolbarPresenter.showLanguageSettingDialog();
    }

    public void showSettingView(int i, int i2, View view) {
        this.mSettingView.show(i, i2, view);
    }

    public void undo() {
        if (this.mToolbarPresenter.isUndoable()) {
            clearControl();
            this.mToolbarPresenter.undo();
        }
    }

    public void updateAnchorSettingView(int i, int i2, AnchorInfo anchorInfo) {
        this.mSettingView.updateByAnchor(i, i2, anchorInfo);
    }

    public void updateAssistanceSelection() {
        if (this.mHandWritingHelpEnabled) {
            this.mItemView.updateAssistance(canUseAssistanceOptions() && getHwToolbarState().isLastStateHandwritingHelp());
        }
    }

    public void updateChangeStyleSettingInfo() {
        this.mWritingToolManager.setToolTypeAction(2, 13);
        this.mWritingToolManager.setChangeStyleSettingInfo(getSettingInfoManager().getChangeStyleData().getChangeStyleInfo());
    }

    public void updateHighlighterSettingInfo() {
        this.mItemView.clearQuickTypeItem();
        this.mHwSettingHighlighterInfo.updateHighlighterSettingInfo();
        updateSettingView(getSettingInfoManager().getHighlighterData().getSettingHighlighterInfoSelected());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    public void updateLastPenInfo() {
        SpenSettingUIPenInfo selectedPenInfo = getSelectedPenInfo();
        if (this.mLastPenInfo == null) {
            this.mLastPenInfo = new SpenSettingUIPenInfo();
            this.mHwSettingInfoSALog.insertPenSettingFirstWritingInfo(selectedPenInfo);
        }
        if (CommonUtil.comparePenInfo(selectedPenInfo, this.mLastPenInfo)) {
            return;
        }
        Logger.m11003i(TAG, "setLastPenInfo penInfo : " + selectedPenInfo.name);
        this.mWritingToolManager.setLastPenInfo(selectedPenInfo);
        this.mLastPenInfo = selectedPenInfo;
    }

    public void updatePenSettingInfo() {
        this.mItemView.clearQuickTypeItem();
        updateAssistanceSelection();
        if (this.mViewPresenter.getComposerModel() != null && this.mViewPresenter.getComposerModel().getModeManager() != null && this.mViewPresenter.getComposerModel().getModeManager().isMode(Mode.Writing)) {
            this.mHwSettingPenInfo.updatePenSettingInfo();
        }
        updateSettingView(getSettingInfoManager().getPenInfoData().getSettingPenInfoSelected());
    }

    public void updateRemoverSettingInfo() {
        this.mHwSettingRemoverInfo.updateRemoverSettingInfo();
        this.mHwSettingFavoriteInfo.clearFavoriteIndex();
        updateAssistanceSelection();
    }

    public void updateSelectionMode() {
        this.mItemView.updateSelectionMode();
    }

    public void updateSelectionSettingInfo() {
        this.mWritingToolManager.setToolTypeAction(2, 10);
        this.mWritingToolManager.setSelectionSettingInfo(getSettingInfoManager().getSelectionInfoData().getSettingSelectionInfo());
        this.mHwSettingFavoriteInfo.clearFavoriteIndex();
    }

    public void updateSettingInfo() {
        if (this.mSettingInfoManager.getToolbarItemData().getSelectedPenTypeItem() == 2048) {
            this.mWritingToolManager.setPenSettingInfo(this.mSettingInfoManager.getHighlighterData().getSettingHighlighterInfoSelected());
        } else {
            this.mWritingToolManager.setPenSettingInfo(this.mSettingInfoManager.getPenInfoData().getSettingPenInfoSelected());
        }
        this.mWritingToolManager.setChangeStyleSettingInfo(this.mSettingInfoManager.getChangeStyleData().getChangeStyleInfo());
        this.mWritingToolManager.setSelectionSettingInfo(this.mSettingInfoManager.getSelectionInfoData().getSettingSelectionInfo());
        this.mWritingToolManager.setRemoverSettingInfo(this.mSettingInfoManager.getRemoverInfoData().getSettingRemoverInfoSelected());
        this.mItemView.onUpdateToolbarItem();
    }

    public void updateTextMode(boolean z) {
        this.mItemView.updateTextMode(z);
        if (z) {
            setEasyWritingPad(false);
        } else {
            this.mItemView.showToolTypeActionPen();
        }
    }

    public void updateToolTypeAction() {
        setToolTypeAction(getSettingInfoManager().getToolbarItemData().getSelectedPenTypeItem());
    }

    public void updateToolbarSelectionState(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (spenSettingUIPenInfo == null) {
            return;
        }
        if (isHighlighterType(spenSettingUIPenInfo)) {
            this.mSettingView.setItemHighlighterSettingInfo(spenSettingUIPenInfo);
            this.mItemView.onUpdateToolbarSelectionState(2048);
            this.mSettingView.setSelectedToolbarItem(256);
        } else {
            this.mSettingView.setItemPenSettingInfo(spenSettingUIPenInfo);
            this.mItemView.onUpdateToolbarSelectionState(2);
            this.mSettingView.setSelectedToolbarItem(4);
        }
    }

    public HwSettingPresenter(final ComposerViewContract.IPresenter iPresenter, HwToolbarPresenterImpl hwToolbarPresenterImpl, @NonNull SettingInfoManager.ComponentFactory componentFactory) {
        this.mViewPresenter = iPresenter;
        this.mToolbarPresenter = hwToolbarPresenterImpl;
        this.mComponentFactory = componentFactory;
        this.mHandWritingHelpEnabled = componentFactory.getConfig().isHandWritingHelpEnabled();
        this.mWritingToolManager = iPresenter.getWritingToolManager();
        this.mSettingInfoManager = getSettingInfoManager();
        HwSettingInfoSALog hwSettingInfoSALog = new HwSettingInfoSALog(new HwSettingInfoSALog.ContextReference() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.a
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingInfoSALog.ContextReference
            public final Context getContext() {
                return iPresenter.getActivity();
            }
        });
        this.mHwSettingInfoSALog = hwSettingInfoSALog;
        this.mHwSettingPenInfo = new HwSettingPenInfo(this.mWritingToolManager, this, hwSettingInfoSALog);
        this.mHwSettingHighlighterInfo = new HwSettingHighlighterInfo(this.mWritingToolManager, this, this.mHwSettingInfoSALog);
        this.mHwSettingRemoverInfo = new HwSettingRemoverInfo(this.mWritingToolManager, this);
        this.mHwSettingFavoriteInfo = new HwSettingFavoriteInfo(this);
        this.mHwSettingQuickColorInfo = new HwSettingQuickColorInfo(this);
        this.mHwSettingQuickSizeInfo = new HwSettingQuickSizeInfo(this);
        this.mHwColorChangeObserver = new HwColorChangeObserver(this.mWritingToolManager, this);
        String str = TAG;
        this.mItemView = new HwSettingContract.NullItemView(str);
        this.mSettingView = new HwSettingContract.NullSettingView(str);
        this.mSettingMiniView = new HwSettingContract.NullSettingMiniView(str);
        initLaserPenInfoList();
    }

    public void updatePenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        this.mToolbarPresenter.getMRemoteHwSettingPresenter().setAllTypePenSettingInfo(spenSettingUIPenInfo);
    }
}
