package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionEditMode extends AbsAction {
    private static final String TAG = Logger.createTag("ActionEditMode");
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ModeManager mModeManager;

    public ActionEditMode(ComposerViewPresenter composerViewPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
    }

    private boolean executeDoAction(String str, Object obj) {
        if (!(obj instanceof Boolean)) {
            Logger.m11000e(TAG, "executeDoAction# error arg" + obj);
            return false;
        }
        if (!this.mComposerViewPresenter.getComposerModel().isEditable()) {
            Logger.m11000e(TAG, "executeDoAction# error is not editable ");
            return false;
        }
        if (!this.mComposerViewPresenter.getComposerModel().getCoeditAdapter().takeServerWritePermission()) {
            Logger.m11000e(TAG, "executeDoAction# don't have permission to write to server ");
            return false;
        }
        if (!this.mModeManager.isMode(Mode.View) && !this.mModeManager.isMode(Mode.Search)) {
            Logger.m11000e(TAG, "executeDoAction# error mode = " + this.mModeManager.getMode());
            if (!this.mModeManager.isMode(Mode.Text)) {
                return false;
            }
            List<SpenObjectBase> selectedObjectList = this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().getSelectedObjectList();
            if (selectedObjectList != null && !selectedObjectList.isEmpty()) {
                return false;
            }
            this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().selectObject(this.mComposerViewPresenter.getDoc().getBodyText());
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        String str2 = TAG;
        Logger.m11003i(str2, "executeDoAction# isTextMode =" + zBooleanValue + " / " + str);
        this.mComposerViewPresenter.setContextMenu(false);
        this.mComposerViewPresenter.getObjectManager().clearSelection();
        if (zBooleanValue) {
            this.mComposerViewPresenter.getNoteManager().setCursorOnScreen(this.mComposerViewPresenter.getPageManager().getDocPageInfo().getCurrentPageIndex());
        }
        this.mModeManager.setMode(zBooleanValue ? Mode.Text : Mode.Writing, str2 + str, true);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        return executeDoAction(str, Boolean.TRUE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str, Object obj) {
        return executeDoAction(str, obj);
    }
}
