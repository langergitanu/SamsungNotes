package com.microsoft.identity.common.java.nativeauth.providers;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordChallengeApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordContinueApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordPollCompletionApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordStartApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordSubmitApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInChallengeApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInInitiateApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInTokenApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInTokenApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpChallengeApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpContinueApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpStartApiResponse;
import com.microsoft.identity.common.java.nativeauth.util.ApiResultUtil;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;", "", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "getResetPasswordChallengeApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordChallengeApiResponse;", "requestCorrelationId", "response", "Lcom/microsoft/identity/common/java/net/HttpResponse;", "getResetPasswordContinueApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResponse;", "getResetPasswordPollCompletionApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordPollCompletionApiResponse;", "getResetPasswordStartApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordStartApiResponse;", "getResetPasswordSubmitApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordSubmitApiResponse;", "getSignInChallengeResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResponse;", "getSignInInitiateResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResponse;", "getSignInTokenApiResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "getSignUpChallengeResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpChallengeApiResponse;", "getSignUpContinueResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResponse;", "getSignUpStartResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResponse;", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NativeAuthResponseHandler {

    @NotNull
    public static final String EMPTY_RESPONSE_ERROR = "empty_response_error";

    @NotNull
    public static final String EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION = "API response body is empty";
    private final String TAG = "NativeAuthResponseHandler";

    @NotNull
    public final ResetPasswordChallengeApiResponse getResetPasswordChallengeApiResponseFromHttpResponse(@NotNull String requestCorrelationId, @NotNull HttpResponse response) {
        String str;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = this.TAG;
        companion.logMethodCall(str2, null, AbstractC0622a.m1170p(this.TAG, ".getResetPasswordChallengeApiResponseFromHttpResponse", AbstractC1974b.m1325r(str2, SearchConstants.TargetContents.TAG)));
        String headerValue = response.getHeaderValue("client-request-id", 0);
        if (headerValue == null || StringsKt.isBlank(headerValue)) {
            str = requestCorrelationId;
        } else {
            Intrinsics.checkNotNullExpressionValue(headerValue, "{\n                respon…rrelationId\n            }");
            str = headerValue;
        }
        String body = response.getBody();
        ResetPasswordChallengeApiResponse result = (body == null || StringsKt.isBlank(body)) ? new ResetPasswordChallengeApiResponse(response.getStatusCode(), str, null, null, null, null, null, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null) : (ResetPasswordChallengeApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), ResetPasswordChallengeApiResponse.class);
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(str);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG, result);
        return result;
    }

    @NotNull
    public final ResetPasswordContinueApiResponse getResetPasswordContinueApiResponseFromHttpResponse(@NotNull String requestCorrelationId, @NotNull HttpResponse response) {
        String str;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = this.TAG;
        companion.logMethodCall(str2, null, AbstractC0622a.m1170p(this.TAG, ".getResetPasswordContinueApiResponseFromHttpResponse", AbstractC1974b.m1325r(str2, SearchConstants.TargetContents.TAG)));
        String headerValue = response.getHeaderValue("client-request-id", 0);
        if (headerValue == null || StringsKt.isBlank(headerValue)) {
            str = requestCorrelationId;
        } else {
            Intrinsics.checkNotNullExpressionValue(headerValue, "{\n                respon…rrelationId\n            }");
            str = headerValue;
        }
        String body = response.getBody();
        ResetPasswordContinueApiResponse result = (body == null || StringsKt.isBlank(body)) ? new ResetPasswordContinueApiResponse(response.getStatusCode(), str, null, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null) : (ResetPasswordContinueApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), ResetPasswordContinueApiResponse.class);
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(str);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG, result);
        return result;
    }

    @NotNull
    public final ResetPasswordPollCompletionApiResponse getResetPasswordPollCompletionApiResponseFromHttpResponse(@NotNull String requestCorrelationId, @NotNull HttpResponse response) {
        String str;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = this.TAG;
        companion.logMethodCall(str2, null, AbstractC0622a.m1170p(this.TAG, ".getResetPasswordPollCompletionApiResponseFromHttpResponse", AbstractC1974b.m1325r(str2, SearchConstants.TargetContents.TAG)));
        String headerValue = response.getHeaderValue("client-request-id", 0);
        if (headerValue == null || StringsKt.isBlank(headerValue)) {
            str = requestCorrelationId;
        } else {
            Intrinsics.checkNotNullExpressionValue(headerValue, "{\n                respon…rrelationId\n            }");
            str = headerValue;
        }
        String body = response.getBody();
        ResetPasswordPollCompletionApiResponse result = (body == null || StringsKt.isBlank(body)) ? new ResetPasswordPollCompletionApiResponse(response.getStatusCode(), str, null, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null) : (ResetPasswordPollCompletionApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), ResetPasswordPollCompletionApiResponse.class);
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(str);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG, result);
        return result;
    }

    @NotNull
    public final ResetPasswordStartApiResponse getResetPasswordStartApiResponseFromHttpResponse(@NotNull String requestCorrelationId, @NotNull HttpResponse response) {
        String str;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = this.TAG;
        companion.logMethodCall(str2, null, AbstractC0622a.m1170p(this.TAG, ".getResetPasswordStartApiResponseFromHttpResponse", AbstractC1974b.m1325r(str2, SearchConstants.TargetContents.TAG)));
        String headerValue = response.getHeaderValue("client-request-id", 0);
        if (headerValue == null || StringsKt.isBlank(headerValue)) {
            str = requestCorrelationId;
        } else {
            Intrinsics.checkNotNullExpressionValue(headerValue, "{\n                respon…rrelationId\n            }");
            str = headerValue;
        }
        String body = response.getBody();
        ResetPasswordStartApiResponse result = (body == null || StringsKt.isBlank(body)) ? new ResetPasswordStartApiResponse(response.getStatusCode(), str, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null) : (ResetPasswordStartApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), ResetPasswordStartApiResponse.class);
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(str);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG, result);
        return result;
    }

    @NotNull
    public final ResetPasswordSubmitApiResponse getResetPasswordSubmitApiResponseFromHttpResponse(@NotNull String requestCorrelationId, @NotNull HttpResponse response) {
        String str;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = this.TAG;
        companion.logMethodCall(str2, null, AbstractC0622a.m1170p(this.TAG, ".getResetPasswordSubmitApiResponseFromHttpResponse", AbstractC1974b.m1325r(str2, SearchConstants.TargetContents.TAG)));
        String headerValue = response.getHeaderValue("client-request-id", 0);
        if (headerValue == null || StringsKt.isBlank(headerValue)) {
            str = requestCorrelationId;
        } else {
            Intrinsics.checkNotNullExpressionValue(headerValue, "{\n                respon…rrelationId\n            }");
            str = headerValue;
        }
        String body = response.getBody();
        ResetPasswordSubmitApiResponse result = (body == null || StringsKt.isBlank(body)) ? new ResetPasswordSubmitApiResponse(response.getStatusCode(), str, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null) : (ResetPasswordSubmitApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), ResetPasswordSubmitApiResponse.class);
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(str);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG, result);
        return result;
    }

    @NotNull
    public final SignInChallengeApiResponse getSignInChallengeResultFromHttpResponse(@NotNull String requestCorrelationId, @NotNull HttpResponse response) {
        String str;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = this.TAG;
        companion.logMethodCall(str2, null, AbstractC0622a.m1170p(this.TAG, ".getSignInChallengeResultFromHttpResponse", AbstractC1974b.m1325r(str2, SearchConstants.TargetContents.TAG)));
        String headerValue = response.getHeaderValue("client-request-id", 0);
        if (headerValue == null || StringsKt.isBlank(headerValue)) {
            str = requestCorrelationId;
        } else {
            Intrinsics.checkNotNullExpressionValue(headerValue, "{\n                respon…rrelationId\n            }");
            str = headerValue;
        }
        String body = response.getBody();
        SignInChallengeApiResponse result = (body == null || StringsKt.isBlank(body)) ? new SignInChallengeApiResponse(response.getStatusCode(), str, null, null, null, null, null, null, null, EMPTY_RESPONSE_ERROR, null, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null) : (SignInChallengeApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignInChallengeApiResponse.class);
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(str);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG, result);
        return result;
    }

    @NotNull
    public final SignInInitiateApiResponse getSignInInitiateResultFromHttpResponse(@NotNull String requestCorrelationId, @NotNull HttpResponse response) {
        String str;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = this.TAG;
        companion.logMethodCall(str2, null, AbstractC0622a.m1170p(this.TAG, ".getSignInInitiateResultFromHttpResponse", AbstractC1974b.m1325r(str2, SearchConstants.TargetContents.TAG)));
        String headerValue = response.getHeaderValue("client-request-id", 0);
        if (headerValue == null || StringsKt.isBlank(headerValue)) {
            str = requestCorrelationId;
        } else {
            Intrinsics.checkNotNullExpressionValue(headerValue, "{\n                respon…rrelationId\n            }");
            str = headerValue;
        }
        String body = response.getBody();
        SignInInitiateApiResponse result = (body == null || StringsKt.isBlank(body)) ? new SignInInitiateApiResponse(response.getStatusCode(), str, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null) : (SignInInitiateApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignInInitiateApiResponse.class);
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(str);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG, result);
        return result;
    }

    @NotNull
    public final SignInTokenApiResult getSignInTokenApiResultFromHttpResponse(@NotNull String requestCorrelationId, @NotNull HttpResponse response) {
        String str;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = this.TAG;
        companion.logMethodCall(str2, null, AbstractC0622a.m1170p(this.TAG, ".getSignInTokenApiResultFromHttpResponse", AbstractC1974b.m1325r(str2, SearchConstants.TargetContents.TAG)));
        String headerValue = response.getHeaderValue("client-request-id", 0);
        if (headerValue == null || StringsKt.isBlank(headerValue)) {
            str = requestCorrelationId;
        } else {
            Intrinsics.checkNotNullExpressionValue(headerValue, "{\n                respon…rrelationId\n            }");
            str = headerValue;
        }
        if (response.getStatusCode() < 400) {
            MicrosoftStsTokenResponse apiResponse = (MicrosoftStsTokenResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), MicrosoftStsTokenResponse.class);
            Intrinsics.checkNotNullExpressionValue(apiResponse, "apiResponse");
            return new SignInTokenApiResult.Success(str, apiResponse);
        }
        String body = response.getBody();
        SignInTokenApiResponse apiResponse2 = (body == null || StringsKt.isBlank(body)) ? new SignInTokenApiResponse(response.getStatusCode(), str, null, null, null, null, null, null) : (SignInTokenApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignInTokenApiResponse.class);
        apiResponse2.setStatusCode(response.getStatusCode());
        apiResponse2.setCorrelationId$common4j(str);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.checkNotNullExpressionValue(apiResponse2, "apiResponse");
        apiResultUtil.logResponse(TAG, apiResponse2);
        return apiResponse2.toErrorResult();
    }

    @NotNull
    public final SignUpChallengeApiResponse getSignUpChallengeResultFromHttpResponse(@NotNull String requestCorrelationId, @NotNull HttpResponse response) {
        String str;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = this.TAG;
        companion.logMethodCall(str2, null, AbstractC0622a.m1170p(this.TAG, ".getSignUpChallengeResultFromHttpResponse", AbstractC1974b.m1325r(str2, SearchConstants.TargetContents.TAG)));
        String headerValue = response.getHeaderValue("client-request-id", 0);
        if (headerValue == null || StringsKt.isBlank(headerValue)) {
            str = requestCorrelationId;
        } else {
            Intrinsics.checkNotNullExpressionValue(headerValue, "{\n                respon…rrelationId\n            }");
            str = headerValue;
        }
        String body = response.getBody();
        SignUpChallengeApiResponse result = (body == null || StringsKt.isBlank(body)) ? new SignUpChallengeApiResponse(response.getStatusCode(), str, null, null, null, null, null, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION) : (SignUpChallengeApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignUpChallengeApiResponse.class);
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(str);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG, result);
        return result;
    }

    @NotNull
    public final SignUpContinueApiResponse getSignUpContinueResultFromHttpResponse(@NotNull String requestCorrelationId, @NotNull HttpResponse response) {
        String str;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = this.TAG;
        companion.logMethodCall(str2, null, AbstractC0622a.m1170p(this.TAG, ".getSignUpContinueResultFromHttpResponse", AbstractC1974b.m1325r(str2, SearchConstants.TargetContents.TAG)));
        String headerValue = response.getHeaderValue("client-request-id", 0);
        if (headerValue == null || StringsKt.isBlank(headerValue)) {
            str = requestCorrelationId;
        } else {
            Intrinsics.checkNotNullExpressionValue(headerValue, "{\n                respon…rrelationId\n            }");
            str = headerValue;
        }
        String body = response.getBody();
        SignUpContinueApiResponse result = (body == null || StringsKt.isBlank(body)) ? new SignUpContinueApiResponse(response.getStatusCode(), str, null, null, null, null, null, EMPTY_RESPONSE_ERROR, null, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null) : (SignUpContinueApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignUpContinueApiResponse.class);
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(str);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG, result);
        return result;
    }

    @NotNull
    public final SignUpStartApiResponse getSignUpStartResultFromHttpResponse(@NotNull String requestCorrelationId, @NotNull HttpResponse response) {
        String str;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = this.TAG;
        companion.logMethodCall(str2, null, AbstractC0622a.m1170p(this.TAG, ".getSignUpStartResultFromHttpResponse", AbstractC1974b.m1325r(str2, SearchConstants.TargetContents.TAG)));
        String headerValue = response.getHeaderValue("client-request-id", 0);
        if (headerValue == null || StringsKt.isBlank(headerValue)) {
            str = requestCorrelationId;
        } else {
            Intrinsics.checkNotNullExpressionValue(headerValue, "{\n                respon…rrelationId\n            }");
            str = headerValue;
        }
        String body = response.getBody();
        SignUpStartApiResponse result = (body == null || StringsKt.isBlank(body)) ? new SignUpStartApiResponse(response.getStatusCode(), str, null, null, null, null, EMPTY_RESPONSE_ERROR, null, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null) : (SignUpStartApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignUpStartApiResponse.class);
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(str);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG, result);
        return result;
    }
}
