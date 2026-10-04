package com.google.api.client.googleapis.extensions.android.accounts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public final class GoogleAccountManager {
    public static final String ACCOUNT_TYPE = "com.google";
    private final AccountManager manager;

    public GoogleAccountManager(AccountManager accountManager) {
        this.manager = (AccountManager) Preconditions.checkNotNull(accountManager);
    }

    public Account getAccountByName(String str) {
        if (str == null) {
            return null;
        }
        for (Account account : getAccounts()) {
            if (str.equals(account.name)) {
                return account;
            }
        }
        return null;
    }

    public AccountManager getAccountManager() {
        return this.manager;
    }

    public Account[] getAccounts() {
        return this.manager.getAccountsByType("com.google");
    }

    public void invalidateAuthToken(String str) {
        this.manager.invalidateAuthToken("com.google", str);
    }

    public GoogleAccountManager(Context context) {
        this(AccountManager.get(context));
    }
}
