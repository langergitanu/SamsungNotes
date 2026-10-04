package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.builder.DiffBuilder;

/* JADX INFO: renamed from: org.apache.commons.lang3.builder.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13804k implements DiffBuilder.SerializableSupplier, Serializable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9788a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f9789b;

    public /* synthetic */ C13804k(int i, int i2) {
        this.f9788a = i2;
        this.f9789b = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9788a) {
        }
        return Integer.valueOf(this.f9789b);
    }
}
