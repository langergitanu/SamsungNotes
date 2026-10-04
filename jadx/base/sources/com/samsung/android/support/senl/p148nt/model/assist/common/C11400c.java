package com.samsung.android.support.senl.p148nt.model.assist.common;

import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.support.senl.p148nt.model.assist.common.C2paHandler;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.assist.common.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C11400c implements OnCompleteListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7667a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2paHandler f7668b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C2paHandler.InnerCallback f7669c;

    public /* synthetic */ C11400c(C2paHandler c2paHandler, C2paHandler.InnerCallback innerCallback, int i) {
        this.f7667a = i;
        this.f7668b = c2paHandler;
        this.f7669c = innerCallback;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        switch (this.f7667a) {
            case 0:
                this.f7668b.lambda$addC2paCreateManifest$1(this.f7669c, task);
                break;
            default:
                this.f7668b.lambda$addC2paManifestList$4(this.f7669c, task);
                break;
        }
    }
}
