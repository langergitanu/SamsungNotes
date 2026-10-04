package com.samsung.android.sdk.scs.p142ai.asr.safety;

import com.samsung.android.sdk.scs.p142ai.asr.safety.WatchDogService;
import java.util.Map;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.safety.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC7704g implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5157a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WatchDogService.RepeatableTask f5158b;

    public /* synthetic */ RunnableC7704g(WatchDogService.RepeatableTask repeatableTask, int i) {
        this.f5157a = i;
        this.f5158b = repeatableTask;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f5157a;
        WatchDogService.RepeatableTask repeatableTask = this.f5158b;
        switch (i) {
            case 0:
                Map<Thread, WatchDog> map = WatchDogService.watchDogHolders;
                repeatableTask.exec();
                break;
            default:
                repeatableTask.iteration();
                break;
        }
    }
}
