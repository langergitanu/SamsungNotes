package com.samsung.android.support.senl.p148nt.coedit.caller.handler;

import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.WaitForDownloadHandler;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.WaitForSyncHandler;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.caller.handler.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9011a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6606a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ IAuthInfoReqListener f6607b;

    public /* synthetic */ RunnableC9011a(IAuthInfoReqListener iAuthInfoReqListener, int i) {
        this.f6606a = i;
        this.f6607b = iAuthInfoReqListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6606a) {
            case 0:
                ((WaitForDownloadHandler.HandlerC90071.AnonymousClass1) this.f6607b).lambda$onReceived$0();
                break;
            default:
                ((WaitForSyncHandler.HandlerC90091.AnonymousClass1) this.f6607b).lambda$onReceived$0();
                break;
        }
    }
}
