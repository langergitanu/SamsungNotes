package io.netty.handler.ssl;

import com.google.android.gms.common.data.AbstractC4539a;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSessionContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class JdkSslContext extends SslContext {
    private static final List<String> DEFAULT_CIPHERS;
    private static final List<String> DEFAULT_CIPHERS_NON_TLSV13;
    private static final String[] DEFAULT_PROTOCOLS;
    private static final Provider DEFAULT_PROVIDER;
    static final String PROTOCOL = "TLS";
    private static final Set<String> SUPPORTED_CIPHERS;
    private static final Set<String> SUPPORTED_CIPHERS_NON_TLSV13;
    private static final InternalLogger logger;
    private final JdkApplicationProtocolNegotiator apn;
    private final String[] cipherSuites;
    private final ClientAuth clientAuth;
    private final boolean isClient;
    private final String[] protocols;
    private final SSLContext sslContext;
    private final List<String> unmodifiableCipherSuites;

    /* JADX INFO: renamed from: io.netty.handler.ssl.JdkSslContext$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C127011 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol */
        static final /* synthetic */ int[] f8938xc16482e4;

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior */
        static final /* synthetic */ int[] f8939xcbdfafc1;

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior */
        static final /* synthetic */ int[] f8940xb32e3251;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ClientAuth;

        static {
            int[] iArr = new int[ApplicationProtocolConfig.Protocol.values().length];
            f8938xc16482e4 = iArr;
            try {
                iArr[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8938xc16482e4[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8938xc16482e4[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ApplicationProtocolConfig.SelectedListenerFailureBehavior.values().length];
            f8939xcbdfafc1 = iArr2;
            try {
                iArr2[ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8939xcbdfafc1[ApplicationProtocolConfig.SelectedListenerFailureBehavior.FATAL_ALERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[ApplicationProtocolConfig.SelectorFailureBehavior.values().length];
            f8940xb32e3251 = iArr3;
            try {
                iArr3[ApplicationProtocolConfig.SelectorFailureBehavior.FATAL_ALERT.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8940xb32e3251[ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr4 = new int[ClientAuth.values().length];
            $SwitchMap$io$netty$handler$ssl$ClientAuth = iArr4;
            try {
                iArr4[ClientAuth.OPTIONAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.REQUIRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Defaults {
        List<String> defaultCiphers;
        List<String> defaultCiphersNonTLSv13;
        String[] defaultProtocols;
        Provider defaultProvider;
        Set<String> supportedCiphers;
        Set<String> supportedCiphersNonTLSv13;

        private Defaults() {
        }

        public void init() {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                this.defaultProvider = sSLContext.getProvider();
                SSLEngine sSLEngineCreateSSLEngine = sSLContext.createSSLEngine();
                this.defaultProtocols = JdkSslContext.defaultProtocols(sSLContext, sSLEngineCreateSSLEngine);
                Set<String> setUnmodifiableSet = Collections.unmodifiableSet(JdkSslContext.supportedCiphers(sSLEngineCreateSSLEngine));
                this.supportedCiphers = setUnmodifiableSet;
                this.defaultCiphers = Collections.unmodifiableList(JdkSslContext.defaultCiphers(sSLEngineCreateSSLEngine, setUnmodifiableSet));
                ArrayList arrayList = new ArrayList(this.defaultCiphers);
                String[] strArr = SslUtils.DEFAULT_TLSV13_CIPHER_SUITES;
                arrayList.removeAll(Arrays.asList(strArr));
                this.defaultCiphersNonTLSv13 = Collections.unmodifiableList(arrayList);
                LinkedHashSet linkedHashSet = new LinkedHashSet(this.supportedCiphers);
                linkedHashSet.removeAll(Arrays.asList(strArr));
                this.supportedCiphersNonTLSv13 = Collections.unmodifiableSet(linkedHashSet);
            } catch (Exception e) {
                throw new Error("failed to initialize the default SSL context", e);
            }
        }

        public /* synthetic */ Defaults(C127011 c127011) {
            this();
        }
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) JdkSslContext.class);
        logger = internalLoggerFactory;
        Defaults defaults = new Defaults(null);
        defaults.init();
        DEFAULT_PROVIDER = defaults.defaultProvider;
        String[] strArr = defaults.defaultProtocols;
        DEFAULT_PROTOCOLS = strArr;
        SUPPORTED_CIPHERS = defaults.supportedCiphers;
        List<String> list = defaults.defaultCiphers;
        DEFAULT_CIPHERS = list;
        DEFAULT_CIPHERS_NON_TLSV13 = defaults.defaultCiphersNonTLSv13;
        SUPPORTED_CIPHERS_NON_TLSV13 = defaults.supportedCiphersNonTLSv13;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("Default protocols (JDK): {} ", Arrays.asList(strArr));
            internalLoggerFactory.debug("Default cipher suites (JDK): {}", list);
        }
    }

    @Deprecated
    public JdkSslContext(SSLContext sSLContext, boolean z, ClientAuth clientAuth) {
        this(sSLContext, z, (Iterable<String>) null, (CipherSuiteFilter) IdentityCipherSuiteFilter.INSTANCE, (JdkApplicationProtocolNegotiator) JdkDefaultApplicationProtocolNegotiator.INSTANCE, clientAuth, (String[]) null, false);
    }

    public static KeyManagerFactory buildKeyManagerFactory(File file, File file2, String str, KeyManagerFactory keyManagerFactory, String str2) {
        String property = Security.getProperty("ssl.KeyManagerFactory.algorithm");
        if (property == null) {
            property = "SunX509";
        }
        return buildKeyManagerFactory(file, property, file2, str, keyManagerFactory, str2);
    }

    private SSLEngine configureAndWrapEngine(SSLEngine sSLEngine, ByteBufAllocator byteBufAllocator) {
        sSLEngine.setEnabledCipherSuites(this.cipherSuites);
        sSLEngine.setEnabledProtocols(this.protocols);
        sSLEngine.setUseClientMode(isClient());
        if (isServer()) {
            int i = C127011.$SwitchMap$io$netty$handler$ssl$ClientAuth[this.clientAuth.ordinal()];
            if (i == 1) {
                sSLEngine.setWantClientAuth(true);
            } else if (i == 2) {
                sSLEngine.setNeedClientAuth(true);
            } else if (i != 3) {
                throw new Error("Unknown auth " + this.clientAuth);
            }
        }
        JdkApplicationProtocolNegotiator.SslEngineWrapperFactory sslEngineWrapperFactoryWrapperFactory = this.apn.wrapperFactory();
        return sslEngineWrapperFactoryWrapperFactory instanceof JdkApplicationProtocolNegotiator.AllocatorAwareSslEngineWrapperFactory ? ((JdkApplicationProtocolNegotiator.AllocatorAwareSslEngineWrapperFactory) sslEngineWrapperFactoryWrapperFactory).wrapSslEngine(sSLEngine, byteBufAllocator, this.apn, isServer()) : sslEngineWrapperFactoryWrapperFactory.wrapSslEngine(sSLEngine, this.apn, isServer());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> defaultCiphers(SSLEngine sSLEngine, Set<String> set) {
        ArrayList arrayList = new ArrayList();
        SslUtils.addIfSupported(set, arrayList, SslUtils.DEFAULT_CIPHER_SUITES);
        SslUtils.useFallbackCiphersIfDefaultIsEmpty(arrayList, sSLEngine.getEnabledCipherSuites());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] defaultProtocols(SSLContext sSLContext, SSLEngine sSLEngine) {
        String[] protocols = sSLContext.getDefaultSSLParameters().getProtocols();
        HashSet hashSet = new HashSet(protocols.length);
        Collections.addAll(hashSet, protocols);
        ArrayList arrayList = new ArrayList();
        SslUtils.addIfSupported(hashSet, arrayList, SslProtocols.TLS_v1_3, SslProtocols.TLS_v1_2, SslProtocols.TLS_v1_1, SslProtocols.TLS_v1);
        return !arrayList.isEmpty() ? (String[]) arrayList.toArray(EmptyArrays.EMPTY_STRINGS) : sSLEngine.getEnabledProtocols();
    }

    private static boolean isTlsV13Supported(String[] strArr) {
        for (String str : strArr) {
            if (SslProtocols.TLS_v1_3.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set<String> supportedCiphers(SSLEngine sSLEngine) {
        String[] supportedCipherSuites = sSLEngine.getSupportedCipherSuites();
        LinkedHashSet linkedHashSet = new LinkedHashSet(supportedCipherSuites.length);
        for (String str : supportedCipherSuites) {
            linkedHashSet.add(str);
            if (str.startsWith("SSL_")) {
                String strM3198h = AbstractC4539a.m3198h(new StringBuilder("TLS_"), str, 4);
                try {
                    sSLEngine.setEnabledCipherSuites(new String[]{strM3198h});
                    linkedHashSet.add(strM3198h);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return linkedHashSet;
    }

    public static JdkApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig applicationProtocolConfig, boolean z) {
        if (applicationProtocolConfig == null) {
            return JdkDefaultApplicationProtocolNegotiator.INSTANCE;
        }
        int i = C127011.f8938xc16482e4[applicationProtocolConfig.protocol().ordinal()];
        if (i == 1) {
            return JdkDefaultApplicationProtocolNegotiator.INSTANCE;
        }
        if (i == 2) {
            if (z) {
                int i2 = C127011.f8940xb32e3251[applicationProtocolConfig.selectorFailureBehavior().ordinal()];
                if (i2 == 1) {
                    return new JdkAlpnApplicationProtocolNegotiator(true, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
                }
                if (i2 == 2) {
                    return new JdkAlpnApplicationProtocolNegotiator(false, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
                }
                throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.selectorFailureBehavior() + " failure behavior");
            }
            int i4 = C127011.f8939xcbdfafc1[applicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
            if (i4 == 1) {
                return new JdkAlpnApplicationProtocolNegotiator(false, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
            }
            if (i4 == 2) {
                return new JdkAlpnApplicationProtocolNegotiator(true, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
            }
            throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.selectedListenerFailureBehavior() + " failure behavior");
        }
        if (i != 3) {
            throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.protocol() + " protocol");
        }
        if (z) {
            int i5 = C127011.f8939xcbdfafc1[applicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
            if (i5 == 1) {
                return new JdkNpnApplicationProtocolNegotiator(false, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
            }
            if (i5 == 2) {
                return new JdkNpnApplicationProtocolNegotiator(true, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
            }
            throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.selectedListenerFailureBehavior() + " failure behavior");
        }
        int i6 = C127011.f8940xb32e3251[applicationProtocolConfig.selectorFailureBehavior().ordinal()];
        if (i6 == 1) {
            return new JdkNpnApplicationProtocolNegotiator(true, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
        }
        if (i6 == 2) {
            return new JdkNpnApplicationProtocolNegotiator(false, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
        }
        throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.selectorFailureBehavior() + " failure behavior");
    }

    @Override // io.netty.handler.ssl.SslContext
    public final List<String> cipherSuites() {
        return this.unmodifiableCipherSuites;
    }

    public final SSLContext context() {
        return this.sslContext;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.isClient;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator) {
        return configureAndWrapEngine(context().createSSLEngine(), byteBufAllocator);
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLSessionContext sessionContext() {
        return isServer() ? context().getServerSessionContext() : context().getClientSessionContext();
    }

    @Deprecated
    public JdkSslContext(SSLContext sSLContext, boolean z, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, ClientAuth clientAuth) {
        this(sSLContext, z, iterable, cipherSuiteFilter, applicationProtocolConfig, clientAuth, (String[]) null, false);
    }

    @Override // io.netty.handler.ssl.SslContext
    public final JdkApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.apn;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i) {
        return configureAndWrapEngine(context().createSSLEngine(str, i), byteBufAllocator);
    }

    public JdkSslContext(SSLContext sSLContext, boolean z, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, ClientAuth clientAuth, String[] strArr, boolean z2) {
        this(sSLContext, z, iterable, cipherSuiteFilter, toNegotiator(applicationProtocolConfig, !z), clientAuth, strArr == null ? null : (String[]) strArr.clone(), z2);
    }

    @Deprecated
    public static KeyManagerFactory buildKeyManagerFactory(File file, File file2, String str, KeyManagerFactory keyManagerFactory) {
        return buildKeyManagerFactory(file, file2, str, keyManagerFactory, KeyStore.getDefaultType());
    }

    public static KeyManagerFactory buildKeyManagerFactory(File file, String str, File file2, String str2, KeyManagerFactory keyManagerFactory, String str3) {
        return SslContext.buildKeyManagerFactory(SslContext.toX509Certificates(file), str, SslContext.toPrivateKey(file2, str2), str2, keyManagerFactory, str3);
    }

    public JdkSslContext(SSLContext sSLContext, boolean z, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, ClientAuth clientAuth, String[] strArr, boolean z2) {
        Set<String> setSupportedCiphers;
        List<String> list;
        super(z2);
        this.apn = (JdkApplicationProtocolNegotiator) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator, "apn");
        this.clientAuth = (ClientAuth) ObjectUtil.checkNotNull(clientAuth, "clientAuth");
        this.sslContext = (SSLContext) ObjectUtil.checkNotNull(sSLContext, "sslContext");
        if (DEFAULT_PROVIDER.equals(sSLContext.getProvider())) {
            strArr = strArr == null ? DEFAULT_PROTOCOLS : strArr;
            this.protocols = strArr;
            if (isTlsV13Supported(strArr)) {
                setSupportedCiphers = SUPPORTED_CIPHERS;
                list = DEFAULT_CIPHERS;
            } else {
                setSupportedCiphers = SUPPORTED_CIPHERS_NON_TLSV13;
                list = DEFAULT_CIPHERS_NON_TLSV13;
            }
        } else {
            SSLEngine sSLEngineCreateSSLEngine = sSLContext.createSSLEngine();
            try {
                if (strArr == null) {
                    this.protocols = defaultProtocols(sSLContext, sSLEngineCreateSSLEngine);
                } else {
                    this.protocols = strArr;
                }
                setSupportedCiphers = supportedCiphers(sSLEngineCreateSSLEngine);
                List<String> listDefaultCiphers = defaultCiphers(sSLEngineCreateSSLEngine, setSupportedCiphers);
                if (!isTlsV13Supported(this.protocols)) {
                    for (String str : SslUtils.DEFAULT_TLSV13_CIPHER_SUITES) {
                        setSupportedCiphers.remove(str);
                        listDefaultCiphers.remove(str);
                    }
                }
                ReferenceCountUtil.release(sSLEngineCreateSSLEngine);
                list = listDefaultCiphers;
            } catch (Throwable th) {
                ReferenceCountUtil.release(sSLEngineCreateSSLEngine);
                throw th;
            }
        }
        String[] strArrFilterCipherSuites = ((CipherSuiteFilter) ObjectUtil.checkNotNull(cipherSuiteFilter, "cipherFilter")).filterCipherSuites(iterable, list, setSupportedCiphers);
        this.cipherSuites = strArrFilterCipherSuites;
        this.unmodifiableCipherSuites = Collections.unmodifiableList(Arrays.asList(strArrFilterCipherSuites));
        this.isClient = z;
    }

    @Deprecated
    public static KeyManagerFactory buildKeyManagerFactory(File file, String str, File file2, String str2, KeyManagerFactory keyManagerFactory) {
        return SslContext.buildKeyManagerFactory(SslContext.toX509Certificates(file), str, SslContext.toPrivateKey(file2, str2), str2, keyManagerFactory, KeyStore.getDefaultType());
    }
}
