package com.squareup.javapoet;

import com.microsoft.identity.client.internal.MsalUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.WildcardType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class WildcardTypeName extends TypeName {
    public final List<TypeName> lowerBounds;
    public final List<TypeName> upperBounds;

    private WildcardTypeName(List<TypeName> list, List<TypeName> list2) {
        this(list, list2, new ArrayList());
    }

    public static TypeName get(WildcardType wildcardType) {
        return get(wildcardType, new LinkedHashMap());
    }

    public static WildcardTypeName subtypeOf(TypeName typeName) {
        return new WildcardTypeName(Collections.singletonList(typeName), Collections.EMPTY_LIST);
    }

    public static WildcardTypeName supertypeOf(TypeName typeName) {
        return new WildcardTypeName(Collections.singletonList(TypeName.OBJECT), Collections.singletonList(typeName));
    }

    @Override // com.squareup.javapoet.TypeName
    public /* bridge */ /* synthetic */ TypeName annotated(List list) {
        return annotated((List<AnnotationSpec>) list);
    }

    @Override // com.squareup.javapoet.TypeName
    public CodeWriter emit(CodeWriter codeWriter) {
        return this.lowerBounds.size() == 1 ? codeWriter.emit("? super $T", this.lowerBounds.get(0)) : this.upperBounds.get(0).equals(TypeName.OBJECT) ? codeWriter.emit(MsalUtils.QUERY_STRING_SYMBOL) : codeWriter.emit("? extends $T", this.upperBounds.get(0));
    }

    @Override // com.squareup.javapoet.TypeName
    public TypeName withoutAnnotations() {
        return new WildcardTypeName(this.upperBounds, this.lowerBounds);
    }

    private WildcardTypeName(List<TypeName> list, List<TypeName> list2, List<AnnotationSpec> list3) {
        super(list3);
        List<TypeName> listImmutableList = Util.immutableList(list);
        this.upperBounds = listImmutableList;
        this.lowerBounds = Util.immutableList(list2);
        Util.checkArgument(listImmutableList.size() == 1, "unexpected extends bounds: %s", list);
        Iterator<TypeName> it = listImmutableList.iterator();
        while (it.hasNext()) {
            TypeName next = it.next();
            Util.checkArgument((next.isPrimitive() || next == TypeName.VOID) ? false : true, "invalid upper bound: %s", next);
        }
        Iterator<TypeName> it2 = this.lowerBounds.iterator();
        while (it2.hasNext()) {
            TypeName next2 = it2.next();
            Util.checkArgument((next2.isPrimitive() || next2 == TypeName.VOID) ? false : true, "invalid lower bound: %s", next2);
        }
    }

    public static TypeName get(WildcardType wildcardType, Map<TypeParameterElement, TypeVariableName> map) {
        TypeMirror extendsBound = wildcardType.getExtendsBound();
        if (extendsBound != null) {
            return subtypeOf(TypeName.get(extendsBound, map));
        }
        TypeMirror superBound = wildcardType.getSuperBound();
        return superBound == null ? subtypeOf(Object.class) : supertypeOf(TypeName.get(superBound, map));
    }

    public static WildcardTypeName subtypeOf(Type type) {
        return subtypeOf(TypeName.get(type));
    }

    @Override // com.squareup.javapoet.TypeName
    public WildcardTypeName annotated(List<AnnotationSpec> list) {
        return new WildcardTypeName(this.upperBounds, this.lowerBounds, concatAnnotations(list));
    }

    public static WildcardTypeName supertypeOf(Type type) {
        return supertypeOf(TypeName.get(type));
    }

    public static TypeName get(java.lang.reflect.WildcardType wildcardType) {
        return get(wildcardType, (Map<Type, TypeVariableName>) new LinkedHashMap());
    }

    public static TypeName get(java.lang.reflect.WildcardType wildcardType, Map<Type, TypeVariableName> map) {
        return new WildcardTypeName(TypeName.list(wildcardType.getUpperBounds(), map), TypeName.list(wildcardType.getLowerBounds(), map));
    }
}
