package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaak {
    private final List zza;
    private final zzvy zzb;

    @Nullable
    private final zzaag zzc;

    public zzaak(List list, zzvy zzvyVar, zzaag zzaagVar) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        this.zzb = (zzvy) Preconditions.checkNotNull(zzvyVar, NativeAuthConstants.GrantType.ATTRIBUTES);
        this.zzc = zzaagVar;
    }

    public static zzaaj zzc() {
        return new zzaaj();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaak)) {
            return false;
        }
        zzaak zzaakVar = (zzaak) obj;
        return Objects.equal(this.zza, zzaakVar.zza) && Objects.equal(this.zzb, zzaakVar.zzb) && Objects.equal(this.zzc, zzaakVar.zzc);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("addresses", this.zza).add(NativeAuthConstants.GrantType.ATTRIBUTES, this.zzb).add("serviceConfig", this.zzc).toString();
    }

    public final zzvy zza() {
        return this.zzb;
    }

    @Nullable
    public final zzaag zzb() {
        return this.zzc;
    }

    public final zzaaj zzd() {
        zzaaj zzaajVar = new zzaaj();
        zzaajVar.zza(this.zza);
        zzaajVar.zzb(this.zzb);
        zzaajVar.zzc(this.zzc);
        return zzaajVar;
    }

    public final List zze() {
        return this.zza;
    }
}
