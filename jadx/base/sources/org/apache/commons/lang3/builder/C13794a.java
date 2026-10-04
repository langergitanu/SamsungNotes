package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.builder.DiffBuilder;

/* JADX INFO: renamed from: org.apache.commons.lang3.builder.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13794a implements DiffBuilder.SerializableSupplier, Serializable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9768a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object[] f9769b;

    public /* synthetic */ C13794a(Object[] objArr, int i) {
        this.f9768a = i;
        this.f9769b = objArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9768a) {
            case 0:
                return DiffBuilder.lambda$append$dbd51caa$1(this.f9769b);
            default:
                return DiffBuilder.lambda$append$dbd7d6e4$1(this.f9769b);
        }
    }
}
