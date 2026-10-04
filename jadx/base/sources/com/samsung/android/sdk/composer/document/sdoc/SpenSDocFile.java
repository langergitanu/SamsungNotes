package com.samsung.android.sdk.composer.document.sdoc;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.sdk.composer.document.sdoc.textspan.SpenTextSpan;
import com.samsung.android.sdk.composer.document.sdoc.util.EndTagUtil;
import com.samsung.android.sdk.composer.document.sdoc.util.LockUtil;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.util.LogUtil;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.smartswitchfileshare.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\u0013\u001a\u00020\u000fH\u0007J\u001a\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0007J6\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001aJ)\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010\u001fJ+\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010!J)\u0010\"\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010#J)\u0010$\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010#J+\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010!J\u0012\u0010&\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010'\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010(\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010*\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J&\u0010,\u001a\u0016\u0012\u0004\u0012\u00020-\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020-\u0018\u0001`\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J.\u0010,\u001a\u0016\u0012\u0004\u0012\u00020-\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020-\u0018\u0001`\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J.\u0010.\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u001a\u0010/\u001a\u0016\u0012\u0004\u0012\u000200\u0018\u00010\u0019j\n\u0012\u0004\u0012\u000200\u0018\u0001`\u001aH\u0007J&\u00101\u001a\u0016\u0012\u0004\u0012\u000200\u0018\u00010\u0019j\n\u0012\u0004\u0012\u000200\u0018\u0001`\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u00102\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020\fH\u0007J\u0012\u00104\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u00105\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u00106\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u00107\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u00107\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u00108\u001a\u00020\u0007J$\u00109\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u00108\u001a\u00020\u0007H\u0007J$\u0010:\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u00108\u001a\u00020\u0007H\u0007J\u0010\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u0007H\u0002J\u001c\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u0010?\u001a\u0004\u0018\u00010\u0005H\u0002J\u001b\u0010@\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u00020\fH\u0082 J\u001b\u0010B\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u00020\fH\u0082 J\u0013\u0010C\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0082 J7\u0010D\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001aH\u0082 J\u001d\u0010F\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010\u00052\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0013\u0010G\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0082 J\u001d\u0010H\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u00020\fH\u0082 J/\u0010I\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u001a\u0010/\u001a\u0016\u0012\u0004\u0012\u000200\u0018\u00010\u0019j\n\u0012\u0004\u0012\u000200\u0018\u0001`\u001aH\u0082 J'\u0010J\u001a\u0016\u0012\u0004\u0012\u000200\u0018\u00010\u0019j\n\u0012\u0004\u0012\u000200\u0018\u0001`\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0013\u0010K\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0013\u0010L\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0013\u0010M\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0013\u0010N\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0082 J%\u0010O\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010\u00052\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u00108\u001a\u00020\u0007H\u0082 J\u0013\u0010P\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0082 J\u001b\u0010Q\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020\fH\u0082 J%\u0010R\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010\u00052\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u00108\u001a\u00020\u0007H\u0082 J/\u0010S\u001a\u0016\u0012\u0004\u0012\u00020-\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020-\u0018\u0001`\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u00020\fH\u0082 J%\u0010T\u001a\u00020\u00052\b\u0010E\u001a\u0004\u0018\u00010\u00052\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u00108\u001a\u00020\u0007H\u0082 J\t\u0010U\u001a\u00020\fH\u0082 J\t\u0010V\u001a\u00020\fH\u0082 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0010\u0010\u0012¨\u0006W"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDocFile;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DEFAULT_CACHE_LIMIT_SIZE", "", "getModifiedTime", "", "sdocFilePath", "checkUnsupportedVersionException", "", "getCreatedTime", "checkValidity", "", "isTrimmingCache", "isTrimmingCache$annotations", "()Z", "stopTrimCache", "trimCache", "context", "Landroid/content/Context;", "limitSize", "ignoreList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lock", "filePath", "passwordList", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "unlock", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "convertTo32bitEncryption", "(Ljava/lang/String;[Ljava/lang/String;)Z", "updateModifiedTime", "getEncryptedCode", "isEncrypted", "isLocked", "hasUnsavedData", "fileFullPath", "getDocumentType", DynamicActionBarProvider.METHOD_GET_DATA, "getTitleSpan", "Lcom/samsung/android/sdk/composer/document/sdoc/textspan/SpenTextSpan;", "setReminderData", Constants.JTAG_DATA_LIST, "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$ReminderData;", "getReminderData", "setFavorite", "flag", "isFavorite", "getFormatVersion", "getUncompressedSize", "deleteCacheDirectory", "mode", "isCacheAvailable", "getCachePath", "throwUncheckedException", "errno", "forceRenameTo", "curPath", "newPath", "SDocFile_getModifiedTime", "checkUnsupportedException", "SDocFile_getCreatedTime", "SDocFile_checkValidity", "SDocFile_trimCache", "cacheDirPath", "SDocFile_hasUnsavedData", "SDocFile_getDocumentType", "SDocFile_getTitle", "SDocFile_setReminderData", "SDocFile_getReminderData", "SDocFile_isFavorite", "SDocFile_getUncompressedSize", "SDocFile_isLocked", "SDocFile_isEncrypted", "SDocFile_deleteCacheDirectory", "SDocFile_getFormatVersion", "SDocFile_setFavorite", "SDocFile_isCacheAvailable", "SDocFile_getTitleSpan", "SDocFile_getCachePath", "SDocFile_isTrimmingCache", "SDocFile_stopTrimCache", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenSDocFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenSDocFile.kt\ncom/samsung/android/sdk/composer/document/sdoc/SpenSDocFile\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1180:1\n1#2:1181\n*E\n"})
public final class SpenSDocFile {
    public static final int DEFAULT_CACHE_LIMIT_SIZE = 524288000;

