package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import io.grpc.internal.GrpcUtil;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
final class zzakn extends zzzi implements zzyh {

    @VisibleForTesting
    static final Logger zza = Logger.getLogger(zzakn.class.getName());

    @VisibleForTesting
    static final zzabd zzb;

    @VisibleForTesting
    static final zzabd zzc;
    private static final zzala zzf;
    private static final zzye zzg;
    private static final zzyu zzh;
    private static final zzwi zzi;
    private final zzwe zzA;
    private final List zzB;
    private zzaam zzC;
    private boolean zzD;

    @Nullable
    private zzajt zzE;

    @Nullable
    private volatile zzzb zzF;
    private boolean zzG;
    private final Set zzH;

    @Nullable
    private Collection zzI;
    private final Object zzJ;
    private final Set zzK;
    private final zzaga zzL;
    private final zzakm zzM;
    private final AtomicBoolean zzN;
    private boolean zzO;
    private volatile boolean zzP;
    private final CountDownLatch zzQ;
    private final zzaeh zzR;
    private final zzaei zzS;
    private final zzaek zzT;
    private final zzwg zzU;
    private final zzxz zzV;
    private final zzakf zzW;
    private zzala zzX;
    private boolean zzY;
    private final boolean zzZ;
    private final zzana zzaa;
    private final long zzab;
    private final long zzac;
    private final boolean zzad;
    private final zzalb zzae;
    private final zzajg zzaf;
    private final zzamh zzag;
    private int zzah;
    private final zzahd zzai;

    @VisibleForTesting
    final zzabl zzd;

    @VisibleForTesting
    final zzahx zze;
    private final zzyi zzj;
    private final String zzk;
    private final URI zzl;
    private final zzaan zzm;
    private final zzaaf zzn;
    private final zzaec zzo;
    private final zzaex zzp;
    private final zzakh zzq;
    private final Executor zzr;
    private final zzale zzs;
    private final zzajl zzt;
    private final zzajl zzu;
    private final zzaow zzv;
    private final zzxl zzw;
    private final Supplier zzx;
    private final long zzy;
    private final zzafa zzz;

