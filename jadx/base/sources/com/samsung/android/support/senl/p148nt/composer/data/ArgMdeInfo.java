package com.samsung.android.support.senl.p148nt.composer.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ArgMdeInfo implements Parcelable {
    public static final Parcelable.Creator<ArgMdeInfo> CREATOR = new Parcelable.Creator<ArgMdeInfo>() { // from class: com.samsung.android.support.senl.nt.composer.data.ArgMdeInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ArgMdeInfo createFromParcel(Parcel parcel) {
            return new ArgMdeInfo(parcel, 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ArgMdeInfo[] newArray(int i) {
            return new ArgMdeInfo[i];
        }
    };
    public int accountType;
    public String groupId;
    public String ownerId;
    public String spaceId;
    public String writer;

    public /* synthetic */ ArgMdeInfo(Parcel parcel, int i) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.spaceId);
        parcel.writeString(this.groupId);
        parcel.writeString(this.ownerId);
        parcel.writeInt(this.accountType);
        parcel.writeString(this.writer);
    }

    public ArgMdeInfo() {
        this.accountType = 0;
    }

    public ArgMdeInfo(String str, String str2, String str3, String str4, int i) {
        this.spaceId = str;
        this.groupId = str2;
        this.ownerId = str3;
        this.accountType = i;
        this.writer = str4;
    }

    private ArgMdeInfo(Parcel parcel) {
        this.spaceId = parcel.readString();
        this.groupId = parcel.readString();
        this.ownerId = parcel.readString();
        this.accountType = parcel.readInt();
        this.writer = parcel.readString();
    }
}
