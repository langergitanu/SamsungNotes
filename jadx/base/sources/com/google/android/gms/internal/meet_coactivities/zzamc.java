package com.google.android.gms.internal.meet_coactivities;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamc implements zzaiw {
    private static final Logger zza = Logger.getLogger(zzamc.class.getName());
    private static final Constructor zzb;
    private static final Method zzc;
    private static final RuntimeException zzd;
    private static final Object[] zze;
    private final Object zzf;

    static {
        Throwable th;
        Method method;
        Method method2;
        Constructor<?> constructor;
        Class<?> cls;
        try {
            cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            method2 = cls.getMethod("add", Long.TYPE);
        } catch (Throwable th2) {
            th = th2;
            method = null;
        }
        try {
            cls.getMethod(VElementFormulasCmd.FSUM, null);
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    constructor = null;
                    break;
                }
                constructor = constructors[i];
                if (constructor.getParameterTypes().length == 0) {
                    break;
                } else {
                    i++;
                }
            }
            th = null;
        } catch (Throwable th3) {
            th = th3;
            method = method2;
            zza.logp(Level.FINE, "io.grpc.internal.ReflectionLongAdderCounter", "<clinit>", "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
            method2 = method;
            constructor = null;
        }
        if (th != null || constructor == null) {
            zzb = null;
            zzc = null;
            zzd = new RuntimeException(th);
        } else {
            zzb = constructor;
            zzc = method2;
            zzd = null;
        }
        zze = new Object[]{1L};
    }

    public zzamc() {
        RuntimeException runtimeException = zzd;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.zzf = zzb.newInstance(null);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static boolean zzb() {
        return zzd == null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaiw
    public final void zza(long j) {
        try {
            zzc.invoke(this.zzf, zze);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }
}
