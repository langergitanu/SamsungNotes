package com.google.android.gms.internal.meet_coactivities;

import android.content.ComponentName;
import android.content.Intent;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.base.Preconditions;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabn extends SocketAddress {
    private final Intent zza;

    public zzabn(Intent intent) {
        boolean z = true;
        if (intent.getComponent() == null && intent.getPackage() == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "'bindIntent' must be explicit. Specify either a package or ComponentName.");
        this.zza = intent;
    }

    public static zzabn zzb(ComponentName componentName) {
        return new zzabn(new Intent("grpc.io.action.BIND").setComponent(componentName));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzabn) {
            return this.zza.filterEquals(((zzabn) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        Intent intent = this.zza;
        if (intent.getPackage() != null) {
            intent = intent.cloneFilter().setPackage(null);
        }
        return intent.filterHashCode();
    }

    public final String toString() {
        return AbstractC0541b.m773o("AndroidComponentAddress[", String.valueOf(this.zza), "]");
    }

    public final Intent zza() {
        return this.zza.cloneFilter();
    }

    public final String zzc() {
        return this.zza.getPackage() != null ? this.zza.getPackage() : this.zza.getComponent().getPackageName();
    }
}
