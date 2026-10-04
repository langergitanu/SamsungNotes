package com.nimbusds.jose.jwk;

import java.util.LinkedList;
import java.util.List;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class JWKSelector {
    private final JWKMatcher matcher;

    public JWKSelector(JWKMatcher jWKMatcher) {
        if (jWKMatcher == null) {
            throw new IllegalArgumentException("The JWK matcher must not be null");
        }
        this.matcher = jWKMatcher;
    }

    public JWKMatcher getMatcher() {
        return this.matcher;
    }

    public List<JWK> select(JWKSet jWKSet) {
        LinkedList linkedList = new LinkedList();
        if (jWKSet != null) {
            for (JWK jwk : jWKSet.getKeys()) {
                if (this.matcher.matches(jwk)) {
                    linkedList.add(jwk);
                }
            }
        }
        return linkedList;
    }
}
