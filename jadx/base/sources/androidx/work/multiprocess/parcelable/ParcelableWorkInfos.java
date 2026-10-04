package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableWorkInfos implements Parcelable {
    public static final Parcelable.Creator<ParcelableWorkInfos> CREATOR = new Parcelable.Creator<ParcelableWorkInfos>() { // from class: androidx.work.multiprocess.parcelable.ParcelableWorkInfos.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWorkInfos createFromParcel(Parcel parcel) {
            return new ParcelableWorkInfos(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWorkInfos[] newArray(int i) {
            return new ParcelableWorkInfos[i];
        }
    };
    private final List<WorkInfo> mInfos;

    public ParcelableWorkInfos(@NonNull List<WorkInfo> list) {
        this.mInfos = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public List<WorkInfo> getWorkInfos() {
        return this.mInfos;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        ParcelableWorkInfo[] parcelableWorkInfoArr = new ParcelableWorkInfo[this.mInfos.size()];
        for (int i2 = 0; i2 < this.mInfos.size(); i2++) {
            parcelableWorkInfoArr[i2] = new ParcelableWorkInfo(this.mInfos.get(i2));
        }
        parcel.writeParcelableArray(parcelableWorkInfoArr, i);
    }

    public ParcelableWorkInfos(@NonNull Parcel parcel) {
        Parcelable[] parcelableArray = parcel.readParcelableArray(getClass().getClassLoader());
        this.mInfos = new ArrayList(parcelableArray.length);
        for (Parcelable parcelable : parcelableArray) {
            this.mInfos.add(((ParcelableWorkInfo) parcelable).getWorkInfo());
        }
    }
}
