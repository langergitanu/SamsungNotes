package cz.msebera.android.httpclient.client.utils;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CloneUtils {
    private CloneUtils() {
    }

    public static Object clone(Object obj) {
        return cloneObject(obj);
    }

    public static <T> T cloneObject(T t) throws CloneNotSupportedException {
        if (t == null) {
            return null;
        }
        if (!(t instanceof Cloneable)) {
            throw new CloneNotSupportedException();
        }
        try {
            try {
                return (T) t.getClass().getMethod("clone", null).invoke(t, null);
            } catch (IllegalAccessException e) {
                throw new IllegalAccessError(e.getMessage());
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (cause instanceof CloneNotSupportedException) {
                    throw ((CloneNotSupportedException) cause);
                }
                throw new Error("Unexpected exception", cause);
            }
        } catch (NoSuchMethodException e3) {
            throw new NoSuchMethodError(e3.getMessage());
        }
    }
}
