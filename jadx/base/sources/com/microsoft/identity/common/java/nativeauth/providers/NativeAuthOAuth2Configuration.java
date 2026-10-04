package com.microsoft.identity.common.java.nativeauth.providers;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.BuildValues;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.java.util.UrlUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\u0018\u0000  2\u00020\u0001:\u0001 B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0003R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;", "Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsOAuth2Configuration;", "authorityUrl", "Ljava/net/URL;", SyncDBSchema.SyncInfo.CLIENT_ID, "", "challengeType", "useMockApiForNativeAuth", "", "(Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;Z)V", SearchConstants.TargetContents.TAG, "kotlin.jvm.PlatformType", "getChallengeType", "()Ljava/lang/String;", "getClientId", "getUseMockApiForNativeAuth", "()Z", "getAuthorityUrl", "getEndpointUrlFromRootAndTenantAndSuffix", "root", "endpointSuffix", "getResetPasswordChallengeEndpoint", "getResetPasswordContinueEndpoint", "getResetPasswordPollCompletionEndpoint", "getResetPasswordStartEndpoint", "getResetPasswordSubmitEndpoint", "getSignInChallengeEndpoint", "getSignInInitiateEndpoint", "getSignInTokenEndpoint", "getSignUpChallengeEndpoint", "getSignUpContinueEndpoint", "getSignUpStartEndpoint", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NativeAuthOAuth2Configuration extends MicrosoftStsOAuth2Configuration {

    @NotNull
    private static final String MOCK_API_URL_WITH_NATIVE_AUTH_TENANT = "https://native-auth-mock-api.azurewebsites.net/lumonconvergedps.onmicrosoft.com";

    @NotNull
    private static final String RESET_PASSWORD_CHALLENGE_ENDPOINT_SUFFIX = "/resetpassword/v1.0/challenge";

    @NotNull
    private static final String RESET_PASSWORD_COMPLETE_ENDPOINT_SUFFIX = "/resetpassword/v1.0/poll_completion";

    @NotNull
    private static final String RESET_PASSWORD_CONTINUE_ENDPOINT_SUFFIX = "/resetpassword/v1.0/continue";

    @NotNull
    private static final String RESET_PASSWORD_START_ENDPOINT_SUFFIX = "/resetpassword/v1.0/start";

    @NotNull
    private static final String RESET_PASSWORD_SUBMIT_ENDPOINT_SUFFIX = "/resetpassword/v1.0/submit";

    @NotNull
    private static final String SIGNUP_CHALLENGE_ENDPOINT_SUFFIX = "/signup/v1.0/challenge";

    @NotNull
    private static final String SIGNUP_CONTINUE_ENDPOINT_SUFFIX = "/signup/v1.0/continue";

    @NotNull
    private static final String SIGNUP_START_ENDPOINT_SUFFIX = "/signup/v1.0/start";

    @NotNull
    private static final String SIGN_IN_CHALLENGE_ENDPOINT_SUFFIX = "/oauth2/v2.0/challenge";

    @NotNull
    private static final String SIGN_IN_INITIATE_ENDPOINT_SUFFIX = "/oauth2/v2.0/initiate";

    @NotNull
    private static final String SIGN_IN_TOKEN_ENDPOINT_SUFFIX = "/oauth2/v2.0/token";
    private final String TAG;

    @NotNull
    private final URL authorityUrl;

    @NotNull
    private final String challengeType;

    @NotNull
    private final String clientId;
    private final boolean useMockApiForNativeAuth;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ NativeAuthOAuth2Configuration(URL url, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 8) != 0) {
            Boolean boolShouldUseMockApiForNativeAuth = BuildValues.shouldUseMockApiForNativeAuth();
            Intrinsics.checkNotNullExpressionValue(boolShouldUseMockApiForNativeAuth, "shouldUseMockApiForNativeAuth()");
            z = boolShouldUseMockApiForNativeAuth.booleanValue();
        }
        this(url, str, str2, z);
    }

    private final URL getEndpointUrlFromRootAndTenantAndSuffix(URL root, String endpointSuffix) throws MalformedURLException, URISyntaxException {
        URL urlAppendPathToURL;
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, null, AbstractC0622a.m1170p(this.TAG, ".getEndpointUrlFromRootAndTenantAndSuffix", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        try {
            String dc = BuildValues.getDC();
            Intrinsics.checkNotNullExpressionValue(dc, "getDC()");
            if (dc.length() > 0) {
                urlAppendPathToURL = UrlUtil.appendPathAndQueryToURL(root, endpointSuffix, "dc=" + BuildValues.getDC());
            } else {
                urlAppendPathToURL = UrlUtil.appendPathToURL(root, endpointSuffix);
            }
            Intrinsics.checkNotNullExpressionValue(urlAppendPathToURL, "{\n            if (BuildV…)\n            }\n        }");
            return urlAppendPathToURL;
        } catch (MalformedURLException e) {
            Logger.error(this.TAG, "appendPathToURL failed", e);
            throw e;
        } catch (URISyntaxException e2) {
            Logger.error(this.TAG, "appendPathToURL failed", e2);
            throw e2;
        }
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Configuration
    @NotNull
    public URL getAuthorityUrl() {
        return this.useMockApiForNativeAuth ? new URL(MOCK_API_URL_WITH_NATIVE_AUTH_TENANT) : this.authorityUrl;
    }

    @NotNull
    public final String getChallengeType() {
        return this.challengeType;
    }

    @NotNull
    public final String getClientId() {
        return this.clientId;
    }

    @NotNull
    public final URL getResetPasswordChallengeEndpoint() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, null, AbstractC0622a.m1170p(this.TAG, ".getResetPasswordChallengeEndpoint", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), RESET_PASSWORD_CHALLENGE_ENDPOINT_SUFFIX);
    }

    @NotNull
    public final URL getResetPasswordContinueEndpoint() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, null, AbstractC0622a.m1170p(this.TAG, ".getResetPasswordContinueEndpoint", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), RESET_PASSWORD_CONTINUE_ENDPOINT_SUFFIX);
    }

    @NotNull
    public final URL getResetPasswordPollCompletionEndpoint() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, null, AbstractC0622a.m1170p(this.TAG, ".getResetPasswordPollCompletionEndpoint", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), RESET_PASSWORD_COMPLETE_ENDPOINT_SUFFIX);
    }

    @NotNull
    public final URL getResetPasswordStartEndpoint() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, null, AbstractC0622a.m1170p(this.TAG, ".getResetPasswordStartEndpoint", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), RESET_PASSWORD_START_ENDPOINT_SUFFIX);
    }

    @NotNull
    public final URL getResetPasswordSubmitEndpoint() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, null, AbstractC0622a.m1170p(this.TAG, ".getResetPasswordSubmitEndpoint", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), RESET_PASSWORD_SUBMIT_ENDPOINT_SUFFIX);
    }

    @NotNull
    public final URL getSignInChallengeEndpoint() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, null, AbstractC0622a.m1170p(this.TAG, ".getSignInChallengeEndpoint", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGN_IN_CHALLENGE_ENDPOINT_SUFFIX);
    }

    @NotNull
    public final URL getSignInInitiateEndpoint() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, null, AbstractC0622a.m1170p(this.TAG, ".getSignInInitiateEndpoint", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGN_IN_INITIATE_ENDPOINT_SUFFIX);
    }

    @NotNull
    public final URL getSignInTokenEndpoint() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, null, AbstractC0622a.m1170p(this.TAG, ".getSignInTokenEndpoint", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGN_IN_TOKEN_ENDPOINT_SUFFIX);
    }

    @NotNull
    public final URL getSignUpChallengeEndpoint() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, null, AbstractC0622a.m1170p(this.TAG, ".getSignUpChallengeEndpoint", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGNUP_CHALLENGE_ENDPOINT_SUFFIX);
    }

    @NotNull
    public final URL getSignUpContinueEndpoint() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, null, AbstractC0622a.m1170p(this.TAG, ".getSignUpContinueEndpoint", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGNUP_CONTINUE_ENDPOINT_SUFFIX);
    }

    @NotNull
    public final URL getSignUpStartEndpoint() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, null, AbstractC0622a.m1170p(this.TAG, ".getSignUpStartEndpoint", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGNUP_START_ENDPOINT_SUFFIX);
    }

    public final boolean getUseMockApiForNativeAuth() {
        return this.useMockApiForNativeAuth;
    }

    public NativeAuthOAuth2Configuration(@NotNull URL authorityUrl, @NotNull String clientId, @NotNull String challengeType, boolean z) {
        Intrinsics.checkNotNullParameter(authorityUrl, "authorityUrl");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(challengeType, "challengeType");
        this.authorityUrl = authorityUrl;
        this.clientId = clientId;
        this.challengeType = challengeType;
        this.useMockApiForNativeAuth = z;
        this.TAG = "NativeAuthOAuth2Configuration";
    }
}
