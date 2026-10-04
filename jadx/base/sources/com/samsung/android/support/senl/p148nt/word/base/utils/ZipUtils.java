package com.samsung.android.support.senl.p148nt.word.base.utils;

import android.os.CancellationSignal;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import kotlin.text.StringsKt;
import org.apache.poi.util.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u000eJ(\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fR\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/utils/ZipUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "unZip", "", "zipFile", "zip", "folder", "Ljava/io/File;", "cancellationSignal", "Landroid/os/CancellationSignal;", "zipFolder", "outputStream", "Ljava/io/OutputStream;", "processFolder", "zipOutputStream", "Ljava/util/zip/ZipOutputStream;", "prefixLength", "", "deleteDirectory", "", "directoryToBeDeleted", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nZipUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipUtils.kt\ncom/samsung/android/support/senl/nt/word/base/utils/ZipUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
public final class ZipUtils {

    @NotNull
    public static final ZipUtils INSTANCE = new ZipUtils();
    private static final String TAG = Logger.createTag("ZipUtils");

    private ZipUtils() {
    }

    private final void processFolder(File folder, ZipOutputStream zipOutputStream, int prefixLength, CancellationSignal cancellationSignal) throws IOException {
        File[] fileArrListFiles = folder.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (cancellationSignal.isCanceled()) {
                return;
            }
            if (file.isFile()) {
                String path = file.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                String strSubstring = path.substring(prefixLength);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                zipOutputStream.putNextEntry(new ZipEntry(strSubstring));
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    IOUtils.copy(fileInputStream, zipOutputStream);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    zipOutputStream.closeEntry();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileInputStream, th);
                        throw th2;
                    }
                }
            } else if (file.isDirectory()) {
                Intrinsics.checkNotNull(file);
                processFolder(file, zipOutputStream, prefixLength, cancellationSignal);
            }
        }
    }

    public final boolean deleteDirectory(@NotNull File directoryToBeDeleted) {
        Intrinsics.checkNotNullParameter(directoryToBeDeleted, "directoryToBeDeleted");
        File[] fileArrListFiles = directoryToBeDeleted.listFiles();
        if (fileArrListFiles != null) {
            Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
            while (it.hasNext()) {
                File file = (File) it.next();
                Intrinsics.checkNotNull(file);
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    /* JADX WARN: Finally extract failed */
    public final void unZip(@NotNull String zipFile) {
        Intrinsics.checkNotNullParameter(zipFile, "zipFile");
        Logger.m10999d(TAG, "zipFile " + zipFile);
        ZipFile zipFile2 = new ZipFile(new File(zipFile));
        try {
            String strSubstring = zipFile.substring(0, StringsKt.m14130D(zipFile, '.'));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            File file = new File(strSubstring);
            if (!file.mkdir() && !file.exists()) {
                throw new Exception("Make directory failed");
            }
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
            Intrinsics.checkNotNullExpressionValue(enumerationEntries, "entries(...)");
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                Intrinsics.checkNotNull(zipEntryNextElement, "null cannot be cast to non-null type java.util.zip.ZipEntry");
                ZipEntry zipEntry = zipEntryNextElement;
                String name = zipEntry.getName();
                File file2 = new File(strSubstring, name);
                String canonicalPath = file2.getCanonicalPath();
                Intrinsics.checkNotNull(canonicalPath);
                if (!StringsKt.m14145S(canonicalPath, strSubstring)) {
                    throw new SecurityException("canonicalPath is not start with path");
                }
                File parentFile = file2.getParentFile();
                if (parentFile == null) {
                    throw new IOException("Invalid parent");
                }
                if (!parentFile.mkdirs() && !parentFile.exists()) {
                    throw new Exception("Make directory failed");
                }
                if (!zipEntry.isDirectory()) {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntry));
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        try {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 2048);
                            try {
                                byte[] bArr = new byte[2048];
                                while (true) {
                                    int i = bufferedInputStream.read(bArr, 0, 2048);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        bufferedOutputStream.write(bArr, 0, i);
                                    }
                                }
                                bufferedOutputStream.flush();
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(bufferedOutputStream, null);
                                CloseableKt.closeFinally(fileOutputStream, null);
                                CloseableKt.closeFinally(bufferedInputStream, null);
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CloseableKt.closeFinally(bufferedOutputStream, th);
                                    throw th2;
                                }
                            }
                        } finally {
                        }
                    } finally {
                    }
                }
                Intrinsics.checkNotNull(name);
                if (StringsKt.m14167w(name, Constants.ZIP_EXTENSION_WITH_DOT)) {
                    ZipUtils zipUtils = INSTANCE;
                    String absolutePath = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                    zipUtils.unZip(absolutePath);
                }
            }
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(zipFile2, null);
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(zipFile2, th3);
                throw th4;
            }
        }
    }

    public final void zip(@NotNull File folder, @Nullable File zipFile, @NotNull CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
        try {
            INSTANCE.zipFolder(folder, fileOutputStream, cancellationSignal);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    public final void zipFolder(@NotNull File folder, @Nullable OutputStream outputStream, @NotNull CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        try {
            if (cancellationSignal.isCanceled()) {
                CloseableKt.closeFinally(zipOutputStream, null);
                return;
            }
            INSTANCE.processFolder(folder, zipOutputStream, folder.getPath().length() + 1, cancellationSignal);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zipOutputStream, null);
        } finally {
        }
    }
}
