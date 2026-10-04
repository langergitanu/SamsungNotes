package com.samsung.android.sdk.scs.p142ai.asr;

import android.content.SharedPreferences;
import com.samsung.android.sdk.scs.p142ai.asr.Repository;
import com.samsung.android.sdk.scs.p142ai.asr_6_0.Repository;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerFeature;
import java.util.function.Function;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7693i implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5141a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SharedPreferences f5142b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f5143c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Enum f5144d;

    public /* synthetic */ C7693i(Enum r12, SharedPreferences sharedPreferences, String str, int i) {
        this.f5141a = i;
        this.f5144d = r12;
        this.f5142b = sharedPreferences;
        this.f5143c = str;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5141a) {
            case 0:
                return Repository.SharedPrefRepository.lambda$getServerType$1((ServerFeature) this.f5144d, this.f5142b, this.f5143c, (String) obj);
            default:
                return Repository.SharedPrefRepository.lambda$getServerType$1((com.samsung.android.scs.p140ai.sdkcommon.asr.ServerFeature) this.f5144d, this.f5142b, this.f5143c, (String) obj);
        }
    }
}
