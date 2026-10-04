package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.IHwToolbarSmartPenGroup;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarAssistance extends HwToolbarItem implements IHwToolbarSmartPenGroup.Child {
    private static final String TAG = Logger.createTag("HwToolbarAssistance");
    private boolean disabledByMathSolver;
    private IHwToolbarSmartPenGroup.Parent mParent;

    public HwToolbarAssistance(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
        this.disabledByMathSolver = false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
        AbstractC8014b.m7224z("functionEnabled# ", TAG, z);
        this.mHwToolbarItemManager.getSettingInstance().setAssistance(z);
        IHwToolbarSmartPenGroup.Parent parent = this.mParent;
        if (parent != null) {
            parent.notifyFunctionEnabled(getViewId(), z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        Logger.m10999d(TAG, "onClick# ");
        if (this.disabledByMathSolver) {
            ToastHandler.show(this.mView.getContext(), C9086R.string.solve_math_toast_turn_off_math_solver, 0);
            return;
        }
        if (this.mView.isSelected()) {
            if (this.mHwSettingViewManager.isShownSettingViews(16384)) {
                this.mHwSettingViewManager.hide();
            }
            setSelected(false);
            this.mHwToolbarItemManager.getSettingInstance().setLastStateHandwritingHelp(false);
            return;
        }
        this.mHwSettingViewManager.hide();
        this.mHwToolbarItemManager.getSettingInstance().setLastStateHandwritingHelp(true);
        if (!this.mHwToolbarItemManager.isSelected(2)) {
            this.mHwToolbarItemManager.onSelected(2);
        }
        this.mHwSettingViewManager.show(getViewId(), 16384);
        this.mHwToolbarItemManager.onSelected(getViewId());
    }

    public void runAction() {
        this.mHwToolbarItemManager.getSettingInstance().setLastStateHandwritingHelp(true);
        if (!this.mHwToolbarItemManager.isSelected(2)) {
            this.mHwToolbarItemManager.onSelected(2);
        }
        this.mHwToolbarItemManager.onSelected(getViewId());
    }

    public void setDisabledByMathSolver(boolean z) {
        this.disabledByMathSolver = z;
        this.mView.setAlpha(z ? 0.4f : 1.0f);
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
        if (z) {
            this.mHwToolbarItemManager.getSettingInstance().setSALogForAssistance();
        }
        functionEnable(z);
        IHwToolbarSmartPenGroup.Parent parent = this.mParent;
        if (parent == null) {
            return true;
        }
        parent.notifySelected(getViewId(), z);
        return true;
    }
}
