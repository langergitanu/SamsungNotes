package com.samsung.android.app.notes.sync.p135db;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceBinder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class SyncSaveDocumentManager$DocumentServiceConnection implements ServiceConnection {
    private boolean mRequestDisconnect;
    final /* synthetic */ C6747p this$0;

    public /* synthetic */ SyncSaveDocumentManager$DocumentServiceConnection(C6747p c6747p, int i) {
        this(c6747p);
    }

    public boolean isRequestDisconnect() {
        return this.mRequestDisconnect;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Logger.m8697d("SyncSaveDocumentManager", "onServiceConnected");
        synchronized (this.this$0.f4127g) {
            try {
                if (isRequestDisconnect()) {
                    this.this$0.f4126f.set(true);
                    return;
                }
                this.this$0.f4125e = ((IDocumentServiceBinder) iBinder).subscribe(DocumentSubscriptionId.SYNC_SERVICE_ID.getUser(), this.this$0.f4124d);
                C6747p c6747p = this.this$0;
                c6747p.f4124d = c6747p.f4125e.getUser();
                this.this$0.f4125e.registerDocumentServiceListener(new C6746o());
                this.this$0.f4126f.set(true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Logger.m8697d("SyncSaveDocumentManager", "onServiceDisconnected");
    }

    public void setRequestDisconnect(boolean z) {
        this.mRequestDisconnect = z;
    }

    private SyncSaveDocumentManager$DocumentServiceConnection(C6747p c6747p) {
        this.this$0 = c6747p;
        this.mRequestDisconnect = false;
    }
}
