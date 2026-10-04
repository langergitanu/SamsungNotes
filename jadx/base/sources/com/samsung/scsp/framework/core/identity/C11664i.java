package com.samsung.scsp.framework.core.identity;

import com.google.gson.JsonArray;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.identity.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11664i implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8217a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8218b;

    public /* synthetic */ C11664i(Object obj, int i) {
        this.f8217a = i;
        this.f8218b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f8217a) {
            case 0:
                UserIdentityImpl.lambda$new$1((UserRegistration) this.f8218b, (String) obj);
                break;
            default:
                PushInfoList.lambda$toJsonArray$0((JsonArray) this.f8218b, (PushInfo) obj);
                break;
        }
    }
}
