package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.Context;
import android.os.Debug;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Logger {
    private static final int FILE_LOG_BUF_SIZE = 100;
    public static final int FILE_LOG_SCENARIO_OBJECT_ADDREMOVE = 4;
    public static final int FILE_LOG_SCENARIO_OBJECT_CHANGE = 2;
    public static final int FILE_LOG_SCENARIO_PAGE = 16;
    public static final int FILE_LOG_SCENARIO_UNDOREDO = 8;
    public static final float MB_UNIT = 1048576.0f;
    public static final int NONE = 0;
    public static final String START_TAG = "CPLog$StartTime";
    protected static final String TAG = "CPLog$";
    public static final String TIME_TAG = "[Performance]";
    private static final HashMap<String, Long> mTimeMap = new HashMap<>();
    private static final List<FileLogParam> mFileLogBuffer = new CopyOnWriteArrayList();
    private static long mFileLogScenario = 0;
    private static long mFileLogSkipScenario = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FileLogParam {
        String mMsg;

        public FileLogParam(String str) {
            this.mMsg = str;
        }
    }

    public static void addFileLog(String str, String str2, int i) {
        m11003i(str, str2);
        if (i != 0) {
            long j = mFileLogScenario;
            long j2 = i;
            if ((j & j2) != 0) {
                return;
            }
            long j3 = mFileLogSkipScenario;
            if ((j3 & j2) != 0) {
                mFileLogSkipScenario = ((long) (~i)) & j3;
                return;
            }
            mFileLogScenario = j | j2;
        } else if (mFileLogBuffer.size() > 100) {
            return;
        }
        mFileLogBuffer.add(new FileLogParam(str2));
    }

    public static void addSkipFileLog(int i) {
        mFileLogSkipScenario |= (long) i;
    }

    public static String createCoverTag(String str) {
        return AbstractC0541b.m772n("Cover$", str);
    }

    public static String createDynamicTemplateLog(String str) {
        return AbstractC0541b.m772n("CPLog$$DynamicTemplate$", str);
    }

    public static String createTag(String str) {
        return AbstractC0541b.m772n(TAG, str);
    }

    /* JADX INFO: renamed from: d */
    public static void m10999d(String str, String str2) {
        LoggerBase.m7125d(str, str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m11000e(String str, String str2) {
        LoggerBase.m7126e(str, str2);
    }

    public static void endTime(String str, String str2, String str3) {
        Long lRemove = mTimeMap.remove(str);
        if (lRemove == null) {
            return;
        }
        StringBuilder sbM15l = AbstractC0000a.m15l(TIME_TAG, str3, ": ");
        sbM15l.append(System.currentTimeMillis() - lRemove.longValue());
        sbM15l.append(" ms");
        m10999d(str2, sbM15l.toString());
    }

    /* JADX INFO: renamed from: f */
    public static void m11002f(String str, String str2) {
        LoggerBase.m7128f(str, str2);
    }

    public static String getEncode(String str) {
        return LoggerBase.getEncode(str);
    }

    public static String getHashForLog(Object obj) {
        return obj == null ? " object is null" : Integer.toHexString(obj.hashCode());
    }

    public static int getLength(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public static String getLogFilePath(Context context) {
        return LoggerBase.getLogFilePath(context);
    }

    public static int getNativeHeapAllocatedSize() {
        return (int) (Debug.getNativeHeapAllocatedSize() / 1048576.0f);
    }

    public static String getTimeString(long j) {
        return LoggerBase.getTimeString(j);
    }

    /* JADX INFO: renamed from: i */
    public static void m11003i(String str, String str2) {
        LoggerBase.m7130i(str, str2);
    }

    public static void midTime(String str, String str2, String str3) {
        Long l = mTimeMap.get(str);
        if (l == null) {
            return;
        }
        StringBuilder sbM15l = AbstractC0000a.m15l(TIME_TAG, str3, ": ");
        sbM15l.append(System.currentTimeMillis() - l.longValue());
        sbM15l.append(" ms");
        m10999d(str2, sbM15l.toString());
    }

    public static void mustAddFileLog(String str, String str2) {
        m11003i(str, str2);
        mFileLogBuffer.add(new FileLogParam(str2));
    }

    public static void printFileLog(String str) {
        List<FileLogParam> list = mFileLogBuffer;
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (FileLogParam fileLogParam : list) {
            sb.append("[");
            sb.append(fileLogParam.mMsg);
            sb.append(PropertyUtils.INDEXED_DELIM2);
        }
        m11002f(str, sb.toString());
        mFileLogBuffer.clear();
        mFileLogScenario = 0L;
    }

    public static void printMemory(String str, String str2) {
        LoggerBase.printMemory(str, str2);
    }

    public static void startTime(String str) {
        mTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: renamed from: w */
    public static void m11004w(String str, String str2) {
        LoggerBase.m7131w(str, str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m11001e(String str, String str2, Throwable th) {
        LoggerBase.m7127e(str, str2, th);
    }

    public static void startTime(String str, String str2, String str3) {
        startTime(str);
        m10999d(str2, TIME_TAG + str3);
    }

    public static String createTag(String str, String str2) {
        return TAG + str2 + '$' + str;
    }
}
