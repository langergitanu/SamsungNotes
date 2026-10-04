package com.samsung.android.support.senl.p148nt.composer.main.simple.presenter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerDocInitialization;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.ComposerStateManager;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.NoteInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.SimpleComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.listener.ISimpleListenerContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleComposerViewPresenter implements ISimpleListenerContract.IPresenter {
    private static final String TAG = Logger.createTag("SimpleComposerViewPresenter", SimpleComposerConstant.TAG_PREFIX);
    private final ComposerStateManager mComposerStateManager;
    private boolean mIsInitialized = false;
    private NoteInfoManager mNoteInfoManager;
    private final SCVListenerManager mSCVListenerManager;
    private final SCVScrollZoomController mSCVScrollZoomController;
    private SimpleComposerViewContract.IView mView;

    public SimpleComposerViewPresenter() {
        ComposerStateManager composerStateManager = new ComposerStateManager();
        this.mComposerStateManager = composerStateManager;
        SCVScrollZoomController sCVScrollZoomController = new SCVScrollZoomController(composerStateManager);
        this.mSCVScrollZoomController = sCVScrollZoomController;
        this.mSCVListenerManager = new SCVListenerManager(sCVScrollZoomController);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.presenter.listener.ISimpleListenerContract.IPresenter
    public SpenWNote getDoc() {
        return this.mNoteInfoManager.getNote();
    }

    public SimpleComposerViewContract.ZoomScrollPresenter getSCVScrollZoomController() {
        return this.mSCVScrollZoomController;
    }

    public void init(NoteInfoManager noteInfoManager) {
        this.mNoteInfoManager = noteInfoManager;
        this.mSCVScrollZoomController.init(noteInfoManager);
    }

    public void initNote() {
        SpenWNote note = this.mNoteInfoManager.getNote();
        ComposerDocInitialization.setPageDefaultHeight(note);
        this.mSCVScrollZoomController.setView(this.mView);
        this.mView.initView(note);
        this.mSCVListenerManager.init(this.mView);
        this.mIsInitialized = true;
    }

    public void onDestroy() {
        if (this.mView != null) {
            this.mSCVListenerManager.release();
            this.mView.release();
            this.mView = null;
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (this.mIsInitialized) {
            this.mComposerStateManager.onSaveInstanceState(bundle);
        }
    }

    public void restoreState(@NonNull Bundle bundle) {
        this.mComposerStateManager.restoreState(bundle);
    }

    public void setView(SimpleComposerViewContract.IView iView) {
        this.mView = iView;
    }
}
