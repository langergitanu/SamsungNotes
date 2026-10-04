package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo;

import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenTextManagerActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9872c implements ListenerImplContract.IStickyMemoManager, HwToolbarPresenter.IStickyMemoManager, SpenTextManagerActionListenerImpl.OnBeforeTextChangedByKeyboardListener, HistoryEventListenerImpl.OnCommitListener, ScrollController.OnScrollListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ StickyMemoManager f7030a;

    public /* synthetic */ C9872c(StickyMemoManager stickyMemoManager) {
        this.f7030a = stickyMemoManager;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.OnCommitListener
    public void onCommit() {
        StickyMemoManager.onCommitListener$lambda$0(this.f7030a);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ScrollController.OnScrollListener
    public void onScroll() {
        StickyMemoManager.initComposerConnection$lambda$16(this.f7030a);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenTextManagerActionListenerImpl.OnBeforeTextChangedByKeyboardListener
    public void onTyping() {
        StickyMemoManager.init$lambda$4(this.f7030a);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IStickyMemoManager
    public void openStickyMemo(SpenStickyNote spenStickyNote) {
        StickyMemoManager.onAttachView$lambda$5(this.f7030a, spenStickyNote);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter.IStickyMemoManager
    public void setBlockCommitListener(boolean z) {
        this.f7030a.isBlockingOnCommitListener = z;
    }
}
