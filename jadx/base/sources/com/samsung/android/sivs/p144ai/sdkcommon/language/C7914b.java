package com.samsung.android.sivs.p144ai.sdkcommon.language;

import android.os.Parcel;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IClassificationService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ICorrectionService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IEmojiAugmentationService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: com.samsung.android.sivs.ai.sdkcommon.language.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7914b implements BiConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5408a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Parcel f5409b;

    public /* synthetic */ C7914b(Parcel parcel, int i) {
        this.f5408a = i;
        this.f5409b = parcel;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        switch (this.f5408a) {
            case 0:
                IClassificationService.Stub.Proxy.lambda$classify2$1(this.f5409b, str, str2);
                break;
            case 1:
                IClassificationService.Stub.Proxy.lambda$classify$0(this.f5409b, str, str2);
                break;
            case 2:
                IClassificationService.Stub.Proxy.lambda$classify3$2(this.f5409b, str, str2);
                break;
            case 3:
                IClassificationService.Stub.Proxy.lambda$classify3$3(this.f5409b, str, str2);
                break;
            case 4:
                IConfigurationService.Stub.Proxy.lambda$getOndeviceSafetyCheck$3(this.f5409b, str, str2);
                break;
            case 5:
                IConfigurationService.Stub.Proxy.lambda$getModelInfo$4(this.f5409b, str, str2);
                break;
            case 6:
                IConfigurationService.Stub.Proxy.lambda$getModelInfo$5(this.f5409b, str, str2);
                break;
            case 7:
                IConfigurationService.Stub.Proxy.lambda$getLlmSupportLanguage$2(this.f5409b, str, str2);
                break;
            case 8:
                IConfigurationService.Stub.Proxy.lambda$getTranslateSupportLanguage$0(this.f5409b, str, str2);
                break;
            case 9:
                IConfigurationService.Stub.Proxy.lambda$getConfig$1(this.f5409b, str, str2);
                break;
            case 10:
                IConfigurationService.Stub.Proxy.lambda$prewarmLlm$6(this.f5409b, str, str2);
                break;
            case 11:
                IConfigurationService.Stub.Proxy.lambda$prewarmLlm$7(this.f5409b, str, str2);
                break;
            case 12:
                ICorrectionService.Stub.Proxy.lambda$correctWithHeader2$1(this.f5409b, str, str2);
                break;
            case 13:
                ICorrectionService.Stub.Proxy.lambda$correctWithHeader$0(this.f5409b, str, str2);
                break;
            case 14:
                ICorrectionService.Stub.Proxy.lambda$correctWithHeader3$2(this.f5409b, str, str2);
                break;
            case 15:
                ICorrectionService.Stub.Proxy.lambda$correctWithHeader3$3(this.f5409b, str, str2);
                break;
            case 16:
                IEmojiAugmentationService.Stub.Proxy.lambda$augmentWithHeader$0(this.f5409b, str, str2);
                break;
            case 17:
                IEmojiAugmentationService.Stub.Proxy.lambda$augmentWithHeader2$1(this.f5409b, str, str2);
                break;
            case 18:
                IEmojiAugmentationService.Stub.Proxy.lambda$augmentWithHeader3$2(this.f5409b, str, str2);
                break;
            case 19:
                IEmojiAugmentationService.Stub.Proxy.lambda$augmentWithHeader3$3(this.f5409b, str, str2);
                break;
            case 20:
                IExtractionService.Stub.Proxy.lambda$extractor$0(this.f5409b, str, str2);
                break;
            case 21:
                IExtractionService.Stub.Proxy.lambda$extractor3$2(this.f5409b, str, str2);
                break;
            case 22:
                IExtractionService.Stub.Proxy.lambda$extractor3$3(this.f5409b, str, str2);
                break;
            case 23:
                IExtractionService.Stub.Proxy.lambda$extractor2$1(this.f5409b, str, str2);
                break;
            case 24:
                IExtractionService.Stub.Proxy.lambda$extractorMultiModalOnDeviceOnly$4(this.f5409b, str, str2);
                break;
            case 25:
                IExtractionService.Stub.Proxy.lambda$extractorMultiModalOnDeviceOnly$5(this.f5409b, str, str2);
                break;
            case 26:
                IExtractionService.Stub.Proxy.lambda$extractorMultiModal2$8(this.f5409b, str, str2);
                break;
            case 27:
                IExtractionService.Stub.Proxy.lambda$extractorMultiModal2$9(this.f5409b, str, str2);
                break;
            case 28:
                IExtractionService.Stub.Proxy.lambda$extractorMultiModal$6(this.f5409b, str, str2);
                break;
            default:
                IExtractionService.Stub.Proxy.lambda$extractorMultiModal$7(this.f5409b, str, str2);
                break;
        }
    }
}
