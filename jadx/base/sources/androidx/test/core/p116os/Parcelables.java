package androidx.test.core.p116os;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class Parcelables {
    private Parcelables() {
    }

    public static <T extends Parcelable> T forceParcel(T t, Parcelable.Creator<T> creator) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            t.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } finally {
            parcelObtain.recycle();
        }
    }
}
