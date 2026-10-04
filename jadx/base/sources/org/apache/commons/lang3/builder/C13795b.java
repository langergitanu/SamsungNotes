package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.builder.DiffBuilder;

/* JADX INFO: renamed from: org.apache.commons.lang3.builder.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13795b implements DiffBuilder.SerializableSupplier, Serializable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9770a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ char f9771b;

    public /* synthetic */ C13795b(char c, int i) {
        this.f9770a = i;
        this.f9771b = c;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9770a) {
            case 0:
                return Character.valueOf(this.f9771b);
            default:
                return DiffBuilder.lambda$append$cfd3e398$1(this.f9771b);
        }
    }
}
