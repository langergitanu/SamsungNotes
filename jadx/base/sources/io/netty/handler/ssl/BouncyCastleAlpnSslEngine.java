package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkAlpnSslEngine;
import io.netty.util.internal.SuppressJava6Requirement;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class BouncyCastleAlpnSslEngine extends JdkAlpnSslEngine {
    public BouncyCastleAlpnSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z) {
        super(sSLEngine, jdkApplicationProtocolNegotiator, z, new BiConsumer<SSLEngine, JdkAlpnSslEngine.AlpnSelector>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslEngine.1
            @Override // java.util.function.BiConsumer
            public void accept(SSLEngine sSLEngine2, JdkAlpnSslEngine.AlpnSelector alpnSelector) {
                BouncyCastleAlpnSslUtils.setHandshakeApplicationProtocolSelector(sSLEngine2, alpnSelector);
            }
        }, new BiConsumer<SSLEngine, List<String>>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslEngine.2
            @Override // java.util.function.BiConsumer
            public void accept(SSLEngine sSLEngine2, List<String> list) {
                BouncyCastleAlpnSslUtils.setApplicationProtocols(sSLEngine2, list);
            }
        });
    }

    @Override // io.netty.handler.ssl.JdkAlpnSslEngine, javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return BouncyCastleAlpnSslUtils.getApplicationProtocol(getWrappedEngine());
    }

    @Override // io.netty.handler.ssl.JdkAlpnSslEngine, javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        return BouncyCastleAlpnSslUtils.getHandshakeApplicationProtocol(getWrappedEngine());
    }

    @Override // io.netty.handler.ssl.JdkAlpnSslEngine, javax.net.ssl.SSLEngine
    public BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return BouncyCastleAlpnSslUtils.getHandshakeApplicationProtocolSelector(getWrappedEngine());
    }

    @Override // io.netty.handler.ssl.JdkAlpnSslEngine, javax.net.ssl.SSLEngine
    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> biFunction) {
        BouncyCastleAlpnSslUtils.setHandshakeApplicationProtocolSelector(getWrappedEngine(), biFunction);
    }
}
