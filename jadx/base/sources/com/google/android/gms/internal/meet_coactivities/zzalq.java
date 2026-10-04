package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzalq extends zzzd {
    private static final Logger zze = Logger.getLogger(zzalq.class.getName());
    private final zzyt zzf;
    private zzalk zzh;

    @Nullable
    private zzabk zzk;
    private zzwz zzl;
    private zzwz zzm;
    private final boolean zzn;
    private final Map zzg = new HashMap();
    private int zzi = 0;
    private boolean zzj = true;

    public zzalq(zzyt zzytVar) {
        zzwz zzwzVar = zzwz.IDLE;
        this.zzl = zzwzVar;
        this.zzm = zzwzVar;
        int i = zzalx.zzb;
        this.zzn = zzahv.zzg("GRPC_EXPERIMENTAL_XDS_DUALSTACK_ENDPOINTS", false);
        this.zzf = (zzyt) Preconditions.checkNotNull(zzytVar, "helper");
    }

    private final void zzm() {
        zzabk zzabkVar = this.zzk;
        if (zzabkVar != null) {
            zzabkVar.zza();
            this.zzk = null;
        }
    }

    private final void zzn() {
        if (this.zzn) {
            zzabk zzabkVar = this.zzk;
            if (zzabkVar == null || !zzabkVar.zzb()) {
                try {
                    zzabl zzablVarZzb = this.zzf.zzb();
                    this.zzk = zzablVarZzb.zza(new zzalh(this), 250L, TimeUnit.MILLISECONDS, this.zzf.zzc());
                } catch (NullPointerException unused) {
                }
            }
        }
    }

    private final void zzo(zzwz zzwzVar, zzzb zzzbVar) {
        if (zzwzVar == this.zzm && (zzwzVar == zzwz.IDLE || zzwzVar == zzwz.CONNECTING)) {
            return;
        }
        this.zzm = zzwzVar;
        this.zzf.zze(zzwzVar, zzzbVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzp(zzalp zzalpVar) {
        zzwz zzwzVar = zzalpVar.zzb;
        zzwz zzwzVar2 = zzwz.READY;
        if (zzwzVar != zzwzVar2) {
            return;
        }
        if (zzalp.zzb(zzalpVar) == zzwzVar2) {
            zzo(zzwzVar2, new zzys(zzyv.zzd(zzalpVar.zza, null)));
            return;
        }
        zzwz zzwzVarZzb = zzalp.zzb(zzalpVar);
        zzwz zzwzVar3 = zzwz.TRANSIENT_FAILURE;
        if (zzwzVarZzb == zzwzVar3) {
            zzo(zzwzVar3, new zzalm(zzyv.zzb(zzalpVar.zzc.zzb.zzd())));
        } else if (this.zzm != zzwzVar3) {
            zzo(zzalp.zzb(zzalpVar), new zzalm(zzyv.zzc()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final SocketAddress zzq(zzza zzzaVar) {
        boolean z;
        zzakk zzakkVar = (zzakk) zzzaVar;
        zzakkVar.zzj.zzd.zzd();
        Preconditions.checkState(zzakkVar.zzg, "not started");
        List list = zzakkVar.zze;
        if (list != null) {
            z = list.size() == 1;
        }
        Preconditions.checkState(z, "%s does not have exactly one group", list);
        return (SocketAddress) ((zzxm) list.get(0)).zzb().get(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.meet_coactivities.zzzd
    public final zzabd zza(zzyz zzyzVar) {
        zzwz zzwzVar;
        Boolean bool;
        if (this.zzl == zzwz.SHUTDOWN) {
            return zzabd.zzh.zze("Already shut down");
        }
        List listZze = zzyzVar.zze();
        if (listZze.isEmpty()) {
            zzabd zzabdVarZze = zzabd.zzk.zze("NameResolver returned no usable address. addrs=" + String.valueOf(zzyzVar.zze()) + ", attrs=" + String.valueOf(zzyzVar.zza()));
            zzb(zzabdVarZze);
            return zzabdVarZze;
        }
        Iterator it = listZze.iterator();
        while (it.hasNext()) {
            if (((zzxm) it.next()) == null) {
                zzabd zzabdVarZze2 = zzabd.zzk.zze("NameResolver returned address list with null endpoint. addrs=" + String.valueOf(zzyzVar.zze()) + ", attrs=" + String.valueOf(zzyzVar.zza()));
                zzb(zzabdVarZze2);
                return zzabdVarZze2;
            }
        }
        this.zzj = true;
        if ((zzyzVar.zzd() instanceof zzall) && (bool = ((zzall) zzyzVar.zzd()).zza) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(listZze);
            Collections.shuffle(arrayList, new Random());
            listZze = arrayList;
        }
        ImmutableList immutableListBuild = ImmutableList.builder().addAll((Iterable) listZze).build();
        zzalk zzalkVar = this.zzh;
        if (zzalkVar == null) {
            this.zzh = new zzalk(immutableListBuild);
        } else if (this.zzl == zzwz.READY) {
            SocketAddress socketAddressZzc = zzalkVar.zzc();
            this.zzh.zze(immutableListBuild);
            if (this.zzh.zzh(socketAddressZzc)) {
                zzza zzzaVarZze = ((zzalp) this.zzg.get(socketAddressZzc)).zze();
                zzalk zzalkVar2 = this.zzh;
                zzzaVarZze.zze(Collections.singletonList(new zzxm(Collections.singletonList(zzalkVar2.zzc()), zzalkVar2.zzb())));
                return zzabd.zza;
            }
            this.zzh.zzd();
        } else {
            zzalkVar.zze(immutableListBuild);
        }
        HashSet<SocketAddress> hashSet = new HashSet(this.zzg.keySet());
        HashSet hashSet2 = new HashSet();
        int size = immutableListBuild.size();
        for (int i = 0; i < size; i++) {
            hashSet2.addAll(((zzxm) immutableListBuild.get(i)).zzb());
        }
        for (SocketAddress socketAddress : hashSet) {
            if (!hashSet2.contains(socketAddress)) {
                ((zzalp) this.zzg.remove(socketAddress)).zze().zzc();
            }
        }
        if (hashSet.size() == 0 || (zzwzVar = this.zzl) == zzwz.CONNECTING || zzwzVar == zzwz.READY) {
            zzwz zzwzVar2 = zzwz.CONNECTING;
            this.zzl = zzwzVar2;
            zzo(zzwzVar2, new zzalm(zzyv.zzc()));
            zzm();
            zzd();
        } else {
            zzwz zzwzVar3 = zzwz.IDLE;
            if (zzwzVar == zzwzVar3) {
                zzo(zzwzVar3, new zzalo(this, this));
            } else if (zzwzVar == zzwz.TRANSIENT_FAILURE) {
                zzm();
                zzd();
            }
        }
        return zzabd.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzd
    public final void zzb(zzabd zzabdVar) {
        Iterator it = this.zzg.values().iterator();
        while (it.hasNext()) {
            ((zzalp) it.next()).zze().zzc();
        }
        this.zzg.clear();
        zzo(zzwz.TRANSIENT_FAILURE, new zzalm(zzyv.zzb(zzabdVar)));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzd
    public final void zzd() {
        final zzza zzzaVarZza;
        zzalk zzalkVar = this.zzh;
        if (zzalkVar == null || !zzalkVar.zzg() || this.zzl == zzwz.SHUTDOWN) {
            return;
        }
        SocketAddress socketAddressZzc = this.zzh.zzc();
        if (this.zzg.containsKey(socketAddressZzc)) {
            zzzaVarZza = ((zzalp) this.zzg.get(socketAddressZzc)).zze();
        } else {
            zzvy zzvyVarZzb = this.zzh.zzb();
            zzalj zzaljVar = new zzalj(this, null);
            zzyt zzytVar = this.zzf;
            zzyn zzynVarZzb = zzyq.zzb();
            zzynVarZzb.zzb(Lists.newArrayList(new zzxm(Collections.singletonList(socketAddressZzc), zzvyVarZzb)));
            zzynVarZzb.zza(zzzd.zzb, zzaljVar);
            zzzaVarZza = zzytVar.zza(zzynVarZzb.zzc());
            zzalp zzalpVar = new zzalp(zzzaVarZza, zzwz.IDLE, zzaljVar);
            zzaljVar.zzc = zzalpVar;
            this.zzg.put(socketAddressZzc, zzalpVar);
            if (((zzakk) zzzaVarZza).zza.zza().zzc(zzzd.zzc) == null) {
                zzaljVar.zzb = zzxa.zzb(zzwz.READY);
            }
            zzzaVarZza.zzd(new zzzc() { // from class: com.google.android.gms.internal.meet_coactivities.zzalg
                @Override // com.google.android.gms.internal.meet_coactivities.zzzc
                public final void zza(zzxa zzxaVar) {
                    this.zza.zzl(zzzaVarZza, zzxaVar);
                }
            });
        }
        int iOrdinal = ((zzalp) this.zzg.get(socketAddressZzc)).zzc().ordinal();
        if (iOrdinal == 0) {
            if (this.zzn) {
                zzn();
                return;
            } else {
                zzzaVarZza.zzb();
                return;
            }
        }
        if (iOrdinal == 1) {
            zze.logp(Level.WARNING, "io.grpc.internal.PickFirstLeafLoadBalancer", "requestConnection", "Requesting a connection even though we have a READY subchannel");
            return;
        }
        if (iOrdinal == 2) {
            this.zzh.zzf();
            zzd();
        } else {
            if (iOrdinal != 3) {
                return;
            }
            zzzaVarZza.zzb();
            zzalp.zzg((zzalp) this.zzg.get(socketAddressZzc), zzwz.CONNECTING);
            zzn();
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzd
    public final void zze() {
        zze.logp(Level.FINE, "io.grpc.internal.PickFirstLeafLoadBalancer", "shutdown", "Shutting down, currently have {} subchannels created", Integer.valueOf(this.zzg.size()));
        zzwz zzwzVar = zzwz.SHUTDOWN;
        this.zzl = zzwzVar;
        this.zzm = zzwzVar;
        zzm();
        Iterator it = this.zzg.values().iterator();
        while (it.hasNext()) {
            ((zzalp) it.next()).zze().zzc();
        }
        this.zzg.clear();
    }

    public final void zzl(zzza zzzaVar, zzxa zzxaVar) {
        zzwz zzwzVarZza = zzxaVar.zza();
        zzalp zzalpVar = (zzalp) this.zzg.get(zzq(zzzaVar));
        if (zzalpVar == null || zzalpVar.zze() != zzzaVar || zzwzVarZza == zzwz.SHUTDOWN) {
            return;
        }
        zzwz zzwzVar = zzwz.IDLE;
        if (zzwzVarZza == zzwzVar) {
            this.zzf.zzd();
        }
        zzalp.zzg(zzalpVar, zzwzVarZza);
        zzwz zzwzVar2 = this.zzl;
        zzwz zzwzVar3 = zzwz.TRANSIENT_FAILURE;
        if (zzwzVar2 == zzwzVar3 || this.zzm == zzwzVar3) {
            if (zzwzVarZza == zzwz.CONNECTING) {
                return;
            }
            if (zzwzVarZza == zzwzVar) {
                zzd();
                return;
            }
        }
        int iOrdinal = zzwzVarZza.ordinal();
        if (iOrdinal == 0) {
            zzwz zzwzVar4 = zzwz.CONNECTING;
            this.zzl = zzwzVar4;
            zzo(zzwzVar4, new zzalm(zzyv.zzc()));
            return;
        }
        if (iOrdinal == 1) {
            zzm();
            for (zzalp zzalpVar2 : this.zzg.values()) {
                if (!zzalpVar2.zze().equals(zzalpVar.zza)) {
                    zzalpVar2.zze().zzc();
                }
            }
            this.zzg.clear();
            zzwz zzwzVar5 = zzwz.READY;
            zzalp.zzg(zzalpVar, zzwzVar5);
            this.zzg.put(zzq(zzalpVar.zza), zzalpVar);
            this.zzh.zzh(zzq(zzzaVar));
            this.zzl = zzwzVar5;
            zzp(zzalpVar);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                throw new IllegalArgumentException("Unsupported state:".concat(String.valueOf(zzwzVarZza)));
            }
            this.zzh.zzd();
            this.zzl = zzwzVar;
            zzo(zzwzVar, new zzalo(this, this));
            return;
        }
        if (this.zzh.zzg() && ((zzalp) this.zzg.get(this.zzh.zzc())).zze() == zzzaVar && this.zzh.zzf()) {
            zzm();
            zzd();
        }
        zzalk zzalkVar = this.zzh;
        if (zzalkVar == null || zzalkVar.zzg() || this.zzg.size() < this.zzh.zza()) {
            return;
        }
        Iterator it = this.zzg.values().iterator();
        while (it.hasNext()) {
            if (!((zzalp) it.next()).zzh()) {
                return;
            }
        }
        zzwz zzwzVar6 = zzwz.TRANSIENT_FAILURE;
        this.zzl = zzwzVar6;
        zzo(zzwzVar6, new zzalm(zzyv.zzb(zzxaVar.zzd())));
        int i = this.zzi + 1;
        this.zzi = i;
        if (i >= this.zzh.zza() || this.zzj) {
            this.zzj = false;
            this.zzi = 0;
            this.zzf.zzd();
        }
    }
}
