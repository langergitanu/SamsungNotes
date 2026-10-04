package com.samsung.android.support.senl.p148nt.model.converter.task.service;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.access.folder.FolderAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.hashtag.HashTagAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.tag.HashTagData;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.converter.HashtagDataConverter;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.category.CategoryColorConverter;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.category.CategoryToFolderConverter;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertedDocumentUpdater {
    private static final String TAG = ModelLogger.createConverterTag("ConvertedDocumentUpdater");
    private static CategoryColorConverter sColorModel;
    private final Context mAppContext;
    private CategoryToFolderConverter mCategoryToFolderConverter;
    private final NotesDocument<ISpenDocument> mConvertedDocument;
    private NotesDocumentEntity mConvertedEntity;
    private final String mConvertedNoteUuid;
    private final IConvertInfo mInfo;
    private final boolean mIsConvertedFromOutside;
    private final String mOriginNoteUuid;
    private final boolean mSaveConvertedNoteAsNewNote;

    public ConvertedDocumentUpdater(Context context, NotesDocument<ISpenDocument> notesDocument, IConvertInfo iConvertInfo) {
        this.mAppContext = context;
        initColorModel(context);
        setCategoryToFolderConverter(new CategoryToFolderConverter(sColorModel));
        this.mConvertedDocument = notesDocument;
        this.mConvertedEntity = notesDocument.getDocumentEntityContainer().getEntity();
        this.mInfo = iConvertInfo;
        String uuid = iConvertInfo.getUuid();
        this.mOriginNoteUuid = uuid;
        this.mConvertedNoteUuid = this.mConvertedEntity.getUuid();
        this.mSaveConvertedNoteAsNewNote = TextUtils.isEmpty(iConvertInfo.getDstUuid());
        this.mIsConvertedFromOutside = TextUtils.isEmpty(uuid);
    }

    private static synchronized void initColorModel(Context context) {
        if (sColorModel == null) {
            sColorModel = new CategoryColorConverter(FolderAccessHandler.getContract().getResourceInjector(context.getResources()));
        }
    }

    private void setConvertedFolderData() {
        DataLogger.m12302d(TAG, "updateFolderData, originalCategory : " + this.mConvertedEntity.getCategoryUuid());
        if (TextUtils.isEmpty(this.mConvertedEntity.getCategoryUuid())) {
            this.mConvertedEntity.setCategoryUuid(PredefinedCategory.UNCATEGORIZED.getUuid());
        } else {
            if (PredefinedCategory.SHARED_NOTE_BOOK.getUuid().equals(this.mConvertedEntity.getCategoryUuid())) {
                return;
            }
            this.mConvertedEntity.setCategoryUuid(this.mCategoryToFolderConverter.convert(this.mConvertedEntity.getCategoryUuid()));
        }
    }

    private void setPreviousFolderData() {
        if (TextUtils.isEmpty(this.mInfo.getFolderName())) {
            return;
        }
        this.mConvertedEntity.setCategoryUuid(this.mCategoryToFolderConverter.createNewFolder(this.mInfo.getFolderName(), sColorModel.getDefaultColor()));
    }

    private void updateConvertedEntity() {
        NotesDocumentEntity notesDocumentEntity;
        if (!this.mSaveConvertedNoteAsNewNote || (notesDocumentEntity = NotesDataRepositoryFactory.newInstance(this.mAppContext).createDocumentDataRepository().get(this.mOriginNoteUuid)) == null) {
            return;
        }
        DataLogger.m12302d(TAG, "updateConvertedEntity, originalEntity : " + notesDocumentEntity + ", mConvertedEntity : " + this.mConvertedEntity);
        notesDocumentEntity.setId(this.mConvertedEntity.getId());
        notesDocumentEntity.setUuid(this.mConvertedEntity.getUuid());
        notesDocumentEntity.setOriginUuid(this.mConvertedEntity.getOriginUuid());
        notesDocumentEntity.setFilePath(this.mConvertedEntity.getFilePath());
        notesDocumentEntity.setIsDeleted(0);
        notesDocumentEntity.setMdeItemId("");
        notesDocumentEntity.getTimeSaveParam().setTime(Long.valueOf(notesDocumentEntity.getCreatedAt()), Long.valueOf(notesDocumentEntity.getLastModifiedAt()));
        this.mConvertedDocument.getDocumentEntityContainer().setEntity(notesDocumentEntity);
        this.mConvertedEntity = notesDocumentEntity;
    }

    public void setCategoryToFolderConverter(@NonNull CategoryToFolderConverter categoryToFolderConverter) {
        this.mCategoryToFolderConverter = categoryToFolderConverter;
    }

    public void updateDocumentMappingData() {
        if (this.mIsConvertedFromOutside) {
            return;
        }
        NotesDataRepositoryFactory.newInstance(this.mAppContext).createMappedDocumentRepository().insert(this.mOriginNoteUuid, this.mConvertedNoteUuid, true);
    }

    public void updateEntity() {
        updateConvertedEntity();
        updateFolderData();
        updateImportData();
        updateLockData();
        updateDocumentMappingData();
        updateTagData();
    }

    public void updateFolderData() {
        if (this.mSaveConvertedNoteAsNewNote) {
            if (this.mIsConvertedFromOutside) {
                setPreviousFolderData();
            } else {
                setConvertedFolderData();
            }
        }
    }

    public void updateImportData() {
        if (this.mSaveConvertedNoteAsNewNote && this.mInfo.isImported()) {
            this.mConvertedEntity.setImported(true);
            this.mConvertedEntity.setImportedAt(System.currentTimeMillis());
        }
    }

    public void updateLockData() {
        int lockType = this.mInfo.getLockType();
        this.mConvertedDocument.getDocumentRepository().setLockAccountGuid(lockType == 5 ? RequestToSamsungAccountManager.INSTANCE.getUserIdHash() : "");
        this.mConvertedEntity.setIsLock(lockType);
        if (LockUtils.isLockedOtherDocType(lockType)) {
            return;
        }
        SpenWordDocument spenWordDocument = (SpenWordDocument) this.mConvertedDocument.getDoc();
        if (spenWordDocument.hasAttachedFile(Constants.SNote.WNOTE_LOCKED_FILE_KEY)) {
            spenWordDocument.detachFile(Constants.SNote.WNOTE_LOCKED_FILE_KEY);
            DataLogger.m12302d(TAG, "updateLockData, detachFile");
        }
    }

    public void updateTagData() {
        HashTagAccessHandler.HashTagAccessContract contract;
        if (this.mIsConvertedFromOutside || (contract = HashTagAccessHandler.getContract()) == null) {
            return;
        }
        List<HashTagData> hashTagData = contract.getHashTagData(this.mOriginNoteUuid);
        if (hashTagData.isEmpty()) {
            return;
        }
        new HashtagDataConverter().updateHashtag(this.mAppContext, this.mConvertedNoteUuid, hashTagData);
    }
}
