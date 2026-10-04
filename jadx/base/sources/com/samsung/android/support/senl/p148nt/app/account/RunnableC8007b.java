package com.samsung.android.support.senl.p148nt.app.account;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.account.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8007b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6058a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Activity f6059b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6060c;

    public /* synthetic */ RunnableC8007b(Activity activity, String str, int i) {
        this.f6058a = i;
        this.f6059b = activity;
        this.f6060c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6058a) {
            case 0:
                ToastHandler.show(this.f6059b, (String) this.f6060c, 1);
                break;
            case 1:
                ToastHandler.show(this.f6059b, (String) this.f6060c, 1);
                break;
            default:
                ((GUIDManager) this.f6060c).lambda$requestAndWaitGuidReceived$2(this.f6059b);
                break;
        }
    }

    public /* synthetic */ RunnableC8007b(GUIDManager gUIDManager, Activity activity) {
        this.f6058a = 2;
        this.f6060c = gUIDManager;
        this.f6059b = activity;
    }
}
