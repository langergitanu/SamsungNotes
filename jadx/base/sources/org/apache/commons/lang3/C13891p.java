package org.apache.commons.lang3;

import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: renamed from: org.apache.commons.lang3.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13891p implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9914a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function f9915b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f9916c;

    public /* synthetic */ C13891p(String str, Function function) {
        this.f9916c = str;
        this.f9915b = function;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f9914a) {
            case 0:
                return EnumUtils.lambda$getFirstEnumIgnoreCase$2(this.f9916c, this.f9915b, (Enum) obj);
            default:
                return ThreadUtils.lambda$namePredicate$2(this.f9915b, this.f9916c, obj);
        }
    }

    public /* synthetic */ C13891p(Function function, String str) {
        this.f9915b = function;
        this.f9916c = str;
    }
}
