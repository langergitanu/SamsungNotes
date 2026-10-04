package com.sec.android.diagmonagent.dma.aperf;

import android.os.Parcel;
import android.os.Parcelable;
import com.sec.android.diagmonagent.dma.aperf.utils.aPerfUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SubOperation implements Parcelable {
    public static final Parcelable.Creator<SubOperation> CREATOR = new Parcelable.Creator<SubOperation>() { // from class: com.sec.android.diagmonagent.dma.aperf.SubOperation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubOperation createFromParcel(Parcel parcel) {
            return new SubOperation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubOperation[] newArray(int i) {
            return new SubOperation[i];
        }
    };
    private String opId;
    private long startSubOpTimeMills;
    private String startSubOpTimestamp;
    private long subOpDataSize;
    private long subOpElapsedTime;
    private String subOpId;
    private long subOpItemCount;
    private String subOpName;

    public SubOperation(String str, String str2, String str3) {
        this.subOpItemCount = 0L;
        this.subOpDataSize = 0L;
        this.opId = str;
        this.subOpName = str2;
        this.subOpId = str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.startSubOpTimeMills = jCurrentTimeMillis;
        this.startSubOpTimestamp = aPerfUtil.localToUTC(jCurrentTimeMillis);
        this.subOpElapsedTime = -1L;
    }

    public void calculateOpElapsedTime() {
        this.subOpElapsedTime = System.currentTimeMillis() - this.startSubOpTimeMills;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOpId() {
        return this.opId;
    }

    public long getStartSubOpTimeMills() {
        return this.startSubOpTimeMills;
    }

    public String getStartSubOpTimestamp() {
        return this.startSubOpTimestamp;
    }

    public long getSubOpDataSize() {
        return this.subOpDataSize;
    }

    public long getSubOpElapsedTime() {
        return this.subOpElapsedTime;
    }

    public String getSubOpId() {
        return this.subOpId;
    }

    public long getSubOpItemCount() {
        return this.subOpItemCount;
    }

    public String getSubOpName() {
        return this.subOpName;
    }

    public void setSubOpCountSize(long j, long j2) {
        this.subOpItemCount = j;
        this.subOpDataSize = j2;
    }

    public void setSubOpElapsedTime(long j) {
        this.subOpElapsedTime = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.subOpId);
        parcel.writeString(this.subOpName);
        parcel.writeLong(this.startSubOpTimeMills);
        parcel.writeString(this.startSubOpTimestamp);
        parcel.writeLong(this.subOpElapsedTime);
        parcel.writeLong(this.subOpItemCount);
        parcel.writeLong(this.subOpDataSize);
    }

    public SubOperation(Parcel parcel) {
        this.subOpItemCount = 0L;
        this.subOpDataSize = 0L;
        this.subOpId = parcel.readString();
        this.subOpName = parcel.readString();
        this.startSubOpTimeMills = parcel.readLong();
        this.startSubOpTimestamp = parcel.readString();
        this.subOpElapsedTime = parcel.readLong();
        this.subOpItemCount = parcel.readLong();
        this.subOpDataSize = parcel.readLong();
    }
}
