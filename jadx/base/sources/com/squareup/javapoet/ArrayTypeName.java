package com.squareup.javapoet;

import com.adobe.internal.xmp.XMPConst;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ArrayTypeName extends TypeName {
    public final TypeName componentType;

    private ArrayTypeName(TypeName typeName) {
        this(typeName, new ArrayList());
    }

    private CodeWriter emitBrackets(CodeWriter codeWriter, boolean z) {
        if (isAnnotated()) {
            codeWriter.emit(" ");
            emitAnnotations(codeWriter);
        }
        ArrayTypeName arrayTypeNameAsArray = TypeName.asArray(this.componentType);
        String str = XMPConst.ARRAY_ITEM_NAME;
        if (arrayTypeNameAsArray != null) {
            codeWriter.emit(XMPConst.ARRAY_ITEM_NAME);
            return TypeName.asArray(this.componentType).emitBrackets(codeWriter, z);
        }
        if (z) {
            str = "...";
        }
        return codeWriter.emit(str);
    }

    private CodeWriter emitLeafType(CodeWriter codeWriter) {
        return TypeName.asArray(this.componentType) != null ? TypeName.asArray(this.componentType).emitLeafType(codeWriter) : this.componentType.emit(codeWriter);
    }

    public static ArrayTypeName get(ArrayType arrayType) {
        return get(arrayType, new LinkedHashMap());
    }

    /* JADX INFO: renamed from: of */
    public static ArrayTypeName m13151of(TypeName typeName) {
        return new ArrayTypeName(typeName);
    }

    @Override // com.squareup.javapoet.TypeName
    public /* bridge */ /* synthetic */ TypeName annotated(List list) {
        return annotated((List<AnnotationSpec>) list);
    }

    @Override // com.squareup.javapoet.TypeName
    public CodeWriter emit(CodeWriter codeWriter) {
        return emit(codeWriter, false);
    }

    @Override // com.squareup.javapoet.TypeName
    public TypeName withoutAnnotations() {
        return new ArrayTypeName(this.componentType);
    }

    private ArrayTypeName(TypeName typeName, List<AnnotationSpec> list) {
        super(list);
        this.componentType = (TypeName) Util.checkNotNull(typeName, "rawType == null", new Object[0]);
    }

    public static ArrayTypeName get(ArrayType arrayType, Map<TypeParameterElement, TypeVariableName> map) {
        return new ArrayTypeName(TypeName.get(arrayType.getComponentType(), map));
    }

    /* JADX INFO: renamed from: of */
    public static ArrayTypeName m13152of(Type type) {
        return m13151of(TypeName.get(type));
    }

    @Override // com.squareup.javapoet.TypeName
    public ArrayTypeName annotated(List<AnnotationSpec> list) {
        return new ArrayTypeName(this.componentType, concatAnnotations(list));
    }

    public CodeWriter emit(CodeWriter codeWriter, boolean z) {
        emitLeafType(codeWriter);
        return emitBrackets(codeWriter, z);
    }

    public static ArrayTypeName get(GenericArrayType genericArrayType) {
        return get(genericArrayType, (Map<Type, TypeVariableName>) new LinkedHashMap());
    }

    public static ArrayTypeName get(GenericArrayType genericArrayType, Map<Type, TypeVariableName> map) {
        return m13151of(TypeName.get(genericArrayType.getGenericComponentType(), map));
    }
}
