package com.microsoft.identity.common.java.providers.microsoft;

import com.microsoft.identity.common.java.providers.oauth2.IDToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftIdToken extends IDToken {
    public static final String AUDIENCE = "aud";
    public static final String ISSUED_AT = "iat";
    public static final String ISSUER = "iss";
    public static final String NOT_BEFORE = "nbf";
    public static final String OBJECT_ID = "oid";
    public static final String TENANT_ID = "tid";
    public static final String VERSION = "ver";

    public MicrosoftIdToken(String str) {
        super(str);
    }
}
