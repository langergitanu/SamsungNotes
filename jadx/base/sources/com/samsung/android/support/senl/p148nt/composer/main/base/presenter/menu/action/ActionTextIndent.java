package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskIndentThread;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionTextIndent extends AbsAction {
    private static final String TAG = Logger.createTag("ActionTextIndent");
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ControllerManager mControllerManager;
    private final boolean mIsIndent;

    public ActionTextIndent(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, boolean z) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mControllerManager = controllerManager;
        this.mIsIndent = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        if (this.mControllerManager.getTaskController().isRunning()) {
            Logger.m11004w(TAG, "doAction# error task is running / " + str);
            return false;
        }
        final ObjectManager objectManager = this.mComposerViewPresenter.getObjectManager();
        if (!objectManager.isFocusedTextBox()) {
            Logger.m11004w(TAG, "doAction# isFocusedTextBox false / " + str);
            return false;
        }
        Logger.m11003i(TAG, "doAction# mIsIndent =" + this.mIsIndent + " / " + str);
        objectManager.commitHistory();
        objectManager.getSelectedObjectManager().setFocusCurTextBox();
        final TextManager textManager = this.mComposerViewPresenter.getTextManager();
        SpenObjectShape textBox = textManager.getTextBox();
        final int[] cursorFromFocusedTextBox = textManager.getCursorFromFocusedTextBox();
        this.mControllerManager.getTaskController().execute(new TaskIndentThread(), new TaskIndentThread.InputValues(textManager.getIndent(), textManager.getParagraphIndex(textBox, cursorFromFocusedTextBox), textBox, this.mIsIndent), new Task.Callback<Task.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.action.ActionTextIndent.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(Task.ResultValues resultValues) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(Task.ResultValues resultValues) {
                textManager.notifyToListener(cursorFromFocusedTextBox);
                objectManager.commitHistory();
            }
        }, false);
        return true;
    }
}
