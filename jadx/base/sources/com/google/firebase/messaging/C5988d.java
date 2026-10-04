package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;

/* JADX INFO: renamed from: com.google.firebase.messaging.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5988d implements SuccessContinuation, RequestDeduplicator.GetTokenRequest {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ FirebaseMessaging f3519a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f3520b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Store.Token f3521c;

    public /* synthetic */ C5988d(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f3519a = firebaseMessaging;
        this.f3520b = str;
        this.f3521c = token;
    }

    @Override // com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest
    public Task start() {
        return this.f3519a.lambda$blockingGetToken$10(this.f3520b, this.f3521c);
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        return this.f3519a.lambda$blockingGetToken$9(this.f3520b, this.f3521c, (String) obj);
    }
}
