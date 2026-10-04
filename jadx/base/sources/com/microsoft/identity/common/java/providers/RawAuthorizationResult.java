package com.microsoft.identity.common.java.providers;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.UrlUtil;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import com.samsung.android.mcf.continuity.interfaces.ContinuityCommand;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RawAuthorizationResult {
    private static final String TAG = "RawAuthorizationResult";

    @Nullable
    private final URI mAuthorizationFinalUri;

    @Nullable
    private final BaseException mException;
    private final ResultCode mResultCode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RawAuthorizationResultBuilder {
        private URI authorizationFinalUri;
        private BaseException exception;
        private ResultCode resultCode;

        /* JADX INFO: Access modifiers changed from: private */
        public RawAuthorizationResultBuilder authorizationFinalUri(@Nullable URI uri) {
            this.authorizationFinalUri = uri;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RawAuthorizationResult build() {
            return new RawAuthorizationResult(this.resultCode, this.authorizationFinalUri, this.exception);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RawAuthorizationResultBuilder exception(@Nullable BaseException baseException) {
            this.exception = baseException;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RawAuthorizationResultBuilder resultCode(ResultCode resultCode) {
            this.resultCode = resultCode;
            return this;
        }

        public String toString() {
            return "RawAuthorizationResult.RawAuthorizationResultBuilder(resultCode=" + this.resultCode + ", authorizationFinalUri=" + this.authorizationFinalUri + ", exception=" + this.exception + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ResultCode {
        UNKNOWN(-1),
        CANCELLED(2001),
        NON_OAUTH_ERROR(2002),
        COMPLETED(2003),
        BROKER_INSTALLATION_TRIGGERED(ContinuityCommand.CMD_ASYNC_STOP_ADVERTISEMENT),
        DEVICE_REGISTRATION_REQUIRED(ContinuityCommand.CMD_ASYNC_SEND_MESSAGE),
        SDK_CANCELLED(ContinuityCommand.CMD_ASYNC_REGISTER_SIMPLE_MESSAGE_LISTENER),
        MDM_FLOW(ContinuityCommand.CMD_ASYNC_UNREGISTER_SIMPLE_MESSAGE_LISTENER);

        private final int mCode;

        ResultCode(int i) {
            this.mCode = i;
        }

        public static ResultCode fromInteger(@Nullable Integer num) {
            if (num == null) {
                return UNKNOWN;
            }
            for (ResultCode resultCode : values()) {
                if (resultCode.mCode == num.intValue()) {
                    return resultCode;
                }
            }
            return null;
        }
    }

    public RawAuthorizationResult(ResultCode resultCode, @Nullable URI uri, @Nullable BaseException baseException) {
        this.mResultCode = resultCode;
        this.mAuthorizationFinalUri = uri;
        this.mException = baseException;
    }

    private static RawAuthorizationResultBuilder builder() {
        return new RawAuthorizationResultBuilder();
    }

    @NonNull
    public static RawAuthorizationResult fromException(@NonNull BaseException baseException) {
        if (baseException != null) {
            return builder().resultCode(ResultCode.NON_OAUTH_ERROR).exception(baseException).build();
        }
        throw new NullPointerException("e is marked non-null but is null");
    }

    @NonNull
    public static RawAuthorizationResult fromPropertyBag(@NonNull PropertyBag propertyBag) {
        if (propertyBag != null) {
            return builder().resultCode(ResultCode.fromInteger((Integer) propertyBag.get(AuthenticationConstants.LocalBroadcasterFields.RESULT_CODE))).authorizationFinalUri((URI) propertyBag.get("com.microsoft.aad.adal:BrowserFinalUrl")).exception((BaseException) propertyBag.get("com.microsoft.aad.adal:AuthenticationException")).build();
        }
        throw new NullPointerException("propertyBag is marked non-null but is null");
    }

    @NonNull
    public static RawAuthorizationResult fromRedirectUri(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        try {
            URI uri = new URI(str);
            return builder().resultCode(getResultCodeFromFinalRedirectUri(uri)).authorizationFinalUri(uri).build();
        } catch (URISyntaxException e) {
            return fromException(new ClientException("malformed_url", "Failed to parse redirect URL", e));
        }
    }

    @NonNull
    public static RawAuthorizationResult fromResultCode(ResultCode resultCode) {
        if (resultCode != ResultCode.NON_OAUTH_ERROR && resultCode != ResultCode.COMPLETED && resultCode != ResultCode.DEVICE_REGISTRATION_REQUIRED && resultCode != ResultCode.BROKER_INSTALLATION_TRIGGERED) {
            return builder().resultCode(resultCode).build();
        }
        throw new IllegalArgumentException("Result code " + resultCode + " should be set via other factory methods");
    }

    @NonNull
    public static RawAuthorizationResult fromThrowable(@NonNull Throwable th) {
        if (th != null) {
            return th instanceof BaseException ? fromException((BaseException) th) : builder().resultCode(ResultCode.NON_OAUTH_ERROR).exception(new BaseException("unknown_error", "Unknown error with class: ".concat(th.getClass().getSimpleName()), th)).build();
        }
        throw new NullPointerException("e is marked non-null but is null");
    }

    private static ResultCode getResultCodeFromFinalRedirectUri(@NonNull URI uri) {
        if (uri == null) {
            throw new NullPointerException("uri is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, "getResultCodeFromFinalRedirectUri", new StringBuilder());
        Map<String, String> parameters = UrlUtil.getParameters(uri);
        if ("msauth".equalsIgnoreCase(uri.getScheme())) {
            if (parameters.containsKey(AuthenticationConstants.AAD.APP_LINK_KEY)) {
                Logger.info(strM1170p, "Return to caller with BROWSER_CODE_WAIT_FOR_BROKER_INSTALL, and waiting for result.");
                return ResultCode.BROKER_INSTALLATION_TRIGGERED;
            }
            if (AuthenticationConstants.AAD.DEVICE_REGISTRATION_REDIRECT_URI_HOSTNAME.equalsIgnoreCase(uri.getHost())) {
                Logger.info(strM1170p, " Device needs to be registered, sending BROWSER_CODE_DEVICE_REGISTER");
                return ResultCode.DEVICE_REGISTRATION_REQUIRED;
            }
        }
        if (!StringUtil.equalsIgnoreCase(parameters.get("error_subcode"), "cancel")) {
            return ResultCode.COMPLETED;
        }
        Logger.info(strM1170p, "User cancelled the session");
        return ResultCode.CANCELLED;
    }

    @NonNull
    public static PropertyBag toPropertyBag(@NonNull RawAuthorizationResult rawAuthorizationResult) {
        if (rawAuthorizationResult == null) {
            throw new NullPointerException("data is marked non-null but is null");
        }
        PropertyBag propertyBag = new PropertyBag();
        propertyBag.put(AuthenticationConstants.LocalBroadcasterFields.RESULT_CODE, Integer.valueOf(rawAuthorizationResult.mResultCode.mCode));
        propertyBag.put("com.microsoft.aad.adal:BrowserFinalUrl", rawAuthorizationResult.mAuthorizationFinalUri);
        propertyBag.put("com.microsoft.aad.adal:AuthenticationException", rawAuthorizationResult.mException);
        return propertyBag;
    }

    @Nullable
    public URI getAuthorizationFinalUri() {
        return this.mAuthorizationFinalUri;
    }

    @Nullable
    public BaseException getException() {
        return this.mException;
    }

    public ResultCode getResultCode() {
        return this.mResultCode;
    }
}
