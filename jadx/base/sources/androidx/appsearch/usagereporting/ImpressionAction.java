package androidx.appsearch.usagereporting;

import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.usagereporting.TakenAction;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document(name = C$$__AppSearch__ImpressionAction.SCHEMA_NAME)
@ExperimentalAppSearchApi
public class ImpressionAction extends TakenAction {

    @Document.StringProperty(indexingType = 2)
    private final String mQuery;

    @Document.StringProperty(joinableValueType = 1)
    private final String mReferencedQualifiedId;

    @Document.LongProperty
    private final int mResultRankGlobal;

    @Document.LongProperty
    private final int mResultRankInBlock;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Document.BuilderProducer
    public static final class Builder extends TakenAction.BuilderImpl<Builder> {
        private String mQuery;
        private String mReferencedQualifiedId;
        private int mResultRankGlobal;
        private int mResultRankInBlock;

        public Builder(String str, String str2, long j) {
            this(str, str2, j, 3);
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

        public Builder(ImpressionAction impressionAction) {
            super((TakenAction) Preconditions.checkNotNull(impressionAction));
            this.mQuery = impressionAction.getQuery();
            this.mReferencedQualifiedId = impressionAction.getReferencedQualifiedId();
            this.mResultRankInBlock = impressionAction.getResultRankInBlock();
            this.mResultRankGlobal = impressionAction.getResultRankGlobal();
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        public ImpressionAction build() {
            return new ImpressionAction(this.mNamespace, this.mId, this.mDocumentTtlMillis, this.mActionTimestampMillis, this.mActionType, this.mQuery, this.mReferencedQualifiedId, this.mResultRankInBlock, this.mResultRankGlobal);
        }

        public Builder(String str, String str2, long j, int i) {
            super(str, str2, j, i);
            this.mResultRankInBlock = -1;
            this.mResultRankGlobal = -1;
        }
    }

    public ImpressionAction(String str, String str2, long j, long j2, int i, String str3, String str4, int i2, int i4) {
        super(str, str2, j, j2, i);
        this.mQuery = str3;
        this.mReferencedQualifiedId = str4;
        this.mResultRankInBlock = i2;
        this.mResultRankGlobal = i4;
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
}
