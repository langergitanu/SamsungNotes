package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.internal.PickFirstLoadBalancer;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class PickFirstLoadBalancerProvider extends LoadBalancerProvider {
    private static final String NO_CONFIG = "no service config";
    private static final String SHUFFLE_ADDRESS_LIST_KEY = "shuffleAddressList";

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f8836a = 0;
    private static final String CONFIG_FLAG_NAME = "GRPC_EXPERIMENTAL_PICKFIRST_LB_CONFIG";

    @VisibleForTesting
    static boolean enablePickFirstConfig = !Strings.isNullOrEmpty(System.getenv(CONFIG_FLAG_NAME));

    @Override // io.grpc.LoadBalancerProvider
    public String getPolicyName() {
        return GrpcUtil.DEFAULT_LB_POLICY;
    }

    @Override // io.grpc.LoadBalancerProvider
    public int getPriority() {
        return 5;
    }

    @Override // io.grpc.LoadBalancerProvider
    public boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.LoadBalancer.Factory
    public LoadBalancer newLoadBalancer(LoadBalancer.Helper helper) {
        return new PickFirstLoadBalancer(helper);
    }

    @Override // io.grpc.LoadBalancerProvider
    public NameResolver.ConfigOrError parseLoadBalancingPolicyConfig(Map<String, ?> map) {
        if (!enablePickFirstConfig) {
            return NameResolver.ConfigOrError.fromConfig(NO_CONFIG);
        }
        try {
            return NameResolver.ConfigOrError.fromConfig(new PickFirstLoadBalancer.PickFirstLoadBalancerConfig(JsonUtil.getBoolean(map, SHUFFLE_ADDRESS_LIST_KEY)));
        } catch (RuntimeException e) {
            return NameResolver.ConfigOrError.fromError(Status.UNAVAILABLE.withCause(e).withDescription("Failed parsing configuration for " + getPolicyName()));
        }
    }
}
