package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.source.JWKSetSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.events.Event;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class AbstractJWKSetSourceEvent<S extends JWKSetSource<C>, C extends SecurityContext> implements Event<S, C> {
    private final C context;
    private final S source;

    public AbstractJWKSetSourceEvent(S s, C c) {
        Objects.requireNonNull(s);
        this.source = s;
        this.context = c;
    }

    @Override // com.nimbusds.jose.util.events.Event
    public C getContext() {
        return this.context;
    }

    @Override // com.nimbusds.jose.util.events.Event
    public S getSource() {
        return this.source;
    }
}
