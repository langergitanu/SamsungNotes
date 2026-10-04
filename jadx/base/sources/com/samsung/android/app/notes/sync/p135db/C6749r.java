package com.samsung.android.app.notes.sync.p135db;

import android.content.Context;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncInfoEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.DocumentTempDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.ArrayList;
import p001A.AbstractC0000a;
import p234q1.C14433b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6749r {

    /* JADX INFO: renamed from: a */
    public final NotesDocumentRepository f4133a;

    /* JADX INFO: renamed from: b */
    public final SyncNoteDataRepository f4134b;

    /* JADX INFO: renamed from: c */
    public final DocumentTempDataRepository f4135c;

    /* JADX INFO: renamed from: d */
    public final C14433b f4136d = new C14433b(12);

    /* JADX INFO: renamed from: e */
    public final Context f4137e;

    public C6749r(Context context) {
        this.f4133a = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        this.f4134b = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        this.f4135c = NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
        this.f4137e = context;
    }

    /* JADX INFO: renamed from: a */
    public final void m4885a(String str, String str2) {
        StringBuilder sbM16m = AbstractC0000a.m16m("[SyncDelete] deleteAfterServerUpdate, docUUID: ", str, " by ", str2, ", callee: ");
        sbM16m.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        Debugger.m8614f("WDocWriteResolver", sbM16m.toString());
        DocumentWriteResolver.deleteEntityFromDocumentTable(this.f4137e, str);
        this.f4136d.m15037k(str);
    }

    /* JADX INFO: renamed from: b */
    public final void m4886b(int i, String str, String str2) {
        StringBuilder sbM16m = AbstractC0000a.m16m("[SyncDelete] deleteAllNoteData, docUUID: ", str, " by ", str2, ", callee: ");
        sbM16m.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        Debugger.m8614f("WDocWriteResolver", sbM16m.toString());
        DocumentWriteResolver.deleteAllNoteData(this.f4137e, str, i);
        this.f4136d.m15037k(str);
    }

    /* JADX INFO: renamed from: c */
    public final void m4887c(String str, String str2) {
        AbstractC4539a.m3190D("setCommitId() : ", str2, "WDocWriteResolver");
        this.f4134b.updateCommitId(str, str2);
    }

    /* JADX INFO: renamed from: d */
    public final void m4888d(int i, String str) {
        this.f4134b.updateDirty(str, i);
    }

    /* JADX INFO: renamed from: e */
    public final void m4889e(String str, String str2, int i, long j, long j2, String str3, String str4) {
        long j3;
        String str5;
        SyncNoteDataRepository syncNoteDataRepository = this.f4134b;
        boolean zIsExist = syncNoteDataRepository.isExist(str);
        SyncInfoEntity syncInfoEntityCreateOrUpdateSyncInfoEntity = syncNoteDataRepository.get(str);
        if (zIsExist) {
            int i2 = FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED.equals(str3) ? 2 : 0;
            String str6 = str2;
            String str7 = "uncategorized:///";
            if ("root".equals(str6)) {
                str6 = FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED.equals(str3) ? "trash:///" : "uncategorized:///";
            }
            if (i2 == 0) {
                StringBuilder sbM16m = AbstractC0000a.m16m("setNoteFolder, sDocUUID : ", str, ", folderUUID : ", str6, ", isDeleted : ");
                sbM16m.append(i2);
                Debugger.m8614f("WDocWriteResolver", sbM16m.toString());
                j3 = j2;
                str5 = str4;
            } else {
                StringBuilder sbM16m2 = AbstractC0000a.m16m("setNoteFolder, sDocUUID : ", str, ", folderUUID : ", str6, ", isDeleted : ");
                sbM16m2.append(i2);
                sbM16m2.append(", recyclerBinTimeMoved = ");
                j3 = j2;
                sbM16m2.append(j3);
                sbM16m2.append(", restorePath = ");
                str5 = str4;
                sbM16m2.append(str5);
                Debugger.m8614f("WDocWriteResolver", sbM16m2.toString());
            }
            if ("1".equals(str6)) {
                Debugger.m8614f("WDocWriteResolver", "setNoteFolder, Fix parent UUID " + str6 + " to uncategorized:///");
            } else {
                str7 = str6;
            }
            if (syncInfoEntityCreateOrUpdateSyncInfoEntity == null) {
                syncInfoEntityCreateOrUpdateSyncInfoEntity = this.f4133a.createOrUpdateSyncInfoEntity(str);
            }
            int i4 = i2;
            this.f4134b.updateEntityBySetNoteFolder(str, i4, str7, j, i, j3, str5);
            syncNoteDataRepository.insert(syncInfoEntityCreateOrUpdateSyncInfoEntity);
            if (i4 != 2 || WidgetAccessHandler.getWidgetAccessContract() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            WidgetAccessHandler.getWidgetAccessContract().sendDeleteUuidWidgetBroadcast(this.f4137e, arrayList);
        }
    }
}
