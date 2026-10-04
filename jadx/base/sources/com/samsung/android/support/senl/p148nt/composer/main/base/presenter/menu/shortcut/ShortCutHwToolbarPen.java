package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutHwToolbarPen extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutHwToolbarPen");
    private final HwToolbarPresenter mHwToolbarPresenter;
    private final ModeManager mModeManager;

    public ShortCutHwToolbarPen(ModeManager modeManager, HwToolbarPresenter hwToolbarPresenter) {
        super(Shortcut.Pen);
        this.mModeManager = modeManager;
        this.mHwToolbarPresenter = hwToolbarPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        String str = TAG;
        Logger.m10999d(str, "doAction# ");
        if (this.mModeManager.isMode(Mode.Text)) {
            this.mModeManager.setMode(Mode.Writing, str, true);
        }
        if (this.mModeManager.isMode(Mode.Writing) && !this.mHwToolbarPresenter.isSelected(2)) {
            this.mHwToolbarPresenter.onSelected(2);
        }
        return true;
    }
}
