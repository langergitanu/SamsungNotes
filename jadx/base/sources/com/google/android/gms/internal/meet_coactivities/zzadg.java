package com.google.android.gms.internal.meet_coactivities;

import android.os.Parcel;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzadg implements Closeable {

    @Nullable
    private Parcel zza;

    public zzadg(Parcel parcel) {
        this.zza = parcel;
    }

    public static zzadg zzc() {
        return new zzadg(Parcel.obtain());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Parcel parcel = this.zza;
        if (parcel != null) {
            parcel.recycle();
            this.zza = null;
        }
    }

    public final Parcel zza() {
        Preconditions.checkState(this.zza != null, "get() after close()/release()");
        return this.zza;
    }

    public final Parcel zzb() {
        Parcel parcelZza = zza();
        this.zza = null;
        return parcelZza;
    }
}
