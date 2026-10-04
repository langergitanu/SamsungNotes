package com.squareup.javapoet;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class CodeWriter {
    private static final String NO_PACKAGE = new String();
    private final Set<String> alwaysQualify;
    private boolean comment;
    private final Multiset<String> currentTypeVariables;
    private final Map<String, ClassName> importableTypes;
    private final Map<String, ClassName> importedTypes;
    private final String indent;
    private int indentLevel;
    private boolean javadoc;
    private final LineWrapper out;
    private String packageName;
    private final Set<String> referencedNames;
    int statementLine;
    private final Set<String> staticImportClassNames;
    private final Set<String> staticImports;
    private boolean trailingNewline;
    private final List<TypeSpec> typeSpecStack;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Multiset<T> {
        private final Map<T, Integer> map;

        private Multiset() {
            this.map = new LinkedHashMap();
        }

        public void add(T t) {
            this.map.put(t, Integer.valueOf(this.map.getOrDefault(t, 0).intValue() + 1));
        }

        public boolean contains(T t) {
            return this.map.getOrDefault(t, 0).intValue() > 0;
        }

        public void remove(T t) {
            int iIntValue = this.map.getOrDefault(t, 0).intValue();
            if (iIntValue != 0) {
                this.map.put(t, Integer.valueOf(iIntValue - 1));
                return;
            }
            throw new IllegalStateException(t + " is not in the multiset");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CodeWriter(Appendable appendable) {
        Set set = Collections.EMPTY_SET;
        this(appendable, Constant.WHITE_SPACE_FOR_LINK_ICON, set, set);
    }

    private void emitIndentation() {
        for (int i = 0; i < this.indentLevel; i++) {
            this.out.append(this.indent);
        }
    }

    private void emitLiteral(Object obj) {
        if (obj instanceof TypeSpec) {
            ((TypeSpec) obj).emit(this, null, Collections.EMPTY_SET);
            return;
        }
        if (obj instanceof AnnotationSpec) {
            ((AnnotationSpec) obj).emit(this, true);
        } else if (obj instanceof CodeBlock) {
            emit((CodeBlock) obj);
        } else {
            emitAndIndent(String.valueOf(obj));
        }
    }

    private boolean emitStaticImportMember(String str, String str2) {
        String strSubstring = str2.substring(1);
        if (strSubstring.isEmpty() || !Character.isJavaIdentifierStart(strSubstring.charAt(0))) {
            return false;
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(str, Extension.DOT);
        sbM781w.append(extractMemberName(strSubstring));
        String string = sbM781w.toString();
        String strM756B = AbstractC0541b.m756B(str, ".*");
        if (!this.staticImports.contains(string) && !this.staticImports.contains(strM756B)) {
            return false;
        }
        emitAndIndent(strSubstring);
        return true;
    }

    private static String extractMemberName(String str) {
        Util.checkArgument(Character.isJavaIdentifierStart(str.charAt(0)), "not an identifier: %s", str);
        for (int i = 1; i <= str.length(); i++) {
            if (!SourceVersion.isIdentifier(str.substring(0, i))) {
                return str.substring(0, i - 1);
            }
        }
        return str;
    }

    private void importableType(ClassName className) {
        ClassName className2;
        String strSimpleName;
        ClassName classNamePut;
        if (className.packageName().isEmpty() || this.alwaysQualify.contains(className.simpleName) || (classNamePut = this.importableTypes.put((strSimpleName = (className2 = className.topLevelClassName()).simpleName()), className2)) == null) {
            return;
        }
        this.importableTypes.put(strSimpleName, classNamePut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$emitTypeVariables$0(TypeVariableName typeVariableName) {
        this.currentTypeVariables.add(typeVariableName.name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$popTypeVariables$1(TypeVariableName typeVariableName) {
        this.currentTypeVariables.remove(typeVariableName.name);
    }

    private ClassName resolve(String str) {
        for (int size = this.typeSpecStack.size() - 1; size >= 0; size--) {
            if (this.typeSpecStack.get(size).nestedTypesSimpleNames.contains(str)) {
                return stackClassName(size, str);
            }
        }
        if (this.typeSpecStack.size() > 0 && Objects.equals(this.typeSpecStack.get(0).name, str)) {
            return ClassName.get(this.packageName, str, new String[0]);
        }
        ClassName className = this.importedTypes.get(str);
        if (className != null) {
            return className;
        }
        return null;
    }

    private ClassName stackClassName(int i, String str) {
        ClassName classNameNestedClass = ClassName.get(this.packageName, this.typeSpecStack.get(0).name, new String[0]);
        for (int i2 = 1; i2 <= i; i2++) {
            classNameNestedClass = classNameNestedClass.nestedClass(this.typeSpecStack.get(i2).name);
        }
        return classNameNestedClass.nestedClass(str);
    }

    public CodeWriter emit(String str) {
        return emitAndIndent(str);
    }

    public CodeWriter emitAndIndent(String str) {
        String[] strArrSplit = str.split("\\R", -1);
        int length = strArrSplit.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            String str2 = strArrSplit[i];
            if (!z) {
                if ((this.javadoc || this.comment) && this.trailingNewline) {
                    emitIndentation();
                    this.out.append(this.javadoc ? " *" : "//");
                }
                this.out.append("\n");
                this.trailingNewline = true;
                int i2 = this.statementLine;
                if (i2 != -1) {
                    if (i2 == 0) {
                        indent(2);
                    }
                    this.statementLine++;
                }
            }
            if (!str2.isEmpty()) {
                if (this.trailingNewline) {
                    emitIndentation();
                    if (this.javadoc) {
                        this.out.append(" * ");
                    } else if (this.comment) {
                        this.out.append("// ");
                    }
                }
                this.out.append(str2);
                this.trailingNewline = false;
            }
            i++;
            z = false;
        }
        return this;
    }

    public void emitAnnotations(List<AnnotationSpec> list, boolean z) {
        Iterator<AnnotationSpec> it = list.iterator();
        while (it.hasNext()) {
            it.next().emit(this, z);
            emit(z ? " " : "\n");
        }
    }

    public void emitComment(CodeBlock codeBlock) {
        this.trailingNewline = true;
        this.comment = true;
        try {
            emit(codeBlock);
            emit("\n");
        } finally {
            this.comment = false;
        }
    }

    public void emitJavadoc(CodeBlock codeBlock) {
        if (codeBlock.isEmpty()) {
            return;
        }
        emit("/**\n");
        this.javadoc = true;
        try {
            emit(codeBlock, true);
            this.javadoc = false;
            emit(" */\n");
        } catch (Throwable th) {
            this.javadoc = false;
            throw th;
        }
    }

    public void emitModifiers(Set<Modifier> set, Set<Modifier> set2) {
        if (set.isEmpty()) {
            return;
        }
        for (Modifier modifier : EnumSet.copyOf((Collection) set)) {
            if (!set2.contains(modifier)) {
                emitAndIndent(modifier.name().toLowerCase(Locale.US));
                emitAndIndent(" ");
            }
        }
    }

    public void emitTypeVariables(List<TypeVariableName> list) {
        if (list.isEmpty()) {
            return;
        }
        list.forEach(new C11722g(this, 1));
        emit("<");
        boolean z = true;
        for (TypeVariableName typeVariableName : list) {
            if (!z) {
                emit(SQLKeyword.COMMA);
            }
            emitAnnotations(typeVariableName.annotations, true);
            emit("$L", typeVariableName.name);
            Iterator<TypeName> it = typeVariableName.bounds.iterator();
            boolean z2 = true;
            while (it.hasNext()) {
                emit(z2 ? " extends $T" : " & $T", it.next());
                z2 = false;
            }
            z = false;
        }
        emit(">");
    }

    public CodeWriter emitWrappingSpace() {
        this.out.wrappingSpace(this.indentLevel + 2);
        return this;
    }

    public Map<String, ClassName> importedTypes() {
        return this.importedTypes;
    }

    public CodeWriter indent() {
        return indent(1);
    }

    public String lookupName(ClassName className) {
        String strSimpleName = className.topLevelClassName().simpleName();
        if (this.currentTypeVariables.contains(strSimpleName)) {
            return className.canonicalName;
        }
        ClassName classNameEnclosingClassName = className;
        boolean z = false;
        while (classNameEnclosingClassName != null) {
            ClassName classNameResolve = resolve(classNameEnclosingClassName.simpleName());
            boolean z2 = classNameResolve != null;
            if (classNameResolve != null && Objects.equals(classNameResolve.canonicalName, classNameEnclosingClassName.canonicalName)) {
                return String.join(Extension.DOT, className.simpleNames().subList(classNameEnclosingClassName.simpleNames().size() - 1, className.simpleNames().size()));
            }
            classNameEnclosingClassName = classNameEnclosingClassName.enclosingClassName();
            z = z2;
        }
        if (z) {
            return className.canonicalName;
        }
        if (Objects.equals(this.packageName, className.packageName())) {
            this.referencedNames.add(strSimpleName);
            return String.join(Extension.DOT, className.simpleNames());
        }
        if (!this.javadoc) {
            importableType(className);
        }
        return className.canonicalName;
    }

    public CodeWriter popPackage() {
        String str = this.packageName;
        String str2 = NO_PACKAGE;
        Util.checkState(str != str2, "package not set", new Object[0]);
        this.packageName = str2;
        return this;
    }

    public CodeWriter popType() {
        this.typeSpecStack.remove(r0.size() - 1);
        return this;
    }

    public void popTypeVariables(List<TypeVariableName> list) {
        list.forEach(new C11722g(this, 0));
    }

    public CodeWriter pushPackage(String str) {
        String str2 = this.packageName;
        Util.checkState(str2 == NO_PACKAGE, "package already set: %s", str2);
        this.packageName = (String) Util.checkNotNull(str, "packageName == null", new Object[0]);
        return this;
    }

    public CodeWriter pushType(TypeSpec typeSpec) {
        this.typeSpecStack.add(typeSpec);
        return this;
    }

    public Map<String, ClassName> suggestedImports() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.importableTypes);
        linkedHashMap.keySet().removeAll(this.referencedNames);
        return linkedHashMap;
    }

    public CodeWriter unindent() {
        return unindent(1);
    }

    public CodeWriter(Appendable appendable, String str, Set<String> set, Set<String> set2) {
        this(appendable, str, Collections.EMPTY_MAP, set, set2);
    }

    public CodeWriter emit(String str, Object... objArr) {
        return emit(CodeBlock.m13156of(str, objArr));
    }

    public CodeWriter indent(int i) {
        this.indentLevel += i;
        return this;
    }

    public CodeWriter unindent(int i) {
        Util.checkArgument(this.indentLevel - i >= 0, "cannot unindent %s from %s", Integer.valueOf(i), Integer.valueOf(this.indentLevel));
        this.indentLevel -= i;
        return this;
    }

    public CodeWriter(Appendable appendable, String str, Map<String, ClassName> map, Set<String> set, Set<String> set2) {
        this.javadoc = false;
        this.comment = false;
        this.packageName = NO_PACKAGE;
        this.typeSpecStack = new ArrayList();
        this.importableTypes = new LinkedHashMap();
        this.referencedNames = new LinkedHashSet();
        this.currentTypeVariables = new Multiset<>();
        this.statementLine = -1;
        this.out = new LineWrapper(appendable, str, 100);
        this.indent = (String) Util.checkNotNull(str, "indent == null", new Object[0]);
        this.importedTypes = (Map) Util.checkNotNull(map, "importedTypes == null", new Object[0]);
        this.staticImports = (Set) Util.checkNotNull(set, "staticImports == null", new Object[0]);
        this.alwaysQualify = (Set) Util.checkNotNull(set2, "alwaysQualify == null", new Object[0]);
        this.staticImportClassNames = new LinkedHashSet();
        for (String str2 : set) {
            this.staticImportClassNames.add(str2.substring(0, str2.lastIndexOf(46)));
        }
    }

    public CodeWriter emit(CodeBlock codeBlock) {
        return emit(codeBlock, false);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:53:0x00a4. Please report as an issue. */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public com.squareup.javapoet.CodeWriter emit(com.squareup.javapoet.CodeBlock r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.javapoet.CodeWriter.emit(com.squareup.javapoet.CodeBlock, boolean):com.squareup.javapoet.CodeWriter");
    }

    public void emitModifiers(Set<Modifier> set) {
        emitModifiers(set, Collections.EMPTY_SET);
    }
}
