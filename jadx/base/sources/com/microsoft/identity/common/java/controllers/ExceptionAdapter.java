package com.microsoft.identity.common.java.controllers;

import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.gson.JsonSyntaxException;
import com.microsoft.identity.common.java.commands.parameters.BrokerInteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.BrokerSilentTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.constants.OAuth2ErrorCode;
import com.microsoft.identity.common.java.constants.OAuth2SubErrorCode;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.DeviceRegistrationRequiredException;
import com.microsoft.identity.common.java.exception.IntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.exception.TerminalException;
import com.microsoft.identity.common.java.exception.UiRequiredException;
import com.microsoft.identity.common.java.exception.UserCancelException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationStatus;
import com.microsoft.identity.common.java.providers.oauth2.TokenErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.telemetry.CliTelemInfo;
import com.microsoft.identity.common.java.util.HeaderSerializationUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import lombok.NonNull;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ExceptionAdapter {
    private static final String TAG = "ExceptionAdapter";

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.controllers.ExceptionAdapter$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C63861 {

        /* JADX INFO: renamed from: $SwitchMap$com$microsoft$identity$common$java$providers$oauth2$AuthorizationStatus */
        static final /* synthetic */ int[] f3593x2595e97a;

        static {
            int[] iArr = new int[AuthorizationStatus.values().length];
            f3593x2595e97a = iArr;
            try {
                iArr[AuthorizationStatus.FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3593x2595e97a[AuthorizationStatus.SDK_CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3593x2595e97a[AuthorizationStatus.USER_CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void applyCliTelemInfo(@Nullable CliTelemInfo cliTelemInfo, @NonNull BaseException baseException) {
        if (baseException == null) {
            throw new NullPointerException("outErr is marked non-null but is null");
        }
        if (cliTelemInfo != null) {
            baseException.setSpeRing(cliTelemInfo.getSpeRing());
            baseException.setRefreshTokenAge(cliTelemInfo.getRefreshTokenAge());
            baseException.setCliTelemErrorCode(cliTelemInfo.getServerErrorCode());
            baseException.setCliTelemSubErrorCode(cliTelemInfo.getServerSubErrorCode());
        }
    }

    public static BaseException baseExceptionFromException(Throwable th) {
        if (th instanceof ExecutionException) {
            th = th.getCause();
        }
        return th instanceof BaseException ? (BaseException) th : clientExceptionFromException(th);
    }

    @NonNull
    public static ClientException clientExceptionFromException(@NonNull Throwable th) {
        if (th == null) {
            throw new NullPointerException("exception is marked non-null but is null");
        }
        if (th instanceof ClientException) {
            return (ClientException) th;
        }
        Throwable cause = th instanceof ExecutionException ? th.getCause() : th;
        if (!(cause instanceof TerminalException)) {
            if (!(cause instanceof IOException)) {
                return cause instanceof InterruptedException ? new ClientException(ClientException.INTERRUPTED_OPERATION, "SDK cancelled operation, the thread execution was interrupted", cause) : new ClientException("unknown_error", cause.getMessage(), cause);
            }
            return new ClientException("io_error", "An IO error occurred with message: " + cause.getMessage(), cause);
        }
        String errorCode = ((TerminalException) cause).getErrorCode();
        Throwable cause2 = th.getCause();
        if (cause2 != null) {
            cause = cause2;
        }
        return new ClientException(errorCode, "An unhandled exception occurred with message: " + cause.getMessage(), cause);
    }

    public static ServiceException convertToNativeAuthException(@NonNull ServiceException serviceException) {
        if (serviceException == null) {
            throw new NullPointerException("exception is marked non-null but is null");
        }
        ServiceException serviceException2 = new ServiceException(serviceException.getErrorCode(), "Token request failed. Please perform sign-in.\nOriginal exception details: " + serviceException.getMessage(), serviceException.getHttpStatusCode(), serviceException);
        serviceException2.setOauthSubErrorCode(serviceException.getOAuthSubErrorCode());
        serviceException2.setHttpResponseHeaders(serviceException.getHttpResponseHeaders());
        serviceException2.setHttpResponseBody(serviceException.getHttpResponseBody());
        return serviceException2;
    }

    @Nullable
    public static BaseException exceptionFromAcquireTokenResult(AcquireTokenResult acquireTokenResult, CommandParameters commandParameters) {
        AuthorizationResult authorizationResult = acquireTokenResult.getAuthorizationResult();
        if (authorizationResult == null) {
            AbstractC4539a.m3189C(new StringBuilder(), TAG, ":exceptionFromAcquireTokenResult", "AuthorizationResult was null -- expected for ATS cases.");
        } else if (!authorizationResult.getSuccess()) {
            return exceptionFromAuthorizationResult(authorizationResult, commandParameters);
        }
        return exceptionFromTokenResult(acquireTokenResult.getTokenResult(), commandParameters);
    }

    public static BaseException exceptionFromAuthorizationResult(@NonNull AuthorizationResult authorizationResult, @Nullable CommandParameters commandParameters) {
        if (authorizationResult == null) {
            throw new NullPointerException("authorizationResult is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":exceptionFromAuthorizationResult", new StringBuilder());
        AuthorizationErrorResponse authorizationErrorResponse = authorizationResult.getAuthorizationErrorResponse();
        if (authorizationErrorResponse == null) {
            Logger.warn(strM1170p, "AuthorizationErrorResponse is not set");
            return new ClientException("unknown_error", "Authorization failed with unknown error. Authorization Status: " + authorizationResult.getAuthorizationStatus());
        }
        int i = C63861.f3593x2595e97a[authorizationResult.getAuthorizationStatus().ordinal()];
        if (i == 1) {
            if (authorizationErrorResponse instanceof MicrosoftAuthorizationErrorResponse) {
                MicrosoftAuthorizationErrorResponse microsoftAuthorizationErrorResponse = (MicrosoftAuthorizationErrorResponse) authorizationErrorResponse;
                if (microsoftAuthorizationErrorResponse.getError().equals(MicrosoftAuthorizationErrorResponse.DEVICE_REGISTRATION_NEEDED)) {
                    return new DeviceRegistrationRequiredException(microsoftAuthorizationErrorResponse.getError(), microsoftAuthorizationErrorResponse.getErrorDescription(), microsoftAuthorizationErrorResponse.getUpnToWpj());
                }
            }
            return new ServiceException(authorizationErrorResponse.getError(), authorizationErrorResponse.getErrorDescription(), 0, null);
        }
        if (i == 2) {
            return new ClientException(authorizationErrorResponse.getError(), authorizationErrorResponse.getErrorDescription());
        }
        if (i == 3) {
            return new UserCancelException();
        }
        Logger.warn(strM1170p, "No AuthorizationResult status set");
        return new ClientException(authorizationErrorResponse.getError(), authorizationErrorResponse.getErrorDescription());
    }

    public static ServiceException exceptionFromTokenResult(TokenResult tokenResult, CommandParameters commandParameters) {
        if (tokenResult != null && !tokenResult.getSuccess() && tokenResult.getErrorResponse() != null && !StringUtil.isNullOrEmpty(tokenResult.getErrorResponse().getError())) {
            ServiceException exceptionFromTokenErrorResponse = getExceptionFromTokenErrorResponse(commandParameters, tokenResult.getErrorResponse());
            applyCliTelemInfo(tokenResult.getCliTelemInfo(), exceptionFromTokenErrorResponse);
            return exceptionFromTokenErrorResponse;
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":exceptionFromTokenResult", new StringBuilder());
        StringBuilder sb = new StringBuilder("Unknown error, Token result is null [");
        sb.append(tokenResult == null);
        sb.append("]");
        Logger.warn(strM1170p, sb.toString());
        return new ServiceException("unknown_error", "Request failed, but no error returned back from service.", null);
    }

    public static ServiceException getExceptionFromTokenErrorResponse(@NonNull TokenErrorResponse tokenErrorResponse) {
        if (tokenErrorResponse == null) {
            throw new NullPointerException("errorResponse is marked non-null but is null");
        }
        ServiceException uiRequiredException = shouldBeConvertedToUiRequiredException(tokenErrorResponse.getError()) ? new UiRequiredException(tokenErrorResponse.getError(), tokenErrorResponse.getErrorDescription()) : new ServiceException(tokenErrorResponse.getError(), tokenErrorResponse.getErrorDescription(), null);
        uiRequiredException.setOauthSubErrorCode(tokenErrorResponse.getSubError());
        setHttpResponseUsingTokenErrorResponse(uiRequiredException, tokenErrorResponse);
        return uiRequiredException;
    }

    private static boolean isBrokerTokenCommandParameters(CommandParameters commandParameters) {
        return (commandParameters instanceof BrokerSilentTokenCommandParameters) || (commandParameters instanceof BrokerInteractiveTokenCommandParameters);
    }

    private static boolean isIntunePolicyRequiredError(@NonNull TokenErrorResponse tokenErrorResponse) {
        if (tokenErrorResponse != null) {
            return !StringUtil.isNullOrEmpty(tokenErrorResponse.getError()) && !StringUtil.isNullOrEmpty(tokenErrorResponse.getSubError()) && tokenErrorResponse.getError().equalsIgnoreCase("unauthorized_client") && tokenErrorResponse.getSubError().equalsIgnoreCase(OAuth2SubErrorCode.PROTECTION_POLICY_REQUIRED);
        }
        throw new NullPointerException("errorResponse is marked non-null but is null");
    }

    private static void setHttpResponseUsingTokenErrorResponse(@NonNull ServiceException serviceException, @NonNull TokenErrorResponse tokenErrorResponse) {
        if (serviceException == null) {
            throw new NullPointerException("exception is marked non-null but is null");
        }
        if (tokenErrorResponse == null) {
            throw new NullPointerException("errorResponse is marked non-null but is null");
        }
        try {
            serviceException.setHttpResponse(synthesizeHttpResponse(tokenErrorResponse.getStatusCode(), tokenErrorResponse.getResponseHeadersJson(), tokenErrorResponse.getResponseBody()));
        } catch (JSONException unused) {
            Logger.warn(TAG, "Failed to deserialize error data: status, headers, response body.");
        }
    }

    private static boolean shouldBeConvertedToUiRequiredException(String str) {
        return "invalid_grant".equalsIgnoreCase(str) || OAuth2ErrorCode.INTERACTION_REQUIRED.equalsIgnoreCase(str);
    }

    private static HttpResponse synthesizeHttpResponse(int i, @Nullable String str, @Nullable String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        try {
            return new HttpResponse(i, str2, HeaderSerializationUtil.fromJson(str));
        } catch (JsonSyntaxException unused) {
            AbstractC4539a.m3189C(new StringBuilder(), TAG, ":applyHttpErrorResponseData", "Failed to deserialize error data: status, headers, response body.");
            return null;
        }
    }

    @SuppressFBWarnings({"BC_UNCONFIRMED_CAST"})
    public static ServiceException getExceptionFromTokenErrorResponse(@Nullable CommandParameters commandParameters, @NonNull TokenErrorResponse tokenErrorResponse) {
        IntuneAppProtectionPolicyRequiredException intuneAppProtectionPolicyRequiredException;
        if (tokenErrorResponse != null) {
            if (isIntunePolicyRequiredError(tokenErrorResponse)) {
                if (commandParameters != null && isBrokerTokenCommandParameters(commandParameters)) {
                    if (commandParameters instanceof BrokerInteractiveTokenCommandParameters) {
                        intuneAppProtectionPolicyRequiredException = new IntuneAppProtectionPolicyRequiredException(tokenErrorResponse.getError(), tokenErrorResponse.getErrorDescription(), (BrokerInteractiveTokenCommandParameters) commandParameters);
                    } else {
                        intuneAppProtectionPolicyRequiredException = new IntuneAppProtectionPolicyRequiredException(tokenErrorResponse.getError(), tokenErrorResponse.getErrorDescription(), (BrokerSilentTokenCommandParameters) commandParameters);
                    }
                    intuneAppProtectionPolicyRequiredException.setOauthSubErrorCode(tokenErrorResponse.getSubError());
                    setHttpResponseUsingTokenErrorResponse(intuneAppProtectionPolicyRequiredException, tokenErrorResponse);
                    return intuneAppProtectionPolicyRequiredException;
                }
                Logger.warn(TAG, "In order to properly construct the IntuneAppProtectionPolicyRequiredException we need the command parameters to be supplied.  Returning as service exception instead.");
                return getExceptionFromTokenErrorResponse(tokenErrorResponse);
            }
            return getExceptionFromTokenErrorResponse(tokenErrorResponse);
        }
        throw new NullPointerException("errorResponse is marked non-null but is null");
    }
}
