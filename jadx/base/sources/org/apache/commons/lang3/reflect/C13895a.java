package org.apache.commons.lang3.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.Predicate;

/* JADX INFO: renamed from: org.apache.commons.lang3.reflect.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13895a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9922a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Class f9923b;

    public /* synthetic */ C13895a(Class cls, int i) {
        this.f9922a = i;
        this.f9923b = cls;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f9922a) {
            case 0:
                return FieldUtils.lambda$getFieldsListWithAnnotation$0(this.f9923b, (Field) obj);
            case 1:
                return MethodUtils.lambda$getMethodsListWithAnnotation$6(this.f9923b, (Method) obj);
            default:
                return this.f9923b.isInstance(obj);
        }
    }
}
