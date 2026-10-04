package com.google.auto.common;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.google.auto.common.D */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C5415D implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3271a;

    public /* synthetic */ C5415D(int i) {
        this.f3271a = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f3271a) {
            case 0:
                return ImmutableBiMap.builder();
            default:
                return ImmutableMap.builder();
        }
    }
}
