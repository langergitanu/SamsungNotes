package com.samsung.android.sdk.scs.p142ai.asr;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.BTCLocaleInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.LocaleInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7690f implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5138a;

    public /* synthetic */ C7690f(int i) {
        this.f5138a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5138a) {
            case 0:
                return ExpiringData.lambda$new$0(obj);
            case 1:
                return Environment.lambda$getSupportedBTCLocaleInfosFromCP$22((Bundle) obj);
            case 2:
                return Environment.lambda$isBilingualAsrSupported$15((Bundle) obj);
            case 3:
                return Environment.lambda$getURI$17((Context) obj);
            case 4:
                return Integer.valueOf(((LocaleInfo) obj).getOrder());
            case 5:
                return Environment.lambda$getSupportedLocalesFromCP$19((ConnectionType) obj);
            case 6:
                return Environment.lambda$getSupportedLocalesFromCP$21((Bundle) obj);
            case 7:
                return ((ArrayList) obj).stream();
            case 8:
                return Locale.forLanguageTag((String) obj);
            case 9:
                return Environment.lambda$getAvailableLocalesForAudioToTranslation$14((Bundle) obj);
            case 10:
                return Environment.lambda$getSupportedBTCLocaleInfosFromCP$24((ArrayList) obj);
            case 11:
                return Environment.createLocaleInfo((Locale) obj);
            case 12:
                return Environment.lambda$getSupportedServerLists$26((Bundle) obj);
            case 13:
                return Environment.lambda$getSupportedServerLists$27((ArrayList) obj);
            case 14:
                return Environment.lambda$getSupportedLocaleInfos$7((Bundle) obj);
            case 15:
                return Environment.lambda$getSupportedLocaleInfos$8((List) obj);
            case 16:
                return Environment.lambda$getDictationTermsOfServiceUrl$13((Bundle) obj);
            case 17:
                return Uri.parse((String) obj);
            case 18:
                return Environment.lambda$isExtModeCallSupported$16((Bundle) obj);
            case 19:
                return Integer.valueOf(((BTCLocaleInfo) obj).getOrder());
            case 20:
                return Environment.lambda$getConfigURI$18((Context) obj);
            case 21:
                return ((Context) obj).getContentResolver();
            case 22:
                return Environment.getSupportedLocalesFromRes((Context) obj);
            case 23:
                return Environment.getSupportedLocalesFromCP((Context) obj);
            case 24:
                return Environment.lambda$static$0((List) obj);
            case 25:
                return Environment.lambda$static$1((List) obj);
            case 26:
                return Environment.lambda$static$2((List) obj);
            case 27:
                return Environment.lambda$static$3((String) obj);
            case 28:
                return ((Supplier) obj).get();
            default:
                return Arrays.stream((DictationType[]) obj);
        }
    }
}
