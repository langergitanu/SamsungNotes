package androidx.test.internal.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.test.internal.util.ProcSummary;
import com.samsung.android.support.senl.p145cm.base.common.constants.AppUpdateConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class LogUtil {
    private static volatile String myProcName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Supplier {
        String get();
    }

    private static boolean isLoggable(String str, int i) {
        if (str.length() > 23) {
            str = str.substring(0, 22);
        }
        return Log.isLoggable(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$logDebugWithProcess$1(String str) {
        StringBuilder sbM781w = AbstractC0541b.m781w(str, " in ");
        sbM781w.append(procName());
        return sbM781w.toString();
    }

    public static void logDebug(String str, String str2, Object... objArr) {
        logDebug(str, new C3926b(str2, 1), objArr);
    }

    public static void logDebugWithProcess(String str, String str2, Object... objArr) {
        logDebug(str, new C3926b(str2, 0), objArr);
    }

    private static final String procName() {
        String str;
        String str2 = myProcName;
        if (str2 != null) {
            return str2;
        }
        try {
            str = ProcSummary.summarize(AppUpdateConstants.UPDATE_TYPE.SELF).cmdline;
        } catch (ProcSummary.SummaryException unused) {
            str = "unknown";
        }
        return (str.length() <= 64 || !str.contains("-classpath")) ? str : "robolectric";
    }

    private static void logDebug(String str, Supplier supplier, Object... objArr) {
        if (isLoggable(str, 3)) {
            Object[] objArr2 = new Object[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                if (obj instanceof Supplier) {
                    objArr2[i] = ((Supplier) obj).get();
                } else {
                    objArr2[i] = obj;
                }
            }
            Log.d(str, String.format(supplier.get(), objArr2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$logDebug$0(String str) {
        return str;
    }

    public static Supplier lazyArg(Supplier supplier) {
        return supplier;
    }
}
