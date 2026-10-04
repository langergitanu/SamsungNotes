package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionNewPage extends AbsAction {
    private static final String TAG = Logger.createTag("ActionNewPage");
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;

    public ActionNewPage(ComposerViewPresenter composerViewPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerViewPresenter.getComposerModel();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        if (!this.mComposerModel.isEditable()) {
            Logger.m11003i(TAG, "doAction# " + str + " isEditable false ");
            return false;
        }
        int currentPageIndex = this.mComposerViewPresenter.getCurrentPageIndex();
        Logger.m11003i(TAG, "doAction# " + str + " / currIdx = " + currentPageIndex);
        this.mComposerViewPresenter.insertNewPageByCurrentPage(currentPageIndex);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean isSupported() {
        return !this.mComposerModel.isSingleMode();
    }
}
