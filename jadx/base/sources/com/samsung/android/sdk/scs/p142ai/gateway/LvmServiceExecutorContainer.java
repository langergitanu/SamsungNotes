package com.samsung.android.sdk.scs.p142ai.gateway;

import android.content.Context;
import android.os.IInterface;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorFactory;
import com.samsung.android.sdk.scs.p142ai.gateway.executor.TemplateContainer;
import com.samsung.android.sdk.scs.p142ai.visual.RequestType;
import com.samsung.android.sdk.scs.p142ai.visual.VisualAppInfo;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class LvmServiceExecutorContainer extends AiServiceExecutorContainer<VisualAppInfo> implements TemplateContainer<Boolean> {
    protected final Map<AiServiceExecutorFactory.ServiceType, AiServiceExecutor<? extends IInterface>> mCancelServiceExecutorMap;

    public LvmServiceExecutorContainer(@NonNull Context context) {
        super(context);
        this.mCancelServiceExecutorMap = new EnumMap(AiServiceExecutorFactory.ServiceType.class);
    }

    @NonNull
    public abstract AiServiceExecutor<? extends IInterface> createCancelServiceExecutor(@NonNull AiServiceExecutorFactory.ServiceType serviceType);

    public AiServiceExecutor<? extends IInterface> getCancelServiceExecutor(@NonNull AiServiceExecutorFactory.ServiceType serviceType) {
        if (serviceType == null) {
            throw new IllegalArgumentException("ServiceType is null.");
        }
        AiServiceExecutor<? extends IInterface> aiServiceExecutor = this.mCancelServiceExecutorMap.get(serviceType);
        if (aiServiceExecutor != null) {
            return aiServiceExecutor;
        }
        AiServiceExecutor<? extends IInterface> aiServiceExecutorCreateCancelServiceExecutor = createCancelServiceExecutor(serviceType);
        this.mCancelServiceExecutorMap.put(serviceType, aiServiceExecutorCreateCancelServiceExecutor);
        return aiServiceExecutorCreateCancelServiceExecutor;
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.executor.TemplateContainer
    public Task<Boolean> release() {
        releaseExecutors(this.mServiceExecutorMap);
        releaseExecutors(this.mCancelServiceExecutorMap);
        return null;
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorContainer
    @NonNull
    public AiServiceExecutorFactory.ServiceType getServiceType(@NonNull VisualAppInfo visualAppInfo) {
        return AiServiceExecutorFactory.ServiceType.CLOUD_CORE;
    }

    @NonNull
    public AiServiceExecutorFactory.ServiceType getServiceType(@NonNull RequestType requestType) {
        if (RequestType.ONDEVICE.equals(requestType)) {
            return AiServiceExecutorFactory.ServiceType.AI_CORE;
        }
        return AiServiceExecutorFactory.ServiceType.CLOUD_CORE;
    }
}
