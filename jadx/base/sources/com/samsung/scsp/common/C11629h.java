package com.samsung.scsp.common;

import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.scsp.common.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11629h implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8142a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8143b;

    public /* synthetic */ C11629h(Object obj, int i) {
        this.f8142a = i;
        this.f8143b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f8142a) {
        }
        return Objects.equals(this.f8143b, obj);
    }
}
