package com.samsung.android.support.senl.p148nt.base.common.diagmon;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.sec.android.diagmonagent.log.provider.DiagMonSDK;
import com.sec.android.diagmonagent.log.provider.EventBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\u0019\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\u001c\u001a\u00020\u0012H\u0007J\"\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J&\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\u00142\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010*2\u0006\u0010.\u001a\u00020\u0005H\u0002J\u001a\u0010/\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u00100\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonLogger;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "TEST_DIAGMON_LOGGING", "", "LOG_FILE_NAME", "EXTRA_FILE_NAME", "LOG_DIR", "LOG_FILE_PATH", "EXTRA_FILE_PATH", "reportHistory", "", "preferences", "Landroid/content/SharedPreferences;", "report", "", "e", "", "mainErrCode", "reportOnce", "reportOnceDay", "extraMsg", "getExceptionMsg", "subErrCode", "", "clearPreferencesForLogger", "reportToDiagmon", "metaInfo", "isAlreadyReported", "isAlreadyReportedWhithinDay", "getSharedPreferences", "isReadyToReport", "()Z", "initializeLogger", "isLoggingState", "reportForError", "postReport", "writeFile", "file", "Ljava/io/File;", "log", "extraLog", "createLogFileToReport", "filePath", "prepareFilesToReport", "createLogDirectoryToReport", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DiagMonLogger {

    @NotNull
    private static final String EXTRA_FILE_NAME = "extra.log";

    @NotNull
    private static final String EXTRA_FILE_PATH;

    @NotNull
    public static final DiagMonLogger INSTANCE = new DiagMonLogger();

    @Nullable
    private static final String LOG_DIR;

    @NotNull
    private static final String LOG_FILE_NAME = "diagmon.log";

    @NotNull
    private static final String LOG_FILE_PATH;

    @NotNull
    private static final String TAG = "DiagMonLogger";
    private static final boolean TEST_DIAGMON_LOGGING = true;

    @Nullable
    private static SharedPreferences preferences;

    @NotNull
    private static final List<String> reportHistory;

    static {
        File filesDir;
        String parent;
        Context appContext = ApplicationManager.INSTANCE.getInstance().getAppContext();
        String strConcat = (appContext == null || (filesDir = appContext.getFilesDir()) == null || (parent = filesDir.getParent()) == null) ? null : parent.concat("/diagmon/");
        LOG_DIR = strConcat;
        LOG_FILE_PATH = AbstractC0541b.m756B(strConcat, LOG_FILE_NAME);
        EXTRA_FILE_PATH = AbstractC0541b.m756B(strConcat, EXTRA_FILE_NAME);
        reportHistory = new ArrayList();
    }

    private DiagMonLogger() {
    }

    @JvmStatic
    public static final void clearPreferencesForLogger() {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorClear;
        SharedPreferences.Editor editorEdit2;
        SharedPreferences.Editor editorClear2;
        SharedPreferences.Editor editorEdit3;
        SharedPreferences.Editor editorClear3;
        SharedPreferences.Editor editorEdit4;
        SharedPreferences.Editor editorClear4;
        Logger.m8697d(TAG, "clearPreferencesForLogger()");
        Context applicationContext = BaseUtils.getApplicationContext();
        SharedPreferences sharedPreferences = applicationContext != null ? applicationContext.getSharedPreferences("SYNC_ERROR", 0) : null;
        if (sharedPreferences != null && (editorEdit4 = sharedPreferences.edit()) != null && (editorClear4 = editorEdit4.clear()) != null) {
            editorClear4.apply();
        }
        SharedPreferences sharedPreferences2 = applicationContext != null ? applicationContext.getSharedPreferences("SERVER_ERROR", 0) : null;
        if (sharedPreferences2 != null && (editorEdit3 = sharedPreferences2.edit()) != null && (editorClear3 = editorEdit3.clear()) != null) {
            editorClear3.apply();
        }
        SharedPreferences sharedPreferences3 = applicationContext != null ? applicationContext.getSharedPreferences("APP_ERROR", 0) : null;
        if (sharedPreferences3 != null && (editorEdit2 = sharedPreferences3.edit()) != null && (editorClear2 = editorEdit2.clear()) != null) {
            editorClear2.apply();
        }
        SharedPreferences sharedPreferences4 = applicationContext != null ? applicationContext.getSharedPreferences("SPEN_ERROR", 0) : null;
        if (sharedPreferences4 == null || (editorEdit = sharedPreferences4.edit()) == null || (editorClear = editorEdit.clear()) == null) {
            return;
        }
        editorClear.apply();
    }

    private final boolean createLogDirectoryToReport() {
        File file = new File(LOG_DIR);
        try {
            if (file.exists()) {
                FileUtils.deleteFile(file);
            }
            return file.mkdirs();
        } catch (IOException unused) {
            return false;
        }
    }

    private final File createLogFileToReport(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                return file;
            }
            return null;
        } catch (IOException e) {
            AbstractC4539a.m3214x("createLogFileToReport() : ", e.getMessage(), TAG);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final String getExceptionMsg(@Nullable String mainErrCode, int subErrCode, @Nullable String extraMsg) {
        StringBuilder sbM778t = AbstractC0541b.m778t(subErrCode, "subErrCode = ", ", errMsg = ");
        sbM778t.append(DiagMonError.getErrorMsg(mainErrCode, subErrCode));
        if (!TextUtils.isEmpty(extraMsg)) {
            sbM778t.append(SQLKeyword.COMMA);
            sbM778t.append(extraMsg);
        }
        String string = sbM778t.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void getSharedPreferences(String mainErrCode) {
        Context applicationContext = BaseUtils.getApplicationContext();
        switch (mainErrCode.hashCode()) {
            case -460935356:
                if (mainErrCode.equals("SYNC_ERROR")) {
                    preferences = applicationContext != null ? applicationContext.getSharedPreferences("SYNC_ERROR", 0) : null;
                    return;
                }
                break;
            case 1178575340:
                if (mainErrCode.equals("SERVER_ERROR")) {
                    preferences = applicationContext != null ? applicationContext.getSharedPreferences("SERVER_ERROR", 0) : null;
                    return;
                }
                break;
            case 1237317162:
                if (mainErrCode.equals("APP_ERROR")) {
                    preferences = applicationContext != null ? applicationContext.getSharedPreferences("APP_ERROR", 0) : null;
                    return;
                }
                break;
            case 1293467695:
                if (mainErrCode.equals("SPEN_ERROR")) {
                    preferences = applicationContext != null ? applicationContext.getSharedPreferences("SPEN_ERROR", 0) : null;
                    return;
                }
                break;
        }
        preferences = null;
    }

    private final void initializeLogger() {
        preferences = null;
    }

    private final boolean isAlreadyReported(Throwable e, String mainErrCode) {
        getSharedPreferences(mainErrCode);
        SharedPreferences sharedPreferences = preferences;
        if (sharedPreferences == null) {
            Logger.m8698e(TAG, "isAlreadyReported() : true <- No main error code!");
            return true;
        }
        Long lValueOf = sharedPreferences != null ? Long.valueOf(sharedPreferences.getLong(e.getMessage(), -1L)) : null;
        Intrinsics.checkNotNull(lValueOf);
        if (lValueOf.longValue() <= -1) {
            return false;
        }
        AbstractC4539a.m3206p("isAlreadyReported() : Skip this error = ", e.getMessage(), TAG);
        return true;
    }

    private final boolean isAlreadyReportedWhithinDay(Throwable e, String mainErrCode) {
        getSharedPreferences(mainErrCode);
        SharedPreferences sharedPreferences = preferences;
        if (sharedPreferences == null) {
            Logger.m8698e(TAG, "isAlreadyReportedWhithinDay() : true <- No main error code!");
            return true;
        }
        Long lValueOf = sharedPreferences != null ? Long.valueOf(sharedPreferences.getLong(e.getMessage(), -1L)) : null;
        long currentTime = TimeManager.INSTANCE.getCurrentTime();
        Intrinsics.checkNotNull(lValueOf);
        if (currentTime - lValueOf.longValue() > 86400000) {
            return false;
        }
        AbstractC4539a.m3206p("isAlreadyReportedWhithinDay() : Skip this error = ", e.getMessage(), TAG);
        return true;
    }

    private final boolean isLoggingState() {
        DeviceInfo.isEngMode();
        return true;
    }

    private final boolean isReadyToReport() {
        return isLoggingState() && createLogDirectoryToReport();
    }

    private final void postReport(Throwable e) {
        SharedPreferences sharedPreferences = preferences;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences != null ? sharedPreferences.edit() : null;
            if (editorEdit != null) {
                editorEdit.putLong(e.getMessage(), TimeManager.INSTANCE.getCurrentTime());
            }
            if (editorEdit != null) {
                editorEdit.apply();
            }
        }
    }

    private final void prepareFilesToReport(Throwable e, String extraMsg) {
        writeFile(createLogFileToReport(LOG_FILE_PATH), e, null);
        if (TextUtils.isEmpty(extraMsg)) {
            return;
        }
        writeFile(createLogFileToReport(EXTRA_FILE_PATH), e, extraMsg);
    }

    @JvmStatic
    public static final synchronized void report(@NotNull Throwable e, @NotNull String mainErrCode) {
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(mainErrCode, "mainErrCode");
        DiagMonLogger diagMonLogger = INSTANCE;
        diagMonLogger.initializeLogger();
        diagMonLogger.reportToDiagmon(e, mainErrCode, null);
    }

    private final void reportForError(Throwable e, String mainErrCode) {
        Context appContext = ApplicationManager.INSTANCE.getInstance().getAppContext();
        DiagMonSDK.customEventReport(appContext, new EventBuilder(appContext).setErrorCode(mainErrCode).setLogPath(LOG_DIR));
        postReport(e);
    }

    @JvmStatic
    public static final synchronized void reportOnce(@NotNull Throwable e, @NotNull String mainErrCode) {
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(mainErrCode, "mainErrCode");
        DiagMonLogger diagMonLogger = INSTANCE;
        if (diagMonLogger.isAlreadyReported(e, mainErrCode)) {
            return;
        }
        diagMonLogger.reportToDiagmon(e, mainErrCode, null);
    }

    @JvmStatic
    public static final synchronized void reportOnceDay(@NotNull Throwable e, @NotNull String mainErrCode) {
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(mainErrCode, "mainErrCode");
        DiagMonLogger diagMonLogger = INSTANCE;
        if (diagMonLogger.isAlreadyReportedWhithinDay(e, mainErrCode)) {
            return;
        }
        diagMonLogger.reportToDiagmon(e, mainErrCode, null);
    }

    private final void reportToDiagmon(Throwable e, String mainErrCode, String metaInfo) {
        if (isReadyToReport()) {
            prepareFilesToReport(e, metaInfo);
            reportForError(e, mainErrCode);
        }
    }

    private final boolean writeFile(File file, Throwable log, String extraLog) {
        if (file == null || !file.exists() || log == null) {
            Logger.m8698e(TAG, "writeFile() : Failed to log exception file!");
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            try {
                PrintStream printStream = new PrintStream((OutputStream) fileOutputStream, false, "UTF-8");
                try {
                    if (TextUtils.isEmpty(extraLog)) {
                        log.printStackTrace(printStream);
                    } else {
                        printStream.println(extraLog);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(printStream, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    return true;
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            AbstractC4539a.m3214x("writeFile() : ", e.getMessage(), TAG);
            return true;
        }
    }

    @JvmStatic
    public static final synchronized void report(@NotNull Throwable e, @NotNull String mainErrCode, @Nullable String extraMsg) {
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(mainErrCode, "mainErrCode");
        DiagMonLogger diagMonLogger = INSTANCE;
        diagMonLogger.initializeLogger();
        diagMonLogger.reportToDiagmon(e, mainErrCode, extraMsg);
    }

    @JvmStatic
    public static final synchronized void reportOnce(@NotNull Throwable e, @NotNull String mainErrCode, @Nullable String extraMsg) {
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(mainErrCode, "mainErrCode");
        DiagMonLogger diagMonLogger = INSTANCE;
        if (diagMonLogger.isAlreadyReported(e, mainErrCode)) {
            return;
        }
        diagMonLogger.reportToDiagmon(e, mainErrCode, extraMsg);
    }

    @JvmStatic
    public static final synchronized void reportOnceDay(@NotNull Throwable e, @NotNull String mainErrCode, @Nullable String extraMsg) {
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(mainErrCode, "mainErrCode");
        DiagMonLogger diagMonLogger = INSTANCE;
        if (diagMonLogger.isAlreadyReportedWhithinDay(e, mainErrCode)) {
            return;
        }
        diagMonLogger.reportToDiagmon(e, mainErrCode, extraMsg);
    }
}
