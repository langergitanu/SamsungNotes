package com.samsung.android.scloud.rpc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SamsungCloudRPCProfile implements Parcelable {
    public static final Parcelable.Creator<SamsungCloudRPCProfile> CREATOR = new Parcelable.Creator<SamsungCloudRPCProfile>() { // from class: com.samsung.android.scloud.rpc.SamsungCloudRPCProfile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SamsungCloudRPCProfile createFromParcel(Parcel parcel) {
            return new SamsungCloudRPCProfile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SamsungCloudRPCProfile[] newArray(int i) {
            return new SamsungCloudRPCProfile[i];
        }
    };
    public String accountName;
    public String authorityName;
    public String cloudDisplayName;
    public int isOn;
    public long lastUpdatedTime;
    public int preCondition;
    public long recordCount;
    public String serviceDiaplayName;
    public long sizeInByte;
    public int usingNetworkOption;

    public SamsungCloudRPCProfile() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.cloudDisplayName = parcel.readString();
        this.serviceDiaplayName = parcel.readString();
        this.preCondition = parcel.readInt();
        this.accountName = parcel.readString();
        this.authorityName = parcel.readString();
        this.recordCount = parcel.readLong();
        this.sizeInByte = parcel.readLong();
        this.lastUpdatedTime = parcel.readLong();
        this.isOn = parcel.readInt();
        this.usingNetworkOption = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cloudDisplayName);
        parcel.writeString(this.serviceDiaplayName);
        parcel.writeInt(this.preCondition);
        parcel.writeString(this.accountName);
        parcel.writeString(this.authorityName);
        parcel.writeLong(this.recordCount);
        parcel.writeLong(this.sizeInByte);
        parcel.writeLong(this.lastUpdatedTime);
        parcel.writeInt(this.isOn);
        parcel.writeInt(this.usingNetworkOption);
    }

    public SamsungCloudRPCProfile(Parcel parcel) {
        readFromParcel(parcel);
    }
}
