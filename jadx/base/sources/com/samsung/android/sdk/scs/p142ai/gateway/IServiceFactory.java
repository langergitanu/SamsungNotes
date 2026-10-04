package com.samsung.android.sdk.scs.p142ai.gateway;

import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface IServiceFactory<T> {
    T createService(@NonNull IBinder iBinder);
}
