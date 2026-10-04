package com.vladsch.flexmark.util.data;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.data.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11846b implements DataNotNullValueFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8364a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8365b;

    public /* synthetic */ C11846b(Object obj, int i) {
        this.f8364a = i;
        this.f8365b = obj;
    }

    @Override // com.vladsch.flexmark.util.data.DataNotNullValueFactory, com.vladsch.flexmark.util.data.DataValueFactory
    public final Object apply(DataHolder dataHolder) {
        switch (this.f8364a) {
            case 0:
                return ((DataKey) this.f8365b).get(dataHolder);
            case 1:
                return (Boolean) ((DataKey) this.f8365b).get(dataHolder);
            default:
                return DataKey.lambda$new$1(this.f8365b, dataHolder);
        }
    }
}
