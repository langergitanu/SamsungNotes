package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzaps extends zzzd {
    private static final Logger zzh = Logger.getLogger(zzaps.class.getName());
    protected boolean zze;
    protected zzwz zzg;
    private final zzyt zzj;
    private final Map zzi = new LinkedHashMap();
    protected final zzzf zzf = new zzalx();

    public zzaps(zzyt zzytVar) {
        this.zzj = (zzyt) Preconditions.checkNotNull(zzytVar, "helper");
        zzh.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "<init>", "Created");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzd
    public final zzabd zza(zzyz zzyzVar) throws Throwable {
        zzaps zzapsVar;
        Throwable th;
        zzabd zzabdVarZze;
        zzapr zzaprVar;
        zzxm zzxmVar;
        try {
            this.zze = true;
            zzh.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "acceptResolvedAddressesInternal", "Received resolution result: {0}", zzyzVar);
            HashMap map = new HashMap();
            Iterator it = zzyzVar.zze().iterator();
            while (it.hasNext()) {
                zzapr zzaprVar2 = new zzapr((zzxm) it.next());
                zzapq zzapqVar = (zzapq) this.zzi.get(zzaprVar2);
                if (zzapqVar != null) {
                    try {
                        map.put(zzaprVar2, zzapqVar);
                    } catch (Throwable th2) {
                        th = th2;
                        zzapsVar = this;
                        zzapsVar.zze = false;
                        throw th;
                    }
                } else {
                    zzapsVar = this;
                    try {
                        map.put(zzaprVar2, new zzapq(zzapsVar, zzaprVar2, this.zzf, null, new zzys(zzyv.zzc())));
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        zzapsVar.zze = false;
                        throw th;
                    }
                }
            }
            zzapsVar = this;
            ArrayList arrayList = null;
            if (map.isEmpty()) {
                zzabdVarZze = zzabd.zzk.zze("NameResolver returned no usable address. ".concat(zzyzVar.toString()));
                zzb(zzabdVarZze);
            } else {
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    if (!zzapsVar.zzi.containsKey(key)) {
                        zzapsVar.zzi.put(key, (zzapq) entry.getValue());
                    }
                }
                for (Map.Entry entry2 : map.entrySet()) {
                    zzapq zzapqVar2 = (zzapq) zzapsVar.zzi.get(entry2.getKey());
                    Object key2 = entry2.getKey();
                    if (key2 instanceof zzxm) {
                        zzaprVar = new zzapr((zzxm) key2);
                    } else {
                        Preconditions.checkArgument(key2 instanceof zzapr, "key is wrong type");
                        zzaprVar = (zzapr) key2;
                    }
                    Iterator it2 = zzyzVar.zze().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            zzxmVar = null;
                            break;
                        }
                        zzxmVar = (zzxm) it2.next();
                        if (zzaprVar.equals(new zzapr(zzxmVar))) {
                            break;
                        }
                    }
                    Preconditions.checkNotNull(zzxmVar, String.valueOf(key2).concat(" no longer present in load balancer children"));
                    zzyx zzyxVarZzc = zzyzVar.zzc();
                    zzyxVarZzc.zza(Collections.singletonList(zzxmVar));
                    zzvv zzvvVarZza = zzvy.zza();
                    zzvvVarZza.zzb(zzzd.zzd, Boolean.TRUE);
                    zzyxVarZzc.zzb(zzvvVarZza.zzc());
                    zzyxVarZzc.zzc(null);
                    zzyz zzyzVarZzd = zzyxVarZzc.zzd();
                    Preconditions.checkNotNull(zzyzVarZzd, "Missing address list for child");
                    zzapqVar2.zzc.zzc(zzyzVarZzd);
                }
                zzabd zzabdVar = zzabd.zza;
                Set setKeySet = map.keySet();
                arrayList = new ArrayList();
                ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) zzapsVar.zzi.keySet());
                int size = immutableListCopyOf.size();
                for (int i = 0; i < size; i++) {
                    Object obj = immutableListCopyOf.get(i);
                    if (!setKeySet.contains(obj)) {
                        arrayList.add((zzapq) zzapsVar.zzi.remove(obj));
                    }
                }
                zzabdVarZze = zzabdVar;
            }
            if (zzabdVarZze.zzj()) {
                zzk();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((zzapq) it3.next()).zzg();
                }
            }
            zzapsVar.zze = false;
            return zzabdVarZze;
        } catch (Throwable th4) {
            th = th4;
            zzapsVar = this;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzd
    public final void zzb(zzabd zzabdVar) {
        if (this.zzg != zzwz.READY) {
            this.zzj.zze(zzwz.TRANSIENT_FAILURE, new zzys(zzyv.zzb(zzabdVar)));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzd
    public final void zze() {
        zzh.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "shutdown", "Shutdown");
        Iterator it = this.zzi.values().iterator();
        while (it.hasNext()) {
            ((zzapq) it.next()).zzg();
        }
        this.zzi.clear();
    }

    public final zzyt zzg() {
        return this.zzj;
    }

    @VisibleForTesting
    public final Collection zzh() {
        return this.zzi.values();
    }

    public abstract void zzk();
}
