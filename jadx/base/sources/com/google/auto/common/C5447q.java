package com.google.auto.common;

import java.util.Objects;
import java.util.function.Predicate;
import javax.lang.model.element.TypeElement;

/* JADX INFO: renamed from: com.google.auto.common.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C5447q implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return Objects.nonNull((TypeElement) obj);
    }
}
