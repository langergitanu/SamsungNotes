package io.netty.handler.ssl;

import io.netty.util.ReferenceCounted;
import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
interface OpenSslKeyMaterial extends ReferenceCounted {
    X509Certificate[] certificateChain();

    long certificateChainAddress();

    long privateKeyAddress();

    @Override // io.netty.util.ReferenceCounted
    boolean release();

    @Override // io.netty.util.ReferenceCounted
    boolean release(int i);

    @Override // io.netty.util.ReferenceCounted
    OpenSslKeyMaterial retain();

    @Override // io.netty.util.ReferenceCounted
    OpenSslKeyMaterial retain(int i);

    @Override // io.netty.util.ReferenceCounted
    OpenSslKeyMaterial touch();

    @Override // io.netty.util.ReferenceCounted
    OpenSslKeyMaterial touch(Object obj);
}
