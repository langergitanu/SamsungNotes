package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.internal.meet_coactivities.zzlq;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzko<API extends zzlq<API>> {
    private final zzmn zza;

    public zzko(zzmn zzmnVar) {
        this.zza = zzmnVar;
    }

    private static void zzi(String str, zzml zzmlVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date(TimeUnit.NANOSECONDS.toMillis(zzmlVar.zze()))));
        sb.append(": logging error [");
        zzmm.zza(1, zzmlVar.zzf(), sb);
        sb.append("]: ");
        sb.append(str);
        System.err.println(sb);
        System.err.flush();
    }

    public abstract zzlq zza(Level level);

    public final zzlq zzb() {
        return zza(Level.FINER);
    }

    public final zzlq zzc() {
        return zza(Level.INFO);
    }

    public final zzlq zzd() {
        return zza(Level.SEVERE);
    }

    public final zzlq zze() {
        return zza(Level.WARNING);
    }

    public final String zzf() {
        return this.zza.zza();
    }

    public final void zzg(zzml zzmlVar) {
        try {
            zzpk zzpkVarZzc = zzpk.zzc();
            try {
                if (zzpkVarZzc.zzb() <= 100) {
                    this.zza.zzc(zzmlVar);
                } else {
                    zzi("unbounded recursion in log statement", zzmlVar);
                }
                zzpkVarZzc.close();
            } finally {
            }
        } catch (RuntimeException e) {
            try {
                this.zza.zzb(e, zzmlVar);
            } catch (zzmo e2) {
                throw e2;
            } catch (RuntimeException e3) {
                zzi(AbstractC0541b.m757C(e3.getClass().getName(), ": ", e3.getMessage()), zzmlVar);
                try {
                    e3.printStackTrace(System.err);
                } catch (RuntimeException unused) {
                }
            }
        }
    }

    public final boolean zzh(Level level) {
        return this.zza.zzd(level);
    }
}
