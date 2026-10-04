package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: renamed from: com.google.firebase.messaging.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5987c implements SuccessContinuation {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3517a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f3518b;

    public /* synthetic */ C5987c(String str, int i) {
        this.f3517a = i;
        this.f3518b = str;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        switch (this.f3517a) {
            case 0:
                return FirebaseMessaging.lambda$subscribeToTopic$7(this.f3518b, (TopicsSubscriber) obj);
            default:
                return FirebaseMessaging.lambda$unsubscribeFromTopic$8(this.f3518b, (TopicsSubscriber) obj);
        }
    }
}
