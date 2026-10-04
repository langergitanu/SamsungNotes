package com.microsoft.identity.common.java.providers.oauth2;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.util.UrlUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.net.URI;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AuthorizationResultFactory<GenericAuthorizationResult extends AuthorizationResult, GenericAuthorizationRequest extends AuthorizationRequest> {
    private static final String TAG = "AuthorizationResultFactory";

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C64341 {

        /* JADX INFO: renamed from: $SwitchMap$com$microsoft$identity$common$java$providers$RawAuthorizationResult$ResultCode */
        static final /* synthetic */ int[] f3605x673a98e8;

        static {
            int[] iArr = new int[RawAuthorizationResult.ResultCode.values().length];
            f3605x673a98e8 = iArr;
            try {
                iArr[RawAuthorizationResult.ResultCode.CANCELLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3605x673a98e8[RawAuthorizationResult.ResultCode.SDK_CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3605x673a98e8[RawAuthorizationResult.ResultCode.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3605x673a98e8[RawAuthorizationResult.ResultCode.NON_OAUTH_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3605x673a98e8[RawAuthorizationResult.ResultCode.BROKER_INSTALLATION_TRIGGERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3605x673a98e8[RawAuthorizationResult.ResultCode.DEVICE_REGISTRATION_REQUIRED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3605x673a98e8[RawAuthorizationResult.ResultCode.MDM_FLOW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public GenericAuthorizationResult createAuthorizationResult(@NonNull RawAuthorizationResult rawAuthorizationResult, @NonNull GenericAuthorizationRequest genericauthorizationrequest) {
        if (rawAuthorizationResult == null) {
            throw new NullPointerException("data is marked non-null but is null");
        }
        if (genericauthorizationrequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":createAuthorizationResult", new StringBuilder());
        URI authorizationFinalUri = rawAuthorizationResult.getAuthorizationFinalUri();
        switch (C64341.f3605x673a98e8[rawAuthorizationResult.getResultCode().ordinal()]) {
            case 1:
                Logger.info(strM1170p, null, "The authorization request was intentionally cancelled.");
                return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.USER_CANCEL, MicrosoftAuthorizationErrorResponse.USER_CANCEL, MicrosoftAuthorizationErrorResponse.USER_CANCELLED_FLOW);
            case 2:
                Logger.info(strM1170p, null, "SDK cancelled the authorization request.");
                return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.SDK_CANCEL, MicrosoftAuthorizationErrorResponse.SDK_AUTH_CANCEL, MicrosoftAuthorizationErrorResponse.SDK_CANCELLED_FLOW);
            case 3:
                if (authorizationFinalUri != null) {
                    return (GenericAuthorizationResult) parseRedirectUriAndCreateAuthorizationResult(authorizationFinalUri, genericauthorizationrequest.getState());
                }
                Logger.warn(strM1170p, null, "returned URL is null or empty.");
                return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_FAILED, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_SERVER_INVALID_RESPONSE);
            case 4:
                BaseException exception = rawAuthorizationResult.getException();
                if (exception != null) {
                    return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, exception.getErrorCode(), exception.getMessage());
                }
                break;
            case 5:
                break;
            case 6:
                Logger.info(strM1170p, "Device Registration needed, need to start WPJ");
                GenericAuthorizationResult genericauthorizationresult = (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.DEVICE_REGISTRATION_NEEDED, MicrosoftAuthorizationErrorResponse.DEVICE_REGISTRATION_NEEDED_ERROR_DESCRIPTION);
                genericauthorizationresult.getAuthorizationErrorResponse().setUpnToWpj(UrlUtil.getParameters(authorizationFinalUri).get("username"));
                return genericauthorizationresult;
            case 7:
                Logger.info(strM1170p, "MDM required. Launching Intune MDM link on browser.");
                return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.DEVICE_NEEDS_TO_BE_MANAGED, MicrosoftAuthorizationErrorResponse.DEVICE_NEEDS_TO_BE_MANAGED_ERROR_DESCRIPTION);
            default:
                return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR, "Unknown result code returned [" + rawAuthorizationResult.getResultCode() + "]");
        }
        Logger.info(strM1170p, "Device needs to have broker installed, we expect the apps to call usback when the broker is installed");
        GenericAuthorizationResult genericauthorizationresult2 = (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.BROKER_NEEDS_TO_BE_INSTALLED, MicrosoftAuthorizationErrorResponse.BROKER_NEEDS_TO_BE_INSTALLED_ERROR_DESCRIPTION);
        genericauthorizationresult2.getAuthorizationErrorResponse().setUpnToWpj(UrlUtil.getParameters(authorizationFinalUri).get("username"));
        return genericauthorizationresult2;
    }

    public abstract GenericAuthorizationResult createAuthorizationResultWithErrorResponse(AuthorizationStatus authorizationStatus, @NonNull String str, @Nullable String str2);

    public abstract GenericAuthorizationResult parseRedirectUriAndCreateAuthorizationResult(@NonNull URI uri, @Nullable String str);

    public abstract GenericAuthorizationResult validateAndCreateAuthorizationResult(@NonNull Map<String, String> map, @Nullable String str, @Nullable String str2);
}
