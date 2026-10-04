package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: com.google.firebase.messaging.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC5991g implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3525a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3526b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ TaskCompletionSource f3527c;

    public /* synthetic */ RunnableC5991g(Object obj, TaskCompletionSource taskCompletionSource, int i) {
        this.f3525a = i;
        this.f3526b = obj;
        this.f3527c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3525a) {
            case 0:
                ((FirebaseMessaging) this.f3526b).lambda$getToken$4(this.f3527c);
                break;
            case 1:
                ((FirebaseMessaging) this.f3526b).lambda$deleteToken$5(this.f3527c);
                break;
            case 2:
                ((FirebaseMessaging) this.f3526b).lambda$deleteToken$6(this.f3527c);
                break;
            default:
                ((ImageDownload) this.f3526b).lambda$start$0(this.f3527c);
                break;
        }
    }
}
