package com.samsung.android.support.senl.p148nt.data.repository.document;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtension;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesMappedDocumentEntity;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesMappedDocumentRepository {
    private static final String TAG = DataLogger.createTag("NotesMappedDocumentRepository");
    protected final NotesDocumentDao mNotesDocumentDao = NotesDatabaseManager.getInstance().getDocumentDao();
    protected final NotesMappedDocumentDao mNotesMappedDocumentDao = NotesDatabaseManager.getInstance().getMappedDocumentDao();

    public void delete(@NonNull List<DocumentData> list) {
        DataLogger.m12307i(TAG, "delete, documentUuidList : " + list);
        this.mNotesMappedDocumentDao.delete(this.mNotesDocumentDao, list);
    }

    public void deleteMappedEntity(@NonNull String str) {
        AbstractC0000a.m2C("delete, mappedDocumentUuid : ", str, TAG);
        this.mNotesMappedDocumentDao.deleteMappedEntity(str);
    }

    public List<NotesMappedDocumentEntity> dumpMappedDocument() {
        DataLogger.m12307i(TAG, "getAllMappedAtEntity");
        return this.mNotesMappedDocumentDao.dumpMappedDocumentList();
    }

    @Nullable
    public String findLatestConvertedMappedUuid(@NonNull String str) {
        AbstractC0000a.m2C("findLatestConvertedMappedUuid, originalDocumentUuid : ", str, TAG);
        return this.mNotesMappedDocumentDao.findLatestConvertedMappedUuid(str);
    }

    @Nullable
    public String findLatestMappedUuid(@NonNull String str) {
        AbstractC0000a.m2C("findLatestMappedUuid, originalDocumentUuid : ", str, TAG);
        return this.mNotesMappedDocumentDao.findLatestMappedUuid(str);
    }

    public String findMappedDocumentUuid(@NonNull String str, long j) {
        DataLogger.m12307i(TAG, "findMappedDocumentUuid, originalDocumentUuid : " + str + ", serverTimestamp : " + j);
        return this.mNotesMappedDocumentDao.findMappedDocumentUuid(str, j);
    }

    public String findOriginalDocumentUuid(@NonNull String str) {
        AbstractC0000a.m2C("findOriginalDocumentUuid, mappedDocumentUuid : ", str, TAG);
        return this.mNotesMappedDocumentDao.findOriginalDocumentUuid(str);
    }

    public boolean getConverted(@NonNull String str) {
        AbstractC0000a.m2C("getConverted, mappedDocumentUuid : ", str, TAG);
        return this.mNotesMappedDocumentDao.getConverted(str) != 0;
    }

    public long getMappedAt(@NonNull String str) {
        AbstractC0000a.m2C("getMappedAt, mappedDocumentUuid : ", str, TAG);
        return this.mNotesMappedDocumentDao.getMappedAt(str);
    }

    public Pair<AtomicInteger, AtomicInteger> insert(@NonNull String str, @NonNull String str2, boolean z) {
        return this.mNotesMappedDocumentDao.insert(this.mNotesDocumentDao, str, str2, z);
    }

    public void setConverted(@DocumentExtension String str, @NonNull String str2, boolean z) {
        String str3 = TAG;
        StringBuilder sbM16m = AbstractC0000a.m16m("setConverted, documentExtension : ", str, ", uuid : ", str2, ", converted : ");
        sbM16m.append(z);
        DataLogger.m12307i(str3, sbM16m.toString());
        if (".sdocx".equals(str)) {
            this.mNotesMappedDocumentDao.setConvertedByMappedUuid(str2, z ? 1 : 0);
        } else {
            this.mNotesMappedDocumentDao.setConvertedByOriginalUuid(str2, z ? 1 : 0);
        }
    }

    public boolean verifyMappedUuid(@NonNull String str, @NonNull String str2) {
        DataLogger.m12307i(TAG, "verifyMappedUuid, originalDocumentUuid : " + str + ", mappedDocumentUuid : " + str2);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mNotesMappedDocumentDao.verifyMappedUuid(str, str2);
    }

    public void delete(@NonNull String str, long j) {
        DataLogger.m12307i(TAG, "delete, originalDocumentUuid : " + str + " , minMappedAt : " + j);
        this.mNotesMappedDocumentDao.deleteMappedEntity(str, j);
    }
}
