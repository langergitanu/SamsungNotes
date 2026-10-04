package com.google.auto.common;

import java.util.function.Function;

/* JADX INFO: renamed from: com.google.auto.common.B */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C5412B implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3267a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function f3268b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Function f3269c;

    public /* synthetic */ C5412B(Function function, Function function2, int i) {
        this.f3267a = i;
        this.f3268b = function;
        this.f3269c = function2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f3267a) {
            case 0:
                return MoreStreams.lambda$toImmutableBiMap$3(this.f3268b, this.f3269c, obj);
            default:
                return MoreStreams.lambda$toImmutableMap$0(this.f3268b, this.f3269c, obj);
        }
    }
}
