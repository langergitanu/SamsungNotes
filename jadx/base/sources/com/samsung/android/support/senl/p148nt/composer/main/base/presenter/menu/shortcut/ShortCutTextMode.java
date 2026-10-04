package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutTextMode extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutTextMode");
    private final ModeManager mModeManager;
    private final SoftInputManager mSoftInputManager;

    public ShortCutTextMode(ModeManager modeManager, SoftInputManager softInputManager) {
        super(Shortcut.TextMode);
        this.mModeManager = modeManager;
        this.mSoftInputManager = softInputManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        String str = TAG;
        Logger.m10999d(str, "doAction# ");
        if (this.mModeManager.isMode(Mode.Writing)) {
            this.mModeManager.setMode(Mode.Text, str, true);
        } else if (this.mModeManager.isMode(Mode.Text) && !this.mSoftInputManager.isInputMethodShown()) {
            this.mSoftInputManager.show(true);
        }
        return true;
    }
}
