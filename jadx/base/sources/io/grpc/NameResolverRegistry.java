package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import io.grpc.NameResolver;
import io.grpc.ServiceProviders;
import io.grpc.internal.DnsNameResolverProvider;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4159")
@ThreadSafe
public final class NameResolverRegistry {
    private static final String UNKNOWN_SCHEME = "unknown";
    private static NameResolverRegistry instance;
    private static final Logger logger = Logger.getLogger(NameResolverRegistry.class.getName());
    private final NameResolver.Factory factory = new NameResolverFactory();

    @GuardedBy("this")
    private String defaultScheme = "unknown";

    @GuardedBy("this")
    private final LinkedHashSet<NameResolverProvider> allProviders = new LinkedHashSet<>();

    @GuardedBy("this")
    private ImmutableMap<String, NameResolverProvider> effectiveProviders = ImmutableMap.m4321of();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class NameResolverFactory extends NameResolver.Factory {
        private NameResolverFactory() {
        }

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            String str;
            synchronized (NameResolverRegistry.this) {
                str = NameResolverRegistry.this.defaultScheme;
            }
            return str;
        }

        @Override // io.grpc.NameResolver.Factory
        @Nullable
        public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
            NameResolverProvider nameResolverProvider;
            String scheme = uri.getScheme();
            if (scheme == null || (nameResolverProvider = NameResolverRegistry.this.providers().get(scheme.toLowerCase(Locale.US))) == null) {
                return null;
            }
            return nameResolverProvider.newNameResolver(uri, args);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NameResolverPriorityAccessor implements ServiceProviders.PriorityAccessor<NameResolverProvider> {
        private NameResolverPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(NameResolverProvider nameResolverProvider) {
            return nameResolverProvider.priority();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(NameResolverProvider nameResolverProvider) {
            return nameResolverProvider.isAvailable();
        }
    }

    private synchronized void addProvider(NameResolverProvider nameResolverProvider) {
        Preconditions.checkArgument(nameResolverProvider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(nameResolverProvider);
    }

    public static synchronized NameResolverRegistry getDefaultRegistry() {
        try {
            if (instance == null) {
                List<NameResolverProvider> listLoadAll = ServiceProviders.loadAll(NameResolverProvider.class, getHardCodedClasses(), NameResolverProvider.class.getClassLoader(), new NameResolverPriorityAccessor());
                if (listLoadAll.isEmpty()) {
                    logger.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                instance = new NameResolverRegistry();
                for (NameResolverProvider nameResolverProvider : listLoadAll) {
                    logger.fine("Service loader found " + nameResolverProvider);
                    instance.addProvider(nameResolverProvider);
                }
                instance.refreshProviders();
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
            int i = DnsNameResolverProvider.f8834a;
            arrayList.add(DnsNameResolverProvider.class);
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized void refreshProviders() {
        try {
            HashMap map = new HashMap();
            String scheme = "unknown";
            int iPriority = Integer.MIN_VALUE;
            for (NameResolverProvider nameResolverProvider : this.allProviders) {
                String scheme2 = nameResolverProvider.getScheme();
                NameResolverProvider nameResolverProvider2 = (NameResolverProvider) map.get(scheme2);
                if (nameResolverProvider2 == null || nameResolverProvider2.priority() < nameResolverProvider.priority()) {
                    map.put(scheme2, nameResolverProvider);
                }
                if (iPriority < nameResolverProvider.priority()) {
                    iPriority = nameResolverProvider.priority();
                    scheme = nameResolverProvider.getScheme();
                }
            }
            this.effectiveProviders = ImmutableMap.copyOf((Map) map);
            this.defaultScheme = scheme;
        } catch (Throwable th) {
            throw th;
        }
    }

    public NameResolver.Factory asFactory() {
        return this.factory;
    }

    public synchronized void deregister(NameResolverProvider nameResolverProvider) {
        this.allProviders.remove(nameResolverProvider);
        refreshProviders();
    }

    @VisibleForTesting
    public synchronized Map<String, NameResolverProvider> providers() {
        return this.effectiveProviders;
    }

    public synchronized void register(NameResolverProvider nameResolverProvider) {
        addProvider(nameResolverProvider);
        refreshProviders();
    }
}
