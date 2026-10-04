package com.samsung.android.sdk.scs.p142ai.asr_6_0;

import com.samsung.android.scs.p140ai.sdkcommon.asr.BTCLocaleInfo;
import com.samsung.android.scs.p140ai.sdkcommon.asr.LocaleInfo;
import com.samsung.android.scs.p140ai.sdkcommon.asr.ServerInfo;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr_6_0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7713a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5165a;

    public /* synthetic */ C7713a(int i) {
        this.f5165a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f5165a) {
            case 0:
                return Objects.nonNull((LocaleInfo) obj);
            case 1:
                return Objects.nonNull((BTCLocaleInfo) obj);
            case 2:
                return Environment.lambda$getSupportedBTCLocaleInfosFromCP$19((BTCLocaleInfo) obj);
            default:
                return Objects.nonNull((ServerInfo) obj);
        }
    }
}
