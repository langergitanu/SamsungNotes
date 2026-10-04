package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class JWECryptoParts {
    private final Base64URL authenticationTag;
    private final Base64URL cipherText;
    private final Base64URL encryptedKey;
    private final JWEHeader header;

    /* JADX INFO: renamed from: iv */
    private final Base64URL f3619iv;

    public JWECryptoParts(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4) {
        this(null, base64URL, base64URL2, base64URL3, base64URL4);
    }

    public Base64URL getAuthenticationTag() {
        return this.authenticationTag;
    }

    public Base64URL getCipherText() {
        return this.cipherText;
    }

    public Base64URL getEncryptedKey() {
        return this.encryptedKey;
    }

    public JWEHeader getHeader() {
        return this.header;
    }

    public Base64URL getInitializationVector() {
        return this.f3619iv;
    }

    public JWECryptoParts(JWEHeader jWEHeader, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4) {
        this.header = jWEHeader;
        this.encryptedKey = base64URL;
        this.f3619iv = base64URL2;
        if (base64URL3 == null) {
            throw new IllegalArgumentException("The cipher text must not be null");
        }
        this.cipherText = base64URL3;
        this.authenticationTag = base64URL4;
    }
}
