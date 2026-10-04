package androidx.appsearch.usagereporting;

import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document(name = C$$__AppSearch__TakenAction.SCHEMA_NAME)
@ExperimentalAppSearchApi
public abstract class TakenAction {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final long DEFAULT_DOCUMENT_TTL_MILLIS = 5184000000L;

    @Document.CreationTimestampMillis
    private final long mActionTimestampMillis;

    @Document.LongProperty
    private final int mActionType;

    @Document.TtlMillis
    private final long mDocumentTtlMillis;

    @Document.InterfaceC0555Id
    private final String mId;

    @Document.Namespace
    private final String mNamespace;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ActionType {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Document.BuilderProducer
    public static final class Builder extends BuilderImpl<Builder> {
        public Builder(String str, String str2, long j, int i) {
            super(str, str2, j, i);
        }

        public Builder(TakenAction takenAction) {
            super(takenAction);
        }
    }

    public TakenAction(String str, String str2, long j, long j2, int i) {
        this.mNamespace = (String) Preconditions.checkNotNull(str);
        this.mId = (String) Preconditions.checkNotNull(str2);
        this.mDocumentTtlMillis = j;
        this.mActionTimestampMillis = j2;
        this.mActionType = i;
    }

    public long getActionTimestampMillis() {
        return this.mActionTimestampMillis;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getActionType() {
        return this.mActionType;
    }

    public long getDocumentTtlMillis() {
        return this.mDocumentTtlMillis;
    }

    public String getId() {
        return this.mId;
    }

    public String getNamespace() {
        return this.mNamespace;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BuilderImpl<T extends BuilderImpl<T>> {
        protected long mActionTimestampMillis;
        protected int mActionType;
        protected long mDocumentTtlMillis;
        protected final String mId;
        protected final String mNamespace;

        public BuilderImpl(String str, String str2, long j, int i) {
            this.mNamespace = (String) Preconditions.checkNotNull(str);
            this.mId = (String) Preconditions.checkNotNull(str2);
            this.mActionTimestampMillis = j;
            this.mActionType = i;
            this.mDocumentTtlMillis = TakenAction.DEFAULT_DOCUMENT_TTL_MILLIS;
        }

        public TakenAction build() {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        public T setDocumentTtlMillis(long j) {
            this.mDocumentTtlMillis = j;
            return this;
        }

        public BuilderImpl(TakenAction takenAction) {
            this(takenAction.getNamespace(), takenAction.getId(), takenAction.getActionTimestampMillis(), takenAction.getActionType());
            this.mDocumentTtlMillis = takenAction.getDocumentTtlMillis();
        }
    }
}
