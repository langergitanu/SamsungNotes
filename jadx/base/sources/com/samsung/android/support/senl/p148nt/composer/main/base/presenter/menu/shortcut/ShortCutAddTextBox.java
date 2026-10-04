package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutAddTextBox extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutAddTextBox");
    private final ModeManager mModeManager;
    private final OptionMenuAddPresenter mOptionMenuAddPresenter;

    public ShortCutAddTextBox(ModeManager modeManager, OptionMenuAddPresenter optionMenuAddPresenter) {
        super(Shortcut.AddTextBox);
        this.mModeManager = modeManager;
        this.mOptionMenuAddPresenter = optionMenuAddPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        Logger.m11003i(TAG, "doAction#");
        if (!this.mModeManager.isMode(Mode.Text)) {
            return false;
        }
        this.mOptionMenuAddPresenter.addTextBox();
        return true;
    }
}
