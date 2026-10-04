package com.samsung.android.support.senl.p148nt.model.documents.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.common.constants.SaveStrategy;
import com.samsung.android.support.senl.p145cm.base.common.util.DataStrategy;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constants.SpenOpenMode;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constants.WritingMode;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class DocumentRepository<SpenDocument extends ISpenDocument, Entity extends DocumentEntityContainer> implements Parcelable, Cloneable {
    private static final String TAG = ModelLogger.createTag("DocumentRepository");
    private String mCaller;
    private DocumentAdjustData mDocumentAdjustData;
    private Entity mDocumentEntity;
    private DocumentSubscriptionId mDocumentSubscriptionId;
    private final DocumentType mDocumentType;
    private boolean mIsNewDocument;
    private String mLoadPath;
    private String mLockAccountGuid;
    private String mLockConfirm;

    @SpenOpenMode
    private int mMode;
    private String mOldUuid;
    private String mSavePath;
    private final DataStrategy mSaveStrategy;
    private SpenDocument mSpenDocument;
    private String mUuid;

    @WritingMode
    private int mWritingMode;

    public DocumentRepository(@NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NonNull String str5, @NonNull DocumentType documentType, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        this.mOldUuid = "";
        this.mMode = 0;
        this.mWritingMode = 0;
        this.mSaveStrategy = new DataStrategy(67760);
        this.mUuid = str;
        this.mLoadPath = str2;
        this.mSavePath = str3;
        this.mLockConfirm = str4;
        this.mCaller = str5;
        this.mDocumentType = documentType;
        this.mDocumentSubscriptionId = documentSubscriptionId;
    }

    public static void checkNonNullObjects(DocumentRepository<? extends ISpenDocument, ? extends DocumentEntityContainer> documentRepository) {
        if (documentRepository == null) {
            throw new IllegalArgumentException("DocumentRepository is null object.");
        }
        if (TextUtils.isEmpty(documentRepository.getUuid())) {
            throw new IllegalArgumentException("Uuid value must be passed.");
        }
    }

    private void printDatabaseStrategy(@NonNull String str, @NonNull DataStrategy dataStrategy) {
        StringBuilder sbM12325j = AbstractC11014a.m12325j(str, " strategy : ");
        if (dataStrategy.check(2)) {
            sbM12325j.append("BROADCAST_RELOAD_AFTER_SAVE,");
        }
        if (dataStrategy.check(4)) {
            sbM12325j.append("CLOSE_AFTER_SAVE,");
        }
        if (dataStrategy.check(8)) {
            sbM12325j.append("CREATE_AUTO_TITLE,");
        }
        if (dataStrategy.check(16)) {
            sbM12325j.append("SHOW_SAVE_SUCCESS_MESSAGE,");
        }
        if (dataStrategy.check(32)) {
            sbM12325j.append("SHOW_DELETE_EMPTY_DOCUMENT_MESSAGE,");
        }
        if (dataStrategy.check(64)) {
            sbM12325j.append("DO_NOT_DELETE_SERVICE_CACHE,");
        }
        if (dataStrategy.check(128)) {
            sbM12325j.append("FORCE_SAVE,");
        }
        if (dataStrategy.check(1024)) {
            sbM12325j.append("DO_NOT_UPDATE_DATABASE,");
        }
        if (dataStrategy.check(2048)) {
            sbM12325j.append("CREATE_THUMBNAIL_CACHE,");
        }
        if (dataStrategy.check(4096)) {
            sbM12325j.append("DO_NOT_UPDATE_MAPPING_TABLE,");
        }
        if (dataStrategy.check(8192)) {
            sbM12325j.append("BROADCAST_FORCE_UPDATE,");
        }
        if (dataStrategy.check(16384)) {
            sbM12325j.append("DO_NOT_UPDATE_MODIFIED_TIME,");
        }
        if (dataStrategy.check(32768)) {
            sbM12325j.append("DO_NOT_UPDATE_WIDGET,");
        }
        if (dataStrategy.check(65536)) {
            sbM12325j.append("SEND_ANALYTICS,");
        }
        DataLogger.m12302d(TAG, "printDatabaseStrategy - " + ((Object) sbM12325j));
    }

    public DocumentRepository<SpenDocument, Entity> addSaveStrategy(@SaveStrategy int i) {
        this.mSaveStrategy.add(i);
        return this;
    }

    public void adjustDocument(DocumentAdjustData documentAdjustData) {
    }

    public DocumentRepository<SpenDocument, Entity> caller(String str) {
        this.mCaller = str;
        return this;
    }

    public boolean checkSaveStrategy(@SaveStrategy int i) {
        return this.mSaveStrategy.check(i);
    }

    public DocumentRepository<SpenDocument, Entity> clearSaveStrategy() {
        this.mSaveStrategy.clear();
        return this;
    }

    @Override // 
    @NonNull
    /* JADX INFO: renamed from: clone */
    public abstract DocumentRepository mo22197clone();

    @SaveStrategy
    public int createDatabaseStrategy(@NonNull DataStrategy dataStrategy) {
        printDatabaseStrategy("model", dataStrategy);
        DataStrategy dataStrategy2 = new DataStrategy(67592);
        if (!dataStrategy.check(8)) {
            dataStrategy2.remove(8);
        }
        if (!dataStrategy.check(2048)) {
            dataStrategy2.remove(2048);
        }
        if (!dataStrategy.check(65536)) {
            dataStrategy2.remove(65536);
        }
        if (dataStrategy.check(4096)) {
            dataStrategy2.add(4096);
        }
        if (dataStrategy.check(8192)) {
            dataStrategy2.add(8192);
        }
        if (dataStrategy.check(16384)) {
            dataStrategy2.add(16384);
        }
        if (dataStrategy.check(32768)) {
            dataStrategy2.add(32768);
        }
        printDatabaseStrategy("data", dataStrategy2);
        return dataStrategy2.getMStrategy();
    }

    @NonNull
    public abstract Runnable createLoadDatabaseRunnable(@NonNull Context context);

    @NonNull
    public abstract SpenDocument createSpenDocument(@NonNull Context context, @NonNull String[] strArr, int i, boolean z, boolean z2);

    public abstract void createThumbnail(Context context);

    public abstract boolean deleteDatabase(@NonNull Context context, @NonNull Entity entity);

    public boolean deleteDocumentEntity(@NonNull Context context) {
        DataLogger.m12302d(TAG, "deleteDocumentEntity, documentEntity : " + getDocumentEntity());
        return deleteDatabase(context, getDocumentEntity());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DocumentRepository<SpenDocument, Entity> documentSubscriptionId(DocumentSubscriptionId documentSubscriptionId) {
        this.mDocumentSubscriptionId = documentSubscriptionId;
        return this;
    }

    public DocumentAdjustData getAdjustData() {
        DataLogger.m12307i(TAG, "getAdjustData, data : " + this.mDocumentAdjustData);
        return this.mDocumentAdjustData;
    }

    public String getCaller() {
        return this.mCaller;
    }

    @NonNull
    public Entity getDocumentEntity() {
        return this.mDocumentEntity;
    }

    public DocumentSubscriptionId getDocumentSubscriptionId() {
        return this.mDocumentSubscriptionId;
    }

    public DocumentType getDocumentType() {
        return this.mDocumentType;
    }

    public String getLoadPath() {
        return TextUtils.isEmpty(this.mLoadPath) ? getSavePath() : this.mLoadPath;
    }

    public String getLockAccountGuid() {
        return this.mLockAccountGuid;
    }

    public String getLockConfirm() {
        return this.mLockConfirm;
    }

    @SpenOpenMode
    public int getMode() {
        return this.mMode;
    }

    public String getOldUuid() {
        return this.mOldUuid;
    }

    public String getSavePath() {
        return this.mSavePath;
    }

    public int getSaveStrategy() {
        return this.mSaveStrategy.getMStrategy();
    }

    public SpenDocument getSpenDocument() {
        return this.mSpenDocument;
    }

    public String getUuid() {
        return this.mUuid;
    }

    @WritingMode
    public int getWritingMode() {
        return this.mWritingMode;
    }

    public boolean isNewDocument() {
        return this.mIsNewDocument;
    }

    public boolean isOldNote() {
        return !TextUtils.isEmpty(this.mOldUuid);
    }

    public boolean isSpenNoteDocType() {
        return DocumentType.SPEN_NOTE_DOC.equals(getDocumentType());
    }

    public boolean isSpenSDocType() {
        return DocumentType.SPEN_SDOC.equals(getDocumentType());
    }

    public boolean isSpenWordDocType() {
        return DocumentType.SPEN_SDOCX.equals(getDocumentType());
    }

    public abstract void loadDatabase(@NonNull Context context);

    public DocumentRepository<SpenDocument, Entity> loadPath(String str) {
        this.mLoadPath = str;
        return this;
    }

    public DocumentRepository<SpenDocument, Entity> lockConfirm(String str) {
        this.mLockConfirm = str;
        return this;
    }

    public DocumentRepository<SpenDocument, Entity> removeSaveStrategy(@SaveStrategy int i) {
        this.mSaveStrategy.remove(i);
        return this;
    }

    public abstract boolean rollbackDatabase(@NonNull Context context, boolean z, @NonNull Entity entity, @NonNull SpenDocument spendocument, @NonNull DocumentDataSource documentDataSource);

    public boolean rollbackDocumentEntity(@NonNull Context context, @NonNull DocumentDataSource documentDataSource) {
        DataLogger.m12302d(TAG, "rollbackDocumentEntity, documentEntity : " + getDocumentEntity());
        return rollbackDatabase(context, documentDataSource.isNew(), getDocumentEntity(), getSpenDocument(), documentDataSource);
    }

    public abstract boolean saveAutoTitle(@NonNull Context context);

    public SaveResult saveCacheSpenDocument() {
        SaveResult saveResult = new SaveResult();
        ISpenDocument spenDocument = getSpenDocument();
        String str = TAG;
        DataLogger.m12302d(str, "saveCacheSpenDocument, doc : " + spenDocument + ", documentEntity : " + getDocumentEntity());
        if (spenDocument == null) {
            return saveResult;
        }
        DataLogger.m12308p(str, "saveCacheSpenDocument - start, isContentChanged : " + spenDocument.isContentChanged() + ", savePath : " + DataLogger.getEncode(getSavePath()));
        try {
            DataLogger.m12305f(str, "saveCacheSpenDocument start - uuid : " + getUuid() + ", savePath : " + DataLogger.getEncode(getSavePath()));
            DocumentFileManager.getInstance().quickSaveWordDocument((SpenWordDocument) spenDocument, getSavePath());
            DataLogger.m12305f(str, "saveCacheSpenDocument success - uuid : " + getUuid() + ModelLogger.getContentLog((SpenWordDocument) spenDocument) + ", savePath : " + DataLogger.getEncode(getSavePath()));
            DataLogger.m12308p(str, "saveCacheSpenDocument - end, isContentChanged : " + spenDocument.isContentChanged());
            return saveResult.setIsFileSaved(true);
        } catch (Exception e) {
            DataLogger.m12306f(TAG, "saveCacheSpenDocument, error : ", e);
            return saveResult.setException(e);
        }
    }

    public boolean saveDocumentEntity(@NonNull Context context, @NonNull DocumentDataSource documentDataSource, boolean z) {
        DocumentEntityContainer documentEntity = getDocumentEntity();
        String str = TAG;
        DataLogger.m12302d(str, "saveDocumentEntity, entity : " + documentEntity + " , updateModifiedTime : " + z);
        if (documentEntity == null) {
            return false;
        }
        DataLogger.m12302d(str, "saveDocumentEntity, documentEntity : " + documentEntity.getEntity());
        return saveToDatabase(context, documentDataSource.isNew(), getDocumentEntity(), getSpenDocument(), documentDataSource, z);
    }

    public DocumentRepository<SpenDocument, Entity> savePath(String str) {
        this.mSavePath = str;
        return this;
    }

    public SaveResult saveSpenDocument() {
        SaveResult saveResult = new SaveResult();
        ISpenDocument spenDocument = getSpenDocument();
        String str = TAG;
        DataLogger.m12302d(str, "saveSpenDocument, doc : " + spenDocument + ", documentEntity : " + getDocumentEntity());
        if (spenDocument == null) {
            return saveResult;
        }
        DataLogger.m12308p(str, "saveSpenDocument - start, isContentChanged : " + spenDocument.isContentChanged() + ", savePath : " + DataLogger.getEncode(getSavePath()));
        try {
            DataLogger.m12305f(str, "saveSpenDocument start - uuid : " + getUuid() + ", savePath : " + DataLogger.getEncode(getSavePath()));
            DocumentFileManager.getInstance().saveWordDocument((SpenWordDocument) spenDocument, getSavePath());
            DataLogger.m12305f(str, "saveSpenDocument success - uuid : " + getUuid() + ModelLogger.getContentLog((SpenWordDocument) spenDocument) + ", savePath : " + DataLogger.getEncode(getSavePath()));
            DataLogger.m12308p(str, "saveSpenDocument - end, isContentChanged : " + spenDocument.isContentChanged());
            return saveResult.setIsFileSaved(true);
        } catch (Exception e) {
            DataLogger.m12306f(TAG, "saveSpenDocument, error : ", e);
            return saveResult.setException(e);
        }
    }

    public abstract boolean saveToDatabase(@NonNull Context context, boolean z, @NonNull Entity entity, @NonNull SpenDocument spendocument, @NonNull DocumentDataSource documentDataSource, boolean z2);

    public DocumentRepository<SpenDocument, Entity> setAdjustData(DocumentAdjustData documentAdjustData) {
        DataLogger.m12307i(TAG, "setAdjustData, data : " + documentAdjustData);
        this.mDocumentAdjustData = documentAdjustData;
        return this;
    }

    public DocumentRepository<SpenDocument, Entity> setDocument(SpenDocument spendocument) {
        this.mSpenDocument = spendocument;
        return this;
    }

    public void setDocumentEntity(Entity entity) {
        this.mDocumentEntity = entity;
    }

    public DocumentRepository<SpenDocument, Entity> setLockAccountGuid(String str) {
        this.mLockAccountGuid = str;
        return this;
    }

    public DocumentRepository<SpenDocument, Entity> setMode(@SpenOpenMode int i) {
        this.mMode = i;
        return this;
    }

    public void setNewDocument(boolean z) {
        this.mIsNewDocument = z;
    }

    public DocumentRepository<SpenDocument, Entity> setOldUuid(String str) {
        this.mOldUuid = str;
        return this;
    }

    public DocumentRepository<SpenDocument, Entity> setSaveStrategy(int i) {
        this.mSaveStrategy.set(i);
        return this;
    }

    public DocumentRepository<SpenDocument, Entity> setUuid(String str) {
        this.mUuid = str;
        return this;
    }

    public DocumentRepository<SpenDocument, Entity> setWritingMode(@WritingMode int i) {
        this.mWritingMode = i;
        return this;
    }

    public SaveResult snapSaveSpenDocument() {
        SaveResult saveResult = new SaveResult();
        ISpenDocument spenDocument = getSpenDocument();
        String str = TAG;
        DataLogger.m12302d(str, "snapSaveSpenDocument, doc : " + spenDocument + ", documentEntity : " + getDocumentEntity());
        if (spenDocument == null) {
            return saveResult;
        }
        DataLogger.m12308p(str, "snapSaveSpenDocument - start, isContentChanged : " + spenDocument.isContentChanged() + ", savePath : " + DataLogger.getEncode(getSavePath()));
        try {
            DataLogger.m12305f(str, "snapSaveSpenDocument start - uuid : " + getUuid() + ", savePath : " + DataLogger.getEncode(getSavePath()));
            DocumentFileManager.getInstance().snapSaveWordDocument((SpenWordDocument) spenDocument, getSavePath(), false);
            DataLogger.m12305f(str, "snapSaveSpenDocument success - uuid : " + getUuid() + ModelLogger.getContentLog((SpenWordDocument) spenDocument) + ", savePath : " + DataLogger.getEncode(getSavePath()));
            DataLogger.m12308p(str, "snapSaveSpenDocument - end, isContentChanged : " + spenDocument.isContentChanged());
            return saveResult.setIsFileSaved(true);
        } catch (Exception e) {
            DataLogger.m12306f(TAG, "snapSaveSpenDocument, error : ", e);
            return saveResult.setException(e);
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("DocumentRepository{uuid='");
        sb.append(this.mUuid);
        sb.append("', oldUuid='");
        sb.append(this.mOldUuid);
        sb.append("', documentType=");
        sb.append(this.mDocumentType);
        sb.append(", caller='");
        sb.append(this.mCaller);
        sb.append("', loadPath='");
        AbstractC11014a.m12336u(this.mLoadPath, sb, "', savePath='");
        AbstractC11014a.m12336u(this.mSavePath, sb, "', lockConfirm='");
        sb.append(this.mLockConfirm);
        sb.append("', guid='");
        sb.append(DataLogger.pii(this.mLockAccountGuid));
        sb.append("', id=");
        sb.append(this.mDocumentSubscriptionId);
        sb.append(", strategy=");
        sb.append(this.mSaveStrategy);
        sb.append(", entity=");
        sb.append(this.mDocumentEntity);
        sb.append(", document=");
        sb.append(this.mSpenDocument);
        sb.append(", mode=");
        sb.append(this.mMode);
        sb.append(", writingMode=");
        sb.append(this.mWritingMode);
        sb.append(", adjustData=");
        sb.append(this.mDocumentAdjustData);
        sb.append('}');
        return sb.toString();
    }

    public boolean updateOriginalEntityWithLatest() {
        DocumentEntityContainer documentEntity = getDocumentEntity();
        DataLogger.m12302d(TAG, "saveDocumentEntity, entity : " + documentEntity);
        try {
            documentEntity.updateOriginalEntityWithLatest();
            return true;
        } catch (CloneNotSupportedException e) {
            DataLogger.m12303e(TAG, "saveDocumentEntity, updateOriginalEntityWithLatest - e : " + e.getMessage());
            return false;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUuid);
        parcel.writeString(this.mLoadPath);
        parcel.writeString(this.mSavePath);
        parcel.writeString(this.mLockConfirm);
        parcel.writeString(this.mCaller);
        parcel.writeInt(this.mDocumentType.ordinal());
        parcel.writeParcelable(this.mDocumentSubscriptionId, i);
        parcel.writeParcelable(this.mDocumentEntity, i);
        parcel.writeInt(this.mMode);
        parcel.writeParcelable(this.mDocumentAdjustData, i);
        parcel.writeInt(this.mWritingMode);
        parcel.writeString(this.mOldUuid);
    }

    public DocumentRepository(Parcel parcel) {
        this.mOldUuid = "";
        this.mMode = 0;
        this.mWritingMode = 0;
        this.mSaveStrategy = new DataStrategy(67760);
        this.mUuid = parcel.readString();
        this.mLoadPath = parcel.readString();
        this.mSavePath = parcel.readString();
        this.mLockConfirm = parcel.readString();
        this.mCaller = parcel.readString();
        DocumentType documentType = DocumentType.values()[parcel.readInt()];
        this.mDocumentType = documentType;
        this.mDocumentSubscriptionId = (DocumentSubscriptionId) parcel.readParcelable(DocumentSubscriptionId.class.getClassLoader());
        this.mDocumentEntity = (Entity) parcel.readParcelable(DocumentEntityContainer.class.getClassLoader());
        this.mMode = parcel.readInt();
        this.mDocumentAdjustData = (DocumentAdjustData) parcel.readParcelable(DocumentAdjustData.class.getClassLoader());
        this.mWritingMode = parcel.readInt();
        this.mOldUuid = parcel.readString();
        String str = TAG;
        StringBuilder sb = new StringBuilder("DocumentUser - parcel, uuid : ");
        sb.append(this.mUuid);
        sb.append(", loadPath : ");
        AbstractC11014a.m12336u(this.mLoadPath, sb, ", savePath : ");
        AbstractC11014a.m12336u(this.mSavePath, sb, ", lockConfirm : ");
        sb.append(this.mLockConfirm);
        sb.append(", caller : ");
        sb.append(this.mCaller);
        sb.append(", documentType : ");
        sb.append(documentType);
        sb.append(", user : ");
        sb.append(this.mDocumentSubscriptionId);
        sb.append(", mDocumentAdjustData : ");
        sb.append(this.mDocumentAdjustData);
        DataLogger.m12302d(str, sb.toString());
    }
}
