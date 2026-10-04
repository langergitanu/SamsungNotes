package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import android.content.Context;
import com.samsung.android.app.notes.sync.p135db.C6749r;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import com.samsung.android.support.senl.p148nt.data.resolver.tag.OldHashtagResolver;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentDeleteUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p001A.AbstractC0000a;
import p093X.InterfaceC0334b;
import p244u1.C14477a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SDocResolverContractImpl implements InterfaceC0334b {
    private C6749r getWDocWriteResolver(Context context) {
        return new C6749r(context);
    }

    @Override // p093X.InterfaceC0334b
    public boolean convertTo32bitEncrypt(Context context, String str) {
        return true;
    }

    @Override // p093X.InterfaceC0334b
    public void deleteSDoc(Context context, String str, int i, boolean z) {
        String str2;
        NotesFolder folder;
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        if (i == 2) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean zEquals = PredefinedCategory.RECYCLE_BIN.getUuid().equals(syncNoteDataRepositoryCreateSyncNoteDataRepository.getCategoryUuid(str));
            String absolutePath = CategoryConstants.OldUncategorized.PATH;
            if (!zEquals && !PredefinedCategory.OLD_NOTES.getUuid().equals(syncNoteDataRepositoryCreateSyncNoteDataRepository.getCategoryUuid(str)) && (folder = NotesDataRepositoryFactory.newInstance(context).createDocumentCategoryTreeRepository().getAllDocumentCategoryTree(false).getFolder(syncNoteDataRepositoryCreateSyncNoteDataRepository.getCategoryUuid(str))) != null) {
                absolutePath = folder.getAbsolutePath();
            }
            String str3 = absolutePath;
            if (z) {
                str2 = str;
                syncNoteDataRepositoryCreateSyncNoteDataRepository.updateEntityByDeleteSdocToRecycleBinInSync(str2, i, jCurrentTimeMillis, "trash:///", str3);
            } else {
                str2 = str;
                syncNoteDataRepositoryCreateSyncNoteDataRepository.updateEntityByDeleteSdocToRecycleBin(str2, i, jCurrentTimeMillis, "trash:///", str3, 1, TimeManager.getCurrentTime(context));
            }
        } else {
            str2 = str;
            if (i == 1) {
                if (z) {
                    syncNoteDataRepositoryCreateSyncNoteDataRepository.setNoteDeleted(str2, i);
                } else {
                    long currentTime = TimeManager.getCurrentTime(context);
                    syncNoteDataRepositoryCreateSyncNoteDataRepository.updateEntityByDeleteSdocToDelete(str2, i, 1, currentTime, 1, currentTime);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(str2);
                NotesDocumentDeleteUtils.deleteDocumentFile(context, NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().getDocumentDataList(arrayList), 4);
                NotesDataRepositoryFactory.newInstance(context).createDocumentStrokeRepository().deleteByUuid(str2);
                NotesDataRepositoryFactory.newInstance(context).createDocumentRetryRepository().deleteByUuid(str2);
                NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().deleteByUuid(str2);
            }
        }
        C14477a.m15065b().m15073i();
        OldHashtagResolver.notifyTagBoardByUuid(context, str2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(str2);
        WidgetBroadcast.sendDeleteUUIDWidgetBroadcast(context, arrayList2);
    }

    @Override // p093X.InterfaceC0334b
    public void deleteSDocSync(Context context, String str, boolean z, String str2) {
        if (!z) {
            getWDocWriteResolver(context).m4885a(str, str2);
            return;
        }
        getWDocWriteResolver(context).m4886b(3, str, str2);
        if (NotesDatabaseManager.getInstance().getHashtagContentDao().deleteByUuid(str) > 0) {
            new NotesTagRepository(context).notifyTagBoard();
        }
    }

    public String getAccountGuid(Context context, String str) {
        return NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getLockAccountGuid(str);
    }

    @Override // p093X.InterfaceC0334b
    public int getDirtyCountOfNoteExtraInfo(Context context) {
        return NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getDirtyCountOfNoteExtraInfo();
    }

    @Override // p093X.InterfaceC0334b
    public int getNoteDeleted(Context context, String str) {
        int noteDeleted = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getNoteDeleted(str);
        if ("trash:///".equals(NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getCategoryUuid(str))) {
            return noteDeleted;
        }
        return 0;
    }

    @Override // p093X.InterfaceC0334b
    public String getNoteFilePath() {
        return WDocUtils.getNoteFilePath(BaseUtils.getApplicationContext());
    }

    @Override // p093X.InterfaceC0334b
    public long getNoteSaveTime(Context context, String str) {
        NotesDocumentEntity notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
        if (notesDocumentEntityM9f != null) {
            return notesDocumentEntityM9f.getLastModifiedAt();
        }
        return 0L;
    }

    @Override // p093X.InterfaceC0334b
    public long getNoteServerTime(Context context, String str) {
        Long noteServerTimestamp = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getNoteServerTimestamp(str);
        if (noteServerTimestamp == null) {
            return 0L;
        }
        return noteServerTimestamp.longValue();
    }

    @Override // p093X.InterfaceC0334b
    public int getSdocContractLockTypeNone() {
        return 0;
    }

    @Override // p093X.InterfaceC0334b
    public int getSdocContractLockTypeSdoc() {
        return 1;
    }

    @Override // p093X.InterfaceC0334b
    public int getSdocContractNo() {
        return 0;
    }

    @Override // p093X.InterfaceC0334b
    public int getSdocContractToRecycleBin() {
        return 2;
    }

    @Override // p093X.InterfaceC0334b
    public int getSdocContractYes() {
        return 1;
    }

    public String getTitle(Context context, String str) {
        return NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getTitle(str);
    }

    @Override // p093X.InterfaceC0334b
    public List<String> getUUIDList(Context context) {
        return NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getUuidListOldSync();
    }

    @Override // p093X.InterfaceC0334b
    public List<String> getUUIDListByCategoryDirty(Context context, int i) {
        return NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getUuidListByCategoryDirty(i);
    }

    public List<String> getUUIDListByDeleted(Context context, int i) {
        return NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getUuidListByDeleted(i);
    }

    @Override // p093X.InterfaceC0334b
    public List<String> getUUIDListByDirty(Context context, int i) {
        return NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getUuidListByDirty(i);
    }

    @Override // p093X.InterfaceC0334b
    public List<String> getUUIDListByDirtyForExtraInfo(Context context, int i) {
        return NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getUuidListByDirtyForExtraInfo(i);
    }

    @Override // p093X.InterfaceC0334b
    public List<String> getUUIDListByLocked(Context context, boolean z) {
        return NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getUuidListLockedNote(z);
    }

    @Override // p093X.InterfaceC0334b
    public HashMap<String, Long> getUuidAndNoteTimeList(Context context) {
        return NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getUuidAndNoteTimeList();
    }

    @Override // p093X.InterfaceC0334b
    public boolean isExistNote(Context context, String str) {
        return AbstractC0000a.m9f(context, str) != null;
    }

    @Override // p093X.InterfaceC0334b
    public void recoverySDoc(Context context, String str, long j, int i) {
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        NotesFolder notesFolderFind = NotesDataRepositoryFactory.newInstance(context).createDocumentCategoryTreeRepository().getAllDocumentCategoryTree(false).find(syncNoteDataRepositoryCreateSyncNoteDataRepository.getAbsolutePath(str));
        syncNoteDataRepositoryCreateSyncNoteDataRepository.updateEntityByRecoverySDoc(str, i, j, 0, notesFolderFind != null ? notesFolderFind.getUuid() : "1");
        NotesDataRepositoryFactory.newInstance(context).createDocumentContentRepository().updateIsDirtyAndIsDeleted(str, i, 0);
        C14477a.m15065b().m15073i();
    }

    @Override // p093X.InterfaceC0334b
    public void recycleBinResolverUpdateTimeMoved(Context context, String str, long j) {
        NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().updateRecycleBinResolverUpdateTimeMoved(str, j);
    }

    @Override // p093X.InterfaceC0334b
    public void restoreSDoc(Context context, String str, boolean z) {
        String str2;
        NotesDocumentEntity notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
        if (notesDocumentEntityM9f != null) {
            NotesFolder notesFolderFind = NotesDataRepositoryFactory.newInstance(context).createDocumentCategoryTreeRepository().getAllDocumentCategoryTree(false).find(notesDocumentEntityM9f.getAbsolutePath());
            String uuid = (notesFolderFind == null || PredefinedCategory.RECYCLE_BIN.getUuid().equals(notesFolderFind.getUuid()) || PredefinedCategory.OLD_NOTES.getUuid().equals(notesFolderFind.getUuid())) ? "1" : notesFolderFind.getUuid();
            if (z) {
                str2 = str;
                NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().updateEntityByRestoreSDocInSync(str2, 0, 0, uuid);
            } else {
                str2 = str;
                NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().updateEntityByRestoreSDoc(str2, 0, 0, 1, TimeManager.getCurrentTime(context), uuid);
            }
        } else {
            str2 = str;
        }
        NotesDataRepositoryFactory.newInstance(context).createDocumentContentRepository().updateIsDeleted(str2, 0);
        C14477a.m15065b().m15073i();
        OldHashtagResolver.notifyTagBoardByUuid(context, str2);
    }

    @Override // p093X.InterfaceC0334b
    public void setNoteDirty(Context context, String str, int i) {
        getWDocWriteResolver(context).m4888d(i, str);
    }

    @Override // p093X.InterfaceC0334b
    public int setNoteFavorite(Context context, String str, boolean z, boolean z2) {
        if (z2) {
            return NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().updateNoteFavorite(str, z ? 1 : 0);
        }
        return NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().updateNoteFavoriteAndCategoryDirtyTimestamp(str, z ? 1 : 0, TimeManager.getCurrentTime(context));
    }

    @Override // p093X.InterfaceC0334b
    public void setNoteServerTime(Context context, String str, long j) {
        NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().updateServerTimestamp(str, j);
    }

    @Override // p093X.InterfaceC0334b
    public void setNoteServerTimeAndDirty(Context context, String str, long j, int i) {
        NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().updateDirtyAndTimestamp(str, i, j);
    }

    @Override // p093X.InterfaceC0334b
    public String getNoteFilePath(Context context, String str) {
        return new NotesDocumentRepository(context).getPath(str);
    }
}
