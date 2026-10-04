package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
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
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuRemoveAnchorToText extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuRemoveAnchorToText");
    private ModeManager mModeManager;
    private ObjectManager mObjectManager;
    private PdfManager mPdfManager;
    private ComposerViewPresenter mPresenter;
    private TaskController mTaskController;
    private TextManager mTextManager;

    public ContextMenuRemoveAnchorToText(ComposerViewPresenter composerViewPresenter, TaskController taskController) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mPdfManager = composerViewPresenter.getPdfManager();
        this.mTaskController = taskController;
        this.mPresenter = composerViewPresenter;
    }

    private void executeReleaseAnchor() {
        Logger.m11003i(TAG, "executeReleaseAnchor#");
        this.mTaskController.execute(new TaskAnchor(), new TaskAnchor.InputValues(this.mObjectManager, this.mTextManager, new TaskContract.AutoScrollContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuRemoveAnchorToText.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.common.TaskContract.AutoScrollContract
            public void setAutoScrollEnabled(boolean z) {
                ContextMenuRemoveAnchorToText.this.mPresenter.setAutoScrollEnabled(z);
            }
        }, this.mObjectManager.isSelectedBodyText() ? this.mTextManager.getCursorFromFocusedTextBox() : null), new Task.Callback<TaskAnchor.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuRemoveAnchorToText.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskAnchor.ResultValues resultValues) {
                Logger.m11000e(ContextMenuRemoveAnchorToText.TAG, "releaseAnchor fail#");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskAnchor.ResultValues resultValues) {
                if (ContextMenuRemoveAnchorToText.this.mModeManager.isMode(Mode.Writing)) {
                    ContextMenuRemoveAnchorToText.this.mObjectManager.clearSelectObject();
                } else {
                    ContextMenuRemoveAnchorToText.this.mObjectManager.selectObject(ContextMenuRemoveAnchorToText.this.mObjectManager.getNote().getBodyText());
                }
            }
        }, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_REMOVE_ANCHOR_TO_TEXT;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_remove_anchor_to_text).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (!this.mModeManager.isEditMode() || this.mObjectManager.getSelectedObjectList() == null || this.mObjectManager.getSelectedObjectList().isEmpty()) {
            return false;
        }
        if ((this.mObjectManager.getSelectedObjectPageList() != null && !this.mObjectManager.getSelectedObjectPageList().isEmpty()) || this.mPdfManager.hasSelectedPDF()) {
            return false;
        }
        if (!this.mObjectManager.isSelectedBodyText()) {
            List<SpenObjectBase> selectedObjectList = this.mObjectManager.getSelectedObjectList();
            return (selectedObjectList.size() == 1 && selectedObjectList.get(0).getType() == 22) ? false : true;
        }
        int[] cursorFromFocusedTextBox = this.mTextManager.getCursorFromFocusedTextBox();
        ArrayList<SpenObjectSpan> arrayListFindObjectSpan = this.mTextManager.getTextBox().findObjectSpan(cursorFromFocusedTextBox[0], cursorFromFocusedTextBox[1]);
        if (arrayListFindObjectSpan != null && !arrayListFindObjectSpan.isEmpty()) {
            for (SpenObjectSpan spenObjectSpan : arrayListFindObjectSpan) {
                if (spenObjectSpan.getObj() != null && spenObjectSpan.getObj().getType() == 22) {
                    return false;
                }
            }
            if (arrayListFindObjectSpan.size() == cursorFromFocusedTextBox[1] - cursorFromFocusedTextBox[0]) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        String str = TAG;
        Logger.m11003i(str, "executeRemoveAnchorMenu#");
        Logger.addFileLog(str, "CTXRemoveATT", 0);
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_VIEW_CTX_ANCHOR_TO_TEXT, "b");
        this.mObjectManager.setObjectSpanEnable(false);
        executeReleaseAnchor();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean isLockRelated() {
        return true;
    }
}
