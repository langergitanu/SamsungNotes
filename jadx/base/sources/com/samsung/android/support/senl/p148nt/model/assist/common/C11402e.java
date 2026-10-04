package com.samsung.android.support.senl.p148nt.model.assist.common;

import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.support.senl.p148nt.model.assist.common.C2paHandler;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.assist.common.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C11402e implements OnCompleteListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7673a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2paHandler f7674b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f7675c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ String f7676d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C2paHandler.CallbackImpl f7677e;

    public /* synthetic */ C11402e(C2paHandler c2paHandler, String str, String str2, C2paHandler.CallbackImpl callbackImpl, int i) {
        this.f7673a = i;
        this.f7674b = c2paHandler;
        this.f7675c = str;
        this.f7676d = str2;
        this.f7677e = callbackImpl;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        switch (this.f7673a) {
            case 0:
                this.f7674b.lambda$copyC2paManifestList$3(this.f7675c, this.f7676d, this.f7677e, task);
                break;
            default:
                this.f7674b.lambda$copyAndAppendC2paManifest$0(this.f7675c, this.f7676d, this.f7677e, task);
                break;
        }
    }
}
