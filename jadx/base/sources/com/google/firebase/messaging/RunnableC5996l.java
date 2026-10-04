package com.google.firebase.messaging;

import com.google.firebase.messaging.WithinAppServiceConnection;

/* JADX INFO: renamed from: com.google.firebase.messaging.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC5996l implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3537a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3538b;

    public /* synthetic */ RunnableC5996l(Object obj, int i) {
        this.f3537a = i;
        this.f3538b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3537a) {
            case 0:
                ((SharedPreferencesQueue) this.f3538b).syncState();
                break;
            default:
                ((WithinAppServiceConnection.BindRequest) this.f3538b).lambda$arrangeTimeout$0();
                break;
        }
    }
}
