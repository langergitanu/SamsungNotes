package com.google.android.play.core.internal;

import java.io.PrintStream;

/* JADX INFO: renamed from: com.google.android.play.core.internal.ci */
/* JADX INFO: loaded from: classes5.dex */
public final class C5214ci {

    /* JADX INFO: renamed from: a */
    static final AbstractC5208cc f2981a;

    static {
        AbstractC5208cc c5212cg;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e.printStackTrace(System.err);
            }
            c5212cg = (num == null || num.intValue() < 19) ? !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new C5211cf() : new C5212cg() : new C5213ch();
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = C5212cg.class.getName();
            StringBuilder sb = new StringBuilder(name.length() + 133);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            c5212cg = new C5212cg();
        }
        f2981a = c5212cg;
    }

    /* JADX INFO: renamed from: a */
    public static void m3978a(Throwable th, Throwable th2) {
        f2981a.mo3976a(th, th2);
    }
}
