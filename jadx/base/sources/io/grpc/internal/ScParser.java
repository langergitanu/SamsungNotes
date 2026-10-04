package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.NameResolver;
import io.grpc.Status;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@VisibleForTesting
public final class ScParser extends NameResolver.ServiceConfigParser {
    private final AutoConfiguredLoadBalancerFactory autoLoadBalancerFactory;
    private final int maxHedgedAttemptsLimit;
    private final int maxRetryAttemptsLimit;
    private final boolean retryEnabled;

    public ScParser(boolean z, int i, int i2, AutoConfiguredLoadBalancerFactory autoConfiguredLoadBalancerFactory) {
        this.retryEnabled = z;
        this.maxRetryAttemptsLimit = i;
        this.maxHedgedAttemptsLimit = i2;
        this.autoLoadBalancerFactory = (AutoConfiguredLoadBalancerFactory) Preconditions.checkNotNull(autoConfiguredLoadBalancerFactory, "autoLoadBalancerFactory");
    }

    @Override // io.grpc.NameResolver.ServiceConfigParser
    public NameResolver.ConfigOrError parseServiceConfig(Map<String, ?> map) {
        Object config;
        try {
            NameResolver.ConfigOrError loadBalancerPolicy = this.autoLoadBalancerFactory.parseLoadBalancerPolicy(map);
            if (loadBalancerPolicy == null) {
                config = null;
            } else {
                if (loadBalancerPolicy.getError() != null) {
                    return NameResolver.ConfigOrError.fromError(loadBalancerPolicy.getError());
                }
                config = loadBalancerPolicy.getConfig();
            }
            return NameResolver.ConfigOrError.fromConfig(ManagedChannelServiceConfig.fromServiceConfig(map, this.retryEnabled, this.maxRetryAttemptsLimit, this.maxHedgedAttemptsLimit, config));
        } catch (RuntimeException e) {
            return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to parse service config").withCause(e));
        }
    }
}
