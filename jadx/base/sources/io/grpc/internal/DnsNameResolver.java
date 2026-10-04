package io.grpc.internal;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.SharedResourceHolder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.apache.commons.text.lookup.StringLookupFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DnsNameResolver extends NameResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @VisibleForTesting
    static final long DEFAULT_NETWORK_CACHE_TTL_SECONDS = 30;
    private static final String JNDI_LOCALHOST_PROPERTY;
    private static final String JNDI_PROPERTY;
    private static final String JNDI_TXT_PROPERTY;

    @VisibleForTesting
    static final String NETWORKADDRESS_CACHE_TTL_PROPERTY = "networkaddress.cache.ttl";
    private static final String SERVICE_CONFIG_NAME_PREFIX = "_grpc_config.";
    static final String SERVICE_CONFIG_PREFIX = "grpc_config=";

    @VisibleForTesting
    static boolean enableJndi;

    @VisibleForTesting
    static boolean enableJndiLocalhost;

    @VisibleForTesting
    protected static boolean enableTxt;
    private static String localHostname;
    private static final ResourceResolverFactory resourceResolverFactory;
    private final String authority;
    private final long cacheTtlNanos;
    private Executor executor;
    private final SharedResourceHolder.Resource<Executor> executorResource;
    private final String host;
    private NameResolver.Listener2 listener;
    private final int port;

    @VisibleForTesting
    final ProxyDetector proxyDetector;
    protected boolean resolved;
    private boolean resolving;
    private final NameResolver.ServiceConfigParser serviceConfigParser;
    private boolean shutdown;
    private final Stopwatch stopwatch;
    private final SynchronizationContext syncContext;
    private final boolean usingExecutorResource;
    private static final Logger logger = Logger.getLogger(DnsNameResolver.class.getName());
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY = "clientLanguage";
    private static final String SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY = "percentage";
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY = "clientHostname";
    private static final String SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY = "serviceConfig";
    private static final Set<String> SERVICE_CONFIG_CHOICE_KEYS = Collections.unmodifiableSet(new HashSet(Arrays.asList(SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY)));
    private final Random random = new Random();
    protected volatile AddressResolver addressResolver = JdkAddressResolver.INSTANCE;
    private final AtomicReference<ResourceResolver> resourceResolver = new AtomicReference<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public interface AddressResolver {
        List<InetAddress> resolveAddress(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class InternalResolutionResult {
        private List<EquivalentAddressGroup> addresses;
        public Attributes attributes;
        private NameResolver.ConfigOrError config;
        private Status error;

        private InternalResolutionResult() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum JdkAddressResolver implements AddressResolver {
        INSTANCE;

        @Override // io.grpc.internal.DnsNameResolver.AddressResolver
        public List<InetAddress> resolveAddress(String str) {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class Resolve implements Runnable {
        private final NameResolver.Listener2 savedListener;

        public Resolve(NameResolver.Listener2 listener2) {
            this.savedListener = (NameResolver.Listener2) Preconditions.checkNotNull(listener2, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            final boolean z;
            SynchronizationContext synchronizationContext;
            Runnable runnable;
            EquivalentAddressGroup equivalentAddressGroupDetectProxy;
            NameResolver.ResolutionResult.Builder builderNewBuilder;
            Logger logger = DnsNameResolver.logger;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                DnsNameResolver.logger.finer("Attempting DNS resolution of " + DnsNameResolver.this.host);
            }
            InternalResolutionResult internalResolutionResultDoResolve = null;
            try {
                try {
                    equivalentAddressGroupDetectProxy = DnsNameResolver.this.detectProxy();
                    builderNewBuilder = NameResolver.ResolutionResult.newBuilder();
                } catch (IOException e) {
                    this.savedListener.onError(Status.UNAVAILABLE.withDescription("Unable to resolve host " + DnsNameResolver.this.host).withCause(e));
                    z = 0 != 0 && null.error == null;
                    synchronizationContext = DnsNameResolver.this.syncContext;
                    runnable = new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z) {
                                DnsNameResolver dnsNameResolver = DnsNameResolver.this;
                                dnsNameResolver.resolved = true;
                                if (dnsNameResolver.cacheTtlNanos > 0) {
                                    DnsNameResolver.this.stopwatch.reset().start();
                                }
                            }
                            DnsNameResolver.this.resolving = false;
                        }
                    };
                }
                if (equivalentAddressGroupDetectProxy != null) {
                    if (DnsNameResolver.logger.isLoggable(level)) {
                        DnsNameResolver.logger.finer("Using proxy address " + equivalentAddressGroupDetectProxy);
                    }
                    builderNewBuilder.setAddresses(Collections.singletonList(equivalentAddressGroupDetectProxy));
                } else {
                    internalResolutionResultDoResolve = DnsNameResolver.this.doResolve(false);
                    if (internalResolutionResultDoResolve.error != null) {
                        this.savedListener.onError(internalResolutionResultDoResolve.error);
                        z = internalResolutionResultDoResolve != null && internalResolutionResultDoResolve.error == null;
                        synchronizationContext = DnsNameResolver.this.syncContext;
                        runnable = new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z) {
                                    DnsNameResolver dnsNameResolver = DnsNameResolver.this;
                                    dnsNameResolver.resolved = true;
                                    if (dnsNameResolver.cacheTtlNanos > 0) {
                                        DnsNameResolver.this.stopwatch.reset().start();
                                    }
                                }
                                DnsNameResolver.this.resolving = false;
                            }
                        };
                        synchronizationContext.execute(runnable);
                    }
                    if (internalResolutionResultDoResolve.addresses != null) {
                        builderNewBuilder.setAddresses(internalResolutionResultDoResolve.addresses);
                    }
                    if (internalResolutionResultDoResolve.config != null) {
                        builderNewBuilder.setServiceConfig(internalResolutionResultDoResolve.config);
                    }
                    Attributes attributes = internalResolutionResultDoResolve.attributes;
                    if (attributes != null) {
                        builderNewBuilder.setAttributes(attributes);
                    }
                }
                this.savedListener.onResult(builderNewBuilder.build());
                z = internalResolutionResultDoResolve != null && internalResolutionResultDoResolve.error == null;
                synchronizationContext = DnsNameResolver.this.syncContext;
                runnable = new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z) {
                            DnsNameResolver dnsNameResolver = DnsNameResolver.this;
                            dnsNameResolver.resolved = true;
                            if (dnsNameResolver.cacheTtlNanos > 0) {
                                DnsNameResolver.this.stopwatch.reset().start();
                            }
                        }
                        DnsNameResolver.this.resolving = false;
                    }
                };
                synchronizationContext.execute(runnable);
            } catch (Throwable th) {
                z = 0 != 0 && null.error == null;
                DnsNameResolver.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z) {
                            DnsNameResolver dnsNameResolver = DnsNameResolver.this;
                            dnsNameResolver.resolved = true;
                            if (dnsNameResolver.cacheTtlNanos > 0) {
                                DnsNameResolver.this.stopwatch.reset().start();
                            }
                        }
                        DnsNameResolver.this.resolving = false;
                    }
                });
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public interface ResourceResolver {
        List<SrvRecord> resolveSrv(String str);

        List<String> resolveTxt(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResourceResolverFactory {
        @Nullable
        ResourceResolver newResourceResolver();

        @Nullable
        Throwable unavailabilityCause();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static final class SrvRecord {
        public final String host;
        public final int port;

        public SrvRecord(String str, int i) {
            this.host = str;
            this.port = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SrvRecord.class == obj.getClass()) {
                SrvRecord srvRecord = (SrvRecord) obj;
                if (this.port == srvRecord.port && this.host.equals(srvRecord.host)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.host, Integer.valueOf(this.port));
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("host", this.host).add("port", this.port).toString();
        }
    }

    static {
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        JNDI_PROPERTY = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        JNDI_LOCALHOST_PROPERTY = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        JNDI_TXT_PROPERTY = property3;
        enableJndi = Boolean.parseBoolean(property);
        enableJndiLocalhost = Boolean.parseBoolean(property2);
        enableTxt = Boolean.parseBoolean(property3);
        resourceResolverFactory = getResourceResolverFactory(DnsNameResolver.class.getClassLoader());
    }

    public DnsNameResolver(@Nullable String str, String str2, NameResolver.Args args, SharedResourceHolder.Resource<Executor> resource, Stopwatch stopwatch, boolean z) {
        Preconditions.checkNotNull(args, "args");
        this.executorResource = resource;
        URI uriCreate = URI.create("//" + ((String) Preconditions.checkNotNull(str2, "name")));
        Preconditions.checkArgument(uriCreate.getHost() != null, "Invalid DNS name: %s", str2);
        this.authority = (String) Preconditions.checkNotNull(uriCreate.getAuthority(), "nameUri (%s) doesn't have an authority", uriCreate);
        this.host = uriCreate.getHost();
        if (uriCreate.getPort() == -1) {
            this.port = args.getDefaultPort();
        } else {
            this.port = uriCreate.getPort();
        }
        this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(args.getProxyDetector(), "proxyDetector");
        this.cacheTtlNanos = getNetworkAddressCacheTtlNanos(z);
        this.stopwatch = (Stopwatch) Preconditions.checkNotNull(stopwatch, NotificationCompat.CATEGORY_STOPWATCH);
        this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(args.getSynchronizationContext(), "syncContext");
        Executor offloadExecutor = args.getOffloadExecutor();
        this.executor = offloadExecutor;
        this.usingExecutorResource = offloadExecutor == null;
        this.serviceConfigParser = (NameResolver.ServiceConfigParser) Preconditions.checkNotNull(args.getServiceConfigParser(), "serviceConfigParser");
    }

    private boolean cacheRefreshRequired() {
        if (!this.resolved) {
            return true;
        }
        long j = this.cacheTtlNanos;
        if (j != 0) {
            return j > 0 && this.stopwatch.elapsed(TimeUnit.NANOSECONDS) > this.cacheTtlNanos;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public EquivalentAddressGroup detectProxy() {
        ProxiedSocketAddress proxiedSocketAddressProxyFor = this.proxyDetector.proxyFor(InetSocketAddress.createUnresolved(this.host, this.port));
        if (proxiedSocketAddressProxyFor != null) {
            return new EquivalentAddressGroup(proxiedSocketAddressProxyFor);
        }
        return null;
    }

    @Nullable
    private static final List<String> getClientLanguagesFromChoice(Map<String, ?> map) {
        return JsonUtil.getListOfStrings(map, SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY);
    }

    @Nullable
    private static final List<String> getHostnamesFromChoice(Map<String, ?> map) {
        return JsonUtil.getListOfStrings(map, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY);
    }

    private static String getLocalHostname() {
        if (localHostname == null) {
            try {
                localHostname = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }
        return localHostname;
    }

    private static long getNetworkAddressCacheTtlNanos(boolean z) {
        if (z) {
            return 0L;
        }
        String property = System.getProperty("networkaddress.cache.ttl");
        long j = DEFAULT_NETWORK_CACHE_TTL_SECONDS;
        if (property != null) {
            try {
                j = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                logger.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, Long.valueOf(DEFAULT_NETWORK_CACHE_TTL_SECONDS)});
            }
        }
        return j > 0 ? TimeUnit.SECONDS.toNanos(j) : j;
    }

    @Nullable
    private static final Double getPercentageFromChoice(Map<String, ?> map) {
        return JsonUtil.getNumberAsDouble(map, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY);
    }

    @VisibleForTesting
    @Nullable
    public static ResourceResolverFactory getResourceResolverFactory(ClassLoader classLoader) {
        try {
            try {
                try {
                    ResourceResolverFactory resourceResolverFactory2 = (ResourceResolverFactory) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, classLoader).asSubclass(ResourceResolverFactory.class).getConstructor(null).newInstance(null);
                    if (resourceResolverFactory2.unavailabilityCause() == null) {
                        return resourceResolverFactory2;
                    }
                    logger.log(Level.FINE, "JndiResourceResolverFactory not available, skipping.", resourceResolverFactory2.unavailabilityCause());
                    return null;
                } catch (Exception e) {
                    logger.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e);
                    return null;
                }
            } catch (Exception e2) {
                logger.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e2);
                return null;
            }
        } catch (ClassCastException e3) {
            logger.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e3);
            return null;
        } catch (ClassNotFoundException e5) {
            logger.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e5);
            return null;
        }
    }

    @VisibleForTesting
    @Nullable
    public static Map<String, ?> maybeChooseServiceConfig(Map<String, ?> map, Random random, String str) {
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Verify.verify(SERVICE_CONFIG_CHOICE_KEYS.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List<String> clientLanguagesFromChoice = getClientLanguagesFromChoice(map);
        if (clientLanguagesFromChoice != null && !clientLanguagesFromChoice.isEmpty()) {
            Iterator<String> it = clientLanguagesFromChoice.iterator();
            while (it.hasNext()) {
                if (StringLookupFactory.KEY_JAVA.equalsIgnoreCase(it.next())) {
                }
            }
            return null;
        }
        Double percentageFromChoice = getPercentageFromChoice(map);
        if (percentageFromChoice != null) {
            int iIntValue = percentageFromChoice.intValue();
            Verify.verify(iIntValue >= 0 && iIntValue <= 100, "Bad percentage: %s", percentageFromChoice);
            if (random.nextInt(100) >= iIntValue) {
                return null;
            }
        }
        List<String> hostnamesFromChoice = getHostnamesFromChoice(map);
        if (hostnamesFromChoice != null && !hostnamesFromChoice.isEmpty()) {
            Iterator<String> it2 = hostnamesFromChoice.iterator();
            while (it2.hasNext()) {
                if (it2.next().equals(str)) {
                }
            }
            return null;
        }
        Map<String, ?> object = JsonUtil.getObject(map, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY);
        if (object != null) {
            return object;
        }
        throw new VerifyException(String.format("key '%s' missing in '%s'", map, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY));
    }

    @Nullable
    public static NameResolver.ConfigOrError parseServiceConfig(List<String> list, Random random, String str) {
        try {
            Iterator<Map<String, ?>> it = parseTxtResults(list).iterator();
            Map<String, ?> mapMaybeChooseServiceConfig = null;
            while (it.hasNext()) {
                try {
                    mapMaybeChooseServiceConfig = maybeChooseServiceConfig(it.next(), random, str);
                    if (mapMaybeChooseServiceConfig != null) {
                        break;
                    }
                } catch (RuntimeException e) {
                    return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to pick service config choice").withCause(e));
                }
            }
            if (mapMaybeChooseServiceConfig == null) {
                return null;
            }
            return NameResolver.ConfigOrError.fromConfig(mapMaybeChooseServiceConfig);
        } catch (IOException | RuntimeException e2) {
            return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to parse TXT records").withCause(e2));
        }
    }

    @VisibleForTesting
    public static List<Map<String, ?>> parseTxtResults(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.startsWith(SERVICE_CONFIG_PREFIX)) {
                Object obj = JsonParser.parse(str.substring(12));
                if (!(obj instanceof List)) {
                    throw new ClassCastException(AbstractC0541b.m769k(obj, "wrong type "));
                }
                arrayList.addAll(JsonUtil.checkObjectList((List) obj));
            } else {
                logger.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    private void resolve() {
        if (this.resolving || this.shutdown || !cacheRefreshRequired()) {
            return;
        }
        this.resolving = true;
        this.executor.execute(new Resolve(this.listener));
    }

    private List<EquivalentAddressGroup> resolveAddresses() {
        Exception e = null;
        try {
            try {
                List<InetAddress> listResolveAddress = this.addressResolver.resolveAddress(this.host);
                ArrayList arrayList = new ArrayList(listResolveAddress.size());
                Iterator<InetAddress> it = listResolveAddress.iterator();
                while (it.hasNext()) {
                    arrayList.add(new EquivalentAddressGroup(new InetSocketAddress(it.next(), this.port)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e2) {
                e = e2;
                Throwables.throwIfUnchecked(e);
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            if (e != null) {
                logger.log(Level.FINE, "Address resolution failure", (Throwable) e);
            }
            throw th;
        }
    }

    @Nullable
    private NameResolver.ConfigOrError resolveServiceConfig() {
        List<String> listResolveTxt = Collections.EMPTY_LIST;
        ResourceResolver resourceResolver = getResourceResolver();
        if (resourceResolver != null) {
            try {
                listResolveTxt = resourceResolver.resolveTxt(SERVICE_CONFIG_NAME_PREFIX + this.host);
            } catch (Exception e) {
                logger.log(Level.FINE, "ServiceConfig resolution failure", (Throwable) e);
            }
        }
        if (listResolveTxt.isEmpty()) {
            logger.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.host});
            return null;
        }
        NameResolver.ConfigOrError serviceConfig = parseServiceConfig(listResolveTxt, this.random, getLocalHostname());
        if (serviceConfig == null) {
            return null;
        }
        if (serviceConfig.getError() != null) {
            return NameResolver.ConfigOrError.fromError(serviceConfig.getError());
        }
        return this.serviceConfigParser.parseServiceConfig((Map) serviceConfig.getConfig());
    }

    @VisibleForTesting
    public static boolean shouldUseJndi(boolean z, boolean z2, String str) {
        if (!z) {
            return false;
        }
        if (StringLookupFactory.KEY_LOCALHOST.equalsIgnoreCase(str)) {
            return z2;
        }
        if (str.contains(":")) {
            return false;
        }
        boolean z3 = true;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '.') {
                z3 &= cCharAt >= '0' && cCharAt <= '9';
            }
        }
        return true ^ z3;
    }

    public InternalResolutionResult doResolve(boolean z) {
        InternalResolutionResult internalResolutionResult = new InternalResolutionResult();
        try {
            internalResolutionResult.addresses = resolveAddresses();
        } catch (Exception e) {
            if (!z) {
                internalResolutionResult.error = Status.UNAVAILABLE.withDescription("Unable to resolve host " + this.host).withCause(e);
                return internalResolutionResult;
            }
        }
        if (enableTxt) {
            internalResolutionResult.config = resolveServiceConfig();
        }
        return internalResolutionResult;
    }

    @VisibleForTesting
    public String getHost() {
        return this.host;
    }

    public final int getPort() {
        return this.port;
    }

    @Nullable
    public ResourceResolver getResourceResolver() {
        ResourceResolverFactory resourceResolverFactory2;
        if (!shouldUseJndi(enableJndi, enableJndiLocalhost, this.host)) {
            return null;
        }
        ResourceResolver resourceResolver = this.resourceResolver.get();
        return (resourceResolver != null || (resourceResolverFactory2 = resourceResolverFactory) == null) ? resourceResolver : resourceResolverFactory2.newResourceResolver();
    }

    @Override // io.grpc.NameResolver
    public String getServiceAuthority() {
        return this.authority;
    }

    @Override // io.grpc.NameResolver
    public void refresh() {
        Preconditions.checkState(this.listener != null, "not started");
        resolve();
    }

    @VisibleForTesting
    public void setAddressResolver(AddressResolver addressResolver) {
        this.addressResolver = addressResolver;
    }

    @VisibleForTesting
    public void setResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver.set(resourceResolver);
    }

    @Override // io.grpc.NameResolver
    public void shutdown() {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        Executor executor = this.executor;
        if (executor == null || !this.usingExecutorResource) {
            return;
        }
        this.executor = (Executor) SharedResourceHolder.release(this.executorResource, executor);
    }

    @Override // io.grpc.NameResolver
    public void start(NameResolver.Listener2 listener2) {
        Preconditions.checkState(this.listener == null, "already started");
        if (this.usingExecutorResource) {
            this.executor = (Executor) SharedResourceHolder.get(this.executorResource);
        }
        this.listener = (NameResolver.Listener2) Preconditions.checkNotNull(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        resolve();
    }
}
