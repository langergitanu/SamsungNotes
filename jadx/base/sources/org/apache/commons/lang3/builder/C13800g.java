package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.DiffBuilder;

/* JADX INFO: renamed from: org.apache.commons.lang3.builder.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13800g implements DiffBuilder.SerializableSupplier, Serializable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9780a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ byte[] f9781b;

    public /* synthetic */ C13800g(byte[] bArr, int i) {
        this.f9780a = i;
        this.f9781b = bArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9780a) {
        }
        return ArrayUtils.toObject(this.f9781b);
    }
}
