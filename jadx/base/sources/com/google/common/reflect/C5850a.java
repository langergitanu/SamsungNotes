package com.google.common.reflect;

import com.google.common.base.Predicate;
import com.google.common.reflect.ClassPath;

/* JADX INFO: renamed from: com.google.common.reflect.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5850a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3418a;

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        switch (this.f3418a) {
            case 0:
                return ((ClassPath.ClassInfo) obj).isTopLevel();
            default:
                return ((Class) obj).isInterface();
        }
    }
}
