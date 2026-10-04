package com.samsung.android.smartswitchfileshare;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import java.text.DecimalFormat;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CommonUtil {
    public static String getByteToCeilGiBString(long j) {
        if (j <= 0) {
            return new DecimalFormat("0").format(0L) + " MB";
        }
        if (j >= 1073741824) {
            return new DecimalFormat("0.00").format(getByteToCeilMiB(j) / 1024.0d) + " GB";
        }
        return new DecimalFormat("0").format(getByteToCeilMiB(j)) + " MB";
    }

    public static long getByteToCeilMiB(long j) {
        return j <= 0 ? j : (long) Math.ceil(j / 1048576.0d);
    }

    public static long getElapse(long j) {
        if (j > 0) {
            return SystemClock.elapsedRealtime() - j;
        }
        return 0L;
    }

    public static String getElapseSz(long j) {
        return String.format(Locale.ENGLISH, "elapse:%8d", Long.valueOf(getElapse(j)));
    }

    public static String makeFormattedTag(String str) {
        return TextUtils.isEmpty(str) ? Constants.PREFIX : AbstractC0541b.m772n(Constants.PREFIX, str);
    }

    public static void printLog(boolean z, String str, String str2) {
        if (z) {
            Log.v(str, str2);
        } else {
            Log.i(str, str2);
        }
    }
}
