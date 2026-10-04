package androidx.test.internal.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableIBinder implements Parcelable {
    public static final Parcelable.Creator<ParcelableIBinder> CREATOR = new Parcelable.Creator<ParcelableIBinder>() { // from class: androidx.test.internal.util.ParcelableIBinder.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableIBinder createFromParcel(Parcel parcel) {
            return new ParcelableIBinder(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableIBinder[] newArray(int i) {
            return new ParcelableIBinder[i];
        }
    };
    private final IBinder iBinder;

    public ParcelableIBinder(IBinder iBinder) {
        this.iBinder = (IBinder) Checks.checkNotNull(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getIBinder() {
        return this.iBinder;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.iBinder);
    }

    public ParcelableIBinder(Parcel parcel) {
        this.iBinder = parcel.readStrongBinder();
    }
}
