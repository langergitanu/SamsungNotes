package com.google.api.client.auth.oauth;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedParser;
import com.google.api.client.util.Beta;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public abstract class AbstractOAuthGetToken extends GenericUrl {
    public String consumerKey;
    public OAuthSigner signer;
    public HttpTransport transport;
    protected boolean usePost;

    public AbstractOAuthGetToken(String str) {
        super(str);
    }

    public OAuthParameters createParameters() {
        OAuthParameters oAuthParameters = new OAuthParameters();
        oAuthParameters.consumerKey = this.consumerKey;
        oAuthParameters.signer = this.signer;
        return oAuthParameters;
    }

    public final OAuthCredentialsResponse execute() throws IOException {
        HttpRequest httpRequestBuildRequest = this.transport.createRequestFactory().buildRequest(this.usePost ? "POST" : "GET", this, null);
        createParameters().intercept(httpRequestBuildRequest);
        HttpResponse httpResponseExecute = httpRequestBuildRequest.execute();
        httpResponseExecute.setContentLoggingLimit(0);
        OAuthCredentialsResponse oAuthCredentialsResponse = new OAuthCredentialsResponse();
        UrlEncodedParser.parse(httpResponseExecute.parseAsString(), oAuthCredentialsResponse);
        return oAuthCredentialsResponse;
    }
}
