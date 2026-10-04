package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.document.search.SearchData;
import com.samsung.android.sdk.composer.listener.SpenComposerActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SearchController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.link.LinkAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionListenerImpl extends SpenComposerActionListener {
    private static final String TAG = Logger.createTag("ActionListenerImpl");
    private final ContextMenuListenerImpl mContextMenuListener;
    protected ModeManager mModeManager;
    protected ListenerImplContract.IPresenter mPresenter;
    private final SearchController mSearchController;
    private ListenerImplContract.IStickyMemoManager mStickyMemoManager;
    private final ListenerImplContract.IView mView;

    public ActionListenerImpl(ListenerImplContract.IView iView, ListenerImplContract.IPresenter iPresenter, ControllerManager controllerManager, ContextMenuListenerImpl contextMenuListenerImpl) {
        this.mView = iView;
        this.mPresenter = iPresenter;
        this.mSearchController = controllerManager.getSearchController();
        this.mModeManager = iPresenter.getComposerModel().getModeManager();
        this.mContextMenuListener = contextMenuListenerImpl;
    }

    private int getActionLinkTypeToHyperLinkTypeConverting(int i) {
        if (i == 0) {
            return 2;
        }
        if (i == 1) {
            return 3;
        }
        if (i == 2) {
            return 1;
        }
        return i == 3 ? 7 : 0;
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onActionLinkClicked(String str, int i) {
        Logger.m10999d(TAG, "onActionLinkClicked type =" + i);
        new LinkAction().startActivityHyperTextByType(this.mPresenter.getActivity(), str, getActionLinkTypeToHyperLinkTypeConverting(i));
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onComposerClicked(MotionEvent motionEvent) {
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onEditModeChanged(int i) {
        if (i == 1 || i == 2) {
            if (this.mModeManager.isMode(Mode.Search) && this.mModeManager.getPrevMode() == Mode.ReadOnly) {
                Logger.m10999d(TAG, "onEditModeChanged# search mode from read only mode. skip to change mode");
                return;
            }
            Mode mode = Mode.Text;
            Mode mode2 = i == 2 ? Mode.Writing : mode;
            if (!this.mModeManager.isMode(mode) && !this.mModeManager.isMode(Mode.Writing)) {
                ComposerSA.insertLog(this.mPresenter.getDoc().isCoeditMode() ? "682" : "301", ComposerSAConstants.EVENT_VIEW_TOUCH_TO_EDIT, mode2 == mode ? "1" : "2");
            }
            this.mModeManager.setMode(mode2, "onEditModeChanged#", true);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onInitLayoutFinished() {
        Logger.m10999d(TAG, "onInitLayoutFinished#");
        this.mView.hideCover();
        this.mPresenter.onInitLayoutFinished();
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        if (i == 0 || i == i4) {
            return;
        }
        this.mView.setDelayFlagToUpdateDecorView(true);
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public boolean onPerformContextMenuAction(int i) {
        return this.mContextMenuListener.onPerformContextMenuAction(i);
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onSearchingText(int i, SearchData searchData) {
        SearchController searchController = this.mSearchController;
        if (searchController != null && searchController.canUpdateSearchingResult()) {
            this.mSearchController.updateSearchingResult(i, searchData);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onSmoothScrollEnd() {
        this.mView.onSmoothScrollEnd();
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onStickyMemoClicked(@NonNull SpenCustomObject spenCustomObject) {
        Logger.m10999d(TAG, "onStickyMemoClicked#");
        ListenerImplContract.IStickyMemoManager iStickyMemoManager = this.mStickyMemoManager;
        if (iStickyMemoManager == null || !(spenCustomObject instanceof SpenStickyNote)) {
            return;
        }
        iStickyMemoManager.openStickyMemo((SpenStickyNote) spenCustomObject);
    }

    public void release() {
        this.mStickyMemoManager = null;
    }

    public void setStickyMemoManager(ListenerImplContract.IStickyMemoManager iStickyMemoManager) {
        this.mStickyMemoManager = iStickyMemoManager;
    }
}
