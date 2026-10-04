package com.google.auto.common;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Function;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor8;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class AnnotationValues {
    private static final Equivalence<AnnotationValue> ANNOTATION_VALUE_EQUIVALENCE = new Equivalence<AnnotationValue>() { // from class: com.google.auto.common.AnnotationValues.1
        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(AnnotationValue annotationValue, AnnotationValue annotationValue2) {
            return ((Boolean) annotationValue.accept(new SimpleAnnotationValueVisitor8<Boolean, AnnotationValue>(this) { // from class: com.google.auto.common.AnnotationValues.1.1
                public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
                    return visitArray((List<? extends AnnotationValue>) list, (AnnotationValue) obj);
                }

                public Boolean defaultAction(Object obj, AnnotationValue annotationValue3) {
                    return Boolean.valueOf(obj.equals(annotationValue3.accept(new SimpleAnnotationValueVisitor8<Object, Void>(this) { // from class: com.google.auto.common.AnnotationValues.1.1.1
                        public Object defaultAction(Object obj2, Void r2) {
                            return obj2;
                        }
                    }, (Object) null)));
                }

                public Boolean visitAnnotation(AnnotationMirror annotationMirror, AnnotationValue annotationValue3) {
                    return (Boolean) annotationValue3.accept(new SimpleAnnotationValueVisitor8<Boolean, AnnotationMirror>(this) { // from class: com.google.auto.common.AnnotationValues.1.1.2
                        public Boolean defaultAction(Object obj, AnnotationMirror annotationMirror2) {
                            return Boolean.FALSE;
                        }

                        public Boolean visitAnnotation(AnnotationMirror annotationMirror2, AnnotationMirror annotationMirror3) {
                            return Boolean.valueOf(AnnotationMirrors.equivalence().equivalent(annotationMirror3, annotationMirror2));
                        }
                    }, annotationMirror);
                }

                public Boolean visitArray(List<? extends AnnotationValue> list, AnnotationValue annotationValue3) {
                    return (Boolean) annotationValue3.accept(new SimpleAnnotationValueVisitor8<Boolean, List<? extends AnnotationValue>>(this) { // from class: com.google.auto.common.AnnotationValues.1.1.3
                        public /* bridge */ /* synthetic */ Object visitArray(List list2, Object obj) {
                            return visitArray((List<? extends AnnotationValue>) list2, (List<? extends AnnotationValue>) obj);
                        }

                        public Boolean defaultAction(Object obj, List<? extends AnnotationValue> list2) {
                            return Boolean.FALSE;
                        }

                        public Boolean visitArray(List<? extends AnnotationValue> list2, List<? extends AnnotationValue> list3) {
                            return Boolean.valueOf(AnnotationValues.equivalence().pairwise().equivalent(list3, list2));
                        }
                    }, list);
                }

                public Boolean visitType(TypeMirror typeMirror, AnnotationValue annotationValue3) {
                    return (Boolean) annotationValue3.accept(new SimpleAnnotationValueVisitor8<Boolean, TypeMirror>(this) { // from class: com.google.auto.common.AnnotationValues.1.1.4
                        public Boolean defaultAction(Object obj, TypeMirror typeMirror2) {
                            return Boolean.FALSE;
                        }

                        public Boolean visitType(TypeMirror typeMirror2, TypeMirror typeMirror3) {
                            return Boolean.valueOf(MoreTypes.equivalence().equivalent(typeMirror3, typeMirror2));
                        }
                    }, typeMirror);
                }
            }, annotationValue2)).booleanValue();
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(AnnotationValue annotationValue) {
            return ((Integer) annotationValue.accept(new SimpleAnnotationValueVisitor8<Integer, Void>(this) { // from class: com.google.auto.common.AnnotationValues.1.2
                public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
                    return visitArray((List<? extends AnnotationValue>) list, (Void) obj);
                }

                public Integer defaultAction(Object obj, Void r2) {
                    return Integer.valueOf(obj.hashCode());
                }

                public Integer visitAnnotation(AnnotationMirror annotationMirror, Void r2) {
                    return Integer.valueOf(AnnotationMirrors.equivalence().hash(annotationMirror));
                }

                public Integer visitArray(List<? extends AnnotationValue> list, Void r2) {
                    return Integer.valueOf(AnnotationValues.equivalence().pairwise().hash(list));
                }

                public Integer visitType(TypeMirror typeMirror, Void r2) {
                    return Integer.valueOf(MoreTypes.equivalence().hash(typeMirror));
                }
            }, (Object) null)).intValue();
        }
    };
    private static final ArrayVisitor<DeclaredType> TYPE_MIRRORS_VISITOR = new ArrayVisitor<>(new C5433c());
    private static final ArrayVisitor<AnnotationMirror> ANNOTATION_MIRRORS_VISITOR = new ArrayVisitor<>(new C5440j());
    private static final ArrayVisitor<VariableElement> ENUMS_VISITOR = new ArrayVisitor<>(new C5441k());
    private static final ArrayVisitor<String> STRINGS_VISITOR = new ArrayVisitor<>(new C5442l());
    private static final ArrayVisitor<Integer> INTS_VISITOR = new ArrayVisitor<>(new C5443m());
    private static final ArrayVisitor<Long> LONGS_VISITOR = new ArrayVisitor<>(new C5444n());
    private static final ArrayVisitor<Byte> BYTES_VISITOR = new ArrayVisitor<>(new C5445o());
    private static final ArrayVisitor<Short> SHORTS_VISITOR = new ArrayVisitor<>(new C5434d());
    private static final ArrayVisitor<Float> FLOATS_VISITOR = new ArrayVisitor<>(new C5435e());
    private static final ArrayVisitor<Double> DOUBLES_VISITOR = new ArrayVisitor<>(new C5436f());
    private static final ArrayVisitor<Boolean> BOOLEANS_VISITOR = new ArrayVisitor<>(new C5437g());
    private static final ArrayVisitor<Character> CHARS_VISITOR = new ArrayVisitor<>(new C5438h());
    private static final ArrayVisitor<AnnotationValue> ANNOTATION_VALUES_VISITOR = new ArrayVisitor<>(new C5439i());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AnnotationMirrorVisitor extends DefaultVisitor<AnnotationMirror> {
        static final AnnotationMirrorVisitor INSTANCE = new AnnotationMirrorVisitor();

        public AnnotationMirrorVisitor() {
            super(AnnotationMirror.class);
        }

        public AnnotationMirror visitAnnotation(AnnotationMirror annotationMirror, Void r2) {
            return annotationMirror;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ArrayVisitor<T> extends SimpleAnnotationValueVisitor8<ImmutableList<T>, Void> {
        final Function<AnnotationValue, T> visitT;

        public ArrayVisitor(Function<AnnotationValue, T> function) {
            this.visitT = (Function) Preconditions.checkNotNull(function);
        }

        public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
            return visitArray((List<? extends AnnotationValue>) list, (Void) obj);
        }

        public ImmutableList<T> defaultAction(Object obj, Void r4) {
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("Expected an array, got instead: ");
            sb.append(strValueOf);
            throw new IllegalStateException(sb.toString());
        }

        public ImmutableList<T> visitArray(List<? extends AnnotationValue> list, Void r2) {
            return (ImmutableList) list.stream().map(this.visitT).collect(MoreStreams.toImmutableList());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DefaultVisitor<T> extends SimpleAnnotationValueVisitor8<T, Void> {
        final Class<T> clazz;

        public DefaultVisitor(Class<T> cls) {
            this.clazz = (Class) Preconditions.checkNotNull(cls);
        }

        public T defaultAction(Object obj, Void r5) {
            String simpleName = this.clazz.getSimpleName();
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(strValueOf.length() + simpleName.length() + 26);
            sb.append("Expected a ");
            sb.append(simpleName);
            sb.append(", got instead: ");
            sb.append(strValueOf);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class EnumVisitor extends DefaultVisitor<VariableElement> {
        static final EnumVisitor INSTANCE = new EnumVisitor();

        public EnumVisitor() {
            super(VariableElement.class);
        }

        public VariableElement visitEnumConstant(VariableElement variableElement, Void r2) {
            return variableElement;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TypeMirrorVisitor extends DefaultVisitor<DeclaredType> {
        static final TypeMirrorVisitor INSTANCE = new TypeMirrorVisitor();

        public TypeMirrorVisitor() {
            super(DeclaredType.class);
        }

        public DeclaredType visitType(TypeMirror typeMirror, Void r2) {
            return MoreTypes.asDeclared(typeMirror);
        }
    }

    private AnnotationValues() {
    }

    public static Equivalence<AnnotationValue> equivalence() {
        return ANNOTATION_VALUE_EQUIVALENCE;
    }

    public static AnnotationMirror getAnnotationMirror(AnnotationValue annotationValue) {
        return (AnnotationMirror) AnnotationMirrorVisitor.INSTANCE.visit(annotationValue);
    }

    public static ImmutableList<AnnotationMirror> getAnnotationMirrors(AnnotationValue annotationValue) {
        return (ImmutableList) ANNOTATION_MIRRORS_VISITOR.visit(annotationValue);
    }

    public static ImmutableList<AnnotationValue> getAnnotationValues(AnnotationValue annotationValue) {
        return (ImmutableList) ANNOTATION_VALUES_VISITOR.visit(annotationValue);
    }

    public static boolean getBoolean(AnnotationValue annotationValue) {
        return ((Boolean) valueOfType(annotationValue, Boolean.class)).booleanValue();
    }

    public static ImmutableList<Boolean> getBooleans(AnnotationValue annotationValue) {
        return (ImmutableList) BOOLEANS_VISITOR.visit(annotationValue);
    }

    public static byte getByte(AnnotationValue annotationValue) {
        return ((Byte) valueOfType(annotationValue, Byte.class)).byteValue();
    }

    public static ImmutableList<Byte> getBytes(AnnotationValue annotationValue) {
        return (ImmutableList) BYTES_VISITOR.visit(annotationValue);
    }

    public static char getChar(AnnotationValue annotationValue) {
        return ((Character) valueOfType(annotationValue, Character.class)).charValue();
    }

    public static ImmutableList<Character> getChars(AnnotationValue annotationValue) {
        return (ImmutableList) CHARS_VISITOR.visit(annotationValue);
    }

    public static double getDouble(AnnotationValue annotationValue) {
        return ((Double) valueOfType(annotationValue, Double.class)).doubleValue();
    }

    public static ImmutableList<Double> getDoubles(AnnotationValue annotationValue) {
        return (ImmutableList) DOUBLES_VISITOR.visit(annotationValue);
    }

    public static VariableElement getEnum(AnnotationValue annotationValue) {
        return (VariableElement) EnumVisitor.INSTANCE.visit(annotationValue);
    }

    public static ImmutableList<VariableElement> getEnums(AnnotationValue annotationValue) {
        return (ImmutableList) ENUMS_VISITOR.visit(annotationValue);
    }

    public static float getFloat(AnnotationValue annotationValue) {
        return ((Float) valueOfType(annotationValue, Float.class)).floatValue();
    }

    public static ImmutableList<Float> getFloats(AnnotationValue annotationValue) {
        return (ImmutableList) FLOATS_VISITOR.visit(annotationValue);
    }

    public static int getInt(AnnotationValue annotationValue) {
        return ((Integer) valueOfType(annotationValue, Integer.class)).intValue();
    }

    public static ImmutableList<Integer> getInts(AnnotationValue annotationValue) {
        return (ImmutableList) INTS_VISITOR.visit(annotationValue);
    }

    public static long getLong(AnnotationValue annotationValue) {
        return ((Long) valueOfType(annotationValue, Long.class)).longValue();
    }

    public static ImmutableList<Long> getLongs(AnnotationValue annotationValue) {
        return (ImmutableList) LONGS_VISITOR.visit(annotationValue);
    }

    public static short getShort(AnnotationValue annotationValue) {
        return ((Short) valueOfType(annotationValue, Short.class)).shortValue();
    }

    public static ImmutableList<Short> getShorts(AnnotationValue annotationValue) {
        return (ImmutableList) SHORTS_VISITOR.visit(annotationValue);
    }

    public static String getString(AnnotationValue annotationValue) {
        return (String) valueOfType(annotationValue, String.class);
    }

    public static ImmutableList<String> getStrings(AnnotationValue annotationValue) {
        return (ImmutableList) STRINGS_VISITOR.visit(annotationValue);
    }

    public static DeclaredType getTypeMirror(AnnotationValue annotationValue) {
        return (DeclaredType) TypeMirrorVisitor.INSTANCE.visit(annotationValue);
    }

    public static ImmutableList<DeclaredType> getTypeMirrors(AnnotationValue annotationValue) {
        return (ImmutableList) TYPE_MIRRORS_VISITOR.visit(annotationValue);
    }

    public static String toString(AnnotationValue annotationValue) {
        return AnnotationOutput.toString(annotationValue);
    }

    private static <T> T valueOfType(AnnotationValue annotationValue, Class<T> cls) {
        Object value = annotationValue.getValue();
        if (cls.isInstance(value)) {
            return cls.cast(value);
        }
        String simpleName = cls.getSimpleName();
        String strValueOf = String.valueOf(value);
        StringBuilder sb = new StringBuilder(strValueOf.length() + simpleName.length() + 24);
        sb.append("Expected ");
        sb.append(simpleName);
        sb.append(", got instead: ");
        sb.append(strValueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnnotationValue lambda$static$0(AnnotationValue annotationValue) {
        return annotationValue;
    }
}
