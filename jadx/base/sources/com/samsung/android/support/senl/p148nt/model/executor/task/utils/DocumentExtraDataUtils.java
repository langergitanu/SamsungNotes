package com.samsung.android.support.senl.p148nt.model.executor.task.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.ExternalSharedDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.ExternalSharedDocumentsRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DocumentExtraDataUtils {
    private static final String TAG = ModelLogger.createTag("DocumentExtraDataUtils");

    public static boolean save(@NonNull Context context, @NonNull DocumentDataSource documentDataSource, boolean z) {
        boolean zIsContentEmpty = documentDataSource.isContentEmpty();
        DataLogger.m12307i(TAG, "save, uuid : " + documentDataSource.getUuid() + ", isContentEmpty : " + zIsContentEmpty + ", isDiscarded : " + documentDataSource.isDiscarded());
        if (documentDataSource.isDiscarded()) {
            return false;
        }
        documentDataSource.saveCoverData(context);
        if (!zIsContentEmpty && documentDataSource.saveTagDataSource(context) && z) {
            updateExternalSharedDocuments(context, documentDataSource);
        }
        documentDataSource.saveStickyNotes(context);
        return true;
    }

    public static void updateExternalSharedDocuments(@NonNull Context context, @NonNull DocumentDataSource documentDataSource) {
        updateExternalSharedDocuments(context, documentDataSource.getUuid(), documentDataSource.getDocumentEntityContainer().getEntity().getLastModifiedAt(), !documentDataSource.isSaveCache());
    }

    public static void updateExternalSharedDocuments(@NonNull Context context, @NonNull String str, long j, boolean z) {
        ExternalSharedDocumentsRepository externalSharedDocumentsRepositoryCreateExternalSharedDocumentsRepository = NotesDataRepositoryFactory.newInstance(context).createExternalSharedDocumentsRepository();
        ExternalSharedDocumentEntity entity = externalSharedDocumentsRepositoryCreateExternalSharedDocumentsRepository.getEntity(str);
        if (entity == null) {
            entity = new ExternalSharedDocumentEntity();
            entity.setUuid(str);
        }
        if (entity.getTimestamp() >= j) {
            entity.setTimestamp(entity.getTimestamp() + 1);
        } else {
            entity.setTimestamp(j);
        }
        externalSharedDocumentsRepositoryCreateExternalSharedDocumentsRepository.insert(entity);
        if (z) {
            DataUpdateManager.getInstance().onDocumentUpdated(Collections.singleton(str));
        }
    }
}
