package com.google.auto.common;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class AnnotationMirrors {
    private static final Equivalence<AnnotationMirror> ANNOTATION_MIRROR_EQUIVALENCE = new Equivalence<AnnotationMirror>() { // from class: com.google.auto.common.AnnotationMirrors.1
        public String toString() {
            return "AnnotationMirrors.equivalence()";
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(AnnotationMirror annotationMirror, AnnotationMirror annotationMirror2) {
            return MoreTypes.equivalence().equivalent(annotationMirror.getAnnotationType(), annotationMirror2.getAnnotationType()) && AnnotationValues.equivalence().pairwise().equivalent(AnnotationMirrors.getAnnotationValuesWithDefaults(annotationMirror).values(), AnnotationMirrors.getAnnotationValuesWithDefaults(annotationMirror2).values());
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(AnnotationMirror annotationMirror) {
            return Arrays.hashCode(new int[]{MoreTypes.equivalence().hash(annotationMirror.getAnnotationType()), AnnotationValues.equivalence().pairwise().hash(AnnotationMirrors.getAnnotationValuesWithDefaults(annotationMirror).values())});
        }
    };

    private AnnotationMirrors() {
    }

    public static Equivalence<AnnotationMirror> equivalence() {
        return ANNOTATION_MIRROR_EQUIVALENCE;
    }

    public static ImmutableSet<? extends AnnotationMirror> getAnnotatedAnnotations(Element element, Class<? extends Annotation> cls) {
        String canonicalName = cls.getCanonicalName();
        return canonicalName == null ? ImmutableSet.m4349of() : getAnnotatedAnnotations(element, canonicalName);
    }

    public static Map.Entry<ExecutableElement, AnnotationValue> getAnnotationElementAndValue(AnnotationMirror annotationMirror, String str) {
        Preconditions.checkNotNull(annotationMirror);
        Preconditions.checkNotNull(str);
        UnmodifiableIterator<Map.Entry<ExecutableElement, AnnotationValue>> it = getAnnotationValuesWithDefaults(annotationMirror).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<ExecutableElement, AnnotationValue> next = it.next();
            if (next.getKey().getSimpleName().contentEquals(str)) {
                return next;
            }
        }
        throw new IllegalArgumentException(String.format("@%s does not define an element %s()", MoreElements.asType(annotationMirror.getAnnotationType().asElement()).getQualifiedName(), str));
    }

    public static AnnotationValue getAnnotationValue(AnnotationMirror annotationMirror, String str) {
        return getAnnotationElementAndValue(annotationMirror, str).getValue();
    }

    public static ImmutableMap<ExecutableElement, AnnotationValue> getAnnotationValuesWithDefaults(AnnotationMirror annotationMirror) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        Map mapUnmodifiableMap = Collections.unmodifiableMap(annotationMirror.getElementValues());
        for (ExecutableElement executableElement : ElementFilter.methodsIn(annotationMirror.getAnnotationType().asElement().getEnclosedElements())) {
            if (mapUnmodifiableMap.containsKey(executableElement)) {
                builder.put(executableElement, (AnnotationValue) mapUnmodifiableMap.get(executableElement));
            } else {
                if (executableElement.getDefaultValue() == null) {
                    String strValueOf = String.valueOf(MoreElements.asType(executableElement.getEnclosingElement()).getQualifiedName());
                    String strValueOf2 = String.valueOf(executableElement.getSimpleName());
                    StringBuilder sb = new StringBuilder(strValueOf2.length() + strValueOf.length() + 63);
                    sb.append("Unset annotation value without default should never happen: ");
                    sb.append(strValueOf);
                    sb.append('.');
                    sb.append(strValueOf2);
                    sb.append("()");
                    throw new IllegalStateException(sb.toString());
                }
                builder.put(executableElement, executableElement.getDefaultValue());
            }
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getAnnotatedAnnotations$0(TypeElement typeElement, AnnotationMirror annotationMirror) {
        return MoreElements.isAnnotationPresent(annotationMirror.getAnnotationType().asElement(), typeElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getAnnotatedAnnotations$1(String str, AnnotationMirror annotationMirror) {
        return MoreElements.isAnnotationPresent(annotationMirror.getAnnotationType().asElement(), str);
    }

    public static String toString(AnnotationMirror annotationMirror) {
        return AnnotationOutput.toString(annotationMirror);
    }

    public static ImmutableSet<? extends AnnotationMirror> getAnnotatedAnnotations(Element element, final TypeElement typeElement) {
        return (ImmutableSet) element.getAnnotationMirrors().stream().filter(new Predicate() { // from class: com.google.auto.common.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AnnotationMirrors.lambda$getAnnotatedAnnotations$0(typeElement, (AnnotationMirror) obj);
            }
        }).collect(MoreStreams.toImmutableSet());
    }

    public static ImmutableSet<? extends AnnotationMirror> getAnnotatedAnnotations(Element element, final String str) {
        return (ImmutableSet) element.getAnnotationMirrors().stream().filter(new Predicate() { // from class: com.google.auto.common.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AnnotationMirrors.lambda$getAnnotatedAnnotations$1(str, (AnnotationMirror) obj);
            }
        }).collect(MoreStreams.toImmutableSet());
    }
}
