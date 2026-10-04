package com.squareup.javapoet;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.squareup.javapoet.CodeBlock;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.StreamSupport;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class CodeBlock {
    final List<Object> args;
    final List<String> formatParts;
    private static final Pattern NAMED_ARGUMENT = Pattern.compile("\\$(?<argumentName>[\\w_]+):(?<typeChar>[\\w]).*");
    private static final Pattern LOWERCASE = Pattern.compile("[a-z]+[\\w_]*");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        final List<Object> args;
        final List<String> formatParts;

        private void addArgument(String str, char c, Object obj) {
            if (c == 'L') {
                this.args.add(argToLiteral(obj));
                return;
            }
            if (c == 'N') {
                this.args.add(argToName(obj));
            } else if (c == 'S') {
                this.args.add(argToString(obj));
            } else {
                if (c != 'T') {
                    throw new IllegalArgumentException(AbstractC0541b.m773o("invalid format string: '", str, "'"));
                }
                this.args.add(argToType(obj));
            }
        }

        private Object argToLiteral(Object obj) {
            return obj;
        }

        private String argToName(Object obj) {
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof ParameterSpec) {
                return ((ParameterSpec) obj).name;
            }
            if (obj instanceof FieldSpec) {
                return ((FieldSpec) obj).name;
            }
            if (obj instanceof MethodSpec) {
                return ((MethodSpec) obj).name;
            }
            if (obj instanceof TypeSpec) {
                return ((TypeSpec) obj).name;
            }
            throw new IllegalArgumentException(AbstractC0541b.m769k(obj, "expected name but was "));
        }

        private String argToString(Object obj) {
            if (obj != null) {
                return String.valueOf(obj);
            }
            return null;
        }

        private TypeName argToType(Object obj) {
            if (obj instanceof TypeName) {
                return (TypeName) obj;
            }
            if (obj instanceof TypeMirror) {
                return TypeName.get((TypeMirror) obj);
            }
            if (obj instanceof Element) {
                return TypeName.get(((Element) obj).asType());
            }
            if (obj instanceof Type) {
                return TypeName.get((Type) obj);
            }
            throw new IllegalArgumentException(AbstractC0541b.m769k(obj, "expected type but was "));
        }

        private boolean isNoArgPlaceholder(char c) {
            return c == '$' || c == '>' || c == '<' || c == '[' || c == ']' || c == 'W' || c == 'Z';
        }

        public Builder add(String str, Object... objArr) {
            int i;
            char cCharAt;
            boolean z;
            int i2;
            int[] iArr = new int[objArr.length];
            int i4 = 0;
            boolean z2 = false;
            int i5 = 0;
            boolean z3 = false;
            while (true) {
                if (i4 >= str.length()) {
                    break;
                }
                if (str.charAt(i4) != '$') {
                    int iIndexOf = str.indexOf(36, i4 + 1);
                    if (iIndexOf == -1) {
                        iIndexOf = str.length();
                    }
                    this.formatParts.add(str.substring(i4, iIndexOf));
                    i4 = iIndexOf;
                } else {
                    int i6 = i4 + 1;
                    int i7 = i6;
                    while (true) {
                        Util.checkArgument(i7 < str.length(), "dangling format characters in '%s'", str);
                        i = i7 + 1;
                        cCharAt = str.charAt(i7);
                        if (cCharAt < '0' || cCharAt > '9') {
                            break;
                        }
                        i7 = i;
                    }
                    if (isNoArgPlaceholder(cCharAt)) {
                        Util.checkArgument(i6 == i7, "$$, $>, $<, $[, $], $W, and $Z may not have an index", new Object[0]);
                        this.formatParts.add("$" + cCharAt);
                    } else {
                        if (i6 < i7) {
                            int i8 = Integer.parseInt(str.substring(i6, i7)) - 1;
                            if (objArr.length > 0) {
                                int length = i8 % objArr.length;
                                iArr[length] = iArr[length] + 1;
                            }
                            i2 = i5;
                            i5 = i8;
                            z = true;
                        } else {
                            z = z3;
                            i2 = i5 + 1;
                            z2 = true;
                        }
                        Util.checkArgument(i5 >= 0 && i5 < objArr.length, "index %d for '%s' not in range (received %s arguments)", Integer.valueOf(i5 + 1), str.substring(i4, i7 + 1), Integer.valueOf(objArr.length));
                        Util.checkArgument((z && z2) ? false : true, "cannot mix indexed and positional parameters", new Object[0]);
                        addArgument(str, cCharAt, objArr[i5]);
                        this.formatParts.add("$" + cCharAt);
                        i5 = i2;
                        z3 = z;
                    }
                    i4 = i;
                }
            }
            if (z2) {
                Util.checkArgument(i5 >= objArr.length, "unused arguments: expected %s, received %s", Integer.valueOf(i5), Integer.valueOf(objArr.length));
            }
            if (z3) {
                ArrayList arrayList = new ArrayList();
                for (int i9 = 0; i9 < objArr.length; i9++) {
                    if (iArr[i9] == 0) {
                        arrayList.add("$" + (i9 + 1));
                    }
                }
                Util.checkArgument(arrayList.isEmpty(), "unused argument%s: %s", arrayList.size() == 1 ? "" : "s", String.join(SQLKeyword.COMMA, arrayList));
            }
            return this;
        }

        public Builder addNamed(String str, Map<String, ?> map) {
            for (String str2 : map.keySet()) {
                Util.checkArgument(CodeBlock.LOWERCASE.matcher(str2).matches(), "argument '%s' must start with a lowercase character", str2);
            }
            int iRegionEnd = 0;
            while (iRegionEnd < str.length()) {
                int iIndexOf = str.indexOf("$", iRegionEnd);
                if (iIndexOf == -1) {
                    this.formatParts.add(str.substring(iRegionEnd));
                    return this;
                }
                if (iRegionEnd != iIndexOf) {
                    this.formatParts.add(str.substring(iRegionEnd, iIndexOf));
                    iRegionEnd = iIndexOf;
                }
                int iIndexOf2 = str.indexOf(58, iRegionEnd);
                Matcher matcher = iIndexOf2 != -1 ? CodeBlock.NAMED_ARGUMENT.matcher(str.substring(iRegionEnd, Math.min(iIndexOf2 + 2, str.length()))) : null;
                if (matcher == null || !matcher.lookingAt()) {
                    Util.checkArgument(iRegionEnd < str.length() - 1, "dangling $ at end", new Object[0]);
                    int i = iRegionEnd + 1;
                    Util.checkArgument(isNoArgPlaceholder(str.charAt(i)), "unknown format $%s at %s in '%s'", Character.valueOf(str.charAt(i)), Integer.valueOf(i), str);
                    int i2 = iRegionEnd + 2;
                    this.formatParts.add(str.substring(iRegionEnd, i2));
                    iRegionEnd = i2;
                } else {
                    String strGroup = matcher.group("argumentName");
                    Util.checkArgument(map.containsKey(strGroup), "Missing named argument for $%s", strGroup);
                    char cCharAt = matcher.group("typeChar").charAt(0);
                    addArgument(str, cCharAt, map.get(strGroup));
                    this.formatParts.add("$" + cCharAt);
                    iRegionEnd = matcher.regionEnd() + iRegionEnd;
                }
            }
            return this;
        }

        public Builder addStatement(String str, Object... objArr) {
            add("$[", new Object[0]);
            add(str, objArr);
            add(";\n$]", new Object[0]);
            return this;
        }

        public Builder beginControlFlow(String str, Object... objArr) {
            add(str + " {\n", objArr);
            indent();
            return this;
        }

        public CodeBlock build() {
            return new CodeBlock(this);
        }

        public Builder clear() {
            this.formatParts.clear();
            this.args.clear();
            return this;
        }

        public Builder endControlFlow() {
            unindent();
            add("}\n", new Object[0]);
            return this;
        }

        public Builder indent() {
            this.formatParts.add("$>");
            return this;
        }

        public boolean isEmpty() {
            return this.formatParts.isEmpty();
        }

        public Builder nextControlFlow(String str, Object... objArr) {
            unindent();
            add("} " + str + " {\n", objArr);
            indent();
            return this;
        }

        public Builder unindent() {
            this.formatParts.add("$<");
            return this;
        }

        private Builder() {
            this.formatParts = new ArrayList();
            this.args = new ArrayList();
        }

        public Builder endControlFlow(String str, Object... objArr) {
            unindent();
            add("} " + str + ";\n", objArr);
            return this;
        }

        public Builder addStatement(CodeBlock codeBlock) {
            return addStatement("$L", codeBlock);
        }

        public Builder add(CodeBlock codeBlock) {
            this.formatParts.addAll(codeBlock.formatParts);
            this.args.addAll(codeBlock.args);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CodeBlockJoiner {
        private final Builder builder;
        private final String delimiter;
        private boolean first = true;

        public CodeBlockJoiner(String str, Builder builder) {
            this.delimiter = str;
            this.builder = builder;
        }

        public CodeBlockJoiner add(CodeBlock codeBlock) {
            if (!this.first) {
                this.builder.add(this.delimiter, new Object[0]);
            }
            this.first = false;
            this.builder.add(codeBlock);
            return this;
        }

        public CodeBlock join() {
            return this.builder.build();
        }

        public CodeBlockJoiner merge(CodeBlockJoiner codeBlockJoiner) {
            CodeBlock codeBlockBuild = codeBlockJoiner.builder.build();
            if (!codeBlockBuild.isEmpty()) {
                add(codeBlockBuild);
            }
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static CodeBlock join(Iterable<CodeBlock> iterable, String str) {
        return (CodeBlock) StreamSupport.stream(iterable.spliterator(), false).collect(joining(str));
    }

    public static Collector<CodeBlock, ?, CodeBlock> joining(final String str) {
        return Collector.of(new Supplier() { // from class: com.squareup.javapoet.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return CodeBlock.lambda$joining$0(str);
            }
        }, new C11717b(), new C11718c(), new C11719d(0), new Collector.Characteristics[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CodeBlockJoiner lambda$joining$0(String str) {
        return new CodeBlockJoiner(str, builder());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CodeBlockJoiner lambda$joining$1(String str, Builder builder) {
        return new CodeBlockJoiner(str, builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CodeBlock lambda$joining$2(Builder builder, String str, CodeBlockJoiner codeBlockJoiner) {
        builder.add(m13156of("$N", str));
        return codeBlockJoiner.join();
    }

    /* JADX INFO: renamed from: of */
    public static CodeBlock m13156of(String str, Object... objArr) {
        return new Builder().add(str, objArr).build();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && CodeBlock.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isEmpty() {
        return this.formatParts.isEmpty();
    }

    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.formatParts.addAll(this.formatParts);
        builder.args.addAll(this.args);
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            new CodeWriter(sb).emit(this);
            return sb.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private CodeBlock(Builder builder) {
        this.formatParts = Util.immutableList(builder.formatParts);
        this.args = Util.immutableList(builder.args);
    }

    public static Collector<CodeBlock, ?, CodeBlock> joining(final String str, String str2, final String str3) {
        final Builder builderAdd = builder().add("$N", str2);
        return Collector.of(new Supplier() { // from class: com.squareup.javapoet.e
            @Override // java.util.function.Supplier
            public final Object get() {
                return CodeBlock.lambda$joining$1(str, builderAdd);
            }
        }, new C11717b(), new C11718c(), new Function() { // from class: com.squareup.javapoet.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return CodeBlock.lambda$joining$2(builderAdd, str3, (CodeBlock.CodeBlockJoiner) obj);
            }
        }, new Collector.Characteristics[0]);
    }
}
