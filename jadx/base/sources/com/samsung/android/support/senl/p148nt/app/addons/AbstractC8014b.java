package com.samsung.android.support.senl.p148nt.app.addons;

import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.addons.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC8014b {
    /* JADX INFO: renamed from: A */
    public static void m7195A(StringBuilder sb, String str, int i) {
        sb.append(i);
        Logger.m11003i(str, sb.toString());
    }

    /* JADX INFO: renamed from: B */
    public static void m7196B(String str, String str2, String str3) {
        Logger.m10999d(str3, str + str2);
    }

    /* JADX INFO: renamed from: C */
    public static void m7197C(String str, String str2, String str3) {
        Logger.m11003i(str3, str + str2);
    }

    /* JADX INFO: renamed from: D */
    public static void m7198D(String str, String str2, String str3) {
        Logger.m11000e(str3, str + str2);
    }

    /* JADX INFO: renamed from: a */
    public static String m7199a(StringBuffer stringBuffer, String str, String str2) {
        stringBuffer.append(str);
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: b */
    public static void m7200b(int i, int i2, String str, String str2, String str3) {
        MainLogger.m7258i(str3, str + i + str2 + i2);
    }

    /* JADX INFO: renamed from: c */
    public static void m7201c(int i, String str, String str2) {
        MainLogger.m7258i(str2, str + i);
    }

    /* JADX INFO: renamed from: d */
    public static void m7202d(Resources resources, int i, StringBuilder sb, String str) {
        sb.append(resources.getString(i));
        sb.append(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: e */
    public static /* synthetic */ void m7203e(MediaMetadataRetriever mediaMetadataRetriever) throws Exception {
        boolean zIsTerminated;
        if (mediaMetadataRetriever instanceof AutoCloseable) {
            mediaMetadataRetriever.close();
            return;
        }
        if (!(mediaMetadataRetriever instanceof ExecutorService)) {
            mediaMetadataRetriever.release();
            return;
        }
        ExecutorService executorService = (ExecutorService) mediaMetadataRetriever;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m7204f(IOException iOException, StringBuilder sb, String str) {
        sb.append(iOException.getMessage());
        Logger.m11000e(str, sb.toString());
    }

    /* JADX INFO: renamed from: g */
    public static void m7205g(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        Logger.m11000e(str, sb.toString());
    }

    /* JADX INFO: renamed from: h */
    public static void m7206h(String str, int i, SOLogger sOLogger, String str2) {
        sOLogger.SOLoggerD(str2, str + i);
    }

    /* JADX INFO: renamed from: i */
    public static void m7207i(String str, Exception exc, String str2) {
        Logger.m11000e(str2, str + exc);
    }

    /* JADX INFO: renamed from: j */
    public static void m7208j(String str, String str2, SOLogger sOLogger, String str3) {
        sOLogger.SOLoggerD(str3, str + str2);
    }

    /* JADX INFO: renamed from: k */
    public static void m7209k(String str, String str2, String str3) {
        MainLogger.m7258i(str3, str + str2);
    }

    /* JADX INFO: renamed from: l */
    public static void m7210l(String str, String str2, boolean z) {
        MainLogger.m7254d(str2, str + z);
    }

    /* JADX INFO: renamed from: m */
    public static void m7211m(String str, boolean z, SOLogger sOLogger, String str2) {
        sOLogger.SOLoggerD(str2, str + z);
    }

    /* JADX INFO: renamed from: n */
    public static void m7212n(StringBuilder sb, String str, int i) {
        sb.append(i);
        MainLogger.m7258i(str, sb.toString());
    }

    /* JADX INFO: renamed from: o */
    public static void m7213o(StringBuilder sb, String str, String str2) {
        sb.append(str);
        Logger.m10999d(str2, sb.toString());
    }

    /* JADX INFO: renamed from: p */
    public static void m7214p(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        Logger.m11003i(str3, sb.toString());
    }

    /* JADX INFO: renamed from: q */
    public static void m7215q(StringBuilder sb, boolean z, String str) {
        sb.append(z);
        Logger.m10999d(str, sb.toString());
    }

    /* JADX INFO: renamed from: r */
    public static void m7216r(int i, int i2, String str, String str2, String str3) {
        Logger.m10999d(str3, str + i + str2 + i2);
    }

    /* JADX INFO: renamed from: s */
    public static void m7217s(int i, String str, String str2) {
        Logger.m11003i(str2, str + i);
    }

    /* JADX INFO: renamed from: t */
    public static void m7218t(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        CoeditLogger.m8920e(str, sb.toString());
    }

    /* JADX INFO: renamed from: u */
    public static void m7219u(String str, String str2, String str3) {
        CoeditLogger.m8919d(str3, str + str2);
    }

    /* JADX INFO: renamed from: v */
    public static void m7220v(String str, String str2, boolean z) {
        Logger.m10999d(str2, str + z);
    }

    /* JADX INFO: renamed from: w */
    public static void m7221w(StringBuilder sb, String str, int i) {
        sb.append(i);
        Logger.m10999d(str, sb.toString());
    }

    /* JADX INFO: renamed from: x */
    public static void m7222x(StringBuilder sb, boolean z, String str) {
        sb.append(z);
        Logger.m11003i(str, sb.toString());
    }

    /* JADX INFO: renamed from: y */
    public static void m7223y(String str, String str2, String str3) {
        CoeditLogger.m8923i(str3, str + str2);
    }

    /* JADX INFO: renamed from: z */
    public static void m7224z(String str, String str2, boolean z) {
        Logger.m11003i(str2, str + z);
    }
}
