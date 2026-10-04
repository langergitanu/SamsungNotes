package com.samsung.android.app.notes.sync.p135db;

import android.content.Context;
import android.graphics.Bitmap;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.contract.DataToSyncManager;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncInfoEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentDeleteUtils;
import com.samsung.android.support.senl.p148nt.model.utils.OldDocumentThumbnailUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6733b implements DataToSyncManager.DataObserver, DataToSyncManager.DataContract {

    /* JADX INFO: renamed from: a */
    public final Context f4095a = DataUtils.getContext();

    @Override // com.samsung.android.support.senl.nt.data.contract.DataToSyncManager.DataContract
    public final String createHWThumbnailFiles(Context context, List list, String str, List list2, String str2, boolean z) {
        return OldDocumentThumbnailUtils.createHWThumbnailFiles(context, list, str, list2, str2, z);
    }

    @Override // com.samsung.android.support.senl.nt.data.contract.DataToSyncManager.DataContract
    public final String createThumbnailFile(Context context, Bitmap bitmap, String str) {
        return OldDocumentThumbnailUtils.createThumbnailFile(context, bitmap, str);
    }

    @Override // com.samsung.android.support.senl.nt.data.contract.DataToSyncManager.DataContract
    public final Bitmap decodeSampledBitmapFromFile(Context context, String str) {
        return OldDocumentThumbnailUtils.decodeSampledBitmapFromFile(context, str);
    }

    @Override // com.samsung.android.support.senl.nt.data.contract.DataToSyncManager.DataContract
    public final void deleteDocumentFile(Context context, List list, int i) {
        NotesDocumentDeleteUtils.deleteDocumentFile(context, list, i);
    }

    @Override // com.samsung.android.support.senl.nt.data.contract.DataToSyncManager.DataObserver
    public final void onCoeditDocumentSaved(String str, long j) {
        NotesDatabaseManager.getInstance().getSyncInfoDao().updateCheckPoint(str, j);
    }

    @Override // com.samsung.android.support.senl.nt.data.contract.DataToSyncManager.DataObserver
    public final void onCoverUpdated(String str) {
        Context context = this.f4095a;
        NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().updateDirtyAndTimestampByUuidList(Collections.singletonList(str), 1, TimeManager.getCurrentTime(context));
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }

    @Override // com.samsung.android.support.senl.nt.data.contract.DataToSyncManager.DataObserver
    public final void onMappedDocumentChanged(String str) {
        SyncInfoDao syncInfoDao = NotesDatabaseManager.getInstance().getSyncInfoDao();
        if (syncInfoDao.isExistByClientId(str)) {
            syncInfoDao.setExtraInfoDirty(str, 1);
            return;
        }
        SyncInfoEntity syncInfoEntity = new SyncInfoEntity();
        syncInfoEntity.setNoteClientId(str);
        syncInfoEntity.setIsExtraInfoDirty(1);
        syncInfoDao.upsert(syncInfoEntity);
    }

    @Override // com.samsung.android.support.senl.nt.data.contract.DataToSyncManager.DataObserver
    public final void onPostDocumentSaved(NotesDocumentEntity notesDocumentEntity) {
        if (UUIDUtils.isGenUuid(notesDocumentEntity.getUuid())) {
            return;
        }
        String serverId = notesDocumentEntity.getServerId();
        Debugger.m8615i("DataObserverImpl", "onPostDocumentSaved, serverId : " + notesDocumentEntity.getServerId() + ", isDirty: " + notesDocumentEntity.getIsDirty());
        if (serverId != null) {
            try {
                if (!serverId.isEmpty()) {
                    NotesDataRepositoryFactory.newInstance(this.f4095a).createSyncNoteDataRepository().updateServerId(notesDocumentEntity.getUuid(), serverId);
                }
            } catch (Exception e) {
                AbstractC0000a.m21r(e, new StringBuilder("onPostDocumentSaved, e : "), "DataObserverImpl");
                return;
            }
        }
        if (notesDocumentEntity.getIsDirty() != 1) {
            Debugger.m8615i("DataObserverImpl", "onPostDocumentSaved, not dirty!");
        } else if (notesDocumentEntity.getMdeSpaceId().isEmpty()) {
            RequestToSyncManager.INSTANCE.requestSyncByModification();
        } else {
            Debugger.m8615i("DataObserverImpl", "onPostDocumentSaved, spaceId is not empty!");
        }
    }

    @Override // com.samsung.android.support.senl.nt.data.contract.DataToSyncManager.DataObserver
    public final void onTagUpdated(Collection collection) {
        Context context = this.f4095a;
        NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().updateDirtyAndTimestampByUuidList(collection, 1, TimeManager.getCurrentTime(context));
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }
}
