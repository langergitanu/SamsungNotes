package com.samsung.android.sdk.scs.p142ai.asr;

import android.content.SharedPreferences;
import com.samsung.android.sdk.scs.p142ai.asr.Repository;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerFeature;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerType;
import java.util.function.Function;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7694j implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5145a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f5146b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f5147c;

    public /* synthetic */ C7694j(ServerType serverType, String str) {
        this.f5147c = serverType;
        this.f5146b = str;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5145a) {
            case 0:
                return Repository.SharedPrefRepository.lambda$setServerType$0((ServerType) this.f5147c, this.f5146b, (SharedPreferences.Editor) obj);
            default:
                return Repository.SharedPrefRepository.lambda$getServerType$2(this.f5146b, (ServerFeature) this.f5147c, (SharedPreferences) obj);
        }
    }

    public /* synthetic */ C7694j(String str, ServerFeature serverFeature) {
        this.f5146b = str;
        this.f5147c = serverFeature;
    }
}
