package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.OpenSslCertificateCompressionConfig;
import io.netty.handler.ssl.util.LazyX509Certificate;
import io.netty.internal.tcnative.AsyncSSLPrivateKeyMethod;
import io.netty.internal.tcnative.CertificateCompressionAlgo;
import io.netty.internal.tcnative.CertificateVerifier;
import io.netty.internal.tcnative.ResultCallback;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SSLPrivateKeyMethod;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateRevokedException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ReferenceCountedOpenSslContext extends SslContext implements ReferenceCounted {
    private static final Integer DH_KEY_LENGTH;
    protected static final int VERIFY_DEPTH = 10;
    private final OpenSslApplicationProtocolNegotiator apn;
    private volatile int bioNonApplicationBufferSize;
    final ClientAuth clientAuth;
    protected long ctx;
    final ReadWriteLock ctxLock;
    final boolean enableOcsp;
    final OpenSslEngineMap engineMap;
    final Certificate[] keyCertChain;
    private final ResourceLeakTracker<ReferenceCountedOpenSslContext> leak;
    private final int mode;
    final String[] protocols;
    private final AbstractReferenceCounted refCnt;
    final boolean tlsFalseStart;
    private final List<String> unmodifiableCiphers;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountedOpenSslContext.class);
    private static final int DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE = Math.max(1, SystemPropertyUtil.getInt("io.netty.handler.ssl.openssl.bioNonApplicationBufferSize", 2048));
    static final boolean USE_TASKS = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.useTasks", true);
    private static final ResourceLeakDetector<ReferenceCountedOpenSslContext> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslContext.class);
    static final boolean CLIENT_ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.client.enableSessionTicketExtension", false);
    static final boolean CLIENT_ENABLE_SESSION_TICKET_TLSV13 = SystemPropertyUtil.getBoolean("jdk.tls.client.enableSessionTicketExtension", true);
    static final boolean SERVER_ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.server.enableSessionTicketExtension", false);
    static final boolean SERVER_ENABLE_SESSION_TICKET_TLSV13 = SystemPropertyUtil.getBoolean("jdk.tls.server.enableSessionTicketExtension", true);
    static final boolean SERVER_ENABLE_SESSION_CACHE = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.sessionCacheServer", true);
    static final boolean CLIENT_ENABLE_SESSION_CACHE = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.sessionCacheClient", false);
    static final OpenSslApplicationProtocolNegotiator NONE_PROTOCOL_NEGOTIATOR = new OpenSslApplicationProtocolNegotiator() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslContext.2
        @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
        public ApplicationProtocolConfig.Protocol protocol() {
            return ApplicationProtocolConfig.Protocol.NONE;
        }

        @Override // io.netty.handler.ssl.ApplicationProtocolNegotiator
        public List<String> protocols() {
            return Collections.EMPTY_LIST;
        }

        @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
        public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
            return ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT;
        }

        @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
        public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior() {
            return ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
        }
    };

    /* JADX INFO: renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C127183 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol */
        static final /* synthetic */ int[] f8943xc16482e4;

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior */
        static final /* synthetic */ int[] f8944xcbdfafc1;

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior */
        static final /* synthetic */ int[] f8945xb32e3251;

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode */
        static final /* synthetic */ int[] f8946xca5a932f;

        static {
            int[] iArr = new int[ApplicationProtocolConfig.SelectedListenerFailureBehavior.values().length];
            f8944xcbdfafc1 = iArr;
            try {
                iArr[ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8944xcbdfafc1[ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ApplicationProtocolConfig.SelectorFailureBehavior.values().length];
            f8945xb32e3251 = iArr2;
            try {
                iArr2[ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8945xb32e3251[ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[OpenSslCertificateCompressionConfig.AlgorithmMode.values().length];
            f8946xca5a932f = iArr3;
            try {
                iArr3[OpenSslCertificateCompressionConfig.AlgorithmMode.Decompress.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8946xca5a932f[OpenSslCertificateCompressionConfig.AlgorithmMode.Compress.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8946xca5a932f[OpenSslCertificateCompressionConfig.AlgorithmMode.Both.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr4 = new int[ApplicationProtocolConfig.Protocol.values().length];
            f8943xc16482e4 = iArr4;
            try {
                iArr4[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8943xc16482e4[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8943xc16482e4[ApplicationProtocolConfig.Protocol.NPN_AND_ALPN.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8943xc16482e4[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AbstractCertificateVerifier extends CertificateVerifier {
        private final OpenSslEngineMap engineMap;

        public AbstractCertificateVerifier(OpenSslEngineMap openSslEngineMap) {
            this.engineMap = openSslEngineMap;
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static int translateToError(Throwable th) {
            if (th instanceof CertificateRevokedException) {
                return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
            }
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                if (cause instanceof CertPathValidatorException) {
                    CertPathValidatorException.Reason reason = ((CertPathValidatorException) cause).getReason();
                    if (reason == CertPathValidatorException.BasicReason.EXPIRED) {
                        return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
                    }
                    if (reason == CertPathValidatorException.BasicReason.NOT_YET_VALID) {
                        return CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID;
                    }
                    if (reason == CertPathValidatorException.BasicReason.REVOKED) {
                        return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
                    }
                }
            }
            return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
        }

        public final int verify(long j, byte[][] bArr, String str) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j);
            if (referenceCountedOpenSslEngine == null) {
                return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
            }
            try {
                verify(referenceCountedOpenSslEngine, ReferenceCountedOpenSslContext.certificates(bArr), str);
                return CertificateVerifier.X509_V_OK;
            } catch (Throwable th) {
                ReferenceCountedOpenSslContext.logger.debug("verification of certificate failed", (Throwable) th);
                referenceCountedOpenSslEngine.initHandshakeException(th);
                return th instanceof OpenSslCertificateException ? th.errorCode() : th instanceof CertificateExpiredException ? CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED : th instanceof CertificateNotYetValidException ? CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID : PlatformDependent.javaVersion() >= 7 ? translateToError(th) : CertificateVerifier.X509_V_ERR_UNSPECIFIED;
            }
        }

        public abstract void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AsyncPrivateKeyMethod implements AsyncSSLPrivateKeyMethod {
        private final OpenSslEngineMap engineMap;
        private final OpenSslAsyncPrivateKeyMethod keyMethod;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class ResultCallbackListener implements FutureListener<byte[]> {
            private final ReferenceCountedOpenSslEngine engine;
            private final ResultCallback<byte[]> resultCallback;
            private final long ssl;

            public ResultCallbackListener(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, long j, ResultCallback<byte[]> resultCallback) {
                this.engine = referenceCountedOpenSslEngine;
                this.ssl = j;
                this.resultCallback = resultCallback;
            }

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<byte[]> future) {
                Throwable thCause = future.cause();
                if (thCause == null) {
                    try {
                        this.resultCallback.onSuccess(this.ssl, ReferenceCountedOpenSslContext.verifyResult(future.getNow()));
                        return;
                    } catch (SignatureException e) {
                        thCause = e;
                        this.engine.initHandshakeException(thCause);
                    }
                }
                this.resultCallback.onError(this.ssl, thCause);
            }
        }

        public AsyncPrivateKeyMethod(OpenSslEngineMap openSslEngineMap, OpenSslAsyncPrivateKeyMethod openSslAsyncPrivateKeyMethod) {
            this.engineMap = openSslEngineMap;
            this.keyMethod = openSslAsyncPrivateKeyMethod;
        }

        public void decrypt(long j, byte[] bArr, ResultCallback<byte[]> resultCallback) {
            try {
                ReferenceCountedOpenSslEngine referenceCountedOpenSslEngineRetrieveEngine = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j);
                this.keyMethod.decrypt(referenceCountedOpenSslEngineRetrieveEngine, bArr).addListener(new ResultCallbackListener(referenceCountedOpenSslEngineRetrieveEngine, j, resultCallback));
            } catch (SSLException e) {
                resultCallback.onError(j, e);
            }
        }

        public void sign(long j, int i, byte[] bArr, ResultCallback<byte[]> resultCallback) {
            try {
                ReferenceCountedOpenSslEngine referenceCountedOpenSslEngineRetrieveEngine = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j);
                this.keyMethod.sign(referenceCountedOpenSslEngineRetrieveEngine, i, bArr).addListener(new ResultCallbackListener(referenceCountedOpenSslEngineRetrieveEngine, j, resultCallback));
            } catch (SSLException e) {
                resultCallback.onError(j, e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CompressionAlgorithm implements CertificateCompressionAlgo {
        private final OpenSslCertificateCompressionAlgorithm compressionAlgorithm;
        private final OpenSslEngineMap engineMap;

        public CompressionAlgorithm(OpenSslEngineMap openSslEngineMap, OpenSslCertificateCompressionAlgorithm openSslCertificateCompressionAlgorithm) {
            this.engineMap = openSslEngineMap;
            this.compressionAlgorithm = openSslCertificateCompressionAlgorithm;
        }

        public int algorithmId() {
            return this.compressionAlgorithm.algorithmId();
        }

        public byte[] compress(long j, byte[] bArr) throws SSLException {
            return this.compressionAlgorithm.compress(ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j), bArr);
        }

        public byte[] decompress(long j, int i, byte[] bArr) throws SSLException {
            return this.compressionAlgorithm.decompress(ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j), i, bArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DefaultOpenSslEngineMap implements OpenSslEngineMap {
        private final Map<Long, ReferenceCountedOpenSslEngine> engines;

        private DefaultOpenSslEngineMap() {
            this.engines = PlatformDependent.newConcurrentHashMap();
        }

        @Override // io.netty.handler.ssl.OpenSslEngineMap
        public void add(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) {
            this.engines.put(Long.valueOf(referenceCountedOpenSslEngine.sslPointer()), referenceCountedOpenSslEngine);
        }

        @Override // io.netty.handler.ssl.OpenSslEngineMap
        public ReferenceCountedOpenSslEngine get(long j) {
            return this.engines.get(Long.valueOf(j));
        }

        @Override // io.netty.handler.ssl.OpenSslEngineMap
        public ReferenceCountedOpenSslEngine remove(long j) {
            return this.engines.remove(Long.valueOf(j));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PrivateKeyMethod implements SSLPrivateKeyMethod {
        private final OpenSslEngineMap engineMap;
        private final OpenSslPrivateKeyMethod keyMethod;

        public PrivateKeyMethod(OpenSslEngineMap openSslEngineMap, OpenSslPrivateKeyMethod openSslPrivateKeyMethod) {
            this.engineMap = openSslEngineMap;
            this.keyMethod = openSslPrivateKeyMethod;
        }

        public byte[] decrypt(long j, byte[] bArr) throws Exception {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngineRetrieveEngine = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j);
            try {
                return ReferenceCountedOpenSslContext.verifyResult(this.keyMethod.decrypt(referenceCountedOpenSslEngineRetrieveEngine, bArr));
            } catch (Exception e) {
                referenceCountedOpenSslEngineRetrieveEngine.initHandshakeException(e);
                throw e;
            }
        }

        public byte[] sign(long j, int i, byte[] bArr) throws Exception {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngineRetrieveEngine = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j);
            try {
                return ReferenceCountedOpenSslContext.verifyResult(this.keyMethod.sign(referenceCountedOpenSslEngineRetrieveEngine, i, bArr));
            } catch (Exception e) {
                referenceCountedOpenSslEngineRetrieveEngine.initHandshakeException(e);
                throw e;
            }
        }
    }

    static {
        Integer numValueOf = null;
        try {
            String str = SystemPropertyUtil.get("jdk.tls.ephemeralDHKeySize");
            if (str != null) {
                try {
                    numValueOf = Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    logger.debug("ReferenceCountedOpenSslContext supports -Djdk.tls.ephemeralDHKeySize={int}, but got: ".concat(str));
                }
            }
        } catch (Throwable unused2) {
        }
        DH_KEY_LENGTH = numValueOf;
    }

    public ReferenceCountedOpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, int i, Certificate[] certificateArr, ClientAuth clientAuth, String[] strArr, boolean z, boolean z2, boolean z3, Map.Entry<SslContextOption<?>, Object>... entryArr) {
        boolean zBooleanValue;
        OpenSslPrivateKeyMethod openSslPrivateKeyMethod;
        OpenSslAsyncPrivateKeyMethod openSslAsyncPrivateKeyMethod;
        OpenSslCertificateCompressionConfig openSslCertificateCompressionConfig;
        Integer num;
        super(z);
        this.refCnt = new AbstractReferenceCounted() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslContext.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.AbstractReferenceCounted
            public void deallocate() {
                ReferenceCountedOpenSslContext.this.destroy();
                if (ReferenceCountedOpenSslContext.this.leak != null) {
                    ReferenceCountedOpenSslContext.this.leak.close(ReferenceCountedOpenSslContext.this);
                }
            }

            @Override // io.netty.util.ReferenceCounted
            public ReferenceCounted touch(Object obj) {
                if (ReferenceCountedOpenSslContext.this.leak != null) {
                    ReferenceCountedOpenSslContext.this.leak.record(obj);
                }
                return ReferenceCountedOpenSslContext.this;
            }
        };
        this.engineMap = new DefaultOpenSslEngineMap();
        this.ctxLock = new ReentrantReadWriteLock();
        this.bioNonApplicationBufferSize = DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE;
        OpenSsl.ensureAvailability();
        if (z2 && !OpenSsl.isOcspSupported()) {
            throw new IllegalStateException("OCSP is not supported.");
        }
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("mode most be either SSL.SSL_MODE_SERVER or SSL.SSL_MODE_CLIENT");
        }
        boolean zBooleanValue2 = USE_TASKS;
        if (entryArr != null) {
            openSslPrivateKeyMethod = null;
            openSslAsyncPrivateKeyMethod = null;
            openSslCertificateCompressionConfig = null;
            num = null;
            zBooleanValue = false;
            for (Map.Entry<SslContextOption<?>, Object> entry : entryArr) {
                SslContextOption<?> key = entry.getKey();
                if (key == OpenSslContextOption.TLS_FALSE_START) {
                    zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
                } else if (key == OpenSslContextOption.USE_TASKS) {
                    zBooleanValue2 = ((Boolean) entry.getValue()).booleanValue();
                } else if (key == OpenSslContextOption.PRIVATE_KEY_METHOD) {
                    openSslPrivateKeyMethod = (OpenSslPrivateKeyMethod) entry.getValue();
                } else if (key == OpenSslContextOption.ASYNC_PRIVATE_KEY_METHOD) {
                    openSslAsyncPrivateKeyMethod = (OpenSslAsyncPrivateKeyMethod) entry.getValue();
                } else if (key == OpenSslContextOption.CERTIFICATE_COMPRESSION_ALGORITHMS) {
                    openSslCertificateCompressionConfig = (OpenSslCertificateCompressionConfig) entry.getValue();
                } else if (key == OpenSslContextOption.MAX_CERTIFICATE_LIST_BYTES) {
                    num = (Integer) entry.getValue();
                } else {
                    logger.debug("Skipping unsupported SslContextOption: " + entry.getKey());
                }
            }
        } else {
            zBooleanValue = false;
            openSslPrivateKeyMethod = null;
            openSslAsyncPrivateKeyMethod = null;
            openSslCertificateCompressionConfig = null;
            num = null;
        }
        if (openSslPrivateKeyMethod != null && openSslAsyncPrivateKeyMethod != null) {
            throw new IllegalArgumentException("You can either only use OpenSslAsyncPrivateKeyMethod or OpenSslPrivateKeyMethod");
        }
        this.tlsFalseStart = zBooleanValue;
        this.leak = z3 ? leakDetector.track(this) : null;
        this.mode = i;
        this.clientAuth = isServer() ? (ClientAuth) ObjectUtil.checkNotNull(clientAuth, "clientAuth") : ClientAuth.NONE;
        this.protocols = strArr == null ? OpenSsl.defaultProtocols(i == 0) : strArr;
        this.enableOcsp = z2;
        this.keyCertChain = certificateArr == null ? null : (Certificate[]) certificateArr.clone();
        String[] strArrFilterCipherSuites = ((CipherSuiteFilter) ObjectUtil.checkNotNull(cipherSuiteFilter, "cipherFilter")).filterCipherSuites(iterable, OpenSsl.DEFAULT_CIPHERS, OpenSsl.availableJavaCipherSuites());
        LinkedHashSet linkedHashSet = new LinkedHashSet(strArrFilterCipherSuites.length);
        Collections.addAll(linkedHashSet, strArrFilterCipherSuites);
        ArrayList arrayList = new ArrayList(linkedHashSet);
        this.unmodifiableCiphers = arrayList;
        this.apn = (OpenSslApplicationProtocolNegotiator) ObjectUtil.checkNotNull(openSslApplicationProtocolNegotiator, "apn");
        try {
            boolean zIsTlsv13Supported = OpenSsl.isTlsv13Supported();
            try {
                this.ctx = SSLContext.make(zIsTlsv13Supported ? 62 : 30, i);
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                try {
                    if (arrayList.isEmpty()) {
                        SSLContext.setCipherSuite(this.ctx, "", false);
                        if (zIsTlsv13Supported) {
                            SSLContext.setCipherSuite(this.ctx, "", true);
                        }
                    } else {
                        CipherSuiteConverter.convertToCipherStrings(arrayList, sb, sb2, OpenSsl.isBoringSSL());
                        SSLContext.setCipherSuite(this.ctx, sb.toString(), false);
                        if (zIsTlsv13Supported) {
                            SSLContext.setCipherSuite(this.ctx, OpenSsl.checkTls13Ciphers(logger, sb2.toString()), true);
                        }
                    }
                    int options = SSLContext.getOptions(this.ctx) | SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_CIPHER_SERVER_PREFERENCE | SSL.SSL_OP_NO_COMPRESSION | SSL.SSL_OP_NO_TICKET;
                    options = sb.length() == 0 ? options | SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2 : options;
                    SSLContext.setOptions(this.ctx, zIsTlsv13Supported ? options : options | SSL.SSL_OP_NO_TLSv1_3);
                    long j = this.ctx;
                    SSLContext.setMode(j, SSLContext.getMode(j) | SSL.SSL_MODE_ACCEPT_MOVING_WRITE_BUFFER);
                    Integer num2 = DH_KEY_LENGTH;
                    if (num2 != null) {
                        SSLContext.setTmpDHLength(this.ctx, num2.intValue());
                    }
                    List<String> listProtocols = openSslApplicationProtocolNegotiator.protocols();
                    if (!listProtocols.isEmpty()) {
                        String[] strArr2 = (String[]) listProtocols.toArray(new String[0]);
                        int iOpensslSelectorFailureBehavior = opensslSelectorFailureBehavior(openSslApplicationProtocolNegotiator.selectorFailureBehavior());
                        int i2 = C127183.f8943xc16482e4[openSslApplicationProtocolNegotiator.protocol().ordinal()];
                        if (i2 == 1) {
                            SSLContext.setNpnProtos(this.ctx, strArr2, iOpensslSelectorFailureBehavior);
                        } else if (i2 == 2) {
                            SSLContext.setAlpnProtos(this.ctx, strArr2, iOpensslSelectorFailureBehavior);
                        } else {
                            if (i2 != 3) {
                                throw new Error();
                            }
                            SSLContext.setNpnProtos(this.ctx, strArr2, iOpensslSelectorFailureBehavior);
                            SSLContext.setAlpnProtos(this.ctx, strArr2, iOpensslSelectorFailureBehavior);
                        }
                    }
                    if (z2) {
                        SSLContext.enableOcsp(this.ctx, isClient());
                    }
                    SSLContext.setUseTasks(this.ctx, zBooleanValue2);
                    if (openSslPrivateKeyMethod != null) {
                        SSLContext.setPrivateKeyMethod(this.ctx, new PrivateKeyMethod(this.engineMap, openSslPrivateKeyMethod));
                    }
                    if (openSslAsyncPrivateKeyMethod != null) {
                        SSLContext.setPrivateKeyMethod(this.ctx, new AsyncPrivateKeyMethod(this.engineMap, openSslAsyncPrivateKeyMethod));
                    }
                    if (openSslCertificateCompressionConfig != null) {
                        for (OpenSslCertificateCompressionConfig.AlgorithmConfig algorithmConfig : openSslCertificateCompressionConfig) {
                            CompressionAlgorithm compressionAlgorithm = new CompressionAlgorithm(this.engineMap, algorithmConfig.algorithm());
                            int i4 = C127183.f8946xca5a932f[algorithmConfig.mode().ordinal()];
                            if (i4 == 1) {
                                SSLContext.addCertificateCompressionAlgorithm(this.ctx, SSL.SSL_CERT_COMPRESSION_DIRECTION_DECOMPRESS, compressionAlgorithm);
                            } else if (i4 == 2) {
                                SSLContext.addCertificateCompressionAlgorithm(this.ctx, SSL.SSL_CERT_COMPRESSION_DIRECTION_COMPRESS, compressionAlgorithm);
                            } else {
                                if (i4 != 3) {
                                    throw new IllegalStateException();
                                }
                                SSLContext.addCertificateCompressionAlgorithm(this.ctx, SSL.SSL_CERT_COMPRESSION_DIRECTION_BOTH, compressionAlgorithm);
                            }
                        }
                    }
                    if (num != null) {
                        SSLContext.setMaxCertList(this.ctx, num.intValue());
                    }
                    SSLContext.setCurvesList(this.ctx, OpenSsl.NAMED_GROUPS);
                } catch (SSLException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SSLException("failed to set cipher suite: " + this.unmodifiableCiphers, e2);
                }
            } catch (Exception e3) {
                throw new SSLException("failed to create an SSL_CTX", e3);
            }
        } catch (Throwable th) {
            release();
            throw th;
        }
    }

    public static X509Certificate[] certificates(byte[][] bArr) {
        int length = bArr.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i = 0; i < length; i++) {
            x509CertificateArr[i] = new LazyX509Certificate(bArr[i]);
        }
        return x509CertificateArr;
    }

    public static X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return PlatformDependent.javaVersion() >= 7 ? OpenSslX509TrustManagerWrapper.wrapIfNeeded((X509TrustManager) trustManager) : (X509TrustManager) trustManager;
            }
        }
        throw new IllegalStateException("no X509TrustManager found");
    }

    public static X509KeyManager chooseX509KeyManager(KeyManager[] keyManagerArr) {
        for (KeyManager keyManager : keyManagerArr) {
            if (keyManager instanceof X509KeyManager) {
                return (X509KeyManager) keyManager;
            }
        }
        throw new IllegalStateException("no X509KeyManager found");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroy() {
        Lock lockWriteLock = this.ctxLock.writeLock();
        lockWriteLock.lock();
        try {
            long j = this.ctx;
            if (j != 0) {
                if (this.enableOcsp) {
                    SSLContext.disableOcsp(j);
                }
                SSLContext.free(this.ctx);
                this.ctx = 0L;
                OpenSslSessionContext openSslSessionContextSessionContext = sessionContext();
                if (openSslSessionContextSessionContext != null) {
                    openSslSessionContextSessionContext.destroy();
                }
            }
            lockWriteLock.unlock();
        } catch (Throwable th) {
            lockWriteLock.unlock();
            throw th;
        }
    }

    public static void freeBio(long j) {
        if (j != 0) {
            SSL.freeBIO(j);
        }
    }

    private static long newBIO(ByteBuf byteBuf) {
        try {
            long jNewMemBIO = SSL.newMemBIO();
            int i = byteBuf.readableBytes();
            if (SSL.bioWrite(jNewMemBIO, OpenSsl.memoryAddress(byteBuf) + ((long) byteBuf.readerIndex()), i) == i) {
                return jNewMemBIO;
            }
            SSL.freeBIO(jNewMemBIO);
            throw new IllegalStateException("Could not write data to memory BIO");
        } finally {
            byteBuf.release();
        }
    }

    private static int opensslSelectorFailureBehavior(ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior) {
        int i = C127183.f8945xb32e3251[selectorFailureBehavior.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new Error();
    }

    public static OpenSslKeyMaterialProvider providerFor(KeyManagerFactory keyManagerFactory, String str) {
        return keyManagerFactory instanceof OpenSslX509KeyManagerFactory ? ((OpenSslX509KeyManagerFactory) keyManagerFactory).newProvider() : keyManagerFactory instanceof OpenSslCachingX509KeyManagerFactory ? ((OpenSslCachingX509KeyManagerFactory) keyManagerFactory).newProvider(str) : new OpenSslKeyMaterialProvider(chooseX509KeyManager(keyManagerFactory.getKeyManagers()), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ReferenceCountedOpenSslEngine retrieveEngine(OpenSslEngineMap openSslEngineMap, long j) throws SSLException {
        ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = openSslEngineMap.get(j);
        if (referenceCountedOpenSslEngine != null) {
            return referenceCountedOpenSslEngine;
        }
        throw new SSLException("Could not find a " + StringUtil.simpleClassName((Class<?>) ReferenceCountedOpenSslEngine.class) + " for sslPointer " + j);
    }

    public static void setKeyMaterial(long j, X509Certificate[] x509CertificateArr, PrivateKey privateKey, String str) throws Throwable {
        long bio;
        long bio2;
        long bio3 = 0;
        PemEncoded pem = null;
        try {
            try {
                ByteBufAllocator byteBufAllocator = ByteBufAllocator.DEFAULT;
                pem = PemX509Certificate.toPEM(byteBufAllocator, true, x509CertificateArr);
                bio = toBIO(byteBufAllocator, pem.retain());
                try {
                    bio2 = toBIO(byteBufAllocator, pem.retain());
                    if (privateKey != null) {
                        try {
                            bio3 = toBIO(byteBufAllocator, privateKey);
                        } catch (SSLException e) {
                            throw e;
                        } catch (Exception e2) {
                            e = e2;
                            throw new SSLException("failed to set certificate and key", e);
                        }
                    }
                    long j2 = bio3;
                    try {
                        SSLContext.setCertificateBio(j, bio, j2, str == null ? "" : str);
                        SSLContext.setCertificateChainBio(j, bio2, true);
                        freeBio(j2);
                        freeBio(bio);
                        freeBio(bio2);
                        pem.release();
                    } catch (SSLException e3) {
                        throw e3;
                    } catch (Exception e5) {
                        e = e5;
                        throw new SSLException("failed to set certificate and key", e);
                    } catch (Throwable th) {
                        th = th;
                        bio3 = j2;
                        freeBio(bio3);
                        freeBio(bio);
                        freeBio(bio2);
                        if (pem != null) {
                            pem.release();
                        }
                        throw th;
                    }
                } catch (SSLException e6) {
                } catch (Exception e7) {
                    e = e7;
                } catch (Throwable th2) {
                    th = th2;
                    bio2 = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SSLException e8) {
        } catch (Exception e9) {
            e = e9;
        } catch (Throwable th4) {
            th = th4;
            bio = 0;
            bio2 = 0;
        }
    }

    public static long toBIO(ByteBufAllocator byteBufAllocator, PrivateKey privateKey) {
        if (privateKey == null) {
            return 0L;
        }
        PemEncoded pem = PemPrivateKey.toPEM(byteBufAllocator, true, privateKey);
        try {
            return toBIO(byteBufAllocator, pem.retain());
        } finally {
            pem.release();
        }
    }

    public static OpenSslApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig applicationProtocolConfig) {
        if (applicationProtocolConfig == null) {
            return NONE_PROTOCOL_NEGOTIATOR;
        }
        int i = C127183.f8943xc16482e4[applicationProtocolConfig.protocol().ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i == 4) {
                return NONE_PROTOCOL_NEGOTIATOR;
            }
            throw new Error();
        }
        int i2 = C127183.f8944xcbdfafc1[applicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
        if (i2 != 1 && i2 != 2) {
            throw new UnsupportedOperationException("OpenSSL provider does not support " + applicationProtocolConfig.selectedListenerFailureBehavior() + " behavior");
        }
        int i4 = C127183.f8945xb32e3251[applicationProtocolConfig.selectorFailureBehavior().ordinal()];
        if (i4 == 1 || i4 == 2) {
            return new OpenSslDefaultApplicationProtocolNegotiator(applicationProtocolConfig);
        }
        throw new UnsupportedOperationException("OpenSSL provider does not support " + applicationProtocolConfig.selectorFailureBehavior() + " behavior");
    }

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    public static boolean useExtendedTrustManager(X509TrustManager x509TrustManager) {
        return PlatformDependent.javaVersion() >= 7 && (x509TrustManager instanceof X509ExtendedTrustManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] verifyResult(byte[] bArr) throws SignatureException {
        if (bArr != null) {
            return bArr;
        }
        throw new SignatureException();
    }

    @Override // io.netty.handler.ssl.SslContext
    public ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.apn;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final List<String> cipherSuites() {
        return this.unmodifiableCiphers;
    }

    @Deprecated
    public final long context() {
        return sslCtxPointer();
    }

    public int getBioNonApplicationBufferSize() {
        return this.bioNonApplicationBufferSize;
    }

    @Deprecated
    public boolean getRejectRemoteInitiatedRenegotiation() {
        return true;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.mode == 0;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i) {
        return newEngine0(byteBufAllocator, str, i, true);
    }

    public SSLEngine newEngine0(ByteBufAllocator byteBufAllocator, String str, int i, boolean z) {
        return new ReferenceCountedOpenSslEngine(this, byteBufAllocator, str, i, z, true);
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z) {
        return new SslHandler(newEngine0(byteBufAllocator, null, -1, false), z);
    }

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.refCnt.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release() {
        return this.refCnt.release();
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain() {
        this.refCnt.retain();
        return this;
    }

    @Override // io.netty.handler.ssl.SslContext
    public abstract OpenSslSessionContext sessionContext();

    public void setBioNonApplicationBufferSize(int i) {
        this.bioNonApplicationBufferSize = ObjectUtil.checkPositiveOrZero(i, "bioNonApplicationBufferSize");
    }

    @Deprecated
    public final void setPrivateKeyMethod(OpenSslPrivateKeyMethod openSslPrivateKeyMethod) {
        ObjectUtil.checkNotNull(openSslPrivateKeyMethod, "method");
        Lock lockWriteLock = this.ctxLock.writeLock();
        lockWriteLock.lock();
        try {
            SSLContext.setPrivateKeyMethod(this.ctx, new PrivateKeyMethod(this.engineMap, openSslPrivateKeyMethod));
        } finally {
            lockWriteLock.unlock();
        }
    }

    @Deprecated
    public void setRejectRemoteInitiatedRenegotiation(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Renegotiation is not supported");
        }
    }

    @Deprecated
    public final void setTicketKeys(byte[] bArr) {
        sessionContext().setTicketKeys(bArr);
    }

    @Deprecated
    public final void setUseTasks(boolean z) {
        Lock lockWriteLock = this.ctxLock.writeLock();
        lockWriteLock.lock();
        try {
            SSLContext.setUseTasks(this.ctx, z);
        } finally {
            lockWriteLock.unlock();
        }
    }

    @Deprecated
    public final long sslCtxPointer() {
        Lock lock = this.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.getSslCtx(this.ctx);
        } finally {
            lock.unlock();
        }
    }

    @Deprecated
    public final OpenSslSessionStats stats() {
        return sessionContext().stats();
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator) {
        return newEngine(byteBufAllocator, null, -1);
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i, boolean z) {
        return new SslHandler(newEngine0(byteBufAllocator, str, i, false), z);
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release(int i) {
        return this.refCnt.release(i);
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain(int i) {
        this.refCnt.retain(i);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch(Object obj) {
        this.refCnt.touch(obj);
        return this;
    }

    @Override // io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z, Executor executor) {
        return new SslHandler(newEngine0(byteBufAllocator, null, -1, false), z, executor);
    }

    @Override // io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i, boolean z, Executor executor) {
        return new SslHandler(newEngine0(byteBufAllocator, str, i, false), executor);
    }

    public static long toBIO(ByteBufAllocator byteBufAllocator, X509Certificate... x509CertificateArr) {
        if (x509CertificateArr == null) {
            return 0L;
        }
        ObjectUtil.checkNonEmpty(x509CertificateArr, "certChain");
        PemEncoded pem = PemX509Certificate.toPEM(byteBufAllocator, true, x509CertificateArr);
        try {
            return toBIO(byteBufAllocator, pem.retain());
        } finally {
            pem.release();
        }
    }

    public static long toBIO(ByteBufAllocator byteBufAllocator, PemEncoded pemEncoded) {
        try {
            ByteBuf byteBufContent = pemEncoded.content();
            if (byteBufContent.isDirect()) {
                return newBIO(byteBufContent.retainedSlice());
            }
            ByteBuf byteBufDirectBuffer = byteBufAllocator.directBuffer(byteBufContent.readableBytes());
            try {
                byteBufDirectBuffer.writeBytes(byteBufContent, byteBufContent.readerIndex(), byteBufContent.readableBytes());
                long jNewBIO = newBIO(byteBufDirectBuffer.retainedSlice());
                try {
                    if (pemEncoded.isSensitive()) {
                        SslUtils.zeroout(byteBufDirectBuffer);
                    }
                    return jNewBIO;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (pemEncoded.isSensitive()) {
                        SslUtils.zeroout(byteBufDirectBuffer);
                    }
                    throw th;
                } finally {
                }
            }
        } finally {
            pemEncoded.release();
        }
    }
}
