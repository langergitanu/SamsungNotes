package com.samsung.scsp.framework.core.identity;

import com.google.gson.JsonObject;
import com.samsung.scsp.error.FaultBarrier;
import java.util.Map;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.identity.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11656a implements FaultBarrier.ThrowableSupplier, FaultBarrier.ThrowableRunnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8198a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8199b;

    public /* synthetic */ C11656a(Object obj, int i) {
        this.f8198a = i;
        this.f8199b = obj;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        switch (this.f8198a) {
            case 0:
                return ((AbstractIdentityImpl) this.f8199b).lambda$isNewPdidCreated$0();
            case 1:
            default:
                return ((DeviceId) this.f8199b).getSsdid();
            case 2:
                return ((AbstractToken) this.f8199b).getTokenFromPreference();
            case 3:
                return ((DeviceIdentityImpl) this.f8199b).getToken();
            case 4:
                return UserIdentityImpl.lambda$checkUserId$3((AccountInfoSupplier) this.f8199b);
            case 5:
                return UserRegisterApiImpl.lambda$saveRequestHeader$2((Map) this.f8199b);
        }
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() {
        switch (this.f8198a) {
            case 1:
                AbstractRegisterApi.lambda$makeDevicePayload$4((JsonObject) this.f8199b);
                break;
            default:
                ((ScspDeviceIdentity) this.f8199b).lambda$onRegistrationRequired$0();
                break;
        }
    }
}
