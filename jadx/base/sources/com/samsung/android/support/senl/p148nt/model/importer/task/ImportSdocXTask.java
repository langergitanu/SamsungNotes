package com.samsung.android.support.senl.p148nt.model.importer.task;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenBoundFileNotFoundException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.LockFileUtils;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.restore.RestoreSaveFailedNote;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportSdocXParam;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ImportSdocXTask extends ImportSdocXBaseTask<ImportSdocXParam> {
    private static final String TAG = ModelLogger.createTag("ImportSdocXTask");
    private final int mDeleteType;
    private String mTitle;

    public ImportSdocXTask(ImportSdocXParam importSdocXParam) {
        this(importSdocXParam, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void clearCanvasCacheData(SpenWNote spenWNote) {
        if (((ImportSdocXParam) getParam()).clearCanvasCache()) {
            Iterator<SpenWPage> it = spenWNote.getPageList().iterator();
            while (it.hasNext()) {
                it.next().clearCanvasCacheData();
            }
            DataLogger.m12307i(TAG, "clearCanvasCacheData, finished");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isCoEditNote() {
        return ((ImportSdocXParam) getParam()).isCoEditNote();
    }

    @NonNull
    private SpenWNote openNote(@NonNull String str, boolean z) {
        return DocumentFileManager.getInstance().open(getContext(), str, SpenDocumentDisplayUtils.getScreenWidth(getContext()), getOpenMode(str), false, z, isCoEditNote());
    }

    private boolean restoreCorruptedInfo(@NonNull String str) {
        try {
            return new RestoreSaveFailedNote(getContext(), getUuid(), str, getOpenMode(str), null).setIsCoeditMode(isCoEditNote()).setIsNewNote(true).call().booleanValue();
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("restoreCorruptedInfo, e: "), TAG);
            return false;
        }
    }

    private void updateDocumentTimeEntity(@NonNull NotesDocumentEntity notesDocumentEntity, @NonNull String str) {
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = this.mFactory.createDocumentDataRepository();
        String uuid = notesDocumentRepositoryCreateDocumentDataRepository.getUuid(str);
        if (TextUtils.isEmpty(uuid)) {
            notesDocumentEntity.getTimeSaveParam().setTime(Long.valueOf(TimeManager.convertSdkTimeToAppTime(SpenWNoteFile.getDisplayCreatedTime(str))), Long.valueOf(TimeManager.convertSdkTimeToAppTime(SpenWNoteFile.getDisplayModifiedTime(str))));
        } else {
            NotesDocumentEntity notesDocumentEntity2 = notesDocumentRepositoryCreateDocumentDataRepository.get(uuid);
            notesDocumentEntity.getTimeSaveParam().setTime(Long.valueOf(notesDocumentEntity2.getCreatedAt()), Long.valueOf(notesDocumentEntity2.getLastModifiedAt()));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportSdocXBaseTask
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public void saveExtraData() {
        NotesDocumentEntity entityFromPath = this.mNotesDocumentRepository.getEntityFromPath(getExternalPath());
        boolean z = (entityFromPath == null || UUIDUtils.isCoeditUuid(entityFromPath.getUuid())) ? false : true;
        DataLogger.m12302d(TAG, "saveExtraData, isDuplicated: " + z);
        if (z) {
            copyCoverData(entityFromPath.getUuid(), getUuid());
        }
    }

    public ImportSdocXTask(ImportSdocXParam importSdocXParam, @DeleteType int i) {
        super(importSdocXParam);
        this.mDeleteType = i;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    @NonNull
    public NotesDocumentEntity createDocumentEntity(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull SpenWNote spenWNote) {
        NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
        notesDocumentEntity.setUuid(str);
        notesDocumentEntity.setFilePath(str2);
        notesDocumentEntity.setIsDeleted(this.mDeleteType);
        notesDocumentEntity.setCategoryUuid(str4);
        notesDocumentEntity.setIsLock(LockFileUtils.getLockTypeFromSdocx(getContext(), spenWNote));
        notesDocumentEntity.setPageMode(spenWNote.getPageMode() == SpenWNote.PageMode.LIST ? 2 : 1);
        updateDocumentTimeEntity(notesDocumentEntity, str3);
        String str5 = this.mTitle;
        if (str5 != null) {
            notesDocumentEntity.setTitle(str5);
        }
        return notesDocumentEntity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public boolean isImportable(@NonNull SpenWNote spenWNote) {
        boolean z = ((ImportSdocXParam) getParam()).skipEmptyNote() && SpenWordDocument.isContentEmpty(spenWNote);
        DataLogger.m12302d(TAG, "isImportable, isEmptyNote: " + z);
        return !z && super.isImportable(spenWNote);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    @NonNull
    public SpenWNote open(@NonNull String str, @NonNull String str2) throws Exception {
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("open, uuid : ", str, ", externalPath : ");
        AbstractC11014a.m12336u(str2, sbM15l, " isCoeditNote: ");
        sbM15l.append(isCoEditNote());
        DataLogger.m12302d(str3, sbM15l.toString());
        try {
            return openNote(str2, isCoEditNote());
        } catch (Exception e) {
            DataLogger.m12306f(TAG, "open, uuid : " + str + ", e: ", e);
            if (!(e instanceof SpenBoundFileNotFoundException)) {
                throw e;
            }
            if (restoreCorruptedInfo(str2)) {
                return openNote(str2, isCoEditNote());
            }
            throw new RuntimeException("fail to restore note");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public boolean saveToDatabase(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull SpenWNote spenWNote, @NonNull NotesDocumentEntity notesDocumentEntity, @NonNull String str4) {
        String str5 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("save, uuid : ", str, ", savePath : ");
        sbM15l.append(DataLogger.getEncode(str2));
        sbM15l.append(", externalPath : ");
        sbM15l.append(DataLogger.getEncode(str3));
        sbM15l.append(", document : ");
        sbM15l.append(spenWNote);
        DataLogger.m12302d(str5, sbM15l.toString());
        return super.saveToDatabase(str, str2, str3, spenWNote, notesDocumentEntity, str4) && DocumentWriteResolver.save(getContext(), true, str2, notesDocumentEntity, spenWNote, notesDocumentEntity.getLockAccountGuid(), true, 2048, str4);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public void updateSPenDocument(@NonNull SpenWNote spenWNote) {
        spenWNote.setServerCheckPoint(-1L);
        clearCanvasCacheData(spenWNote);
    }

    public ImportSdocXTask(ImportSdocXParam importSdocXParam, @DeleteType int i, String str) {
        super(importSdocXParam);
        this.mDeleteType = i;
        this.mTitle = str;
    }
}
