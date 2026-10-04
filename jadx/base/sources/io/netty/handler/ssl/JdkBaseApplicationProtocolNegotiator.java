package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class JdkBaseApplicationProtocolNegotiator implements JdkApplicationProtocolNegotiator {
    private final JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory listenerFactory;
    private final List<String> protocols;
    private final JdkApplicationProtocolNegotiator.ProtocolSelectorFactory selectorFactory;
    private final JdkApplicationProtocolNegotiator.SslEngineWrapperFactory wrapperFactory;
    static final JdkApplicationProtocolNegotiator.ProtocolSelectorFactory FAIL_SELECTOR_FACTORY = new JdkApplicationProtocolNegotiator.ProtocolSelectorFactory() { // from class: io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator.1
        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelectorFactory
        public JdkApplicationProtocolNegotiator.ProtocolSelector newSelector(SSLEngine sSLEngine, Set<String> set) {
            return new FailProtocolSelector((JdkSslEngine) sSLEngine, set);
        }
    };
    static final JdkApplicationProtocolNegotiator.ProtocolSelectorFactory NO_FAIL_SELECTOR_FACTORY = new JdkApplicationProtocolNegotiator.ProtocolSelectorFactory() { // from class: io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator.2
        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelectorFactory
        public JdkApplicationProtocolNegotiator.ProtocolSelector newSelector(SSLEngine sSLEngine, Set<String> set) {
            return new NoFailProtocolSelector((JdkSslEngine) sSLEngine, set);
        }
    };
    static final JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory FAIL_SELECTION_LISTENER_FACTORY = new JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory() { // from class: io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator.3
        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory
        public JdkApplicationProtocolNegotiator.ProtocolSelectionListener newListener(SSLEngine sSLEngine, List<String> list) {
            return new FailProtocolSelectionListener((JdkSslEngine) sSLEngine, list);
        }
    };
    static final JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory NO_FAIL_SELECTION_LISTENER_FACTORY = new JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory() { // from class: io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator.4
        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory
        public JdkApplicationProtocolNegotiator.ProtocolSelectionListener newListener(SSLEngine sSLEngine, List<String> list) {
            return new NoFailProtocolSelectionListener((JdkSslEngine) sSLEngine, list);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class FailProtocolSelectionListener extends NoFailProtocolSelectionListener {
        public FailProtocolSelectionListener(JdkSslEngine jdkSslEngine, List<String> list) {
            super(jdkSslEngine, list);
        }

        @Override // io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator.NoFailProtocolSelectionListener
        public void noSelectedMatchFound(String str) throws SSLHandshakeException {
            throw new SSLHandshakeException("No compatible protocols found");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class FailProtocolSelector extends NoFailProtocolSelector {
        public FailProtocolSelector(JdkSslEngine jdkSslEngine, Set<String> set) {
            super(jdkSslEngine, set);
        }

        @Override // io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator.NoFailProtocolSelector
        public String noSelectMatchFound() throws SSLHandshakeException {
            throw new SSLHandshakeException("Selected protocol is not supported");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NoFailProtocolSelector implements JdkApplicationProtocolNegotiator.ProtocolSelector {
        private final JdkSslEngine engineWrapper;
        private final Set<String> supportedProtocols;

        public NoFailProtocolSelector(JdkSslEngine jdkSslEngine, Set<String> set) {
            this.engineWrapper = jdkSslEngine;
            this.supportedProtocols = set;
        }

        public String noSelectMatchFound() {
            this.engineWrapper.setNegotiatedApplicationProtocol(null);
            return null;
        }

        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelector
        public String select(List<String> list) {
            for (String str : this.supportedProtocols) {
                if (list.contains(str)) {
                    this.engineWrapper.setNegotiatedApplicationProtocol(str);
                    return str;
                }
            }
            return noSelectMatchFound();
        }

        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelector
        public void unsupported() {
            this.engineWrapper.setNegotiatedApplicationProtocol(null);
        }
    }

    public JdkBaseApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.SslEngineWrapperFactory sslEngineWrapperFactory, JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolSelectionListenerFactory, Iterable<String> iterable) {
        this(sslEngineWrapperFactory, protocolSelectorFactory, protocolSelectionListenerFactory, ApplicationProtocolUtil.toList(iterable));
    }

    @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolListenerFactory() {
        return this.listenerFactory;
    }

    @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory() {
        return this.selectorFactory;
    }

    @Override // io.netty.handler.ssl.ApplicationProtocolNegotiator
    public List<String> protocols() {
        return this.protocols;
    }

    @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public JdkApplicationProtocolNegotiator.SslEngineWrapperFactory wrapperFactory() {
        return this.wrapperFactory;
    }

    public JdkBaseApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.SslEngineWrapperFactory sslEngineWrapperFactory, JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolSelectionListenerFactory, String... strArr) {
        this(sslEngineWrapperFactory, protocolSelectorFactory, protocolSelectionListenerFactory, ApplicationProtocolUtil.toList(strArr));
    }

    private JdkBaseApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.SslEngineWrapperFactory sslEngineWrapperFactory, JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolSelectionListenerFactory, List<String> list) {
        this.wrapperFactory = (JdkApplicationProtocolNegotiator.SslEngineWrapperFactory) ObjectUtil.checkNotNull(sslEngineWrapperFactory, "wrapperFactory");
        this.selectorFactory = (JdkApplicationProtocolNegotiator.ProtocolSelectorFactory) ObjectUtil.checkNotNull(protocolSelectorFactory, "selectorFactory");
        this.listenerFactory = (JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory) ObjectUtil.checkNotNull(protocolSelectionListenerFactory, "listenerFactory");
        this.protocols = Collections.unmodifiableList((List) ObjectUtil.checkNotNull(list, "protocols"));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NoFailProtocolSelectionListener implements JdkApplicationProtocolNegotiator.ProtocolSelectionListener {
        private final JdkSslEngine engineWrapper;
        private final List<String> supportedProtocols;

        public NoFailProtocolSelectionListener(JdkSslEngine jdkSslEngine, List<String> list) {
            this.engineWrapper = jdkSslEngine;
            this.supportedProtocols = list;
        }

        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelectionListener
        public void selected(String str) {
            if (this.supportedProtocols.contains(str)) {
                this.engineWrapper.setNegotiatedApplicationProtocol(str);
            } else {
                noSelectedMatchFound(str);
            }
        }

        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelectionListener
        public void unsupported() {
            this.engineWrapper.setNegotiatedApplicationProtocol(null);
        }

        public void noSelectedMatchFound(String str) {
        }
    }
}
