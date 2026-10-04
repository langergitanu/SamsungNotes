package com.google.api.client.auth.oauth;

import com.google.api.client.util.Base64;
import com.google.api.client.util.Beta;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.StringUtils;
import java.security.PrivateKey;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public final class OAuthRsaSigner implements OAuthSigner {
    public PrivateKey privateKey;

    @Override // com.google.api.client.auth.oauth.OAuthSigner
    public String computeSignature(String str) {
        return Base64.encodeBase64String(SecurityUtils.sign(SecurityUtils.getSha1WithRsaSignatureAlgorithm(), this.privateKey, StringUtils.getBytesUtf8(str)));
    }

    @Override // com.google.api.client.auth.oauth.OAuthSigner
    public String getSignatureMethod() {
        return "RSA-SHA1";
    }
}
