package io.grpc.util;

import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.NameResolver;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class SecretRoundRobinLoadBalancerProvider {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Provider extends LoadBalancerProvider {
        private static final String NO_CONFIG = "no service config";

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int f8855a = 0;

        @Override // io.grpc.LoadBalancerProvider
        public String getPolicyName() {
            return "round_robin";
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
            return new RoundRobinLoadBalancer(helper);
        }

        @Override // io.grpc.LoadBalancerProvider
        public NameResolver.ConfigOrError parseLoadBalancingPolicyConfig(Map<String, ?> map) {
            return NameResolver.ConfigOrError.fromConfig(NO_CONFIG);
        }
    }

    private SecretRoundRobinLoadBalancerProvider() {
    }
}
