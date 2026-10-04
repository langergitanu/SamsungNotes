package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.app.SearchSpec;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "JoinSpecCreator")
public final class JoinSpec extends AbstractSafeParcelable {
    public static final int AGGREGATION_SCORING_AVG_RANKING_SIGNAL = 3;
    public static final int AGGREGATION_SCORING_MAX_RANKING_SIGNAL = 4;
    public static final int AGGREGATION_SCORING_MIN_RANKING_SIGNAL = 2;
    public static final int AGGREGATION_SCORING_OUTER_RESULT_RANKING_SIGNAL = 0;
    public static final int AGGREGATION_SCORING_RESULT_COUNT = 1;
    public static final int AGGREGATION_SCORING_SUM_RANKING_SIGNAL = 5;

    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<JoinSpec> CREATOR = new StubCreators.JoinSpecCreator();
    private static final int DEFAULT_MAX_JOINED_RESULT_COUNT = 10;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String QUALIFIED_ID = "this.qualifiedId()";

    @AbstractSafeParcelable.Field(getter = "getAggregationScoringStrategy", m1109id = 5)
    private final int mAggregationScoringStrategy;

    @AbstractSafeParcelable.Field(getter = "getChildPropertyExpression", m1109id = 3)
    private final String mChildPropertyExpression;

    @AbstractSafeParcelable.Field(getter = "getMaxJoinedResultCount", m1109id = 4)
    private final int mMaxJoinedResultCount;

    @AbstractSafeParcelable.Field(getter = "getNestedQuery", m1109id = 1)
    private final String mNestedQuery;

    @AbstractSafeParcelable.Field(getter = "getNestedSearchSpec", m1109id = 2)
    private final SearchSpec mNestedSearchSpec;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AggregationScoringStrategy {
    }

    @AbstractSafeParcelable.Constructor
    public JoinSpec(@AbstractSafeParcelable.Param(m1110id = 1) String str, @AbstractSafeParcelable.Param(m1110id = 2) SearchSpec searchSpec, @AbstractSafeParcelable.Param(m1110id = 3) String str2, @AbstractSafeParcelable.Param(m1110id = 4) int i, @AbstractSafeParcelable.Param(m1110id = 5) int i2) {
        Objects.requireNonNull(str);
        this.mNestedQuery = str;
        Objects.requireNonNull(searchSpec);
        this.mNestedSearchSpec = searchSpec;
        Objects.requireNonNull(str2);
        this.mChildPropertyExpression = str2;
        this.mMaxJoinedResultCount = i;
        this.mAggregationScoringStrategy = i2;
    }

    public int getAggregationScoringStrategy() {
        return this.mAggregationScoringStrategy;
    }

    public String getChildPropertyExpression() {
        return this.mChildPropertyExpression;
    }

    public int getMaxJoinedResultCount() {
        return this.mMaxJoinedResultCount;
    }

    public String getNestedQuery() {
        return this.mNestedQuery;
    }

    public SearchSpec getNestedSearchSpec() {
        return this.mNestedSearchSpec;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private static final SearchSpec EMPTY_SEARCH_SPEC = new SearchSpec.Builder().build();
        private int mAggregationScoringStrategy;
        private String mChildPropertyExpression;
        private int mMaxJoinedResultCount;
        private String mNestedQuery;
        private SearchSpec mNestedSearchSpec;

        public Builder(String str) {
            this.mNestedQuery = "";
            this.mNestedSearchSpec = EMPTY_SEARCH_SPEC;
            this.mMaxJoinedResultCount = 10;
            this.mAggregationScoringStrategy = 0;
            Preconditions.checkNotNull(str);
            this.mChildPropertyExpression = str;
        }

        public JoinSpec build() {
            return new JoinSpec(this.mNestedQuery, this.mNestedSearchSpec, this.mChildPropertyExpression, this.mMaxJoinedResultCount, this.mAggregationScoringStrategy);
        }

        @CanIgnoreReturnValue
        public Builder setAggregationScoringStrategy(int i) {
            Preconditions.checkArgumentInRange(i, 0, 5, "aggregationScoringStrategy");
            this.mAggregationScoringStrategy = i;
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder setChildPropertyExpression(String str) {
            Preconditions.checkNotNull(str);
            this.mChildPropertyExpression = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMaxJoinedResultCount(int i) {
            this.mMaxJoinedResultCount = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setNestedSearch(String str, SearchSpec searchSpec) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(searchSpec);
            this.mNestedQuery = str;
            this.mNestedSearchSpec = searchSpec;
            return this;
        }

        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder(JoinSpec joinSpec) {
            this.mNestedQuery = "";
            this.mNestedSearchSpec = EMPTY_SEARCH_SPEC;
            this.mMaxJoinedResultCount = 10;
            this.mAggregationScoringStrategy = 0;
            Preconditions.checkNotNull(joinSpec);
            this.mNestedQuery = joinSpec.getNestedQuery();
            this.mNestedSearchSpec = joinSpec.getNestedSearchSpec();
            this.mChildPropertyExpression = joinSpec.getChildPropertyExpression();
            this.mMaxJoinedResultCount = joinSpec.getMaxJoinedResultCount();
            this.mAggregationScoringStrategy = joinSpec.getAggregationScoringStrategy();
        }
    }
}
