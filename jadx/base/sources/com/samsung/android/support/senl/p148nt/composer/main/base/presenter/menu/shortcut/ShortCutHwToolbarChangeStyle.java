package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutHwToolbarChangeStyle extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutHwToolbarChangeStyle");
    private final HwToolbarPresenter mHwToolbarPresenter;
    private final ModeManager mModeManager;

    public ShortCutHwToolbarChangeStyle(ModeManager modeManager, HwToolbarPresenter hwToolbarPresenter) {
        super(Shortcut.ChangeStyle);
        this.mModeManager = modeManager;
        this.mHwToolbarPresenter = hwToolbarPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        Logger.m10999d(TAG, "doAction# ");
        if (this.mModeManager.isMode(Mode.Writing) && !this.mHwToolbarPresenter.isSelected(16)) {
            this.mHwToolbarPresenter.onSelected(16);
        }
        return true;
    }
}
