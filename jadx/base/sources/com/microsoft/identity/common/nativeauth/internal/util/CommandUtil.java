package com.microsoft.identity.common.nativeauth.internal.util;

import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.AcquireTokenNoFixedScopesCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters;
import com.microsoft.identity.common.java.request.SdkType;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CommandUtil {
    /* JADX WARN: Multi-variable type inference failed */
    public static SilentTokenCommandParameters convertAcquireTokenNoFixedScopesCommandParameters(AcquireTokenNoFixedScopesCommandParameters acquireTokenNoFixedScopesCommandParameters, String str) {
        return ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) SilentTokenCommandParameters.builder().platformComponents(acquireTokenNoFixedScopesCommandParameters.getPlatformComponents())).applicationName(acquireTokenNoFixedScopesCommandParameters.getApplicationName())).applicationVersion(acquireTokenNoFixedScopesCommandParameters.getApplicationVersion())).clientId(acquireTokenNoFixedScopesCommandParameters.getClientId())).isSharedDevice(acquireTokenNoFixedScopesCommandParameters.isSharedDevice())).oAuth2TokenCache(acquireTokenNoFixedScopesCommandParameters.getOAuth2TokenCache())).redirectUri(acquireTokenNoFixedScopesCommandParameters.getRedirectUri())).requiredBrokerProtocolVersion(acquireTokenNoFixedScopesCommandParameters.getRequiredBrokerProtocolVersion())).sdkType(SdkType.MSAL)).sdkVersion(acquireTokenNoFixedScopesCommandParameters.getSdkVersion())).authority(acquireTokenNoFixedScopesCommandParameters.authority)).forceRefresh(acquireTokenNoFixedScopesCommandParameters.isForceRefresh())).account(acquireTokenNoFixedScopesCommandParameters.getAccount())).authenticationScheme(acquireTokenNoFixedScopesCommandParameters.getAuthenticationScheme())).powerOptCheckEnabled(acquireTokenNoFixedScopesCommandParameters.isPowerOptCheckEnabled())).correlationId(str)).correlationId(acquireTokenNoFixedScopesCommandParameters.getCorrelationId())).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SignInStartCommandParameters createSignInStartCommandParametersWithScopes(SignInStartCommandParameters signInStartCommandParameters, List<String> list) {
        return ((SignInStartCommandParameters.SignInStartCommandParametersBuilder) ((SignInStartCommandParameters.SignInStartCommandParametersBuilder) signInStartCommandParameters.toBuilder().scopes(list)).correlationId(signInStartCommandParameters.getCorrelationId())).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SignInSubmitCodeCommandParameters createSignInSubmitCodeCommandParametersWithScopes(SignInSubmitCodeCommandParameters signInSubmitCodeCommandParameters, List<String> list) {
        return ((SignInSubmitCodeCommandParameters.SignInSubmitCodeCommandParametersBuilder) ((SignInSubmitCodeCommandParameters.SignInSubmitCodeCommandParametersBuilder) signInSubmitCodeCommandParameters.toBuilder().scopes(list)).correlationId(signInSubmitCodeCommandParameters.getCorrelationId())).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SignInSubmitPasswordCommandParameters createSignInSubmitPasswordCommandParameters(SignInStartCommandParameters signInStartCommandParameters, String str, String str2) {
        return ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) SignInSubmitPasswordCommandParameters.builder().platformComponents(signInStartCommandParameters.getPlatformComponents())).applicationName(signInStartCommandParameters.getApplicationName())).applicationVersion(signInStartCommandParameters.getApplicationVersion())).clientId(signInStartCommandParameters.getClientId())).isSharedDevice(signInStartCommandParameters.isSharedDevice())).redirectUri(signInStartCommandParameters.getRedirectUri())).oAuth2TokenCache(signInStartCommandParameters.getOAuth2TokenCache())).requiredBrokerProtocolVersion(signInStartCommandParameters.getRequiredBrokerProtocolVersion())).sdkType(SdkType.MSAL)).sdkVersion(signInStartCommandParameters.getSdkVersion())).powerOptCheckEnabled(signInStartCommandParameters.isPowerOptCheckEnabled())).authority(signInStartCommandParameters.getAuthority())).continuationToken(str2).password(signInStartCommandParameters.getPassword()).scopes(signInStartCommandParameters.getScopes())).correlationId(str)).challengeType(signInStartCommandParameters.getChallengeType())).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SignInSubmitPasswordCommandParameters createSignInSubmitPasswordCommandParametersWithScopes(SignInSubmitPasswordCommandParameters signInSubmitPasswordCommandParameters, String str, List<String> list) {
        return ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) ((SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder) signInSubmitPasswordCommandParameters.toBuilder().scopes(list)).correlationId(str)).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SignInWithContinuationTokenCommandParameters createSignInWithContinuationTokenCommandParametersWithScopes(SignInWithContinuationTokenCommandParameters signInWithContinuationTokenCommandParameters, List<String> list) {
        return ((SignInWithContinuationTokenCommandParameters.SignInWithContinuationTokenCommandParametersBuilder) ((SignInWithContinuationTokenCommandParameters.SignInWithContinuationTokenCommandParametersBuilder) signInWithContinuationTokenCommandParameters.toBuilder().scopes(list)).correlationId(signInWithContinuationTokenCommandParameters.getCorrelationId())).build();
    }
}
