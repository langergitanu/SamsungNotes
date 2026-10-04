package com.google.auto.common;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import java.util.function.BinaryOperator;

/* JADX INFO: renamed from: com.google.auto.common.C */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C5414C implements BinaryOperator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3270a;

    public /* synthetic */ C5414C(int i) {
        this.f3270a = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f3270a) {
            case 0:
                return MoreStreams.lambda$toImmutableMap$2((ImmutableMap.Builder) obj, (ImmutableMap.Builder) obj2);
            default:
                return MoreStreams.lambda$toImmutableBiMap$5((ImmutableBiMap.Builder) obj, (ImmutableBiMap.Builder) obj2);
        }
    }
}
