package com.samsung.android.sivs.p144ai.sdkcommon.language;

import android.os.Parcel;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IFormatConversionService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IGenericService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.INotesOrganizationService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISmartCaptureService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISmartCoverService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISmartReplyService;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntConsumer;

/* JADX INFO: renamed from: com.samsung.android.sivs.ai.sdkcommon.language.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7915c implements IntConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5410a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Parcel f5411b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Map f5412c;

    public /* synthetic */ C7915c(Parcel parcel, HashMap map, int i) {
        this.f5410a = i;
        this.f5411b = parcel;
        this.f5412c = map;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        switch (this.f5410a) {
            case 0:
                IFormatConversionService.Stub.lambda$onTransact$0(this.f5411b, this.f5412c, i);
                break;
            case 1:
                IFormatConversionService.Stub.lambda$onTransact$1(this.f5411b, this.f5412c, i);
                break;
            case 2:
                IGenericService.Stub.lambda$onTransact$0(this.f5411b, this.f5412c, i);
                break;
            case 3:
                IGenericService.Stub.lambda$onTransact$1(this.f5411b, this.f5412c, i);
                break;
            case 4:
                IGenericService.Stub.lambda$onTransact$2(this.f5411b, this.f5412c, i);
                break;
            case 5:
                IGenericService.Stub.lambda$onTransact$3(this.f5411b, this.f5412c, i);
                break;
            case 6:
                INotesOrganizationService.Stub.lambda$onTransact$0(this.f5411b, this.f5412c, i);
                break;
            case 7:
                INotesOrganizationService.Stub.lambda$onTransact$1(this.f5411b, this.f5412c, i);
                break;
            case 8:
                INotesOrganizationService.Stub.lambda$onTransact$2(this.f5411b, this.f5412c, i);
                break;
            case 9:
                INotesOrganizationService.Stub.lambda$onTransact$3(this.f5411b, this.f5412c, i);
                break;
            case 10:
                INotesOrganizationService.Stub.lambda$onTransact$4(this.f5411b, this.f5412c, i);
                break;
            case 11:
                ISmartCaptureService.Stub.lambda$onTransact$0(this.f5411b, this.f5412c, i);
                break;
            case 12:
                ISmartCoverService.Stub.lambda$onTransact$0(this.f5411b, this.f5412c, i);
                break;
            case 13:
                ISmartCoverService.Stub.lambda$onTransact$1(this.f5411b, this.f5412c, i);
                break;
            case 14:
                ISmartCoverService.Stub.lambda$onTransact$2(this.f5411b, this.f5412c, i);
                break;
            case 15:
                ISmartCoverService.Stub.lambda$onTransact$3(this.f5411b, this.f5412c, i);
                break;
            case 16:
                ISmartReplyService.Stub.lambda$onTransact$0(this.f5411b, this.f5412c, i);
                break;
            case 17:
                ISmartReplyService.Stub.lambda$onTransact$1(this.f5411b, this.f5412c, i);
                break;
            case 18:
                ISmartReplyService.Stub.lambda$onTransact$2(this.f5411b, this.f5412c, i);
                break;
            case 19:
                ISmartReplyService.Stub.lambda$onTransact$3(this.f5411b, this.f5412c, i);
                break;
            case 20:
                ISmartReplyService.Stub.lambda$onTransact$4(this.f5411b, this.f5412c, i);
                break;
            case 21:
                ISmartReplyService.Stub.lambda$onTransact$5(this.f5411b, this.f5412c, i);
                break;
            case 22:
                ISmartReplyService.Stub.lambda$onTransact$6(this.f5411b, this.f5412c, i);
                break;
            case 23:
                ISuggestionService.Stub.lambda$onTransact$0(this.f5411b, this.f5412c, i);
                break;
            case 24:
                ISuggestionService.Stub.lambda$onTransact$9(this.f5411b, this.f5412c, i);
                break;
            case 25:
                ISuggestionService.Stub.lambda$onTransact$10(this.f5411b, this.f5412c, i);
                break;
            case 26:
                ISuggestionService.Stub.lambda$onTransact$1(this.f5411b, this.f5412c, i);
                break;
            case 27:
                ISuggestionService.Stub.lambda$onTransact$2(this.f5411b, this.f5412c, i);
                break;
            case 28:
                ISuggestionService.Stub.lambda$onTransact$3(this.f5411b, this.f5412c, i);
                break;
            default:
                ISuggestionService.Stub.lambda$onTransact$4(this.f5411b, this.f5412c, i);
                break;
        }
    }
}
