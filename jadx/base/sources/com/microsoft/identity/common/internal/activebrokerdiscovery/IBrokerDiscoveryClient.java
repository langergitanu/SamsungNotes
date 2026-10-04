package com.microsoft.identity.common.internal.activebrokerdiscovery;

import com.microsoft.identity.common.internal.broker.BrokerData;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClient;", "", "getActiveBroker", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "shouldSkipCache", "", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface IBrokerDiscoveryClient {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ BrokerData getActiveBroker$default(IBrokerDiscoveryClient iBrokerDiscoveryClient, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getActiveBroker");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            return iBrokerDiscoveryClient.getActiveBroker(z);
        }
    }

    @Nullable
    BrokerData getActiveBroker(boolean shouldSkipCache);
}
