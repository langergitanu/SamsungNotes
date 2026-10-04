package com.nimbusds.jose.proc;

import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEProvider;
import java.security.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface JWEDecrypterFactory extends JWEProvider {
    JWEDecrypter createJWEDecrypter(JWEHeader jWEHeader, Key key);
}
