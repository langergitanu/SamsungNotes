package com.squareup.javapoet;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ParameterizedTypeName extends TypeName {
    private final ParameterizedTypeName enclosingType;
    public final ClassName rawType;
    public final List<TypeName> typeArguments;

    public ParameterizedTypeName(ParameterizedTypeName parameterizedTypeName, ClassName className, List<TypeName> list) {
        this(parameterizedTypeName, className, list, new ArrayList());
    }

    public static ParameterizedTypeName get(ClassName className, TypeName... typeNameArr) {
        return new ParameterizedTypeName(null, className, Arrays.asList(typeNameArr));
    }

    @Override // com.squareup.javapoet.TypeName
    public /* bridge */ /* synthetic */ TypeName annotated(List list) {
        return annotated((List<AnnotationSpec>) list);
    }

    @Override // com.squareup.javapoet.TypeName
    public CodeWriter emit(CodeWriter codeWriter) {
        ParameterizedTypeName parameterizedTypeName = this.enclosingType;
        if (parameterizedTypeName != null) {
            parameterizedTypeName.emit(codeWriter);
            codeWriter.emit(Extension.DOT);
            if (isAnnotated()) {
                codeWriter.emit(" ");
                emitAnnotations(codeWriter);
            }
            codeWriter.emit(this.rawType.simpleName());
        } else {
            this.rawType.emit(codeWriter);
        }
        if (!this.typeArguments.isEmpty()) {
            codeWriter.emitAndIndent("<");
            boolean z = true;
            for (TypeName typeName : this.typeArguments) {
                if (!z) {
                    codeWriter.emitAndIndent(SQLKeyword.COMMA);
                }
                typeName.emit(codeWriter);
                z = false;
            }
            codeWriter.emitAndIndent(">");
        }
        return codeWriter;
    }

    public ParameterizedTypeName nestedClass(String str) {
        Util.checkNotNull(str, "name == null", new Object[0]);
        return new ParameterizedTypeName(this, this.rawType.nestedClass(str), new ArrayList(), new ArrayList());
    }

    @Override // com.squareup.javapoet.TypeName
    public TypeName withoutAnnotations() {
        return new ParameterizedTypeName(this.enclosingType, this.rawType.withoutAnnotations(), this.typeArguments, new ArrayList());
    }

    private ParameterizedTypeName(ParameterizedTypeName parameterizedTypeName, ClassName className, List<TypeName> list, List<AnnotationSpec> list2) {
        super(list2);
        this.rawType = ((ClassName) Util.checkNotNull(className, "rawType == null", new Object[0])).annotated(list2);
        this.enclosingType = parameterizedTypeName;
        List<TypeName> listImmutableList = Util.immutableList(list);
        this.typeArguments = listImmutableList;
        Util.checkArgument((listImmutableList.isEmpty() && parameterizedTypeName == null) ? false : true, "no type arguments: %s", className);
        Iterator<TypeName> it = listImmutableList.iterator();
        while (it.hasNext()) {
            TypeName next = it.next();
            Util.checkArgument((next.isPrimitive() || next == TypeName.VOID) ? false : true, "invalid type parameter: %s", next);
        }
    }

    public static ParameterizedTypeName get(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeName(null, ClassName.get(cls), TypeName.list(typeArr));
    }

    @Override // com.squareup.javapoet.TypeName
    public ParameterizedTypeName annotated(List<AnnotationSpec> list) {
        return new ParameterizedTypeName(this.enclosingType, this.rawType, this.typeArguments, concatAnnotations(list));
    }

    public static ParameterizedTypeName get(ParameterizedType parameterizedType) {
        return get(parameterizedType, (Map<Type, TypeVariableName>) new LinkedHashMap());
    }

    public ParameterizedTypeName nestedClass(String str, List<TypeName> list) {
        Util.checkNotNull(str, "name == null", new Object[0]);
        return new ParameterizedTypeName(this, this.rawType.nestedClass(str), list, new ArrayList());
    }

    public static ParameterizedTypeName get(ParameterizedType parameterizedType, Map<Type, TypeVariableName> map) {
        ClassName className = ClassName.get((Class<?>) parameterizedType.getRawType());
        ParameterizedType parameterizedType2 = (!(parameterizedType.getOwnerType() instanceof ParameterizedType) || Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers())) ? null : (ParameterizedType) parameterizedType.getOwnerType();
        List<TypeName> list = TypeName.list(parameterizedType.getActualTypeArguments(), map);
        if (parameterizedType2 != null) {
            return get(parameterizedType2, map).nestedClass(className.simpleName(), list);
        }
        return new ParameterizedTypeName(null, className, list);
    }
}
