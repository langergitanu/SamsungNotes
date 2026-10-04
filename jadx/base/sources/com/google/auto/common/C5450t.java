package com.google.auto.common;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.common.base.Function;
import javax.lang.model.element.Element;

/* JADX INFO: renamed from: com.google.auto.common.t */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C5450t implements Function {
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return BasicAnnotationProcessor.ElementName.forAnnotatedElement((Element) obj);
    }
}
