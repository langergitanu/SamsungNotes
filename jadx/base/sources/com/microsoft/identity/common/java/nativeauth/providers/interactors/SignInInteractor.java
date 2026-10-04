package com.microsoft.identity.common.java.nativeauth.providers.interactors;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthRequestProvider;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthResponseHandler;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInInitiateRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInTokenRequest;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInInitiateApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInTokenApiResult;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.net.UrlConnectionHttpClient;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.microsoft.identity.common.java.util.StringUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0019H\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u001eJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u001fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/SignInInteractor;", "", "httpClient", "Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;", "nativeAuthRequestProvider", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;", "nativeAuthResponseHandler", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;", "(Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;)V", SearchConstants.TargetContents.TAG, "", "performContinuationTokenTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInWithContinuationTokenCommandParameters;", "performGetToken", "requestCorrelationId", "request", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest;", "performOOBTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitCodeCommandParameters;", "performPasswordTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitPasswordCommandParameters;", "performSignInChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInChallengeRequest;", "continuationToken", "correlationId", "performSignInInitiate", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInStartCommandParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInInitiateRequest;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SignInInteractor {

    @NotNull
    private final String TAG;

    @NotNull
    private final UrlConnectionHttpClient httpClient;

    @NotNull
    private final NativeAuthRequestProvider nativeAuthRequestProvider;

    @NotNull
    private final NativeAuthResponseHandler nativeAuthResponseHandler;

    public SignInInteractor(@NotNull UrlConnectionHttpClient httpClient, @NotNull NativeAuthRequestProvider nativeAuthRequestProvider, @NotNull NativeAuthResponseHandler nativeAuthResponseHandler) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(nativeAuthRequestProvider, "nativeAuthRequestProvider");
        Intrinsics.checkNotNullParameter(nativeAuthResponseHandler, "nativeAuthResponseHandler");
        this.httpClient = httpClient;
        this.nativeAuthRequestProvider = nativeAuthRequestProvider;
        this.nativeAuthResponseHandler = nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue("SignInInteractor", "SignInInteractor::class.java.simpleName");
        this.TAG = "SignInInteractor";
    }

    private final SignInTokenApiResult performGetToken(String requestCorrelationId, SignInTokenRequest request) {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, AbstractC0622a.m1170p(this.TAG, ".performGetToken", new StringBuilder()));
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse response = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(response, "response");
        return nativeAuthResponseHandler.getSignInTokenApiResultFromHttpResponse(requestCorrelationId, response);
    }

    @NotNull
    public final SignInTokenApiResult performContinuationTokenTokenRequest(@NotNull SignInWithContinuationTokenCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performContinuationTokenTokenRequest", new StringBuilder()));
        SignInTokenRequest signInTokenRequestCreateContinuationTokenTokenRequest$common4j = this.nativeAuthRequestProvider.createContinuationTokenTokenRequest$common4j(parameters);
        String correlationId = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.getCorrelationId()");
        return performGetToken(correlationId, signInTokenRequestCreateContinuationTokenTokenRequest$common4j);
    }

    @NotNull
    public final SignInTokenApiResult performOOBTokenRequest(@NotNull SignInSubmitCodeCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performOOBTokenRequest", new StringBuilder()));
        SignInTokenRequest signInTokenRequestCreateOOBTokenRequest$common4j = this.nativeAuthRequestProvider.createOOBTokenRequest$common4j(parameters);
        String correlationId = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.getCorrelationId()");
        return performGetToken(correlationId, signInTokenRequestCreateOOBTokenRequest$common4j);
    }

    @NotNull
    public final SignInTokenApiResult performPasswordTokenRequest(@NotNull SignInSubmitPasswordCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performPasswordTokenRequest", new StringBuilder()));
        SignInTokenRequest signInTokenRequestCreatePasswordTokenRequest$common4j = this.nativeAuthRequestProvider.createPasswordTokenRequest$common4j(parameters);
        try {
            String correlationId = parameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.getCorrelationId()");
            return performGetToken(correlationId, signInTokenRequestCreatePasswordTokenRequest$common4j);
        } finally {
            StringUtil.overwriteWithNull(signInTokenRequestCreatePasswordTokenRequest$common4j.getParameters().getPassword());
        }
    }

    @NotNull
    public final SignInChallengeApiResult performSignInChallenge(@NotNull String continuationToken, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.INSTANCE.logMethodCall(this.TAG, correlationId, AbstractC0622a.m1170p(this.TAG, ".performSignInChallenge(continuationToken: String)", new StringBuilder()));
        return performSignInChallenge(correlationId, this.nativeAuthRequestProvider.createSignInChallengeRequest$common4j(continuationToken, correlationId));
    }

    @NotNull
    public final SignInInitiateApiResult performSignInInitiate(@NotNull SignInStartCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performSignInInitiate(parameters: SignInStartCommandParameters)", new StringBuilder()));
        SignInInitiateRequest signInInitiateRequestCreateSignInInitiateRequest$common4j = this.nativeAuthRequestProvider.createSignInInitiateRequest$common4j(parameters);
        String correlationId = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.getCorrelationId()");
        return performSignInInitiate(correlationId, signInInitiateRequestCreateSignInInitiateRequest$common4j);
    }

    private final SignInChallengeApiResult performSignInChallenge(String requestCorrelationId, SignInChallengeRequest request) {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, AbstractC0622a.m1170p(this.TAG, ".performSignInChallenge", new StringBuilder()));
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse response = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(response, "response");
        return nativeAuthResponseHandler.getSignInChallengeResultFromHttpResponse(requestCorrelationId, response).toResult();
    }

    private final SignInInitiateApiResult performSignInInitiate(String requestCorrelationId, SignInInitiateRequest request) {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, AbstractC0622a.m1170p(this.TAG, ".performSignInInitiate", new StringBuilder()));
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse response = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(response, "response");
        return nativeAuthResponseHandler.getSignInInitiateResultFromHttpResponse(requestCorrelationId, response).toResult();
    }
}
