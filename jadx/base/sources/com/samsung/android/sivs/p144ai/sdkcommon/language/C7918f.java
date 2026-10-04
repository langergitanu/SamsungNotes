package com.samsung.android.sivs.p144ai.sdkcommon.language;

import android.os.Parcel;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionServiceForExternal;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ITranslationService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IUsageService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: com.samsung.android.sivs.ai.sdkcommon.language.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7918f implements BiConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5418a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Parcel f5419b;

    public /* synthetic */ C7918f(Parcel parcel, int i) {
        this.f5418a = i;
        this.f5419b = parcel;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        switch (this.f5418a) {
            case 0:
                ISuggestionService.Stub.Proxy.lambda$suggestionMultiModal$8(this.f5419b, str, str2);
                break;
            case 1:
                ISuggestionService.Stub.Proxy.lambda$suggestionWithCategory$5(this.f5419b, str, str2);
                break;
            case 2:
                ISuggestionService.Stub.Proxy.lambda$suggestionWithCategory$6(this.f5419b, str, str2);
                break;
            case 3:
                ISuggestionService.Stub.Proxy.lambda$reportGeneration$9(this.f5419b, str, str2);
                break;
            case 4:
                ISuggestionServiceForExternal.Stub.Proxy.lambda$suggestionWithHeaderForExternal$1(this.f5419b, str, str2);
                break;
            case 5:
                ISuggestionServiceForExternal.Stub.Proxy.lambda$suggestionWithHeaderForExternal$2(this.f5419b, str, str2);
                break;
            case 6:
                ISuggestionServiceForExternal.Stub.Proxy.lambda$suggestionForExternal$0(this.f5419b, str, str2);
                break;
            case 7:
                ISummarizationService.Stub.Proxy.lambda$summarizeOnDevice$4(this.f5419b, str, str2);
                break;
            case 8:
                ISummarizationService.Stub.Proxy.lambda$summarizeWithHeader3$2(this.f5419b, str, str2);
                break;
            case 9:
                ISummarizationService.Stub.Proxy.lambda$summarizeWithHeader3$3(this.f5419b, str, str2);
                break;
            case 10:
                ISummarizationService.Stub.Proxy.lambda$getTokenCount$5(this.f5419b, str, str2);
                break;
            case 11:
                ISummarizationService.Stub.Proxy.lambda$getTokenCount$6(this.f5419b, str, str2);
                break;
            case 12:
                ISummarizationService.Stub.Proxy.lambda$summarizeWithHeader$0(this.f5419b, str, str2);
                break;
            case 13:
                ISummarizationService.Stub.Proxy.lambda$summarizeWithHeader2$1(this.f5419b, str, str2);
                break;
            case 14:
                ISummarizationService.Stub.Proxy.lambda$summarizeOnDeviceWithExtraPrompt$7(this.f5419b, str, str2);
                break;
            case 15:
                ISummarizationService.Stub.Proxy.lambda$summarizeOnDeviceWithExtraPrompt$8(this.f5419b, str, str2);
                break;
            case 16:
                IToneConvertService.Stub.Proxy.lambda$toneConverterWithHeader2$1(this.f5419b, str, str2);
                break;
            case 17:
                IToneConvertService.Stub.Proxy.lambda$toneConverterWithHeader3$2(this.f5419b, str, str2);
                break;
            case 18:
                IToneConvertService.Stub.Proxy.lambda$toneConverterWithHeader3$3(this.f5419b, str, str2);
                break;
            case 19:
                IToneConvertService.Stub.Proxy.lambda$toneConvertDynamicStyle$4(this.f5419b, str, str2);
                break;
            case 20:
                IToneConvertService.Stub.Proxy.lambda$toneConvertDynamicStyle$5(this.f5419b, str, str2);
                break;
            case 21:
                IToneConvertService.Stub.Proxy.lambda$toneConverterWithHeader$0(this.f5419b, str, str2);
                break;
            case 22:
                ITranslationService.Stub.Proxy.lambda$translateWithHeader2$1(this.f5419b, str, str2);
                break;
            case 23:
                ITranslationService.Stub.Proxy.lambda$translateWithHeader2$2(this.f5419b, str, str2);
                break;
            case 24:
                ITranslationService.Stub.Proxy.lambda$interpret$3(this.f5419b, str, str2);
                break;
            case 25:
                ITranslationService.Stub.Proxy.lambda$interpret$4(this.f5419b, str, str2);
                break;
            case 26:
                ITranslationService.Stub.Proxy.lambda$translateWithHeader$0(this.f5419b, str, str2);
                break;
            case 27:
                IUsageService.Stub.Proxy.lambda$usageWithHeader$0(this.f5419b, str, str2);
                break;
            case 28:
                IWritingComposerService.Stub.Proxy.lambda$composeDynamicStyle$2(this.f5419b, str, str2);
                break;
            default:
                IWritingComposerService.Stub.Proxy.lambda$composeDynamicStyle$3(this.f5419b, str, str2);
                break;
        }
    }
}
