package com.samsung.android.settings.external;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DynamicSummaryData implements Parcelable {
    public static final Parcelable.Creator<DynamicSummaryData> CREATOR = new Parcelable.Creator<DynamicSummaryData>() { // from class: com.samsung.android.settings.external.DynamicSummaryData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicSummaryData createFromParcel(Parcel parcel) {
            return new DynamicSummaryData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicSummaryData[] newArray(int i) {
            return new DynamicSummaryData[i];
        }
    };
    private int mOrder;
    private String mSummary;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private int mOrder;
        private String mSummary;

        public Builder() {
        }

        public DynamicSummaryData build() {
            return new DynamicSummaryData(this);
        }

        public Builder setOrder(int i) {
            this.mOrder = i;
            return this;
        }

        public Builder setSummary(String str) {
            this.mSummary = str;
            return this;
        }

        public Builder(DynamicSummaryData dynamicSummaryData) {
            this.mOrder = dynamicSummaryData.mOrder;
            this.mSummary = dynamicSummaryData.mSummary;
        }
    }

    private void readFromParcel(Parcel parcel) {
        this.mOrder = parcel.readInt();
        this.mSummary = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public String getSummary() {
        return this.mSummary;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mOrder);
        parcel.writeString(this.mSummary);
    }

    private DynamicSummaryData(Builder builder) {
        this.mOrder = builder.mOrder;
        this.mSummary = builder.mSummary;
    }

    public DynamicSummaryData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
