package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
public final class zzzh {
    private static final Logger zza = Logger.getLogger(zzzh.class.getName());
    private static zzzh zzb;
    private static final Iterable zzc;
    private final LinkedHashSet zzd = new LinkedHashSet();
    private final LinkedHashMap zze = new LinkedHashMap();

    static {
        ArrayList arrayList = new ArrayList();
        try {
            int i = zzalx.zzb;
            arrayList.add(zzalx.class);
        } catch (ClassNotFoundException e) {
            zza.logp(Level.WARNING, "io.grpc.LoadBalancerRegistry", "getHardCodedClasses", "Unable to find pick-first LoadBalancer", (Throwable) e);
        }
        try {
            int i2 = zzapw.f2185a;
            arrayList.add(zzapw.class);
        } catch (ClassNotFoundException e2) {
            zza.logp(Level.FINE, "io.grpc.LoadBalancerRegistry", "getHardCodedClasses", "Unable to find round-robin LoadBalancer", (Throwable) e2);
        }
        zzc = Collections.unmodifiableList(arrayList);
    }

    public static synchronized zzzh zzb() {
        try {
            if (zzb == null) {
                List<zzzf> listZza = zzaax.zza(zzzf.class, zzc, zzzf.class.getClassLoader(), new zzzg());
                zzb = new zzzh();
                for (zzzf zzzfVar : listZza) {
                    zza.logp(Level.FINE, "io.grpc.LoadBalancerRegistry", "getDefaultRegistry", "Service loader found ".concat(String.valueOf(zzzfVar)));
                    zzb.zzc(zzzfVar);
                }
                zzb.zzd();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzb;
    }

    private final synchronized void zzc(zzzf zzzfVar) {
        zzzfVar.zze();
        Preconditions.checkArgument(true, "isAvailable() returned false");
        this.zzd.add(zzzfVar);
    }

    private final synchronized void zzd() {
        try {
            this.zze.clear();
            for (zzzf zzzfVar : this.zzd) {
                String strZzd = zzzfVar.zzd();
                if (((zzzf) this.zze.get(strZzd)) != null) {
                    zzzfVar.zzb();
                } else {
                    this.zze.put(strZzd, zzzfVar);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Nullable
    public final synchronized zzzf zza(String str) {
        return (zzzf) this.zze.get(Preconditions.checkNotNull(str, "policy"));
    }
}
