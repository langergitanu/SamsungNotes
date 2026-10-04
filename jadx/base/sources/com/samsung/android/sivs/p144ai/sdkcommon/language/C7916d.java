package com.samsung.android.sivs.p144ai.sdkcommon.language;

import android.os.Parcel;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IFormatConversionService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IGenericService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.INotesOrganizationService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISmartCaptureService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISmartCoverService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISmartReplyService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: com.samsung.android.sivs.ai.sdkcommon.language.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7916d implements BiConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5413a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Parcel f5414b;

    public /* synthetic */ C7916d(Parcel parcel, int i) {
        this.f5413a = i;
        this.f5414b = parcel;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        switch (this.f5413a) {
            case 0:
                IFormatConversionService.Stub.Proxy.lambda$convert$0(this.f5414b, str, str2);
                break;
            case 1:
                IFormatConversionService.Stub.Proxy.lambda$convert$1(this.f5414b, str, str2);
                break;
            case 2:
                IGenericService.Stub.Proxy.lambda$genericWithHeader3$2(this.f5414b, str, str2);
                break;
            case 3:
                IGenericService.Stub.Proxy.lambda$genericWithHeader3$3(this.f5414b, str, str2);
                break;
            case 4:
                IGenericService.Stub.Proxy.lambda$genericWithHeader$0(this.f5414b, str, str2);
                break;
            case 5:
                IGenericService.Stub.Proxy.lambda$genericWithHeader2$1(this.f5414b, str, str2);
                break;
            case 6:
                INotesOrganizationService.Stub.Proxy.lambda$organizeWithHeader$0(this.f5414b, str, str2);
                break;
            case 7:
                INotesOrganizationService.Stub.Proxy.lambda$organizeWithType$1(this.f5414b, str, str2);
                break;
            case 8:
                INotesOrganizationService.Stub.Proxy.lambda$organizeWithType3$3(this.f5414b, str, str2);
                break;
            case 9:
                INotesOrganizationService.Stub.Proxy.lambda$organizeWithType3$4(this.f5414b, str, str2);
                break;
            case 10:
                INotesOrganizationService.Stub.Proxy.lambda$organizeWithType2$2(this.f5414b, str, str2);
                break;
            case 11:
                ISmartCaptureService.Stub.Proxy.lambda$captureWithHeader$0(this.f5414b, str, str2);
                break;
            case 12:
                ISmartCoverService.Stub.Proxy.lambda$coverWithHeader$0(this.f5414b, str, str2);
                break;
            case 13:
                ISmartCoverService.Stub.Proxy.lambda$coverWithHeader3$2(this.f5414b, str, str2);
                break;
            case 14:
                ISmartCoverService.Stub.Proxy.lambda$coverWithHeader3$3(this.f5414b, str, str2);
                break;
            case 15:
                ISmartCoverService.Stub.Proxy.lambda$coverWithHeader2$1(this.f5414b, str, str2);
                break;
            case 16:
                ISmartReplyService.Stub.Proxy.lambda$replyWithCategory$5(this.f5414b, str, str2);
                break;
            case 17:
                ISmartReplyService.Stub.Proxy.lambda$replyWithCategory$6(this.f5414b, str, str2);
                break;
            case 18:
                ISmartReplyService.Stub.Proxy.lambda$replyWithHeader$0(this.f5414b, str, str2);
                break;
            case 19:
                ISmartReplyService.Stub.Proxy.lambda$replyWithHeader2$1(this.f5414b, str, str2);
                break;
            case 20:
                ISmartReplyService.Stub.Proxy.lambda$identifyLanguage$4(this.f5414b, str, str2);
                break;
            case 21:
                ISmartReplyService.Stub.Proxy.lambda$replyWithHeader3$2(this.f5414b, str, str2);
                break;
            case 22:
                ISmartReplyService.Stub.Proxy.lambda$replyWithHeader3$3(this.f5414b, str, str2);
                break;
            case 23:
                ISuggestionService.Stub.Proxy.lambda$suggestionWithHeaderOnDevice$3(this.f5414b, str, str2);
                break;
            case 24:
                ISuggestionService.Stub.Proxy.lambda$reportGeneration$10(this.f5414b, str, str2);
                break;
            case 25:
                ISuggestionService.Stub.Proxy.lambda$suggestionWithHeaderOnDevice$4(this.f5414b, str, str2);
                break;
            case 26:
                ISuggestionService.Stub.Proxy.lambda$suggestion$0(this.f5414b, str, str2);
                break;
            case 27:
                ISuggestionService.Stub.Proxy.lambda$suggestionWithHeader$1(this.f5414b, str, str2);
                break;
            case 28:
                ISuggestionService.Stub.Proxy.lambda$suggestionWithHeader$2(this.f5414b, str, str2);
                break;
            default:
                ISuggestionService.Stub.Proxy.lambda$suggestionMultiModal$7(this.f5414b, str, str2);
                break;
        }
    }
}
