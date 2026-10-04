package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
public class JdkIdn implements Idn {
    private final Method toUnicode;

    public JdkIdn() {
        try {
            this.toUnicode = Class.forName("java.net.IDN").getMethod("toUnicode", String.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e.getMessage(), e);
        } catch (SecurityException e2) {
            throw new IllegalStateException(e2.getMessage(), e2);
        }
    }

    @Override // cz.msebera.android.httpclient.client.utils.Idn
    public String toUnicode(String str) {
        try {
            return (String) this.toUnicode.invoke(null, str);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e.getMessage(), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }
}
