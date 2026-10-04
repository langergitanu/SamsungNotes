package com.sec.android.diagmonagent.log.provider;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.sec.android.diagmonagent.common.logger.AppLog;
import com.sec.android.diagmonagent.common.util.CommonUtils;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DiagMonLogger implements Thread.UncaughtExceptionHandler {
    private static final String DMA_PKG_NAME = "com.sec.android.diagmonagent";
    private static final int DMA_SUPPORT_VERSION = 600000000;
    private static final int LEGACY_DMA = 1;
    private static final String LOG_CRASH_FILE_NAME = "diagmon.log";
    private static final String LOG_EVENT_FILE_NAME = "diagmon_event.log";
    private static final String LOG_MEMORY_FILE_NAME = "diagmon_memory.log";
    private static final String LOG_STORAGE_FILE_NAME = "diagmon_storage.log";
    private static final String LOG_THREAD_STACK_FILE_NAME = "diagmon_thread.log";
    private static final int NEW_DMA = 2;
    private static final int NO_DMA = 0;
    private static final String TAG = "DiagMonLogger";
    private final String DIRECTORY;
    private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
    private DiagMonConfig diagmonConfig;
    private EventBuilder eventBuilder;
    private Context mContext;
    private final String[] logcatCmd = {"logcat -b events -v threadtime -v printable -v uid -d *:v", "cat /proc/meminfo", "df"};
    private boolean mIsAppend = false;

    public DiagMonLogger(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, DiagMonConfig diagMonConfig) {
        this.mContext = context;
        this.defaultUncaughtExceptionHandler = uncaughtExceptionHandler;
        this.diagmonConfig = diagMonConfig;
        this.DIRECTORY = AbstractC0622a.m1170p(context.getApplicationInfo().dataDir, "/exception/", new StringBuilder());
        createEventBuilder();
    }

    private void createEventBuilder() {
        AppLog.m13140d("Diagmon Logger Init");
        AppLog.m13140d("CRASH_LOG_PATH : " + this.DIRECTORY + LOG_CRASH_FILE_NAME);
        AppLog.m13140d("EVENT_LOG_PATH : " + this.DIRECTORY + LOG_EVENT_FILE_NAME);
        AppLog.m13140d("THREAD_STACK_LOG_PATH : " + this.DIRECTORY + LOG_THREAD_STACK_FILE_NAME);
        AppLog.m13140d("MEMORY_LOG_PATH : " + this.DIRECTORY + LOG_MEMORY_FILE_NAME);
        AppLog.m13140d("STORAGE_LOG_PATH : " + this.DIRECTORY + LOG_STORAGE_FILE_NAME);
        int diagmonType = getDiagmonType();
        if (diagmonType == 1) {
            this.eventBuilder = new EventBuilder(this.mContext).setErrorCode("fatal exception");
        } else {
            if (diagmonType != 2) {
                return;
            }
            this.eventBuilder = new EventBuilder(this.mContext).setLogPath(this.DIRECTORY).setErrorCode("fatal exception");
        }
    }

    private void eventReport() {
        DiagMonSDK.sendUncaughtExceptionEvent(this.eventBuilder);
        AppLog.m13140d("[Falcon_DiagMonSDK][3][" + TAG + "]");
    }

    private int getDiagmonType() {
        try {
            return this.mContext.getPackageManager().getPackageInfo("com.sec.android.diagmonagent", 0).versionCode < DMA_SUPPORT_VERSION ? 1 : 2;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    private String getLogByThreads() {
        StringBuilder sb = new StringBuilder();
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            if (stackTrace.length < 1) {
                AppLog.m13140d("no StackTraceElement");
            } else {
                sb.append("Thread ID : ");
                sb.append(thread.getId());
                sb.append(", Thread's name : ");
                sb.append(thread.getName());
                sb.append("\n");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append("\t at ");
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
                sb.append("\n");
            }
        }
        String string = sb.toString();
        return TextUtils.isEmpty(string) ? "No data" : string;
    }

    private String getLogFromBuffer(Context context, String str) {
        PackageInfo servicePkgInfo = CommonUtils.getServicePkgInfo(context);
        if (servicePkgInfo == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(AbstractC0622a.m1170p(servicePkgInfo.versionName, "\nDiagMonSA SDK version : 6.05.079\n=========================================\n", new StringBuilder("=========================================\nService version   : ")));
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException unused) {
            AppLog.m13141e("IOException occurred during getCrashLog");
        }
        return sb.toString();
    }

    private File makeDir(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private File makeFile(String str, String str2) {
        if (!makeDir(str).isDirectory()) {
            return null;
        }
        File file = new File(AbstractC0541b.m757C(str, "/", str2));
        try {
            file.createNewFile();
        } catch (IOException e) {
            Debug.LogENG(e.getLocalizedMessage());
        }
        return file;
    }

    private void makeLogFile(File file, Throwable th, String str) {
        if (file == null || !file.exists() || th == null) {
            AppLog.m13140d("Failed to write log into file");
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, this.mIsAppend);
            try {
                PrintStream printStream = new PrintStream((OutputStream) fileOutputStream, true, "UTF-8");
                try {
                    this.mIsAppend = true;
                    if (TextUtils.isEmpty(str)) {
                        th.printStackTrace(printStream);
                    } else {
                        printStream.println(str);
                    }
                    printStream.close();
                    fileOutputStream.close();
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IOException e) {
            AppLog.m13141e("IOException occurred during writeLogFile");
            AppLog.m13141e(e.getMessage());
        } catch (OutOfMemoryError e2) {
            AppLog.m13141e("OutOfMemoryError Exception occurred during writeLogFile");
            AppLog.m13141e(e2.getMessage());
        }
    }

    private void removeLogs() {
        File file = new File(this.DIRECTORY);
        if (!file.exists()) {
            AppLog.m13140d("The directory doesn't exist.");
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    removeLogs();
                } else {
                    file2.delete();
                }
            }
        }
    }

    private void showEnrichedData() {
        File file = new File(this.DIRECTORY);
        File[] fileArrListFiles = file.listFiles();
        if (!file.exists()) {
            AppLog.m13140d("The directory doesn't exist.");
            return;
        }
        for (File file2 : fileArrListFiles) {
            AppLog.m13140d("[Falcon_DiagMonSDK][2][" + TAG + "]" + file2.getName());
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String str = DiagMonUtil.TAG;
        Log.d(str, "Agreement for ueHandler : " + this.diagmonConfig.getAgree());
        Log.d(str, "Agreement for ueHandler : " + this.diagmonConfig.getAgreeAsString());
        StringBuilder sb = new StringBuilder("[Falcon_DiagMonSDK][0][");
        String str2 = TAG;
        sb.append(str2);
        sb.append("]");
        AppLog.m13140d(sb.toString());
        try {
            try {
                if (this.diagmonConfig.getAgree() && !DiagMonUtil.insufficientStorage()) {
                    AppLog.m13140d("[Falcon_DiagMonSDK][1][" + str2 + "]");
                    AppLog.initLogger(this.diagmonConfig.getContext(), this.diagmonConfig.getServiceId());
                    removeLogs();
                    makeLogFile(makeFile(this.DIRECTORY, LOG_CRASH_FILE_NAME), th, null);
                    makeLogFile(makeFile(this.DIRECTORY, LOG_EVENT_FILE_NAME), th, getLogFromBuffer(this.mContext, this.logcatCmd[0]));
                    makeLogFile(makeFile(this.DIRECTORY, LOG_THREAD_STACK_FILE_NAME), th, getLogByThreads());
                    makeLogFile(makeFile(this.DIRECTORY, LOG_MEMORY_FILE_NAME), th, getLogFromBuffer(this.mContext, this.logcatCmd[1]));
                    makeLogFile(makeFile(this.DIRECTORY, LOG_STORAGE_FILE_NAME), th, getLogFromBuffer(this.mContext, this.logcatCmd[2]));
                    if (DiagMonUtil.checkDMA(this.mContext) == 1) {
                        this.eventBuilder.setLogPath(this.DIRECTORY);
                    }
                    showEnrichedData();
                    eventReport();
                    synchronized (this) {
                        try {
                            wait(AiSTTListView.USER_SCROLL_INTERVAL);
                        } catch (Exception unused) {
                        }
                    }
                }
            } catch (OutOfMemoryError e) {
                AppLog.m13141e(e.getMessage());
            }
        } finally {
            this.defaultUncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
