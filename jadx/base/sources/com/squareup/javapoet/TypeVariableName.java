package com.squareup.javapoet;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class TypeVariableName extends TypeName {
    public final List<TypeName> bounds;
    public final String name;

    private TypeVariableName(String str, List<TypeName> list) {
        this(str, list, new ArrayList());
    }

    public static TypeVariableName get(String str) {
        return m13159of(str, Collections.EMPTY_LIST);
    }

    /* JADX INFO: renamed from: of */
    private static TypeVariableName m13159of(String str, List<TypeName> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.remove(TypeName.OBJECT);
        return new TypeVariableName(str, Collections.unmodifiableList(arrayList));
    }

    @Override // com.squareup.javapoet.TypeName
    public /* bridge */ /* synthetic */ TypeName annotated(List list) {
        return annotated((List<AnnotationSpec>) list);
    }

    @Override // com.squareup.javapoet.TypeName
    public CodeWriter emit(CodeWriter codeWriter) {
        emitAnnotations(codeWriter);
        return codeWriter.emitAndIndent(this.name);
    }

    public TypeVariableName withBounds(Type... typeArr) {
        return withBounds(TypeName.list(typeArr));
    }

    @Override // com.squareup.javapoet.TypeName
    public TypeName withoutAnnotations() {
        return new TypeVariableName(this.name, this.bounds);
    }

    private TypeVariableName(String str, List<TypeName> list, List<AnnotationSpec> list2) {
        super(list2);
        this.name = (String) Util.checkNotNull(str, "name == null", new Object[0]);
        this.bounds = list;
        Iterator<TypeName> it = list.iterator();
        while (it.hasNext()) {
            TypeName next = it.next();
            Util.checkArgument((next.isPrimitive() || next == TypeName.VOID) ? false : true, "invalid bound: %s", next);
        }
    }

    public static TypeVariableName get(String str, TypeName... typeNameArr) {
        return m13159of(str, Arrays.asList(typeNameArr));
    }

    @Override // com.squareup.javapoet.TypeName
    public TypeVariableName annotated(List<AnnotationSpec> list) {
        return new TypeVariableName(this.name, this.bounds, list);
    }

    public TypeVariableName withBounds(TypeName... typeNameArr) {
        return withBounds(Arrays.asList(typeNameArr));
    }

    public static TypeVariableName get(String str, Type... typeArr) {
        return m13159of(str, TypeName.list(typeArr));
    }

    public TypeVariableName withBounds(List<? extends TypeName> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.bounds);
        arrayList.addAll(list);
        return new TypeVariableName(this.name, arrayList, this.annotations);
    }

    public static TypeVariableName get(TypeVariable typeVariable) {
        return get(typeVariable.asElement());
    }

    public static TypeVariableName get(TypeVariable typeVariable, Map<TypeParameterElement, TypeVariableName> map) {
        TypeParameterElement typeParameterElement = (TypeParameterElement) typeVariable.asElement();
        TypeVariableName typeVariableName = map.get(typeParameterElement);
        if (typeVariableName != null) {
            return typeVariableName;
        }
        ArrayList arrayList = new ArrayList();
        TypeVariableName typeVariableName2 = new TypeVariableName(typeParameterElement.getSimpleName().toString(), Collections.unmodifiableList(arrayList));
        map.put(typeParameterElement, typeVariableName2);
        Iterator it = typeParameterElement.getBounds().iterator();
        while (it.hasNext()) {
            arrayList.add(TypeName.get((TypeMirror) it.next(), map));
        }
        arrayList.remove(TypeName.OBJECT);
        return typeVariableName2;
    }

    public static TypeVariableName get(TypeParameterElement typeParameterElement) {
        String string = typeParameterElement.getSimpleName().toString();
        List bounds = typeParameterElement.getBounds();
        ArrayList arrayList = new ArrayList();
        Iterator it = bounds.iterator();
        while (it.hasNext()) {
            arrayList.add(TypeName.get((TypeMirror) it.next()));
        }
        return m13159of(string, arrayList);
    }

    public static TypeVariableName get(java.lang.reflect.TypeVariable<?> typeVariable) {
        return get(typeVariable, (Map<Type, TypeVariableName>) new LinkedHashMap());
    }

    public static TypeVariableName get(java.lang.reflect.TypeVariable<?> typeVariable, Map<Type, TypeVariableName> map) {
        TypeVariableName typeVariableName = map.get(typeVariable);
        if (typeVariableName != null) {
            return typeVariableName;
        }
        ArrayList arrayList = new ArrayList();
        TypeVariableName typeVariableName2 = new TypeVariableName(typeVariable.getName(), Collections.unmodifiableList(arrayList));
        map.put(typeVariable, typeVariableName2);
        for (Type type : typeVariable.getBounds()) {
            arrayList.add(TypeName.get(type, map));
        }
        arrayList.remove(TypeName.OBJECT);
        return typeVariableName2;
    }
}
