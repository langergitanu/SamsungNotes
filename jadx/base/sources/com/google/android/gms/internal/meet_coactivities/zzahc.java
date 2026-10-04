package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import org.apache.commons.text.lookup.StringLookupFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahc extends zzaan {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f2184a = 0;
    private static final boolean zza = zzyl.zza(zzahc.class.getClassLoader());

    @Override // com.google.android.gms.internal.meet_coactivities.zzaah
    public final zzaam zza(URI uri, zzaaf zzaafVar) {
        if (!StringLookupFactory.KEY_DNS.equals(uri.getScheme())) {
            return null;
        }
        String str = (String) Preconditions.checkNotNull(uri.getPath(), "targetPath");
        Preconditions.checkArgument(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new zzahb(uri.getAuthority(), str.substring(1), zzaafVar, zzahv.zzi, Stopwatch.createUnstarted(), zza);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaah
    public final String zzb() {
        return StringLookupFactory.KEY_DNS;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaan
    public final int zzc() {
        return 5;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaan
    public final Collection zzd() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaan
    public final boolean zze() {
        return true;
    }
}
