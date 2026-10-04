package org.apache.commons.lang3;

import java.lang.annotation.Annotation;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.commons.lang3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13790a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9765a;

    public /* synthetic */ C13790a(int i) {
        this.f9765a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f9765a) {
            case 0:
                return Annotation.class.isAssignableFrom((Class) obj);
            case 1:
                return StringUtils.isEmpty((String) obj);
            case 2:
                return Objects.nonNull(obj);
            case 3:
                return Objects.isNull(obj);
            default:
                return Objects.nonNull((Supplier) obj);
        }
    }
}
