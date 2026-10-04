package cz.msebera.android.httpclient.config;

import androidx.glance.AbstractC2821a;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class SocketConfig implements Cloneable {
    public static final SocketConfig DEFAULT = new Builder().build();
    private final int backlogSize;
    private final int rcvBufSize;
    private final int sndBufSize;
    private final boolean soKeepAlive;
    private final int soLinger;
    private final boolean soReuseAddress;
    private final int soTimeout;
    private final boolean tcpNoDelay;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private int backlogSize;
        private int rcvBufSize;
        private int sndBufSize;
        private boolean soKeepAlive;
        private boolean soReuseAddress;
        private int soTimeout;
        private int soLinger = -1;
        private boolean tcpNoDelay = true;

        public SocketConfig build() {
            return new SocketConfig(this.soTimeout, this.soReuseAddress, this.soLinger, this.soKeepAlive, this.tcpNoDelay, this.sndBufSize, this.rcvBufSize, this.backlogSize);
        }

        public Builder setBacklogSize(int i) {
            this.backlogSize = i;
            return this;
        }

        public Builder setRcvBufSize(int i) {
            this.rcvBufSize = i;
            return this;
        }

        public Builder setSndBufSize(int i) {
            this.sndBufSize = i;
            return this;
        }

        public Builder setSoKeepAlive(boolean z) {
            this.soKeepAlive = z;
            return this;
        }

        public Builder setSoLinger(int i) {
            this.soLinger = i;
            return this;
        }

        public Builder setSoReuseAddress(boolean z) {
            this.soReuseAddress = z;
            return this;
        }

        public Builder setSoTimeout(int i) {
            this.soTimeout = i;
            return this;
        }

        public Builder setTcpNoDelay(boolean z) {
            this.tcpNoDelay = z;
            return this;
        }
    }

    public SocketConfig(int i, boolean z, int i2, boolean z2, boolean z3, int i4, int i5, int i6) {
        this.soTimeout = i;
        this.soReuseAddress = z;
        this.soLinger = i2;
        this.soKeepAlive = z2;
        this.tcpNoDelay = z3;
        this.sndBufSize = i4;
        this.rcvBufSize = i5;
        this.backlogSize = i6;
    }

    public static Builder copy(SocketConfig socketConfig) {
        Args.notNull(socketConfig, "Socket config");
        return new Builder().setSoTimeout(socketConfig.getSoTimeout()).setSoReuseAddress(socketConfig.isSoReuseAddress()).setSoLinger(socketConfig.getSoLinger()).setSoKeepAlive(socketConfig.isSoKeepAlive()).setTcpNoDelay(socketConfig.isTcpNoDelay()).setSndBufSize(socketConfig.getSndBufSize()).setRcvBufSize(socketConfig.getRcvBufSize()).setBacklogSize(socketConfig.getBacklogSize());
    }

    public static Builder custom() {
        return new Builder();
    }

    public int getBacklogSize() {
        return this.backlogSize;
    }

    public int getRcvBufSize() {
        return this.rcvBufSize;
    }

    public int getSndBufSize() {
        return this.sndBufSize;
    }

    public int getSoLinger() {
        return this.soLinger;
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public boolean isSoKeepAlive() {
        return this.soKeepAlive;
    }

    public boolean isSoReuseAddress() {
        return this.soReuseAddress;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[soTimeout=");
        sb.append(this.soTimeout);
        sb.append(", soReuseAddress=");
        sb.append(this.soReuseAddress);
        sb.append(", soLinger=");
        sb.append(this.soLinger);
        sb.append(", soKeepAlive=");
        sb.append(this.soKeepAlive);
        sb.append(", tcpNoDelay=");
        sb.append(this.tcpNoDelay);
        sb.append(", sndBufSize=");
        sb.append(this.sndBufSize);
        sb.append(", rcvBufSize=");
        sb.append(this.rcvBufSize);
        sb.append(", backlogSize=");
        return AbstractC2821a.m2223n(sb, "]", this.backlogSize);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SocketConfig m22208clone() {
        return (SocketConfig) super.clone();
    }
}
