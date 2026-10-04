package com.microsoft.identity.common.internal.controllers;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.commands.RefreshOnCommand;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;
import com.microsoft.identity.common.internal.telemetry.events.ApiStartEvent;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.GenerateShrCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.RemoveAccountCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.exception.BrokerRequiredException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.exception.UiRequiredException;
import com.microsoft.identity.common.java.p132ui.PreferredAuthMethod;
import com.microsoft.identity.common.java.platform.DevicePoPUtils;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationResponse;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationStatus;
import com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.result.GenerateShrResult;
import com.microsoft.identity.common.java.result.LocalAuthenticationResult;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.java.util.ResultUtil;
import com.microsoft.identity.common.java.util.ThreadUtils;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import com.microsoft.identity.common.logging.Logger;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class LocalMSALController extends BaseController {
    private static final String TAG = "LocalMSALController";
    private IAuthorizationStrategy mAuthorizationStrategy = null;
    private Future<AuthorizationResult> mAuthorizationFuture = null;
    private AuthorizationRequest mAuthorizationRequest = null;

    private boolean authorizationPending(@NonNull String str) {
        return str.equals(ErrorStrings.DEVICE_CODE_FLOW_AUTHORIZATION_PENDING_ERROR_CODE);
    }

    private AuthorizationResult performAuthorizationRequest(@NonNull OAuth2Strategy oAuth2Strategy, @NonNull InteractiveTokenCommandParameters interactiveTokenCommandParameters) throws ExecutionException, InterruptedException {
        interactiveTokenCommandParameters.getPlatformComponents().getPlatformUtil().throwIfNetworkNotAvailable(interactiveTokenCommandParameters.isPowerOptCheckEnabled());
        this.mAuthorizationStrategy = interactiveTokenCommandParameters.getPlatformComponents().getAuthorizationStrategyFactory().getAuthorizationStrategy(interactiveTokenCommandParameters);
        AuthorizationRequest authorizationRequest = getAuthorizationRequest(oAuth2Strategy, interactiveTokenCommandParameters);
        this.mAuthorizationRequest = authorizationRequest;
        Future<AuthorizationResult> futureRequestAuthorization = oAuth2Strategy.requestAuthorization(authorizationRequest, this.mAuthorizationStrategy);
        this.mAuthorizationFuture = futureRequestAuthorization;
        AuthorizationResult authorizationResult = futureRequestAuthorization.get();
        this.mAuthorizationFuture = null;
        return authorizationResult;
    }

    private void renewAT(@NonNull SilentTokenCommandParameters silentTokenCommandParameters, @NonNull AcquireTokenResult acquireTokenResult, @NonNull OAuth2TokenCache oAuth2TokenCache, @NonNull OAuth2Strategy oAuth2Strategy, @NonNull ICacheRecord iCacheRecord, @NonNull String str) throws ServiceException, ClientException {
        Logger.verbose(str, "Renewing access token...");
        renewAccessToken(silentTokenCommandParameters, acquireTokenResult, oAuth2TokenCache, oAuth2Strategy, iCacheRecord);
    }

    private void setAcquireTokenResult(AcquireTokenResult acquireTokenResult, SilentTokenCommandParameters silentTokenCommandParameters, List<ICacheRecord> list) {
        acquireTokenResult.setLocalAuthenticationResult(new LocalAuthenticationResult(finalizeCacheRecordForResult(list.get(0), silentTokenCommandParameters.getAuthenticationScheme()), list, SdkType.MSAL, true));
    }

    private boolean userHasLocalAccountRecord(@NonNull OAuth2TokenCache oAuth2TokenCache, @NonNull String str, @NonNull String str2) {
        return oAuth2TokenCache.getAccountByHomeAccountId(null, str, str2) != null;
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AcquireTokenResult acquireDeviceCodeFlowToken(AuthorizationResult authorizationResult, DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters) throws Exception {
        Logger.verbose(TAG + ":acquireDeviceCodeFlowToken", "Device Code Flow: Polling for token...");
        Telemetry.emit(new ApiStartEvent().putApiId(TelemetryEventStrings.Api.LOCAL_DEVICE_CODE_FLOW_POLLING));
        AcquireTokenResult acquireTokenResult = new AcquireTokenResult();
        acquireTokenResult.setAuthorizationResult(authorizationResult);
        MicrosoftStsAuthorizationResponse microsoftStsAuthorizationResponse = (MicrosoftStsAuthorizationResponse) authorizationResult.getAuthorizationResponse();
        try {
            OAuth2Strategy oAuth2StrategyCreateOAuth2Strategy = deviceCodeFlowCommandParameters.getAuthority().createOAuth2Strategy(OAuth2StrategyParameters.builder().platformComponents(deviceCodeFlowCommandParameters.getPlatformComponents()).authenticationScheme(deviceCodeFlowCommandParameters.getAuthenticationScheme()).build());
            MicrosoftStsTokenRequest microsoftStsTokenRequest = (MicrosoftStsTokenRequest) oAuth2StrategyCreateOAuth2Strategy.createTokenRequest(this.mAuthorizationRequest, microsoftStsAuthorizationResponse, deviceCodeFlowCommandParameters.getAuthenticationScheme());
            int i = Integer.parseInt(microsoftStsAuthorizationResponse.getInterval()) * 1000;
            String error = ErrorStrings.DEVICE_CODE_FLOW_AUTHORIZATION_PENDING_ERROR_CODE;
            TokenResult tokenResultRequestToken = null;
            while (authorizationPending(error)) {
                ThreadUtils.sleepSafely(i, TAG, "Attempting to sleep thread during Device Code Flow token polling...");
                error = "";
                tokenResultRequestToken = oAuth2StrategyCreateOAuth2Strategy.requestToken(microsoftStsTokenRequest);
                if (tokenResultRequestToken.getErrorResponse() != null) {
                    error = tokenResultRequestToken.getErrorResponse().getError();
                }
            }
            validateDeviceCodeFlowServiceResult(tokenResultRequestToken);
            acquireTokenResult.setTokenResult(tokenResultRequestToken);
            List<ICacheRecord> listSaveTokens = saveTokens(oAuth2StrategyCreateOAuth2Strategy, this.mAuthorizationRequest, acquireTokenResult.getTokenResult().getTokenResponse(), deviceCodeFlowCommandParameters.getOAuth2TokenCache());
            acquireTokenResult.setLocalAuthenticationResult(new LocalAuthenticationResult(finalizeCacheRecordForResult(listSaveTokens.get(0), deviceCodeFlowCommandParameters.getAuthenticationScheme()), listSaveTokens, SdkType.MSAL, false));
            ResultUtil.logResult(TAG, tokenResultRequestToken);
            Telemetry.emit(new ApiEndEvent().putResult(acquireTokenResult).putApiId(TelemetryEventStrings.Api.LOCAL_DEVICE_CODE_FLOW_POLLING));
            return acquireTokenResult;
        } catch (Exception e) {
            Telemetry.emit(new ApiEndEvent().putException(e).putApiId(TelemetryEventStrings.Api.LOCAL_DEVICE_CODE_FLOW_POLLING));
            throw e;
        }
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AcquireTokenResult acquireToken(@NonNull InteractiveTokenCommandParameters interactiveTokenCommandParameters) throws ExecutionException, InterruptedException, ArgumentException, ClientException {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append(":acquireToken");
        Logger.verbose(sb.toString(), "Acquiring token...");
        Telemetry.emit(new ApiStartEvent().putProperties(interactiveTokenCommandParameters).putApiId("101"));
        AcquireTokenResult acquireTokenResult = new AcquireTokenResult();
        interactiveTokenCommandParameters.validate();
        InteractiveTokenCommandParameters interactiveTokenCommandParametersBuild = ((InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParameters.toBuilder().scopes(addDefaultScopes(interactiveTokenCommandParameters))).build();
        logParameters(str, interactiveTokenCommandParametersBuild);
        interactiveTokenCommandParametersBuild.getPlatformComponents().getPlatformUtil().throwIfNetworkNotAvailable(interactiveTokenCommandParametersBuild.isPowerOptCheckEnabled());
        Authority.KnownAuthorityResult knownAuthorityResult = Authority.getKnownAuthorityResult(interactiveTokenCommandParametersBuild.getAuthority());
        if (!knownAuthorityResult.getKnown()) {
            Telemetry.emit(new ApiEndEvent().putException(knownAuthorityResult.getClientException()).putApiId("101"));
            throw knownAuthorityResult.getClientException();
        }
        OAuth2Strategy oAuth2StrategyCreateOAuth2Strategy = interactiveTokenCommandParametersBuild.getAuthority().createOAuth2Strategy(OAuth2StrategyParameters.builder().platformComponents(interactiveTokenCommandParameters.getPlatformComponents()).authenticationScheme(interactiveTokenCommandParameters.getAuthenticationScheme()).build());
        AuthorizationResult authorizationResultPerformAuthorizationRequest = performAuthorizationRequest(oAuth2StrategyCreateOAuth2Strategy, interactiveTokenCommandParametersBuild);
        acquireTokenResult.setAuthorizationResult(authorizationResultPerformAuthorizationRequest);
        ResultUtil.logResult(str, authorizationResultPerformAuthorizationRequest);
        if (authorizationResultPerformAuthorizationRequest.getAuthorizationStatus().equals(AuthorizationStatus.SUCCESS)) {
            TokenResult tokenResultPerformTokenRequest = performTokenRequest(oAuth2StrategyCreateOAuth2Strategy, this.mAuthorizationRequest, authorizationResultPerformAuthorizationRequest.getAuthorizationResponse(), interactiveTokenCommandParametersBuild);
            acquireTokenResult.setTokenResult(tokenResultPerformTokenRequest);
            if (tokenResultPerformTokenRequest != null && tokenResultPerformTokenRequest.getSuccess()) {
                List<ICacheRecord> listSaveTokens = saveTokens(oAuth2StrategyCreateOAuth2Strategy, this.mAuthorizationRequest, tokenResultPerformTokenRequest.getTokenResponse(), interactiveTokenCommandParametersBuild.getOAuth2TokenCache());
                acquireTokenResult.setLocalAuthenticationResult(new LocalAuthenticationResult(finalizeCacheRecordForResult(listSaveTokens.get(0), interactiveTokenCommandParametersBuild.getAuthenticationScheme()), listSaveTokens, SdkType.MSAL, false));
            }
        }
        Telemetry.emit(new ApiEndEvent().putResult(acquireTokenResult).putApiId("101"));
        return acquireTokenResult;
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AcquireTokenResult acquireTokenSilent(@NonNull SilentTokenCommandParameters silentTokenCommandParameters) throws ServiceException, ArgumentException, ClientException {
        String str = TAG + ":acquireTokenSilent";
        Logger.verbose(str, "Acquiring token silently...");
        Telemetry.emit(new ApiStartEvent().putProperties(silentTokenCommandParameters).putApiId("103"));
        AcquireTokenResult acquireTokenResult = new AcquireTokenResult();
        silentTokenCommandParameters.validate();
        SilentTokenCommandParameters silentTokenCommandParametersBuild = ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) silentTokenCommandParameters.toBuilder().scopes(addDefaultScopes(silentTokenCommandParameters))).build();
        OAuth2TokenCache oAuth2TokenCache = silentTokenCommandParametersBuild.getOAuth2TokenCache();
        AccountRecord cachedAccountRecord = getCachedAccountRecord(silentTokenCommandParametersBuild);
        AbstractAuthenticationScheme authenticationScheme = silentTokenCommandParametersBuild.getAuthenticationScheme();
        OAuth2Strategy oAuth2StrategyCreateOAuth2Strategy = silentTokenCommandParametersBuild.getAuthority().createOAuth2Strategy(OAuth2StrategyParameters.builder().platformComponents(silentTokenCommandParameters.getPlatformComponents()).authenticationScheme(authenticationScheme).build());
        List<ICacheRecord> listLoadWithAggregatedAccountData = oAuth2TokenCache.loadWithAggregatedAccountData(silentTokenCommandParametersBuild.getClientId(), silentTokenCommandParameters.getApplicationIdentifier(), silentTokenCommandParameters.getMamEnrollmentId(), TextUtils.join(" ", silentTokenCommandParametersBuild.getScopes()), cachedAccountRecord, authenticationScheme);
        ICacheRecord iCacheRecord = listLoadWithAggregatedAccountData.get(0);
        if (LibraryConfiguration.getInstance().isRefreshInEnabled() && iCacheRecord.getAccessToken() != null && iCacheRecord.getAccessToken().refreshOnIsActive()) {
            Logger.info(str, "RefreshOn is active. This will extend your token usage in the rare case servers are not available.");
        }
        if (LibraryConfiguration.getInstance().isRefreshInEnabled() && iCacheRecord.getAccessToken() != null && iCacheRecord.getAccessToken().shouldRefresh()) {
            if (iCacheRecord.getAccessToken().isExpired()) {
                Logger.warn(str, "Access token is expired. Removing from cache...");
                oAuth2TokenCache.removeCredential(iCacheRecord.getAccessToken());
                renewAT(silentTokenCommandParametersBuild, acquireTokenResult, oAuth2TokenCache, oAuth2StrategyCreateOAuth2Strategy, iCacheRecord, str);
            } else {
                setAcquireTokenResult(acquireTokenResult, silentTokenCommandParametersBuild, listLoadWithAggregatedAccountData);
                CommandDispatcher.submitAndForget(new RefreshOnCommand(silentTokenCommandParameters, asControllerFactory(), PublicApiId.MSAL_REFRESH_ON));
            }
        } else if (accessTokenIsNull(iCacheRecord) || refreshTokenIsNull(iCacheRecord) || silentTokenCommandParametersBuild.isForceRefresh() || !isRequestAuthorityRealmSameAsATRealm(silentTokenCommandParametersBuild.getAuthority(), iCacheRecord.getAccessToken()) || !oAuth2StrategyCreateOAuth2Strategy.validateCachedResult(authenticationScheme, iCacheRecord)) {
            if (refreshTokenIsNull(iCacheRecord)) {
                UiRequiredException uiRequiredException = new UiRequiredException("no_tokens_found", "No refresh token was found. ");
                Telemetry.emit(new ApiEndEvent().putException(uiRequiredException).putApiId("103"));
                throw uiRequiredException;
            }
            renewAT(silentTokenCommandParametersBuild, acquireTokenResult, oAuth2TokenCache, oAuth2StrategyCreateOAuth2Strategy, iCacheRecord, str);
        } else if (iCacheRecord.getAccessToken().isExpired()) {
            Logger.warn(str, "Access token is expired. Removing from cache...");
            oAuth2TokenCache.removeCredential(iCacheRecord.getAccessToken());
            renewAT(silentTokenCommandParametersBuild, acquireTokenResult, oAuth2TokenCache, oAuth2StrategyCreateOAuth2Strategy, iCacheRecord, str);
        } else {
            Logger.verbose(str, "Returning silent result");
            setAcquireTokenResult(acquireTokenResult, silentTokenCommandParametersBuild, listLoadWithAggregatedAccountData);
        }
        Telemetry.emit(new ApiEndEvent().putResult(acquireTokenResult).putApiId("103"));
        return acquireTokenResult;
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean canEqual(Object obj) {
        return obj instanceof LocalMSALController;
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AuthorizationResult deviceCodeFlowAuthRequest(DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters) throws Exception {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append(":deviceCodeFlowAuthRequest");
        String string = sb.toString();
        Logger.verbose(string, "Device Code Flow: Authorizing user code...");
        TokenCommandParameters tokenCommandParametersBuild = ((DeviceCodeFlowCommandParameters.DeviceCodeFlowCommandParametersBuilder) deviceCodeFlowCommandParameters.toBuilder().scopes(addDefaultScopes(deviceCodeFlowCommandParameters))).build();
        logParameters(str, tokenCommandParametersBuild);
        Telemetry.emit(new ApiStartEvent().putProperties(tokenCommandParametersBuild).putApiId(TelemetryEventStrings.Api.LOCAL_DEVICE_CODE_FLOW_ACQUIRE_URL_AND_CODE));
        Authority.KnownAuthorityResult knownAuthorityResult = Authority.getKnownAuthorityResult(tokenCommandParametersBuild.getAuthority());
        if (!knownAuthorityResult.getKnown()) {
            Telemetry.emit(new ApiEndEvent().putException(knownAuthorityResult.getClientException()).putApiId(TelemetryEventStrings.Api.LOCAL_DEVICE_CODE_FLOW_ACQUIRE_URL_AND_CODE));
            throw knownAuthorityResult.getClientException();
        }
        try {
            OAuth2Strategy oAuth2StrategyCreateOAuth2Strategy = tokenCommandParametersBuild.getAuthority().createOAuth2Strategy(OAuth2StrategyParameters.builder().platformComponents(deviceCodeFlowCommandParameters.getPlatformComponents()).authenticationScheme(deviceCodeFlowCommandParameters.getAuthenticationScheme()).build());
            AuthorizationRequest authorizationRequest = getAuthorizationRequest(oAuth2StrategyCreateOAuth2Strategy, tokenCommandParametersBuild);
            this.mAuthorizationRequest = authorizationRequest;
            AuthorizationResult deviceCode = oAuth2StrategyCreateOAuth2Strategy.getDeviceCode((MicrosoftStsAuthorizationRequest) authorizationRequest);
            validateDeviceCodeFlowServiceResult(deviceCode);
            Logger.verbose(string, "Device Code Flow authorization step finished...");
            ResultUtil.logResult(str, deviceCode);
            Telemetry.emit(new ApiEndEvent().putApiId(TelemetryEventStrings.Api.LOCAL_DEVICE_CODE_FLOW_ACQUIRE_URL_AND_CODE));
            return deviceCode;
        } catch (Exception e) {
            Telemetry.emit(new ApiEndEvent().putException(e).putApiId(TelemetryEventStrings.Api.LOCAL_DEVICE_CODE_FLOW_ACQUIRE_URL_AND_CODE));
            throw e;
        }
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof LocalMSALController) && ((LocalMSALController) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public GenerateShrResult generateSignedHttpRequest(@NonNull GenerateShrCommandParameters generateShrCommandParameters) {
        OAuth2TokenCache oAuth2TokenCache = generateShrCommandParameters.getOAuth2TokenCache();
        String clientId = generateShrCommandParameters.getClientId();
        String homeAccountId = generateShrCommandParameters.getHomeAccountId();
        IPoPAuthenticationSchemeParams popParameters = generateShrCommandParameters.getPopParameters();
        if (userHasLocalAccountRecord(oAuth2TokenCache, clientId, homeAccountId)) {
            return DevicePoPUtils.generateSignedHttpRequest(generateShrCommandParameters.getPlatformComponents(), popParameters);
        }
        GenerateShrResult generateShrResult = new GenerateShrResult();
        generateShrResult.setErrorCode("no_account_found");
        generateShrResult.setErrorMessage("Account does not exist.");
        return generateShrResult;
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @WorkerThread
    public List<ICacheRecord> getAccounts(@NonNull CommandParameters commandParameters) {
        Telemetry.emit(new ApiStartEvent().putProperties(commandParameters).putApiId(TelemetryEventStrings.Api.LOCAL_GET_ACCOUNTS));
        List<ICacheRecord> accountsWithAggregatedAccountData = commandParameters.getOAuth2TokenCache().getAccountsWithAggregatedAccountData(null, commandParameters.getClientId());
        Telemetry.emit(new ApiEndEvent().putApiId(TelemetryEventStrings.Api.LOCAL_GET_ACCOUNTS).put(TelemetryEventStrings.Key.ACCOUNTS_NUMBER, Integer.toString(accountsWithAggregatedAccountData.size())).put(TelemetryEventStrings.Key.IS_SUCCESSFUL, "true"));
        return accountsWithAggregatedAccountData;
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public List<ICacheRecord> getCurrentAccount(CommandParameters commandParameters) {
        return getAccounts(commandParameters);
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean getDeviceMode(CommandParameters commandParameters) {
        com.microsoft.identity.common.internal.logging.Logger.warn(TAG + ":getDeviceMode", "LocalMSALController is not eligible to use the broker. Do not check sharedDevice mode and return false immediately.");
        return false;
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public PreferredAuthMethod getPreferredAuthMethod() throws BrokerRequiredException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getPreferredAuthMethod", new StringBuilder());
        BrokerRequiredException brokerRequiredException = new BrokerRequiredException(BrokerData.getProdMicrosoftAuthenticator().getPackageName(), null);
        Logger.error(strM1170p, "Broker required.", brokerRequiredException);
        throw brokerRequiredException;
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public void onFinishAuthorizationSession(int i, int i2, @NonNull PropertyBag propertyBag) throws Exception {
        Logger.verbose(TAG + ":onFinishAuthorizationSession", "Completing authorization...");
        Telemetry.emit(new ApiStartEvent().putApiId(TelemetryEventStrings.Api.LOCAL_COMPLETE_ACQUIRE_TOKEN_INTERACTIVE).put(TelemetryEventStrings.Key.RESULT_CODE, String.valueOf(i2)).put(TelemetryEventStrings.Key.REQUEST_CODE, String.valueOf(i)));
        try {
            this.mAuthorizationStrategy.completeAuthorization(i, RawAuthorizationResult.fromPropertyBag(propertyBag));
        } catch (Exception e) {
            Future<AuthorizationResult> future = this.mAuthorizationFuture;
            if (future == null || !(future instanceof ResultFuture) || future.isDone()) {
                throw e;
            }
            ((ResultFuture) this.mAuthorizationFuture).setException(e);
        }
        Telemetry.emit(new ApiEndEvent().putApiId(TelemetryEventStrings.Api.LOCAL_COMPLETE_ACQUIRE_TOKEN_INTERACTIVE));
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @WorkerThread
    public boolean removeAccount(@NonNull RemoveAccountCommandParameters removeAccountCommandParameters) {
        Telemetry.emit(new ApiStartEvent().putProperties(removeAccountCommandParameters).putApiId(TelemetryEventStrings.Api.LOCAL_REMOVE_ACCOUNT));
        boolean z = !removeAccountCommandParameters.getOAuth2TokenCache().removeAccount(null, removeAccountCommandParameters.getClientId(), removeAccountCommandParameters.getAccount() == null ? null : removeAccountCommandParameters.getAccount().getHomeAccountId(), removeAccountCommandParameters.getAccount() != null ? removeAccountCommandParameters.getAccount().getRealm() : null).isEmpty();
        Telemetry.emit(new ApiEndEvent().put(TelemetryEventStrings.Key.IS_SUCCESSFUL, String.valueOf(z)).putApiId(TelemetryEventStrings.Api.LOCAL_REMOVE_ACCOUNT));
        return z;
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean removeCurrentAccount(RemoveAccountCommandParameters removeAccountCommandParameters) {
        return removeAccount(removeAccountCommandParameters);
    }
}
