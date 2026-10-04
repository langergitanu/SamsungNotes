package com.samsung.android.sdk.scs.p142ai.gateway;

import android.content.Context;
import android.os.IInterface;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.utils.BaseConstants;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorFactory;
import java.util.Objects;
import p092W3.C0332a;
import p099Y2.C0347a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class LvmServiceExecutorFactory extends AiServiceExecutorFactory implements ILvmServiceExecutorFactory {

    /* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.gateway.LvmServiceExecutorFactory$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C77341 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$sdk$scs$ai$gateway$AiServiceExecutorFactory$ServiceType */
        static final /* synthetic */ int[] f5187x32fda04;

        static {
            int[] iArr = new int[AiServiceExecutorFactory.ServiceType.values().length];
            f5187x32fda04 = iArr;
            try {
                iArr[AiServiceExecutorFactory.ServiceType.AI_CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public LvmServiceExecutorFactory(Context context) {
        super(context);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.ILvmServiceExecutorFactory
    public AiServiceExecutor<? extends IInterface> createImageEditor(@NonNull AiServiceExecutorFactory.ServiceType serviceType, @NonNull String str) {
        return createService(serviceType, str, BaseConstants.SERVICE_ACTION.ACTION_ON_DEVICE_SERVICE, new C0347a(28), BaseConstants.SERVICE_ACTION.ACTION_IMAGE_EDITOR_SERVICE, new C0347a(29));
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorFactory
    @NonNull
    public <T extends IInterface> AiServiceExecutor<T> createService(@NonNull AiServiceExecutorFactory.ServiceType serviceType, @NonNull String str, @NonNull String str2, @NonNull AiServiceExecutorFactory.ServiceStubFactory<T> serviceStubFactory, @NonNull String str3, @NonNull AiServiceExecutorFactory.ServiceStubFactory<T> serviceStubFactory2) {
        String servicePackage = getServicePackage(serviceType);
        if (AiServiceExecutorFactory.ServiceType.AI_CORE.equals(serviceType)) {
            Context context = this.context;
            Objects.requireNonNull(serviceStubFactory);
            return new AiServiceExecutor<>(context, serviceType, new C0332a(serviceStubFactory, 5), str2, servicePackage);
        }
        Context context2 = this.context;
        Objects.requireNonNull(serviceStubFactory2);
        return new AiServiceExecutor<>(context2, serviceType, new C0332a(serviceStubFactory2, 5), str3, servicePackage);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorFactory
    @NonNull
    public String getServicePackage(@NonNull AiServiceExecutorFactory.ServiceType serviceType) {
        return C77341.f5187x32fda04[serviceType.ordinal()] != 1 ? BaseConstants.PACKAGE_INFO.PACKAGE_VISUAL_CLOUD_CORE_SERVICES : BaseConstants.PACKAGE_INFO.PACKAGE_AICORE_SERVICES;
    }
}
