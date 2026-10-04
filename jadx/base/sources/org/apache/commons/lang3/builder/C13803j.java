package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.builder.DiffBuilder;

/* JADX INFO: renamed from: org.apache.commons.lang3.builder.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13803j implements DiffBuilder.SerializableSupplier, Serializable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9786a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9787b;

    public /* synthetic */ C13803j(Object obj, int i) {
        this.f9786a = i;
        this.f9787b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9786a) {
            case 0:
                return DiffBuilder.lambda$append$9e3d8e65$1(this.f9787b);
            default:
                return DiffBuilder.lambda$append$9e40489f$1(this.f9787b);
        }
    }
}
