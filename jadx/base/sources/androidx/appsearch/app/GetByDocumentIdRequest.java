package androidx.appsearch.app;

import android.os.Bundle;
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
import androidx.appsearch.util.BundleUtil;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "GetByDocumentIdRequestCreator")
public final class GetByDocumentIdRequest extends AbstractSafeParcelable {

    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<GetByDocumentIdRequest> CREATOR = new StubCreators.GetByDocumentIdRequestCreator();
    public static final String PROJECTION_SCHEMA_TYPE_WILDCARD = "*";

    @AbstractSafeParcelable.Field(m1109id = 2)
    final List<String> mIds;
    private Set<String> mIdsCached;

    @AbstractSafeParcelable.Field(getter = "getNamespace", m1109id = 1)
    private final String mNamespace;

    @AbstractSafeParcelable.Field(m1109id = 3)
    final Bundle mTypePropertyPaths;

    @AbstractSafeParcelable.Constructor
    public GetByDocumentIdRequest(@AbstractSafeParcelable.Param(m1110id = 1) String str, @AbstractSafeParcelable.Param(m1110id = 2) List<String> list, @AbstractSafeParcelable.Param(m1110id = 3) Bundle bundle) {
        Objects.requireNonNull(str);
        this.mNamespace = str;
        Objects.requireNonNull(list);
        this.mIds = list;
        Objects.requireNonNull(bundle);
        this.mTypePropertyPaths = bundle;
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

    public Map<String, List<PropertyPath>> getProjectionPaths() {
        Set<String> setKeySet = this.mTypePropertyPaths.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            ArrayList<String> stringArrayList = this.mTypePropertyPaths.getStringArrayList(str);
            if (stringArrayList != null) {
                int size = stringArrayList.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    arrayList.add(new PropertyPath(stringArrayList.get(i)));
                }
                arrayMap.put(str, Collections.unmodifiableList(arrayList));
            }
        }
        return arrayMap;
    }

    public Map<String, List<String>> getProjections() {
        Set<String> setKeySet = this.mTypePropertyPaths.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            ArrayList<String> stringArrayList = this.mTypePropertyPaths.getStringArrayList(str);
            if (stringArrayList != null) {
                arrayMap.put(str, Collections.unmodifiableList(stringArrayList));
            }
        }
        return arrayMap;
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
        private List<String> mIds = new ArrayList();
        private Bundle mProjectionTypePropertyPaths = new Bundle();
        private boolean mBuilt = false;

        public Builder(String str) {
            this.mNamespace = (String) Preconditions.checkNotNull(str);
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mIds = new ArrayList(this.mIds);
                this.mProjectionTypePropertyPaths = BundleUtil.deepCopy(this.mProjectionTypePropertyPaths);
                this.mBuilt = false;
            }
        }

        @CanIgnoreReturnValue
        public Builder addIds(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addIds(Arrays.asList(strArr));
        }

        @CanIgnoreReturnValue
        public Builder addProjection(String str, Collection<String> collection) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList<String> arrayList = new ArrayList<>(collection.size());
            for (String str2 : collection) {
                Preconditions.checkNotNull(str2);
                arrayList.add(str2);
            }
            this.mProjectionTypePropertyPaths.putStringArrayList(str, arrayList);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addProjectionPaths(String str, Collection<PropertyPath> collection) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(collection);
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<PropertyPath> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
            return addProjection(str, arrayList);
        }

        public GetByDocumentIdRequest build() {
            this.mBuilt = true;
            return new GetByDocumentIdRequest(this.mNamespace, this.mIds, this.mProjectionTypePropertyPaths);
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
