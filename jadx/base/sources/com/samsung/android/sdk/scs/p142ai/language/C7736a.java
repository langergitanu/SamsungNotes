package com.samsung.android.sdk.scs.p142ai.language;

import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.language.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7736a implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5188a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AppInfo f5189b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Map f5190c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f5191d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f5192e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f5193f;

    public /* synthetic */ C7736a(Extractor extractor, Object obj, AppInfo.RequestType requestType, AppInfo appInfo, Map map, int i) {
        this.f5188a = i;
        this.f5191d = extractor;
        this.f5192e = obj;
        this.f5193f = requestType;
        this.f5189b = appInfo;
        this.f5190c = map;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5188a) {
            case 0:
                ((Corrector) this.f5191d).lambda$correct$0(this.f5189b, (String) this.f5192e, (CorrectionSubTask) this.f5193f, this.f5190c, (LlmServiceObserver2) obj);
                break;
            case 1:
                ((Extractor) this.f5191d).lambda$extract$1((ExtractionInputParams) this.f5192e, (AppInfo.RequestType) this.f5193f, this.f5189b, this.f5190c, (LlmServiceObserver2) obj);
                break;
            case 2:
                ((Extractor) this.f5191d).lambda$extract$2((ExtractionMultiInputParams) this.f5192e, (AppInfo.RequestType) this.f5193f, this.f5189b, this.f5190c, (LlmServiceObserver2) obj);
                break;
            case 3:
                ((Extractor) this.f5191d).lambda$extract$0(this.f5189b, (String) this.f5192e, (ExtractionCategory) this.f5193f, this.f5190c, (LlmServiceObserver2) obj);
                break;
            case 4:
                ((FormatConverter) this.f5191d).lambda$convert$0(this.f5189b, (String) this.f5192e, (FormatConversionType) this.f5193f, this.f5190c, (LlmServiceObserver2) obj);
                break;
            case 5:
                ((Generic) this.f5191d).lambda$generic$0(this.f5189b, (String) this.f5192e, (String) this.f5193f, this.f5190c, (LlmServiceObserver2) obj);
                break;
            case 6:
                ((NotesOrganizer) this.f5191d).lambda$notesOrganize$0(this.f5189b, (String) this.f5192e, (NotesOrganizationFormatType) this.f5193f, this.f5190c, (LlmServiceObserver2) obj);
                break;
            case 7:
                ((SmartReplyer) this.f5191d).lambda$smartReply$1(this.f5189b, (String) this.f5192e, (SmartReplyCategory) this.f5193f, this.f5190c, (LlmServiceObserver2) obj);
                break;
            case 8:
                ((Suggester) this.f5191d).lambda$reportGeneration$3(this.f5189b, (String) this.f5192e, (String) this.f5193f, this.f5190c, (LlmServiceObserver2) obj);
                break;
            case 9:
                ((Summarizer) this.f5191d).lambda$summarizeOnDevice$1(this.f5189b, (String) this.f5192e, (SummaryOnDeviceType) this.f5193f, this.f5190c, (LlmServiceObserver2) obj);
                break;
            case 10:
                ((ToneConverter) this.f5191d).lambda$toneConvert$0(this.f5189b, (String) this.f5192e, (ToneType) this.f5193f, this.f5190c, (LlmServiceObserver2) obj);
                break;
            default:
                ((ToneConverter) this.f5191d).lambda$toneConvert$1(this.f5189b, (String) this.f5192e, (String) this.f5193f, this.f5190c, (LlmServiceObserver2) obj);
                break;
        }
    }

    public /* synthetic */ C7736a(Object obj, AppInfo appInfo, String str, Object obj2, Map map, int i) {
        this.f5188a = i;
        this.f5191d = obj;
        this.f5189b = appInfo;
        this.f5192e = str;
        this.f5193f = obj2;
        this.f5190c = map;
    }
}
