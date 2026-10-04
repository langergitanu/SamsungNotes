package androidx.appsearch.builtintypes;

import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.builtintypes.Thing;
import androidx.appsearch.utils.DateTimeFormatValidator;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document(name = C$$__AppSearch__AlarmInstance.SCHEMA_NAME)
public class AlarmInstance extends Thing {
    public static final int STATUS_DISMISSED = 3;
    public static final int STATUS_FIRING = 2;
    public static final int STATUS_MISSED = 5;
    public static final int STATUS_SCHEDULED = 1;
    public static final int STATUS_SNOOZED = 4;
    public static final int STATUS_UNKNOWN = 0;

    @Document.StringProperty
    private final String mScheduledTime;

    @Document.LongProperty
    private final long mSnoozeDurationMillis;

    @Document.LongProperty
    private final int mStatus;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Document.BuilderProducer
    public static final class Builder extends BuilderImpl<Builder> {
        public Builder(String str, String str2, String str3) {
            super(str, str2, str3);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl addAlternateName(String str) {
            return super.addAlternateName(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl addPotentialAction(PotentialAction potentialAction) {
            return super.addPotentialAction(potentialAction);
        }

        @Override // androidx.appsearch.builtintypes.AlarmInstance.BuilderImpl, androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ AlarmInstance build() {
            return super.build();
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl clearAlternateNames() {
            return super.clearAlternateNames();
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl clearPotentialActions() {
            return super.clearPotentialActions();
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setAlternateNames(List list) {
            return super.setAlternateNames(list);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setCreationTimestampMillis(long j) {
            return super.setCreationTimestampMillis(j);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setDescription(String str) {
            return super.setDescription(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setDocumentScore(int i) {
            return super.setDocumentScore(i);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setDocumentTtlMillis(long j) {
            return super.setDocumentTtlMillis(j);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setImage(String str) {
            return super.setImage(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setName(String str) {
            return super.setName(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setPotentialActions(List list) {
            return super.setPotentialActions(list);
        }

        @Override // androidx.appsearch.builtintypes.AlarmInstance.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setSnoozeDurationMillis(long j) {
            return super.setSnoozeDurationMillis(j);
        }

        @Override // androidx.appsearch.builtintypes.AlarmInstance.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setStatus(int i) {
            return super.setStatus(i);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setUrl(String str) {
            return super.setUrl(str);
        }

        public Builder(AlarmInstance alarmInstance) {
            super(alarmInstance);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BuilderImpl<T extends BuilderImpl<T>> extends Thing.BuilderImpl<T> {
        protected final String mScheduledTime;
        protected long mSnoozeDurationMillis;
        protected int mStatus;

        public BuilderImpl(String str, String str2, String str3) {
            super(str, str2);
            Preconditions.checkNotNull(str3);
            Preconditions.checkArgument(DateTimeFormatValidator.validateISO8601DateTime(str3), "scheduledTime must be in the format: yyyy-MM-ddTHH:mm:ss");
            this.mScheduledTime = str3;
            this.mSnoozeDurationMillis = -1L;
        }

        public T setSnoozeDurationMillis(long j) {
            this.mSnoozeDurationMillis = j;
            return this;
        }

        public T setStatus(int i) {
            this.mStatus = i;
            return this;
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public AlarmInstance build() {
            return new AlarmInstance(this.mNamespace, this.mId, this.mDocumentScore, this.mCreationTimestampMillis, this.mDocumentTtlMillis, this.mName, this.mAlternateNames, this.mDescription, this.mImage, this.mUrl, this.mPotentialActions, this.mScheduledTime, this.mStatus, this.mSnoozeDurationMillis);
        }

        public BuilderImpl(AlarmInstance alarmInstance) {
            super(new Thing.Builder(alarmInstance).build());
            this.mScheduledTime = alarmInstance.getScheduledTime();
            this.mStatus = alarmInstance.getStatus();
            this.mSnoozeDurationMillis = alarmInstance.getSnoozeDurationMillis();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Status {
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public AlarmInstance(String str, String str2, int i, long j, long j2, String str3, List<String> list, String str4, String str5, String str6, List<PotentialAction> list2, String str7, int i2, long j3) {
        super(str, str2, i, j, j2, str3, list, str4, str5, str6, list2);
        this.mScheduledTime = (String) Preconditions.checkNotNull(str7);
        this.mStatus = i2;
        this.mSnoozeDurationMillis = j3;
    }

    public String getScheduledTime() {
        return this.mScheduledTime;
    }

    public long getSnoozeDurationMillis() {
        return this.mSnoozeDurationMillis;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
