package com.samsung.android.support.senl.p148nt.app.common.log;

import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MainLogger {
    private static final String TAG = "NotesMain$";

    public static void activityResultLog(String str, int i, int i2) {
        int[] iArr = NotesConstants.REQUEST_CODE_IDS;
        if (iArr.length != NotesConstants.REQUEST_CODE_NAMES.length) {
            AbstractC8014b.m7200b(i, i2, "activityResultLog logging fail# , requestCode : ", ", resultCode : ", str);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("activityResultLog # ");
        if (i == -1) {
            stringBuffer.append("REQUEST_CODE_NONE");
        } else {
            int i4 = 0;
            for (int i5 : iArr) {
                if ((i & i5) == i5) {
                    stringBuffer.append(SQLKeyword.COMMA);
                    stringBuffer.append(NotesConstants.REQUEST_CODE_NAMES[i4]);
                    i -= i5;
                }
                i4++;
            }
        }
        m7258i(str, stringBuffer.toString() + ", resultCode : " + i2);
    }

    /* JADX INFO: renamed from: d */
    public static void m7254d(String str, String str2) {
        LoggerBase.m7125d(TAG.concat(str), str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m7255e(String str, String str2) {
        LoggerBase.m7126e(TAG.concat(str), str2);
    }

    /* JADX INFO: renamed from: f */
    public static void m7257f(String str, String str2) {
        LoggerBase.m7128f(TAG.concat(str), str2);
    }

    public static String getEncode(String str) {
        return LoggerBase.getEncode(str);
    }

    /* JADX INFO: renamed from: i */
    public static void m7258i(String str, String str2) {
        LoggerBase.m7130i(TAG.concat(str), str2);
    }

    /* JADX INFO: renamed from: w */
    public static void m7259w(String str, String str2) {
        LoggerBase.m7131w(TAG.concat(str), str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m7256e(String str, String str2, Throwable th) {
        LoggerBase.m7127e(TAG.concat(str), str2, th);
    }
}
