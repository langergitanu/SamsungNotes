package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuSendToBack extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuSendToBack");
    private ModeManager mModeManager;
    private ObjectManager mObjectManager;

    public ContextMenuSendToBack(ComposerViewPresenter composerViewPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
    }

    public static boolean isAvailableToChangeZOrder(ObjectManager objectManager, ModeManager modeManager) {
        return (!modeManager.isEditMode() || objectManager.getSelectedObjectList() == null || objectManager.getSelectedObjectList().isEmpty() || objectManager.isFocusedTextBox() || objectManager.isSelectedObjectOfObjectSpan() || objectManager.isObjectPlotSelected()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_SEND_TO_BACK;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_send_to_back).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        return isAvailableToChangeZOrder(this.mObjectManager, this.mModeManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        String str = TAG;
        Logger.m10999d(str, "executeBringToFrontMenu#" + this.mObjectManager.getSelectedObjectList().size());
        Logger.addFileLog(str, "CTXSTB", 0);
        this.mObjectManager.getSelectedObjectManager().sendToBack();
        ComposerSA.insertLog("411", ComposerSAConstants.EVENT_WRITING_CTX_MENU_MOVE_BACKWARD);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean isLockRelated() {
        return true;
    }
}
