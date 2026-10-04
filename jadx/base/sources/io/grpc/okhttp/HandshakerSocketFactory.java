package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import io.grpc.Attributes;
import io.grpc.InternalChannelz;
import java.net.Socket;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
interface HandshakerSocketFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HandshakeResult {
        public final Attributes attributes;
        public final InternalChannelz.Security securityInfo;
        public final Socket socket;

        public HandshakeResult(Socket socket, Attributes attributes, InternalChannelz.Security security) {
            this.socket = (Socket) Preconditions.checkNotNull(socket, "socket");
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes, NativeAuthConstants.GrantType.ATTRIBUTES);
            this.securityInfo = security;
        }
    }

    HandshakeResult handshake(Socket socket, Attributes attributes);
}
