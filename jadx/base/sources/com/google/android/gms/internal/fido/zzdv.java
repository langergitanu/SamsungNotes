package com.google.android.gms.internal.fido;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzdv {
    private final Deque zza = new ArrayDeque(16);

    private zzdv(boolean z) {
    }

    public static zzdv zza() {
        return new zzdv(false);
    }

    private final long zzh() {
        if (this.zza.isEmpty()) {
            return 0L;
        }
        return ((Long) this.zza.peek()).longValue();
    }

    private final void zzi(long j) {
        this.zza.pop();
        this.zza.push(Long.valueOf(j));
    }

    public final void zzb() throws IOException {
        if (this.zza.isEmpty()) {
            return;
        }
        throw new IOException("data item not completed, stackSize: " + this.zza.size() + " scope: " + zzh());
    }

    public final void zzc() throws IOException {
        long jZzh = zzh();
        if (jZzh >= 0) {
            throw new IOException(AbstractC0622a.m1169o("expected indefinite length scope but found ", jZzh));
        }
        if (jZzh == -5) {
            throw new IOException("expected a value for dangling key in indefinite-length map");
        }
        this.zza.pop();
    }

    public final void zzd() throws IOException {
        long jZzh = zzh();
        if (jZzh != -1) {
            if (jZzh != -2) {
                return;
            } else {
                jZzh = -2;
            }
        }
        throw new IOException(AbstractC0622a.m1169o("expected non-string scope but found ", jZzh));
    }

    public final void zze(long j) throws IOException {
        long jZzh = zzh();
        if (jZzh != j) {
            if (jZzh != -1) {
                if (jZzh != -2) {
                    return;
                } else {
                    jZzh = -2;
                }
            }
            StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "expected non-string scope or scope ", " but found ");
            sbM1323p.append(jZzh);
            throw new IOException(sbM1323p.toString());
        }
    }

    public final void zzf() {
        long jZzh = zzh();
        if (jZzh == 1) {
            this.zza.pop();
            return;
        }
        if (jZzh > 1) {
            zzi(jZzh - 1);
        } else if (jZzh == -4) {
            zzi(-5L);
        } else if (jZzh == -5) {
            zzi(-4L);
        }
    }

    public final void zzg(long j) {
        this.zza.push(Long.valueOf(j));
    }
}
