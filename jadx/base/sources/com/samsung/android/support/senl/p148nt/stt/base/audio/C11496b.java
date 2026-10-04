package com.samsung.android.support.senl.p148nt.stt.base.audio;

import java.util.function.IntFunction;
import opennlp.tools.p217ml.model.AbstractDataIndexer;
import opennlp.tools.p217ml.model.OnePassDataIndexer;
import opennlp.tools.p217ml.model.TwoPassDataIndexer;
import opennlp.tools.postag.POSTagFormatMapper;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.base.audio.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class C11496b implements IntFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7862a;

    public /* synthetic */ C11496b(int i) {
        this.f7862a = i;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i) {
        switch (this.f7862a) {
            case 0:
                return ScsRecognizer.startRecognizer$lambda$3(i);
            case 1:
                return AbstractDataIndexer.lambda$toIndexedStringArray$2(i);
            case 2:
                return OnePassDataIndexer.lambda$computeEventCounts$1(i);
            case 3:
                return TwoPassDataIndexer.lambda$computeEventCounts$1(i);
            case 4:
                return POSTagFormatMapper.lambda$convertTags$0(i);
            case 5:
                return IteratorUtils.lambda$get$0(i);
            default:
                return ReflectionToStringBuilder.lambda$toNoNullStringArray$0(i);
        }
    }
}
