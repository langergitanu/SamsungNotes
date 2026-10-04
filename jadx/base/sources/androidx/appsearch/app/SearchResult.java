package androidx.appsearch.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.GenericDocumentParcel;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.appsearch.util.BundleUtil;
import androidx.collection.ArrayMap;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.glance.AbstractC2821a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "SearchResultCreator")
public final class SearchResult extends AbstractSafeParcelable {

    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<SearchResult> CREATOR = new StubCreators.SearchResultCreator();

    @AbstractSafeParcelable.Field(getter = "getDatabaseName", m1109id = 4)
    private final String mDatabaseName;

    @AbstractSafeParcelable.Field(m1109id = 1)
    final GenericDocumentParcel mDocument;
    private GenericDocument mDocumentCached;

    @AbstractSafeParcelable.Field(getter = "getInformationalRankingSignals", m1109id = 7)
    private final List<Double> mInformationalRankingSignals;

    @AbstractSafeParcelable.Field(getter = "getJoinedResults", m1109id = 6)
    private final List<SearchResult> mJoinedResults;

    @AbstractSafeParcelable.Field(m1109id = 2)
    final List<MatchInfo> mMatchInfos;
    private List<MatchInfo> mMatchInfosCached;

    @AbstractSafeParcelable.Field(getter = "getPackageName", m1109id = 3)
    private final String mPackageName;

    @AbstractSafeParcelable.Field(m1109id = 8)
    final Bundle mParentTypeMap;

