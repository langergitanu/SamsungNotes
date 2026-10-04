package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.builder.DiffBuilder;

/* JADX INFO: renamed from: org.apache.commons.lang3.builder.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13809p implements DiffBuilder.SerializableSupplier, Serializable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9798a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ double f9799b;

    public /* synthetic */ C13809p(double d, int i) {
        this.f9798a = i;
        this.f9799b = d;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9798a) {
        }
        return Double.valueOf(this.f9799b);
    }
}
