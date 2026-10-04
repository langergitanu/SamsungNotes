package com.samsung.scsp.framework.core.network.base;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.network.base.NetworkImpl;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.network.base.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11679i implements NetworkImpl.ConnectionSetter, FaultBarrier.ThrowableRunnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8243a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8244b;

    public /* synthetic */ C11679i(Object obj, int i) {
        this.f8243a = i;
        this.f8244b = obj;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() throws IOException {
        switch (this.f8243a) {
            case 1:
                ((Closeable) this.f8244b).close();
                break;
            default:
                ((FileInputStream) this.f8244b).close();
                break;
        }
    }

    @Override // com.samsung.scsp.framework.core.network.base.NetworkImpl.ConnectionSetter
    public void setup(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setRequestMethod((String) this.f8244b);
    }
}
