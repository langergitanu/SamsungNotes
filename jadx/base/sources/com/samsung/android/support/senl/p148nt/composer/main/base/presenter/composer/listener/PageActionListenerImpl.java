package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.samsung.android.sdk.composer.listener.SpenPageActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageActionListenerImpl extends SpenPageActionListener {
    private static final String TAG = Logger.createTag("PageActionListenerImpl");
    protected NoteManager mNoteManager;
    private ListenerImplContract.IPresenter mPresenter;
    private ProgressController mProgressController;

    public PageActionListenerImpl(ListenerImplContract.IPresenter iPresenter, ProgressController progressController) {
        this.mPresenter = iPresenter;
        this.mNoteManager = iPresenter.getNoteManager();
        this.mProgressController = progressController;
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenPageActionListener
    public void onLastPageChanged(int i) {
        onLastPageChanged(i, true);
    }

    public void onLastPageChanged(int i, boolean z) {
        if (this.mPresenter.getComposerModel().getMdeManager().getCoeditAdapter().isCoeditNote() && this.mProgressController.isShowingProgressCircleByType(5)) {
            Logger.m11000e(TAG, "onLastPageChanged# coedit is not ready");
            return;
        }
        if (this.mNoteManager.isAddPageBlocked()) {
            Logger.m11004w(TAG, "onLastPageChanged# ignore, addPage is blocked");
            return;
        }
        PageManager pageManager = this.mPresenter.getPageManager();
        int pageCount = pageManager.getPageCount();
        int pageCount2 = this.mPresenter.getDoc().getPageCount();
        if (z && pageCount != pageCount2) {
            AbstractC8014b.m7216r(pageCount2, pageCount, "onLastPageChanged mismatch# ", " ", TAG);
            pageManager.initPageInfoList(this.mPresenter.getDoc());
        }
        SpenWNote doc = this.mPresenter.getDoc();
        int[] newPageSize = this.mNoteManager.getNewPageSize(pageCount2 - 1);
        int i2 = newPageSize[1];
        int height = doc.getHeight() - i2;
        String str = TAG;
        Logger.m10999d(str, "onLastPageChanged# " + i + " " + height);
        int i4 = i - height;
        int i5 = (i4 / i2) + (i4 % i2 > 0 ? 1 : 0);
        if (i5 <= 0) {
            return;
        }
        AbstractC8014b.m7216r(pageCount, i5, "onLastPageChanged# ", " new page count: ", str);
        boolean zIsChangedRealContent = (this.mPresenter.getComposerModel().getModeManager().isComposerViewMode() || !this.mPresenter.getComposerModel().isInitLayoutFinishedOneSecond()) ? this.mPresenter.getComposerModel().isChangedRealContent() : true;
        this.mNoteManager.addPages(i5, newPageSize[0], newPageSize[1], true, true);
        if (!zIsChangedRealContent) {
            doc.clearChangedFlag();
            Logger.m11003i(str, "onLastPageChanged# clearChangedFlag");
        }
        if (pageCount2 == 1) {
            this.mPresenter.getComposerControllerManager().getScrollController().alignmentContent(0);
        }
    }
}
