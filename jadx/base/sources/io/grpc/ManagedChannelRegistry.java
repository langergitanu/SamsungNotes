package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.ManagedChannelProvider;
import io.grpc.ServiceProviders;
import io.grpc.netty.NettyChannelProvider;
import io.grpc.netty.UdsNettyChannelProvider;
import io.grpc.okhttp.OkHttpChannelProvider;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ThreadSafe
@Internal
public final class ManagedChannelRegistry {
    private static ManagedChannelRegistry instance;
    private static final Logger logger = Logger.getLogger(ManagedChannelRegistry.class.getName());

    @GuardedBy("this")
    private final LinkedHashSet<ManagedChannelProvider> allProviders = new LinkedHashSet<>();

    @GuardedBy("this")
    private List<ManagedChannelProvider> effectiveProviders = Collections.EMPTY_LIST;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ManagedChannelPriorityAccessor implements ServiceProviders.PriorityAccessor<ManagedChannelProvider> {
        private ManagedChannelPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.priority();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.isAvailable();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String str) {
            super(str);
        }
    }

    private synchronized void addProvider(ManagedChannelProvider managedChannelProvider) {
        Preconditions.checkArgument(managedChannelProvider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(managedChannelProvider);
    }

    public static synchronized ManagedChannelRegistry getDefaultRegistry() {
        try {
            if (instance == null) {
                List<ManagedChannelProvider> listLoadAll = ServiceProviders.loadAll(ManagedChannelProvider.class, getHardCodedClasses(), ManagedChannelProvider.class.getClassLoader(), new ManagedChannelPriorityAccessor());
                instance = new ManagedChannelRegistry();
                for (ManagedChannelProvider managedChannelProvider : listLoadAll) {
                    logger.fine("Service loader found " + managedChannelProvider);
                    instance.addProvider(managedChannelProvider);
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
            arrayList.add(OkHttpChannelProvider.class);
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e);
        }
        try {
            arrayList.add(NettyChannelProvider.class);
        } catch (ClassNotFoundException e2) {
            logger.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e2);
        }
        try {
            arrayList.add(UdsNettyChannelProvider.class);
        } catch (ClassNotFoundException e3) {
            logger.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e3);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized void refreshProviders() {
        ArrayList arrayList = new ArrayList(this.allProviders);
        Collections.sort(arrayList, Collections.reverseOrder(new Comparator<ManagedChannelProvider>() { // from class: io.grpc.ManagedChannelRegistry.1
            @Override // java.util.Comparator
            public int compare(ManagedChannelProvider managedChannelProvider, ManagedChannelProvider managedChannelProvider2) {
                return managedChannelProvider.priority() - managedChannelProvider2.priority();
            }
        }));
        this.effectiveProviders = Collections.unmodifiableList(arrayList);
    }

    public synchronized void deregister(ManagedChannelProvider managedChannelProvider) {
        this.allProviders.remove(managedChannelProvider);
        refreshProviders();
    }

    public ManagedChannelBuilder<?> newChannelBuilder(String str, ChannelCredentials channelCredentials) {
        return newChannelBuilder(NameResolverRegistry.getDefaultRegistry(), str, channelCredentials);
    }

    public ManagedChannelProvider provider() {
        List<ManagedChannelProvider> listProviders = providers();
        if (listProviders.isEmpty()) {
            return null;
        }
        return listProviders.get(0);
    }

    @VisibleForTesting
    public synchronized List<ManagedChannelProvider> providers() {
        return this.effectiveProviders;
    }

    public synchronized void register(ManagedChannelProvider managedChannelProvider) {
        addProvider(managedChannelProvider);
        refreshProviders();
    }

    @VisibleForTesting
    public ManagedChannelBuilder<?> newChannelBuilder(NameResolverRegistry nameResolverRegistry, String str, ChannelCredentials channelCredentials) {
        NameResolverProvider nameResolverProvider;
        try {
            nameResolverProvider = nameResolverRegistry.providers().get(new URI(str).getScheme());
        } catch (URISyntaxException unused) {
            nameResolverProvider = null;
        }
        if (nameResolverProvider == null) {
            nameResolverProvider = nameResolverRegistry.providers().get(nameResolverRegistry.asFactory().getDefaultScheme());
        }
        Collection<Class<? extends SocketAddress>> producedSocketAddressTypes = nameResolverProvider != null ? nameResolverProvider.getProducedSocketAddressTypes() : Collections.EMPTY_SET;
        if (providers().isEmpty()) {
            throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
        }
        StringBuilder sb = new StringBuilder();
        for (ManagedChannelProvider managedChannelProvider : providers()) {
            if (managedChannelProvider.getSupportedSocketAddressTypes().containsAll(producedSocketAddressTypes)) {
                ManagedChannelProvider.NewChannelBuilderResult newChannelBuilderResultNewChannelBuilder = managedChannelProvider.newChannelBuilder(str, channelCredentials);
                if (newChannelBuilderResultNewChannelBuilder.getChannelBuilder() != null) {
                    return newChannelBuilderResultNewChannelBuilder.getChannelBuilder();
                }
                sb.append("; ");
                sb.append(managedChannelProvider.getClass().getName());
                sb.append(": ");
                sb.append(newChannelBuilderResultNewChannelBuilder.getError());
            } else {
                sb.append("; ");
                sb.append(managedChannelProvider.getClass().getName());
                sb.append(": does not support 1 or more of ");
                sb.append(Arrays.toString(producedSocketAddressTypes.toArray()));
            }
        }
        throw new ProviderNotFoundException(sb.substring(2));
    }
}
