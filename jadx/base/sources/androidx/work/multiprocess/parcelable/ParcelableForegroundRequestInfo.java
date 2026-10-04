package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableForegroundRequestInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableForegroundRequestInfo> CREATOR = new Parcelable.Creator<ParcelableForegroundRequestInfo>() { // from class: androidx.work.multiprocess.parcelable.ParcelableForegroundRequestInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableForegroundRequestInfo createFromParcel(Parcel parcel) {
            return new ParcelableForegroundRequestInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableForegroundRequestInfo[] newArray(int i) {
            return new ParcelableForegroundRequestInfo[i];
        }
    };
    private final ForegroundInfo mForegroundInfo;
    private final String mId;

    public ParcelableForegroundRequestInfo(@NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        this.mId = str;
        this.mForegroundInfo = foregroundInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public ForegroundInfo getForegroundInfo() {
        return this.mForegroundInfo;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeInt(this.mForegroundInfo.getNotificationId());
        parcel.writeInt(this.mForegroundInfo.getForegroundServiceType());
        parcel.writeParcelable(this.mForegroundInfo.getNotification(), i);
    }

    public ParcelableForegroundRequestInfo(@NonNull Parcel parcel) {
        this.mId = parcel.readString();
        this.mForegroundInfo = new ForegroundInfo(parcel.readInt(), (Notification) parcel.readParcelable(getClass().getClassLoader()), parcel.readInt());
    }
}