    static {
        zzabd zzabdVar = zzabd.zzk;
        zzabdVar.zze("Channel shutdownNow invoked");
        zzb = zzabdVar.zze("Channel shutdown invoked");
        zzc = zzabdVar.zze("Subchannel shutdown invoked");
        zzf = new zzala(null, new HashMap(), new HashMap(), null, null, null);
        zzg = new zzaiy();
        zzh = new zzajb();
        zzi = new zzajd();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zzakn(zzaku zzakuVar, zzaex zzaexVar, URI uri, zzaan zzaanVar, zzahd zzahdVar, zzale zzaleVar, Supplier supplier, List list, zzaow zzaowVar) {
        zzabl zzablVar = new zzabl(new zzajc(this));
        this.zzd = zzablVar;
        this.zzz = new zzafa();
        this.zzH = new HashSet(16, 0.75f);
        this.zzJ = new Object();
        this.zzK = new HashSet(1, 0.75f);
        this.zzM = new zzakm(this, null);
        this.zzN = new AtomicBoolean(false);
        this.zzQ = new CountDownLatch(1);
        this.zzah = 1;
        this.zzX = zzf;
        this.zzY = false;
        this.zzaa = new zzana();
        int i = zzxi.zza;
        zzajk zzajkVar = new zzajk(this, 0 == true ? 1 : 0);
        this.zzae = zzajkVar;
        this.zze = new zzajn(this, 0 == true ? 1 : 0);
        this.zzaf = new zzajg(this, 0 == true ? 1 : 0);
        String str = (String) Preconditions.checkNotNull(zzakuVar.zzh, "target");
        this.zzk = str;
        zzyi zzyiVarZzc = zzyi.zzc("Channel", str);
        this.zzj = zzyiVarZzc;
        this.zzv = (zzaow) Preconditions.checkNotNull(zzaowVar, "timeProvider");
        zzale zzaleVar2 = (zzale) Preconditions.checkNotNull(zzakuVar.zzd, "executorPool");
        this.zzs = zzaleVar2;
        Executor executor = (Executor) Preconditions.checkNotNull((Executor) zzaleVar2.zza(), "executor");
        this.zzr = executor;
        zzajl zzajlVar = new zzajl((zzale) Preconditions.checkNotNull(zzakuVar.zze, "offloadExecutorPool"));
        this.zzu = zzajlVar;
        zzaeg zzaegVar = new zzaeg(zzaexVar, null, zzajlVar);
        this.zzp = zzaegVar;
        new zzaeg(zzaexVar, null, zzajlVar);
        zzakh zzakhVar = new zzakh(zzaegVar.zzb(), 0 == true ? 1 : 0);
        this.zzq = zzakhVar;
        zzaek zzaekVar = new zzaek(zzyiVarZzc, 0, zzaowVar.zza(), AbstractC0541b.m773o("Channel for '", str, "'"));
        this.zzT = zzaekVar;
        zzaej zzaejVar = new zzaej(zzaekVar, zzaowVar);
        this.zzU = zzaejVar;
        zzaat zzaatVar = zzahv.zzg;
        this.zzad = true;
        zzaec zzaecVar = new zzaec(zzzh.zzb(), zzakuVar.zzi);
        this.zzo = zzaecVar;
        this.zzl = (URI) Preconditions.checkNotNull(uri, "targetUri");
        this.zzm = (zzaan) Preconditions.checkNotNull(zzaanVar, "nameResolverProvider");
        zzanz zzanzVar = new zzanz(true, 5, 5, zzaecVar);
        zzaad zzaadVarZzb = zzaaf.zzb();
        zzaadVarZzb.zzb(GrpcUtil.DEFAULT_PORT_SSL);
        zzaadVarZzb.zzd(zzaatVar);
        zzaadVarZzb.zzg(zzablVar);
        zzaadVarZzb.zze(zzakhVar);
        zzaadVarZzb.zzf(zzanzVar);
        zzaadVarZzb.zza(zzaejVar);
        zzaadVarZzb.zzc(zzajlVar);
        zzaaf zzaafVarZzh = zzaadVarZzb.zzh();
        this.zzn = zzaafVarZzh;
        this.zzC = zzn(uri, null, zzaanVar, zzaafVarZzh);
        this.zzt = new zzajl(zzaleVar);
        zzaga zzagaVar = new zzaga(executor, zzablVar);
        this.zzL = zzagaVar;
        zzagaVar.zze(zzajkVar);
        this.zzai = zzahdVar;
        this.zzZ = true;
        zzakf zzakfVar = new zzakf(this, this.zzC.zza(), null);
        this.zzW = zzakfVar;
        this.zzA = zzwm.zza(zzakfVar, list);
        this.zzB = new ArrayList(zzakuVar.zzg);
        this.zzx = (Supplier) Preconditions.checkNotNull(supplier, "stopwatchSupplier");
        long j = zzakuVar.zzl;
        if (j == -1) {
            this.zzy = -1L;
        } else {
            Preconditions.checkArgument(j >= zzaku.zzb, "invalid idleTimeoutMillis %s", j);
            this.zzy = zzakuVar.zzl;
        }
        this.zzag = new zzamh(new zzajp(this, null), zzablVar, zzaegVar.zzb(), Stopwatch.createUnstarted());
        this.zzw = (zzxl) Preconditions.checkNotNull(zzakuVar.zzj, "decompressorRegistry");
        this.zzac = 16777216L;
        this.zzab = 1048576L;
        zzaiz zzaizVar = new zzaiz(this, zzaowVar);
        this.zzR = zzaizVar;
        this.zzS = zzaizVar.zza();
        zzxz zzxzVar = (zzxz) Preconditions.checkNotNull(zzakuVar.zzm);
        this.zzV = zzxzVar;
        zzxzVar.zzc(this);
        zzaac.zza();
    }

    public static /* bridge */ /* synthetic */ Executor zzI(zzakn zzaknVar, zzwd zzwdVar) {
        Executor executorZzn = zzwdVar.zzn();
        return executorZzn == null ? zzaknVar.zzr : executorZzn;
    }

    public static /* bridge */ /* synthetic */ void zzO(zzakn zzaknVar) {
        zzaknVar.zzaf(true);
        zzaknVar.zzL.zzl(null);
        zzaknVar.zzU.zza(2, "Entering IDLE state");
        zzaknVar.zzz.zza(zzwz.IDLE);
        if (zzaknVar.zze.zzd(zzaknVar.zzJ, zzaknVar.zzL)) {
            zzaknVar.zzU();
        }
    }

    public static /* bridge */ /* synthetic */ void zzP(zzakn zzaknVar) {
        if (!zzaknVar.zzP && zzaknVar.zzN.get() && zzaknVar.zzH.isEmpty() && zzaknVar.zzK.isEmpty()) {
            zzaknVar.zzU.zza(2, "Terminated");
            zzaknVar.zzV.zzf(zzaknVar);
            zzaknVar.zzs.zzb(zzaknVar.zzr);
            zzaknVar.zzt.zzb();
            zzaknVar.zzu.zzb();
            zzaknVar.zzp.close();
            zzaknVar.zzP = true;
            zzaknVar.zzQ.countDown();
        }
    }

    public static /* bridge */ /* synthetic */ void zzQ(zzakn zzaknVar) {
        zzaknVar.zzd.zzd();
        if (zzaknVar.zzD) {
            zzaknVar.zzC.zzb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzae() {
        long j = this.zzy;
        if (j == -1) {
            return;
        }
        this.zzag.zzi(j, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaf(boolean z) {
        this.zzd.zzd();
        if (z) {
            Preconditions.checkState(this.zzD, "nameResolver is not started");
            Preconditions.checkState(this.zzE != null, "lbHelper is null");
        }
        zzaam zzaamVar = this.zzC;
        if (zzaamVar != null) {
            zzaamVar.zzc();
            this.zzD = false;
            if (z) {
                this.zzC = zzn(this.zzl, null, this.zzm, this.zzn);
            } else {
                this.zzC = null;
            }
        }
        zzajt zzajtVar = this.zzE;
        if (zzajtVar != null) {
            zzajtVar.zza.zzc();
            this.zzE = null;
        }
        this.zzF = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzag(zzzb zzzbVar) {
        this.zzF = zzzbVar;
        this.zzL.zzl(zzzbVar);
    }

    @VisibleForTesting
    public static zzaam zzn(URI uri, @Nullable String str, zzaan zzaanVar, zzaaf zzaafVar) {
        zzaam zzaamVarZza = zzaanVar.zza(uri, zzaafVar);
        if (zzaamVarZza != null) {
            return new zzany(zzaamVarZza, new zzaee(new zzahd(), zzaafVar.zzg(), zzaafVar.zze()), zzaafVar.zze());
        }
        throw new IllegalArgumentException("cannot create a NameResolver for ".concat(String.valueOf(uri)));
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.zzj.zza()).add("target", this.zzk).toString();
    }

    @VisibleForTesting
    public final void zzU() {
        this.zzd.zzd();
        if (this.zzN.get() || this.zzG) {
            return;
        }
        if (this.zze.zze()) {
            this.zzag.zzh(false);
        } else {
            zzae();
        }
        if (this.zzE == null) {
            this.zzU.zza(2, "Exiting idle mode");
            zzajt zzajtVar = new zzajt(this, null);
            zzajtVar.zza = new zzadu(this.zzo, zzajtVar);
            this.zzE = zzajtVar;
            this.zzz.zza(zzwz.CONNECTING);
            this.zzC.zzd(new zzajw(this, zzajtVar, this.zzC));
            this.zzD = true;
        }
    }

    @VisibleForTesting
    public final void zzV(Throwable th) {
        if (this.zzG) {
            return;
        }
        this.zzG = true;
        this.zzag.zzh(true);
        zzaf(false);
        zzag(new zzaja(this, th));
        this.zzW.zzg(null);
        this.zzU.zza(4, "PANIC! Entering TRANSIENT_FAILURE");
        this.zzz.zza(zzwz.TRANSIENT_FAILURE);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwe
    public final zzwi zza(zzaab zzaabVar, zzwd zzwdVar) {
        return this.zzA.zza(zzaabVar, zzwdVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwe
    public final String zzb() {
        return this.zzA.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzym
    public final zzyi zzc() {
        return this.zzj;
    }
}
