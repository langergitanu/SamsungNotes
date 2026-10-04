package com.samsung.scsp.framework.core.identity;

import com.google.gson.JsonObject;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.Network;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.identity.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11659d implements Network.StreamListener, FaultBarrier.ThrowableRunnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8205a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8206b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8207c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f8208d;

    public /* synthetic */ C11659d(Object obj, int i, Object obj2, Object obj3) {
        this.f8205a = i;
        this.f8206b = obj;
        this.f8207c = obj2;
        this.f8208d = obj3;
    }

    @Override // com.samsung.scsp.framework.core.network.Network.StreamListener
    public void onStream(HttpRequest httpRequest, Map map, InputStream inputStream) {
        switch (this.f8205a) {
            case 0:
                ((AbstractRegisterApi) this.f8206b).lambda$register$1((Map) this.f8207c, (JsonObject) this.f8208d, httpRequest, map, inputStream);
                break;
            default:
                ((UserUpdateApiImpl) this.f8206b).lambda$update$0((PushInfoList) this.f8207c, (DeviceInfo) this.f8208d, httpRequest, map, inputStream);
                break;
        }
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() {
        ((UserUpdater) this.f8206b).lambda$update$0((PushInfoList) this.f8207c, (DeviceInfo) this.f8208d);
    }
}
