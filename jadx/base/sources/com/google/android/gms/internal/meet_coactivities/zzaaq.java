package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
public final class zzaaq {
    private static final Logger zza = Logger.getLogger(zzaaq.class.getName());
    private static zzaaq zzb;

    @GuardedBy("this")
    private String zzc = "unknown";

    @GuardedBy("this")
    private final LinkedHashSet zzd = new LinkedHashSet();

    @GuardedBy("this")
    private ImmutableMap zze = ImmutableMap.m4321of();

    public static synchronized zzaaq zzb() {
        if (zzb == null) {
            ArrayList arrayList = new ArrayList();
            try {
                int i = zzahc.f2184a;
                arrayList.add(zzahc.class);
            } catch (ClassNotFoundException e) {
                zza.logp(Level.FINE, "io.grpc.NameResolverRegistry", "getHardCodedClasses", "Unable to find DNS NameResolver", (Throwable) e);
            }
            List<zzaan> listZza = zzaax.zza(zzaan.class, Collections.unmodifiableList(arrayList), zzaan.class.getClassLoader(), new zzaap(null));
            if (listZza.isEmpty()) {
                zza.logp(Level.WARNING, "io.grpc.NameResolverRegistry", "getDefaultRegistry", "No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
            }
            zzb = new zzaaq();
            for (zzaan zzaanVar : listZza) {
                zza.logp(Level.FINE, "io.grpc.NameResolverRegistry", "getDefaultRegistry", "Service loader found ".concat(String.valueOf(zzaanVar)));
                zzb.zzf(zzaanVar);
            }
            zzb.zzg();
        }
        return zzb;
    }

    private final synchronized void zzf(zzaan zzaanVar) {
        zzaanVar.zze();
        Preconditions.checkArgument(true, "isAvailable() returned false");
        this.zzd.add(zzaanVar);
    }

    private final synchronized void zzg() {
        try {
            HashMap map = new HashMap();
            String strZzb = "unknown";
            byte b = -2147483648;
            for (zzaan zzaanVar : this.zzd) {
                String strZzb2 = zzaanVar.zzb();
                if (((zzaan) map.get(strZzb2)) != null) {
                    zzaanVar.zzc();
                } else {
                    map.put(strZzb2, zzaanVar);
                }
                zzaanVar.zzc();
                if (b < 5) {
                    zzaanVar.zzc();
                    strZzb = zzaanVar.zzb();
                }
                b = 5;
            }
            this.zze = ImmutableMap.copyOf((Map) map);
            this.zzc = strZzb;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final zzaan zza(String str) {
        if (str == null) {
            return null;
        }
        return (zzaan) zzd().get(str.toLowerCase(Locale.US));
    }

    public final synchronized String zzc() {
        return this.zzc;
    }

    @VisibleForTesting
    public final synchronized Map zzd() {
        return this.zze;
    }

    public final synchronized void zze(zzaan zzaanVar) {
        zzf(zzaanVar);
        zzg();
    }
}
