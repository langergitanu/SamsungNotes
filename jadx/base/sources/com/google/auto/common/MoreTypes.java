package com.google.auto.common;

import com.google.android.gms.common.data.AbstractC4539a;
import com.google.common.base.Equivalence;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.IntersectionType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleTypeVisitor8;
import javax.lang.model.util.Types;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class MoreTypes {
    private static final int HASH_MULTIPLIER = 31;
    private static final int HASH_SEED = 17;

    /* JADX INFO: renamed from: com.google.auto.common.MoreTypes$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C54261 {
        static final /* synthetic */ int[] $SwitchMap$javax$lang$model$type$TypeKind;

        static {
            int[] iArr = new int[TypeKind.values().length];
            $SwitchMap$javax$lang$model$type$TypeKind = iArr;
            try {
                iArr[TypeKind.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.CHAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.FLOAT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.INT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.SHORT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ArrayTypeVisitor extends CastingTypeVisitor<ArrayType> {
        private static final ArrayTypeVisitor INSTANCE = new ArrayTypeVisitor();

        public ArrayTypeVisitor() {
            super("array");
        }

        public ArrayType visitArray(ArrayType arrayType, Void r2) {
            return arrayType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AsElementVisitor extends SimpleTypeVisitor8<Element, Void> {
        private static final AsElementVisitor INSTANCE = new AsElementVisitor();

        private AsElementVisitor() {
        }

        public Element defaultAction(TypeMirror typeMirror, Void r4) {
            String strValueOf = String.valueOf(typeMirror);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
            sb.append(strValueOf);
            sb.append(" cannot be converted to an Element");
            throw new IllegalArgumentException(sb.toString());
        }

        public Element visitDeclared(DeclaredType declaredType, Void r2) {
            return declaredType.asElement();
        }

        public Element visitError(ErrorType errorType, Void r2) {
            return errorType.asElement();
        }

        public Element visitTypeVariable(TypeVariable typeVariable, Void r2) {
            return typeVariable.asElement();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class CastingTypeVisitor<T> extends SimpleTypeVisitor8<T, Void> {
        private final String label;

        public CastingTypeVisitor(String str) {
            this.label = str;
        }

        public T defaultAction(TypeMirror typeMirror, Void r5) {
            String strValueOf = String.valueOf(typeMirror);
            String str = this.label;
            StringBuilder sb = new StringBuilder(AbstractC4539a.m3194d(strValueOf.length() + 22, str));
            sb.append(strValueOf);
            sb.append(" does not represent a ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CastingUncheckedVisitor extends SimpleTypeVisitor8<Boolean, Void> {
        public CastingUncheckedVisitor() {
            super(Boolean.FALSE);
        }

        private static boolean isJavaLangObject(TypeMirror typeMirror) {
            if (typeMirror.getKind() != TypeKind.DECLARED) {
                return false;
            }
            return MoreTypes.asTypeElement(typeMirror).getQualifiedName().contentEquals("java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean uncheckedTypeArgument(TypeMirror typeMirror) {
            if (typeMirror.getKind().equals(TypeKind.WILDCARD)) {
                WildcardType wildcardTypeAsWildcard = MoreTypes.asWildcard(typeMirror);
                return ((wildcardTypeAsWildcard.getExtendsBound() == null || isJavaLangObject(wildcardTypeAsWildcard.getExtendsBound())) && wildcardTypeAsWildcard.getSuperBound() == null) ? false : true;
            }
            return true;
        }

        public Boolean visitArray(ArrayType arrayType, Void r2) {
            return (Boolean) visit(arrayType.getComponentType(), r2);
        }

        public Boolean visitDeclared(DeclaredType declaredType, Void r2) {
            return Boolean.valueOf(declaredType.getTypeArguments().stream().anyMatch(new C5417F()));
        }

        public Boolean visitTypeVariable(TypeVariable typeVariable, Void r2) {
            return Boolean.TRUE;
        }

        public Boolean visitUnknown(TypeMirror typeMirror, Void r2) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ComparedElements {

        /* JADX INFO: renamed from: a */
        final Element f3276a;
        final ImmutableList<TypeMirror> aArguments;

        /* JADX INFO: renamed from: b */
        final Element f3277b;
        final ImmutableList<TypeMirror> bArguments;

        public ComparedElements(Element element, ImmutableList<TypeMirror> immutableList, Element element2, ImmutableList<TypeMirror> immutableList2) {
            this.f3276a = element;
            this.aArguments = immutableList;
            this.f3277b = element2;
            this.bArguments = immutableList2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ComparedElements) {
                ComparedElements comparedElements = (ComparedElements) obj;
                int size = this.aArguments.size();
                if (this.f3276a.equals(comparedElements.f3276a) && this.f3277b.equals(comparedElements.f3277b) && size == this.bArguments.size()) {
                    for (int i = 0; i < size; i++) {
                        if (this.aArguments.get(i) != this.bArguments.get(i)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f3276a.hashCode() * 31) + this.f3277b.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DeclaredTypeVisitor extends CastingTypeVisitor<DeclaredType> {
        private static final DeclaredTypeVisitor INSTANCE = new DeclaredTypeVisitor();

        public DeclaredTypeVisitor() {
            super("declared type");
        }

        public DeclaredType visitDeclared(DeclaredType declaredType, Void r2) {
            return declaredType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class EqualVisitor extends SimpleTypeVisitor8<Boolean, EqualVisitorParam> {
        private static final EqualVisitor INSTANCE = new EqualVisitor();

        private EqualVisitor() {
        }

        private Set<ComparedElements> visitingSetPlus(Set<ComparedElements> set, Element element, Element element2) {
            ImmutableList immutableListM4302of = ImmutableList.m4302of();
            return visitingSetPlus(set, element, immutableListM4302of, element2, immutableListM4302of);
        }

        public Boolean defaultAction(TypeMirror typeMirror, EqualVisitorParam equalVisitorParam) {
            return Boolean.valueOf(typeMirror.getKind().equals(equalVisitorParam.type.getKind()));
        }

        public Boolean visitArray(ArrayType arrayType, EqualVisitorParam equalVisitorParam) {
            if (!equalVisitorParam.type.getKind().equals(TypeKind.ARRAY)) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(MoreTypes.equal(arrayType.getComponentType(), equalVisitorParam.type.getComponentType(), equalVisitorParam.visiting));
        }

        public Boolean visitDeclared(DeclaredType declaredType, EqualVisitorParam equalVisitorParam) {
            if (!equalVisitorParam.type.getKind().equals(TypeKind.DECLARED)) {
                return Boolean.FALSE;
            }
            DeclaredType declaredType2 = equalVisitorParam.type;
            Element elementAsElement = declaredType.asElement();
            Element elementAsElement2 = declaredType2.asElement();
            Set<ComparedElements> setVisitingSetPlus = visitingSetPlus(equalVisitorParam.visiting, elementAsElement, declaredType.getTypeArguments(), elementAsElement2, declaredType2.getTypeArguments());
            if (setVisitingSetPlus.equals(equalVisitorParam.visiting)) {
                return Boolean.TRUE;
            }
            return Boolean.valueOf(elementAsElement.equals(elementAsElement2) && MoreTypes.equal(MoreTypes.enclosingType(declaredType), MoreTypes.enclosingType(declaredType2), setVisitingSetPlus) && MoreTypes.equalLists(declaredType.getTypeArguments(), declaredType2.getTypeArguments(), setVisitingSetPlus));
        }

        public Boolean visitError(ErrorType errorType, EqualVisitorParam equalVisitorParam) {
            return Boolean.valueOf(errorType.equals(equalVisitorParam.type));
        }

        public Boolean visitExecutable(ExecutableType executableType, EqualVisitorParam equalVisitorParam) {
            if (!equalVisitorParam.type.getKind().equals(TypeKind.EXECUTABLE)) {
                return Boolean.FALSE;
            }
            ExecutableType executableType2 = equalVisitorParam.type;
            return Boolean.valueOf(MoreTypes.equalLists(executableType.getParameterTypes(), executableType2.getParameterTypes(), equalVisitorParam.visiting) && MoreTypes.equal(executableType.getReturnType(), executableType2.getReturnType(), equalVisitorParam.visiting) && MoreTypes.equalLists(executableType.getThrownTypes(), executableType2.getThrownTypes(), equalVisitorParam.visiting) && MoreTypes.equalLists(executableType.getTypeVariables(), executableType2.getTypeVariables(), equalVisitorParam.visiting));
        }

        public Boolean visitIntersection(IntersectionType intersectionType, EqualVisitorParam equalVisitorParam) {
            if (!equalVisitorParam.type.getKind().equals(TypeKind.INTERSECTION)) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(MoreTypes.equalLists(intersectionType.getBounds(), equalVisitorParam.type.getBounds(), equalVisitorParam.visiting));
        }

        public Boolean visitTypeVariable(TypeVariable typeVariable, EqualVisitorParam equalVisitorParam) {
            if (!equalVisitorParam.type.getKind().equals(TypeKind.TYPEVAR)) {
                return Boolean.FALSE;
            }
            TypeVariable typeVariable2 = equalVisitorParam.type;
            TypeParameterElement typeParameterElementAsElement = typeVariable.asElement();
            TypeParameterElement typeParameterElementAsElement2 = typeVariable2.asElement();
            Set<ComparedElements> setVisitingSetPlus = visitingSetPlus(equalVisitorParam.visiting, typeParameterElementAsElement, typeParameterElementAsElement2);
            if (setVisitingSetPlus.equals(equalVisitorParam.visiting)) {
                return Boolean.TRUE;
            }
            return Boolean.valueOf(MoreTypes.equalLists(typeParameterElementAsElement.getBounds(), typeParameterElementAsElement2.getBounds(), setVisitingSetPlus) && MoreTypes.equal(typeVariable.getLowerBound(), typeVariable2.getLowerBound(), setVisitingSetPlus) && typeVariable.asElement().getSimpleName().equals(typeVariable2.asElement().getSimpleName()));
        }

        public Boolean visitUnknown(TypeMirror typeMirror, EqualVisitorParam equalVisitorParam) {
            throw new UnsupportedOperationException();
        }

        public Boolean visitWildcard(WildcardType wildcardType, EqualVisitorParam equalVisitorParam) {
            if (!equalVisitorParam.type.getKind().equals(TypeKind.WILDCARD)) {
                return Boolean.FALSE;
            }
            WildcardType wildcardType2 = equalVisitorParam.type;
            return Boolean.valueOf(MoreTypes.equal(wildcardType.getExtendsBound(), wildcardType2.getExtendsBound(), equalVisitorParam.visiting) && MoreTypes.equal(wildcardType.getSuperBound(), wildcardType2.getSuperBound(), equalVisitorParam.visiting));
        }

        private Set<ComparedElements> visitingSetPlus(Set<ComparedElements> set, Element element, List<? extends TypeMirror> list, Element element2, List<? extends TypeMirror> list2) {
            ComparedElements comparedElements = new ComparedElements(element, ImmutableList.copyOf((Collection) list), element2, ImmutableList.copyOf((Collection) list2));
            HashSet hashSet = new HashSet(set);
            hashSet.add(comparedElements);
            return hashSet;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class EqualVisitorParam {
        TypeMirror type;
        Set<ComparedElements> visiting;

        private EqualVisitorParam() {
        }

        public /* synthetic */ EqualVisitorParam(C54261 c54261) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ErrorTypeVisitor extends CastingTypeVisitor<ErrorType> {
        private static final ErrorTypeVisitor INSTANCE = new ErrorTypeVisitor();

        public ErrorTypeVisitor() {
            super("error type");
        }

        public ErrorType visitError(ErrorType errorType, Void r2) {
            return errorType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ExecutableTypeVisitor extends CastingTypeVisitor<ExecutableType> {
        private static final ExecutableTypeVisitor INSTANCE = new ExecutableTypeVisitor();

        public ExecutableTypeVisitor() {
            super("executable type");
        }

        public ExecutableType visitExecutable(ExecutableType executableType, Void r2) {
            return executableType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HashVisitor extends SimpleTypeVisitor8<Integer, Set<Element>> {
        private static final HashVisitor INSTANCE = new HashVisitor();

        private HashVisitor() {
        }

        public int hashKind(int i, TypeMirror typeMirror) {
            return (i * 31) + typeMirror.getKind().hashCode();
        }

        public Integer defaultAction(TypeMirror typeMirror, Set<Element> set) {
            return Integer.valueOf(hashKind(17, typeMirror));
        }

        public Integer visitArray(ArrayType arrayType, Set<Element> set) {
            return Integer.valueOf(((Integer) arrayType.getComponentType().accept(this, set)).intValue() + (hashKind(17, arrayType) * 31));
        }

        public Integer visitDeclared(DeclaredType declaredType, Set<Element> set) {
            Element elementAsElement = declaredType.asElement();
            if (set.contains(elementAsElement)) {
                return 0;
            }
            HashSet hashSet = new HashSet(set);
            hashSet.add(elementAsElement);
            return Integer.valueOf(MoreTypes.hashList(declaredType.getTypeArguments(), hashSet) + ((((Integer) declaredType.getEnclosingType().accept(this, hashSet)).intValue() + (((hashKind(17, declaredType) * 31) + declaredType.asElement().hashCode()) * 31)) * 31));
        }

        public Integer visitExecutable(ExecutableType executableType, Set<Element> set) {
            return Integer.valueOf(MoreTypes.hashList(executableType.getTypeVariables(), set) + ((MoreTypes.hashList(executableType.getThrownTypes(), set) + ((((Integer) executableType.getReturnType().accept(this, set)).intValue() + ((MoreTypes.hashList(executableType.getParameterTypes(), set) + (hashKind(17, executableType) * 31)) * 31)) * 31)) * 31));
        }

        public Integer visitTypeVariable(TypeVariable typeVariable, Set<Element> set) {
            int iIntValue = ((Integer) typeVariable.getLowerBound().accept(this, set)).intValue() + (hashKind(17, typeVariable) * 31);
            Iterator it = typeVariable.asElement().getBounds().iterator();
            while (it.hasNext()) {
                iIntValue = (iIntValue * 31) + ((Integer) ((TypeMirror) it.next()).accept(this, set)).intValue();
            }
            return Integer.valueOf(iIntValue);
        }

        public Integer visitUnknown(TypeMirror typeMirror, Set<Element> set) {
            throw new UnsupportedOperationException();
        }

        public Integer visitWildcard(WildcardType wildcardType, Set<Element> set) {
            return Integer.valueOf((((hashKind(17, wildcardType) * 31) + (wildcardType.getExtendsBound() == null ? 0 : ((Integer) wildcardType.getExtendsBound().accept(this, set)).intValue())) * 31) + (wildcardType.getSuperBound() != null ? ((Integer) wildcardType.getSuperBound().accept(this, set)).intValue() : 0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class IntersectionTypeVisitor extends CastingTypeVisitor<IntersectionType> {
        private static final IntersectionTypeVisitor INSTANCE = new IntersectionTypeVisitor();

        public IntersectionTypeVisitor() {
            super("intersection type");
        }

        public IntersectionType visitIntersection(IntersectionType intersectionType, Void r2) {
            return intersectionType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class IsTypeOf extends SimpleTypeVisitor8<Boolean, Void> {
        private final Class<?> clazz;

        public IsTypeOf(Class<?> cls) {
            this.clazz = cls;
        }

        public Boolean defaultAction(TypeMirror typeMirror, Void r4) {
            String strValueOf = String.valueOf(typeMirror);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 37);
            sb.append(strValueOf);
            sb.append(" cannot be represented as a Class<?>.");
            throw new IllegalArgumentException(sb.toString());
        }

        public Boolean visitArray(ArrayType arrayType, Void r2) {
            return Boolean.valueOf(this.clazz.isArray() && MoreTypes.isTypeOf(this.clazz.getComponentType(), arrayType.getComponentType()));
        }

        public Boolean visitDeclared(DeclaredType declaredType, Void r2) {
            return Boolean.valueOf(MoreElements.asType(declaredType.asElement()).getQualifiedName().contentEquals(this.clazz.getCanonicalName()));
        }

        public Boolean visitError(ErrorType errorType, Void r2) {
            return Boolean.FALSE;
        }

        public Boolean visitNoType(NoType noType, Void r4) {
            if (noType.getKind().equals(TypeKind.VOID)) {
                return Boolean.valueOf(this.clazz.equals(Void.TYPE));
            }
            String strValueOf = String.valueOf(noType);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 37);
            sb.append(strValueOf);
            sb.append(" cannot be represented as a Class<?>.");
            throw new IllegalArgumentException(sb.toString());
        }

        public Boolean visitPrimitive(PrimitiveType primitiveType, Void r4) {
            switch (C54261.$SwitchMap$javax$lang$model$type$TypeKind[primitiveType.getKind().ordinal()]) {
                case 1:
                    return Boolean.valueOf(this.clazz.equals(Boolean.TYPE));
                case 2:
                    return Boolean.valueOf(this.clazz.equals(Byte.TYPE));
                case 3:
                    return Boolean.valueOf(this.clazz.equals(Character.TYPE));
                case 4:
                    return Boolean.valueOf(this.clazz.equals(Double.TYPE));
                case 5:
                    return Boolean.valueOf(this.clazz.equals(Float.TYPE));
                case 6:
                    return Boolean.valueOf(this.clazz.equals(Integer.TYPE));
                case 7:
                    return Boolean.valueOf(this.clazz.equals(Long.TYPE));
                case 8:
                    return Boolean.valueOf(this.clazz.equals(Short.TYPE));
                default:
                    String strValueOf = String.valueOf(primitiveType);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 37);
                    sb.append(strValueOf);
                    sb.append(" cannot be represented as a Class<?>.");
                    throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class IsTypeVisitor extends SimpleTypeVisitor8<Boolean, Void> {
        private static final IsTypeVisitor INSTANCE = new IsTypeVisitor();

        private IsTypeVisitor() {
        }

        public Boolean defaultAction(TypeMirror typeMirror, Void r2) {
            return Boolean.FALSE;
        }

        public Boolean visitArray(ArrayType arrayType, Void r2) {
            return Boolean.TRUE;
        }

        public Boolean visitDeclared(DeclaredType declaredType, Void r2) {
            return Boolean.valueOf(MoreElements.isType(declaredType.asElement()));
        }

        public Boolean visitNoType(NoType noType, Void r2) {
            return Boolean.valueOf(noType.getKind().equals(TypeKind.VOID));
        }

        public Boolean visitPrimitive(PrimitiveType primitiveType, Void r2) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NoTypeVisitor extends CastingTypeVisitor<NoType> {
        private static final NoTypeVisitor INSTANCE = new NoTypeVisitor();

        public NoTypeVisitor() {
            super("non-type");
        }

        public NoType visitNoType(NoType noType, Void r2) {
            return noType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NullTypeVisitor extends CastingTypeVisitor<NullType> {
        private static final NullTypeVisitor INSTANCE = new NullTypeVisitor();

        public NullTypeVisitor() {
            super("null");
        }

        public NullType visitNull(NullType nullType, Void r2) {
            return nullType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PrimitiveTypeVisitor extends CastingTypeVisitor<PrimitiveType> {
        private static final PrimitiveTypeVisitor INSTANCE = new PrimitiveTypeVisitor();

        public PrimitiveTypeVisitor() {
            super("primitive type");
        }

        public PrimitiveType visitPrimitive(PrimitiveType primitiveType, Void r2) {
            return primitiveType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ReferencedTypes extends SimpleTypeVisitor8<Void, ImmutableSet.Builder<TypeElement>> {
        private static final ReferencedTypes INSTANCE = new ReferencedTypes();

        private ReferencedTypes() {
        }

        public Void visitArray(ArrayType arrayType, ImmutableSet.Builder<TypeElement> builder) {
            arrayType.getComponentType().accept(this, builder);
            return null;
        }

        public Void visitDeclared(DeclaredType declaredType, ImmutableSet.Builder<TypeElement> builder) {
            builder.add(MoreElements.asType(declaredType.asElement()));
            Iterator it = declaredType.getTypeArguments().iterator();
            while (it.hasNext()) {
                ((TypeMirror) it.next()).accept(this, builder);
            }
            return null;
        }

        public Void visitTypeVariable(TypeVariable typeVariable, ImmutableSet.Builder<TypeElement> builder) {
            typeVariable.getLowerBound().accept(this, builder);
            typeVariable.getUpperBound().accept(this, builder);
            return null;
        }

        public Void visitWildcard(WildcardType wildcardType, ImmutableSet.Builder<TypeElement> builder) {
            TypeMirror extendsBound = wildcardType.getExtendsBound();
            if (extendsBound != null) {
                extendsBound.accept(this, builder);
            }
            TypeMirror superBound = wildcardType.getSuperBound();
            if (superBound == null) {
                return null;
            }
            superBound.accept(this, builder);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TypeEquivalence extends Equivalence<TypeMirror> {
        private static final TypeEquivalence INSTANCE = new TypeEquivalence();

        private TypeEquivalence() {
        }

        public String toString() {
            return "MoreTypes.equivalence()";
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(TypeMirror typeMirror, TypeMirror typeMirror2) {
            return MoreTypes.equal(typeMirror, typeMirror2, ImmutableSet.m4349of());
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(TypeMirror typeMirror) {
            return MoreTypes.hash(typeMirror, ImmutableSet.m4349of());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TypeVariableVisitor extends CastingTypeVisitor<TypeVariable> {
        private static final TypeVariableVisitor INSTANCE = new TypeVariableVisitor();

        public TypeVariableVisitor() {
            super("type variable");
        }

        public TypeVariable visitTypeVariable(TypeVariable typeVariable, Void r2) {
            return typeVariable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class WildcardTypeVisitor extends CastingTypeVisitor<WildcardType> {
        private static final WildcardTypeVisitor INSTANCE = new WildcardTypeVisitor();

        public WildcardTypeVisitor() {
            super("wildcard type");
        }

        public WildcardType visitWildcard(WildcardType wildcardType, Void r2) {
            return wildcardType;
        }
    }

    private MoreTypes() {
    }

    public static ArrayType asArray(TypeMirror typeMirror) {
        return (ArrayType) typeMirror.accept(ArrayTypeVisitor.INSTANCE, (Object) null);
    }

    public static DeclaredType asDeclared(TypeMirror typeMirror) {
        return (DeclaredType) typeMirror.accept(DeclaredTypeVisitor.INSTANCE, (Object) null);
    }

    public static Element asElement(TypeMirror typeMirror) {
        return (Element) typeMirror.accept(AsElementVisitor.INSTANCE, (Object) null);
    }

    public static ErrorType asError(TypeMirror typeMirror) {
        return (ErrorType) typeMirror.accept(ErrorTypeVisitor.INSTANCE, (Object) null);
    }

    public static ExecutableType asExecutable(TypeMirror typeMirror) {
        return (ExecutableType) typeMirror.accept(ExecutableTypeVisitor.INSTANCE, (Object) null);
    }

    public static IntersectionType asIntersection(TypeMirror typeMirror) {
        return (IntersectionType) typeMirror.accept(IntersectionTypeVisitor.INSTANCE, (Object) null);
    }

    public static TypeMirror asMemberOf(Types types, DeclaredType declaredType, VariableElement variableElement) {
        if (!variableElement.getKind().equals(ElementKind.PARAMETER)) {
            return types.asMemberOf(declaredType, variableElement);
        }
        ExecutableElement executableElementAsExecutable = MoreElements.asExecutable(variableElement.getEnclosingElement());
        ExecutableType executableTypeAsExecutable = asExecutable(types.asMemberOf(declaredType, executableElementAsExecutable));
        List parameters = executableElementAsExecutable.getParameters();
        List parameterTypes = executableTypeAsExecutable.getParameterTypes();
        Preconditions.checkState(parameters.size() == parameterTypes.size());
        for (int i = 0; i < parameters.size(); i++) {
            if (((VariableElement) parameters.get(i)).equals(variableElement)) {
                return (TypeMirror) parameterTypes.get(i);
            }
        }
        String strValueOf = String.valueOf(variableElement);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
        sb.append("Could not find variable: ");
        sb.append(strValueOf);
        throw new IllegalStateException(sb.toString());
    }

    public static NoType asNoType(TypeMirror typeMirror) {
        return (NoType) typeMirror.accept(NoTypeVisitor.INSTANCE, (Object) null);
    }

    public static NullType asNullType(TypeMirror typeMirror) {
        return (NullType) typeMirror.accept(NullTypeVisitor.INSTANCE, (Object) null);
    }

    public static PrimitiveType asPrimitiveType(TypeMirror typeMirror) {
        return (PrimitiveType) typeMirror.accept(PrimitiveTypeVisitor.INSTANCE, (Object) null);
    }

    public static TypeElement asTypeElement(TypeMirror typeMirror) {
        return MoreElements.asType(asElement(typeMirror));
    }

    public static ImmutableSet<TypeElement> asTypeElements(Iterable<? extends TypeMirror> iterable) {
        Preconditions.checkNotNull(iterable);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        Iterator<? extends TypeMirror> it = iterable.iterator();
        while (it.hasNext()) {
            builder.add(asTypeElement(it.next()));
        }
        return builder.build();
    }

    public static TypeVariable asTypeVariable(TypeMirror typeMirror) {
        return (TypeVariable) typeMirror.accept(TypeVariableVisitor.INSTANCE, (Object) null);
    }

    public static WildcardType asWildcard(TypeMirror typeMirror) {
        return (WildcardType) typeMirror.accept(WildcardTypeVisitor.INSTANCE, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TypeMirror enclosingType(DeclaredType declaredType) {
        TypeMirror enclosingType = declaredType.getEnclosingType();
        if (enclosingType.getKind().equals(TypeKind.NONE) || declaredType.asElement().getModifiers().contains(Modifier.STATIC)) {
            return null;
        }
        return enclosingType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equal(TypeMirror typeMirror, TypeMirror typeMirror2, Set<ComparedElements> set) {
        if (typeMirror == typeMirror2) {
            return true;
        }
        if (typeMirror == null || typeMirror2 == null) {
            return false;
        }
        if (typeMirror.equals(typeMirror2) && !(typeMirror instanceof ExecutableType)) {
            return true;
        }
        EqualVisitorParam equalVisitorParam = new EqualVisitorParam(null);
        equalVisitorParam.type = typeMirror2;
        equalVisitorParam.visiting = set;
        return ((Boolean) typeMirror.accept(EqualVisitor.INSTANCE, equalVisitorParam)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalLists(List<? extends TypeMirror> list, List<? extends TypeMirror> list2, Set<ComparedElements> set) {
        if (list.size() != list2.size()) {
            return false;
        }
        Iterator<? extends TypeMirror> it = list.iterator();
        Iterator<? extends TypeMirror> it2 = list2.iterator();
        while (it.hasNext()) {
            if (!equal(it.next(), it2.next(), set)) {
                return false;
            }
        }
        return true;
    }

    public static Equivalence<TypeMirror> equivalence() {
        return TypeEquivalence.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hash(TypeMirror typeMirror, Set<Element> set) {
        if (typeMirror == null) {
            return 0;
        }
        return ((Integer) typeMirror.accept(HashVisitor.INSTANCE, set)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashList(List<? extends TypeMirror> list, Set<Element> set) {
        Iterator<? extends TypeMirror> it = list.iterator();
        int iHash = 17;
        while (it.hasNext()) {
            iHash = (iHash * 31) + hash(it.next(), set);
        }
        return iHash;
    }

    public static boolean isConversionFromObjectUnchecked(TypeMirror typeMirror) {
        return ((Boolean) new CastingUncheckedVisitor().visit(typeMirror, null)).booleanValue();
    }

    private static boolean isObjectType(DeclaredType declaredType) {
        return asTypeElement(declaredType).getQualifiedName().contentEquals("java.lang.Object");
    }

    public static boolean isType(TypeMirror typeMirror) {
        return ((Boolean) typeMirror.accept(IsTypeVisitor.INSTANCE, (Object) null)).booleanValue();
    }

    public static boolean isTypeOf(Class<?> cls, TypeMirror typeMirror) {
        Preconditions.checkNotNull(cls);
        return ((Boolean) typeMirror.accept(new IsTypeOf(cls), (Object) null)).booleanValue();
    }

    public static Optional<DeclaredType> nonObjectSuperclass(Types types, Elements elements, DeclaredType declaredType) {
        Preconditions.checkNotNull(types);
        Preconditions.checkNotNull(elements);
        Preconditions.checkNotNull(declaredType);
        TypeMirror superclass = asTypeElement(declaredType).getSuperclass();
        if (!isType(superclass)) {
            return Optional.absent();
        }
        DeclaredType declaredTypeAsDeclared = asDeclared(superclass);
        return isObjectType(declaredTypeAsDeclared) ? Optional.absent() : declaredTypeAsDeclared.getTypeArguments().isEmpty() ? Optional.m4267of(declaredTypeAsDeclared) : Optional.m4267of(asDeclared((TypeMirror) types.directSupertypes(declaredType).get(0)));
    }

    public static ImmutableSet<TypeElement> referencedTypes(TypeMirror typeMirror) {
        Preconditions.checkNotNull(typeMirror);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        typeMirror.accept(ReferencedTypes.INSTANCE, builder);
        return builder.build();
    }
}
