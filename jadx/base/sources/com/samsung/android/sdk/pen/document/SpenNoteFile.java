package com.samsung.android.sdk.pen.document;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.SpenError;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001c\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0007J\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\bH\u0007J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J0\u0010\u001a\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007J\u001c\u0010\u001c\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001c\u0010 \u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001c\u0010!\u001a\u00020\"2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010#\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010$\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010%\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010&\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010'\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010(\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010)\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010*\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001c\u0010+\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010,\u001a\u00020\"2\b\u0010-\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010.\u001a\u00020\"2\b\u0010-\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010/\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u000202H\u0002J'\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0082 J'\u00105\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0082 J\u0013\u00106\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J\u001d\u00107\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u00010\u000f2\b\u00109\u001a\u0004\u0018\u00010\u000fH\u0082 J\u001b\u0010:\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\bH\u0082 J\u0013\u0010;\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J\u0013\u0010<\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J1\u0010=\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0082 J\u001d\u0010>\u001a\u00020\u000f2\b\u00104\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J\u0013\u0010?\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J!\u0010@\u001a\u00020\b2\u0006\u00104\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020BH\u0082 J\u001d\u0010@\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J\u001d\u0010C\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J\u0013\u0010D\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J#\u0010E\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GH\u0082 J\u0013\u0010I\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J\u0013\u0010J\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J\u0013\u0010K\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J+\u0010L\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020G2\u0006\u0010O\u001a\u00020PH\u0082 J\u0013\u0010Q\u001a\u00020\u00052\b\u0010R\u001a\u0004\u0018\u00010\u000fH\u0082 J\u0013\u0010S\u001a\u00020\u00052\b\u0010R\u001a\u0004\u0018\u00010\u000fH\u0082 J\u0013\u0010T\u001a\u00020\u000f2\b\u0010R\u001a\u0004\u0018\u00010\u000fH\u0082 J\u0013\u0010U\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J\u001d\u0010V\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J\u0013\u0010W\u001a\u00020\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J\u0013\u0010X\u001a\u00020\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082 J'\u0010Y\u001a\u00020\b2\b\u0010Z\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0082 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006["}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenNoteFile;", "", "<init>", "()V", "ORIENTATION_PORTRAIT", "", "ORIENTATION_LANDSCAPE", "isBuildTypeEngMode", "", "()Z", "lock", "", "context", "Landroid/content/Context;", "filePath", "", "password", "unlock", "isLocked", "copy", "destFilePath", "srcFilePath", "setFavorite", "flag", "isFavorite", "isValid", "setCoverImage", "imageFilePath", "getCoverImagePath", "releaseCoverImagePath", "coverImagePath", "getOrientation", "hasUnsavedData", "getLastEditedCacheDataTime", "", "removeNote", "getWidth", "getHeight", "getAppName", "getAppMajorVersion", "getAppMinorVersion", "getAppPatchName", "getFormatVersion", "removeCache", "getLastModifiedTime", "spdPath", "getCreatedTime", "isrightPassword", "deleteFile", "file", "Ljava/io/File;", "NoteFile_lock", "cacheDirPath", "NoteFile_unlock", "NoteFile_isLocked", "NoteFile_copy", "destFilepath", "srcFilepath", "NoteFile_setFavorite", "NoteFile_isFavorite", "NoteFile_isValid", "NoteFile_setCoverImage", "NoteFile_getCoverImage", "NoteFile_getOrientation", "NoteFile_hasUnsavedData", "lastEditedTime", "Ljava/lang/Long;", "NoteFile_getLastEditedCacheDataTime", "NoteFile_removeNote", "NoteFile_getSize", "width", "Ljava/lang/Integer;", "height", "NoteFile_getWidth", "NoteFile_getHeight", "NoteFile_getAppName", "NoteFile_getAppVersion", "appMajorVersion", "appMinorVersion", "appPatchName", "Ljava/lang/StringBuffer;", "NoteFile_getAppMajorVersion", "filepath", "NoteFile_getAppMinorVersion", "NoteFile_getAppPatchName", "NoteFile_getFormatVersion", "NoteFile_removeCache", "NoteFile_getLastModifiedTime", "NoteFile_getCreatedTime", "NoteFile_isRightPassword", "appDir", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNoteFile {

    @NotNull
    public static final SpenNoteFile INSTANCE = new SpenNoteFile();
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 0;

    private SpenNoteFile() {
    }

    private final native boolean NoteFile_copy(String destFilepath, String srcFilepath);

    private final native int NoteFile_getAppMajorVersion(String filepath);

    private final native int NoteFile_getAppMinorVersion(String filepath);

    private final native String NoteFile_getAppName(String filePath);

    private final native String NoteFile_getAppPatchName(String filepath);

    private final native boolean NoteFile_getAppVersion(String filePath, Integer appMajorVersion, Integer appMinorVersion, StringBuffer appPatchName);

    private final native String NoteFile_getCoverImage(String cacheDirPath, String filePath);

    private final native long NoteFile_getCreatedTime(String filePath);

    private final native int NoteFile_getFormatVersion(String filePath);

    private final native int NoteFile_getHeight(String filePath);

    private final native long NoteFile_getLastEditedCacheDataTime(String cacheDirPath, String filePath);

    private final native long NoteFile_getLastModifiedTime(String filePath);

    private final native int NoteFile_getOrientation(String filePath);

    private final native boolean NoteFile_getSize(String filePath, Integer width, Integer height);

    private final native int NoteFile_getWidth(String filePath);

    private final native boolean NoteFile_hasUnsavedData(String cacheDirPath, String filePath);

    private final native boolean NoteFile_hasUnsavedData(String cacheDirPath, String filePath, Long lastEditedTime);

    private final native boolean NoteFile_isFavorite(String filePath);

    private final native boolean NoteFile_isLocked(String filePath);

    private final native boolean NoteFile_isRightPassword(String appDir, String spdPath, String password);

    private final native boolean NoteFile_isValid(String filePath);

    private final native boolean NoteFile_lock(String cacheDirPath, String filePath, String password);

    private final native boolean NoteFile_removeCache(String cacheDirPath, String filePath);

    private final native boolean NoteFile_removeNote(String filePath);

    private final native boolean NoteFile_setCoverImage(String cacheDirPath, String filePath, String password, String imageFilePath);

    private final native boolean NoteFile_setFavorite(String filePath, boolean flag);

    private final native boolean NoteFile_unlock(String cacheDirPath, String filePath, String password);

    @JvmStatic
    public static final void copy(@Nullable String destFilePath, @Nullable String srcFilePath) throws IOException, SpenUnsupportedTypeException {
        if (INSTANCE.NoteFile_copy(destFilePath, srcFilePath)) {
            return;
        }
        int error = SpenError.getError();
        if (error == 10 || error == 11) {
            throw new IOException();
        }
        if (error == 13) {
            throw new SpenUnsupportedTypeException(AbstractC0541b.m773o("E_UNSUPPORTED_TYPE : [", srcFilePath, "] does not correspond to the SPD file format"));
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    private final void deleteFile(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    Intrinsics.checkNotNull(file2);
                    deleteFile(file2);
                }
            }
            file.delete();
        }
    }

    @JvmStatic
    public static final int getAppMajorVersion(@Nullable String filePath) {
        return INSTANCE.NoteFile_getAppMajorVersion(filePath);
    }

    @JvmStatic
    public static final int getAppMinorVersion(@Nullable String filePath) {
        return INSTANCE.NoteFile_getAppMinorVersion(filePath);
    }

    @JvmStatic
    @NotNull
    public static final String getAppName(@Nullable String filePath) {
        return INSTANCE.NoteFile_getAppName(filePath);
    }

    @JvmStatic
    @NotNull
    public static final String getAppPatchName(@Nullable String filePath) {
        return INSTANCE.NoteFile_getAppPatchName(filePath);
    }

    @JvmStatic
    @NotNull
    public static final String getCoverImagePath(@Nullable Context context, @Nullable String filePath) {
        if (context != null) {
            return INSTANCE.NoteFile_getCoverImage(context.getFilesDir().getAbsolutePath(), filePath);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @JvmStatic
    public static final long getCreatedTime(@Nullable String spdPath) {
        return INSTANCE.NoteFile_getCreatedTime(spdPath);
    }

    @JvmStatic
    public static final int getFormatVersion(@Nullable String filePath) {
        return INSTANCE.NoteFile_getFormatVersion(filePath);
    }

    @JvmStatic
    public static final int getHeight(@Nullable String filePath) {
        return INSTANCE.NoteFile_getHeight(filePath);
    }

    @JvmStatic
    public static final long getLastEditedCacheDataTime(@Nullable Context context, @Nullable String filePath) {
        if (context != null) {
            return INSTANCE.NoteFile_getLastEditedCacheDataTime(context.getFilesDir().getAbsolutePath(), filePath);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @JvmStatic
    public static final long getLastModifiedTime(@Nullable String spdPath) {
        return INSTANCE.NoteFile_getLastModifiedTime(spdPath);
    }

    @JvmStatic
    public static final int getOrientation(@Nullable String filePath) {
        return INSTANCE.NoteFile_getOrientation(filePath);
    }

    @JvmStatic
    public static final int getWidth(@Nullable String filePath) {
        return INSTANCE.NoteFile_getWidth(filePath);
    }

    @JvmStatic
    public static final boolean hasUnsavedData(@Nullable Context context, @Nullable String filePath) {
        if (context != null) {
            return INSTANCE.NoteFile_hasUnsavedData(context.getFilesDir().getAbsolutePath(), filePath);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    private final boolean isBuildTypeEngMode() {
        return Intrinsics.areEqual("eng", Build.TYPE);
    }

    @JvmStatic
    public static final boolean isFavorite(@Nullable String filePath) {
        return INSTANCE.NoteFile_isFavorite(filePath);
    }

    @JvmStatic
    public static final boolean isLocked(@Nullable String filePath) {
        return INSTANCE.NoteFile_isLocked(filePath);
    }

    @JvmStatic
    public static final boolean isValid(@Nullable String filePath) {
        return INSTANCE.NoteFile_isValid(filePath);
    }

    @JvmStatic
    public static final boolean isrightPassword(@Nullable Context context, @Nullable String spdPath, @Nullable String password) throws IOException, SpenUnsupportedTypeException {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        boolean zNoteFile_isRightPassword = INSTANCE.NoteFile_isRightPassword(context.getFilesDir().getAbsolutePath(), spdPath, password);
        if (zNoteFile_isRightPassword) {
            return zNoteFile_isRightPassword;
        }
        int error = SpenError.getError();
        if (error == 10 || error == 11) {
            throw new IOException();
        }
        if (error == 13) {
            throw new SpenUnsupportedTypeException(AbstractC0541b.m773o("E_UNSUPPORTED_TYPE : [", spdPath, "] does not correspond to the SPD file format"));
        }
        if (error != 17) {
            SpenError.ThrowUncheckedException(SpenError.getError());
            return zNoteFile_isRightPassword;
        }
        Log.i("SpenNoteFile", "the password is wrong");
        return zNoteFile_isRightPassword;
    }

    @JvmStatic
    public static final void lock(@Nullable Context context, @Nullable String filePath, @Nullable String password) throws IOException, SpenUnsupportedTypeException {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (INSTANCE.NoteFile_lock(context.getFilesDir().getAbsolutePath(), filePath, password)) {
            return;
        }
        int error = SpenError.getError();
        if (error == 10 || error == 11) {
            throw new IOException();
        }
        if (error == 13) {
            throw new SpenUnsupportedTypeException(AbstractC0541b.m773o("E_UNSUPPORTED_TYPE : [", filePath, "] does not correspond to the SPD file format"));
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void releaseCoverImagePath(@Nullable String coverImagePath) {
        File parentFile;
        if (coverImagePath == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        File file = new File(coverImagePath);
        if (file.exists() && (parentFile = file.getParentFile()) != null && parentFile.exists()) {
            INSTANCE.deleteFile(parentFile);
        }
    }

    @JvmStatic
    public static final void removeCache(@Nullable Context context, @Nullable String filePath) {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (INSTANCE.NoteFile_removeCache(context.getFilesDir().getAbsolutePath(), filePath)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void removeNote(@Nullable String filePath) throws IOException, SpenUnsupportedTypeException {
        if (INSTANCE.NoteFile_removeNote(filePath)) {
            return;
        }
        int error = SpenError.getError();
        if (error == 10 || error == 11) {
            throw new IOException();
        }
        if (error == 13) {
            throw new SpenUnsupportedTypeException(AbstractC0541b.m773o("E_UNSUPPORTED_TYPE : [", filePath, "] does not correspond to the SPD file format"));
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void setCoverImage(@Nullable Context context, @Nullable String filePath, @Nullable String password, @Nullable String imageFilePath) throws IOException, SpenUnsupportedTypeException {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (INSTANCE.NoteFile_setCoverImage(context.getFilesDir().getAbsolutePath(), filePath, password, imageFilePath)) {
            return;
        }
        int error = SpenError.getError();
        if (error == 10 || error == 11) {
            throw new IOException();
        }
        if (error == 13) {
            throw new SpenUnsupportedTypeException(AbstractC0541b.m773o("E_UNSUPPORTED_TYPE : [", filePath, "] does not correspond to the SPD file format"));
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void setFavorite(@Nullable String filePath, boolean flag) throws IOException, SpenUnsupportedTypeException {
        if (INSTANCE.NoteFile_setFavorite(filePath, flag)) {
            return;
        }
        int error = SpenError.getError();
        if (error == 10 || error == 11) {
            throw new IOException();
        }
        if (error == 13) {
            throw new SpenUnsupportedTypeException(AbstractC0541b.m773o("E_UNSUPPORTED_TYPE : [", filePath, "] does not correspond to the SPD file format"));
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void unlock(@Nullable Context context, @Nullable String filePath, @Nullable String password) throws IOException, SpenUnsupportedTypeException {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (INSTANCE.NoteFile_unlock(context.getFilesDir().getAbsolutePath(), filePath, password)) {
            return;
        }
        int error = SpenError.getError();
        if (error == 10 || error == 11) {
            throw new IOException();
        }
        if (error == 13) {
            throw new SpenUnsupportedTypeException(AbstractC0541b.m773o("E_UNSUPPORTED_TYPE : [", filePath, "] does not correspond to the SPD file format"));
        }
        if (error == 17) {
            throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }
}
