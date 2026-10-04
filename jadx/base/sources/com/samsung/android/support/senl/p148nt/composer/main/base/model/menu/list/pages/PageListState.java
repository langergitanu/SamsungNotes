package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.SaveInstancesHelper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListState implements Parcelable, SaveInstancesHelper.LargeableData {
    public static final Parcelable.Creator<PageListState> CREATOR = new Parcelable.Creator<PageListState>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.menu.list.pages.PageListState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageListState createFromParcel(Parcel parcel) {
            return new PageListState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageListState[] newArray(int i) {
            return new PageListState[i];
        }
    };
    private static final int LARGE_BASE_SEARCH_SIZE = 2000;
    private static final int LARGE_BASE_SELECTED_SIZE = 700;
    private boolean mHasSearchInputFieldFocus;
    private boolean mIsDeletingPages;
    private final int mMode;
    private int[] mPageIndexArray;
    private String[] mPageSearchThumbnailArray;
    private String mSearchKeyword;
    private List<String> mSelectedItems;

    public PageListState(int i) {
        this.mMode = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.util.SaveInstancesHelper.LargeableData
    public Parcelable getData() {
        return this;
    }

    public int getMode() {
        return this.mMode;
    }

    public int[] getPageIndexArray() {
        return this.mPageIndexArray;
    }

    public String[] getPageSearchThumbnailArray() {
        return this.mPageSearchThumbnailArray;
    }

    public String getSearchKeyword() {
        return this.mSearchKeyword;
    }

    public List<String> getSelectedItems() {
        return this.mSelectedItems;
    }

    public boolean hasSearchInputFieldFocus() {
        return this.mHasSearchInputFieldFocus;
    }

    public boolean isDeletingPages() {
        return this.mIsDeletingPages;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.util.SaveInstancesHelper.LargeableData
    public boolean isLarge() {
        List<String> list = this.mSelectedItems;
        if (list != null && list.size() > 700) {
            return true;
        }
        String[] strArr = this.mPageSearchThumbnailArray;
        return strArr != null && strArr.length > 2000;
    }

    public void setDeletingPages(boolean z) {
        this.mIsDeletingPages = z;
    }

    public void setHasSearchInputFieldFocus(boolean z) {
        this.mHasSearchInputFieldFocus = z;
    }

    public void setPageIndexArray(int[] iArr) {
        this.mPageIndexArray = iArr;
    }

    public void setPageSearchThumbnailArray(String[] strArr) {
        this.mPageSearchThumbnailArray = strArr;
    }

    public void setSearchKeyword(String str) {
        this.mSearchKeyword = str;
    }

    public void setSelectedItems(List<String> list) {
        this.mSelectedItems = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mMode);
        parcel.writeInt(this.mHasSearchInputFieldFocus ? 1 : 0);
        parcel.writeString(this.mSearchKeyword);
        parcel.writeIntArray(this.mPageIndexArray);
        parcel.writeStringArray(this.mPageSearchThumbnailArray);
        parcel.writeStringList(this.mSelectedItems);
        parcel.writeInt(this.mIsDeletingPages ? 1 : 0);
    }

    public PageListState(Parcel parcel) {
        this.mMode = parcel.readInt();
        this.mHasSearchInputFieldFocus = parcel.readInt() != 0;
        this.mSearchKeyword = parcel.readString();
        this.mPageIndexArray = parcel.createIntArray();
        this.mPageSearchThumbnailArray = parcel.createStringArray();
        this.mSelectedItems = parcel.createStringArrayList();
        this.mIsDeletingPages = parcel.readInt() != 0;
    }
}
