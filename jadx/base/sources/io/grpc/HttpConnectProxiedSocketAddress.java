package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class HttpConnectProxiedSocketAddress extends ProxiedSocketAddress {
    private static final long serialVersionUID = 0;

    @Nullable
    private final String password;
    private final SocketAddress proxyAddress;
    private final InetSocketAddress targetAddress;

    @Nullable
    private final String username;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {

        @Nullable
        private String password;
        private SocketAddress proxyAddress;
        private InetSocketAddress targetAddress;

        @Nullable
        private String username;

        public HttpConnectProxiedSocketAddress build() {
            return new HttpConnectProxiedSocketAddress(this.proxyAddress, this.targetAddress, this.username, this.password);
        }

        public Builder setPassword(@Nullable String str) {
            this.password = str;
            return this;
        }

        public Builder setProxyAddress(SocketAddress socketAddress) {
            this.proxyAddress = (SocketAddress) Preconditions.checkNotNull(socketAddress, "proxyAddress");
            return this;
        }

        public Builder setTargetAddress(InetSocketAddress inetSocketAddress) {
            this.targetAddress = (InetSocketAddress) Preconditions.checkNotNull(inetSocketAddress, "targetAddress");
            return this;
        }

        public Builder setUsername(@Nullable String str) {
            this.username = str;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpConnectProxiedSocketAddress)) {
            return false;
        }
        HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress = (HttpConnectProxiedSocketAddress) obj;
        return Objects.equal(this.proxyAddress, httpConnectProxiedSocketAddress.proxyAddress) && Objects.equal(this.targetAddress, httpConnectProxiedSocketAddress.targetAddress) && Objects.equal(this.username, httpConnectProxiedSocketAddress.username) && Objects.equal(this.password, httpConnectProxiedSocketAddress.password);
    }

    @Nullable
    public String getPassword() {
        return this.password;
    }

    public SocketAddress getProxyAddress() {
        return this.proxyAddress;
    }

    public InetSocketAddress getTargetAddress() {
        return this.targetAddress;
    }

    @Nullable
    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return Objects.hashCode(this.proxyAddress, this.targetAddress, this.username, this.password);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("proxyAddr", this.proxyAddress).add("targetAddr", this.targetAddress).add("username", this.username).add("hasPassword", this.password != null).toString();
    }

    private HttpConnectProxiedSocketAddress(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, @Nullable String str, @Nullable String str2) {
        Preconditions.checkNotNull(socketAddress, "proxyAddress");
        Preconditions.checkNotNull(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            Preconditions.checkState(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.proxyAddress = socketAddress;
        this.targetAddress = inetSocketAddress;
        this.username = str;
        this.password = str2;
    }
}
