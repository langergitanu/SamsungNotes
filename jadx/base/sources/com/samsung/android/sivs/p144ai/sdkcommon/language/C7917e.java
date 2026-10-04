package com.samsung.android.sivs.p144ai.sdkcommon.language;

import android.os.Parcel;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionServiceForExternal;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ITranslationService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IUsageService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntConsumer;

/* JADX INFO: renamed from: com.samsung.android.sivs.ai.sdkcommon.language.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7917e implements IntConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5415a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Parcel f5416b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Map f5417c;

    public /* synthetic */ C7917e(Parcel parcel, HashMap map, int i) {
        this.f5415a = i;
        this.f5416b = parcel;
        this.f5417c = map;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        switch (this.f5415a) {
            case 0:
                ISuggestionService.Stub.lambda$onTransact$5(this.f5416b, this.f5417c, i);
                break;
            case 1:
                ISuggestionService.Stub.lambda$onTransact$6(this.f5416b, this.f5417c, i);
                break;
            case 2:
                ISuggestionService.Stub.lambda$onTransact$7(this.f5416b, this.f5417c, i);
                break;
            case 3:
                ISuggestionService.Stub.lambda$onTransact$8(this.f5416b, this.f5417c, i);
                break;
            case 4:
                ISuggestionServiceForExternal.Stub.lambda$onTransact$0(this.f5416b, this.f5417c, i);
                break;
            case 5:
                ISuggestionServiceForExternal.Stub.lambda$onTransact$1(this.f5416b, this.f5417c, i);
                break;
            case 6:
                ISuggestionServiceForExternal.Stub.lambda$onTransact$2(this.f5416b, this.f5417c, i);
                break;
            case 7:
                ISummarizationService.Stub.lambda$onTransact$0(this.f5416b, this.f5417c, i);
                break;
            case 8:
                ISummarizationService.Stub.lambda$onTransact$1(this.f5416b, this.f5417c, i);
                break;
            case 9:
                ISummarizationService.Stub.lambda$onTransact$2(this.f5416b, this.f5417c, i);
                break;
            case 10:
                ISummarizationService.Stub.lambda$onTransact$3(this.f5416b, this.f5417c, i);
                break;
            case 11:
                ISummarizationService.Stub.lambda$onTransact$4(this.f5416b, this.f5417c, i);
                break;
            case 12:
                ISummarizationService.Stub.lambda$onTransact$5(this.f5416b, this.f5417c, i);
                break;
            case 13:
                ISummarizationService.Stub.lambda$onTransact$6(this.f5416b, this.f5417c, i);
                break;
            case 14:
                ISummarizationService.Stub.lambda$onTransact$7(this.f5416b, this.f5417c, i);
                break;
            case 15:
                ISummarizationService.Stub.lambda$onTransact$8(this.f5416b, this.f5417c, i);
                break;
            case 16:
                IToneConvertService.Stub.lambda$onTransact$0(this.f5416b, this.f5417c, i);
                break;
            case 17:
                IToneConvertService.Stub.lambda$onTransact$1(this.f5416b, this.f5417c, i);
                break;
            case 18:
                IToneConvertService.Stub.lambda$onTransact$2(this.f5416b, this.f5417c, i);
                break;
            case 19:
                IToneConvertService.Stub.lambda$onTransact$3(this.f5416b, this.f5417c, i);
                break;
            case 20:
                IToneConvertService.Stub.lambda$onTransact$4(this.f5416b, this.f5417c, i);
                break;
            case 21:
                IToneConvertService.Stub.lambda$onTransact$5(this.f5416b, this.f5417c, i);
                break;
            case 22:
                ITranslationService.Stub.lambda$onTransact$0(this.f5416b, this.f5417c, i);
                break;
            case 23:
                ITranslationService.Stub.lambda$onTransact$1(this.f5416b, this.f5417c, i);
                break;
            case 24:
                ITranslationService.Stub.lambda$onTransact$2(this.f5416b, this.f5417c, i);
                break;
            case 25:
                ITranslationService.Stub.lambda$onTransact$3(this.f5416b, this.f5417c, i);
                break;
            case 26:
                ITranslationService.Stub.lambda$onTransact$4(this.f5416b, this.f5417c, i);
                break;
            case 27:
                IUsageService.Stub.lambda$onTransact$0(this.f5416b, this.f5417c, i);
                break;
            case 28:
                IWritingComposerService.Stub.lambda$onTransact$0(this.f5416b, this.f5417c, i);
                break;
            default:
                IWritingComposerService.Stub.lambda$onTransact$1(this.f5416b, this.f5417c, i);
                break;
        }
    }
}
