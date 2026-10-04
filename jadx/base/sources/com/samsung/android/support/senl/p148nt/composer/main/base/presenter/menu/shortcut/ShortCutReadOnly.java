package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutReadOnly extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutReadOnly");
    private final ActionManager mActionManager;

    public ShortCutReadOnly(ActionManager actionManager) {
        setShortcut(Shortcut.ReadingMode);
        this.mActionManager = actionManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        return this.mActionManager.doAction(ActionManager.ActionType.ReadOnlyMode, TAG);
    }
}
