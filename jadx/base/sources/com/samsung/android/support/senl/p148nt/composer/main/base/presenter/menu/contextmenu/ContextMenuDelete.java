package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectSpanHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskDelete;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuDelete extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuDelete");
    private final Config mConfig;
    private final DynamicTemplateController mDynamicTemplateController;
    private final ModeManager mModeManager;
    private final ObjectManager mObjectManager;
    private final TaskController mTaskController;

    public ContextMenuDelete(ComposerViewPresenter composerViewPresenter, TaskController taskController, DynamicTemplateController dynamicTemplateController) {
        this.mConfig = composerViewPresenter.getComponentFactory().getConfig();
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mTaskController = taskController;
        this.mDynamicTemplateController = dynamicTemplateController;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_DELETE;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_delete).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (!this.mModeManager.isEditMode()) {
            return false;
        }
        if ((this.mObjectManager.getTextManager() != null && this.mObjectManager.getTextManager().hasFocusedTextBox()) || this.mObjectManager.isFocusedTextBox() || this.mObjectManager.getSelectedObjectList().isEmpty()) {
            return false;
        }
        ArrayList<SpenObjectBase> selectedSafeObjectList = this.mObjectManager.getSelectedSafeObjectList();
        return (selectedSafeObjectList != null && selectedSafeObjectList.size() == 1 && selectedSafeObjectList.get(0).getLockState()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        String str = TAG;
        Logger.addFileLog(str, "CTXDel", 0);
        Logger.m10999d(str, "executeDeleteMenu#" + this.mObjectManager.getSelectedObjectList().size());
        if (this.mObjectManager.getSelectedObjectManager().getSelectedObjectPageList() != null || this.mObjectManager.getSelectedObjectManager().isSelectedTable()) {
            ObjectManager objectManager = this.mObjectManager;
            TaskDelete.InputValues inputValues = new TaskDelete.InputValues(objectManager, this.mDynamicTemplateController, objectManager.getSelectedObjectList(), this.mObjectManager.getSelectedObjectManager().getSelectedObjectPageList());
            TaskDelete taskDelete = new TaskDelete();
            this.mTaskController.execute(taskDelete, inputValues, taskDelete.getDefaultCallback(), false);
        } else {
            ObjectSpanHelper objectSpanHelper = new ObjectSpanHelper(this.mObjectManager.getNote());
            objectSpanHelper.deleteObjectSpan(objectSpanHelper.findObjectSpan(this.mObjectManager.getSelectedObjectList(), this.mConfig.isIrremovableTableDeleteBlocked()));
            this.mObjectManager.getSelectedObjectManager().closeObjectControlExceptTextBox();
        }
        ComposerSA.insertLog("411", ComposerSAConstants.EVENT_WRITING_CTX_MENU_DELETE);
    }
}
