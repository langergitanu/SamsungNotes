package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.app.Activity;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarItemVisibilityManager {
    private final Activity mActivity;
    private final Map<Integer, HwToolbarItem> mBtnMap;
    private final HwToolbarItemManager.IHwToolbarMenu mHwToolbarMenu;
    private final HwToolbarPresenterImpl mHwToolbarPresenter;
    private int quickColorCount = -1;
    private int quickSizeCount = -1;

    public HwToolbarItemVisibilityManager(HwToolbarPresenterImpl hwToolbarPresenterImpl, HwToolbarItemManager.IHwToolbarMenu iHwToolbarMenu, Activity activity, Map<Integer, HwToolbarItem> map) {
        this.mHwToolbarPresenter = hwToolbarPresenterImpl;
        this.mHwToolbarMenu = iHwToolbarMenu;
        this.mActivity = activity;
        this.mBtnMap = Collections.unmodifiableMap(map);
    }

    private int getQuickColorUseCount() {
        if (DeviceInfo.isVSTModel()) {
            return 1;
        }
        if (this.quickColorCount == -1) {
            this.quickColorCount = getToolbarItemData().getQuickColorUseCount();
        }
        return this.quickColorCount;
    }

    private int getQuickSizeUseCount() {
        if (DeviceInfo.isVSTModel()) {
            return 1;
        }
        if (this.quickSizeCount == -1) {
            this.quickSizeCount = getToolbarItemData().getQuickSizeUseCount();
        }
        return this.quickSizeCount;
    }

    private SettingToolbarItemData getToolbarItemData() {
        return this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getToolbarItemData();
    }

    private boolean isNewPdfReaderModeWithAI() {
        return FeatureInfo.isAiFeatureEnabled() && this.mHwToolbarPresenter.isPdfReader();
    }

    private void processForSmartPen() {
        if (this.mBtnMap.containsKey(4194304) && shouldShow(4194304)) {
            ((HwToolbarSmartPen) this.mBtnMap.get(4194304)).initSelectedMenu();
            for (int i : HwToolbarConstants.SMART_PEN_ITEMS) {
                HwToolbarItem hwToolbarItem = this.mBtnMap.get(Integer.valueOf(i));
                if (hwToolbarItem != null) {
                    hwToolbarItem.getView().setVisibility(8);
                }
            }
        }
    }

    private boolean shouldShow(int i) {
        switch (i) {
            case 16:
                return getToolbarItemData().isEnabledPenStyle();
            case 32:
                return !FeatureInfo.isBeautifierFeatureEnabled() && RecognitionUtil.isSupported(this.mActivity) && getToolbarItemData().isEnabledConvertToText();
            case 64:
                return getToolbarItemData().isEnabledAutoFixShapes() && RecognitionUtil.isSupported(this.mActivity);
            case 128:
                return !FeatureInfo.isBeautifierFeatureEnabled() && RecognitionUtil.isSupported(this.mActivity) && getToolbarItemData().isEnabledStraighten();
            case 1024:
                return getToolbarItemData().isEnabledEasyWritingPad() && FeatureInfo.isEnabledEasyWritingPad(this.mActivity);
            case 4096:
                return getToolbarItemData().isEnabledLockCanvas();
            case 8192:
                return this.mHwToolbarMenu.isSupportDirectWrite() && getToolbarItemData().isEnabledSpenToText();
            case 16385:
                return 1 <= getQuickColorUseCount();
            case 16387:
                return 2 <= getQuickColorUseCount();
            case 16389:
                return 3 <= getQuickColorUseCount();
            case 16393:
                return 4 <= getQuickColorUseCount();
            case 16407:
                return 5 <= getQuickColorUseCount();
            case 32769:
                return 1 <= getQuickSizeUseCount();
            case 32771:
                return 2 <= getQuickSizeUseCount();
            case 32773:
                return 3 <= getQuickSizeUseCount();
            case 65536:
                return this.mHwToolbarPresenter.isTextButtonEnabled();
            case 131072:
                return FeatureInfo.isHandwritingHelpEnabled(this.mActivity) && RecognitionUtil.isSupported(this.mActivity) && getToolbarItemData().isEnabledAssistance();
            case 262144:
                return getToolbarItemData().isEnabledLaserPointer() && !this.mHwToolbarPresenter.isCoeditNote();
            case 524288:
                return FeatureInfo.isBeautifierFeatureEnabled() && RecognitionUtil.isSupported(this.mActivity) && getToolbarItemData().isEnabledCleanUpAndConvertText();
            case 1048576:
                return !isNewPdfReaderModeWithAI() && FeatureInfo.isAiFeatureEnabled() && this.mHwToolbarPresenter.isSupportedAiMenu() && this.mHwToolbarPresenter.canShowAiContextMenu();
            case 2097152:
                return DeviceInfo.isVSTModel() || isNewPdfReaderModeWithAI();
            case 4194304:
                HwToolbarSmartPen hwToolbarSmartPen = (HwToolbarSmartPen) this.mBtnMap.get(4194304);
                if (hwToolbarSmartPen != null) {
                    hwToolbarSmartPen.getChildItemMap().isEmpty();
                }
                return false;
            default:
                return true;
        }
    }

    public HwToolbarSmartPen getVisibleSmartPen() {
        return null;
    }

    public void initToolbarItemsVisibility() {
        Iterator<Integer> it = this.mBtnMap.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            updateVisible(shouldShow(iIntValue), iIntValue);
        }
        processForSmartPen();
    }

    public void updateVisible(boolean z, int i) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(Integer.valueOf(i));
        if (hwToolbarItem == null) {
            return;
        }
        hwToolbarItem.getView().setVisibility(z ? 0 : 8);
    }

    public void updateVisibleDirectWriteMenu() {
        boolean z = this.mHwToolbarMenu.isSupportDirectWrite() && getToolbarItemData().isEnabledSpenToText();
        if (getVisibleSmartPen() != null) {
            return;
        }
        updateVisible(z, 8192);
    }
}
