package com.google.auto.common;

import com.google.android.gms.common.data.AbstractC4539a;
import com.google.auto.common.Overrides;
import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleElementVisitor8;
import javax.lang.model.util.Types;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public final class MoreElements {

    /* JADX INFO: renamed from: com.google.auto.common.MoreElements$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C54252 {
        static final /* synthetic */ int[] $SwitchMap$com$google$auto$common$Visibility;

        static {
            int[] iArr = new int[Visibility.values().length];
            $SwitchMap$com$google$auto$common$Visibility = iArr;
            try {
                iArr[Visibility.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$auto$common$Visibility[Visibility.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class CastingElementVisitor<T> extends SimpleElementVisitor8<T, Void> {
        private final String label;

        public CastingElementVisitor(String str) {
            this.label = str;
        }

        public final T defaultAction(Element element, Void r5) {
            String strValueOf = String.valueOf(element);
            String str = this.label;
            StringBuilder sb = new StringBuilder(AbstractC4539a.m3194d(strValueOf.length() + 22, str));
            sb.append(strValueOf);
            sb.append(" does not represent a ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ExecutableElementVisitor extends CastingElementVisitor<ExecutableElement> {
        private static final ExecutableElementVisitor INSTANCE = new ExecutableElementVisitor();

        public ExecutableElementVisitor() {
            super("executable element");
        }

        public ExecutableElement visitExecutable(ExecutableElement executableElement, Void r2) {
            return executableElement;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PackageElementVisitor extends CastingElementVisitor<PackageElement> {
        private static final PackageElementVisitor INSTANCE = new PackageElementVisitor();

        public PackageElementVisitor() {
            super("package element");
        }

        public PackageElement visitPackage(PackageElement packageElement, Void r2) {
            return packageElement;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TypeElementVisitor extends CastingElementVisitor<TypeElement> {
        private static final TypeElementVisitor INSTANCE = new TypeElementVisitor();

        public TypeElementVisitor() {
            super("type element");
        }

        public TypeElement visitType(TypeElement typeElement, Void r2) {
            return typeElement;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TypeParameterElementVisitor extends CastingElementVisitor<TypeParameterElement> {
        private static final TypeParameterElementVisitor INSTANCE = new TypeParameterElementVisitor();

        public TypeParameterElementVisitor() {
            super("type parameter element");
        }

        public TypeParameterElement visitTypeParameter(TypeParameterElement typeParameterElement, Void r2) {
            return typeParameterElement;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class VariableElementVisitor extends CastingElementVisitor<VariableElement> {
        private static final VariableElementVisitor INSTANCE = new VariableElementVisitor();

        public VariableElementVisitor() {
            super("variable element");
        }

        public VariableElement visitVariable(VariableElement variableElement, Void r2) {
            return variableElement;
        }
    }

    private MoreElements() {
    }

    public static ExecutableElement asExecutable(Element element) {
        return (ExecutableElement) element.accept(ExecutableElementVisitor.INSTANCE, (Object) null);
    }

    public static PackageElement asPackage(Element element) {
        return (PackageElement) element.accept(PackageElementVisitor.INSTANCE, (Object) null);
    }

    public static TypeElement asType(Element element) {
        return (TypeElement) element.accept(TypeElementVisitor.INSTANCE, (Object) null);
    }

    public static TypeParameterElement asTypeParameter(Element element) {
        return (TypeParameterElement) element.accept(TypeParameterElementVisitor.INSTANCE, (Object) null);
    }

    public static VariableElement asVariable(Element element) {
        return (VariableElement) element.accept(VariableElementVisitor.INSTANCE, (Object) null);
    }

    public static ImmutableSet<ExecutableElement> getAllMethods(TypeElement typeElement, Types types, Elements elements) {
        return getAllMethods(typeElement, new Overrides.ExplicitOverrides(types));
    }

    public static Optional<AnnotationMirror> getAnnotationMirror(Element element, Class<? extends Annotation> cls) {
        String canonicalName = cls.getCanonicalName();
        return canonicalName == null ? Optional.absent() : getAnnotationMirror(element, canonicalName);
    }

    @Deprecated
    public static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Elements elements) {
        return getLocalAndInheritedMethods(typeElement, new Overrides.NativeOverrides(elements));
    }

    public static PackageElement getPackage(Element element) {
        while (element.getKind() != ElementKind.PACKAGE) {
            element = element.getEnclosingElement();
        }
        return (PackageElement) element;
    }

    public static <T extends Element> Predicate<T> hasModifiers(Modifier... modifierArr) {
        return hasModifiers(ImmutableSet.copyOf(modifierArr));
    }

    public static boolean isAnnotationPresent(Element element, Class<? extends Annotation> cls) {
        return getAnnotationMirror(element, cls).isPresent();
    }

    public static boolean isType(Element element) {
        return element.getKind().isClass() || element.getKind().isInterface();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getAllMethods$0(Set set, ExecutableElement executableElement) {
        return !set.contains(executableElement);
    }

    public static boolean methodVisibleFromPackage(ExecutableElement executableElement, PackageElement packageElement) {
        int i = C54252.$SwitchMap$com$google$auto$common$Visibility[Visibility.ofElement(executableElement).ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return true;
        }
        return getPackage(executableElement).equals(packageElement);
    }

    public static boolean overrides(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement, Types types) {
        return new Overrides.ExplicitOverrides(types).overrides(executableElement, executableElement2, typeElement);
    }

    private static ImmutableSet<ExecutableElement> getAllMethods(TypeElement typeElement, Overrides overrides) {
        LinkedHashMultimap linkedHashMultimapCreate = LinkedHashMultimap.create();
        getAllMethods(typeElement, linkedHashMultimapCreate);
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = linkedHashMultimapCreate.asMap().values().iterator();
        while (it.hasNext()) {
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) it.next());
            int i = 0;
            while (i < immutableListCopyOf.size()) {
                ExecutableElement executableElement = (ExecutableElement) immutableListCopyOf.get(i);
                i++;
                int i2 = i;
                while (true) {
                    if (i2 >= immutableListCopyOf.size()) {
                        break;
                    }
                    if (overrides.overrides((ExecutableElement) immutableListCopyOf.get(i2), executableElement, typeElement)) {
                        linkedHashSet.add(executableElement);
                        break;
                    }
                    i2++;
                }
            }
        }
        return (ImmutableSet) linkedHashMultimapCreate.values().stream().filter(new java.util.function.Predicate() { // from class: com.google.auto.common.A
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MoreElements.lambda$getAllMethods$0(linkedHashSet, (ExecutableElement) obj);
            }
        }).collect(MoreStreams.toImmutableSet());
    }

    public static <T extends Element> Predicate<T> hasModifiers(final Set<Modifier> set) {
        return (Predicate<T>) new Predicate<T>() { // from class: com.google.auto.common.MoreElements.1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // com.google.common.base.Predicate
            public boolean apply(Element element) {
                return element.getModifiers().containsAll(set);
            }
        };
    }

    public static boolean isAnnotationPresent(Element element, TypeElement typeElement) {
        return getAnnotationMirror(element, typeElement).isPresent();
    }

    public static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Types types, Elements elements) {
        return getLocalAndInheritedMethods(typeElement, new Overrides.ExplicitOverrides(types));
    }

    public static boolean isAnnotationPresent(Element element, String str) {
        return getAnnotationMirror(element, str).isPresent();
    }

    public static Optional<AnnotationMirror> getAnnotationMirror(Element element, TypeElement typeElement) {
        for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
            if (annotationMirror.getAnnotationType().asElement().equals(typeElement)) {
                return Optional.m4267of(annotationMirror);
            }
        }
        return Optional.absent();
    }

    private static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Overrides overrides) {
        PackageElement packageElement = getPackage(typeElement);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<ExecutableElement> it = getAllMethods(typeElement, overrides).iterator();
        while (it.hasNext()) {
            ExecutableElement next = it.next();
            if (!next.getModifiers().contains(Modifier.STATIC) && methodVisibleFromPackage(next, packageElement)) {
                builder.add(next);
            }
        }
        return builder.build();
    }

    public static Optional<AnnotationMirror> getAnnotationMirror(Element element, String str) {
        for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
            if (asType(annotationMirror.getAnnotationType().asElement()).getQualifiedName().contentEquals(str)) {
                return Optional.m4267of(annotationMirror);
            }
        }
        return Optional.absent();
    }

    private static void getAllMethods(TypeElement typeElement, SetMultimap<String, ExecutableElement> setMultimap) {
        Iterator it = typeElement.getInterfaces().iterator();
        while (it.hasNext()) {
            getAllMethods(MoreTypes.asTypeElement((TypeMirror) it.next()), setMultimap);
        }
        if (typeElement.getSuperclass().getKind() != TypeKind.NONE) {
            getAllMethods(MoreTypes.asTypeElement(typeElement.getSuperclass()), setMultimap);
        }
        for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
            setMultimap.put(executableElement.getSimpleName().toString(), executableElement);
        }
    }
}
