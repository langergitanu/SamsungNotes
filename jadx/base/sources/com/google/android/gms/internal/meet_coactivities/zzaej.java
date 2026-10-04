package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.text.MessageFormat;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaej extends zzwg {
    private final zzaek zza;

    public zzaej(zzaek zzaekVar, zzaow zzaowVar) {
        this.zza = (zzaek) Preconditions.checkNotNull(zzaekVar, "tracer");
    }

    public static void zzc(zzyi zzyiVar, int i, String str) {
        Level levelZze = zze(i);
        if (zzaek.zza.isLoggable(levelZze)) {
            zzaek.zzb(zzyiVar, levelZze, str);
        }
    }

    public static void zzd(zzyi zzyiVar, int i, String str, Object... objArr) {
        Level levelZze = zze(2);
        if (zzaek.zza.isLoggable(levelZze)) {
            zzaek.zzb(zzyiVar, levelZze, MessageFormat.format(str, objArr));
        }
    }

    private static Level zze(int i) {
        int i2 = i - 1;
        return i2 != 1 ? (i2 == 2 || i2 == 3) ? Level.FINE : Level.FINEST : Level.FINER;
    }

    private final boolean zzf(int i) {
        if (i == 1) {
            return false;
        }
        this.zza.zzd();
        return false;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwg
    public final void zza(int i, String str) {
        zzc(this.zza.zza(), i, str);
        zzf(i);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzwg
    public final void zzb(int i, String str, Object... objArr) {
        Level levelZze = zze(i);
        zzf(i);
        zza(i, zzaek.zza.isLoggable(levelZze) ? MessageFormat.format(str, objArr) : null);
    }
}
