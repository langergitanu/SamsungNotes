package com.microsoft.identity.common.java.nativeauth.providers.interactors;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitNewPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthRequestProvider;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthResponseHandler;
import com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordContinueRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordPollCompletionRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordStartRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordSubmitRequest;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordPollCompletionApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordStartApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordSubmitApiResult;
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
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0019H\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u001cJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\"H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/ResetPasswordInteractor;", "", "httpClient", "Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;", "nativeAuthRequestProvider", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;", "nativeAuthResponseHandler", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;", "(Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;)V", SearchConstants.TargetContents.TAG, "", "performResetPasswordChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordChallengeApiResult;", "requestCorrelationId", "request", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordChallengeRequest;", "continuationToken", "correlationId", "performResetPasswordContinue", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitCodeCommandParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordContinueRequest;", "performResetPasswordPollCompletion", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordPollCompletionApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordPollCompletionRequest;", "performResetPasswordStart", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordStartApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordStartCommandParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest;", "performResetPasswordSubmit", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordSubmitApiResult;", "commandParameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitNewPasswordCommandParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordSubmitRequest;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ResetPasswordInteractor {

    @NotNull
    private final String TAG;

    @NotNull
    private final UrlConnectionHttpClient httpClient;

    @NotNull
    private final NativeAuthRequestProvider nativeAuthRequestProvider;

    @NotNull
    private final NativeAuthResponseHandler nativeAuthResponseHandler;

    public ResetPasswordInteractor(@NotNull UrlConnectionHttpClient httpClient, @NotNull NativeAuthRequestProvider nativeAuthRequestProvider, @NotNull NativeAuthResponseHandler nativeAuthResponseHandler) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(nativeAuthRequestProvider, "nativeAuthRequestProvider");
        Intrinsics.checkNotNullParameter(nativeAuthResponseHandler, "nativeAuthResponseHandler");
        this.httpClient = httpClient;
        this.nativeAuthRequestProvider = nativeAuthRequestProvider;
        this.nativeAuthResponseHandler = nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue("ResetPasswordInteractor", "ResetPasswordInteractor::class.java.simpleName");
        this.TAG = "ResetPasswordInteractor";
    }

    @NotNull
    public final ResetPasswordChallengeApiResult performResetPasswordChallenge(@NotNull String continuationToken, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.INSTANCE.logMethodCall(this.TAG, correlationId, AbstractC0622a.m1170p(this.TAG, ".performResetPasswordChallenge(continuationToken: String)", new StringBuilder()));
        return performResetPasswordChallenge(correlationId, this.nativeAuthRequestProvider.createResetPasswordChallengeRequest$common4j(continuationToken, correlationId));
    }

    @NotNull
    public final ResetPasswordContinueApiResult performResetPasswordContinue(@NotNull ResetPasswordSubmitCodeCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performResetPasswordContinue(parameters: ResetPasswordSubmitCodeCommandParameters)", new StringBuilder()));
        ResetPasswordContinueRequest resetPasswordContinueRequestCreateResetPasswordContinueRequest$common4j = this.nativeAuthRequestProvider.createResetPasswordContinueRequest$common4j(parameters);
        String correlationId = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.getCorrelationId()");
        return performResetPasswordContinue(correlationId, resetPasswordContinueRequestCreateResetPasswordContinueRequest$common4j);
    }

    @NotNull
    public final ResetPasswordPollCompletionApiResult performResetPasswordPollCompletion(@NotNull String continuationToken, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.INSTANCE.logMethodCall(this.TAG, correlationId, AbstractC0622a.m1170p(this.TAG, ".performResetPasswordPollCompletion(continuationToken: String)", new StringBuilder()));
        return performResetPasswordPollCompletion(correlationId, this.nativeAuthRequestProvider.createResetPasswordPollCompletionRequest$common4j(continuationToken, correlationId));
    }

    @NotNull
    public final ResetPasswordStartApiResult performResetPasswordStart(@NotNull ResetPasswordStartCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performResetPasswordStart(parameters: ResetPasswordStartCommandParameters)", new StringBuilder()));
        ResetPasswordStartRequest resetPasswordStartRequestCreateResetPasswordStartRequest$common4j = this.nativeAuthRequestProvider.createResetPasswordStartRequest$common4j(parameters);
        String correlationId = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.getCorrelationId()");
        return performResetPasswordStart(correlationId, resetPasswordStartRequestCreateResetPasswordStartRequest$common4j);
    }

    @NotNull
    public final ResetPasswordSubmitApiResult performResetPasswordSubmit(@NotNull ResetPasswordSubmitNewPasswordCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performResetPasswordSubmit(commandParameters: ResetPasswordSubmitNewPasswordCommandParameters)", new StringBuilder()));
        ResetPasswordSubmitRequest resetPasswordSubmitRequestCreateResetPasswordSubmitRequest$common4j = this.nativeAuthRequestProvider.createResetPasswordSubmitRequest$common4j(commandParameters);
        try {
            String correlationId = commandParameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
            return performResetPasswordSubmit(correlationId, resetPasswordSubmitRequestCreateResetPasswordSubmitRequest$common4j);
        } finally {
            NativeAuthRequest.NativeAuthRequestParameters parameters = resetPasswordSubmitRequestCreateResetPasswordSubmitRequest$common4j.getParameters();
            Intrinsics.checkNotNull(parameters, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordSubmitRequest.NativeAuthResetPasswordSubmitRequestParameters");
            StringUtil.overwriteWithNull(((ResetPasswordSubmitRequest.NativeAuthResetPasswordSubmitRequestParameters) parameters).getNewPassword());
        }
    }

    private final ResetPasswordChallengeApiResult performResetPasswordChallenge(String requestCorrelationId, ResetPasswordChallengeRequest request) {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, AbstractC0622a.m1170p(this.TAG, ".performResetPasswordChallenge", new StringBuilder()));
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse httpResponse = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(httpResponse, "httpResponse");
        return nativeAuthResponseHandler.getResetPasswordChallengeApiResponseFromHttpResponse(requestCorrelationId, httpResponse).toResult();
    }

    private final ResetPasswordPollCompletionApiResult performResetPasswordPollCompletion(String requestCorrelationId, ResetPasswordPollCompletionRequest request) {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, AbstractC0622a.m1170p(this.TAG, ".performResetPasswordPollCompletion", new StringBuilder()));
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse httpResponse = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(httpResponse, "httpResponse");
        return nativeAuthResponseHandler.getResetPasswordPollCompletionApiResponseFromHttpResponse(requestCorrelationId, httpResponse).toResult();
    }

    private final ResetPasswordContinueApiResult performResetPasswordContinue(String requestCorrelationId, ResetPasswordContinueRequest request) {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, AbstractC0622a.m1170p(this.TAG, ".performResetPasswordContinue", new StringBuilder()));
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse httpResponse = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(httpResponse, "httpResponse");
        return nativeAuthResponseHandler.getResetPasswordContinueApiResponseFromHttpResponse(requestCorrelationId, httpResponse).toResult();
    }

    private final ResetPasswordStartApiResult performResetPasswordStart(String requestCorrelationId, ResetPasswordStartRequest request) {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, AbstractC0622a.m1170p(this.TAG, ".performResetPasswordStart", new StringBuilder()));
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse httpResponse = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(httpResponse, "httpResponse");
        return nativeAuthResponseHandler.getResetPasswordStartApiResponseFromHttpResponse(requestCorrelationId, httpResponse).toResult();
    }

    private final ResetPasswordSubmitApiResult performResetPasswordSubmit(String requestCorrelationId, ResetPasswordSubmitRequest request) {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, AbstractC0622a.m1170p(this.TAG, ".performResetPasswordSubmit", new StringBuilder()));
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse httpResponse = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(httpResponse, "httpResponse");
        return nativeAuthResponseHandler.getResetPasswordSubmitApiResponseFromHttpResponse(requestCorrelationId, httpResponse).toResult();
    }
}
