package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.DiffBuilder;

/* JADX INFO: renamed from: org.apache.commons.lang3.builder.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13806m implements DiffBuilder.SerializableSupplier, Serializable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9792a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean[] f9793b;

    public /* synthetic */ C13806m(boolean[] zArr, int i) {
        this.f9792a = i;
        this.f9793b = zArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9792a) {
        }
        return ArrayUtils.toObject(this.f9793b);
    }
}
