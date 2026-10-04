package com.google.common.net;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultiset;
import java.util.Collection;

/* JADX INFO: renamed from: com.google.common.net.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5820a implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3416a;

    public /* synthetic */ C5820a(int i) {
        this.f3416a = i;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f3416a) {
            case 0:
                return MediaType.lambda$computeToString$0((String) obj);
            default:
                return ImmutableMultiset.copyOf((Collection) obj);
        }
    }
}
