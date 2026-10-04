package com.google.android.gms.internal.gcm;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes5.dex */
public final class zzq {
    private static final zzr zzdq;
    private static final int zzdr;

    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0006, B:6:0x000e, B:9:0x0016, B:11:0x001e, B:12:0x0024), top: B:24:0x0006 }] */
    static {
        Integer numZzac;
        zzr zzdVar;
        try {
            numZzac = zzac();
            if (numZzac != null) {
                try {
                    zzdVar = numZzac.intValue() >= 19 ? new zzv() : !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new zzu() : new zzd();
                } catch (Throwable th) {
                    th = th;
                    PrintStream printStream = System.err;
                    String name = zzd.class.getName();
                    StringBuilder sb = new StringBuilder(name.length() + 133);
                    sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                    sb.append(name);
                    sb.append("will be used. The error is: ");
                    printStream.println(sb.toString());
                    th.printStackTrace(System.err);
                    zzdVar = new zzd();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            numZzac = null;
        }
        zzdq = zzdVar;
        zzdr = numZzac == null ? 1 : numZzac.intValue();
    }

    private static Integer zzac() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    public static void zzd(Throwable th, Throwable th2) {
        zzdq.zzd(th, th2);
    }

    public static final class zzd extends zzr {
        @Override // com.google.android.gms.internal.gcm.zzr
        public final void zzd(Throwable th, Throwable th2) {
        }
    }
}
