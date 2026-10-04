package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Constraints;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableConstraints implements Parcelable {
    public static final Parcelable.Creator<ParcelableConstraints> CREATOR = new Parcelable.Creator<ParcelableConstraints>() { // from class: androidx.work.multiprocess.parcelable.ParcelableConstraints.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableConstraints createFromParcel(Parcel parcel) {
            return new ParcelableConstraints(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableConstraints[] newArray(int i) {
            return new ParcelableConstraints[i];
        }
    };
    private final Constraints mConstraints;

    public ParcelableConstraints(@NonNull Constraints constraints) {
        this.mConstraints = constraints;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public Constraints getConstraints() {
        return this.mConstraints;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(WorkTypeConverters.networkTypeToInt(this.mConstraints.getRequiredNetworkType()));
        ParcelUtils.writeBooleanValue(parcel, this.mConstraints.getRequiresBatteryNotLow());
        ParcelUtils.writeBooleanValue(parcel, this.mConstraints.getRequiresCharging());
        ParcelUtils.writeBooleanValue(parcel, this.mConstraints.getRequiresStorageNotLow());
        ParcelUtils.writeBooleanValue(parcel, this.mConstraints.getRequiresDeviceIdle());
        boolean zHasContentUriTriggers = this.mConstraints.hasContentUriTriggers();
        ParcelUtils.writeBooleanValue(parcel, zHasContentUriTriggers);
        if (zHasContentUriTriggers) {
            parcel.writeByteArray(WorkTypeConverters.setOfTriggersToByteArray(this.mConstraints.getContentUriTriggers()));
        }
        parcel.writeLong(this.mConstraints.getContentTriggerMaxDelayMillis());
        parcel.writeLong(this.mConstraints.getContentTriggerUpdateDelayMillis());
    }

    public ParcelableConstraints(@NonNull Parcel parcel) {
        Constraints.Builder builder = new Constraints.Builder();
        builder.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(parcel.readInt()));
        builder.setRequiresBatteryNotLow(ParcelUtils.readBooleanValue(parcel));
        builder.setRequiresCharging(ParcelUtils.readBooleanValue(parcel));
        builder.setRequiresStorageNotLow(ParcelUtils.readBooleanValue(parcel));
        builder.setRequiresDeviceIdle(ParcelUtils.readBooleanValue(parcel));
        if (ParcelUtils.readBooleanValue(parcel)) {
            for (Constraints.ContentUriTrigger contentUriTrigger : WorkTypeConverters.byteArrayToSetOfTriggers(parcel.createByteArray())) {
                builder.addContentUriTrigger(contentUriTrigger.getUri(), contentUriTrigger.getIsTriggeredForDescendants());
            }
        }
        long j = parcel.readLong();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.setTriggerContentMaxDelay(j, timeUnit);
        builder.setTriggerContentUpdateDelay(parcel.readLong(), timeUnit);
        this.mConstraints = builder.build();
    }
}
