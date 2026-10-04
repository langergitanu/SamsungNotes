package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableRemoteWorkRequest implements Parcelable {
    public static final Parcelable.Creator<ParcelableRemoteWorkRequest> CREATOR = new Parcelable.Creator<ParcelableRemoteWorkRequest>() { // from class: androidx.work.multiprocess.parcelable.ParcelableRemoteWorkRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableRemoteWorkRequest createFromParcel(Parcel parcel) {
            return new ParcelableRemoteWorkRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableRemoteWorkRequest[] newArray(int i) {
            return new ParcelableRemoteWorkRequest[i];
        }
    };
    private final ParcelableWorkerParameters mParcelableWorkerParameters;
    private final String mWorkerClassName;

    public ParcelableRemoteWorkRequest(@NonNull String str, @NonNull WorkerParameters workerParameters) {
        this.mWorkerClassName = str;
        this.mParcelableWorkerParameters = new ParcelableWorkerParameters(workerParameters);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public ParcelableWorkerParameters getParcelableWorkerParameters() {
        return this.mParcelableWorkerParameters;
    }

    @NonNull
    public String getWorkerClassName() {
        return this.mWorkerClassName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mWorkerClassName);
        this.mParcelableWorkerParameters.writeToParcel(parcel, i);
    }

    public ParcelableRemoteWorkRequest(@NonNull Parcel parcel) {
        this.mWorkerClassName = parcel.readString();
        this.mParcelableWorkerParameters = new ParcelableWorkerParameters(parcel);
    }
}
