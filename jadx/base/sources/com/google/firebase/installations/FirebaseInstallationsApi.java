package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface FirebaseInstallationsApi {
    @NonNull
    Task<Void> delete();

    @NonNull
    Task<String> getId();

    @NonNull
    Task<InstallationTokenResult> getToken(boolean z);

    @DeferredApi
    FidListenerHandle registerFidListener(@NonNull FidListener fidListener);
}
