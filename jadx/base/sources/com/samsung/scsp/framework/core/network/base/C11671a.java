package com.samsung.scsp.framework.core.network.base;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.Network;
import com.samsung.scsp.framework.core.network.base.NetworkImpl;
import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.network.base.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11671a implements NetworkImpl.ConnectionSetter, FaultBarrier.ThrowableRunnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8229a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ HttpRequest f8230b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8231c;

    public /* synthetic */ C11671a(HttpRequest httpRequest, Object obj, int i) {
        this.f8229a = i;
        this.f8230b = httpRequest;
        this.f8231c = obj;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() {
        NetworkImpl.lambda$execute$14(this.f8230b, (ScspException) this.f8231c);
    }

    @Override // com.samsung.scsp.framework.core.network.base.NetworkImpl.ConnectionSetter
    public void setup(HttpURLConnection httpURLConnection) throws IOException {
        switch (this.f8229a) {
            case 0:
                NetworkImpl.lambda$post$1(this.f8230b, (Network.StreamListener) this.f8231c, httpURLConnection);
                break;
            case 1:
                NetworkImpl.lambda$patch$3(this.f8230b, (Network.StreamListener) this.f8231c, httpURLConnection);
                break;
            default:
                NetworkImpl.lambda$put$2(this.f8230b, (Network.StreamListener) this.f8231c, httpURLConnection);
                break;
        }
    }
}
