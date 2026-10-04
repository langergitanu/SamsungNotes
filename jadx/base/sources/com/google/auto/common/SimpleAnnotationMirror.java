package com.google.auto.common;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.util.ElementFilter;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class SimpleAnnotationMirror implements AnnotationMirror {
    private final TypeElement annotationType;
    private final ImmutableMap<ExecutableElement, ? extends AnnotationValue> elementValues;
    private final ImmutableMap<String, ? extends AnnotationValue> namedValues;

    private SimpleAnnotationMirror(TypeElement typeElement, Map<String, ? extends AnnotationValue> map) {
        Preconditions.checkArgument(typeElement.getKind().equals(ElementKind.ANNOTATION_TYPE), "annotationType must be an annotation: %s", typeElement);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(map);
        ArrayList arrayList = new ArrayList();
        for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
            String string = executableElement.getSimpleName().toString();
            if (linkedHashMap2.containsKey(string)) {
                linkedHashMap.put(string, (AnnotationValue) linkedHashMap2.remove(string));
            } else if (executableElement.getDefaultValue() != null) {
                linkedHashMap.put(string, executableElement.getDefaultValue());
            } else {
                arrayList.add(string);
            }
        }
        Preconditions.checkArgument(linkedHashMap2.isEmpty(), "namedValues has entries for members that are not in %s: %s", typeElement, linkedHashMap2);
        Preconditions.checkArgument(arrayList.isEmpty(), "namedValues is missing entries for: %s", arrayList);
        this.annotationType = typeElement;
        this.namedValues = ImmutableMap.copyOf((Map) map);
        this.elementValues = (ImmutableMap) ElementFilter.methodsIn(typeElement.getEnclosedElements()).stream().collect(MoreStreams.toImmutableMap(new C5419H(), new Function() { // from class: com.google.auto.common.I
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SimpleAnnotationMirror.lambda$new$1(linkedHashMap, (ExecutableElement) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnnotationValue lambda$new$1(Map map, ExecutableElement executableElement) {
        return (AnnotationValue) map.get(executableElement.getSimpleName().toString());
    }

    /* JADX INFO: renamed from: of */
    public static AnnotationMirror m4254of(TypeElement typeElement) {
        return m4255of(typeElement, ImmutableMap.m4321of());
    }

    public boolean equals(Object obj) {
        return (obj instanceof AnnotationMirror) && AnnotationMirrors.equivalence().equivalent(this, (AnnotationMirror) obj);
    }

    public DeclaredType getAnnotationType() {
        return MoreTypes.asDeclared(this.annotationType.asType());
    }

    public Map<ExecutableElement, ? extends AnnotationValue> getElementValues() {
        return this.elementValues;
    }

    public int hashCode() {
        return AnnotationMirrors.equivalence().hash(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Log.TAG_SEPARATOR);
        sb.append((CharSequence) this.annotationType.getQualifiedName());
        if (!this.namedValues.isEmpty()) {
            sb.append(PropertyUtils.MAPPED_DELIM);
            sb.append(Joiner.m4266on(SQLKeyword.COMMA).withKeyValueSeparator(" = ").join(this.namedValues));
            sb.append(PropertyUtils.MAPPED_DELIM2);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: of */
    public static AnnotationMirror m4255of(TypeElement typeElement, Map<String, ? extends AnnotationValue> map) {
        return new SimpleAnnotationMirror(typeElement, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ExecutableElement lambda$new$0(ExecutableElement executableElement) {
        return executableElement;
    }
}
