package com.samsung.android.sdk.scs.p142ai.gateway;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.feature.Feature;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class AiServiceExecutorFactory {
    protected final Context context;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public interface ServiceStubFactory<T> {
        T createStub(IBinder iBinder);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public enum ServiceType {
        AI_CORE,
        CLOUD_CORE,
        SIVS
    }

    public AiServiceExecutorFactory(Context context) {
        this.context = context.getApplicationContext();
    }

    @NonNull
    public abstract <T extends IInterface> AiServiceExecutor<T> createService(@NonNull ServiceType serviceType, @NonNull @Feature.featureName String str, @NonNull String str2, @NonNull ServiceStubFactory<T> serviceStubFactory, @NonNull String str3, @NonNull ServiceStubFactory<T> serviceStubFactory2);

    @NonNull
    public abstract String getServicePackage(@NonNull ServiceType serviceType);
}
