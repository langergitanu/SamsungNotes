package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting;

import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingUILaserPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.SettingInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteQuickColorInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarConstants;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RemoteHwSettingPresenter extends HwSettingPresenter implements RemoteFunctionContract.TargetClassContract {
    private static final String TAG = Logger.createTag("RemoteHwSettingPresenter");
    private String mBeautifierLanguage;
    private final String mClassName;
    private boolean mIsBeautifierSupported;
    private boolean mIsSinglePageMode;
    private int mQuickColorUseCount;
    private int mQuickSizeUseCount;
    private final RemoteFunctionContract.PresenterContract mRemoteFunctionPresenter;
    private HwSettingPresenter mSuperClass;

    public RemoteHwSettingPresenter(HwSettingPresenter hwSettingPresenter, RemoteFunctionContract.PresenterContract presenterContract, SettingInfoManager.ComponentFactory componentFactory) {
        super(componentFactory);
        this.mClassName = "RemoteHwSettingPresenter";
        this.mQuickColorUseCount = HwToolbarConstants.QUICK_COLOR.values().length;
        this.mQuickSizeUseCount = HwToolbarConstants.QUICK_SIZE.values().length;
        for (Field field : hwSettingPresenter.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                field.set(this, field.get(hwSettingPresenter));
            } catch (IllegalAccessException e) {
                Logger.m11000e(TAG, "construct error " + e.getMessage());
            }
        }
        this.mRemoteFunctionPresenter = presenterContract;
        this.mSuperClass = hwSettingPresenter;
    }

    @RemoteConstant.RemoteSenderType(4)
    private void syncInitToolbarMenuInfo() {
        boolean zIsEnableUndoRedoMenu = this.mToolbarPresenter.isEnableUndoRedoMenu();
        boolean z = false;
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "onRedoable", Boolean.valueOf(zIsEnableUndoRedoMenu && this.mToolbarPresenter.isRedoable()));
        RemoteFunctionContract.PresenterContract presenterContract = this.mRemoteFunctionPresenter;
        String str = this.mClassName;
        if (zIsEnableUndoRedoMenu && this.mToolbarPresenter.isUndoable()) {
            z = true;
        }
        presenterContract.remoteFunctionCall(str, "onUndoable", Boolean.valueOf(z));
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "setSinglePageMode", Boolean.valueOf(this.mWritingToolManager.isSinglePageMode()));
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "setQuickColorUseCount", Integer.valueOf(this.mSettingInfoManager.getToolbarItemData().isEnableQuickColor() ? this.mSettingInfoManager.getToolbarItemData().getQuickColorUseCount() : 3));
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "setQuickSizeUseCount", Integer.valueOf(this.mSettingInfoManager.getToolbarItemData().isEnableQuickSize() ? this.mSettingInfoManager.getToolbarItemData().getQuickSizeUseCount() : 1));
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "setSinglePageMode", Boolean.valueOf(this.mWritingToolManager.isSinglePageMode()));
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "onBeautifierLanguage", getBeautifierLanguage(), Boolean.valueOf(isBeautifierSupportedLanguage()));
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "setLastStateHandwritingHelp", Boolean.valueOf(this.mItemView.getHwToolbarState().isLastStateHandwritingHelp()));
    }

    @RemoteConstant.RemoteSenderType(4)
    private void syncLaserPen() {
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "onUpdatedLaserPen", getSettingInfoManager().getLaserPenData().getLaserPenInfo());
    }

    @RemoteConstant.RemoteSenderType(4)
    private void syncMenuState() {
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "setConnectionStickyMemo", Boolean.valueOf(isNotStickyMemoConnected()));
        List<Integer> disabledMenus = this.mItemView.getDisabledMenus();
        if (disabledMenus.isEmpty()) {
            return;
        }
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "setEnableMenus", Boolean.FALSE, disabledMenus);
    }

    @RemoteConstant.RemoteSenderType(4)
    private void syncPageState() {
        this.mPageIndex = this.mViewPresenter.getCurrentPageIndex();
        this.mPageCount = this.mViewPresenter.getWritingToolManager().getPageCount();
        this.mTwoPageView = this.mViewPresenter.getComposerModel().getTextOnlyModeState().getLastPageColumn() == 2;
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setPageIndex", Integer.valueOf(this.mPageIndex));
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setPageCount", Integer.valueOf(this.mPageCount));
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setTwoPageView", Boolean.valueOf(this.mTwoPageView));
    }

    @RemoteConstant.RemoteSenderType(4)
    private void syncSolveMathEnabled() {
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "setSolveMathEnabled", Boolean.valueOf(this.mItemView.isSolveMathEnabled()));
    }

    @RemoteConstant.RemoteSenderType(4)
    private void syncZoomLock() {
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "onZoomLock", Boolean.valueOf(this.mToolbarPresenter.isZoomLocked()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("addFavoritePenInfo")
    public void addFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "addFavoritePenInfo", spenSettingUIPenInfo);
        super.addFavoritePenInfo(spenSettingUIPenInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("addRecentColor")
    public void addRecentColor(int i) {
        super.addRecentColor(i);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "addRecentColor", Integer.valueOf(i));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteReceiverFunctionName("receiveAddedSelectMenu")
    @RemoteConstant.RemoteFunctionName("addSelectedMenu")
    public void addSelectedMenu(int i) {
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "addSelectedMenu", Integer.valueOf(i));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteReceiverFunctionName("receiveApplyQuickColor")
    @RemoteConstant.RemoteFunctionName("applyQuickColor")
    public void applyQuickColor(float[] fArr) {
        super.applyQuickColor(fArr);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "applyQuickColor", new RemoteQuickColorInfo(-1, fArr));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("applyQuickSize")
    public void applyQuickSize(int i) {
        super.applyQuickSize(i);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "applyQuickSize", Integer.valueOf(i));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("applyToolbarEnabledState")
    public void applyToolbarEnabledState(boolean z) {
        super.applyToolbarEnabledState(z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "applyToolbarEnabledState", Boolean.valueOf(z));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("changeFavoritePenInfo")
    public void changeFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo, SpenSettingUIPenInfo spenSettingUIPenInfo2) {
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "changeFavoritePenInfo", spenSettingUIPenInfo, spenSettingUIPenInfo2);
        super.changeFavoritePenInfo(spenSettingUIPenInfo, spenSettingUIPenInfo2);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("changeTextMode")
    public void changeTextMode() {
        super.changeTextMode();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "changeTextMode", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("changeWritingMode")
    public void changeWritingMode() {
        super.changeWritingMode();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "changeWritingMode", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("executeConvertToText")
    public void executeConvertToText() {
        if (this.mRemoteFunctionPresenter.getRemoteType() == 4) {
            super.executeConvertToText();
            this.mSettingView.hide();
            this.mItemView.hideDirectWrite();
        }
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "executeConvertToText", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("executeEraseAllOnAllPages")
    public void executeEraseAllOnAllPages() {
        super.executeEraseAllOnAllPages();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "executeEraseAllOnAllPages", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("executeEraseAllOnCurrentPage")
    public void executeEraseAllOnCurrentPage(int i) {
        super.executeEraseAllOnCurrentPage(i);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "executeEraseAllOnCurrentPage", Integer.valueOf(i));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    public String getBeautifierLanguage() {
        return this.mRemoteFunctionPresenter.getRemoteType() == 2 ? this.mBeautifierLanguage : super.getBeautifierLanguage();
    }

    public int getQuickColorUseCount() {
        return this.mQuickColorUseCount;
    }

    public int getQuickSizeUseCount() {
        return this.mQuickSizeUseCount;
    }

    public HwSettingPresenter getSuperClass() {
        return this.mSuperClass;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.TargetClassContract
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteReceiverFunctionName("toolbarSynchronization")
    @RemoteConstant.RemoteFunctionName("init")
    public void init() {
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "init", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    public boolean isBeautifierSupportedLanguage() {
        return this.mRemoteFunctionPresenter.getRemoteType() == 2 ? this.mIsBeautifierSupported : super.isBeautifierSupportedLanguage();
    }

    public boolean isSinglePageMode() {
        return this.mIsSinglePageMode;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("notifyRecentColorChanged")
    public void notifyRecentColorChanged() {
        super.notifyRecentColorChanged();
        if (this.mRemoteFunctionPresenter.getRemoteType() != 4) {
            if (this.mRemoteFunctionPresenter.getRemoteType() == 2) {
                this.mSettingView.notifyChangedRecentColor(getSettingInfoManager().getColorRecentData().getRecentColors());
            }
        } else {
            RemoteFunctionContract.PresenterContract presenterContract = this.mRemoteFunctionPresenter;
            String str = this.mClassName;
            SettingInfoManager settingInfoManager = this.mSettingInfoManager;
            presenterContract.remoteFunctionCall(str, "receiveReplaceSettingInfo", settingInfoManager.getSettingInfoMessage(settingInfoManager.getColorRecentData()));
            this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "notifyRecentColorChanged", new Object[0]);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("onBeautifierLanguage")
    public void onBeautifierLanguage(String str, boolean z) {
        this.mBeautifierLanguage = str;
        this.mIsBeautifierSupported = z;
        super.onBeautifierLanguage(str, z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "onBeautifierLanguage", str, Boolean.valueOf(z));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("onObjectChanged")
    public void onObjectChanged() {
        super.onObjectChanged();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "onObjectChanged", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("onPaletteChanged")
    public void onPaletteChanged(List<Integer> list) {
        super.onPaletteChanged(list);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "onPaletteChanged", list);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("onRedoable")
    public void onRedoable(boolean z) {
        super.onRedoable(z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "onRedoable", Boolean.valueOf(z));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("onUndoable")
    public void onUndoable(boolean z) {
        super.onUndoable(z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "onUndoable", Boolean.valueOf(z));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("onUpdatedLaserPen")
    public void onUpdatedLaserPen(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
        super.onUpdatedLaserPen(spenSettingUILaserPenInfo);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "onUpdatedLaserPen", spenSettingUILaserPenInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("onZoomLock")
    public void onZoomLock(boolean z) {
        super.onZoomLock(z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "onZoomLock", Boolean.valueOf(z));
    }

    @RemoteConstant.RemoteFunctionName("receiveAddedSelectMenu")
    public void receiveAddedSelectMenu(int i) {
        this.mItemView.onUpdateToolbarSelectionState(i);
        this.mItemView.updateStateSelected(i, true);
        this.mItemView.setSelectMenu(i, true);
        cancelConvertToText();
        hideColorSpoid();
    }

    @RemoteConstant.RemoteFunctionName("receiveApplyQuickColor")
    public void receiveApplyQuickColor(RemoteQuickColorInfo remoteQuickColorInfo) {
        super.applyQuickColor(remoteQuickColorInfo.getHsvColor());
    }

    @RemoteConstant.RemoteFunctionName("receiveQuickColorInfo")
    public void receiveQuickColorInfo(RemoteQuickColorInfo remoteQuickColorInfo) {
        super.setQuickColorInfo(remoteQuickColorInfo.getIndex(), remoteQuickColorInfo.getHsvColor());
        this.mSettingView.setQuickColorSettingInfo(remoteQuickColorInfo.getHsvColor());
    }

    @RemoteConstant.RemoteFunctionName("receiveRemovedSelectMenu")
    public void receiveRemovedSelectMenu(int i) {
        this.mItemView.updateStateSelected(i, false);
        this.mItemView.setSelectMenu(i, false);
    }

    @RemoteConstant.RemoteFunctionName("receiveReplaceSettingInfo")
    public void receiveReplaceSettingInfo(String str) {
        this.mSettingInfoManager.replaceSettingInfo(str);
    }

    @RemoteConstant.RemoteFunctionName("receiveSyncSettingInfo")
    public void receiveSyncSettingInfo(String str) {
        if (this.mRemoteFunctionPresenter.isDynamicWeightAndFixedOpacityFeatureDisabled()) {
            this.mSettingView.setIsSupportFixedOpacity(false);
            this.mSettingView.setIsSupportDynamicPenWeightByTextSize(false);
        }
        this.mSettingInfoManager.setSaveOperation(false);
        this.mSettingInfoManager.replaceSettingInfo(str);
        updateSettingInfo();
        this.mItemView.onUpdateToolbarQuickItem();
    }

    @RemoteConstant.RemoteFunctionName("receiveSyncSupportedToolbarAddons")
    public void receiveSyncSupportedToolbarAddons(List<Integer> list) {
        String str = TAG;
        Logger.m11003i(str, "receiveSyncSupportedToolbarAddons# supportedMenuIdList=" + list);
        if (this.mRemoteFunctionPresenter.isAIAssistDisabled()) {
            Logger.m11003i(str, "receiveSyncSupportedToolbarAddons# Remove AI Assist button");
            list.remove((Object) 1048576);
        }
        this.mItemView.updateVisible(true, list);
    }

    @RemoteConstant.RemoteFunctionName("receiveSyncToolbarSelectedMenu")
    public void receiveSyncToolbarSelectedMenu(List<Integer> list) {
        this.mItemView.getHwToolbarState().setSelectMenu(list);
        HwSettingContract.IItemView iItemView = this.mItemView;
        iItemView.restoreHwToolbarState(iItemView.getHwToolbarState());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("redo")
    public void redo() {
        super.redo();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "redo", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("releaseAssistPopup")
    public void releaseAssistPopup() {
        if (this.mRemoteFunctionPresenter.getRemoteType() == 2) {
            this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "releaseAssistPopup", new Object[0]);
        } else if (this.mRemoteFunctionPresenter.getRemoteType() == 4) {
            super.releaseAssistPopup();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteFunctionName("reloadHwToolbarState")
    public void reloadHwToolbarState() {
        HwSettingContract.IItemView iItemView = this.mItemView;
        boolean zCorrectSelectionMenu = iItemView.correctSelectionMenu(iItemView.getHwToolbarState());
        super.reloadHwToolbarState();
        if (!zCorrectSelectionMenu || this.mToolbarPresenter.isTextMode()) {
            return;
        }
        Logger.m11003i(TAG, "selection menu corrected");
        this.mItemView.updateLastPenTypeSelectionState();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("removeFavoritePenInfo")
    public void removeFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "removeFavoritePenInfo", spenSettingUIPenInfo);
        super.removeFavoritePenInfo(spenSettingUIPenInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteReceiverFunctionName("receiveRemovedSelectMenu")
    @RemoteConstant.RemoteFunctionName("removeSelectedMenu")
    public void removeSelectedMenu(int i) {
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "removeSelectedMenu", Integer.valueOf(i));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("setAlignment")
    public void setAlignment(boolean z) {
        if (this.mRemoteFunctionPresenter.getRemoteType() == 4) {
            super.setAlignment(z);
            if (z) {
                this.mSettingView.hide();
                this.mItemView.hideDirectWrite();
            }
        }
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setAlignment", Boolean.valueOf(z));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setAlignmentOptions")
    public void setAlignmentOptions(boolean z, boolean z2, boolean z3, boolean z4) {
        super.setAlignmentOptions(z, z2, z3, z4);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setAlignmentOptions", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setAllTypePenSettingInfo")
    public void setAllTypePenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        super.setAllTypePenSettingInfo(spenSettingUIPenInfo);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setAllTypePenSettingInfo", spenSettingUIPenInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setAssistance")
    public void setAssistance(boolean z) {
        super.setAssistance(z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setAssistance", Boolean.valueOf(z));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setAssistanceOptions")
    public void setAssistanceOptions(boolean z, boolean z2, boolean z3) {
        super.setAssistanceOptions(z, z2, z3);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setAssistanceOptions", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("setConnectionStickyMemo")
    public void setConnectionStickyMemo(boolean z) {
        super.setConnectionStickyMemo(z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setConnectionStickyMemo", Boolean.valueOf(z));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("setDirectWrite")
    public void setDirectWrite(boolean z) {
        boolean z2 = this.mItemView.isDirectWriteUsing() != z;
        super.setDirectWrite(z);
        if (z2) {
            this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setDirectWrite", Boolean.valueOf(z));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("setEasyWritingPad")
    public void setEasyWritingPad(boolean z) {
        super.setEasyWritingPad(z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setEasyWritingPad", Boolean.valueOf(z));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("setEnableLaserPen")
    public void setEnableLaserPen(boolean z) {
        super.setEnableLaserPen(z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setEnableLaserPen", Boolean.valueOf(z));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("setEnableMenus")
    public void setEnableMenus(boolean z, List<Integer> list) {
        super.setEnableMenus(z, list);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setEnableMenus", Boolean.valueOf(z), list);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setFavoriteInfoList")
    public void setFavoriteInfoList(List<SpenSettingUIPenInfo> list) {
        super.setFavoriteInfoList(list);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setFavoriteInfoList", list);
        if (this.mRemoteFunctionPresenter.isRemotedFunctionCall()) {
            this.mSettingView.onUpdateFavoriteButton(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setHighlighterSettingInfo")
    public boolean setHighlighterSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (!super.setHighlighterSettingInfo(spenSettingUIPenInfo)) {
            return false;
        }
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setHighlighterSettingInfo", spenSettingUIPenInfo);
        if (!this.mRemoteFunctionPresenter.isRemotedFunctionCall()) {
            return true;
        }
        this.mSettingView.setItemHighlighterSettingInfo(spenSettingUIPenInfo);
        this.mSettingView.onUpdateFavoriteButton(false);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setLaserPenInfo")
    public void setLaserPenInfo(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo, boolean z, boolean z2) {
        super.setLaserPenInfo(spenSettingUILaserPenInfo, z, z2);
        RemoteFunctionContract.PresenterContract presenterContract = this.mRemoteFunctionPresenter;
        String str = this.mClassName;
        Boolean bool = Boolean.FALSE;
        presenterContract.remoteFunctionSync(str, "setLaserPenInfo", spenSettingUILaserPenInfo, bool, bool);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setLastStateHandwritingHelp")
    public void setLastStateHandwritingHelp(boolean z) {
        super.setLastStateHandwritingHelp(z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setLastStateHandwritingHelp", Boolean.valueOf(z));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("setPageCount")
    public void setPageCount(int i) {
        boolean z = this.mPageCount != i;
        super.setPageCount(i);
        if (z) {
            if (this.mRemoteFunctionPresenter.getRemoteType() == 2) {
                this.mSettingView.updateRemoverSettingLayout();
            } else {
                this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setPageCount", Integer.valueOf(i));
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("setPageIndex")
    public void setPageIndex(int i) {
        boolean z = this.mPageIndex != i;
        super.setPageIndex(i);
        if (z) {
            if (this.mRemoteFunctionPresenter.getRemoteType() == 2) {
                this.mSettingView.updateRemoverSettingLayout();
            } else {
                this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setPageIndex", Integer.valueOf(i));
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setPenSettingInfo")
    public boolean setPenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (!super.setPenSettingInfo(spenSettingUIPenInfo)) {
            return false;
        }
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setPenSettingInfo", spenSettingUIPenInfo);
        if (!this.mRemoteFunctionPresenter.isRemotedFunctionCall()) {
            return true;
        }
        this.mSettingView.setItemPenSettingInfo(spenSettingUIPenInfo);
        this.mSettingView.onUpdateFavoriteButton(false);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteReceiverFunctionName("receiveQuickColorInfo")
    @RemoteConstant.RemoteFunctionName("setQuickColorInfo")
    public void setQuickColorInfo(int i, float[] fArr) {
        super.setQuickColorInfo(i, fArr);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setQuickColorInfo", new RemoteQuickColorInfo(i, fArr));
    }

    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("setQuickColorUseCount")
    public void setQuickColorUseCount(int i) {
        this.mQuickColorUseCount = i;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setQuickSizeInfo")
    public void setQuickSizeInfo(int i, int i2) {
        super.setQuickSizeInfo(i, i2);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setQuickSizeInfo", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.mRemoteFunctionPresenter.isRemotedFunctionCall()) {
            this.mSettingView.setQuickSizeInfo(i2);
        }
    }

    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("setQuickSizeUseCount")
    public void setQuickSizeUseCount(int i) {
        this.mQuickSizeUseCount = i;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setRemoverSettingInfo")
    public void setRemoverSettingInfo(SpenSettingRemoverInfo spenSettingRemoverInfo) {
        super.setRemoverSettingInfo(spenSettingRemoverInfo);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setRemoverSettingInfo", spenSettingRemoverInfo);
        if (this.mRemoteFunctionPresenter.isRemotedFunctionCall()) {
            this.mSettingView.setRemoverSettingInfo(spenSettingRemoverInfo);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setSelectionSettingInfo")
    public void setSelectionSettingInfo(@NonNull SpenSettingSelectionInfo spenSettingSelectionInfo) {
        super.setSelectionSettingInfo(spenSettingSelectionInfo);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setSelectionSettingInfo", spenSettingSelectionInfo);
        if (this.mRemoteFunctionPresenter.isRemotedFunctionCall()) {
            this.mSettingView.setSelectionSettingInfo(spenSettingSelectionInfo);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("setShapeRecognition")
    public void setShapeRecognition(boolean z) {
        super.setShapeRecognition(z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setShapeRecognition", Boolean.valueOf(z));
    }

    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("setSinglePageMode")
    public void setSinglePageMode(boolean z) {
        AbstractC8014b.m7224z("setSinglePageMode ", TAG, z);
        this.mIsSinglePageMode = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("setSolveMathEnabled")
    public void setSolveMathEnabled(boolean z) {
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setSolveMathEnabled", Boolean.valueOf(z));
        super.setSolveMathEnabled(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setStyleSettingInfo")
    public void setStyleSettingInfo(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        super.setStyleSettingInfo(spenSettingUIChangeStyleInfo);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setStyleSettingInfo", spenSettingUIChangeStyleInfo);
        if (this.mRemoteFunctionPresenter.isRemotedFunctionCall()) {
            this.mSettingView.setItemChangeStyleInfo(spenSettingUIChangeStyleInfo);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("setTwoPageView")
    public void setTwoPageView(boolean z) {
        boolean z2 = this.mTwoPageView != z;
        super.setTwoPageView(z);
        if (z2) {
            if (this.mRemoteFunctionPresenter.getRemoteType() == 2) {
                this.mSettingView.updateRemoverSettingLayout();
            } else {
                this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setTwoPageView", Boolean.valueOf(z));
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("setZoomLock")
    public void setZoomLock(boolean z) {
        super.setZoomLock(z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setZoomLock", Boolean.valueOf(z));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("setZoomState")
    public void setZoomState(boolean z) {
        super.setZoomState(z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setZoomState", Boolean.valueOf(z));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    public void showAiAssistMenu(View view) {
        super.showAiAssistMenu(view);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "showAiAssistMenu", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("showCleanUpAndCTT")
    public void showCleanUpAndCTT() {
        super.showCleanUpAndCTT();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "showCleanUpAndCTT", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("showLanguageSettingDialog")
    public void showLanguageSettingDialog() {
        super.showLanguageSettingDialog();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "showLanguageSettingDialog", new Object[0]);
    }

    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteReceiverFunctionName("receiveSyncSettingInfo")
    @RemoteConstant.RemoteFunctionName("syncSettingInfo")
    public void syncSettingInfo() {
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "syncSettingInfo", this.mSettingInfoManager.getSettingInfoMessage(new String[0]));
    }

    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("syncSupportedToolbarAddons")
    public void syncSupportedToolbarAddons() {
        List<Integer> collaborationViewSupportedMenuIdList = this.mToolbarPresenter.getCollaborationViewSupportedMenuIdList();
        if (collaborationViewSupportedMenuIdList == null || collaborationViewSupportedMenuIdList.isEmpty()) {
            Logger.m11003i(TAG, "supportedMenuIdList is empty.");
        } else {
            this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "receiveSyncSupportedToolbarAddons", collaborationViewSupportedMenuIdList);
        }
    }

    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteReceiverFunctionName("receiveSyncToolbarSelectedMenu")
    @RemoteConstant.RemoteFunctionName("syncToolbarSelectedMenu")
    public void syncToolbarSelectedMenu() {
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "syncToolbarSelectedMenu", this.mItemView.getHwToolbarState().getSelectedMenu());
    }

    @RemoteConstant.RemoteFunctionName("toolbarSynchronization")
    public void toolbarSynchronization() {
        syncInitToolbarMenuInfo();
        syncSupportedToolbarAddons();
        syncSettingInfo();
        syncToolbarSelectedMenu();
        syncZoomLock();
        syncLaserPen();
        syncSolveMathEnabled();
        syncMenuState();
        syncPageState();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("undo")
    public void undo() {
        super.undo();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "undo", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("updateChangeStyleSettingInfo")
    public void updateChangeStyleSettingInfo() {
        super.updateChangeStyleSettingInfo();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "updateChangeStyleSettingInfo", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("updateHighlighterSettingInfo")
    public void updateHighlighterSettingInfo() {
        super.updateHighlighterSettingInfo();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "updateHighlighterSettingInfo", new Object[0]);
        if (this.mRemoteFunctionPresenter.isRemotedFunctionCall()) {
            this.mSettingView.setSelectedToolbarItem(256);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("updatePenSettingInfo")
    public void updatePenSettingInfo() {
        Logger.m11003i(TAG, "updatePenSettingInfo");
        super.updatePenSettingInfo();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "updatePenSettingInfo", new Object[0]);
        if (this.mRemoteFunctionPresenter.isRemotedFunctionCall()) {
            this.mSettingView.setSelectedToolbarItem(4);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("updateRemoverSettingInfo")
    public void updateRemoverSettingInfo() {
        super.updateRemoverSettingInfo();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "updateRemoverSettingInfo", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("updateSelectionSettingInfo")
    public void updateSelectionSettingInfo() {
        super.updateSelectionSettingInfo();
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "updateSelectionSettingInfo", new Object[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("updateTextMode")
    public void updateTextMode(boolean z) {
        this.mItemView.updateTextMode(z);
        if (z) {
            setEasyWritingPad(false);
        }
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "updateTextMode", Boolean.valueOf(z));
    }

    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("showAiAssistMenu")
    public void showAiAssistMenu() {
        this.mItemView.executeAiAssist();
    }

    public RemoteHwSettingPresenter(ComposerViewContract.IPresenter iPresenter, HwToolbarPresenterImpl hwToolbarPresenterImpl, RemoteFunctionContract.PresenterContract presenterContract, SettingInfoManager.ComponentFactory componentFactory) {
        super(iPresenter, hwToolbarPresenterImpl, componentFactory);
        this.mClassName = "RemoteHwSettingPresenter";
        this.mQuickColorUseCount = HwToolbarConstants.QUICK_COLOR.values().length;
        this.mQuickSizeUseCount = HwToolbarConstants.QUICK_SIZE.values().length;
        this.mRemoteFunctionPresenter = presenterContract;
    }
}
