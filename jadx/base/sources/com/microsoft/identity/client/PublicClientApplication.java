package com.microsoft.identity.client;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.client.AcquireTokenParameters;
import com.microsoft.identity.client.AcquireTokenSilentParameters;
import com.microsoft.identity.client.DeviceCodeFlowParameters;
import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.Logger;
import com.microsoft.identity.client.claims.ClaimsRequest;
import com.microsoft.identity.client.configuration.AccountMode;
import com.microsoft.identity.client.configuration.LoggerConfiguration;
import com.microsoft.identity.client.exception.MsalArgumentException;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.exception.MsalUiRequiredException;
import com.microsoft.identity.client.helper.BrokerHelperActivity;
import com.microsoft.identity.client.internal.AsyncResult;
import com.microsoft.identity.client.internal.CommandParametersAdapter;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.client.internal.controllers.MSALControllerFactory;
import com.microsoft.identity.client.internal.controllers.MsalExceptionAdapter;
import com.microsoft.identity.common.adal.internal.tokensharing.TokenShareUtility;
import com.microsoft.identity.common.components.AndroidPlatformComponentsFactory;
import com.microsoft.identity.common.crypto.AndroidAuthSdkStorageEncryptionManager;
import com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClientFactory;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;
import com.microsoft.identity.common.internal.commands.GenerateShrCommand;
import com.microsoft.identity.common.internal.commands.GetDeviceModeCommand;
import com.microsoft.identity.common.internal.commands.GetPreferredAuthMethodFromAuthenticator;
import com.microsoft.identity.common.internal.controllers.LocalMSALController;
import com.microsoft.identity.common.internal.migration.AdalMigrationAdapter;
import com.microsoft.identity.common.internal.migration.TokenMigrationCallback;
import com.microsoft.identity.common.internal.migration.TokenMigrationUtility;
import com.microsoft.identity.common.internal.net.cache.HttpCache;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryB2CAuthority;
import com.microsoft.identity.common.java.authorities.CIAMAuthority;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.cache.IShareSingleSignOnState;
import com.microsoft.identity.common.java.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.commands.DeviceCodeFlowCommand;
import com.microsoft.identity.common.java.commands.DeviceCodeFlowCommandCallback;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.commands.InteractiveTokenCommand;
import com.microsoft.identity.common.java.commands.SilentTokenCommand;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.controllers.CommandResult;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.nativeauth.BuildValues;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.OtelContextExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.p132ui.PreferredAuthMethod;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.result.GenerateShrResult;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.java.result.LocalAuthenticationResult;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.java.util.SchemaUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.msal.BuildConfig;
import com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfigurationFactory;
import com.samsung.android.sdk.mobileservice.auth.TokenInfo;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PublicClientApplication implements IPublicClientApplication, ITokenShare {
    private static final String ACCESS_NETWORK_STATE_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
    private static final String ERR_UNSUPPORTED_OPERATION = "This method is unsupported.";
    private static final String INTERNET_PERMISSION = "android.permission.INTERNET";
    private static final String TAG = "PublicClientApplication";
    private static final String TSL_MSG_FAILED_TO_SAVE = "Failed to save FRT - see getCause() for additional Exception info";
    private static final String TSM_MSG_FAILED_TO_RETRIEVE = "Failed to retrieve FRT - see getCause() for additional Exception info";
    private static final ExecutorService sBackgroundExecutor = Executors.newCachedThreadPool();
    protected PublicClientApplicationConfiguration mPublicClientConfiguration;
    protected TokenShareUtility mTokenShareUtility;
    protected AccountMatcher homeAccountMatcher = new AccountMatcher() { // from class: com.microsoft.identity.client.PublicClientApplication.21
        @Override // com.microsoft.identity.client.PublicClientApplication.AccountMatcher
        public boolean matches(@NonNull String str, @NonNull IAccount iAccount) {
            return str.contains(iAccount.getId());
        }
    };
    protected AccountMatcher localAccountMatcher = new AccountMatcher() { // from class: com.microsoft.identity.client.PublicClientApplication.22
        @Override // com.microsoft.identity.client.PublicClientApplication.AccountMatcher
        public boolean matches(@NonNull String str, @NonNull IAccount iAccount) {
            Map<String, ITenantProfile> tenantProfiles;
            if (str.contains(iAccount.getId())) {
                return true;
            }
            if (!(iAccount instanceof MultiTenantAccount) || (tenantProfiles = ((MultiTenantAccount) iAccount).getTenantProfiles()) == null || tenantProfiles.isEmpty()) {
                return false;
            }
            for (Map.Entry<String, ITenantProfile> entry : tenantProfiles.entrySet()) {
                if (!TextUtils.isEmpty(entry.getValue().getId()) && str.contains(entry.getValue().getId())) {
                    return true;
                }
            }
            return false;
        }
    };
    protected AccountMatcher usernameMatcher = new AccountMatcher() { // from class: com.microsoft.identity.client.PublicClientApplication.23
        @Override // com.microsoft.identity.client.PublicClientApplication.AccountMatcher
        public boolean matches(@NonNull String str, @NonNull IAccount iAccount) {
            ArrayList<IClaimable> arrayList = new ArrayList();
            if (iAccount.getClaims() != null) {
                arrayList.add(iAccount);
            }
            if (iAccount instanceof MultiTenantAccount) {
                for (Map.Entry<String, ITenantProfile> entry : ((MultiTenantAccount) iAccount).getTenantProfiles().entrySet()) {
                    if (entry.getValue().getClaims() != null) {
                        arrayList.add(entry.getValue());
                    }
                }
            }
            for (IClaimable iClaimable : arrayList) {
                if (iClaimable.getClaims() != null && str.equalsIgnoreCase(SchemaUtil.getDisplayableId(iClaimable.getClaims()))) {
                    return true;
                }
            }
            return false;
        }
    };

    /* JADX INFO: renamed from: com.microsoft.identity.client.PublicClientApplication$25 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C621225 {

        /* JADX INFO: renamed from: $SwitchMap$com$microsoft$identity$common$java$commands$ICommandResult$ResultStatus */
        static final /* synthetic */ int[] f3577x184111ae;

        static {
            int[] iArr = new int[ICommandResult.ResultStatus.values().length];
            f3577x184111ae = iArr;
            try {
                iArr[ICommandResult.ResultStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3577x184111ae[ICommandResult.ResultStatus.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3577x184111ae[ICommandResult.ResultStatus.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BrokerDeviceModeCallback {
        void onError(MsalException msalException);

        void onGetMode(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NONNULL_CONSTANTS {
        static final String ACCOUNT = "account";
        static final String ACTIVITY = "activity";
        static final String AUTHORITY = "authority";
        static final String CALLBACK = "callback";
        static final String CHALLENGE_TYPES = "challenge_types";
        static final String CLIENT_ID = "client_id";
        static final String CONFIG_FILE = "config_file";
        static final String CONTEXT = "context";
        static final String LISTENER = "listener";
        static final String NULL_ERROR_SUFFIX = " cannot be null or empty";
        static final String REDIRECT_URI = "redirect_uri";
        static final String SCOPES = "scopes";
    }

    public PublicClientApplication(@NonNull PublicClientApplicationConfiguration publicClientApplicationConfiguration) throws MsalClientException {
        this.mPublicClientConfiguration = publicClientApplicationConfiguration;
        initializeApplication();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MsalException baseExceptionToMsalException(@NonNull BaseException baseException) {
        return "no_account_found".equalsIgnoreCase(baseException.getErrorCode()) ? new MsalUiRequiredException("no_account_found", "The supplied account could not be located.") : new MsalClientException(baseException.getErrorCode(), baseException.getMessage());
    }

    public static void checkInternetPermission(@NonNull PublicClientApplicationConfiguration publicClientApplicationConfiguration) {
        PackageManager packageManager = publicClientApplicationConfiguration.getAppContext().getPackageManager();
        if (packageManager.checkPermission(INTERNET_PERMISSION, publicClientApplicationConfiguration.getAppContext().getPackageName()) != 0 || packageManager.checkPermission(ACCESS_NETWORK_STATE_PERMISSION, publicClientApplicationConfiguration.getAppContext().getPackageName()) != 0) {
            throw new IllegalStateException("android.permission.Internet or android.permission.ACCESS_NETWORK_STATE is missing");
        }
    }

    public static void create(@NonNull final Context context, final int i, @NonNull final IPublicClientApplication.ApplicationCreatedListener applicationCreatedListener) {
        MsalUtils.validateNonNullArgument(context, "context");
        MsalUtils.validateNonNullArgument(applicationCreatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        runOnBackground(new Runnable() { // from class: com.microsoft.identity.client.PublicClientApplication.1
            @Override // java.lang.Runnable
            public void run() {
                PublicClientApplication.create(PublicClientApplicationConfigurationFactory.initializeConfiguration(context, i), (String) null, (String) null, (String) null, applicationCreatedListener);
            }
        });
    }

    private GenerateShrCommand createGenerateShrCommand(@NonNull IAccount iAccount, @NonNull PoPAuthenticationScheme poPAuthenticationScheme, @NonNull CommandCallback<GenerateShrResult, BaseException> commandCallback, @NonNull String str) {
        PublicClientApplicationConfiguration publicClientApplicationConfiguration = this.mPublicClientConfiguration;
        return new GenerateShrCommand(CommandParametersAdapter.createGenerateShrCommandParameters(publicClientApplicationConfiguration, publicClientApplicationConfiguration.getOAuth2TokenCache(), ((Account) iAccount).getHomeAccountId(), poPAuthenticationScheme), new MSALControllerFactory(this.mPublicClientConfiguration), commandCallback, str);
    }

    public static void createMultipleAccountPublicClientApplication(@NonNull final Context context, final int i, @NonNull final IPublicClientApplication.IMultipleAccountApplicationCreatedListener iMultipleAccountApplicationCreatedListener) {
        MsalUtils.validateNonNullArgument(context, "context");
        MsalUtils.validateNonNullArgument(iMultipleAccountApplicationCreatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        runOnBackground(new Runnable() { // from class: com.microsoft.identity.client.PublicClientApplication.4
            @Override // java.lang.Runnable
            public void run() {
                PublicClientApplication.createMultipleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(context, i), iMultipleAccountApplicationCreatedListener);
            }
        });
    }

    private static NativeAuthPublicClientApplication createNativeAuthApplication(@NonNull NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<String> list) throws MsalClientException {
        if (str != null) {
            nativeAuthPublicClientApplicationConfiguration.setClientId(str);
        }
        if (str2 != null) {
            nativeAuthPublicClientApplicationConfiguration.getAuthorities().clear();
            Authority authorityFromAuthorityUrl = Authority.getAuthorityFromAuthorityUrl(str2);
            authorityFromAuthorityUrl.setDefault(Boolean.TRUE);
            nativeAuthPublicClientApplicationConfiguration.getAuthorities().add(authorityFromAuthorityUrl);
        }
        if (str3 != null) {
            nativeAuthPublicClientApplicationConfiguration.setRedirectUri(str3);
        }
        if (list != null) {
            nativeAuthPublicClientApplicationConfiguration.setChallengeTypes(list);
        }
        validateAccountModeConfiguration(nativeAuthPublicClientApplicationConfiguration);
        nativeAuthPublicClientApplicationConfiguration.setIsSharedDevice(false);
        nativeAuthPublicClientApplicationConfiguration.validateConfiguration();
        return new NativeAuthPublicClientApplication(nativeAuthPublicClientApplicationConfiguration);
    }

    public static INativeAuthPublicClientApplication createNativeAuthPublicClientApplication(@NonNull Context context, int i) throws MsalException {
        MsalUtils.validateNonNullArgument(context, "context");
        try {
            return createNativeAuthApplication(NativeAuthPublicClientApplicationConfigurationFactory.INSTANCE.initializeNativeAuthConfiguration(context, i), null, null, null, null);
        } catch (MsalException e) {
            throw e;
        } catch (BaseException e2) {
            throw new MsalClientException("unknown_error", MsalClientException.NATIVE_AUTH_APPLICATION_CREATION_UNKNOWN_ERROR_MESSAGE, e2);
        }
    }

    public static void createSingleAccountPublicClientApplication(@NonNull final Context context, final int i, @NonNull final IPublicClientApplication.ISingleAccountApplicationCreatedListener iSingleAccountApplicationCreatedListener) {
        MsalUtils.validateNonNullArgument(context, "context");
        MsalUtils.validateNonNullArgument(iSingleAccountApplicationCreatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        runOnBackground(new Runnable() { // from class: com.microsoft.identity.client.PublicClientApplication.6
            @Override // java.lang.Runnable
            public void run() {
                PublicClientApplication.createSingleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(context, i), iSingleAccountApplicationCreatedListener);
            }
        });
    }

    public static CommandCallback<List<ICacheRecord>, BaseException> getLoadAccountsCallback(final IPublicClientApplication.LoadAccountsCallback loadAccountsCallback) {
        return new CommandCallback<List<ICacheRecord>, BaseException>() { // from class: com.microsoft.identity.client.PublicClientApplication.18
            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
            public void onError(BaseException baseException) {
                loadAccountsCallback.onError(MsalExceptionAdapter.msalExceptionFromBaseException(baseException));
            }

            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
            public void onTaskCompleted(List<ICacheRecord> list) {
                if (list == null) {
                    loadAccountsCallback.onTaskCompleted((List<IAccount>) null);
                } else {
                    loadAccountsCallback.onTaskCompleted(AccountAdapter.adapt(list));
                }
            }

            @Override // com.microsoft.identity.common.java.commands.CommandCallback
            public void onCancel() {
            }
        };
    }

    private OAuth2TokenCache<?, ?, ?> getOAuth2TokenCache() {
        return MsalOAuth2TokenCache.create(AndroidPlatformComponentsFactory.createFromContext(this.mPublicClientConfiguration.getAppContext()));
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    private void initializeApplication() throws MsalClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":initializeApplication", new StringBuilder());
        Context appContext = this.mPublicClientConfiguration.getAppContext();
        setupTelemetry(appContext, this.mPublicClientConfiguration);
        AzureActiveDirectory.setEnvironment(this.mPublicClientConfiguration.getEnvironment());
        Authority.addKnownAuthorities(this.mPublicClientConfiguration.getAuthorities());
        initializeLoggerSettings(this.mPublicClientConfiguration.getLoggerConfiguration());
        initializeTokenSharingLibrary();
        this.mPublicClientConfiguration.checkIntentFilterAddedToAppManifestForBrokerFlow();
        checkInternetPermission(this.mPublicClientConfiguration);
        HttpCache.initialize(appContext.getCacheDir());
        com.microsoft.identity.common.logging.Logger.info(strM1170p, "Create new public client application.");
    }

    public static void initializeLoggerSettings(@Nullable LoggerConfiguration loggerConfiguration) {
        if (loggerConfiguration != null) {
            Logger.LogLevel logLevel = loggerConfiguration.getLogLevel();
            boolean zIsPiiEnabled = loggerConfiguration.isPiiEnabled();
            boolean zIsLogcatEnabled = loggerConfiguration.isLogcatEnabled();
            Logger logger = Logger.getInstance();
            if (logLevel != null) {
                logger.setLogLevel(logLevel);
            }
            logger.setEnablePII(zIsPiiEnabled);
            logger.setEnableLogcatLog(zIsLogcatEnabled);
        }
    }

    private void initializeTokenSharingLibrary() {
        if (!(this.mPublicClientConfiguration.getOAuth2TokenCache() instanceof MsalOAuth2TokenCache)) {
            throw new IllegalStateException("TSL support mandates use of the MsalOAuth2TokenCache");
        }
        this.mTokenShareUtility = new TokenShareUtility(this.mPublicClientConfiguration.getClientId(), this.mPublicClientConfiguration.getRedirectUri(), (MsalOAuth2TokenCache) this.mPublicClientConfiguration.getOAuth2TokenCache());
    }

    private static boolean isAccountHomeTenant(@Nullable Map<String, ?> map, @NonNull String str) {
        if (map == null || map.isEmpty()) {
            return false;
        }
        return map.get("tid").equals(str);
    }

    private static void runOnBackground(@NonNull Runnable runnable) {
        new Thread(runnable).start();
    }

    public static AccountRecord selectAccountRecordForTokenRequest(@NonNull PublicClientApplicationConfiguration publicClientApplicationConfiguration, @NonNull TokenParameters tokenParameters) throws ClientException {
        ITenantProfile iTenantProfile;
        String strM1170p = AbstractC0622a.m1170p(TAG, ":selectAccountRecordForTokenRequest", new StringBuilder());
        if (TextUtils.isEmpty(tokenParameters.getAuthority())) {
            tokenParameters.setAuthority(publicClientApplicationConfiguration.getDefaultAuthority().getAuthorityURL().toString());
        }
        if (tokenParameters.getAccount() == null) {
            return null;
        }
        ITenantProfile account = tokenParameters.getAccount();
        MultiTenantAccount multiTenantAccount = (MultiTenantAccount) account;
        String authority = tokenParameters.getAuthority();
        Authority cIAMAuthority = BuildValues.shouldUseMockApiForNativeAuth().booleanValue() ? new CIAMAuthority(authority) : Authority.getAuthorityFromAuthorityUrl(authority);
        if ((cIAMAuthority instanceof AzureActiveDirectoryB2CAuthority) || (cIAMAuthority instanceof CIAMAuthority)) {
            return AccountAdapter.getAccountInternal(publicClientApplicationConfiguration.getClientId(), publicClientApplicationConfiguration.getOAuth2TokenCache(), multiTenantAccount.getHomeAccountId(), multiTenantAccount.getTenantId());
        }
        if (!(cIAMAuthority instanceof AzureActiveDirectoryAuthority)) {
            throw new UnsupportedOperationException("Unsupported Authority type: ".concat(cIAMAuthority.getClass().getSimpleName()));
        }
        AzureActiveDirectoryAuthority azureActiveDirectoryAuthority = (AzureActiveDirectoryAuthority) cIAMAuthority;
        String tenantId = azureActiveDirectoryAuthority.getAudience().getTenantId();
        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setEnvironment(multiTenantAccount.getEnvironment());
        accountRecord.setHomeAccountId(multiTenantAccount.getHomeAccountId());
        if (!StringUtil.isUuid(tenantId) && !AzureActiveDirectoryAudience.isHomeTenantAlias(tenantId)) {
            tenantId = azureActiveDirectoryAuthority.getAudience().getTenantUuidForAlias(cIAMAuthority.getAuthorityURL().toString());
        }
        accountRecord.setRealm(tenantId);
        if (AzureActiveDirectoryAudience.isHomeTenantAlias(tenantId) || isAccountHomeTenant(multiTenantAccount.getClaims(), tenantId)) {
            iTenantProfile = multiTenantAccount.getClaims() != null ? multiTenantAccount : null;
        } else {
            iTenantProfile = multiTenantAccount.getTenantProfiles().get(tenantId);
        }
        if (iTenantProfile != null || !(tokenParameters instanceof AcquireTokenSilentParameters)) {
            account = iTenantProfile;
        } else if (account.getClaims() == null) {
            Iterator<ITenantProfile> it = multiTenantAccount.getTenantProfiles().values().iterator();
            while (it.hasNext()) {
                account = it.next();
                if (account.getClaims() != null) {
                    break;
                }
            }
            account = iTenantProfile;
        }
        if (account != null) {
            accountRecord.setLocalAccountId(account.getId());
            accountRecord.setUsername(account.getUsername());
            return accountRecord;
        }
        com.microsoft.identity.common.logging.Logger.warnPII(strM1170p, "No account record found for IAccount with request tenantId: " + tenantId);
        throw new ClientException("no_account_found", "No account record found for IAccount");
    }

    private static void setupTelemetry(@NonNull Context context, @NonNull PublicClientApplicationConfiguration publicClientApplicationConfiguration) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":setupTelemetry", new StringBuilder());
        if (publicClientApplicationConfiguration.getTelemetryConfiguration() != null) {
            com.microsoft.identity.common.logging.Logger.verbose(strM1170p, "Telemetry configuration is set. Telemetry is enabled.");
        } else {
            com.microsoft.identity.common.logging.Logger.verbose(strM1170p, "Telemetry configuration is null. Telemetry is disabled.");
        }
        new Telemetry.Builder().withContext(context).defaultConfiguration(publicClientApplicationConfiguration.getTelemetryConfiguration()).build();
    }

    public static void showExpectedMsalRedirectUriInfo(Activity activity) {
        activity.startActivity(BrokerHelperActivity.createStartIntent(activity.getApplicationContext()));
    }

    private static void validateAccountModeConfiguration(@NonNull PublicClientApplicationConfiguration publicClientApplicationConfiguration) throws MsalClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":validateAccountModeConfiguration", new StringBuilder());
        if (publicClientApplicationConfiguration.getAccountMode() == AccountMode.SINGLE && publicClientApplicationConfiguration.getDefaultAuthority() != null && (publicClientApplicationConfiguration.getDefaultAuthority() instanceof AzureActiveDirectoryB2CAuthority)) {
            com.microsoft.identity.common.logging.Logger.warn(strM1170p, "Warning! B2C applications should use MultipleAccountPublicClientApplication. Use of SingleAccount mode with multiple IEF policies is unsupported.");
            if (publicClientApplicationConfiguration.getAuthorities().size() > 1) {
                throw new MsalClientException(MsalClientException.SAPCA_USE_WITH_MULTI_POLICY_B2C);
            }
        }
    }

    private void validateBrokerNotInUse() throws MsalClientException {
        if (new MSALControllerFactory(this.mPublicClientConfiguration).brokerEligibleAndInstalled()) {
            throw new MsalClientException("Cannot perform this action - broker is enabled.");
        }
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    @Deprecated
    public void acquireToken(@NonNull Activity activity, @NonNull String[] strArr, @NonNull AuthenticationCallback authenticationCallback) {
        acquireTokenInternal(buildAcquireTokenParameters(activity, (Fragment) null, Arrays.asList(strArr), (IAccount) null, (Prompt) null, (List<Map.Entry<String, String>>) null, (String[]) null, (String) null, authenticationCallback, (String) null, (ClaimsRequest) null), "122");
    }

    public void acquireTokenInternal(@NonNull final AcquireTokenParameters acquireTokenParameters, @NonNull final String str) {
        sBackgroundExecutor.submit(OtelContextExtension.wrap(new Runnable() { // from class: com.microsoft.identity.client.PublicClientApplication.15
            @Override // java.lang.Runnable
            public void run() {
                final CommandCallback commandCallback = PublicClientApplication.this.getCommandCallback(acquireTokenParameters.getCallback(), acquireTokenParameters);
                try {
                    PublicClientApplication.this.validateAcquireTokenParameters(acquireTokenParameters);
                    AcquireTokenParameters acquireTokenParameters2 = acquireTokenParameters;
                    acquireTokenParameters2.setAccountRecord(PublicClientApplication.selectAccountRecordForTokenRequest(PublicClientApplication.this.mPublicClientConfiguration, acquireTokenParameters2));
                    PublicClientApplicationConfiguration publicClientApplicationConfiguration = PublicClientApplication.this.mPublicClientConfiguration;
                    InteractiveTokenCommandParameters interactiveTokenCommandParametersCreateInteractiveTokenCommandParameters = CommandParametersAdapter.createInteractiveTokenCommandParameters(publicClientApplicationConfiguration, publicClientApplicationConfiguration.getOAuth2TokenCache(), acquireTokenParameters);
                    CommandDispatcher.beginInteractive(new InteractiveTokenCommand(interactiveTokenCommandParametersCreateInteractiveTokenCommandParameters, new MSALControllerFactory(PublicClientApplication.this.mPublicClientConfiguration, interactiveTokenCommandParametersCreateInteractiveTokenCommandParameters.getAuthority()), commandCallback, str));
                } catch (Exception e) {
                    final BaseException baseExceptionBaseExceptionFromException = ExceptionAdapter.baseExceptionFromException(e);
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.microsoft.identity.client.PublicClientApplication.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            commandCallback.onError(baseExceptionBaseExceptionFromException);
                        }
                    });
                }
            }
        }));
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    public IAuthenticationResult acquireTokenSilent(@NonNull AcquireTokenSilentParameters acquireTokenSilentParameters) {
        return acquireTokenSilentInternal(acquireTokenSilentParameters, PublicApiId.PCA_ACQUIRE_TOKEN_SILENT_WITH_PARAMETERS);
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    public void acquireTokenSilentAsync(@NonNull AcquireTokenSilentParameters acquireTokenSilentParameters) {
        acquireTokenSilentAsyncInternal(acquireTokenSilentParameters, PublicApiId.PCA_ACQUIRE_TOKEN_SILENT_ASYNC_WITH_PARAMETERS);
    }

    public void acquireTokenSilentAsyncInternal(@NonNull final AcquireTokenSilentParameters acquireTokenSilentParameters, @NonNull final String str) {
        sBackgroundExecutor.submit(OtelContextExtension.wrap(new Runnable() { // from class: com.microsoft.identity.client.PublicClientApplication.16
            @Override // java.lang.Runnable
            public void run() {
                final CommandCallback commandCallback = PublicClientApplication.this.getCommandCallback(acquireTokenSilentParameters.getCallback(), acquireTokenSilentParameters);
                try {
                    PublicClientApplication.this.validateAcquireTokenSilentParameters(acquireTokenSilentParameters);
                    AcquireTokenSilentParameters acquireTokenSilentParameters2 = acquireTokenSilentParameters;
                    acquireTokenSilentParameters2.setAccountRecord(PublicClientApplication.selectAccountRecordForTokenRequest(PublicClientApplication.this.mPublicClientConfiguration, acquireTokenSilentParameters2));
                    PublicClientApplicationConfiguration publicClientApplicationConfiguration = PublicClientApplication.this.mPublicClientConfiguration;
                    SilentTokenCommandParameters silentTokenCommandParametersCreateSilentTokenCommandParameters = CommandParametersAdapter.createSilentTokenCommandParameters(publicClientApplicationConfiguration, publicClientApplicationConfiguration.getOAuth2TokenCache(), acquireTokenSilentParameters);
                    CommandDispatcher.submitSilent(new SilentTokenCommand(silentTokenCommandParametersCreateSilentTokenCommandParameters, new MSALControllerFactory(PublicClientApplication.this.mPublicClientConfiguration, silentTokenCommandParametersCreateSilentTokenCommandParameters.getAuthority()), commandCallback, str));
                } catch (Exception e) {
                    final BaseException baseExceptionBaseExceptionFromException = ExceptionAdapter.baseExceptionFromException(e);
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.microsoft.identity.client.PublicClientApplication.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            commandCallback.onError(baseExceptionBaseExceptionFromException);
                        }
                    });
                }
            }
        }));
    }

    public IAuthenticationResult acquireTokenSilentInternal(@NonNull AcquireTokenSilentParameters acquireTokenSilentParameters, @NonNull String str) throws MsalException {
        if (acquireTokenSilentParameters.getCallback() != null) {
            throw new IllegalArgumentException("Do not provide callback for synchronous methods");
        }
        final ResultFuture resultFuture = new ResultFuture();
        acquireTokenSilentParameters.setCallback(new SilentAuthenticationCallback() { // from class: com.microsoft.identity.client.PublicClientApplication.17
            @Override // com.microsoft.identity.client.SilentAuthenticationCallback
            public void onError(MsalException msalException) {
                resultFuture.setResult(new AsyncResult(null, msalException));
            }

            @Override // com.microsoft.identity.client.SilentAuthenticationCallback
            public void onSuccess(IAuthenticationResult iAuthenticationResult) {
                resultFuture.setResult(new AsyncResult(iAuthenticationResult, null));
            }
        });
        acquireTokenSilentAsyncInternal(acquireTokenSilentParameters, str);
        try {
            AsyncResult asyncResult = (AsyncResult) resultFuture.get();
            if (asyncResult.getSuccess()) {
                return (IAuthenticationResult) asyncResult.getResult();
            }
            throw asyncResult.getException();
        } catch (ExecutionException e) {
            throw new MsalClientException("unknown_error", "Unexpected error while acquiring token.", e);
        }
    }

    public IAuthenticationResult acquireTokenSilentSyncInternal(@NonNull String[] strArr, @NonNull String str, @NonNull IAccount iAccount, boolean z, @NonNull String str2) throws MsalException {
        MsalUtils.throwOnMainThread("acquireTokenSilent");
        final ResultFuture resultFuture = new ResultFuture();
        acquireTokenSilentAsyncInternal(buildAcquireTokenSilentParameters(strArr, iAccount, str, z, null, new SilentAuthenticationCallback() { // from class: com.microsoft.identity.client.PublicClientApplication.24
            @Override // com.microsoft.identity.client.SilentAuthenticationCallback
            public void onError(MsalException msalException) {
                resultFuture.setResult(new AsyncResult(null, msalException));
            }

            @Override // com.microsoft.identity.client.SilentAuthenticationCallback
            public void onSuccess(IAuthenticationResult iAuthenticationResult) {
                resultFuture.setResult(new AsyncResult(iAuthenticationResult, null));
            }
        }), str2);
        try {
            AsyncResult asyncResult = (AsyncResult) resultFuture.get();
            if (asyncResult.getSuccess()) {
                return (IAuthenticationResult) asyncResult.getResult();
            }
            throw asyncResult.getException();
        } catch (ExecutionException e) {
            throw new MsalClientException("unknown_error", "Unexpected error while acquiring token.", e);
        }
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    public void acquireTokenWithDeviceCode(@NonNull List<String> list, @NonNull IPublicClientApplication.DeviceCodeFlowCallback deviceCodeFlowCallback, @Nullable ClaimsRequest claimsRequest, @Nullable UUID uuid) {
        Context appContext = this.mPublicClientConfiguration.getAppContext();
        PackageHelper packageHelper = new PackageHelper(appContext);
        Span spanCreateSpan = OTelUtility.createSpan(SpanName.AcquireTokenDcf.name());
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpan);
            try {
                spanCreateSpan.setAttribute(AttributeName.application_name.name(), this.mPublicClientConfiguration.getAppContext().getPackageName());
                if (!packageHelper.verifyIfValidTeamsPackage(appContext.getPackageName())) {
                    spanCreateSpan.setAttribute(AttributeName.error_message.name(), "acquireTokenWithDeviceCode with claims is not supported for current package.");
                    throw new UnsupportedOperationException("This method is unsupported.");
                }
                DeviceCodeFlowParameters.Builder builder = new DeviceCodeFlowParameters.Builder();
                if (uuid != null) {
                    builder.withCorrelationId(uuid);
                    spanCreateSpan.setAttribute(AttributeName.correlation_id.name(), uuid.toString());
                }
                DeviceCodeFlowParameters deviceCodeFlowParametersBuild = builder.withScopes(list).withClaims(claimsRequest).build();
                PublicClientApplicationConfiguration publicClientApplicationConfiguration = this.mPublicClientConfiguration;
                CommandDispatcher.submitSilent(new DeviceCodeFlowCommand(CommandParametersAdapter.createDeviceCodeFlowWithClaimsCommandParameters(publicClientApplicationConfiguration, publicClientApplicationConfiguration.getOAuth2TokenCache(), deviceCodeFlowParametersBuild), new MSALControllerFactory(this.mPublicClientConfiguration), getDeviceCodeFlowCommandCallback(deviceCodeFlowCallback), PublicApiId.DEVICE_CODE_FLOW_WITH_CLAIMS_AND_CALLBACK));
                spanCreateSpan.setStatus(StatusCode.OK);
                if (scopeMakeCurrentSpan != null) {
                    scopeMakeCurrentSpan.close();
                }
            } finally {
            }
        } finally {
        }
    }

    public AcquireTokenParameters buildAcquireTokenParameters(@NonNull Activity activity, @Nullable Fragment fragment, @NonNull List<String> list, @Nullable IAccount iAccount, @Nullable Prompt prompt, @Nullable List<Map.Entry<String, String>> list2, @Nullable String[] strArr, @Nullable String str, @NonNull AuthenticationCallback authenticationCallback, @Nullable String str2, @Nullable ClaimsRequest claimsRequest) {
        MsalUtils.validateNonNullArgument(activity, Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        MsalUtils.validateNonNullArgument(list, "scopes");
        MsalUtils.validateNonNullArgument(authenticationCallback, Profile.PhoneNumberData.TYPE_CALLBACK);
        AcquireTokenParameters.Builder builderWithAuthorizationQueryStringParameters = new AcquireTokenParameters.Builder().startAuthorizationFromActivity(activity).withFragment(fragment).forAccount(iAccount).withScopes(list).withPrompt(prompt).withAuthorizationQueryStringParameters(list2);
        if (strArr == null) {
            strArr = new String[0];
        }
        return builderWithAuthorizationQueryStringParameters.withOtherScopesToAuthorize(Arrays.asList(strArr)).fromAuthority(str).withCallback(authenticationCallback).withLoginHint(str2).withClaims(claimsRequest).build();
    }

    public AcquireTokenSilentParameters buildAcquireTokenSilentParameters(@NonNull String[] strArr, @NonNull IAccount iAccount, @NonNull String str, boolean z, @Nullable ClaimsRequest claimsRequest, @NonNull SilentAuthenticationCallback silentAuthenticationCallback) {
        MsalUtils.validateNonNullArgument(iAccount, "account");
        MsalUtils.validateNonNullArgument(silentAuthenticationCallback, Profile.PhoneNumberData.TYPE_CALLBACK);
        return new AcquireTokenSilentParameters.Builder().withScopes(Arrays.asList(strArr)).forAccount(iAccount).fromAuthority(str).forceRefresh(z).withClaims(claimsRequest).withCallback(silentAuthenticationCallback).build();
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    public String generateSignedHttpRequest(@NonNull IAccount iAccount, @NonNull PoPAuthenticationScheme poPAuthenticationScheme) throws MsalException {
        final ResultFuture resultFuture = new ResultFuture();
        CommandDispatcher.submitSilent(createGenerateShrCommand(iAccount, poPAuthenticationScheme, new CommandCallback<GenerateShrResult, BaseException>() { // from class: com.microsoft.identity.client.PublicClientApplication.13
            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
            public void onError(@NonNull BaseException baseException) {
                resultFuture.setResult(new AsyncResult(null, PublicClientApplication.this.baseExceptionToMsalException(baseException)));
            }

            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
            public void onTaskCompleted(@NonNull GenerateShrResult generateShrResult) {
                resultFuture.setResult(new AsyncResult(generateShrResult, null));
            }

            @Override // com.microsoft.identity.common.java.commands.CommandCallback
            public void onCancel() {
            }
        }, PublicApiId.PCA_GENERATE_SIGNED_HTTP_REQUEST));
        try {
            AsyncResult asyncResult = (AsyncResult) resultFuture.get();
            if (asyncResult.getSuccess()) {
                return ((GenerateShrResult) asyncResult.getResult()).getShr();
            }
            throw asyncResult.getException();
        } catch (InterruptedException e) {
            e = e;
            throw new MsalClientException("unknown_error", "Unexpected error while generating SHR.", e);
        } catch (ExecutionException e2) {
            e = e2;
            throw new MsalClientException("unknown_error", "Unexpected error while generating SHR.", e);
        }
    }

    @Nullable
    public String getActiveBrokerPackageName(@NonNull Context context) {
        BrokerData activeBroker = BrokerDiscoveryClientFactory.getInstanceForClientSdk(context, AndroidPlatformComponentsFactory.createFromContext(context)).getActiveBroker(false);
        if (activeBroker != null) {
            return activeBroker.getPackageName();
        }
        return null;
    }

    public CommandCallback getCommandCallback(@NonNull final SilentAuthenticationCallback silentAuthenticationCallback, @NonNull final TokenParameters tokenParameters) {
        return new CommandCallback<ILocalAuthenticationResult, BaseException>() { // from class: com.microsoft.identity.client.PublicClientApplication.19
            @Override // com.microsoft.identity.common.java.commands.CommandCallback
            public void onCancel() {
                SilentAuthenticationCallback silentAuthenticationCallback2 = silentAuthenticationCallback;
                if (!(silentAuthenticationCallback2 instanceof AuthenticationCallback)) {
                    throw new IllegalStateException("Silent requests cannot be cancelled.");
                }
                ((AuthenticationCallback) silentAuthenticationCallback2).onCancel();
            }

            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
            public void onError(BaseException baseException) {
                MsalException msalExceptionMsalExceptionFromBaseException = MsalExceptionAdapter.msalExceptionFromBaseException(baseException);
                SilentAuthenticationCallback silentAuthenticationCallback2 = silentAuthenticationCallback;
                if (silentAuthenticationCallback2 == null) {
                    throw new IllegalStateException("callback cannot be null or empty");
                }
                silentAuthenticationCallback2.onError(msalExceptionMsalExceptionFromBaseException);
            }

            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
            public void onTaskCompleted(ILocalAuthenticationResult iLocalAuthenticationResult) {
                PublicClientApplication.this.postAuthResult(iLocalAuthenticationResult, tokenParameters, silentAuthenticationCallback);
            }
        };
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    public PublicClientApplicationConfiguration getConfiguration() {
        return this.mPublicClientConfiguration;
    }

    public DeviceCodeFlowCommandCallback getDeviceCodeFlowCommandCallback(@NonNull final IPublicClientApplication.DeviceCodeFlowCallback deviceCodeFlowCallback) {
        return new DeviceCodeFlowCommandCallback<LocalAuthenticationResult, BaseException>() { // from class: com.microsoft.identity.client.PublicClientApplication.20
            @Override // com.microsoft.identity.common.java.commands.DeviceCodeFlowCommandCallback
            public void onUserCodeReceived(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull Date date) {
                deviceCodeFlowCallback.onUserCodeReceived(str, str2, str3, date);
            }

            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
            public void onError(@NonNull BaseException baseException) {
                deviceCodeFlowCallback.onError(MsalExceptionAdapter.msalExceptionFromBaseException(baseException));
            }

            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
            public void onTaskCompleted(@NonNull LocalAuthenticationResult localAuthenticationResult) {
                deviceCodeFlowCallback.onTokenReceived(AuthenticationResultAdapter.adapt(localAuthenticationResult));
            }

            @Override // com.microsoft.identity.common.java.commands.CommandCallback
            public void onCancel() {
            }
        };
    }

    @Override // com.microsoft.identity.client.ITokenShare, com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    public String getMsaFamilyRefreshToken(@NonNull String str) {
        return getMsaFamilyRefreshTokenWithMetadata(str).getRefreshToken();
    }

    @Override // com.microsoft.identity.client.ITokenShare, com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    public String getOrgIdFamilyRefreshToken(@NonNull String str) {
        return getOrgIdFamilyRefreshTokenWithMetadata(str).getRefreshToken();
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    public PreferredAuthMethod getPreferredAuthConfiguration() throws BaseException {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":getPreferredAuthConfiguration", new StringBuilder());
        PublicClientApplicationConfiguration publicClientApplicationConfiguration = this.mPublicClientConfiguration;
        CommandParameters commandParametersCreateCommandParameters = CommandParametersAdapter.createCommandParameters(publicClientApplicationConfiguration, publicClientApplicationConfiguration.getOAuth2TokenCache());
        PublicClientApplicationConfiguration publicClientApplicationConfiguration2 = this.mPublicClientConfiguration;
        try {
            CommandResult commandResult = CommandDispatcher.submitSilentReturningFuture(new GetPreferredAuthMethodFromAuthenticator(commandParametersCreateCommandParameters, new MSALControllerFactory(publicClientApplicationConfiguration2, CommandParametersAdapter.getRequestAuthority(publicClientApplicationConfiguration2)), new CommandCallback<PreferredAuthMethod, BaseException>() { // from class: com.microsoft.identity.client.PublicClientApplication.12
                @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
                public void onError(BaseException baseException) {
                    com.microsoft.identity.common.logging.Logger.error(strM1170p, "Unexpected error on GetPreferredAuthMethodFromAuthenticator", baseException);
                }

                @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
                public void onTaskCompleted(PreferredAuthMethod preferredAuthMethod) {
                    com.microsoft.identity.common.logging.Logger.info(strM1170p, "Preferred AuthMethod: " + preferredAuthMethod.name());
                }

                @Override // com.microsoft.identity.common.java.commands.CommandCallback
                public void onCancel() {
                }
            }, PublicApiId.PCA_IS_QR_PIN_AVAILABLE)).get(15L, TimeUnit.SECONDS);
            int i = C621225.f3577x184111ae[commandResult.getStatus().ordinal()];
            if (i == 1) {
                com.microsoft.identity.common.logging.Logger.info(strM1170p, "Preferred AuthMethod: " + commandResult.getResult());
                return (PreferredAuthMethod) commandResult.getResult();
            }
            if (i == 2) {
                BaseException baseException = (BaseException) commandResult.getResult();
                com.microsoft.identity.common.logging.Logger.error(strM1170p, "Unexpected error on GetPreferredAuthMethodFromAuthenticator", baseException);
                throw baseException;
            }
            if (i == 3) {
                com.microsoft.identity.common.logging.Logger.warn(strM1170p, "GetPreferredAuthMethodFromAuthenticator was cancelled");
                return PreferredAuthMethod.NONE;
            }
            com.microsoft.identity.common.logging.Logger.warn(strM1170p, "Unexpected status on GetPreferredAuthMethodFromAuthenticator: " + commandResult.getStatus());
            return PreferredAuthMethod.NONE;
        } catch (InterruptedException e) {
            e = e;
            com.microsoft.identity.common.logging.Logger.error(strM1170p, "Unexpected error on GetPreferredAuthMethodFromAuthenticator", e);
            return PreferredAuthMethod.NONE;
        } catch (ExecutionException e2) {
            e = e2;
            com.microsoft.identity.common.logging.Logger.error(strM1170p, "Unexpected error on GetPreferredAuthMethodFromAuthenticator", e);
            return PreferredAuthMethod.NONE;
        } catch (TimeoutException e3) {
            e = e3;
            com.microsoft.identity.common.logging.Logger.error(strM1170p, "Unexpected error on GetPreferredAuthMethodFromAuthenticator", e);
            return PreferredAuthMethod.NONE;
        }
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    public boolean isSharedDevice() {
        return this.mPublicClientConfiguration.getIsSharedDevice();
    }

    public boolean isValidBrokerPackage(@NonNull Context context, @NonNull String str) {
        return new BrokerValidator(context).isValidBrokerPackage(str);
    }

    public void performMigration(@NonNull TokenMigrationCallback tokenMigrationCallback) {
        HashMap map = new HashMap();
        map.put(this.mPublicClientConfiguration.getClientId(), this.mPublicClientConfiguration.getRedirectUri());
        AdalMigrationAdapter adalMigrationAdapter = new AdalMigrationAdapter(this.mPublicClientConfiguration.getAppContext(), map, false);
        if (adalMigrationAdapter.getMigrationStatus()) {
            tokenMigrationCallback.onMigrationFinished(0);
        } else {
            new TokenMigrationUtility()._import(adalMigrationAdapter, new SharedPreferencesFileManager(this.mPublicClientConfiguration.getAppContext(), "com.microsoft.aad.adal.cache", new AndroidAuthSdkStorageEncryptionManager(this.mPublicClientConfiguration.getAppContext())).getAll(), (IShareSingleSignOnState) this.mPublicClientConfiguration.getOAuth2TokenCache(), tokenMigrationCallback);
        }
    }

    public void postAuthResult(@NonNull ILocalAuthenticationResult iLocalAuthenticationResult, @NonNull TokenParameters tokenParameters, @NonNull SilentAuthenticationCallback silentAuthenticationCallback) {
        if (silentAuthenticationCallback == null) {
            throw new IllegalStateException("callback cannot be null or empty");
        }
        List<String> declinedScopes = AuthenticationResultAdapter.getDeclinedScopes(Arrays.asList(iLocalAuthenticationResult.getScope()), tokenParameters.getScopes());
        if (declinedScopes.isEmpty()) {
            silentAuthenticationCallback.onSuccess(AuthenticationResultAdapter.adapt(iLocalAuthenticationResult));
        } else {
            silentAuthenticationCallback.onError(AuthenticationResultAdapter.declinedScopeExceptionFromResult(iLocalAuthenticationResult, declinedScopes, tokenParameters));
        }
    }

    @Override // com.microsoft.identity.client.ITokenShare, com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    public void saveMsaFamilyRefreshToken(@NonNull String str) throws MsalClientException {
        MsalUtils.validateNonNullArgument(str, TokenInfo.TOKEN_TYPE_REFRESH);
        try {
            this.mTokenShareUtility.saveMsaFamilyRefreshToken(str);
        } catch (Exception e) {
            throw new MsalClientException(ClientException.TOKEN_SHARING_MSA_PERSISTENCE_ERROR, TSL_MSG_FAILED_TO_SAVE, e);
        }
    }

    @Override // com.microsoft.identity.client.ITokenShare, com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    public void saveOrgIdFamilyRefreshToken(@NonNull String str) throws MsalClientException {
        MsalUtils.validateNonNullArgument(str, "SsoStateSerializerBlob");
        validateBrokerNotInUse();
        try {
            this.mTokenShareUtility.saveOrgIdFamilyRefreshToken(str);
        } catch (Exception e) {
            throw new MsalClientException(ClientException.TOKEN_SHARING_DESERIALIZATION_ERROR, TSL_MSG_FAILED_TO_SAVE, e);
        }
    }

    public void validateAcquireTokenParameters(AcquireTokenParameters acquireTokenParameters) throws MsalArgumentException {
        Activity activity = acquireTokenParameters.getActivity();
        List<String> scopes = acquireTokenParameters.getScopes();
        AuthenticationCallback callback = acquireTokenParameters.getCallback();
        MsalUtils.validateNonNullArg(activity, Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        MsalUtils.validateNonNullArg(scopes, "scopes");
        MsalUtils.validateNonNullArg(callback, Profile.PhoneNumberData.TYPE_CALLBACK);
    }

    public void validateAcquireTokenSilentParameters(AcquireTokenSilentParameters acquireTokenSilentParameters) throws MsalArgumentException {
        String authority = acquireTokenSilentParameters.getAuthority();
        IAccount account = acquireTokenSilentParameters.getAccount();
        List<String> scopes = acquireTokenSilentParameters.getScopes();
        SilentAuthenticationCallback callback = acquireTokenSilentParameters.getCallback();
        MsalUtils.validateNonNullArg(authority, "authority");
        MsalUtils.validateNonNullArg(account, "account");
        MsalUtils.validateNonNullArg(callback, Profile.PhoneNumberData.TYPE_CALLBACK);
        MsalUtils.validateNonNullArg(scopes, "scopes");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AccountMatcher {
        private final AccountMatcher[] mDelegateMatchers;

        public AccountMatcher() {
            this.mDelegateMatchers = new AccountMatcher[0];
        }

        public boolean matches(@NonNull String str, @NonNull IAccount iAccount) {
            boolean zMatches = false;
            for (AccountMatcher accountMatcher : this.mDelegateMatchers) {
                zMatches = accountMatcher.matches(str, iAccount);
                if (zMatches) {
                    return zMatches;
                }
            }
            return zMatches;
        }

        public AccountMatcher(@NonNull AccountMatcher... accountMatcherArr) {
            this.mDelegateMatchers = accountMatcherArr;
        }
    }

    @Override // com.microsoft.identity.client.ITokenShare, com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    public TokenShareResult getMsaFamilyRefreshTokenWithMetadata(@NonNull String str) throws MsalClientException {
        MsalUtils.validateNonNullArgument(str, "identifier");
        validateBrokerNotInUse();
        try {
            return new TokenShareResult(this.mTokenShareUtility.getMsaFamilyRefreshTokenWithMetadata(str));
        } catch (Exception e) {
            throw new MsalClientException(ClientException.TOKEN_CACHE_ITEM_NOT_FOUND, TSM_MSG_FAILED_TO_RETRIEVE, e);
        }
    }

    @Override // com.microsoft.identity.client.ITokenShare, com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    public TokenShareResult getOrgIdFamilyRefreshTokenWithMetadata(@NonNull String str) throws MsalClientException {
        MsalUtils.validateNonNullArgument(str, "identifier");
        validateBrokerNotInUse();
        try {
            return new TokenShareResult(this.mTokenShareUtility.getOrgIdFamilyRefreshTokenWithMetadata(str));
        } catch (Exception e) {
            throw new MsalClientException(ClientException.TOKEN_CACHE_ITEM_NOT_FOUND, TSM_MSG_FAILED_TO_RETRIEVE, e);
        }
    }

    public static void create(@NonNull final Context context, @NonNull final File file, @NonNull final IPublicClientApplication.ApplicationCreatedListener applicationCreatedListener) {
        MsalUtils.validateNonNullArgument(context, "context");
        MsalUtils.validateNonNullArgument(applicationCreatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        runOnBackground(new Runnable() { // from class: com.microsoft.identity.client.PublicClientApplication.2
            @Override // java.lang.Runnable
            public void run() {
                PublicClientApplication.create(PublicClientApplicationConfigurationFactory.initializeConfiguration(context, file), (String) null, (String) null, (String) null, applicationCreatedListener);
            }
        });
    }

    public static void createMultipleAccountPublicClientApplication(@NonNull final Context context, @NonNull final File file, @NonNull final IPublicClientApplication.IMultipleAccountApplicationCreatedListener iMultipleAccountApplicationCreatedListener) {
        MsalUtils.validateNonNullArgument(context, "context");
        MsalUtils.validateNonNullArgument(iMultipleAccountApplicationCreatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        runOnBackground(new Runnable() { // from class: com.microsoft.identity.client.PublicClientApplication.5
            @Override // java.lang.Runnable
            public void run() {
                PublicClientApplication.createMultipleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(context, file), iMultipleAccountApplicationCreatedListener);
            }
        });
    }

    public static void createSingleAccountPublicClientApplication(@NonNull final Context context, @NonNull final File file, @NonNull final IPublicClientApplication.ISingleAccountApplicationCreatedListener iSingleAccountApplicationCreatedListener) {
        MsalUtils.validateNonNullArgument(context, "context");
        MsalUtils.validateNonNullArgument(file, "config_file");
        MsalUtils.validateNonNullArgument(iSingleAccountApplicationCreatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        runOnBackground(new Runnable() { // from class: com.microsoft.identity.client.PublicClientApplication.7
            @Override // java.lang.Runnable
            public void run() {
                PublicClientApplication.createSingleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(context, file), iSingleAccountApplicationCreatedListener);
            }
        });
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    public void acquireToken(@NonNull AcquireTokenParameters acquireTokenParameters) {
        acquireTokenInternal(acquireTokenParameters, "121");
    }

    public static void create(@NonNull final Context context, @NonNull final String str, @Nullable final String str2, @NonNull final String str3, @NonNull final IPublicClientApplication.ApplicationCreatedListener applicationCreatedListener) {
        MsalUtils.validateNonNullArgument(context, "context");
        MsalUtils.validateNonNullArgument(str, "client_id");
        MsalUtils.validateNonNullArgument(str3, "redirect_uri");
        MsalUtils.validateNonNullArgument(applicationCreatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        runOnBackground(new Runnable() { // from class: com.microsoft.identity.client.PublicClientApplication.3
            @Override // java.lang.Runnable
            public void run() {
                PublicClientApplication.create(PublicClientApplicationConfigurationFactory.initializeConfiguration(context), str, str2, str3, applicationCreatedListener);
            }
        });
    }

    @NonNull
    @WorkerThread
    public static IMultipleAccountPublicClientApplication createMultipleAccountPublicClientApplication(@NonNull Context context, @NonNull int i) {
        MsalUtils.validateNonNullArgument(context, "context");
        return createMultipleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(context, i));
    }

    public static INativeAuthPublicClientApplication createNativeAuthPublicClientApplication(@NonNull Context context, @NonNull File file) throws MsalClientException {
        MsalUtils.validateNonNullArgument(context, "context");
        MsalUtils.validateNonNullArgument(file, "config_file");
        try {
            return createNativeAuthApplication(NativeAuthPublicClientApplicationConfigurationFactory.INSTANCE.initializeNativeAuthConfiguration(context, file), null, null, null, null);
        } catch (BaseException e) {
            throw new MsalClientException("unknown_error", MsalClientException.NATIVE_AUTH_APPLICATION_CREATION_UNKNOWN_ERROR_MESSAGE, e);
        }
    }

    @NonNull
    @WorkerThread
    public static ISingleAccountPublicClientApplication createSingleAccountPublicClientApplication(@NonNull Context context, int i) {
        MsalUtils.validateNonNullArgument(context, "context");
        return createSingleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(context, i));
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    public void generateSignedHttpRequest(@NonNull IAccount iAccount, @NonNull PoPAuthenticationScheme poPAuthenticationScheme, @NonNull final IPublicClientApplication.SignedHttpRequestRequestCallback signedHttpRequestRequestCallback) {
        try {
            CommandDispatcher.submitSilent(createGenerateShrCommand(iAccount, poPAuthenticationScheme, new CommandCallback<GenerateShrResult, BaseException>() { // from class: com.microsoft.identity.client.PublicClientApplication.14
                @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
                public void onError(@NonNull BaseException baseException) {
                    signedHttpRequestRequestCallback.onError(PublicClientApplication.this.baseExceptionToMsalException(baseException));
                }

                @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
                public void onTaskCompleted(@NonNull GenerateShrResult generateShrResult) {
                    signedHttpRequestRequestCallback.onTaskCompleted(generateShrResult.getShr());
                }

                @Override // com.microsoft.identity.common.java.commands.CommandCallback
                public void onCancel() {
                }
            }, "1101"));
        } catch (MsalClientException e) {
            signedHttpRequestRequestCallback.onError((MsalException) new MsalClientException("unknown_error", "Unexpected error while generating SHR.", e));
        }
    }

    @NonNull
    @WorkerThread
    public static IMultipleAccountPublicClientApplication createMultipleAccountPublicClientApplication(@NonNull Context context, @NonNull File file) {
        MsalUtils.validateNonNullArgument(context, "context");
        MsalUtils.validateNonNullArgument(file, "configFile");
        return createMultipleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(context, file));
    }

    @NonNull
    @WorkerThread
    public static ISingleAccountPublicClientApplication createSingleAccountPublicClientApplication(@NonNull Context context, @Nullable File file) {
        MsalUtils.validateNonNullArgument(context, "context");
        return createSingleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(context, file));
    }

    @NonNull
    @WorkerThread
    public static IPublicClientApplication create(@NonNull Context context, int i) {
        MsalUtils.validateNonNullArgument(context, "context");
        return create(PublicClientApplicationConfigurationFactory.initializeConfiguration(context, i));
    }

    public static INativeAuthPublicClientApplication createNativeAuthPublicClientApplication(@NonNull Context context, @NonNull String str, @NonNull String str2, @Nullable String str3, @NonNull List<String> list) throws MsalClientException {
        MsalUtils.validateNonNullArgument(context, "context");
        MsalUtils.validateNonNullArgument(str, "client_id");
        MsalUtils.validateNonNullArgument(str2, "authority");
        MsalUtils.validateNonNullArgument(list, NativeAuthPublicClientApplicationConfiguration.NativeAuthSerializedNames.CHALLENGE_TYPES);
        try {
            return createNativeAuthApplication(NativeAuthPublicClientApplicationConfigurationFactory.INSTANCE.initializeNativeAuthConfiguration(context), str, str2, str3, list);
        } catch (BaseException e) {
            throw new MsalClientException("unknown_error", MsalClientException.NATIVE_AUTH_APPLICATION_CREATION_UNKNOWN_ERROR_MESSAGE, e);
        }
    }

    @WorkerThread
    private static IPublicClientApplication create(@NonNull PublicClientApplicationConfiguration publicClientApplicationConfiguration) throws MsalException {
        MsalUtils.validateNonNullArgument(publicClientApplicationConfiguration, "configuration");
        MsalUtils.throwOnMainThread("createPublicClientApplication");
        final ResultFuture resultFuture = new ResultFuture();
        create(publicClientApplicationConfiguration, (String) null, (String) null, (String) null, new IPublicClientApplication.ApplicationCreatedListener() { // from class: com.microsoft.identity.client.PublicClientApplication.8
            @Override // com.microsoft.identity.client.IPublicClientApplication.ApplicationCreatedListener
            public void onCreated(IPublicClientApplication iPublicClientApplication) {
                resultFuture.setResult(new AsyncResult(iPublicClientApplication, null));
            }

            @Override // com.microsoft.identity.client.IPublicClientApplication.ApplicationCreatedListener
            public void onError(MsalException msalException) {
                resultFuture.setResult(new AsyncResult(null, msalException));
            }
        });
        try {
            AsyncResult asyncResult = (AsyncResult) resultFuture.get();
            if (asyncResult.getSuccess()) {
                return (IPublicClientApplication) asyncResult.getResult();
            }
            throw asyncResult.getException();
        } catch (ExecutionException e) {
            throw new MsalClientException("unknown_error", MsalClientException.NATIVE_AUTH_APPLICATION_CREATION_UNKNOWN_ERROR_MESSAGE, e);
        }
    }

    @WorkerThread
    private static IMultipleAccountPublicClientApplication createMultipleAccountPublicClientApplication(@NonNull PublicClientApplicationConfiguration publicClientApplicationConfiguration) throws MsalException {
        AccountMode accountMode = publicClientApplicationConfiguration.getAccountMode();
        AccountMode accountMode2 = AccountMode.MULTIPLE;
        if (accountMode == accountMode2) {
            IPublicClientApplication iPublicClientApplicationCreate = create(publicClientApplicationConfiguration);
            if (iPublicClientApplicationCreate instanceof IMultipleAccountPublicClientApplication) {
                return (IMultipleAccountPublicClientApplication) iPublicClientApplicationCreate;
            }
            if (publicClientApplicationConfiguration.getAccountMode() == accountMode2 && iPublicClientApplicationCreate.isSharedDevice()) {
                throw new MsalClientException(ErrorStrings.MULTIPLE_ACCOUNT_PCA_INIT_FAIL_ON_SHARED_DEVICE_ERROR_CODE, ErrorStrings.MULTIPLE_ACCOUNT_PCA_INIT_FAIL_ON_SHARED_DEVICE_ERROR_MESSAGE);
            }
            throw new MsalClientException(ErrorStrings.MULTIPLE_ACCOUNT_PCA_INIT_FAIL_UNKNOWN_REASON_ERROR_CODE, ErrorStrings.MULTIPLE_ACCOUNT_PCA_INIT_FAIL_UNKNOWN_REASON_ERROR_MESSAGE);
        }
        throw new MsalClientException(ErrorStrings.MULTIPLE_ACCOUNT_PCA_INIT_FAIL_ACCOUNT_MODE_ERROR_CODE, ErrorStrings.MULTIPLE_ACCOUNT_PCA_INIT_FAIL_ACCOUNT_MODE_ERROR_MESSAGE);
    }

    @WorkerThread
    private static ISingleAccountPublicClientApplication createSingleAccountPublicClientApplication(@Nullable PublicClientApplicationConfiguration publicClientApplicationConfiguration) throws MsalException {
        IPublicClientApplication iPublicClientApplicationCreate = create(publicClientApplicationConfiguration);
        if (iPublicClientApplicationCreate instanceof ISingleAccountPublicClientApplication) {
            return (ISingleAccountPublicClientApplication) iPublicClientApplicationCreate;
        }
        if (publicClientApplicationConfiguration.getAccountMode() != AccountMode.SINGLE) {
            throw new MsalClientException(ErrorStrings.SINGLE_ACCOUNT_PCA_INIT_FAIL_ACCOUNT_MODE_ERROR_CODE, ErrorStrings.SINGLE_ACCOUNT_PCA_INIT_FAIL_ACCOUNT_MODE_ERROR_MESSAGE);
        }
        throw new MsalClientException(ErrorStrings.SINGLE_ACCOUNT_PCA_INIT_FAIL_UNKNOWN_REASON_ERROR_CODE, ErrorStrings.SINGLE_ACCOUNT_PCA_INIT_FAIL_UNKNOWN_REASON_ERROR_MESSAGE);
    }

    @Deprecated
    public AcquireTokenParameters buildAcquireTokenParameters(@NonNull Activity activity, @Nullable Fragment fragment, @NonNull String[] strArr, @Nullable IAccount iAccount, @Nullable Prompt prompt, @Nullable List<Map.Entry<String, String>> list, @Nullable String[] strArr2, @Nullable String str, @NonNull AuthenticationCallback authenticationCallback, @Nullable String str2, @Nullable ClaimsRequest claimsRequest) {
        MsalUtils.validateNonNullArgument(activity, Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        MsalUtils.validateNonNullArgument(strArr, "scopes");
        MsalUtils.validateNonNullArgument(authenticationCallback, Profile.PhoneNumberData.TYPE_CALLBACK);
        AcquireTokenParameters.Builder builderWithAuthorizationQueryStringParameters = new AcquireTokenParameters.Builder().startAuthorizationFromActivity(activity).withFragment(fragment).forAccount(iAccount).withScopes(Arrays.asList(strArr)).withPrompt(prompt).withAuthorizationQueryStringParameters(list);
        if (strArr2 == null) {
            strArr2 = new String[0];
        }
        return builderWithAuthorizationQueryStringParameters.withOtherScopesToAuthorize(Arrays.asList(strArr2)).fromAuthority(str).withCallback(authenticationCallback).withLoginHint(str2).withClaims(claimsRequest).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createSingleAccountPublicClientApplication(@NonNull PublicClientApplicationConfiguration publicClientApplicationConfiguration, @NonNull final IPublicClientApplication.ISingleAccountApplicationCreatedListener iSingleAccountApplicationCreatedListener) {
        create(publicClientApplicationConfiguration, (String) null, (String) null, (String) null, new IPublicClientApplication.ApplicationCreatedListener() { // from class: com.microsoft.identity.client.PublicClientApplication.11
            @Override // com.microsoft.identity.client.IPublicClientApplication.ApplicationCreatedListener
            public void onCreated(IPublicClientApplication iPublicClientApplication) {
                if (iPublicClientApplication instanceof ISingleAccountPublicClientApplication) {
                    iSingleAccountApplicationCreatedListener.onCreated((ISingleAccountPublicClientApplication) iPublicClientApplication);
                } else if (iPublicClientApplication.getConfiguration().getAccountMode() != AccountMode.SINGLE) {
                    iSingleAccountApplicationCreatedListener.onError(new MsalClientException(ErrorStrings.SINGLE_ACCOUNT_PCA_INIT_FAIL_ACCOUNT_MODE_ERROR_CODE, ErrorStrings.SINGLE_ACCOUNT_PCA_INIT_FAIL_ACCOUNT_MODE_ERROR_MESSAGE));
                } else {
                    iSingleAccountApplicationCreatedListener.onError(new MsalClientException(ErrorStrings.SINGLE_ACCOUNT_PCA_INIT_FAIL_UNKNOWN_REASON_ERROR_CODE, ErrorStrings.SINGLE_ACCOUNT_PCA_INIT_FAIL_UNKNOWN_REASON_ERROR_MESSAGE));
                }
            }

            @Override // com.microsoft.identity.client.IPublicClientApplication.ApplicationCreatedListener
            public void onError(MsalException msalException) {
                iSingleAccountApplicationCreatedListener.onError(msalException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createMultipleAccountPublicClientApplication(@NonNull PublicClientApplicationConfiguration publicClientApplicationConfiguration, @NonNull final IPublicClientApplication.IMultipleAccountApplicationCreatedListener iMultipleAccountApplicationCreatedListener) {
        create(publicClientApplicationConfiguration, (String) null, (String) null, (String) null, new IPublicClientApplication.ApplicationCreatedListener() { // from class: com.microsoft.identity.client.PublicClientApplication.10
            @Override // com.microsoft.identity.client.IPublicClientApplication.ApplicationCreatedListener
            public void onCreated(@NonNull IPublicClientApplication iPublicClientApplication) {
                if (iPublicClientApplication instanceof IMultipleAccountPublicClientApplication) {
                    iMultipleAccountApplicationCreatedListener.onCreated((IMultipleAccountPublicClientApplication) iPublicClientApplication);
                } else if (iPublicClientApplication.getConfiguration().getAccountMode() == AccountMode.MULTIPLE && iPublicClientApplication.isSharedDevice()) {
                    iMultipleAccountApplicationCreatedListener.onError(new MsalClientException(ErrorStrings.MULTIPLE_ACCOUNT_PCA_INIT_FAIL_ON_SHARED_DEVICE_ERROR_CODE, ErrorStrings.MULTIPLE_ACCOUNT_PCA_INIT_FAIL_ON_SHARED_DEVICE_ERROR_MESSAGE));
                } else {
                    iMultipleAccountApplicationCreatedListener.onError(new MsalClientException(ErrorStrings.MULTIPLE_ACCOUNT_PCA_INIT_FAIL_UNKNOWN_REASON_ERROR_CODE, ErrorStrings.MULTIPLE_ACCOUNT_PCA_INIT_FAIL_UNKNOWN_REASON_ERROR_MESSAGE));
                }
            }

            @Override // com.microsoft.identity.client.IPublicClientApplication.ApplicationCreatedListener
            public void onError(MsalException msalException) {
                iMultipleAccountApplicationCreatedListener.onError(msalException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void create(@NonNull final PublicClientApplicationConfiguration publicClientApplicationConfiguration, @Nullable String str, @Nullable String str2, @Nullable String str3, @NonNull final IPublicClientApplication.ApplicationCreatedListener applicationCreatedListener) {
        if (str != null) {
            publicClientApplicationConfiguration.setClientId(str);
        }
        if (str2 != null) {
            publicClientApplicationConfiguration.getAuthorities().clear();
            Authority authorityFromAuthorityUrl = Authority.getAuthorityFromAuthorityUrl(str2);
            authorityFromAuthorityUrl.setDefault(Boolean.TRUE);
            publicClientApplicationConfiguration.getAuthorities().add(authorityFromAuthorityUrl);
        }
        if (str3 != null) {
            publicClientApplicationConfiguration.setRedirectUri(str3);
        }
        try {
            validateAccountModeConfiguration(publicClientApplicationConfiguration);
            CommandDispatcher.submitSilent(new GetDeviceModeCommand(CommandParametersAdapter.createCommandParameters(publicClientApplicationConfiguration, publicClientApplicationConfiguration.getOAuth2TokenCache()), new MSALControllerFactory(publicClientApplicationConfiguration), new CommandCallback<Boolean, BaseException>() { // from class: com.microsoft.identity.client.PublicClientApplication.9
                @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
                public void onError(BaseException baseException) {
                    applicationCreatedListener.onError(MsalExceptionAdapter.msalExceptionFromBaseException(baseException));
                }

                @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
                public void onTaskCompleted(Boolean bool) {
                    publicClientApplicationConfiguration.setIsSharedDevice(bool.booleanValue());
                    try {
                        PublicClientApplicationConfiguration publicClientApplicationConfiguration2 = publicClientApplicationConfiguration;
                        if ((publicClientApplicationConfiguration2 instanceof NativeAuthPublicClientApplicationConfiguration) && publicClientApplicationConfiguration2.getAccountMode() == AccountMode.SINGLE) {
                            publicClientApplicationConfiguration.validateConfiguration();
                            applicationCreatedListener.onCreated(new NativeAuthPublicClientApplication((NativeAuthPublicClientApplicationConfiguration) publicClientApplicationConfiguration));
                            return;
                        }
                        if (publicClientApplicationConfiguration.getAccountMode() != AccountMode.SINGLE && !bool.booleanValue()) {
                            applicationCreatedListener.onCreated(new MultipleAccountPublicClientApplication(publicClientApplicationConfiguration));
                            return;
                        }
                        applicationCreatedListener.onCreated(new SingleAccountPublicClientApplication(publicClientApplicationConfiguration));
                    } catch (MsalClientException e) {
                        applicationCreatedListener.onError(e);
                    }
                }

                @Override // com.microsoft.identity.common.java.commands.CommandCallback
                public void onCancel() {
                }
            }, PublicApiId.PCA_GET_DEVICE_MODE));
        } catch (MsalClientException e) {
            applicationCreatedListener.onError(e);
        }
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    public void acquireTokenWithDeviceCode(@NonNull List<String> list, @NonNull IPublicClientApplication.DeviceCodeFlowCallback deviceCodeFlowCallback) {
        PublicClientApplicationConfiguration publicClientApplicationConfiguration = this.mPublicClientConfiguration;
        CommandDispatcher.submitSilent(new DeviceCodeFlowCommand(CommandParametersAdapter.createDeviceCodeFlowCommandParameters(publicClientApplicationConfiguration, publicClientApplicationConfiguration.getOAuth2TokenCache(), list), new LocalMSALController().asControllerFactory(), getDeviceCodeFlowCommandCallback(deviceCodeFlowCallback), PublicApiId.DEVICE_CODE_FLOW_WITH_CALLBACK));
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    @Deprecated
    public void acquireTokenWithDeviceCode(@NonNull String[] strArr, @NonNull IPublicClientApplication.DeviceCodeFlowCallback deviceCodeFlowCallback) {
        PublicClientApplicationConfiguration publicClientApplicationConfiguration = this.mPublicClientConfiguration;
        CommandDispatcher.submitSilent(new DeviceCodeFlowCommand(CommandParametersAdapter.createDeviceCodeFlowCommandParameters(publicClientApplicationConfiguration, publicClientApplicationConfiguration.getOAuth2TokenCache(), Arrays.asList(strArr)), new LocalMSALController().asControllerFactory(), getDeviceCodeFlowCommandCallback(deviceCodeFlowCallback), PublicApiId.DEVICE_CODE_FLOW_WITH_CALLBACK));
    }
}
