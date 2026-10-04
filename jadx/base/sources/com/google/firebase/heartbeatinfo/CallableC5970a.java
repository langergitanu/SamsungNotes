package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.google.firebase.heartbeatinfo.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class CallableC5970a implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3501a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DefaultHeartBeatController f3502b;

    public /* synthetic */ CallableC5970a(DefaultHeartBeatController defaultHeartBeatController, int i) {
        this.f3501a = i;
        this.f3502b = defaultHeartBeatController;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f3501a) {
            case 0:
                return this.f3502b.lambda$getHeartBeatsHeader$1();
            default:
                return this.f3502b.lambda$registerHeartBeat$0();
        }
    }
}
