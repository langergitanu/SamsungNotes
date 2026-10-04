package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuDelete;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutDeleteSecond extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutDeleteSecond");
    private final ContextMenuDelete mContextMenuDelete;
    private final TextManager mTextManager;

    public ShortCutDeleteSecond(TextManager textManager, ContextMenuDelete contextMenuDelete) {
        super(Shortcut.DeleteSecond);
        this.mContextMenuDelete = contextMenuDelete;
        this.mTextManager = textManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        String str = TAG;
        Logger.m10999d(str, "doAction# ");
        if (this.mContextMenuDelete.canShow()) {
            this.mContextMenuDelete.executeMenu();
            return true;
        }
        Logger.addFileLog(str, "SCDel", 0);
        return this.mTextManager.removeSelectedText();
    }
}
