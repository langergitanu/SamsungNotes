package androidx.appsearch.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "SearchSuggestionSpecCreator")
public final class SearchSuggestionSpec extends AbstractSafeParcelable {

    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<SearchSuggestionSpec> CREATOR = new StubCreators.SearchSuggestionSpecCreator();
    public static final int SUGGESTION_RANKING_STRATEGY_DOCUMENT_COUNT = 0;
    public static final int SUGGESTION_RANKING_STRATEGY_NONE = 2;
    public static final int SUGGESTION_RANKING_STRATEGY_TERM_FREQUENCY = 1;

    @AbstractSafeParcelable.Field(m1109id = 4)
    final Bundle mFilterDocumentIds;

    @AbstractSafeParcelable.Field(getter = "getFilterNamespaces", m1109id = 1)
    private final List<String> mFilterNamespaces;

    @AbstractSafeParcelable.Field(m1109id = 3)
    final Bundle mFilterProperties;

    @AbstractSafeParcelable.Field(getter = "getFilterSchemas", m1109id = 2)
    private final List<String> mFilterSchemas;

    @AbstractSafeParcelable.Field(getter = "getMaximumResultCount", m1109id = 6)
    private final int mMaximumResultCount;

    @AbstractSafeParcelable.Field(getter = "getRankingStrategy", m1109id = 5)
    private final int mRankingStrategy;

    @AbstractSafeParcelable.Field(getter = "getSearchStringParameters", m1109id = 7)
    private final List<String> mSearchStringParameters;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface SuggestionRankingStrategy {
    }

    @AbstractSafeParcelable.Constructor
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SearchSuggestionSpec(@AbstractSafeParcelable.Param(m1110id = 1) List<String> list, @AbstractSafeParcelable.Param(m1110id = 2) List<String> list2, @AbstractSafeParcelable.Param(m1110id = 3) Bundle bundle, @AbstractSafeParcelable.Param(m1110id = 4) Bundle bundle2, @AbstractSafeParcelable.Param(m1110id = 5) int i, @AbstractSafeParcelable.Param(m1110id = 6) int i2, @AbstractSafeParcelable.Param(m1110id = 7) List<String> list3) {
        Preconditions.checkArgument(i2 >= 1, "MaximumResultCount must be positive.");
        this.mFilterNamespaces = (List) Preconditions.checkNotNull(list);
        this.mFilterSchemas = (List) Preconditions.checkNotNull(list2);
        this.mFilterProperties = (Bundle) Preconditions.checkNotNull(bundle);
        this.mFilterDocumentIds = (Bundle) Preconditions.checkNotNull(bundle2);
        this.mRankingStrategy = i;
        this.mMaximumResultCount = i2;
        this.mSearchStringParameters = list3 != null ? Collections.unmodifiableList(list3) : Collections.EMPTY_LIST;
    }

