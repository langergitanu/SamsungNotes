package com.samsung.android.support.senl.p148nt.composer.main.simple.model;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.OpenParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.DocumentLoadContract;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentLoadManager implements DocumentLoadContract.LoadListener {
    private static final String TAG = Logger.createTag("DocumentLoadManager", SimpleComposerConstant.TAG_PREFIX);
    private DocumentLoadContract.IDataStore mDataStore;
    private DocumentLoadContract.LoadListener mLoadListener;

    private void createDataStore(NoteInfoManager noteInfoManager) {
        if (this.mDataStore == null) {
            if (noteInfoManager.getNoteInfoArgument().isNeededClose()) {
                this.mDataStore = new DocumentLocalStore(noteInfoManager.getNoteInfoArgument().isNeededDownload());
            } else {
                this.mDataStore = new DocumentServiceStore();
            }
            this.mDataStore.setLoadListener(this);
        }
    }

    public void loadDocument(DocumentLoadContract.IComposer iComposer, NoteInfoManager noteInfoManager, DocumentLoadContract.LoadListener loadListener) {
        Logger.m10999d(TAG, "loadDocument# " + noteInfoManager.hashCode());
        this.mLoadListener = loadListener;
        createDataStore(noteInfoManager);
        int screenWidth = SpenDocumentDisplayUtils.getScreenWidth(iComposer.getActivity());
        NoteInfoArgument noteInfoArgument = noteInfoManager.getNoteInfoArgument();
        this.mDataStore.loadDocument(iComposer, new OpenParam.Builder().setPageWidth(screenWidth).setUuid(noteInfoArgument.getUuid()).setDocPath(noteInfoArgument.getPath()).setLockAccountGuid(noteInfoArgument.getLockAccountGuid()).done());
    }

    public void onDestroyed() {
        DocumentLoadContract.IDataStore iDataStore = this.mDataStore;
        if (iDataStore == null) {
            return;
        }
        iDataStore.onDestroyed();
        this.mDataStore = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.LoadListener
    public void onLoadNoteCompleted(SpenWNote spenWNote, String str) {
        Logger.m10999d(TAG, "onLoadNoteCompleted# ");
        this.mLoadListener.onLoadNoteCompleted(spenWNote, str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.LoadListener
    public void onLoadNoteFailed(Throwable th) {
        Logger.m10999d(TAG, "onLoadNoteCompleted# ");
        this.mLoadListener.onLoadNoteFailed(th);
    }
}
