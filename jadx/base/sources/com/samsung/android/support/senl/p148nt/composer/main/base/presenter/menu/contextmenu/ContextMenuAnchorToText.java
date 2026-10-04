package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAnchor;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.TaskContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuAnchorToText extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuAnchorToText");
    private ModeManager mModeManager;
    private ObjectManager mObjectManager;
    private ComposerViewPresenter mPresenter;
    private TaskController mTaskController;
    private TextManager mTextManager;

    public ContextMenuAnchorToText(ComposerViewPresenter composerViewPresenter, TaskController taskController) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mTaskController = taskController;
        this.mPresenter = composerViewPresenter;
    }

    private void executeAnchor(List<SpenObjectBase> list, List<SpenWPage> list2) {
        this.mTaskController.execute(new TaskAnchor(), new TaskAnchor.InputValues(this.mObjectManager, this.mTextManager, new TaskContract.AutoScrollContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuAnchorToText.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.common.TaskContract.AutoScrollContract
            public void setAutoScrollEnabled(boolean z) {
                ContextMenuAnchorToText.this.mPresenter.setAutoScrollEnabled(z);
            }
        }, list, list2), new Task.Callback<TaskAnchor.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuAnchorToText.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskAnchor.ResultValues resultValues) {
                Logger.m11000e(ContextMenuAnchorToText.TAG, "Anchor fail#");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskAnchor.ResultValues resultValues) {
                if (ContextMenuAnchorToText.this.mModeManager.isMode(Mode.Writing)) {
                    ContextMenuAnchorToText.this.mObjectManager.clearSelectObject();
                } else {
                    ContextMenuAnchorToText.this.mObjectManager.selectObject(ContextMenuAnchorToText.this.mObjectManager.getNote().getBodyText());
                }
            }
        }, false);
    }

    private boolean isObjectSpanSupportedType(int i) {
        return i == 14 || i == 3 || i == 10 || i == 13 || i == 17;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_ANCHOR_TO_TEXT;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_anchor_to_text).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        List<SpenObjectBase> selectedObjectList;
        if (!this.mModeManager.isEditMode() || this.mObjectManager.getSelectedObjectPageList() == null || (selectedObjectList = this.mObjectManager.getSelectedObjectList()) == null || selectedObjectList.isEmpty()) {
            return false;
        }
        Iterator<SpenObjectBase> it = selectedObjectList.iterator();
        while (it.hasNext()) {
            if (!isObjectSpanSupportedType(it.next().getType())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        String str = TAG;
        Logger.m10999d(str, "executeAnchorMenu#" + this.mObjectManager.getSelectedObjectList().size());
        Logger.addFileLog(str, "CTXATT", 0);
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_VIEW_CTX_ANCHOR_TO_TEXT, "a");
        ArrayList arrayList = new ArrayList(this.mObjectManager.getSelectedObjectList());
        ArrayList arrayList2 = new ArrayList(this.mObjectManager.getSelectedObjectPageList());
        this.mObjectManager.selectObject(null);
        this.mObjectManager.setObjectSpanEnable(true);
        executeAnchor(arrayList, arrayList2);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean isLockRelated() {
        return true;
    }
}
