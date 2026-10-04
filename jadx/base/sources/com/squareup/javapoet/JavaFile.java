package com.squareup.javapoet;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.squareup.javapoet.CodeBlock;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class JavaFile {
    private static final Appendable NULL_APPENDABLE = new Appendable() { // from class: com.squareup.javapoet.JavaFile.1
        @Override // java.lang.Appendable
        public Appendable append(char c) {
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) {
            return this;
        }
    };
    private final Set<String> alwaysQualify;
    public final CodeBlock fileComment;
    private final String indent;
    public final String packageName;
    public final boolean skipJavaLangImports;
    private final Set<String> staticImports;
    public final TypeSpec typeSpec;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private final CodeBlock.Builder fileComment;
        private String indent;
        private final String packageName;
        private boolean skipJavaLangImports;
        public final Set<String> staticImports;
        private final TypeSpec typeSpec;

        public Builder addFileComment(String str, Object... objArr) {
            this.fileComment.add(str, objArr);
            return this;
        }

        public Builder addStaticImport(Enum<?> r2) {
            return addStaticImport(ClassName.get((Class<?>) r2.getDeclaringClass()), r2.name());
        }

        public JavaFile build() {
            return new JavaFile(this);
        }

        public Builder indent(String str) {
            this.indent = str;
            return this;
        }

        public Builder skipJavaLangImports(boolean z) {
            this.skipJavaLangImports = z;
            return this;
        }

        private Builder(String str, TypeSpec typeSpec) {
            this.fileComment = CodeBlock.builder();
            this.indent = Constant.WHITE_SPACE_FOR_LINK_ICON;
            this.staticImports = new TreeSet();
            this.packageName = str;
            this.typeSpec = typeSpec;
        }

        public Builder addStaticImport(Class<?> cls, String... strArr) {
            return addStaticImport(ClassName.get(cls), strArr);
        }

        public Builder addStaticImport(ClassName className, String... strArr) {
            Util.checkArgument(className != null, "className == null", new Object[0]);
            Util.checkArgument(strArr != null, "names == null", new Object[0]);
            Util.checkArgument(strArr.length > 0, "names array is empty", new Object[0]);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                Util.checkArgument(str != null, "null entry in names array: %s", Arrays.toString(strArr));
                this.staticImports.add(className.canonicalName + Extension.DOT + str);
            }
            return this;
        }
    }

    private static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (th != null) {
            try {
                AbstractC2322a.m1634x(autoCloseable);
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                return;
            }
        }
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
                return;
            } else if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
                return;
            } else {
                if (!(autoCloseable instanceof MediaDrm)) {
                    throw new IllegalArgumentException();
                }
                ((MediaDrm) autoCloseable).release();
                return;
            }
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static Builder builder(String str, TypeSpec typeSpec) {
        Util.checkNotNull(str, "packageName == null", new Object[0]);
        Util.checkNotNull(typeSpec, "typeSpec == null", new Object[0]);
        return new Builder(str, typeSpec);
    }

    private void emit(CodeWriter codeWriter) {
        codeWriter.pushPackage(this.packageName);
        if (!this.fileComment.isEmpty()) {
            codeWriter.emitComment(this.fileComment);
        }
        if (!this.packageName.isEmpty()) {
            codeWriter.emit("package $L;\n", this.packageName);
            codeWriter.emit("\n");
        }
        if (!this.staticImports.isEmpty()) {
            Iterator<String> it = this.staticImports.iterator();
            while (it.hasNext()) {
                codeWriter.emit("import static $L;\n", it.next());
            }
            codeWriter.emit("\n");
        }
        int i = 0;
        for (ClassName className : new TreeSet(codeWriter.importedTypes().values())) {
            if (!this.skipJavaLangImports || !className.packageName().equals("java.lang") || this.alwaysQualify.contains(className.simpleName)) {
                codeWriter.emit("import $L;\n", className.withoutAnnotations());
                i++;
            }
        }
        if (i > 0) {
            codeWriter.emit("\n");
        }
        this.typeSpec.emit(codeWriter, null, Collections.EMPTY_SET);
        codeWriter.popPackage();
    }

    private void fillAlwaysQualifiedNames(TypeSpec typeSpec, Set<String> set) {
        set.addAll(typeSpec.alwaysQualifiedNames);
        Iterator<TypeSpec> it = typeSpec.typeSpecs.iterator();
        while (it.hasNext()) {
            fillAlwaysQualifiedNames(it.next(), set);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && JavaFile.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public Builder toBuilder() {
        Builder builder = new Builder(this.packageName, this.typeSpec);
        builder.fileComment.add(this.fileComment);
        builder.skipJavaLangImports = this.skipJavaLangImports;
        builder.indent = this.indent;
        return builder;
    }

    public JavaFileObject toJavaFileObject() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.packageName.isEmpty()) {
            str = this.typeSpec.name;
        } else {
            str = this.packageName.replace('.', '/') + '/' + this.typeSpec.name;
        }
        sb.append(str);
        sb.append(JavaFileObject.Kind.SOURCE.extension);
        return new SimpleJavaFileObject(URI.create(sb.toString()), JavaFileObject.Kind.SOURCE) { // from class: com.squareup.javapoet.JavaFile.2
            private final long lastModified = System.currentTimeMillis();

            public long getLastModified() {
                return this.lastModified;
            }

            public InputStream openInputStream() {
                return new ByteArrayInputStream(getCharContent(true).getBytes(StandardCharsets.UTF_8));
            }

            public String getCharContent(boolean z) {
                return JavaFile.this.toString();
            }
        };
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            writeTo(sb);
            return sb.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public void writeTo(Appendable appendable) {
        CodeWriter codeWriter = new CodeWriter(NULL_APPENDABLE, this.indent, this.staticImports, this.alwaysQualify);
        emit(codeWriter);
        emit(new CodeWriter(appendable, this.indent, codeWriter.suggestedImports(), this.staticImports, this.alwaysQualify));
    }

    public File writeToFile(File file) {
        return writeToPath(file.toPath()).toFile();
    }

    public Path writeToPath(Path path) {
        return writeToPath(path, StandardCharsets.UTF_8);
    }

    private JavaFile(Builder builder) {
        this.fileComment = builder.fileComment.build();
        this.packageName = builder.packageName;
        this.typeSpec = builder.typeSpec;
        this.skipJavaLangImports = builder.skipJavaLangImports;
        this.staticImports = Util.immutableSet(builder.staticImports);
        this.indent = builder.indent;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        fillAlwaysQualifiedNames(builder.typeSpec, linkedHashSet);
        this.alwaysQualify = Util.immutableSet(linkedHashSet);
    }

    public Path writeToPath(Path path, Charset charset) throws Exception {
        Util.checkArgument(Files.notExists(path, new LinkOption[0]) || Files.isDirectory(path, new LinkOption[0]), "path %s exists but is not a directory.", path);
        if (!this.packageName.isEmpty()) {
            for (String str : this.packageName.split(RemoteConstant.VERSION_DIVIDE)) {
                path = path.resolve(str);
            }
            Files.createDirectories(path, new FileAttribute[0]);
        }
        Path pathResolve = path.resolve(this.typeSpec.name + ".java");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(pathResolve, new OpenOption[0]), charset);
        try {
            writeTo(outputStreamWriter);
            $closeResource(null, outputStreamWriter);
            return pathResolve;
        } finally {
        }
    }

    public void writeTo(Path path) {
        writeToPath(path);
    }

    public void writeTo(Path path, Charset charset) throws Exception {
        writeToPath(path, charset);
    }

    public void writeTo(File file) {
        writeTo(file.toPath());
    }

    public void writeTo(Filer filer) throws Exception {
        String str;
        if (this.packageName.isEmpty()) {
            str = this.typeSpec.name;
        } else {
            str = this.packageName + Extension.DOT + this.typeSpec.name;
        }
        List<Element> list = this.typeSpec.originatingElements;
        JavaFileObject javaFileObjectCreateSourceFile = filer.createSourceFile(str, (Element[]) list.toArray(new Element[list.size()]));
        try {
            Writer writerOpenWriter = javaFileObjectCreateSourceFile.openWriter();
            try {
                writeTo(writerOpenWriter);
                if (writerOpenWriter != null) {
                    $closeResource(null, writerOpenWriter);
                }
            } finally {
            }
        } catch (Exception e) {
            try {
                javaFileObjectCreateSourceFile.delete();
            } catch (Exception unused) {
            }
            throw e;
        }
    }
}
