package com.microsoft.identity.client;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.microsoft.identity.client.exception.MsalException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ISingleAccountPublicClientApplication extends IPublicClientApplication {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CurrentAccountCallback {
        void onAccountChanged(@Nullable IAccount iAccount, @Nullable IAccount iAccount2);

        void onAccountLoaded(@Nullable IAccount iAccount);

        void onError(@NonNull MsalException msalException);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SignOutCallback {
        void onError(@NonNull MsalException msalException);

        void onSignOut();
    }

    @Override // com.microsoft.identity.client.IPublicClientApplication
    @WorkerThread
    IAuthenticationResult acquireTokenSilent(@NonNull AcquireTokenSilentParameters acquireTokenSilentParameters);

    @WorkerThread
    @Deprecated
    IAuthenticationResult acquireTokenSilent(@NonNull String[] strArr, @NonNull String str);

    @Override // com.microsoft.identity.client.IPublicClientApplication
    void acquireTokenSilentAsync(@NonNull AcquireTokenSilentParameters acquireTokenSilentParameters);

    @Deprecated
    void acquireTokenSilentAsync(@NonNull String[] strArr, @NonNull String str, @NonNull SilentAuthenticationCallback silentAuthenticationCallback);

    @WorkerThread
    ICurrentAccountResult getCurrentAccount();

    void getCurrentAccountAsync(CurrentAccountCallback currentAccountCallback);

    @Deprecated
    void signIn(@NonNull Activity activity, @Nullable String str, @NonNull String[] strArr, @NonNull AuthenticationCallback authenticationCallback);

    @Deprecated
    void signIn(@NonNull Activity activity, @Nullable String str, @NonNull String[] strArr, @Nullable Prompt prompt, @NonNull AuthenticationCallback authenticationCallback);

    void signIn(@NonNull SignInParameters signInParameters);

    @Deprecated
    void signInAgain(@NonNull Activity activity, @NonNull String[] strArr, @Nullable Prompt prompt, @NonNull AuthenticationCallback authenticationCallback);

    void signInAgain(@NonNull SignInParameters signInParameters);

    void signOut(@NonNull SignOutCallback signOutCallback);

    @WorkerThread
    boolean signOut();
}
