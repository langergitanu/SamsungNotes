package com.samsung.android.support.senl.p148nt.composer.main.simple.model;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.OpenParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.DocumentLoadContract;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.entity.WordDocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceBinder;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;
import com.samsung.android.support.senl.p148nt.model.service.NotesWordDocumentService;
import com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class DocumentServiceStore implements DocumentLoadContract.IDataStore {
    private static final String TAG = Logger.createTag("DocumentServiceStore", SimpleComposerConstant.TAG_PREFIX);
    private DocumentLoadContract.IComposer mComposer;
    private ServiceConnection mConnection;
    private DocumentLoadContract.LoadListener mLoadListener;
    private OpenParam mOpenParam;
    private IDocumentServiceWrapper mService;
    private DocumentSubscriptionId mSubscriptionId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DocumentServiceConnection implements ServiceConnection {
        public /* synthetic */ DocumentServiceConnection(DocumentServiceStore documentServiceStore, int i) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Logger.m10999d(DocumentServiceStore.TAG, "onServiceConnected");
            if (CommonUtil.isNotAvailableActivity(DocumentServiceStore.this.mComposer.getActivity())) {
                Logger.m11000e(DocumentServiceStore.TAG, "onServiceConnected# not available activity");
                return;
            }
            if (!(iBinder instanceof IDocumentServiceBinder)) {
                Logger.m11000e(DocumentServiceStore.TAG, "wrong type" + iBinder);
                return;
            }
            DocumentServiceStore.this.mService = ((IDocumentServiceBinder) iBinder).subscribe(DocumentSubscriptionId.COMPOSER_SERVICE_ID.getUser(), DocumentServiceStore.this.mSubscriptionId);
            DocumentServiceStore documentServiceStore = DocumentServiceStore.this;
            documentServiceStore.mSubscriptionId = documentServiceStore.mService.getUser();
            DocumentServiceStore.this.openDocument();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Logger.m10999d(DocumentServiceStore.TAG, "onServiceDisconnected");
            DocumentServiceStore.this.mService = null;
        }

        private DocumentServiceConnection() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OpenCacheListener extends NotesDocumentCompletionListener<SpenWordDocument> {
        DocumentRepository<SpenWordDocument, WordDocumentEntityContainer> mDocumentRepository;

        public OpenCacheListener(DocumentRepository<SpenWordDocument, WordDocumentEntityContainer> documentRepository) {
            this.mDocumentRepository = documentRepository;
        }

        @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
        public void completed(@NonNull NotesDocument<SpenWordDocument> notesDocument, @NonNull String str) {
            DocumentServiceStore.this.onLoadDocCompleted(notesDocument, notesDocument.getLoadPath());
        }

        @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
        public void failed(Throwable th, String str) {
            DocumentServiceStore.this.mService.open(this.mDocumentRepository, DocumentServiceStore.this.new OpenDocumentListener());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OpenDocumentListener extends NotesDocumentCompletionListener<SpenWordDocument> {
        public OpenDocumentListener() {
        }

        @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
        public void completed(@NonNull NotesDocument<SpenWordDocument> notesDocument, @NonNull String str) {
            DocumentServiceStore.this.onLoadDocCompleted(notesDocument, notesDocument.getLoadPath());
        }

        @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
        public void failed(Throwable th, String str) {
            DocumentServiceStore.this.onLoadDocFailed(th);
        }
    }

    private void connect(DocumentLoadContract.IComposer iComposer) {
        this.mComposer = iComposer;
        this.mConnection = new DocumentServiceConnection(this, 0);
        Activity activity = this.mComposer.getActivity();
        activity.bindService(new Intent(activity, (Class<?>) NotesWordDocumentService.class), this.mConnection, 1);
    }

    private void disconnect(Context context) {
        if (this.mService == null) {
            Logger.m10999d(TAG, "disconnect# service is not connected");
            return;
        }
        Logger.m10999d(TAG, "disconnect# unsubscribe service");
        this.mService.unsubscribe();
        try {
            context.unbindService(this.mConnection);
        } catch (IllegalArgumentException e) {
            Logger.m11001e(TAG, "disconnect unbindService", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadDocCompleted(NotesDocument<SpenWordDocument> notesDocument, String str) {
        Logger.m10999d(TAG, "onLoadDocCompleted# " + notesDocument.getUuid());
        DocumentLoadContract.LoadListener loadListener = this.mLoadListener;
        if (loadListener != null) {
            loadListener.onLoadNoteCompleted((SpenWNote) notesDocument.getDoc(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadDocFailed(Throwable th) {
        Logger.m11000e(TAG, "onLoadDocFailed# " + th);
        DocumentLoadContract.LoadListener loadListener = this.mLoadListener;
        if (loadListener != null) {
            loadListener.onLoadNoteFailed(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openDocument() {
        Logger.m10999d(TAG, "openDocument# " + this.mOpenParam.getUuid());
        DocumentRepository<SpenWordDocument, WordDocumentEntityContainer> documentRepositoryMakeDocRepository = this.mOpenParam.makeDocRepository(DocumentSubscriptionId.COMPOSER_SERVICE_ID.getUser() + "_DocumentServiceConnection", this.mService.getUser());
        this.mService.openCache(documentRepositoryMakeDocRepository, new OpenCacheListener(documentRepositoryMakeDocRepository));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.IDataStore
    public void loadDocument(DocumentLoadContract.IComposer iComposer, OpenParam openParam) {
        this.mOpenParam = openParam;
        connect(iComposer);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.IDataStore
    public void onDestroyed() {
        disconnect(this.mComposer.getActivity());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.model.DocumentLoadContract.IDataStore
    public void setLoadListener(DocumentLoadContract.LoadListener loadListener) {
        this.mLoadListener = loadListener;
    }
}
