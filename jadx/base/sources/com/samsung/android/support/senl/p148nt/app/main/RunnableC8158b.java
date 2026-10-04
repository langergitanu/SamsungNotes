package com.samsung.android.support.senl.p148nt.app.main;

import com.samsung.android.support.senl.p148nt.app.main.AppLaunchManager;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8158b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6150a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6151b;

    public /* synthetic */ RunnableC8158b(Object obj, int i) {
        this.f6150a = i;
        this.f6151b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6150a) {
            case 0:
                ((AppLaunchManager) this.f6151b).lambda$onCheckNewVersion$2();
                break;
            case 1:
                ((AppLaunchManager) this.f6151b).lambda$migrateCoverData$5();
                break;
            case 2:
                ((AppLaunchManager) this.f6151b).lambda$deleteDuplicatedDB$1();
                break;
            case 3:
                ((AppLaunchManager) this.f6151b).lambda$restoreDatabase$0();
                break;
            default:
                ((AppLaunchManager.C81441) this.f6151b).lambda$onFinish$0();
                break;
        }
    }
}
