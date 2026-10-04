package com.microsoft.identity.common.internal.p131ui.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.internal.providers.oauth2.AndroidAuthorizationStrategy;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationActivityFactory;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.p132ui.AuthorizationAgent;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.logging.Logger;
import java.net.URI;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class EmbeddedWebViewAuthorizationStrategy<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest> extends AndroidAuthorizationStrategy<GenericOAuth2Strategy, GenericAuthorizationRequest> {
    private static final String TAG = "EmbeddedWebViewAuthorizationStrategy";
    private GenericAuthorizationRequest mAuthorizationRequest;
    private ResultFuture<AuthorizationResult> mAuthorizationResultFuture;
    private GenericOAuth2Strategy mOAuth2Strategy;

    public EmbeddedWebViewAuthorizationStrategy(@NonNull Context context, @NonNull Activity activity, @Nullable Fragment fragment) {
        super(context, activity, fragment);
    }

    private Intent buildAuthorizationActivityStartIntent(URI uri) {
        return AuthorizationActivityFactory.getAuthorizationActivityIntent(getApplicationContext(), null, uri.toString(), this.mAuthorizationRequest.getBrkRedirectUri() != null ? this.mAuthorizationRequest.getBrkRedirectUri() : this.mAuthorizationRequest.getRedirectUri(), this.mAuthorizationRequest.getRequestHeaders(), AuthorizationAgent.WEBVIEW, this.mAuthorizationRequest.isWebViewZoomEnabled(), this.mAuthorizationRequest.isWebViewZoomControlsEnabled());
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy
    public void completeAuthorization(int i, @NonNull RawAuthorizationResult rawAuthorizationResult) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":completeAuthorization", new StringBuilder());
        if (i != 1001) {
            Logger.warnPII(strM1170p, "Unknown request code " + i);
            return;
        }
        GenericOAuth2Strategy genericoauth2strategy = this.mOAuth2Strategy;
        if (genericoauth2strategy != null && this.mAuthorizationResultFuture != null) {
            this.mAuthorizationResultFuture.setResult(genericoauth2strategy.getAuthorizationResultFactory().createAuthorizationResult(rawAuthorizationResult, this.mAuthorizationRequest));
            return;
        }
        StringBuilder sb = new StringBuilder("SDK Cancel triggering before request is sent out. Potentially due to an stale activity state, oAuth2Strategy null ? [");
        sb.append(this.mOAuth2Strategy == null);
        sb.append("]mAuthorizationResultFuture ? [");
        sb.append(this.mAuthorizationResultFuture == null);
        sb.append("]");
        Logger.warn(strM1170p, sb.toString());
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy
    public Future<AuthorizationResult> requestAuthorization(GenericAuthorizationRequest genericauthorizationrequest, GenericOAuth2Strategy genericoauth2strategy) throws ClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":requestAuthorization", new StringBuilder());
        this.mAuthorizationResultFuture = new ResultFuture<>();
        this.mOAuth2Strategy = genericoauth2strategy;
        this.mAuthorizationRequest = genericauthorizationrequest;
        Logger.info(strM1170p, "Perform the authorization request with embedded webView.");
        launchIntent(buildAuthorizationActivityStartIntent(genericauthorizationrequest.getAuthorizationRequestAsHttpRequest()));
        return this.mAuthorizationResultFuture;
    }
}
