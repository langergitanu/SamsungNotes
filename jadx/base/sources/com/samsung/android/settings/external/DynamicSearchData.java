package com.samsung.android.settings.external;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DynamicSearchData implements Parcelable {
    public static final Parcelable.Creator<DynamicSearchData> CREATOR = new Parcelable.Creator<DynamicSearchData>() { // from class: com.samsung.android.settings.external.DynamicSearchData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicSearchData createFromParcel(Parcel parcel) {
            return new DynamicSearchData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicSearchData[] newArray(int i) {
            return new DynamicSearchData[i];
        }
    };
    private String mKey;
    private String mKeywords;
    private int mKeywordsRes;
    private String mSearchTitle;
    private int mSearchTitleRes;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private String mKey;
        private String mKeywords;
        private int mKeywordsRes;
        private String mSearchTitle;
        private int mSearchTitleRes;

        public Builder() {
        }

        public DynamicSearchData build() {
            return new DynamicSearchData(this);
        }

        public Builder setKey(String str) {
            this.mKey = str;
            return this;
        }

        public Builder setKeywords(String str) {
            this.mKeywords = str;
            return this;
        }

        public Builder setKeywordsRes(int i) {
            this.mKeywordsRes = i;
            return this;
        }

        public Builder setSearchTitle(String str) {
            this.mSearchTitle = str;
            return this;
        }

        public Builder setSearchTitleRes(int i) {
            this.mSearchTitleRes = i;
            return this;
        }

        public Builder(DynamicSearchData dynamicSearchData) {
            this.mKey = dynamicSearchData.mKey;
            this.mKeywords = dynamicSearchData.mKeywords;
            this.mSearchTitle = dynamicSearchData.mSearchTitle;
        }
    }

    private void readFromParcel(Parcel parcel) {
        this.mKey = parcel.readString();
        this.mKeywords = parcel.readString();
        this.mSearchTitle = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getKey() {
        return this.mKey;
    }

    public String getKeywords() {
        return this.mKeywords;
    }

    public int getKeywordsRes() {
        return this.mKeywordsRes;
    }

    public String getSearchTitle() {
        return this.mSearchTitle;
    }

    public int getSearchTitleRes() {
        return this.mSearchTitleRes;
    }

    public void updateTextResource(Context context) {
        String string;
        String string2 = null;
        try {
            string = context.getResources().getString(this.mKeywordsRes);
        } catch (Exception unused) {
            string = null;
        }
        if (!TextUtils.isEmpty(string)) {
            this.mKeywords = string;
        }
        try {
            string2 = context.getResources().getString(this.mSearchTitleRes);
        } catch (Exception unused2) {
        }
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        this.mSearchTitle = string2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mKey);
        parcel.writeString(this.mKeywords);
        parcel.writeString(this.mSearchTitle);
    }

    private DynamicSearchData(Builder builder) {
        this.mKey = builder.mKey;
        this.mKeywords = builder.mKeywords;
        this.mKeywordsRes = builder.mKeywordsRes;
        this.mSearchTitle = builder.mSearchTitle;
        this.mSearchTitleRes = builder.mSearchTitleRes;
    }

    public DynamicSearchData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
