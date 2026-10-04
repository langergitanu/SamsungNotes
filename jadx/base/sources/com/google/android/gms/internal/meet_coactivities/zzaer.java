package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaer extends zzwi {
    private static final Logger zza = Logger.getLogger(zzaer.class.getName());
    private static final double zzb;
    private final zzaab zzc;
    private final Executor zzd;
    private final boolean zze;
    private final zzaei zzf;
    private final zzxe zzg;
    private zzael zzh;
    private final boolean zzi;
    private zzwd zzj;
    private zzaes zzk;
    private boolean zzl;
    private boolean zzm;
    private final ScheduledExecutorService zzn;
    private zzxl zzo = zzxl.zza();
    private final zzajg zzp;

    static {
        "gzip".getBytes(Charset.forName("US-ASCII"));
        zzb = TimeUnit.SECONDS.toNanos(1L);
    }

    public zzaer(zzaab zzaabVar, Executor executor, zzwd zzwdVar, zzajg zzajgVar, ScheduledExecutorService scheduledExecutorService, zzaei zzaeiVar, @Nullable zzye zzyeVar) {
        int i = zzww.zza;
        this.zzc = zzaabVar;
        zzaabVar.zzf();
        System.identityHashCode(this);
        int i2 = zzapz.zza;
        if (executor == MoreExecutors.directExecutor()) {
            this.zzd = new zzaoa();
            this.zze = true;
        } else {
            this.zzd = new zzaoh(executor);
            this.zze = false;
        }
        this.zzf = zzaeiVar;
        this.zzg = zzxe.zzb();
        this.zzi = zzaabVar.zzb() == zzzz.UNARY || zzaabVar.zzb() == zzzz.SERVER_STREAMING;
        this.zzj = zzwdVar;
        this.zzp = zzajgVar;
        this.zzn = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final zzxi zzq() {
        zzxi zzxiVarZzi = this.zzj.zzi();
        if (zzxiVarZzi == null) {
            return null;
        }
        return zzxiVarZzi;
    }

    private final void zzr(Object obj) {
        Preconditions.checkState(this.zzk != null, "Not started");
        Preconditions.checkState(!this.zzl, "call was cancelled");
        Preconditions.checkState(!this.zzm, "call was half-closed");
        try {
            zzaes zzaesVar = this.zzk;
            if (zzaesVar instanceof zzanr) {
                ((zzanr) zzaesVar).zzaa(obj);
            } else {
                zzaesVar.zzm(this.zzc.zzc(obj));
            }
            if (this.zzi) {
                return;
            }
            this.zzk.zzc();
        } catch (Error e) {
            this.zzk.zzb(zzabd.zzb.zze("Client sendMessage() failed with Error"));
            throw e;
        } catch (RuntimeException e2) {
            this.zzk.zzb(zzabd.zzb.zzd(e2).zze("Failed to stream message"));
        }
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("method", this.zzc).toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zza(@Nullable String str, @Nullable Throwable th) {
        int i = zzapz.zza;
        if (str == null && th == null) {
            CancellationException cancellationException = new CancellationException("Cancelled without a message or cause");
            zza.logp(Level.WARNING, "io.grpc.internal.ClientCallImpl", "cancelInternal", "Cancelling without a message or cause is suboptimal", (Throwable) cancellationException);
            th = cancellationException;
        }
        if (this.zzl) {
            return;
        }
        this.zzl = true;
        try {
            if (this.zzk != null) {
                zzabd zzabdVar = zzabd.zzb;
                zzabd zzabdVarZze = str != null ? zzabdVar.zze(str) : zzabdVar.zze("Call cancelled without message");
                if (th != null) {
                    zzabdVarZze = zzabdVarZze.zzd(th);
                }
                this.zzk.zzb(zzabdVarZze);
            }
            zzael zzaelVar = this.zzh;
            if (zzaelVar != null) {
                zzaelVar.zzd();
            }
        } finally {
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zzb() {
        int i = zzapz.zza;
        Preconditions.checkState(this.zzk != null, "Not started");
        Preconditions.checkState(!this.zzl, "call was cancelled");
        Preconditions.checkState(!this.zzm, "call already half-closed");
        this.zzm = true;
        this.zzk.zzd();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zzc(int i) {
        int i2 = zzapz.zza;
        Preconditions.checkState(this.zzk != null, "Not started");
        Preconditions.checkArgument(true, "Number requested must be non-negative");
        this.zzk.zzf(i);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zzd(Object obj) {
        int i = zzapz.zza;
        zzr(obj);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwi
    public final void zze(zzwh zzwhVar, zzzv zzzvVar) {
        zzaes zzajeVar;
        int i = zzapz.zza;
        Preconditions.checkState(this.zzk == null, "Already started");
        Preconditions.checkState(!this.zzl, "call was cancelled");
        Preconditions.checkNotNull(zzwhVar, "observer");
        Preconditions.checkNotNull(zzzvVar, Contract.HEADERS);
        zzwd zzwdVar = this.zzj;
        zzwb zzwbVar = zzakx.zza;
        zzakx zzakxVar = (zzakx) zzwdVar.zzl(zzwbVar);
        if (zzakxVar != null) {
            Long l = zzakxVar.zzb;
            if (l != null) {
                zzxi zzxiVarZzc = zzxi.zzc(l.longValue(), TimeUnit.NANOSECONDS);
                zzxi zzxiVarZzi = this.zzj.zzi();
                if (zzxiVarZzi == null || zzxiVarZzc.compareTo(zzxiVarZzi) < 0) {
                    this.zzj = this.zzj.zza(zzxiVarZzc);
                }
            }
            Boolean bool = zzakxVar.zzc;
            if (bool != null) {
                this.zzj = bool.booleanValue() ? this.zzj.zzg() : this.zzj.zzh();
            }
            if (zzakxVar.zzd != null) {
                Integer numZzj = this.zzj.zzj();
                if (numZzj != null) {
                    this.zzj = this.zzj.zzc(Math.min(numZzj.intValue(), zzakxVar.zzd.intValue()));
                } else {
                    this.zzj = this.zzj.zzc(zzakxVar.zzd.intValue());
                }
            }
            if (zzakxVar.zze != null) {
                Integer numZzk = this.zzj.zzk();
                if (numZzk != null) {
                    this.zzj = this.zzj.zzd(Math.min(numZzk.intValue(), zzakxVar.zze.intValue()));
                } else {
                    this.zzj = this.zzj.zzd(zzakxVar.zze.intValue());
                }
            }
        }
        zzwu zzwuVar = zzwt.zza;
        zzxl zzxlVar = this.zzo;
        zzzvVar.zzd(zzahv.zzf);
        zzzvVar.zzd(zzahv.zzb);
        zzzq zzzqVar = zzahv.zzc;
        zzzvVar.zzd(zzzqVar);
        byte[] bArrZza = zzyg.zza(zzxlVar);
        if (bArrZza.length != 0) {
            zzzvVar.zzf(zzzqVar, bArrZza);
        }
        zzzvVar.zzd(zzahv.zzd);
        zzzvVar.zzd(zzahv.zze);
        zzxi zzxiVarZzq = zzq();
        boolean z = zzxiVarZzq != null && zzxiVarZzq.equals(null);
        zzael zzaelVar = new zzael(this, zzxiVarZzq, z);
        this.zzh = zzaelVar;
        if (zzxiVarZzq == null || zzaelVar.zzd > 0) {
            zzajg zzajgVar = this.zzp;
            zzaab zzaabVar = this.zzc;
            zzwd zzwdVar2 = this.zzj;
            zzxe zzxeVar = this.zzg;
            if (zzajgVar.zzb.zzad) {
                zzakx zzakxVar2 = (zzakx) zzwdVar2.zzl(zzwbVar);
                zzajeVar = new zzaje(zzajgVar, zzaabVar, zzzvVar, zzwdVar2, zzakxVar2 == null ? null : zzakxVar2.zzf, zzakxVar2 != null ? zzakxVar2.zzg : null, zzxeVar);
            } else {
                zzwq[] zzwqVarArrZzh = zzahv.zzh(zzwdVar2, zzzvVar, 0, false);
                zzxe zzxeVarZza = zzxeVar.zza();
                try {
                    zzajeVar = zzajgVar.zzb.zzL.zzd(zzaabVar, zzzvVar, zzwdVar2, zzwqVarArrZzh);
                } finally {
                    zzxeVar.zze(zzxeVarZza);
                }
            }
            this.zzk = zzajeVar;
        } else {
            zzwq[] zzwqVarArrZzh2 = zzahv.zzh(this.zzj, zzzvVar, 0, false);
            String str = true != z ? "CallOptions" : AuthenticationConstants.Broker.CHALLENGE_RESPONSE_CONTEXT;
            Long l2 = (Long) this.zzj.zzl(zzwq.zza);
            double d = this.zzh.zzd;
            double d2 = zzb;
            this.zzk = new zzahf(zzabd.zzd.zze(String.format("ClientCall started after %s deadline was exceeded %.9f seconds ago. Name resolution delay %.9f seconds.", str, Double.valueOf(d / d2), Double.valueOf(l2 == null ? 0.0d : l2.longValue() / d2))), zzaet.PROCESSED, zzwqVarArrZzh2);
        }
        if (this.zze) {
            this.zzk.zze();
        }
        if (this.zzj.zzj() != null) {
            this.zzk.zzj(this.zzj.zzj().intValue());
        }
        if (this.zzj.zzk() != null) {
            this.zzk.zzk(this.zzj.zzk().intValue());
        }
        if (zzxiVarZzq != null) {
            this.zzk.zzh(zzxiVarZzq);
        }
        this.zzk.zzg(zzwuVar);
        this.zzk.zzi(this.zzo);
        this.zzf.zzb();
        this.zzk.zzl(new zzaeq(this, zzwhVar));
        this.zzh.zzc();
    }

    public final zzaer zzm(zzxl zzxlVar) {
        this.zzo = zzxlVar;
        return this;
    }
}
