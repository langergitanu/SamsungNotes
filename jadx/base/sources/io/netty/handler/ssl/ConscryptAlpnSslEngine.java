package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLHandshakeException;
import org.conscrypt.AllocatedBuffer;
import org.conscrypt.BufferAllocator;
import org.conscrypt.HandshakeListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
abstract class ConscryptAlpnSslEngine extends JdkSslEngine {
    private static final boolean USE_BUFFER_ALLOCATOR = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.conscrypt.useBufferAllocator", true);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class BufferAdapter extends AllocatedBuffer {
        private final ByteBuffer buffer;
        private final ByteBuf nettyBuffer;

        public BufferAdapter(ByteBuf byteBuf) {
            this.nettyBuffer = byteBuf;
            this.buffer = byteBuf.nioBuffer(0, byteBuf.capacity());
        }

        @Override // org.conscrypt.AllocatedBuffer
        public ByteBuffer nioBuffer() {
            return this.buffer;
        }

        @Override // org.conscrypt.AllocatedBuffer
        public AllocatedBuffer release() {
            this.nettyBuffer.release();
            return this;
        }

        @Override // org.conscrypt.AllocatedBuffer
        public AllocatedBuffer retain() {
            this.nettyBuffer.retain();
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class BufferAllocatorAdapter extends BufferAllocator {
        private final ByteBufAllocator alloc;

        public BufferAllocatorAdapter(ByteBufAllocator byteBufAllocator) {
            this.alloc = byteBufAllocator;
        }

        @Override // org.conscrypt.BufferAllocator
        public AllocatedBuffer allocateDirectBuffer(int i) {
            return new BufferAdapter(this.alloc.directBuffer(i));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ClientEngine extends ConscryptAlpnSslEngine {
        private final JdkApplicationProtocolNegotiator.ProtocolSelectionListener protocolListener;

        public ClientEngine(SSLEngine sSLEngine, ByteBufAllocator byteBufAllocator, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator) {
            super(sSLEngine, byteBufAllocator, jdkApplicationProtocolNegotiator.protocols());
            org.conscrypt.Conscrypt.setHandshakeListener(sSLEngine, new HandshakeListener() { // from class: io.netty.handler.ssl.ConscryptAlpnSslEngine.ClientEngine.1
                @Override // org.conscrypt.HandshakeListener
                public void onHandshakeFinished() throws SSLHandshakeException {
                    ClientEngine.this.selectProtocol();
                }
            });
            this.protocolListener = (JdkApplicationProtocolNegotiator.ProtocolSelectionListener) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator.protocols()), "protocolListener");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void selectProtocol() throws SSLHandshakeException {
            try {
                this.protocolListener.selected(org.conscrypt.Conscrypt.getApplicationProtocol(getWrappedEngine()));
            } catch (Throwable th) {
                throw SslUtils.toSSLHandshakeException(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ServerEngine extends ConscryptAlpnSslEngine {
        private final JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector;

        public ServerEngine(SSLEngine sSLEngine, ByteBufAllocator byteBufAllocator, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator) {
            super(sSLEngine, byteBufAllocator, jdkApplicationProtocolNegotiator.protocols());
            org.conscrypt.Conscrypt.setHandshakeListener(sSLEngine, new HandshakeListener() { // from class: io.netty.handler.ssl.ConscryptAlpnSslEngine.ServerEngine.1
                @Override // org.conscrypt.HandshakeListener
                public void onHandshakeFinished() throws SSLHandshakeException {
                    ServerEngine.this.selectProtocol();
                }
            });
            this.protocolSelector = (JdkApplicationProtocolNegotiator.ProtocolSelector) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator.protocols())), "protocolSelector");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void selectProtocol() throws SSLHandshakeException {
            try {
                String applicationProtocol = org.conscrypt.Conscrypt.getApplicationProtocol(getWrappedEngine());
                this.protocolSelector.select(applicationProtocol != null ? Collections.singletonList(applicationProtocol) : Collections.EMPTY_LIST);
            } catch (Throwable th) {
                throw SslUtils.toSSLHandshakeException(th);
            }
        }
    }

    public static ConscryptAlpnSslEngine newClientEngine(SSLEngine sSLEngine, ByteBufAllocator byteBufAllocator, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator) {
        return new ClientEngine(sSLEngine, byteBufAllocator, jdkApplicationProtocolNegotiator);
    }

    public static ConscryptAlpnSslEngine newServerEngine(SSLEngine sSLEngine, ByteBufAllocator byteBufAllocator, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator) {
        return new ServerEngine(sSLEngine, byteBufAllocator, jdkApplicationProtocolNegotiator);
    }

    public final int calculateOutNetBufSize(int i, int i2) {
        return (int) Math.min(2147483647L, ((long) i) + (((long) org.conscrypt.Conscrypt.maxSealOverhead(getWrappedEngine())) * ((long) i2)));
    }

    public final SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) {
        return org.conscrypt.Conscrypt.unwrap(getWrappedEngine(), byteBufferArr, byteBufferArr2);
    }

    private ConscryptAlpnSslEngine(SSLEngine sSLEngine, ByteBufAllocator byteBufAllocator, List<String> list) {
        super(sSLEngine);
        if (USE_BUFFER_ALLOCATOR) {
            org.conscrypt.Conscrypt.setBufferAllocator(sSLEngine, new BufferAllocatorAdapter(byteBufAllocator));
        }
        org.conscrypt.Conscrypt.setApplicationProtocols(sSLEngine, (String[]) list.toArray(new String[0]));
    }
}
