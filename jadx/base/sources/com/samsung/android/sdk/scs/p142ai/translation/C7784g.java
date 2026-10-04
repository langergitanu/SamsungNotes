package com.samsung.android.sdk.scs.p142ai.translation;

import com.samsung.android.sivs.p144ai.sdkcommon.translation.LanguageDirection;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.translation.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7784g implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5244a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5245b;

    public /* synthetic */ C7784g(Object obj, int i) {
        this.f5244a = i;
        this.f5245b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f5244a) {
            case 0:
                return NeuralTranslator.lambda$getTargetLanguageList$8((String) this.f5245b, (LanguageDirection) obj);
            default:
                return NeuralTranslator.lambda$getAvailableLanguageDirectionStringList$9((LanguageDirectionState) this.f5245b, (Map.Entry) obj);
        }
    }
}
