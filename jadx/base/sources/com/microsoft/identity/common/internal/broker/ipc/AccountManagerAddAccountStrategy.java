package com.microsoft.identity.common.internal.broker.ipc;

import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.internal.util.AccountManagerUtil;
import com.microsoft.identity.common.internal.util.ProcessUtil;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.logging.Logger;
import java.io.IOException;
import java.util.HashSet;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressLint({"MissingPermission"})
public class AccountManagerAddAccountStrategy implements IIpcStrategy {
    private static final String TAG = "AccountManagerAddAccountStrategy";
    private final Context mContext;

    public AccountManagerAddAccountStrategy(Context context) {
        this.mContext = context;
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    @Nullable
    public Bundle communicateToBroker(@NonNull BrokerOperationBundle brokerOperationBundle) throws BrokerCommunicationException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":communicateToBroker", new StringBuilder());
        StringBuilder sbM15l = AbstractC0000a.m15l("Broker operation: ", brokerOperationBundle.getOperation().name(), " brokerPackage: ");
        sbM15l.append(brokerOperationBundle.getTargetBrokerAppPackageName());
        Logger.info(strM1170p, sbM15l.toString());
        try {
            AccountManagerFuture<Bundle> accountManagerFutureAddAccount = AccountManager.get(this.mContext).addAccount(AuthenticationConstants.Broker.BROKER_ACCOUNT_TYPE, AuthenticationConstants.Broker.AUTHTOKEN_TYPE, null, brokerOperationBundle.getAccountManagerBundle(), null, null, ProcessUtil.getPreferredHandler());
            Logger.verbose(strM1170p, "Received result from broker");
            return accountManagerFutureAddAccount.getResult();
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            Logger.error(strM1170p, e.getMessage(), e);
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.CONNECTION_ERROR, getType(), "Failed to connect to AccountManager", e);
        }
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    @NonNull
    public IIpcStrategy.Type getType() {
        return IIpcStrategy.Type.ACCOUNT_MANAGER_ADD_ACCOUNT;
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public boolean isSupportedByTargetedBroker(@NonNull String str) {
        HashSet hashSet = new HashSet();
        hashSet.add(AuthenticationConstants.Broker.BROKER_PACKAGE_NAME);
        return AccountManagerUtil.canUseAccountManagerOperation(this.mContext, hashSet);
    }
}
