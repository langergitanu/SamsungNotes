package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuCut;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutCut extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutCut");
    private final ContextMenuCut mContextMenuCut;

    public ShortCutCut(ContextMenuCut contextMenuCut) {
        super(Shortcut.Cut);
        this.mContextMenuCut = contextMenuCut;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        Logger.m10999d(TAG, "doAction# ");
        if (!this.mContextMenuCut.canShow()) {
            return false;
        }
        this.mContextMenuCut.executeMenu();
        return true;
    }
}