    @NotNull
    public static final SpenSDocFile INSTANCE = new SpenSDocFile();

    @NotNull
    private static final String TAG = "SpenSDocFile";

    private SpenSDocFile() {
    }

    private final native boolean SDocFile_checkValidity(String sdocFilePath);

    private final native boolean SDocFile_deleteCacheDirectory(String cacheDirPath, String fileFullPath, int mode);

    private final native String SDocFile_getCachePath(String cacheDirPath, String fileFullPath, int mode);

    private final native long SDocFile_getCreatedTime(String sdocFilePath, boolean checkUnsupportedException);

    private final native int SDocFile_getDocumentType(String sdocFilePath);

    private final native int SDocFile_getFormatVersion(String sdocFilePath);

    private final native long SDocFile_getModifiedTime(String sdocFilePath, boolean checkUnsupportedException);

    private final native ArrayList<SpenSDoc.ReminderData> SDocFile_getReminderData(String sdocFilePath);

    private final native String SDocFile_getTitle(String sdocFilePath, boolean checkUnsupportedException);

    private final native ArrayList<SpenTextSpan> SDocFile_getTitleSpan(String sdocFilePath, boolean checkUnsupportedException);

    private final native long SDocFile_getUncompressedSize(String sdocFilePath);

    private final native boolean SDocFile_hasUnsavedData(String cacheDirPath, String fileFullPath);

    private final native boolean SDocFile_isCacheAvailable(String cacheDirPath, String fileFullPath, int mode);

    private final native boolean SDocFile_isEncrypted(String sdocFilePath);

    private final native boolean SDocFile_isFavorite(String sdocFilePath);

    private final native boolean SDocFile_isLocked(String sdocFilePath);

    private final native boolean SDocFile_isTrimmingCache();

    private final native boolean SDocFile_setFavorite(String sdocFilePath, boolean flag);

    private final native boolean SDocFile_setReminderData(String sdocFilePath, ArrayList<SpenSDoc.ReminderData> dataList);

    private final native boolean SDocFile_stopTrimCache();

