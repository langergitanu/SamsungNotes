package io.grpc.netty;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import io.grpc.Attributes;
import io.grpc.Internal;
import io.grpc.InternalChannelz;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
@CheckReturnValue
public final class ProtocolNegotiationEvent {
    static final ProtocolNegotiationEvent DEFAULT = new ProtocolNegotiationEvent(Attributes.EMPTY, null);
    private final Attributes attributes;

    @Nullable
    private final InternalChannelz.Security security;

    private ProtocolNegotiationEvent(Attributes attributes, @Nullable InternalChannelz.Security security) {
        this.attributes = (Attributes) Preconditions.checkNotNull(attributes, NativeAuthConstants.GrantType.ATTRIBUTES);
        this.security = security;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ProtocolNegotiationEvent)) {
            return false;
        }
        ProtocolNegotiationEvent protocolNegotiationEvent = (ProtocolNegotiationEvent) obj;
        return Objects.equal(this.attributes, protocolNegotiationEvent.attributes) && Objects.equal(this.security, protocolNegotiationEvent.security);
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    @Nullable
    public InternalChannelz.Security getSecurity() {
        return this.security;
    }

    public int hashCode() {
        return Objects.hashCode(this.attributes, this.security);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add(NativeAuthConstants.GrantType.ATTRIBUTES, this.attributes).add("security", this.security).toString();
    }

    public ProtocolNegotiationEvent withAttributes(Attributes attributes) {
        return new ProtocolNegotiationEvent(attributes, this.security);
    }

    public ProtocolNegotiationEvent withSecurity(@Nullable InternalChannelz.Security security) {
        return new ProtocolNegotiationEvent(this.attributes, security);
    }
}
