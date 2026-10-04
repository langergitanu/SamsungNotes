package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface JWSVerifier extends JWSProvider {
    boolean verify(JWSHeader jWSHeader, byte[] bArr, Base64URL base64URL);
}
