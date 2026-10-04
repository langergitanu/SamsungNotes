package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "UvmEntriesCreator")
public class UvmEntries extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<UvmEntries> CREATOR = new zzaz();

    @Nullable
    @SafeParcelable.Field(getter = "getUvmEntryList", m3227id = 1)
    private final List zza;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private final List zza = new ArrayList();

        @NonNull
        public Builder addAll(@NonNull List<UvmEntry> list) {
            com.google.android.gms.internal.fido.zzap.zzc(list.size() + this.zza.size() <= 3);
            this.zza.addAll(list);
            return this;
        }

        @NonNull
        public Builder addUvmEntry(@Nullable UvmEntry uvmEntry) {
            if (this.zza.size() >= 3) {
                throw new IllegalStateException();
            }
            this.zza.add(uvmEntry);
            return this;
        }

        @NonNull
        public UvmEntries build() {
            return new UvmEntries(this.zza);
        }
    }

    @SafeParcelable.Constructor
    public UvmEntries(@Nullable @SafeParcelable.Param(m3228id = 1) List list) {
        this.zza = list;
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        if (!(obj instanceof UvmEntries)) {
            return false;
        }
        UvmEntries uvmEntries = (UvmEntries) obj;
        List list2 = this.zza;
        if (list2 == null && uvmEntries.zza == null) {
            return true;
        }
        return list2 != null && (list = uvmEntries.zza) != null && list2.containsAll(list) && uvmEntries.zza.containsAll(this.zza);
    }

    @Nullable
    public List<UvmEntry> getUvmEntryList() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(new HashSet(this.zza));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getUvmEntryList(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @NonNull
    public final JSONArray zza() {
        try {
            JSONArray jSONArray = new JSONArray();
            if (this.zza != null) {
                for (int i = 0; i < this.zza.size(); i++) {
                    UvmEntry uvmEntry = (UvmEntry) this.zza.get(i);
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put((int) uvmEntry.getMatcherProtectionType());
                    jSONArray2.put((int) uvmEntry.getKeyProtectionType());
                    jSONArray2.put((int) uvmEntry.getMatcherProtectionType());
                    jSONArray.put(i, jSONArray2);
                }
            }
            return jSONArray;
        } catch (JSONException e) {
            throw new RuntimeException("Error encoding UvmEntries to JSON object", e);
        }
    }
}
