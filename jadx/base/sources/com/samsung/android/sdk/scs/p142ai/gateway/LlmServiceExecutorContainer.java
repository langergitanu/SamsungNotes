package com.samsung.android.sdk.scs.p142ai.gateway;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorFactory;
import com.samsung.android.sdk.scs.p142ai.gateway.executor.VoidContainer;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class LlmServiceExecutorContainer extends AiServiceExecutorContainer<AppInfo> implements VoidContainer {

    /* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.gateway.LlmServiceExecutorContainer$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C77331 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$sdk$scs$ai$language$AppInfo$RequestType */
        static final /* synthetic */ int[] f5186x4e450857;

        static {
            int[] iArr = new int[AppInfo.RequestType.values().length];
            f5186x4e450857 = iArr;
            try {
                iArr[AppInfo.RequestType.ONDEVICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public LlmServiceExecutorContainer(@NonNull Context context) {
        super(context);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.executor.VoidContainer
    public void release() {
        releaseExecutors(this.mServiceExecutorMap);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorContainer
    @NonNull
    public AiServiceExecutorFactory.ServiceType getServiceType(@NonNull AppInfo appInfo) {
        return appInfo == null ? AiServiceExecutorFactory.ServiceType.SIVS : C77331.f5186x4e450857[appInfo.getRequestType().ordinal()] != 1 ? AiServiceExecutorFactory.ServiceType.SIVS : AiServiceExecutorFactory.ServiceType.AI_CORE;
    }
}
