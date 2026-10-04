package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class zzaab {
    private final zzzz zza;
    private final String zzb;

    @Nullable
    private final String zzc;
    private final zzzy zzd;
    private final zzzy zze;
    private final boolean zzf;

    public /* synthetic */ zzaab(zzzz zzzzVar, String str, zzzy zzzyVar, zzzy zzzyVar2, Object obj, boolean z, boolean z2, boolean z3, zzaaa zzaaaVar) {
        new AtomicReferenceArray(2);
        this.zza = (zzzz) Preconditions.checkNotNull(zzzzVar, "type");
        this.zzb = (String) Preconditions.checkNotNull(str, "fullMethodName");
        int iLastIndexOf = ((String) Preconditions.checkNotNull(str, "fullMethodName")).lastIndexOf(47);
        this.zzc = iLastIndexOf == -1 ? null : str.substring(0, iLastIndexOf);
        this.zzd = (zzzy) Preconditions.checkNotNull(zzzyVar, "requestMarshaller");
        this.zze = (zzzy) Preconditions.checkNotNull(zzzyVar2, "responseMarshaller");
        this.zzf = z3;
    }

    @CheckReturnValue
    public static zzzx zza(zzzy zzzyVar, zzzy zzzyVar2) {
        zzzx zzzxVar = new zzzx(null);
        zzzxVar.zzb(null);
        zzzxVar.zzc(null);
        return zzzxVar;
    }

    public static String zze(String str, String str2) {
        return AbstractC0541b.m757C((String) Preconditions.checkNotNull(str, "fullServiceName"), "/", (String) Preconditions.checkNotNull(str2, "methodName"));
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("fullMethodName", this.zzb).add("type", this.zza).add("idempotent", false).add("safe", false).add("sampledToLocalTracing", this.zzf).add("requestMarshaller", this.zzd).add("responseMarshaller", this.zze).add("schemaDescriptor", (Object) null).omitNullValues().toString();
    }

    public final zzzz zzb() {
        return this.zza;
    }

    public final InputStream zzc(Object obj) {
        return this.zzd.zza(obj);
    }

    public final Object zzd(InputStream inputStream) {
        return this.zze.zzb(inputStream);
    }

    public final String zzf() {
        return this.zzb;
    }

    @Nullable
    public final String zzg() {
        return this.zzc;
    }
}
