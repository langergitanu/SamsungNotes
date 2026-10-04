package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuResizeToDefault extends ContextMenuFitToPageWidth {
    private static final String TAG = Logger.createTag("ContextMenuResizeToDefault");

    public ContextMenuResizeToDefault(ComposerViewPresenter composerViewPresenter) {
        super(composerViewPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuFitToPageWidth
    public void addFileLog() {
        Logger.addFileLog(TAG, "CTXRTD", 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuFitToPageWidth, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_RESIZE_TO_DEFAULT;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_resize_to_default).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuFitToPageWidth, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (isAvailableToFit(this.mModeManager, this.mObjectManager)) {
            return isObjectFit(this.mObjectManager);
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuFitToPageWidth
    public void execute() {
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_RESIZE_TO_DEFAULT);
        this.mObjectManager.setFitWidth(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuFitToPageWidth, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean isLockRelated() {
        return true;
    }
}
