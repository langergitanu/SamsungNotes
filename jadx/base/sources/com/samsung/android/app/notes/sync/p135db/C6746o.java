package com.samsung.android.app.notes.sync.p135db;

import android.content.Intent;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6746o implements IDocumentServiceWrapper.DocumentServiceListener {
    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
    public final void onChangedDocumentByUser(DocumentSubscriptionId documentSubscriptionId, String str) {
        Logger.m8697d("SyncSaveDocumentManager", "onServiceConnected, onChangedDocumentByUser");
    }

    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
    public final void onChangedWorkingState(String str, SchedulerDataSource.WorkingState workingState, DocumentSubscriptionId documentSubscriptionId) {
        Logger.m8697d("SyncSaveDocumentManager", "onChangedWorkingState, uuid : " + str + ", workingState : " + workingState + ", owner : " + documentSubscriptionId);
    }

    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
    public final void onForceClosedDocument() {
        Logger.m8697d("SyncSaveDocumentManager", "onServiceConnected, onForceClosedDocument");
    }

    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
    public final void onOpenedByUser(DocumentSubscriptionId documentSubscriptionId, String str) {
        Logger.m8697d("SyncSaveDocumentManager", "onServiceConnected, onOpenedByUser");
    }

    @Override // com.samsung.android.support.senl.nt.model.service.IDocumentServiceWrapper.DocumentServiceListener
    public final void onReceiveBroadcastMessage(DocumentSubscriptionId documentSubscriptionId, Intent intent) {
        Logger.m8697d("SyncSaveDocumentManager", "onReceiveBroadcastMessage, sender : " + documentSubscriptionId + ", intent : " + intent);
    }
}
