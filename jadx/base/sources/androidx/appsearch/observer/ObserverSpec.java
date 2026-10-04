package androidx.appsearch.observer;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.app.DocumentClassFactoryRegistry;
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "ObserverSpecCreator")
public final class ObserverSpec extends AbstractSafeParcelable {

    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<ObserverSpec> CREATOR = new StubCreators.ObserverSpecCreator();

    @AbstractSafeParcelable.Field(m1109id = 1)
    final List<String> mFilterSchemas;
    private volatile Set<String> mFilterSchemasCached;

    @AbstractSafeParcelable.Constructor
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ObserverSpec(@AbstractSafeParcelable.Param(m1110id = 1) List<String> list) {
        this.mFilterSchemas = (List) Preconditions.checkNotNull(list);
    }

    public Set<String> getFilterSchemas() {
        if (this.mFilterSchemasCached == null) {
            List<String> list = this.mFilterSchemas;
            if (list == null) {
                this.mFilterSchemasCached = Collections.EMPTY_SET;
            } else {
                this.mFilterSchemasCached = Collections.unmodifiableSet(new ArraySet(list));
            }
        }
        return this.mFilterSchemasCached;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private ArrayList<String> mFilterSchemas = new ArrayList<>();
        private boolean mBuilt = false;

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mFilterSchemas = new ArrayList<>(this.mFilterSchemas);
                this.mBuilt = false;
            }
        }

        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addFilterDocumentClasses(Class<?>... clsArr) {
            Preconditions.checkNotNull(clsArr);
            resetIfBuilt();
            return addFilterDocumentClasses(Arrays.asList(clsArr));
        }

        @CanIgnoreReturnValue
        public Builder addFilterSchemas(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterSchemas(Arrays.asList(strArr));
        }

        public ObserverSpec build() {
            this.mBuilt = true;
            return new ObserverSpec(this.mFilterSchemas);
        }

        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addFilterDocumentClasses(Collection<? extends Class<?>> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList arrayList = new ArrayList(collection.size());
            DocumentClassFactoryRegistry documentClassFactoryRegistry = DocumentClassFactoryRegistry.getInstance();
            Iterator<? extends Class<?>> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(documentClassFactoryRegistry.getOrCreateFactory((Class) it.next()).getSchemaName());
            }
            addFilterSchemas(arrayList);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addFilterSchemas(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mFilterSchemas.addAll(collection);
            return this;
        }
    }
}
