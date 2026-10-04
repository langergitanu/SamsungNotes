package com.google.api.client.auth.oauth;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public final class OAuthCredentialsResponse {

    @Key("oauth_callback_confirmed")
    public Boolean callbackConfirmed;

    @Key("oauth_token")
    public String token;

    @Key("oauth_token_secret")
    public String tokenSecret;
}