    private final native boolean SDocFile_trimCache(String cacheDirPath, int limitSize, ArrayList<String> ignoreList);

    @JvmStatic
    public static final void checkValidity(@Nullable String sdocFilePath) {
        SpenSDocFile spenSDocFile = INSTANCE;
        if (spenSDocFile.SDocFile_checkValidity(sdocFilePath)) {
            return;
        }
        spenSDocFile.throwUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final boolean convertTo32bitEncryption(@Nullable String filePath, @Nullable String[] passwordList) throws IOException {
        if (filePath == null || passwordList == null || passwordList.length < 2) {
            Log.d(TAG, "convertTo32bitEncrypt() - invalid password List");
            return false;
        }
        if (!AbstractC2322a.m1607A(filePath)) {
            throw new IOException(AbstractC0541b.m773o("convertTo32bitEncryption() - the file isn't exist.[", LogUtil.logPath(filePath), "]"));
        }
        EndTagUtil endTagUtil = new EndTagUtil(null);
        try {
            endTagUtil.parse(filePath, true);
            if (endTagUtil.getMDocumentType() != 1) {
                AbstractC6670b.m4757r("convertTo32bitEncryption() - the file[", LogUtil.logPath(filePath), "] is not locked.", TAG);
                return false;
            }
            if (!endTagUtil.isEncrypted()) {
                AbstractC6670b.m4757r("convertTo32bitEncryption() - the file[", LogUtil.logPath(filePath), "] is not encrypted.", TAG);
                return false;
            }
            String str = filePath + "_" + System.currentTimeMillis() + DiskFileUpload.postfix;
            String str2 = passwordList[0];
            String str3 = passwordList[1];
            if (str2 == null || str3 == null) {
                Log.d(TAG, "convertTo32bitEncrypt() - invalid password List2");
                return false;
            }
            if (str2.compareTo(str3) == 0) {
                return false;
            }
            try {
                LockUtil.decrypt(filePath, str, str3);
                try {
                    LockUtil.encrypt(str, str2);
                    INSTANCE.forceRenameTo(str, filePath);
                    return true;
                } catch (Exception e) {
                    Log.d(TAG, "convertTo32bitEncrypt() - encryption fail. : " + e);
                    return false;
                }
            } catch (Exception e2) {
                Log.d(TAG, "convertTo32bitEncrypt() - decryption fail. : " + e2);
                return false;
            }
        } catch (Exception unused) {
            AbstractC6670b.m4757r("convertTo32bitEncryption() - fail to parse file[", LogUtil.logPath(filePath), "]", TAG);
            return false;
        }
    }

    @JvmStatic
    public static final boolean deleteCacheDirectory(@Nullable Context context, @Nullable String fileFullPath) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        boolean zSDocFile_deleteCacheDirectory = INSTANCE.SDocFile_deleteCacheDirectory(context.getFilesDir().getAbsolutePath(), fileFullPath, -1);
        if (zSDocFile_deleteCacheDirectory) {
            return zSDocFile_deleteCacheDirectory;
        }
        int error = SpenError.getError();
        if (error == 11) {
            throw new IOException();
        }
        SpenError.ThrowUncheckedException(error);
        return zSDocFile_deleteCacheDirectory;
    }

    private final boolean forceRenameTo(String curPath, String newPath) {
        if (curPath == null || newPath == null) {
            Log.i(TAG, "forceRenameTo() - Invalid argument.");
            return false;
        }
        File file = new File(curPath);
        if (!file.exists()) {
            AbstractC6670b.m4757r("forceRenameTo() - Fail to get source File. [", LogUtil.logPath(curPath), "]", TAG);
            return false;
        }
        File file2 = new File(newPath);
        if (file2.exists()) {
            if (Intrinsics.areEqual(file, file2)) {
                return true;
            }
            if (!file2.delete()) {
                AbstractC6670b.m4757r("forceRenameTo() - Cannot delete dest file [", LogUtil.logPath(curPath), "]", TAG);
                return false;
            }
        }
        if (file.renameTo(file2)) {
            return true;
        }
        Log.d(TAG, AbstractC0541b.m775q("forceRenameTo() - Cannot rename file [", LogUtil.logPath(curPath), "] to [", LogUtil.logPath(newPath), "]"));
        return false;
    }

