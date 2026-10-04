package com.squareup.javapoet;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor8;
import opennlp.tools.parser.Parse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class AnnotationSpec {
    public final Map<String, List<CodeBlock>> members;
    public final TypeName type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        public final Map<String, List<CodeBlock>> members;
        private final TypeName type;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List lambda$addMember$0(String str) {
            return new ArrayList();
        }

        public Builder addMember(String str, String str2, Object... objArr) {
            return addMember(str, CodeBlock.m13156of(str2, objArr));
        }

        public Builder addMemberForValue(String str, Object obj) {
            Util.checkNotNull(str, "memberName == null", new Object[0]);
            Util.checkNotNull(obj, "value == null, constant non-null value expected for %s", str);
            Util.checkArgument(SourceVersion.isName(str), "not a valid name: %s", str);
            return obj instanceof Class ? addMember(str, "$T.class", obj) : obj instanceof Enum ? addMember(str, "$T.$L", obj.getClass(), ((Enum) obj).name()) : obj instanceof String ? addMember(str, "$S", obj) : obj instanceof Float ? addMember(str, "$Lf", obj) : obj instanceof Character ? addMember(str, "'$L'", Util.characterLiteralWithoutSingleQuotes(((Character) obj).charValue())) : addMember(str, "$L", obj);
        }

        public AnnotationSpec build() {
            for (String str : this.members.keySet()) {
                Util.checkNotNull(str, "name == null", new Object[0]);
                Util.checkArgument(SourceVersion.isName(str), "not a valid name: %s", str);
            }
            return new AnnotationSpec(this);
        }

        private Builder(TypeName typeName) {
            this.members = new LinkedHashMap();
            this.type = typeName;
        }

        public Builder addMember(String str, CodeBlock codeBlock) {
            this.members.computeIfAbsent(str, new C11719d(2)).add(codeBlock);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Visitor extends SimpleAnnotationValueVisitor8<Builder, String> {
        final Builder builder;

        public Visitor(Builder builder) {
            super(builder);
            this.builder = builder;
        }

        public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
            return visitArray((List<? extends AnnotationValue>) list, (String) obj);
        }

        public Builder defaultAction(Object obj, String str) {
            return this.builder.addMemberForValue(str, obj);
        }

        public Builder visitAnnotation(AnnotationMirror annotationMirror, String str) {
            return this.builder.addMember(str, "$L", AnnotationSpec.get(annotationMirror));
        }

        public Builder visitArray(List<? extends AnnotationValue> list, String str) {
            Iterator<? extends AnnotationValue> it = list.iterator();
            while (it.hasNext()) {
                it.next().accept(this, str);
            }
            return this.builder;
        }

        public Builder visitEnumConstant(VariableElement variableElement, String str) {
            return this.builder.addMember(str, "$T.$L", variableElement.asType(), variableElement.getSimpleName());
        }

        public Builder visitType(TypeMirror typeMirror, String str) {
            return this.builder.addMember(str, "$T.class", typeMirror);
        }
    }

    public static Builder builder(ClassName className) {
        Util.checkNotNull(className, "type == null", new Object[0]);
        return new Builder(className);
    }

    private void emitAnnotationValues(CodeWriter codeWriter, String str, String str2, List<CodeBlock> list) {
        boolean z = true;
        if (list.size() == 1) {
            codeWriter.indent(2);
            codeWriter.emit(list.get(0));
            codeWriter.unindent(2);
            return;
        }
        codeWriter.emit(AbstractC0541b.m772n(Parse.BRACKET_LCB, str));
        codeWriter.indent(2);
        for (CodeBlock codeBlock : list) {
            if (!z) {
                codeWriter.emit(str2);
            }
            codeWriter.emit(codeBlock);
            z = false;
        }
        codeWriter.unindent(2);
        codeWriter.emit(AbstractC0541b.m756B(str, "}"));
    }

    public static AnnotationSpec get(Annotation annotation) {
        return get(annotation, false);
    }

    public void emit(CodeWriter codeWriter, boolean z) {
        String str = z ? "" : "\n";
        String str2 = z ? SQLKeyword.COMMA : ",\n";
        if (this.members.isEmpty()) {
            codeWriter.emit("@$T", this.type);
            return;
        }
        if (this.members.size() == 1 && this.members.containsKey("value")) {
            codeWriter.emit("@$T(", this.type);
            emitAnnotationValues(codeWriter, str, str2, this.members.get("value"));
            codeWriter.emit(")");
            return;
        }
        codeWriter.emit("@$T(".concat(str), this.type);
        codeWriter.indent(2);
        Iterator<Map.Entry<String, List<CodeBlock>>> it = this.members.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<CodeBlock>> next = it.next();
            codeWriter.emit("$L = ", next.getKey());
            emitAnnotationValues(codeWriter, str, str2, next.getValue());
            if (it.hasNext()) {
                codeWriter.emit(str2);
            }
        }
        codeWriter.unindent(2);
        codeWriter.emit(str.concat(")"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AnnotationSpec.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public Builder toBuilder() {
        Builder builder = new Builder(this.type);
        for (Map.Entry<String, List<CodeBlock>> entry : this.members.entrySet()) {
            builder.members.put(entry.getKey(), new ArrayList(entry.getValue()));
        }
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            new CodeWriter(sb).emit("$L", this);
            return sb.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private AnnotationSpec(Builder builder) {
        this.type = builder.type;
        this.members = Util.immutableMultimap(builder.members);
    }

    public static AnnotationSpec get(Annotation annotation, boolean z) {
        Builder builder = builder(annotation.annotationType());
        try {
            Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
            Arrays.sort(declaredMethods, Comparator.comparing(new C11719d(1)));
            for (Method method : declaredMethods) {
                Object objInvoke = method.invoke(annotation, null);
                if (z || !Objects.deepEquals(objInvoke, method.getDefaultValue())) {
                    if (objInvoke.getClass().isArray()) {
                        for (int i = 0; i < Array.getLength(objInvoke); i++) {
                            builder.addMemberForValue(method.getName(), Array.get(objInvoke, i));
                        }
                    } else if (objInvoke instanceof Annotation) {
                        builder.addMember(method.getName(), "$L", get((Annotation) objInvoke));
                    } else {
                        builder.addMemberForValue(method.getName(), objInvoke);
                    }
                }
            }
            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException("Reflecting " + annotation + " failed!", e);
        }
    }

    public static Builder builder(Class<?> cls) {
        return builder(ClassName.get(cls));
    }

    public static AnnotationSpec get(AnnotationMirror annotationMirror) {
        Builder builder = builder(ClassName.get(annotationMirror.getAnnotationType().asElement()));
        Visitor visitor = new Visitor(builder);
        for (ExecutableElement executableElement : annotationMirror.getElementValues().keySet()) {
            ((AnnotationValue) annotationMirror.getElementValues().get(executableElement)).accept(visitor, executableElement.getSimpleName().toString());
        }
        return builder.build();
    }
}
