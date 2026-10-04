package kotlin.p196io;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007\u001a*\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007\u001a\u0012\u0010\u000e\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0012\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0012\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u0003*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u0014\u001a&\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a8\u0010\u001b\u001a\u00020\u0018*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001a\b\u0002\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d\u001a\n\u0010 \u001a\u00020\u0018*\u00020\u0001\u001a\u0012\u0010!\u001a\u00020\u0018*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001\u001a\u0012\u0010!\u001a\u00020\u0018*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0003\u001a\u0012\u0010#\u001a\u00020\u0018*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001\u001a\u0012\u0010#\u001a\u00020\u0018*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0003\u001a\n\u0010$\u001a\u00020\u0001*\u00020\u0001\u001a\u0011\u0010$\u001a\u00020%*\u00020%H\u0002¢\u0006\u0002\b&\u001a\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010'*\b\u0012\u0004\u0012\u00020\u00010'H\u0002¢\u0006\u0002\b&\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00012\u0006\u0010)\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00012\u0006\u0010)\u001a\u00020\u0003\u001a\u0012\u0010*\u001a\u00020\u0001*\u00020\u00012\u0006\u0010)\u001a\u00020\u0001\u001a\u0012\u0010*\u001a\u00020\u0001*\u00020\u00012\u0006\u0010)\u001a\u00020\u0003\"\u0015\u0010\u0007\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0015\u0010\n\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\"\u0015\u0010\f\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006+"}, m13886d2 = {"createTempDir", "Ljava/io/File;", "prefix", "", "suffix", "directory", "createTempFile", BundleContract.EXTRA_DATA, "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "toRelativeString", "base", "relativeTo", "relativeToOrSelf", "relativeToOrNull", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "copyTo", "target", "overwrite", "", "bufferSize", "", "copyRecursively", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "deleteRecursively", "startsWith", "other", "endsWith", "normalize", "Lkotlin/io/FilePathComponents;", "normalize$FilesKt__UtilsKt", "", "resolve", "relative", "resolveSibling", "kotlin-stdlib"}, m13887k = 5, m13888mv = {2, 1, 0}, m13890xi = 49, m13891xs = "kotlin/io/FilesKt")
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,473:1\n1#2:474\n1292#3,3:475\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n*L\n347#1:475,3\n*E\n"})
public class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public static final boolean copyRecursively(@NotNull File file, @NotNull File target, boolean z, @NotNull final Function2<? super File, ? super IOException, ? extends OnErrorAction> onError) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (!file.exists()) {
            return onError.invoke(file, new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE;
        }
        try {
            for (File file2 : FilesKt__FileTreeWalkKt.walkTopDown(file).onFail(new Function2() { // from class: kotlin.io.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesKt__UtilsKt.copyRecursively$lambda$4$FilesKt__UtilsKt(onError, (File) obj, (IOException) obj2);
                }
            })) {
                if (file2.exists()) {
                    File file3 = new File(target, toRelativeString(file2, file));
                    if (file3.exists() && (!file2.isDirectory() || !file3.isDirectory())) {
                        if (z) {
                            if (file3.isDirectory()) {
                                if (!deleteRecursively(file3)) {
                                }
                            } else if (!file3.delete()) {
                            }
                        }
                        if (onError.invoke(file3, new FileAlreadyExistsException(file2, file3, "The destination file already exists.")) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                    }
                    if (file2.isDirectory()) {
                        file3.mkdirs();
                    } else {
                        boolean z2 = z;
                        if (copyTo$default(file2, file3, z2, 0, 4, null).length() != file2.length() && onError.invoke(file2, new IOException("Source file wasn't copied completely, length of destination file differs.")) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                        z = z2;
                    }
                } else if (onError.invoke(file2, new NoSuchFileException(file2, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) {
                    return false;
                }
            }
            return true;
        } catch (TerminateException unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean copyRecursively$default(File file, File file2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function2 = new Function2() { // from class: kotlin.io.FilesKt__UtilsKt.copyRecursively.1
                @Override // kotlin.jvm.functions.Function2
                public final Void invoke(File file3, IOException exception) throws IOException {
                    Intrinsics.checkNotNullParameter(file3, "<unused var>");
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    throw exception;
                }
            };
        }
        return copyRecursively(file, file2, z, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyRecursively$lambda$4$FilesKt__UtilsKt(Function2 function2, File f, IOException e) throws TerminateException {
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(e, "e");
        if (function2.invoke(f, e) != OnErrorAction.TERMINATE) {
            return Unit.INSTANCE;
        }
        throw new TerminateException(f);
    }

    @NotNull
    public static final File copyTo(@NotNull File file, @NotNull File target, boolean z, int i) throws FileSystemException {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z) {
                throw new FileAlreadyExistsException(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new FileAlreadyExistsException(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (file.isDirectory()) {
            if (target.mkdirs()) {
                return target;
            }
            throw new FileSystemException(file, target, "Failed to create target directory.");
        }
        File parentFile = target.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(target);
            try {
                ByteStreamsKt.copyTo(fileInputStream, fileOutputStream, i);
                CloseableKt.closeFinally(fileOutputStream, null);
                CloseableKt.closeFinally(fileInputStream, null);
                return target;
            } finally {
            }
        } finally {
        }
    }

    public static /* synthetic */ File copyTo$default(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 8192;
        }
        return copyTo(file, file2, z, i);
    }

    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @NotNull
    public static final File createTempDir(@NotNull String prefix, @Nullable String str, @Nullable File file) throws IOException {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File fileCreateTempFile = File.createTempFile(prefix, str, file);
        fileCreateTempFile.delete();
        if (fileCreateTempFile.mkdir()) {
            Intrinsics.checkNotNull(fileCreateTempFile);
            return fileCreateTempFile;
        }
        throw new IOException("Unable to create temporary directory " + fileCreateTempFile + '.');
    }

    public static /* synthetic */ File createTempDir$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return createTempDir(str, str2, file);
    }

    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @NotNull
    public static final File createTempFile(@NotNull String prefix, @Nullable String str, @Nullable File file) throws IOException {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File fileCreateTempFile = File.createTempFile(prefix, str, file);
        Intrinsics.checkNotNullExpressionValue(fileCreateTempFile, "createTempFile(...)");
        return fileCreateTempFile;
    }

    public static /* synthetic */ File createTempFile$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return createTempFile(str, str2, file);
    }

    public static final boolean deleteRecursively(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        while (true) {
            boolean z = true;
            for (File file2 : FilesKt__FileTreeWalkKt.walkBottomUp(file)) {
                if (!file2.delete() && file2.exists()) {
                    z = false;
                } else {
                    if (z) {
                        break;
                    }
                    z = false;
                }
            }
            return z;
        }
    }

    public static final boolean endsWith(@NotNull File file, @NotNull File other) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(other);
        if (components2.isRooted()) {
            return Intrinsics.areEqual(file, other);
        }
        int size = components.getSize() - components2.getSize();
        if (size < 0) {
            return false;
        }
        return components.getSegments().subList(size, components.getSize()).equals(components2.getSegments());
    }

    @NotNull
    public static String getExtension(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt__StringsKt.substringAfterLast(name, '.', "");
    }

    @NotNull
    public static final String getInvariantSeparatorsPath(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        char c = File.separatorChar;
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return c != '/' ? StringsKt__StringsJVMKt.replace$default(path, c, '/', false, 4, (Object) null) : path;
    }

    @NotNull
    public static final String getNameWithoutExtension(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.m14154b0(name, Extension.DOT);
    }

    @NotNull
    public static final File normalize(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        File root = components.getRoot();
        List<File> listNormalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(components.getSegments());
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        return resolve(root, CollectionsKt.m13955n(listNormalize$FilesKt__UtilsKt, separator, null, null, null, 62));
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.getRoot(), normalize$FilesKt__UtilsKt(filePathComponents.getSegments()));
    }

    @NotNull
    public static final File relativeTo(@NotNull File file, @NotNull File base) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        return new File(toRelativeString(file, base));
    }

