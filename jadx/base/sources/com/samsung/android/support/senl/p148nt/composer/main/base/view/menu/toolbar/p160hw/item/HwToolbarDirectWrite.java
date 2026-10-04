package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.IHwToolbarSmartPenGroup;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarDirectWrite extends HwToolbarItem implements IHwToolbarSmartPenGroup.Child {
    private static final String TAG = Logger.createTag("HwToolbarDirectWrite");
    private IHwToolbarSmartPenGroup.Parent mParent;

    public HwToolbarDirectWrite(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void clearControl() {
        if (this.mHwToolbarItemManager.isTextMode()) {
            return;
        }
        this.mHwToolbarItemManager.clearContextMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
        this.mHwToolbarItemManager.getSettingInstance().setDirectWrite(z);
        IHwToolbarSmartPenGroup.Parent parent = this.mParent;
        if (parent != null) {
            parent.notifyFunctionEnabled(getViewId(), z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        Logger.m10999d(TAG, "onClick# ");
        this.mHwSettingViewManager.hide();
        functionEnable(!this.mView.isSelected());
        if (this.mView.isSelected()) {
            if (!this.mHwToolbarItemManager.isTextMode()) {
                this.mHwToolbarItemManager.updateLastPenTypeSelectionState();
            }
            setSelected(false);
        } else {
            this.mHwToolbarItemManager.onSelected(getViewId(), !this.mHwToolbarItemManager.isTextMode());
        }
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_WRITING_S_PEN_TO_TEXT, this.mView.isSelected() ? "1" : "0");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void setEnable(boolean z) {
        super.setEnable(z);
        IHwToolbarSmartPenGroup.Parent parent = this.mParent;
        if (parent != null) {
            parent.notifyEnabled(getViewId(), z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.IHwToolbarSmartPenGroup.Child
    public void setParent(IHwToolbarSmartPenGroup.Parent parent) {
        this.mParent = parent;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        if (!super.setSelected(z)) {
            return false;
        }
        IHwToolbarSmartPenGroup.Parent parent = this.mParent;
        if (parent == null) {
            return true;
        }
        parent.notifySelected(getViewId(), z);
        return true;
    }

    public void updateDirectWrite() {
        if (setSelected(this.mHwToolbarItemManager.isDirectWriteUsing())) {
            functionEnable(this.mView.isSelected());
        }
    }
}
