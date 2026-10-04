package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyi {
    private static final AtomicLong zza = new AtomicLong();
    private final String zzb;

    @Nullable
    private final String zzc;
    private final long zzd;

    public zzyi(String str, String str2, long j) {
        Preconditions.checkNotNull(str, "typeName");
        Preconditions.checkArgument(!str.isEmpty(), "empty type");
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j;
    }

    public static zzyi zzb(Class cls, @Nullable String str) {
        String simpleName = ((Class) Preconditions.checkNotNull(cls, "type")).getSimpleName();
        if (simpleName.isEmpty()) {
            simpleName = cls.getName().substring(cls.getPackage().getName().length() + 1);
        }
        return zzc(simpleName, str);
    }

    public static zzyi zzc(String str, @Nullable String str2) {
        return new zzyi(str, str2, zza.incrementAndGet());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb + "<" + this.zzd + ">");
        if (this.zzc != null) {
            sb.append(": (");
            sb.append(this.zzc);
            sb.append(PropertyUtils.MAPPED_DELIM2);
        }
        return sb.toString();
    }

    public final long zza() {
        return this.zzd;
    }
}
