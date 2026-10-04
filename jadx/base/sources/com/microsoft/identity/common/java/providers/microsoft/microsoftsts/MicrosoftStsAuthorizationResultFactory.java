package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationStatus;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.UrlUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.net.URI;
import java.util.Map;
import lombok.NonNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftStsAuthorizationResultFactory extends AuthorizationResultFactory<MicrosoftStsAuthorizationResult, MicrosoftStsAuthorizationRequest> {
    private static final String TAG = "MicrosoftStsAuthorizationResultFactory";

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory
    public /* bridge */ /* synthetic */ AuthorizationResult validateAndCreateAuthorizationResult(@NonNull Map map, @Nullable String str, @Nullable String str2) {
        return validateAndCreateAuthorizationResult((Map<String, String>) map, str, str2);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory
    public MicrosoftStsAuthorizationResult createAuthorizationResultWithErrorResponse(AuthorizationStatus authorizationStatus, @NonNull String str, @Nullable String str2) {
        if (str == null) {
            throw new NullPointerException("error is marked non-null but is null");
        }
        String str3 = TAG + ":createAuthorizationResultWithErrorResponse";
        Logger.info(str3, "Error is returned from webview redirect");
        Logger.infoPII(str3, "error: " + str + " errorDescription: " + str2);
        return new MicrosoftStsAuthorizationResult(authorizationStatus, new MicrosoftStsAuthorizationErrorResponse(str, str2));
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory
    public MicrosoftStsAuthorizationResult parseRedirectUriAndCreateAuthorizationResult(@NonNull URI uri, @Nullable String str) {
        if (uri == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":parseUrlAndCreateAuthorizationResponse", new StringBuilder());
        Map<String, String> parameters = UrlUtil.getParameters(uri);
        if (!parameters.isEmpty()) {
            return parameters.containsKey("code") ? validateAndCreateAuthorizationResult(parameters, str, (String) null) : parameters.containsKey("error") ? createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, parameters.get("error"), parameters.get("error_subcode"), parameters.get("error_description")) : createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_FAILED, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_SERVER_INVALID_RESPONSE);
        }
        Logger.warn(strM1170p, "Invalid server response, empty query string from the webview redirect.");
        return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_FAILED, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_SERVER_INVALID_RESPONSE);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory
    public MicrosoftStsAuthorizationResult validateAndCreateAuthorizationResult(@NonNull Map<String, String> map, @Nullable String str, @Nullable String str2) {
        if (map == null) {
            throw new NullPointerException("urlParameters is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":validateAndCreateAuthorizationResult", new StringBuilder());
        String str3 = map.get("state");
        String str4 = map.get("code");
        if (StringUtil.isNullOrEmpty(str3)) {
            Logger.warn(strM1170p, "State parameter is not returned from the webview redirect.");
            return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "state_mismatch", MicrosoftAuthorizationErrorResponse.STATE_NOT_RETURNED);
        }
        if (StringUtil.isNullOrEmpty(str) || !str.equals(str3)) {
            Logger.warn(strM1170p, "State parameter returned from the redirect is not same as the one sent in request.");
            return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "state_mismatch", MicrosoftAuthorizationErrorResponse.STATE_NOT_THE_SAME);
        }
        Logger.info(strM1170p, "Auth code is successfully returned from webview redirect.");
        return new MicrosoftStsAuthorizationResult(AuthorizationStatus.SUCCESS, new MicrosoftStsAuthorizationResponse(str4, str3, map));
    }

    private MicrosoftStsAuthorizationResult createAuthorizationResultWithErrorResponse(AuthorizationStatus authorizationStatus, String str, String str2, String str3) {
        String str4 = TAG + ":createAuthorizationResultWithErrorResponse";
        Logger.info(str4, "Error is returned from webview redirect");
        StringBuilder sbM16m = AbstractC0000a.m16m("error: ", str, "error subcode:", str2, " errorDescription: ");
        sbM16m.append(str3);
        Logger.infoPII(str4, sbM16m.toString());
        return new MicrosoftStsAuthorizationResult(authorizationStatus, new MicrosoftStsAuthorizationErrorResponse(str, str2, str3));
    }
}
