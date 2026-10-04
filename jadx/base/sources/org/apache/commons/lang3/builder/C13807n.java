package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.DiffBuilder;

/* JADX INFO: renamed from: org.apache.commons.lang3.builder.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13807n implements DiffBuilder.SerializableSupplier, Serializable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9794a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ double[] f9795b;

    public /* synthetic */ C13807n(double[] dArr, int i) {
        this.f9794a = i;
        this.f9795b = dArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9794a) {
        }
        return ArrayUtils.toObject(this.f9795b);
    }
}
