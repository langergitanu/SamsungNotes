package com.microsoft.identity.client;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IMultipleAccountPublicClientApplication extends IPublicClientApplication {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface GetAccountCallback extends TaskCompletedCallbackWithError<IAccount, MsalException> {
        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
        void onError(MsalException msalException);

        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
        void onTaskCompleted(IAccount iAccount);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface RemoveAccountCallback {
        void onError(@NonNull MsalException msalException);

        void onRemoved();
    }

    @Deprecated
    void acquireToken(@NonNull Activity activity, @NonNull String[] strArr, @Nullable String str, @NonNull AuthenticationCallback authenticationCallback);

    @Override // com.microsoft.identity.client.IPublicClientApplication
    void acquireToken(@NonNull AcquireTokenParameters acquireTokenParameters);

    @Override // com.microsoft.identity.client.IPublicClientApplication
    @WorkerThread
    IAuthenticationResult acquireTokenSilent(@NonNull AcquireTokenSilentParameters acquireTokenSilentParameters);

    @WorkerThread
    @Deprecated
    IAuthenticationResult acquireTokenSilent(@NonNull String[] strArr, @NonNull IAccount iAccount, @NonNull String str);

    @Override // com.microsoft.identity.client.IPublicClientApplication
    void acquireTokenSilentAsync(@NonNull AcquireTokenSilentParameters acquireTokenSilentParameters);

    @Deprecated
    void acquireTokenSilentAsync(@NonNull String[] strArr, @NonNull IAccount iAccount, @NonNull String str, @NonNull SilentAuthenticationCallback silentAuthenticationCallback);

    @WorkerThread
    IAccount getAccount(@NonNull String str);

    void getAccount(@NonNull String str, @NonNull GetAccountCallback getAccountCallback);

    @WorkerThread
    List<IAccount> getAccounts();

    void getAccounts(@NonNull IPublicClientApplication.LoadAccountsCallback loadAccountsCallback);

    void removeAccount(@Nullable IAccount iAccount, @NonNull RemoveAccountCallback removeAccountCallback);

    @WorkerThread
    boolean removeAccount(@Nullable IAccount iAccount);
}
