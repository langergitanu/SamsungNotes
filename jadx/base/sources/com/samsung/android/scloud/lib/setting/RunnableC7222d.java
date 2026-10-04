package com.samsung.android.scloud.lib.setting;

import com.samsung.android.scloud.lib.setting.LibSyncScheduleManager;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.scloud.lib.setting.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7222d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4852a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4853b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4854c;

    public /* synthetic */ RunnableC7222d(Object obj, Object obj2, int i) {
        this.f4852a = i;
        this.f4853b = obj;
        this.f4854c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4852a) {
            case 0:
                ((LibSyncScheduleManager) this.f4853b).lambda$requestCloud$2((LibSyncScheduleManager.RequestPendingStatus) this.f4854c);
                break;
            default:
                ((SyncPerformancePolicyManager) this.f4853b).lambda$loadPolicy$0((Consumer) this.f4854c);
                break;
        }
    }
}
