package com.samsung.android.sivs.p144ai.sdkcommon.language;

import android.os.Parcel;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IClassificationService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ICorrectionService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IEmojiAugmentationService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntConsumer;

/* JADX INFO: renamed from: com.samsung.android.sivs.ai.sdkcommon.language.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7913a implements IntConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5405a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Parcel f5406b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Map f5407c;

    public /* synthetic */ C7913a(Parcel parcel, HashMap map, int i) {
        this.f5405a = i;
        this.f5406b = parcel;
        this.f5407c = map;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        switch (this.f5405a) {
            case 0:
                IClassificationService.Stub.lambda$onTransact$0(this.f5406b, this.f5407c, i);
                break;
            case 1:
                IClassificationService.Stub.lambda$onTransact$1(this.f5406b, this.f5407c, i);
                break;
            case 2:
                IClassificationService.Stub.lambda$onTransact$2(this.f5406b, this.f5407c, i);
                break;
            case 3:
                IClassificationService.Stub.lambda$onTransact$3(this.f5406b, this.f5407c, i);
                break;
            case 4:
                IConfigurationService.Stub.lambda$onTransact$0(this.f5406b, this.f5407c, i);
                break;
            case 5:
                IConfigurationService.Stub.lambda$onTransact$1(this.f5406b, this.f5407c, i);
                break;
            case 6:
                IConfigurationService.Stub.lambda$onTransact$2(this.f5406b, this.f5407c, i);
                break;
            case 7:
                IConfigurationService.Stub.lambda$onTransact$3(this.f5406b, this.f5407c, i);
                break;
            case 8:
                IConfigurationService.Stub.lambda$onTransact$4(this.f5406b, this.f5407c, i);
                break;
            case 9:
                IConfigurationService.Stub.lambda$onTransact$5(this.f5406b, this.f5407c, i);
                break;
            case 10:
                IConfigurationService.Stub.lambda$onTransact$6(this.f5406b, this.f5407c, i);
                break;
            case 11:
                IConfigurationService.Stub.lambda$onTransact$7(this.f5406b, this.f5407c, i);
                break;
            case 12:
                ICorrectionService.Stub.lambda$onTransact$0(this.f5406b, this.f5407c, i);
                break;
            case 13:
                ICorrectionService.Stub.lambda$onTransact$1(this.f5406b, this.f5407c, i);
                break;
            case 14:
                ICorrectionService.Stub.lambda$onTransact$2(this.f5406b, this.f5407c, i);
                break;
            case 15:
                ICorrectionService.Stub.lambda$onTransact$3(this.f5406b, this.f5407c, i);
                break;
            case 16:
                IEmojiAugmentationService.Stub.lambda$onTransact$0(this.f5406b, this.f5407c, i);
                break;
            case 17:
                IEmojiAugmentationService.Stub.lambda$onTransact$1(this.f5406b, this.f5407c, i);
                break;
            case 18:
                IEmojiAugmentationService.Stub.lambda$onTransact$2(this.f5406b, this.f5407c, i);
                break;
            case 19:
                IEmojiAugmentationService.Stub.lambda$onTransact$3(this.f5406b, this.f5407c, i);
                break;
            case 20:
                IExtractionService.Stub.lambda$onTransact$0(this.f5406b, this.f5407c, i);
                break;
            case 21:
                IExtractionService.Stub.lambda$onTransact$1(this.f5406b, this.f5407c, i);
                break;
            case 22:
                IExtractionService.Stub.lambda$onTransact$2(this.f5406b, this.f5407c, i);
                break;
            case 23:
                IExtractionService.Stub.lambda$onTransact$3(this.f5406b, this.f5407c, i);
                break;
            case 24:
                IExtractionService.Stub.lambda$onTransact$4(this.f5406b, this.f5407c, i);
                break;
            case 25:
                IExtractionService.Stub.lambda$onTransact$5(this.f5406b, this.f5407c, i);
                break;
            case 26:
                IExtractionService.Stub.lambda$onTransact$6(this.f5406b, this.f5407c, i);
                break;
            case 27:
                IExtractionService.Stub.lambda$onTransact$7(this.f5406b, this.f5407c, i);
                break;
            case 28:
                IExtractionService.Stub.lambda$onTransact$8(this.f5406b, this.f5407c, i);
                break;
            default:
                IExtractionService.Stub.lambda$onTransact$9(this.f5406b, this.f5407c, i);
                break;
        }
    }
}
