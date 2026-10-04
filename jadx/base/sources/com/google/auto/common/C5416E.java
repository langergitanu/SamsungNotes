package com.google.auto.common;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: com.google.auto.common.E */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C5416E implements BiConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3272a;

    public /* synthetic */ C5416E(int i) {
        this.f3272a = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f3272a) {
            case 0:
                ((ImmutableBiMap.Builder) obj).put((Map.Entry) obj2);
                break;
            default:
                ((ImmutableMap.Builder) obj).put((Map.Entry) obj2);
                break;
        }
    }
}
