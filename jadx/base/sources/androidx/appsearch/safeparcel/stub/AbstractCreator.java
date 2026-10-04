package androidx.appsearch.safeparcel.stub;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.safeparcel.SafeParcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class AbstractCreator<T> implements Parcelable.Creator<T> {
    public static void writeToParcel(SafeParcelable safeParcelable, Parcel parcel, int i) {
        throw new UnsupportedOperationException("writeToParcel is not implemented and should not be used.");
    }

    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel parcel) {
        throw new UnsupportedOperationException("createFromParcel is not implemented and should not be used.");
    }

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int i) {
        throw new UnsupportedOperationException("newArray is not implemented and should not be used.");
    }
}
