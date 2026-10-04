package com.samsung.android.sdk.scs.p142ai.asr;

import android.content.SharedPreferences;
import com.samsung.android.sdk.scs.p142ai.asr.RecognitionConfig;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Stream;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7691g implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5139a;

    public /* synthetic */ C7691g(int i) {
        this.f5139a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5139a) {
            case 0:
                return RecognitionConfig.Builder.lambda$addDictationType$0((Stream) obj);
            case 1:
                return RecognitionConfig.Builder.lambda$removeDictationType$1((Stream) obj);
            case 2:
                return ((Locale) obj).toLanguageTag();
            case 3:
                return ((SharedPreferences) obj).edit();
            default:
                return Boolean.valueOf(((SharedPreferences.Editor) obj).commit());
        }
    }
}
