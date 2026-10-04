package org.conscrypt;

import androidx.glance.AbstractC2821a;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class ApplicationProtocolSelectorAdapter {
    private static final int NO_PROTOCOL_SELECTED = -1;
    private final SSLEngine engine;
    private final ApplicationProtocolSelector selector;
    private final SSLSocket socket;

    public ApplicationProtocolSelectorAdapter(SSLEngine sSLEngine, ApplicationProtocolSelector applicationProtocolSelector) {
        this.engine = (SSLEngine) Preconditions.checkNotNull(sSLEngine, "engine");
        this.socket = null;
        this.selector = (ApplicationProtocolSelector) Preconditions.checkNotNull(applicationProtocolSelector, "selector");
    }

    public int selectApplicationProtocol(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            List<String> listAsList = Arrays.asList(SSLUtils.decodeProtocols(bArr));
            SSLEngine sSLEngine = this.engine;
            String strSelectApplicationProtocol = sSLEngine != null ? this.selector.selectApplicationProtocol(sSLEngine, listAsList) : this.selector.selectApplicationProtocol(this.socket, listAsList);
            if (strSelectApplicationProtocol != null && !strSelectApplicationProtocol.isEmpty()) {
                int iM2212c = 0;
                for (String str : listAsList) {
                    if (strSelectApplicationProtocol.equals(str)) {
                        return iM2212c;
                    }
                    iM2212c = AbstractC2821a.m2212c(1, iM2212c, str);
                }
            }
        }
        return -1;
    }

    public ApplicationProtocolSelectorAdapter(SSLSocket sSLSocket, ApplicationProtocolSelector applicationProtocolSelector) {
        this.engine = null;
        this.socket = (SSLSocket) Preconditions.checkNotNull(sSLSocket, "socket");
        this.selector = (ApplicationProtocolSelector) Preconditions.checkNotNull(applicationProtocolSelector, "selector");
    }
}
