package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
final class zzais implements zzyh, zzaox {
    private final zzyi zza;
    private final String zzb;
    private final zzail zzc;
    private final zzaex zzd;
    private final ScheduledExecutorService zze;
    private final zzxz zzf;
    private final zzaei zzg;
    private final zzwg zzh;
    private final List zzi;
    private final zzabl zzj;
    private final zzaim zzk;
    private volatile List zzl;
    private final Stopwatch zzm;

    @Nullable
    private zzabk zzn;

    @Nullable
    private zzabk zzo;

    @Nullable
    private zzalc zzp;

    @Nullable
    private zzaey zzs;

    @Nullable
    private volatile zzalc zzt;
    private zzabd zzv;
    private zzahe zzw;
    private final Collection zzq = new ArrayList();
    private final zzahx zzr = new zzahz(this);
    private volatile zzxa zzu = zzxa.zzb(zzwz.IDLE);

    public zzais(List list, String str, String str2, zzahd zzahdVar, zzaex zzaexVar, ScheduledExecutorService scheduledExecutorService, Supplier supplier, zzabl zzablVar, zzail zzailVar, zzxz zzxzVar, zzaei zzaeiVar, zzaek zzaekVar, zzyi zzyiVar, zzwg zzwgVar, List list2) {
        Preconditions.checkNotNull(list, "addressGroups");
        Preconditions.checkArgument(!list.isEmpty(), "addressGroups is empty");
        zzI(list, "addressGroups contains null entry");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.zzl = listUnmodifiableList;
        this.zzk = new zzaim(listUnmodifiableList);
        this.zzb = str;
        this.zzd = zzaexVar;
        this.zze = scheduledExecutorService;
        this.zzm = (Stopwatch) supplier.get();
        this.zzj = zzablVar;
        this.zzc = zzailVar;
        this.zzf = zzxzVar;
        this.zzg = zzaeiVar;
        this.zza = (zzyi) Preconditions.checkNotNull(zzyiVar, "logId");
        this.zzh = (zzwg) Preconditions.checkNotNull(zzwgVar, "channelLogger");
        this.zzi = list2;
    }

    public static /* bridge */ /* synthetic */ void zzA(zzais zzaisVar, zzwz zzwzVar) {
        zzaisVar.zzj.zzd();
        zzaisVar.zzJ(zzxa.zzb(zzwzVar));
    }

    public static /* bridge */ /* synthetic */ void zzB(zzais zzaisVar) {
        zzaif zzaifVar = new zzaif(zzaisVar);
        zzabl zzablVar = zzaisVar.zzj;
        zzablVar.zzc(zzaifVar);
        zzablVar.zzb();
    }

    public static /* bridge */ /* synthetic */ void zzC(zzais zzaisVar, zzaey zzaeyVar, boolean z) {
        zzaig zzaigVar = new zzaig(zzaisVar, zzaeyVar, z);
        zzabl zzablVar = zzaisVar.zzj;
        zzablVar.zzc(zzaigVar);
        zzablVar.zzb();
    }

