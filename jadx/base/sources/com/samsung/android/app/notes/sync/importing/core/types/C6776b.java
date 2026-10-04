package com.samsung.android.app.notes.sync.importing.core.types;

import com.google.api.services.drive.model.File;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.Classifier;
import com.samsung.android.sdk.scs.p142ai.language.Configuration;
import com.samsung.android.sdk.scs.p142ai.language.EmojiAugmentor;
import com.samsung.android.sdk.scs.p142ai.language.SmartCoverer;
import com.samsung.android.sdk.scs.p142ai.language.SmartReplyer;
import com.samsung.android.sdk.scs.p142ai.language.Suggester;
import com.samsung.android.sdk.scs.p142ai.language.SuggestionInputParams;
import com.samsung.android.sdk.scs.p142ai.language.WritingComposer;
import com.samsung.android.sdk.scs.p142ai.language.WritingComposerInputParams;
import com.samsung.android.sdk.scs.p142ai.language.WritingComposerMultiInputParams;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;
import p089W.C0328b;
import p089W.C0329c;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.importing.core.types.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6776b implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4158a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4159b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4160c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f4161d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f4162e;

    public /* synthetic */ C6776b(int i, Object obj, Object obj2, Object obj3, Object obj4) {
        this.f4158a = i;
        this.f4159b = obj;
        this.f4160c = obj2;
        this.f4161d = obj3;
        this.f4162e = obj4;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4158a) {
            case 0:
                ((SnoteGoogleDriveSync) this.f4159b).lambda$getImportListFromServer$0((ArrayList) this.f4160c, (ArrayList) this.f4161d, (C0329c) this.f4162e, (File) obj);
                break;
            case 1:
                ((SnoteGoogleDriveSync) this.f4159b).lambda$getImportListFromServer$1((ArrayList) this.f4160c, (ArrayList) this.f4161d, (C0328b) this.f4162e, (File) obj);
                break;
            case 2:
                ((Classifier) this.f4159b).lambda$classify$0((AppInfo) this.f4160c, (String) this.f4161d, (Map) this.f4162e, (LlmServiceObserver2) obj);
                break;
            case 3:
                ((Configuration) this.f4159b).lambda$prewarmLlm$1((AppInfo) this.f4160c, (String) this.f4161d, (Map) this.f4162e, (LlmServiceObserver2) obj);
                break;
            case 4:
                ((EmojiAugmentor) this.f4159b).lambda$emojiAugment$0((AppInfo) this.f4160c, (String) this.f4161d, (Map) this.f4162e, (LlmServiceObserver2) obj);
                break;
            case 5:
                ((SmartCoverer) this.f4159b).lambda$smartCover$0((AppInfo) this.f4160c, (String) this.f4161d, (Map) this.f4162e, (LlmServiceObserver2) obj);
                break;
            case 6:
                ((SmartReplyer) this.f4159b).lambda$smartReply$0((AppInfo) this.f4160c, (String) this.f4161d, (Map) this.f4162e, (LlmServiceObserver2) obj);
                break;
            case 7:
                ((Suggester) this.f4159b).lambda$suggestion$0((AppInfo) this.f4160c, (String) this.f4161d, (Map) this.f4162e, (LlmServiceObserver2) obj);
                break;
            case 8:
                ((Suggester) this.f4159b).lambda$suggestion$2((SuggestionInputParams) this.f4160c, (AppInfo) this.f4161d, (Map) this.f4162e, (LlmServiceObserver2) obj);
                break;
            case 9:
                ((WritingComposer) this.f4159b).lambda$compose$0((WritingComposerInputParams) this.f4160c, (AppInfo) this.f4161d, (Map) this.f4162e, (LlmServiceObserver2) obj);
                break;
            default:
                ((WritingComposer) this.f4159b).lambda$compose$1((WritingComposerMultiInputParams) this.f4160c, (AppInfo) this.f4161d, (Map) this.f4162e, (LlmServiceObserver2) obj);
                break;
        }
    }
}
