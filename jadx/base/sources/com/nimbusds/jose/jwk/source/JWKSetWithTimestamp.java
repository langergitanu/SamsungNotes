package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import java.util.Date;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
@Immutable
public final class JWKSetWithTimestamp {
    private final JWKSet jwkSet;
    private final Date timestamp;

    public JWKSetWithTimestamp(JWKSet jWKSet) {
        this(jWKSet, new Date());
    }

    public Date getDate() {
        return this.timestamp;
    }

    public JWKSet getJWKSet() {
        return this.jwkSet;
    }

    public JWKSetWithTimestamp(JWKSet jWKSet, Date date) {
        if (jWKSet == null) {
            throw new IllegalArgumentException("The JWK set must not be null");
        }
        this.jwkSet = jWKSet;
        if (date == null) {
            throw new IllegalArgumentException("The timestamp must not null");
        }
        this.timestamp = date;
    }
}
