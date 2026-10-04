package com.microsoft.identity.common.java.nativeauth.providers.interactors;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitUserAttributesCommandParameters;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthRequestProvider;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthResponseHandler;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signup.SignUpChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signup.SignUpContinueRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signup.SignUpStartRequest;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpStartApiResult;
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
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u001fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/SignUpInteractor;", "", "httpClient", "Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;", "nativeAuthRequestProvider", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;", "nativeAuthResponseHandler", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;", "(Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;)V", SearchConstants.TargetContents.TAG, "", "performSignUpChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpChallengeApiResult;", "requestCorrelationId", "request", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpChallengeRequest;", "continuationToken", "correlationId", "performSignUpContinue", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpContinueRequest;", "performSignUpStart", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "commandParameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpStartCommandParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest;", "performSignUpSubmitCode", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitCodeCommandParameters;", "performSignUpSubmitPassword", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitPasswordCommandParameters;", "performSignUpSubmitUserAttributes", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitUserAttributesCommandParameters;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SignUpInteractor {

    @NotNull
    private final String TAG;

    @NotNull
    private final UrlConnectionHttpClient httpClient;

    @NotNull
    private final NativeAuthRequestProvider nativeAuthRequestProvider;

    @NotNull
    private final NativeAuthResponseHandler nativeAuthResponseHandler;

    public SignUpInteractor(@NotNull UrlConnectionHttpClient httpClient, @NotNull NativeAuthRequestProvider nativeAuthRequestProvider, @NotNull NativeAuthResponseHandler nativeAuthResponseHandler) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(nativeAuthRequestProvider, "nativeAuthRequestProvider");
        Intrinsics.checkNotNullParameter(nativeAuthResponseHandler, "nativeAuthResponseHandler");
        this.httpClient = httpClient;
        this.nativeAuthRequestProvider = nativeAuthRequestProvider;
        this.nativeAuthResponseHandler = nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue("SignUpInteractor", "SignUpInteractor::class.java.simpleName");
        this.TAG = "SignUpInteractor";
    }

    private final SignUpContinueApiResult performSignUpContinue(String requestCorrelationId, SignUpContinueRequest request) {
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
        return nativeAuthResponseHandler.getSignUpContinueResultFromHttpResponse(requestCorrelationId, response).toResult();
    }

    @NotNull
    public final SignUpChallengeApiResult performSignUpChallenge(@NotNull String continuationToken, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.INSTANCE.logMethodCall(this.TAG, correlationId, AbstractC0622a.m1170p(this.TAG, ".performSignUpChallenge", new StringBuilder()));
        return performSignUpChallenge(correlationId, this.nativeAuthRequestProvider.createSignUpChallengeRequest$common4j(continuationToken, correlationId));
    }

    @NotNull
    public final SignUpStartApiResult performSignUpStart(@NotNull SignUpStartCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performSignUpStart", new StringBuilder()));
        SignUpStartRequest signUpStartRequestCreateSignUpStartRequest$common4j = this.nativeAuthRequestProvider.createSignUpStartRequest$common4j(commandParameters);
        try {
            String correlationId = commandParameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
            return performSignUpStart(correlationId, signUpStartRequestCreateSignUpStartRequest$common4j);
        } finally {
            StringUtil.overwriteWithNull(signUpStartRequestCreateSignUpStartRequest$common4j.getParameters().getPassword());
        }
    }

    @NotNull
    public final SignUpContinueApiResult performSignUpSubmitCode(@NotNull SignUpSubmitCodeCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        SignUpContinueRequest signUpContinueRequestCreateSignUpSubmitCodeRequest$common4j = this.nativeAuthRequestProvider.createSignUpSubmitCodeRequest$common4j(commandParameters);
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return performSignUpContinue(correlationId, signUpContinueRequestCreateSignUpSubmitCodeRequest$common4j);
    }

    @NotNull
    public final SignUpContinueApiResult performSignUpSubmitPassword(@NotNull SignUpSubmitPasswordCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        SignUpContinueRequest signUpContinueRequestCreateSignUpSubmitPasswordRequest$common4j = this.nativeAuthRequestProvider.createSignUpSubmitPasswordRequest$common4j(commandParameters);
        try {
            String correlationId = commandParameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
            return performSignUpContinue(correlationId, signUpContinueRequestCreateSignUpSubmitPasswordRequest$common4j);
        } finally {
            StringUtil.overwriteWithNull(signUpContinueRequestCreateSignUpSubmitPasswordRequest$common4j.getParameters().getPassword());
        }
    }

    @NotNull
    public final SignUpContinueApiResult performSignUpSubmitUserAttributes(@NotNull SignUpSubmitUserAttributesCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        SignUpContinueRequest signUpContinueRequestCreateSignUpSubmitUserAttributesRequest$common4j = this.nativeAuthRequestProvider.createSignUpSubmitUserAttributesRequest$common4j(commandParameters);
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return performSignUpContinue(correlationId, signUpContinueRequestCreateSignUpSubmitUserAttributesRequest$common4j);
    }

    private final SignUpChallengeApiResult performSignUpChallenge(String requestCorrelationId, SignUpChallengeRequest request) {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, AbstractC0622a.m1170p(this.TAG, ".performSignUpChallenge", new StringBuilder()));
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
        return nativeAuthResponseHandler.getSignUpChallengeResultFromHttpResponse(requestCorrelationId, response).toResult();
    }

    private final SignUpStartApiResult performSignUpStart(String requestCorrelationId, SignUpStartRequest request) {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, AbstractC0622a.m1170p(this.TAG, ".performSignUpStart", new StringBuilder()));
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
        return nativeAuthResponseHandler.getSignUpStartResultFromHttpResponse(requestCorrelationId, response).toResult();
    }
}
