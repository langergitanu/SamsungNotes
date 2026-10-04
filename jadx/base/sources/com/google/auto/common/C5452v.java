package com.google.auto.common;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.squareup.javapoet.AnnotationSpec;
import java.util.Collection;
import java.util.function.Function;

/* JADX INFO: renamed from: com.google.auto.common.v */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C5452v implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3283a;

    public /* synthetic */ C5452v(int i) {
        this.f3283a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f3283a) {
            case 0:
                return BasicAnnotationProcessor.ProcessingStepAsStep.lambda$new$0((Class) obj);
            case 1:
                return BasicAnnotationProcessor.ProcessingStepAsStep.lambda$new$1((Class) obj);
            case 2:
                return BasicAnnotationProcessor.lambda$getSupportedAnnotationTypes$1((BasicAnnotationProcessor.Step) obj);
            case 3:
                return ((AnnotationSpec.Builder) obj).build();
            case 4:
                return ((ImmutableMap.Builder) obj).build();
            case 5:
                return ((ImmutableBiMap.Builder) obj).build();
            case 6:
                return ImmutableSet.copyOf((Collection) obj);
            default:
                return ImmutableList.copyOf((Collection) obj);
        }
    }
}
