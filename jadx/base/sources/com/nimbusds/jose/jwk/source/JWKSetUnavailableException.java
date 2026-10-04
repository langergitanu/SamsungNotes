package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.KeySourceException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class JWKSetUnavailableException extends KeySourceException {
    private static final long serialVersionUID = 1;

    public JWKSetUnavailableException(String str) {
        super(str);
    }

    public JWKSetUnavailableException(String str, Throwable th) {
        super(str, th);
    }
}
