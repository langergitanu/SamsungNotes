package com.samsung.android.support.senl.p148nt.app.labs;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.labs.SpenDocumentTester;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.labs.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8097b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6112a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6113b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6114c;

    public /* synthetic */ RunnableC8097b(Context context, String str) {
        this.f6112a = 2;
        this.f6114c = context;
        this.f6113b = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f6112a) {
            case 0:
                ((DatabaseTester) this.f6113b).lambda$arrange$0((Context) this.f6114c);
                break;
            case 1:
                ((SpenDocumentTester) this.f6113b).lambda$updateProgressMessage$0((String) this.f6114c);
                break;
            case 2:
                SpenDocumentTester.C80914.lambda$finish$0((Context) this.f6114c, (String) this.f6113b);
                break;
            default:
                ((DocumentTest) this.f6113b).lambda$executeGenAIAutoTest$3((DialogUtils.ProgressDialog) this.f6114c);
                break;
        }
    }

    public /* synthetic */ RunnableC8097b(Object obj, Object obj2, int i) {
        this.f6112a = i;
        this.f6113b = obj;
        this.f6114c = obj2;
    }
}
