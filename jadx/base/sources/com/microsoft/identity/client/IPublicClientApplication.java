package com.microsoft.identity.client;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.microsoft.identity.client.claims.ClaimsRequest;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.common.java.p132ui.PreferredAuthMethod;
import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IPublicClientApplication {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ApplicationCreatedListener {
        void onCreated(IPublicClientApplication iPublicClientApplication);

        void onError(MsalException msalException);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DeviceCodeFlowCallback {
        void onError(@NonNull MsalException msalException);

        void onTokenReceived(@NonNull IAuthenticationResult iAuthenticationResult);

        void onUserCodeReceived(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull Date date);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IMultipleAccountApplicationCreatedListener {
        void onCreated(IMultipleAccountPublicClientApplication iMultipleAccountPublicClientApplication);

        void onError(MsalException msalException);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISingleAccountApplicationCreatedListener {
        void onCreated(ISingleAccountPublicClientApplication iSingleAccountPublicClientApplication);

        void onError(MsalException msalException);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LoadAccountsCallback extends TaskCompletedCallbackWithError<List<IAccount>, MsalException> {
        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
        void onError(MsalException msalException);

        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
        void onTaskCompleted(List<IAccount> list);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SignedHttpRequestRequestCallback extends TaskCompletedCallbackWithError<String, MsalException> {
        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
        void onError(MsalException msalException);

        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
        void onTaskCompleted(String str);
    }

    @Deprecated
    void acquireToken(@NonNull Activity activity, @NonNull String[] strArr, @NonNull AuthenticationCallback authenticationCallback);

    void acquireToken(@NonNull AcquireTokenParameters acquireTokenParameters);

    @WorkerThread
    IAuthenticationResult acquireTokenSilent(@NonNull AcquireTokenSilentParameters acquireTokenSilentParameters);

    void acquireTokenSilentAsync(@NonNull AcquireTokenSilentParameters acquireTokenSilentParameters);

    void acquireTokenWithDeviceCode(@NonNull List<String> list, @NonNull DeviceCodeFlowCallback deviceCodeFlowCallback);

    void acquireTokenWithDeviceCode(@NonNull List<String> list, @NonNull DeviceCodeFlowCallback deviceCodeFlowCallback, @Nullable ClaimsRequest claimsRequest, @Nullable UUID uuid);

    @Deprecated
    void acquireTokenWithDeviceCode(@NonNull String[] strArr, @NonNull DeviceCodeFlowCallback deviceCodeFlowCallback);

    @NonNull
    String generateSignedHttpRequest(@NonNull IAccount iAccount, @NonNull PoPAuthenticationScheme poPAuthenticationScheme);

    void generateSignedHttpRequest(@NonNull IAccount iAccount, @NonNull PoPAuthenticationScheme poPAuthenticationScheme, @NonNull SignedHttpRequestRequestCallback signedHttpRequestRequestCallback);

    PublicClientApplicationConfiguration getConfiguration();

    PreferredAuthMethod getPreferredAuthConfiguration();

    boolean isSharedDevice();
}
