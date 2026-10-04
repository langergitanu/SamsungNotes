package androidx.appsearch.builtintypes;

import androidx.annotation.IntRange;
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
@Document(name = C$$__AppSearch__Alarm.SCHEMA_NAME)
public class Alarm extends Thing {
    public static final int ORIGINATING_DEVICE_SMART_PHONE = 1;
    public static final int ORIGINATING_DEVICE_SMART_WATCH = 2;
    public static final int ORIGINATING_DEVICE_UNKNOWN = 0;

    @Document.StringProperty
    private final String mBlackoutPeriodEndDate;

    @Document.StringProperty
    private final String mBlackoutPeriodStartDate;

    @Document.LongProperty
    private final int[] mDaysOfWeek;

    @Document.BooleanProperty
    private final boolean mEnabled;

    @Document.LongProperty
    private final int mHour;

    @Document.LongProperty
    private final int mMinute;

    @Document.DocumentProperty
    private final AlarmInstance mNextInstance;

    @Document.LongProperty(name = "computingDevice")
    private final int mOriginatingDevice;

    @Document.DocumentProperty
    private final AlarmInstance mPreviousInstance;

    @Document.StringProperty
    private final String mRingtone;

    @Document.BooleanProperty
    private final boolean mShouldVibrate;

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

        @Override // androidx.appsearch.builtintypes.Alarm.BuilderImpl, androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Alarm build() {
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

