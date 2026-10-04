package com.samsung.android.settings.external;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DynamicMenuData implements Parcelable {
    public static final Parcelable.Creator<DynamicMenuData> CREATOR = new Parcelable.Creator<DynamicMenuData>() { // from class: com.samsung.android.settings.external.DynamicMenuData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicMenuData createFromParcel(Parcel parcel) {
            return new DynamicMenuData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicMenuData[] newArray(int i) {
            return new DynamicMenuData[i];
        }
    };
    private boolean mIsChecked;
    private boolean mIsEnabled;
    private boolean mIsSummaryPrimaryDark;
    private boolean mIsVisible;
    private String mKey;
    private String mSummary;
    private int mSummaryRes;
    private String mTitle;
    private int mTitleRes;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InvalidMenuDataException extends RuntimeException {
        public InvalidMenuDataException(String str) {
            super(str);
        }
    }

    private void readFromParcel(Parcel parcel) {
        this.mKey = parcel.readString();
        this.mTitle = parcel.readString();
        this.mSummary = parcel.readString();
        this.mIsChecked = parcel.readInt() == 1;
        this.mIsEnabled = parcel.readInt() == 1;
        this.mIsVisible = parcel.readInt() == 1;
        this.mIsSummaryPrimaryDark = parcel.readInt() == 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getChecked() {
        return this.mIsChecked;
    }

    public boolean getColorPrimaryDark() {
        return this.mIsSummaryPrimaryDark;
    }

    public boolean getEnabled() {
        return this.mIsEnabled;
    }

    public String getKey() {
        return this.mKey;
    }

    public String getSummary() {
        return this.mSummary;
    }

    public int getSummaryRes() {
        return this.mSummaryRes;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getTitleRes() {
        return this.mTitleRes;
    }

    public boolean getVisible() {
        return this.mIsVisible;
    }

    public void updateTextResource(Context context) {
        String string;
        String string2 = null;
        try {
            string = context.getResources().getString(this.mTitleRes);
        } catch (Exception unused) {
            string = null;
        }
        if (!TextUtils.isEmpty(string)) {
            this.mTitle = string;
        }
        try {
            string2 = context.getResources().getString(this.mSummaryRes);
        } catch (Exception unused2) {
        }
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        this.mSummary = string2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mKey);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSummary);
        parcel.writeInt(this.mIsChecked ? 1 : 0);
        parcel.writeInt(this.mIsEnabled ? 1 : 0);
        parcel.writeInt(this.mIsVisible ? 1 : 0);
        parcel.writeInt(this.mIsSummaryPrimaryDark ? 1 : 0);
    }

    private DynamicMenuData(Builder builder) {
        this.mKey = builder.mKey;
        this.mTitle = builder.mTitle;
        this.mTitleRes = builder.mTitleRes;
        this.mSummary = builder.mSummary;
        this.mSummaryRes = builder.mSummaryRes;
        this.mIsChecked = builder.mIsChecked;
        this.mIsEnabled = builder.mIsEnabled;
        this.mIsVisible = builder.mIsVisible;
        this.mIsSummaryPrimaryDark = builder.mIsSummaryPrimaryDark;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private boolean mIsChecked;
        private boolean mIsEnabled;
        private boolean mIsSummaryPrimaryDark;
        private boolean mIsVisible;
        private String mKey;
        private String mSummary;
        private int mSummaryRes;
        private String mTitle;
        private int mTitleRes;

        public Builder() {
            this.mIsEnabled = true;
            this.mIsVisible = true;
        }

        public DynamicMenuData build() {
            if (TextUtils.isEmpty(this.mKey)) {
                throw new InvalidMenuDataException("Key cannot be empty");
            }
            return new DynamicMenuData(this);
        }

        public Builder setChecked(boolean z) {
            this.mIsChecked = z;
            return this;
        }

        public Builder setColorPrimaryDark(boolean z) {
            this.mIsSummaryPrimaryDark = z;
            return this;
        }

        public Builder setEnabled(boolean z) {
            this.mIsEnabled = z;
            return this;
        }

        public Builder setKey(String str) {
            this.mKey = str;
            return this;
        }

        public Builder setSummary(String str) {
            this.mSummary = str;
            return this;
        }

        public Builder setSummaryRes(int i) {
            this.mSummaryRes = i;
            return this;
        }

        public Builder setTitle(String str) {
            this.mTitle = str;
            return this;
        }

        public Builder setTitleRes(int i) {
            this.mTitleRes = i;
            return this;
        }

        public Builder setVisible(boolean z) {
            this.mIsVisible = z;
            return this;
        }

        public Builder(DynamicMenuData dynamicMenuData) {
            this.mKey = dynamicMenuData.mKey;
            this.mTitle = dynamicMenuData.mTitle;
            this.mTitleRes = dynamicMenuData.mTitleRes;
            this.mSummary = dynamicMenuData.mSummary;
            this.mSummaryRes = dynamicMenuData.mSummaryRes;
            this.mIsChecked = dynamicMenuData.mIsChecked;
            this.mIsEnabled = dynamicMenuData.mIsEnabled;
            this.mIsVisible = dynamicMenuData.mIsVisible;
            this.mIsSummaryPrimaryDark = dynamicMenuData.mIsSummaryPrimaryDark;
        }
    }

    public DynamicMenuData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