    public Map<String, List<String>> getFilterDocumentIds() {
        Set<String> setKeySet = this.mFilterDocumentIds.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            arrayMap.put(str, (List) Preconditions.checkNotNull(this.mFilterDocumentIds.getStringArrayList(str)));
        }
        return arrayMap;
    }

    public List<String> getFilterNamespaces() {
        List<String> list = this.mFilterNamespaces;
        return list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
    }

    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_PROPERTIES)
    public Map<String, List<String>> getFilterProperties() {
        Set<String> setKeySet = this.mFilterProperties.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            arrayMap.put(str, (List) Preconditions.checkNotNull(this.mFilterProperties.getStringArrayList(str)));
        }
        return arrayMap;
    }

    public List<String> getFilterSchemas() {
        List<String> list = this.mFilterSchemas;
        return list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
    }

    public int getMaximumResultCount() {
        return this.mMaximumResultCount;
    }

    public int getRankingStrategy() {
        return this.mRankingStrategy;
    }

    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SEARCH_STRING_PARAMETERS)
    public List<String> getSearchStringParameters() {
        return this.mSearchStringParameters;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private final int mTotalResultCount;
        private ArrayList<String> mNamespaces = new ArrayList<>();
        private ArrayList<String> mSchemas = new ArrayList<>();
        private Bundle mTypePropertyFilters = new Bundle();
        private Bundle mDocumentIds = new Bundle();
        private int mRankingStrategy = 0;
        private List<String> mSearchStringParameters = new ArrayList();
        private boolean mBuilt = false;

        public Builder(@IntRange(from = 1) int i) {
            Preconditions.checkArgument(i >= 1, "maximumResultCount must be positive.");
            this.mTotalResultCount = i;
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mNamespaces = new ArrayList<>(this.mNamespaces);
                this.mSchemas = new ArrayList<>(this.mSchemas);
                this.mTypePropertyFilters = BundleUtil.deepCopy(this.mTypePropertyFilters);
                this.mDocumentIds = BundleUtil.deepCopy(this.mDocumentIds);
                this.mSearchStringParameters = new ArrayList(this.mSearchStringParameters);
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
        public Builder addFilterDocumentIds(String str, String... strArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterDocumentIds(str, Arrays.asList(strArr));
        }

        @CanIgnoreReturnValue
        public Builder addFilterNamespaces(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterNamespaces(Arrays.asList(strArr));
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_PROPERTIES)
        public Builder addFilterProperties(String str, Collection<String> collection) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList<String> arrayList = new ArrayList<>(collection.size());
            for (String str2 : collection) {
                Preconditions.checkNotNull(str2);
                arrayList.add(str2);
            }
            this.mTypePropertyFilters.putStringArrayList(str, arrayList);
            return this;
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_PROPERTIES)
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addFilterPropertyPaths(String str, Collection<PropertyPath> collection) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(collection);
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<PropertyPath> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
            return addFilterProperties(str, arrayList);
        }

        @CanIgnoreReturnValue
        public Builder addFilterSchemas(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterSchemas(Arrays.asList(strArr));
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SEARCH_STRING_PARAMETERS)
        public Builder addSearchStringParameters(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addSearchStringParameters(Arrays.asList(strArr));
        }

        public SearchSuggestionSpec build() {
            if (!this.mSchemas.isEmpty()) {
                ArraySet arraySet = new ArraySet(this.mSchemas);
                for (String str : this.mTypePropertyFilters.keySet()) {
                    if (!arraySet.contains(str)) {
                        throw new IllegalStateException(AbstractC0541b.m773o("The schema: ", str, " exists in the property filter but doesn't exist in the schema filter."));
                    }
                }
            }
            if (!this.mNamespaces.isEmpty()) {
                ArraySet arraySet2 = new ArraySet(this.mNamespaces);
                for (String str2 : this.mDocumentIds.keySet()) {
                    if (!arraySet2.contains(str2)) {
                        throw new IllegalStateException(AbstractC0541b.m773o("The namespace: ", str2, " exists in the document id filter but doesn't exist in the namespace filter."));
                    }
                }
            }
            this.mBuilt = true;
            return new SearchSuggestionSpec(this.mNamespaces, this.mSchemas, this.mTypePropertyFilters, this.mDocumentIds, this.mRankingStrategy, this.mTotalResultCount, this.mSearchStringParameters);
        }

        @CanIgnoreReturnValue
        public Builder setRankingStrategy(int i) {
            Preconditions.checkArgumentInRange(i, 0, 2, "Suggestion ranking strategy");
            resetIfBuilt();
            this.mRankingStrategy = i;
            return this;
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
        public Builder addFilterNamespaces(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mNamespaces.addAll(collection);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addFilterSchemas(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mSchemas.addAll(collection);
            return this;
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SEARCH_STRING_PARAMETERS)
        public Builder addSearchStringParameters(List<String> list) {
            Preconditions.checkNotNull(list);
            resetIfBuilt();
            this.mSearchStringParameters.addAll(list);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addFilterDocumentIds(String str, Collection<String> collection) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList<String> arrayList = new ArrayList<>(collection.size());
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add((String) Preconditions.checkNotNull(it.next()));
            }
            this.mDocumentIds.putStringArrayList(str, arrayList);
            return this;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addFilterPropertyPaths(Class<?> cls, Collection<PropertyPath> collection) {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            return addFilterPropertyPaths(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), collection);
        }

        public Builder addFilterProperties(Class<?> cls, Collection<String> collection) {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            return addFilterProperties(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), collection);
        }
    }
}
