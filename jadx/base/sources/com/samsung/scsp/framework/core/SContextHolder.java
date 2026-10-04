package com.samsung.scsp.framework.core;

import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.common.Holder;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.decorator.SdkConfig;
import com.samsung.scsp.framework.core.network.Network;
import com.samsung.scsp.framework.core.network.NetworkFunction;
import com.samsung.scsp.framework.core.network.NetworkPermissionFactoryLoader;
import com.samsung.scsp.framework.core.network.base.NetworkImpl;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SContextHolder {
    public final String applicationId;
    public final SdkConfig.Domain domain;
    public final boolean isAccountRequiredFeature;
    public final boolean isDrsSupportedFeature;
    public Network network;
    public int requestTimeOut = 60000;
    public SContext scontext;
    public final String userAgent;
    public final String version;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NetworkFactory {
        private NetworkFactory() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Network get(SContext sContext) {
            final Predicate<String> predicate = NetworkPermissionFactoryLoader.load(ContextFactory.getApplicationContext()).get();
            final NetworkFunction urlStreamHandlerFactorySupplier = sContext.getUrlStreamHandlerFactorySupplier();
            if (urlStreamHandlerFactorySupplier != null) {
                final Holder holder = new Holder();
                FaultBarrier.run(new FaultBarrier.ThrowableRunnable() { // from class: com.samsung.scsp.framework.core.c
                    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
                    public final void run() {
                        SContextHolder.NetworkFactory.lambda$get$0(holder, urlStreamHandlerFactorySupplier, predicate);
                    }
                });
                if (holder.get() != null) {
                    return (Network) holder.get();
                }
            }
            return new NetworkImpl(predicate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$get$0(Holder holder, NetworkFunction networkFunction, Predicate predicate) {
            holder.hold(networkFunction.apply(predicate));
        }
    }

    public SContextHolder(String str, String str2, boolean z, boolean z2, SdkConfig.Domain domain) {
        SContext sContext = SContext.getInstance();
        this.scontext = sContext;
        this.userAgent = ScspUserAgentFactory.get(sContext, str, str2);
        this.network = NetworkFactory.get(this.scontext);
        this.isAccountRequiredFeature = z;
        this.isDrsSupportedFeature = z2;
        this.applicationId = str;
        this.version = str2;
        this.domain = domain;
    }
}
