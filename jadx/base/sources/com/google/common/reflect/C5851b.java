package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.reflect.MutableTypeToInstanceMap;
import java.util.Map;

/* JADX INFO: renamed from: com.google.common.reflect.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5851b implements Function {
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return MutableTypeToInstanceMap.UnmodifiableEntry.m4483b((Map.Entry) obj);
    }
}
