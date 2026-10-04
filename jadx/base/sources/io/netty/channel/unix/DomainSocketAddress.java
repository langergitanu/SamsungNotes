package io.netty.channel.unix;

import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DomainSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -6934618000832236893L;
    private final String socketPath;

    public DomainSocketAddress(String str) {
        this.socketPath = (String) ObjectUtil.checkNotNull(str, "socketPath");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DomainSocketAddress) {
            return ((DomainSocketAddress) obj).socketPath.equals(this.socketPath);
        }
        return false;
    }

    public int hashCode() {
        return this.socketPath.hashCode();
    }

    public String path() {
        return this.socketPath;
    }

    public String toString() {
        return path();
    }

    public DomainSocketAddress(File file) {
        this(file.getPath());
    }
}
