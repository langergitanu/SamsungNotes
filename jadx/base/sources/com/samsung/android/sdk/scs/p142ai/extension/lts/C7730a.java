package com.samsung.android.sdk.scs.p142ai.extension.lts;

import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.extension.lts.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7730a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5181a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f5182b;

    public /* synthetic */ C7730a(int i, int i2) {
        this.f5181a = i2;
        this.f5182b = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f5181a) {
            case 0:
                return LineChunkStrategy.lambda$canHandle$0(this.f5182b, (String) obj);
            case 1:
                return ParagraphChunkStrategy.lambda$canHandle$0(this.f5182b, (String) obj);
            default:
                return SentenceChunkStrategy.lambda$canHandle$0(this.f5182b, (String) obj);
        }
    }
}
