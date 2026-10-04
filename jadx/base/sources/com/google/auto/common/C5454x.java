package com.google.auto.common;

import com.google.auto.common.BasicAnnotationProcessor;
import com.squareup.javapoet.AnnotationSpec;
import java.util.function.Function;

/* JADX INFO: renamed from: com.google.auto.common.x */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C5454x implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3286a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3287b;

    public /* synthetic */ C5454x(Object obj, int i) {
        this.f3286a = i;
        this.f3287b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f3286a) {
            case 0:
                return GeneratedAnnotationSpecs.lambda$generatedAnnotationSpec$1((String) this.f3287b, (AnnotationSpec.Builder) obj);
            case 1:
                return GeneratedAnnotationSpecs.lambda$generatedAnnotationSpec$0((String) this.f3287b, (AnnotationSpec.Builder) obj);
            default:
                return ((BasicAnnotationProcessor) this.f3287b).lambda$getSupportedAnnotationTypeElements$0((BasicAnnotationProcessor.Step) obj);
        }
    }
}
