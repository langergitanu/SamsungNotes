package com.opencsv.bean;

import com.opencsv.bean.function.AccessorInvoker;
import com.opencsv.bean.function.AssignmentInvoker;

/* JADX INFO: renamed from: com.opencsv.bean.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6627j implements AssignmentInvoker, AccessorInvoker {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ FieldAccess f3687a;

    public /* synthetic */ C6627j(FieldAccess fieldAccess) {
        this.f3687a = fieldAccess;
    }

    @Override // com.opencsv.bean.function.AccessorInvoker
    public Object invoke(Object obj) {
        return this.f3687a.lambda$determineAccessorMethod$2(obj);
    }

    @Override // com.opencsv.bean.function.AssignmentInvoker
    public void invoke(Object obj, Object obj2) throws IllegalAccessException {
        this.f3687a.lambda$determineAssignmentMethod$5(obj, obj2);
    }
}
