package com.vladsch.flexmark.util.data;

import java.util.function.Supplier;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.data.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11845a implements DataValueFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8362a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Supplier f8363b;

    public /* synthetic */ C11845a(Supplier supplier, int i) {
        this.f8362a = i;
        this.f8363b = supplier;
    }

    @Override // com.vladsch.flexmark.util.data.DataValueFactory
    public final Object apply(DataHolder dataHolder) {
        switch (this.f8362a) {
            case 0:
                return DataKey.lambda$new$0((NotNullValueSupplier) this.f8363b, dataHolder);
            default:
                return NullableDataKey.lambda$new$0(this.f8363b, dataHolder);
        }
    }
}
