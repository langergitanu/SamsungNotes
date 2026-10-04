package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.common.Holder;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.Network;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.identity.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11658c implements FaultBarrier.ThrowableSupplier, FaultBarrier.ThrowableRunnable, Network.StreamListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8202a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8203b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8204c;

    public /* synthetic */ C11658c(Object obj, Object obj2, int i) {
        this.f8202a = i;
        this.f8203b = obj;
        this.f8204c = obj2;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        switch (this.f8202a) {
            case 0:
                return ((AbstractRegisterApi) this.f8203b).lambda$makeRequestHeader$2((SContextHolder) this.f8204c);
            case 1:
            default:
                return ((DeviceId) this.f8203b).lambda$generateStrongDeviceIDHash$0((String) this.f8204c);
            case 2:
                return ((AbstractToken) this.f8203b).lambda$renew$0((String) this.f8204c);
        }
    }

    @Override // com.samsung.scsp.framework.core.network.Network.StreamListener
    public void onStream(HttpRequest httpRequest, Map map, InputStream inputStream) throws ScspException {
        switch (this.f8202a) {
            case 3:
                ((AbstractTokenApi) this.f8203b).lambda$renew$1((Holder) this.f8204c, httpRequest, map, inputStream);
                break;
            default:
                ((DeviceUpdateApiImpl) this.f8203b).lambda$update$0((DeviceInfo) this.f8204c, httpRequest, map, inputStream);
                break;
        }
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() {
        switch (this.f8202a) {
            case 1:
                AbstractRegisterApi.lambda$makeRequestHeader$3((E2eeInfoSupplier) this.f8203b, (HashMap) this.f8204c);
                break;
            case 5:
                ((DeviceUpdater) this.f8203b).lambda$update$0((DeviceInfo) this.f8204c);
                break;
            default:
                ((UserRegistration) this.f8203b).deregister((String) this.f8204c);
                break;
        }
    }
}
