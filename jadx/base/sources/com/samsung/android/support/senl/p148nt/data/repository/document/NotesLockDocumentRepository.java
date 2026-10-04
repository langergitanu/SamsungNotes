package com.samsung.android.support.senl.p148nt.data.repository.document;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesLockDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesLockDocumentRepository {
    private static final String TAG = DataLogger.createTag("NotesLockDocumentRepository");
    private final NotesLockDocumentDao mNotesLockDocumentDao = NotesDatabaseManager.getInstance().getLockDocumentDao();
    private final NotesCategoryTreeDao mNotesCategoryTreeDao = NotesDatabaseManager.getInstance().getCategoryTreeDao();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$getEntities$3(List list, List list2) {
        return this.mNotesLockDocumentDao.getEntities(list2, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$getLockNoteCount$0(List list, Collection collection) {
        return this.mNotesLockDocumentDao.getLockNoteCount(collection, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$getLockedEntitiesWithExcludeTypes$1(List list, List list2) {
        return this.mNotesLockDocumentDao.getLockedEntitiesWithExcludeTypes(list2, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$getLockedNoteUuidsWithExcludeTypes$2(List list, List list2) {
        return this.mNotesLockDocumentDao.getLockedNoteUuidsWithExcludeTypes(list2, list);
    }

    public void changeAccountGuidByUuid(String str, String str2) {
        this.mNotesLockDocumentDao.updateAccountGuidByUuid(str, str2);
    }

    public void changeLockGuidForUndefined(@NonNull String str, @LockType int... iArr) {
        DataLogger.m12307i(TAG, "changeLockGuidForUndefined, lockAccountGuid : " + DataLogger.pii(str) + " , lockTypes : " + Arrays.toString(iArr));
        this.mNotesLockDocumentDao.updateLockGuidForUndefined(str, iArr);
    }

    public List<String> find(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (z) {
            arrayList.addAll(this.mNotesCategoryTreeDao.getAllDocumentCategoryTree(str, false).getFolderUuids());
        }
        return this.mNotesLockDocumentDao.find(arrayList);
    }

    public int getAllLockedDataCount(@DeleteType int i) {
        DataLogger.m12307i(TAG, "getAllLockedDataCount, deleteType : " + i);
        return this.mNotesLockDocumentDao.getAllLockedDataCount(i);
    }

    public List<NotesDocumentEntity> getEntities(List<String> list, List<Integer> list2) {
        return new SplitTaskExecutor(new C11385b(this, list2, 1)).execute(list);
    }

    public int getLockNoteCount(List<String> list, List<Integer> list2) {
        return SplitTaskExecutor.getInt(new C11385b(this, list2, 2), list);
    }

    @LockType
    public int getLockType(@NonNull String str) {
        AbstractC0000a.m2C("getLockType, uuid : ", str, TAG);
        return this.mNotesLockDocumentDao.getLockType(str);
    }

    public List<NotesDocumentEntity> getLockedEntitiesWithExcludeTypes(List<String> list, List<Integer> list2) {
        return new SplitTaskExecutor(new C11385b(this, list2, 3)).execute(list);
    }

    public List<String> getLockedNoteUuidsWithExcludeTypes(List<String> list, List<Integer> list2) {
        return new SplitTaskExecutor(new C11385b(this, list2, 0)).execute(list);
    }

    public List<String> getPathListWithEmptyGuid(@LockType int... iArr) {
        return this.mNotesLockDocumentDao.getPathListWithEmptyGuid(iArr);
    }

    public void lockByUuid(@NonNull String str, @LockType int i) {
        DataLogger.m12307i(TAG, "lockByUuid, uuid : " + str + ", lockType : " + i);
        this.mNotesLockDocumentDao.lockByUuid(str, i);
    }
}
