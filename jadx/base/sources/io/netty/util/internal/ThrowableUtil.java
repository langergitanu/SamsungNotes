package io.netty.util.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ThrowableUtil {
    private ThrowableUtil() {
    }

    @SuppressJava6Requirement(reason = "Throwable addSuppressed is only available for >= 7. Has check for < 7.")
    public static void addSuppressed(Throwable th, Throwable th2) {
        if (haveSuppressed()) {
            th.addSuppressed(th2);
        }
    }

    public static void addSuppressedAndClear(Throwable th, List<Throwable> list) {
        addSuppressed(th, list);
        list.clear();
    }

    @SuppressJava6Requirement(reason = "Throwable getSuppressed is only available for >= 7. Has check for < 7.")
    public static Throwable[] getSuppressed(Throwable th) {
        return !haveSuppressed() ? EmptyArrays.EMPTY_THROWABLES : th.getSuppressed();
    }

    public static boolean haveSuppressed() {
        return PlatformDependent.javaVersion() >= 7;
    }

    public static String stackTraceToString(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        try {
            return new String(byteArrayOutputStream.toByteArray());
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static <T extends Throwable> T unknownStackTrace(T t, Class<?> cls, String str) {
        t.setStackTrace(new StackTraceElement[]{new StackTraceElement(cls.getName(), str, null, -1)});
        return t;
    }

    public static void addSuppressed(Throwable th, List<Throwable> list) {
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            addSuppressed(th, it.next());
        }
    }
}
