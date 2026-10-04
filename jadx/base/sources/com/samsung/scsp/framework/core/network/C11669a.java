package com.samsung.scsp.framework.core.network;

import android.content.Context;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.network.HttpRequestImpl;
import com.samsung.scsp.framework.core.network.NetworkPermissionFactoryLoader;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.network.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11669a implements FaultBarrier.ThrowableRunnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8224a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8225b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8226c;

    public /* synthetic */ C11669a(int i, Object obj, String str) {
        this.f8224a = i;
        this.f8225b = obj;
        this.f8226c = str;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public final void run() {
        switch (this.f8224a) {
            case 0:
                NetworkPermissionFactoryLoader.lambda$load$0((NetworkPermissionFactoryLoader.NetworkPermissionFactoryHolder) this.f8225b, (String) this.f8226c);
                break;
            case 1:
                NetworkPermissionFactoryLoader.lambda$load$2((Context) this.f8226c, (NetworkPermissionFactoryLoader.NetworkPermissionFactoryHolder) this.f8225b);
                break;
            default:
                ((HttpRequestImpl.HttpRequestBuilder) this.f8225b).lambda$putNetworkHeader$0((String) this.f8226c);
                break;
        }
    }

    public /* synthetic */ C11669a(Context context, NetworkPermissionFactoryLoader.NetworkPermissionFactoryHolder networkPermissionFactoryHolder) {
        this.f8224a = 1;
        this.f8226c = context;
        this.f8225b = networkPermissionFactoryHolder;
    }
}
