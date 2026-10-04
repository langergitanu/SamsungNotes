package com.sec.android.diagmonagent.dma.aperf;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.sec.android.diagmonagent.dma.aperf.utils.aPerfUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Operation implements Parcelable {
    public static final Parcelable.Creator<Operation> CREATOR = new Parcelable.Creator<Operation>() { // from class: com.sec.android.diagmonagent.dma.aperf.Operation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Operation createFromParcel(Parcel parcel) {
            return new Operation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Operation[] newArray(int i) {
            return new Operation[i];
        }
    };
    private long opDataSize;
    private long opElapsedTime;
    private String opId;
    private long opItemCount;
    private String opName;
    private long startOpTimeMills;
    private String startOpTimestamp;
    private long stopOpTimeMills;
    private String stopOpTimestamp;
    private ArrayList<SubOperation> subOpList;
    private long subOpTotalCount;
    private long subOpTotalElapsedTime;
    private ArrayList<Tag> tagList;

    public Operation(String str) {
        this.subOpList = null;
        this.tagList = null;
        this.opName = str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.startOpTimeMills = jCurrentTimeMillis;
        this.startOpTimestamp = aPerfUtil.localToUTC(jCurrentTimeMillis);
        this.opElapsedTime = -1L;
        this.opId = aPerfUtil.generateUUID();
        this.opItemCount = 0L;
        this.opDataSize = 0L;
        this.subOpTotalCount = 0L;
        this.subOpTotalElapsedTime = -1L;
    }

    public void addSubOperation(SubOperation subOperation) {
        if (this.subOpList == null) {
            this.subOpList = new ArrayList<>();
        }
        this.subOpList.add(subOperation);
    }

    public void addTags(ArrayList<Tag> arrayList) {
        this.tagList = arrayList;
    }

    public void calculateStopOpTime() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.opElapsedTime = jCurrentTimeMillis - this.startOpTimeMills;
        this.stopOpTimeMills = jCurrentTimeMillis;
        this.stopOpTimestamp = aPerfUtil.localToUTC(jCurrentTimeMillis);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getOpDataSize() {
        return this.opDataSize;
    }

    public long getOpElapsedTime() {
        return this.opElapsedTime;
    }

    public String getOpId() {
        return this.opId;
    }

    public long getOpItemCount() {
        return this.opItemCount;
    }

    public String getOpName() {
        return this.opName;
    }

    public long getStartOpTimeMills() {
        return this.startOpTimeMills;
    }

    public String getStartOpTimestamp() {
        return this.startOpTimestamp;
    }

    public long getSubOpTotalCount() {
        return this.subOpTotalCount;
    }

    public long getSubOpTotalElapsedTime() {
        return this.subOpTotalElapsedTime;
    }

    public ArrayList<SubOperation> getSubOps() {
        ArrayList<SubOperation> arrayList = this.subOpList;
        if (arrayList != null) {
            return arrayList;
        }
        return null;
    }

    public ArrayList<Tag> getTags() {
        return this.tagList;
    }

    public void setOpDataSize(long j) {
        this.opDataSize = j;
    }

    public void setOpItemCount(long j) {
        this.opItemCount = j;
    }

    public void setSubOpTotalCount(long j) {
        this.subOpTotalCount = j;
    }

    public void setSubOpTotalElapsedTime(long j) {
        this.subOpTotalElapsedTime = j;
    }

    public void setSubOps(ArrayList<SubOperation> arrayList) {
        this.subOpList = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("opId", this.opId);
        bundle.putString("opName", this.opName);
        bundle.putLong("startOpTimeMills", this.startOpTimeMills);
        bundle.putString("startOpTimestamp", this.startOpTimestamp);
        bundle.putLong("stopOpTimeMills", this.stopOpTimeMills);
        bundle.putString("stopOpTimestamp", this.stopOpTimestamp);
        bundle.putLong("opElapsedTime", this.opElapsedTime);
        bundle.putLong("opItemCount", this.opItemCount);
        bundle.putLong("opDataSize", this.opDataSize);
        bundle.putParcelableArrayList("subOpList", this.subOpList);
        bundle.putParcelableArrayList("tagList", this.tagList);
        bundle.putLong("subOpTotalElapsedTime", this.subOpTotalElapsedTime);
        bundle.putLong("subOpTotalCount", this.subOpTotalCount);
        parcel.writeBundle(bundle);
    }

    public Operation(Parcel parcel) {
        this.subOpList = null;
        this.tagList = null;
        Bundle bundle = parcel.readBundle();
        bundle.setClassLoader(Operation.class.getClassLoader());
        this.opId = bundle.getString("opId");
        this.opName = bundle.getString("opName");
        this.startOpTimeMills = bundle.getLong("startOpTimeMills");
        this.startOpTimestamp = bundle.getString("startOpTimestamp");
        this.stopOpTimeMills = bundle.getLong("stopOpTimeMills");
        this.stopOpTimestamp = bundle.getString("stopOpTimestamp");
        this.opElapsedTime = bundle.getLong("opElapsedTime");
        this.opItemCount = bundle.getLong("opItemCount");
        this.opDataSize = bundle.getLong("opDataSize");
        this.subOpList = bundle.getParcelableArrayList("subOpList");
        this.tagList = bundle.getParcelableArrayList("tagList");
        this.subOpTotalElapsedTime = bundle.getLong("subOpTotalElapsedTime");
        this.subOpTotalCount = bundle.getLong("subOpTotalCount");
    }
}
