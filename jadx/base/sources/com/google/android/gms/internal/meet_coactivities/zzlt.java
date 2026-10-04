package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class zzlt {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final long zze;

    public zzlt(String str, Class cls, boolean z) {
        this(str, cls, z, true);
    }

    public static zzlt zzd(String str, Class cls) {
        return new zzlt(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        String name = getClass().getName();
        return AbstractC0541b.m776r(AbstractC0541b.m781w(name, "/"), this.zza, "[", cls.getName(), "]");
    }

    public void zza(Iterator it, zzls zzlsVar) {
        while (it.hasNext()) {
            zzb(it.next(), zzlsVar);
        }
    }

    public void zzb(Object obj, zzls zzlsVar) {
        zzlsVar.zza(this.zza, obj);
    }

    public final long zzc() {
        return this.zze;
    }

    public final Object zze(Object obj) {
        return this.zzb.cast(obj);
    }

    public final String zzf() {
        return this.zza;
    }

    public final void zzg(Object obj, zzls zzlsVar) {
        if (!this.zzd || zznr.zza() <= 20) {
            zzb(obj, zzlsVar);
        } else {
            zzlsVar.zza(this.zza, obj);
        }
    }

    public final void zzh(Iterator it, zzls zzlsVar) {
        if (!this.zzc) {
            throw new IllegalStateException("non repeating key");
        }
        if (!this.zzd || zznr.zza() <= 20) {
            zza(it, zzlsVar);
        } else {
            while (it.hasNext()) {
                zzlsVar.zza(this.zza, it.next());
            }
        }
    }

    public final boolean zzi() {
        return this.zzc;
    }

    private zzlt(String str, Class cls, boolean z, boolean z2) {
        zzpi.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z;
        this.zzd = z2;
        int iIdentityHashCode = System.identityHashCode(this);
        long j = 0;
        for (int i = 0; i < 5; i++) {
            j |= 1 << (iIdentityHashCode & 63);
            iIdentityHashCode >>>= 6;
        }
        this.zze = j;
    }
}
