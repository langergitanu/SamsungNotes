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
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuObjectLock extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuObjectLock");
    ModeManager mModeManager;
    ObjectManager mObjectManager;

    public ContextMenuObjectLock(ComposerViewPresenter composerViewPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
    }

    public void addFileLog() {
        Logger.addFileLog(TAG, "CTXObjectLock", 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        int i = isObjectLock() ? C9086R.string.composer_ctx_menu_unlock : C9086R.string.composer_ctx_menu_lock;
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_LOCK;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), i).setEnabled(canShow());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        List<SpenObjectBase> selectedObjectList;
        if (!this.mModeManager.isEditMode() || this.mObjectManager.getSelectedObjectPageList() == null || (selectedObjectList = this.mObjectManager.getSelectedObjectList()) == null || selectedObjectList.isEmpty()) {
            return false;
        }
        boolean z = -1;
        for (SpenObjectBase spenObjectBase : selectedObjectList) {
            if (spenObjectBase.getType() != 3 && spenObjectBase.getType() != 14) {
                return false;
            }
            boolean lockState = spenObjectBase.getLockState();
            if (z == -1) {
                z = lockState;
            } else if (z != lockState) {
                return false;
            }
        }
        return true;
    }

    public void execute() {
        ComposerSA.insertLog("401", "2035", isObjectLock() ? "0" : "1");
        Iterator<SpenObjectBase> it = this.mObjectManager.getSelectedObjectList().iterator();
        while (it.hasNext()) {
            it.next().setLockState(!r1.getLockState());
        }
        this.mObjectManager.commitHistory();
        this.mObjectManager.clearSelectObject();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m11003i(TAG, "executeMenu# ");
        addFileLog();
        execute();
    }

    public boolean isObjectLock() {
        List<SpenObjectBase> selectedObjectList = this.mObjectManager.getSelectedObjectList();
        if (selectedObjectList == null || selectedObjectList.isEmpty()) {
            Logger.m11003i(TAG, "isObjectLock# getSelectedObjectList is empty");
            return false;
        }
        Iterator<SpenObjectBase> it = selectedObjectList.iterator();
        while (it.hasNext()) {
            if (it.next().getLockState()) {
                return true;
            }
        }
        return false;
    }
}
