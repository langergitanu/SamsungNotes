package com.nimbusds.jose.jwk;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.nimbusds.jose.KeyException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class JWKException extends KeyException {
    public JWKException(String str) {
        super(str);
    }

    public static JWKException expectedClass(Class<? extends JWK> cls) {
        return new JWKException(AbstractC2322a.m1621k("Invalid JWK: Must be an instance of ", cls));
    }

    public static JWKException expectedPrivate() {
        return new JWKException("Expected private JWK but none available");
    }
}
