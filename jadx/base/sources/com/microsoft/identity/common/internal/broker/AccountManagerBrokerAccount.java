package com.microsoft.identity.common.internal.broker;

import android.accounts.Account;
import android.accounts.AccountManager;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.broker.IBrokerAccount;
import com.microsoft.identity.common.logging.Logger;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AccountManagerBrokerAccount implements IBrokerAccount {
    private static final String TAG = "AccountManagerBrokerAccount";

    @NonNull
    private final Account mAccount;

    private AccountManagerBrokerAccount(@NonNull Account account) {
        if (account == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        this.mAccount = account;
    }

    @NonNull
    public static AccountManagerBrokerAccount adapt(@NonNull Account account) {
        if (account != null) {
            return new AccountManagerBrokerAccount(account);
        }
        throw new NullPointerException("account is marked non-null but is null");
    }

    @NonNull
    public static AccountManagerBrokerAccount cast(@NonNull AccountManager accountManager, @NonNull IBrokerAccount iBrokerAccount) {
        if (accountManager == null) {
            throw new NullPointerException("accountManager is marked non-null but is null");
        }
        if (iBrokerAccount != null) {
            return iBrokerAccount instanceof AccountManagerBrokerAccount ? (AccountManagerBrokerAccount) iBrokerAccount : create(accountManager, iBrokerAccount.getUsername(), iBrokerAccount.getType());
        }
        throw new NullPointerException("account is marked non-null but is null");
    }

    @NonNull
    public static AccountManagerBrokerAccount create(@NonNull AccountManager accountManager, @NonNull String str, @NonNull String str2) {
        if (accountManager == null) {
            throw new NullPointerException("accountManager is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("accountName is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("accountType is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":create", new StringBuilder());
        Account account = getAccount(accountManager, str, str2);
        if (account == null) {
            account = new Account(str, str2);
            Logger.verbose(strM1170p, "Creating account.");
            Logger.verbosePII(strM1170p, "Creating account with name :" + account.name);
            accountManager.addAccountExplicitly(account, null, null);
        }
        setVisibility(accountManager, account, AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME);
        setVisibility(accountManager, account, AuthenticationConstants.Broker.COMPANY_PORTAL_APP_PACKAGE_NAME);
        if (BrokerData.getShouldTrustDebugBrokers()) {
            setVisibility(accountManager, account, BrokerData.getDebugMockCp().getPackageName());
            setVisibility(accountManager, account, BrokerData.getDebugMockAuthApp().getPackageName());
            setVisibility(accountManager, account, BrokerData.getDebugBrokerHost().getPackageName());
        }
        return adapt(account);
    }

    private static void setVisibility(@NonNull AccountManager accountManager, @NonNull Account account, @NonNull String str) {
        if (accountManager == null) {
            throw new NullPointerException("accountManager is marked non-null but is null");
        }
        if (account == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("packageName is marked non-null but is null");
        }
        if (accountManager.getAccountVisibility(account, str) != 1) {
            accountManager.setAccountVisibility(account, str, 1);
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof AccountManagerBrokerAccount;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountManagerBrokerAccount)) {
            return false;
        }
        AccountManagerBrokerAccount accountManagerBrokerAccount = (AccountManagerBrokerAccount) obj;
        if (!accountManagerBrokerAccount.canEqual(this)) {
            return false;
        }
        Account account = getAccount();
        Account account2 = accountManagerBrokerAccount.getAccount();
        return account != null ? account.equals(account2) : account2 == null;
    }

    @NonNull
    public Account getAccount() {
        return this.mAccount;
    }

    @Override // com.microsoft.identity.common.java.broker.IBrokerAccount
    @NonNull
    public String getType() {
        return this.mAccount.type;
    }

    @Override // com.microsoft.identity.common.java.broker.IBrokerAccount
    @NonNull
    public String getUsername() {
        return this.mAccount.name;
    }

    public int hashCode() {
        Account account = getAccount();
        return 59 + (account == null ? 43 : account.hashCode());
    }

    @Nullable
    private static Account getAccount(@NonNull AccountManager accountManager, @NonNull String str, @NonNull String str2) {
        if (accountManager == null) {
            throw new NullPointerException("accountManager is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("accountName is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("accountType is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getAccount", new StringBuilder());
        Account[] accountsByType = accountManager.getAccountsByType(str2);
        if (accountsByType != null) {
            for (Account account : accountsByType) {
                if (account.name.equalsIgnoreCase(str)) {
                    return account;
                }
            }
        }
        Logger.verbose(strM1170p, "Account not found.");
        return null;
    }
}
