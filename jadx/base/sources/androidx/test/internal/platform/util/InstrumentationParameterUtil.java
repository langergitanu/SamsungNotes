package androidx.test.internal.platform.util;

import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class InstrumentationParameterUtil {
    public static long getTimeoutMillis(String str, long j) {
        Checks.checkArgument(j != 0, "default timeout value cannot be zero");
        long j2 = Long.parseLong(InstrumentationRegistry.getArguments().getString(str, "0"));
        if (j2 != 0) {
            j = j2;
        }
        return j < 0 ? TimeUnit.DAYS.toMillis(1L) : j;
    }
}
