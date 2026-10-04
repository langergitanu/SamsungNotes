package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyz {
    private final List zza;
    private final zzvy zzb;

    @Nullable
    private final Object zzc;

    public /* synthetic */ zzyz(List list, zzvy zzvyVar, Object obj, zzyy zzyyVar) {
        this.zza = Collections.unmodifiableList(new ArrayList((Collection) Preconditions.checkNotNull(list, "addresses")));
        this.zzb = (zzvy) Preconditions.checkNotNull(zzvyVar, NativeAuthConstants.GrantType.ATTRIBUTES);
        this.zzc = obj;
    }

    public static zzyx zzb() {
        return new zzyx();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzyz)) {
            return false;
        }
        zzyz zzyzVar = (zzyz) obj;
        return Objects.equal(this.zza, zzyzVar.zza) && Objects.equal(this.zzb, zzyzVar.zzb) && Objects.equal(this.zzc, zzyzVar.zzc);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("addresses", this.zza).add(NativeAuthConstants.GrantType.ATTRIBUTES, this.zzb).add("loadBalancingPolicyConfig", this.zzc).toString();
    }

    public final zzvy zza() {
        return this.zzb;
    }

    public final zzyx zzc() {
        zzyx zzyxVar = new zzyx();
        zzyxVar.zza(this.zza);
        zzyxVar.zzb(this.zzb);
        zzyxVar.zzc(this.zzc);
        return zzyxVar;
    }

    @Nullable
    public final Object zzd() {
        return this.zzc;
    }

    public final List zze() {
        return this.zza;
    }
}
