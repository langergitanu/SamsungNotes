package io.grpc.inprocess;

import com.google.common.base.Preconditions;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class InProcessSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -2803441206326023474L;
    private final String name;

    public InProcessSocketAddress(String str) {
        this.name = (String) Preconditions.checkNotNull(str, "name");
    }

    public boolean equals(Object obj) {
        if (obj instanceof InProcessSocketAddress) {
            return this.name.equals(((InProcessSocketAddress) obj).name);
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return this.name;
    }
}
