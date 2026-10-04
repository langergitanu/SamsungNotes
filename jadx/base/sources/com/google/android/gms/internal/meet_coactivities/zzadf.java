package com.google.android.gms.internal.meet_coactivities;

import android.os.Parcel;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzadf {
    private final zzacl zza;
    private final int zzb;
    private final zzaor zzc;
    private boolean zzd;

    @Nullable
    private InputStream zze;

    @Nullable
    private Queue zzf;
    private boolean zzg;

    @GuardedBy("this")
    private int zzh;
    private int zzi;
    private int zzj;

    @GuardedBy("this")
    private int zzk = 1;

    public /* synthetic */ zzadf(zzacl zzaclVar, int i, zzaor zzaorVar, zzade zzadeVar) {
        this.zza = zzaclVar;
        this.zzb = i;
        this.zzc = zzaorVar;
    }

    @GuardedBy("this")
    private final void zzb(int i) {
        int i2 = this.zzk;
        int i4 = i - 1;
        if (i4 == 1) {
            Preconditions.checkState(i2 == 1);
        } else if (i4 == 2) {
            Preconditions.checkState(i2 == 2);
        } else if (i4 == 3) {
            Preconditions.checkState(i2 == 3);
        }
        this.zzk = i;
    }

    public final synchronized String toString() {
        String simpleName;
        int i;
        try {
            simpleName = getClass().getSimpleName();
            i = this.zzk;
        } catch (Throwable th) {
            throw th;
        }
        return simpleName + "[S=" + (i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "CLOSED" : "SUFFIX_SENT" : "ALL_MESSAGES_SENT" : "PREFIX_SENT" : "INITIAL") + "/NDM=" + this.zzi + "]";
    }

    @GuardedBy("this")
    public abstract int zza(Parcel parcel);

    public final zzaor zzc() {
        return this.zzc;
    }

    @GuardedBy("this")
    public final void zzd(InputStream inputStream) {
        this.zzd = true;
        Queue queue = this.zzf;
        if (queue != null) {
            queue.add(inputStream);
        } else {
            if (this.zze == null) {
                this.zze = inputStream;
                return;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            this.zzf = concurrentLinkedQueue;
            concurrentLinkedQueue.add(inputStream);
        }
    }

    @GuardedBy("this")
    public final void zze() {
        this.zzd = true;
    }

    @GuardedBy("this")
    public final void zzf() {
        this.zzg = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00c0 A[Catch: all -> 0x005c, TryCatch #3 {all -> 0x005c, blocks: (B:22:0x0033, B:75:0x0105, B:77:0x0110, B:28:0x0056, B:29:0x005b, B:38:0x007a, B:40:0x007e, B:46:0x008f, B:48:0x0099, B:58:0x00bb, B:60:0x00c0, B:62:0x00cb, B:63:0x00d6, B:64:0x00e6, B:70:0x00f7, B:72:0x00fb, B:74:0x0101, B:65:0x00ea, B:66:0x00ed, B:67:0x00ee, B:68:0x00f0, B:69:0x00f1, B:41:0x0081, B:43:0x0085, B:33:0x0062, B:35:0x0074, B:84:0x013a, B:49:0x009d, B:51:0x00a3, B:55:0x00ab), top: B:101:0x0033, inners: #2 }] */
    @GuardedBy("this")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzg() throws zzabe {
        int iZza;
        InputStream inputStream;
        int i;
        while (true) {
            int i2 = this.zzk;
            int i4 = i2 - 1;
            if (i2 == 0) {
                throw null;
            }
            boolean z = true;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2 || !this.zzg) {
                        return;
                    }
                } else if (!zzi() && !this.zzg) {
                    return;
                }
            } else if (!this.zzd) {
                return;
            }
            if (!this.zza.zzv()) {
                return;
            }
            try {
                try {
                    zzadg zzadgVarZzc = zzadg.zzc();
                    try {
                        int i5 = 0;
                        zzadgVarZzc.zza().writeInt(0);
                        Parcel parcelZza = zzadgVarZzc.zza();
                        int i6 = this.zzh;
                        this.zzh = i6 + 1;
                        parcelZza.writeInt(i6);
                        int i7 = this.zzk;
                        int i8 = i7 - 1;
                        if (i7 == 0) {
                            throw null;
                        }
                        if (i8 == 0) {
                            iZza = zza(zzadgVarZzc.zza()) | 1;
                            zzb(2);
                            if (zzi() || this.zzg) {
                            }
                            zzado.zzb(zzadgVarZzc.zza(), iZza);
                            int iDataSize = zzadgVarZzc.zza().dataSize();
                            this.zza.zzr(this.zzb, zzadgVarZzc);
                            long j = iDataSize;
                            this.zzc.zzl(j);
                            this.zzc.zzk(j);
                            zzadgVarZzc.close();
                        } else if (i8 == 1) {
                            iZza = 0;
                        } else {
                            if (i8 != 2) {
                                throw new AssertionError();
                            }
                            zzadgVarZzc.zza();
                            iZza = i5 | 4;
                            zzb(4);
                            zzado.zzb(zzadgVarZzc.zza(), iZza);
                            int iDataSize2 = zzadgVarZzc.zza().dataSize();
                            this.zza.zzr(this.zzb, zzadgVarZzc);
                            long j2 = iDataSize2;
                            this.zzc.zzl(j2);
                            this.zzc.zzk(j2);
                            zzadgVarZzc.close();
                        }
                        if (this.zzi == 0) {
                            inputStream = this.zze;
                        } else {
                            Queue queue = this.zzf;
                            inputStream = queue != null ? (InputStream) queue.peek() : null;
                        }
                        if (inputStream != null) {
                            int i9 = iZza | 2;
                            Parcel parcelZza2 = zzadgVarZzc.zza();
                            if (inputStream instanceof zzadh) {
                                throw null;
                            }
                            byte[] bArrZzb = zzacn.zzb();
                            try {
                                int i10 = inputStream.read(bArrZzb);
                                if (i10 <= 0) {
                                    parcelZza2.writeInt(0);
                                } else {
                                    parcelZza2.writeInt(i10);
                                    parcelZza2.writeByteArray(bArrZzb, 0, i10);
                                    this.zzj += i10;
                                    if (i10 == bArrZzb.length) {
                                        i = 128;
                                    }
                                    if (!z) {
                                        inputStream.close();
                                        int i11 = this.zzi;
                                        this.zzi = i11 + 1;
                                        if (i11 > 0) {
                                            ((Queue) Preconditions.checkNotNull(this.zzf)).poll();
                                        }
                                        this.zzc.zzi(i11);
                                        zzaor zzaorVar = this.zzc;
                                        long j3 = this.zzj;
                                        zzaorVar.zzj(i11, j3, j3);
                                        this.zzj = 0;
                                    }
                                    i5 = i9 | i;
                                }
                                z = false;
                                i = 0;
                                if (!z) {
                                }
                                i5 = i9 | i;
                            } finally {
                                zzacn.zza(bArrZzb);
                            }
                        } else {
                            Preconditions.checkState(this.zzg);
                            i5 = iZza;
                        }
                        if (!this.zzg || zzi()) {
                            iZza = i5;
                            zzado.zzb(zzadgVarZzc.zza(), iZza);
                            int iDataSize22 = zzadgVarZzc.zza().dataSize();
                            this.zza.zzr(this.zzb, zzadgVarZzc);
                            long j22 = iDataSize22;
                            this.zzc.zzl(j22);
                            this.zzc.zzk(j22);
                            zzadgVarZzc.close();
                        } else {
                            zzb(3);
                            zzadgVarZzc.zza();
                            iZza = i5 | 4;
                            zzb(4);
                            zzado.zzb(zzadgVarZzc.zza(), iZza);
                            int iDataSize222 = zzadgVarZzc.zza().dataSize();
                            this.zza.zzr(this.zzb, zzadgVarZzc);
                            long j222 = iDataSize222;
                            this.zzc.zzl(j222);
                            this.zzc.zzk(j222);
                            zzadgVarZzc.close();
                        }
                    } catch (Throwable th) {
                        try {
                            zzadgVarZzc.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } catch (IOException e) {
                    throw new zzabe(zzabd.zzj.zzd(e), null);
                }
            } catch (zzabe e2) {
                zzb(5);
                throw e2;
            }
        }
    }

    public final boolean zzh() {
        return this.zza.zzv();
    }

    @GuardedBy("this")
    public final boolean zzi() {
        Queue queue = this.zzf;
        return queue != null ? !queue.isEmpty() : this.zze != null && this.zzi == 0;
    }
}
