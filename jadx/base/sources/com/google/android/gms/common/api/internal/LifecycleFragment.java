package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@KeepForSdk
public interface LifecycleFragment {
    @KeepForSdk
    void addCallback(@NonNull String str, @NonNull LifecycleCallback lifecycleCallback);

    @Nullable
    @KeepForSdk
    <T extends LifecycleCallback> T getCallbackOrNull(@NonNull String str, @NonNull Class<T> cls);

    @Nullable
    @KeepForSdk
    Activity getLifecycleActivity();

    @KeepForSdk
    boolean isCreated();

    @KeepForSdk
    boolean isStarted();

    @KeepForSdk
    void startActivityForResult(@NonNull Intent intent, int i);
}
