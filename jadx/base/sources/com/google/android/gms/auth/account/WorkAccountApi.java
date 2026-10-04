package com.google.android.gms.auth.account;

import android.accounts.Account;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface WorkAccountApi {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public interface AddAccountResult extends Result {
        @NonNull
        Account getAccount();
    }

    @NonNull
    @Deprecated
    PendingResult<AddAccountResult> addWorkAccount(@NonNull GoogleApiClient googleApiClient, @NonNull String str);

    @NonNull
    @Deprecated
    PendingResult<Result> removeWorkAccount(@NonNull GoogleApiClient googleApiClient, @NonNull Account account);

    @Deprecated
    void setWorkAuthenticatorEnabled(@NonNull GoogleApiClient googleApiClient, boolean z);

    @NonNull
    @Deprecated
    PendingResult<Result> setWorkAuthenticatorEnabledWithResult(@NonNull GoogleApiClient googleApiClient, boolean z);
}
