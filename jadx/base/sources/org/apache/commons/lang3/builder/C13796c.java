package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.DiffBuilder;

/* JADX INFO: renamed from: org.apache.commons.lang3.builder.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13796c implements DiffBuilder.SerializableSupplier, Serializable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9772a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ long[] f9773b;

    public /* synthetic */ C13796c(long[] jArr, int i) {
        this.f9772a = i;
        this.f9773b = jArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9772a) {
        }
        return ArrayUtils.toObject(this.f9773b);
    }
}
