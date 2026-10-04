package com.samsung.android.support.senl.addons.base.utils;

import android.content.Context;
import com.google.firebase.messaging.Constants;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0005H\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0005H\u0007J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0005J\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/FileUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mExternalFilesDirAbsolutePath", "initialize", "", "context", "Landroid/content/Context;", "getExternalFilesDirAbsolutePath", "extractFileName", "filePath", "isExistedFile", "", "deleteFile", "moveFile", Constants.MessagePayloadKeys.FROM, "to", "findFile", "directory", "fileName", "findFileExcept", "makeDirectory", "directoryPath", "deleteFilesExcept", "dirPath", "exceptName", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFileUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUtils.kt\ncom/samsung/android/support/senl/addons/base/utils/FileUtils\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,150:1\n37#2:151\n36#2,3:152\n*S KotlinDebug\n*F\n+ 1 FileUtils.kt\ncom/samsung/android/support/senl/addons/base/utils/FileUtils\n*L\n20#1:151\n20#1:152,3\n*E\n"})
public final class FileUtils {

    @NotNull
    public static final FileUtils INSTANCE = new FileUtils();

    @NotNull
    private static final String TAG = Logger.createTag("FileUtils");

    @NotNull
    private static String mExternalFilesDirAbsolutePath = "";

    private FileUtils() {
    }

    @JvmStatic
    public static final boolean deleteFile(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            File file = new File(filePath);
            Logger.m7100d(TAG, "deleteFile delete " + Logger.getEncode(file.getAbsolutePath()));
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Exception e) {
            Logger.m7101e(TAG, "deleteFile " + e.getMessage());
            return false;
        }
    }

    @JvmStatic
    public static final boolean isExistedFile(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String str = TAG;
        Logger.m7100d(str, "isExistedFile");
        try {
            if (!new File(filePath).exists()) {
                return false;
            }
            Logger.m7104i(str, "isExistedFile : " + Logger.getEncode(filePath));
            return true;
        } catch (Exception e) {
            Logger.m7101e(TAG, "isExistedFile : " + e.getMessage());
            return false;
        }
    }

    public final void deleteFilesExcept(@NotNull String dirPath, @NotNull String exceptName) {
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        Intrinsics.checkNotNullParameter(exceptName, "exceptName");
        try {
            File[] fileArrListFiles = new File(dirPath).listFiles();
            if (fileArrListFiles != null) {
                Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
                int i = 0;
                while (it.hasNext()) {
                    String name = ((File) it.next()).getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (!StringsKt.m14162r(name, exceptName)) {
                        i++;
                        deleteFile(dirPath + name);
                    }
                }
                Logger.m7104i(TAG, "deleted : " + i + " @" + Logger.getEncode(dirPath));
            }
        } catch (Exception e) {
            Logger.m7101e(TAG, "delete excepted file : " + e.getMessage());
        }
    }

    @NotNull
    public final String extractFileName(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        AbstractC6670b.m4763x("extractFileName filePath : ", filePath, TAG);
        try {
            String str = ((String[]) StringsKt__StringsKt.split$default(filePath, new String[]{File.separator}, false, 0, 6, (Object) null).toArray(new String[0]))[r4.length - 1];
            String strSubstring = str.substring(0, StringsKt.m14130D(str, '.'));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        } catch (Exception e) {
            Logger.m7101e(TAG, "extractFileName : " + e.getMessage());
            return "";
        }
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
                    Intrinsics.checkNotNull(name);
                    if (StringsKt.m14162r(name, String.valueOf(fileName))) {
                        Logger.m7104i(TAG, "find file @" + i + " : " + Logger.getEncode(name));
                        return directory + name;
                    }
                }
            }
        } catch (Exception e) {
            Logger.m7101e(TAG, "findFile : " + e.getMessage());
        }
        Logger.m7104i(TAG, "not find file @" + Logger.getEncode(directory) + "/" + Logger.getEncode(fileName));
        return "";
    }

    @NotNull
    public final String findFileExcept(@NotNull String directory, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        try {
            File[] fileArrListFiles = new File(directory).listFiles();
            if (fileArrListFiles != null) {
                int length = fileArrListFiles.length;
                for (int i = 0; i < length; i++) {
                    String name = fileArrListFiles[i].getName();
                    Intrinsics.checkNotNull(name);
                    if (!StringsKt.m14162r(name, fileName)) {
                        Logger.m7104i(TAG, "find excepted file @" + i + " : " + Logger.getEncode(name));
                        return directory + name;
                    }
                }
            }
        } catch (Exception e) {
            AbstractC6670b.m4763x("find excepted file : ", e.getMessage(), TAG);
        }
        Logger.m7104i(TAG, "not find excepted file @" + Logger.getEncode(directory) + "/" + Logger.getEncode(fileName));
        return "";
    }

    @NotNull
    public final String getExternalFilesDirAbsolutePath() {
        return mExternalFilesDirAbsolutePath;
    }

    public final void initialize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File externalFilesDir = context.getExternalFilesDir(null);
        mExternalFilesDirAbsolutePath = String.valueOf(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null);
    }

    public final boolean makeDirectory(@NotNull String directoryPath) {
        Intrinsics.checkNotNullParameter(directoryPath, "directoryPath");
        try {
            File file = new File(directoryPath);
            if (file.exists()) {
                return true;
            }
            String str = TAG;
            Logger.m7100d(str, "makeDirectory(), a directory is not existed, make it");
            if (file.mkdirs()) {
                return true;
            }
            Logger.m7101e(str, "makeDirectory(), fail to make a directory");
            return false;
        } catch (Exception e) {
            AbstractC6670b.m4763x("makeDirectory : ", e.getMessage(), TAG);
            return false;
        }
    }

    public final void moveFile(@NotNull String from, @NotNull String to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        String str = TAG;
        Logger.m7104i(str, "moveFile from/to : " + Logger.getEncode(from) + ":::" + Logger.getEncode(to));
        try {
            if (new File(from).renameTo(new File(to))) {
                return;
            }
            Logger.m7105w(str, "moveFile(), fail to rename");
        } catch (Exception e) {
            Logger.m7101e(TAG, "moveFile : " + e.getMessage());
        }
    }
}
