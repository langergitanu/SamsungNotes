package com.samsung.android.sdk.scs.p142ai.asr_6_0;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.scs.p140ai.sdkcommon.asr.BTCLocaleInfo;
import com.samsung.android.scs.p140ai.sdkcommon.asr.LocaleInfo;
import com.samsung.android.sdk.scs.p142ai.asr_6_0.RecognitionConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Stream;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr_6_0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7715c implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5167a;

    public /* synthetic */ C7715c(int i) {
        this.f5167a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5167a) {
            case 0:
                return ExpiringData.lambda$new$0(obj);
            case 1:
                return Environment.lambda$getSupportedLocaleInfos$7((Bundle) obj);
            case 2:
                return Environment.lambda$getSupportedBTCLocaleInfosFromCP$18((Bundle) obj);
            case 3:
                return Environment.lambda$getSupportedBTCLocaleInfosFromCP$20((ArrayList) obj);
            case 4:
                return Integer.valueOf(((LocaleInfo) obj).getOrder());
            case 5:
                return Environment.createLocaleInfo((Locale) obj);
            case 6:
                return Environment.lambda$getSupportedServerLists$22((Bundle) obj);
            case 7:
                return Environment.lambda$getSupportedServerLists$23((ArrayList) obj);
            case 8:
                return Environment.lambda$getDictationTermsOfServiceUrl$13((Bundle) obj);
            case 9:
                return Environment.lambda$getSupportedLocaleInfos$8((List) obj);
            case 10:
                return Environment.getSupportedLocalesFromRes((Context) obj);
            case 11:
                return Environment.getSupportedLocalesFromCP((Context) obj);
            case 12:
                return Environment.lambda$static$0((ArrayList) obj);
            case 13:
                return Environment.lambda$static$1((ArrayList) obj);
            case 14:
                return Environment.lambda$static$2((ArrayList) obj);
            case 15:
                return Environment.lambda$static$3((String) obj);
            case 16:
                return Integer.valueOf(((BTCLocaleInfo) obj).getOrder());
            case 17:
                return Environment.lambda$getURI$14((Context) obj);
            case 18:
                return Environment.lambda$getSupportedLocalesFromCP$15((ConnectionType) obj);
            case 19:
                return Environment.lambda$getSupportedLocalesFromCP$17((Bundle) obj);
            case 20:
                return Arrays.stream((DictationType[]) obj);
            case 21:
                return RecognitionConfig.Builder.lambda$addDictationType$0((Stream) obj);
            default:
                return RecognitionConfig.Builder.lambda$removeDictationType$1((Stream) obj);
        }
    }
}
