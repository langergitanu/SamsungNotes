package com.samsung.android.sdk.scs.p142ai.language;

import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.language.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7738c implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5196a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AppInfo f5197b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f5198c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Map f5199d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f5200e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f5201f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f5202g;

    public /* synthetic */ C7738c(Suggester suggester, AppInfo.RequestType requestType, AppInfo appInfo, String str, SuggestionCategory suggestionCategory, Map map) {
        this.f5200e = suggester;
        this.f5201f = requestType;
        this.f5197b = appInfo;
        this.f5198c = str;
        this.f5202g = suggestionCategory;
        this.f5199d = map;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5196a) {
            case 0:
                ((Suggester) this.f5200e).lambda$suggestion$1((AppInfo.RequestType) this.f5201f, this.f5197b, this.f5198c, (SuggestionCategory) this.f5202g, this.f5199d, (LlmServiceObserver2) obj);
                break;
            default:
                ((Translator) this.f5200e).lambda$interpret$0(this.f5197b, this.f5198c, (String) this.f5201f, (String) this.f5202g, this.f5199d, (LlmServiceObserver2) obj);
                break;
        }
    }

    public /* synthetic */ C7738c(Translator translator, AppInfo appInfo, String str, String str2, String str3, Map map) {
        this.f5200e = translator;
        this.f5197b = appInfo;
        this.f5198c = str;
        this.f5201f = str2;
        this.f5202g = str3;
        this.f5199d = map;
    }
}
