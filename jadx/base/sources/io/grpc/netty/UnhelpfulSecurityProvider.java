package io.grpc.netty;

import java.security.Provider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class UnhelpfulSecurityProvider extends Provider {
    private static final long serialVersionUID = 0;

    public UnhelpfulSecurityProvider() {
        super("UnhelpfulSecurityProvider", 0.0d, "A Provider that provides nothing");
    }
}
