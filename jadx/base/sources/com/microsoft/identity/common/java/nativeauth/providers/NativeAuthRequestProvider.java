package com.microsoft.identity.common.java.nativeauth.providers;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitNewPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitUserAttributesCommandParameters;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordContinueRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordPollCompletionRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordStartRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordSubmitRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInInitiateRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInTokenRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signup.SignUpChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signup.SignUpContinueRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signup.SignUpStartRequest;
import com.microsoft.identity.common.java.platform.Device;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\u001d\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020%H\u0000¢\u0006\u0002\b&J\u001d\u0010'\u001a\u00020(2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0000¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020+2\u0006\u0010\u0015\u001a\u00020,H\u0000¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020/2\u0006\u0010\u0015\u001a\u000200H\u0000¢\u0006\u0002\b1J\u001d\u00102\u001a\u0002032\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0000¢\u0006\u0002\b4J\u0015\u00105\u001a\u0002062\u0006\u0010\u0015\u001a\u000207H\u0000¢\u0006\u0002\b8J\u001d\u00109\u001a\u00020:2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020=2\u0006\u0010\u0015\u001a\u00020>H\u0000¢\u0006\u0002\b?J\u0015\u0010@\u001a\u00020A2\u0006\u0010\u0015\u001a\u00020BH\u0000¢\u0006\u0002\bCJ\u0015\u0010D\u001a\u00020A2\u0006\u0010\u0015\u001a\u00020EH\u0000¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u00020A2\u0006\u0010\u0015\u001a\u00020HH\u0000¢\u0006\u0002\bIJ\u001e\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060K2\u0006\u0010!\u001a\u00020\u0006H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;", "", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;", "(Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;)V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "resetPasswordChallengeEndpoint", "resetPasswordContinueEndpoint", "resetPasswordPollCompletionEndpoint", "resetPasswordStartEndpoint", "resetPasswordSubmitEndpoint", "signInChallengeEndpoint", "signInInitiateEndpoint", "signInTokenEndpoint", "signUpChallengeEndpoint", "signUpContinueEndpoint", "signUpStartEndpoint", "createContinuationTokenTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest;", "commandParameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInWithContinuationTokenCommandParameters;", "createContinuationTokenTokenRequest$common4j", "createOOBTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitCodeCommandParameters;", "createOOBTokenRequest$common4j", "createPasswordTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitPasswordCommandParameters;", "createPasswordTokenRequest$common4j", "createResetPasswordChallengeRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordChallengeRequest;", "continuationToken", "correlationId", "createResetPasswordChallengeRequest$common4j", "createResetPasswordContinueRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordContinueRequest;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitCodeCommandParameters;", "createResetPasswordContinueRequest$common4j", "createResetPasswordPollCompletionRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordPollCompletionRequest;", "createResetPasswordPollCompletionRequest$common4j", "createResetPasswordStartRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordStartCommandParameters;", "createResetPasswordStartRequest$common4j", "createResetPasswordSubmitRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordSubmitRequest;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitNewPasswordCommandParameters;", "createResetPasswordSubmitRequest$common4j", "createSignInChallengeRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInChallengeRequest;", "createSignInChallengeRequest$common4j", "createSignInInitiateRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInInitiateRequest;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInStartCommandParameters;", "createSignInInitiateRequest$common4j", "createSignUpChallengeRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpChallengeRequest;", "createSignUpChallengeRequest$common4j", "createSignUpStartRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpStartCommandParameters;", "createSignUpStartRequest$common4j", "createSignUpSubmitCodeRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpContinueRequest;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitCodeCommandParameters;", "createSignUpSubmitCodeRequest$common4j", "createSignUpSubmitPasswordRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitPasswordCommandParameters;", "createSignUpSubmitPasswordRequest$common4j", "createSignUpSubmitUserAttributesRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitUserAttributesCommandParameters;", "createSignUpSubmitUserAttributesRequest$common4j", "getRequestHeaders", "", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NativeAuthRequestProvider {
    private final String TAG;

    @NotNull
    private final NativeAuthOAuth2Configuration config;

    @NotNull
    private final String resetPasswordChallengeEndpoint;

    @NotNull
    private final String resetPasswordContinueEndpoint;

    @NotNull
    private final String resetPasswordPollCompletionEndpoint;

    @NotNull
    private final String resetPasswordStartEndpoint;

    @NotNull
    private final String resetPasswordSubmitEndpoint;

    @NotNull
    private final String signInChallengeEndpoint;

    @NotNull
    private final String signInInitiateEndpoint;

    @NotNull
    private final String signInTokenEndpoint;

    @NotNull
    private final String signUpChallengeEndpoint;

    @NotNull
    private final String signUpContinueEndpoint;

    @NotNull
    private final String signUpStartEndpoint;

    public NativeAuthRequestProvider(@NotNull NativeAuthOAuth2Configuration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.TAG = "NativeAuthRequestProvider";
        String string = config.getSignUpStartEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string, "config.getSignUpStartEndpoint().toString()");
        this.signUpStartEndpoint = string;
        String string2 = config.getSignUpChallengeEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "config.getSignUpChallengeEndpoint().toString()");
        this.signUpChallengeEndpoint = string2;
        String string3 = config.getSignUpContinueEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string3, "config.getSignUpContinueEndpoint().toString()");
        this.signUpContinueEndpoint = string3;
        String string4 = config.getSignInInitiateEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string4, "config.getSignInInitiateEndpoint().toString()");
        this.signInInitiateEndpoint = string4;
        String string5 = config.getSignInChallengeEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string5, "config.getSignInChallengeEndpoint().toString()");
        this.signInChallengeEndpoint = string5;
        String string6 = config.getSignInTokenEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string6, "config.getSignInTokenEndpoint().toString()");
        this.signInTokenEndpoint = string6;
        String string7 = config.getResetPasswordStartEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string7, "config.getResetPasswordStartEndpoint().toString()");
        this.resetPasswordStartEndpoint = string7;
        String string8 = config.getResetPasswordChallengeEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string8, "config.getResetPasswordC…engeEndpoint().toString()");
        this.resetPasswordChallengeEndpoint = string8;
        String string9 = config.getResetPasswordContinueEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string9, "config.getResetPasswordC…inueEndpoint().toString()");
        this.resetPasswordContinueEndpoint = string9;
        String string10 = config.getResetPasswordSubmitEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string10, "config.getResetPasswordSubmitEndpoint().toString()");
        this.resetPasswordSubmitEndpoint = string10;
        String string11 = config.getResetPasswordPollCompletionEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string11, "config.getResetPasswordP…tionEndpoint().toString()");
        this.resetPasswordPollCompletionEndpoint = string11;
    }

    private final Map<String, String> getRequestHeaders(String correlationId) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("client-request-id", correlationId);
        treeMap.put("x-client-SKU", DiagnosticContext.INSTANCE.getRequestContext().get("x-client-SKU"));
        treeMap.put("x-client-Ver", Device.getProductVersion());
        Map<String, String> platformIdParameters = Device.getPlatformIdParameters();
        Intrinsics.checkNotNullExpressionValue(platformIdParameters, "getPlatformIdParameters()");
        treeMap.putAll(platformIdParameters);
        Map<String, String> telemetryHeaders = EstsTelemetry.getInstance().getTelemetryHeaders();
        Intrinsics.checkNotNullExpressionValue(telemetryHeaders, "getInstance().telemetryHeaders");
        treeMap.putAll(telemetryHeaders);
        treeMap.put("Content-Type", "application/x-www-form-urlencoded");
        return treeMap;
    }

    @NotNull
    public final SignInTokenRequest createContinuationTokenTokenRequest$common4j(@NotNull SignInWithContinuationTokenCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".createContinuationTokenRequest", new StringBuilder()));
        SignInTokenRequest.Companion companion2 = SignInTokenRequest.INSTANCE;
        String continuationToken = commandParameters.continuationToken;
        List<String> list = commandParameters.scopes;
        String clientId = this.config.getClientId();
        String username = commandParameters.username;
        String challengeType = this.config.getChallengeType();
        String str = this.signInTokenEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        Map<String, String> requestHeaders = getRequestHeaders(correlationId);
        Intrinsics.checkNotNullExpressionValue(continuationToken, "continuationToken");
        Intrinsics.checkNotNullExpressionValue(username, "username");
        return companion2.createContinuationTokenRequest(continuationToken, clientId, username, list, challengeType, str, requestHeaders);
    }

    @NotNull
    public final SignInTokenRequest createOOBTokenRequest$common4j(@NotNull SignInSubmitCodeCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".createOOBTokenRequest", new StringBuilder()));
        SignInTokenRequest.Companion companion2 = SignInTokenRequest.INSTANCE;
        String code = commandParameters.code;
        List<String> list = commandParameters.scopes;
        String continuationToken = commandParameters.continuationToken;
        String clientId = this.config.getClientId();
        String challengeType = this.config.getChallengeType();
        String str = this.signInTokenEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        Map<String, String> requestHeaders = getRequestHeaders(correlationId);
        Intrinsics.checkNotNullExpressionValue(code, "code");
        Intrinsics.checkNotNullExpressionValue(continuationToken, "continuationToken");
        return companion2.createOOBTokenRequest(code, continuationToken, clientId, list, challengeType, str, requestHeaders);
    }

    @NotNull
    public final SignInTokenRequest createPasswordTokenRequest$common4j(@NotNull SignInSubmitPasswordCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".createPasswordTokenRequest", new StringBuilder()));
        SignInTokenRequest.Companion companion2 = SignInTokenRequest.INSTANCE;
        char[] password = commandParameters.password;
        List<String> list = commandParameters.scopes;
        String continuationToken = commandParameters.continuationToken;
        String clientId = this.config.getClientId();
        String challengeType = this.config.getChallengeType();
        String str = this.signInTokenEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        Map<String, String> requestHeaders = getRequestHeaders(correlationId);
        Intrinsics.checkNotNullExpressionValue(password, "password");
        Intrinsics.checkNotNullExpressionValue(continuationToken, "continuationToken");
        return companion2.createPasswordTokenRequest(password, continuationToken, clientId, list, challengeType, str, requestHeaders);
    }

    @NotNull
    public final ResetPasswordChallengeRequest createResetPasswordChallengeRequest$common4j(@NotNull String continuationToken, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, correlationId, AbstractC0622a.m1170p(this.TAG, ".createResetPasswordChallengeRequest", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return ResetPasswordChallengeRequest.INSTANCE.create(this.config.getClientId(), continuationToken, this.config.getChallengeType(), this.resetPasswordChallengeEndpoint, getRequestHeaders(correlationId));
    }

    @NotNull
    public final ResetPasswordContinueRequest createResetPasswordContinueRequest$common4j(@NotNull ResetPasswordSubmitCodeCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".createResetPasswordContinueRequest", new StringBuilder()));
        ResetPasswordContinueRequest.Companion companion2 = ResetPasswordContinueRequest.INSTANCE;
        String clientId = this.config.getClientId();
        String str = commandParameters.continuationToken;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.continuationToken");
        String str2 = commandParameters.code;
        Intrinsics.checkNotNullExpressionValue(str2, "commandParameters.code");
        String str3 = this.resetPasswordContinueEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return companion2.create(clientId, str, str2, str3, getRequestHeaders(correlationId));
    }

    @NotNull
    public final ResetPasswordPollCompletionRequest createResetPasswordPollCompletionRequest$common4j(@NotNull String continuationToken, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, correlationId, AbstractC0622a.m1170p(this.TAG, ".createResetPasswordPollCompletionRequest", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return ResetPasswordPollCompletionRequest.INSTANCE.create(this.config.getClientId(), continuationToken, this.resetPasswordPollCompletionEndpoint, getRequestHeaders(correlationId));
    }

    @NotNull
    public final ResetPasswordStartRequest createResetPasswordStartRequest$common4j(@NotNull ResetPasswordStartCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".createResetPasswordStartRequest", new StringBuilder()));
        ResetPasswordStartRequest.Companion companion2 = ResetPasswordStartRequest.INSTANCE;
        String clientId = this.config.getClientId();
        String str = commandParameters.username;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.username");
        String challengeType = this.config.getChallengeType();
        String str2 = this.resetPasswordStartEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return companion2.create(clientId, str, challengeType, str2, getRequestHeaders(correlationId));
    }

    @NotNull
    public final ResetPasswordSubmitRequest createResetPasswordSubmitRequest$common4j(@NotNull ResetPasswordSubmitNewPasswordCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".createResetPasswordSubmitRequest", new StringBuilder()));
        ResetPasswordSubmitRequest.Companion companion2 = ResetPasswordSubmitRequest.INSTANCE;
        String clientId = this.config.getClientId();
        String str = commandParameters.continuationToken;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.continuationToken");
        char[] cArr = commandParameters.newPassword;
        Intrinsics.checkNotNullExpressionValue(cArr, "commandParameters.newPassword");
        String str2 = this.resetPasswordSubmitEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return companion2.create(clientId, str, cArr, str2, getRequestHeaders(correlationId));
    }

    @NotNull
    public final SignInChallengeRequest createSignInChallengeRequest$common4j(@NotNull String continuationToken, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, correlationId, AbstractC0622a.m1170p(this.TAG, ".createSignInChallengeRequest", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return SignInChallengeRequest.INSTANCE.create(this.config.getClientId(), continuationToken, this.config.getChallengeType(), this.signInChallengeEndpoint, getRequestHeaders(correlationId));
    }

    @NotNull
    public final SignInInitiateRequest createSignInInitiateRequest$common4j(@NotNull SignInStartCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".createSignInInitiateRequest", new StringBuilder()));
        SignInInitiateRequest.Companion companion2 = SignInInitiateRequest.INSTANCE;
        String str = commandParameters.username;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.username");
        String clientId = this.config.getClientId();
        String challengeType = this.config.getChallengeType();
        String str2 = this.signInInitiateEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return companion2.create(str, clientId, challengeType, str2, getRequestHeaders(correlationId));
    }

    @NotNull
    public final SignUpChallengeRequest createSignUpChallengeRequest$common4j(@NotNull String continuationToken, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, correlationId, AbstractC0622a.m1170p(this.TAG, ".createSignUpChallengeRequest", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return SignUpChallengeRequest.INSTANCE.create(continuationToken, this.config.getClientId(), this.config.getChallengeType(), this.signUpChallengeEndpoint, getRequestHeaders(correlationId));
    }

    @NotNull
    public final SignUpStartRequest createSignUpStartRequest$common4j(@NotNull SignUpStartCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".createSignUpStartRequest", new StringBuilder()));
        SignUpStartRequest.Companion companion2 = SignUpStartRequest.INSTANCE;
        String username = commandParameters.username;
        char[] cArr = commandParameters.password;
        Map<String, String> map = commandParameters.userAttributes;
        String challengeType = this.config.getChallengeType();
        String clientId = this.config.getClientId();
        String str = this.signUpStartEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        Map<String, String> requestHeaders = getRequestHeaders(correlationId);
        Intrinsics.checkNotNullExpressionValue(username, "username");
        return companion2.create(username, cArr, map, clientId, challengeType, str, requestHeaders);
    }

    @NotNull
    public final SignUpContinueRequest createSignUpSubmitCodeRequest$common4j(@NotNull SignUpSubmitCodeCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".createSignUpSubmitCodeRequest", new StringBuilder()));
        SignUpContinueRequest.Companion companion2 = SignUpContinueRequest.INSTANCE;
        String str = commandParameters.code;
        String clientId = this.config.getClientId();
        String str2 = commandParameters.continuationToken;
        Intrinsics.checkNotNullExpressionValue(str2, "commandParameters.continuationToken");
        String str3 = this.signUpContinueEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return SignUpContinueRequest.Companion.create$default(companion2, null, null, str, clientId, str2, "oob", str3, getRequestHeaders(correlationId), 3, null);
    }

    @NotNull
    public final SignUpContinueRequest createSignUpSubmitPasswordRequest$common4j(@NotNull SignUpSubmitPasswordCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".createSignUpSubmitPasswordRequest", new StringBuilder()));
        SignUpContinueRequest.Companion companion2 = SignUpContinueRequest.INSTANCE;
        char[] cArr = commandParameters.password;
        String clientId = this.config.getClientId();
        String str = commandParameters.continuationToken;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.continuationToken");
        String str2 = this.signUpContinueEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return SignUpContinueRequest.Companion.create$default(companion2, cArr, null, null, clientId, str, "password", str2, getRequestHeaders(correlationId), 6, null);
    }

    @NotNull
    public final SignUpContinueRequest createSignUpSubmitUserAttributesRequest$common4j(@NotNull SignUpSubmitUserAttributesCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".createSignUpSubmitUserAttributesRequest", new StringBuilder()));
        SignUpContinueRequest.Companion companion2 = SignUpContinueRequest.INSTANCE;
        Map<String, String> map = commandParameters.userAttributes;
        String clientId = this.config.getClientId();
        String str = commandParameters.continuationToken;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.continuationToken");
        String str2 = this.signUpContinueEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return SignUpContinueRequest.Companion.create$default(companion2, null, map, null, clientId, str, NativeAuthConstants.GrantType.ATTRIBUTES, str2, getRequestHeaders(correlationId), 5, null);
    }
}
