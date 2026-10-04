package com.microsoft.identity.common.internal.result;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.commands.AcquirePrtSsoTokenResult;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IBrokerResultAdapter {
    @NonNull
    ILocalAuthenticationResult authenticationResultFromBundle(Bundle bundle);

    @NonNull
    Bundle bundleFromAuthenticationResult(@NonNull ILocalAuthenticationResult iLocalAuthenticationResult, @Nullable String str);

    @NonNull
    Bundle bundleFromBaseException(@NonNull BaseException baseException, @Nullable String str);

    @NonNull
    AcquirePrtSsoTokenResult getAcquirePrtSsoTokenResultFromBundle(Bundle bundle);

    @NonNull
    BaseException getBaseExceptionFromBundle(Bundle bundle);
}
