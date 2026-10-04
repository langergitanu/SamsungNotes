package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.JavaInstanceConstructor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Reminder implements Parcelable {
    public static final Parcelable.Creator<Reminder> CREATOR = new Parcelable.Creator<Reminder>() { // from class: com.samsung.android.support.senl.nt.data.database.core.migration.legacy.data.Reminder.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Reminder createFromParcel(Parcel parcel) {
            return new Reminder(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Reminder[] newArray(int i) {
            return new Reminder[i];
        }
    };
    private String mDocumentUuid;
    private int mRequestCode;
    private long mTriggerTime;

    public Reminder() {
        this.mDocumentUuid = "";
        this.mRequestCode = -1;
        this.mTriggerTime = -1L;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void generateRequestCode() {
        this.mRequestCode = getRandomNumberInRange(10000, Integer.MAX_VALUE);
    }

    public String getDocumentUuid() {
        return this.mDocumentUuid;
    }

    public int getRandomNumberInRange(int i, int i2) {
        if (i < i2) {
            return JavaInstanceConstructor.getSecureRandom().nextInt((i2 - i) + 1) + i;
        }
        throw new IllegalArgumentException("max must be greater than min");
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public long getTriggerTime() {
        return this.mTriggerTime;
    }

    public void setDocumentUuid(@Nullable String str) {
        if (str == null) {
            str = "";
        }
        this.mDocumentUuid = str;
    }

    public void setRequestCode(int i) {
        this.mRequestCode = i;
    }

    public void setTriggerTime(long j) {
        this.mTriggerTime = j;
    }

    @NonNull
    public String toString() {
        return "mDocumentUuid: " + this.mDocumentUuid + ", mRequestCode: " + this.mRequestCode + ", mTriggerTime: " + this.mTriggerTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mDocumentUuid);
        parcel.writeInt(this.mRequestCode);
        parcel.writeLong(this.mTriggerTime);
    }

    public Reminder(Parcel parcel) {
        this.mDocumentUuid = "";
        this.mRequestCode = -1;
        this.mTriggerTime = -1L;
        this.mDocumentUuid = parcel.readString();
        this.mRequestCode = parcel.readInt();
        this.mTriggerTime = parcel.readLong();
    }
}
