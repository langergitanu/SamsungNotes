package org.apache.commons.text.lookup;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;
import org.apache.commons.lang3.function.FailableSupplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class InetAddressStringLookup extends AbstractStringLookup {
    static final InetAddressStringLookup LOCAL_HOST;
    static final InetAddressStringLookup LOOPACK_ADDRESS;
    private final FailableSupplier<InetAddress, UnknownHostException> inetAddressSupplier;

    static {
        final int i = 0;
        LOCAL_HOST = new InetAddressStringLookup(new FailableSupplier() { // from class: org.apache.commons.text.lookup.d
            @Override // org.apache.commons.lang3.function.FailableSupplier
            public final Object get() {
                switch (i) {
                    case 0:
                        return InetAddress.getLocalHost();
                    default:
                        return InetAddress.getLoopbackAddress();
                }
            }
        });
        final int i2 = 1;
        LOOPACK_ADDRESS = new InetAddressStringLookup(new FailableSupplier() { // from class: org.apache.commons.text.lookup.d
            @Override // org.apache.commons.lang3.function.FailableSupplier
            public final Object get() {
                switch (i2) {
                    case 0:
                        return InetAddress.getLocalHost();
                    default:
                        return InetAddress.getLoopbackAddress();
                }
            }
        });
    }

    private InetAddressStringLookup(FailableSupplier<InetAddress, UnknownHostException> failableSupplier) {
        Objects.requireNonNull(failableSupplier, "inetAddressSupplier");
        this.inetAddressSupplier = failableSupplier;
    }

    private InetAddress getInetAddress() {
        return this.inetAddressSupplier.get();
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        try {
            int iHashCode = str.hashCode();
            if (iHashCode != -1147692044) {
                if (iHashCode != 3373707) {
                    if (iHashCode == 1339224004 && str.equals("canonical-name")) {
                        return getInetAddress().getCanonicalHostName();
                    }
                } else if (str.equals("name")) {
                    return getInetAddress().getHostName();
                }
            } else if (str.equals("address")) {
                return getInetAddress().getHostAddress();
            }
            throw new IllegalArgumentException(str);
        } catch (UnknownHostException unused) {
            return null;
        }
    }
}
