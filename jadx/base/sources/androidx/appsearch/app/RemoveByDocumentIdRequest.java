package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "RemoveByDocumentIdRequestCreator")
public final class RemoveByDocumentIdRequest extends AbstractSafeParcelable {

    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<RemoveByDocumentIdRequest> CREATOR = new StubCreators.RemoveByDocumentIdRequestCreator();

    @AbstractSafeParcelable.Field(m1109id = 2)
    final List<String> mIds;
    private Set<String> mIdsCached;

    @AbstractSafeParcelable.Field(getter = "getNamespace", m1109id = 1)
    private final String mNamespace;

    @AbstractSafeParcelable.Constructor
    public RemoveByDocumentIdRequest(@AbstractSafeParcelable.Param(m1110id = 1) String str, @AbstractSafeParcelable.Param(m1110id = 2) List<String> list) {
        Objects.requireNonNull(str);
        this.mNamespace = str;
        Objects.requireNonNull(list);
        this.mIds = list;
    }

    public Set<String> getIds() {
        if (this.mIdsCached == null) {
            this.mIdsCached = Collections.unmodifiableSet(new ArraySet(this.mIds));
        }
        return this.mIdsCached;
    }

    public String getNamespace() {
        return this.mNamespace;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private final String mNamespace;
        private ArraySet<String> mIds = new ArraySet<>();
        private boolean mBuilt = false;

        public Builder(String str) {
            this.mNamespace = (String) Preconditions.checkNotNull(str);
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mIds = new ArraySet<>((ArraySet) this.mIds);
                this.mBuilt = false;
            }
        }

        @CanIgnoreReturnValue
        public Builder addIds(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addIds(Arrays.asList(strArr));
        }

        public RemoveByDocumentIdRequest build() {
            this.mBuilt = true;
            return new RemoveByDocumentIdRequest(this.mNamespace, new ArrayList(this.mIds));
        }

        @CanIgnoreReturnValue
        public Builder addIds(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mIds.addAll(collection);
            return this;
        }
    }
}
