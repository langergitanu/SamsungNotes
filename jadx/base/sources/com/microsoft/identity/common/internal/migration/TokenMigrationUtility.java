package com.microsoft.identity.common.internal.migration;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.cache.IShareSingleSignOnState;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.logging.Logger;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TokenMigrationUtility<T extends BaseAccount, U extends RefreshToken> {
    private static final String TAG = "TokenMigrationUtility";
    private static final ExecutorService sBackgroundExecutor = Executors.newCachedThreadPool();

    public void _import(final IMigrationAdapter<T, U> iMigrationAdapter, final Map<String, String> map, final IShareSingleSignOnState<T, U> iShareSingleSignOnState, final TokenMigrationCallback tokenMigrationCallback) {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":_import", new StringBuilder());
        sBackgroundExecutor.execute(new Runnable() { // from class: com.microsoft.identity.common.internal.migration.TokenMigrationUtility.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                for (Map.Entry<T, U> entry : iMigrationAdapter.adapt(map)) {
                    try {
                        iShareSingleSignOnState.setSingleSignOnState(entry.getKey(), entry.getValue());
                        i++;
                    } catch (ClientException unused) {
                        Logger.warn(strM1170p, "Failed to save account/refresh token . Skipping ");
                    }
                }
                tokenMigrationCallback.onMigrationFinished(i);
            }
        });
    }
}