    @AbstractSafeParcelable.Field(getter = "getRankingSignal", m1109id = 5)
    private final double mRankingSignal;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MatchRange {
        private final int mEnd;
        private final int mStart;

        public MatchRange(int i, int i2) {
            if (i > i2) {
                throw new IllegalArgumentException("Start point must be less than or equal to end point");
            }
            this.mStart = i;
            this.mEnd = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MatchRange)) {
                return false;
            }
            MatchRange matchRange = (MatchRange) obj;
            return getStart() == matchRange.getStart() && getEnd() == matchRange.getEnd();
        }

        public int getEnd() {
            return this.mEnd;
        }

        public int getStart() {
            return this.mStart;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Integer.valueOf(this.mStart), Integer.valueOf(this.mEnd));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MatchRange { start: ");
            sb.append(this.mStart);
            sb.append(" , end: ");
            return AbstractC2821a.m2223n(sb, "}", this.mEnd);
        }
    }

    @AbstractSafeParcelable.Constructor
    public SearchResult(@AbstractSafeParcelable.Param(m1110id = 1) GenericDocumentParcel genericDocumentParcel, @AbstractSafeParcelable.Param(m1110id = 2) List<MatchInfo> list, @AbstractSafeParcelable.Param(m1110id = 3) String str, @AbstractSafeParcelable.Param(m1110id = 4) String str2, @AbstractSafeParcelable.Param(m1110id = 5) double d, @AbstractSafeParcelable.Param(m1110id = 6) List<SearchResult> list2, @AbstractSafeParcelable.Param(m1110id = 7) List<Double> list3, @AbstractSafeParcelable.Param(m1110id = 8) Bundle bundle) {
        this.mDocument = (GenericDocumentParcel) Preconditions.checkNotNull(genericDocumentParcel);
        this.mMatchInfos = (List) Preconditions.checkNotNull(list);
        this.mPackageName = (String) Preconditions.checkNotNull(str);
        this.mDatabaseName = (String) Preconditions.checkNotNull(str2);
        this.mRankingSignal = d;
        this.mJoinedResults = Collections.unmodifiableList((List) Preconditions.checkNotNull(list2));
        if (list3 != null) {
            this.mInformationalRankingSignals = Collections.unmodifiableList(list3);
        } else {
            this.mInformationalRankingSignals = Collections.EMPTY_LIST;
        }
        if (bundle != null) {
            this.mParentTypeMap = bundle;
        } else {
            this.mParentTypeMap = Bundle.EMPTY;
        }
    }

    public String getDatabaseName() {
        return this.mDatabaseName;
    }

    public <T> T getDocument(Class<T> cls) {
        return (T) getDocument(cls, null);
    }

    public GenericDocument getGenericDocument() {
        if (this.mDocumentCached == null) {
            this.mDocumentCached = new GenericDocument(this.mDocument);
        }
        return this.mDocumentCached;
    }

    @FlaggedApi(Flags.FLAG_ENABLE_INFORMATIONAL_RANKING_EXPRESSIONS)
    public List<Double> getInformationalRankingSignals() {
        return this.mInformationalRankingSignals;
    }

    public List<SearchResult> getJoinedResults() {
        return this.mJoinedResults;
    }

    public List<MatchInfo> getMatchInfos() {
        if (this.mMatchInfosCached == null) {
            this.mMatchInfosCached = new ArrayList(this.mMatchInfos.size());
            for (int i = 0; i < this.mMatchInfos.size(); i++) {
                MatchInfo matchInfo = this.mMatchInfos.get(i);
                matchInfo.setDocument(getGenericDocument());
                List<MatchInfo> list = this.mMatchInfosCached;
                if (list != null) {
                    list.add(matchInfo);
                }
            }
            this.mMatchInfosCached = Collections.unmodifiableList(this.mMatchInfosCached);
        }
        return (List) Preconditions.checkNotNull(this.mMatchInfosCached);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_RESULT_PARENT_TYPES)
    public Map<String, List<String>> getParentTypeMap() {
        Set<String> setKeySet = this.mParentTypeMap.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            ArrayList<String> stringArrayList = this.mParentTypeMap.getStringArrayList(str);
            if (stringArrayList != null) {
                arrayMap.put(str, stringArrayList);
            }
        }
        return arrayMap;
    }

    public double getRankingSignal() {
        return this.mRankingSignal;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public <T> T getDocument(Class<T> cls, Map<String, List<String>> map) {
        Preconditions.checkNotNull(cls);
        return (T) getGenericDocument().toDocumentClass(cls, new DocumentClassMappingContext(map, getParentTypeMap()));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @SafeParcelable.Class(creator = "MatchInfoCreator")
    public static final class MatchInfo extends AbstractSafeParcelable {

        @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final Parcelable.Creator<MatchInfo> CREATOR = new StubCreators.MatchInfoCreator();
        private MatchRange mExactMatchRangeCached;

        @AbstractSafeParcelable.Field(m1109id = 3)
        final int mExactMatchRangeEnd;

        @AbstractSafeParcelable.Field(m1109id = 2)
        final int mExactMatchRangeStart;
        private String mFullText;

        @AbstractSafeParcelable.Field(getter = "getPropertyPath", m1109id = 1)
        private final String mPropertyPath;

        @AbstractSafeParcelable.Field(m1109id = 7)
        final int mSnippetRangeEnd;

        @AbstractSafeParcelable.Field(m1109id = 6)
        final int mSnippetRangeStart;
        private MatchRange mSubmatchRangeCached;

        @AbstractSafeParcelable.Field(m1109id = 5)
        final int mSubmatchRangeEnd;

        @AbstractSafeParcelable.Field(m1109id = 4)
        final int mSubmatchRangeStart;
        private MatchRange mWindowRangeCached;
        private PropertyPath mPropertyPathObject = null;
        private GenericDocument mDocument = null;

        @AbstractSafeParcelable.Constructor
        public MatchInfo(@AbstractSafeParcelable.Param(m1110id = 1) String str, @AbstractSafeParcelable.Param(m1110id = 2) int i, @AbstractSafeParcelable.Param(m1110id = 3) int i2, @AbstractSafeParcelable.Param(m1110id = 4) int i4, @AbstractSafeParcelable.Param(m1110id = 5) int i5, @AbstractSafeParcelable.Param(m1110id = 6) int i6, @AbstractSafeParcelable.Param(m1110id = 7) int i7) {
            this.mPropertyPath = (String) Preconditions.checkNotNull(str);
            this.mExactMatchRangeStart = i;
            this.mExactMatchRangeEnd = i2;
            this.mSubmatchRangeStart = i4;
            this.mSubmatchRangeEnd = i5;
            this.mSnippetRangeStart = i6;
            this.mSnippetRangeEnd = i7;
        }

        private void checkSubmatchSupported() {
            if (this.mSubmatchRangeStart == -1) {
                throw new UnsupportedOperationException("Submatch is not supported with this backend/Android API level combination");
            }
        }

        private static String getPropertyValues(GenericDocument genericDocument, String str) {
            String propertyString = genericDocument.getPropertyString(str);
            if (propertyString != null) {
                return propertyString;
            }
            throw new IllegalStateException(AbstractC0541b.m772n("No content found for requested property path: ", str));
        }

        private CharSequence getSubstring(MatchRange matchRange) {
            return getFullText().substring(matchRange.getStart(), matchRange.getEnd());
        }

        public CharSequence getExactMatch() {
            return getSubstring(getExactMatchRange());
        }

        public MatchRange getExactMatchRange() {
            if (this.mExactMatchRangeCached == null) {
                this.mExactMatchRangeCached = new MatchRange(this.mExactMatchRangeStart, this.mExactMatchRangeEnd);
            }
            return this.mExactMatchRangeCached;
        }

        public String getFullText() {
            if (this.mFullText == null) {
                GenericDocument genericDocument = this.mDocument;
                if (genericDocument == null) {
                    throw new IllegalStateException("Document has not been populated; this MatchInfo cannot be used yet");
                }
                this.mFullText = getPropertyValues(genericDocument, this.mPropertyPath);
            }
            return this.mFullText;
        }

        public String getPropertyPath() {
            return this.mPropertyPath;
        }

        public PropertyPath getPropertyPathObject() {
            if (this.mPropertyPathObject == null) {
                this.mPropertyPathObject = new PropertyPath(this.mPropertyPath);
            }
            return this.mPropertyPathObject;
        }

        public CharSequence getSnippet() {
            return getSubstring(getSnippetRange());
        }

        public MatchRange getSnippetRange() {
            if (this.mWindowRangeCached == null) {
                this.mWindowRangeCached = new MatchRange(this.mSnippetRangeStart, this.mSnippetRangeEnd);
            }
            return this.mWindowRangeCached;
        }

        public CharSequence getSubmatch() {
            checkSubmatchSupported();
            return getSubstring(getSubmatchRange());
        }

        public MatchRange getSubmatchRange() {
            checkSubmatchSupported();
            if (this.mSubmatchRangeCached == null) {
                this.mSubmatchRangeCached = new MatchRange(this.mSubmatchRangeStart, this.mSubmatchRangeEnd);
            }
            return this.mSubmatchRangeCached;
        }

        public void setDocument(GenericDocument genericDocument) {
            this.mDocument = genericDocument;
        }

        @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
        @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void writeToParcel(Parcel parcel, int i) {
            AbstractCreator.writeToParcel(this, parcel, i);
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder {
            private MatchRange mExactMatchRange;
            private final String mPropertyPath;
            private MatchRange mSnippetRange;
            int mSubmatchRangeEnd;
            int mSubmatchRangeStart;

            public Builder(String str) {
                this.mExactMatchRange = new MatchRange(0, 0);
                this.mSubmatchRangeStart = -1;
                this.mSubmatchRangeEnd = -1;
                this.mSnippetRange = new MatchRange(0, 0);
                this.mPropertyPath = (String) Preconditions.checkNotNull(str);
            }

            public MatchInfo build() {
                return new MatchInfo(this.mPropertyPath, this.mExactMatchRange.getStart(), this.mExactMatchRange.getEnd(), this.mSubmatchRangeStart, this.mSubmatchRangeEnd, this.mSnippetRange.getStart(), this.mSnippetRange.getEnd());
            }

            @CanIgnoreReturnValue
            public Builder setExactMatchRange(MatchRange matchRange) {
                this.mExactMatchRange = (MatchRange) Preconditions.checkNotNull(matchRange);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSnippetRange(MatchRange matchRange) {
                this.mSnippetRange = (MatchRange) Preconditions.checkNotNull(matchRange);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSubmatchRange(MatchRange matchRange) {
                this.mSubmatchRangeStart = matchRange.getStart();
                this.mSubmatchRangeEnd = matchRange.getEnd();
                return this;
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public Builder(MatchInfo matchInfo) {
                this.mExactMatchRange = new MatchRange(0, 0);
                this.mSubmatchRangeStart = -1;
                this.mSubmatchRangeEnd = -1;
                this.mSnippetRange = new MatchRange(0, 0);
                Preconditions.checkNotNull(matchInfo);
                this.mPropertyPath = matchInfo.mPropertyPath;
                this.mExactMatchRange = matchInfo.getExactMatchRange();
                this.mSubmatchRangeStart = matchInfo.mSubmatchRangeStart;
                this.mSubmatchRangeEnd = matchInfo.mSubmatchRangeEnd;
                this.mSnippetRange = matchInfo.getSnippetRange();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private boolean mBuilt;
        private final String mDatabaseName;
        private GenericDocument mGenericDocument;
        private List<Double> mInformationalRankingSignals;
        private List<SearchResult> mJoinedResults;
        private List<MatchInfo> mMatchInfos;
        private final String mPackageName;
        private Bundle mParentTypeMap;
        private double mRankingSignal;

        public Builder(String str, String str2) {
            this.mMatchInfos = new ArrayList();
            this.mInformationalRankingSignals = new ArrayList();
            this.mParentTypeMap = new Bundle();
            this.mJoinedResults = new ArrayList();
            this.mBuilt = false;
            this.mPackageName = (String) Preconditions.checkNotNull(str);
            this.mDatabaseName = (String) Preconditions.checkNotNull(str2);
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mMatchInfos = new ArrayList(this.mMatchInfos);
                this.mJoinedResults = new ArrayList(this.mJoinedResults);
                this.mInformationalRankingSignals = new ArrayList(this.mInformationalRankingSignals);
                this.mParentTypeMap = BundleUtil.deepCopy(this.mParentTypeMap);
                this.mBuilt = false;
            }
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_INFORMATIONAL_RANKING_EXPRESSIONS)
        public Builder addInformationalRankingSignal(double d) {
            resetIfBuilt();
            this.mInformationalRankingSignals.add(Double.valueOf(d));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addJoinedResult(SearchResult searchResult) {
            resetIfBuilt();
            this.mJoinedResults.add(searchResult);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addMatchInfo(MatchInfo matchInfo) {
            Preconditions.checkState(matchInfo.mDocument == null, "This MatchInfo is already associated with a SearchResult and can't be reassigned");
            resetIfBuilt();
            this.mMatchInfos.add(matchInfo);
            return this;
        }

        public SearchResult build() {
            this.mBuilt = true;
            return new SearchResult(this.mGenericDocument.getDocumentParcel(), this.mMatchInfos, this.mPackageName, this.mDatabaseName, this.mRankingSignal, this.mJoinedResults, this.mInformationalRankingSignals, this.mParentTypeMap);
        }

        @CanIgnoreReturnValue
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder clearJoinedResults() {
            resetIfBuilt();
            this.mJoinedResults.clear();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDocument(Object obj) {
            Preconditions.checkNotNull(obj);
            resetIfBuilt();
            return setGenericDocument(GenericDocument.fromDocumentClass(obj));
        }

        @CanIgnoreReturnValue
        public Builder setGenericDocument(GenericDocument genericDocument) {
            Preconditions.checkNotNull(genericDocument);
            resetIfBuilt();
            this.mGenericDocument = genericDocument;
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_SEARCH_RESULT_PARENT_TYPES)
        public Builder setParentTypeMap(Map<String, List<String>> map) {
            Preconditions.checkNotNull(map);
            resetIfBuilt();
            this.mParentTypeMap.clear();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                Preconditions.checkNotNull(entry.getKey());
                Preconditions.checkNotNull(entry.getValue());
                ArrayList<String> arrayList = new ArrayList<>(entry.getValue().size());
                for (int i = 0; i < entry.getValue().size(); i++) {
                    arrayList.add((String) Preconditions.checkNotNull(entry.getValue().get(i)));
                }
                this.mParentTypeMap.putStringArrayList(entry.getKey(), arrayList);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setRankingSignal(double d) {
            resetIfBuilt();
            this.mRankingSignal = d;
            return this;
        }

        @OptIn(markerClass = {ExperimentalAppSearchApi.class})
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(SearchResult searchResult) {
            this.mMatchInfos = new ArrayList();
            this.mInformationalRankingSignals = new ArrayList();
            this.mParentTypeMap = new Bundle();
            this.mJoinedResults = new ArrayList();
            this.mBuilt = false;
            Preconditions.checkNotNull(searchResult);
            this.mPackageName = searchResult.getPackageName();
            this.mDatabaseName = searchResult.getDatabaseName();
            this.mGenericDocument = searchResult.getGenericDocument();
            this.mRankingSignal = searchResult.getRankingSignal();
            this.mInformationalRankingSignals = new ArrayList(searchResult.getInformationalRankingSignals());
            setParentTypeMap(searchResult.getParentTypeMap());
            List<MatchInfo> matchInfos = searchResult.getMatchInfos();
            for (int i = 0; i < matchInfos.size(); i++) {
                addMatchInfo(new MatchInfo.Builder(matchInfos.get(i)).build());
            }
            List<SearchResult> joinedResults = searchResult.getJoinedResults();
            for (int i2 = 0; i2 < joinedResults.size(); i2++) {
                addJoinedResult(joinedResults.get(i2));
            }
        }
    }
}
