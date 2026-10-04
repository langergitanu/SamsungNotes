package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.base.Preconditions;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaek {
    static final Logger zza = Logger.getLogger(zzwg.class.getName());
    private final Object zzb = new Object();
    private final zzyi zzc;

    public zzaek(zzyi zzyiVar, int i, long j, String str) {
        Preconditions.checkNotNull(str, "description");
        this.zzc = (zzyi) Preconditions.checkNotNull(zzyiVar, "logId");
        zzxv zzxvVar = new zzxv();
        zzxvVar.zza(str.concat(" created"));
        zzxvVar.zzb(zzxw.CT_INFO);
        zzxvVar.zzd(j);
        zzc(zzxvVar.zze());
    }

    public static void zzb(zzyi zzyiVar, Level level, String str) {
        Logger logger = zza;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, AbstractC0541b.m774p("[", String.valueOf(zzyiVar), "] ", str));
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public final zzyi zza() {
        return this.zzc;
    }

    public final void zzc(zzxy zzxyVar) {
        int iOrdinal = zzxyVar.zzb.ordinal();
        Level level = iOrdinal != 2 ? iOrdinal != 3 ? Level.FINEST : Level.FINE : Level.FINER;
        synchronized (this.zzb) {
        }
        zzb(this.zzc, level, zzxyVar.zza);
    }

    public final boolean zzd() {
        synchronized (this.zzb) {
        }
        return false;
    }
}
