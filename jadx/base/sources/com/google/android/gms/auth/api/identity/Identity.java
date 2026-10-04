package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p262authapi.zbaq;
import com.google.android.gms.internal.p262authapi.zbaw;
import com.google.android.gms.internal.p262authapi.zbbg;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Identity {
    private Identity() {
    }

    @NonNull
    public static AuthorizationClient getAuthorizationClient(@NonNull Activity activity) {
        return new zbaq((Activity) Preconditions.checkNotNull(activity), new zbb(null).zbb());
    }

    @NonNull
    public static CredentialSavingClient getCredentialSavingClient(@NonNull Activity activity) {
        return new zbaw((Activity) Preconditions.checkNotNull(activity), new zbh());
    }

    @NonNull
    public static SignInClient getSignInClient(@NonNull Activity activity) {
        return new zbbg((Activity) Preconditions.checkNotNull(activity), new zbu());
    }

    @NonNull
    public static AuthorizationClient getAuthorizationClient(@NonNull Context context) {
        return new zbaq((Context) Preconditions.checkNotNull(context), new zbb(null).zbb());
    }

    @NonNull
    public static CredentialSavingClient getCredentialSavingClient(@NonNull Context context) {
        return new zbaw((Context) Preconditions.checkNotNull(context), new zbh());
    }

    @NonNull
    public static SignInClient getSignInClient(@NonNull Context context) {
        return new zbbg((Context) Preconditions.checkNotNull(context), new zbu());
    }
}
