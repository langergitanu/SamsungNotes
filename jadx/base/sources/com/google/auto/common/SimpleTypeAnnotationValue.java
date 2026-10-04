package com.google.auto.common;

import com.google.common.base.Preconditions;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.AnnotationValueVisitor;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class SimpleTypeAnnotationValue implements AnnotationValue {
    private final TypeMirror value;

    private SimpleTypeAnnotationValue(TypeMirror typeMirror) {
        Preconditions.checkArgument(typeMirror.getKind().isPrimitive() || typeMirror.getKind().equals(TypeKind.DECLARED) || typeMirror.getKind().equals(TypeKind.ARRAY), "value must be a primitive, array, or declared type, but was %s (%s)", typeMirror.getKind(), typeMirror);
        if (typeMirror.getKind().equals(TypeKind.DECLARED)) {
            Preconditions.checkArgument(MoreTypes.asDeclared(typeMirror).getTypeArguments().isEmpty(), "value must not be a parameterized type: %s", typeMirror);
        }
        this.value = typeMirror;
    }

    /* JADX INFO: renamed from: of */
    public static AnnotationValue m4256of(TypeMirror typeMirror) {
        return new SimpleTypeAnnotationValue(typeMirror);
    }

    public <R, P> R accept(AnnotationValueVisitor<R, P> annotationValueVisitor, P p) {
        return (R) annotationValueVisitor.visitType(getValue(), p);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 6);
        sb.append(strValueOf);
        sb.append(".class");
        return sb.toString();
    }

    public TypeMirror getValue() {
        return this.value;
    }
}
