package io.grpc.netty;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.grpc.ExperimentalApi;
import io.grpc.internal.ConscryptLoader;
import io.netty.handler.codec.http2.Http2SecurityUtil;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.ApplicationProtocolNegotiator;
import io.netty.handler.ssl.OpenSsl;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslProtocols;
import io.netty.handler.ssl.SslProvider;
import io.netty.handler.ssl.SupportedCipherSuiteFilter;
import java.io.File;
import java.io.InputStream;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1784")
public class GrpcSslContexts {
    private static final ApplicationProtocolConfig ALPN;
    private static final String HTTP2_VERSION = "h2";
    private static final String IBM_PROVIDER_NAME = "IBMJSSE2";
    private static final List<String> NEXT_PROTOCOL_VERSIONS;
    private static final ApplicationProtocolConfig NPN;
    private static final ApplicationProtocolConfig NPN_AND_ALPN;
    private static final String OPENJSSE_PROVIDER_NAME = "OpenJSSE";
    private static final String SUN_PROVIDER_NAME = "SunJSSE";
    private static final Logger logger = Logger.getLogger(GrpcSslContexts.class.getName());

    /* JADX INFO: renamed from: io.grpc.netty.GrpcSslContexts$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C122251 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$SslProvider;

        static {
            int[] iArr = new int[SslProvider.values().length];
            $SwitchMap$io$netty$handler$ssl$SslProvider = iArr;
            try {
                iArr[SslProvider.JDK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ConscryptHolder {
        static final Provider PROVIDER;
        static final Throwable UNAVAILABILITY_CAUSE;

        static {
            Provider providerNewProvider = null;
            try {
                th = null;
                providerNewProvider = ConscryptLoader.newProvider();
            } catch (Throwable th) {
                th = th;
            }
            PROVIDER = providerNewProvider;
            UNAVAILABILITY_CAUSE = th;
        }

        private ConscryptHolder() {
        }
    }

    static {
        List<String> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList("h2"));
        NEXT_PROTOCOL_VERSIONS = listUnmodifiableList;
        ApplicationProtocolConfig.Protocol protocol = ApplicationProtocolConfig.Protocol.ALPN;
        ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior = ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE;
        ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior = ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT;
        ALPN = new ApplicationProtocolConfig(protocol, selectorFailureBehavior, selectedListenerFailureBehavior, (Iterable<String>) listUnmodifiableList);
        NPN = new ApplicationProtocolConfig(ApplicationProtocolConfig.Protocol.NPN, selectorFailureBehavior, selectedListenerFailureBehavior, (Iterable<String>) listUnmodifiableList);
        NPN_AND_ALPN = new ApplicationProtocolConfig(ApplicationProtocolConfig.Protocol.NPN_AND_ALPN, selectorFailureBehavior, selectedListenerFailureBehavior, (Iterable<String>) listUnmodifiableList);
    }

    private GrpcSslContexts() {
    }

    @CanIgnoreReturnValue
    public static SslContextBuilder configure(SslContextBuilder sslContextBuilder) {
        return configure(sslContextBuilder, defaultSslProvider());
    }

    private static SslProvider defaultSslProvider() {
        if (OpenSsl.isAvailable()) {
            logger.log(Level.FINE, "Selecting OPENSSL");
            return SslProvider.OPENSSL;
        }
        Provider providerFindJdkProvider = findJdkProvider();
        if (providerFindJdkProvider != null) {
            logger.log(Level.FINE, "Selecting JDK with provider {0}", providerFindJdkProvider);
            return SslProvider.JDK;
        }
        Logger logger2 = logger;
        Level level = Level.INFO;
        logger2.log(level, "Java 9 ALPN API unavailable (this may be normal)");
        logger2.log(level, "netty-tcnative unavailable (this may be normal)", OpenSsl.unavailabilityCause());
        logger2.log(level, "Conscrypt not found (this may be normal)", ConscryptHolder.UNAVAILABILITY_CAUSE);
        logger2.log(level, "Jetty ALPN unavailable (this may be normal)", JettyTlsUtil.getJettyAlpnUnavailabilityCause());
        throw new IllegalStateException("Could not find TLS ALPN provider; no working netty-tcnative, Conscrypt, or Jetty NPN/ALPN available");
    }

    public static void ensureAlpnAndH2Enabled(ApplicationProtocolNegotiator applicationProtocolNegotiator) {
        boolean z = false;
        Preconditions.checkArgument(applicationProtocolNegotiator != null, "ALPN must be configured");
        if (applicationProtocolNegotiator.protocols() != null && !applicationProtocolNegotiator.protocols().isEmpty()) {
            z = true;
        }
        Preconditions.checkArgument(z, "ALPN must be enabled and list HTTP/2 as a supported protocol.");
        Preconditions.checkArgument(applicationProtocolNegotiator.protocols().contains("h2"), "This ALPN config does not support HTTP/2. Expected %s, but got %s'.", "h2", applicationProtocolNegotiator.protocols());
    }

    private static Provider findJdkProvider() {
        for (Provider provider : Security.getProviders("SSLContext.TLS")) {
            if (SUN_PROVIDER_NAME.equals(provider.getName())) {
                if (JettyTlsUtil.isJettyAlpnConfigured() || JettyTlsUtil.isJettyNpnConfigured() || JettyTlsUtil.isJava9AlpnAvailable()) {
                    return provider;
                }
            } else if (IBM_PROVIDER_NAME.equals(provider.getName()) || OPENJSSE_PROVIDER_NAME.equals(provider.getName())) {
                if (JettyTlsUtil.isJava9AlpnAvailable()) {
                    return provider;
                }
            } else {
                if (ConscryptLoader.isConscrypt(provider)) {
                    return provider;
                }
            }
        }
        Provider provider2 = ConscryptHolder.PROVIDER;
        if (provider2 != null) {
            return provider2;
        }
        return null;
    }

    public static SslContextBuilder forClient() {
        return configure(SslContextBuilder.forClient());
    }

    public static SslContextBuilder forServer(File file, File file2) {
        return configure(SslContextBuilder.forServer(file, file2));
    }

    @CanIgnoreReturnValue
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1784")
    public static SslContextBuilder configure(SslContextBuilder sslContextBuilder, SslProvider sslProvider) {
        int i = C122251.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i == 1) {
            Provider providerFindJdkProvider = findJdkProvider();
            if (providerFindJdkProvider != null) {
                return configure(sslContextBuilder, providerFindJdkProvider);
            }
            throw new IllegalArgumentException("Could not find Jetty NPN/ALPN or Conscrypt as installed JDK providers");
        }
        if (i == 2) {
            return sslContextBuilder.sslProvider(SslProvider.OPENSSL).ciphers(Http2SecurityUtil.CIPHERS, SupportedCipherSuiteFilter.INSTANCE).applicationProtocolConfig(OpenSsl.isAlpnSupported() ? NPN_AND_ALPN : NPN);
        }
        throw new IllegalArgumentException("Unsupported provider: " + sslProvider);
    }

    public static SslContextBuilder forServer(File file, File file2, String str) {
        return configure(SslContextBuilder.forServer(file, file2, str));
    }

    public static SslContextBuilder forServer(InputStream inputStream, InputStream inputStream2) {
        return configure(SslContextBuilder.forServer(inputStream, inputStream2));
    }

    public static SslContextBuilder forServer(InputStream inputStream, InputStream inputStream2, String str) {
        return configure(SslContextBuilder.forServer(inputStream, inputStream2, str));
    }

    @CanIgnoreReturnValue
    public static SslContextBuilder configure(SslContextBuilder sslContextBuilder, Provider provider) {
        ApplicationProtocolConfig applicationProtocolConfig;
        if (SUN_PROVIDER_NAME.equals(provider.getName())) {
            if (JettyTlsUtil.isJettyAlpnConfigured()) {
                applicationProtocolConfig = ALPN;
            } else if (JettyTlsUtil.isJettyNpnConfigured()) {
                applicationProtocolConfig = NPN;
            } else if (JettyTlsUtil.isJava9AlpnAvailable()) {
                applicationProtocolConfig = ALPN;
            } else {
                throw new IllegalArgumentException(provider.getName() + " selected, but Java 9+ and Jetty NPN/ALPN unavailable");
            }
        } else if (!IBM_PROVIDER_NAME.equals(provider.getName()) && !OPENJSSE_PROVIDER_NAME.equals(provider.getName())) {
            if (ConscryptLoader.isConscrypt(provider)) {
                applicationProtocolConfig = ALPN;
                sslContextBuilder.protocols(SslProtocols.TLS_v1_2);
            } else {
                throw new IllegalArgumentException("Unknown provider; can't configure: " + provider);
            }
        } else if (JettyTlsUtil.isJava9AlpnAvailable()) {
            applicationProtocolConfig = ALPN;
        } else {
            throw new IllegalArgumentException(provider.getName() + " selected, but Java 9+ ALPN unavailable");
        }
        return sslContextBuilder.sslProvider(SslProvider.JDK).ciphers(Http2SecurityUtil.CIPHERS, SupportedCipherSuiteFilter.INSTANCE).applicationProtocolConfig(applicationProtocolConfig).sslContextProvider(provider);
    }
}
