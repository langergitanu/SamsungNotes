package com.google.auto.common;

import java.util.function.Function;
import javax.lang.model.element.AnnotationValue;

/* JADX INFO: renamed from: com.google.auto.common.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C5444n implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Long.valueOf(AnnotationValues.getLong((AnnotationValue) obj));
    }
}
