package com.samsung.android.support.senl.p148nt.model.importer.task;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.support.senl.p145cm.base.common.util.LockFileUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenOpenModeManager;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportSdocParam;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.io.IOException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ImportSdocTask extends ImportTask<SpenSDoc, ImportSdocParam> {
    private static final String TAG = ModelLogger.createTag("ImportSdocTask");

    public ImportSdocTask(ImportSdocParam importSdocParam) {
        super(importSdocParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public String getDocumentExtension() {
        return ".sdoc";
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public void updateSPenDocument(@NonNull SpenSDoc spenSDoc) {
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public boolean close(@Nullable SpenSDoc spenSDoc, String str) {
        DataLogger.m12302d(TAG, "close, document : " + spenSDoc);
        try {
            if (spenSDoc != null) {
                try {
                    if (!spenSDoc.isClosed()) {
                        spenSDoc.close(true);
                    }
                } catch (IOException e) {
                    DataLogger.m12303e(TAG, "close, e : " + e.getMessage());
                    SpenOpenModeManager.INSTANCE.getInstance().disuse(getExternalPath());
                    return false;
                }
            }
            return true;
        } finally {
            SpenOpenModeManager.INSTANCE.getInstance().disuse(getExternalPath());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    @NonNull
    public NotesDocumentEntity createDocumentEntity(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull SpenSDoc spenSDoc) {
        NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
        try {
            notesDocumentEntity.setUuid(str);
            notesDocumentEntity.setFilePath(str2);
            notesDocumentEntity.setCategoryUuid(str4);
            notesDocumentEntity.setIsLock(LockFileUtils.getLockTypeFromSdoc(getContext(), spenSDoc));
            notesDocumentEntity.setPageMode(1);
            notesDocumentEntity.getTimeSaveParam().setTime(Long.valueOf(SpenSDocFile.getCreatedTime(str3)), Long.valueOf(SpenSDocFile.getModifiedTime(str3)));
            return notesDocumentEntity;
        } catch (SpenSDocUnsupportedFileException | SpenSDocUnsupportedVersionException | IOException e) {
            AbstractC11014a.m12333r(e, new StringBuilder("save, e : "), TAG);
            return notesDocumentEntity;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    @NonNull
    public SpenSDoc open(@NonNull String str, @NonNull String str2) {
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("open, uuid : ", str, ", externalPath : ");
        sbM15l.append(DataLogger.getEncode(str2));
        DataLogger.m12302d(str3, sbM15l.toString());
        return new SpenSDoc(getContext(), str2, getParam().getConfirmResult(), getParam().getPasswordList(), getOpenMode(str2));
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public boolean saveSPenDocument(@NonNull String str, @NonNull SpenSDoc spenSDoc) throws IOException {
        DataLogger.m12302d(TAG, "saveSpenDocument, savePath : " + DataLogger.getEncode(str) + ", document : " + spenSDoc);
        spenSDoc.save(str, null, SpenSDocFile.getCreatedTime(getExternalPath()), SpenSDocFile.getModifiedTime(getExternalPath()));
        return AbstractC2322a.m1607A(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public boolean saveToDatabase(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull SpenSDoc spenSDoc, @NonNull NotesDocumentEntity notesDocumentEntity, @NonNull String str4) {
        String str5 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("saveToDatabase, uuid : ", str, ", savePath : ");
        sbM15l.append(DataLogger.getEncode(str2));
        sbM15l.append(", externalPath : ");
        sbM15l.append(DataLogger.getEncode(str3));
        sbM15l.append(", document : ");
        sbM15l.append(spenSDoc);
        DataLogger.m12302d(str5, sbM15l.toString());
        return super.saveToDatabase(str, str2, str3, spenSDoc, notesDocumentEntity, str4) && DocumentWriteResolver.save(getContext(), true, str2, notesDocumentEntity, spenSDoc, notesDocumentEntity.getLockAccountGuid(), true, str4);
    }
}
