package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.drive.query.internal.zzt;
import com.google.android.gms.drive.query.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "QueryCreator")
@SafeParcelable.Reserved({1000})
public class Query extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Query> CREATOR = new zzb();

    @SafeParcelable.Field(m3227id = 7)
    private final List<DriveSpace> zzby;

    @SafeParcelable.Field(m3227id = 1)
    private final zzr zzlm;

    @SafeParcelable.Field(m3227id = 3)
    private final String zzln;

    @Nullable
    @SafeParcelable.Field(m3227id = 4)
    private final SortOrder zzlo;

    @SafeParcelable.Field(m3227id = 5)
    final List<String> zzlp;

    @SafeParcelable.Field(m3227id = 6)
    final boolean zzlq;

    @SafeParcelable.Field(m3227id = 8)
    final boolean zzlr;

    private Query(zzr zzrVar, String str, SortOrder sortOrder, @NonNull List<String> list, boolean z, @NonNull Set<DriveSpace> set, boolean z2) {
        this(zzrVar, str, sortOrder, list, z, new ArrayList(set), z2);
    }

    public Filter getFilter() {
        return this.zzlm;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzln;
    }

    @Nullable
    public SortOrder getSortOrder() {
        return this.zzlo;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", this.zzlm, this.zzlo, this.zzln, this.zzby);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzlm, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzln, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzlo, i, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzlp, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzlq);
        SafeParcelWriter.writeTypedList(parcel, 7, this.zzby, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzlr);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @ShowFirstParty
    public final Set<DriveSpace> zzbi() {
        return this.zzby == null ? new HashSet() : new HashSet(this.zzby);
    }

    @SafeParcelable.Constructor
    public Query(@SafeParcelable.Param(m3228id = 1) zzr zzrVar, @SafeParcelable.Param(m3228id = 3) String str, @Nullable @SafeParcelable.Param(m3228id = 4) SortOrder sortOrder, @NonNull @SafeParcelable.Param(m3228id = 5) List<String> list, @SafeParcelable.Param(m3228id = 6) boolean z, @NonNull @SafeParcelable.Param(m3228id = 7) List<DriveSpace> list2, @SafeParcelable.Param(m3228id = 8) boolean z2) {
        this.zzlm = zzrVar;
        this.zzln = str;
        this.zzlo = sortOrder;
        this.zzlp = list;
        this.zzlq = z;
        this.zzby = list2;
        this.zzlr = z2;
    }

    @VisibleForTesting
    public static class Builder {
        private String zzln;
        private SortOrder zzlo;
        private List<String> zzlp;
        private boolean zzlq;
        private boolean zzlr;
        private final List<Filter> zzls;
        private Set<DriveSpace> zzlt;

        public Builder() {
            this.zzls = new ArrayList();
            this.zzlp = Collections.EMPTY_LIST;
            this.zzlt = Collections.EMPTY_SET;
        }

        public Builder addFilter(@NonNull Filter filter) {
            Preconditions.checkNotNull(filter, "Filter may not be null.");
            if (!(filter instanceof zzt)) {
                this.zzls.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new zzr(zzx.zzmv, this.zzls), this.zzln, this.zzlo, this.zzlp, this.zzlq, this.zzlt, this.zzlr);
        }

        @Deprecated
        public Builder setPageToken(String str) {
            this.zzln = str;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzlo = sortOrder;
            return this;
        }

        public Builder(Query query) {
            ArrayList arrayList = new ArrayList();
            this.zzls = arrayList;
            this.zzlp = Collections.EMPTY_LIST;
            this.zzlt = Collections.EMPTY_SET;
            arrayList.add(query.getFilter());
            this.zzln = query.getPageToken();
            this.zzlo = query.getSortOrder();
            this.zzlp = query.zzlp;
            this.zzlq = query.zzlq;
            query.zzbi();
            this.zzlt = query.zzbi();
            this.zzlr = query.zzlr;
        }
    }
}
