package com.microsoft.identity.common.internal.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.PropertyBagUtil;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.BrokerActivity;
import com.microsoft.identity.common.internal.broker.BrokerResult;
import com.microsoft.identity.common.internal.broker.ipc.AccountManagerAddAccountStrategy;
import com.microsoft.identity.common.internal.broker.ipc.BoundServiceStrategy;
import com.microsoft.identity.common.internal.broker.ipc.BrokerOperationBundle;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.internal.cache.ActiveBrokerCacheUpdater;
import com.microsoft.identity.common.internal.cache.ClientActiveBrokerCache;
import com.microsoft.identity.common.internal.cache.HelloCache;
import com.microsoft.identity.common.internal.cache.HelloCacheResult;
import com.microsoft.identity.common.internal.commands.parameters.AndroidActivityInteractiveTokenCommandParameters;
import com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;
import com.microsoft.identity.common.internal.telemetry.events.ApiStartEvent;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeWithClientKeyInternal;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.java.commands.AcquirePrtSsoTokenResult;
import com.microsoft.identity.common.java.commands.parameters.AcquirePrtSsoTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.GenerateShrCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.RemoveAccountCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.exception.UnsupportedBrokerException;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.p132ui.PreferredAuthMethod;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAccount;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.result.GenerateShrResult;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.BrokerProtocolVersionUtil;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ThreadUtils;
import com.microsoft.identity.common.java.util.ported.LocalBroadcaster;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.identity.common.sharedwithoneauth.OneAuthSharedFunctions;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerMsalController extends BaseController {
    private static final String TAG = "BrokerMsalController";

    @Nullable
    private final List<IIpcStrategy> ipcStrategies;
    private final String mActiveBrokerPackageName;
    private final Context mApplicationContext;
    private ResultFuture<Bundle> mBrokerResultFuture;
    private final IPlatformComponents mComponents;
    private final HelloCache mHelloCache;
    private BrokerOperationExecutor mOperationExecutor;
    protected final MsalBrokerRequestAdapter mRequestAdapter;
    protected final MsalBrokerResultAdapter mResultAdapter;
    private static final long WAIT_BETWEEN_DCF_POLLING_MILLISECONDS = TimeUnit.SECONDS.toMillis(5);
    private static final long HELLO_CACHE_ENTRY_TIMEOUT = TimeUnit.HOURS.toMillis(4);

    @VisibleForTesting
    public BrokerMsalController(@NonNull Context context, @NonNull IPlatformComponents iPlatformComponents, @NonNull String str, @Nullable List<IIpcStrategy> list) {
        this.mRequestAdapter = new MsalBrokerRequestAdapter();
        this.mResultAdapter = new MsalBrokerResultAdapter();
        this.mComponents = iPlatformComponents;
        this.mApplicationContext = context;
        this.mActiveBrokerPackageName = str;
        this.ipcStrategies = list;
        this.mHelloCache = getHelloCache();
    }

    @NonNull
    private Intent getBrokerAuthorizationIntent(@NonNull final InteractiveTokenCommandParameters interactiveTokenCommandParameters) {
        return (Intent) getBrokerOperationExecutor().execute(interactiveTokenCommandParameters, new BrokerOperationExecutor.BrokerOperation<Intent>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.2
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_GET_INTENT_FOR_INTERACTIVE_REQUEST, BrokerMsalController.this.mActiveBrokerPackageName, null);
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getMethodName() {
                return ":getBrokerAuthorizationIntent";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @Nullable
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy) throws ClientException {
                BrokerMsalController.this.verifyTokenParametersAreSupported(interactiveTokenCommandParameters);
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, interactiveTokenCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull Intent intent) {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public Intent extractResultBundle(@Nullable Bundle bundle) throws ClientException {
                if (bundle == null) {
                    throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
                }
                Intent intentForInteractiveRequestFromResultBundle = BrokerMsalController.this.mResultAdapter.getIntentForInteractiveRequestFromResultBundle(bundle, this.negotiatedBrokerProtocolVersion);
                intentForInteractiveRequestFromResultBundle.putExtras(BrokerMsalController.this.mRequestAdapter.getRequestBundleForAcquireTokenInteractive(interactiveTokenCommandParameters, this.negotiatedBrokerProtocolVersion));
                return intentForInteractiveRequestFromResultBundle;
            }
        });
    }

    @NonNull
    @WorkerThread
    private synchronized BrokerOperationExecutor getBrokerOperationExecutor() {
        try {
            if (this.mOperationExecutor == null) {
                List<IIpcStrategy> ipcStrategies = this.ipcStrategies;
                if (ipcStrategies == null) {
                    ipcStrategies = OneAuthSharedFunctions.getIpcStrategies(this.mApplicationContext, this.mActiveBrokerPackageName);
                }
                this.mOperationExecutor = new BrokerOperationExecutor(ipcStrategies, new ActiveBrokerCacheUpdater(this.mApplicationContext, ClientActiveBrokerCache.getClientSdkCache(this.mComponents.getStorageSupplier())));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mOperationExecutor;
    }

    private void msalOAuth2TokenCacheSetSingleSignOnState(@NonNull MsalOAuth2TokenCache msalOAuth2TokenCache, MicrosoftStsAccount microsoftStsAccount, MicrosoftRefreshToken microsoftRefreshToken) throws ClientException {
        msalOAuth2TokenCache.setSingleSignOnState(microsoftStsAccount, microsoftRefreshToken);
    }

    private void saveMsaAccountToCache(@NonNull Bundle bundle, @NonNull MsalOAuth2TokenCache msalOAuth2TokenCache) throws ClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":saveMsaAccountToCache", new StringBuilder());
        BrokerResult brokerResultBrokerResultFromBundle = new MsalBrokerResultAdapter().brokerResultFromBundle(bundle);
        if (bundle.getBoolean(AuthenticationConstants.Broker.BROKER_REQUEST_V2_SUCCESS) && AzureActiveDirectoryAudience.MSA_MEGA_TENANT_ID.equalsIgnoreCase(brokerResultBrokerResultFromBundle.getTenantId())) {
            Logger.info(strM1170p, "Result returned for MSA Account, saving to cache");
            if (StringUtil.isNullOrEmpty(brokerResultBrokerResultFromBundle.getClientInfo())) {
                Logger.error(strM1170p, "ClientInfo is empty.", null);
                throw new ClientException("unknown_error", "ClientInfo is empty.");
            }
            try {
                ClientInfo clientInfo = new ClientInfo(brokerResultBrokerResultFromBundle.getClientInfo());
                MicrosoftStsAccount microsoftStsAccount = new MicrosoftStsAccount(new IDToken(brokerResultBrokerResultFromBundle.getIdToken()), clientInfo);
                microsoftStsAccount.setEnvironment(brokerResultBrokerResultFromBundle.getEnvironment());
                msalOAuth2TokenCacheSetSingleSignOnState(msalOAuth2TokenCache, microsoftStsAccount, new MicrosoftRefreshToken(brokerResultBrokerResultFromBundle.getRefreshToken(), clientInfo, brokerResultBrokerResultFromBundle.getScope(), brokerResultBrokerResultFromBundle.getClientId(), brokerResultBrokerResultFromBundle.getEnvironment(), brokerResultBrokerResultFromBundle.getFamilyId()));
            } catch (ServiceException e) {
                Logger.errorPII(strM1170p, "Exception while creating Idtoken or ClientInfo, cannot save MSA account tokens", e);
                throw new ClientException("invalid_jwt", e.getMessage(), e);
            }
        }
    }

    @edu.umd.cs.findbugs.annotations.Nullable
    private String tryGetNegotiatedProtocolVersionFromHelloCache(@Nullable String str, @NonNull String str2) throws UnsupportedBrokerException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":tryGetNegotiatedProtocolVersionFromHelloCache", new StringBuilder());
        HelloCacheResult helloCacheResult = this.mHelloCache.getHelloCacheResult(str, str2);
        if (helloCacheResult == null) {
            Logger.info(strM1170p, "No valid entry found in cache");
            return null;
        }
        if (helloCacheResult.isHandShakeError()) {
            Logger.info(strM1170p, "Handshake error from cache.");
            throw new UnsupportedBrokerException(this.mActiveBrokerPackageName);
        }
        String negotiatedProtocolVersion = helloCacheResult.getNegotiatedProtocolVersion();
        if (!StringUtil.isNullOrEmpty(negotiatedProtocolVersion)) {
            return negotiatedProtocolVersion;
        }
        Logger.warn(strM1170p, "Unexpected: cachedProtocolVersion is empty. Continue with hello IPC protocol.");
        return null;
    }

    private void validateNestedAppAuthParameters(@NonNull TokenCommandParameters tokenCommandParameters, @NonNull String str) throws ClientException {
        if (tokenCommandParameters.hasNestedAppParameters()) {
            if (!StringUtil.isNullOrEmpty(tokenCommandParameters.getChildClientId()) && !StringUtil.isNullOrEmpty(tokenCommandParameters.getChildRedirectUri()) && !BrokerProtocolVersionUtil.canSupportNestedAppAuthentication(str)) {
                throw new ClientException(ClientException.NESTED_APP_AUTH_NOT_SUPPORTED, AbstractC0541b.m772n("The min broker protocol version for Nested app auth should be equal or more than 15.0. Current required version is set to: ", str));
            }
            if (StringUtil.isNullOrEmpty(tokenCommandParameters.getChildClientId())) {
                throw new ClientException(ClientException.NESTED_APP_INVALID_PARAMETERS, "ClientId of the nested app is null or empty");
            }
            if (StringUtil.isNullOrEmpty(tokenCommandParameters.getChildRedirectUri())) {
                throw new ClientException(ClientException.NESTED_APP_INVALID_PARAMETERS, "RedirectURI of the nested app is null or empty");
            }
            if (tokenCommandParameters.getSdkType() != SdkType.MSAL_CPP) {
                throw new ClientException(ClientException.NESTED_APP_INVALID_PARAMETERS, "Nested app auth is only supported for request originating from OneAuth");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyBrokerVersionIsSupported(@Nullable Bundle bundle, @Nullable String str) throws UnsupportedBrokerException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":verifyBrokerVersionIsSupported", new StringBuilder());
        if (bundle == null) {
            Logger.info(strM1170p, "result bundle is null");
            return;
        }
        try {
            BrokerResult brokerResultBrokerResultFromBundle = this.mResultAdapter.brokerResultFromBundle(bundle);
            if (!brokerResultBrokerResultFromBundle.isSuccess() && ErrorStrings.UNSUPPORTED_BROKER_VERSION_ERROR_CODE.equals(brokerResultBrokerResultFromBundle.getErrorCode())) {
                this.mHelloCache.saveHandshakeError(str, "15.0");
                throw new UnsupportedBrokerException(this.mActiveBrokerPackageName);
            }
        } catch (ClientException unused) {
            Logger.info(strM1170p, "ResultBundle does not contain BrokerResult. So, this is not likely a broker version supported issue. Continuing.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyTokenParametersAreSupported(@NonNull TokenCommandParameters tokenCommandParameters) throws ClientException {
        String requiredBrokerProtocolVersion = tokenCommandParameters.getRequiredBrokerProtocolVersion();
        if ((tokenCommandParameters.getAuthenticationScheme() instanceof PopAuthenticationSchemeWithClientKeyInternal) && !BrokerProtocolVersionUtil.canSupportPopAuthenticationSchemeWithClientKey(requiredBrokerProtocolVersion)) {
            throw new ClientException(ClientException.AUTH_SCHEME_NOT_SUPPORTED, AbstractC0541b.m772n("The min broker protocol version for PopAuthenticationSchemeWithClientKey should be equal or more than 11.0. Current required version is set to: ", requiredBrokerProtocolVersion));
        }
        validateNestedAppAuthParameters(tokenCommandParameters, requiredBrokerProtocolVersion);
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AcquireTokenResult acquireDeviceCodeFlowToken(final AuthorizationResult authorizationResult, final DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters) {
        return (AcquireTokenResult) getBrokerOperationExecutor().execute(deviceCodeFlowCommandParameters, new BrokerOperationExecutor.BrokerOperation<AcquireTokenResult>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.4
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                BrokerOperationBundle.Operation operation = BrokerOperationBundle.Operation.MSAL_ACQUIRE_TOKEN_DCF;
                String str = BrokerMsalController.this.mActiveBrokerPackageName;
                BrokerMsalController brokerMsalController = BrokerMsalController.this;
                return new BrokerOperationBundle(operation, str, brokerMsalController.mRequestAdapter.getRequestBundleForDeviceCodeFlowTokenRequest(brokerMsalController.mApplicationContext, deviceCodeFlowCommandParameters, authorizationResult, this.negotiatedBrokerProtocolVersion));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getMethodName() {
                return ":deviceCodeFlowAuthRequest";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @Nullable
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy) {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, deviceCodeFlowCommandParameters.getRequiredBrokerProtocolVersion());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public AcquireTokenResult extractResultBundle(@Nullable Bundle bundle) throws UnsupportedBrokerException, ClientException {
                if (bundle == null) {
                    throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
                }
                BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, deviceCodeFlowCommandParameters.getRequiredBrokerProtocolVersion());
                AcquireTokenResult deviceCodeFlowTokenResultFromResultBundle = BrokerMsalController.this.mResultAdapter.getDeviceCodeFlowTokenResultFromResultBundle(bundle);
                if (deviceCodeFlowTokenResultFromResultBundle != null) {
                    return deviceCodeFlowTokenResultFromResultBundle;
                }
                ThreadUtils.sleepSafely((int) BrokerMsalController.WAIT_BETWEEN_DCF_POLLING_MILLISECONDS, BrokerMsalController.TAG, "Attempting to sleep thread during Device Code Flow token polling...");
                return BrokerMsalController.this.acquireDeviceCodeFlowToken(authorizationResult, deviceCodeFlowCommandParameters);
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull AcquireTokenResult acquireTokenResult) {
                apiEndEvent.putResult(acquireTokenResult);
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AcquireTokenResult acquireToken(@NonNull InteractiveTokenCommandParameters interactiveTokenCommandParameters) throws Exception {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":acquireToken", new StringBuilder());
        Telemetry.emit(new ApiStartEvent().putProperties(interactiveTokenCommandParameters).putApiId("201"));
        this.mBrokerResultFuture = new ResultFuture<>();
        Intent brokerAuthorizationIntent = getBrokerAuthorizationIntent(interactiveTokenCommandParameters);
        Activity activity = interactiveTokenCommandParameters instanceof AndroidActivityInteractiveTokenCommandParameters ? ((AndroidActivityInteractiveTokenCommandParameters) interactiveTokenCommandParameters).getActivity() : null;
        Intent intent = new Intent(this.mApplicationContext, (Class<?>) BrokerActivity.class);
        intent.putExtra(BrokerActivity.BROKER_INTENT, brokerAuthorizationIntent);
        LocalBroadcaster.INSTANCE.registerCallback(AuthenticationConstants.LocalBroadcasterAliases.RETURN_BROKER_INTERACTIVE_ACQUIRE_TOKEN_RESULT, new LocalBroadcaster.IReceiverCallback() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.1
            @Override // com.microsoft.identity.common.java.util.ported.LocalBroadcaster.IReceiverCallback
            public void onReceive(@NonNull PropertyBag propertyBag) {
                Logger.verbose(strM1170p, "Received result from Broker...");
                Telemetry.emit(new ApiStartEvent().putApiId("202").put(TelemetryEventStrings.Key.REQUEST_CODE, ((Integer) propertyBag.getOrDefault(AuthenticationConstants.LocalBroadcasterFields.REQUEST_CODE, -1)).toString()).put(TelemetryEventStrings.Key.RESULT_CODE, ((Integer) propertyBag.getOrDefault(AuthenticationConstants.LocalBroadcasterFields.RESULT_CODE, -1)).toString()));
                BrokerMsalController.this.mBrokerResultFuture.setResult(PropertyBagUtil.toBundle(propertyBag));
                Telemetry.emit(new ApiEndEvent().putApiId("202"));
                LocalBroadcaster.INSTANCE.unregisterCallback(AuthenticationConstants.LocalBroadcasterAliases.RETURN_BROKER_INTERACTIVE_ACQUIRE_TOKEN_RESULT);
            }
        });
        if (activity == null) {
            intent.addFlags(268435456);
            this.mApplicationContext.startActivity(intent);
        } else {
            activity.startActivity(intent);
        }
        try {
            Bundle bundle = this.mBrokerResultFuture.get();
            String stringExtra = brokerAuthorizationIntent.getStringExtra(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY);
            if (interactiveTokenCommandParameters.getOAuth2TokenCache() != null && !BrokerProtocolVersionUtil.canSupportMsaAccountsInBroker(stringExtra)) {
                saveMsaAccountToCache(bundle, (MsalOAuth2TokenCache) interactiveTokenCommandParameters.getOAuth2TokenCache());
            }
            verifyBrokerVersionIsSupported(bundle, interactiveTokenCommandParameters.getRequiredBrokerProtocolVersion());
            AcquireTokenResult acquireTokenResultFromResultBundle = this.mResultAdapter.getAcquireTokenResultFromResultBundle(bundle);
            Telemetry.emit(new ApiEndEvent().putResult(acquireTokenResultFromResultBundle).putApiId("201"));
            return acquireTokenResultFromResultBundle;
        } catch (BaseException e) {
            e = e;
            Telemetry.emit(new ApiEndEvent().putException(e).putApiId("201"));
            throw e;
        } catch (ExecutionException e2) {
            e = e2;
            Telemetry.emit(new ApiEndEvent().putException(e).putApiId("201"));
            throw e;
        }
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @NonNull
    public AcquireTokenResult acquireTokenSilent(@NonNull final SilentTokenCommandParameters silentTokenCommandParameters) {
        return (AcquireTokenResult) getBrokerOperationExecutor().execute(silentTokenCommandParameters, new BrokerOperationExecutor.BrokerOperation<AcquireTokenResult>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.5
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public BrokerOperationBundle getBundle() {
                BrokerOperationBundle.Operation operation = BrokerOperationBundle.Operation.MSAL_ACQUIRE_TOKEN_SILENT;
                String str = BrokerMsalController.this.mActiveBrokerPackageName;
                BrokerMsalController brokerMsalController = BrokerMsalController.this;
                return new BrokerOperationBundle(operation, str, brokerMsalController.mRequestAdapter.getRequestBundleForAcquireTokenSilent(brokerMsalController.mApplicationContext, silentTokenCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getMethodName() {
                return ":acquireTokenSilent";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getTelemetryApiId() {
                return TelemetryEventStrings.Api.BROKER_ACQUIRE_TOKEN_SILENT;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy) throws ClientException {
                BrokerMsalController.this.verifyTokenParametersAreSupported(silentTokenCommandParameters);
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, silentTokenCommandParameters.getRequiredBrokerProtocolVersion());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public AcquireTokenResult extractResultBundle(@Nullable Bundle bundle) throws UnsupportedBrokerException, ClientException {
                if (bundle == null) {
                    throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
                }
                BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, silentTokenCommandParameters.getRequiredBrokerProtocolVersion());
                return BrokerMsalController.this.mResultAdapter.getAcquireTokenResultFromResultBundle(bundle);
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull AcquireTokenResult acquireTokenResult) {
                apiEndEvent.putResult(acquireTokenResult);
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AcquireTokenResult acquireTokenWithPassword(@lombok.NonNull RopcTokenCommandParameters ropcTokenCommandParameters) throws ClientException {
        if (ropcTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        throw new ClientException("acquireTokenWithPassword() not supported in BrokerMsalController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean canEqual(Object obj) {
        return obj instanceof BrokerMsalController;
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AuthorizationResult deviceCodeFlowAuthRequest(final DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters) {
        return (AuthorizationResult) getBrokerOperationExecutor().execute(deviceCodeFlowCommandParameters, new BrokerOperationExecutor.BrokerOperation<AuthorizationResult>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.3
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                BrokerOperationBundle.Operation operation = BrokerOperationBundle.Operation.MSAL_FETCH_DCF_AUTH_RESULT;
                String str = BrokerMsalController.this.mActiveBrokerPackageName;
                BrokerMsalController brokerMsalController = BrokerMsalController.this;
                return new BrokerOperationBundle(operation, str, brokerMsalController.mRequestAdapter.getRequestBundleForDeviceCodeFlowAuthRequest(brokerMsalController.mApplicationContext, deviceCodeFlowCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getMethodName() {
                return ":deviceCodeFlowAuthRequest";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @Nullable
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy) {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, deviceCodeFlowCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull AuthorizationResult authorizationResult) {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public AuthorizationResult extractResultBundle(@Nullable Bundle bundle) throws UnsupportedBrokerException, ClientException {
                if (bundle == null) {
                    throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
                }
                BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, deviceCodeFlowCommandParameters.getRequiredBrokerProtocolVersion());
                return BrokerMsalController.this.mResultAdapter.getDeviceCodeFlowAuthResultFromResultBundle(bundle);
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BrokerMsalController) && ((BrokerMsalController) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public GenerateShrResult generateSignedHttpRequest(@NonNull final GenerateShrCommandParameters generateShrCommandParameters) {
        return (GenerateShrResult) getBrokerOperationExecutor().execute(generateShrCommandParameters, new BrokerOperationExecutor.BrokerOperation<GenerateShrResult>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.12
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_GENERATE_SHR, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForGenerateShr(generateShrCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getMethodName() {
                return ":generateSignedHttpRequest";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @Nullable
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy) {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, generateShrCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull GenerateShrResult generateShrResult) {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public GenerateShrResult extractResultBundle(@Nullable Bundle bundle) throws UnsupportedBrokerException, ClientException {
                if (bundle == null) {
                    throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
                }
                BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, generateShrCommandParameters.getRequiredBrokerProtocolVersion());
                return BrokerMsalController.this.mResultAdapter.getGenerateShrResultFromResultBundle(bundle);
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @NonNull
    public List<ICacheRecord> getAccounts(@NonNull final CommandParameters commandParameters) {
        return (List) getBrokerOperationExecutor().execute(commandParameters, new BrokerOperationExecutor.BrokerOperation<List<ICacheRecord>>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.6
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_GET_ACCOUNTS, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForGetAccounts(commandParameters, this.negotiatedBrokerProtocolVersion));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getMethodName() {
                return ":getAccounts";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getTelemetryApiId() {
                return TelemetryEventStrings.Api.BROKER_GET_ACCOUNTS;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy) {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, commandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public List<ICacheRecord> extractResultBundle(@Nullable Bundle bundle) throws UnsupportedBrokerException, ClientException {
                if (bundle == null) {
                    throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
                }
                BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, commandParameters.getRequiredBrokerProtocolVersion());
                return BrokerMsalController.this.mResultAdapter.getAccountsFromResultBundle(bundle);
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull List<ICacheRecord> list) {
                apiEndEvent.put(TelemetryEventStrings.Key.ACCOUNTS_NUMBER, Integer.toString(list.size()));
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @NonNull
    public List<ICacheRecord> getCurrentAccount(@NonNull final CommandParameters commandParameters) {
        if (commandParameters.isSharedDevice()) {
            return (List) getBrokerOperationExecutor().execute(commandParameters, new BrokerOperationExecutor.BrokerOperation<List<ICacheRecord>>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.10
                private String negotiatedBrokerProtocolVersion;

                @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
                @NonNull
                public BrokerOperationBundle getBundle() {
                    return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_GET_CURRENT_ACCOUNT_IN_SHARED_DEVICE, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForGetAccounts(commandParameters, this.negotiatedBrokerProtocolVersion));
                }

                @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
                @NonNull
                public String getMethodName() {
                    return ":getCurrentAccount";
                }

                @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
                @NonNull
                public String getTelemetryApiId() {
                    return TelemetryEventStrings.Api.BROKER_GET_CURRENT_ACCOUNT;
                }

                @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
                public void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy) {
                    this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, commandParameters.getRequiredBrokerProtocolVersion());
                }

                @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
                @NonNull
                public List<ICacheRecord> extractResultBundle(@Nullable Bundle bundle) throws UnsupportedBrokerException, ClientException {
                    if (bundle == null) {
                        throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
                    }
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, commandParameters.getRequiredBrokerProtocolVersion());
                    return BrokerMsalController.this.mResultAdapter.getAccountsFromResultBundle(bundle);
                }

                @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
                public void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull List<ICacheRecord> list) {
                    apiEndEvent.put(TelemetryEventStrings.Key.ACCOUNTS_NUMBER, Integer.toString(list.size()));
                }
            });
        }
        Logger.verbose(TAG + ":getCurrentAccount", "Not a shared device, invoke getAccounts() instead of getCurrentAccount()");
        return getAccounts(commandParameters);
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean getDeviceMode(@NonNull CommandParameters commandParameters) {
        return ((Boolean) getBrokerOperationExecutor().execute(commandParameters, new BrokerOperationExecutor.BrokerOperation<Boolean>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.9
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_GET_DEVICE_MODE, BrokerMsalController.this.mActiveBrokerPackageName, null);
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getMethodName() {
                return ":getDeviceMode";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getTelemetryApiId() {
                return TelemetryEventStrings.Api.GET_BROKER_DEVICE_MODE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public Boolean extractResultBundle(@Nullable Bundle bundle) throws ClientException {
                if (bundle != null) {
                    return Boolean.valueOf(BrokerMsalController.this.mResultAdapter.getDeviceModeFromResultBundle(bundle));
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull Boolean bool) {
                apiEndEvent.put(TelemetryEventStrings.Key.IS_DEVICE_SHARED, Boolean.toString(bool.booleanValue()));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy) {
            }
        })).booleanValue();
    }

    @VisibleForTesting
    public HelloCache getHelloCache() {
        return new HelloCache(this.mApplicationContext, AuthenticationConstants.Broker.MSAL_TO_BROKER_PROTOCOL_NAME, this.mActiveBrokerPackageName, this.mComponents, HELLO_CACHE_ENTRY_TIMEOUT);
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public PreferredAuthMethod getPreferredAuthMethod() {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":getPreferredAuthMethod", new StringBuilder());
        return (PreferredAuthMethod) getBrokerOperationExecutor().execute(null, new BrokerOperationExecutor.BrokerOperation<PreferredAuthMethod>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.8
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_GET_PREFERRED_AUTH_METHOD, BrokerMsalController.this.mActiveBrokerPackageName, null);
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getMethodName() {
                return ":getPreferredAuthMethod";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getTelemetryApiId() {
                return TelemetryEventStrings.Api.GET_PREFERRED_AUTH_METHOD;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy) throws BrokerCommunicationException {
                if ((iIpcStrategy instanceof BoundServiceStrategy) || (iIpcStrategy instanceof AccountManagerAddAccountStrategy)) {
                    String str = iIpcStrategy + " is not supported for getPreferredAuthMethod operation";
                    Logger.warn(strM1170p, str);
                    throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE, iIpcStrategy.getType(), str, null);
                }
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull PreferredAuthMethod preferredAuthMethod) {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public PreferredAuthMethod extractResultBundle(@Nullable Bundle bundle) {
                return BrokerMsalController.this.mResultAdapter.getPreferredAuthMethodFromResultBundle(bundle);
            }
        });
    }

    public AcquirePrtSsoTokenResult getSsoToken(@NonNull final AcquirePrtSsoTokenCommandParameters acquirePrtSsoTokenCommandParameters) {
        return (AcquirePrtSsoTokenResult) getBrokerOperationExecutor().execute(acquirePrtSsoTokenCommandParameters, new BrokerOperationExecutor.BrokerOperation<AcquirePrtSsoTokenResult>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.13
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_SSO_TOKEN, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForSsoToken(acquirePrtSsoTokenCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getMethodName() {
                return ":getSsoToken";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @Nullable
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy) {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, acquirePrtSsoTokenCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull AcquirePrtSsoTokenResult acquirePrtSsoTokenResult) {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public AcquirePrtSsoTokenResult extractResultBundle(@Nullable Bundle bundle) throws UnsupportedBrokerException, ClientException {
                if (bundle == null) {
                    throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
                }
                BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, acquirePrtSsoTokenCommandParameters.getRequiredBrokerProtocolVersion());
                return BrokerMsalController.this.mResultAdapter.getAcquirePrtSsoTokenResultFromBundle(bundle);
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    @VisibleForTesting
    public String hello(@NonNull IIpcStrategy iIpcStrategy, @Nullable String str) {
        return hello(iIpcStrategy, str, "15.0");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public void onFinishAuthorizationSession(int i, int i2, @NonNull PropertyBag propertyBag) {
        throw new UnsupportedOperationException();
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean removeAccount(@NonNull final RemoveAccountCommandParameters removeAccountCommandParameters) {
        return ((Boolean) getBrokerOperationExecutor().execute(removeAccountCommandParameters, new BrokerOperationExecutor.BrokerOperation<Boolean>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.7
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_REMOVE_ACCOUNT, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForRemoveAccount(removeAccountCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getMethodName() {
                return ":removeAccount";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public String getTelemetryApiId() {
                return TelemetryEventStrings.Api.BROKER_REMOVE_ACCOUNT;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy) {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, removeAccountCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull Boolean bool) {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            @NonNull
            public Boolean extractResultBundle(@Nullable Bundle bundle) throws BaseException {
                BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, removeAccountCommandParameters.getRequiredBrokerProtocolVersion());
                BrokerMsalController.this.mResultAdapter.verifyRemoveAccountResultFromBundle(bundle);
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean removeCurrentAccount(@NonNull final RemoveAccountCommandParameters removeAccountCommandParameters) {
        if (removeAccountCommandParameters.isSharedDevice()) {
            return ((Boolean) getBrokerOperationExecutor().execute(removeAccountCommandParameters, new BrokerOperationExecutor.BrokerOperation<Boolean>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.11
                private String negotiatedBrokerProtocolVersion;

                @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
                @NonNull
                public BrokerOperationBundle getBundle() {
                    return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_SIGN_OUT_FROM_SHARED_DEVICE, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForRemoveAccountFromSharedDevice(removeAccountCommandParameters, this.negotiatedBrokerProtocolVersion));
                }

                @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
                @NonNull
                public String getMethodName() {
                    return ":removeCurrentAccount";
                }

                @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
                @NonNull
                public String getTelemetryApiId() {
                    return TelemetryEventStrings.Api.BROKER_REMOVE_ACCOUNT_FROM_SHARED_DEVICE;
                }

                @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
                public void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy) {
                    this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, removeAccountCommandParameters.getRequiredBrokerProtocolVersion());
                }

                @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
                public void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull Boolean bool) {
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
                @NonNull
                public Boolean extractResultBundle(@Nullable Bundle bundle) throws BaseException {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, removeAccountCommandParameters.getRequiredBrokerProtocolVersion());
                    BrokerMsalController.this.mResultAdapter.verifyRemoveAccountResultFromBundle(bundle);
                    return Boolean.TRUE;
                }
            })).booleanValue();
        }
        Logger.verbose(":removeCurrentAccount", "Not a shared device, invoke removeAccount() instead of removeCurrentAccount()");
        return removeAccount(removeAccountCommandParameters);
    }

    @NonNull
    @VisibleForTesting
    public String hello(@NonNull IIpcStrategy iIpcStrategy, @Nullable String str, @NonNull String str2) throws UnsupportedBrokerException, ClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":hello", new StringBuilder());
        String strTryGetNegotiatedProtocolVersionFromHelloCache = tryGetNegotiatedProtocolVersionFromHelloCache(str, str2);
        if (!StringUtil.isNullOrEmpty(strTryGetNegotiatedProtocolVersionFromHelloCache)) {
            return strTryGetNegotiatedProtocolVersionFromHelloCache;
        }
        String str3 = this.mActiveBrokerPackageName;
        StringBuilder sbM16m = AbstractC0000a.m16m("Calling broker for to establish negotiated protocol version for: MinRequestVersion=", str, ", ClientMaxProtocolVersion=", str2, ", ActiveBroker=");
        sbM16m.append(str3);
        Logger.info(strM1170p, sbM16m.toString());
        Bundle bundle = new Bundle();
        bundle.putString(AuthenticationConstants.Broker.CLIENT_ADVERTISED_MAXIMUM_BP_VERSION_KEY, str2);
        if (!StringUtil.isNullOrEmpty(str)) {
            bundle.putString(AuthenticationConstants.Broker.CLIENT_CONFIGURED_MINIMUM_BP_VERSION_KEY, str);
        }
        try {
            String strVerifyHelloFromResultBundle = this.mResultAdapter.verifyHelloFromResultBundle(this.mActiveBrokerPackageName, iIpcStrategy.communicateToBroker(new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_HELLO, this.mActiveBrokerPackageName, bundle)));
            this.mHelloCache.saveNegotiatedProtocolVersion(str, str2, strVerifyHelloFromResultBundle);
            return strVerifyHelloFromResultBundle;
        } catch (UnsupportedBrokerException e) {
            this.mHelloCache.saveHandshakeError(str, str2);
            throw e;
        }
    }

    public BrokerMsalController(@NonNull Context context, @NonNull IPlatformComponents iPlatformComponents, @NonNull String str) {
        this(context, iPlatformComponents, str, null);
    }
}
