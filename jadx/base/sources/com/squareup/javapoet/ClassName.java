package com.squareup.javapoet;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.SimpleElementVisitor8;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ClassName extends TypeName implements Comparable<ClassName> {
    private static final String NO_PACKAGE = "";
    public static final ClassName OBJECT = get((Class<?>) Object.class);
    final String canonicalName;
    final ClassName enclosingClassName;
    final String packageName;
    final String simpleName;
    private List<String> simpleNames;

    public static ClassName bestGuess(String str) {
        int iIndexOf = 0;
        while (true) {
            boolean z = true;
            if (iIndexOf >= str.length() || !Character.isLowerCase(str.codePointAt(iIndexOf))) {
                break;
            }
            iIndexOf = str.indexOf(46, iIndexOf) + 1;
            if (iIndexOf == 0) {
                z = false;
            }
            Util.checkArgument(z, "couldn't make a guess for %s", str);
        }
        String strSubstring = iIndexOf == 0 ? "" : str.substring(0, iIndexOf - 1);
        String[] strArrSplit = str.substring(iIndexOf).split(RemoteConstant.VERSION_DIVIDE, -1);
        int length = strArrSplit.length;
        ClassName className = null;
        int i = 0;
        while (i < length) {
            String str2 = strArrSplit[i];
            Util.checkArgument(!str2.isEmpty() && Character.isUpperCase(str2.codePointAt(0)), "couldn't make a guess for %s", str);
            i++;
            className = new ClassName(strSubstring, className, str2);
        }
        return className;
    }

    private List<ClassName> enclosingClasses() {
        ArrayList arrayList = new ArrayList();
        for (ClassName className = this; className != null; className = className.enclosingClassName) {
            arrayList.add(className);
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static ClassName get(Class<?> cls) {
        Util.checkNotNull(cls, "clazz == null", new Object[0]);
        Util.checkArgument(!cls.isPrimitive(), "primitive types cannot be represented as a ClassName", new Object[0]);
        Util.checkArgument(!Void.TYPE.equals(cls), "'void' type cannot be represented as a ClassName", new Object[0]);
        Util.checkArgument(!cls.isArray(), "array types cannot be represented as a ClassName", new Object[0]);
        String str = "";
        while (cls.isAnonymousClass()) {
            str = cls.getName().substring(cls.getName().lastIndexOf(36)) + str;
            cls = cls.getEnclosingClass();
        }
        String str2 = cls.getSimpleName() + str;
        if (cls.getEnclosingClass() != null) {
            return get(cls.getEnclosingClass()).nestedClass(str2);
        }
        int iLastIndexOf = cls.getName().lastIndexOf(46);
        return new ClassName(iLastIndexOf != -1 ? cls.getName().substring(0, iLastIndexOf) : "", null, str2);
    }

    @Override // com.squareup.javapoet.TypeName
    public /* bridge */ /* synthetic */ TypeName annotated(List list) {
        return annotated((List<AnnotationSpec>) list);
    }

    public String canonicalName() {
        return this.canonicalName;
    }

    @Override // com.squareup.javapoet.TypeName
    public CodeWriter emit(CodeWriter codeWriter) {
        String strLookupName;
        boolean z = false;
        for (ClassName className : enclosingClasses()) {
            if (z) {
                codeWriter.emit(Extension.DOT);
                strLookupName = className.simpleName;
            } else if (className.isAnnotated() || className == this) {
                strLookupName = codeWriter.lookupName(className);
                int iLastIndexOf = strLookupName.lastIndexOf(46);
                if (iLastIndexOf != -1) {
                    int i = iLastIndexOf + 1;
                    codeWriter.emitAndIndent(strLookupName.substring(0, i));
                    strLookupName = strLookupName.substring(i);
                    z = true;
                }
            }
            if (className.isAnnotated()) {
                if (z) {
                    codeWriter.emit(" ");
                }
                className.emitAnnotations(codeWriter);
            }
            codeWriter.emit(strLookupName);
            z = true;
        }
        return codeWriter;
    }

    public ClassName enclosingClassName() {
        return this.enclosingClassName;
    }

    @Override // com.squareup.javapoet.TypeName
    public boolean isAnnotated() {
        if (super.isAnnotated()) {
            return true;
        }
        ClassName className = this.enclosingClassName;
        return className != null && className.isAnnotated();
    }

    public ClassName nestedClass(String str) {
        return new ClassName(this.packageName, this, str);
    }

    public String packageName() {
        return this.packageName;
    }

    public ClassName peerClass(String str) {
        return new ClassName(this.packageName, this.enclosingClassName, str);
    }

    public String reflectionName() {
        if (this.enclosingClassName != null) {
            return this.enclosingClassName.reflectionName() + '$' + this.simpleName;
        }
        if (this.packageName.isEmpty()) {
            return this.simpleName;
        }
        return this.packageName + '.' + this.simpleName;
    }

    public String simpleName() {
        return this.simpleName;
    }

    public List<String> simpleNames() {
        List<String> list = this.simpleNames;
        if (list != null) {
            return list;
        }
        if (this.enclosingClassName == null) {
            this.simpleNames = Collections.singletonList(this.simpleName);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(enclosingClassName().simpleNames());
            arrayList.add(this.simpleName);
            this.simpleNames = Collections.unmodifiableList(arrayList);
        }
        return this.simpleNames;
    }

    public ClassName topLevelClassName() {
        ClassName className = this.enclosingClassName;
        return className != null ? className.topLevelClassName() : this;
    }

    private ClassName(String str, ClassName className, String str2) {
        this(str, className, str2, (List<AnnotationSpec>) Collections.EMPTY_LIST);
    }

    @Override // com.squareup.javapoet.TypeName
    public ClassName annotated(List<AnnotationSpec> list) {
        return new ClassName(this.packageName, this.enclosingClassName, this.simpleName, concatAnnotations(list));
    }

    @Override // java.lang.Comparable
    public int compareTo(ClassName className) {
        return this.canonicalName.compareTo(className.canonicalName);
    }

    @Override // com.squareup.javapoet.TypeName
    public ClassName withoutAnnotations() {
        if (!isAnnotated()) {
            return this;
        }
        ClassName className = this.enclosingClassName;
        return new ClassName(this.packageName, className != null ? className.withoutAnnotations() : null, this.simpleName);
    }

    private ClassName(String str, ClassName className, String str2, List<AnnotationSpec> list) {
        super(list);
        Objects.requireNonNull(str, "packageName == null");
        this.packageName = str;
        this.enclosingClassName = className;
        this.simpleName = str2;
        if (className != null) {
            str2 = className.canonicalName + '.' + str2;
        } else if (!str.isEmpty()) {
            str2 = AbstractC1038a.m1212m('.', str, str2);
        }
        this.canonicalName = str2;
    }

    public static ClassName get(String str, String str2, String... strArr) {
        ClassName className = new ClassName(str, null, str2);
        for (String str3 : strArr) {
            className = className.nestedClass(str3);
        }
        return className;
    }

    public static ClassName get(final TypeElement typeElement) {
        Util.checkNotNull(typeElement, "element == null", new Object[0]);
        final String string = typeElement.getSimpleName().toString();
        return (ClassName) typeElement.getEnclosingElement().accept(new SimpleElementVisitor8<ClassName, Void>() { // from class: com.squareup.javapoet.ClassName.1
            public ClassName defaultAction(Element element, Void r32) {
                throw new IllegalArgumentException("Unexpected type nesting: " + typeElement);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public ClassName visitPackage(PackageElement packageElement, Void r4) {
                return new ClassName(packageElement.getQualifiedName().toString(), (ClassName) null, string);
            }

            public ClassName visitType(TypeElement typeElement2, Void r2) {
                return ClassName.get(typeElement2).nestedClass(string);
            }

            public ClassName visitUnknown(Element element, Void r32) {
                return ClassName.get("", string, new String[0]);
            }
        }, (Object) null);
    }
}
