package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.text.TextUtils;
import android.util.Pair;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.contract.DataToSyncManager;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesMappedDocumentEntity;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesMappedDocumentDao implements BaseDao<NotesMappedDocumentEntity> {
    private static final String TAG = DataLogger.createTag("NotesMappedDocumentDao");

    @Query("DELETE FROM mapped_document")
    public abstract void clear();

    @Transaction
    public void delete(NotesDocumentDao notesDocumentDao, boolean z, String str) {
        if (z) {
            updateConverted(str, 0);
            return;
        }
        notesDocumentDao.updateLastMappedAt(str, 0L);
        DataToSyncManager.getInstance().onMappedDocumentChanged(str);
        delete(str);
    }

    @Query("DELETE FROM mapped_document WHERE UUID=:originalDocumentUuid")
    public abstract void delete(String str);

    @Query("DELETE FROM mapped_document WHERE mappedUUID=:mappedDocumentUuid")
    public abstract void deleteMappedEntity(String str);

    @Query("DELETE FROM mapped_document WHERE UUID=:originalDocumentUuid AND mappedAt<:minMappedAt")
    public abstract void deleteMappedEntity(String str, long j);

    @Query("SELECT * FROM mapped_document ORDER BY UUID ASC")
    public abstract List<NotesMappedDocumentEntity> dumpMappedDocumentList();

    @Query("SELECT mappedUUID FROM mapped_document WHERE converted IS 1 AND UUID=:originalDocumentUuid ORDER BY _id DESC LIMIT 1")
    public abstract String findLatestConvertedMappedUuid(String str);

    @Query("SELECT mappedUUID FROM mapped_document WHERE UUID=:originalDocumentUuid ORDER BY _id DESC LIMIT 1")
    public abstract String findLatestMappedUuid(String str);

    @Query("SELECT mappedUUID FROM mapped_document WHERE UUID=:originalDocumentUuid AND mappedAt=:serverTimestamp ORDER BY _id DESC LIMIT 1")
    public abstract String findMappedDocumentUuid(String str, long j);

    @Query("SELECT UUID FROM mapped_document WHERE mappedUUID=:mappedDocumentUuid")
    public abstract String findOriginalDocumentUuid(String str);

    @Query("SELECT converted FROM mapped_document WHERE mappedUUID=:mappedDocumentUuid")
    public abstract int getConverted(String str);

    @Transaction
    public long getDocumentServerTimestamp(NotesDocumentDao notesDocumentDao, String str) {
        Long serverTimeStamp = notesDocumentDao.getServerTimeStamp(str);
        if (serverTimeStamp == null) {
            return 0L;
        }
        return serverTimeStamp.longValue();
    }

    @Query("SELECT mappedAt FROM mapped_document WHERE mappedUUID=:mappedDocumentUuid")
    public abstract long getMappedAt(String str);

    @Transaction
    public Pair<AtomicInteger, AtomicInteger> insert(NotesDocumentDao notesDocumentDao, NotesMappedDocumentEntity notesMappedDocumentEntity, String str, long j) {
        notesDocumentDao.updateLastMappedAt(str, j);
        DataToSyncManager.getInstance().onMappedDocumentChanged(str);
        return upsert(notesMappedDocumentEntity);
    }

    @Query("UPDATE OR ABORT mapped_document SET converted=:converted WHERE mappedUUID=:mappedUuid")
    public abstract void setConvertedByMappedUuid(String str, int i);

    @Query("UPDATE OR ABORT mapped_document SET converted=:converted WHERE UUID=:originalUuid")
    public abstract void setConvertedByOriginalUuid(String str, int i);

    @Query("UPDATE OR ABORT mapped_document SET converted=:isConverted WHERE mappedUUID=:mappedUuid")
    public abstract void updateConverted(String str, int i);

    @Query("SELECT old.lastModifiedAt=new.lastModifiedAt FROM mapped_document AS map LEFT OUTER JOIN sdoc AS old ON old.UUID=:originalDocumentUuid LEFT OUTER JOIN sdoc AS new ON new.UUID=:mappedDocumentUuid WHERE map.mappedUUID=:mappedDocumentUuid AND map.converted=1 ORDER BY map._id DESC LIMIT 1")
    public abstract boolean verifyMappedUuid(String str, String str2);

    @Transaction
    public Pair<AtomicInteger, AtomicInteger> insert(NotesDocumentDao notesDocumentDao, String str, String str2, long j, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (Objects.equals(str, str2)) {
                return Pair.create(new AtomicInteger(0), new AtomicInteger());
            }
            NotesMappedDocumentEntity notesMappedDocumentEntity = new NotesMappedDocumentEntity();
            notesMappedDocumentEntity.setUuid(str);
            notesMappedDocumentEntity.setMappedUuid(str2);
            notesMappedDocumentEntity.setMappedAt(j);
            notesMappedDocumentEntity.setIsConverted(z ? 1 : 0);
            return insert(notesDocumentDao, notesMappedDocumentEntity, str, j);
        }
        return Pair.create(new AtomicInteger(0), new AtomicInteger());
    }

    @Transaction
    public void delete(NotesDocumentDao notesDocumentDao, Collection<DocumentData> collection) {
        for (DocumentData documentData : collection) {
            if (documentData != null) {
                delete(notesDocumentDao, documentData.getFilePath().endsWith(".sdocx"), documentData.getUuid());
            }
        }
    }

    @Transaction
    public Pair<AtomicInteger, AtomicInteger> insert(NotesDocumentDao notesDocumentDao, String str, String str2, boolean z) {
        long documentServerTimestamp = getDocumentServerTimestamp(notesDocumentDao, str);
        String str3 = TAG;
        StringBuilder sbM16m = AbstractC0000a.m16m("insert, originalDocumentUuid : ", str, ", mappedDocumentUuid : ", str2, ", originalServerTimestamp : ");
        sbM16m.append(documentServerTimestamp);
        sbM16m.append(", isConverted : ");
        sbM16m.append(z);
        DataLogger.m12307i(str3, sbM16m.toString());
        return insert(notesDocumentDao, str, str2, documentServerTimestamp, z);
    }

    @Transaction
    public void insert(HashMap<String, Long> map) {
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (findLatestMappedUuid(entry.getKey()) == null && entry.getValue() != null && entry.getValue().longValue() != 0) {
                NotesMappedDocumentEntity notesMappedDocumentEntity = new NotesMappedDocumentEntity();
                notesMappedDocumentEntity.setUuid(entry.getKey());
                notesMappedDocumentEntity.setMappedAt(entry.getValue().longValue());
                notesMappedDocumentEntity.setMappedUuid("SYNCED_" + notesMappedDocumentEntity.getUuid());
                notesMappedDocumentEntity.setIsConverted(1);
                upsert(notesMappedDocumentEntity);
                DataLogger.m12307i(TAG, "insert, originalDocumentUuid : " + entry.getKey() + ", mappedDocumentUuid : SYNCED_" + notesMappedDocumentEntity.getUuid());
            }
        }
    }
}
