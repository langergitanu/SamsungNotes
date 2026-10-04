package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface zzf extends IInterface {
    Bundle zzd(String str, Bundle bundle);

    @Nullable
    Bundle zze(Account account, String str, Bundle bundle);

    @Nullable
    Bundle zzf(Account account);

    Bundle zzg(String str);

    AccountChangeEventsResponse zzh(AccountChangeEventsRequest accountChangeEventsRequest);
}
