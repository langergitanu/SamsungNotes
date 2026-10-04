package com.google.auto.common;

import com.google.auto.common.Overrides;
import java.util.function.Function;
import javax.lang.model.element.TypeParameterElement;

/* JADX INFO: renamed from: com.google.auto.common.G */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C5418G implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Overrides.ExplicitOverrides.TypeSubstVisitor.lambda$erasedParameterTypes$0((TypeParameterElement) obj);
    }
}
