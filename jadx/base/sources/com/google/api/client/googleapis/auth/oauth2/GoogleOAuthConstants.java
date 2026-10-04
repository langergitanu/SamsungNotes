package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.util.Beta;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class GoogleOAuthConstants {
    public static final String AUTHORIZATION_SERVER_URL = "https://accounts.google.com/o/oauth2/auth";

    @Beta
    public static final String DEFAULT_PUBLIC_CERTS_ENCODED_URL = "https://www.googleapis.com/oauth2/v1/certs";
    public static final String OOB_REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
    public static final String TOKEN_SERVER_URL = "https://accounts.google.com/o/oauth2/token";

    private GoogleOAuthConstants() {
    }
}
