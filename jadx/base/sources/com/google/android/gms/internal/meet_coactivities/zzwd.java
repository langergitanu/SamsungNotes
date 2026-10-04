package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@CheckReturnValue
@Immutable
public final class zzwd {
    public static final zzwd zza;

    @Nullable
    private final zzxi zzb;

    @Nullable
    private final Executor zzc;
    private final Object[][] zzd;
    private final List zze;

    @Nullable
    private final Boolean zzf;

    @Nullable
    private final Integer zzg;

    @Nullable
    private final Integer zzh;

    static {
        zzwa zzwaVar = new zzwa();
        zzwaVar.zzc = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        zzwaVar.zzd = Collections.EMPTY_LIST;
        zza = new zzwd(zzwaVar, null);
    }

    public /* synthetic */ zzwd(zzwa zzwaVar, zzwc zzwcVar) {
        this.zzb = zzwaVar.zza;
        this.zzc = zzwaVar.zzb;
        this.zzd = zzwaVar.zzc;
        this.zze = zzwaVar.zzd;
        this.zzf = zzwaVar.zze;
        this.zzg = zzwaVar.zzf;
        this.zzh = zzwaVar.zzg;
    }

    private static zzwa zzp(zzwd zzwdVar) {
        zzwa zzwaVar = new zzwa();
        zzwaVar.zza = zzwdVar.zzb;
        zzwaVar.zzb = zzwdVar.zzc;
        zzwaVar.zzc = zzwdVar.zzd;
        zzwaVar.zzd = zzwdVar.zze;
        zzwaVar.zze = zzwdVar.zzf;
        zzwaVar.zzf = zzwdVar.zzg;
        zzwaVar.zzg = zzwdVar.zzh;
        return zzwaVar;
    }

    public final String toString() {
        MoreObjects.ToStringHelper toStringHelperAdd = MoreObjects.toStringHelper(this).add("deadline", this.zzb).add("authority", (Object) null).add("callCredentials", (Object) null);
        Executor executor = this.zzc;
        return toStringHelperAdd.add("executor", executor != null ? executor.getClass() : null).add("compressorName", (Object) null).add("customOptions", Arrays.deepToString(this.zzd)).add("waitForReady", zzo()).add("maxInboundMessageSize", this.zzg).add("maxOutboundMessageSize", this.zzh).add("streamTracerFactories", this.zze).toString();
    }

    public final zzwd zza(@Nullable zzxi zzxiVar) {
        zzwa zzwaVarZzp = zzp(this);
        zzwaVarZzp.zza = zzxiVar;
        return new zzwd(zzwaVarZzp, null);
    }

    public final zzwd zzb(@Nullable Executor executor) {
        zzwa zzwaVarZzp = zzp(this);
        zzwaVarZzp.zzb = executor;
        return new zzwd(zzwaVarZzp, null);
    }

    public final zzwd zzc(int i) {
        Preconditions.checkArgument(i >= 0, "invalid maxsize %s", i);
        zzwa zzwaVarZzp = zzp(this);
        zzwaVarZzp.zzf = Integer.valueOf(i);
        return new zzwd(zzwaVarZzp, null);
    }

    public final zzwd zzd(int i) {
        Preconditions.checkArgument(i >= 0, "invalid maxsize %s", i);
        zzwa zzwaVarZzp = zzp(this);
        zzwaVarZzp.zzg = Integer.valueOf(i);
        return new zzwd(zzwaVarZzp, null);
    }

    public final zzwd zze(zzwb zzwbVar, Object obj) {
        Preconditions.checkNotNull(zzwbVar, "key");
        Preconditions.checkNotNull(obj, "value");
        zzwa zzwaVarZzp = zzp(this);
        int i = 0;
        while (true) {
            Object[][] objArr = this.zzd;
            if (i >= objArr.length) {
                i = -1;
                break;
            }
            if (zzwbVar.equals(objArr[i][0])) {
                break;
            }
            i++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.zzd.length + (i == -1 ? 1 : 0), 2);
        zzwaVarZzp.zzc = objArr2;
        Object[][] objArr3 = this.zzd;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i == -1) {
            zzwaVarZzp.zzc[this.zzd.length] = new Object[]{zzwbVar, obj};
        } else {
            zzwaVarZzp.zzc[i] = new Object[]{zzwbVar, obj};
        }
        return new zzwd(zzwaVarZzp, null);
    }

    public final zzwd zzf(zzwn zzwnVar) {
        ArrayList arrayList = new ArrayList(this.zze.size() + 1);
        arrayList.addAll(this.zze);
        arrayList.add(zzwnVar);
        zzwa zzwaVarZzp = zzp(this);
        zzwaVarZzp.zzd = Collections.unmodifiableList(arrayList);
        return new zzwd(zzwaVarZzp, null);
    }

    public final zzwd zzg() {
        zzwa zzwaVarZzp = zzp(this);
        zzwaVarZzp.zze = Boolean.TRUE;
        return new zzwd(zzwaVarZzp, null);
    }

    public final zzwd zzh() {
        zzwa zzwaVarZzp = zzp(this);
        zzwaVarZzp.zze = Boolean.FALSE;
        return new zzwd(zzwaVarZzp, null);
    }

    @Nullable
    public final zzxi zzi() {
        return this.zzb;
    }

    @Nullable
    public final Integer zzj() {
        return this.zzg;
    }

    @Nullable
    public final Integer zzk() {
        return this.zzh;
    }

    public final Object zzl(zzwb zzwbVar) {
        Preconditions.checkNotNull(zzwbVar, "key");
        int i = 0;
        while (true) {
            Object[][] objArr = this.zzd;
            if (i >= objArr.length) {
                zzwb.zzb(zzwbVar);
                return null;
            }
            if (zzwbVar.equals(objArr[i][0])) {
                return this.zzd[i][1];
            }
            i++;
        }
    }

    public final List zzm() {
        return this.zze;
    }

    @Nullable
    public final Executor zzn() {
        return this.zzc;
    }

    public final boolean zzo() {
        return Boolean.TRUE.equals(this.zzf);
    }
}
