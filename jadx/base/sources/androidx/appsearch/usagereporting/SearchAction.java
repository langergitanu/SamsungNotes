package androidx.appsearch.usagereporting;

import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.usagereporting.TakenAction;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document(name = C$$__AppSearch__SearchAction.SCHEMA_NAME)
@ExperimentalAppSearchApi
public class SearchAction extends TakenAction {

    @Document.LongProperty
    private final int mFetchedResultCount;

    @Document.StringProperty(indexingType = 2)
    private final String mQuery;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Document.BuilderProducer
    public static final class Builder extends TakenAction.BuilderImpl<Builder> {
        private int mFetchedResultCount;
        private String mQuery;

        public Builder(String str, String str2, long j) {
            this(str, str2, j, 1);
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ TakenAction.BuilderImpl setDocumentTtlMillis(long j) {
            return super.setDocumentTtlMillis(j);
        }

        @CanIgnoreReturnValue
        public Builder setFetchedResultCount(int i) {
            this.mFetchedResultCount = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setQuery(String str) {
            this.mQuery = str;
            return this;
        }

        public Builder(SearchAction searchAction) {
            super((TakenAction) Preconditions.checkNotNull(searchAction));
            this.mQuery = searchAction.getQuery();
            this.mFetchedResultCount = searchAction.getFetchedResultCount();
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        public SearchAction build() {
            return new SearchAction(this.mNamespace, this.mId, this.mDocumentTtlMillis, this.mActionTimestampMillis, this.mActionType, this.mQuery, this.mFetchedResultCount);
        }

        public Builder(String str, String str2, long j, int i) {
            super(str, str2, j, i);
            this.mFetchedResultCount = -1;
        }
    }

    public SearchAction(String str, String str2, long j, long j2, int i, String str3, int i2) {
        super(str, str2, j, j2, i);
        this.mQuery = str3;
        this.mFetchedResultCount = i2;
    }

    public int getFetchedResultCount() {
        return this.mFetchedResultCount;
    }

    public String getQuery() {
        return this.mQuery;
    }
}
