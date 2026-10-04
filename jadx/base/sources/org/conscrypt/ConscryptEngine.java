package org.conscrypt;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECKey;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.ExternalSession;
import org.conscrypt.NativeCrypto;
import org.conscrypt.NativeRef;
import org.conscrypt.NativeSsl;
import org.conscrypt.SSLParametersImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class ConscryptEngine extends AbstractConscryptEngine implements NativeCrypto.SSLHandshakeCallbacks, SSLParametersImpl.AliasChooser, SSLParametersImpl.PSKCallbacks {
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING;
    private static final SSLEngineResult NEED_UNWRAP_CLOSED;
    private static final SSLEngineResult NEED_UNWRAP_OK;
    private static final SSLEngineResult NEED_WRAP_CLOSED;
    private static final SSLEngineResult NEED_WRAP_OK;
    private static BufferAllocator defaultBufferAllocator;
    private ActiveSession activeSession;
    private BufferAllocator bufferAllocator;
    private OpenSSLKey channelIdPrivateKey;
    private SessionSnapshot closedSession;
    private final SSLSession externalSession;
    private boolean handshakeFinished;
    private HandshakeListener handshakeListener;
    private ByteBuffer lazyDirectBuffer;
    private int maxSealOverhead;
    private final NativeSsl.BioWrapper networkBio;
    private String peerHostname;
    private final PeerInfoProvider peerInfoProvider;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private final NativeSsl ssl;
    private final SSLParametersImpl sslParameters;
    private int state;

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
        defaultBufferAllocator = null;
    }

    public ConscryptEngine(SSLParametersImpl sSLParametersImpl) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = PeerInfoProvider.nullProvider();
        NativeSsl nativeSslNewSsl = newSsl(sSLParametersImpl, this, this);
        this.ssl = nativeSslNewSsl;
        this.networkBio = nativeSslNewSsl.newBio();
    }

    private void beginHandshakeInternal() throws SSLHandshakeException {
        NativeSslSession cachedSession;
        int i = this.state;
        if (i == 0) {
            throw new IllegalStateException("Client/server mode must be set before handshake");
        }
        if (i != 1) {
            if (i == 6 || i == 7 || i == 8) {
                throw new SSLHandshakeException("Engine has already been closed");
            }
            return;
        }
        transitionTo(2);
        try {
            try {
                this.ssl.initialize(getHostname(), this.channelIdPrivateKey);
                if (getUseClientMode() && (cachedSession = clientSessionContext().getCachedSession(getHostname(), getPeerPort(), this.sslParameters)) != null) {
                    cachedSession.offerToResume(this.ssl);
                }
                this.maxSealOverhead = this.ssl.getMaxSealOverhead();
                handshake();
            } catch (IOException e) {
                if (e.getMessage().contains("unexpected CCS")) {
                    Platform.logEvent("ssl_unexpected_ccs: host=" + getPeerHost());
                }
                closeAll();
                throw SSLUtils.toSSLHandshakeException(e);
            }
        } catch (Throwable th) {
            closeAndFreeResources();
            throw th;
        }
    }

    private static int calcDstsLength(ByteBuffer[] byteBufferArr, int i, int i2) {
        int iRemaining = 0;
        for (int i4 = 0; i4 < byteBufferArr.length; i4++) {
            ByteBuffer byteBuffer = byteBufferArr[i4];
            Preconditions.checkArgument(byteBuffer != null, "dsts[%d] is null", Integer.valueOf(i4));
            if (byteBuffer.isReadOnly()) {
                throw new ReadOnlyBufferException();
            }
            if (i4 >= i && i4 < i + i2) {
                iRemaining += byteBuffer.remaining();
            }
        }
        return iRemaining;
    }

    private static long calcSrcsLength(ByteBuffer[] byteBufferArr, int i, int i2) {
        long jRemaining = 0;
        while (i < i2) {
            ByteBuffer byteBuffer = byteBufferArr[i];
            if (byteBuffer == null) {
                throw new IllegalArgumentException(AbstractC0541b.m767i(i, "srcs[", "] is null"));
            }
            jRemaining += (long) byteBuffer.remaining();
            i++;
        }
        return jRemaining;
    }

    private ClientSessionContext clientSessionContext() {
        return this.sslParameters.getClientSessionContext();
    }

    private void closeAll() {
        closeOutbound();
        closeInbound();
    }

    private void closeAndFreeResources() {
        transitionTo(8);
        NativeSsl nativeSsl = this.ssl;
        if (nativeSsl != null) {
            nativeSsl.close();
        }
        NativeSsl.BioWrapper bioWrapper = this.networkBio;
        if (bioWrapper != null) {
            bioWrapper.close();
        }
    }

    private SSLException convertException(Throwable th) {
        return ((th instanceof SSLHandshakeException) || !this.handshakeFinished) ? SSLUtils.toSSLHandshakeException(th) : SSLUtils.toSSLException(th);
    }

    private long directByteBufferAddress(ByteBuffer byteBuffer, int i) {
        return NativeCrypto.getDirectBufferAddress(byteBuffer) + ((long) i);
    }

    private void finishHandshake() {
        this.handshakeFinished = true;
        HandshakeListener handshakeListener = this.handshakeListener;
        if (handshakeListener != null) {
            handshakeListener.onHandshakeFinished();
        }
    }

    private void freeIfDone() {
        if (isInboundDone() && isOutboundDone()) {
            closeAndFreeResources();
        }
    }

    public static BufferAllocator getDefaultBufferAllocator() {
        return defaultBufferAllocator;
    }

    private SSLEngineResult.Status getEngineStatus() {
        int i = this.state;
        return (i == 6 || i == 7 || i == 8) ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK;
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatusInternal() {
        if (this.handshakeFinished) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        switch (this.state) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            case 2:
                return pendingStatus(pendingOutboundEncryptedBytes());
            case 3:
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            default:
                throw new IllegalStateException("Unexpected engine state: " + this.state);
        }
    }

    private ByteBuffer getOrCreateLazyDirectBuffer() {
        if (this.lazyDirectBuffer == null) {
            this.lazyDirectBuffer = ByteBuffer.allocateDirect(Math.max(16384, 16709));
        }
        this.lazyDirectBuffer.clear();
        return this.lazyDirectBuffer;
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLHandshakeException {
        try {
            try {
                int iDoHandshake = this.ssl.doHandshake();
                if (iDoHandshake == 2) {
                    return pendingStatus(pendingOutboundEncryptedBytes());
                }
                if (iDoHandshake == 3) {
                    return SSLEngineResult.HandshakeStatus.NEED_WRAP;
                }
                this.activeSession.onPeerCertificateAvailable(getPeerHost(), getPeerPort());
                finishHandshake();
                return SSLEngineResult.HandshakeStatus.FINISHED;
            } catch (IOException e) {
                closeAll();
                throw e;
            }
        } catch (Exception e2) {
            throw SSLUtils.toSSLHandshakeException(e2);
        }
    }

    private boolean isHandshakeStarted() {
        int i = this.state;
        return (i == 0 || i == 1) ? false : true;
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) {
        return (this.handshakeFinished || handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) ? handshakeStatus : handshake();
    }

    private SSLEngineResult newResult(int i, int i2, SSLEngineResult.HandshakeStatus handshakeStatus) {
        SSLEngineResult.Status engineStatus = getEngineStatus();
        if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
            handshakeStatus = getHandshakeStatusInternal();
        }
        return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i, i2);
    }

    private static NativeSsl newSsl(SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine, SSLParametersImpl.AliasChooser aliasChooser) {
        try {
            return NativeSsl.newInstance(sSLParametersImpl, conscryptEngine, aliasChooser, conscryptEngine);
        } catch (SSLException e) {
            throw new RuntimeException(e);
        }
    }

    private SSLException newSslExceptionWithMessage(String str) {
        return !this.handshakeFinished ? new SSLException(str) : new SSLHandshakeException(str);
    }

    private int pendingInboundCleartextBytes() {
        return this.ssl.getPendingReadableBytes();
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i) {
        return i > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    private ConscryptSession provideAfterHandshakeSession() {
        return this.state < 2 ? SSLNullSession.getNullSession() : provideSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConscryptSession provideHandshakeSession() {
        ConscryptSession nullSession;
        synchronized (this.ssl) {
            try {
                nullSession = this.state == 2 ? this.activeSession : SSLNullSession.getNullSession();
            } catch (Throwable th) {
                throw th;
            }
        }
        return nullSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConscryptSession provideSession() {
        synchronized (this.ssl) {
            try {
                int i = this.state;
                if (i == 8) {
                    ConscryptSession nullSession = this.closedSession;
                    if (nullSession == null) {
                        nullSession = SSLNullSession.getNullSession();
                    }
                    return nullSession;
                }
                if (i < 3) {
                    return SSLNullSession.getNullSession();
                }
                return this.activeSession;
            } finally {
            }
        }
    }

    private int readEncryptedData(ByteBuffer byteBuffer, int i) throws SSLException {
        try {
            int iPosition = byteBuffer.position();
            if (byteBuffer.remaining() < i) {
                return 0;
            }
            int iMin = Math.min(i, byteBuffer.limit() - iPosition);
            if (!byteBuffer.isDirect()) {
                return readEncryptedDataHeap(byteBuffer, iMin);
            }
            int encryptedDataDirect = readEncryptedDataDirect(byteBuffer, iPosition, iMin);
            if (encryptedDataDirect <= 0) {
                return encryptedDataDirect;
            }
            byteBuffer.position(iPosition + encryptedDataDirect);
            return encryptedDataDirect;
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private int readEncryptedDataDirect(ByteBuffer byteBuffer, int i, int i2) {
        return this.networkBio.readDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int readEncryptedDataHeap(ByteBuffer byteBuffer, int i) {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBufferAllocateDirectBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBufferAllocateDirectBuffer = bufferAllocator.allocateDirectBuffer(i);
                orCreateLazyDirectBuffer = allocatedBufferAllocateDirectBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int encryptedDataDirect = readEncryptedDataDirect(orCreateLazyDirectBuffer, 0, Math.min(i, orCreateLazyDirectBuffer.remaining()));
            if (encryptedDataDirect > 0) {
                orCreateLazyDirectBuffer.position(encryptedDataDirect);
                orCreateLazyDirectBuffer.flip();
                byteBuffer.put(orCreateLazyDirectBuffer);
            }
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            return encryptedDataDirect;
        } catch (Throwable th) {
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            throw th;
        }
    }

    private SSLEngineResult readPendingBytesFromBIO(ByteBuffer byteBuffer, int i, int i2, SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        try {
            int iPendingOutboundEncryptedBytes = pendingOutboundEncryptedBytes();
            if (iPendingOutboundEncryptedBytes <= 0) {
                return null;
            }
            if (byteBuffer.remaining() < iPendingOutboundEncryptedBytes) {
                SSLEngineResult.Status status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                    handshakeStatus = getHandshakeStatus(iPendingOutboundEncryptedBytes);
                }
                return new SSLEngineResult(status, mayFinishHandshake(handshakeStatus), i, i2);
            }
            int encryptedData = readEncryptedData(byteBuffer, iPendingOutboundEncryptedBytes);
            if (encryptedData <= 0) {
                NativeCrypto.SSL_clear_error();
            } else {
                i2 += encryptedData;
                iPendingOutboundEncryptedBytes -= encryptedData;
            }
            SSLEngineResult.Status engineStatus = getEngineStatus();
            if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                handshakeStatus = getHandshakeStatus(iPendingOutboundEncryptedBytes);
            }
            return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i, i2);
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private int readPlaintextData(ByteBuffer byteBuffer) throws SSLException {
        try {
            int iPosition = byteBuffer.position();
            int iMin = Math.min(16709, byteBuffer.limit() - iPosition);
            if (!byteBuffer.isDirect()) {
                return readPlaintextDataHeap(byteBuffer, iMin);
            }
            int plaintextDataDirect = readPlaintextDataDirect(byteBuffer, iPosition, iMin);
            if (plaintextDataDirect <= 0) {
                return plaintextDataDirect;
            }
            byteBuffer.position(iPosition + plaintextDataDirect);
            return plaintextDataDirect;
        } catch (CertificateException e) {
            throw convertException(e);
        }
    }

    private int readPlaintextDataDirect(ByteBuffer byteBuffer, int i, int i2) {
        return this.ssl.readDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int readPlaintextDataHeap(ByteBuffer byteBuffer, int i) {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBufferAllocateDirectBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBufferAllocateDirectBuffer = bufferAllocator.allocateDirectBuffer(i);
                orCreateLazyDirectBuffer = allocatedBufferAllocateDirectBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int plaintextDataDirect = readPlaintextDataDirect(orCreateLazyDirectBuffer, 0, Math.min(i, orCreateLazyDirectBuffer.remaining()));
            if (plaintextDataDirect > 0) {
                orCreateLazyDirectBuffer.position(plaintextDataDirect);
                orCreateLazyDirectBuffer.flip();
                byteBuffer.put(orCreateLazyDirectBuffer);
            }
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            return plaintextDataDirect;
        } catch (Throwable th) {
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            throw th;
        }
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    private void sendSSLShutdown() {
        try {
            this.ssl.shutdown();
        } catch (IOException unused) {
        }
    }

    private AbstractSessionContext sessionContext() {
        return this.sslParameters.getSessionContext();
    }

    public static void setDefaultBufferAllocator(BufferAllocator bufferAllocator) {
        defaultBufferAllocator = bufferAllocator;
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

    private void transitionTo(int i) {
        int i2;
        if (i == 2) {
            this.handshakeFinished = false;
            this.activeSession = new ActiveSession(this.ssl, this.sslParameters.getSessionContext());
        } else if (i == 8 && !this.ssl.isClosed() && (i2 = this.state) >= 2 && i2 < 8) {
            this.closedSession = new SessionSnapshot(this.activeSession);
        }
        this.state = i;
    }

    private int writeEncryptedData(ByteBuffer byteBuffer, int i) throws SSLException {
        try {
            int iPosition = byteBuffer.position();
            int iWriteEncryptedDataDirect = byteBuffer.isDirect() ? writeEncryptedDataDirect(byteBuffer, iPosition, i) : writeEncryptedDataHeap(byteBuffer, iPosition, i);
            if (iWriteEncryptedDataDirect > 0) {
                byteBuffer.position(iPosition + iWriteEncryptedDataDirect);
            }
            return iWriteEncryptedDataDirect;
        } catch (IOException e) {
            closeAll();
            throw new SSLException(e);
        }
    }

    private int writeEncryptedDataDirect(ByteBuffer byteBuffer, int i, int i2) {
        return this.networkBio.writeDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int writeEncryptedDataHeap(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBufferAllocateDirectBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBufferAllocateDirectBuffer = bufferAllocator.allocateDirectBuffer(i2);
                orCreateLazyDirectBuffer = allocatedBufferAllocateDirectBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int iLimit = byteBuffer.limit();
            int iMin = Math.min(Math.min(iLimit - i, i2), orCreateLazyDirectBuffer.remaining());
            byteBuffer.limit(i + iMin);
            orCreateLazyDirectBuffer.put(byteBuffer);
            byteBuffer.limit(iLimit);
            byteBuffer.position(i);
            int iWriteEncryptedDataDirect = writeEncryptedDataDirect(orCreateLazyDirectBuffer, 0, iMin);
            byteBuffer.position(i);
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            return iWriteEncryptedDataDirect;
        } catch (Throwable th) {
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            throw th;
        }
    }

    private int writePlaintextData(ByteBuffer byteBuffer, int i) throws SSLException {
        try {
            int iPosition = byteBuffer.position();
            int iWritePlaintextDataDirect = byteBuffer.isDirect() ? writePlaintextDataDirect(byteBuffer, iPosition, i) : writePlaintextDataHeap(byteBuffer, iPosition, i);
            if (iWritePlaintextDataDirect > 0) {
                byteBuffer.position(iPosition + iWritePlaintextDataDirect);
            }
            return iWritePlaintextDataDirect;
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private int writePlaintextDataDirect(ByteBuffer byteBuffer, int i, int i2) {
        return this.ssl.writeDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int writePlaintextDataHeap(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBufferAllocateDirectBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBufferAllocateDirectBuffer = bufferAllocator.allocateDirectBuffer(i2);
                orCreateLazyDirectBuffer = allocatedBufferAllocateDirectBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int iLimit = byteBuffer.limit();
            int iMin = Math.min(i2, orCreateLazyDirectBuffer.remaining());
            byteBuffer.limit(i + iMin);
            orCreateLazyDirectBuffer.put(byteBuffer);
            orCreateLazyDirectBuffer.flip();
            byteBuffer.limit(iLimit);
            byteBuffer.position(i);
            int iWritePlaintextDataDirect = writePlaintextDataDirect(orCreateLazyDirectBuffer, 0, iMin);
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            return iWritePlaintextDataDirect;
        } catch (Throwable th) {
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            throw th;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void beginHandshake() {
        synchronized (this.ssl) {
            beginHandshakeInternal();
        }
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr) {
        return x509KeyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) x509KeyManager).chooseEngineClientAlias(strArr, x500PrincipalArr, this) : x509KeyManager.chooseClientAlias(strArr, x500PrincipalArr, null);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str) {
        return pSKKeyManager.chooseClientKeyIdentity(str, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseServerAlias(X509KeyManager x509KeyManager, String str) {
        return x509KeyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) x509KeyManager).chooseEngineServerAlias(str, null, this) : x509KeyManager.chooseServerAlias(str, null, null);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager) {
        return pSKKeyManager.chooseServerKeyIdentityHint(this);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void clientCertificateRequested(byte[] bArr, int[] iArr, byte[][] bArr2) throws SSLException {
        this.ssl.chooseClientCertificate(bArr, iArr, bArr2);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        return this.ssl.clientPSKKeyRequested(str, bArr, bArr2);
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeInbound() {
        synchronized (this.ssl) {
            try {
                int i = this.state;
                if (i != 8 && i != 6) {
                    if (isHandshakeStarted()) {
                        if (this.state == 7) {
                            transitionTo(8);
                        } else {
                            transitionTo(6);
                        }
                        freeIfDone();
                    } else {
                        closeAndFreeResources();
                    }
                }
            } finally {
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeOutbound() {
        synchronized (this.ssl) {
            try {
                int i = this.state;
                if (i != 8 && i != 7) {
                    if (isHandshakeStarted()) {
                        if (this.state == 6) {
                            transitionTo(8);
                        } else {
                            transitionTo(7);
                        }
                        sendSSLShutdown();
                        freeIfDone();
                    } else {
                        closeAndFreeResources();
                    }
                }
            } finally {
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i) {
        synchronized (this.ssl) {
            int i2 = this.state;
            if (i2 >= 3 && i2 != 8) {
                return this.ssl.exportKeyingMaterial(str, bArr, i);
            }
            return null;
        }
    }

    public void finalize() throws Throwable {
        try {
            closeAndFreeResources();
        } finally {
            super.finalize();
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return provideAfterHandshakeSession().getApplicationProtocol();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public String[] getApplicationProtocols() {
        return this.sslParameters.getApplicationProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getChannelId() {
        byte[] tlsChannelId;
        synchronized (this.ssl) {
            try {
                if (getUseClientMode()) {
                    throw new IllegalStateException("Not allowed in client mode");
                }
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Channel ID is only available after handshake completes");
                }
                tlsChannelId = this.ssl.getTlsChannelId();
            } catch (Throwable th) {
                throw th;
            }
        }
        return tlsChannelId;
    }

    @Override // javax.net.ssl.SSLEngine
    public Runnable getDelegatedTask() {
        return null;
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        String applicationProtocol;
        synchronized (this.ssl) {
            try {
                applicationProtocol = this.state >= 2 ? getApplicationProtocol() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        SSLEngineResult.HandshakeStatus handshakeStatusInternal;
        synchronized (this.ssl) {
            handshakeStatusInternal = getHandshakeStatusInternal();
        }
        return handshakeStatusInternal;
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public String getHostname() {
        String str = this.peerHostname;
        return str != null ? str : this.peerInfoProvider.getHostname();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2) {
        return pSKKeyManager.getKey(str, str2, this);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getPeerHost() {
        String str = this.peerHostname;
        return str != null ? str : this.peerInfoProvider.getHostnameOrIP();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public int getPeerPort() {
        return this.peerInfoProvider.getPort();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLParameters getSSLParameters() {
        SSLParameters sSLParameters = super.getSSLParameters();
        Platform.getSSLParameters(sSLParameters, this.sslParameters, this);
        return sSLParameters;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLSession getSession() {
        return this.externalSession;
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getTlsUnique() {
        return this.ssl.getTlsUnique();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLSession handshakeSession() {
        synchronized (this.ssl) {
            try {
                if (this.state != 2) {
                    return null;
                }
                return Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.2
                    @Override // org.conscrypt.ExternalSession.Provider
                    public ConscryptSession provideSession() {
                        return ConscryptEngine.this.provideHandshakeSession();
                    }
                }));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001f  */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isInboundDone() {
        boolean z;
        synchronized (this.ssl) {
            try {
                int i = this.state;
                if (i == 8 || i == 6 || this.ssl.wasShutdownReceived()) {
                    z = pendingInboundCleartextBytes() == 0;
                }
            } finally {
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001f  */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isOutboundDone() {
        boolean z;
        synchronized (this.ssl) {
            try {
                int i = this.state;
                if (i == 8 || i == 7 || this.ssl.wasShutdownSent()) {
                    z = pendingOutboundEncryptedBytes() == 0;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public int maxSealOverhead() {
        return this.maxSealOverhead;
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onNewSessionEstablished(long j) {
        try {
            NativeCrypto.SSL_SESSION_up_ref(j);
            sessionContext().cacheSession(NativeSslSession.newInstance(new NativeRef.SSL_SESSION(j), this.activeSession));
        } catch (Exception unused) {
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onSSLStateChange(int i, int i2) {
        synchronized (this.ssl) {
            try {
                if (i == 16) {
                    transitionTo(2);
                } else if (i == 32) {
                    int i4 = this.state;
                    if (i4 != 2 && i4 != 4) {
                        throw new IllegalStateException("Completed handshake while in mode " + this.state);
                    }
                    transitionTo(3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int pendingOutboundEncryptedBytes() {
        return this.networkBio.getPendingWrittenBytes();
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int selectApplicationProtocol(byte[] bArr) {
        ApplicationProtocolSelectorAdapter applicationProtocolSelector = this.sslParameters.getApplicationProtocolSelector();
        if (applicationProtocolSelector == null) {
            return 3;
        }
        return applicationProtocolSelector.selectApplicationProtocol(bArr);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void serverCertificateRequested() {
        synchronized (this.ssl) {
            this.ssl.configureServerCertificate();
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        return this.ssl.serverPSKKeyRequested(str, str2, bArr);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public long serverSessionRequested(byte[] bArr) {
        return 0L;
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocols(String[] strArr) {
        this.sslParameters.setApplicationProtocols(strArr);
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setBufferAllocator(BufferAllocator bufferAllocator) {
        synchronized (this.ssl) {
            try {
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Could not set buffer allocator after the initial handshake has begun.");
                }
                this.bufferAllocator = bufferAllocator;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdEnabled(boolean z) {
        synchronized (this.ssl) {
            try {
                if (getUseClientMode()) {
                    throw new IllegalStateException("Not allowed in client mode");
                }
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Could not enable/disable Channel ID after the initial handshake has begun.");
                }
                this.sslParameters.channelIdEnabled = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        if (!getUseClientMode()) {
            throw new IllegalStateException("Not allowed in server mode");
        }
        synchronized (this.ssl) {
            try {
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Could not change Channel ID private key after the initial handshake has begun.");
                }
                if (privateKey == null) {
                    this.sslParameters.channelIdEnabled = false;
                    this.channelIdPrivateKey = null;
                    return;
                }
                this.sslParameters.channelIdEnabled = true;
                try {
                    ECParameterSpec params = privateKey instanceof ECKey ? ((ECKey) privateKey).getParams() : null;
                    if (params == null) {
                        params = OpenSSLECGroupContext.getCurveByName("prime256v1").getECParameterSpec();
                    }
                    this.channelIdPrivateKey = OpenSSLKey.fromECPrivateKeyForTLSStackOnly(privateKey, params);
                } catch (InvalidKeyException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnableSessionCreation(boolean z) {
        this.sslParameters.setEnableSessionCreation(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHandshakeListener(HandshakeListener handshakeListener) {
        synchronized (this.ssl) {
            try {
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Handshake listener must be set before starting the handshake.");
                }
                this.handshakeListener = handshakeListener;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHostname(String str) {
        this.sslParameters.setUseSni(str != null);
        this.peerHostname = str;
    }

    @Override // javax.net.ssl.SSLEngine
    public void setNeedClientAuth(boolean z) {
        this.sslParameters.setNeedClientAuth(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setSSLParameters(SSLParameters sSLParameters) {
        super.setSSLParameters(sSLParameters);
        Platform.setSSLParameters(sSLParameters, this.sslParameters, this);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setUseClientMode(boolean z) {
        synchronized (this.ssl) {
            try {
                if (isHandshakeStarted()) {
                    throw new IllegalArgumentException("Can not change mode after handshake: state == " + this.state);
                }
                transitionTo(1);
                this.sslParameters.setUseClientMode(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setUseSessionTickets(boolean z) {
        this.sslParameters.setUseSessionTickets(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setWantClientAuth(boolean z) {
        this.sslParameters.setWantClientAuth(z);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        SSLEngineResult sSLEngineResultUnwrap;
        synchronized (this.ssl) {
            try {
                try {
                    sSLEngineResultUnwrap = unwrap(singleSrcBuffer(byteBuffer), singleDstBuffer(byteBuffer2));
                } finally {
                    resetSingleSrcBuffer();
                    resetSingleDstBuffer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sSLEngineResultUnwrap;
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void verifyCertificateChain(byte[][] bArr, String str) throws CertificateException {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    X509Certificate[] x509CertificateArrDecodeX509CertificateChain = SSLUtils.decodeX509CertificateChain(bArr);
                    X509TrustManager x509TrustManager = this.sslParameters.getX509TrustManager();
                    if (x509TrustManager == null) {
                        throw new CertificateException("No X.509 TrustManager");
                    }
                    this.activeSession.onPeerCertificatesReceived(getPeerHost(), getPeerPort(), x509CertificateArrDecodeX509CertificateChain);
                    if (getUseClientMode()) {
                        Platform.checkServerTrusted(x509TrustManager, x509CertificateArrDecodeX509CertificateChain, str, this);
                        return;
                    } else {
                        Platform.checkClientTrusted(x509TrustManager, x509CertificateArrDecodeX509CertificateChain, x509CertificateArrDecodeX509CertificateChain[0].getPublicKey().getAlgorithm(), this);
                        return;
                    }
                }
            } catch (CertificateException e) {
                throw e;
            } catch (Exception e2) {
                throw new CertificateException(e2);
            }
        }
        throw new CertificateException("Peer sent no certificate");
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        SSLEngineResult sSLEngineResultWrap;
        synchronized (this.ssl) {
            try {
                try {
                    sSLEngineResultWrap = wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
                } finally {
                    resetSingleSrcBuffer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sSLEngineResultWrap;
    }

    public void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.sslParameters.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i) {
        return !this.handshakeFinished ? pendingStatus(i) : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer byteBuffer) {
        int iBytesProduced;
        int iWritePlaintextData;
        SSLEngineResult pendingBytesFromBIO;
        boolean z = true;
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBuffer != null, "dst is null");
        int i4 = i + i2;
        Preconditions.checkPositionIndexes(i, i4, byteBufferArr.length);
        if (!byteBuffer.isReadOnly()) {
            if (i != 0 || i2 != byteBufferArr.length) {
                byteBufferArr = (ByteBuffer[]) Arrays.copyOfRange(byteBufferArr, i, i4);
            }
            BufferUtils.checkNotNull(byteBufferArr);
            synchronized (this.ssl) {
                try {
                    int i5 = this.state;
                    if (i5 != 0) {
                        if (i5 == 1) {
                            beginHandshakeInternal();
                        } else if (i5 == 7 || i5 == 8) {
                            SSLEngineResult pendingBytesFromBIO2 = readPendingBytesFromBIO(byteBuffer, 0, 0, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
                            if (pendingBytesFromBIO2 != null) {
                                freeIfDone();
                                return pendingBytesFromBIO2;
                            }
                            return new SSLEngineResult(SSLEngineResult.Status.CLOSED, getHandshakeStatusInternal(), 0, 0);
                        }
                        SSLEngineResult.HandshakeStatus handshakeStatusHandshake = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                        if (!this.handshakeFinished) {
                            handshakeStatusHandshake = handshake();
                            if (handshakeStatusHandshake == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                                return NEED_UNWRAP_OK;
                            }
                            if (this.state == 8) {
                                return NEED_UNWRAP_CLOSED;
                            }
                        }
                        int iMin = (int) Math.min(BufferUtils.remaining(byteBufferArr), 16384L);
                        if (byteBuffer.remaining() < SSLUtils.calculateOutNetBufSize(iMin)) {
                            return new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatusInternal(), 0, 0);
                        }
                        if (iMin > 0) {
                            ByteBuffer bufferLargerThan = BufferUtils.getBufferLargerThan(byteBufferArr, 16384);
                            if (bufferLargerThan == null) {
                                bufferLargerThan = BufferUtils.copyNoConsume(byteBufferArr, getOrCreateLazyDirectBuffer(), 16384);
                            } else {
                                z = false;
                            }
                            iWritePlaintextData = writePlaintextData(bufferLargerThan, Math.min(16384, bufferLargerThan.remaining()));
                            if (iWritePlaintextData > 0) {
                                if (z) {
                                    BufferUtils.consume(byteBufferArr, iWritePlaintextData);
                                }
                                SSLEngineResult pendingBytesFromBIO3 = readPendingBytesFromBIO(byteBuffer, iWritePlaintextData, 0, handshakeStatusHandshake);
                                if (pendingBytesFromBIO3 == null) {
                                    iBytesProduced = 0;
                                } else {
                                    if (pendingBytesFromBIO3.getStatus() != SSLEngineResult.Status.OK) {
                                        return pendingBytesFromBIO3;
                                    }
                                    iBytesProduced = pendingBytesFromBIO3.bytesProduced();
                                }
                            } else {
                                int error = this.ssl.getError(iWritePlaintextData);
                                if (error == 2) {
                                    SSLEngineResult pendingBytesFromBIO4 = readPendingBytesFromBIO(byteBuffer, 0, 0, handshakeStatusHandshake);
                                    if (pendingBytesFromBIO4 == null) {
                                        pendingBytesFromBIO4 = new SSLEngineResult(getEngineStatus(), SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
                                    }
                                    return pendingBytesFromBIO4;
                                }
                                if (error == 3) {
                                    SSLEngineResult pendingBytesFromBIO5 = readPendingBytesFromBIO(byteBuffer, 0, 0, handshakeStatusHandshake);
                                    if (pendingBytesFromBIO5 == null) {
                                        pendingBytesFromBIO5 = NEED_WRAP_CLOSED;
                                    }
                                    return pendingBytesFromBIO5;
                                }
                                if (error == 6) {
                                    closeAll();
                                    SSLEngineResult pendingBytesFromBIO6 = readPendingBytesFromBIO(byteBuffer, 0, 0, handshakeStatusHandshake);
                                    if (pendingBytesFromBIO6 == null) {
                                        pendingBytesFromBIO6 = CLOSED_NOT_HANDSHAKING;
                                    }
                                    return pendingBytesFromBIO6;
                                }
                                closeAll();
                                throw newSslExceptionWithMessage("SSL_write: error " + error);
                            }
                        } else {
                            iBytesProduced = 0;
                            iWritePlaintextData = 0;
                        }
                        return (iWritePlaintextData != 0 || (pendingBytesFromBIO = readPendingBytesFromBIO(byteBuffer, 0, iBytesProduced, handshakeStatusHandshake)) == null) ? newResult(iWritePlaintextData, iBytesProduced, handshakeStatusHandshake) : pendingBytesFromBIO;
                    }
                    throw new IllegalStateException("Client/server mode must be set before calling wrap");
                } finally {
                }
            }
        }
        throw new ReadOnlyBufferException();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        SSLEngineResult sSLEngineResultUnwrap;
        synchronized (this.ssl) {
            try {
                try {
                    sSLEngineResultUnwrap = unwrap(singleSrcBuffer(byteBuffer), byteBufferArr);
                } finally {
                    resetSingleSrcBuffer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sSLEngineResultUnwrap;
    }

    public ConscryptEngine(String str, int i, SSLParametersImpl sSLParametersImpl) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = PeerInfoProvider.forHostAndPort(str, i);
        NativeSsl nativeSslNewSsl = newSsl(sSLParametersImpl, this, this);
        this.ssl = nativeSslNewSsl;
        this.networkBio = nativeSslNewSsl.newBio();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) {
        SSLEngineResult sSLEngineResultUnwrap;
        synchronized (this.ssl) {
            try {
                try {
                    sSLEngineResultUnwrap = unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i, i2);
                } finally {
                    resetSingleSrcBuffer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sSLEngineResultUnwrap;
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) {
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBufferArr2 != null, "dsts is null");
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0145 A[Catch: all -> 0x004a, TryCatch #3 {all -> 0x004a, IOException -> 0x0106, blocks: (B:12:0x002c, B:26:0x0050, B:28:0x0056, B:30:0x005e, B:31:0x0060, B:33:0x0062, B:35:0x0066, B:36:0x0068, B:38:0x006a, B:47:0x0080, B:48:0x008b, B:50:0x008d, B:52:0x0093, B:54:0x0098, B:55:0x00a3, B:67:0x00c2, B:69:0x00ca, B:85:0x00ec, B:93:0x0103, B:88:0x00f5, B:90:0x00fb, B:104:0x0114, B:105:0x011d, B:106:0x011e, B:107:0x0122, B:109:0x0124, B:111:0x0131, B:113:0x0136, B:114:0x0139, B:112:0x0134, B:118:0x0141, B:120:0x0145, B:122:0x014b, B:126:0x0158, B:127:0x015f, B:125:0x0154, B:129:0x0161, B:130:0x0165, B:132:0x0167, B:133:0x016e, B:116:0x013b, B:134:0x016f, B:135:0x0173, B:70:0x00cd, B:72:0x00d7, B:79:0x00e2, B:57:0x00a5, B:58:0x00ac, B:60:0x00af, B:61:0x00ba, B:20:0x003a, B:21:0x0048, B:25:0x004d, B:137:0x0175, B:138:0x017c), top: B:146:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x014b A[Catch: all -> 0x004a, TryCatch #3 {all -> 0x004a, IOException -> 0x0106, blocks: (B:12:0x002c, B:26:0x0050, B:28:0x0056, B:30:0x005e, B:31:0x0060, B:33:0x0062, B:35:0x0066, B:36:0x0068, B:38:0x006a, B:47:0x0080, B:48:0x008b, B:50:0x008d, B:52:0x0093, B:54:0x0098, B:55:0x00a3, B:67:0x00c2, B:69:0x00ca, B:85:0x00ec, B:93:0x0103, B:88:0x00f5, B:90:0x00fb, B:104:0x0114, B:105:0x011d, B:106:0x011e, B:107:0x0122, B:109:0x0124, B:111:0x0131, B:113:0x0136, B:114:0x0139, B:112:0x0134, B:118:0x0141, B:120:0x0145, B:122:0x014b, B:126:0x0158, B:127:0x015f, B:125:0x0154, B:129:0x0161, B:130:0x0165, B:132:0x0167, B:133:0x016e, B:116:0x013b, B:134:0x016f, B:135:0x0173, B:70:0x00cd, B:72:0x00d7, B:79:0x00e2, B:57:0x00a5, B:58:0x00ac, B:60:0x00af, B:61:0x00ba, B:20:0x003a, B:21:0x0048, B:25:0x004d, B:137:0x0175, B:138:0x017c), top: B:146:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0161 A[Catch: all -> 0x004a, TryCatch #3 {all -> 0x004a, IOException -> 0x0106, blocks: (B:12:0x002c, B:26:0x0050, B:28:0x0056, B:30:0x005e, B:31:0x0060, B:33:0x0062, B:35:0x0066, B:36:0x0068, B:38:0x006a, B:47:0x0080, B:48:0x008b, B:50:0x008d, B:52:0x0093, B:54:0x0098, B:55:0x00a3, B:67:0x00c2, B:69:0x00ca, B:85:0x00ec, B:93:0x0103, B:88:0x00f5, B:90:0x00fb, B:104:0x0114, B:105:0x011d, B:106:0x011e, B:107:0x0122, B:109:0x0124, B:111:0x0131, B:113:0x0136, B:114:0x0139, B:112:0x0134, B:118:0x0141, B:120:0x0145, B:122:0x014b, B:126:0x0158, B:127:0x015f, B:125:0x0154, B:129:0x0161, B:130:0x0165, B:132:0x0167, B:133:0x016e, B:116:0x013b, B:134:0x016f, B:135:0x0173, B:70:0x00cd, B:72:0x00d7, B:79:0x00e2, B:57:0x00a5, B:58:0x00ac, B:60:0x00af, B:61:0x00ba, B:20:0x003a, B:21:0x0048, B:25:0x004d, B:137:0x0175, B:138:0x017c), top: B:146:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[LOOP:0: B:67:0x00c2->B:150:?, LOOP_END, SYNTHETIC] */
    @Override // org.conscrypt.AbstractConscryptEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer[] byteBufferArr2, int i4, int i5) {
        int encryptedPacketLength;
        int i6;
        int i7;
        boolean z = true;
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBufferArr2 != null, "dsts is null");
        int i8 = i2 + i;
        Preconditions.checkPositionIndexes(i, i8, byteBufferArr.length);
        int i9 = i4 + i5;
        Preconditions.checkPositionIndexes(i4, i9, byteBufferArr2.length);
        int iCalcDstsLength = calcDstsLength(byteBufferArr2, i4, i5);
        long jCalcSrcsLength = calcSrcsLength(byteBufferArr, i, i8);
        synchronized (this.ssl) {
            try {
                int i10 = this.state;
                if (i10 != 0) {
                    if (i10 == 1) {
                        beginHandshakeInternal();
                    } else if (i10 == 6 || i10 == 8) {
                        freeIfDone();
                        return new SSLEngineResult(SSLEngineResult.Status.CLOSED, getHandshakeStatusInternal(), 0, 0);
                    }
                    SSLEngineResult.HandshakeStatus handshakeStatusInternal = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                    if (!this.handshakeFinished) {
                        handshakeStatusInternal = handshake();
                        if (handshakeStatusInternal == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
                            return NEED_WRAP_OK;
                        }
                        if (this.state == 8) {
                            return NEED_WRAP_CLOSED;
                        }
                    }
                    if (pendingInboundCleartextBytes() > 0) {
                        z = false;
                    }
                    if (jCalcSrcsLength <= 0 || !z) {
                        if (z) {
                            return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                        }
                        encryptedPacketLength = 0;
                    } else {
                        if (jCalcSrcsLength < 5) {
                            return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                        }
                        encryptedPacketLength = SSLUtils.getEncryptedPacketLength(byteBufferArr, i);
                        if (encryptedPacketLength < 0) {
                            throw new SSLException("Unable to parse TLS packet header");
                        }
                        if (jCalcSrcsLength < encryptedPacketLength) {
                            return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                        }
                    }
                    if (encryptedPacketLength <= 0 || i >= i8) {
                        i6 = 0;
                    } else {
                        i6 = 0;
                        while (true) {
                            ByteBuffer byteBuffer = byteBufferArr[i];
                            int iRemaining = byteBuffer.remaining();
                            if (iRemaining != 0) {
                                int iWriteEncryptedData = writeEncryptedData(byteBuffer, Math.min(encryptedPacketLength, iRemaining));
                                if (iWriteEncryptedData <= 0) {
                                    NativeCrypto.SSL_clear_error();
                                    break;
                                }
                                i6 += iWriteEncryptedData;
                                encryptedPacketLength -= iWriteEncryptedData;
                                if (encryptedPacketLength != 0 && iWriteEncryptedData == iRemaining) {
                                    i++;
                                    if (i < i8) {
                                        break;
                                    }
                                }
                            } else {
                                i++;
                                if (i < i8) {
                                }
                            }
                        }
                    }
                    if (iCalcDstsLength <= 0) {
                        try {
                            this.ssl.forceRead();
                            i7 = 0;
                            if ((this.handshakeFinished ? pendingInboundCleartextBytes() : 0) <= 0) {
                            }
                        } catch (InterruptedIOException unused) {
                            return newResult(i6, i, handshakeStatusInternal);
                        }
                    } else {
                        i7 = 0;
                        while (i4 < i9) {
                            try {
                                ByteBuffer byteBuffer2 = byteBufferArr2[i4];
                                if (byteBuffer2.hasRemaining()) {
                                    int plaintextData = readPlaintextData(byteBuffer2);
                                    if (plaintextData <= 0) {
                                        if (plaintextData != -6) {
                                            if (plaintextData != -3 && plaintextData != -2) {
                                                closeAll();
                                                throw newSslExceptionWithMessage("SSL_read");
                                            }
                                            return newResult(i6, i7, handshakeStatusInternal);
                                        }
                                        closeAll();
                                        return new SSLEngineResult(SSLEngineResult.Status.CLOSED, pendingOutboundEncryptedBytes() > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, i6, i7);
                                    }
                                    i7 += plaintextData;
                                    if (byteBuffer2.hasRemaining()) {
                                        break;
                                    }
                                }
                                i4++;
                            } catch (InterruptedIOException unused2) {
                                i = i7;
                                return newResult(i6, i, handshakeStatusInternal);
                            }
                        }
                        if ((this.handshakeFinished ? pendingInboundCleartextBytes() : 0) <= 0) {
                            SSLEngineResult.Status status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                            if (handshakeStatusInternal != SSLEngineResult.HandshakeStatus.FINISHED) {
                                handshakeStatusInternal = getHandshakeStatusInternal();
                            }
                            return new SSLEngineResult(status, mayFinishHandshake(handshakeStatusInternal), i6, i7);
                        }
                        return newResult(i6, i7, handshakeStatusInternal);
                    }
                } else {
                    throw new IllegalStateException("Client/server mode must be set before calling unwrap");
                }
            } catch (IOException e) {
                closeAll();
                throw convertException(e);
            } finally {
            }
        }
    }

    public ConscryptEngine(SSLParametersImpl sSLParametersImpl, PeerInfoProvider peerInfoProvider, SSLParametersImpl.AliasChooser aliasChooser) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = (PeerInfoProvider) Preconditions.checkNotNull(peerInfoProvider, "peerInfoProvider");
        NativeSsl nativeSslNewSsl = newSsl(sSLParametersImpl, this, aliasChooser);
        this.ssl = nativeSslNewSsl;
        this.networkBio = nativeSslNewSsl.newBio();
    }
}
