package com.samsung.android.sdk.scs.p142ai.asr;

import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerFeature;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerType;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7689e implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5136a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5137b;

    public /* synthetic */ C7689e(Object obj, int i) {
        this.f5136a = i;
        this.f5137b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f5136a) {
            case 0:
                return ((ExpiringData) this.f5137b).lambda$getOrCompute$2(obj);
            case 1:
                return Environment.lambda$getCurrentServerInfo$10((ServerType) this.f5137b, (ServerInfo) obj);
            default:
                return Environment.lambda$getSupportedServerInfos$12((ServerFeature) this.f5137b, (ServerInfo) obj);
        }
    }
}
