package com.microsoft.identity.common.internal.broker.ipc;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.internal.cache.ActiveBrokerCacheUpdater;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerOperationBundle {
    private static final String TAG = "BrokerOperationBundle";

    @Nullable
    public final Bundle bundle;

    @NonNull
    public final Operation operation;

    @NonNull
    public final String targetBrokerAppPackageName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Operation {
        MSAL_HELLO(AuthenticationConstants.BrokerContentProvider.API.MSAL_HELLO, AuthenticationConstants.BrokerAccountManagerOperation.HELLO),
        MSAL_GET_INTENT_FOR_INTERACTIVE_REQUEST(AuthenticationConstants.BrokerContentProvider.API.ACQUIRE_TOKEN_INTERACTIVE, AuthenticationConstants.BrokerAccountManagerOperation.GET_INTENT_FOR_INTERACTIVE_REQUEST),
        MSAL_ACQUIRE_TOKEN_SILENT(AuthenticationConstants.BrokerContentProvider.API.ACQUIRE_TOKEN_SILENT, AuthenticationConstants.BrokerAccountManagerOperation.ACQUIRE_TOKEN_SILENT),
        MSAL_GET_ACCOUNTS(AuthenticationConstants.BrokerContentProvider.API.GET_ACCOUNTS, AuthenticationConstants.BrokerAccountManagerOperation.GET_ACCOUNTS),
        MSAL_REMOVE_ACCOUNT(AuthenticationConstants.BrokerContentProvider.API.REMOVE_ACCOUNT, AuthenticationConstants.BrokerAccountManagerOperation.REMOVE_ACCOUNT),
        MSAL_GET_DEVICE_MODE(AuthenticationConstants.BrokerContentProvider.API.GET_DEVICE_MODE, AuthenticationConstants.BrokerAccountManagerOperation.GET_DEVICE_MODE),
        MSAL_GET_CURRENT_ACCOUNT_IN_SHARED_DEVICE(AuthenticationConstants.BrokerContentProvider.API.GET_CURRENT_ACCOUNT_SHARED_DEVICE, AuthenticationConstants.BrokerAccountManagerOperation.GET_CURRENT_ACCOUNT),
        MSAL_SIGN_OUT_FROM_SHARED_DEVICE(AuthenticationConstants.BrokerContentProvider.API.SIGN_OUT_FROM_SHARED_DEVICE, AuthenticationConstants.BrokerAccountManagerOperation.REMOVE_ACCOUNT_FROM_SHARED_DEVICE),
        MSAL_GENERATE_SHR(AuthenticationConstants.BrokerContentProvider.API.GENERATE_SHR, AuthenticationConstants.BrokerAccountManagerOperation.GENERATE_SHR),
        BROKER_GET_KEY_FROM_INACTIVE_BROKER(null, null),
        BROKER_API_HELLO(AuthenticationConstants.BrokerContentProvider.API.BROKER_HELLO, null),
        BROKER_API_GET_BROKER_ACCOUNTS(AuthenticationConstants.BrokerContentProvider.API.BROKER_GET_ACCOUNTS, null),
        BROKER_API_REMOVE_BROKER_ACCOUNT(AuthenticationConstants.BrokerContentProvider.API.BROKER_REMOVE_ACCOUNT, null),
        BROKER_API_UPDATE_BRT(AuthenticationConstants.BrokerContentProvider.API.BROKER_UPDATE_BRT, null),
        BROKER_GET_FLIGHTS(AuthenticationConstants.BrokerContentProvider.API.BROKER_GET_FLIGHTS, null),
        BROKER_SET_FLIGHTS(AuthenticationConstants.BrokerContentProvider.API.BROKER_SET_FLIGHTS, null),
        MSAL_SSO_TOKEN(AuthenticationConstants.BrokerContentProvider.API.GET_SSO_TOKEN, null),
        DEVICE_REGISTRATION_OPERATIONS(AuthenticationConstants.BrokerContentProvider.API.DEVICE_REGISTRATION_PROTOCOLS, null),
        BROKER_API_UPLOAD_LOGS(AuthenticationConstants.BrokerContentProvider.API.BROKER_UPLOAD_LOGS, null),
        MSAL_FETCH_DCF_AUTH_RESULT(AuthenticationConstants.BrokerContentProvider.API.FETCH_DCF_AUTH_RESULT, null),
        MSAL_ACQUIRE_TOKEN_DCF(AuthenticationConstants.BrokerContentProvider.API.ACQUIRE_TOKEN_DCF, null),
        BROKER_DISCOVERY_METADATA_RETRIEVAL(AuthenticationConstants.BrokerContentProvider.API.BROKER_DISCOVERY_METADATA_RETRIEVAL, null),
        BROKER_DISCOVERY_FROM_SDK(AuthenticationConstants.BrokerContentProvider.API.BROKER_DISCOVERY_FROM_SDK, null),
        BROKER_DISCOVERY_SET_ACTIVE_BROKER(AuthenticationConstants.BrokerContentProvider.API.BROKER_DISCOVERY_SET_ACTIVE_BROKER, null),
        PASSTHROUGH(AuthenticationConstants.BrokerContentProvider.API.PASSTHROUGH, null),
        BROKER_READ_RESTRICTIONS_MANAGER(AuthenticationConstants.BrokerContentProvider.API.READ_RESTRICTIONS_MANAGER, null),
        MSAL_GET_PREFERRED_AUTH_METHOD(AuthenticationConstants.BrokerContentProvider.API.GET_PREFERRED_AUTH_METHOD, null),
        BROKER_INDIVIDUAL_LOGS_UPLOAD(AuthenticationConstants.BrokerContentProvider.API.BROKER_INDIVIDUAL_LOGS_UPLOAD, null);

        final String mAccountManagerOperation;
        final AuthenticationConstants.BrokerContentProvider.API mContentApi;

        Operation(AuthenticationConstants.BrokerContentProvider.API api, String str) {
            this.mContentApi = api;
            this.mAccountManagerOperation = str;
        }

        public String getAccountManagerOperation() {
            return this.mAccountManagerOperation;
        }

        public AuthenticationConstants.BrokerContentProvider.API getContentApi() {
            return this.mContentApi;
        }
    }

    public BrokerOperationBundle(@NonNull Operation operation, @NonNull String str, @Nullable Bundle bundle) {
        this.operation = operation;
        this.targetBrokerAppPackageName = str;
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        this.bundle = bundle2;
        bundle2.putBoolean(ActiveBrokerCacheUpdater.KEY_REQUEST_ACTIVE_BROKER_DATA, true);
        Logger.info(TAG, "Requested Active Broker Data");
    }

    private String getAccountManagerAddAccountOperationKey() throws BrokerCommunicationException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getAccountManagerAddAccountOperationKey", new StringBuilder());
        String accountManagerOperation = this.operation.getAccountManagerOperation();
        if (accountManagerOperation != null) {
            return accountManagerOperation;
        }
        String str = "Operation " + this.operation.name() + " is not supported by AccountManager addAccount().";
        Logger.warn(strM1170p, str);
        throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_CLIENT_SIDE, IIpcStrategy.Type.ACCOUNT_MANAGER_ADD_ACCOUNT, str, null);
    }

    public Bundle getAccountManagerBundle() {
        Bundle bundle = this.bundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(AuthenticationConstants.Broker.BROKER_ACCOUNT_MANAGER_OPERATION_KEY, getAccountManagerAddAccountOperationKey());
        return bundle;
    }

    @Nullable
    public Bundle getBundle() {
        return this.bundle;
    }

    public String getContentProviderPath() throws BrokerCommunicationException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getContentProviderUriPath", new StringBuilder());
        AuthenticationConstants.BrokerContentProvider.API contentApi = this.operation.getContentApi();
        if (contentApi != null) {
            return contentApi.getPath();
        }
        String str = "Operation " + this.operation.name() + " is not supported by ContentProvider.";
        Logger.warn(strM1170p, str);
        throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_CLIENT_SIDE, IIpcStrategy.Type.CONTENT_PROVIDER, str, null);
    }

    @NonNull
    public Operation getOperation() {
        return this.operation;
    }

    @NonNull
    public String getTargetBrokerAppPackageName() {
        return this.targetBrokerAppPackageName;
    }
}
