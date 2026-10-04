package com.google.auto.common;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.AnnotationValueVisitor;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor8;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class AnnotationOutput {
    private static final AnnotationValueVisitor<AnnotationValue, AnnotationValue> ARRAY_VISITOR = new SimpleAnnotationValueVisitor8<AnnotationValue, AnnotationValue>() { // from class: com.google.auto.common.AnnotationOutput.1
        public AnnotationValue defaultAction(Object obj, AnnotationValue annotationValue) {
            return annotationValue;
        }

        public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
            return visitArray((List<? extends AnnotationValue>) list, (AnnotationValue) obj);
        }

        public AnnotationValue visitArray(List<? extends AnnotationValue> list, AnnotationValue annotationValue) {
            return list.size() == 1 ? (AnnotationValue) Iterables.getOnlyElement(list) : annotationValue;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SourceFormVisitor extends SimpleAnnotationValueVisitor8<Void, StringBuilder> {
        private SourceFormVisitor() {
        }

        private String formatType(TypeMirror typeMirror) {
            return MoreTypes.asTypeElement(typeMirror).getQualifiedName().toString();
        }

        public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
            return visitArray((List<? extends AnnotationValue>) list, (StringBuilder) obj);
        }

        public Void defaultAction(Object obj, StringBuilder sb) {
            sb.append(obj);
            return null;
        }

        public Void visitAnnotation(AnnotationMirror annotationMirror, StringBuilder sb) {
            sb.append('@');
            sb.append(formatType(annotationMirror.getAnnotationType()));
            ImmutableMap immutableMapCopyOf = ImmutableMap.copyOf(annotationMirror.getElementValues());
            if (immutableMapCopyOf.isEmpty()) {
                return null;
            }
            sb.append(PropertyUtils.MAPPED_DELIM);
            Optional optionalShortForm = AnnotationOutput.shortForm(immutableMapCopyOf);
            if (optionalShortForm.isPresent()) {
                visit(AnnotationOutput.maybeShorten((AnnotationValue) optionalShortForm.get()), sb);
            } else {
                UnmodifiableIterator it = immutableMapCopyOf.entrySet().iterator();
                String str = "";
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    sb.append(str);
                    sb.append((CharSequence) ((ExecutableElement) entry.getKey()).getSimpleName());
                    sb.append(" = ");
                    visit(AnnotationOutput.maybeShorten((AnnotationValue) entry.getValue()), sb);
                    str = SQLKeyword.COMMA;
                }
            }
            sb.append(PropertyUtils.MAPPED_DELIM2);
            return null;
        }

        public Void visitArray(List<? extends AnnotationValue> list, StringBuilder sb) {
            sb.append('{');
            String str = "";
            for (AnnotationValue annotationValue : list) {
                sb.append(str);
                visit(annotationValue, sb);
                str = SQLKeyword.COMMA;
            }
            sb.append('}');
            return null;
        }

        public Void visitByte(byte b, StringBuilder sb) {
            sb.append("(byte) ");
            sb.append((int) b);
            return null;
        }

        public Void visitChar(char c, StringBuilder sb) {
            AnnotationOutput.appendQuoted(sb, c);
            return null;
        }

        public Void visitDouble(double d, StringBuilder sb) {
            if (Double.isNaN(d)) {
                sb.append("Double.NaN");
                return null;
            }
            if (d == Double.POSITIVE_INFINITY) {
                sb.append("Double.POSITIVE_INFINITY");
                return null;
            }
            if (d == Double.NEGATIVE_INFINITY) {
                sb.append("Double.NEGATIVE_INFINITY");
                return null;
            }
            sb.append(d);
            return null;
        }

        public Void visitEnumConstant(VariableElement variableElement, StringBuilder sb) {
            sb.append(formatType(variableElement.asType()));
            sb.append('.');
            sb.append((CharSequence) variableElement.getSimpleName());
            return null;
        }

        public Void visitFloat(float f, StringBuilder sb) {
            if (Float.isNaN(f)) {
                sb.append("Float.NaN");
                return null;
            }
            if (f == Float.POSITIVE_INFINITY) {
                sb.append("Float.POSITIVE_INFINITY");
                return null;
            }
            if (f == Float.NEGATIVE_INFINITY) {
                sb.append("Float.NEGATIVE_INFINITY");
                return null;
            }
            sb.append(f);
            sb.append('F');
            return null;
        }

        public Void visitLong(long j, StringBuilder sb) {
            sb.append(j);
            sb.append('L');
            return null;
        }

        public Void visitShort(short s, StringBuilder sb) {
            sb.append("(short) ");
            sb.append((int) s);
            return null;
        }

        public Void visitString(String str, StringBuilder sb) {
            AnnotationOutput.appendQuoted(sb, str);
            return null;
        }

        public Void visitType(TypeMirror typeMirror, StringBuilder sb) {
            sb.append(formatType(typeMirror));
            sb.append(".class");
            return null;
        }
    }

    private AnnotationOutput() {
    }

    private static void appendEscaped(StringBuilder sb, char c) {
        if (c == '\t') {
            sb.append("\\t");
            return;
        }
        if (c == '\n') {
            sb.append("\\n");
            return;
        }
        if (c == '\r') {
            sb.append("\\r");
            return;
        }
        if (c == '\"' || c == '\'' || c == '\\') {
            sb.append('\\');
            sb.append(c);
        } else if (c < ' ') {
            sb.append(String.format("\\%03o", Integer.valueOf(c)));
        } else if (c < 127 || Character.isLetter(c)) {
            sb.append(c);
        } else {
            sb.append(String.format("\\u%04x", Integer.valueOf(c)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StringBuilder appendQuoted(StringBuilder sb, String str) {
        sb.append('\"');
        for (int i = 0; i < str.length(); i++) {
            appendEscaped(sb, str.charAt(i));
        }
        sb.append('\"');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AnnotationValue maybeShorten(AnnotationValue annotationValue) {
        return (AnnotationValue) ARRAY_VISITOR.visit(annotationValue, annotationValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Optional<AnnotationValue> shortForm(Map<ExecutableElement, AnnotationValue> map) {
        return (map.size() == 1 && ((ExecutableElement) Iterables.getOnlyElement(map.keySet())).getSimpleName().contentEquals("value")) ? Optional.of((AnnotationValue) Iterables.getOnlyElement(map.values())) : Optional.empty();
    }

    public static String toString(AnnotationValue annotationValue) {
        StringBuilder sb = new StringBuilder();
        new SourceFormVisitor().visit(annotationValue, sb);
        return sb.toString();
    }

    public static String toString(AnnotationMirror annotationMirror) {
        StringBuilder sb = new StringBuilder();
        new SourceFormVisitor().visitAnnotation(annotationMirror, sb);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StringBuilder appendQuoted(StringBuilder sb, char c) {
        sb.append('\'');
        appendEscaped(sb, c);
        sb.append('\'');
        return sb;
    }
}
