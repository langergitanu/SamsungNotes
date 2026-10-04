package com.samsung.android.scloud.lib.setting;

import com.samsung.android.scloud.lib.setting.LibSyncScheduleManager;
import java.util.ArrayList;
import java.util.function.Function;

/* JADX INFO: renamed from: com.samsung.android.scloud.lib.setting.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7221c implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4851a;

    public /* synthetic */ C7221c(int i) {
        this.f4851a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4851a) {
            case 0:
                return LibSyncScheduleManager.lambda$processRequest$4((LibSyncScheduleManager.CountUnit) obj);
            case 1:
                return LibSyncScheduleManager.RequestPendingStatus.lambda$addPendingUpload$0((String) obj);
            default:
                return Integer.valueOf(((ArrayList) obj).size());
        }
    }
}
