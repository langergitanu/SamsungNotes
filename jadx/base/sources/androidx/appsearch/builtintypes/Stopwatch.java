package androidx.appsearch.builtintypes;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.builtintypes.Thing;
import androidx.appsearch.utils.BootCountUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document(name = C$$__AppSearch__Stopwatch.SCHEMA_NAME)
public class Stopwatch extends Thing {
    public static final int STATUS_PAUSED = 3;
    public static final int STATUS_RESET = 1;
    public static final int STATUS_RUNNING = 2;
    public static final int STATUS_UNKNOWN = 0;

    @Document.LongProperty
    private final long mAccumulatedDurationMillis;

    @Document.LongProperty
    private final long mBaseTimeMillis;

    @Document.LongProperty
    private final long mBaseTimeMillisInElapsedRealtime;

    @Document.LongProperty
    private final int mBootCount;

    @Document.DocumentProperty
    private final List<StopwatchLap> mLaps;

    @Document.LongProperty
    private final int mStatus;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
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

        @Override // androidx.appsearch.builtintypes.Stopwatch.BuilderImpl, androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Stopwatch build() {
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

        @Override // androidx.appsearch.builtintypes.Stopwatch.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setAccumulatedDurationMillis(long j) {
            return super.setAccumulatedDurationMillis(j);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setAlternateNames(List list) {
            return super.setAlternateNames(list);
        }

        @Override // androidx.appsearch.builtintypes.Stopwatch.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setBaseTimeMillis(long j, long j2, int i) {
            return super.setBaseTimeMillis(j, j2, i);
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

        @Override // androidx.appsearch.builtintypes.Stopwatch.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setLaps(List list) {
            return super.setLaps(list);
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

        @Override // androidx.appsearch.builtintypes.Stopwatch.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setStatus(int i) {
            return super.setStatus(i);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setUrl(String str) {
            return super.setUrl(str);
        }

        public Builder(Stopwatch stopwatch) {
            super(stopwatch);
        }

        @Override // androidx.appsearch.builtintypes.Stopwatch.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setBaseTimeMillis(Context context, long j, long j2) {
            return super.setBaseTimeMillis(context, j, j2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BuilderImpl<T extends BuilderImpl<T>> extends Thing.BuilderImpl<T> {
        protected long mAccumulatedDurationMillis;
        protected long mBaseTimeMillis;
        protected long mBaseTimeMillisInElapsedRealtime;
        protected int mBootCount;
        protected List<StopwatchLap> mLaps;
        protected int mStatus;

        public BuilderImpl(String str, String str2) {
            super(str, str2);
            this.mLaps = Collections.EMPTY_LIST;
        }

        public T setAccumulatedDurationMillis(long j) {
            this.mAccumulatedDurationMillis = j;
            return this;
        }

        public T setBaseTimeMillis(long j, long j2, int i) {
            this.mBaseTimeMillis = j;
            this.mBaseTimeMillisInElapsedRealtime = j2;
            this.mBootCount = i;
            return this;
        }

        public T setLaps(List<StopwatchLap> list) {
            this.mLaps = (List) Preconditions.checkNotNull(list);
            return this;
        }

        public T setStatus(int i) {
            this.mStatus = Preconditions.checkArgumentInRange(i, 0, 3, "status");
            return this;
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public Stopwatch build() {
            return new Stopwatch(this.mNamespace, this.mId, this.mDocumentScore, this.mCreationTimestampMillis, this.mDocumentTtlMillis, this.mName, this.mAlternateNames, this.mDescription, this.mImage, this.mUrl, this.mPotentialActions, this.mBaseTimeMillis, this.mBaseTimeMillisInElapsedRealtime, this.mBootCount, this.mStatus, this.mAccumulatedDurationMillis, this.mLaps);
        }

        public BuilderImpl(Stopwatch stopwatch) {
            super(new Thing.Builder(stopwatch).build());
            this.mBaseTimeMillis = stopwatch.getBaseTimeMillis();
            this.mBaseTimeMillisInElapsedRealtime = stopwatch.getBaseTimeMillisInElapsedRealtime();
            this.mBootCount = stopwatch.getBootCount();
            this.mStatus = stopwatch.getStatus();
            this.mAccumulatedDurationMillis = stopwatch.getAccumulatedDurationMillis();
            this.mLaps = stopwatch.getLaps();
        }

        public T setBaseTimeMillis(Context context, long j, long j2) {
            return (T) setBaseTimeMillis(j, j2, BootCountUtil.getCurrentBootCount(context));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Status {
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public Stopwatch(String str, String str2, int i, long j, long j2, String str3, List<String> list, String str4, String str5, String str6, List<PotentialAction> list2, long j3, long j5, int i2, int i4, long j6, List<StopwatchLap> list3) {
        super(str, str2, i, j, j2, str3, list, str4, str5, str6, list2);
        this.mBaseTimeMillis = j3;
        this.mBaseTimeMillisInElapsedRealtime = j5;
        this.mBootCount = i2;
        this.mStatus = i4;
        this.mAccumulatedDurationMillis = j6;
        this.mLaps = (List) Preconditions.checkNotNull(list3);
    }

    public long calculateBaseTimeMillis(Context context) {
        int currentBootCount = BootCountUtil.getCurrentBootCount(context);
        if (currentBootCount == -1 || currentBootCount != this.mBootCount) {
            return this.mBaseTimeMillis;
        }
        return System.currentTimeMillis() - (SystemClock.elapsedRealtime() - this.mBaseTimeMillisInElapsedRealtime);
    }

    public long calculateCurrentAccumulatedDurationMillis(Context context) {
        int i = this.mStatus;
        return (i == 3 || i == 1) ? this.mAccumulatedDurationMillis : (System.currentTimeMillis() - calculateBaseTimeMillis(context)) + this.mAccumulatedDurationMillis;
    }

    public long getAccumulatedDurationMillis() {
        return this.mAccumulatedDurationMillis;
    }

    public long getBaseTimeMillis() {
        return this.mBaseTimeMillis;
    }

    public long getBaseTimeMillisInElapsedRealtime() {
        return this.mBaseTimeMillisInElapsedRealtime;
    }

    public int getBootCount() {
        return this.mBootCount;
    }

    public List<StopwatchLap> getLaps() {
        return this.mLaps;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
