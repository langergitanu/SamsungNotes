package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.content.Intent;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ServiceContractImpl;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9960d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7076a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7077b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f7078c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f7079d;

    public /* synthetic */ RunnableC9960d(Object obj, int i, Object obj2, Object obj3) {
        this.f7076a = i;
        this.f7077b = obj;
        this.f7078c = obj2;
        this.f7079d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7076a) {
            case 0:
                ((ServiceContractImpl.C99541) this.f7077b).lambda$fail$0((Activity) this.f7078c, (String) this.f7079d);
                break;
            default:
                ((Initializer) this.f7077b).lambda$handleActionSend$0((EntryAction) this.f7078c, (Intent) this.f7079d);
                break;
        }
    }
}
