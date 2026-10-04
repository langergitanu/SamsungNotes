package com.samsung.android.support.senl.p148nt.model.repository.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.DataStrategy;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constants.WritingMode;
import com.samsung.android.support.senl.p148nt.base.common.util.DynamicTemplateUuidUtil;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtension;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.common.utils.DocumentCustomDataUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentFileUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentThumbnailEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyNoteEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.ConvertedDocumentUpdater;
import com.samsung.android.support.senl.p148nt.model.document.save.DocumentPostSaveOperation;
import com.samsung.android.support.senl.p148nt.model.document.save.ThumbnailCreator;
import com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentType;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.documents.data.MdeDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.SaveResult;
import com.samsung.android.support.senl.p148nt.model.documents.data.TagDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.VoiceRecordingDataSource;
import com.samsung.android.support.senl.p148nt.model.executor.task.utils.DocumentExtraDataUtils;
import com.samsung.android.support.senl.p148nt.model.repository.data.cover.DocumentCoverRepository;
import com.samsung.android.support.senl.p148nt.model.repository.data.pdf.PDFDataSource;
import com.samsung.android.support.senl.p148nt.model.repository.data.sticky.DocumentStickyRepository;
import com.samsung.android.support.senl.p148nt.model.repository.data.sticky.StickyDataSource;
import com.samsung.android.support.senl.p148nt.model.repository.data.tag.DocumentTagRepository;
import com.samsung.android.support.senl.p148nt.model.repository.data.voice.VoiceRecordingRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentSyncUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class NotesDocument<SpenDocument extends ISpenDocument> implements DocumentDataSource<SpenDocument, DocumentEntityContainer> {
    private CoverDataSource mCoverDataSource;
    private final DocumentRepository<SpenDocument, ? extends DocumentEntityContainer> mDocumentRepository;
    private boolean mIsContentChanged;
    private boolean mIsNew;
    private boolean mIsReservedDiscard;
    private long mLoadTime;
    private MdeDataSource mMdeDataSource;
    private PDFDataSource mPDFDataSource;
    private DocumentSchedulerDataSource mSchedulerDataSource;
    private StickyDataSource mStickyDataSource;
    private TagDataSource mTagDataSource;

    @Nullable
    private Boolean mTemporaryCacheSaved;
    private final List<String> mTemporaryChangedPageIdList;
    private VoiceRecordingDataSource mVoiceRecordingInfo;
    private int mWritingMode;
    private static final String TAG = ModelLogger.createTag("NotesDocument");
    public static final Parcelable.Creator<NotesDocument> CREATOR = new Parcelable.Creator<NotesDocument>() { // from class: com.samsung.android.support.senl.nt.model.repository.data.NotesDocument.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotesDocument createFromParcel(Parcel parcel) {
            return new NotesDocument(parcel, 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotesDocument[] newArray(int i) {
            return new NotesDocument[i];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavingLocker implements Closeable {
        private final NotesDocumentRepository mDocumentRepository;
        private final DocumentEntityContainer mEntityContainer;
        private final String mSdkCachePath;
        private final String mUuid;

        public SavingLocker(@NonNull Context context, String str, DocumentEntityContainer documentEntityContainer, int i, @NonNull String str2) {
            DataLogger.m12309w(NotesDocument.TAG, "SavingLocker - uuid : " + str + ", flag : " + i);
            this.mUuid = str;
            this.mEntityContainer = documentEntityContainer;
            this.mSdkCachePath = str2;
            documentEntityContainer.getEntity().setIsSavingByWhichPid(i);
            NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context.getApplicationContext()).createDocumentDataRepository();
            this.mDocumentRepository = notesDocumentRepositoryCreateDocumentDataRepository;
            notesDocumentRepositoryCreateDocumentDataRepository.updateSaving(str, i, documentEntityContainer.getEntity().getSize());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            DataLogger.m12309w(NotesDocument.TAG, "SavingLocker#close - uuid : " + this.mUuid + ", flag : 0");
            this.mDocumentRepository.updateSaving(this.mUuid, 0, StorageUtils.getDocumentSize(this.mSdkCachePath));
            this.mEntityContainer.getEntity().setIsSavingByWhichPid(0);
        }
    }

    public /* synthetic */ NotesDocument(Parcel parcel, int i) {
        this(parcel);
    }

    private boolean applyDatabase(@NonNull Context context, boolean z, boolean z2) {
        boolean zSaveToDatabase = true;
        if (!z2) {
            boolean forceUpdate = getDocumentEntityContainer().getEntity().getTimeSaveParam().getForceUpdate();
            if (z || (UUIDUtils.isCoeditUuid(getUuid()) && !forceUpdate)) {
                zSaveToDatabase = false;
            }
            zSaveToDatabase = saveToDatabase(context, zSaveToDatabase);
        }
        if (zSaveToDatabase) {
            setDirty(false);
        }
        return zSaveToDatabase;
    }

    private void clearTemporaryChangedPageIdList() {
        this.mTemporaryChangedPageIdList.clear();
    }

    @DocumentExtension
    private String convertToDocumentExtension(@NonNull DocumentType documentType) {
        return documentType == DocumentType.SPEN_SDOC ? ".sdoc" : ".sdocx";
    }

    private void deleteDatabase(@NonNull Context context) {
        String str = TAG;
        DataLogger.m12302d(str, "deleteDatabase, documentEntity Container : " + getDocumentRepository().getDocumentEntity());
        try {
            DataLogger.m12308p(str, "deleteDatabase - start");
            getDocumentRepository().deleteDocumentEntity(context);
            DataLogger.m12308p(str, "deleteDatabase - end");
        } catch (Throwable th) {
            DataLogger.m12308p(TAG, "deleteDatabase - end");
            throw th;
        }
    }

    private void fixStickyNotesInfo(@NonNull DocumentStickyRepository documentStickyRepository) {
        HashSet hashSet = new HashSet();
        for (SpenWPage spenWPage : ((SpenWNote) getDoc()).getPageList()) {
            int customObjectCount = spenWPage.getCustomObjectCount();
            for (int i = 0; i < customObjectCount; i++) {
                SpenCustomObject customObject = spenWPage.getCustomObject(i);
                if (customObject != null && (customObject instanceof SpenStickyNote)) {
                    StickyNoteEntity stickyNoteEntity = documentStickyRepository.get(customObject.getId());
                    if (stickyNoteEntity == null) {
                        stickyNoteEntity = new StickyNoteEntity();
                        stickyNoteEntity.setObjectId(customObject.getId());
                        stickyNoteEntity.setPageUuid(spenWPage.getId());
                        stickyNoteEntity.setDocumentUuid(getUuid());
                        documentStickyRepository.insert(Collections.singleton(stickyNoteEntity), false);
                    } else if (!stickyNoteEntity.getPageUuid().equals(spenWPage.getId())) {
                        DataLogger.m12307i(TAG, "fixStickyNotesInfo, update, id: " + stickyNoteEntity.getObjectId() + ", from: " + stickyNoteEntity.getPageUuid() + " > to: " + spenWPage.getId());
                        stickyNoteEntity.setPageUuid(spenWPage.getId());
                        documentStickyRepository.update(stickyNoteEntity);
                    }
                    hashSet.add(stickyNoteEntity.getObjectId());
                }
            }
        }
        Iterator it = ((Set) documentStickyRepository.getAllObjectIds().stream().filter(new C11462a(hashSet, 0)).collect(Collectors.toSet())).iterator();
        while (it.hasNext()) {
            documentStickyRepository.delete((String) it.next());
        }
    }

    private ArrayList<String> getChangedPageIdListForCollector() {
        ArrayList<String> arrayList = new ArrayList<>(getTemporaryChangedPageIdList());
        if (arrayList.isEmpty()) {
            setChangedPageIdListForCollector(arrayList);
        }
        return arrayList;
    }

    private String getHashCode() {
        return "#hashCode: " + Integer.toHexString(hashCode());
    }

    private String getSdkCachePath() {
        return ((SpenWNote) getDoc()).getInternalDirectory();
    }

    private List<String> getTemporaryChangedPageIdList() {
        return this.mTemporaryChangedPageIdList;
    }

    @Nullable
    private DocumentThumbnailEntity getThumbnailData(Context context, String str) {
        return NotesDataRepositoryFactory.newInstance(context.getApplicationContext()).createDocumentThumbnailRepository().getEntity(str);
    }

    private boolean isNeedToUpdateWidget(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z || z2) {
            return false;
        }
        return z3 || !z4;
    }

    private boolean isThumbnailDataChanged(@Nullable DocumentThumbnailEntity documentThumbnailEntity, @Nullable DocumentThumbnailEntity documentThumbnailEntity2) {
        if (documentThumbnailEntity == null) {
            return documentThumbnailEntity2 != null;
        }
        if (documentThumbnailEntity2 == null) {
            return false;
        }
        return (Objects.equals(documentThumbnailEntity.getImagePath(), documentThumbnailEntity2.getImagePath()) && Objects.equals(documentThumbnailEntity.getPlayTime(), documentThumbnailEntity2.getPlayTime()) && Integer.valueOf(documentThumbnailEntity.getBackgroundType()).equals(Integer.valueOf(documentThumbnailEntity2.getBackgroundType())) && Integer.valueOf(documentThumbnailEntity.getLayout()).equals(Integer.valueOf(documentThumbnailEntity2.getLayout()))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$fixStickyNotesInfo$0(Set set, String str) {
        return !set.contains(str);
    }

    private boolean notUpdateDatabase() {
        return getDocumentRepository().checkSaveStrategy(1024);
    }

    private SaveResult requestSaveSpenDocument(@NonNull Context context) {
        SaveResult saveResultSaveSpenDocument = saveSpenDocument();
        if (!saveResultSaveSpenDocument.isFileSaved() && isNew()) {
            deleteDatabase(context);
        }
        return saveResultSaveSpenDocument;
    }

    private void setChangedPageIdListForCollector(@NonNull List<String> list) {
        list.clear();
        ArrayList<String> changedPageIdList = getChangedPageIdList();
        if (changedPageIdList == null || changedPageIdList.isEmpty()) {
            return;
        }
        list.addAll(changedPageIdList);
    }

    private void setTemporaryChangedPageIdList() {
        setChangedPageIdListForCollector(getTemporaryChangedPageIdList());
    }

    private void updateAppCustomData() {
        if (DynamicTemplateUuidUtil.INSTANCE.isPostFixContained(getUuid())) {
            try {
                DocumentCustomDataUtils.updateDynamicTemplateData((SpenWNote) getDoc(), getUuid());
            } catch (JSONException e) {
                DataLogger.m12303e(TAG, "updateAppCustomData, e: " + e.getMessage());
            }
        }
    }

    private void updateConvertedInfo(Context context) {
        String oldUuid = getDocumentRepository().getOldUuid();
        if (TextUtils.isEmpty(oldUuid)) {
            return;
        }
        NotesDocumentEntity notesDocumentEntity = NotesDataRepositoryFactory.newInstance(context.getApplicationContext()).createDocumentDataRepository().get(oldUuid);
        new ConvertedDocumentUpdater(context, this, new ConvertInfo(getDocumentRepository().getLoadPath(), hashCode()).setUuid(oldUuid).setLockType((notesDocumentEntity == null || !LockUtils.isLockedSdocType(notesDocumentEntity.getIsLock())) ? 0 : 5).setIsImported(notesDocumentEntity == null)).updateEntity();
    }

    private void updateDataBaseAfterSaveFile(@NonNull Context context, @NonNull NotesDocumentEntity notesDocumentEntity) {
        NotesDataRepositoryFactory.newInstance(context).createDocumentExtraRepository().updateFormatVersion(notesDocumentEntity.getUuid(), SpenWNoteFile.getFormatVersion(notesDocumentEntity.getFilePath()));
    }

    private boolean updateDatabaseAfterFileSave() {
        return getDocumentRepository().checkSaveStrategy(524288);
    }

    private void updatePDFData() {
        PDFDataSource pDFDataSource = this.mPDFDataSource;
        if (pDFDataSource != null) {
            pDFDataSource.updateAttachedFile();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void clearChangedPageIdList() {
        ISpenDocument doc = getDoc();
        if (doc != null) {
            doc.clearChangedPageIdList();
        }
        clearTemporaryChangedPageIdList();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void clearVoiceRecordingInfo() {
        DataLogger.m12302d(TAG, "clearVoiceRecordingInfo");
        this.mVoiceRecordingInfo = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public DocumentDataSource<SpenDocument, DocumentEntityContainer> cloneDocument(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull Context context) {
        String strNewUUID = UUIDUtils.newUUID(context);
        DocumentRepository<SpenDocument, ? extends DocumentEntityContainer> documentRepository = getDocumentRepository();
        String strCreateSavedPath = NotesDocumentFileUtils.createSavedPath(context, strNewUUID, null, convertToDocumentExtension(documentRepository.getDocumentType()));
        DocumentRepository documentRepositoryCaller = getDocumentRepository().mo22197clone().setUuid(strNewUUID).loadPath(strCreateSavedPath).savePath(strCreateSavedPath).lockConfirm(documentRepository.getLockConfirm()).clearSaveStrategy().documentSubscriptionId(documentSubscriptionId).caller(documentRepository.getDocumentSubscriptionId().getUser());
        NotesDocumentEntity entity = documentRepositoryCaller.getDocumentEntity().getEntity();
        entity.setUuid(strNewUUID);
        entity.setFilePath(documentRepositoryCaller.getSavePath());
        entity.setIsDirty(1);
        NotesDocument notesDocument = new NotesDocument(context, documentRepositoryCaller, false);
        notesDocument.setNewDocument(true);
        notesDocument.setDirty(true);
        notesDocument.setDoc(documentRepository.getSpenDocument());
        VoiceRecordingDataSource voiceRecordingInfo = getVoiceRecordingInfo();
        if (voiceRecordingInfo != null) {
            notesDocument.setVoiceRecordingInfo(voiceRecordingInfo.getFilePath(), voiceRecordingInfo.getContentIndex());
        }
        return notesDocument;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void copy(DocumentDataSource documentDataSource) {
        NotesDocument notesDocument = (NotesDocument) documentDataSource;
        if (notesDocument == null) {
            return;
        }
        notesDocument.mVoiceRecordingInfo = this.mVoiceRecordingInfo;
        notesDocument.mIsNew = this.mIsNew;
        notesDocument.mIsContentChanged = this.mIsContentChanged;
        notesDocument.setTagDataSource(this.mTagDataSource);
        notesDocument.setMdeDataSource(this.mMdeDataSource);
        notesDocument.setMode(this.mWritingMode);
        notesDocument.setCoverDataSource(this.mCoverDataSource);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void createThumbnail(Context context) {
        getDocumentRepository().createThumbnail(context);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public ArrayList<String> getChangedPageIdList() {
        ISpenDocument doc = getDoc();
        if (doc == null) {
            return null;
        }
        return doc.getChangedPageIdList();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public CoverDataSource getCoverDataSource() {
        return this.mCoverDataSource;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public SpenDocument getDoc() {
        DocumentRepository<SpenDocument, ? extends DocumentEntityContainer> documentRepository = this.mDocumentRepository;
        if (documentRepository != null) {
            return (SpenDocument) documentRepository.getSpenDocument();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    @NonNull
    public DocumentEntityContainer getDocumentEntityContainer() {
        return getDocumentRepository().getDocumentEntity();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    @NonNull
    public DocumentRepository<SpenDocument, ? extends DocumentEntityContainer> getDocumentRepository() {
        return this.mDocumentRepository;
    }

    public String getKey() {
        return getDocumentRepository().getUuid();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public String getLoadPath() {
        return getDocumentRepository().getLoadPath();
    }

    public long getLoadTime() {
        return this.mLoadTime;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public String getLockConfirm() {
        return getDocumentRepository().getLockConfirm();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public MdeDataSource getMdeDataSource() {
        DataLogger.m12302d(TAG, "getMdeDataSource() : " + this.mMdeDataSource);
        return this.mMdeDataSource;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public String getPath() {
        return getDocumentRepository().getSavePath();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    @Nullable
    public DocumentSchedulerDataSource getScheduler() {
        return this.mSchedulerDataSource;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    @NonNull
    public StickyDataSource getStickyDataSource() {
        return this.mStickyDataSource;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    @NonNull
    public DocumentSubscriptionId getSubscriptionId() {
        DataLogger.m12307i(TAG, "getSubscriptionId : " + getDocumentRepository().getDocumentSubscriptionId());
        return getDocumentRepository().getDocumentSubscriptionId();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public TagDataSource getTagDataSource() {
        return this.mTagDataSource;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    @NonNull
    public String getUuid() {
        return getDocumentRepository().getUuid();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public VoiceRecordingDataSource getVoiceRecordingInfo() {
        return this.mVoiceRecordingInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    @WritingMode
    public int getWritingMode() {
        return this.mWritingMode;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean isChangedOnlyThumbnail() {
        ISpenDocument doc = getDoc();
        if (doc == null) {
            DataLogger.m12307i(TAG, "isChangedOnlyThumbnail, getDoc is null");
            return false;
        }
        DataLogger.m12307i(TAG, "isChangedOnlyThumbnail, getDoc().isChangedOnlyThumbnail() : " + doc.isChangedOnlyThumbnail());
        return !this.mIsContentChanged && doc.isChangedOnlyThumbnail();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean isContentChanged() {
        ISpenDocument doc = getDoc();
        if (doc == null) {
            DataLogger.m12307i(TAG, "isContentChanged, getDoc is null");
            return false;
        }
        DataLogger.m12307i(TAG, "isContentChanged, mIsContentChanged : " + this.mIsContentChanged + ", getDoc().isContentChanged() : " + doc.isContentChanged());
        return this.mIsContentChanged || doc.isContentChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean isContentEmpty() {
        String str = TAG;
        DataLogger.m12302d(str, "isContentEmpty, doc : " + getDoc());
        if (getDoc() != null && !getDoc().isClosed()) {
            return getDoc().isContentEmpty();
        }
        DataLogger.m12302d(str, "isContentEmpty, already closed");
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean isCoverChanged() {
        return getCoverDataSource() != null && getCoverDataSource().isChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean isDiscarded() {
        return this.mIsReservedDiscard;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean isEntityChanged() {
        return getDocumentEntityContainer().isChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean isLocked() {
        return getDocumentRepository().getDocumentEntity().getEntity().getIsLock() == 5;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean isNew() {
        return this.mIsNew;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean isSaveCache() {
        return getDoc() != null && getDoc().isSaveCache();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean isStickyNoteChanged() {
        return getStickyDataSource().getIsChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean isTagChanged() {
        return getTagDataSource() != null && getTagDataSource().isChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void reserveDiscard(boolean z) {
        this.mIsReservedDiscard = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0188 A[Catch: all -> 0x00b3, TryCatch #0 {all -> 0x00b3, blocks: (B:7:0x0097, B:9:0x00a5, B:13:0x00bb, B:15:0x0119, B:16:0x0131, B:18:0x013c, B:20:0x0146, B:28:0x0182, B:30:0x0188, B:32:0x018f, B:23:0x0153, B:25:0x0161, B:27:0x017e), top: B:63:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0201  */
    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SaveResult save(@NonNull Context context) throws Throwable {
        SavingLocker savingLocker;
        ArrayList<String> arrayList;
        boolean z;
        boolean zApplyDatabase;
        SaveResult saveResultRequestSaveSpenDocument;
        SaveResult saveResult;
        boolean z2;
        boolean zIsNeedToUpdateWidget;
        boolean z3;
        ArrayList<String> arrayList2;
        String str = TAG;
        DataLogger.m12307i(str, "save, try to save, document hashCode: " + Integer.toHexString(hashCode()) + ", isContentChanged : " + isContentChanged() + ", isChangedOnlyThumbnail : " + isChangedOnlyThumbnail() + ", DO_NOT_UPDATE_DATABASE : " + getDocumentRepository().checkSaveStrategy(1024));
        if (this.mWritingMode != 0) {
            SaveResult saveResultSaveSpenDocument = saveSpenDocument();
            DataLogger.m12307i(str, "save, result : " + saveResultSaveSpenDocument);
            return saveResultSaveSpenDocument;
        }
        ArrayList<String> changedPageIdListForCollector = getChangedPageIdListForCollector();
        SavingLocker savingLocker2 = new SavingLocker(context, getUuid(), getDocumentEntityContainer(), Process.myPid(), getSdkCachePath());
        try {
            boolean zIsChanged = getDocumentEntityContainer().isChanged();
            boolean zIsChangedOnlyThumbnail = isChangedOnlyThumbnail();
            boolean zIsSaveCache = isSaveCache();
            boolean zNotUpdateDatabase = notUpdateDatabase();
            boolean zIsTagChanged = isTagChanged();
            boolean zIsCoverChanged = isCoverChanged();
            boolean zIsStickyNoteChanged = isStickyNoteChanged();
            boolean zUpdateDatabaseAfterFileSave = updateDatabaseAfterFileSave();
            savingLocker = savingLocker2;
            try {
                boolean zCheckSaveStrategy = getDocumentRepository().checkSaveStrategy(32768);
                DocumentThumbnailEntity thumbnailData = getThumbnailData(context, getUuid());
                if (zIsChangedOnlyThumbnail) {
                    arrayList = changedPageIdListForCollector;
                    z = zUpdateDatabaseAfterFileSave;
                    getDocumentRepository().removeSaveStrategy(65536);
                } else {
                    arrayList = changedPageIdListForCollector;
                    z = zUpdateDatabaseAfterFileSave;
                }
                DataLogger.m12307i(str, "save, doNotSaveDatabase: " + zNotUpdateDatabase + ", isEntityChanged: " + zIsChanged + ", isSaveCache: " + zIsSaveCache + ", isChangedOnlyThumbnail: " + zIsChangedOnlyThumbnail + ", isTagChanged: " + zIsTagChanged + ", isCoverChanged: " + zIsCoverChanged + ", isStickyChanged: " + zIsStickyNoteChanged + ", doNotUpdateWidget: " + zCheckSaveStrategy);
                updateConvertedInfo(context);
                updateAppCustomData();
                getDocumentRepository().adjustDocument(getDocumentRepository().getAdjustData());
                if (zIsChangedOnlyThumbnail) {
                    getDocumentRepository().addSaveStrategy(4096);
                    NotesDocumentSyncUtils.setDocumentEntitySyncSkipped(getDocumentRepository().getDocumentEntity().getEntity());
                }
                NotesDocumentEntity entity = getDocumentEntityContainer().getEntity();
                if (z) {
                    saveResultRequestSaveSpenDocument = requestSaveSpenDocument(context);
                    if (!saveResultRequestSaveSpenDocument.isFileSaved()) {
                        saveResult = saveResultRequestSaveSpenDocument;
                        z2 = false;
                        zIsNeedToUpdateWidget = !saveResult.isFileSaved() ? isNeedToUpdateWidget(zCheckSaveStrategy, zNotUpdateDatabase, zIsSaveCache, zIsChangedOnlyThumbnail) : false;
                        saveResult.setIsDBSaved(z2);
                        z3 = (saveResult.get() || zNotUpdateDatabase || (zIsChangedOnlyThumbnail && !zIsTagChanged)) ? false : true;
                        savingLocker.close();
                        if (z3) {
                            arrayList2 = arrayList;
                        } else {
                            DataStrategy dataStrategy = new DataStrategy(60);
                            if (getDocumentRepository().checkSaveStrategy(262144)) {
                                dataStrategy.remove(8);
                            }
                            arrayList2 = arrayList;
                            DataRepositoryScheduler.runnable(new DocumentPostSaveOperation(context, isNew(), entity, arrayList2, DocumentSubscriptionId.COMPOSER_SERVICE_ID.getUser().equals(getSubscriptionId().getUser()) ? 0 : -1).setStrategy(dataStrategy.getMStrategy())).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
                            setNewDocument(false);
                        }
                        if (zIsNeedToUpdateWidget) {
                            DataRepositoryScheduler.runnable(new DocumentPostSaveOperation(context, getDocumentRepository().isNewDocument(), getDocumentEntityContainer().getEntity(), arrayList2).setStrategy(2)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
                        }
                        clearChangedPageIdList();
                        DataLogger.m12307i(str, "save, result : " + saveResult + ", needToUpdateWidget : " + zIsNeedToUpdateWidget);
                        return saveResult;
                    }
                    zApplyDatabase = applyDatabase(context, zIsChangedOnlyThumbnail, zNotUpdateDatabase);
                } else {
                    zApplyDatabase = applyDatabase(context, zIsChangedOnlyThumbnail, zNotUpdateDatabase);
                    saveResultRequestSaveSpenDocument = requestSaveSpenDocument(context);
                    if (saveResultRequestSaveSpenDocument.isFileSaved()) {
                        NotesDocumentEntity entity2 = getDocumentRepository().getDocumentEntity().getEntity();
                        updateDataBaseAfterSaveFile(context, entity2);
                        if (isThumbnailDataChanged(thumbnailData, getThumbnailData(context, getUuid()))) {
                            ThumbnailCreator.sendForceUpdateBroadcast(context, entity2);
                        }
                    }
                }
                boolean z4 = zApplyDatabase;
                saveResult = saveResultRequestSaveSpenDocument;
                z2 = z4;
                if (!saveResult.isFileSaved()) {
                }
                saveResult.setIsDBSaved(z2);
                if (saveResult.get()) {
                }
                savingLocker.close();
                if (z3) {
                }
                if (zIsNeedToUpdateWidget) {
                }
                clearChangedPageIdList();
                DataLogger.m12307i(str, "save, result : " + saveResult + ", needToUpdateWidget : " + zIsNeedToUpdateWidget);
                return saveResult;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                try {
                    savingLocker.close();
                    throw th2;
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            savingLocker = savingLocker2;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean saveAutoTitle(@NonNull Context context) {
        return getDocumentRepository().saveAutoTitle(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public SaveResult saveCache(@NonNull Context context) {
        SaveResult saveResultSaveCacheSpenDocument;
        if (this.mWritingMode == 100) {
            DataLogger.m12307i(TAG, "saveCache, try to save in PDF Writing mode, document hashCode: " + Integer.toHexString(hashCode()) + ", isContentChanged : " + isContentChanged());
            updatePDFData();
            saveResultSaveCacheSpenDocument = saveCacheSpenDocument();
            if (saveResultSaveCacheSpenDocument.get()) {
                setDirty(false);
            }
            DocumentCacheUtils.savePDFWriterCacheDat(context, getUuid(), this);
        } else {
            boolean zNotUpdateDatabase = notUpdateDatabase();
            boolean zIsChangedOnlyThumbnail = isChangedOnlyThumbnail();
            String str = TAG;
            DataLogger.m12307i(str, "saveCache, try to save, document hashCode: " + Integer.toHexString(hashCode()) + ", isContentChanged : " + isContentChanged() + ", isChangedOnlyThumbnail : " + isChangedOnlyThumbnail() + ", DO_NOT_UPDATE_DATABASE : " + getDocumentRepository().checkSaveStrategy(1024));
            SavingLocker savingLocker = new SavingLocker(context, getUuid(), getDocumentEntityContainer(), Process.myPid(), getSdkCachePath());
            try {
                setTemporaryChangedPageIdList();
                updateAppCustomData();
                getDocumentRepository().removeSaveStrategy(65536);
                DataLogger.m12307i(str, "saveCache, doNotSaveDatabase: " + zNotUpdateDatabase + ", isChangedOnlyThumbnail : " + zIsChangedOnlyThumbnail);
                if (zIsChangedOnlyThumbnail) {
                    getDocumentRepository().addSaveStrategy(4096);
                    NotesDocumentSyncUtils.setDocumentEntitySyncSkipped(getDocumentRepository().getDocumentEntity().getEntity());
                }
                boolean zApplyDatabase = applyDatabase(context, zIsChangedOnlyThumbnail, zNotUpdateDatabase);
                saveResultSaveCacheSpenDocument = saveCacheSpenDocument();
                if (!saveResultSaveCacheSpenDocument.isFileSaved() && isNew()) {
                    deleteDatabase(context);
                }
                saveResultSaveCacheSpenDocument.setIsDBSaved(zApplyDatabase);
                DocumentCacheUtils.saveDocumentDat(context, getUuid(), this);
                if (saveResultSaveCacheSpenDocument.get()) {
                    DocumentExtraDataUtils.save(context, this, false);
                }
                savingLocker.close();
                if (saveResultSaveCacheSpenDocument.get() && !zNotUpdateDatabase && !zIsChangedOnlyThumbnail) {
                    DataRepositoryScheduler.runnable(new DocumentPostSaveOperation(context, isNew(), getDocumentEntityContainer().getEntity(), null).setStrategy(18)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
                    setNewDocument(false);
                }
            } finally {
            }
        }
        DataLogger.m12307i(TAG, "saveCache, result : " + saveResultSaveCacheSpenDocument);
        return saveResultSaveCacheSpenDocument;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public SaveResult saveCacheSpenDocument() {
        String str = TAG;
        DataLogger.m12302d(str, "saveCacheSpenDocument");
        try {
            DataLogger.m12308p(str, "saveCacheSpenDocument spen document - start");
            SaveResult saveResultSaveCacheSpenDocument = getDocumentRepository().saveCacheSpenDocument();
            DataLogger.m12308p(str, "saveCacheSpenDocument spen document - end");
            return saveResultSaveCacheSpenDocument;
        } catch (Throwable th) {
            DataLogger.m12308p(TAG, "saveCacheSpenDocument spen document - end");
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void saveCoverData(@NonNull Context context) {
        String str = TAG;
        DataLogger.m12302d(str, "saveCoverData - start");
        ((DocumentCoverRepository) getCoverDataSource()).save(context, getUuid());
        DataLogger.m12302d(str, "saveCoverData - end");
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public SaveResult saveSpenDocument() {
        String str = TAG;
        DataLogger.m12302d(str, "saveSpenDocument");
        try {
            DataLogger.m12308p(str, "saveSpenDocument spen document - start");
            SaveResult saveResultSaveSpenDocument = getDocumentRepository().saveSpenDocument();
            DataLogger.m12308p(str, "saveSpenDocument spen document - end");
            return saveResultSaveSpenDocument;
        } catch (Throwable th) {
            DataLogger.m12308p(TAG, "saveSpenDocument spen document - end");
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void saveStickyNotes(@NonNull Context context) {
        String str = TAG;
        DataLogger.m12302d(str, "saveStickyNotes - start");
        DocumentStickyRepository documentStickyRepository = (DocumentStickyRepository) getStickyDataSource();
        fixStickyNotesInfo(documentStickyRepository);
        documentStickyRepository.save(context);
        DataLogger.m12302d(str, "saveStickyNotes - end");
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean saveTagDataSource(@NonNull Context context) {
        if (!isTagChanged()) {
            return false;
        }
        try {
            String str = TAG;
            DataLogger.m12302d(str, "saveTagDataSource - start");
            boolean zSave = ((DocumentTagRepository) getTagDataSource()).save(context, getUuid());
            DataLogger.m12302d(str, "saveTagDataSource - end");
            return zSave;
        } catch (Throwable th) {
            DataLogger.m12302d(TAG, "saveTagDataSource - end");
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public boolean saveToDatabase(@NonNull Context context, boolean z) {
        String str = TAG;
        DataLogger.m12308p(str, "save entity to database - start");
        DataLogger.m12302d(str, "saveToDatabase, updateModifiedTime : " + z);
        boolean zSaveDocumentEntity = getDocumentRepository().saveDocumentEntity(context, this, z);
        DataLogger.m12308p(str, "save entity to database - end");
        if (zSaveDocumentEntity) {
            DataLogger.m12308p(str, "save tag entity to database - start");
            getTagDataSource().save(context, getUuid());
            DataLogger.m12308p(str, "save tag entity to database - end");
            setDirty(false);
            getDocumentRepository().updateOriginalEntityWithLatest();
        }
        DataLogger.m12302d(str, "saveToDatabase, result : " + zSaveDocumentEntity);
        return zSaveDocumentEntity;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void setAllPageIdList() {
        ISpenDocument doc = getDoc();
        if (doc == null) {
            return;
        }
        doc.setAllPageIdList();
    }

    public void setCoverDataSource(CoverDataSource coverDataSource) {
        if (coverDataSource == null) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext == null) {
                return;
            } else {
                coverDataSource = new DocumentCoverRepository(applicationContext, getUuid());
            }
        }
        this.mCoverDataSource = coverDataSource;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void setDirty(boolean z) {
        DataLogger.m12302d(TAG, "setDirty# dirty: " + z);
        this.mIsContentChanged = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void setDoc(SpenDocument spendocument) {
        if (spendocument != null) {
            DataLogger.m12302d(TAG, "setDoc, doc hashCode: " + Integer.toHexString(spendocument.hashCode()) + ", mTemporaryCacheSaved : " + this.mTemporaryCacheSaved);
            Boolean bool = this.mTemporaryCacheSaved;
            if (bool != null) {
                spendocument.setSaveCache(bool.booleanValue());
                this.mTemporaryCacheSaved = null;
            }
        }
        DocumentRepository<SpenDocument, ? extends DocumentEntityContainer> documentRepository = this.mDocumentRepository;
        if (documentRepository != null) {
            documentRepository.setDocument(spendocument);
        }
    }

    public void setLoadTime(long j, @Nullable String str) {
        AbstractC11014a.m12334s("setLoadTime, message: ", str, TAG);
        this.mLoadTime = j;
    }

    public void setLockConfirm(String str) {
        getDocumentRepository().lockConfirm(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void setMdeDataSource(MdeDataSource mdeDataSource) {
        DataLogger.m12302d(TAG, "setMdeDataSource() : " + mdeDataSource);
        this.mMdeDataSource = mdeDataSource;
    }

    public void setMode(@WritingMode int i) {
        this.mWritingMode = i;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void setNewDocument(boolean z) {
        this.mIsNew = z;
    }

    public void setPDFDataSource(PDFDataSource pDFDataSource) {
        this.mPDFDataSource = pDFDataSource;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void setScheduler(DocumentSchedulerDataSource documentSchedulerDataSource) {
        this.mSchedulerDataSource = documentSchedulerDataSource;
    }

    public void setStickyDataSource(@NonNull StickyDataSource stickyDataSource) {
        this.mStickyDataSource = stickyDataSource;
    }

    public void setTagDataSource(TagDataSource tagDataSource) {
        this.mTagDataSource = tagDataSource;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public void setVoiceRecordingInfo(String str, int i) {
        setVoiceRecordingInfo(str, i, 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public SaveResult snapSave(@NonNull Context context) {
        String str = TAG;
        DataLogger.m12307i(str, "snapSave, try to save, document hashCode: " + Integer.toHexString(hashCode()) + ", isContentChanged : " + isContentChanged() + ", isChangedOnlyThumbnail : " + isChangedOnlyThumbnail());
        SavingLocker savingLocker = new SavingLocker(context, getUuid(), getDocumentEntityContainer(), Process.myPid(), getSdkCachePath());
        try {
            boolean zIsChangedOnlyThumbnail = isChangedOnlyThumbnail();
            setTemporaryChangedPageIdList();
            updateAppCustomData();
            getDocumentRepository().removeSaveStrategy(65536);
            DataLogger.m12307i(str, "snapSave, isChangedOnlyThumbnail : " + zIsChangedOnlyThumbnail);
            SaveResult saveResultSnapSaveSpenDocument = snapSaveSpenDocument();
            if (saveResultSnapSaveSpenDocument.isFileSaved()) {
                setDirty(false);
                if (this.mWritingMode == 100) {
                    DocumentCacheUtils.savePDFWriterCacheDat(context, getUuid(), this);
                } else {
                    DocumentCacheUtils.saveDocumentDat(context, getUuid(), this);
                }
            }
            DataLogger.m12307i(str, "snapSave, result : " + saveResultSnapSaveSpenDocument);
            savingLocker.close();
            return saveResultSnapSaveSpenDocument;
        } finally {
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource
    public SaveResult snapSaveSpenDocument() {
        String str = TAG;
        DataLogger.m12302d(str, "snapSaveSpenDocument");
        try {
            DataLogger.m12308p(str, "snapSaveSpenDocument spen document - start");
            SaveResult saveResultSnapSaveSpenDocument = getDocumentRepository().snapSaveSpenDocument();
            DataLogger.m12308p(str, "snapSaveSpenDocument spen document - end");
            return saveResultSnapSaveSpenDocument;
        } catch (Throwable th) {
            DataLogger.m12308p(TAG, "snapSaveSpenDocument spen document - end");
            throw th;
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("NotesDocument - ");
        sb.append(getHashCode());
        sb.append(" {mUuid: ");
        sb.append(getUuid());
        sb.append(", mIsNew: ");
        sb.append(this.mIsNew);
        sb.append(", mIsContentChanged: ");
        sb.append(this.mIsContentChanged);
        sb.append(", mDoc: ");
        sb.append(getDoc());
        sb.append(", mDoc.isClosed: ");
        sb.append(getDoc() == null ? "null" : Boolean.valueOf(getDoc().isClosed()));
        sb.append(", mPath: ");
        sb.append(DataLogger.getEncode(getPath()));
        sb.append(", mLoadPath: ");
        sb.append(DataLogger.getEncode(getLoadPath()));
        sb.append(", mWritingMode: ");
        sb.append(this.mWritingMode);
        sb.append(", mDocumentUser: ");
        sb.append(getSubscriptionId());
        sb.append(", mIsSaveCache : ");
        sb.append(isSaveCache());
        sb.append(", mLockConfirm: ");
        sb.append(getLockConfirm());
        sb.append(", mTagDataSource: ");
        sb.append(this.mTagDataSource);
        sb.append(", mCoverDataSource: ");
        sb.append(this.mCoverDataSource);
        sb.append(", mIsReservedDiscard");
        sb.append(this.mIsReservedDiscard);
        sb.append(", mMdeDataSource : ");
        sb.append(this.mMdeDataSource);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        String str = TAG;
        DataLogger.m12309w(str, "@--- DOCUMENT write parcelable start");
        parcel.writeParcelable(this.mVoiceRecordingInfo, i);
        parcel.writeInt(this.mIsNew ? 1 : 0);
        parcel.writeInt(this.mIsContentChanged ? 1 : 0);
        parcel.writeLong(this.mLoadTime);
        parcel.writeParcelable(this.mDocumentRepository, i);
        parcel.writeParcelable(this.mTagDataSource, i);
        parcel.writeParcelable(this.mMdeDataSource, i);
        parcel.writeInt(isSaveCache() ? 1 : 0);
        parcel.writeInt(this.mWritingMode);
        parcel.writeParcelable(this.mCoverDataSource, i);
        DataLogger.m12309w(str, "@--- DOCUMENT write parcelable end");
    }

    public NotesDocument(@NonNull Context context, @NonNull DocumentRepository<SpenDocument, ? extends DocumentEntityContainer> documentRepository) {
        this(context, documentRepository, true);
    }

    public void setVoiceRecordingInfo(String str, int i, int i2) {
        String str2 = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "setVoiceRecordingInfo# contentIndex: ", ", voiceRecordingPath: ");
        sbM778t.append(DataLogger.getEncode(str));
        DataLogger.m12302d(str2, sbM778t.toString());
        clearVoiceRecordingInfo();
        if (TextUtils.isEmpty(str) || i <= -1) {
            return;
        }
        this.mVoiceRecordingInfo = new VoiceRecordingRepository(str, i, i2);
    }

    public NotesDocument(@NonNull Context context, @NonNull DocumentRepository<SpenDocument, ? extends DocumentEntityContainer> documentRepository, boolean z) {
        this.mStickyDataSource = new DocumentStickyRepository();
        this.mTemporaryChangedPageIdList = new ArrayList();
        this.mDocumentRepository = documentRepository;
        this.mWritingMode = documentRepository != null ? documentRepository.getWritingMode() : 0;
        setTagDataSource(new DocumentTagRepository());
        setCoverDataSource(new DocumentCoverRepository(context, getUuid()));
        if (z) {
            documentRepository.loadDatabase(context);
        }
        DataLogger.m12302d(TAG, "NotesDocument, " + getHashCode());
    }

    private NotesDocument(Parcel parcel) {
        this.mStickyDataSource = new DocumentStickyRepository();
        this.mTemporaryChangedPageIdList = new ArrayList();
        String str = TAG;
        DataLogger.m12309w(str, "@--- DOCUMENT read parcelable start");
        this.mVoiceRecordingInfo = (VoiceRecordingDataSource) parcel.readParcelable(VoiceRecordingDataSource.class.getClassLoader());
        this.mIsNew = parcel.readInt() == 1;
        this.mIsContentChanged = parcel.readInt() == 1;
        this.mLoadTime = parcel.readLong();
        this.mDocumentRepository = (DocumentRepository) parcel.readParcelable(DocumentRepository.class.getClassLoader());
        this.mTagDataSource = (TagDataSource) parcel.readParcelable(TagDataSource.class.getClassLoader());
        this.mMdeDataSource = (MdeDataSource) parcel.readParcelable(MdeDataSource.class.getClassLoader());
        this.mTemporaryCacheSaved = parcel.readInt() == 1 ? Boolean.TRUE : null;
        this.mWritingMode = parcel.readInt();
        setCoverDataSource((CoverDataSource) parcel.readParcelable(CoverDataSource.class.getClassLoader()));
        DataLogger.m12302d(str, "mTemporaryCacheSaved : " + this.mTemporaryCacheSaved);
        DataLogger.m12309w(str, "@--- DOCUMENT read parcelable end");
    }
}
