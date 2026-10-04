package androidx.appsearch.builtintypes;

import androidx.annotation.OptIn;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.builtintypes.Thing;
import androidx.core.util.Preconditions;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document(name = C$$__AppSearch__StopwatchLap.SCHEMA_NAME)
public class StopwatchLap extends Thing {

    @Document.LongProperty
    private final long mAccumulatedLapDurationMillis;

    @Document.LongProperty
    private final long mLapDurationMillis;

    @Document.LongProperty
    private final int mLapNumber;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Document.BuilderProducer
    public static final class Builder extends BuilderImpl<Builder> {
        public Builder(String str, String str2) {
            super(str, str2);
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

        @Override // androidx.appsearch.builtintypes.StopwatchLap.BuilderImpl, androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ StopwatchLap build() {
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

        @Override // androidx.appsearch.builtintypes.StopwatchLap.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setAccumulatedLapDurationMillis(long j) {
            return super.setAccumulatedLapDurationMillis(j);
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

        @Override // androidx.appsearch.builtintypes.StopwatchLap.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setLapDurationMillis(long j) {
            return super.setLapDurationMillis(j);
        }

        @Override // androidx.appsearch.builtintypes.StopwatchLap.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setLapNumber(int i) {
            return super.setLapNumber(i);
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

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setUrl(String str) {
            return super.setUrl(str);
        }

        public Builder(StopwatchLap stopwatchLap) {
            super(stopwatchLap);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BuilderImpl<T extends BuilderImpl<T>> extends Thing.BuilderImpl<T> {
        protected long mAccumulatedLapDurationMillis;
        protected long mLapDurationMillis;
        protected int mLapNumber;

        public BuilderImpl(String str, String str2) {
            super(str, str2);
        }

        public T setAccumulatedLapDurationMillis(long j) {
            this.mAccumulatedLapDurationMillis = j;
            return this;
        }

        public T setLapDurationMillis(long j) {
            this.mLapDurationMillis = j;
            return this;
        }

        public T setLapNumber(int i) {
            Preconditions.checkArgument(i >= 1, "Lap number must start at 1");
            this.mLapNumber = i;
            return this;
        }

        public BuilderImpl(StopwatchLap stopwatchLap) {
            super(new Thing.Builder(stopwatchLap).build());
            this.mLapNumber = stopwatchLap.getLapNumber();
            this.mLapDurationMillis = stopwatchLap.getLapDurationMillis();
            this.mAccumulatedLapDurationMillis = stopwatchLap.getAccumulatedLapDurationMillis();
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public StopwatchLap build() {
            return new StopwatchLap(this.mNamespace, this.mId, this.mDocumentScore, this.mCreationTimestampMillis, this.mDocumentTtlMillis, this.mName, this.mAlternateNames, this.mDescription, this.mImage, this.mUrl, this.mPotentialActions, this.mLapNumber, this.mLapDurationMillis, this.mAccumulatedLapDurationMillis);
        }
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public StopwatchLap(String str, String str2, int i, long j, long j2, String str3, List<String> list, String str4, String str5, String str6, List<PotentialAction> list2, int i2, long j3, long j5) {
        super(str, str2, i, j, j2, str3, list, str4, str5, str6, list2);
        this.mLapNumber = i2;
        this.mLapDurationMillis = j3;
        this.mAccumulatedLapDurationMillis = j5;
    }

    public long getAccumulatedLapDurationMillis() {
        return this.mAccumulatedLapDurationMillis;
    }

    public long getLapDurationMillis() {
        return this.mLapDurationMillis;
    }

    public int getLapNumber() {
        return this.mLapNumber;
    }
}
