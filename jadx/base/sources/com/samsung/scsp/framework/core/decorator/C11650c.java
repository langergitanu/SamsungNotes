package com.samsung.scsp.framework.core.decorator;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.Network;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.decorator.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11650c implements FaultBarrier.ThrowableSupplier, Network.StreamListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8180a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8181b;

    public /* synthetic */ C11650c(Object obj, int i) {
        this.f8180a = i;
        this.f8181b = obj;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        switch (this.f8180a) {
            case 0:
                return PlatformConfigurationImpl.lambda$downloadPlatformConfiguration$0((Map) this.f8181b);
            case 1:
            default:
                return AbstractDecorator.lambda$new$1((Constructor) this.f8181b);
            case 2:
                return PlatformConfigurationImpl.lambda$getMaxAge$6((List) this.f8181b);
        }
    }

    @Override // com.samsung.scsp.framework.core.network.Network.StreamListener
    public void onStream(HttpRequest httpRequest, Map map, InputStream inputStream) {
        ((PlatformConfigurationImpl) this.f8181b).lambda$downloadPlatformConfiguration$4(httpRequest, map, inputStream);
    }
}
