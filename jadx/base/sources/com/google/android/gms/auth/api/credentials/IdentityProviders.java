package com.google.android.gms.auth.api.credentials;

import android.accounts.Account;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class IdentityProviders {

    @NonNull
    public static final String FACEBOOK = "https://www.facebook.com";

    @NonNull
    public static final String GOOGLE = "https://accounts.google.com";

    @NonNull
    public static final String LINKEDIN = "https://www.linkedin.com";

    @NonNull
    public static final String MICROSOFT = "https://login.live.com";

    @NonNull
    public static final String PAYPAL = "https://www.paypal.com";

    @NonNull
    public static final String TWITTER = "https://twitter.com";

    @NonNull
    public static final String YAHOO = "https://login.yahoo.com";

    private IdentityProviders() {
    }

    @Nullable
    public static final String getIdentityProviderForAccount(@NonNull Account account) {
        Preconditions.checkNotNull(account, "account cannot be null");
        if ("com.google".equals(account.type)) {
            return GOOGLE;
        }
        if ("com.facebook.auth.login".equals(account.type)) {
            return FACEBOOK;
        }
        return null;
    }
}
