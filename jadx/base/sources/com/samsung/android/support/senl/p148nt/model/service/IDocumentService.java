package com.samsung.android.support.senl.p148nt.model.service;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface IDocumentService {
    boolean askForReadyToDownloadDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str);

    boolean askForReadyToReplaceOriginalDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str);

    void close(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener);

    void discardQuickSave(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener);

    void open(@NonNull DocumentRepository<? extends ISpenDocument, ? extends DocumentEntityContainer> documentRepository, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener);

    void openCache(@NonNull DocumentRepository<? extends ISpenDocument, ? extends DocumentEntityContainer> documentRepository, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener);

    void release(@NonNull DocumentSubscriptionId documentSubscriptionId, long j, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener);

    void reload(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener);

    void save(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, boolean z2, DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener);

    void saveCache(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener);

    void sendBroadcastMessage(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull Intent intent);

    void snapSave(@NonNull DocumentDataSource<? extends ISpenDocument, ? extends DocumentEntityContainer> documentDataSource, boolean z, @Nullable DocumentCompletionListener<? extends ISpenDocument> documentCompletionListener);
}
