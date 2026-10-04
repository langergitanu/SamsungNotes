package com.vladsch.flexmark.util.data;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.data.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11847c implements DataValueFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8366a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DataKeyBase f8367b;

    public /* synthetic */ C11847c(DataKeyBase dataKeyBase, int i) {
        this.f8366a = i;
        this.f8367b = dataKeyBase;
    }

    @Override // com.vladsch.flexmark.util.data.DataValueFactory
    public final Object apply(DataHolder dataHolder) {
        switch (this.f8366a) {
            case 0:
                return this.f8367b.getDefaultValue(dataHolder);
            default:
                return this.f8367b.get(dataHolder);
        }
    }
}