    @JvmStatic
    @NotNull
    public static final String getCachePath(@Nullable Context context, @Nullable String fileFullPath, int mode) {
        if (context != null) {
            return INSTANCE.SDocFile_getCachePath(context.getFilesDir().getAbsolutePath(), fileFullPath, mode);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @JvmStatic
    public static final long getCreatedTime(@Nullable String sdocFilePath) {
        SpenSDocFile spenSDocFile = INSTANCE;
        long jSDocFile_getCreatedTime = spenSDocFile.SDocFile_getCreatedTime(sdocFilePath, true);
        if (jSDocFile_getCreatedTime == -1) {
            spenSDocFile.throwUncheckedException(SpenError.getError());
        }
        return jSDocFile_getCreatedTime;
    }

    @JvmStatic
    public static final int getDocumentType(@Nullable String sdocFilePath) throws SpenSDocUnsupportedFileException, SpenSDocUnsupportedVersionException, IOException {
        SpenSDocFile spenSDocFile = INSTANCE;
        int iSDocFile_getDocumentType = spenSDocFile.SDocFile_getDocumentType(sdocFilePath);
        if (iSDocFile_getDocumentType == -1) {
            spenSDocFile.throwUncheckedException(SpenError.getError());
        }
        return iSDocFile_getDocumentType;
    }

    @JvmStatic
    @Nullable
    public static final String getEncryptedCode(@Nullable String filePath, @Nullable String[] passwordList) throws Throwable {
        String str;
        String str2;
        if (filePath == null || passwordList == null || passwordList.length < 2) {
            throw new IllegalArgumentException("getEncryptedCode() - invalid argument");
        }
        if (!AbstractC2322a.m1607A(filePath)) {
            AbstractC6670b.m4757r("getEncryptedCode() - the file isn't exist.[", LogUtil.logPath(filePath), "]", TAG);
            return null;
        }
        EndTagUtil endTagUtil = new EndTagUtil(null);
        try {
            endTagUtil.parse(filePath, true);
            if (endTagUtil.getMDocumentType() != 1) {
                AbstractC6670b.m4757r("getEncryptedCode() - the file[", LogUtil.logPath(filePath), "] is not locked.", TAG);
                return null;
            }
            if (!endTagUtil.isEncrypted()) {
                AbstractC6670b.m4757r("getEncryptedCode() - the file[", LogUtil.logPath(filePath), "] is not encrypted.", TAG);
                return null;
            }
            Iterator it = ArrayIteratorKt.iterator(passwordList);
            while (it.hasNext() && (str = (String) it.next()) != null) {
                try {
                    str2 = filePath + "_" + System.currentTimeMillis() + DiskFileUpload.postfix;
                    try {
                        try {
                            LockUtil.decrypt(filePath, str2, str);
                            File file = new File(str2);
                            if (file.exists() && !file.delete()) {
                                Intrinsics.checkNotNull(str2);
                                AbstractC6670b.m4757r("getEncryptedCode() - fail to delete temp file. [", LogUtil.logPath(str2), "]", TAG);
                            }
                            return str;
                        } catch (Exception e) {
                            e = e;
                            Log.d(TAG, "getEncryptedCode() - Exception : " + e);
                            File file2 = new File(str2);
                            if (file2.exists() && !file2.delete()) {
                                Intrinsics.checkNotNull(str2);
                                AbstractC6670b.m4757r("getEncryptedCode() - fail to delete temp file. [", LogUtil.logPath(str2), "]", TAG);
                                return null;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        File file3 = new File(str2);
                        if (!file3.exists() || file3.delete()) {
                            throw th;
                        }
                        Intrinsics.checkNotNull(str2);
                        AbstractC6670b.m4757r("getEncryptedCode() - fail to delete temp file. [", LogUtil.logPath(str2), "]", TAG);
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = null;
                }
            }
            return null;
        } catch (Exception unused) {
            AbstractC6670b.m4757r("getEncryptedCode() - fail to parse file[", LogUtil.logPath(filePath), "]", TAG);
            return null;
        }
    }

    @JvmStatic
    public static final int getFormatVersion(@Nullable String sdocFilePath) throws SpenSDocUnsupportedFileException, SpenSDocUnsupportedVersionException, IOException {
        SpenSDocFile spenSDocFile = INSTANCE;
        int iSDocFile_getFormatVersion = spenSDocFile.SDocFile_getFormatVersion(sdocFilePath);
        if (iSDocFile_getFormatVersion == -1) {
            spenSDocFile.throwUncheckedException(SpenError.getError());
        }
        return iSDocFile_getFormatVersion;
    }

    @JvmStatic
    public static final long getModifiedTime(@Nullable String sdocFilePath) {
        SpenSDocFile spenSDocFile = INSTANCE;
        long jSDocFile_getModifiedTime = spenSDocFile.SDocFile_getModifiedTime(sdocFilePath, true);
        if (jSDocFile_getModifiedTime == -1) {
            spenSDocFile.throwUncheckedException(SpenError.getError());
        }
        return jSDocFile_getModifiedTime;
    }

    @JvmStatic
    @Nullable
    public static final ArrayList<SpenSDoc.ReminderData> getReminderData(@Nullable String sdocFilePath) throws SpenSDocUnsupportedFileException, SpenSDocUnsupportedVersionException, IOException {
        SpenSDocFile spenSDocFile = INSTANCE;
        ArrayList<SpenSDoc.ReminderData> arrayListSDocFile_getReminderData = spenSDocFile.SDocFile_getReminderData(sdocFilePath);
        if (arrayListSDocFile_getReminderData == null) {
            spenSDocFile.throwUncheckedException(SpenError.getError());
        }
        return arrayListSDocFile_getReminderData;
    }

    @JvmStatic
    @Nullable
    public static final String getTitle(@Nullable String sdocFilePath) {
        return getTitle(sdocFilePath, true);
    }

    @JvmStatic
    @Nullable
    public static final ArrayList<SpenTextSpan> getTitleSpan(@Nullable String sdocFilePath) {
        return getTitleSpan(sdocFilePath, true);
    }

    @JvmStatic
    public static final long getUncompressedSize(@Nullable String sdocFilePath) throws SpenSDocUnsupportedFileException, SpenSDocUnsupportedVersionException, IOException {
        SpenSDocFile spenSDocFile = INSTANCE;
        long jSDocFile_getUncompressedSize = spenSDocFile.SDocFile_getUncompressedSize(sdocFilePath);
        if (jSDocFile_getUncompressedSize == -1) {
            spenSDocFile.throwUncheckedException(SpenError.getError());
        }
        return jSDocFile_getUncompressedSize;
    }

    @JvmStatic
    public static final boolean hasUnsavedData(@Nullable Context context, @Nullable String fileFullPath) {
        if (context != null) {
            return INSTANCE.SDocFile_hasUnsavedData(context.getFilesDir().getAbsolutePath(), fileFullPath);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @JvmStatic
    public static final boolean isCacheAvailable(@Nullable Context context, @Nullable String fileFullPath, int mode) {
        if (context != null) {
            return INSTANCE.SDocFile_isCacheAvailable(context.getFilesDir().getAbsolutePath(), fileFullPath, mode);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @JvmStatic
    public static final boolean isEncrypted(@Nullable String sdocFilePath) {
        return INSTANCE.SDocFile_isEncrypted(sdocFilePath);
    }

    @JvmStatic
    public static final boolean isFavorite(@Nullable String sdocFilePath) {
        return INSTANCE.SDocFile_isFavorite(sdocFilePath);
    }

    @JvmStatic
    public static final boolean isLocked(@Nullable String sdocFilePath) {
        if (sdocFilePath != null) {
            return INSTANCE.SDocFile_isLocked(sdocFilePath);
        }
        throw new IllegalArgumentException("isLocked() - invalid argument");
    }

    public static final boolean isTrimmingCache() {
        return INSTANCE.SDocFile_isTrimmingCache();
    }

    @JvmStatic
    public static /* synthetic */ void isTrimmingCache$annotations() {
    }

    @JvmStatic
    public static final void lock(@Nullable String filePath, @Nullable String[] passwordList) throws IOException {
        Log.d(TAG, "lock()");
        if (filePath == null || passwordList == null || passwordList.length < 2) {
            throw new IllegalArgumentException("lock() - invalid argument1");
        }
        String str = passwordList[0];
        if (str == null) {
            throw new IllegalArgumentException("lock() - invalid argument2");
        }
        if (!AbstractC2322a.m1607A(filePath)) {
            throw new IOException(AbstractC0541b.m773o("lock() - the file isn't exist.[", LogUtil.logPath(filePath), "]"));
        }
        EndTagUtil endTagUtil = new EndTagUtil(null);
        endTagUtil.parse(filePath, true);
        if (endTagUtil.getMDocumentType() != 0) {
            throw new IllegalStateException(AbstractC0541b.m773o("lock() - the file[", LogUtil.logPath(filePath), "] is locked already.").toString());
        }
        endTagUtil.setDocumentType(1);
        endTagUtil.setCreatedTime(endTagUtil.getMCreatedTime());
        endTagUtil.setModifiedTime(endTagUtil.getMModifiedTime());
        endTagUtil.update(filePath);
        LockUtil.encrypt(filePath, str);
    }

    @JvmStatic
    public static final void setFavorite(@Nullable String sdocFilePath, boolean flag) throws SpenSDocUnsupportedFileException, SpenSDocUnsupportedVersionException, IOException {
        SpenSDocFile spenSDocFile = INSTANCE;
        if (spenSDocFile.SDocFile_setFavorite(sdocFilePath, flag)) {
            return;
        }
        spenSDocFile.throwUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void setReminderData(@Nullable String sdocFilePath, @Nullable ArrayList<SpenSDoc.ReminderData> dataList) throws SpenSDocUnsupportedFileException, SpenSDocUnsupportedVersionException, IOException {
        SpenSDocFile spenSDocFile = INSTANCE;
        if (spenSDocFile.SDocFile_setReminderData(sdocFilePath, dataList)) {
            return;
        }
        spenSDocFile.throwUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void stopTrimCache() {
        if (INSTANCE.SDocFile_stopTrimCache()) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    private final void throwUncheckedException(int errno) throws SpenSDocUnsupportedFileException, SpenSDocUnsupportedVersionException, IOException {
        if (errno == 19) {
            throw new SpenAlreadyClosedException("SpenSDocFile is already closed");
        }
        switch (errno) {
            case 11:
                throw new IOException();
            case 12:
                throw new SpenSDocUnsupportedVersionException("E_UNSUPPORTED_VERSION : code version can note support this file");
            case 13:
                throw new SpenSDocUnsupportedFileException("E_UNSUPPORTED_TYPE : It does not correspond to the SDoc file format");
            default:
                SpenError.ThrowUncheckedException(errno);
                return;
        }
    }

    @JvmStatic
    public static final void trimCache(@Nullable Context context, int limitSize) {
        INSTANCE.trimCache(context, limitSize, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trimCache$default(SpenSDocFile spenSDocFile, Context context, int i, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            arrayList = null;
        }
        spenSDocFile.trimCache(context, i, arrayList);
    }

    @JvmStatic
    @Nullable
    public static final String unlock(@Nullable String filePath, @Nullable String[] passwordList) throws Exception {
        Log.d(TAG, "unlock()");
        if (filePath == null) {
            throw new IllegalArgumentException("unlock() - invalid argument");
        }
        if (!AbstractC2322a.m1607A(filePath)) {
            throw new IOException(AbstractC0541b.m773o("unlock() - the file isn't exist.[", LogUtil.logPath(filePath), "]"));
        }
        String str = null;
        EndTagUtil endTagUtil = new EndTagUtil(null);
        endTagUtil.parse(filePath, true);
        if (endTagUtil.getMDocumentType() != 1) {
            throw new IllegalStateException(AbstractC0541b.m773o("unlock() - the file[", LogUtil.logPath(filePath), "] is not locked.").toString());
        }
        if (endTagUtil.isEncrypted()) {
            if (passwordList == null || passwordList.length < 2) {
                throw new IllegalArgumentException("unlock() - invalid argument");
            }
            str = passwordList[0];
            try {
                Intrinsics.checkNotNull(str);
                LockUtil.decrypt(filePath, str);
            } catch (Exception e) {
                Log.d(TAG, "unlock - step 1 fail. " + e);
                String str2 = passwordList[1];
                if (str2 != null && str2.length() != 0) {
                    Intrinsics.checkNotNull(str);
                    if (str2.compareTo(str) != 0) {
                        Log.d(TAG, "unlock - try step 2.");
                        LockUtil.decrypt(filePath, str2);
                        str = str2;
                    }
                }
                throw e;
            }
        }
        endTagUtil.removeEncryptionInfo();
        endTagUtil.setDocumentType(0);
        endTagUtil.setCreatedTime(endTagUtil.getMCreatedTime());
        endTagUtil.setModifiedTime(endTagUtil.getMModifiedTime());
        endTagUtil.resetStartPosition(filePath);
        endTagUtil.update(filePath);
        return str;
    }

    @JvmStatic
    public static final boolean updateModifiedTime(@Nullable String filePath, @Nullable String[] passwordList) throws IOException {
        if (filePath == null || passwordList == null || passwordList.length < 2) {
            Log.d(TAG, "updateModifiedTime() - invalid password List");
            return false;
        }
        if (!AbstractC2322a.m1607A(filePath)) {
            throw new IOException(AbstractC0541b.m773o("updateModifiedTime() - the file isn't exist.[", LogUtil.logPath(filePath), "]"));
        }
        EndTagUtil endTagUtil = new EndTagUtil(null);
        try {
            endTagUtil.parse(filePath, true);
            if (endTagUtil.getMDocumentType() != 1) {
                AbstractC6670b.m4757r("updateModifiedTime() - the file[", LogUtil.logPath(filePath), "] is not locked.", TAG);
                return false;
            }
            if (!endTagUtil.isEncrypted()) {
                AbstractC6670b.m4757r("updateModifiedTime() - the file[", LogUtil.logPath(filePath), "] is not encrypted.", TAG);
                return false;
            }
            String str = passwordList[0];
            String str2 = passwordList[1];
            if (str == null || str2 == null) {
                Log.d(TAG, "updateModifiedTime() - invalid password List2");
                return false;
            }
            if (str.compareTo(str2) == 0) {
                return false;
            }
            String str3 = filePath + "_" + System.currentTimeMillis() + DiskFileUpload.postfix;
            if (LockUtil.isInvalidDecryption(filePath, str3, str2)) {
                try {
                    LockUtil.decrypt(filePath, str3, str);
                    File file = new File(str3);
                    if (file.exists() && !file.delete()) {
                        Log.d(TAG, "updateModifiedTime() - fail to delete temporary file.");
                    }
                    EndTagUtil endTagUtil2 = new EndTagUtil(null);
                    try {
                        endTagUtil2.parse(filePath, true);
                        endTagUtil2.setCreatedTime(endTagUtil2.getMCreatedTime());
                        endTagUtil2.setModifiedTime(endTagUtil2.getMModifiedTime() + 1);
                        endTagUtil2.update(filePath);
                        return true;
                    } catch (Exception unused) {
                        Log.d(TAG, "updateModifiedTime() - fail to parse endtag");
                        return false;
                    }
                } catch (Exception e) {
                    Log.d(TAG, "updateModifiedTime() - invalid file : " + e);
                }
            }
            return false;
        } catch (Exception unused2) {
            AbstractC6670b.m4757r("updateModifiedTime() - fail to parse file[", LogUtil.logPath(filePath), "]", TAG);
            return false;
        }
    }

    @JvmStatic
    @Nullable
    public static final String getTitle(@Nullable String sdocFilePath, boolean checkUnsupportedVersionException) throws SpenSDocUnsupportedFileException, SpenSDocUnsupportedVersionException, IOException {
        SpenSDocFile spenSDocFile = INSTANCE;
        String strSDocFile_getTitle = spenSDocFile.SDocFile_getTitle(sdocFilePath, checkUnsupportedVersionException);
        if (strSDocFile_getTitle == null) {
            spenSDocFile.throwUncheckedException(SpenError.getError());
        }
        return strSDocFile_getTitle;
    }

    @JvmStatic
    @Nullable
    public static final ArrayList<SpenTextSpan> getTitleSpan(@Nullable String sdocFilePath, boolean checkUnsupportedVersionException) throws SpenSDocUnsupportedFileException, SpenSDocUnsupportedVersionException, IOException {
        SpenSDocFile spenSDocFile = INSTANCE;
        ArrayList<SpenTextSpan> arrayListSDocFile_getTitleSpan = spenSDocFile.SDocFile_getTitleSpan(sdocFilePath, checkUnsupportedVersionException);
        if (arrayListSDocFile_getTitleSpan == null) {
            spenSDocFile.throwUncheckedException(SpenError.getError());
        }
        return arrayListSDocFile_getTitleSpan;
    }

    public final void trimCache(@Nullable Context context, int limitSize, @Nullable ArrayList<String> ignoreList) {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (SDocFile_trimCache(context.getFilesDir().getAbsolutePath(), limitSize, ignoreList)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final long getCreatedTime(@Nullable String sdocFilePath, boolean checkUnsupportedVersionException) throws SpenSDocUnsupportedFileException, SpenSDocUnsupportedVersionException, IOException {
        SpenSDocFile spenSDocFile = INSTANCE;
        long jSDocFile_getCreatedTime = spenSDocFile.SDocFile_getCreatedTime(sdocFilePath, checkUnsupportedVersionException);
        if (jSDocFile_getCreatedTime == -1) {
            spenSDocFile.throwUncheckedException(SpenError.getError());
        }
        return jSDocFile_getCreatedTime;
    }

    @JvmStatic
    public static final long getModifiedTime(@Nullable String sdocFilePath, boolean checkUnsupportedVersionException) {
        SpenSDocFile spenSDocFile = INSTANCE;
        long jSDocFile_getModifiedTime = spenSDocFile.SDocFile_getModifiedTime(sdocFilePath, checkUnsupportedVersionException);
        if (jSDocFile_getModifiedTime == -1) {
            spenSDocFile.throwUncheckedException(SpenError.getError());
        }
        return jSDocFile_getModifiedTime;
    }

    public final boolean deleteCacheDirectory(@Nullable Context context, @Nullable String fileFullPath, int mode) throws IOException {
        if (context != null) {
            boolean zSDocFile_deleteCacheDirectory = SDocFile_deleteCacheDirectory(context.getFilesDir().getAbsolutePath(), fileFullPath, mode);
            if (zSDocFile_deleteCacheDirectory) {
                return zSDocFile_deleteCacheDirectory;
            }
            int error = SpenError.getError();
            if (error != 11) {
                SpenError.ThrowUncheckedException(error);
                return zSDocFile_deleteCacheDirectory;
            }
            throw new IOException();
        }
        throw new IllegalArgumentException("Required value was null.");
    }
}
