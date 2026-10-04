package com.samsung.android.sdk.scs.p142ai.gateway;

import android.content.Context;
import android.os.IInterface;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorFactory;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class AiServiceExecutorContainer<AppInfo> {
    private static final String TAG = "AiServiceExecutorContainer";
    protected final Context mContext;
    protected final Map<AiServiceExecutorFactory.ServiceType, AiServiceExecutor<? extends IInterface>> mServiceExecutorMap = new EnumMap(AiServiceExecutorFactory.ServiceType.class);

    public AiServiceExecutorContainer(@NonNull Context context) {
        this.mContext = context;
    }

    @NonNull
    public abstract AiServiceExecutor<? extends IInterface> createServiceExecutor(@NonNull AiServiceExecutorFactory.ServiceType serviceType);

    public Context getContext() {
        return this.mContext;
    }

    public AiServiceExecutor<? extends IInterface> getServiceExecutor(@NonNull AiServiceExecutorFactory.ServiceType serviceType) {
        if (serviceType == null) {
            throw new IllegalArgumentException("ServiceType is null.");
        }
        AiServiceExecutor<? extends IInterface> aiServiceExecutor = this.mServiceExecutorMap.get(serviceType);
        if (aiServiceExecutor != null) {
            return aiServiceExecutor;
        }
        AiServiceExecutor<? extends IInterface> aiServiceExecutorCreateServiceExecutor = createServiceExecutor(serviceType);
        this.mServiceExecutorMap.put(serviceType, aiServiceExecutorCreateServiceExecutor);
        return aiServiceExecutorCreateServiceExecutor;
    }

    @NonNull
    public abstract AiServiceExecutorFactory.ServiceType getServiceType(@NonNull AppInfo appinfo);

    public void releaseExecutor(@NonNull Map<AiServiceExecutorFactory.ServiceType, AiServiceExecutor<? extends IInterface>> map, @NonNull AiServiceExecutorFactory.ServiceType serviceType) {
        AiServiceExecutor<? extends IInterface> aiServiceExecutor = map.get(serviceType);
        if (aiServiceExecutor != null) {
            Log.m6489i(TAG, "release: " + aiServiceExecutor.isConnected());
            aiServiceExecutor.deInit();
        }
        map.remove(serviceType);
    }

    public void releaseExecutors(@NonNull Map<AiServiceExecutorFactory.ServiceType, AiServiceExecutor<? extends IInterface>> map) {
        Iterator<AiServiceExecutorFactory.ServiceType> it = map.keySet().iterator();
        while (it.hasNext()) {
            releaseExecutor(map, it.next());
        }
    }
}
