package com.samsung.android.support.senl.p148nt.app.sync.providers;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.base.common.StorageLogger;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRetryDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.ExceptionFileManager;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SDocProviderDump {
    private static final float SIZE_UNIT_MB = 1048576.0f;

    public static void dump(Context context, PrintWriter printWriter) {
        printAppVersionInfo(context, printWriter);
        printSettingInfo(context, printWriter);
        printStatusInfo(context, printWriter);
        printDatabaseInfo(context, printWriter);
        printFileLoggingInfo(context, printWriter);
    }

    @WorkerThread
    public static void dumpStorageInfo(@NonNull Context context) {
        List<NotesDocumentEntity> listDumpDocumentTable = NotesDatabaseManager.getInstance().getDebugDao().dumpDocumentTable();
        StorageLogger.INSTANCE.print(context, Arrays.asList(getDocumentFileCountInfo(context), getDocumentDBCountInfo(listDumpDocumentTable)));
    }

    private static String getDocumentDBCountInfo(@NonNull List<NotesDocumentEntity> list) {
        return "dump doc(DB):" + list.size();
    }

    private static String getDocumentFileCountInfo(@NonNull Context context) {
        int cacheCount = DocumentCacheUtils.getCacheCount(context, 0);
        int cacheCount2 = DocumentCacheUtils.getCacheCount(context, 100);
        StringBuilder sb = new StringBuilder("doc(File) count: ");
        sb.append(getNoteCount(context));
        sb.append(" / appCache: ");
        sb.append(cacheCount + cacheCount2);
        AbstractC0622a.m1180z(sb, cacheCount, cacheCount2, "(doc: ", "/ pdf:");
        sb.append(") / sdkCache: ");
        sb.append(WDocUtils.getSdkCacheDocCount(context));
        return sb.toString();
    }

    private static String getNoteCount(Context context) {
        int i;
        File[] fileArrListFiles = new File(WDocUtils.getNoteFilePath(context)).listFiles();
        int i2 = 0;
        if (fileArrListFiles != null) {
            int length = fileArrListFiles.length;
            i = 0;
            int i4 = 0;
            while (i2 < length) {
                String name = fileArrListFiles[i2].getName();
                String strSubstring = name.substring(name.lastIndexOf(46) + 1);
                if ("sdocx".equals(strSubstring)) {
                    i4++;
                } else if ("sdoc".equals(strSubstring)) {
                    i++;
                }
                i2++;
            }
            i2 = i4;
        } else {
            i = 0;
        }
        return (i2 + i) + "(sdocx: " + i2 + "/ sdoc: " + i + ")";
    }

    private static String getRecognitionLanguage() {
        return SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE, null);
    }

    private static String getUILogs(Context context) {
        SharedPreferencesCompat.setApplicationContext(context.getApplicationContext());
        return "Sort [type/order: " + NotesUtils.getSortType() + "/" + NotesUtils.getOrderType() + "]";
    }

    private static void printAppVersionInfo(Context context, PrintWriter printWriter) {
        printWriter.println("version: " + PackageManagerCompat.INSTANCE.getInstance().getVersionInfo(context));
    }

    private static void printDatabaseInfo(Context context, PrintWriter printWriter) {
        NotesDebugDao debugDao = NotesDatabaseManager.getInstance().getDebugDao();
        NotesRetryDao retryDao = NotesDatabaseManager.getInstance().getRetryDao();
        List<NotesDocumentEntity> listDumpDocumentTable = debugDao.dumpDocumentTable();
        List<NotesCategoryTreeEntity> allCategoryEntities = debugDao.getAllCategoryEntities();
        Set<String> exceptedNotes = ExceptionFileManager.getExceptedNotes(context);
        printWriter.println(getDocumentFileCountInfo(context));
        printWriter.println(getDocumentDBCountInfo(listDumpDocumentTable));
        printWriter.println("converted note count: " + NotesDataRepositoryFactory.newInstance(context).createNotesConvertedDocumentRepository().getAll_ConvertedCount(0));
        printWriter.println("collect status(note/pdf/done/excepted): " + retryDao.getCountInState(1) + "/" + retryDao.getCountInState(3) + "/" + retryDao.getCountInState(2) + "/" + exceptedNotes.size() + '\n');
        printDocumentTable(printWriter, listDumpDocumentTable, exceptedNotes);
        printFolderTable(printWriter, allCategoryEntities);
    }

    @SuppressLint({"DefaultLocale"})
    private static void printDocumentTable(PrintWriter printWriter, List<NotesDocumentEntity> list, Set<String> set) {
        if (list.isEmpty()) {
            return;
        }
        printWriter.println("[No] UUID / delete / dirty / corrupted / LOCK_TYPE [/owner] / createdAt / lastModifiedAt / serverTimestamp / folderUuid / folder dirty / folder serverTimestamp / path [/sdoc / lastMappedAt] / exist / spaceId / size / excepted");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (NotesDocumentEntity notesDocumentEntity : list) {
            int i2 = i + 1;
            sb.append(String.format(Locale.ENGLISH, "%03d", Integer.valueOf(i)));
            String uuid = notesDocumentEntity.getUuid();
            sb.append(SQLKeyword.COMMA);
            sb.append(uuid);
            int isDeleted = notesDocumentEntity.getIsDeleted();
            sb.append(", delete:");
            sb.append(isDeleted);
            int isDirty = notesDocumentEntity.getIsDirty();
            sb.append(SQLKeyword.COMMA);
            sb.append(isDirty);
            int corrupted = notesDocumentEntity.getCorrupted();
            sb.append(SQLKeyword.COMMA);
            sb.append(corrupted);
            int isLock = notesDocumentEntity.getIsLock();
            sb.append(SQLKeyword.COMMA);
            sb.append(LockUtils.lockTypeToString(isLock));
            if (isLock == 5) {
                sb.append(SQLKeyword.COMMA);
                sb.append(DataLogger.pii(notesDocumentEntity.getLockAccountGuid()));
            }
            long createdAt = notesDocumentEntity.getCreatedAt();
            sb.append(SQLKeyword.COMMA);
            sb.append(Logger.getTimeString(createdAt));
            long lastModifiedAt = notesDocumentEntity.getLastModifiedAt();
            sb.append(SQLKeyword.COMMA);
            sb.append(Logger.getTimeString(lastModifiedAt));
            try {
                long jLongValue = notesDocumentEntity.getServerTimestamp().longValue();
                sb.append(SQLKeyword.COMMA);
                sb.append(Logger.getTimeString(jLongValue));
            } catch (Exception unused) {
                sb.append(", serverTimestamp:0");
            }
            String categoryUuid = notesDocumentEntity.getCategoryUuid();
            sb.append(SQLKeyword.COMMA);
            sb.append(categoryUuid);
            int categoryIsDirty = notesDocumentEntity.getCategoryIsDirty();
            sb.append(SQLKeyword.COMMA);
            sb.append(categoryIsDirty);
            try {
                long jLongValue2 = notesDocumentEntity.getCategoryServerTimeStamp().longValue();
                sb.append(SQLKeyword.COMMA);
                sb.append(Logger.getTimeString(jLongValue2));
            } catch (Exception unused2) {
                sb.append(", categoryServerTimeStamp:0");
            }
            String filePath = notesDocumentEntity.getFilePath();
            File file = new File(filePath);
            sb.append(SQLKeyword.COMMA);
            sb.append(Logger.getEncode(file.getName()));
            if (filePath.toLowerCase().endsWith(".sdoc")) {
                sb.append(", sdoc, ");
                sb.append(notesDocumentEntity.getLastMappedAt());
            }
            sb.append(SQLKeyword.COMMA);
            sb.append(file.exists());
            sb.append(SQLKeyword.COMMA);
            sb.append(notesDocumentEntity.getMdeSpaceId());
            sb.append(SQLKeyword.COMMA);
            sb.append(String.format("%.2f", Float.valueOf(notesDocumentEntity.getSize() / 1048576.0f)));
            sb.append("MB, ");
            sb.append(set.contains(uuid));
            sb.append('\n');
            i = i2;
        }
        printWriter.print(sb);
    }

    private static void printFileLoggingInfo(Context context, PrintWriter printWriter) {
        printWriter.println(FileExtensions.getLogText(context));
    }

    private static void printFolderTable(PrintWriter printWriter, List<NotesCategoryTreeEntity> list) {
        int size = list.size();
        printWriter.println("\ndump folder: " + size);
        printWriter.println("[No] UUID / parentUUID / name / delete / reorder / dirty / msSync / createdAt / lastModifiedAt / serverTimestamp");
        if (size != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (NotesCategoryTreeEntity notesCategoryTreeEntity : list) {
                String uuid = notesCategoryTreeEntity.getUuid();
                int i2 = i + 1;
                sb.append(String.format(Locale.ENGLISH, "%03d", Integer.valueOf(i)));
                sb.append(SQLKeyword.COMMA);
                sb.append(uuid);
                sb.append(SQLKeyword.COMMA);
                sb.append(notesCategoryTreeEntity.getParentUuid());
                sb.append(SQLKeyword.COMMA);
                sb.append(Logger.getEncode(notesCategoryTreeEntity.getDisplayName()));
                sb.append(", delete:");
                sb.append(notesCategoryTreeEntity.getIsDeleted());
                sb.append(SQLKeyword.COMMA);
                sb.append(notesCategoryTreeEntity.getReorder());
                sb.append(SQLKeyword.COMMA);
                sb.append(notesCategoryTreeEntity.getIsDirty());
                sb.append(SQLKeyword.COMMA);
                sb.append(notesCategoryTreeEntity.isSyncWithMS());
                sb.append(SQLKeyword.COMMA);
                sb.append(Logger.getTimeString(notesCategoryTreeEntity.getCreatedAt()));
                sb.append(SQLKeyword.COMMA);
                sb.append(Logger.getTimeString(notesCategoryTreeEntity.getLastModifiedAt()));
                try {
                    sb.append(SQLKeyword.COMMA);
                    sb.append(Logger.getTimeString(notesCategoryTreeEntity.getServerTimeStamp().longValue()));
                } catch (Exception unused) {
                    sb.append(", 0");
                }
                sb.append('\n');
                i = i2;
            }
            printWriter.println(sb);
        }
    }

    private static void printSettingInfo(Context context, PrintWriter printWriter) {
        printWriter.println("UI Sort options: " + getUILogs(context));
        printWriter.println("HW Recognition Lang: " + getRecognitionLanguage() + '\n');
    }

    private static void printStatusInfo(Context context, PrintWriter printWriter) {
        printWriter.println("Service status: " + ServiceManager.INSTANCE.getInstance().dumpStatus(context));
    }
}
