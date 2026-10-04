package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.lang.reflect.Constructor;

/* JADX INFO: renamed from: com.google.common.util.concurrent.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5929m implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3447a;

    public /* synthetic */ C5929m(int i) {
        this.f3447a = i;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f3447a) {
            case 0:
                return FuturesGetChecked.lambda$static$0((Constructor) obj);
            default:
                return ClosingFuture.access$000((ClosingFuture) obj);
        }
    }
}