        @Override // androidx.appsearch.builtintypes.Alarm.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setBlackoutPeriodEndDate(String str) {
            return super.setBlackoutPeriodEndDate(str);
        }

        @Override // androidx.appsearch.builtintypes.Alarm.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setBlackoutPeriodStartDate(String str) {
            return super.setBlackoutPeriodStartDate(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setCreationTimestampMillis(long j) {
            return super.setCreationTimestampMillis(j);
        }

        @Override // androidx.appsearch.builtintypes.Alarm.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setDaysOfWeek(@IntRange(from = 1, m706to = 7) int[] iArr) {
            return super.setDaysOfWeek(iArr);
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

        @Override // androidx.appsearch.builtintypes.Alarm.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setEnabled(boolean z) {
            return super.setEnabled(z);
        }

        @Override // androidx.appsearch.builtintypes.Alarm.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setHour(@IntRange(from = 0, m706to = 23) int i) {
            return super.setHour(i);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setImage(String str) {
            return super.setImage(str);
        }

        @Override // androidx.appsearch.builtintypes.Alarm.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setMinute(@IntRange(from = 0, m706to = 59) int i) {
            return super.setMinute(i);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setName(String str) {
            return super.setName(str);
        }

        @Override // androidx.appsearch.builtintypes.Alarm.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setNextInstance(AlarmInstance alarmInstance) {
            return super.setNextInstance(alarmInstance);
        }

        @Override // androidx.appsearch.builtintypes.Alarm.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setOriginatingDevice(int i) {
            return super.setOriginatingDevice(i);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setPotentialActions(List list) {
            return super.setPotentialActions(list);
        }

        @Override // androidx.appsearch.builtintypes.Alarm.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setPreviousInstance(AlarmInstance alarmInstance) {
            return super.setPreviousInstance(alarmInstance);
        }

        @Override // androidx.appsearch.builtintypes.Alarm.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setRingtone(String str) {
            return super.setRingtone(str);
        }

        @Override // androidx.appsearch.builtintypes.Alarm.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setShouldVibrate(boolean z) {
            return super.setShouldVibrate(z);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setUrl(String str) {
            return super.setUrl(str);
        }

        public Builder(Alarm alarm) {
            super(alarm);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BuilderImpl<T extends BuilderImpl<T>> extends Thing.BuilderImpl<T> {
        protected String mBlackoutPeriodEndDate;
        protected String mBlackoutPeriodStartDate;
        protected int[] mDaysOfWeek;
        protected boolean mEnabled;
        protected int mHour;
        protected int mMinute;
        protected AlarmInstance mNextInstance;
        protected int mOriginatingDevice;
        protected AlarmInstance mPreviousInstance;
        protected String mRingtone;
        protected boolean mShouldVibrate;

        public BuilderImpl(String str, String str2) {
            super(str, str2);
        }

        public T setBlackoutPeriodEndDate(String str) {
            if (str != null) {
                Preconditions.checkArgument(DateTimeFormatValidator.validateISO8601Date(str), "blackoutPeriodEndDate must be in the format: yyyy-MM-dd");
            }
            this.mBlackoutPeriodEndDate = str;
            return this;
        }

        public T setBlackoutPeriodStartDate(String str) {
            if (str != null) {
                Preconditions.checkArgument(DateTimeFormatValidator.validateISO8601Date(str), "blackoutPeriodStartDate must be in the format: yyyy-MM-dd");
            }
            this.mBlackoutPeriodStartDate = str;
            return this;
        }

        public T setDaysOfWeek(@IntRange(from = 1, m706to = 7) int... iArr) {
            if (iArr != null) {
                for (int i : iArr) {
                    Preconditions.checkArgumentInRange(i, 1, 7, "daysOfWeek");
                }
            }
            this.mDaysOfWeek = iArr;
            return this;
        }

        public T setEnabled(boolean z) {
            this.mEnabled = z;
            return this;
        }

        public T setHour(@IntRange(from = 0, m706to = 23) int i) {
            this.mHour = Preconditions.checkArgumentInRange(i, 0, 23, "hour");
            return this;
        }

        public T setMinute(@IntRange(from = 0, m706to = 59) int i) {
            this.mMinute = Preconditions.checkArgumentInRange(i, 0, 59, "minute");
            return this;
        }

        public T setNextInstance(AlarmInstance alarmInstance) {
            this.mNextInstance = alarmInstance;
            return this;
        }

        public T setOriginatingDevice(int i) {
            this.mOriginatingDevice = i;
            return this;
        }

        public T setPreviousInstance(AlarmInstance alarmInstance) {
            this.mPreviousInstance = alarmInstance;
            return this;
        }

        public T setRingtone(String str) {
            this.mRingtone = str;
            return this;
        }

        public T setShouldVibrate(boolean z) {
            this.mShouldVibrate = z;
            return this;
        }

        public BuilderImpl(Alarm alarm) {
            super(new Thing.Builder(alarm).build());
            this.mEnabled = alarm.isEnabled();
            this.mDaysOfWeek = alarm.getDaysOfWeek();
            this.mHour = alarm.getHour();
            this.mMinute = alarm.getMinute();
            this.mBlackoutPeriodStartDate = alarm.getBlackoutPeriodStartDate();
            this.mBlackoutPeriodEndDate = alarm.getBlackoutPeriodEndDate();
            this.mRingtone = alarm.getRingtone();
            this.mShouldVibrate = alarm.shouldVibrate();
            this.mPreviousInstance = alarm.getPreviousInstance();
            this.mNextInstance = alarm.getNextInstance();
            this.mOriginatingDevice = alarm.getOriginatingDevice();
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public Alarm build() {
            return new Alarm(this.mNamespace, this.mId, this.mDocumentScore, this.mCreationTimestampMillis, this.mDocumentTtlMillis, this.mName, this.mAlternateNames, this.mDescription, this.mImage, this.mUrl, this.mPotentialActions, this.mEnabled, this.mDaysOfWeek, this.mHour, this.mMinute, this.mBlackoutPeriodStartDate, this.mBlackoutPeriodEndDate, this.mRingtone, this.mShouldVibrate, this.mPreviousInstance, this.mNextInstance, this.mOriginatingDevice);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface OriginatingDevice {
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public Alarm(String str, String str2, int i, long j, long j2, String str3, List<String> list, String str4, String str5, String str6, List<PotentialAction> list2, boolean z, int[] iArr, int i2, int i4, String str7, String str8, String str9, boolean z2, AlarmInstance alarmInstance, AlarmInstance alarmInstance2, int i5) {
        super(str, str2, i, j, j2, str3, list, str4, str5, str6, list2);
        this.mEnabled = z;
        this.mDaysOfWeek = iArr;
        this.mHour = i2;
        this.mMinute = i4;
        this.mBlackoutPeriodStartDate = str7;
        this.mBlackoutPeriodEndDate = str8;
        this.mRingtone = str9;
        this.mShouldVibrate = z2;
        this.mPreviousInstance = alarmInstance;
        this.mNextInstance = alarmInstance2;
        this.mOriginatingDevice = i5;
    }

    public String getBlackoutPeriodEndDate() {
        return this.mBlackoutPeriodEndDate;
    }

    public String getBlackoutPeriodStartDate() {
        return this.mBlackoutPeriodStartDate;
    }

    public int[] getDaysOfWeek() {
        return this.mDaysOfWeek;
    }

    @IntRange(from = 0, m706to = 23)
    public int getHour() {
        return this.mHour;
    }

    @IntRange(from = 0, m706to = 59)
    public int getMinute() {
        return this.mMinute;
    }

    public AlarmInstance getNextInstance() {
        return this.mNextInstance;
    }

    public int getOriginatingDevice() {
        return this.mOriginatingDevice;
    }

    public AlarmInstance getPreviousInstance() {
        return this.mPreviousInstance;
    }

    public String getRingtone() {
        return this.mRingtone;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean shouldVibrate() {
        return this.mShouldVibrate;
    }
}
