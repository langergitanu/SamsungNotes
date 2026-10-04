package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;

/* JADX INFO: renamed from: com.google.firebase.messaging.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5990f implements OnSuccessListener, FirebaseInstanceIdInternal.NewTokenListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ FirebaseMessaging f3524a;

    public /* synthetic */ C5990f(FirebaseMessaging firebaseMessaging) {
        this.f3524a = firebaseMessaging;
    }

    @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener
    public void onNewToken(String str) {
        this.f3524a.lambda$new$0(str);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        this.f3524a.lambda$new$2((TopicsSubscriber) obj);
    }
}
