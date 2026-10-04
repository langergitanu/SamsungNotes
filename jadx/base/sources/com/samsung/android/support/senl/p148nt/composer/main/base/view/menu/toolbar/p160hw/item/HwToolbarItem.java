package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectMath;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.common.Policy;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.SmartTipPopup;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class HwToolbarItem {
    protected static final float DISABLED_ALPHA = 0.4f;
    protected static final float ENABLED_ALPHA = 1.0f;
    private static final String TAG = Logger.createTag("HwToolbarItem");
    HwSettingViewManager mHwSettingViewManager;
    protected HwToolbarItemContract mHwToolbarItemManager;
    protected View mView;
    private int mViewId;
    WritingToolManager mWritingToolManager;
    protected SmartTipPopup mSmartTipPopup = null;
    protected boolean mIsActive = true;

    public HwToolbarItem(View view, HwToolbarItemContract hwToolbarItemContract) {
        this.mView = view;
        this.mHwToolbarItemManager = hwToolbarItemContract;
        this.mWritingToolManager = hwToolbarItemContract.getWritingToolManager();
        this.mHwSettingViewManager = this.mHwToolbarItemManager.getMInAppSettingViewManager();
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOtherPopup() {
        this.mHwToolbarItemManager.getHwToolbarPresenter().hideAiSuggestionView();
        this.mHwToolbarItemManager.getHwToolbarPresenter().releaseAssistPopup();
        this.mHwToolbarItemManager.getHwToolbarPresenter().onHideSolveMathContextMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSettingPopup() {
        HwSettingViewManager hwSettingViewManager = this.mHwSettingViewManager;
        if (hwSettingViewManager != null) {
            hwSettingViewManager.hideColorSpoid();
        }
    }

    private void init() {
        View view = this.mView;
        if (view == null) {
            return;
        }
        ToolbarUtil.setBgRippleToolbar(view);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!view2.isClickable()) {
                    Logger.m11000e(HwToolbarItem.TAG, "onClick# in disable state");
                    return;
                }
                if (HwToolbarItem.this.hasInputSkipper()) {
                    UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
                    if (!UserInputSkipper.isValidEvent(tag)) {
                        return;
                    } else {
                        UserInputSkipper.setHoldingEventTime(tag);
                    }
                }
                HwToolbarItem hwToolbarItem = HwToolbarItem.this;
                if (hwToolbarItem.mHwToolbarItemManager.onPreClick(hwToolbarItem.getViewId())) {
                    Logger.m10999d(HwToolbarItem.TAG, "onClick# consumed by preClick");
                    return;
                }
                Logger.m10999d(HwToolbarItem.TAG, "onClick# " + ((Object) view2.getContentDescription()));
                HwToolbarItem.this.clearSettingPopup();
                HwToolbarItem.this.clearOtherPopup();
                HwToolbarItem.this.clearControl();
                HwToolbarItem.this.onClick();
                HwToolbarItem hwToolbarItem2 = HwToolbarItem.this;
                hwToolbarItem2.mHwToolbarItemManager.onItemClickSALogging(hwToolbarItem2.getViewId());
                HwToolbarItem.this.mHwToolbarItemManager.setMenuDirty();
            }
        });
        this.mView.setAccessibilityDelegate(new VoiceAssistAsButton());
        ViewCompat.getInstance().setTooltipText(this.mView);
    }

    public void clearControl() {
        Logger.m10999d(TAG, "clearControl#");
        this.mHwToolbarItemManager.clearContextMenu();
        this.mWritingToolManager.clearSelection();
        this.mWritingToolManager.clearControl();
    }

    public void dismissSmartTipPopup() {
        SmartTipPopup smartTipPopup = this.mSmartTipPopup;
        if (smartTipPopup == null || !smartTipPopup.isShowing()) {
            return;
        }
        Logger.m10999d(TAG, "dismissSmartTipPopup");
        this.mSmartTipPopup.dismiss();
        this.mSmartTipPopup = null;
    }

    public void doneShownSmartTip() {
    }

    public abstract void functionEnable(boolean z);

    public int[] getHorizonOnScreen(int i) {
        return ToolbarUtil.getHorizonOnScreen(this.mView, i);
    }

    public String getSmartTipString() {
        return "";
    }

    public View getView() {
        return this.mView;
    }

    public int getViewCenterPosition() {
        return ToolbarUtil.getViewCenterPosition(this.mView).x;
    }

    public int getViewId() {
        return this.mViewId;
    }

    public boolean hasInputSkipper() {
        return false;
    }

    public boolean hasToShowSmartTip() {
        return false;
    }

    public boolean isClearObject() {
        return !isSpenObjectMathSelected();
    }

    public boolean isSelected() {
        return this.mView.isSelected();
    }

    public boolean isShowingSmartTipPopup() {
        SmartTipPopup smartTipPopup = this.mSmartTipPopup;
        if (smartTipPopup == null) {
            return false;
        }
        return smartTipPopup.isShowing();
    }

    public boolean isSpenObjectMathSelected() {
        List<SpenObjectBase> selectedObjectList;
        ObjectManager objectManager = this.mHwToolbarItemManager.getHwToolbarPresenter().getObjectManager();
        if (objectManager == null || (selectedObjectList = objectManager.getSelectedObjectList()) == null) {
            return false;
        }
        for (SpenObjectBase spenObjectBase : selectedObjectList) {
            if ((spenObjectBase instanceof SpenObjectMath) && ((SpenObjectMath) spenObjectBase).isEditable()) {
                return true;
            }
        }
        return false;
    }

    public abstract void onClick();

    public void onItemSelected() {
        clearSettingPopup();
        clearOtherPopup();
        this.mHwToolbarItemManager.clearContextMenu();
        this.mWritingToolManager.clearSelection();
        this.mHwToolbarItemManager.hide();
        this.mHwToolbarItemManager.setMenuDirty();
    }

    public void release() {
        this.mIsActive = false;
        View view = this.mView;
        if (view != null) {
            view.setOnClickListener(null);
        }
        dismissSmartTipPopup();
    }

    public void setEnable(boolean z) {
        if (z == this.mView.isEnabled()) {
            return;
        }
        this.mView.setEnabled(z);
        this.mView.setAlpha(z ? 1.0f : 0.4f);
    }

    public void setPolicy(int i, Policy policy) {
        Policy.Action action = policy.getAction();
        Iterator<Integer> it = policy.getExclusiveDeactivationByEnabled().iterator();
        while (it.hasNext()) {
            if (i == it.next().intValue()) {
                setEnable(action != Policy.Action.ENABLED);
            }
        }
    }

    public boolean setSelected(boolean z) {
        HwSettingViewManager hwSettingViewManager;
        if (z == this.mView.isSelected()) {
            return false;
        }
        if (!z && (hwSettingViewManager = this.mHwSettingViewManager) != null) {
            hwSettingViewManager.hide();
        }
        this.mView.setSelected(z);
        this.mHwToolbarItemManager.updateStateSelected(this.mViewId, z);
        return true;
    }

    public void setSmartTipPopup() {
        if (this.mSmartTipPopup != null) {
            return;
        }
        try {
            SmartTipPopup smartTipPopup = new SmartTipPopup(this.mView, getSmartTipString());
            this.mSmartTipPopup = smartTipPopup;
            smartTipPopup.setOnDismissListener(new SmartTipPopup.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItem.3
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.OnDismissListener
                public void onDismissed() {
                    Logger.m10999d(HwToolbarItem.TAG, "mSmartTipPopup onDismissed");
                    ToolbarUtil.setBgRippleToolbar(HwToolbarItem.this.mView);
                }
            });
        } catch (InstantiationException e) {
            Logger.m11000e(TAG, "setSmartTipPopup " + e.getMessage());
        }
    }

    public void setViewId(int i) {
        this.mViewId = i;
    }

    public void showSmartTipPopup() {
        HwSettingViewManager hwSettingViewManager;
        View view = this.mView;
        if (view != null && view.getVisibility() == 0 && this.mIsActive) {
            if ((!SharedPreferencesCompat.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_INTRO_TOOLBAR_SHOWN, true) || ((hwSettingViewManager = this.mHwSettingViewManager) != null && hwSettingViewManager.isTabletLayout())) && hasToShowSmartTip()) {
                this.mHwToolbarItemManager.toolbarMovePosition(this.mView);
                if (this.mSmartTipPopup == null) {
                    setSmartTipPopup();
                }
                this.mView.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItem.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SmartTipPopup smartTipPopup;
                        View view2 = HwToolbarItem.this.mView;
                        if (view2 == null || view2.getVisibility() != 0) {
                            return;
                        }
                        HwToolbarItem hwToolbarItem = HwToolbarItem.this;
                        if (!hwToolbarItem.mIsActive || (smartTipPopup = hwToolbarItem.mSmartTipPopup) == null) {
                            return;
                        }
                        boolean zShow = smartTipPopup.show();
                        AbstractC8014b.m7220v("showSmartTipPopup# isShowing : ", HwToolbarItem.TAG, zShow);
                        if (zShow) {
                            HwToolbarItem.this.mView.setBackgroundResource(C9086R.drawable.comp_hw_toolbar_ic_smart_tip);
                            HwToolbarItem.this.doneShownSmartTip();
                        }
                    }
                }, 300L);
            }
        }
    }

    public void talkback() {
        View view = this.mView;
        if (view == null || !VoiceAssistantTTS.isVoiceAssistantEnabled(view.getContext()) || isSelected()) {
            return;
        }
        VoiceAssistantTTS.getInstance().sendTalkBackMessage(this.mView.getContext().getResources().getString(C9086R.string.rich_text_font_color_popup_not_selected));
    }

    public void unselect() {
        if (this.mView.isSelected()) {
            this.mView.setSelected(false);
            this.mHwToolbarItemManager.updateStateSelected(getViewId(), false);
        }
    }

    public void updateSmartTipPopup() {
        Logger.m10999d(TAG, "updateSmartTipPopup");
        dismissSmartTipPopup();
        setSmartTipPopup();
        showSmartTipPopup();
    }
}
