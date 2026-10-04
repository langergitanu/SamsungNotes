package com.google.auto.common;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.common.base.Function;

/* JADX INFO: renamed from: com.google.auto.common.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C5448r implements Function {
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return BasicAnnotationProcessor.asStep((BasicAnnotationProcessor.ProcessingStep) obj);
    }
}
