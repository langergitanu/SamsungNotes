package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.ServiceProviders;
import io.grpc.internal.PickFirstLoadBalancerProvider;
import io.grpc.util.SecretRoundRobinLoadBalancerProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
@ThreadSafe
public final class LoadBalancerRegistry {
    private static LoadBalancerRegistry instance;
    private final LinkedHashSet<LoadBalancerProvider> allProviders = new LinkedHashSet<>();
    private final LinkedHashMap<String, LoadBalancerProvider> effectiveProviders = new LinkedHashMap<>();
    private static final Logger logger = Logger.getLogger(LoadBalancerRegistry.class.getName());
    private static final Iterable<Class<?>> HARDCODED_CLASSES = getHardCodedClasses();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LoadBalancerPriorityAccessor implements ServiceProviders.PriorityAccessor<LoadBalancerProvider> {
        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(LoadBalancerProvider loadBalancerProvider) {
            return loadBalancerProvider.getPriority();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(LoadBalancerProvider loadBalancerProvider) {
            return loadBalancerProvider.isAvailable();
        }
    }

    private synchronized void addProvider(LoadBalancerProvider loadBalancerProvider) {
        Preconditions.checkArgument(loadBalancerProvider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(loadBalancerProvider);
    }

    public static synchronized LoadBalancerRegistry getDefaultRegistry() {
        try {
            if (instance == null) {
                List<LoadBalancerProvider> listLoadAll = ServiceProviders.loadAll(LoadBalancerProvider.class, HARDCODED_CLASSES, LoadBalancerProvider.class.getClassLoader(), new LoadBalancerPriorityAccessor());
                instance = new LoadBalancerRegistry();
                for (LoadBalancerProvider loadBalancerProvider : listLoadAll) {
                    logger.fine("Service loader found " + loadBalancerProvider);
                    instance.addProvider(loadBalancerProvider);
                }
                instance.refreshProviderMap();
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    @VisibleForTesting
    public static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            int i = PickFirstLoadBalancerProvider.f8836a;
            arrayList.add(PickFirstLoadBalancerProvider.class);
        } catch (ClassNotFoundException e) {
            logger.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e);
        }
        try {
            int i2 = SecretRoundRobinLoadBalancerProvider.Provider.f8855a;
            arrayList.add(SecretRoundRobinLoadBalancerProvider.Provider.class);
        } catch (ClassNotFoundException e2) {
            logger.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e2);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized void refreshProviderMap() {
        try {
            this.effectiveProviders.clear();
            for (LoadBalancerProvider loadBalancerProvider : this.allProviders) {
                String policyName = loadBalancerProvider.getPolicyName();
                LoadBalancerProvider loadBalancerProvider2 = this.effectiveProviders.get(policyName);
                if (loadBalancerProvider2 == null || loadBalancerProvider2.getPriority() < loadBalancerProvider.getPriority()) {
                    this.effectiveProviders.put(policyName, loadBalancerProvider);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void deregister(LoadBalancerProvider loadBalancerProvider) {
        this.allProviders.remove(loadBalancerProvider);
        refreshProviderMap();
    }

    @Nullable
    public synchronized LoadBalancerProvider getProvider(String str) {
        return this.effectiveProviders.get(Preconditions.checkNotNull(str, "policy"));
    }

    @VisibleForTesting
    public synchronized Map<String, LoadBalancerProvider> providers() {
        return new LinkedHashMap(this.effectiveProviders);
    }

    public synchronized void register(LoadBalancerProvider loadBalancerProvider) {
        addProvider(loadBalancerProvider);
        refreshProviderMap();
    }
}
