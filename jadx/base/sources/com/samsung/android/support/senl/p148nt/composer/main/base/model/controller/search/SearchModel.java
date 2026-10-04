package com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.composer.document.search.SearchData;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SearchModel implements Parcelable {
    public static final Parcelable.Creator<SearchModel> CREATOR = new Parcelable.Creator<SearchModel>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.controller.search.SearchModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchModel createFromParcel(Parcel parcel) {
            return new SearchModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchModel[] newArray(int i) {
            return new SearchModel[i];
        }
    };
    private int mCount;
    private int mCurrent;
    private boolean mIsIncludeSearchData;
    private boolean mIsSearching;
    private String mKeyword;
    private List<SearchData> mResults;

    public SearchModel(String str, boolean z) {
        this.mKeyword = str;
        this.mCount = 0;
        this.mCurrent = -1;
        this.mIsIncludeSearchData = z;
        if (z) {
            this.mResults = new CopyOnWriteArrayList();
        }
        this.mIsSearching = false;
    }

    public void addSearchResults(SearchData searchData) {
        List<SearchData> list = this.mResults;
        if (list == null) {
            return;
        }
        list.add(searchData);
    }

    public boolean canBackward() {
        return this.mCount > 0 && this.mCurrent > 0;
    }

    public boolean canForward() {
        int i = this.mCount;
        return i > 0 && this.mCurrent < i - 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCount() {
        return this.mCount;
    }

    public int getCurrent() {
        return this.mCurrent;
    }

    public String getKeyword() {
        return this.mKeyword;
    }

    public List<SearchData> getSearchResults() {
        return this.mResults;
    }

    public boolean isSearching() {
        return this.mIsSearching;
    }

    public void setCount(int i) {
        this.mCount = i;
    }

    public void setCurrent(int i) {
        this.mCurrent = i;
    }

    public void setSearchResults(List<SearchData> list) {
        this.mResults = list;
    }

    public void setSearching(boolean z) {
        this.mIsSearching = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mKeyword);
        parcel.writeInt(this.mCurrent);
        parcel.writeInt(this.mCount);
    }

    public SearchModel(Parcel parcel) {
        this.mKeyword = parcel.readString();
        this.mCurrent = parcel.readInt();
        this.mCount = parcel.readInt();
    }
}
