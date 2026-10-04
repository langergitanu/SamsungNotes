package com.microsoft.identity.client;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.ISingleAccountPublicClientApplication;
import com.microsoft.identity.client.claims.ClaimsRequest;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.AsyncResult;
import com.microsoft.identity.client.internal.CommandParametersAdapter;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.client.internal.controllers.MSALControllerFactory;
import com.microsoft.identity.client.internal.controllers.MsalExceptionAdapter;
import com.microsoft.identity.common.adal.internal.util.JsonExtensions;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.crypto.AndroidAuthSdkStorageEncryptionManager;
import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;
import com.microsoft.identity.common.internal.commands.GetCurrentAccountCommand;
import com.microsoft.identity.common.internal.commands.RemoveCurrentAccountCommand;
import com.microsoft.identity.common.internal.migration.TokenMigrationCallback;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.commands.DeviceCodeFlowCommandCallback;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.java.result.LocalAuthenticationResult;
import com.microsoft.identity.common.java.util.ResultFuture;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SingleAccountPublicClientApplication extends PublicClientApplication implements ISingleAccountPublicClientApplication {
    public static final String CURRENT_ACCOUNT_SHARED_PREFERENCE_KEY = "com.microsoft.identity.client.single_account_credential_cache.current_account";
    public static final String SINGLE_ACCOUNT_CREDENTIAL_SHARED_PREFERENCES = "com.microsoft.identity.client.single_account_credential_cache";
    private static final String TAG = "SingleAccountPublicClientApplication";
    private SharedPreferencesFileManager sharedPreferencesFileManager;

    public SingleAccountPublicClientApplication(@NonNull PublicClientApplicationConfiguration publicClientApplicationConfiguration) {
        super(publicClientApplicationConfiguration);
        initializeSharedPreferenceFileManager(publicClientApplicationConfiguration.getAppContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCurrentAccountNotifyCallback(@NonNull ISingleAccountPublicClientApplication.CurrentAccountCallback currentAccountCallback, @Nullable List<ICacheRecord> list, @Nullable MultiTenantAccount multiTenantAccount, boolean z) {
        MultiTenantAccount accountFromICacheRecordList = list == null ? null : getAccountFromICacheRecordList(list);
        if (z || !isHomeAccountIdMatching(multiTenantAccount, accountFromICacheRecordList)) {
            currentAccountCallback.onAccountChanged(multiTenantAccount, accountFromICacheRecordList);
        }
        currentAccountCallback.onAccountLoaded(accountFromICacheRecordList);
    }

    @Nullable
    private MultiTenantAccount getAccountFromICacheRecordList(@NonNull List<ICacheRecord> list) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getAccountFromICacheRecords", new StringBuilder());
        if (list.size() == 0) {
            return null;
        }
        List<IAccount> listAdapt = AccountAdapter.adapt(list);
        if (listAdapt.size() != 1) {
            com.microsoft.identity.common.logging.Logger.verbose(strM1170p, "Returned cacheRecords were adapted into multiple IAccount. This is unexpected in Single account mode.Returning the first adapted account.");
        }
        if (listAdapt.isEmpty()) {
            return null;
        }
        return (MultiTenantAccount) listAdapt.get(0);
    }

    private void getCurrentAccountAsyncInternal(@NonNull final ISingleAccountPublicClientApplication.CurrentAccountCallback currentAccountCallback, @NonNull final String str) {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":getCurrentAccountAsyncInternal", new StringBuilder());
        performMigration(new TokenMigrationCallback() { // from class: com.microsoft.identity.client.SingleAccountPublicClientApplication.1
            @Override // com.microsoft.identity.common.internal.migration.TokenMigrationCallback
            public void onMigrationFinished(int i) {
                PublicClientApplicationConfiguration publicClientApplicationConfiguration = SingleAccountPublicClientApplication.this.mPublicClientConfiguration;
                CommandDispatcher.submitSilent(new GetCurrentAccountCommand(CommandParametersAdapter.createCommandParameters(publicClientApplicationConfiguration, publicClientApplicationConfiguration.getOAuth2TokenCache()), new MSALControllerFactory(SingleAccountPublicClientApplication.this.mPublicClientConfiguration), new CommandCallback<List<ICacheRecord>, BaseException>() { // from class: com.microsoft.identity.client.SingleAccountPublicClientApplication.1.1
                    @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
                    public void onError(BaseException baseException) {
                        currentAccountCallback.onError(MsalExceptionAdapter.msalExceptionFromBaseException(baseException));
                    }

                    @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
                    public void onTaskCompleted(List<ICacheRecord> list) {
                        MultiTenantAccount persistedCurrentAccount;
                        boolean z;
                        try {
                            persistedCurrentAccount = SingleAccountPublicClientApplication.this.getPersistedCurrentAccount();
                            z = false;
                        } catch (NullPointerException e) {
                            com.microsoft.identity.common.logging.Logger.error(strM1170p, "Failed to load Persisted Current Account", e);
                            SingleAccountPublicClientApplication.this.sharedPreferencesFileManager.remove(SingleAccountPublicClientApplication.CURRENT_ACCOUNT_SHARED_PREFERENCE_KEY);
                            persistedCurrentAccount = null;
                            z = true;
                        }
                        SingleAccountPublicClientApplication.this.persistCurrentAccount(list);
                        C62201 c62201 = C62201.this;
                        SingleAccountPublicClientApplication.this.checkCurrentAccountNotifyCallback(currentAccountCallback, list, persistedCurrentAccount, z);
                    }

                    @Override // com.microsoft.identity.common.java.commands.CommandCallback
                    public void onCancel() {
                    }
                }, str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MultiTenantAccount getPersistedCurrentAccount() {
        synchronized (SingleAccountPublicClientApplication.class) {
            try {
                String string = this.sharedPreferencesFileManager.getString(CURRENT_ACCOUNT_SHARED_PREFERENCE_KEY);
                if (StringExtensions.isNullOrBlank(string)) {
                    return null;
                }
                return getAccountFromICacheRecordList(JsonExtensions.getICacheRecordListFromJsonString(string));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void initializeSharedPreferenceFileManager(@NonNull Context context) {
        this.sharedPreferencesFileManager = new SharedPreferencesFileManager(context, SINGLE_ACCOUNT_CREDENTIAL_SHARED_PREFERENCES, new AndroidAuthSdkStorageEncryptionManager(context));
    }

    private boolean isHomeAccountIdMatching(@Nullable IAccount iAccount, @Nullable IAccount iAccount2) {
        MultiTenantAccount multiTenantAccount = iAccount instanceof MultiTenantAccount ? (MultiTenantAccount) iAccount : null;
        MultiTenantAccount multiTenantAccount2 = iAccount2 instanceof MultiTenantAccount ? (MultiTenantAccount) iAccount2 : null;
        return (multiTenantAccount == null ? "" : multiTenantAccount.getHomeAccountId()).equalsIgnoreCase(multiTenantAccount2 != null ? multiTenantAccount2.getHomeAccountId() : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void persistCurrentAccount(@Nullable List<ICacheRecord> list) {
        synchronized (SingleAccountPublicClientApplication.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        com.microsoft.identity.common.logging.Logger.info(TAG, "persisting cache records with size " + list.size());
                        this.sharedPreferencesFileManager.putString(CURRENT_ACCOUNT_SHARED_PREFERENCE_KEY, JsonExtensions.getJsonStringFromICacheRecordList(list));
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.sharedPreferencesFileManager.clear();
        }
    }

    @Override // com.microsoft.identity.client.PublicClientApplication, com.microsoft.identity.client.IPublicClientApplication
    public void acquireToken(@NonNull AcquireTokenParameters acquireTokenParameters) {
        MultiTenantAccount persistedCurrentAccount = getPersistedCurrentAccount();
        if (persistedCurrentAccount != null) {
            if (acquireTokenParameters.getAccount() == null && StringExtensions.isNullOrBlank(acquireTokenParameters.getLoginHint())) {
                acquireTokenParameters.getCallback().onError(new MsalClientException(MsalClientException.CURRENT_ACCOUNT_MISMATCH, MsalClientException.CURRENT_ACCOUNT_MISMATCH_ERROR_MESSAGE));
                return;
            }
            if (acquireTokenParameters.getAccount() != null && !isHomeAccountIdMatching(persistedCurrentAccount, acquireTokenParameters.getAccount())) {
                acquireTokenParameters.getCallback().onError(new MsalClientException(MsalClientException.CURRENT_ACCOUNT_MISMATCH, MsalClientException.CURRENT_ACCOUNT_MISMATCH_ERROR_MESSAGE));
                return;
            } else if (!StringExtensions.isNullOrBlank(acquireTokenParameters.getLoginHint()) && !persistedCurrentAccount.getUsername().equalsIgnoreCase(acquireTokenParameters.getLoginHint())) {
                acquireTokenParameters.getCallback().onError(new MsalClientException(MsalClientException.CURRENT_ACCOUNT_MISMATCH, MsalClientException.CURRENT_ACCOUNT_MISMATCH_ERROR_MESSAGE));
                return;
            }
        }
        acquireTokenInternal(acquireTokenParameters, PublicApiId.SINGLE_ACCOUNT_PCA_ACQUIRE_TOKEN_WITH_PARAMETERS);
    }

    @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication
    @WorkerThread
    @Deprecated
    public IAuthenticationResult acquireTokenSilent(@NonNull String[] strArr, @NonNull String str) throws MsalClientException {
        MultiTenantAccount persistedCurrentAccount = getPersistedCurrentAccount();
        if (persistedCurrentAccount != null) {
            return acquireTokenSilentSyncInternal(strArr, str, persistedCurrentAccount, false, PublicApiId.SINGLE_ACCOUNT_PCA_ACQUIRE_TOKEN_SILENT_WITH_SCOPES_AUTHORITY);
        }
        throw new MsalClientException(MsalClientException.NO_CURRENT_ACCOUNT, MsalClientException.NO_CURRENT_ACCOUNT_ERROR_MESSAGE);
    }

    @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication
    @Deprecated
    public void acquireTokenSilentAsync(@NonNull String[] strArr, @NonNull String str, @NonNull SilentAuthenticationCallback silentAuthenticationCallback) {
        MultiTenantAccount persistedCurrentAccount = getPersistedCurrentAccount();
        if (persistedCurrentAccount == null) {
            silentAuthenticationCallback.onError(new MsalClientException(MsalClientException.NO_CURRENT_ACCOUNT, MsalClientException.NO_CURRENT_ACCOUNT_ERROR_MESSAGE));
        } else {
            acquireTokenSilentAsyncInternal(buildAcquireTokenSilentParameters(strArr, persistedCurrentAccount, str, false, null, silentAuthenticationCallback), PublicApiId.f3597x2a5030cc);
        }
    }

    @Override // com.microsoft.identity.client.PublicClientApplication
    public CommandCallback<ILocalAuthenticationResult, BaseException> getCommandCallback(@NonNull final SilentAuthenticationCallback silentAuthenticationCallback, @NonNull final TokenParameters tokenParameters) {
        return new CommandCallback<ILocalAuthenticationResult, BaseException>() { // from class: com.microsoft.identity.client.SingleAccountPublicClientApplication.3
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
            public void onTaskCompleted(@NonNull ILocalAuthenticationResult iLocalAuthenticationResult) {
                if (silentAuthenticationCallback == null) {
                    throw new IllegalStateException("callback cannot be null or empty");
                }
                SingleAccountPublicClientApplication.this.persistCurrentAccount(iLocalAuthenticationResult.getCacheRecordWithTenantProfileData());
                SingleAccountPublicClientApplication.this.postAuthResult(iLocalAuthenticationResult, tokenParameters, silentAuthenticationCallback);
            }
        };
    }

    @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication
    public ICurrentAccountResult getCurrentAccount() throws MsalException {
        MsalUtils.throwOnMainThread("getCurrentAccount");
        final ResultFuture resultFuture = new ResultFuture();
        getCurrentAccountAsyncInternal(new ISingleAccountPublicClientApplication.CurrentAccountCallback() { // from class: com.microsoft.identity.client.SingleAccountPublicClientApplication.2
            @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication.CurrentAccountCallback
            public void onAccountChanged(@Nullable IAccount iAccount, @Nullable IAccount iAccount2) {
                resultFuture.setResult(new AsyncResult(new CurrentAccountResult(iAccount2, iAccount, false), null));
            }

            @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication.CurrentAccountCallback
            public void onAccountLoaded(@Nullable IAccount iAccount) {
                resultFuture.setResult(new AsyncResult(new CurrentAccountResult(iAccount, null, false), null));
            }

            @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication.CurrentAccountCallback
            public void onError(@NonNull MsalException msalException) {
                resultFuture.setResult(new AsyncResult(null, msalException));
            }
        }, PublicApiId.SINGLE_ACCOUNT_PCA_GET_CURRENT_ACCOUNT);
        try {
            AsyncResult asyncResult = (AsyncResult) resultFuture.get();
            if (asyncResult.getSuccess()) {
                return (ICurrentAccountResult) asyncResult.getResult();
            }
            throw asyncResult.getException();
        } catch (ExecutionException e) {
            throw new MsalClientException("unknown_error", "Unknown exception while fetching current account.", e);
        }
    }

    @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication
    public void getCurrentAccountAsync(@NonNull ISingleAccountPublicClientApplication.CurrentAccountCallback currentAccountCallback) {
        getCurrentAccountAsyncInternal(currentAccountCallback, PublicApiId.SINGLE_ACCOUNT_PCA_GET_CURRENT_ACCOUNT_ASYNC);
    }

    @Override // com.microsoft.identity.client.PublicClientApplication
    public DeviceCodeFlowCommandCallback getDeviceCodeFlowCommandCallback(@NonNull final IPublicClientApplication.DeviceCodeFlowCallback deviceCodeFlowCallback) {
        return new DeviceCodeFlowCommandCallback<LocalAuthenticationResult, BaseException>() { // from class: com.microsoft.identity.client.SingleAccountPublicClientApplication.6
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
                IAuthenticationResult iAuthenticationResultAdapt = AuthenticationResultAdapter.adapt(localAuthenticationResult);
                SingleAccountPublicClientApplication.this.persistCurrentAccount(localAuthenticationResult.getCacheRecordWithTenantProfileData());
                deviceCodeFlowCallback.onTokenReceived(iAuthenticationResultAdapt);
            }

            @Override // com.microsoft.identity.common.java.commands.CommandCallback
            public void onCancel() {
            }
        };
    }

    @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication
    public void signIn(@NonNull SignInParameters signInParameters) {
        if (getPersistedCurrentAccount() != null) {
            signInParameters.getCallback().onError(new MsalClientException(MsalClientException.INVALID_PARAMETER, "An account is already signed in."));
            return;
        }
        AcquireTokenParameters acquireTokenParametersBuildAcquireTokenParameters = buildAcquireTokenParameters(signInParameters.getActivity(), (Fragment) null, signInParameters.getScopes(), (IAccount) null, signInParameters.getPrompt(), (List<Map.Entry<String, String>>) null, (String[]) null, (String) null, signInParameters.getCallback(), signInParameters.getLoginHint(), (ClaimsRequest) null);
        if (signInParameters.getPrompt() == null) {
            acquireTokenInternal(acquireTokenParametersBuildAcquireTokenParameters, PublicApiId.SINGLE_ACCOUNT_PCA_SIGN_IN_WITH_PARAMETERS);
        } else {
            acquireTokenInternal(acquireTokenParametersBuildAcquireTokenParameters, PublicApiId.SINGLE_ACCOUNT_PCA_SIGN_IN_WITH_PARAMETERS_PROMPT);
        }
    }

    @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication
    public void signInAgain(@NonNull SignInParameters signInParameters) {
        MultiTenantAccount persistedCurrentAccount = getPersistedCurrentAccount();
        if (persistedCurrentAccount == null) {
            signInParameters.getCallback().onError(new MsalClientException(MsalClientException.NO_CURRENT_ACCOUNT, MsalClientException.NO_CURRENT_ACCOUNT_ERROR_MESSAGE));
            return;
        }
        AcquireTokenParameters acquireTokenParametersBuildAcquireTokenParameters = buildAcquireTokenParameters(signInParameters.getActivity(), (Fragment) null, signInParameters.getScopes(), persistedCurrentAccount, signInParameters.getPrompt(), (List<Map.Entry<String, String>>) null, (String[]) null, (String) null, signInParameters.getCallback(), (String) null, (ClaimsRequest) null);
        if (signInParameters.getPrompt() == null) {
            acquireTokenInternal(acquireTokenParametersBuildAcquireTokenParameters, PublicApiId.SINGLE_ACCOUNT_PCA_EXISTING_SIGN_IN_WITH_PARAMETERS);
        } else {
            acquireTokenInternal(acquireTokenParametersBuildAcquireTokenParameters, PublicApiId.SINGLE_ACCOUNT_PCA_EXISTING_SIGN_IN_WITH_PARAMETERS_PROMPT);
        }
    }

    @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication
    public void signOut(@NonNull ISingleAccountPublicClientApplication.SignOutCallback signOutCallback) {
        signOutInternal(signOutCallback, PublicApiId.SINGLE_ACCOUNT_PCA_SIGN_OUT_WITH_CALLBACK);
    }

    public void signOutInternal(@NonNull final ISingleAccountPublicClientApplication.SignOutCallback signOutCallback, @NonNull String str) {
        MultiTenantAccount persistedCurrentAccount = getPersistedCurrentAccount();
        if (persistedCurrentAccount == null) {
            signOutCallback.onError(new MsalClientException(MsalClientException.NO_CURRENT_ACCOUNT, MsalClientException.NO_CURRENT_ACCOUNT_ERROR_MESSAGE));
            return;
        }
        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setEnvironment(persistedCurrentAccount.getEnvironment());
        accountRecord.setHomeAccountId(persistedCurrentAccount.getHomeAccountId());
        PublicClientApplicationConfiguration publicClientApplicationConfiguration = this.mPublicClientConfiguration;
        CommandDispatcher.submitSilent(new RemoveCurrentAccountCommand(CommandParametersAdapter.createRemoveAccountCommandParameters(publicClientApplicationConfiguration, publicClientApplicationConfiguration.getOAuth2TokenCache(), accountRecord), new MSALControllerFactory(this.mPublicClientConfiguration), new CommandCallback<Boolean, BaseException>() { // from class: com.microsoft.identity.client.SingleAccountPublicClientApplication.4
            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
            public void onError(BaseException baseException) {
                signOutCallback.onError(MsalExceptionAdapter.msalExceptionFromBaseException(baseException));
            }

            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
            public void onTaskCompleted(Boolean bool) {
                SingleAccountPublicClientApplication.this.persistCurrentAccount(null);
                signOutCallback.onSignOut();
            }

            @Override // com.microsoft.identity.common.java.commands.CommandCallback
            public void onCancel() {
            }
        }, str));
    }

    @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication
    public boolean signOut() throws MsalException {
        MsalUtils.throwOnMainThread("signOut");
        final ResultFuture resultFuture = new ResultFuture();
        signOutInternal(new ISingleAccountPublicClientApplication.SignOutCallback() { // from class: com.microsoft.identity.client.SingleAccountPublicClientApplication.5
            @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication.SignOutCallback
            public void onError(@NonNull MsalException msalException) {
                resultFuture.setResult(new AsyncResult(Boolean.FALSE, msalException));
            }

            @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication.SignOutCallback
            public void onSignOut() {
                resultFuture.setResult(new AsyncResult(Boolean.TRUE, null));
            }
        }, PublicApiId.SINGLE_ACCOUNT_PCA_SIGN_OUT);
        try {
            AsyncResult asyncResult = (AsyncResult) resultFuture.get();
            if (asyncResult.getSuccess()) {
                return ((Boolean) asyncResult.getResult()).booleanValue();
            }
            throw asyncResult.getException();
        } catch (ExecutionException e) {
            throw new MsalClientException("unknown_error", "Unexpected error during signOut.", e);
        }
    }

    @Override // com.microsoft.identity.client.PublicClientApplication, com.microsoft.identity.client.IPublicClientApplication
    public IAuthenticationResult acquireTokenSilent(@NonNull AcquireTokenSilentParameters acquireTokenSilentParameters) throws MsalClientException {
        MultiTenantAccount persistedCurrentAccount = getPersistedCurrentAccount();
        if (persistedCurrentAccount != null) {
            if (isHomeAccountIdMatching(persistedCurrentAccount, acquireTokenSilentParameters.getAccount())) {
                return acquireTokenSilentInternal(acquireTokenSilentParameters, PublicApiId.SINGLE_ACCOUNT_PCA_ACQUIRE_TOKEN_SILENT_WITH_PARAMETERS);
            }
            throw new MsalClientException(MsalClientException.CURRENT_ACCOUNT_MISMATCH, MsalClientException.CURRENT_ACCOUNT_MISMATCH_ERROR_MESSAGE);
        }
        throw new MsalClientException(MsalClientException.NO_CURRENT_ACCOUNT, MsalClientException.NO_CURRENT_ACCOUNT_ERROR_MESSAGE);
    }

    @Override // com.microsoft.identity.client.PublicClientApplication, com.microsoft.identity.client.IPublicClientApplication
    public void acquireTokenSilentAsync(@NonNull AcquireTokenSilentParameters acquireTokenSilentParameters) {
        MultiTenantAccount persistedCurrentAccount = getPersistedCurrentAccount();
        if (persistedCurrentAccount == null) {
            acquireTokenSilentParameters.getCallback().onError(new MsalClientException(MsalClientException.NO_CURRENT_ACCOUNT, MsalClientException.NO_CURRENT_ACCOUNT_ERROR_MESSAGE));
        } else if (!isHomeAccountIdMatching(persistedCurrentAccount, acquireTokenSilentParameters.getAccount())) {
            acquireTokenSilentParameters.getCallback().onError(new MsalClientException(MsalClientException.CURRENT_ACCOUNT_MISMATCH, MsalClientException.CURRENT_ACCOUNT_MISMATCH_ERROR_MESSAGE));
        } else {
            acquireTokenSilentAsyncInternal(acquireTokenSilentParameters, PublicApiId.SINGLE_ACCOUNT_PCA_ACQUIRE_TOKEN_SILENT_ASYNC_WITH_PARAMETERS);
        }
    }

    @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication
    @Deprecated
    public void signInAgain(@NonNull Activity activity, @NonNull String[] strArr, @Nullable Prompt prompt, @NonNull AuthenticationCallback authenticationCallback) {
        MultiTenantAccount persistedCurrentAccount = getPersistedCurrentAccount();
        if (persistedCurrentAccount == null) {
            authenticationCallback.onError(new MsalClientException(MsalClientException.NO_CURRENT_ACCOUNT, MsalClientException.NO_CURRENT_ACCOUNT_ERROR_MESSAGE));
        } else {
            acquireTokenInternal(buildAcquireTokenParameters(activity, (Fragment) null, Arrays.asList(strArr), persistedCurrentAccount, prompt, (List<Map.Entry<String, String>>) null, (String[]) null, (String) null, authenticationCallback, (String) null, (ClaimsRequest) null), PublicApiId.SINGLE_ACCOUNT_PCA_EXISTING_SIGN_IN_WITH_PROMPT);
        }
    }

    @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication
    @Deprecated
    public void signIn(@NonNull Activity activity, @Nullable String str, @NonNull String[] strArr, @NonNull AuthenticationCallback authenticationCallback) {
        if (getPersistedCurrentAccount() != null) {
            authenticationCallback.onError(new MsalClientException(MsalClientException.INVALID_PARAMETER, "An account is already signed in."));
        } else {
            acquireTokenInternal(buildAcquireTokenParameters(activity, (Fragment) null, Arrays.asList(strArr), (IAccount) null, (Prompt) null, (List<Map.Entry<String, String>>) null, (String[]) null, (String) null, authenticationCallback, str, (ClaimsRequest) null), PublicApiId.SINGLE_ACCOUNT_PCA_SIGN_IN);
        }
    }

    @Override // com.microsoft.identity.client.PublicClientApplication, com.microsoft.identity.client.IPublicClientApplication
    @Deprecated
    public void acquireToken(@NonNull Activity activity, @NonNull String[] strArr, @NonNull AuthenticationCallback authenticationCallback) {
        if (getPersistedCurrentAccount() == null) {
            authenticationCallback.onError(new MsalClientException(MsalClientException.NO_CURRENT_ACCOUNT, MsalClientException.NO_CURRENT_ACCOUNT_ERROR_MESSAGE));
        } else {
            acquireTokenInternal(buildAcquireTokenParameters(activity, (Fragment) null, Arrays.asList(strArr), getPersistedCurrentAccount(), (Prompt) null, (List<Map.Entry<String, String>>) null, (String[]) null, (String) null, authenticationCallback, (String) null, (ClaimsRequest) null), PublicApiId.SINGLE_ACCOUNT_PCA_ACQUIRE_TOKEN_WITH_ACTIVITY_SCOPES_CALLBACK);
        }
    }

    @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication
    @Deprecated
    public void signIn(@NonNull Activity activity, @Nullable String str, @NonNull String[] strArr, @Nullable Prompt prompt, @NonNull AuthenticationCallback authenticationCallback) {
        if (getPersistedCurrentAccount() != null) {
            authenticationCallback.onError(new MsalClientException(MsalClientException.INVALID_PARAMETER, "An account is already signed in."));
        } else {
            acquireTokenInternal(buildAcquireTokenParameters(activity, (Fragment) null, Arrays.asList(strArr), (IAccount) null, prompt, (List<Map.Entry<String, String>>) null, (String[]) null, (String) null, authenticationCallback, str, (ClaimsRequest) null), PublicApiId.SINGLE_ACCOUNT_PCA_SIGN_IN_WITH_PROMPT);
        }
    }
}
