package org.apache.commons.collections;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FunctorException extends RuntimeException {
    private static final boolean JDK_SUPPORTS_NESTED;
    static /* synthetic */ Class class$java$lang$Throwable;
    private final Throwable rootCause;

    static {
        boolean z;
        try {
            Class clsClass$ = class$java$lang$Throwable;
            if (clsClass$ == null) {
                clsClass$ = class$("java.lang.Throwable");
                class$java$lang$Throwable = clsClass$;
            }
            clsClass$.getDeclaredMethod("getCause", null);
            z = true;
        } catch (NoSuchMethodException unused) {
            z = false;
        }
        JDK_SUPPORTS_NESTED = z;
    }

    public FunctorException() {
        this.rootCause = null;
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.rootCause;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            PrintWriter printWriter = new PrintWriter((OutputStream) printStream, false);
            printStackTrace(printWriter);
            printWriter.flush();
        }
    }

    public FunctorException(String str) {
        super(str);
        this.rootCause = null;
    }

    public FunctorException(Throwable th) {
        super(th == null ? null : th.getMessage());
        this.rootCause = th;
    }

    public FunctorException(String str, Throwable th) {
        super(str);
        this.rootCause = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        synchronized (printWriter) {
            try {
                super.printStackTrace(printWriter);
                if (this.rootCause != null && !JDK_SUPPORTS_NESTED) {
                    printWriter.print("Caused by: ");
                    this.rootCause.printStackTrace(printWriter);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
