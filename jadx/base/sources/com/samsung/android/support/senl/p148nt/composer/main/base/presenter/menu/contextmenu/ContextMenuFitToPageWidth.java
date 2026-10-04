package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuFitToPageWidth extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuFitToPageWidth");
    ModeManager mModeManager;
    ObjectManager mObjectManager;

    public ContextMenuFitToPageWidth(ComposerViewPresenter composerViewPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
    }

    public void addFileLog() {
        Logger.addFileLog(TAG, "CTXFTPW", 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_FIT_TO_PAGE_WIDTH;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_fit_to_page_width).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (isAvailableToFit(this.mModeManager, this.mObjectManager)) {
            return !isObjectFit(this.mObjectManager);
        }
        return false;
    }

    public void execute() {
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_FIT_TO_DEFAULT);
        this.mObjectManager.setFitWidth(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m11003i(TAG, "executeMenu# ");
        addFileLog();
        execute();
    }

    public boolean isAvailableToFit(ModeManager modeManager, ObjectManager objectManager) {
        List<SpenObjectBase> selectedObjectList;
        return modeManager.isEditMode() && (selectedObjectList = objectManager.getSelectedObjectList()) != null && selectedObjectList.size() == 1 && selectedObjectList.get(0).getType() == 3;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean isLockRelated() {
        return true;
    }

    public boolean isObjectFit(ObjectManager objectManager) {
        SpenObjectBase spenObjectBase = objectManager.getSelectedObjectList().get(0);
        boolean zIsObjectFitPageWidth = objectManager.isObjectFitPageWidth(spenObjectBase);
        Logger.m11003i(TAG, "isObjectFit# objRect:" + spenObjectBase.getRect() + ", isObjectFitPageWidth:" + zIsObjectFitPageWidth);
        return zIsObjectFitPageWidth;
    }
}