    public static /* bridge */ /* synthetic */ void zzD(zzais zzaisVar, zzabd zzabdVar) {
        zzaisVar.zzj.zzd();
        zzaisVar.zzJ(zzxa.zzc(zzabdVar));
        if (zzaisVar.zzw == null) {
            zzaisVar.zzw = new zzahe();
        }
        long jZza = zzaisVar.zzw.zza();
        Stopwatch stopwatch = zzaisVar.zzm;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long jElapsed = jZza - stopwatch.elapsed(timeUnit);
        zzaisVar.zzh.zzb(2, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", zzK(zzabdVar), Long.valueOf(jElapsed));
        Preconditions.checkState(zzaisVar.zzn == null, "previous reconnectTask is not done");
        zzaisVar.zzn = zzaisVar.zzj.zza(new zzaia(zzaisVar), jElapsed, timeUnit, zzaisVar.zze);
    }

    public static /* bridge */ /* synthetic */ void zzE(zzais zzaisVar) {
        zzxu zzxuVar;
        zzaisVar.zzj.zzd();
        Preconditions.checkState(zzaisVar.zzn == null, "Should have no reconnectTask scheduled");
        if (zzaisVar.zzk.zzf()) {
            zzaisVar.zzm.reset().start();
        }
        SocketAddress socketAddressZzb = zzaisVar.zzk.zzb();
        zzaij zzaijVar = null;
        if (socketAddressZzb instanceof zzxu) {
            zzxu zzxuVar2 = (zzxu) socketAddressZzb;
            zzxuVar = zzxuVar2;
            socketAddressZzb = zzxuVar2.zzb();
        } else {
            zzxuVar = null;
        }
        zzvy zzvyVarZza = zzaisVar.zzk.zza();
        String str = (String) zzvyVarZza.zzc(zzxm.zza);
        zzaew zzaewVar = new zzaew();
        if (str == null) {
            str = zzaisVar.zzb;
        }
        zzaewVar.zzb(str);
        zzaewVar.zzc(zzvyVarZza);
        zzaewVar.zze(null);
        zzaewVar.zzd(zzxuVar);
        zzair zzairVar = new zzair();
        zzairVar.zza = zzaisVar.zza;
        zzaik zzaikVar = new zzaik(zzaisVar.zzd.zza(socketAddressZzb, zzaewVar, zzairVar), zzaisVar.zzg, zzaijVar);
        zzairVar.zza = zzaikVar.zzc();
        zzaisVar.zzf.zzb(zzaikVar);
        zzaisVar.zzs = zzaikVar;
        zzaisVar.zzq.add(zzaikVar);
        zzaisVar.zzj.zzc(zzaikVar.zze(new zzaiq(zzaisVar, zzaikVar)));
        zzaisVar.zzh.zzb(2, "Started transport {0}", zzairVar.zza);
    }

    private static void zzI(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Preconditions.checkNotNull(it.next(), str);
        }
    }

    private final void zzJ(zzxa zzxaVar) {
        this.zzj.zzd();
        if (this.zzu.zza() != zzxaVar.zza()) {
            Preconditions.checkState(this.zzu.zza() != zzwz.SHUTDOWN, "Cannot transition out of SHUTDOWN to ".concat(zzxaVar.toString()));
            this.zzu = zzxaVar;
            zzail zzailVar = this.zzc;
            Preconditions.checkState(true, "listener is null");
            ((zzaki) zzailVar).zza.zza(zzxaVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String zzK(zzabd zzabdVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(zzabdVar.zza());
        if (zzabdVar.zzg() != null) {
            sb.append("(");
            sb.append(zzabdVar.zzg());
            sb.append(")");
        }
        if (zzabdVar.zzh() != null) {
            sb.append("[");
            sb.append(zzabdVar.zzh());
            sb.append("]");
        }
        return sb.toString();
    }

    public static /* bridge */ /* synthetic */ void zzz(zzais zzaisVar) {
        zzaisVar.zzj.zzd();
        zzabk zzabkVar = zzaisVar.zzn;
        if (zzabkVar != null) {
            zzabkVar.zza();
            zzaisVar.zzn = null;
            zzaisVar.zzw = null;
        }
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.zza.zza()).add("addressGroups", this.zzl).toString();
    }

    public final void zzF(zzabd zzabdVar) {
        zzaie zzaieVar = new zzaie(this, zzabdVar);
        zzabl zzablVar = this.zzj;
        zzablVar.zzc(zzaieVar);
        zzablVar.zzb();
    }

    public final void zzG(List list) {
        Preconditions.checkNotNull(list, "newAddressGroups");
        zzI(list, "newAddressGroups contains null entry");
        Preconditions.checkArgument(!list.isEmpty(), "newAddressGroups is empty");
        zzaid zzaidVar = new zzaid(this, Collections.unmodifiableList(new ArrayList(list)));
        zzabl zzablVar = this.zzj;
        zzablVar.zzc(zzaidVar);
        zzablVar.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzym
    public final zzyi zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaox
    public final zzaev zzh() {
        zzalc zzalcVar = this.zzt;
        if (zzalcVar != null) {
            return zzalcVar;
        }
        zzabl zzablVar = this.zzj;
        zzablVar.zzc(new zzaib(this));
        zzablVar.zzb();
        return null;
    }
}
