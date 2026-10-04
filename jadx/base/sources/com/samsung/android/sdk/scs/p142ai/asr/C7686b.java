package com.samsung.android.sdk.scs.p142ai.asr;

import com.samsung.android.sivs.p144ai.sdkcommon.asr.BTCLocaleInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.LocaleInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerInfo;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7686b implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5128a;

    public /* synthetic */ C7686b(int i) {
        this.f5128a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f5128a) {
            case 0:
                return Objects.nonNull((ArrayList) obj);
            case 1:
                return Objects.nonNull((LocaleInfo) obj);
            case 2:
                return Objects.nonNull((BTCLocaleInfo) obj);
            case 3:
                return Environment.lambda$getSupportedBTCLocaleInfosFromCP$23((BTCLocaleInfo) obj);
            default:
                return Objects.nonNull((ServerInfo) obj);
        }
    }
}
