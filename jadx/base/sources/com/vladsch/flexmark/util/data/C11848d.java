package com.vladsch.flexmark.util.data;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.data.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11848d implements DataValueFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8368a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8369b;

    public /* synthetic */ C11848d(Object obj, int i) {
        this.f8368a = i;
        this.f8369b = obj;
    }

    @Override // com.vladsch.flexmark.util.data.DataValueFactory
    public final Object apply(DataHolder dataHolder) {
        switch (this.f8368a) {
            case 0:
                return DataKeyBase.lambda$new$0(this.f8369b, dataHolder);
            default:
                return NullableDataKey.lambda$new$1(this.f8369b, dataHolder);
        }
    }
}
