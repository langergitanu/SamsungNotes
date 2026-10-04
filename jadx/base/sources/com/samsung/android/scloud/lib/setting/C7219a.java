package com.samsung.android.scloud.lib.setting;

import com.samsung.android.scloud.lib.setting.LibSyncScheduleManager;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.scloud.lib.setting.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7219a implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4847a;

    public /* synthetic */ C7219a(int i) {
        this.f4847a = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        SyncPerformancePolicy syncPerformancePolicy = (SyncPerformancePolicy) obj;
        switch (this.f4847a) {
            case 0:
                LibSyncScheduleManager.lambda$handleSingleRequest$3(syncPerformancePolicy);
                break;
            case 1:
                LibSyncScheduleManager.RequestTask.lambda$run$0(syncPerformancePolicy);
                break;
            default:
                SyncSettingProviderClient.lambda$loadPerformancePolicy$2(syncPerformancePolicy);
                break;
        }
    }
}
