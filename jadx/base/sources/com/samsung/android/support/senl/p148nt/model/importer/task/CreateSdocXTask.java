package com.samsung.android.support.senl.p148nt.model.importer.task;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.LockFileUtils;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportSdocXParam;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CreateSdocXTask extends ImportSdocXBaseTask<ImportSdocXParam> {
    private static final String TAG = ModelLogger.createTag("CreateSdocXTask");
    private SpenWNote mWNote;

    public CreateSdocXTask(ImportSdocXParam importSdocXParam) {
        super(importSdocXParam);
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

    @NonNull
    private SpenWNote openNote(@NonNull String str) {
        return DocumentFileManager.getInstance().open(getContext(), str, SpenWNote.PageMode.LIST, SpenWNote.Orientation.PORTRAIT, SpenDocumentDisplayUtils.getScreenWidth(getContext()), false);
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

    public SpenWNote getNote() {
        return this.mWNote;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportSdocXBaseTask
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    @NonNull
    public NotesDocumentEntity createDocumentEntity(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull SpenWNote spenWNote) {
        NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
        notesDocumentEntity.setUuid(str);
        notesDocumentEntity.setFilePath(str2);
        notesDocumentEntity.setIsDeleted(0);
        notesDocumentEntity.setCategoryUuid(str4);
        notesDocumentEntity.setIsLock(LockFileUtils.getLockTypeFromSdocx(getContext(), spenWNote));
        notesDocumentEntity.setPageMode(spenWNote.getPageMode() == SpenWNote.PageMode.LIST ? 2 : 1);
        updateDocumentTimeEntity(notesDocumentEntity, str3);
        return notesDocumentEntity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    @NonNull
    public SpenWNote open(@NonNull String str, @NonNull String str2) throws Exception {
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("open, uuid : ", str, ", externalPath : ");
        sbM15l.append(DataLogger.getEncode(str2));
        DataLogger.m12302d(str3, sbM15l.toString());
        try {
            this.mWNote = openNote(str2);
            return (SpenWNote) this.mInjectedCallable.call();
        } catch (Exception e) {
            DataLogger.m12306f(TAG, "open, uuid : " + str + ", exception: ", e);
            throw e;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportSdocXBaseTask, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public boolean saveSPenDocument(@NonNull String str, @NonNull SpenWNote spenWNote) {
        DataLogger.m12302d(getTag(), "saveSPenDocument, savePath : " + DataLogger.getEncode(str) + ", document : " + spenWNote);
        DocumentFileManager.getInstance().saveAsDirectory(spenWNote, str);
        return true;
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
}
