package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.builder.DiffBuilder;

/* JADX INFO: renamed from: org.apache.commons.lang3.builder.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13810q implements DiffBuilder.SerializableSupplier, Serializable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9800a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ float f9801b;

    public /* synthetic */ C13810q(float f, int i) {
        this.f9800a = i;
        this.f9801b = f;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9800a) {
        }
        return Float.valueOf(this.f9801b);
    }
}