    @Nullable
    public static final File relativeToOrNull(@NotNull File file, @NotNull File base) throws IOException {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, base);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return new File(relativeStringOrNull$FilesKt__UtilsKt);
        }
        return null;
    }

    @NotNull
    public static final File relativeToOrSelf(@NotNull File file, @NotNull File base) throws IOException {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, base);
        return relativeStringOrNull$FilesKt__UtilsKt != null ? new File(relativeStringOrNull$FilesKt__UtilsKt) : file;
    }

    @NotNull
    public static final File resolve(@NotNull File file, @NotNull File relative) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        if (FilesKt__FilePathComponentsKt.isRooted(relative)) {
            return relative;
        }
        String string = file.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (string.length() != 0) {
            char c = File.separatorChar;
            if (!StringsKt__StringsKt.endsWith$default((CharSequence) string, c, false, 2, (Object) null)) {
                return new File(string + c + relative);
            }
        }
        return new File(string + relative);
    }

    @NotNull
    public static final File resolveSibling(@NotNull File file, @NotNull File relative) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        return resolve(resolve(components.getRoot(), components.getSize() == 0 ? new File("..") : components.subPath(0, components.getSize() - 1)), relative);
    }

    public static final boolean startsWith(@NotNull File file, @NotNull File other) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(other);
        if (Intrinsics.areEqual(components.getRoot(), components2.getRoot()) && components.getSize() >= components2.getSize()) {
            return components.getSegments().subList(0, components2.getSize()).equals(components2.getSegments());
        }
        return false;
    }

    @NotNull
    public static final String toRelativeString(@NotNull File file, @NotNull File base) throws IOException {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, base);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return relativeStringOrNull$FilesKt__UtilsKt;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + base + '.');
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File file, File file2) throws IOException {
        FilePathComponents filePathComponentsNormalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file));
        FilePathComponents filePathComponentsNormalize$FilesKt__UtilsKt2 = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file2));
        if (!Intrinsics.areEqual(filePathComponentsNormalize$FilesKt__UtilsKt.getRoot(), filePathComponentsNormalize$FilesKt__UtilsKt2.getRoot())) {
            return null;
        }
        int size = filePathComponentsNormalize$FilesKt__UtilsKt2.getSize();
        int size2 = filePathComponentsNormalize$FilesKt__UtilsKt.getSize();
        int iMin = Math.min(size2, size);
        int i = 0;
        while (i < iMin && Intrinsics.areEqual(filePathComponentsNormalize$FilesKt__UtilsKt.getSegments().get(i), filePathComponentsNormalize$FilesKt__UtilsKt2.getSegments().get(i))) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = size - 1;
        if (i <= i2) {
            while (!Intrinsics.areEqual(filePathComponentsNormalize$FilesKt__UtilsKt2.getSegments().get(i2).getName(), "..")) {
                sb.append("..");
                if (i2 != i) {
                    sb.append(File.separatorChar);
                }
                if (i2 != i) {
                    i2--;
                }
            }
            return null;
        }
        if (i < size2) {
            if (i < size) {
                sb.append(File.separatorChar);
            }
            List listDrop = CollectionsKt.drop(filePathComponentsNormalize$FilesKt__UtilsKt.getSegments(), i);
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            CollectionsKt___CollectionsKt.joinTo(listDrop, sb, (124 & 2) != 0 ? SQLKeyword.COMMA : separator, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        return sb.toString();
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (!Intrinsics.areEqual(name, Extension.DOT)) {
                if (!Intrinsics.areEqual(name, "..")) {
                    arrayList.add(file);
                } else if (arrayList.isEmpty() || Intrinsics.areEqual(((File) CollectionsKt.last((List) arrayList)).getName(), "..")) {
                    arrayList.add(file);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public static final File resolve(@NotNull File file, @NotNull String relative) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        return resolve(file, new File(relative));
    }

    @NotNull
    public static final File resolveSibling(@NotNull File file, @NotNull String relative) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        return resolveSibling(file, new File(relative));
    }

    public static final boolean startsWith(@NotNull File file, @NotNull String other) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return startsWith(file, new File(other));
    }

    public static final boolean endsWith(@NotNull File file, @NotNull String other) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return endsWith(file, new File(other));
    }
}
