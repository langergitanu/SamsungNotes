package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectSpanHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCut;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuCut extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuCut");
    private final DynamicTemplateController mDynamicTemplateController;
    private final ModeManager mModeManager;
    private final ObjectManager mObjectManager;
    private final TaskController mTaskController;
    private final TextManager mTextManager;

    public ContextMenuCut(ComposerViewPresenter composerViewPresenter, TaskController taskController, DynamicTemplateController dynamicTemplateController) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mTaskController = taskController;
        this.mDynamicTemplateController = dynamicTemplateController;
    }

    private void cutObjectOfObjectSpan() {
        Logger.addFileLog(TAG, "CTXCutOS", 0);
        int[] iArrFindObjectSpanCursorPosition = new ObjectSpanHelper(this.mObjectManager.getNote()).findObjectSpanCursorPosition(this.mObjectManager.getSelectedObjectList());
        Activity activity = this.mActivity;
        ObjectManager objectManager = this.mObjectManager;
        TextManager textManager = this.mTextManager;
        this.mTaskController.execute(new TaskCut(), new TaskCut.InputValues(activity, objectManager, textManager, this.mDynamicTemplateController, textManager.getTextBox(), iArrFindObjectSpanCursorPosition[0], iArrFindObjectSpanCursorPosition[1]), null, false);
    }

    private void cutText() {
        Logger.addFileLog(TAG, "CTXCutText", 0);
        TextManager textManager = this.mTextManager;
        int[] cursor = textManager.getCursor(textManager.getTextBox());
        Activity activity = this.mActivity;
        ObjectManager objectManager = this.mObjectManager;
        TextManager textManager2 = this.mTextManager;
        this.mTaskController.execute(new TaskCut(), new TaskCut.InputValues(activity, objectManager, textManager2, this.mDynamicTemplateController, textManager2.getTextBox(), cursor[0], cursor[1]), null, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CUT;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_cut).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (KeyguardManagerCompat.INSTANCE.getInstance().isKeyguardSecureOn(this.mActivity) || !this.mModeManager.isEditMode()) {
            return false;
        }
        ArrayList<SpenObjectBase> selectedSafeObjectList = this.mObjectManager.getSelectedSafeObjectList();
        if (selectedSafeObjectList != null && selectedSafeObjectList.size() == 1 && selectedSafeObjectList.get(0).getLockState()) {
            return false;
        }
        return ContextMenuCopy.isAvailableToCopy(this.mObjectManager, this.mTextManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        ComposerSA.insertStatusLog(ComposerSAConstants.EVENT_EDIT_CONTEXTUAL_POPUP_USAGE, "2");
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CUT);
        String str = TAG;
        AbstractC8014b.m7215q(new StringBuilder("executeCutMenu#"), this.mTextManager.hasFocusedTextBox() || this.mObjectManager.isFocusedTextBox(), str);
        if (!this.mModeManager.isEditMode()) {
            Logger.m10999d(str, "executeCutMenu# mode is not edit." + this.mModeManager.getMode());
        } else if (this.mTextManager.hasFocusedTextBox() || this.mObjectManager.isFocusedTextBox()) {
            cutText();
        } else if (this.mObjectManager.isSelectedObjectOfObjectSpan() && !this.mObjectManager.getSelectedObjectManager().isSelectedTable()) {
            cutObjectOfObjectSpan();
        } else {
            Logger.addFileLog(str, "CTXCutObj", 0);
            this.mTaskController.execute(new TaskCut(), new TaskCut.InputValues(this.mActivity, this.mObjectManager, this.mDynamicTemplateController, new ArrayList(this.mObjectManager.getSelectedSafeObjectList())), null, false);
        }
    }
}
