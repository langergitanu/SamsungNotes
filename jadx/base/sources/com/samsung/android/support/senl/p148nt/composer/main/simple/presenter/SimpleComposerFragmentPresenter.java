package com.samsung.android.support.senl.p148nt.composer.main.simple.presenter;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.DocumentLoadContract;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.DocumentLoadManager;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.NoteInfoArgument;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.NoteInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.SCVViewModel;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.SimpleComposerFragmentContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleComposerFragmentPresenter {
    private static final String TAG = Logger.createTag("SimpleComposerFragmentPresenter", SimpleComposerConstant.TAG_PREFIX);
    private final DocumentLoadManager mDocumentLoadManager;
    private final Fragment mFragment;
    private final NoteInfoManager mNoteInfoManager;
    private final SCVViewModel mSCVViewModel;
    private Bundle mSavedInstance;
    private final SimpleComposerViewPresenter mSimpleComposerViewPresenter;
    private final SimpleComposerFragmentContract.IView mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DocumentLoadListenerImpl implements DocumentLoadContract.LoadListener {
        public DocumentLoadListenerImpl() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.LoadListener
        public void onLoadNoteCompleted(SpenWNote spenWNote, String str) {
            SimpleComposerFragmentPresenter.this.mNoteInfoManager.setNote(spenWNote, str);
            SimpleComposerFragmentPresenter.this.attachLoadedDoc(spenWNote);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.LoadListener
        public void onLoadNoteFailed(Throwable th) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleComposerFragmentPresenter(SimpleComposerFragmentContract.IView iView, NoteInfoArgument noteInfoArgument, Bundle bundle) {
        Fragment fragment = (Fragment) iView;
        this.mFragment = fragment;
        this.mView = iView;
        this.mSavedInstance = bundle;
        SCVViewModel sCVViewModel = (SCVViewModel) new ViewModelProvider(fragment).get(SCVViewModel.class);
        this.mSCVViewModel = sCVViewModel;
        sCVViewModel.setOnClearedListener(new SCVViewModel.OnClearedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.presenter.SimpleComposerFragmentPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.simple.presenter.SCVViewModel.OnClearedListener
            public void onCleared() {
                SimpleComposerFragmentPresenter.this.onDestroy();
            }
        });
        NoteInfoManager noteInfoManager = sCVViewModel.getNoteInfoManager();
        this.mNoteInfoManager = noteInfoManager;
        noteInfoManager.setNoteInfoArgument(noteInfoArgument);
        this.mDocumentLoadManager = new DocumentLoadManager();
        SimpleComposerViewPresenter simpleComposerViewPresenter = new SimpleComposerViewPresenter();
        this.mSimpleComposerViewPresenter = simpleComposerViewPresenter;
        simpleComposerViewPresenter.init(noteInfoManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachLoadedDoc(SpenWNote spenWNote) {
        Logger.m10999d(TAG, "attachLoadedDoc# " + this.mNoteInfoManager.hashCode());
        this.mView.updateTitle(spenWNote.getTitle() == null ? "" : spenWNote.getTitle().getText());
        this.mView.attachComposerView(this.mSimpleComposerViewPresenter);
        this.mSimpleComposerViewPresenter.initNote();
        restoreLastState();
    }

    private void restoreLastState() {
        Bundle bundle = this.mSavedInstance;
        if (bundle == null) {
            return;
        }
        this.mSimpleComposerViewPresenter.restoreState(bundle);
        this.mSavedInstance = null;
    }

    public SpenWNote getNote() {
        return this.mNoteInfoManager.getNote();
    }

    public void onDestroy() {
        this.mSCVViewModel.setOnClearedListener(null);
        this.mSimpleComposerViewPresenter.onDestroy();
        this.mDocumentLoadManager.onDestroyed();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        this.mSimpleComposerViewPresenter.onSaveInstanceState(bundle);
    }

    public void requestLoadDocument() {
        if (this.mNoteInfoManager.getNote() != null) {
            attachLoadedDoc(this.mNoteInfoManager.getNote());
        } else {
            this.mDocumentLoadManager.loadDocument(new DocumentLoadContract.IComposer() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.presenter.SimpleComposerFragmentPresenter.2
                @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.IComposer
                public Activity getActivity() {
                    return SimpleComposerFragmentPresenter.this.mFragment.requireActivity();
                }
            }, this.mNoteInfoManager, new DocumentLoadListenerImpl());
        }
    }
}
