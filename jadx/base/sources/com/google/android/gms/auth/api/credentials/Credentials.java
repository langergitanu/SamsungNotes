package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.Auth;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class Credentials {
    @NonNull
    public static CredentialsClient getClient(@NonNull Activity activity) {
        return new CredentialsClient(activity, (Auth.AuthCredentialsOptions) CredentialsOptions.DEFAULT);
    }

    @NonNull
    public static CredentialsClient getClient(@NonNull Activity activity, @NonNull CredentialsOptions credentialsOptions) {
        return new CredentialsClient(activity, (Auth.AuthCredentialsOptions) credentialsOptions);
    }

    @NonNull
    public static CredentialsClient getClient(@NonNull Context context) {
        return new CredentialsClient(context, CredentialsOptions.DEFAULT);
    }

    @NonNull
    public static CredentialsClient getClient(@NonNull Context context, @NonNull CredentialsOptions credentialsOptions) {
        return new CredentialsClient(context, credentialsOptions);
    }
}
