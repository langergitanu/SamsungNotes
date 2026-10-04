package com.samsung.android.support.senl.p148nt.base.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.firebase.messaging.Constants;
import com.samsung.android.mcf.continuity.interfaces.ContinuityBundleFactory;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.p196io.CloseableKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u000e\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005J\u001c\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0007J(\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000fH\u0007J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012H\u0007J\u0010\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u0005J\u0012\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010%\u001a\u00020&2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010'\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010(\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010)\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007J\u001a\u0010+\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0005H\u0007J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0005J\u0018\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010/\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0005H\u0007J\u0010\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0005H\u0007J\u0018\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0007J\u0018\u00107\u001a\u00020\u00052\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0007J\u0010\u00108\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007J\u0010\u00109\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u000104J\"\u0010:\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u00052\u0006\u0010<\u001a\u00020\u000fH\u0007J\u0014\u0010=\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u000104H\u0007J\u0012\u0010>\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u000104H\u0007J \u0010?\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0005H\u0007J\u0018\u0010?\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0005H\u0007J\u0010\u0010?\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0007J\u0018\u0010B\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0007J\u000e\u0010D\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0005J\u0018\u0010%\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0007J\u0018\u0010E\u001a\u00020\u00052\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0007J \u0010E\u001a\u00020\u00052\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010F\u001a\u00020\u000fH\u0002J\u0018\u0010G\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012H\u0007J(\u0010G\u001a\u00020\u00142\u000e\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050I2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012H\u0007J\u001c\u0010J\u001a\u00020\u00142\b\u0010K\u001a\u0004\u0018\u00010\u00052\b\u0010L\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010M\u001a\u00020\u00142\b\u0010K\u001a\u0004\u0018\u00010\u00052\b\u0010L\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005H\u0007J \u0010R\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020UH\u0002J\u001e\u0010V\u001a\u00020\u000b2\u0006\u00103\u001a\u0002042\u0006\u0010W\u001a\u00020\u00122\u0006\u0010X\u001a\u000206J \u0010Y\u001a\u00020\u000b2\u0006\u00103\u001a\u0002042\u0006\u0010W\u001a\u00020\u00122\u0006\u0010X\u001a\u000206H\u0002J\u001e\u0010Z\u001a\u00020\u000f2\u0006\u00103\u001a\u0002042\u0006\u0010[\u001a\u0002062\u0006\u0010\\\u001a\u00020\u0012J\"\u0010]\u001a\u0004\u0018\u0001062\u0006\u00103\u001a\u0002042\u0006\u0010^\u001a\u0002062\u0006\u0010_\u001a\u00020\u0005H\u0002J*\u0010`\u001a\u0004\u0018\u0001062\u0006\u00103\u001a\u0002042\u0006\u0010^\u001a\u0002062\u0006\u0010$\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\u0005H\u0002J\u001a\u0010b\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020\u00122\b\u0010c\u001a\u0004\u0018\u00010dH\u0002J\u001c\u0010e\u001a\u00020\u000f2\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010dH\u0002J\u0010\u0010i\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0005H\u0007J\u001a\u0010j\u001a\u00020\u000f2\b\u0010k\u001a\u0004\u0018\u00010\u00122\u0006\u0010l\u001a\u00020\u0005H\u0007JB\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00120I2\u0006\u0010\u0011\u001a\u00020\u00122\u0010\u0010n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010I2\u0010\u0010o\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010I2\u0006\u0010p\u001a\u00020\u000fH\u0007J\u0016\u0010q\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010r\u001a\u00020\u000fJ\u0010\u0010s\u001a\u00020&2\u0006\u0010\"\u001a\u00020\u0005H\u0007J\u0012\u0010t\u001a\u0004\u0018\u00010\u00052\u0006\u0010u\u001a\u00020\u0005H\u0007J\u0010\u0010v\u001a\u00020&2\u0006\u0010w\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006x"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/FileUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DOWNLOAD_FOLDER_NAME", ContinuityBundleFactory.KEY_DISPLAY_NAME, "FIND_FILE_EXCEPT_EXCEPTIONAL_CASE", "STR_USER_MODE", "DEFAULT_BUF_SIZE", "", "logPath", "filePath", "deleteFile", "", "log", "dir", "Ljava/io/File;", "deleteDirRecursive", "", "forceRenameTo", "curPath", "newPath", "copyFile", "sourceFile", "destFile", "sourceLocation", "targetLocation", "isOverwriteDestFile", "toLowerCase", "copyFileExceptUpdated", "readFile", "", "path", "getFileExt", "fileName", "getFileSize", "", "exists", "extractFile", "extractFileName", "extractFileExtension", "findFile", "targetName", "directory", "findFileExcept", "createNewFile", "makeDirectory", "directoryPath", "getFileNameFromUriWithoutExt", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "getFileNameFromUri", "getFileNameFromFilePath", "getCacheDirPath", "printDirectory", "includedString", "fileLogging", "getDownloadDir", "getDownloadDirWithFileSeparator", "generateUniqueFilePath", BundleContract.EXTRA_DATA, "fileFullName", "generateUniqueFilePathNoExtension", "fileNameWithNoExtension", "isAndroidDir", "getExtensionFromUri", "includeMimeTypeMap", "copyDirectory", "restoreData", "", "moveFile", Constants.MessagePayloadKeys.FROM, "to", "moveFiles", "BUFFER_SIZE", "zip", "sourcePath", "zipPath", "zipEntry", "baseSourcePath", "zos", "Ljava/util/zip/ZipOutputStream;", "copyFileToDirUri", "srcFile", "dstUri", "copyFileToFileUri", "copyUriToFile", "srcUri", "dstFile", "createDirectory", "parentUri", "directoryName", "createFile", "mimeType", "copyFileToStream", "outputStream", "Ljava/io/OutputStream;", "copyStream", "in", "Ljava/io/InputStream;", "out", "isFileExists", "mkFile", "outFile", "inData", "exploredFolder", "exts", "exceptFile", "isSkipNoMedia", "getFileName", "exceptExt", "getStorageSize", "getParentDirectory", "source", "getDirectorySize", "parentDir", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFileUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/FileUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1216:1\n1#2:1217\n739#3,9:1218\n739#3,9:1231\n739#3,9:1244\n739#3,9:1257\n37#4:1227\n36#4,3:1228\n37#4:1240\n36#4,3:1241\n37#4:1253\n36#4,3:1254\n37#4:1266\n36#4,3:1267\n13472#5,2:1270\n*S KotlinDebug\n*F\n+ 1 FileUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/FileUtils\n*L\n390#1:1218,9\n406#1:1231,9\n537#1:1244,9\n560#1:1257,9\n391#1:1227\n391#1:1228,3\n406#1:1240\n406#1:1241,3\n537#1:1253\n537#1:1254,3\n560#1:1266\n560#1:1267,3\n824#1:1270,2\n*E\n"})
public final class FileUtils {
    private static final int BUFFER_SIZE = 10240;
    private static final int DEFAULT_BUF_SIZE = 32768;

    @NotNull
    public static final String DOWNLOAD_FOLDER_NAME = "download";

    @NotNull
    private static final String FIND_FILE_EXCEPT_EXCEPTIONAL_CASE = "null";

    @NotNull
    public static final FileUtils INSTANCE = new FileUtils();

    @NotNull
    public static final String KEY_DISPLAY_NAME = "displayName";

    @NotNull
    private static final String STR_USER_MODE = "[##### User mode]";

    @NotNull
    private static final String TAG = "FileUtils";

    private FileUtils() {
    }

    @JvmStatic
    public static final void copyDirectory(@NotNull File sourceLocation, @NotNull File targetLocation) throws IOException {
        FileOutputStream fileOutputStream;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(sourceLocation, "sourceLocation");
        Intrinsics.checkNotNullParameter(targetLocation, "targetLocation");
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists() && !targetLocation.mkdirs()) {
                throw new IOException(AbstractC0541b.m772n("Error dir create dir ", targetLocation.getAbsolutePath()));
            }
            String[] list = sourceLocation.list();
            if (list == null) {
                return;
            }
            for (String str : list) {
                copyDirectory(new File(sourceLocation, str), new File(targetLocation, str));
            }
            return;
        }
        File parentFile = targetLocation.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException(AbstractC0541b.m772n("Error create dir ", parentFile.getAbsolutePath()));
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(sourceLocation);
            try {
                fileOutputStream = new FileOutputStream(targetLocation);
                try {
                    bArr = new byte[10240];
                } finally {
                }
            } finally {
            }
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            AbstractC4539a.m3214x("copyDirectory - failed to read the file", e.getMessage(), TAG);
        }
    }

    @JvmStatic
    public static final void copyFile(@Nullable File sourceFile, @Nullable File destFile) {
        String path;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        Boolean boolValueOf = destFile != null ? Boolean.valueOf(destFile.exists()) : null;
        Intrinsics.checkNotNull(boolValueOf);
        if (!boolValueOf.booleanValue() && !destFile.createNewFile()) {
            String path2 = destFile.getPath();
            throw new IOException(AbstractC0541b.m773o("Fail to create dest file. [", path2 != null ? logPath(path2) : null, "]"));
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            try {
                fileOutputStream = new FileOutputStream(destFile);
                try {
                    bArr = new byte[10240];
                } finally {
                }
            } finally {
            }
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            Logger.m8698e(TAG, "copyFile() - " + e);
            if (sourceFile != null && (path = sourceFile.getPath()) != null) {
                strLogPath = logPath(path);
            }
            String path3 = destFile.getPath();
            Intrinsics.checkNotNullExpressionValue(path3, "getPath(...)");
            throw new IOException(AbstractC0541b.m775q("Fail to copy [", strLogPath, "] to [", logPath(path3), "]."));
        }
    }

    @JvmStatic
    public static final int copyFileExceptUpdated(@NotNull File sourceLocation, @NotNull File targetLocation) {
        String message;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(sourceLocation, "sourceLocation");
        Intrinsics.checkNotNullParameter(targetLocation, "targetLocation");
        if (sourceLocation.exists()) {
            if (sourceLocation.isDirectory()) {
                String[] list = sourceLocation.list();
                if (list != null) {
                    Iterator it = ArrayIteratorKt.iterator(list);
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        File file = new File(sourceLocation, str);
                        File file2 = new File(targetLocation, str);
                        if (file.lastModified() >= file2.lastModified()) {
                            copyFileExceptUpdated(file, file2);
                        }
                    }
                }
                return 0;
            }
            try {
                File parentFile = targetLocation.getParentFile();
                if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                    FileInputStream fileInputStream = new FileInputStream(sourceLocation);
                    try {
                        fileOutputStream = new FileOutputStream(targetLocation);
                        try {
                            bArr = new byte[1024];
                        } finally {
                        }
                    } finally {
                    }
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileOutputStream, null);
                            CloseableKt.closeFinally(fileInputStream, null);
                            return 0;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                }
            } catch (IOException e) {
                return (e.getMessage() == null || (message = e.getMessage()) == null || !StringsKt.m14162r(message, "ENOSPC")) ? -1 : -4;
            }
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [int] */
    private final int copyFileToFileUri(Context context, File srcFile, Uri dstUri) throws Throwable {
        ?? r6;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(context.getContentResolver().openOutputStream(dstUri));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            boolean zCopyFileToStream = copyFileToStream(srcFile, bufferedOutputStream);
            try {
                bufferedOutputStream.close();
                r6 = zCopyFileToStream;
            } catch (IOException unused) {
                Logger.m8698e(TAG, "copyFileToFileUri bufferedOutputStream close exception");
                r6 = zCopyFileToStream;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedOutputStream2 = bufferedOutputStream;
            Logger.m8698e(TAG, "copyFileToFileUri" + e.getMessage());
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException unused2) {
                    Logger.m8698e(TAG, "copyFileToFileUri bufferedOutputStream close exception");
                }
            }
            r6 = 0;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException unused3) {
                    Logger.m8698e(TAG, "copyFileToFileUri bufferedOutputStream close exception");
                }
            }
            throw th;
        }
        return r6;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean copyFileToStream(File srcFile, OutputStream outputStream) throws Throwable {
        BufferedInputStream bufferedInputStream;
        Exception e;
        boolean zCopyStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFile));
            try {
                try {
                    zCopyStream = copyStream(bufferedInputStream, outputStream);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                        Logger.m8698e(TAG, "bInputStream close exception");
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused2) {
                            Logger.m8698e(TAG, "bOutputStream close exception");
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    Logger.m8698e(TAG, "copyFileToStream" + e.getMessage());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused3) {
                            Logger.m8698e(TAG, "bInputStream close exception");
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused4) {
                            Logger.m8698e(TAG, "bOutputStream close exception");
                        }
                    }
                    zCopyStream = false;
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused5) {
                        Logger.m8698e(TAG, "bInputStream close exception");
                    }
                }
                if (outputStream != null) {
                    throw th;
                }
                try {
                    outputStream.close();
                    throw th;
                } catch (IOException unused6) {
                    Logger.m8698e(TAG, "bOutputStream close exception");
                    throw th;
                }
            }
        } catch (Exception e3) {
            bufferedInputStream = null;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedInputStream2 != null) {
            }
            if (outputStream != null) {
            }
        }
        Logger.m8697d(TAG, "copyFileToStream result :" + zCopyStream + ", srcFile : " + Logger.getEncode(srcFile.getAbsolutePath()) + "(" + srcFile.length() + ")");
        return zCopyStream;
    }

    private final boolean copyStream(InputStream in, OutputStream out) {
        if (in == null || out == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("copyStream Error : %s stream is null", Arrays.copyOf(new Object[]{out == null ? "out" : "in"}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            Logger.m8698e(TAG, str);
        } else {
            try {
                try {
                    byte[] bArr = new byte[32768];
                    long j = 0;
                    loop0: while (true) {
                        long j2 = j;
                        do {
                            int i = in.read(bArr);
                            if (i != -1) {
                                out.write(bArr, 0, i);
                                j += (long) i;
                            } else {
                                try {
                                    break loop0;
                                } catch (IOException unused) {
                                    Logger.m8698e(TAG, "copyStream, out close exception");
                                }
                            }
                        } while (j - j2 < 32768);
                    }
                    out.close();
                    try {
                        in.close();
                        return true;
                    } catch (IOException unused2) {
                        Logger.m8698e(TAG, "copyStream, in close exception");
                        return true;
                    }
                } catch (Exception e) {
                    Logger.m8698e(TAG, "copyStream" + e.getMessage());
                    try {
                        out.close();
                    } catch (IOException unused3) {
                        Logger.m8698e(TAG, "copyStream, out close exception");
                    }
                    try {
                        in.close();
                    } catch (IOException unused4) {
                        Logger.m8698e(TAG, "copyStream, in close exception");
                    }
                    return false;
                }
            } finally {
            }
        }
        return false;
    }

    private final Uri createDirectory(Context context, Uri parentUri, String directoryName) {
        return createFile(context, parentUri, directoryName, "vnd.android.document/directory");
    }

    private final Uri createFile(Context context, Uri parentUri, String fileName, String mimeType) {
        Uri uriCreateDocument;
        try {
            uriCreateDocument = DocumentsContract.createDocument(context.getContentResolver(), parentUri, mimeType, fileName);
        } catch (FileNotFoundException e) {
            AbstractC4539a.m3214x("createFile", e.getMessage(), TAG);
            uriCreateDocument = null;
        }
        Logger.m8702i(TAG, "createFile");
        return uriCreateDocument;
    }

    @JvmStatic
    @NotNull
    public static final File createNewFile(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && parentFile.mkdir()) {
            AbstractC4539a.m3206p("createNewFile, Created directory ", Logger.getEncode(parentFile.getAbsolutePath()), TAG);
        }
        String strExtractFileName = extractFileName(path);
        for (int i = 1; file.exists() && i < Integer.MAX_VALUE; i++) {
            file = new File(parentFile, strExtractFileName + " (" + i + ")");
        }
        AbstractC4539a.m3206p("createNewFile, Created file ", Logger.getEncode(file.getAbsolutePath()), TAG);
        return file;
    }

    private final boolean deleteDirRecursive(File dir) throws IOException {
        File[] fileArrListFiles;
        if (dir == null || !dir.exists()) {
            return false;
        }
        if (dir.isDirectory() && (fileArrListFiles = dir.listFiles()) != null) {
            Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
            while (it.hasNext()) {
                deleteDirRecursive((File) it.next());
            }
        }
        if (dir.delete()) {
            return true;
        }
        String path = dir.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        throw new IOException(AbstractC0541b.m773o("Fail to delete [", logPath(path), "]"));
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean deleteFile(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return deleteFile$default(filePath, false, 2, null);
    }

    public static /* synthetic */ boolean deleteFile$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return deleteFile(str, z);
    }

    @JvmStatic
    public static final boolean exists(@Nullable String filePath) {
        if (filePath == null) {
            Logger.m8698e(TAG, "exists, file path is null");
            return false;
        }
        try {
            if (new File(filePath).exists()) {
                Logger.m8702i(TAG, "exists : " + Logger.getEncode(filePath));
                return true;
            }
        } catch (Exception e) {
            AbstractC4539a.m3214x("exists : ", e.getMessage(), TAG);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0019 A[SYNTHETIC] */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<File> exploredFolder(@NotNull File dir, @Nullable List<String> exts, @Nullable List<String> exceptFile, boolean isSkipNoMedia) {
        List<String> list;
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = dir.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
            while (it.hasNext()) {
                File file = (File) it.next();
                if (file.isDirectory()) {
                    if (isSkipNoMedia) {
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        if (StringsKt.m14145S(name, Extension.DOT) || new File(file, ".nomedia").exists()) {
                        }
                    }
                    Intrinsics.checkNotNull(file);
                    arrayList.addAll(exploredFolder(file, exts, exceptFile, isSkipNoMedia));
                } else {
                    if (isSkipNoMedia) {
                        String name2 = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                        if (!StringsKt.m14145S(name2, Extension.DOT)) {
                        }
                    }
                    List<String> list2 = exts;
                    boolean z = false;
                    boolean z2 = list2 == null || list2.isEmpty() || exts.contains(getFileExt(file.getName()));
                    if (!z2 || (list = exceptFile) == null || list.isEmpty()) {
                        z = z2;
                        if (!z) {
                            Intrinsics.checkNotNull(file);
                            arrayList.add(file);
                        }
                    } else {
                        FileUtils fileUtils = INSTANCE;
                        String name3 = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                        if (!exceptFile.contains(fileUtils.getFileName(name3, false))) {
                        }
                        if (!z) {
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final String extractFile(@Nullable String filePath) {
        List listEmptyList;
        if (filePath == null) {
            Logger.m8697d(TAG, "extractFile filePath is null");
            return "";
        }
        AbstractC4539a.m3188B("extractFile filePath : ", Logger.getEncode(filePath), TAG);
        try {
            List<String> listSplit = new Regex("/").split(filePath, 0);
            if (listSplit.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            }
            return ((String[]) listEmptyList.toArray(new String[0]))[r5.length - 1];
        } catch (Exception e) {
            AbstractC4539a.m3214x("extractFile : ", e.getMessage(), TAG);
            return "";
        }
    }

    @JvmStatic
    @NotNull
    public static final String extractFileExtension(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String strSubstring = filePath.substring(StringsKt.m14130D(filePath, '.'));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @JvmStatic
    @NotNull
    public static final String extractFileName(@Nullable String filePath) {
        List listEmptyList;
        if (filePath == null) {
            return "";
        }
        AbstractC4539a.m3188B("extractFileName filePath : ", Logger.getEncode(filePath), TAG);
        try {
            List<String> listSplit = new Regex("/").split(filePath, 0);
            if (listSplit.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            }
            String str = ((String[]) listEmptyList.toArray(new String[0]))[r5.length - 1];
            int iM14130D = StringsKt.m14130D(str, '.');
            if (iM14130D <= 0) {
                return str;
            }
            String strSubstring = str.substring(0, iM14130D);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        } catch (Exception e) {
            AbstractC4539a.m3214x("extractFileName : ", e.getMessage(), TAG);
            return "";
        }
    }

    @JvmStatic
    @Nullable
    public static final String findFile(@NotNull File dir, @NotNull String targetName) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(targetName, "targetName");
        File[] fileArrListFiles = dir.listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        for (File file : fileArrListFiles) {
            if (file.isDirectory()) {
                Intrinsics.checkNotNull(file);
                String strFindFile = findFile(file, targetName);
                if (strFindFile != null) {
                    return strFindFile;
                }
            } else if (Intrinsics.areEqual(file.getName(), targetName)) {
                return file.getPath();
            }
        }
        return null;
    }

    @JvmStatic
    public static final void forceRenameTo(@Nullable String curPath, @Nullable String newPath) throws IOException {
        if (curPath == null || newPath == null) {
            Logger.m8702i(TAG, "forceRenameTo() - Invalid argument.");
            return;
        }
        File file = new File(curPath);
        if (!file.exists()) {
            throw new IOException(AbstractC0541b.m773o("forceRenameTo() - Fail to get current path File. [", logPath(curPath), "]"));
        }
        File file2 = new File(newPath);
        if (file2.exists()) {
            if (Intrinsics.areEqual(file, file2)) {
                return;
            } else {
                deleteFile(file2);
            }
        }
        if (!file.renameTo(file2)) {
            throw new IOException(AbstractC0541b.m775q("forceRenameTo() - Cannot rename temp file [", logPath(curPath), "] to [", logPath(newPath), "]"));
        }
    }

    @JvmStatic
    @NotNull
    public static final String generateUniqueFilePath(@NotNull String dir, @NotNull String fileName, @NotNull String extension) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(extension, "extension");
        File file = new File(dir, AbstractC0541b.m757C(fileName, Extension.DOT, extension));
        int i = 1;
        while (file.exists()) {
            file = new File(dir, fileName + " (" + i + ")." + extension);
            i++;
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    @JvmStatic
    @NotNull
    public static final String generateUniqueFilePathNoExtension(@NotNull String dir, @NotNull String fileNameWithNoExtension) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(fileNameWithNoExtension, "fileNameWithNoExtension");
        File file = new File(dir, fileNameWithNoExtension);
        int i = 1;
        while (file.exists()) {
            fileNameWithNoExtension = AbstractC2821a.m2218i(i, fileNameWithNoExtension, "_");
            file = new File(dir, fileNameWithNoExtension);
            i++;
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    private final long getDirectorySize(File parentDir) {
        long length;
        long length2 = parentDir.length();
        File[] fileArrListFiles = parentDir.listFiles();
        if (fileArrListFiles == null) {
            return length2;
        }
        for (File file : fileArrListFiles) {
            if (file.isDirectory()) {
                Intrinsics.checkNotNull(file);
                length = getDirectorySize(file);
            } else {
                length = file.length();
            }
            length2 += length;
        }
        return length2;
    }

    @JvmStatic
    @Nullable
    public static final String getDownloadDir(@Nullable Context context) {
        if (context == null || context.getCacheDir() == null) {
            Logger.m8703w(TAG, "getDownloadDirPath#, context or getCacheDir is null");
            return null;
        }
        File file = new File(AbstractC0541b.m757C(context.getCacheDir().getPath(), File.separator, "download"));
        if (file.exists() || file.mkdir()) {
            return file.getPath();
        }
        Logger.m8698e(TAG, "getDownloadDirPath# fail to mkdir");
        return null;
    }

    @JvmStatic
    @NotNull
    public static final String getDownloadDirWithFileSeparator(@Nullable Context context) {
        return AbstractC0541b.m756B(getDownloadDir(context), File.separator);
    }

    @JvmStatic
    @NotNull
    public static final String getExtensionFromUri(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        return INSTANCE.getExtensionFromUri(context, uri, true);
    }

    @JvmStatic
    @NotNull
    public static final String getFileExt(@Nullable String fileName) {
        Boolean boolValueOf = fileName != null ? Boolean.valueOf(StringsKt.m14162r(fileName, Extension.DOT)) : null;
        Intrinsics.checkNotNull(boolValueOf);
        if (!boolValueOf.booleanValue()) {
            return "";
        }
        int iM14130D = StringsKt.m14130D(fileName, '.') + 1;
        int length = fileName.length();
        if (iM14130D == fileName.length()) {
            return "";
        }
        String strSubstring = fileName.substring(iM14130D, length);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @JvmStatic
    @NotNull
    public static final String getFileNameFromFilePath(@NotNull String filePath) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        List<String> listSplit = new Regex("/").split(filePath, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        return strArr[strArr.length - 1];
    }

    @JvmStatic
    @NotNull
    public static final String getFileNameFromUri(@NotNull Context context, @NotNull Uri uri) {
        int columnIndex;
        List listEmptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path) && path != null && StringsKt.m14167w(path, com.samsung.android.support.senl.p148nt.base.common.constants.Constants.PDF_EXTENSION_WITH_DOT)) {
            String queryParameter = uri.getQueryParameter("displayName");
            if (!TextUtils.isEmpty(queryParameter)) {
                return String.valueOf(queryParameter);
            }
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            List<String> listSplit = new Regex(separator).split(path, 0);
            if (listSplit.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            }
            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
            return strArr[strArr.length - 1];
        }
        String str = "";
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            try {
                Cursor cursor = cursorQuery;
                if (cursor != null && cursor.moveToFirst() && (columnIndex = cursor.getColumnIndex("_display_name")) != -1) {
                    String string = cursor.getString(columnIndex);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    str = string;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
                return str;
            } finally {
            }
        } catch (Exception e) {
            Logger.m8699e(TAG, "getFileNameFromUri query ", e);
            return str;
        }
    }

    @JvmStatic
    @NotNull
    public static final String getFileNameFromUriWithoutExt(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String fileNameFromUri = getFileNameFromUri(context, uri);
        try {
            String strSubstring = fileNameFromUri.substring(0, StringsKt.m14130D(fileNameFromUri, '.'));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        } catch (StringIndexOutOfBoundsException unused) {
            return fileNameFromUri;
        }
    }

    @JvmStatic
    public static final long getFileSize(@Nullable String path) {
        long length;
        if (TextUtils.isEmpty(path)) {
            length = 0;
        } else {
            File file = new File(path);
            if (file.exists() && file.canRead()) {
                length = file.length();
            } else {
                AbstractC4539a.m3188B("getFileSize, failed to read docFile path: ", Logger.getEncode(path), TAG);
                length = 0;
            }
        }
        Logger.m8697d(TAG, "getFileSize, size: " + length);
        return length;
    }

    @JvmStatic
    @Nullable
    public static final String getParentDirectory(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new File(source).getParent();
    }

    @JvmStatic
    public static final long getStorageSize(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (TextUtils.isEmpty(path)) {
            return 0L;
        }
        File file = new File(path);
        if (file.exists()) {
            return file.isDirectory() ? INSTANCE.getDirectorySize(file) : file.length();
        }
        return 0L;
    }

    @JvmStatic
    public static final boolean isFileExists(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return !TextUtils.isEmpty(filePath) && AbstractC2322a.m1607A(filePath);
    }

    @JvmStatic
    @NotNull
    public static final String logPath(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return DeviceInfo.isEngMode() ? filePath : STR_USER_MODE;
    }

    @JvmStatic
    public static final boolean makeDirectory(@NotNull String directoryPath) {
        Intrinsics.checkNotNullParameter(directoryPath, "directoryPath");
        try {
            File file = new File(directoryPath);
            if (file.exists()) {
                return true;
            }
            Logger.m8697d(TAG, "makeDirectory(), a directory is not existed, make it");
            if (file.mkdirs()) {
                return true;
            }
            Logger.m8698e(TAG, "makeDirectory(), fail to make a directory");
            return false;
        } catch (Exception e) {
            AbstractC4539a.m3188B("makeDirectory : ", e.getMessage(), TAG);
            return false;
        }
    }

    @JvmStatic
    public static final boolean mkFile(@Nullable File outFile, @NotNull String inData) {
        Intrinsics.checkNotNullParameter(inData, "inData");
        boolean z = false;
        if (outFile != null && !TextUtils.isEmpty(inData)) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(outFile);
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter, 32768);
                        try {
                            int length = inData.length();
                            for (int i = 0; i < length; i += 32768) {
                                bufferedWriter.write(inData, i, Math.min(32768, length - i));
                            }
                            z = true;
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(bufferedWriter, null);
                            CloseableKt.closeFinally(outputStreamWriter, null);
                            CloseableKt.closeFinally(fileOutputStream, null);
                            return true;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e) {
                Logger.m8699e(TAG, "mkFile", e);
            }
        }
        return z;
    }

    @JvmStatic
    public static final void moveFile(@Nullable String from, @Nullable String to) {
        File file;
        Boolean boolValueOf = null;
        if (from != null) {
            try {
                file = new File(from);
            } catch (Exception e) {
                Logger.m8698e(TAG, "moveFile : " + e);
                return;
            }
        } else {
            file = null;
        }
        File file2 = to != null ? new File(to) : null;
        if (file2 != null && file != null) {
            boolValueOf = Boolean.valueOf(file.renameTo(file2));
        }
        Intrinsics.checkNotNull(boolValueOf);
        if (boolValueOf.booleanValue()) {
            return;
        }
        Logger.m8703w(TAG, "moveFile(), fail to rename");
    }

    @JvmStatic
    public static final void moveFiles(@Nullable String from, @Nullable String to) {
        File file;
        File[] fileArrListFiles;
        if (from != null) {
            try {
                file = new File(from);
            } catch (Exception e) {
                Logger.m8698e(TAG, "moveFiles : " + e);
                return;
            }
        } else {
            file = null;
        }
        File file2 = to != null ? new File(to) : null;
        if (file == null || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file3 : fileArrListFiles) {
            if (file3.isFile() && !file3.renameTo(new File(file2, file3.getName()))) {
                throw new IOException("moveFiles failed : " + file3.getName());
            }
        }
    }

    @JvmStatic
    public static final void printDirectory(@NotNull String directoryPath, @Nullable String includedString, boolean fileLogging) {
        Intrinsics.checkNotNullParameter(directoryPath, "directoryPath");
        try {
            StringBuilder sb = new StringBuilder();
            File[] fileArrListFiles = new File(directoryPath).listFiles();
            if (fileArrListFiles != null) {
                Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
                while (it.hasNext()) {
                    String absolutePath = ((File) it.next()).getAbsolutePath();
                    Intrinsics.checkNotNull(absolutePath);
                    if (StringsKt.m14162r(absolutePath, String.valueOf(includedString))) {
                        sb.append(absolutePath);
                        sb.append(SQLKeyword.COMMA);
                    }
                }
                if (fileLogging) {
                    Logger.m8700f(TAG, "printDirectory : " + Logger.getEncode(sb.toString()));
                    return;
                }
                Logger.m8702i(TAG, "printDirectory : " + Logger.getEncode(sb.toString()));
            }
        } catch (Exception e) {
            AbstractC4539a.m3188B("printDirectory : ", e.getMessage(), TAG);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void zip(@NotNull String sourcePath, @NotNull String zipPath) throws IOException {
        Intrinsics.checkNotNullParameter(sourcePath, "sourcePath");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        File file = new File(sourcePath);
        if (!file.isFile() && !file.isDirectory()) {
            throw new IOException("zip# File not found");
        }
        int iM14131E = StringsKt.m14131E(Extension.DOT, 0, 6, zipPath);
        if (iM14131E >= 0) {
            String strSubstring = zipPath.substring(iM14131E);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            if (!StringsKt__StringsJVMKt.equals(strSubstring, com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ZIP_EXTENSION_WITH_DOT, true)) {
                zipPath = AbstractC0541b.m756B(zipPath, com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ZIP_EXTENSION_WITH_DOT);
            }
        }
        File parentFile = new File(zipPath).getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            Logger.m8698e(TAG, "zip# parentFile mkdirs failed");
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(zipPath);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream);
                try {
                    zipOutputStream.setMethod(8);
                    zipOutputStream.setLevel(1);
                    String strSubstring2 = sourcePath.substring(0, StringsKt.m14130D(sourcePath, '/'));
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    INSTANCE.zipEntry(file, strSubstring2, zipOutputStream);
                    zipOutputStream.finish();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(zipOutputStream, null);
                    CloseableKt.closeFinally(bufferedOutputStream, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    private final void zipEntry(File sourceFile, String baseSourcePath, ZipOutputStream zos) {
        if (sourceFile.isDirectory()) {
            File[] fileArrListFiles = sourceFile.listFiles();
            if (fileArrListFiles != null) {
                Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
                while (it.hasNext()) {
                    File file = (File) it.next();
                    Intrinsics.checkNotNull(file);
                    zipEntry(file, baseSourcePath, zos);
                }
                return;
            }
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile));
        try {
            String path = sourceFile.getPath();
            Intrinsics.checkNotNull(path);
            String strSubstring = path.substring(baseSourcePath.length() + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            zos.putNextEntry(new ZipEntry(strSubstring));
            byte[] bArr = new byte[10240];
            while (true) {
                int i = bufferedInputStream.read(bArr, 0, 10240);
                if (i == -1) {
                    zos.closeEntry();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedInputStream, null);
                    return;
                }
                zos.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedInputStream, th);
                throw th2;
            }
        }
    }

    public final int copyFileToDirUri(@NotNull Context context, @NotNull File srcFile, @NotNull Uri dstUri) {
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(srcFile, "srcFile");
        Intrinsics.checkNotNullParameter(dstUri, "dstUri");
        int iCopyFileToDirUri = 0;
        if (srcFile.isDirectory()) {
            String name = srcFile.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Uri uriCreateDirectory = createDirectory(context, dstUri, name);
            File[] fileArrListFiles = srcFile.listFiles();
            if (fileArrListFiles != null) {
                Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
                while (it.hasNext()) {
                    File file = (File) it.next();
                    if (uriCreateDirectory != null) {
                        FileUtils fileUtils = INSTANCE;
                        Intrinsics.checkNotNull(file);
                        numValueOf = Integer.valueOf(fileUtils.copyFileToDirUri(context, file, uriCreateDirectory));
                    } else {
                        numValueOf = null;
                    }
                    if (numValueOf != null) {
                        Intrinsics.checkNotNull(file);
                        iCopyFileToDirUri += copyFileToDirUri(context, file, uriCreateDirectory);
                    }
                }
                return iCopyFileToDirUri;
            }
        } else {
            String name2 = srcFile.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            Uri uriCreateFile = createFile(context, dstUri, name2, "");
            if (uriCreateFile != null) {
                return copyFileToFileUri(context, srcFile, uriCreateFile);
            }
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.samsung.android.support.senl.nt.base.common.util.FileUtils] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean copyUriToFile(@NotNull Context context, @NotNull Uri srcUri, @NotNull File dstFile) throws Throwable {
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        ?? r8;
        ?? bufferedOutputStream;
        Exception e;
        InputStream inputStreamOpenInputStream;
        boolean zCopyStream;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(srcUri, "srcUri");
        Intrinsics.checkNotNullParameter(dstFile, "dstFile");
        InputStream inputStream = null;
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(srcUri);
            try {
                fileOutputStream = new FileOutputStream(dstFile);
                try {
                    bufferedInputStream = new BufferedInputStream(inputStreamOpenInputStream);
                } catch (Exception e2) {
                    bufferedOutputStream = 0;
                    e = e2;
                    bufferedInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = null;
                    bufferedOutputStream = bufferedInputStream;
                    inputStream = inputStreamOpenInputStream;
                    r8 = bufferedOutputStream;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (r8 != 0) {
                    }
                }
            } catch (Exception e3) {
                bufferedInputStream = null;
                bufferedOutputStream = 0;
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            bufferedInputStream = null;
            bufferedOutputStream = 0;
            e = e5;
            inputStreamOpenInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            bufferedInputStream = null;
            r8 = 0;
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (r8 != 0) {
            }
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                try {
                    zCopyStream = copyStream(bufferedInputStream, bufferedOutputStream);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException unused) {
                            Logger.m8698e(TAG, "copyUriToFile, inputStream close exception");
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        Logger.m8698e(TAG, "copyUriToFile, outputStream close exception");
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused3) {
                        Logger.m8698e(TAG, "copyUriToFile, bInputStream close exception");
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused4) {
                        Logger.m8698e(TAG, "copyUriToFile, bOutputStream close exception");
                    }
                } catch (Exception e6) {
                    e = e6;
                    Logger.m8698e(TAG, "copyUriToFile" + e.getMessage());
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException unused5) {
                            Logger.m8698e(TAG, "copyUriToFile, inputStream close exception");
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused6) {
                            Logger.m8698e(TAG, "copyUriToFile, outputStream close exception");
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused7) {
                            Logger.m8698e(TAG, "copyUriToFile, bInputStream close exception");
                        }
                    }
                    if (bufferedOutputStream != 0) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused8) {
                            Logger.m8698e(TAG, "copyUriToFile, bOutputStream close exception");
                        }
                    }
                    zCopyStream = false;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = inputStreamOpenInputStream;
                r8 = bufferedOutputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused9) {
                        Logger.m8698e(TAG, "copyUriToFile, inputStream close exception");
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused10) {
                        Logger.m8698e(TAG, "copyUriToFile, outputStream close exception");
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused11) {
                        Logger.m8698e(TAG, "copyUriToFile, bInputStream close exception");
                    }
                }
                if (r8 != 0) {
                    throw th;
                }
                try {
                    r8.close();
                    throw th;
                } catch (IOException unused12) {
                    Logger.m8698e(TAG, "copyUriToFile, bOutputStream close exception");
                    throw th;
                }
            }
        } catch (Exception e7) {
            bufferedOutputStream = 0;
            e = e7;
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = 0;
            inputStream = inputStreamOpenInputStream;
            r8 = bufferedOutputStream;
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (r8 != 0) {
            }
        }
        Logger.m8702i(TAG, "copyUriToFile result :" + zCopyStream + ", (" + dstFile.length() + ")");
        return zCopyStream;
    }

    @NotNull
    public final String findFileExcept(@Nullable String directory, @NotNull String filePath) {
        File[] fileArrListFiles;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Logger.m8697d(TAG, AbstractC0541b.m775q("findFileExcept, directory/filePath : ", Logger.getEncode(directory), " / [", Logger.getEncode(filePath), "]"));
        if (directory != null) {
            try {
                fileArrListFiles = new File(directory).listFiles();
            } catch (Exception e) {
                AbstractC4539a.m3188B("findFileExcept : ", e.getMessage(), TAG);
                return "";
            }
        } else {
            fileArrListFiles = null;
        }
        if (fileArrListFiles == null) {
            return "";
        }
        int length = fileArrListFiles.length;
        for (int i = 0; i < length; i++) {
            String absolutePath = fileArrListFiles[i].getAbsolutePath();
            Intrinsics.checkNotNull(absolutePath);
            if (StringsKt.m14162r(absolutePath, FIND_FILE_EXCEPT_EXCEPTIONAL_CASE)) {
                deleteFile$default(absolutePath, false, 2, null);
            } else if (!Intrinsics.areEqual(absolutePath, filePath)) {
                Logger.m8702i(TAG, "findFileExcept [" + i + "] : found " + Logger.getEncode(absolutePath));
                return absolutePath;
            }
        }
        return "";
    }

    @NotNull
    public final String getCacheDirPath(@Nullable Context context) {
        File cacheDir = context != null ? context.getCacheDir() : null;
        if (cacheDir == null) {
            return "/data/user/0/com.samsung.android.app.notes/cache";
        }
        String absolutePath = cacheDir.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    @NotNull
    public final String getFileName(@NotNull String path, boolean exceptExt) {
        int iM14131E;
        Intrinsics.checkNotNullParameter(path, "path");
        if (TextUtils.isEmpty(path)) {
            return "";
        }
        String name = new File(path).getName();
        if (TextUtils.isEmpty(name)) {
            return "";
        }
        Intrinsics.checkNotNull(name);
        if (!exceptExt || (iM14131E = StringsKt.m14131E(Extension.DOT, 0, 6, name)) <= 0) {
            return name;
        }
        String strSubstring = name.substring(0, iM14131E);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final boolean isAndroidDir(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return StringsKt.m14145S(path, Environment.getExternalStorageDirectory() + "/Android/");
    }

    @Nullable
    public final byte[] readFile(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        if (!file.exists()) {
            AbstractC4539a.m3206p("readFile# file is empty or not exists ", Logger.getEncode(path), TAG);
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            try {
                byte[] bArr = new byte[(int) file.length()];
                if (fileInputStream.read(bArr) < 0) {
                    CloseableKt.closeFinally(fileInputStream, null);
                    return null;
                }
                if (!file.delete()) {
                    Logger.m8702i(TAG, "readFile# file delete fail");
                }
                CloseableKt.closeFinally(fileInputStream, null);
                return bArr;
            } finally {
            }
        } catch (IOException e) {
            Logger.m8699e(TAG, "readFile# ", e);
            return null;
        }
        Logger.m8699e(TAG, "readFile# ", e);
        return null;
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean deleteFile(@NotNull String filePath, boolean log) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                Logger.m8702i(TAG, "deleteFile# file is empty or not exists " + Logger.getEncode(filePath));
                return false;
            }
            if (log) {
                Logger.m8697d(TAG, "deleteFile delete " + Logger.getEncode(file.getAbsolutePath()));
            }
            return file.delete();
        } catch (Exception e) {
            AbstractC4539a.m3214x("deleteFile ", e.getMessage(), TAG);
            return false;
        }
    }

    private final String getExtensionFromUri(Context context, Uri uri, boolean includeMimeTypeMap) {
        String fileExt;
        String fileNameFromUri = getFileNameFromUri(context, uri);
        if (TextUtils.isEmpty(fileNameFromUri)) {
            fileExt = "";
        } else {
            fileExt = getFileExt(fileNameFromUri);
            if (!TextUtils.isEmpty(fileExt)) {
                return fileExt;
            }
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (!TextUtils.isEmpty(lastPathSegment)) {
            fileExt = getFileExt(lastPathSegment);
            if (!TextUtils.isEmpty(fileExt)) {
                return fileExt;
            }
        }
        return includeMimeTypeMap ? String.valueOf(MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri))) : fileExt;
    }

    @NotNull
    public final String findFile(@NotNull String directory, @Nullable String fileName) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        try {
            File[] fileArrListFiles = new File(directory).listFiles();
            if (fileArrListFiles != null) {
                int length = fileArrListFiles.length;
                for (int i = 0; i < length; i++) {
                    String name = fileArrListFiles[i].getName();
                    if (fileName != null) {
                        Intrinsics.checkNotNull(name);
                        if (StringsKt.m14162r(name, fileName)) {
                            Logger.m8702i(TAG, "findFile [" + i + "] : found " + Logger.getEncode(name));
                            return directory + name;
                        }
                    }
                }
                return "";
            }
            return "";
        } catch (Exception e) {
            AbstractC4539a.m3214x("findFile : ", e.getMessage(), TAG);
            return "";
        }
    }

    @JvmStatic
    @NotNull
    public static final String generateUniqueFilePath(@NotNull String dir, @NotNull String fileFullName) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(fileFullName, "fileFullName");
        int iM14130D = StringsKt.m14130D(fileFullName, '.');
        String strSubstring = fileFullName.substring(0, iM14130D);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = fileFullName.substring(iM14130D + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return generateUniqueFilePath(dir, strSubstring, strSubstring2);
    }

    @JvmStatic
    @SuppressLint({"Range"})
    public static final long getFileSize(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (StringsKt.m14145S(string, "file://") && uri.getPath() != null) {
            String path = uri.getPath();
            Intrinsics.checkNotNull(path);
            String strSubstring = path.substring(7);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            File file = new File(strSubstring);
            if (file.exists()) {
                return file.length();
            }
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            try {
                Cursor cursor = cursorQuery;
                if (cursor != null && cursor.moveToFirst()) {
                    long j = cursor.getLong(cursor.getColumnIndex("_size"));
                    CloseableKt.closeFinally(cursorQuery, null);
                    return j;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
                return -1L;
            } finally {
            }
        } catch (Exception e) {
            Logger.m8699e(TAG, "getFileSize# fail to query file size ", e);
            return -1L;
        }
    }

    @JvmStatic
    public static final boolean deleteFile(@Nullable File dir) {
        if (dir == null || !dir.exists()) {
            return false;
        }
        return INSTANCE.deleteDirRecursive(dir);
    }

    public final void deleteFile(@Nullable String dir, @NotNull String filePath) {
        File file;
        File[] fileArrListFiles;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Logger.m8702i(TAG, "deleteFile dir/filePath " + Logger.getEncode(dir) + "/" + Logger.getEncode(filePath));
        if (dir != null) {
            try {
                file = new File(dir);
            } catch (Exception e) {
                AbstractC4539a.m3214x("deleteFile ", e.getMessage(), TAG);
                return;
            }
        } else {
            file = null;
        }
        if (file != null && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (Intrinsics.areEqual(file2.getPath(), filePath)) {
                    String path = file2.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                    deleteFile$default(path, false, 2, null);
                }
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final String generateUniqueFilePath(@NotNull String path) {
        File file;
        Intrinsics.checkNotNullParameter(path, "path");
        int iM14130D = StringsKt.m14130D(path, '.');
        int iMax = (int) Math.max(StringsKt.m14130D(path, '/'), StringsKt.m14130D(path, '\\'));
        String strSubstring = path.substring(0, iMax);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = path.substring(iMax + 1, iM14130D);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        String strSubstring3 = path.substring(iM14130D + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        int i = 1;
        do {
            file = new File(strSubstring, strSubstring2 + "_" + i + Extension.DOT + strSubstring3);
            i++;
        } while (file.exists());
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f9, code lost:
    
        if (r13.mkdirs() == false) goto L85;
     */
    /* JADX WARN: Finally extract failed */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int copyFile(@NotNull File sourceLocation, @NotNull File targetLocation, boolean isOverwriteDestFile, boolean toLowerCase) {
        String message;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        String message2;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(sourceLocation, "sourceLocation");
        Intrinsics.checkNotNullParameter(targetLocation, "targetLocation");
        if (sourceLocation.exists()) {
            if (sourceLocation.isDirectory()) {
                if (toLowerCase) {
                    String string = targetLocation.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    String lowerCase = string.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    File file = new File(lowerCase);
                    if (file.exists() || file.mkdirs()) {
                        String[] list = sourceLocation.list();
                        if (list != null) {
                            Iterator it = ArrayIteratorKt.iterator(list);
                            while (it.hasNext()) {
                                String str = (String) it.next();
                                copyFile(new File(sourceLocation, str), new File(file, str), isOverwriteDestFile, true);
                            }
                        }
                    }
                    return -1;
                }
                if (targetLocation.exists() || targetLocation.mkdirs()) {
                    String[] list2 = sourceLocation.list();
                    if (list2 != null) {
                        Iterator it2 = ArrayIteratorKt.iterator(list2);
                        while (it2.hasNext()) {
                            String str2 = (String) it2.next();
                            copyFile(new File(sourceLocation, str2), new File(targetLocation, str2), isOverwriteDestFile, false);
                        }
                    }
                }
                return -1;
            }
            if (toLowerCase) {
                String string2 = targetLocation.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                String lowerCase2 = string2.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                File file2 = new File(lowerCase2);
                if (isOverwriteDestFile || !file2.exists()) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null) {
                        String string3 = parentFile.toString();
                        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                        Locale locale3 = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
                        String lowerCase3 = string3.toLowerCase(locale3);
                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                        File file3 = new File(lowerCase3);
                        if (!file3.exists()) {
                        }
                    }
                    try {
                        fileInputStream = new FileInputStream(sourceLocation);
                        try {
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                bArr = new byte[1024];
                            } finally {
                            }
                        } finally {
                        }
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i > 0) {
                                fileOutputStream.write(bArr, 0, i);
                            } else {
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(fileOutputStream, null);
                                CloseableKt.closeFinally(fileInputStream, null);
                                return 0;
                            }
                        }
                    } catch (IOException e) {
                        if (e.getMessage() == null || (message2 = e.getMessage()) == null || !StringsKt.m14162r(message2, "ENOSPC")) {
                            return -1;
                        }
                        return -4;
                    }
                }
            } else if (isOverwriteDestFile || !targetLocation.exists()) {
                File parentFile2 = targetLocation.getParentFile();
                if (parentFile2 == null || parentFile2.exists() || parentFile2.mkdirs()) {
                    try {
                        fileInputStream = new FileInputStream(sourceLocation);
                        try {
                            fileOutputStream = new FileOutputStream(targetLocation);
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int i2 = fileInputStream.read(bArr2);
                                if (i2 > 0) {
                                    fileOutputStream.write(bArr2, 0, i2);
                                } else {
                                    Unit unit2 = Unit.INSTANCE;
                                    CloseableKt.closeFinally(fileOutputStream, null);
                                    CloseableKt.closeFinally(fileInputStream, null);
                                    return 0;
                                }
                                throw th;
                            }
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    } catch (IOException e2) {
                        if (e2.getMessage() == null || (message = e2.getMessage()) == null || !StringsKt.m14162r(message, "ENOSPC")) {
                            return -1;
                        }
                        return -4;
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    @JvmStatic
    public static final void copyDirectory(@NotNull List<String> restoreData, @NotNull File sourceLocation, @NotNull File targetLocation) throws IOException {
        FileOutputStream fileOutputStream;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(restoreData, "restoreData");
        Intrinsics.checkNotNullParameter(sourceLocation, "sourceLocation");
        Intrinsics.checkNotNullParameter(targetLocation, "targetLocation");
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists() && !targetLocation.mkdirs()) {
                throw new IOException(AbstractC0541b.m772n("Error dir create dir ", targetLocation.getAbsolutePath()));
            }
            String[] list = sourceLocation.list();
            if (list == null) {
                return;
            }
            for (String str : list) {
                copyDirectory(restoreData, new File(sourceLocation, str), new File(targetLocation, str));
            }
            return;
        }
        File parentFile = targetLocation.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException(AbstractC0541b.m772n("Error create dir ", parentFile.getAbsolutePath()));
        }
        if (!restoreData.contains(extractFile(sourceLocation.getAbsolutePath()))) {
            return;
        }
        Logger.m8698e(TAG, "copyDirectory - copy");
        try {
            FileInputStream fileInputStream = new FileInputStream(sourceLocation);
            try {
                fileOutputStream = new FileOutputStream(targetLocation);
                try {
                    bArr = new byte[10240];
                } finally {
                }
            } finally {
            }
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i > 0) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                    return;
                }
            }
        } catch (IOException e) {
            AbstractC4539a.m3214x("copyDirectory - failed to read the file", e.getMessage(), TAG);
        }
    }
}
