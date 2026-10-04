package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.drive.zzhs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "MetadataBundleCreator")
@SafeParcelable.Reserved({1})
public final class MetadataBundle extends AbstractSafeParcelable implements ReflectedParcelable {

    @SafeParcelable.Field(m3227id = 2)
    private final Bundle zzjh;
    private static final GmsLogger zzbz = new GmsLogger("MetadataBundle", "");
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzj();

    @SafeParcelable.Constructor
    public MetadataBundle(@SafeParcelable.Param(m3228id = 2) Bundle bundle) {
        Bundle bundle2 = (Bundle) Preconditions.checkNotNull(bundle);
        this.zzjh = bundle2;
        bundle2.setClassLoader(MetadataBundle.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        for (String str : bundle2.keySet()) {
            if (zzf.zzf(str) == null) {
                arrayList.add(str);
                zzbz.wfmt("MetadataBundle", "Ignored unknown metadata field in bundle: %s", str);
            }
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            this.zzjh.remove((String) obj);
        }
    }

    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t) {
        MetadataBundle metadataBundleZzbe = zzbe();
        metadataBundleZzbe.zzb(metadataField, t);
        return metadataBundleZzbe;
    }

    public static MetadataBundle zzbe() {
        return new MetadataBundle(new Bundle());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != MetadataBundle.class) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> setKeySet = this.zzjh.keySet();
        if (!setKeySet.equals(metadataBundle.zzjh.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            if (!Objects.equal(this.zzjh.get(str), metadataBundle.zzjh.get(str))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        Iterator<String> it = this.zzjh.keySet().iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + this.zzjh.get(it.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzjh, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final <T> void zzb(MetadataField<T> metadataField, T t) {
        if (zzf.zzf(metadataField.getName()) == null) {
            String strValueOf = String.valueOf(metadataField.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unregistered field: ".concat(strValueOf) : new String("Unregistered field: "));
        }
        metadataField.zza(t, this.zzjh);
    }

    public final MetadataBundle zzbf() {
        return new MetadataBundle(new Bundle(this.zzjh));
    }

    public final Set<MetadataField<?>> zzbg() {
        HashSet hashSet = new HashSet();
        Iterator<String> it = this.zzjh.keySet().iterator();
        while (it.hasNext()) {
            hashSet.add(zzf.zzf(it.next()));
        }
        return hashSet;
    }

    @Nullable
    public final <T> T zzc(MetadataField<T> metadataField) {
        T t = (T) zza(metadataField);
        this.zzjh.remove(metadataField.getName());
        return t;
    }

    public final boolean zzd(MetadataField<?> metadataField) {
        return this.zzjh.containsKey(metadataField.getName());
    }

    @Nullable
    public final <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zza(this.zzjh);
    }

    public final void zza(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zzhs.zzkq);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.setTempDir(context.getCacheDir());
        }
    }
}
