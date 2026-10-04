package com.samsung.android.sdk.scs.p142ai.asr_6_0;

import android.content.SharedPreferences;
import com.samsung.android.scs.p140ai.sdkcommon.asr.ServerFeature;
import com.samsung.android.scs.p140ai.sdkcommon.asr.ServerType;
import com.samsung.android.sdk.scs.p142ai.asr_6_0.Repository;
import java.util.function.Function;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr_6_0.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7719g implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5173a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f5174b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f5175c;

    public /* synthetic */ C7719g(ServerType serverType, String str) {
        this.f5175c = serverType;
        this.f5174b = str;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5173a) {
            case 0:
                return Repository.SharedPrefRepository.lambda$setServerType$0((ServerType) this.f5175c, this.f5174b, (SharedPreferences.Editor) obj);
            default:
                return Repository.SharedPrefRepository.lambda$getServerType$2(this.f5174b, (ServerFeature) this.f5175c, (SharedPreferences) obj);
        }
    }

    public /* synthetic */ C7719g(String str, ServerFeature serverFeature) {
        this.f5174b = str;
        this.f5175c = serverFeature;
    }
}
