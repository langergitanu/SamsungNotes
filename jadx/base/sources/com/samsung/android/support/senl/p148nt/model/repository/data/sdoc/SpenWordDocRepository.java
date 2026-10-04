package com.samsung.android.support.senl.p148nt.model.repository.data.sdoc;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.common.util.DataStrategy;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.DocumentDBSaver;
import com.samsung.android.support.senl.p148nt.model.document.save.ThumbnailCreator;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentAdjustData;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentType;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.entity.WordDocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.io.File;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SpenWordDocRepository extends DocumentRepository<SpenWordDocument, WordDocumentEntityContainer> implements Parcelable {
    private static final int DEFAULT_PAGE_WIDTH = 1080;
    private SpenWNote.Orientation mOrientation;
    private int mPageHeight;
    private SpenWNote.PageMode mPageMode;
    private int mPageWidth;
    public static final String TAG = ModelLogger.createTag("SpenWordDocRepository");
    public static final Parcelable.Creator<SpenWordDocRepository> CREATOR = new Parcelable.Creator<SpenWordDocRepository>() { // from class: com.samsung.android.support.senl.nt.model.repository.data.sdoc.SpenWordDocRepository.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SpenWordDocRepository createFromParcel(Parcel parcel) {
            return new SpenWordDocRepository(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SpenWordDocRepository[] newArray(int i) {
            return new SpenWordDocRepository[i];
        }
    };

    private SpenWordDocRepository(@NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NonNull String str5, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        super(str, str2, str3, str4, str5, DocumentType.SPEN_SDOCX, documentSubscriptionId);
        this.mPageWidth = 1080;
        this.mPageHeight = 1527;
        this.mPageMode = SpenWNote.PageMode.LIST;
        this.mOrientation = SpenWNote.Orientation.PORTRAIT;
        initialize();
    }

    public static SpenWordDocRepository create(@NonNull DocumentSubscriptionId documentSubscriptionId) {
        return new SpenWordDocRepository("", "", "", "", documentSubscriptionId.getUser(), documentSubscriptionId);
    }

    public static SpenWordDocument createSpenWordDocument(@NonNull Context context, @NonNull SpenWordDocRepository spenWordDocRepository, boolean z) {
        String str = TAG;
        DataLogger.m12302d(str, "createSpenWordDocument, repository : " + spenWordDocRepository);
        try {
            if (spenWordDocRepository.getDocumentEntity().getEntity().getIsDeleted() == 1) {
                throw new RuntimeException("Document was already deleted permanently");
            }
            String loadPath = spenWordDocRepository.getLoadPath();
            boolean zExists = new File(loadPath).exists();
            boolean zHasSnapSavedData = SpenWNoteFile.hasSnapSavedData(context, loadPath);
            DataLogger.m12308p(str, "create spen document - start, loadFileExists: " + zExists + ", existSnapData: " + zHasSnapSavedData + ", path: " + DataLogger.getEncode(loadPath));
            if (zExists || zHasSnapSavedData) {
                SpenWordDocument spenWordDocumentOpenWordDocument = DocumentFileManager.getInstance().openWordDocument(context, loadPath, spenWordDocRepository.getPageWidth(), spenWordDocRepository.getMode(), false, z);
                DataLogger.m12308p(str, "create spen document - end");
                return spenWordDocumentOpenWordDocument;
            }
            SpenWordDocument spenWordDocumentOpenWordDocument2 = DocumentFileManager.getInstance().openWordDocument(context, loadPath, spenWordDocRepository.getOrientation(), spenWordDocRepository.getOrientation() == SpenWNote.Orientation.LANDSCAPE ? spenWordDocRepository.getPageHeight() : spenWordDocRepository.getPageWidth(), spenWordDocRepository.getPageMode(), z);
            DataLogger.m12308p(str, "create spen document - end");
            return spenWordDocumentOpenWordDocument2;
        } catch (Throwable th) {
            DataLogger.m12308p(TAG, "create spen document - end");
            throw th;
        }
    }

    private void initialize() {
        String savePath = getSavePath();
        NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
        notesDocumentEntity.setUuid(getUuid());
        if (savePath == null) {
            savePath = "";
        }
        notesDocumentEntity.setFilePath(savePath);
        try {
            setDocumentEntity(new WordDocumentEntityContainer(notesDocumentEntity));
        } catch (CloneNotSupportedException e) {
            DataLogger.m12303e(TAG, "initialize, e : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createLoadDatabaseRunnable$0(Context context) {
        NotesDocumentEntity notesDocumentEntity = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().get(getUuid());
        DataLogger.m12302d(TAG, "loadDatabase$onComplete, entity : " + notesDocumentEntity);
        if (notesDocumentEntity != null) {
            try {
                setDocumentEntity(new WordDocumentEntityContainer(notesDocumentEntity));
            } catch (CloneNotSupportedException e) {
                DataLogger.m12303e(TAG, "initialize, e : " + e.getMessage());
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository
    public void adjustDocument(DocumentAdjustData documentAdjustData) {
        String str = TAG;
        DataLogger.m12307i(str, "adjustDocument, data : " + documentAdjustData);
        if (documentAdjustData == null || getSpenDocument() == null || getSpenDocument().isClosed()) {
            DataLogger.m12307i(str, "adjustDocument, data was not set.");
            return;
        }
        SpenDocumentDisplayUtils.adjustSize(getSpenDocument().getPage(documentAdjustData.getPageIndex()), documentAdjustData.getDefaultPageHeight(), documentAdjustData.getPageDefaultNumber());
        SpenDocumentDisplayUtils.convertColors(documentAdjustData.getPenColorType(), getSpenDocument().getPage(documentAdjustData.getPageIndex()), documentAdjustData.getDefaultBackgroundColor(), documentAdjustData.getColorSet());
        SpenDocumentDisplayUtils.convertLastPenInfo(getSpenDocument(), documentAdjustData.getPenColorType(), documentAdjustData.getColorSet());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository
    @NonNull
    public Runnable createLoadDatabaseRunnable(@NonNull Context context) {
        return new RunnableC10960a(this, context, 3);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository
    public void createThumbnail(Context context) {
        DataLogger.m12302d(TAG, "createThumbnail, uuid : " + getUuid());
        ThumbnailCreator.EditedInfo editedInfo = ThumbnailCreator.getEditedInfo(context, getSpenDocument());
        new ThumbnailCreator().saveThumbnail(context, getSpenDocument(), getUuid(), editedInfo);
        DocumentDBSaver.insertDocumentThumbnail(NotesDataRepositoryFactory.newInstance(context).createDocumentThumbnailRepository(), getUuid(), getSpenDocument(), editedInfo.pageIndex());
        ThumbnailCreator.sendForceUpdateBroadcast(context, getDocumentEntity().getEntity());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SpenWNote.Orientation getOrientation() {
        return this.mOrientation;
    }

    public int getPageHeight() {
        return this.mPageHeight;
    }

    public SpenWNote.PageMode getPageMode() {
        return this.mPageMode;
    }

    public int getPageWidth() {
        return this.mPageWidth;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository
    public void loadDatabase(@NonNull Context context) {
        DataLogger.m12302d(TAG, "loadDatabase, uuid : " + getUuid());
        Runnable runnableCreateLoadDatabaseRunnable = createLoadDatabaseRunnable(context);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            DataRepositoryScheduler.runnable(runnableCreateLoadDatabaseRunnable).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
        } else {
            runnableCreateLoadDatabaseRunnable.run();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository
    public boolean saveAutoTitle(@NonNull Context context) {
        DataLogger.m12302d(TAG, "saveAutoTitle");
        return DocumentWriteResolver.updateRecommendedTitle(context, getUuid(), getSpenDocument());
    }

    public SpenWordDocRepository setOrientation(SpenWNote.Orientation orientation) {
        this.mOrientation = orientation;
        return this;
    }

    public SpenWordDocRepository setPageHeight(int i) {
        this.mPageHeight = i;
        return this;
    }

    public SpenWordDocRepository setPageMode(SpenWNote.PageMode pageMode) {
        this.mPageMode = pageMode;
        return this;
    }

    public SpenWordDocRepository setPageWidth(int i) {
        this.mPageWidth = i;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("SpenWordDocRepository{uuid : ");
        sb.append(DataLogger.getEncode(getUuid()));
        sb.append(", path : ");
        sb.append(DataLogger.getEncode(getSavePath()));
        sb.append(", doc : ");
        sb.append(getSpenDocument());
        sb.append(", mPageMode=");
        sb.append(this.mPageMode);
        sb.append(", mOrientation=");
        sb.append(this.mOrientation);
        sb.append(", mPageWidth=");
        sb.append(this.mPageWidth);
        sb.append(", mPageHeight=");
        return AbstractC0000a.m13j(sb, this.mPageHeight, '}');
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mOrientation.ordinal());
        parcel.writeInt(this.mPageWidth);
        parcel.writeInt(this.mPageHeight);
        parcel.writeInt(this.mPageMode.ordinal());
    }

    public static SpenWordDocRepository create(@NonNull SpenWordDocRepository spenWordDocRepository) {
        return new SpenWordDocRepository(spenWordDocRepository.getUuid(), spenWordDocRepository.getLoadPath(), spenWordDocRepository.getSavePath(), spenWordDocRepository.getLockConfirm(), spenWordDocRepository.getCaller(), spenWordDocRepository.getDocumentSubscriptionId());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository
    @NonNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DocumentRepository<?, ?> mo22197clone() {
        return create(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository
    @NonNull
    public SpenWordDocument createSpenDocument(@NonNull Context context, @NonNull String[] strArr, int i, boolean z, boolean z2) {
        return createSpenWordDocument(context, this, z2);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository
    public boolean deleteDatabase(@NonNull Context context, @NonNull WordDocumentEntityContainer wordDocumentEntityContainer) {
        NotesDocumentEntity entity = wordDocumentEntityContainer.getEntity();
        DataLogger.m12302d(TAG, "deleteDatabase, entity : " + entity);
        return DocumentWriteResolver.delete(context, entity.getUuid(), 1, getCaller());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository
    public boolean rollbackDatabase(@NonNull Context context, boolean z, @NonNull WordDocumentEntityContainer wordDocumentEntityContainer, @NonNull SpenWordDocument spenWordDocument, @NonNull DocumentDataSource documentDataSource) {
        NotesDocumentEntity rollbackEntity = wordDocumentEntityContainer.getRollbackEntity();
        DataLogger.m12302d(TAG, "rollbackDatabase, entity : " + rollbackEntity);
        return DocumentWriteResolver.save(context, z, documentDataSource.getLoadPath(), rollbackEntity, (SpenWNote) spenWordDocument, getLockAccountGuid(), false, Integer.MAX_VALUE, getCaller());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository
    public boolean saveToDatabase(@NonNull Context context, boolean z, @NonNull WordDocumentEntityContainer wordDocumentEntityContainer, @NonNull SpenWordDocument spenWordDocument, @NonNull DocumentDataSource documentDataSource, boolean z2) {
        DataLogger.m12302d(TAG, "saveToDatabase, isChangedOnlyThumbnail : " + spenWordDocument.isChangedOnlyThumbnail());
        String path = isOldNote() ? documentDataSource.getPath() : documentDataSource.getLoadPath();
        try {
            return DocumentWriteResolver.save(context, z, path, wordDocumentEntityContainer.getEntity(), spenWordDocument, getLockAccountGuid(), z2, createDatabaseStrategy(new DataStrategy(getSaveStrategy())), getCaller());
        } finally {
            removeSaveStrategy(16384);
        }
    }

    public static SpenWordDocRepository create(@NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NonNull String str5, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        return new SpenWordDocRepository(str, str2, str3, str4, str5, documentSubscriptionId);
    }

    public SpenWordDocRepository(Parcel parcel) {
        super(parcel);
        this.mPageWidth = 1080;
        this.mPageHeight = 1527;
        this.mPageMode = SpenWNote.PageMode.LIST;
        this.mOrientation = SpenWNote.Orientation.PORTRAIT;
        this.mOrientation = SpenWNote.Orientation.values()[parcel.readInt()];
        this.mPageWidth = parcel.readInt();
        this.mPageHeight = parcel.readInt();
        this.mPageMode = SpenWNote.PageMode.values()[parcel.readInt()];
    }
}
