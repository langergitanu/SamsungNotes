package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.builder.DiffBuilder;

/* JADX INFO: renamed from: org.apache.commons.lang3.builder.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13811r implements DiffBuilder.SerializableSupplier, Serializable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9802a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ short f9803b;

    public /* synthetic */ C13811r(short s, int i) {
        this.f9802a = i;
        this.f9803b = s;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9802a) {
        }
        return Short.valueOf(this.f9803b);
    }
}
