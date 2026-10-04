package com.samsung.android.sdk.smp.common.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpLog {
    private static final int DEBUG = 4;
    private static final int ERROR = 1;
    private static final int HELP = 6;
    private static final int INFO = 3;
    private static final String LOG_FILE_PATH = "/ppmt";
    private static final long MAX_SIZE_LOG_FILE = 5242880;
    private static final String TAG = "SmpLog";
    private static final int VERBOSE = 5;
    private static final int WARN = 2;
    private static boolean mFileLogEnabled;
    private static boolean mIsTestMode;
    private static boolean mLogEnabled;
    private static String sFilesDir;
    private static File sLogFile;
    private static FileOutputStream sLogFileOutputStream;
    private static int sLogNameCnt;
    private static String sPkgname;

    /* JADX INFO: renamed from: d */
    public static void m6493d(String str, String str2, String str3) {
        m6492d(str, "[" + str2 + "] " + str3);
    }

    /* JADX INFO: renamed from: e */
    public static void m6495e(String str, String str2, String str3) {
        m6494e(str, "[" + str2 + "] " + str3);
    }

    public static void enableLog(boolean z) {
        mLogEnabled = mIsTestMode || z;
    }

    private static void flog(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(DateFormat.format("MM/dd/yy HH:mm:ss", System.currentTimeMillis()));
        char c = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 6 ? 'V' : 'H' : 'D' : 'I' : 'W' : 'E';
        sb.append(' ');
        sb.append(c);
        sb.append(' ');
        sb.append(Process.myPid());
        sb.append(' ');
        sb.append(Process.myTid());
        AbstractC2821a.m2207B(sb, " [", str, "] ", str2);
        sb.append('\n');
        writeLogToFile(sb.toString().getBytes(StandardCharsets.UTF_8));
    }

    private static String getLogFileName() {
        if (TextUtils.isEmpty(sPkgname)) {
            return "Smplog" + (sLogNameCnt % 2) + Constants.TEXT_EXTENSION_WITH_DOT;
        }
        return "Smplog_" + sPkgname + "_" + (sLogNameCnt % 2) + Constants.TEXT_EXTENSION_WITH_DOT;
    }

    private static String getLogFilePath(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath() + LOG_FILE_PATH;
    }

    /* JADX INFO: renamed from: he */
    public static void m6496he(String str, String str2) {
        AbstractC2322a.m1636z("[SMP] ", str2, TAG);
        if (mFileLogEnabled) {
            flog(6, str, str2);
        }
    }

    /* JADX INFO: renamed from: hi */
    public static void m6497hi(String str, String str2) {
        AbstractC6670b.m4756q("[SMP] ", str2, TAG);
        if (mFileLogEnabled) {
            flog(6, str, str2);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m6499i(String str, String str2, String str3) {
        m6498i(str, "[" + str2 + "] " + str3);
    }

    public static boolean isFileLogNotWritable(Context context) {
        try {
            String logFilePath = getLogFilePath(context);
            if (TextUtils.isEmpty(logFilePath)) {
                return true;
            }
            File file = new File(logFilePath);
            return !file.exists() ? (file.mkdir() && file.canWrite()) ? false : true : !file.canWrite();
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean isSmpTestApp() {
        return !TextUtils.isEmpty(sPkgname) && sPkgname.startsWith("com.samsung.android.test.smp");
    }

    private static void log(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder("[");
        sb.append(str);
        sb.append("] ");
        sb.append(str2);
        if (i == 1) {
            Log.e(TAG, sb.toString());
            return;
        }
        if (i == 2) {
            Log.w(TAG, sb.toString());
            return;
        }
        if (i == 3) {
            Log.i(TAG, sb.toString());
        } else if (i == 4) {
            Log.d(TAG, sb.toString());
        } else {
            if (i != 5) {
                return;
            }
            Log.v(TAG, sb.toString());
        }
    }

    private static boolean makeLogFile() {
        try {
            FileOutputStream fileOutputStream = sLogFileOutputStream;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                sLogFileOutputStream = null;
            }
            File file = new File(sFilesDir);
            if (!file.exists() && !file.mkdir()) {
                return false;
            }
            String str = sFilesDir + File.separator + getLogFileName();
            sLogFile = new File(str);
            sLogFileOutputStream = new FileOutputStream(sLogFile, true);
            m6492d(TAG, "Smp log file is created at " + str);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void remakeLogFile() {
        boolean z = sLogFile.length() > MAX_SIZE_LOG_FILE;
        if (z) {
            sLogNameCnt++;
        }
        File file = new File(sFilesDir + File.separator + getLogFileName());
        try {
            sLogFileOutputStream = new FileOutputStream(file, !z);
            sLogFile = file;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setSmpLogSetting(Context context, boolean z, boolean z2) {
        if (context == null) {
            m6496he(TAG, "Fail to set log. context null");
            return;
        }
        sPkgname = context.getPackageName();
        mIsTestMode = z;
        mLogEnabled = z | mLogEnabled;
        mFileLogEnabled = z2;
        if (z2) {
            sFilesDir = getLogFilePath(context);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m6500v(String str, String str2) {
        if (mLogEnabled && isSmpTestApp()) {
            log(5, str, str2);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m6502w(String str, String str2, String str3) {
        m6501w(str, "[" + str2 + "] " + str3);
    }

    private static void writeLogToFile(byte[] bArr) {
        if (TextUtils.isEmpty(sFilesDir)) {
            return;
        }
        File file = sLogFile;
        if ((file == null || !file.exists()) && !makeLogFile()) {
            return;
        }
        try {
            sLogFileOutputStream.write(bArr);
            sLogFileOutputStream.flush();
            if (sLogFile.length() > MAX_SIZE_LOG_FILE) {
                sLogFileOutputStream.close();
                sLogFileOutputStream = null;
                remakeLogFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                sLogFileOutputStream.close();
                sLogFile = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m6492d(String str, String str2) {
        if (mLogEnabled) {
            log(4, str, str2);
        }
        if (mFileLogEnabled) {
            flog(4, str, str2);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m6494e(String str, String str2) {
        if (mLogEnabled) {
            log(1, str, str2);
        }
        if (mFileLogEnabled) {
            flog(1, str, str2);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m6498i(String str, String str2) {
        if (mLogEnabled) {
            log(3, str, str2);
        }
        if (mFileLogEnabled) {
            flog(3, str, str2);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m6501w(String str, String str2) {
        if (mLogEnabled) {
            log(2, str, str2);
        }
        if (mFileLogEnabled) {
            flog(2, str, str2);
        }
    }
}
