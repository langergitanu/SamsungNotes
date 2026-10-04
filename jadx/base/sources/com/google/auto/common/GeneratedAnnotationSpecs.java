package com.google.auto.common;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import java.util.Optional;
import java.util.function.Function;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class GeneratedAnnotationSpecs {
    private GeneratedAnnotationSpecs() {
    }

    @Deprecated
    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, Class<?> cls) {
        return generatedAnnotationSpecBuilder(elements, cls).map(new C5452v(3));
    }

    private static Optional<AnnotationSpec.Builder> generatedAnnotationSpecBuilder(Elements elements, final Class<?> cls) {
        return GeneratedAnnotations.generatedAnnotation(elements).map(new Function() { // from class: com.google.auto.common.z
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return GeneratedAnnotationSpecs.lambda$generatedAnnotationSpecBuilder$2(cls, (TypeElement) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnnotationSpec lambda$generatedAnnotationSpec$0(String str, AnnotationSpec.Builder builder) {
        return builder.addMember("comments", "$S", str).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnnotationSpec lambda$generatedAnnotationSpec$1(String str, AnnotationSpec.Builder builder) {
        return builder.addMember("comments", "$S", str).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnnotationSpec.Builder lambda$generatedAnnotationSpecBuilder$2(Class cls, TypeElement typeElement) {
        return AnnotationSpec.builder(ClassName.get(typeElement)).addMember("value", "$S", cls.getCanonicalName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnnotationSpec.Builder lambda$generatedAnnotationSpecBuilder$3(Class cls, TypeElement typeElement) {
        return AnnotationSpec.builder(ClassName.get(typeElement)).addMember("value", "$S", cls.getCanonicalName());
    }

    @Deprecated
    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, Class<?> cls, String str) {
        return generatedAnnotationSpecBuilder(elements, cls).map(new C5454x(str, 1));
    }

    private static Optional<AnnotationSpec.Builder> generatedAnnotationSpecBuilder(Elements elements, SourceVersion sourceVersion, final Class<?> cls) {
        return GeneratedAnnotations.generatedAnnotation(elements, sourceVersion).map(new Function() { // from class: com.google.auto.common.y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return GeneratedAnnotationSpecs.lambda$generatedAnnotationSpecBuilder$3(cls, (TypeElement) obj);
            }
        });
    }

    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, SourceVersion sourceVersion, Class<?> cls) {
        return generatedAnnotationSpecBuilder(elements, sourceVersion, cls).map(new C5452v(3));
    }

    public static Optional<AnnotationSpec> generatedAnnotationSpec(Elements elements, SourceVersion sourceVersion, Class<?> cls, String str) {
        return generatedAnnotationSpecBuilder(elements, sourceVersion, cls).map(new C5454x(str, 0));
    }
}
