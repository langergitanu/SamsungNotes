package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: renamed from: com.google.firebase.messaging.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5995k implements Continuation, OnCompleteListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3534a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3535b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f3536c;

    public /* synthetic */ C5995k(Object obj, Object obj2, int i) {
        this.f3534a = i;
        this.f3535b = obj;
        this.f3536c = obj2;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        ((EnhancedIntentService) this.f3535b).lambda$onStartCommand$1((Intent) this.f3536c, task);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        switch (this.f3534a) {
            case 0:
                return ((RequestDeduplicator) this.f3535b).lambda$getOrStartGetTokenRequest$0((String) this.f3536c, task);
            default:
                return FcmBroadcastProcessor.lambda$startMessagingService$2((Context) this.f3535b, (Intent) this.f3536c, task);
        }
    }
}
