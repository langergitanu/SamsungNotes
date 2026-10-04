package com.vladsch.flexmark.util.sequence.builder;

import java.util.function.Function;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.sequence.builder.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11883a implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8415a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SegmentBuilderBase f8416b;

    public /* synthetic */ C11883a(SegmentBuilderBase segmentBuilderBase, int i) {
        this.f8415a = i;
        this.f8416b = segmentBuilderBase;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f8415a) {
            case 0:
                return this.f8416b.optimizeText((Object[]) obj);
            default:
                return this.f8416b.handleOverlap((Object[]) obj);
        }
    }
}
