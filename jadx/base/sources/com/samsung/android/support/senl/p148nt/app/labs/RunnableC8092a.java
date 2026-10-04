package com.samsung.android.support.senl.p148nt.app.labs;

import android.content.Context;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.labs.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8092a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6110a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6111b;

    public /* synthetic */ RunnableC8092a(Object obj, int i) {
        this.f6110a = i;
        this.f6111b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6110a) {
            case 0:
                DatabaseTester.lambda$rearrangeDocumentTable$1((Context) this.f6111b);
                break;
            case 1:
                ((SpenDocumentTester) this.f6111b).lambda$hideProgressDialog$1();
                break;
            default:
                ((LabsActivity) this.f6111b).lambda$onClick$0();
                break;
        }
    }
}
