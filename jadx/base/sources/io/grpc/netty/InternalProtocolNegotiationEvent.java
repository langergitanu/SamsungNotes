package io.grpc.netty;

import io.grpc.Attributes;
import io.grpc.Internal;
import io.grpc.InternalChannelz;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalProtocolNegotiationEvent {
    private InternalProtocolNegotiationEvent() {
    }

    public static Attributes getAttributes(ProtocolNegotiationEvent protocolNegotiationEvent) {
        return protocolNegotiationEvent.getAttributes();
    }

    public static ProtocolNegotiationEvent getDefault() {
        return ProtocolNegotiationEvent.DEFAULT;
    }

    @Nullable
    public static InternalChannelz.Security getSecurity(ProtocolNegotiationEvent protocolNegotiationEvent) {
        return protocolNegotiationEvent.getSecurity();
    }

    public static ProtocolNegotiationEvent withAttributes(ProtocolNegotiationEvent protocolNegotiationEvent, Attributes attributes) {
        return protocolNegotiationEvent.withAttributes(attributes);
    }

    public static ProtocolNegotiationEvent withSecurity(ProtocolNegotiationEvent protocolNegotiationEvent, @Nullable InternalChannelz.Security security) {
        return protocolNegotiationEvent.withSecurity(security);
    }
}
