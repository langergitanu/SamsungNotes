package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.annotations.VisibleForTesting;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@VisibleForTesting
final class zzakv extends WeakReference {
    private static final boolean zza = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));
    private static final RuntimeException zzb;
    private final ReferenceQueue zzc;
    private final ConcurrentMap zzd;
    private final String zze;
    private final Reference zzf;
    private final AtomicBoolean zzg;

    static {
        RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
        runtimeException.setStackTrace(new StackTraceElement[0]);
        zzb = runtimeException;
    }

    public zzakv(zzakw zzakwVar, zzzi zzziVar, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
        super(zzakwVar, referenceQueue);
        this.zzg = new AtomicBoolean();
        this.zzf = new SoftReference(zza ? new RuntimeException("ManagedChannel allocation site") : zzb);
        this.zze = zzziVar.toString();
        this.zzc = referenceQueue;
        this.zzd = concurrentMap;
        concurrentMap.put(this, this);
        zza(referenceQueue);
    }

    @VisibleForTesting
    public static int zza(ReferenceQueue referenceQueue) {
        int i = 0;
        while (true) {
            zzakv zzakvVar = (zzakv) referenceQueue.poll();
            if (zzakvVar == null) {
                return i;
            }
            RuntimeException runtimeException = (RuntimeException) zzakvVar.zzf.get();
            zzakvVar.zzb();
            if (!zzakvVar.zzg.get()) {
                i++;
                Level level = Level.SEVERE;
                if (zzakw.zzc.isLoggable(level)) {
                    LogRecord logRecord = new LogRecord(level, AbstractC0541b.m773o("*~*~*~ Previous channel {0} was garbage collected without being shut down! ~*~*~*", System.getProperty(SystemProperties.LINE_SEPARATOR), "    Make sure to call shutdown()/shutdownNow()"));
                    logRecord.setLoggerName(zzakw.zzc.getName());
                    logRecord.setParameters(new Object[]{zzakvVar.zze});
                    logRecord.setThrown(runtimeException);
                    zzakw.zzc.log(logRecord);
                }
            }
        }
    }

    private final void zzb() {
        super.clear();
        this.zzd.remove(this);
        this.zzf.clear();
    }

    @Override // java.lang.ref.Reference
    public final void clear() {
        zzb();
        zza(this.zzc);
    }
}
