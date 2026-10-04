package androidx.appsearch.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.OptIn;
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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
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
@SafeParcelable.Class(creator = "SearchSpecCreator")
public final class SearchSpec extends AbstractSafeParcelable {

    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<SearchSpec> CREATOR = new StubCreators.SearchSpecCreator();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int DEFAULT_NUM_PER_PAGE = 10;

    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public static final int EMBEDDING_SEARCH_METRIC_TYPE_COSINE = 1;

    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public static final int EMBEDDING_SEARCH_METRIC_TYPE_DEFAULT = 0;

    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public static final int EMBEDDING_SEARCH_METRIC_TYPE_DOT_PRODUCT = 2;

    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public static final int EMBEDDING_SEARCH_METRIC_TYPE_EUCLIDEAN = 3;
    public static final int GROUPING_TYPE_PER_NAMESPACE = 2;
    public static final int GROUPING_TYPE_PER_PACKAGE = 1;

    @FlaggedApi(Flags.FLAG_ENABLE_GROUPING_TYPE_PER_SCHEMA)
    public static final int GROUPING_TYPE_PER_SCHEMA = 4;
    private static final int MAX_NUM_PER_PAGE = 10000;
    private static final int MAX_SNIPPET_COUNT = 10000;
    private static final int MAX_SNIPPET_PER_PROPERTY_COUNT = 10000;
    private static final int MAX_SNIPPET_SIZE_LIMIT = 10000;
    public static final int ORDER_ASCENDING = 1;
    public static final int ORDER_DESCENDING = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public static final String PROJECTION_SCHEMA_TYPE_WILDCARD = "*";
    public static final int RANKING_STRATEGY_ADVANCED_RANKING_EXPRESSION = 9;
    public static final int RANKING_STRATEGY_CREATION_TIMESTAMP = 2;
    public static final int RANKING_STRATEGY_DOCUMENT_SCORE = 1;
    public static final int RANKING_STRATEGY_JOIN_AGGREGATE_SCORE = 8;
    public static final int RANKING_STRATEGY_NONE = 0;
    public static final int RANKING_STRATEGY_RELEVANCE_SCORE = 3;
    public static final int RANKING_STRATEGY_SYSTEM_USAGE_COUNT = 6;
    public static final int RANKING_STRATEGY_SYSTEM_USAGE_LAST_USED_TIMESTAMP = 7;
    public static final int RANKING_STRATEGY_USAGE_COUNT = 4;
    public static final int RANKING_STRATEGY_USAGE_LAST_USED_TIMESTAMP = 5;

    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_PROPERTIES)
    public static final String SCHEMA_TYPE_WILDCARD = "*";
    public static final int TERM_MATCH_EXACT_ONLY = 1;
    public static final int TERM_MATCH_PREFIX = 2;

    @AbstractSafeParcelable.Field(getter = "getAdvancedRankingExpression", m1109id = 17)
    private final String mAdvancedRankingExpression;

    @AbstractSafeParcelable.Field(getter = "getDefaultEmbeddingSearchMetricType", m1109id = 21)
    private final int mDefaultEmbeddingSearchMetricType;

    @AbstractSafeParcelable.Field(getter = "getEmbeddingParameters", m1109id = 20)
    private final List<EmbeddingVector> mEmbeddingParameters;

    @AbstractSafeParcelable.Field(getter = "getEnabledFeatures", m1109id = 18)
    private final List<String> mEnabledFeatures;

    @AbstractSafeParcelable.Field(getter = "getFilterDocumentIds", m1109id = 24)
    private final List<String> mFilterDocumentIds;

    @AbstractSafeParcelable.Field(getter = "getResultGroupingLimit", m1109id = 14)
    private final int mGroupingLimit;

    @AbstractSafeParcelable.Field(getter = "getInformationalRankingExpressions", m1109id = 22)
    private final List<String> mInformationalRankingExpressions;

    @AbstractSafeParcelable.Field(getter = "getJoinSpec", m1109id = 16)
    private final JoinSpec mJoinSpec;

    @AbstractSafeParcelable.Field(getter = "getMaxSnippetSize", m1109id = 11)
    private final int mMaxSnippetSize;

    @AbstractSafeParcelable.Field(getter = "getFilterNamespaces", m1109id = 3)
    private final List<String> mNamespaces;

    @AbstractSafeParcelable.Field(getter = "getOrder", m1109id = 8)
    private final int mOrder;

    @AbstractSafeParcelable.Field(getter = "getFilterPackageNames", m1109id = 5)
    private final List<String> mPackageNames;

    @AbstractSafeParcelable.Field(m1109id = 12)
    final Bundle mProjectionTypePropertyMasks;

    @AbstractSafeParcelable.Field(getter = "getRankingStrategy", m1109id = 7)
    private final int mRankingStrategy;

    @AbstractSafeParcelable.Field(getter = "getResultCountPerPage", m1109id = 6)
    private final int mResultCountPerPage;

    @AbstractSafeParcelable.Field(getter = "getResultGroupingTypeFlags", m1109id = 13)
    private final int mResultGroupingTypeFlags;

    @AbstractSafeParcelable.Field(getter = "getFilterSchemas", m1109id = 2)
    private final List<String> mSchemas;

    @AbstractSafeParcelable.Field(getter = "getSearchSourceLogTag", m1109id = 19)
    private final String mSearchSourceLogTag;

    @AbstractSafeParcelable.Field(getter = "getSearchStringParameters", m1109id = 23)
    private final List<String> mSearchStringParameters;

    @AbstractSafeParcelable.Field(getter = "getSnippetCount", m1109id = 9)
    private final int mSnippetCount;

    @AbstractSafeParcelable.Field(getter = "getSnippetCountPerProperty", m1109id = 10)
    private final int mSnippetCountPerProperty;

    @AbstractSafeParcelable.Field(getter = "getTermMatch", m1109id = 1)
    private final int mTermMatchType;

    @AbstractSafeParcelable.Field(m1109id = 4)
    final Bundle mTypePropertyFilters;

    @AbstractSafeParcelable.Field(m1109id = 15)
    final Bundle mTypePropertyWeightsField;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface EmbeddingSearchMetricType {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface GroupingType {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Order {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface RankingStrategy {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface TermMatch {
    }

    @AbstractSafeParcelable.Constructor
    public SearchSpec(@AbstractSafeParcelable.Param(m1110id = 1) int i, @AbstractSafeParcelable.Param(m1110id = 2) List<String> list, @AbstractSafeParcelable.Param(m1110id = 3) List<String> list2, @AbstractSafeParcelable.Param(m1110id = 4) Bundle bundle, @AbstractSafeParcelable.Param(m1110id = 5) List<String> list3, @AbstractSafeParcelable.Param(m1110id = 6) int i2, @AbstractSafeParcelable.Param(m1110id = 7) int i4, @AbstractSafeParcelable.Param(m1110id = 8) int i5, @AbstractSafeParcelable.Param(m1110id = 9) int i6, @AbstractSafeParcelable.Param(m1110id = 10) int i7, @AbstractSafeParcelable.Param(m1110id = 11) int i8, @AbstractSafeParcelable.Param(m1110id = 12) Bundle bundle2, @AbstractSafeParcelable.Param(m1110id = 13) int i9, @AbstractSafeParcelable.Param(m1110id = 14) int i10, @AbstractSafeParcelable.Param(m1110id = 15) Bundle bundle3, @AbstractSafeParcelable.Param(m1110id = 16) JoinSpec joinSpec, @AbstractSafeParcelable.Param(m1110id = 17) String str, @AbstractSafeParcelable.Param(m1110id = 18) List<String> list4, @AbstractSafeParcelable.Param(m1110id = 19) String str2, @AbstractSafeParcelable.Param(m1110id = 20) List<EmbeddingVector> list5, @AbstractSafeParcelable.Param(m1110id = 21) int i11, @AbstractSafeParcelable.Param(m1110id = 22) List<String> list6, @AbstractSafeParcelable.Param(m1110id = 23) List<String> list7, @AbstractSafeParcelable.Param(m1110id = 24) List<String> list8) {
        this.mTermMatchType = i;
        this.mSchemas = Collections.unmodifiableList((List) Preconditions.checkNotNull(list));
        this.mNamespaces = Collections.unmodifiableList((List) Preconditions.checkNotNull(list2));
        this.mTypePropertyFilters = (Bundle) Preconditions.checkNotNull(bundle);
        this.mPackageNames = Collections.unmodifiableList((List) Preconditions.checkNotNull(list3));
        this.mResultCountPerPage = i2;
        this.mRankingStrategy = i4;
        this.mOrder = i5;
        this.mSnippetCount = i6;
        this.mSnippetCountPerProperty = i7;
        this.mMaxSnippetSize = i8;
        this.mProjectionTypePropertyMasks = (Bundle) Preconditions.checkNotNull(bundle2);
        this.mResultGroupingTypeFlags = i9;
        this.mGroupingLimit = i10;
        this.mTypePropertyWeightsField = (Bundle) Preconditions.checkNotNull(bundle3);
        this.mJoinSpec = joinSpec;
        this.mAdvancedRankingExpression = (String) Preconditions.checkNotNull(str);
        this.mEnabledFeatures = Collections.unmodifiableList((List) Preconditions.checkNotNull(list4));
        this.mSearchSourceLogTag = str2;
        if (list5 != null) {
            this.mEmbeddingParameters = Collections.unmodifiableList(list5);
        } else {
            this.mEmbeddingParameters = Collections.EMPTY_LIST;
        }
        this.mDefaultEmbeddingSearchMetricType = i11;
        if (list6 != null) {
            this.mInformationalRankingExpressions = Collections.unmodifiableList(list6);
        } else {
            this.mInformationalRankingExpressions = Collections.EMPTY_LIST;
        }
        this.mSearchStringParameters = list7 != null ? Collections.unmodifiableList(list7) : Collections.EMPTY_LIST;
        this.mFilterDocumentIds = list8 != null ? Collections.unmodifiableList(list8) : Collections.EMPTY_LIST;
    }

    public String getAdvancedRankingExpression() {
        return this.mAdvancedRankingExpression;
    }

    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public int getDefaultEmbeddingSearchMetricType() {
        return this.mDefaultEmbeddingSearchMetricType;
    }

    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public List<EmbeddingVector> getEmbeddingParameters() {
        return this.mEmbeddingParameters;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<String> getEnabledFeatures() {
        return this.mEnabledFeatures;
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_DOCUMENT_IDS)
    public List<String> getFilterDocumentIds() {
        return this.mFilterDocumentIds;
    }

    public List<String> getFilterNamespaces() {
        List<String> list = this.mNamespaces;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List<String> getFilterPackageNames() {
        List<String> list = this.mPackageNames;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_PROPERTIES)
    public Map<String, List<String>> getFilterProperties() {
        Set<String> setKeySet = this.mTypePropertyFilters.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            arrayMap.put(str, (List) Preconditions.checkNotNull(this.mTypePropertyFilters.getStringArrayList(str)));
        }
        return arrayMap;
    }

    public List<String> getFilterSchemas() {
        List<String> list = this.mSchemas;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    @FlaggedApi(Flags.FLAG_ENABLE_INFORMATIONAL_RANKING_EXPRESSIONS)
    public List<String> getInformationalRankingExpressions() {
        return this.mInformationalRankingExpressions;
    }

    public JoinSpec getJoinSpec() {
        return this.mJoinSpec;
    }

    public int getMaxSnippetSize() {
        return this.mMaxSnippetSize;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public Map<String, List<PropertyPath>> getProjectionPaths() {
        Set<String> setKeySet = this.mProjectionTypePropertyMasks.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            ArrayList<String> stringArrayList = this.mProjectionTypePropertyMasks.getStringArrayList(str);
            if (stringArrayList != null) {
                ArrayList arrayList = new ArrayList(stringArrayList.size());
                for (int i = 0; i < stringArrayList.size(); i++) {
                    arrayList.add(new PropertyPath(stringArrayList.get(i)));
                }
                arrayMap.put(str, arrayList);
            }
        }
        return arrayMap;
    }

    public Map<String, List<String>> getProjections() {
        Set<String> setKeySet = this.mProjectionTypePropertyMasks.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            ArrayList<String> stringArrayList = this.mProjectionTypePropertyMasks.getStringArrayList(str);
            Objects.requireNonNull(stringArrayList);
            arrayMap.put(str, stringArrayList);
        }
        return arrayMap;
    }

    public Map<String, Map<PropertyPath, Double>> getPropertyWeightPaths() {
        Set<String> setKeySet = this.mTypePropertyWeightsField.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            Bundle bundle = this.mTypePropertyWeightsField.getBundle(str);
            if (bundle != null) {
                Set<String> setKeySet2 = bundle.keySet();
                ArrayMap arrayMap2 = new ArrayMap(setKeySet2.size());
                for (String str2 : setKeySet2) {
                    arrayMap2.put(new PropertyPath(str2), Double.valueOf(bundle.getDouble(str2)));
                }
                arrayMap.put(str, arrayMap2);
            }
        }
        return arrayMap;
    }

    public Map<String, Map<String, Double>> getPropertyWeights() {
        Set<String> setKeySet = this.mTypePropertyWeightsField.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            Bundle bundle = this.mTypePropertyWeightsField.getBundle(str);
            if (bundle != null) {
                Set<String> setKeySet2 = bundle.keySet();
                ArrayMap arrayMap2 = new ArrayMap(setKeySet2.size());
                for (String str2 : setKeySet2) {
                    arrayMap2.put(str2, Double.valueOf(bundle.getDouble(str2)));
                }
                arrayMap.put(str, arrayMap2);
            }
        }
        return arrayMap;
    }

    public int getRankingStrategy() {
        return this.mRankingStrategy;
    }

    public int getResultCountPerPage() {
        return this.mResultCountPerPage;
    }

    public int getResultGroupingLimit() {
        return this.mGroupingLimit;
    }

    public int getResultGroupingTypeFlags() {
        return this.mResultGroupingTypeFlags;
    }

    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SET_SEARCH_SOURCE_LOG_TAG)
    public String getSearchSourceLogTag() {
        return this.mSearchSourceLogTag;
    }

    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SEARCH_STRING_PARAMETERS)
    public List<String> getSearchStringParameters() {
        return this.mSearchStringParameters;
    }

    public int getSnippetCount() {
        return this.mSnippetCount;
    }

    public int getSnippetCountPerProperty() {
        return this.mSnippetCountPerProperty;
    }

    public int getTermMatch() {
        return this.mTermMatchType;
    }

    @FlaggedApi(Flags.FLAG_ENABLE_LIST_FILTER_HAS_PROPERTY_FUNCTION)
    public boolean isListFilterHasPropertyFunctionEnabled() {
        return this.mEnabledFeatures.contains("LIST_FILTER_HAS_PROPERTY_FUNCTION");
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_LIST_FILTER_MATCH_SCORE_EXPRESSION_FUNCTION)
    public boolean isListFilterMatchScoreExpressionFunctionEnabled() {
        return this.mEnabledFeatures.contains("LIST_FILTER_MATCH_SCORE_EXPRESSION_FUNCTION");
    }

    public boolean isListFilterQueryLanguageEnabled() {
        return this.mEnabledFeatures.contains("LIST_FILTER_QUERY_LANGUAGE");
    }

    public boolean isNumericSearchEnabled() {
        return this.mEnabledFeatures.contains("NUMERIC_SEARCH");
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_SCORABLE_PROPERTY)
    public boolean isScorablePropertyRankingEnabled() {
        return this.mEnabledFeatures.contains("SCHEMA_SCORABLE_PROPERTY_CONFIG");
    }

    public boolean isVerbatimSearchEnabled() {
        return this.mEnabledFeatures.contains("VERBATIM_SEARCH");
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private String mAdvancedRankingExpression;
        private boolean mBuilt;
        private int mDefaultEmbeddingSearchMetricType;
        private List<EmbeddingVector> mEmbeddingParameters;
        private ArraySet<String> mEnabledFeatures;
        private List<String> mFilterDocumentIds;
        private int mGroupingLimit;
        private int mGroupingTypeFlags;
        private List<String> mInformationalRankingExpressions;
        private JoinSpec mJoinSpec;
        private int mMaxSnippetSize;
        private List<String> mNamespaces;
        private int mOrder;
        private List<String> mPackageNames;
        private Bundle mProjectionTypePropertyMasks;
        private int mRankingStrategy;
        private int mResultCountPerPage;
        private List<String> mSchemas;
        private String mSearchSourceLogTag;
        private List<String> mSearchStringParameters;
        private int mSnippetCount;
        private int mSnippetCountPerProperty;
        private int mTermMatchType;
        private Bundle mTypePropertyFilters;
        private Bundle mTypePropertyWeights;

        public Builder() {
            this.mSchemas = new ArrayList();
            this.mNamespaces = new ArrayList();
            this.mTypePropertyFilters = new Bundle();
            this.mPackageNames = new ArrayList();
            this.mEnabledFeatures = new ArraySet<>();
            this.mProjectionTypePropertyMasks = new Bundle();
            this.mTypePropertyWeights = new Bundle();
            this.mEmbeddingParameters = new ArrayList();
            this.mSearchStringParameters = new ArrayList();
            this.mFilterDocumentIds = new ArrayList();
            this.mResultCountPerPage = 10;
            this.mTermMatchType = 2;
            this.mDefaultEmbeddingSearchMetricType = 1;
            this.mSnippetCount = 0;
            this.mSnippetCountPerProperty = 10000;
            this.mMaxSnippetSize = 0;
            this.mRankingStrategy = 0;
            this.mOrder = 0;
            this.mGroupingTypeFlags = 0;
            this.mGroupingLimit = 0;
            this.mAdvancedRankingExpression = "";
            this.mInformationalRankingExpressions = new ArrayList();
            this.mBuilt = false;
        }

        private void modifyEnabledFeature(String str, boolean z) {
            resetIfBuilt();
            if (z) {
                this.mEnabledFeatures.add(str);
            } else {
                this.mEnabledFeatures.remove(str);
            }
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mSchemas = new ArrayList(this.mSchemas);
                this.mTypePropertyFilters = BundleUtil.deepCopy(this.mTypePropertyFilters);
                this.mNamespaces = new ArrayList(this.mNamespaces);
                this.mPackageNames = new ArrayList(this.mPackageNames);
                this.mProjectionTypePropertyMasks = BundleUtil.deepCopy(this.mProjectionTypePropertyMasks);
                this.mTypePropertyWeights = BundleUtil.deepCopy(this.mTypePropertyWeights);
                this.mEmbeddingParameters = new ArrayList(this.mEmbeddingParameters);
                this.mInformationalRankingExpressions = new ArrayList(this.mInformationalRankingExpressions);
                this.mSearchStringParameters = new ArrayList(this.mSearchStringParameters);
                this.mFilterDocumentIds = new ArrayList(this.mFilterDocumentIds);
                this.mBuilt = false;
            }
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
        public Builder addEmbeddingParameters(EmbeddingVector... embeddingVectorArr) {
            Preconditions.checkNotNull(embeddingVectorArr);
            resetIfBuilt();
            return addEmbeddingParameters(Arrays.asList(embeddingVectorArr));
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
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_DOCUMENT_IDS)
        public Builder addFilterDocumentIds(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterDocumentIds(Arrays.asList(strArr));
        }

        @CanIgnoreReturnValue
        public Builder addFilterNamespaces(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterNamespaces(Arrays.asList(strArr));
        }

        @CanIgnoreReturnValue
        public Builder addFilterPackageNames(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterPackageNames(Arrays.asList(strArr));
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
        @FlaggedApi(Flags.FLAG_ENABLE_INFORMATIONAL_RANKING_EXPRESSIONS)
        public Builder addInformationalRankingExpressions(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addInformationalRankingExpressions(Arrays.asList(strArr));
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
            this.mProjectionTypePropertyMasks.putStringArrayList(str, arrayList);
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

        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addProjectionPathsForDocumentClass(Class<?> cls, Collection<PropertyPath> collection) {
            Preconditions.checkNotNull(cls);
            resetIfBuilt();
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<PropertyPath> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
            return addProjectionsForDocumentClass(cls, arrayList);
        }

        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addProjectionsForDocumentClass(Class<?> cls, Collection<String> collection) {
            Preconditions.checkNotNull(cls);
            resetIfBuilt();
            return addProjection(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), collection);
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SEARCH_STRING_PARAMETERS)
        public Builder addSearchStringParameters(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addSearchStringParameters(Arrays.asList(strArr));
        }

        public SearchSpec build() {
            int i;
            JoinSpec joinSpec = this.mJoinSpec;
            if (joinSpec != null) {
                if (this.mRankingStrategy != 8 && joinSpec.getAggregationScoringStrategy() != 0) {
                    throw new IllegalStateException("Aggregate scoring strategy has been set in the nested JoinSpec, but ranking strategy is not RANKING_STRATEGY_JOIN_AGGREGATE_SCORE");
                }
            } else if (this.mRankingStrategy == 8) {
                throw new IllegalStateException("Attempting to rank based on joined documents, but no JoinSpec provided");
            }
            if (!this.mTypePropertyWeights.isEmpty() && (i = this.mRankingStrategy) != 3 && i != 9) {
                throw new IllegalArgumentException("Property weights are only compatible with the RANKING_STRATEGY_RELEVANCE_SCORE and RANKING_STRATEGY_ADVANCED_RANKING_EXPRESSION ranking strategies.");
            }
            this.mBuilt = true;
            return new SearchSpec(this.mTermMatchType, this.mSchemas, this.mNamespaces, this.mTypePropertyFilters, this.mPackageNames, this.mResultCountPerPage, this.mRankingStrategy, this.mOrder, this.mSnippetCount, this.mSnippetCountPerProperty, this.mMaxSnippetSize, this.mProjectionTypePropertyMasks, this.mGroupingTypeFlags, this.mGroupingLimit, this.mTypePropertyWeights, this.mJoinSpec, this.mAdvancedRankingExpression, new ArrayList(this.mEnabledFeatures), this.mSearchSourceLogTag, this.mEmbeddingParameters, this.mDefaultEmbeddingSearchMetricType, this.mInformationalRankingExpressions, this.mSearchStringParameters, this.mFilterDocumentIds);
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearEmbeddingParameters() {
            resetIfBuilt();
            this.mEmbeddingParameters.clear();
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearFilterDocumentIds() {
            resetIfBuilt();
            this.mFilterDocumentIds.clear();
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearFilterNamespaces() {
            resetIfBuilt();
            this.mNamespaces.clear();
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearFilterPackageNames() {
            resetIfBuilt();
            this.mPackageNames.clear();
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearFilterProperties() {
            resetIfBuilt();
            this.mTypePropertyFilters.clear();
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearFilterSchemas() {
            resetIfBuilt();
            this.mSchemas.clear();
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearInformationalRankingExpressions() {
            resetIfBuilt();
            this.mInformationalRankingExpressions.clear();
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearJoinSpec() {
            resetIfBuilt();
            this.mJoinSpec = null;
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearProjections() {
            resetIfBuilt();
            this.mProjectionTypePropertyMasks.clear();
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearPropertyWeights() {
            resetIfBuilt();
            this.mTypePropertyWeights.clear();
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearResultGrouping() {
            resetIfBuilt();
            this.mGroupingTypeFlags = 0;
            this.mGroupingLimit = 0;
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearSearchSourceLogTag() {
            resetIfBuilt();
            this.mSearchSourceLogTag = null;
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder clearSearchStringParameters() {
            resetIfBuilt();
            this.mSearchStringParameters.clear();
            return this;
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
        public Builder setDefaultEmbeddingSearchMetricType(int i) {
            Preconditions.checkArgumentInRange(i, 1, 3, "Embedding search metric type");
            resetIfBuilt();
            this.mDefaultEmbeddingSearchMetricType = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setJoinSpec(JoinSpec joinSpec) {
            resetIfBuilt();
            this.mJoinSpec = (JoinSpec) Preconditions.checkNotNull(joinSpec);
            return this;
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_LIST_FILTER_HAS_PROPERTY_FUNCTION)
        public Builder setListFilterHasPropertyFunctionEnabled(boolean z) {
            modifyEnabledFeature("LIST_FILTER_HAS_PROPERTY_FUNCTION", z);
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_LIST_FILTER_MATCH_SCORE_EXPRESSION_FUNCTION)
        public Builder setListFilterMatchScoreExpressionFunctionEnabled(boolean z) {
            modifyEnabledFeature("LIST_FILTER_MATCH_SCORE_EXPRESSION_FUNCTION", z);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setListFilterQueryLanguageEnabled(boolean z) {
            modifyEnabledFeature("LIST_FILTER_QUERY_LANGUAGE", z);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMaxSnippetSize(@IntRange(from = 0, m706to = 10000) int i) {
            Preconditions.checkArgumentInRange(i, 0, 10000, "maxSnippetSize");
            resetIfBuilt();
            this.mMaxSnippetSize = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setNumericSearchEnabled(boolean z) {
            modifyEnabledFeature("NUMERIC_SEARCH", z);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setOrder(int i) {
            Preconditions.checkArgumentInRange(i, 0, 1, "Result ranking order");
            resetIfBuilt();
            this.mOrder = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPropertyWeightPaths(String str, Map<PropertyPath, Double> map) {
            Preconditions.checkNotNull(map);
            ArrayMap arrayMap = new ArrayMap(map.size());
            for (Map.Entry<PropertyPath, Double> entry : map.entrySet()) {
                arrayMap.put(((PropertyPath) Preconditions.checkNotNull(entry.getKey())).toString(), entry.getValue());
            }
            return setPropertyWeights(str, arrayMap);
        }

        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setPropertyWeightPathsForDocumentClass(Class<?> cls, Map<PropertyPath, Double> map) {
            Preconditions.checkNotNull(cls);
            return setPropertyWeightPaths(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), map);
        }

        @CanIgnoreReturnValue
        public Builder setPropertyWeights(String str, Map<String, Double> map) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(map);
            Bundle bundle = new Bundle();
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                String str2 = (String) Preconditions.checkNotNull(entry.getKey());
                Double d = (Double) Preconditions.checkNotNull(entry.getValue());
                if (d.doubleValue() <= 0.0d) {
                    throw new IllegalArgumentException("Cannot set non-positive property weight value " + d + " for property path: " + str2);
                }
                bundle.putDouble(str2, d.doubleValue());
            }
            this.mTypePropertyWeights.putBundle(str, bundle);
            return this;
        }

        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setPropertyWeightsForDocumentClass(Class<?> cls, Map<String, Double> map) {
            Preconditions.checkNotNull(cls);
            return setPropertyWeights(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), map);
        }

        @CanIgnoreReturnValue
        public Builder setRankingStrategy(int i) {
            Preconditions.checkArgumentInRange(i, 0, 8, "Result ranking strategy");
            resetIfBuilt();
            this.mRankingStrategy = i;
            this.mAdvancedRankingExpression = "";
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setResultCountPerPage(@IntRange(from = 0, m706to = 10000) int i) {
            Preconditions.checkArgumentInRange(i, 0, 10000, "resultCountPerPage");
            resetIfBuilt();
            this.mResultCountPerPage = i;
            return this;
        }

        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setResultGrouping(int i, int i2) {
            Preconditions.checkState(i != 0, "Result grouping type cannot be zero.");
            resetIfBuilt();
            this.mGroupingTypeFlags = i;
            this.mGroupingLimit = i2;
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_SCORABLE_PROPERTY)
        public Builder setScorablePropertyRankingEnabled(boolean z) {
            modifyEnabledFeature("SCHEMA_SCORABLE_PROPERTY_CONFIG", z);
            return this;
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_SET_SEARCH_SOURCE_LOG_TAG)
        public Builder setSearchSourceLogTag(String str) {
            Preconditions.checkStringNotEmpty(str);
            Preconditions.checkArgument(str.length() <= 100, "The maximum supported tag length is 100. This tag is too long: " + str.length());
            resetIfBuilt();
            this.mSearchSourceLogTag = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSnippetCount(@IntRange(from = 0, m706to = 10000) int i) {
            Preconditions.checkArgumentInRange(i, 0, 10000, "snippetCount");
            resetIfBuilt();
            this.mSnippetCount = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSnippetCountPerProperty(@IntRange(from = 0, m706to = 10000) int i) {
            Preconditions.checkArgumentInRange(i, 0, 10000, "snippetCountPerProperty");
            resetIfBuilt();
            this.mSnippetCountPerProperty = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTermMatch(int i) {
            Preconditions.checkArgumentInRange(i, 1, 2, "Term match type");
            resetIfBuilt();
            this.mTermMatchType = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setVerbatimSearchEnabled(boolean z) {
            modifyEnabledFeature("VERBATIM_SEARCH", z);
            return this;
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
        public Builder addEmbeddingParameters(Collection<EmbeddingVector> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mEmbeddingParameters.addAll(collection);
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_SPEC_FILTER_DOCUMENT_IDS)
        public Builder addFilterDocumentIds(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mFilterDocumentIds.addAll(collection);
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
        public Builder addFilterPackageNames(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mPackageNames.addAll(collection);
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
        @FlaggedApi(Flags.FLAG_ENABLE_INFORMATIONAL_RANKING_EXPRESSIONS)
        public Builder addInformationalRankingExpressions(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mInformationalRankingExpressions.addAll(collection);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setRankingStrategy(String str) {
            Preconditions.checkStringNotEmpty(str);
            resetIfBuilt();
            this.mRankingStrategy = 9;
            this.mAdvancedRankingExpression = str;
            return this;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addFilterPropertyPaths(Class<?> cls, Collection<PropertyPath> collection) {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            return addFilterPropertyPaths(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), collection);
        }

        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addFilterDocumentClasses(Class<?>... clsArr) {
            Preconditions.checkNotNull(clsArr);
            resetIfBuilt();
            return addFilterDocumentClasses(Arrays.asList(clsArr));
        }

        public Builder addFilterProperties(Class<?> cls, Collection<String> collection) {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            return addFilterProperties(DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) cls).getSchemaName(), collection);
        }

        @OptIn(markerClass = {ExperimentalAppSearchApi.class})
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder(SearchSpec searchSpec) {
            this.mSchemas = new ArrayList();
            this.mNamespaces = new ArrayList();
            this.mTypePropertyFilters = new Bundle();
            this.mPackageNames = new ArrayList();
            this.mEnabledFeatures = new ArraySet<>();
            this.mProjectionTypePropertyMasks = new Bundle();
            this.mTypePropertyWeights = new Bundle();
            this.mEmbeddingParameters = new ArrayList();
            this.mSearchStringParameters = new ArrayList();
            this.mFilterDocumentIds = new ArrayList();
            this.mResultCountPerPage = 10;
            this.mTermMatchType = 2;
            this.mDefaultEmbeddingSearchMetricType = 1;
            this.mSnippetCount = 0;
            this.mSnippetCountPerProperty = 10000;
            this.mMaxSnippetSize = 0;
            this.mRankingStrategy = 0;
            this.mOrder = 0;
            this.mGroupingTypeFlags = 0;
            this.mGroupingLimit = 0;
            this.mAdvancedRankingExpression = "";
            this.mInformationalRankingExpressions = new ArrayList();
            this.mBuilt = false;
            Objects.requireNonNull(searchSpec);
            this.mSchemas = new ArrayList(searchSpec.getFilterSchemas());
            this.mNamespaces = new ArrayList(searchSpec.getFilterNamespaces());
            for (Map.Entry<String, List<String>> entry : searchSpec.getFilterProperties().entrySet()) {
                addFilterProperties(entry.getKey(), entry.getValue());
            }
            this.mPackageNames = new ArrayList(searchSpec.getFilterPackageNames());
            this.mEnabledFeatures = new ArraySet<>(searchSpec.getEnabledFeatures());
            for (Map.Entry<String, List<String>> entry2 : searchSpec.getProjections().entrySet()) {
                addProjection(entry2.getKey(), entry2.getValue());
            }
            for (Map.Entry<String, Map<String, Double>> entry3 : searchSpec.getPropertyWeights().entrySet()) {
                setPropertyWeights(entry3.getKey(), entry3.getValue());
            }
            this.mEmbeddingParameters = new ArrayList(searchSpec.getEmbeddingParameters());
            this.mSearchStringParameters = new ArrayList(searchSpec.getSearchStringParameters());
            this.mResultCountPerPage = searchSpec.getResultCountPerPage();
            this.mTermMatchType = searchSpec.getTermMatch();
            this.mDefaultEmbeddingSearchMetricType = searchSpec.getDefaultEmbeddingSearchMetricType();
            this.mSnippetCount = searchSpec.getSnippetCount();
            this.mSnippetCountPerProperty = searchSpec.getSnippetCountPerProperty();
            this.mMaxSnippetSize = searchSpec.getMaxSnippetSize();
            this.mRankingStrategy = searchSpec.getRankingStrategy();
            this.mOrder = searchSpec.getOrder();
            this.mGroupingTypeFlags = searchSpec.getResultGroupingTypeFlags();
            this.mGroupingLimit = searchSpec.getResultGroupingLimit();
            this.mJoinSpec = searchSpec.getJoinSpec();
            this.mAdvancedRankingExpression = searchSpec.getAdvancedRankingExpression();
            this.mInformationalRankingExpressions = new ArrayList(searchSpec.getInformationalRankingExpressions());
            this.mSearchSourceLogTag = searchSpec.getSearchSourceLogTag();
            this.mFilterDocumentIds = new ArrayList(searchSpec.getFilterDocumentIds());
        }
    }
}
