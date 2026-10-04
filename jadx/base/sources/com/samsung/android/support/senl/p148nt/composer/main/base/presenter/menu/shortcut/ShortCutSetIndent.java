package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutSetIndent extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutSetIndent");
    private final ActionManager mActionManager;
    private final boolean mIsIndent;

    public ShortCutSetIndent(ActionManager actionManager, boolean z) {
        this.mActionManager = actionManager;
        this.mIsIndent = z;
        if (z) {
            setShortcut(Shortcut.Indent);
        } else {
            setShortcut(Shortcut.Outdent);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        String str = TAG;
        AbstractC8014b.m7215q(new StringBuilder("doAction# mIsIndent = "), this.mIsIndent, str);
        this.mActionManager.doAction(this.mIsIndent ? ActionManager.ActionType.TextIndent : ActionManager.ActionType.TextOutdent, str);
        return true;
    }
}
