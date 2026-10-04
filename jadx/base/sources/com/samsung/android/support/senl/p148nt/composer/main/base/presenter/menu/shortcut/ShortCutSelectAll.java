package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSelectAll;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutSelectAll extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutSelectAll");
    private final ContextMenuSelectAll mContextMenuSelectAll;

    public ShortCutSelectAll(ContextMenuSelectAll contextMenuSelectAll) {
        super(Shortcut.SelectAll);
        this.mContextMenuSelectAll = contextMenuSelectAll;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        Logger.m10999d(TAG, "doAction# ");
        if (!this.mContextMenuSelectAll.canShow()) {
            return false;
        }
        this.mContextMenuSelectAll.executeMenu();
        return true;
    }
}
