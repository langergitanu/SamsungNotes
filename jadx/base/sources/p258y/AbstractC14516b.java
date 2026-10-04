package p258y;

import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: renamed from: y.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC14516b {
    /* JADX INFO: renamed from: a */
    public static String m15113a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: b */
    public static void m15114b(int i, int i2, String str, String str2, String str3) {
        Logger.m11003i(str3, str + i + str2 + i2);
    }

    /* JADX INFO: renamed from: c */
    public static void m15115c(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        MainLogger.m7255e(str, sb.toString());
    }
}
