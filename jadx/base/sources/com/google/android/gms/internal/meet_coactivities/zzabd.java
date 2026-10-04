package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@CheckReturnValue
@Immutable
public final class zzabd {
    public static final zzabd zza;
    public static final zzabd zzb;
    public static final zzabd zzc;
    public static final zzabd zzd;
    public static final zzabd zze;
    public static final zzabd zzf;
    public static final zzabd zzg;
    public static final zzabd zzh;
    public static final zzabd zzi;
    public static final zzabd zzj;
    public static final zzabd zzk;
    private static final List zzl;
    private static final zzzu zzm;
    private final zzaay zzn;
    private final String zzo;
    private final Throwable zzp;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        TreeMap treeMap = new TreeMap();
        zzaay[] zzaayVarArrValues = zzaay.values();
        int length = zzaayVarArrValues.length;
        boolean z = false;
        int i = 0;
        while (true) {
            zzaaz zzaazVar = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            if (i >= length) {
                zzl = Collections.unmodifiableList(new ArrayList(treeMap.values()));
                zza = zzaay.OK.zzb();
                zzb = zzaay.CANCELLED.zzb();
                zzc = zzaay.UNKNOWN.zzb();
                zzaay.INVALID_ARGUMENT.zzb();
                zzd = zzaay.DEADLINE_EXCEEDED.zzb();
                zzaay.NOT_FOUND.zzb();
                zzaay.ALREADY_EXISTS.zzb();
                zze = zzaay.PERMISSION_DENIED.zzb();
                zzf = zzaay.UNAUTHENTICATED.zzb();
                zzg = zzaay.RESOURCE_EXHAUSTED.zzb();
                zzh = zzaay.FAILED_PRECONDITION.zzb();
                zzaay.ABORTED.zzb();
                zzaay.OUT_OF_RANGE.zzb();
                zzi = zzaay.UNIMPLEMENTED.zzb();
                zzj = zzaay.INTERNAL.zzb();
                zzk = zzaay.UNAVAILABLE.zzb();
                zzaay.DATA_LOSS.zzb();
                new zzzt("grpc-status", z, new zzaba(zzaazVar), objArr3 == true ? 1 : 0);
                zzabc zzabcVar = new zzabc(objArr2 == true ? 1 : 0);
                zzm = zzabcVar;
                new zzzt("grpc-message", z, zzabcVar, objArr == true ? 1 : 0);
                return;
            }
            zzaay zzaayVar = zzaayVarArrValues[i];
            zzabd zzabdVar = (zzabd) treeMap.put(Integer.valueOf(zzaayVar.zza()), new zzabd(zzaayVar, null, null));
            if (zzabdVar != null) {
                throw new IllegalStateException(AbstractC0541b.m774p("Code value duplication between ", zzabdVar.zzn.name(), " & ", zzaayVar.name()));
            }
            i++;
        }
    }

    private zzabd(zzaay zzaayVar, @Nullable String str, @Nullable Throwable th) {
        this.zzn = (zzaay) Preconditions.checkNotNull(zzaayVar, "code");
        this.zzo = str;
        this.zzp = th;
    }

    public static zzabd zzb(int i) {
        if (i >= 0) {
            List list = zzl;
            if (i < list.size()) {
                return (zzabd) list.get(i);
            }
        }
        return zzc.zze("Unknown code " + i);
    }

    public static zzabd zzc(Throwable th) {
        for (Throwable cause = (Throwable) Preconditions.checkNotNull(th, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof zzabe) {
                return ((zzabe) cause).zza();
            }
            if (cause instanceof zzabf) {
                return ((zzabf) cause).zza();
            }
        }
        return zzc.zzd(th);
    }

    public static String zzf(zzabd zzabdVar) {
        String str = zzabdVar.zzo;
        zzaay zzaayVar = zzabdVar.zzn;
        return str == null ? zzaayVar.toString() : AbstractC0541b.m757C(String.valueOf(zzaayVar), ": ", str);
    }

    public final String toString() {
        MoreObjects.ToStringHelper toStringHelperAdd = MoreObjects.toStringHelper(this).add("code", this.zzn.name()).add("description", this.zzo);
        Throwable th = this.zzp;
        Object stackTraceAsString = th;
        if (th != null) {
            stackTraceAsString = Throwables.getStackTraceAsString(th);
        }
        return toStringHelperAdd.add("cause", stackTraceAsString).toString();
    }

    public final zzaay zza() {
        return this.zzn;
    }

    public final zzabd zzd(Throwable th) {
        return Objects.equal(this.zzp, th) ? this : new zzabd(this.zzn, this.zzo, th);
    }

    public final zzabd zze(String str) {
        return Objects.equal(this.zzo, str) ? this : new zzabd(this.zzn, str, this.zzp);
    }

    @Nullable
    public final String zzg() {
        return this.zzo;
    }

    @Nullable
    public final Throwable zzh() {
        return this.zzp;
    }

    public final boolean zzj() {
        return zzaay.OK == this.zzn;
    }
}
