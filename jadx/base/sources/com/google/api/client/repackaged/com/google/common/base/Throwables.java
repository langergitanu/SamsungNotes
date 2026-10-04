package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Throwables {
    private Throwables() {
    }

    @Beta
    public static List<Throwable> getCausalChain(Throwable th) {
        Preconditions.checkNotNull(th);
        ArrayList arrayList = new ArrayList(4);
        while (th != null) {
            arrayList.add(th);
            th = th.getCause();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Throwable getRootCause(Throwable th) {
        while (true) {
            Throwable cause = th.getCause();
            if (cause == null) {
                return th;
            }
            th = cause;
        }
    }

    public static String getStackTraceAsString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X */
    public static RuntimeException propagate(Throwable th) throws X {
        propagateIfPossible((Throwable) Preconditions.checkNotNull(th));
        throw new RuntimeException(th);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    public static <X extends Throwable> void propagateIfInstanceOf(@Nullable Throwable th, Class<X> cls) throws X {
        if (th != null && cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X */
    public static void propagateIfPossible(@Nullable Throwable th) throws X {
        propagateIfInstanceOf(th, Error.class);
        propagateIfInstanceOf(th, RuntimeException.class);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X */
    public static <X extends Throwable> void propagateIfPossible(@Nullable Throwable th, Class<X> cls) throws X {
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X */
    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@Nullable Throwable th, Class<X1> cls, Class<X2> cls2) throws X {
        Preconditions.checkNotNull(cls2);
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th, cls2);
    }
}
