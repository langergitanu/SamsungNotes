package com.opencsv.bean;

import android.os.Bundle;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.Configuration;
import com.samsung.android.sdk.scs.p142ai.language.SmartReplyer;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationErrorCode;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.scsp.common.PushConsumerManager;
import com.samsung.scsp.common.PushVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.lang3.Validate;
import org.apache.commons.text.similarity.LevenshteinDistance;

/* JADX INFO: renamed from: com.opencsv.bean.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6631n implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3690a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3691b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f3692c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f3693d;

    public /* synthetic */ C6631n(Object obj, int i, Object obj2, Object obj3) {
        this.f3690a = i;
        this.f3692c = obj;
        this.f3691b = obj2;
        this.f3693d = obj3;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f3690a) {
            case 0:
                FuzzyMappingStrategy.lambda$null$1((List) this.f3692c, (LevenshteinDistance) this.f3691b, (String) this.f3693d, (Map.Entry) obj);
                break;
            case 1:
                FuzzyMappingStrategy.lambda$captureHeader$2((ListValuedMap) this.f3692c, (LinkedList) this.f3693d, (LevenshteinDistance) this.f3691b, (String) obj);
                break;
            case 2:
                TextTranslator.translateText$lambda$8((StringBuilder) this.f3692c, (String) this.f3693d, (CountDownLatch) this.f3691b, (NeuralTranslationErrorCode) obj);
                break;
            case 3:
                ((Configuration) this.f3692c).lambda$getModelInfo$0((AppInfo) this.f3691b, (Map) this.f3693d, (LlmServiceObserver2) obj);
                break;
            case 4:
                ((SmartReplyer) this.f3692c).lambda$identifyLanguage$2((AppInfo) this.f3691b, (String) this.f3693d, (LlmServiceObserver2) obj);
                break;
            case 5:
                MainListDocumentDataDao.lambda$makeDocumentCountEntries$3((NotesDocumentCountEntry) this.f3692c, (ArrayList) this.f3691b, (Map) this.f3693d, (NotesDocumentCountEntry) obj);
                break;
            case 6:
                PushConsumerManager.lambda$add$1((Supplier) this.f3692c, (String[]) this.f3691b, (Bundle) this.f3693d, (PushVo) obj);
                break;
            default:
                Validate.lambda$noNullElements$0((String) this.f3693d, (Object[]) this.f3692c, (AtomicInteger) this.f3691b, obj);
                break;
        }
    }

    public /* synthetic */ C6631n(Object obj, Serializable serializable, Object obj2, int i) {
        this.f3690a = i;
        this.f3692c = obj;
        this.f3693d = serializable;
        this.f3691b = obj2;
    }

    public /* synthetic */ C6631n(String str, Object[] objArr, AtomicInteger atomicInteger) {
        this.f3690a = 7;
        this.f3693d = str;
        this.f3692c = objArr;
        this.f3691b = atomicInteger;
    }
}
