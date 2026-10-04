package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import org.eclipse.jetty.alpn.ALPN;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
abstract class JettyAlpnSslEngine extends JdkSslEngine {
    private static final boolean available = initAvailable();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ClientEngine extends JettyAlpnSslEngine {
        public ClientEngine(SSLEngine sSLEngine, final JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator) {
            super(sSLEngine);
            ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator, "applicationNegotiator");
            final JdkApplicationProtocolNegotiator.ProtocolSelectionListener protocolSelectionListener = (JdkApplicationProtocolNegotiator.ProtocolSelectionListener) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator.protocols()), "protocolListener");
            ALPN.put(sSLEngine, new ALPN.ClientProvider() { // from class: io.netty.handler.ssl.JettyAlpnSslEngine.ClientEngine.1
                public List<String> protocols() {
                    return jdkApplicationProtocolNegotiator.protocols();
                }

                public void selected(String str) throws SSLHandshakeException {
                    try {
                        protocolSelectionListener.selected(str);
                    } catch (Throwable th) {
                        throw SslUtils.toSSLHandshakeException(th);
                    }
                }

                public void unsupported() {
                    protocolSelectionListener.unsupported();
                }
            });
        }

        @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
        public void closeInbound() throws SSLException {
            try {
                ALPN.remove(getWrappedEngine());
            } finally {
                super.closeInbound();
            }
        }

        @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
        public void closeOutbound() {
            try {
                ALPN.remove(getWrappedEngine());
            } finally {
                super.closeOutbound();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ServerEngine extends JettyAlpnSslEngine {
        public ServerEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator) {
            super(sSLEngine);
            ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator, "applicationNegotiator");
            final JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector = (JdkApplicationProtocolNegotiator.ProtocolSelector) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator.protocols())), "protocolSelector");
            ALPN.put(sSLEngine, new ALPN.ServerProvider() { // from class: io.netty.handler.ssl.JettyAlpnSslEngine.ServerEngine.1
                public String select(List<String> list) throws SSLHandshakeException {
                    try {
                        return protocolSelector.select(list);
                    } catch (Throwable th) {
                        throw SslUtils.toSSLHandshakeException(th);
                    }
                }

                public void unsupported() {
                    protocolSelector.unsupported();
                }
            });
        }

        @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
        public void closeInbound() throws SSLException {
            try {
                ALPN.remove(getWrappedEngine());
            } finally {
                super.closeInbound();
            }
        }

        @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
        public void closeOutbound() {
            try {
                ALPN.remove(getWrappedEngine());
            } finally {
                super.closeOutbound();
            }
        }
    }

    private static boolean initAvailable() {
        if (PlatformDependent.javaVersion() > 8) {
            return false;
        }
        try {
            Class.forName("sun.security.ssl.ALPNExtension", true, null);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isAvailable() {
        return available;
    }

    public static JettyAlpnSslEngine newClientEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator) {
        return new ClientEngine(sSLEngine, jdkApplicationProtocolNegotiator);
    }

    public static JettyAlpnSslEngine newServerEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator) {
        return new ServerEngine(sSLEngine, jdkApplicationProtocolNegotiator);
    }

    private JettyAlpnSslEngine(SSLEngine sSLEngine) {
        super(sSLEngine);
    }
}
