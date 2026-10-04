package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FilterInfo implements Parcelable {
    public static final Parcelable.Creator<FilterInfo> CREATOR = new Parcelable.Creator<FilterInfo>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.model.FilterInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FilterInfo createFromParcel(Parcel parcel) {
            return new FilterInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FilterInfo[] newArray(int i) {
            return new FilterInfo[i];
        }
    };
    public static final int FILTER_TIME_NONE = -1;
    public static final int FILTER_TYPE_NONE = 0;
    private static final String KEY_FILTER_COLLAPSE = "key_filter_collapse";
    private static final String KEY_FILTER_COVER_CATEGORY = "key_filter_cover";
    private static final String KEY_FILTER_EMPTY_TYPE = "key_filter_empty_type";
    private static final String KEY_FILTER_TIME = "key_filter_time";
    private static final String KEY_FILTER_TYPE = "key_filter_type";
    private String mCoverSticker;
    private SearchEmptyType mEmptyType;
    private boolean mIsCollapse;
    private int mTime;
    private int mType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SearchEmptyType {
        NONE,
        NO_RECENT,
        NO_NOTE
    }

    public FilterInfo() {
        this.mEmptyType = SearchEmptyType.NONE;
        this.mTime = -1;
        this.mType = 0;
        this.mIsCollapse = SharedPreferencesCompat.getInstance("SearchSettings").getBoolean(NotesConstants.KEY_SEARCH_FILTER, false);
        this.mCoverSticker = CoverStickerConstants.Category.NONE.UUID;
    }

    public void clear() {
        this.mTime = -1;
        this.mType = 0;
        this.mCoverSticker = CoverStickerConstants.Category.NONE.UUID;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String getCoverSticker() {
        return this.mCoverSticker;
    }

    public int getFilterTime() {
        return this.mTime;
    }

    public int getFilterType() {
        return this.mType;
    }

    public SearchEmptyType getSearchEmptyType() {
        return this.mEmptyType;
    }

    public boolean isCollapse() {
        return this.mIsCollapse;
    }

    public boolean isFiltered() {
        return (this.mTime == -1 && this.mType == 0 && this.mCoverSticker.equals(CoverStickerConstants.Category.NONE.UUID)) ? false : true;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.mTime = bundle.getInt(KEY_FILTER_TIME);
        this.mType = bundle.getInt(KEY_FILTER_TYPE);
        this.mIsCollapse = bundle.getBoolean(KEY_FILTER_COLLAPSE);
        this.mCoverSticker = bundle.getString(KEY_FILTER_COVER_CATEGORY);
        this.mEmptyType = SearchEmptyType.values()[bundle.getInt(KEY_FILTER_EMPTY_TYPE)];
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(KEY_FILTER_TIME, this.mTime);
        bundle.putInt(KEY_FILTER_TYPE, this.mType);
        bundle.putBoolean(KEY_FILTER_COLLAPSE, this.mIsCollapse);
        bundle.putString(KEY_FILTER_COVER_CATEGORY, this.mCoverSticker);
        bundle.putInt(KEY_FILTER_EMPTY_TYPE, this.mEmptyType.ordinal());
    }

    public void setCollapse(boolean z) {
        this.mIsCollapse = z;
    }

    public void setCoverSticker(@NonNull String str) {
        this.mCoverSticker = str;
    }

    public void setFilterTime(int i) {
        this.mTime = i;
    }

    public void setFilterType(int i) {
        this.mType = i;
    }

    public void setSearchEmptyType(SearchEmptyType searchEmptyType) {
        this.mEmptyType = searchEmptyType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
    }

    public FilterInfo(Parcel parcel) {
        this.mEmptyType = SearchEmptyType.NONE;
    }
}
