package com.samsung.android.support.senl.p148nt.composer.main.base.model.data;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.InternalImportHandler;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.document.save.DocumentDBSaver;
import com.samsung.android.support.senl.p148nt.model.document.save.ThumbnailCreator;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.sticky.StickyDataSource;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesDocEntityManager implements Observer<NotesDocumentEntity> {
    private static final String TAG = Logger.createTag("NotesDocEntityManager");
    private NotesDocument<SpenWordDocument> mDocState;
    private NotesDocumentEntity mNotesDocumentEntity;
    private final NotesDocumentRepository mNotesDocumentRepository;
    private NotesDocumentEntity mOldNotesDocumentEntity;
    private OnRemovedListener mOnRemovedListener;
    private OnTitleDataChangedListener mOnTitleDataChangedListener;
    private final NotesDataRepositoryFactory mRepositoryFactory;
    private final SyncConflictDataManager mSyncConflictManager;
    private String mUuid;
    private boolean mIsSkipOnRemovedListener = false;
    private long mCreatedTime = 0;
    private long mLastModifiedTime = 0;
    private LiveData<NotesDocumentEntity> mLiveDataNotesDoc = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnRemovedListener {
        void onRemoved();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnTitleDataChangedListener {
        void onChangedCreatedTime(long j);

        void onChangedFavorite(boolean z);

        void onChangedFolder(String str);

        void onChangedLastModifiedTime(long j);

        void onChangedLockState(int i);

        void onDeletedFolder();
    }

    public NotesDocEntityManager(NotesDataRepositoryFactory notesDataRepositoryFactory) {
        this.mRepositoryFactory = notesDataRepositoryFactory;
        this.mNotesDocumentRepository = notesDataRepositoryFactory.createDocumentDataRepository();
        this.mSyncConflictManager = new SyncConflictDataManager(notesDataRepositoryFactory);
    }

    private boolean checkInValidEntity() {
        if (!DeviceInfo.isUserMode() || this.mNotesDocumentEntity != null) {
            return false;
        }
        Logger.m11000e(TAG, "checkValidEntity  mNotesDocumentEntity is null");
        return true;
    }

    private void keepCurrentStatus(NotesDocumentEntity notesDocumentEntity) {
        if (notesDocumentEntity.getMathMode() == this.mNotesDocumentEntity.getMathMode()) {
            return;
        }
        Logger.m11003i(TAG, "keepCurrentStatus, mathMode: " + this.mNotesDocumentEntity.getMathMode());
        notesDocumentEntity.setMathMode(this.mNotesDocumentEntity.getMathMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOpenedTime$0(String str) {
        this.mNotesDocumentRepository.setOpenedTime(str);
    }

    private void releaseObserver() {
        LiveData<NotesDocumentEntity> liveData = this.mLiveDataNotesDoc;
        if (liveData != null) {
            liveData.removeObserver(this);
        }
        this.mSyncConflictManager.removeObserverIsConflicted();
    }

    private void setDeleteState(int i) {
        String folderAbsolutePath;
        if (checkInValidEntity() || (folderAbsolutePath = FolderDataManager.getFolderAbsolutePath(getFolderUuid())) == null) {
            return;
        }
        this.mNotesDocumentEntity.setIsDeleted(i);
        this.mNotesDocumentEntity.setAbsolutePath(folderAbsolutePath);
        this.mNotesDocumentEntity.setRecycleBinTimeMoved(System.currentTimeMillis());
        setFolderUuid(PredefinedCategory.RECYCLE_BIN.getUuid());
    }

    private void updateDocumentEntity(@NonNull NotesDocumentEntity notesDocumentEntity) {
        try {
            this.mDocState.getDocumentEntityContainer().setEntity(notesDocumentEntity);
            this.mDocState.getDocumentEntityContainer().updateOriginalEntityWithLatest();
            this.mOldNotesDocumentEntity = this.mNotesDocumentEntity;
            this.mNotesDocumentEntity = notesDocumentEntity;
        } catch (CloneNotSupportedException e) {
            Logger.m11000e(TAG, "updateDocumentEntity, e : " + e.getMessage());
        }
    }

    private void updateEntityFromDocState(NotesDocument<SpenWordDocument> notesDocument) {
        NotesDocumentEntity entity = notesDocument.getDocumentEntityContainer().getEntity();
        NotesDocument<SpenWordDocument> notesDocument2 = this.mDocState;
        if (notesDocument2 != null && notesDocument2.getUuid().equals(notesDocument.getUuid()) && !isExist() && this.mNotesDocumentEntity != null) {
            Logger.m11003i(TAG, "updateEntityFromDocState#");
            entity.setIsFavorite(this.mNotesDocumentEntity.getIsFavorite());
            entity.setMathMode(this.mNotesDocumentEntity.getMathMode());
        }
        this.mNotesDocumentEntity = entity;
    }

    public void connectObserver(@NonNull String str, LifecycleOwner lifecycleOwner) {
        if (this.mLiveDataNotesDoc == null) {
            initNoteDocEntity(str, lifecycleOwner);
        }
        this.mSyncConflictManager.connectObserver(str, lifecycleOwner);
    }

    public long getCreatedTime() {
        NotesDocumentEntity notesDocumentEntity = this.mNotesDocumentEntity;
        if (notesDocumentEntity != null) {
            return notesDocumentEntity.getCreatedAt();
        }
        NotesDocument<SpenWordDocument> notesDocument = this.mDocState;
        if (notesDocument != null) {
            return ((SpenWordDocument) notesDocument.getDoc()).getCreatedTime();
        }
        return 0L;
    }

    public int getFolderColor(int i) {
        return FolderDataManager.getFolderColor(getFolderUuid(), i);
    }

    public String getFolderName(String str) {
        return FolderDataManager.getFolderName(getFolderUuid(), str);
    }

    public String getFolderUuid() {
        NotesDocumentEntity notesDocumentEntity = this.mNotesDocumentEntity;
        if (notesDocumentEntity != null) {
            return notesDocumentEntity.getCategoryUuid();
        }
        Logger.m11000e(TAG, "getFolderUuid# null");
        return "";
    }

    public long getLastModifiedTime() {
        this.mLastModifiedTime = 0L;
        NotesDocumentEntity notesDocumentEntity = this.mNotesDocumentEntity;
        if (notesDocumentEntity != null) {
            this.mLastModifiedTime = notesDocumentEntity.getLastModifiedAt();
        } else {
            NotesDocument<SpenWordDocument> notesDocument = this.mDocState;
            if (notesDocument != null) {
                this.mLastModifiedTime = ((SpenWordDocument) notesDocument.getDoc()).getModifiedTime();
            }
        }
        return this.mLastModifiedTime;
    }

    public String getLockAccountGuid() {
        return checkInValidEntity() ? "" : this.mNotesDocumentEntity.getLockAccountGuid();
    }

    public NotesDocumentEntity getNotesDocumentEntity() {
        return this.mNotesDocumentEntity;
    }

    public NotesDocumentRepository getNotesDocumentRepository() {
        return this.mNotesDocumentRepository;
    }

    public long getRecycleBinTimeMoved() {
        NotesDocumentEntity notesDocumentEntity = this.mNotesDocumentEntity;
        if (notesDocumentEntity == null) {
            return 0L;
        }
        return notesDocumentEntity.getRecycleBinTimeMoved();
    }

    @NonNull
    public NotesDataRepositoryFactory getRepositoryFactory() {
        return this.mRepositoryFactory;
    }

    public long getServerTimeStamp() {
        Long serverTimestamp;
        if (checkInValidEntity() || (serverTimestamp = this.mNotesDocumentEntity.getServerTimestamp()) == null) {
            return 0L;
        }
        return serverTimestamp.longValue();
    }

    public long getServerTimeStampFromRepository() {
        return this.mNotesDocumentRepository.get(this.mDocState.getUuid()).getServerTimestamp().longValue();
    }

    @NonNull
    public StickyDataSource getStickyNoteRepository() {
        return this.mDocState.getStickyDataSource();
    }

    public SyncConflictDataManager getSyncConflictManager() {
        return this.mSyncConflictManager;
    }

    public String getTitle() {
        return checkInValidEntity() ? "" : this.mNotesDocumentEntity.getTitle();
    }

    public String getUuid() {
        return this.mUuid;
    }

    public void initNoteDocEntity(@NonNull String str, LifecycleOwner lifecycleOwner) {
        LiveData<NotesDocumentEntity> liveData = this.mLiveDataNotesDoc;
        if (liveData != null) {
            liveData.removeObserver(this);
        }
        LiveData<NotesDocumentEntity> liveData2 = this.mNotesDocumentRepository.get_LiveData(str);
        this.mLiveDataNotesDoc = liveData2;
        liveData2.observe(lifecycleOwner, this);
    }

    public boolean insertToDB(@NonNull Context context, String str, String str2, @NonNull SpenWNote spenWNote, NotesDocumentEntity notesDocumentEntity) {
        notesDocumentEntity.setId(null);
        notesDocumentEntity.setUuid(str);
        notesDocumentEntity.setFilePath(str2);
        DocumentDBSaver.saveSDocX(this.mRepositoryFactory, spenWNote, notesDocumentEntity, ThumbnailCreator.getEditedInfo(context, spenWNote).pageIndex());
        return true;
    }

    public void invertBackgroundColor(boolean z) {
        this.mNotesDocumentEntity.setBackgroundColorInverted(z ? 1 : 0);
    }

    public boolean isDeleted() {
        return (checkInValidEntity() || this.mNotesDocumentEntity.getIsDeleted() == 0) ? false : true;
    }

    public boolean isExist() {
        return (checkInValidEntity() || this.mNotesDocumentRepository.get(this.mNotesDocumentEntity.getUuid()) == null) ? false : true;
    }

    public boolean isFavoriteNote() {
        return (checkInValidEntity() || this.mNotesDocumentEntity.getIsFavorite() == 0) ? false : true;
    }

    public boolean isLocked() {
        return (checkInValidEntity() || this.mNotesDocumentEntity.getIsLock() == 0) ? false : true;
    }

    public boolean isObserving() {
        return this.mLiveDataNotesDoc != null;
    }

    public void release() {
        releaseObserver();
        if (this.mNotesDocumentEntity != null) {
            Logger.m11003i(TAG, "release# " + this.mNotesDocumentEntity);
        }
    }

    public void restore() {
        NotesDocumentEntity notesDocumentEntity = this.mOldNotesDocumentEntity;
        if (notesDocumentEntity == null) {
            Logger.m10999d(TAG, "mOldNotesDocumentEntity is null");
            return;
        }
        this.mNotesDocumentEntity = notesDocumentEntity;
        if (!UUIDUtils.isCoeditUuid(notesDocumentEntity.getUuid())) {
            this.mNotesDocumentRepository.restoreByUuidWithSyncTimestampUpdate(Collections.singleton(this.mNotesDocumentEntity.getUuid()));
        } else {
            if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
                Logger.m10999d(TAG, "restore fail - network is not connected");
                return;
            }
            if (!RequestToSamsungAccountManager.INSTANCE.isLogined()) {
                Logger.m10999d(TAG, "restore fail - samsung account is not login");
            }
            new InternalImportHandler().restoreNoteToCoeditAsync(this.mNotesDocumentEntity.getUuid());
        }
    }

    public void setBackgroundColor(int i) {
        if (checkInValidEntity()) {
            return;
        }
        this.mNotesDocumentEntity.setBackgroundColor(i);
    }

    public void setDocState(NotesDocument<SpenWordDocument> notesDocument) {
        NotesDocument<SpenWordDocument> notesDocument2 = this.mDocState;
        if (notesDocument2 != null && !notesDocument2.getUuid().equals(notesDocument.getUuid())) {
            Logger.m10999d(TAG, "setDocState# remove observer");
            releaseObserver();
        }
        updateEntityFromDocState(notesDocument);
        this.mDocState = notesDocument;
        String uuid = notesDocument.getUuid();
        this.mUuid = uuid;
        this.mSyncConflictManager.setUuid(uuid);
    }

    public void setFolderUuid(String str) {
        if (checkInValidEntity()) {
            return;
        }
        AbstractC8014b.m7197C("setFolderUuid# ", str, TAG);
        this.mNotesDocumentEntity.setCategoryUuid(str);
    }

    public void setIsSkipOnRemovedListener(boolean z) {
        this.mIsSkipOnRemovedListener = z;
    }

    public void setNoteFavorite(boolean z) {
        if (!checkInValidEntity() && this.mNotesDocumentRepository.updateFavorite(this.mNotesDocumentEntity.getUuid(), z) == 0) {
            this.mNotesDocumentEntity.setIsFavorite(z ? 1 : 0);
            OnTitleDataChangedListener onTitleDataChangedListener = this.mOnTitleDataChangedListener;
            if (onTitleDataChangedListener != null) {
                onTitleDataChangedListener.onChangedFavorite(z);
            }
        }
    }

    public void setNotesDocumentEntity(String str) {
        this.mUuid = str;
        this.mNotesDocumentEntity = this.mNotesDocumentRepository.get(str);
        this.mSyncConflictManager.setUuid(str);
    }

    public void setOnRemovedListener(OnRemovedListener onRemovedListener) {
        this.mOnRemovedListener = onRemovedListener;
    }

    public void setOnTitleDataChangedListener(OnTitleDataChangedListener onTitleDataChangedListener) {
        this.mOnTitleDataChangedListener = onTitleDataChangedListener;
    }

    public void setOpenedTime(String str) {
        NotesDataTaskExecutor.getIOThreadExecutor().execute(new RunnableC10960a(this, str, 25));
    }

    public void updateDeleteState(Context context, int i) {
        setDeleteState(i);
        if (checkInValidEntity()) {
            return;
        }
        DocumentWriteResolver.delete(context, this.mNotesDocumentEntity.getUuid(), i, TAG);
    }

    public void updateLockEntity(boolean z, String str) {
        if (checkInValidEntity()) {
            return;
        }
        this.mNotesDocumentEntity.setIsLock(z ? 5 : 0);
        this.mNotesDocumentEntity.setLockAccountGuid(str);
        AbstractC8014b.m7224z("updateLockEntity# ", TAG, z);
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(NotesDocumentEntity notesDocumentEntity) {
        boolean z;
        if (notesDocumentEntity == null) {
            OnRemovedListener onRemovedListener = this.mOnRemovedListener;
            if (onRemovedListener == null || this.mIsSkipOnRemovedListener) {
                return;
            }
            onRemovedListener.onRemoved();
            return;
        }
        Logger.m11003i(TAG, "registerDocumentDatabaseObserver#onChanged#" + hashCode() + " uuid : " + notesDocumentEntity.getUuid() + ", isFavorite : " + notesDocumentEntity.getIsFavorite() + ", modifiedAt : " + notesDocumentEntity.getLastModifiedAt() + ", isDeleted : " + notesDocumentEntity.getIsDeleted() + ", serverTime: " + notesDocumentEntity.getServerTimestamp() + ", folder: " + notesDocumentEntity.getCategoryUuid());
        if (checkInValidEntity()) {
            return;
        }
        boolean z2 = false;
        if (this.mOnTitleDataChangedListener == null) {
            z = false;
        } else {
            if (notesDocumentEntity.getIsDeleted() != 0 && FolderDataManager.isFolderDeleted(notesDocumentEntity.getCategoryUuid())) {
                this.mOnTitleDataChangedListener.onDeletedFolder();
                return;
            }
            if (notesDocumentEntity.getIsFavorite() != this.mNotesDocumentEntity.getIsFavorite()) {
                this.mOnTitleDataChangedListener.onChangedFavorite(notesDocumentEntity.getIsFavorite() != 0);
            }
            if (notesDocumentEntity.getCreatedAt() != this.mNotesDocumentEntity.getCreatedAt() || this.mCreatedTime != notesDocumentEntity.getCreatedAt()) {
                this.mCreatedTime = notesDocumentEntity.getCreatedAt();
                this.mOnTitleDataChangedListener.onChangedCreatedTime(notesDocumentEntity.getCreatedAt());
            }
            if (notesDocumentEntity.getLastModifiedAt() != this.mNotesDocumentEntity.getLastModifiedAt() || this.mLastModifiedTime != notesDocumentEntity.getLastModifiedAt()) {
                this.mLastModifiedTime = notesDocumentEntity.getLastModifiedAt();
                this.mOnTitleDataChangedListener.onChangedLastModifiedTime(notesDocumentEntity.getLastModifiedAt());
            }
            if (notesDocumentEntity.getCategoryIsDirty() != this.mNotesDocumentEntity.getCategoryIsDirty()) {
                this.mNotesDocumentEntity.setCategoryIsDirty(notesDocumentEntity.getCategoryIsDirty());
            }
            if (!Objects.equals(notesDocumentEntity.getCategoryServerTimeStamp(), this.mNotesDocumentEntity.getCategoryServerTimeStamp())) {
                this.mNotesDocumentEntity.setCategoryServerTimeStamp(notesDocumentEntity.getCategoryServerTimeStamp());
            }
            boolean z3 = !notesDocumentEntity.getCategoryUuid().equals(this.mNotesDocumentEntity.getCategoryUuid());
            z = notesDocumentEntity.getIsLock() != this.mNotesDocumentEntity.getIsLock();
            z2 = z3;
        }
        int widgetId = this.mNotesDocumentEntity.getWidgetId();
        if (widgetId != -1) {
            notesDocumentEntity.setWidgetId(widgetId);
        }
        keepCurrentStatus(notesDocumentEntity);
        updateDocumentEntity(notesDocumentEntity);
        if (z2) {
            this.mOnTitleDataChangedListener.onChangedFolder(notesDocumentEntity.getCategoryUuid());
        }
        if (z) {
            this.mOnTitleDataChangedListener.onChangedLockState(notesDocumentEntity.getIsLock());
        }
    }
}
