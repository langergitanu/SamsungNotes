package com.samsung.android.support.senl.p148nt.model.document.save;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentText;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.TimeSaveParam;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.DisplayDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.document.save.legacy.SaveNoteContentsResolver;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SDocSaveOperation extends SaveOperation<NotesDocumentEntity, SpenSDoc> {
    private static final String TAG = DataLogger.createTag("SDocSaveOperation");

    public SDocSaveOperation(@NonNull Context context) {
        super(context);
        setSaveStrategy(2056);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setDocumentBackgroundEntity(@NonNull SpenSDoc spenSDoc, @NonNull NotesDocumentEntity notesDocumentEntity) {
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void saveToDatabase(@NonNull SpenSDoc spenSDoc, @NonNull NotesDocumentEntity notesDocumentEntity) {
        if (!isNew() && !notesDocumentEntity.isDirtySkipped()) {
            notesDocumentEntity.setIsDirty(1);
        }
        DocumentDBSaver.saveSDoc(NotesDataRepositoryFactory.newInstance(getContext()).createDocumentDataRepository(), notesDocumentEntity);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setDocumentContentEntity(@NonNull SpenSDoc spenSDoc, @NonNull NotesDocumentEntity notesDocumentEntity) {
        SaveNoteContentsResolver saveNoteContentsResolver = new SaveNoteContentsResolver(getContext());
        saveNoteContentsResolver.removeContents(notesDocumentEntity.getUuid());
        notesDocumentEntity.setContentSecureVersion(0);
        saveNoteContentsResolver.updateContents(notesDocumentEntity, notesDocumentEntity.getUuid(), spenSDoc, false, checkSaveStrategy(131072));
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setDocumentPageEntity(@NonNull SpenSDoc spenSDoc, @NonNull NotesDocumentEntity notesDocumentEntity) {
        notesDocumentEntity.setPageMode(1);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setDocumentSize(@NonNull SpenSDoc spenSDoc, @NonNull NotesDocumentEntity notesDocumentEntity) {
        long sdocStorage = StorageUtils.getSdocStorage(notesDocumentEntity.getFilePath());
        notesDocumentEntity.setSize(sdocStorage);
        DataLogger.m12302d(TAG, "setDocumentSize: " + sdocStorage);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setDocumentTimeEntity(@NonNull SpenSDoc spenSDoc, @NonNull NotesDocumentEntity notesDocumentEntity) {
        long createdTime;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!notesDocumentEntity.getKeepServerTimestamp()) {
            notesDocumentEntity.setServerTimestamp(Long.valueOf(TimeManager.getCurrentTime()));
        }
        TimeSaveParam timeSaveParam = notesDocumentEntity.getTimeSaveParam();
        DataLogger.m12302d(TAG, "setDocumentTimeEntity, timeSaveParam : " + timeSaveParam);
        if (isNew()) {
            if (FileUtils.exists(notesDocumentEntity.getFilePath())) {
                try {
                    createdTime = SpenSDocFile.getCreatedTime(notesDocumentEntity.getFilePath());
                } catch (SpenSDocUnsupportedFileException | SpenSDocUnsupportedVersionException | IOException e) {
                    AbstractC11014a.m12333r(e, new StringBuilder("setDocumentTimeEntity, e : "), TAG);
                    createdTime = jCurrentTimeMillis;
                }
                notesDocumentEntity.setCreatedAt(timeSaveParam.getCreatedTime(Long.valueOf(createdTime)).longValue());
                notesDocumentEntity.setLastModifiedAt(timeSaveParam.getLastModifiedTime(Long.valueOf(createdTime)).longValue());
            } else {
                createdTime = jCurrentTimeMillis;
                notesDocumentEntity.setCreatedAt(timeSaveParam.getCreatedTime(Long.valueOf(createdTime)).longValue());
                notesDocumentEntity.setLastModifiedAt(timeSaveParam.getLastModifiedTime(Long.valueOf(createdTime)).longValue());
            }
        }
        boolean zCheckSaveStrategy = checkSaveStrategy(16384);
        if (!zCheckSaveStrategy) {
            notesDocumentEntity.setLastModifiedAt(timeSaveParam.getLastModifiedTime(Long.valueOf(jCurrentTimeMillis)).longValue());
        }
        if (notesDocumentEntity.getLastModifiedAt() == 0) {
            notesDocumentEntity.setLastModifiedAt(timeSaveParam.getLastModifiedTime(Long.valueOf(jCurrentTimeMillis)).longValue());
        }
        if (notesDocumentEntity.getCreatedAt() == 0) {
            notesDocumentEntity.setCreatedAt(notesDocumentEntity.getLastModifiedAt());
        }
        DataLogger.m12302d(TAG, "setDocumentTimeEntity, isNew : " + isNew() + ", created : " + notesDocumentEntity.getCreatedAt() + ", modified : " + notesDocumentEntity.getLastModifiedAt() + ", doNotUpdateModifiedTime : " + zCheckSaveStrategy);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setDocumentTitleEntity(@NonNull SpenSDoc spenSDoc, @NonNull NotesDocumentEntity notesDocumentEntity) {
        SpenContentText title = spenSDoc.getTitle();
        if (title != null) {
            notesDocumentEntity.setTitle(title.getText());
        }
        notesDocumentEntity.setDisplayTitle(DisplayDataConverter.convertDisplayData(spenSDoc.getTitle()));
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation
    public void setLockAccountGuidEntity(@NonNull SpenSDoc spenSDoc, @NonNull NotesDocumentEntity notesDocumentEntity) {
        DataLogger.m12302d(TAG, "setLockAccountGuid, accountGuid : " + DataLogger.pii(getLockAccountGuid()) + ", lockType : " + notesDocumentEntity.getIsLock());
        notesDocumentEntity.setLockAccountGuid(!LockUtils.isUnLockedDocType(notesDocumentEntity.getIsLock()) ? getLockAccountGuid() : "");
    }
}
