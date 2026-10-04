package com.samsung.android.support.senl.p148nt.data.repository.recognition;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;
import p079T.C0287e;
import p124b4.C4204a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesStrokeRepository {
    private static final String TAG = DataLogger.createTag("NotesStrokeRepository");
    private final NotesStrokeDao mNotesStrokeDao = NotesDatabaseManager.getInstance().getStrokeDao();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuidAndPageIds$0(String str, List list) {
        this.mNotesStrokeDao.deleteByUuidAndPageIds(str, list);
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuidAndPageIds$1(String str, int[] iArr, List list) {
        this.mNotesStrokeDao.deleteByUuidAndPageIds(str, list, iArr);
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$deleteByUuidAndPageIdsWithExcludedTypes$2(String str, int[] iArr, List list) {
        this.mNotesStrokeDao.deleteByUuidAndPageIdsWithExcludedTypes(str, list, iArr);
        return new ArrayList();
    }

    public void deleteByUuid(@NonNull String str) {
        AbstractC0000a.m2C("deleteByUuid, uuid : ", str, TAG);
        this.mNotesStrokeDao.deleteByUuid(str);
    }

    public void deleteByUuidAndPageIds(String str, List<String> list) {
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("deleteByUuidAndPageIds, uuid : ", str, ", removedPages : ");
        sbM15l.append(list.size());
        DataLogger.m12307i(str2, sbM15l.toString());
        new SplitTaskExecutor(new C0287e(this, str, 3)).execute(list);
    }

    public void deleteByUuidAndPageIdsWithExcludedTypes(String str, List<String> list, int... iArr) {
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("deleteByUuidAndPageIdsWithExcludedTypes, uuid : ", str, ", removedPages : ");
        sbM15l.append(list.size());
        sbM15l.append(", excludedTypes : ");
        sbM15l.append(Arrays.toString(iArr));
        DataLogger.m12307i(str2, sbM15l.toString());
        new SplitTaskExecutor(new C4204a(this, str, iArr, 1)).execute(list);
    }

    public void deleteByUuidWithTypes(@NonNull String str, int... iArr) {
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("deleteByUuidWithTypes, uuid : ", str, ", types : ");
        sbM15l.append(Arrays.toString(iArr));
        DataLogger.m12307i(str2, sbM15l.toString());
        this.mNotesStrokeDao.deleteByUuidWithTypes(str, iArr);
    }

    public void deleteDummy() {
        this.mNotesStrokeDao.deleteDummy();
    }

    public List<NotesStrokeSearchEntity> getEntities(String str, int i) {
        DataLogger.m12307i(TAG, "getEntities, uuid: " + str + ", type: " + i);
        return this.mNotesStrokeDao.getEntities(str, i);
    }

    public List<NotesStrokeSearchEntity> getEntityListWithExcludedTypes(String str, int... iArr) {
        return this.mNotesStrokeDao.getEntityListWithExcludedTypes(str, iArr);
    }

    public List<String> getPageIdListByUuid(String str, int... iArr) {
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("getPageIdListByUuid, uuid : ", str, ", type : ");
        sbM15l.append(Arrays.toString(iArr));
        DataLogger.m12307i(str2, sbM15l.toString());
        return this.mNotesStrokeDao.getPageIdListByUuid(str, iArr);
    }

    public void insert(@NonNull NotesStrokeSearchEntity notesStrokeSearchEntity) {
        this.mNotesStrokeDao.upsert(notesStrokeSearchEntity);
    }

    public void insert(@NonNull Collection<? extends NotesStrokeSearchEntity> collection) {
        this.mNotesStrokeDao.upsert((Collection) collection);
    }

    public void deleteByUuid(@NonNull Collection<String> collection) {
        DataLogger.m12307i(TAG, "deleteByUuid, uuidList : " + collection);
        this.mNotesStrokeDao.deleteByUuid(collection);
    }

    public void deleteByUuidAndPageIds(String str, List<String> list, int... iArr) {
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("deleteByUuidAndPageIds, uuid: ", str, ", removedPages: ");
        sbM15l.append(list.size());
        sbM15l.append(", types: ");
        sbM15l.append(Arrays.toString(iArr));
        DataLogger.m12307i(str2, sbM15l.toString());
        new SplitTaskExecutor(new C4204a(this, str, iArr, 0)).execute(list);
    }
}
