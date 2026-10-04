package com.samsung.android.support.senl.p148nt.model.utils;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.constants.DataBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.C10065b;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.temp.domain.model.DeletedNote;
import com.samsung.android.support.senl.p148nt.data.database.temp.p165di.ExtraDbRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class NotesDocumentDeleteUtils {
    private static final long DELAY_TIME_TO_CHECK_DELETED_FILE = 1000;
    public static final String TAG = DataLogger.createTag("NotesDocumentDeleteUtils");
    private static Executor sDeleteExecutor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onDeleted(@NonNull String str);
    }

    @WorkerThread
    public static boolean deleteDocument(@Nullable final Context context, @Nullable final String str, @Nullable final String str2, @Nullable final String str3, @Nullable final String str4, boolean z, @DataBaseConstants.DeletedBy int i, @Nullable final Callback callback) {
        DataLogger.m12302d(TAG, "deleteDocument, filePath: " + DataLogger.getEncode(str2) + ", callee: " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        if (context != null && str2 != null && !str2.isEmpty() && SpenSdkInitializer.initialize(context)) {
            if (z) {
                ExtraDbRepositoryFactory.createDeletedNoteRepository().insert(new DeletedNote(0L, str == null ? "" : str, str2, i));
            }
            try {
                DocumentFileManager.getInstance().delete(str2, new DocumentFileManager.IOAction() { // from class: com.samsung.android.support.senl.nt.model.utils.b
                    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
                    public final Object operate() {
                        return NotesDocumentDeleteUtils.lambda$deleteDocument$1(str2, context, str, str3, str4, callback);
                    }
                });
                if (str == null) {
                    return true;
                }
                DataUpdateManager.getInstance().onDocumentFileDeleted(str);
                return true;
            } catch (IOException e) {
                AbstractC11014a.m12332q(e, new StringBuilder("deleteDocument, e : "), TAG);
            }
        }
        return false;
    }

    private static void deleteDocumentCache(Context context, String str) {
        FileUtils.deleteFile(new File(PageCacheUtils.getRootCacheDirectory(context), str));
    }

    public static void deleteDocumentFile(Context context, List<DocumentData> list, @DataBaseConstants.DeletedBy int i) {
        for (DocumentData documentData : list) {
            if (documentData != null) {
                deleteDocumentFile(context, documentData.getUuid(), documentData.getFilePath(), documentData.getContentUuid(), documentData.getStrokeUuid(), true, true, i, null);
            }
        }
    }

    private static void deleteSPenDocument(@NonNull Context context, @NonNull String str) {
        File[] fileArrListFiles;
        DataLogger.m12302d(TAG, "deleteSPenDocument, filePath: " + DataLogger.getEncode(str));
        String noteFilePath = WDocUtils.getNoteFilePath(context);
        if (TextUtils.isEmpty(noteFilePath)) {
            return;
        }
        String strExtractFile = FileUtils.extractFile(str);
        if (TextUtils.isEmpty(strExtractFile) || (fileArrListFiles = new File(noteFilePath).listFiles(new C10065b(strExtractFile, 2))) == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            FileUtils.deleteFile(file);
        }
    }

    public static synchronized void execute(@NonNull Runnable runnable) {
        try {
            if (sDeleteExecutor == null) {
                sDeleteExecutor = Executors.newFixedThreadPool(5, new SenlThreadFactory(TAG));
            }
            sDeleteExecutor.execute(runnable);
        } catch (Throwable th) {
            throw th;
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$deleteDocument$1(String str, Context context, String str2, String str3, String str4, Callback callback) {
        DataLogger.m12307i(TAG, "deleteDocument, start");
        if (str.endsWith(".sdocx")) {
            SpenWNoteFile.removeClosedCache(context, str);
        }
        deleteSPenDocument(context, str);
        if (str2 != null) {
            deleteDocumentCache(context, str2);
            OldDocumentThumbnailUtils.deleteThumbnailFiles(context, Arrays.asList(str2, str3, str4));
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            DataLogger.m12303e(TAG, "deleteDocument, sleep, e: " + e.getMessage());
        }
        if (!AbstractC2322a.m1607A(str)) {
            ExtraDbRepositoryFactory.createDeletedNoteRepository().delete(str);
        }
        if (callback != null) {
            callback.onDeleted(str);
        }
        DataLogger.m12307i(TAG, "deleteDocument, end");
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$deleteSPenDocument$2(String str, File file, String str2) {
        return str2.startsWith(str);
    }

    @VisibleForTesting
    public static synchronized void setExecutor(ExecutorService executorService) {
        sDeleteExecutor = executorService;
    }

    public static void deleteDocumentFile(Context context, String str, String str2, String str3, String str4, @DataBaseConstants.DeletedBy int i) {
        deleteDocumentFile(context, str, str2, str3, str4, false, true, i, null);
    }

    public static void deleteDocumentFile(Context context, String str, String str2, boolean z, boolean z2, @DataBaseConstants.DeletedBy int i, @Nullable Callback callback) {
        deleteDocumentFile(context, str, str2, null, null, z, z2, i, callback);
    }

    private static void deleteDocumentFile(final Context context, final String str, final String str2, final String str3, final String str4, boolean z, final boolean z2, @DataBaseConstants.DeletedBy final int i, @Nullable final Callback callback) {
        if (!z && !isMainThread()) {
            deleteDocument(context, str, str2, str3, str4, z2, i, callback);
        } else {
            execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    NotesDocumentDeleteUtils.deleteDocument(context, str, str2, str3, str4, z2, i, callback);
                }
            });
        }
    }
}
