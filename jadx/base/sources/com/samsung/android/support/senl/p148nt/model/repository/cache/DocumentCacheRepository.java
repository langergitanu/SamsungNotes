package com.samsung.android.support.senl.p148nt.model.repository.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.documents.SpenSDocDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentCacheRepository implements SpenSDocDataSource {
    private final DocumentDataSource mDocument;
    private final String mPath;
    private final List<DocumentSubscriptionId> mUsingIds = new ArrayList();
    private final String mUuid;

    private DocumentCacheRepository(@NonNull String str, @NonNull String str2, @NonNull DocumentDataSource documentDataSource) {
        this.mUuid = str;
        this.mPath = str2;
        this.mDocument = documentDataSource;
    }

    public static SpenSDocDataSource create(@NonNull String str, @NonNull String str2, @NonNull DocumentDataSource documentDataSource) {
        return new DocumentCacheRepository(str, str2, documentDataSource);
    }

    public static SpenSDocDataSource subscribe(@NonNull SpenSDocDataSource spenSDocDataSource, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        if (spenSDocDataSource instanceof DocumentCacheRepository) {
            ((DocumentCacheRepository) spenSDocDataSource).subscribe(documentSubscriptionId);
        }
        return spenSDocDataSource;
    }

    public static void unsubscribe(@Nullable SpenSDocDataSource spenSDocDataSource, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        if (spenSDocDataSource instanceof DocumentCacheRepository) {
            ((DocumentCacheRepository) spenSDocDataSource).unsubscribe(documentSubscriptionId);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.SpenSDocDataSource
    @NonNull
    public DocumentDataSource getDocument() {
        DocumentDataSource documentDataSource;
        synchronized (this.mDocument) {
            documentDataSource = this.mDocument;
        }
        return documentDataSource;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.SpenSDocDataSource
    @NonNull
    public String getPath() {
        return this.mPath;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.SpenSDocDataSource
    @NonNull
    public ISpenDocument getSpenSDoc() {
        ISpenDocument doc;
        synchronized (this.mDocument) {
            doc = this.mDocument.getDoc();
        }
        return doc;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.SpenSDocDataSource
    @NonNull
    public String getUuid() {
        return this.mUuid;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.SpenSDocDataSource
    public boolean isUsed(@NonNull DocumentSubscriptionId documentSubscriptionId) {
        boolean zContains;
        synchronized (this.mUsingIds) {
            zContains = this.mUsingIds.contains(documentSubscriptionId);
        }
        return zContains;
    }

    @NonNull
    public String toString() {
        ArrayList arrayList;
        synchronized (this.mUsingIds) {
            arrayList = new ArrayList(this.mUsingIds);
        }
        return "DocumentCacheRepository{mUuid='" + getUuid() + "', mPath='" + DataLogger.getEncode(getPath()) + "', mDocument=" + getSpenSDoc() + ", mDocument.isClosed : " + getSpenSDoc().isClosed() + ", mUsingIds=" + arrayList + '}';
    }

    private void subscribe(@NonNull DocumentSubscriptionId documentSubscriptionId) {
        synchronized (this.mUsingIds) {
            try {
                if (!this.mUsingIds.contains(documentSubscriptionId) && !DocumentSubscriptionId.SKIPPED_USERS.contains(documentSubscriptionId)) {
                    this.mUsingIds.add(documentSubscriptionId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void unsubscribe(@NonNull DocumentSubscriptionId documentSubscriptionId) {
        synchronized (this.mUsingIds) {
            this.mUsingIds.remove(documentSubscriptionId);
        }
    }
}
