package com.samsung.android.support.senl.p148nt.model.service;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class IDocumentServiceWrapper implements IDocumentService {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DocumentServiceListener {
        void onChangedDocumentByUser(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str);

        @WorkerThread
        void onChangedWorkingState(@NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId);

        void onForceClosedDocument();

        void onOpenedByUser(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str);

        void onReceiveBroadcastMessage(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull Intent intent);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DocumentSubscriptionListener {
        void onSubscribed(@NonNull IDocumentServiceWrapper iDocumentServiceWrapper);

        void onUnsubscribed(@NonNull IDocumentServiceWrapper iDocumentServiceWrapper);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SyncListener {
        boolean onReadyToDownloadDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str);

        boolean onReadyToReplaceDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str);
    }

    public abstract boolean askForReadyToDownloadDocument(@NonNull String str);

    public abstract boolean askForReadyToReplaceOriginalDocument(@NonNull String str);

    public abstract DocumentSubscriptionId getUser();

    public abstract void notifyDocumentOpenedListener(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str);

    public abstract void notifyForceClosedDocument();

    public abstract void notifyOnChangedDocumentListener(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str);

    public abstract void notifyOnChangedWorkingState(@NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId);

    public abstract boolean notifyOnReadyToDownloadDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str);

    public abstract boolean notifyOnReadyToReplaceDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str);

    public abstract void notifyOnReceiveBroadcastMessage(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull Intent intent);

    public abstract void registerDocumentServiceListener(DocumentServiceListener documentServiceListener);

    public abstract void registerSyncListener(SyncListener syncListener);

    public abstract void save(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener);

    public abstract void unregisterDocumentServiceListener(DocumentServiceListener documentServiceListener);

    public abstract void unregisterSyncListener(SyncListener syncListener);

    public abstract void unsubscribe();
}
