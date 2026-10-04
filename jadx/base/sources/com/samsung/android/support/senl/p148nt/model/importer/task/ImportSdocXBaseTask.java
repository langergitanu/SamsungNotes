package com.samsung.android.support.senl.p148nt.model.importer.task;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenOpenModeManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.NotesSQLiteConstraintException;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportBaseParam;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class ImportSdocXBaseTask<Param extends ImportBaseParam<?>> extends ImportTask<SpenWNote, Param> {
    public ImportSdocXBaseTask(Param param) {
        super(param);
    }

    public void copyCoverData(String str, String str2) {
        DocumentCoverStateTuple coverStateTuple = this.mFactory.createDocumentCoverRepository().getCoverStateTuple(str);
        DataLogger.m12302d(getTag(), "copyCoverData, tuple: " + coverStateTuple);
        if (coverStateTuple == null) {
            return;
        }
        coverStateTuple.setDocUuid(str2);
        try {
            this.mFactory.createDocumentCoverRepository().insert(coverStateTuple, coverStateTuple.state, "copyCoverData");
            FileUtils.copyDirectory(new File(PageCacheUtils.getCoverCacheDirectory(getContext(), str)), new File(PageCacheUtils.getCoverCacheDirectory(getContext(), str2)));
            FileUtils.copyDirectory(new File(PageCacheUtils.getCoverGridCacheDirectory(getContext(), str)), new File(PageCacheUtils.getCoverGridCacheDirectory(getContext(), str2)));
        } catch (NotesSQLiteConstraintException | IOException e) {
            AbstractC11014a.m12333r(e, new StringBuilder("copyCoverData, e: "), getTag());
        }
    }

    public void copyTagData(String str, String str2) {
        NotesTagRepository notesTagRepositoryCreateDocumentTagRepository = this.mFactory.createDocumentTagRepository();
        List<NotesTagEntity> tagListByDocUuid = notesTagRepositoryCreateDocumentTagRepository.getTagListByDocUuid(str);
        if (tagListByDocUuid.isEmpty()) {
            return;
        }
        for (NotesTagEntity notesTagEntity : tagListByDocUuid) {
            notesTagEntity.setId(null);
            notesTagEntity.setDocUuid(str2);
        }
        notesTagRepositoryCreateDocumentTagRepository.insert((Collection<NotesTagEntity>) tagListByDocUuid);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public String getDocumentExtension() {
        return ".sdocx";
    }

    public abstract String getTag();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public boolean close(@Nullable SpenWNote spenWNote, String str) {
        DataLogger.m12302d(getTag(), "close, document : " + spenWNote);
        try {
            if (spenWNote != null) {
                try {
                    if (!spenWNote.isClosed()) {
                        spenWNote.close(true);
                    }
                } catch (IOException e) {
                    DataLogger.m12303e(getTag(), "close, e : " + e.getMessage());
                    SpenOpenModeManager.INSTANCE.getInstance().disuse(getExternalPath());
                    return false;
                }
            }
            return true;
        } finally {
            SpenOpenModeManager.INSTANCE.getInstance().disuse(getExternalPath());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public boolean saveSPenDocument(@NonNull String str, @NonNull SpenWNote spenWNote) {
        DataLogger.m12302d(getTag(), "saveSPenDocument, savePath : " + DataLogger.getEncode(str) + ", document : " + spenWNote);
        DocumentFileManager.getInstance().saveAsDirectory(spenWNote, str);
        return true;
    }
}
