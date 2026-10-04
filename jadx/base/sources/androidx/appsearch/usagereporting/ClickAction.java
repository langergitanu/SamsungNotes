package androidx.appsearch.usagereporting;

import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.usagereporting.TakenAction;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document(name = C$$__AppSearch__ClickAction.SCHEMA_NAME)
@ExperimentalAppSearchApi
public class ClickAction extends TakenAction {

    @Document.StringProperty(indexingType = 2)
    private final String mQuery;

    @Document.StringProperty(joinableValueType = 1)
    private final String mReferencedQualifiedId;

    @Document.LongProperty
    private final int mResultRankGlobal;

    @Document.LongProperty
    private final int mResultRankInBlock;

    @Document.LongProperty
    private final long mTimeStayOnResultMillis;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Document.BuilderProducer
    public static final class Builder extends TakenAction.BuilderImpl<Builder> {
        private String mQuery;
        private String mReferencedQualifiedId;
        private int mResultRankGlobal;
        private int mResultRankInBlock;
        private long mTimeStayOnResultMillis;

        public Builder(String str, String str2, long j) {
            this(str, str2, j, 2);
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ TakenAction.BuilderImpl setDocumentTtlMillis(long j) {
            return super.setDocumentTtlMillis(j);
        }

        @CanIgnoreReturnValue
        public Builder setQuery(String str) {
            this.mQuery = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setReferencedQualifiedId(String str) {
            this.mReferencedQualifiedId = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setResultRankGlobal(int i) {
            this.mResultRankGlobal = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setResultRankInBlock(int i) {
            this.mResultRankInBlock = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTimeStayOnResultMillis(long j) {
            this.mTimeStayOnResultMillis = j;
            return this;
        }

        public Builder(ClickAction clickAction) {
            super((TakenAction) Preconditions.checkNotNull(clickAction));
            this.mQuery = clickAction.getQuery();
            this.mReferencedQualifiedId = clickAction.getReferencedQualifiedId();
            this.mResultRankInBlock = clickAction.getResultRankInBlock();
            this.mResultRankGlobal = clickAction.getResultRankGlobal();
            this.mTimeStayOnResultMillis = clickAction.getTimeStayOnResultMillis();
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        public ClickAction build() {
            return new ClickAction(this.mNamespace, this.mId, this.mDocumentTtlMillis, this.mActionTimestampMillis, this.mActionType, this.mQuery, this.mReferencedQualifiedId, this.mResultRankInBlock, this.mResultRankGlobal, this.mTimeStayOnResultMillis);
        }

        public Builder(String str, String str2, long j, int i) {
            super(str, str2, j, i);
            this.mResultRankInBlock = -1;
            this.mResultRankGlobal = -1;
            this.mTimeStayOnResultMillis = -1L;
        }
    }

    public ClickAction(String str, String str2, long j, long j2, int i, String str3, String str4, int i2, int i4, long j3) {
        super(str, str2, j, j2, i);
        this.mQuery = str3;
        this.mReferencedQualifiedId = str4;
        this.mResultRankInBlock = i2;
        this.mResultRankGlobal = i4;
        this.mTimeStayOnResultMillis = j3;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public String getReferencedQualifiedId() {
        return this.mReferencedQualifiedId;
    }

    public int getResultRankGlobal() {
        return this.mResultRankGlobal;
    }

    public int getResultRankInBlock() {
        return this.mResultRankInBlock;
    }

    public long getTimeStayOnResultMillis() {
        return this.mTimeStayOnResultMillis;
    }
}
