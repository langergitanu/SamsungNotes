package com.google.auto.common;

import java.util.Optional;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class GeneratedAnnotations {
    private GeneratedAnnotations() {
    }

    @Deprecated
    public static Optional<TypeElement> generatedAnnotation(Elements elements) {
        TypeElement typeElement = elements.getTypeElement("javax.annotation.processing.Generated");
        return typeElement != null ? Optional.of(typeElement) : Optional.ofNullable(elements.getTypeElement("javax.annotation.Generated"));
    }

    public static Optional<TypeElement> generatedAnnotation(Elements elements, SourceVersion sourceVersion) {
        String str;
        if (sourceVersion.compareTo(SourceVersion.RELEASE_8) > 0) {
            str = "javax.annotation.processing.Generated";
        } else {
            str = "javax.annotation.Generated";
        }
        return Optional.ofNullable(elements.getTypeElement(str));
    }
}
