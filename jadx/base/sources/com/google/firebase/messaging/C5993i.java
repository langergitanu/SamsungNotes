package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: renamed from: com.google.firebase.messaging.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5993i implements Continuation, OnCompleteListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3529a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3530b;

    public /* synthetic */ C5993i(Object obj, int i) {
        this.f3529a = i;
        this.f3530b = obj;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f3529a) {
            case 1:
                WakeLockHolder.completeWakefulIntent((Intent) this.f3530b);
                break;
            case 2:
                ((WithinAppServiceConnection.BindRequest) this.f3530b).finish();
                break;
            default:
                ((ScheduledFuture) this.f3530b).cancel(false);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return ((GmsRpc) this.f3530b).lambda$extractResponseWhenComplete$0(task);
    }
}
