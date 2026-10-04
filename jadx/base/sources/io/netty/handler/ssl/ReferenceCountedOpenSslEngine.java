package io.netty.handler.ssl;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.util.LazyJavaxX509Certificate;
import io.netty.handler.ssl.util.LazyX509Certificate;
import io.netty.internal.tcnative.AsyncTask;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.security.cert.X509Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ReferenceCountedOpenSslEngine extends SSLEngine implements ReferenceCounted, ApplicationProtocolAccessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING;
    private static final SSLEngineResult NEED_UNWRAP_CLOSED;
    private static final SSLEngineResult NEED_UNWRAP_OK;
    private static final SSLEngineResult NEED_WRAP_CLOSED;
    private static final SSLEngineResult NEED_WRAP_OK;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV2 = 0;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV3 = 1;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1 = 2;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_1 = 3;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_2 = 4;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_3 = 5;
    private Object algorithmConstraints;
    final ByteBufAllocator alloc;
    private final OpenSslApplicationProtocolNegotiator apn;
    private volatile String applicationProtocol;
    private volatile ClientAuth clientAuth;
    private final boolean clientMode;
    private volatile boolean destroyed;
    private final boolean enableOcsp;
    private String endPointIdentificationAlgorithm;
    private final OpenSslEngineMap engineMap;
    private String[] explicitlyEnabledProtocols;
    private HandshakeState handshakeState;
    private boolean isInboundDone;
    final boolean jdkCompatibilityMode;
    private volatile long lastAccessed;
    private final ResourceLeakTracker<ReferenceCountedOpenSslEngine> leak;
    private volatile Collection<?> matchers;
    private int maxWrapBufferSize;
    private int maxWrapOverhead;
    private volatile boolean needTask;
    private long networkBIO;
    private boolean outboundClosed;
    private final ReferenceCountedOpenSslContext parentContext;
    private Throwable pendingException;
    private boolean receivedShutdown;
    private final AbstractReferenceCounted refCnt;
    private final OpenSslSession session;
    private boolean sessionSet;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private List<String> sniHostNames;
    private long ssl;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountedOpenSslEngine.class);
    private static final ResourceLeakDetector<ReferenceCountedOpenSslEngine> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslEngine.class);
    private static final int[] OPENSSL_OP_NO_PROTOCOLS = {SSL.SSL_OP_NO_SSLv2, SSL.SSL_OP_NO_SSLv3, SSL.SSL_OP_NO_TLSv1, SSL.SSL_OP_NO_TLSv1_1, SSL.SSL_OP_NO_TLSv1_2, SSL.SSL_OP_NO_TLSv1_3};
    static final int MAX_PLAINTEXT_LENGTH = SSL.SSL_MAX_PLAINTEXT_LENGTH;
    static final int MAX_RECORD_SIZE = SSL.SSL_MAX_RECORD_LENGTH;

    /* JADX INFO: renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslEngine$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C127213 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol */
        static final /* synthetic */ int[] f8947xc16482e4;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ClientAuth;

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState */
        static final /* synthetic */ int[] f8948xea902ccf;

        static {
            int[] iArr = new int[ApplicationProtocolConfig.Protocol.values().length];
            f8947xc16482e4 = iArr;
            try {
                iArr[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8947xc16482e4[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8947xc16482e4[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8947xc16482e4[ApplicationProtocolConfig.Protocol.NPN_AND_ALPN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ClientAuth.values().length];
            $SwitchMap$io$netty$handler$ssl$ClientAuth = iArr2;
            try {
                iArr2[ClientAuth.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.REQUIRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.OPTIONAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[HandshakeState.values().length];
            f8948xea902ccf = iArr3;
            try {
                iArr3[HandshakeState.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8948xea902ccf[HandshakeState.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8948xea902ccf[HandshakeState.STARTED_IMPLICITLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8948xea902ccf[HandshakeState.STARTED_EXPLICITLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class AsyncTaskDecorator extends TaskDecorator<AsyncTask> implements AsyncRunnable {
        public AsyncTaskDecorator(AsyncTask asyncTask) {
            super(asyncTask);
        }

        @Override // io.netty.handler.ssl.AsyncRunnable
        public void run(Runnable runnable) {
            if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                return;
            }
            this.task.runAsync(ReferenceCountedOpenSslEngine.this.new TaskDecorator(runnable));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class DefaultOpenSslSession implements OpenSslSession {
        private String cipher;
        private volatile long creationTime;
        private volatile Certificate[] localCertificateChain;
        private Certificate[] peerCerts;
        private String protocol;
        private final OpenSslSessionContext sessionContext;
        private Map<String, Object> values;
        private X509Certificate[] x509PeerCerts;
        private boolean valid = true;

        /* JADX INFO: renamed from: id */
        private OpenSslSessionId f8949id = OpenSslSessionId.NULL_ID;
        private volatile int applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;

        public DefaultOpenSslSession(OpenSslSessionContext openSslSessionContext) {
            this.sessionContext = openSslSessionContext;
        }

        private void initCerts(byte[][] bArr, int i) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i4 = i + i2;
                this.peerCerts[i4] = new LazyX509Certificate(bArr[i2]);
                this.x509PeerCerts[i4] = new LazyJavaxX509Certificate(bArr[i2]);
            }
        }

        private SSLSessionBindingEvent newSSLSessionBindingEvent(String str) {
            return new SSLSessionBindingEvent(ReferenceCountedOpenSslEngine.this.session, str);
        }

        private void notifyUnbound(Object obj, String str) {
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueUnbound(newSSLSessionBindingEvent(str));
            }
        }

        @Override // javax.net.ssl.SSLSession
        public int getApplicationBufferSize() {
            return this.applicationBufferSize;
        }

        @Override // javax.net.ssl.SSLSession
        public String getCipherSuite() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    String str = this.cipher;
                    return str == null ? "SSL_NULL_WITH_NULL_NULL" : str;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public long getCreationTime() {
            long j;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                j = this.creationTime;
            }
            return j;
        }

        @Override // javax.net.ssl.SSLSession
        public byte[] getId() {
            return sessionId().cloneBytes();
        }

        @Override // javax.net.ssl.SSLSession
        public long getLastAccessedTime() {
            long j = ReferenceCountedOpenSslEngine.this.lastAccessed;
            return j == -1 ? getCreationTime() : j;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getLocalCertificates() {
            Certificate[] certificateArr = this.localCertificateChain;
            if (certificateArr == null) {
                return null;
            }
            return (Certificate[]) certificateArr.clone();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getLocalPrincipal() {
            Certificate[] certificateArr = this.localCertificateChain;
            if (certificateArr == null || certificateArr.length == 0) {
                return null;
            }
            return ((java.security.cert.X509Certificate) certificateArr[0]).getSubjectX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPacketBufferSize() {
            return SSL.SSL_MAX_ENCRYPTED_LENGTH;
        }

        @Override // javax.net.ssl.SSLSession
        public X509Certificate[] getPeerCertificateChain() {
            X509Certificate[] x509CertificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (ReferenceCountedOpenSslEngine.isEmpty(this.x509PeerCerts)) {
                        throw new SSLPeerUnverifiedException("peer not verified");
                    }
                    x509CertificateArr = (X509Certificate[]) this.x509PeerCerts.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return x509CertificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getPeerCertificates() {
            Certificate[] certificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (ReferenceCountedOpenSslEngine.isEmpty(this.peerCerts)) {
                        throw new SSLPeerUnverifiedException("peer not verified");
                    }
                    certificateArr = (Certificate[]) this.peerCerts.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return certificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public String getPeerHost() {
            return ReferenceCountedOpenSslEngine.this.getPeerHost();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPeerPort() {
            return ReferenceCountedOpenSslEngine.this.getPeerPort();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getPeerPrincipal() {
            return ((java.security.cert.X509Certificate) getPeerCertificates()[0]).getSubjectX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public String getProtocol() {
            String version;
            String str = this.protocol;
            if (str != null) {
                return str;
            }
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    version = !ReferenceCountedOpenSslEngine.this.isDestroyed() ? SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl) : "";
                } catch (Throwable th) {
                    throw th;
                }
            }
            return version;
        }

        @Override // javax.net.ssl.SSLSession
        public Object getValue(String str) {
            ObjectUtil.checkNotNull(str, "name");
            synchronized (this) {
                try {
                    Map<String, Object> map = this.values;
                    if (map == null) {
                        return null;
                    }
                    return map.get(str);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public String[] getValueNames() {
            synchronized (this) {
                try {
                    Map<String, Object> map = this.values;
                    if (map != null && !map.isEmpty()) {
                        return (String[]) map.keySet().toArray(new String[0]);
                    }
                    return EmptyArrays.EMPTY_STRINGS;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public void handshakeFinished(byte[] bArr, String str, String str2, byte[] bArr2, byte[][] bArr3, long j, long j2) {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                        throw new SSLException("Already closed");
                    }
                    this.creationTime = j;
                    OpenSslSessionId openSslSessionId = this.f8949id;
                    OpenSslSessionId openSslSessionId2 = OpenSslSessionId.NULL_ID;
                    if (openSslSessionId == openSslSessionId2) {
                        if (bArr != null) {
                            openSslSessionId2 = new OpenSslSessionId(bArr);
                        }
                        this.f8949id = openSslSessionId2;
                    }
                    this.cipher = ReferenceCountedOpenSslEngine.this.toJavaCipherSuite(str);
                    this.protocol = str2;
                    if (ReferenceCountedOpenSslEngine.this.clientMode) {
                        if (ReferenceCountedOpenSslEngine.isEmpty(bArr3)) {
                            this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                            this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                        } else {
                            this.peerCerts = new Certificate[bArr3.length];
                            this.x509PeerCerts = new X509Certificate[bArr3.length];
                            initCerts(bArr3, 0);
                        }
                    } else if (ReferenceCountedOpenSslEngine.isEmpty(bArr2)) {
                        this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                        this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                    } else if (ReferenceCountedOpenSslEngine.isEmpty(bArr3)) {
                        this.peerCerts = new Certificate[]{new LazyX509Certificate(bArr2)};
                        this.x509PeerCerts = new X509Certificate[]{new LazyJavaxX509Certificate(bArr2)};
                    } else {
                        Certificate[] certificateArr = new Certificate[bArr3.length + 1];
                        this.peerCerts = certificateArr;
                        this.x509PeerCerts = new X509Certificate[bArr3.length + 1];
                        certificateArr[0] = new LazyX509Certificate(bArr2);
                        this.x509PeerCerts[0] = new LazyJavaxX509Certificate(bArr2);
                        initCerts(bArr3, 1);
                    }
                    ReferenceCountedOpenSslEngine.this.calculateMaxWrapOverhead();
                    ReferenceCountedOpenSslEngine.this.handshakeState = HandshakeState.FINISHED;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public void invalidate() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                this.valid = false;
                this.sessionContext.removeFromCache(this.f8949id);
            }
        }

        @Override // javax.net.ssl.SSLSession
        public boolean isValid() {
            boolean z;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    z = this.valid || this.sessionContext.isInCache(this.f8949id);
                } finally {
                }
            }
            return z;
        }

        @Override // javax.net.ssl.SSLSession
        public void putValue(String str, Object obj) {
            Object objPut;
            ObjectUtil.checkNotNull(str, "name");
            ObjectUtil.checkNotNull(obj, "value");
            synchronized (this) {
                try {
                    Map map = this.values;
                    if (map == null) {
                        map = new HashMap(2);
                        this.values = map;
                    }
                    objPut = map.put(str, obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueBound(newSSLSessionBindingEvent(str));
            }
            notifyUnbound(objPut, str);
        }

        @Override // javax.net.ssl.SSLSession
        public void removeValue(String str) {
            ObjectUtil.checkNotNull(str, "name");
            synchronized (this) {
                try {
                    Map<String, Object> map = this.values;
                    if (map == null) {
                        return;
                    }
                    notifyUnbound(map.remove(str), str);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public OpenSslSessionId sessionId() {
            OpenSslSessionId openSslSessionId;
            byte[] sessionId;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (this.f8949id == OpenSslSessionId.NULL_ID && !ReferenceCountedOpenSslEngine.this.isDestroyed() && (sessionId = SSL.getSessionId(ReferenceCountedOpenSslEngine.this.ssl)) != null) {
                        this.f8949id = new OpenSslSessionId(sessionId);
                    }
                    openSslSessionId = this.f8949id;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return openSslSessionId;
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public void setLocalCertificate(Certificate[] certificateArr) {
            this.localCertificateChain = certificateArr;
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public void setSessionId(OpenSslSessionId openSslSessionId) {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (this.f8949id == OpenSslSessionId.NULL_ID) {
                        this.f8949id = openSslSessionId;
                        this.creationTime = System.currentTimeMillis();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public String toString() {
            return "DefaultOpenSslSession{sessionContext=" + this.sessionContext + ", id=" + this.f8949id + '}';
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public void tryExpandApplicationBufferSize(int i) {
            if (i > ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH) {
                int i2 = this.applicationBufferSize;
                int i4 = ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE;
                if (i2 != i4) {
                    this.applicationBufferSize = i4;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public OpenSslSessionContext getSessionContext() {
            return this.sessionContext;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum HandshakeState {
        NOT_STARTED,
        STARTED_IMPLICITLY,
        STARTED_EXPLICITLY,
        FINISHED
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface NativeSslException {
        int errorCode();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class OpenSslException extends SSLException implements NativeSslException {
        private final int errorCode;

        public OpenSslException(String str, int i) {
            super(str);
            this.errorCode = i;
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslEngine.NativeSslException
        public int errorCode() {
            return this.errorCode;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class OpenSslHandshakeException extends SSLHandshakeException implements NativeSslException {
        private final int errorCode;

        public OpenSslHandshakeException(String str, int i) {
            super(str);
            this.errorCode = i;
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslEngine.NativeSslException
        public int errorCode() {
            return this.errorCode;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class TaskDecorator<R extends Runnable> implements Runnable {
        protected final R task;

        public TaskDecorator(R r) {
            this.task = r;
        }

        @Override // java.lang.Runnable
        public void run() {
            ReferenceCountedOpenSslEngine.this.runAndResetNeedTask(this.task);
        }
    }

    static {
        SSLEngineResult.Status status = SSLEngineResult.Status.OK;
        SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        NEED_UNWRAP_OK = new SSLEngineResult(status, handshakeStatus, 0, 0);
        SSLEngineResult.Status status2 = SSLEngineResult.Status.CLOSED;
        NEED_UNWRAP_CLOSED = new SSLEngineResult(status2, handshakeStatus, 0, 0);
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.NEED_WRAP;
        NEED_WRAP_OK = new SSLEngineResult(status, handshakeStatus2, 0, 0);
        NEED_WRAP_CLOSED = new SSLEngineResult(status2, handshakeStatus2, 0, 0);
        CLOSED_NOT_HANDSHAKING = new SSLEngineResult(status2, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
    }

    public ReferenceCountedOpenSslEngine(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, ByteBufAllocator byteBufAllocator, String str, int i, boolean z, boolean z2) {
        super(str, i);
        this.handshakeState = HandshakeState.NOT_STARTED;
        this.refCnt = new AbstractReferenceCounted() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.AbstractReferenceCounted
            public void deallocate() {
                ReferenceCountedOpenSslEngine.this.shutdown();
                if (ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.close(ReferenceCountedOpenSslEngine.this);
                }
                ReferenceCountedOpenSslEngine.this.parentContext.release();
            }

            @Override // io.netty.util.ReferenceCounted
            public ReferenceCounted touch(Object obj) {
                if (ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.record(obj);
                }
                return ReferenceCountedOpenSslEngine.this;
            }
        };
        ClientAuth clientAuth = ClientAuth.NONE;
        this.clientAuth = clientAuth;
        this.lastAccessed = -1L;
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        OpenSsl.ensureAvailability();
        this.engineMap = referenceCountedOpenSslContext.engineMap;
        boolean z3 = referenceCountedOpenSslContext.enableOcsp;
        this.enableOcsp = z3;
        this.jdkCompatibilityMode = z;
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        this.apn = (OpenSslApplicationProtocolNegotiator) referenceCountedOpenSslContext.applicationProtocolNegotiator();
        boolean zIsClient = referenceCountedOpenSslContext.isClient();
        this.clientMode = zIsClient;
        if (PlatformDependent.javaVersion() >= 7) {
            this.session = new ExtendedOpenSslSession(new DefaultOpenSslSession(referenceCountedOpenSslContext.sessionContext())) { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.2
                private String[] peerSupportedSignatureAlgorithms;
                private List requestedServerNames;

                @Override // io.netty.handler.ssl.ExtendedOpenSslSession, javax.net.ssl.ExtendedSSLSession
                public String[] getPeerSupportedSignatureAlgorithms() {
                    String[] strArr;
                    String[] sigAlgs;
                    synchronized (ReferenceCountedOpenSslEngine.this) {
                        try {
                            if (this.peerSupportedSignatureAlgorithms == null) {
                                if (ReferenceCountedOpenSslEngine.this.isDestroyed() || (sigAlgs = SSL.getSigAlgs(ReferenceCountedOpenSslEngine.this.ssl)) == null) {
                                    this.peerSupportedSignatureAlgorithms = EmptyArrays.EMPTY_STRINGS;
                                } else {
                                    LinkedHashSet linkedHashSet = new LinkedHashSet(sigAlgs.length);
                                    for (String str2 : sigAlgs) {
                                        String javaName = SignatureAlgorithmConverter.toJavaName(str2);
                                        if (javaName != null) {
                                            linkedHashSet.add(javaName);
                                        }
                                    }
                                    this.peerSupportedSignatureAlgorithms = (String[]) linkedHashSet.toArray(new String[0]);
                                }
                            }
                            strArr = (String[]) this.peerSupportedSignatureAlgorithms.clone();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return strArr;
                }

                @Override // io.netty.handler.ssl.ExtendedOpenSslSession, javax.net.ssl.ExtendedSSLSession
                public List getRequestedServerNames() {
                    List list;
                    if (ReferenceCountedOpenSslEngine.this.clientMode) {
                        return Java8SslUtils.getSniHostNames((List<String>) ReferenceCountedOpenSslEngine.this.sniHostNames);
                    }
                    synchronized (ReferenceCountedOpenSslEngine.this) {
                        try {
                            if (this.requestedServerNames == null) {
                                if (ReferenceCountedOpenSslEngine.this.isDestroyed() || SSL.getSniHostname(ReferenceCountedOpenSslEngine.this.ssl) == null) {
                                    this.requestedServerNames = Collections.EMPTY_LIST;
                                } else {
                                    this.requestedServerNames = Java8SslUtils.getSniHostName(SSL.getSniHostname(ReferenceCountedOpenSslEngine.this.ssl).getBytes(CharsetUtil.UTF_8));
                                }
                            }
                            list = this.requestedServerNames;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return list;
                }

                @Override // io.netty.handler.ssl.ExtendedOpenSslSession
                public List<byte[]> getStatusResponses() {
                    if (ReferenceCountedOpenSslEngine.this.enableOcsp && ReferenceCountedOpenSslEngine.this.clientMode) {
                        synchronized (ReferenceCountedOpenSslEngine.this) {
                            try {
                                ocspResponse = ReferenceCountedOpenSslEngine.this.isDestroyed() ? null : SSL.getOcspResponse(ReferenceCountedOpenSslEngine.this.ssl);
                            } finally {
                            }
                        }
                    }
                    return ocspResponse == null ? Collections.EMPTY_LIST : Collections.singletonList(ocspResponse);
                }
            };
        } else {
            this.session = new DefaultOpenSslSession(referenceCountedOpenSslContext.sessionContext());
        }
        if (!referenceCountedOpenSslContext.sessionContext().useKeyManager()) {
            this.session.setLocalCertificate(referenceCountedOpenSslContext.keyCertChain);
        }
        Lock lock = referenceCountedOpenSslContext.ctxLock.readLock();
        lock.lock();
        try {
            long jNewSSL = SSL.newSSL(referenceCountedOpenSslContext.ctx, !referenceCountedOpenSslContext.isClient());
            synchronized (this) {
                this.ssl = jNewSSL;
                try {
                    this.networkBIO = SSL.bioNewByteBuffer(jNewSSL, referenceCountedOpenSslContext.getBioNonApplicationBufferSize());
                    if (!zIsClient) {
                        clientAuth = referenceCountedOpenSslContext.clientAuth;
                    }
                    setClientAuth(clientAuth);
                    String[] strArr = referenceCountedOpenSslContext.protocols;
                    if (strArr != null) {
                        setEnabledProtocols0(strArr, true);
                    } else {
                        this.explicitlyEnabledProtocols = getEnabledProtocols();
                    }
                    if (zIsClient && SslUtils.isValidHostNameForSNI(str) && (PlatformDependent.javaVersion() < 8 || Java8SslUtils.isValidHostNameForSNI(str))) {
                        SSL.setTlsExtHostName(this.ssl, str);
                        this.sniHostNames = Collections.singletonList(str);
                    }
                    if (z3) {
                        SSL.enableOcsp(this.ssl);
                    }
                    if (!z) {
                        long j = this.ssl;
                        SSL.setMode(j, SSL.getMode(j) | SSL.SSL_MODE_ENABLE_PARTIAL_WRITE);
                    }
                    if (isProtocolEnabled(SSL.getOptions(this.ssl), SSL.SSL_OP_NO_TLSv1_3, SslProtocols.TLS_v1_3)) {
                        if (zIsClient ? ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_TICKET_TLSV13 : ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_TICKET_TLSV13) {
                            SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_TICKET);
                        }
                    }
                    if (OpenSsl.isBoringSSL() && zIsClient) {
                        SSL.setRenegotiateMode(this.ssl, SSL.SSL_RENEGOTIATE_ONCE);
                    }
                    calculateMaxWrapOverhead();
                } catch (Throwable th) {
                    shutdown();
                    PlatformDependent.throwException(th);
                }
            }
            this.parentContext = referenceCountedOpenSslContext;
            referenceCountedOpenSslContext.retain();
            this.leak = z2 ? leakDetector.track(this) : null;
        } finally {
            lock.unlock();
        }
    }

    private static long bufferAddress(ByteBuffer byteBuffer) {
        return PlatformDependent.hasUnsafe() ? PlatformDependent.directBufferAddress(byteBuffer) : Buffer.address(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateMaxWrapOverhead() {
        this.maxWrapOverhead = SSL.getMaxWrapOverhead(this.ssl);
        this.maxWrapBufferSize = this.jdkCompatibilityMode ? maxEncryptedPacketLength0() : maxEncryptedPacketLength0() << 4;
    }

    private void checkEngineClosed() throws SSLException {
        if (isDestroyed()) {
            throw new SSLException("engine closed");
        }
    }

    private void closeAll() {
        this.receivedShutdown = true;
        closeOutbound();
        closeInbound();
    }

    private boolean doSSLShutdown() {
        if (SSL.isInInit(this.ssl) != 0) {
            return false;
        }
        int iShutdownSSL = SSL.shutdownSSL(this.ssl);
        if (iShutdownSSL >= 0) {
            return true;
        }
        int error = SSL.getError(this.ssl, iShutdownSSL);
        if (error != SSL.SSL_ERROR_SYSCALL && error != SSL.SSL_ERROR_SSL) {
            SSL.clearError();
            return true;
        }
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            int lastErrorNumber = SSL.getLastErrorNumber();
            internalLogger.debug("SSL_shutdown failed: OpenSSL error: {} {}", Integer.valueOf(lastErrorNumber), SSL.getErrorString(lastErrorNumber));
        }
        shutdown();
        return false;
    }

    private SSLEngineResult handleUnwrapException(int i, int i2, SSLException sSLException) throws SSLException {
        int lastErrorNumber = SSL.getLastErrorNumber();
        if (lastErrorNumber != 0) {
            return sslReadErrorResult(SSL.SSL_ERROR_SSL, lastErrorNumber, i, i2);
        }
        throw sSLException;
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLException {
        if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        if (this.handshakeState == HandshakeState.FINISHED) {
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
        checkEngineClosed();
        if (this.pendingException != null) {
            if (SSL.doHandshake(this.ssl) <= 0) {
                SSL.clearError();
            }
            return handshakeException();
        }
        this.engineMap.add(this);
        if (!this.sessionSet) {
            this.parentContext.sessionContext().setSessionFromCache(getPeerHost(), getPeerPort(), this.ssl);
            this.sessionSet = true;
        }
        if (this.lastAccessed == -1) {
            this.lastAccessed = System.currentTimeMillis();
        }
        int iDoHandshake = SSL.doHandshake(this.ssl);
        if (iDoHandshake > 0) {
            if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            }
            this.session.handshakeFinished(SSL.getSessionId(this.ssl), SSL.getCipherForSSL(this.ssl), SSL.getVersion(this.ssl), SSL.getPeerCertificate(this.ssl), SSL.getPeerCertChain(this.ssl), SSL.getTime(this.ssl) * 1000, 1000 * this.parentContext.sessionTimeout());
            selectApplicationProtocol();
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
        int error = SSL.getError(this.ssl, iDoHandshake);
        if (error == SSL.SSL_ERROR_WANT_READ || error == SSL.SSL_ERROR_WANT_WRITE) {
            return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
        }
        if (error == SSL.SSL_ERROR_WANT_X509_LOOKUP || error == SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY || error == SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        if (needWrapAgain(SSL.getLastErrorNumber())) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        if (this.pendingException != null) {
            return handshakeException();
        }
        throw shutdownWithError("SSL_do_handshake", error);
    }

    private SSLEngineResult.HandshakeStatus handshakeException() throws SSLHandshakeException {
        if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        Throwable th = this.pendingException;
        this.pendingException = null;
        shutdown();
        if (th instanceof SSLHandshakeException) {
            throw ((SSLHandshakeException) th);
        }
        SSLHandshakeException sSLHandshakeException = new SSLHandshakeException("General OpenSslEngine problem");
        sSLHandshakeException.initCause(th);
        throw sSLHandshakeException;
    }

    private boolean isBytesAvailableEnoughForWrap(int i, int i2, int i4) {
        return ((long) i) - (((long) this.maxWrapOverhead) * ((long) i4)) >= ((long) i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDestroyed() {
        return this.destroyed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    private static boolean isEndPointVerificationEnabled(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    private static boolean isProtocolEnabled(int i, int i2, String str) {
        return (i & i2) == 0 && OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str);
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) {
        if ((handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP && i2 > 0) || (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP && i > 0)) {
            return handshake();
        }
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.FINISHED;
        if (handshakeStatus != handshakeStatus2) {
            handshakeStatus2 = getHandshakeStatus();
        }
        return mayFinishHandshake(handshakeStatus2);
    }

    private boolean needPendingStatus() {
        if (this.handshakeState == HandshakeState.NOT_STARTED || isDestroyed()) {
            return false;
        }
        return this.handshakeState != HandshakeState.FINISHED || isInboundDone() || isOutboundDone();
    }

    private boolean needWrapAgain(int i) {
        if (SSL.bioLengthNonApplication(this.networkBIO) <= 0) {
            return false;
        }
        Throwable th = this.pendingException;
        if (th == null) {
            this.pendingException = newSSLExceptionForError(i);
        } else if (shouldAddSuppressed(th, i)) {
            ThrowableUtil.addSuppressed(this.pendingException, newSSLExceptionForError(i));
        }
        SSL.clearError();
        return true;
    }

    private SSLEngineResult newResult(SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) {
        return newResult(SSLEngineResult.Status.OK, handshakeStatus, i, i2);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) {
        return newResult(mayFinishHandshake(handshakeStatus, i, i2), i, i2);
    }

    private SSLException newSSLExceptionForError(int i) {
        String errorString = SSL.getErrorString(i);
        return this.handshakeState == HandshakeState.FINISHED ? new OpenSslException(errorString, i) : new OpenSslHandshakeException(errorString, i);
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i) {
        return i > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    private int readPlaintextData(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            int fromSSL = SSL.readFromSSL(this.ssl, bufferAddress(byteBuffer) + ((long) iPosition), byteBuffer.limit() - iPosition);
            if (fromSSL > 0) {
                byteBuffer.position(iPosition + fromSSL);
            }
            return fromSSL;
        }
        int iLimit = byteBuffer.limit();
        int iMin = Math.min(maxEncryptedPacketLength0(), iLimit - iPosition);
        ByteBuf byteBufDirectBuffer = this.alloc.directBuffer(iMin);
        try {
            int fromSSL2 = SSL.readFromSSL(this.ssl, OpenSsl.memoryAddress(byteBufDirectBuffer), iMin);
            if (fromSSL2 > 0) {
                byteBuffer.limit(iPosition + fromSSL2);
                byteBufDirectBuffer.getBytes(byteBufDirectBuffer.readerIndex(), byteBuffer);
                byteBuffer.limit(iLimit);
            }
            return fromSSL2;
        } finally {
            byteBufDirectBuffer.release();
        }
    }

    private void rejectRemoteInitiatedRenegotiation() throws SSLHandshakeException {
        if (isDestroyed()) {
            return;
        }
        if (((this.clientMode || SSL.getHandshakeCount(this.ssl) <= 1) && (!this.clientMode || SSL.getHandshakeCount(this.ssl) <= 2)) || SslProtocols.TLS_v1_3.equals(this.session.getProtocol()) || this.handshakeState != HandshakeState.FINISHED) {
            return;
        }
        shutdown();
        throw new SSLHandshakeException("remote-initiated renegotiation not allowed");
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void runAndResetNeedTask(Runnable runnable) {
        try {
            if (isDestroyed()) {
                return;
            }
            runnable.run();
        } finally {
            this.needTask = false;
        }
    }

    private void selectApplicationProtocol() {
        ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior = this.apn.selectedListenerFailureBehavior();
        List<String> listProtocols = this.apn.protocols();
        int i = C127213.f8947xc16482e4[this.apn.protocol().ordinal()];
        if (i != 1) {
            if (i == 2) {
                String alpnSelected = SSL.getAlpnSelected(this.ssl);
                if (alpnSelected != null) {
                    this.applicationProtocol = selectApplicationProtocol(listProtocols, selectedListenerFailureBehavior, alpnSelected);
                    return;
                }
                return;
            }
            if (i == 3) {
                String nextProtoNegotiated = SSL.getNextProtoNegotiated(this.ssl);
                if (nextProtoNegotiated != null) {
                    this.applicationProtocol = selectApplicationProtocol(listProtocols, selectedListenerFailureBehavior, nextProtoNegotiated);
                    return;
                }
                return;
            }
            if (i != 4) {
                throw new Error();
            }
            String alpnSelected2 = SSL.getAlpnSelected(this.ssl);
            if (alpnSelected2 == null) {
                alpnSelected2 = SSL.getNextProtoNegotiated(this.ssl);
            }
            if (alpnSelected2 != null) {
                this.applicationProtocol = selectApplicationProtocol(listProtocols, selectedListenerFailureBehavior, alpnSelected2);
            }
        }
    }

    private void setClientAuth(ClientAuth clientAuth) {
        if (this.clientMode) {
            return;
        }
        synchronized (this) {
            try {
                if (this.clientAuth == clientAuth) {
                    return;
                }
                if (!isDestroyed()) {
                    int i = C127213.$SwitchMap$io$netty$handler$ssl$ClientAuth[clientAuth.ordinal()];
                    if (i == 1) {
                        SSL.setVerify(this.ssl, 0, 10);
                    } else if (i == 2) {
                        SSL.setVerify(this.ssl, 2, 10);
                    } else {
                        if (i != 3) {
                            throw new Error(clientAuth.toString());
                        }
                        SSL.setVerify(this.ssl, 1, 10);
                    }
                }
                this.clientAuth = clientAuth;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035 A[PHI: r0 r5
      0x0035: PHI (r0v16 int) = (r0v8 int), (r0v10 int), (r0v12 int), (r0v14 int), (r0v17 int) binds: [B:45:0x0070, B:38:0x0061, B:31:0x0052, B:24:0x0043, B:17:0x0033] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r5v13 int) = (r5v9 int), (r5v10 int), (r5v11 int), (r5v12 int), (r5v0 int) binds: [B:45:0x0070, B:38:0x0061, B:31:0x0052, B:24:0x0043, B:17:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setEnabledProtocols0(String[] strArr, boolean z) {
        ObjectUtil.checkNotNullWithIAE(strArr, "protocols");
        int length = OPENSSL_OP_NO_PROTOCOLS.length;
        int length2 = strArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i4 = 1;
            if (i >= length2) {
                synchronized (this) {
                    if (z) {
                        try {
                            this.explicitlyEnabledProtocols = strArr;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (isDestroyed()) {
                        throw new IllegalStateException("failed to enable protocols: " + Arrays.asList(strArr));
                    }
                    SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2 | SSL.SSL_OP_NO_TLSv1_3);
                    int i5 = 0;
                    for (int i6 = 0; i6 < length; i6++) {
                        i5 |= OPENSSL_OP_NO_PROTOCOLS[i6];
                    }
                    int i7 = i2 + 1;
                    while (true) {
                        int[] iArr = OPENSSL_OP_NO_PROTOCOLS;
                        if (i7 < iArr.length) {
                            i5 |= iArr[i7];
                            i7++;
                        } else {
                            SSL.setOptions(this.ssl, i5);
                        }
                    }
                }
                return;
            }
            String str = strArr[i];
            if (!OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str)) {
                throw new IllegalArgumentException(AbstractC0541b.m773o("Protocol ", str, " is not supported."));
            }
            if (str.equals("SSLv2")) {
                if (length > 0) {
                    length = 0;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
            } else if (str.equals(SslProtocols.SSL_v3)) {
                if (length > 1) {
                    length = 1;
                }
                if (i2 < 1) {
                    i2 = i4;
                }
            } else if (str.equals(SslProtocols.TLS_v1)) {
                i4 = 2;
                if (length > 2) {
                    length = 2;
                }
                if (i2 < 2) {
                }
            } else if (str.equals(SslProtocols.TLS_v1_1)) {
                i4 = 3;
                if (length > 3) {
                    length = 3;
                }
                if (i2 < 3) {
                }
            } else if (str.equals(SslProtocols.TLS_v1_2)) {
                i4 = 4;
                if (length > 4) {
                    length = 4;
                }
                if (i2 < 4) {
                }
            } else if (str.equals(SslProtocols.TLS_v1_3)) {
                i4 = 5;
                if (length > 5) {
                    length = 5;
                }
                if (i2 < 5) {
                }
            }
            i++;
        }
    }

    private static boolean shouldAddSuppressed(Throwable th, int i) {
        for (Object obj : ThrowableUtil.getSuppressed(th)) {
            if ((obj instanceof NativeSslException) && ((NativeSslException) obj).errorCode() == i) {
                return false;
            }
        }
        return true;
    }

    private SSLException shutdownWithError(String str, int i) {
        return shutdownWithError(str, i, SSL.getLastErrorNumber());
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleDstBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleSrcBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private int sslPending0() {
        if (this.handshakeState != HandshakeState.FINISHED) {
            return 0;
        }
        return SSL.sslPending(this.ssl);
    }

    private SSLEngineResult sslReadErrorResult(int i, int i2, int i4, int i5) throws SSLException {
        if (needWrapAgain(i2)) {
            return new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, i4, i5);
        }
        throw shutdownWithError("SSL_read", i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toJavaCipherSuite(String str) {
        if (str == null) {
            return null;
        }
        return CipherSuiteConverter.toJava(str, toJavaCipherSuitePrefix(SSL.getVersion(this.ssl)));
    }

    private static String toJavaCipherSuitePrefix(String str) {
        char cCharAt = 0;
        if (str != null && !str.isEmpty()) {
            cCharAt = str.charAt(0);
        }
        return cCharAt != 'S' ? cCharAt != 'T' ? "UNKNOWN" : "TLS" : "SSL";
    }

    private ByteBuf writeEncryptedData(ByteBuffer byteBuffer, int i) throws Throwable {
        int iPosition = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            SSL.bioSetByteBuffer(this.networkBIO, bufferAddress(byteBuffer) + ((long) iPosition), i, false);
            return null;
        }
        ByteBuf byteBufDirectBuffer = this.alloc.directBuffer(i);
        try {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(iPosition + i);
            byteBufDirectBuffer.writeBytes(byteBuffer);
            byteBuffer.position(iPosition);
            byteBuffer.limit(iLimit);
            SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(byteBufDirectBuffer), i, false);
            return byteBufDirectBuffer;
        } catch (Throwable th) {
            byteBufDirectBuffer.release();
            PlatformDependent.throwException(th);
            return null;
        }
    }

    private int writePlaintextData(ByteBuffer byteBuffer, int i) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            int iWriteToSSL = SSL.writeToSSL(this.ssl, bufferAddress(byteBuffer) + ((long) iPosition), i);
            if (iWriteToSSL > 0) {
                byteBuffer.position(iPosition + iWriteToSSL);
            }
            return iWriteToSSL;
        }
        ByteBuf byteBufDirectBuffer = this.alloc.directBuffer(i);
        try {
            byteBuffer.limit(iPosition + i);
            byteBufDirectBuffer.setBytes(0, byteBuffer);
            byteBuffer.limit(iLimit);
            int iWriteToSSL2 = SSL.writeToSSL(this.ssl, OpenSsl.memoryAddress(byteBufDirectBuffer), i);
            if (iWriteToSSL2 > 0) {
                byteBuffer.position(iPosition + iWriteToSSL2);
            } else {
                byteBuffer.position(iPosition);
            }
            byteBufDirectBuffer.release();
            return iWriteToSSL2;
        } catch (Throwable th) {
            byteBufDirectBuffer.release();
            throw th;
        }
    }

    public final synchronized String[] authMethods() {
        if (isDestroyed()) {
            return EmptyArrays.EMPTY_STRINGS;
        }
        return SSL.authenticationMethods(this.ssl);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void beginHandshake() {
        try {
            int i = C127213.f8948xea902ccf[this.handshakeState.ordinal()];
            if (i == 1) {
                this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                if (handshake() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                    this.needTask = true;
                }
                calculateMaxWrapOverhead();
            } else {
                if (i == 2) {
                    throw new SSLException("renegotiation unsupported");
                }
                if (i == 3) {
                    checkEngineClosed();
                    this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                    calculateMaxWrapOverhead();
                } else if (i != 4) {
                    throw new Error();
                }
            }
        } finally {
        }
    }

    public synchronized void bioSetFd(int i) {
        if (!isDestroyed()) {
            SSL.bioSetFd(this.ssl, i);
        }
    }

    public final int calculateMaxLengthForWrap(int i, int i2) {
        return (int) Math.min(this.maxWrapBufferSize, (((long) this.maxWrapOverhead) * ((long) i2)) + ((long) i));
    }

    public final boolean checkSniHostnameMatch(byte[] bArr) {
        return Java8SslUtils.checkSniHostnameMatch(this.matchers, bArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeInbound() {
        try {
            if (this.isInboundDone) {
                return;
            }
            this.isInboundDone = true;
            if (isOutboundDone()) {
                shutdown();
            }
            if (this.handshakeState != HandshakeState.NOT_STARTED && !this.receivedShutdown) {
                throw new SSLException("Inbound closed before receiving peer's close_notify: possible truncation attack?");
            }
        } finally {
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeOutbound() {
        try {
            if (this.outboundClosed) {
                return;
            }
            this.outboundClosed = true;
            if (this.handshakeState == HandshakeState.NOT_STARTED || isDestroyed()) {
                shutdown();
            } else if ((SSL.getShutdown(this.ssl) & SSL.SSL_SENT_SHUTDOWN) != SSL.SSL_SENT_SHUTDOWN) {
                doSSLShutdown();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return this.applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized Runnable getDelegatedTask() {
        if (isDestroyed()) {
            return null;
        }
        AsyncTask task = SSL.getTask(this.ssl);
        if (task == null) {
            return null;
        }
        if (task instanceof AsyncTask) {
            return new AsyncTaskDecorator(task);
        }
        return new TaskDecorator(task);
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getEnableSessionCreation() {
        return false;
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledCipherSuites() {
        String[] strArr;
        boolean z;
        synchronized (this) {
            try {
                if (isDestroyed()) {
                    return EmptyArrays.EMPTY_STRINGS;
                }
                String[] ciphers = SSL.getCiphers(this.ssl);
                if (isProtocolEnabled(SSL.getOptions(this.ssl), SSL.SSL_OP_NO_TLSv1_3, SslProtocols.TLS_v1_3)) {
                    strArr = OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS;
                    z = true;
                } else {
                    strArr = EmptyArrays.EMPTY_STRINGS;
                    z = false;
                }
                if (ciphers == null) {
                    return EmptyArrays.EMPTY_STRINGS;
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(ciphers.length + strArr.length);
                synchronized (this) {
                    for (int i = 0; i < ciphers.length; i++) {
                        try {
                            String javaCipherSuite = toJavaCipherSuite(ciphers[i]);
                            if (javaCipherSuite == null) {
                                javaCipherSuite = ciphers[i];
                            }
                            if ((z && OpenSsl.isTlsv13Supported()) || !SslUtils.isTLSv13Cipher(javaCipherSuite)) {
                                linkedHashSet.add(javaCipherSuite);
                            }
                        } finally {
                        }
                    }
                    Collections.addAll(linkedHashSet, strArr);
                }
                return (String[]) linkedHashSet.toArray(new String[0]);
            } finally {
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledProtocols() {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(SslProtocols.SSL_v2_HELLO);
        synchronized (this) {
            if (isDestroyed()) {
                return (String[]) arrayList.toArray(new String[0]);
            }
            int options = SSL.getOptions(this.ssl);
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1, SslProtocols.TLS_v1)) {
                arrayList.add(SslProtocols.TLS_v1);
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_1, SslProtocols.TLS_v1_1)) {
                arrayList.add(SslProtocols.TLS_v1_1);
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_2, SslProtocols.TLS_v1_2)) {
                arrayList.add(SslProtocols.TLS_v1_2);
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_3, SslProtocols.TLS_v1_3)) {
                arrayList.add(SslProtocols.TLS_v1_3);
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_SSLv2, "SSLv2")) {
                arrayList.add("SSLv2");
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_SSLv3, SslProtocols.SSL_v3)) {
                arrayList.add(SslProtocols.SSL_v3);
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        return this.applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLSession getHandshakeSession() {
        int i = C127213.f8948xea902ccf[this.handshakeState.ordinal()];
        if (i == 1 || i == 2) {
            return null;
        }
        return this.session;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        if (!needPendingStatus()) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getNeedClientAuth() {
        return this.clientAuth == ClientAuth.REQUIRE;
    }

    @Override // io.netty.handler.ssl.ApplicationProtocolAccessor
    public String getNegotiatedApplicationProtocol() {
        return this.applicationProtocol;
    }

    public byte[] getOcspResponse() {
        if (!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        }
        if (!this.clientMode) {
            throw new IllegalStateException("Not a client SSLEngine");
        }
        synchronized (this) {
            try {
                if (isDestroyed()) {
                    return EmptyArrays.EMPTY_BYTES;
                }
                return SSL.getOcspResponse(this.ssl);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public final synchronized SSLParameters getSSLParameters() {
        SSLParameters sSLParameters;
        try {
            sSLParameters = super.getSSLParameters();
            int iJavaVersion = PlatformDependent.javaVersion();
            if (iJavaVersion >= 7) {
                sSLParameters.setEndpointIdentificationAlgorithm(this.endPointIdentificationAlgorithm);
                Java7SslParametersUtils.setAlgorithmConstraints(sSLParameters, this.algorithmConstraints);
                if (iJavaVersion >= 8) {
                    List<String> list = this.sniHostNames;
                    if (list != null) {
                        Java8SslUtils.setSniHostNames(sSLParameters, list);
                    }
                    if (!isDestroyed()) {
                        Java8SslUtils.setUseCipherSuitesOrder(sSLParameters, (SSL.getOptions(this.ssl) & SSL.SSL_OP_CIPHER_SERVER_PREFERENCE) != 0);
                    }
                    Java8SslUtils.setSNIMatchers(sSLParameters, this.matchers);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return sSLParameters;
    }

    @Override // javax.net.ssl.SSLEngine
    public final SSLSession getSession() {
        return this.session;
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedCipherSuites() {
        return (String[]) OpenSsl.AVAILABLE_CIPHER_SUITES.toArray(new String[0]);
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedProtocols() {
        return (String[]) OpenSsl.SUPPORTED_PROTOCOLS_SET.toArray(new String[0]);
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getUseClientMode() {
        return this.clientMode;
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getWantClientAuth() {
        return this.clientAuth == ClientAuth.OPTIONAL;
    }

    public final void initHandshakeException(Throwable th) {
        Throwable th2 = this.pendingException;
        if (th2 == null) {
            this.pendingException = th;
        } else {
            ThrowableUtil.addSuppressed(th2, th);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized boolean isInboundDone() {
        return this.isInboundDone;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0018  */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean isOutboundDone() {
        boolean z;
        if (this.outboundClosed) {
            long j = this.networkBIO;
            if (j != 0) {
                if (SSL.bioLengthNonApplication(j) != 0) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public synchronized boolean isSessionReused() {
        if (isDestroyed()) {
            return false;
        }
        return SSL.isSessionReused(this.ssl);
    }

    public final synchronized SecretKeySpec masterKey() {
        if (isDestroyed()) {
            return null;
        }
        return new SecretKeySpec(SSL.getMasterKey(this.ssl), AES256KeyLoader.AES_ALGORITHM);
    }

    public final synchronized int maxEncryptedPacketLength() {
        return maxEncryptedPacketLength0();
    }

    public final int maxEncryptedPacketLength0() {
        return this.maxWrapOverhead + MAX_PLAINTEXT_LENGTH;
    }

    public final synchronized int maxWrapOverhead() {
        return this.maxWrapOverhead;
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

    @Override // javax.net.ssl.SSLEngine
    public final void setEnableSessionCreation(boolean z) {
        if (z) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledCipherSuites(String[] strArr) {
        ObjectUtil.checkNotNull(strArr, "cipherSuites");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        CipherSuiteConverter.convertToCipherStrings(Arrays.asList(strArr), sb, sb2, OpenSsl.isBoringSSL());
        String string = sb.toString();
        String string2 = sb2.toString();
        if (!OpenSsl.isTlsv13Supported() && !string2.isEmpty()) {
            throw new IllegalArgumentException("TLSv1.3 is not supported by this java version.");
        }
        synchronized (this) {
            try {
                if (isDestroyed()) {
                    throw new IllegalStateException("failed to enable cipher suites: " + string);
                }
                try {
                    SSL.setCipherSuites(this.ssl, string, false);
                    if (OpenSsl.isTlsv13Supported()) {
                        SSL.setCipherSuites(this.ssl, OpenSsl.checkTls13Ciphers(logger, string2), true);
                    }
                    HashSet hashSet = new HashSet(this.explicitlyEnabledProtocols.length);
                    Collections.addAll(hashSet, this.explicitlyEnabledProtocols);
                    if (string.isEmpty()) {
                        hashSet.remove(SslProtocols.TLS_v1);
                        hashSet.remove(SslProtocols.TLS_v1_1);
                        hashSet.remove(SslProtocols.TLS_v1_2);
                        hashSet.remove(SslProtocols.SSL_v3);
                        hashSet.remove("SSLv2");
                        hashSet.remove(SslProtocols.SSL_v2_HELLO);
                    }
                    if (string2.isEmpty()) {
                        hashSet.remove(SslProtocols.TLS_v1_3);
                    }
                    setEnabledProtocols0((String[]) hashSet.toArray(EmptyArrays.EMPTY_STRINGS), false);
                } catch (Exception e) {
                    throw new IllegalStateException("failed to enable cipher suites: " + string, e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledProtocols(String[] strArr) {
        setEnabledProtocols0(strArr, true);
    }

    public final boolean setKeyMaterial(OpenSslKeyMaterial openSslKeyMaterial) {
        synchronized (this) {
            try {
                if (isDestroyed()) {
                    return false;
                }
                SSL.setKeyMaterial(this.ssl, openSslKeyMaterial.certificateChainAddress(), openSslKeyMaterial.privateKeyAddress());
                this.session.setLocalCertificate(openSslKeyMaterial.certificateChain());
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setNeedClientAuth(boolean z) {
        setClientAuth(z ? ClientAuth.REQUIRE : ClientAuth.NONE);
    }

    public void setOcspResponse(byte[] bArr) {
        if (!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        }
        if (this.clientMode) {
            throw new IllegalStateException("Not a server SSLEngine");
        }
        synchronized (this) {
            try {
                if (!isDestroyed()) {
                    SSL.setOcspResponse(this.ssl, bArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public final synchronized void setSSLParameters(SSLParameters sSLParameters) {
        try {
            int iJavaVersion = PlatformDependent.javaVersion();
            if (iJavaVersion >= 7) {
                if (sSLParameters.getAlgorithmConstraints() != null) {
                    throw new IllegalArgumentException("AlgorithmConstraints are not supported.");
                }
                boolean zIsDestroyed = isDestroyed();
                if (iJavaVersion >= 8) {
                    if (!zIsDestroyed) {
                        if (this.clientMode) {
                            List<String> sniHostNames = Java8SslUtils.getSniHostNames(sSLParameters);
                            Iterator<String> it = sniHostNames.iterator();
                            while (it.hasNext()) {
                                SSL.setTlsExtHostName(this.ssl, it.next());
                            }
                            this.sniHostNames = sniHostNames;
                        }
                        if (Java8SslUtils.getUseCipherSuitesOrder(sSLParameters)) {
                            SSL.setOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                        } else {
                            SSL.clearOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                        }
                    }
                    this.matchers = sSLParameters.getSNIMatchers();
                }
                String endpointIdentificationAlgorithm = sSLParameters.getEndpointIdentificationAlgorithm();
                if (!zIsDestroyed && this.clientMode && isEndPointVerificationEnabled(endpointIdentificationAlgorithm)) {
                    SSL.setVerify(this.ssl, 2, -1);
                }
                this.endPointIdentificationAlgorithm = endpointIdentificationAlgorithm;
                this.algorithmConstraints = sSLParameters.getAlgorithmConstraints();
            }
            super.setSSLParameters(sSLParameters);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setSessionId(OpenSslSessionId openSslSessionId) {
        this.session.setSessionId(openSslSessionId);
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setUseClientMode(boolean z) {
        if (z != this.clientMode) {
            throw new UnsupportedOperationException();
        }
    }

    public final synchronized void setVerify(int i, int i2) {
        if (!isDestroyed()) {
            SSL.setVerify(this.ssl, i, i2);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setWantClientAuth(boolean z) {
        setClientAuth(z ? ClientAuth.OPTIONAL : ClientAuth.NONE);
    }

    public final synchronized void shutdown() {
        try {
            if (!this.destroyed) {
                this.destroyed = true;
                OpenSslEngineMap openSslEngineMap = this.engineMap;
                if (openSslEngineMap != null) {
                    openSslEngineMap.remove(this.ssl);
                }
                SSL.freeSSL(this.ssl);
                this.networkBIO = 0L;
                this.ssl = 0L;
                this.outboundClosed = true;
                this.isInboundDone = true;
            }
            SSL.clearError();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized int sslPending() {
        return sslPending0();
    }

    public final synchronized long sslPointer() {
        return this.ssl;
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x01ed, code lost:
    
        if (r23 == null) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01ef, code lost:
    
        r23.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x026c, code lost:
    
        io.netty.internal.tcnative.SSL.bioClearByteBuffer(r18.networkBIO);
        rejectRemoteInitiatedRenegotiation();
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0276, code lost:
    
        if (r18.receivedShutdown != false) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0283, code lost:
    
        if ((io.netty.internal.tcnative.SSL.getShutdown(r18.ssl) & io.netty.internal.tcnative.SSL.SSL_RECEIVED_SHUTDOWN) != io.netty.internal.tcnative.SSL.SSL_RECEIVED_SHUTDOWN) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0285, code lost:
    
        closeAll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x028c, code lost:
    
        if (isInboundDone() == false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x028e, code lost:
    
        r0 = javax.net.ssl.SSLEngineResult.Status.CLOSED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0291, code lost:
    
        r0 = javax.net.ssl.SSLEngineResult.Status.OK;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0293, code lost:
    
        r0 = newResultMayFinishHandshake(r0, r6, r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0298, code lost:
    
        return r0;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer[] byteBufferArr2, int i4, int i5) {
        int i6;
        int i7;
        int encryptedPacketLength;
        int i8;
        int iMin;
        ByteBuf byteBufWriteEncryptedData;
        ByteBuf byteBuf;
        SSLEngineResult sSLEngineResultNewResult;
        int i9 = i;
        int i10 = i4;
        ObjectUtil.checkNotNullWithIAE(byteBufferArr, "srcs");
        if (i9 >= byteBufferArr.length || (i6 = i9 + i2) > byteBufferArr.length) {
            throw new IndexOutOfBoundsException(AbstractC2821a.m2223n(AbstractC0622a.m1173s(i9, i2, "offset: ", ", length: ", " (expected: offset <= offset + length <= srcs.length ("), "))", byteBufferArr.length));
        }
        ObjectUtil.checkNotNullWithIAE(byteBufferArr2, "dsts");
        if (i10 >= byteBufferArr2.length || (i7 = i10 + i5) > byteBufferArr2.length) {
            throw new IndexOutOfBoundsException(AbstractC2821a.m2223n(AbstractC0622a.m1173s(i10, i5, "offset: ", ", length: ", " (expected: offset <= offset + length <= dsts.length ("), "))", byteBufferArr2.length));
        }
        long jRemaining = 0;
        for (int i11 = i10; i11 < i7; i11++) {
            ByteBuffer byteBuffer = (ByteBuffer) ObjectUtil.checkNotNullArrayParam(byteBufferArr2[i11], i11, "dsts");
            if (byteBuffer.isReadOnly()) {
                throw new ReadOnlyBufferException();
            }
            jRemaining += (long) byteBuffer.remaining();
        }
        long jRemaining2 = 0;
        for (int i12 = i9; i12 < i6; i12++) {
            jRemaining2 += (long) ((ByteBuffer) ObjectUtil.checkNotNullArrayParam(byteBufferArr[i12], i12, "srcs")).remaining();
        }
        synchronized (this) {
            try {
                if (isInboundDone()) {
                    return (isOutboundDone() || isDestroyed()) ? CLOSED_NOT_HANDSHAKING : NEED_WRAP_CLOSED;
                }
                SSLEngineResult.HandshakeStatus handshakeStatusHandshake = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                HandshakeState handshakeState = this.handshakeState;
                HandshakeState handshakeState2 = HandshakeState.FINISHED;
                if (handshakeState != handshakeState2) {
                    if (handshakeState != HandshakeState.STARTED_EXPLICITLY) {
                        this.handshakeState = HandshakeState.STARTED_IMPLICITLY;
                    }
                    handshakeStatusHandshake = handshake();
                    if (handshakeStatusHandshake == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                        return newResult(handshakeStatusHandshake, 0, 0);
                    }
                    if (handshakeStatusHandshake == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
                        return NEED_WRAP_OK;
                    }
                    if (this.isInboundDone) {
                        return NEED_WRAP_CLOSED;
                    }
                }
                int iSslPending0 = sslPending0();
                if (this.jdkCompatibilityMode || handshakeState != handshakeState2) {
                    if (jRemaining2 < 5) {
                        return newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_UNDERFLOW, handshakeStatusHandshake, 0, 0);
                    }
                    encryptedPacketLength = SslUtils.getEncryptedPacketLength(byteBufferArr, i);
                    if (encryptedPacketLength == -2) {
                        throw new NotSslRecordException("not an SSL/TLS record");
                    }
                    int i13 = encryptedPacketLength - 5;
                    i8 = iSslPending0;
                    if (i13 > jRemaining) {
                        if (i13 <= MAX_RECORD_SIZE) {
                            this.session.tryExpandApplicationBufferSize(i13);
                            return newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_OVERFLOW, handshakeStatusHandshake, 0, 0);
                        }
                        throw new SSLException("Illegal packet length: " + i13 + " > " + this.session.getApplicationBufferSize());
                    }
                    if (jRemaining2 < encryptedPacketLength) {
                        return newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_UNDERFLOW, handshakeStatusHandshake, 0, 0);
                    }
                } else {
                    if (jRemaining2 == 0 && iSslPending0 <= 0) {
                        return newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_UNDERFLOW, handshakeStatusHandshake, 0, 0);
                    }
                    if (jRemaining == 0) {
                        return newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_OVERFLOW, handshakeStatusHandshake, 0, 0);
                    }
                    encryptedPacketLength = (int) Math.min(2147483647L, jRemaining2);
                    i8 = iSslPending0;
                }
                int i14 = 0;
                int iSslPending02 = i8;
                int i15 = 0;
                loop2: while (true) {
                    ByteBuffer byteBuffer2 = byteBufferArr[i9];
                    int iRemaining = byteBuffer2.remaining();
                    if (iRemaining != 0) {
                        iMin = Math.min(encryptedPacketLength, iRemaining);
                        try {
                            byteBufWriteEncryptedData = writeEncryptedData(byteBuffer2, iMin);
                        } catch (SSLException e) {
                            SSLEngineResult sSLEngineResultHandleUnwrapException = handleUnwrapException(i14, i15, e);
                            SSL.bioClearByteBuffer(this.networkBIO);
                            rejectRemoteInitiatedRenegotiation();
                            return sSLEngineResultHandleUnwrapException;
                        }
                    } else if (iSslPending02 <= 0) {
                        i9++;
                        if (i9 >= i6) {
                            break;
                        }
                    } else {
                        iMin = SSL.bioLengthByteBuffer(this.networkBIO);
                        byteBufWriteEncryptedData = null;
                    }
                    while (true) {
                        try {
                            ByteBuffer byteBuffer3 = byteBufferArr2[i10];
                            if (byteBuffer3.hasRemaining()) {
                                int i16 = i9;
                                try {
                                    int plaintextData = readPlaintextData(byteBuffer3);
                                    int i17 = iMin;
                                    byteBuf = byteBufWriteEncryptedData;
                                    try {
                                        int iBioLengthByteBuffer = i17 - SSL.bioLengthByteBuffer(this.networkBIO);
                                        i14 += iBioLengthByteBuffer;
                                        encryptedPacketLength -= iBioLengthByteBuffer;
                                        int i18 = i17 - iBioLengthByteBuffer;
                                        byteBuffer2.position(byteBuffer2.position() + iBioLengthByteBuffer);
                                        if (plaintextData > 0) {
                                            i15 += plaintextData;
                                            if (byteBuffer3.hasRemaining()) {
                                                if (encryptedPacketLength == 0 || this.jdkCompatibilityMode) {
                                                    break loop2;
                                                }
                                            } else {
                                                iSslPending02 = sslPending0();
                                                i10++;
                                                if (i10 >= i7) {
                                                    sSLEngineResultNewResult = iSslPending02 > 0 ? newResult(SSLEngineResult.Status.BUFFER_OVERFLOW, handshakeStatusHandshake, i14, i15) : newResultMayFinishHandshake(isInboundDone() ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK, handshakeStatusHandshake, i14, i15);
                                                    if (byteBuf != null) {
                                                        byteBuf.release();
                                                    }
                                                    SSL.bioClearByteBuffer(this.networkBIO);
                                                }
                                            }
                                            i9 = i16;
                                            iMin = i18;
                                            byteBufWriteEncryptedData = byteBuf;
                                        } else {
                                            int error = SSL.getError(this.ssl, plaintextData);
                                            if (error != SSL.SSL_ERROR_WANT_READ && error != SSL.SSL_ERROR_WANT_WRITE) {
                                                if (error == SSL.SSL_ERROR_ZERO_RETURN) {
                                                    if (!this.receivedShutdown) {
                                                        closeAll();
                                                    }
                                                    sSLEngineResultNewResult = newResultMayFinishHandshake(isInboundDone() ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK, handshakeStatusHandshake, i14, i15);
                                                    if (byteBuf != null) {
                                                        byteBuf.release();
                                                    }
                                                    SSL.bioClearByteBuffer(this.networkBIO);
                                                } else if (error == SSL.SSL_ERROR_WANT_X509_LOOKUP || error == SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY || error == SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
                                                    sSLEngineResultNewResult = newResult(isInboundDone() ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_TASK, i14, i15);
                                                    if (byteBuf != null) {
                                                        byteBuf.release();
                                                    }
                                                    SSL.bioClearByteBuffer(this.networkBIO);
                                                } else {
                                                    sSLEngineResultNewResult = sslReadErrorResult(error, SSL.getLastErrorNumber(), i14, i15);
                                                    if (byteBuf != null) {
                                                        byteBuf.release();
                                                    }
                                                    SSL.bioClearByteBuffer(this.networkBIO);
                                                }
                                            }
                                            i9 = i16 + 1;
                                            if (i9 >= i6) {
                                                if (byteBuf != null) {
                                                }
                                            } else if (byteBuf != null) {
                                                byteBuf.release();
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        if (byteBuf != null) {
                                            byteBuf.release();
                                        }
                                        throw th;
                                    }
                                } catch (SSLException e2) {
                                    ByteBuf byteBuf2 = byteBufWriteEncryptedData;
                                    SSLEngineResult sSLEngineResultHandleUnwrapException2 = handleUnwrapException(i14, i15, e2);
                                    if (byteBuf2 != null) {
                                        byteBuf2.release();
                                    }
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    rejectRemoteInitiatedRenegotiation();
                                    return sSLEngineResultHandleUnwrapException2;
                                }
                            } else {
                                i10++;
                                if (i10 >= i7) {
                                    if (byteBufWriteEncryptedData != null) {
                                        byteBufWriteEncryptedData.release();
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            byteBuf = byteBufWriteEncryptedData;
                        }
                    }
                }
                rejectRemoteInitiatedRenegotiation();
                return sSLEngineResultNewResult;
            } catch (Throwable th3) {
                SSL.bioClearByteBuffer(this.networkBIO);
                rejectRemoteInitiatedRenegotiation();
                throw th3;
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:204:0x0360, code lost:
    
        r12 = newResultMayFinishHandshake(r8, r1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0364, code lost:
    
        io.netty.internal.tcnative.SSL.bioClearByteBuffer(r11.networkBIO);
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0369, code lost:
    
        if (r2 != null) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x036b, code lost:
    
        r13 = r15.position();
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0371, code lost:
    
        r15.put(r2.internalNioBuffer(r2.readerIndex(), r3));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04bf A[Catch: all -> 0x0030, TryCatch #1 {all -> 0x0030, blocks: (B:9:0x001a, B:11:0x0020, B:13:0x0026, B:16:0x002d, B:20:0x0036, B:19:0x0034, B:35:0x0093, B:37:0x009a, B:39:0x00af, B:38:0x00a2, B:73:0x0136, B:47:0x00c4, B:49:0x00cb, B:61:0x00fb, B:63:0x010c, B:50:0x00d0, B:51:0x00db, B:58:0x00f0, B:60:0x00f7, B:62:0x0100, B:68:0x011b, B:70:0x0122, B:71:0x0126, B:72:0x012b, B:280:0x04b8, B:282:0x04bf, B:284:0x04d6, B:283:0x04ce, B:87:0x0163, B:89:0x016a, B:90:0x016e, B:91:0x0174, B:96:0x018e, B:98:0x0195, B:99:0x019a, B:104:0x01ba, B:106:0x01c1, B:107:0x01c6, B:116:0x01f0, B:118:0x01f7, B:119:0x01fd, B:127:0x0219, B:129:0x0220, B:130:0x0226, B:136:0x0241, B:138:0x0248, B:139:0x024e, B:170:0x02d5, B:172:0x02dc, B:173:0x02e2, B:205:0x0364, B:207:0x036b, B:208:0x0371, B:223:0x03b7, B:225:0x03be, B:226:0x03c4, B:229:0x03d7, B:231:0x03de, B:232:0x03e4, B:237:0x03fb, B:239:0x0402, B:240:0x0408, B:246:0x0421, B:248:0x0428, B:249:0x042e, B:252:0x0441, B:254:0x0448, B:255:0x044e, B:267:0x0475, B:269:0x047c, B:270:0x0482, B:187:0x0323, B:189:0x032a, B:190:0x0330, B:273:0x0493, B:275:0x049a, B:276:0x04a0, B:162:0x02af, B:164:0x02b6, B:165:0x02bc), top: B:292:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04ce A[Catch: all -> 0x0030, TryCatch #1 {all -> 0x0030, blocks: (B:9:0x001a, B:11:0x0020, B:13:0x0026, B:16:0x002d, B:20:0x0036, B:19:0x0034, B:35:0x0093, B:37:0x009a, B:39:0x00af, B:38:0x00a2, B:73:0x0136, B:47:0x00c4, B:49:0x00cb, B:61:0x00fb, B:63:0x010c, B:50:0x00d0, B:51:0x00db, B:58:0x00f0, B:60:0x00f7, B:62:0x0100, B:68:0x011b, B:70:0x0122, B:71:0x0126, B:72:0x012b, B:280:0x04b8, B:282:0x04bf, B:284:0x04d6, B:283:0x04ce, B:87:0x0163, B:89:0x016a, B:90:0x016e, B:91:0x0174, B:96:0x018e, B:98:0x0195, B:99:0x019a, B:104:0x01ba, B:106:0x01c1, B:107:0x01c6, B:116:0x01f0, B:118:0x01f7, B:119:0x01fd, B:127:0x0219, B:129:0x0220, B:130:0x0226, B:136:0x0241, B:138:0x0248, B:139:0x024e, B:170:0x02d5, B:172:0x02dc, B:173:0x02e2, B:205:0x0364, B:207:0x036b, B:208:0x0371, B:223:0x03b7, B:225:0x03be, B:226:0x03c4, B:229:0x03d7, B:231:0x03de, B:232:0x03e4, B:237:0x03fb, B:239:0x0402, B:240:0x0408, B:246:0x0421, B:248:0x0428, B:249:0x042e, B:252:0x0441, B:254:0x0448, B:255:0x044e, B:267:0x0475, B:269:0x047c, B:270:0x0482, B:187:0x0323, B:189:0x032a, B:190:0x0330, B:273:0x0493, B:275:0x049a, B:276:0x04a0, B:162:0x02af, B:164:0x02b6, B:165:0x02bc), top: B:292:0x001a }] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer byteBuffer) {
        int i4;
        Throwable th;
        ByteBuf byteBufDirectBuffer;
        int iBioLengthByteBuffer;
        SSLEngineResult.HandshakeStatus handshakeStatusHandshake;
        int iBioFlushByteBuffer;
        SSLEngineResult sSLEngineResult;
        int iPosition;
        int iWritePlaintextData;
        int iBioLengthByteBuffer2;
        int iPosition2;
        int iBioLengthByteBuffer3;
        SSLEngineResult sSLEngineResultNewResult;
        int iPosition3;
        ObjectUtil.checkNotNullWithIAE(byteBufferArr, "srcs");
        ObjectUtil.checkNotNullWithIAE(byteBuffer, "dst");
        if (i >= byteBufferArr.length || (i4 = i + i2) > byteBufferArr.length) {
            throw new IndexOutOfBoundsException(AbstractC2821a.m2223n(AbstractC0622a.m1173s(i, i2, "offset: ", ", length: ", " (expected: offset <= offset + length <= srcs.length ("), "))", byteBufferArr.length));
        }
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        synchronized (this) {
            try {
                if (isOutboundDone()) {
                    return (isInboundDone() || isDestroyed()) ? CLOSED_NOT_HANDSHAKING : NEED_UNWRAP_CLOSED;
                }
                ?? r14 = 0;
                ?? r12 = 0;
                int i5 = 0;
                ByteBuffer[] byteBufferArr2 = null;
                try {
                    if (byteBuffer.isDirect()) {
                        SSL.bioSetByteBuffer(this.networkBIO, bufferAddress(byteBuffer) + ((long) byteBuffer.position()), byteBuffer.remaining(), true);
                        byteBufDirectBuffer = null;
                    } else {
                        byteBufDirectBuffer = this.alloc.directBuffer(byteBuffer.remaining());
                        try {
                            SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(byteBufDirectBuffer), byteBufDirectBuffer.writableBytes(), true);
                        } catch (Throwable th2) {
                            th = th2;
                            r14 = byteBufDirectBuffer;
                            r12 = byteBufferArr2;
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (r14 == 0) {
                            }
                        }
                    }
                    iBioLengthByteBuffer = SSL.bioLengthByteBuffer(this.networkBIO);
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    try {
                        if (this.outboundClosed) {
                            if (isBytesAvailableEnoughForWrap(byteBuffer.remaining(), 2, 1)) {
                                iBioLengthByteBuffer3 = SSL.bioFlushByteBuffer(this.networkBIO);
                                if (iBioLengthByteBuffer3 <= 0) {
                                    sSLEngineResultNewResult = newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    if (byteBufDirectBuffer == null) {
                                        iPosition3 = byteBuffer.position();
                                        byteBuffer.position(iPosition3 + iBioLengthByteBuffer3);
                                    } else {
                                        byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer3));
                                        byteBufDirectBuffer.release();
                                    }
                                } else if (doSSLShutdown()) {
                                    iBioLengthByteBuffer2 = iBioLengthByteBuffer - SSL.bioLengthByteBuffer(this.networkBIO);
                                    sSLEngineResult = newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, iBioLengthByteBuffer2);
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    if (byteBufDirectBuffer == null) {
                                        iPosition2 = byteBuffer.position();
                                        byteBuffer.position(iPosition2 + iBioLengthByteBuffer2);
                                        return sSLEngineResult;
                                    }
                                    byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer2));
                                } else {
                                    sSLEngineResultNewResult = newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, iBioLengthByteBuffer3);
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    if (byteBufDirectBuffer == null) {
                                        iPosition3 = byteBuffer.position();
                                        byteBuffer.position(iPosition3 + iBioLengthByteBuffer3);
                                    } else {
                                        byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer3));
                                        byteBufDirectBuffer.release();
                                    }
                                }
                                return sSLEngineResultNewResult;
                            }
                            sSLEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), 0, 0);
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (byteBufDirectBuffer == null) {
                                byteBuffer.position(byteBuffer.position());
                                return sSLEngineResult;
                            }
                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), 0));
                            byteBufDirectBuffer.release();
                            return sSLEngineResult;
                        }
                        SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                        HandshakeState handshakeState = this.handshakeState;
                        HandshakeState handshakeState2 = HandshakeState.FINISHED;
                        if (handshakeState != handshakeState2) {
                            if (handshakeState != HandshakeState.STARTED_EXPLICITLY) {
                                this.handshakeState = HandshakeState.STARTED_IMPLICITLY;
                            }
                            iBioFlushByteBuffer = SSL.bioFlushByteBuffer(this.networkBIO);
                            try {
                                if (this.pendingException == null) {
                                    handshakeStatusHandshake = handshake();
                                    iBioFlushByteBuffer = iBioLengthByteBuffer - SSL.bioLengthByteBuffer(this.networkBIO);
                                    if (handshakeStatusHandshake == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                                        sSLEngineResult = newResult(handshakeStatusHandshake, 0, iBioFlushByteBuffer);
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            iPosition = byteBuffer.position();
                                            byteBuffer.position(iPosition + iBioFlushByteBuffer);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer));
                                            byteBufDirectBuffer.release();
                                        }
                                    } else if (iBioFlushByteBuffer > 0) {
                                        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.FINISHED;
                                        if (handshakeStatusHandshake != handshakeStatus2) {
                                            handshakeStatus2 = iBioFlushByteBuffer == iBioLengthByteBuffer ? SSLEngineResult.HandshakeStatus.NEED_WRAP : getHandshakeStatus(SSL.bioLengthNonApplication(this.networkBIO));
                                        }
                                        sSLEngineResult = newResult(mayFinishHandshake(handshakeStatus2), 0, iBioFlushByteBuffer);
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            iPosition = byteBuffer.position();
                                            byteBuffer.position(iPosition + iBioFlushByteBuffer);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer));
                                            byteBufDirectBuffer.release();
                                        }
                                    } else {
                                        if (handshakeStatusHandshake != SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                                            if (this.outboundClosed) {
                                                iBioLengthByteBuffer3 = SSL.bioFlushByteBuffer(this.networkBIO);
                                                sSLEngineResultNewResult = newResultMayFinishHandshake(handshakeStatusHandshake, 0, iBioLengthByteBuffer3);
                                                SSL.bioClearByteBuffer(this.networkBIO);
                                                if (byteBufDirectBuffer == null) {
                                                    iPosition3 = byteBuffer.position();
                                                    byteBuffer.position(iPosition3 + iBioLengthByteBuffer3);
                                                } else {
                                                    byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer3));
                                                    byteBufDirectBuffer.release();
                                                }
                                            }
                                            return sSLEngineResultNewResult;
                                        }
                                        sSLEngineResult = isOutboundDone() ? NEED_UNWRAP_CLOSED : NEED_UNWRAP_OK;
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            iPosition = byteBuffer.position();
                                            byteBuffer.position(iPosition + iBioFlushByteBuffer);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer));
                                            byteBufDirectBuffer.release();
                                        }
                                    }
                                } else if (iBioFlushByteBuffer > 0) {
                                    sSLEngineResult = newResult(SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, iBioFlushByteBuffer);
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    if (byteBufDirectBuffer == null) {
                                        iPosition = byteBuffer.position();
                                        byteBuffer.position(iPosition + iBioFlushByteBuffer);
                                    } else {
                                        byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer));
                                        byteBufDirectBuffer.release();
                                    }
                                } else {
                                    sSLEngineResult = newResult(handshakeException(), 0, 0);
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    if (byteBufDirectBuffer == null) {
                                        iPosition = byteBuffer.position();
                                        byteBuffer.position(iPosition + iBioFlushByteBuffer);
                                    } else {
                                        byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer));
                                        byteBufDirectBuffer.release();
                                    }
                                }
                                return sSLEngineResult;
                            } catch (Throwable th4) {
                                th = th4;
                                r14 = byteBufDirectBuffer;
                                r12 = iBioFlushByteBuffer;
                                SSL.bioClearByteBuffer(this.networkBIO);
                                if (r14 == 0) {
                                    byteBuffer.position(byteBuffer.position() + r12);
                                    throw th;
                                }
                                byteBuffer.put(r14.internalNioBuffer(r14.readerIndex(), r12));
                                r14.release();
                                throw th;
                            }
                        }
                        handshakeStatusHandshake = handshakeStatus;
                        iBioFlushByteBuffer = 0;
                        if (this.jdkCompatibilityMode || handshakeState != handshakeState2) {
                            int iRemaining = 0;
                            for (int i6 = i; i6 < i4; i6++) {
                                ByteBuffer byteBuffer2 = byteBufferArr[i6];
                                if (byteBuffer2 == null) {
                                    throw new IllegalArgumentException("srcs[" + i6 + "] is null");
                                }
                                int i7 = MAX_PLAINTEXT_LENGTH;
                                if (iRemaining != i7 && ((iRemaining = iRemaining + byteBuffer2.remaining()) > i7 || iRemaining < 0)) {
                                    iRemaining = i7;
                                }
                            }
                            if (!isBytesAvailableEnoughForWrap(byteBuffer.remaining(), iRemaining, 1)) {
                                sSLEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), 0, 0);
                                SSL.bioClearByteBuffer(this.networkBIO);
                                if (byteBufDirectBuffer == null) {
                                    iPosition = byteBuffer.position();
                                    byteBuffer.position(iPosition + iBioFlushByteBuffer);
                                } else {
                                    byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer));
                                    byteBufDirectBuffer.release();
                                }
                            }
                            return sSLEngineResult;
                        }
                        iBioFlushByteBuffer = SSL.bioFlushByteBuffer(this.networkBIO);
                        if (iBioFlushByteBuffer > 0) {
                            sSLEngineResult = newResultMayFinishHandshake(handshakeStatusHandshake, 0, iBioFlushByteBuffer);
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (byteBufDirectBuffer == null) {
                                iPosition = byteBuffer.position();
                                byteBuffer.position(iPosition + iBioFlushByteBuffer);
                            } else {
                                byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer));
                                byteBufDirectBuffer.release();
                            }
                        } else {
                            Throwable th5 = this.pendingException;
                            if (th5 != null) {
                                this.pendingException = null;
                                shutdown();
                                throw new SSLException(th5);
                            }
                            while (true) {
                                if (i >= i4) {
                                    sSLEngineResult = newResultMayFinishHandshake(handshakeStatusHandshake, i5, iBioFlushByteBuffer);
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    if (byteBufDirectBuffer == null) {
                                        iPosition = byteBuffer.position();
                                    } else {
                                        byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer));
                                    }
                                } else {
                                    ByteBuffer byteBuffer3 = byteBufferArr[i];
                                    int iRemaining2 = byteBuffer3.remaining();
                                    if (iRemaining2 != 0) {
                                        if (this.jdkCompatibilityMode) {
                                            iWritePlaintextData = writePlaintextData(byteBuffer3, Math.min(iRemaining2, MAX_PLAINTEXT_LENGTH - i5));
                                        } else {
                                            int iRemaining3 = (byteBuffer.remaining() - iBioFlushByteBuffer) - this.maxWrapOverhead;
                                            if (iRemaining3 <= 0) {
                                                sSLEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), i5, iBioFlushByteBuffer);
                                                SSL.bioClearByteBuffer(this.networkBIO);
                                                if (byteBufDirectBuffer == null) {
                                                    iPosition = byteBuffer.position();
                                                } else {
                                                    byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer));
                                                }
                                            } else {
                                                iWritePlaintextData = writePlaintextData(byteBuffer3, Math.min(iRemaining2, iRemaining3));
                                            }
                                        }
                                        int iBioLengthByteBuffer4 = SSL.bioLengthByteBuffer(this.networkBIO);
                                        iBioLengthByteBuffer2 = (iBioLengthByteBuffer - iBioLengthByteBuffer4) + iBioFlushByteBuffer;
                                        if (iWritePlaintextData > 0) {
                                            i5 += iWritePlaintextData;
                                            if (this.jdkCompatibilityMode || iBioLengthByteBuffer2 == byteBuffer.remaining()) {
                                                break;
                                            }
                                            iBioFlushByteBuffer = iBioLengthByteBuffer2;
                                            iBioLengthByteBuffer = iBioLengthByteBuffer4;
                                        } else {
                                            int error = SSL.getError(this.ssl, iWritePlaintextData);
                                            if (error == SSL.SSL_ERROR_ZERO_RETURN) {
                                                if (this.receivedShutdown) {
                                                    sSLEngineResult = newResult(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, i5, iBioLengthByteBuffer2);
                                                    SSL.bioClearByteBuffer(this.networkBIO);
                                                    if (byteBufDirectBuffer == null) {
                                                        iPosition2 = byteBuffer.position();
                                                    } else {
                                                        byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer2));
                                                    }
                                                } else {
                                                    closeAll();
                                                    iBioLengthByteBuffer3 = (iBioLengthByteBuffer4 - SSL.bioLengthByteBuffer(this.networkBIO)) + iBioLengthByteBuffer2;
                                                    SSLEngineResult.HandshakeStatus handshakeStatus3 = SSLEngineResult.HandshakeStatus.FINISHED;
                                                    if (handshakeStatusHandshake != handshakeStatus3) {
                                                        handshakeStatus3 = iBioLengthByteBuffer3 == byteBuffer.remaining() ? SSLEngineResult.HandshakeStatus.NEED_WRAP : getHandshakeStatus(SSL.bioLengthNonApplication(this.networkBIO));
                                                    }
                                                    sSLEngineResultNewResult = newResult(mayFinishHandshake(handshakeStatus3), i5, iBioLengthByteBuffer3);
                                                    SSL.bioClearByteBuffer(this.networkBIO);
                                                    if (byteBufDirectBuffer == null) {
                                                        iPosition3 = byteBuffer.position();
                                                    } else {
                                                        byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer3));
                                                    }
                                                }
                                            } else if (error == SSL.SSL_ERROR_WANT_READ) {
                                                sSLEngineResult = newResult(SSLEngineResult.HandshakeStatus.NEED_UNWRAP, i5, iBioLengthByteBuffer2);
                                                SSL.bioClearByteBuffer(this.networkBIO);
                                                if (byteBufDirectBuffer == null) {
                                                    iPosition2 = byteBuffer.position();
                                                } else {
                                                    byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer2));
                                                }
                                            } else if (error != SSL.SSL_ERROR_WANT_WRITE) {
                                                if (error != SSL.SSL_ERROR_WANT_X509_LOOKUP && error != SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY && error != SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
                                                    throw shutdownWithError("SSL_write", error);
                                                }
                                                sSLEngineResult = newResult(SSLEngineResult.HandshakeStatus.NEED_TASK, i5, iBioLengthByteBuffer2);
                                                SSL.bioClearByteBuffer(this.networkBIO);
                                                if (byteBufDirectBuffer == null) {
                                                    iPosition2 = byteBuffer.position();
                                                } else {
                                                    byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer2));
                                                }
                                            } else if (iBioLengthByteBuffer2 > 0) {
                                                sSLEngineResult = newResult(SSLEngineResult.HandshakeStatus.NEED_WRAP, i5, iBioLengthByteBuffer2);
                                                SSL.bioClearByteBuffer(this.networkBIO);
                                                if (byteBufDirectBuffer == null) {
                                                    iPosition2 = byteBuffer.position();
                                                } else {
                                                    byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer2));
                                                }
                                            } else {
                                                sSLEngineResult = newResult(SSLEngineResult.Status.BUFFER_OVERFLOW, handshakeStatusHandshake, i5, iBioLengthByteBuffer2);
                                                SSL.bioClearByteBuffer(this.networkBIO);
                                                if (byteBufDirectBuffer == null) {
                                                    iPosition2 = byteBuffer.position();
                                                } else {
                                                    byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer2));
                                                }
                                            }
                                        }
                                    }
                                    i++;
                                }
                            }
                            byteBuffer.position(iPosition + iBioFlushByteBuffer);
                        }
                        return sSLEngineResult;
                    } catch (Throwable th6) {
                        th = th6;
                        r14 = byteBufDirectBuffer;
                        r12 = iBioLengthByteBuffer;
                    }
                } catch (Throwable th7) {
                    byteBufferArr2 = byteBufferArr;
                    th = th7;
                    r14 = byteBufDirectBuffer;
                    r12 = byteBufferArr2;
                    SSL.bioClearByteBuffer(this.networkBIO);
                    if (r14 == 0) {
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    private SSLEngineResult newResult(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) {
        if (!isOutboundDone()) {
            if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                this.needTask = true;
            }
            return new SSLEngineResult(status, handshakeStatus, i, i2);
        }
        if (isInboundDone()) {
            handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            shutdown();
        }
        return new SSLEngineResult(SSLEngineResult.Status.CLOSED, handshakeStatus, i, i2);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) {
        return newResult(status, mayFinishHandshake(handshakeStatus, i, i2), i, i2);
    }

    private SSLException shutdownWithError(String str, int i, int i2) {
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} failed with {}: OpenSSL error: {} {}", str, Integer.valueOf(i), Integer.valueOf(i2), SSL.getErrorString(i2));
        }
        shutdown();
        SSLException sSLExceptionNewSSLExceptionForError = newSSLExceptionForError(i2);
        Throwable th = this.pendingException;
        if (th != null) {
            sSLExceptionNewSSLExceptionForError.initCause(th);
            this.pendingException = null;
        }
        return sSLExceptionNewSSLExceptionForError;
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

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) {
        if (handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            return handshakeStatus;
        }
        if (this.handshakeState != HandshakeState.FINISHED) {
            return handshake();
        }
        return (isDestroyed() || SSL.bioLengthNonApplication(this.networkBIO) <= 0) ? handshakeStatus : SSLEngineResult.HandshakeStatus.NEED_WRAP;
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i) {
        if (needPendingStatus()) {
            if (this.needTask) {
                return SSLEngineResult.HandshakeStatus.NEED_TASK;
            }
            return pendingStatus(i);
        }
        return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    private String selectApplicationProtocol(List<String> list, ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior, String str) throws SSLException {
        if (selectedListenerFailureBehavior != ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT) {
            int size = list.size();
            if (!list.contains(str)) {
                if (selectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL) {
                    return list.get(size - 1);
                }
                throw new SSLException(AbstractC0541b.m772n("unknown protocol ", str));
            }
        }
        return str;
    }

    public final SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) {
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) {
        SSLEngineResult sSLEngineResultUnwrap;
        try {
            try {
                sSLEngineResultUnwrap = unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i, i2);
                resetSingleSrcBuffer();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                resetSingleSrcBuffer();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return sSLEngineResultUnwrap;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        try {
        } finally {
            resetSingleSrcBuffer();
            resetSingleDstBuffer();
        }
        return unwrap(singleSrcBuffer(byteBuffer), singleDstBuffer(byteBuffer2));
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        try {
        } finally {
            resetSingleSrcBuffer();
        }
        return unwrap(singleSrcBuffer(byteBuffer), byteBufferArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        try {
        } finally {
            resetSingleSrcBuffer();
        }
        return wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
    }
}
