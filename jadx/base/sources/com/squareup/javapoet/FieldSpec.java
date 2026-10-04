package com.squareup.javapoet;

import com.squareup.javapoet.CodeBlock;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class FieldSpec {
    public final List<AnnotationSpec> annotations;
    public final CodeBlock initializer;
    public final CodeBlock javadoc;
    public final Set<Modifier> modifiers;
    public final String name;
    public final TypeName type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        public final List<AnnotationSpec> annotations;
        private CodeBlock initializer;
        private final CodeBlock.Builder javadoc;
        public final List<Modifier> modifiers;
        private final String name;
        private final TypeName type;

        public Builder addAnnotation(AnnotationSpec annotationSpec) {
            this.annotations.add(annotationSpec);
            return this;
        }

        public Builder addAnnotations(Iterable<AnnotationSpec> iterable) {
            Util.checkArgument(iterable != null, "annotationSpecs == null", new Object[0]);
            Iterator<AnnotationSpec> it = iterable.iterator();
            while (it.hasNext()) {
                this.annotations.add(it.next());
            }
            return this;
        }

        public Builder addJavadoc(String str, Object... objArr) {
            this.javadoc.add(str, objArr);
            return this;
        }

        public Builder addModifiers(Modifier... modifierArr) {
            Collections.addAll(this.modifiers, modifierArr);
            return this;
        }

        public FieldSpec build() {
            return new FieldSpec(this);
        }

        public Builder initializer(String str, Object... objArr) {
            return initializer(CodeBlock.m13156of(str, objArr));
        }

        private Builder(TypeName typeName, String str) {
            this.javadoc = CodeBlock.builder();
            this.initializer = null;
            this.annotations = new ArrayList();
            this.modifiers = new ArrayList();
            this.type = typeName;
            this.name = str;
        }

        public Builder addAnnotation(ClassName className) {
            this.annotations.add(AnnotationSpec.builder(className).build());
            return this;
        }

        public Builder addJavadoc(CodeBlock codeBlock) {
            this.javadoc.add(codeBlock);
            return this;
        }

        public Builder initializer(CodeBlock codeBlock) {
            Util.checkState(this.initializer == null, "initializer was already set", new Object[0]);
            this.initializer = (CodeBlock) Util.checkNotNull(codeBlock, "codeBlock == null", new Object[0]);
            return this;
        }

        public Builder addAnnotation(Class<?> cls) {
            return addAnnotation(ClassName.get(cls));
        }
    }

    public static Builder builder(TypeName typeName, String str, Modifier... modifierArr) {
        Util.checkNotNull(typeName, "type == null", new Object[0]);
        Util.checkArgument(SourceVersion.isName(str), "not a valid name: %s", str);
        return new Builder(typeName, str).addModifiers(modifierArr);
    }

    public void emit(CodeWriter codeWriter, Set<Modifier> set) {
        codeWriter.emitJavadoc(this.javadoc);
        codeWriter.emitAnnotations(this.annotations, false);
        codeWriter.emitModifiers(this.modifiers, set);
        codeWriter.emit("$T $L", this.type, this.name);
        if (!this.initializer.isEmpty()) {
            codeWriter.emit(" = ");
            codeWriter.emit(this.initializer);
        }
        codeWriter.emit(";\n");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && FieldSpec.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public boolean hasModifier(Modifier modifier) {
        return this.modifiers.contains(modifier);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Builder toBuilder() {
        Builder builder = new Builder(this.type, this.name);
        builder.javadoc.add(this.javadoc);
        builder.annotations.addAll(this.annotations);
        builder.modifiers.addAll(this.modifiers);
        builder.initializer = this.initializer.isEmpty() ? null : this.initializer;
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            emit(new CodeWriter(sb), Collections.EMPTY_SET);
            return sb.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private FieldSpec(Builder builder) {
        this.type = (TypeName) Util.checkNotNull(builder.type, "type == null", new Object[0]);
        this.name = (String) Util.checkNotNull(builder.name, "name == null", new Object[0]);
        this.javadoc = builder.javadoc.build();
        this.annotations = Util.immutableList(builder.annotations);
        this.modifiers = Util.immutableSet(builder.modifiers);
        this.initializer = builder.initializer == null ? CodeBlock.builder().build() : builder.initializer;
    }

    public static Builder builder(Type type, String str, Modifier... modifierArr) {
        return builder(TypeName.get(type), str, modifierArr);
    }
}
