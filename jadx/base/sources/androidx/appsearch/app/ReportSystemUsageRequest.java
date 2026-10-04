package androidx.appsearch.app;

import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class ReportSystemUsageRequest {
    private final String mDatabase;
    private final String mDocumentId;
    private final String mNamespace;
    private final String mPackageName;
    private final long mUsageTimestampMillis;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private final String mDatabase;
        private final String mDocumentId;
        private final String mNamespace;
        private final String mPackageName;
        private Long mUsageTimestampMillis;

        public Builder(String str, String str2, String str3, String str4) {
            this.mPackageName = (String) Preconditions.checkNotNull(str);
            this.mDatabase = (String) Preconditions.checkNotNull(str2);
            this.mNamespace = (String) Preconditions.checkNotNull(str3);
            this.mDocumentId = (String) Preconditions.checkNotNull(str4);
        }

        public ReportSystemUsageRequest build() {
            if (this.mUsageTimestampMillis == null) {
                this.mUsageTimestampMillis = Long.valueOf(System.currentTimeMillis());
            }
            return new ReportSystemUsageRequest(this.mPackageName, this.mDatabase, this.mNamespace, this.mDocumentId, this.mUsageTimestampMillis.longValue());
        }

        @CanIgnoreReturnValue
        public Builder setUsageTimestampMillis(long j) {
            this.mUsageTimestampMillis = Long.valueOf(j);
            return this;
        }
    }

    public ReportSystemUsageRequest(String str, String str2, String str3, String str4, long j) {
        this.mPackageName = (String) Preconditions.checkNotNull(str);
        this.mDatabase = (String) Preconditions.checkNotNull(str2);
        this.mNamespace = (String) Preconditions.checkNotNull(str3);
        this.mDocumentId = (String) Preconditions.checkNotNull(str4);
        this.mUsageTimestampMillis = j;
    }

    public String getDatabaseName() {
        return this.mDatabase;
    }

    public String getDocumentId() {
        return this.mDocumentId;
    }

    public String getNamespace() {
        return this.mNamespace;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public long getUsageTimestampMillis() {
        return this.mUsageTimestampMillis;
    }
}
