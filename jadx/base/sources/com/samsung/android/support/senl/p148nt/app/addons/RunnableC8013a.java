package com.samsung.android.support.senl.p148nt.app.addons;

import com.samsung.android.support.senl.p148nt.app.sync.providers.DataUpdateObserverImpl;
import java.util.Collection;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.addons.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8013a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6061a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Collection f6062b;

    public /* synthetic */ RunnableC8013a(Collection collection, int i) {
        this.f6061a = i;
        this.f6062b = collection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6061a) {
            case 0:
                AddonsCopyController.deleteFiles$lambda$0(this.f6062b);
                break;
            case 1:
                DataUpdateObserverImpl.lambda$onDocumentMovedToTrash$2(this.f6062b);
                break;
            case 2:
                DataUpdateObserverImpl.lambda$onDocumentUpdated$3(this.f6062b);
                break;
            default:
                DataUpdateObserverImpl.lambda$onDocumentLocked$1(this.f6062b);
                break;
        }
    }
}
