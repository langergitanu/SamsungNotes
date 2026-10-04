package com.opencsv.bean;

import com.opencsv.bean.function.AccessorInvoker;
import com.opencsv.bean.function.AssignmentInvoker;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: com.opencsv.bean.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6626i implements AssignmentInvoker, AccessorInvoker {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3685a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Method f3686b;

    public /* synthetic */ C6626i(Method method, int i) {
        this.f3685a = i;
        this.f3686b = method;
    }

    @Override // com.opencsv.bean.function.AccessorInvoker
    public Object invoke(Object obj) {
        switch (this.f3685a) {
            case 2:
                return FieldAccess.lambda$determineAccessorMethod$0(this.f3686b, obj);
            default:
                return FieldAccess.lambda$determineAccessorMethod$1(this.f3686b, obj);
        }
    }

    @Override // com.opencsv.bean.function.AssignmentInvoker
    public void invoke(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        switch (this.f3685a) {
            case 0:
                FieldAccess.lambda$determineAssignmentMethod$3(this.f3686b, obj, obj2);
                break;
            default:
                FieldAccess.lambda$determineAssignmentMethod$4(this.f3686b, obj, obj2);
                break;
        }
    }
}
