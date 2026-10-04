package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.proc.SecurityContext;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class JWKSetSourceWrapper<C extends SecurityContext> implements JWKSetSource<C> {
    private final JWKSetSource<C> source;

    public JWKSetSourceWrapper(JWKSetSource<C> jWKSetSource) {
        Objects.requireNonNull(jWKSetSource);
        this.source = jWKSetSource;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public JWKSetSource<C> getSource() {
        return this.source;
    }
}
