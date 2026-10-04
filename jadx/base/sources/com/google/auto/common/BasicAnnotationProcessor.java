package com.google.auto.common;

import androidx.collection.AbstractC0622a;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleElementVisitor8;
import javax.tools.Diagnostic;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BasicAnnotationProcessor extends AbstractProcessor {
    private Elements elements;
    private Messager messager;
    private ImmutableList<? extends Step> steps;
    private final Set<ElementName> deferredElementNames = new LinkedHashSet();
    private final SetMultimap<Step, ElementName> elementsDeferredBySteps = LinkedHashMultimap.create();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ElementName {
        private final Kind kind;
        private final String name;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public enum Kind {
            PACKAGE_NAME,
            TYPE_NAME
        }

        private ElementName(Kind kind, Name name) {
            this.kind = (Kind) Preconditions.checkNotNull(kind);
            this.name = name.toString();
        }

        public static ElementName forAnnotatedElement(Element element) {
            return element.getKind() == ElementKind.PACKAGE ? new ElementName(Kind.PACKAGE_NAME, MoreElements.asPackage(element).getQualifiedName()) : new ElementName(Kind.TYPE_NAME, BasicAnnotationProcessor.getEnclosingType(element).getQualifiedName());
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ElementName)) {
                return false;
            }
            ElementName elementName = (ElementName) obj;
            return this.kind == elementName.kind && this.name.equals(elementName.name);
        }

        public Optional<? extends Element> getElement(Elements elements) {
            return Optional.fromNullable(this.kind == Kind.PACKAGE_NAME ? elements.getPackageElement(this.name) : elements.getTypeElement(this.name));
        }

        public int hashCode() {
            return Objects.hash(this.kind, this.name);
        }

        public String name() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public interface ProcessingStep {
        Set<? extends Class<? extends Annotation>> annotations();

        Set<? extends Element> process(SetMultimap<Class<? extends Annotation>, Element> setMultimap);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Step {
        Set<String> annotations();

        Set<? extends Element> process(ImmutableSetMultimap<String, Element> immutableSetMultimap);
    }

    public static Step asStep(ProcessingStep processingStep) {
        return new ProcessingStepAsStep(processingStep);
    }

    private static void findAnnotatedElements(Element element, ImmutableSet<TypeElement> immutableSet, ImmutableSetMultimap.Builder<TypeElement, Element> builder) {
        for (Element element2 : element.getEnclosedElements()) {
            if (!element2.getKind().isClass() && !element2.getKind().isInterface()) {
                findAnnotatedElements(element2, immutableSet, builder);
            }
        }
        if (element instanceof ExecutableElement) {
            Iterator it = MoreElements.asExecutable(element).getParameters().iterator();
            while (it.hasNext()) {
                findAnnotatedElements((Element) it.next(), immutableSet, builder);
            }
        }
        UnmodifiableIterator<TypeElement> it2 = immutableSet.iterator();
        while (it2.hasNext()) {
            TypeElement next = it2.next();
            if (isAnnotationPresent(element, next)) {
                builder.put(next, element);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TypeElement getEnclosingType(Element element) {
        return (TypeElement) element.accept(new SimpleElementVisitor8<TypeElement, Void>() { // from class: com.google.auto.common.BasicAnnotationProcessor.1
            public TypeElement visitType(TypeElement typeElement, Void r2) {
                return typeElement;
            }

            public TypeElement defaultAction(Element element2, Void r2) {
                return (TypeElement) element2.getEnclosingElement().accept(this, r2);
            }

            public TypeElement visitPackage(PackageElement packageElement, Void r2) {
                throw new IllegalArgumentException();
            }
        }, (Object) null);
    }

    private ImmutableSet<TypeElement> getSupportedAnnotationTypeElements() {
        Preconditions.checkState(this.steps != null);
        return (ImmutableSet) this.steps.stream().flatMap(new C5454x(this, 2)).collect(MoreStreams.toImmutableSet());
    }

    private ImmutableSetMultimap<TypeElement, Element> indexByAnnotation(Set<ElementName> set, ImmutableSet<TypeElement> immutableSet) {
        ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
        Iterator<ElementName> it = set.iterator();
        while (it.hasNext()) {
            Optional<? extends Element> element = it.next().getElement(this.elements);
            if (element.isPresent()) {
                findAnnotatedElements(element.get(), immutableSet, builder);
            }
        }
        return builder.build();
    }

    private static boolean isAnnotationPresent(Element element, final TypeElement typeElement) {
        return element.getAnnotationMirrors().stream().anyMatch(new Predicate() { // from class: com.google.auto.common.u
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return BasicAnnotationProcessor.lambda$isAnnotationPresent$2(typeElement, (AnnotationMirror) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Stream lambda$getSupportedAnnotationTypeElements$0(Step step) {
        return getSupportedAnnotationTypeElements(step).stream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$getSupportedAnnotationTypes$1(Step step) {
        return step.annotations().stream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isAnnotationPresent$2(TypeElement typeElement, AnnotationMirror annotationMirror) {
        return MoreTypes.asTypeElement(annotationMirror.getAnnotationType()).equals(typeElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toClassNameKeyedMultimap$3(ImmutableSetMultimap.Builder builder, TypeElement typeElement, Collection collection) {
        builder.putAll(typeElement.getQualifiedName().toString(), (Iterable) collection);
    }

    private String processingErrorMessage(String str) {
        return AbstractC0622a.m1170p(str, " because not all of its dependencies could be resolved. Check for compilation errors or a circular dependency with generated code.", AbstractC0000a.m16m("[", getClass().getSimpleName(), ":MiscError] ", getClass().getCanonicalName(), " was unable to process "));
    }

    private void reportMissingElements(Set<ElementName> set) {
        for (ElementName elementName : set) {
            Optional<? extends Element> element = elementName.getElement(this.elements);
            if (element.isPresent()) {
                Messager messager = this.messager;
                Diagnostic.Kind kind = Diagnostic.Kind.ERROR;
                String strValueOf = String.valueOf(Ascii.toLowerCase(element.get().getKind().name()));
                messager.printMessage(kind, processingErrorMessage(strValueOf.length() != 0 ? "this ".concat(strValueOf) : new String("this ")), element.get());
            } else {
                this.messager.printMessage(Diagnostic.Kind.ERROR, processingErrorMessage(elementName.name()));
            }
        }
    }

    private static ImmutableSetMultimap<String, Element> toClassNameKeyedMultimap(SetMultimap<TypeElement, Element> setMultimap) {
        final ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
        setMultimap.asMap().forEach(new BiConsumer() { // from class: com.google.auto.common.s
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                BasicAnnotationProcessor.lambda$toClassNameKeyedMultimap$3(builder, (TypeElement) obj, (Collection) obj2);
            }
        });
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<TypeElement, Element> validElements(RoundEnvironment roundEnvironment) {
        ImmutableSet immutableSetCopyOf = ImmutableSet.copyOf((Collection) this.deferredElementNames);
        this.deferredElementNames.clear();
        ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
        UnmodifiableIterator it = immutableSetCopyOf.iterator();
        while (it.hasNext()) {
            ElementName elementName = (ElementName) it.next();
            Optional<? extends Element> element = elementName.getElement(this.elements);
            if (element.isPresent()) {
                findAnnotatedElements(element.get(), getSupportedAnnotationTypeElements(), builder);
            } else {
                this.deferredElementNames.add(elementName);
            }
        }
        ImmutableSetMultimap immutableSetMultimapBuild = builder.build();
        ImmutableSetMultimap.Builder builder2 = ImmutableSetMultimap.builder();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        UnmodifiableIterator<TypeElement> it2 = getSupportedAnnotationTypeElements().iterator();
        while (it2.hasNext()) {
            TypeElement next = it2.next();
            UnmodifiableIterator it3 = Sets.union(roundEnvironment.getElementsAnnotatedWith(next), immutableSetMultimapBuild.get(next)).iterator();
            while (it3.hasNext()) {
                Element element2 = (Element) it3.next();
                ElementName elementNameForAnnotatedElement = ElementName.forAnnotatedElement(element2);
                if (!linkedHashSet.contains(elementNameForAnnotatedElement)) {
                    if (!this.deferredElementNames.contains(elementNameForAnnotatedElement)) {
                        if (SuperficialValidation.validateElement(element2.getKind().equals(ElementKind.PACKAGE) ? element2 : getEnclosingType(element2))) {
                        }
                    }
                    this.deferredElementNames.add(elementNameForAnnotatedElement);
                }
                builder2.put(next, element2);
                linkedHashSet.add(elementNameForAnnotatedElement);
            }
        }
        return builder2.build();
    }

    public final synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        this.elements = processingEnvironment.getElementUtils();
        this.messager = processingEnvironment.getMessager();
        this.steps = ImmutableList.copyOf(steps());
    }

    @Deprecated
    public Iterable<? extends ProcessingStep> initSteps() {
        throw new AssertionError("If steps() is not implemented, initSteps() must be.");
    }

    public void postRound(RoundEnvironment roundEnvironment) {
        if (roundEnvironment.processingOver()) {
            return;
        }
        postProcess();
    }

    public final boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Preconditions.checkState(this.elements != null);
        Preconditions.checkState(this.messager != null);
        Preconditions.checkState(this.steps != null);
        if (!roundEnvironment.processingOver()) {
            process(validElements(roundEnvironment));
            postRound(roundEnvironment);
            return false;
        }
        postRound(roundEnvironment);
        if (!roundEnvironment.errorRaised()) {
            reportMissingElements(ImmutableSet.builder().addAll((Iterable) this.deferredElementNames).addAll((Iterable) this.elementsDeferredBySteps.values()).build());
        }
        return false;
    }

    public Iterable<? extends Step> steps() {
        return Iterables.transform(initSteps(), new C5448r());
    }

    /* JADX INFO: renamed from: getSupportedAnnotationTypes, reason: merged with bridge method [inline-methods] */
    public final ImmutableSet<String> m22113getSupportedAnnotationTypes() {
        Preconditions.checkState(this.steps != null);
        return (ImmutableSet) this.steps.stream().flatMap(new C5452v(2)).collect(MoreStreams.toImmutableSet());
    }

    private ImmutableSet<TypeElement> getSupportedAnnotationTypeElements(Step step) {
        Stream<String> stream = step.annotations().stream();
        final Elements elements = this.elements;
        Objects.requireNonNull(elements);
        return (ImmutableSet) stream.map(new Function() { // from class: com.google.auto.common.p
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return elements.getTypeElement((String) obj);
            }
        }).filter(new C5447q()).collect(MoreStreams.toImmutableSet());
    }

    private void process(ImmutableSetMultimap<TypeElement, Element> immutableSetMultimap) {
        UnmodifiableIterator<? extends Step> it = this.steps.iterator();
        while (it.hasNext()) {
            Step next = it.next();
            ImmutableSet<TypeElement> supportedAnnotationTypeElements = getSupportedAnnotationTypeElements(next);
            ImmutableSetMultimap immutableSetMultimapBuild = new ImmutableSetMultimap.Builder().putAll((Multimap) indexByAnnotation(this.elementsDeferredBySteps.get(next), supportedAnnotationTypeElements)).putAll((Multimap) Multimaps.filterKeys((SetMultimap) immutableSetMultimap, Predicates.m4268in(supportedAnnotationTypeElements))).build();
            if (immutableSetMultimapBuild.isEmpty()) {
                this.elementsDeferredBySteps.removeAll((Object) next);
            } else {
                this.elementsDeferredBySteps.replaceValues(next, Iterables.transform(next.process(toClassNameKeyedMultimap(immutableSetMultimapBuild)), new C5450t()));
            }
        }
    }

    @Deprecated
    public void postProcess() {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ProcessingStepAsStep implements Step {
        private final ImmutableMap<String, Class<? extends Annotation>> annotationsByName;
        private final ProcessingStep processingStep;

        public ProcessingStepAsStep(ProcessingStep processingStep) {
            this.processingStep = processingStep;
            this.annotationsByName = (ImmutableMap) processingStep.annotations().stream().collect(MoreStreams.toImmutableMap(new C5452v(0), new C5452v(1)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$new$0(Class cls) {
            String canonicalName = cls.getCanonicalName();
            Objects.requireNonNull(canonicalName);
            return canonicalName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$toClassKeyedMultimap$2(ImmutableSetMultimap.Builder builder, String str, Collection collection) {
            Class<? extends Annotation> cls = this.annotationsByName.get(str);
            if (cls != null) {
                builder.putAll(cls, (Iterable) collection);
            }
        }

        private ImmutableSetMultimap<Class<? extends Annotation>, Element> toClassKeyedMultimap(SetMultimap<String, Element> setMultimap) {
            final ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
            setMultimap.asMap().forEach(new BiConsumer() { // from class: com.google.auto.common.w
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f3284a.lambda$toClassKeyedMultimap$2(builder, (String) obj, (Collection) obj2);
                }
            });
            return builder.build();
        }

        @Override // com.google.auto.common.BasicAnnotationProcessor.Step
        public Set<String> annotations() {
            return this.annotationsByName.keySet();
        }

        @Override // com.google.auto.common.BasicAnnotationProcessor.Step
        public Set<? extends Element> process(ImmutableSetMultimap<String, Element> immutableSetMultimap) {
            return this.processingStep.process(toClassKeyedMultimap(immutableSetMultimap));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Class lambda$new$1(Class cls) {
            return cls;
        }
    }
}
