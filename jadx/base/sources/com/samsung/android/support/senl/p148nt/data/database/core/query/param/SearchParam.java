package com.samsung.android.support.senl.p148nt.data.database.core.query.param;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.PageMode;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SearchParam extends BaseSearchParam<SearchParam> {
    private boolean mFavoriteNoteOnly;
    private boolean mIncludeFolderName;
    private boolean mIncludeLockedNoteTitle;
    private boolean mIsCoEditMode;
    private boolean mLockedNoteOnly;
    private int mMaxCount;
    private int mOldDocumentOption;
    private int mPageMode;
    private String mQueryFolderName;
    private final String mQueryText;
    private final long mRequestedTime;
    private int mSearchMode;
    private SortParam mSortParam;
    private int mStrategy;

    public SearchParam(String str) {
        this(str, System.currentTimeMillis());
    }

    public SearchParam addStrategy(@SearchConstants.Strategy int i) {
        this.mStrategy = i | this.mStrategy;
        return this;
    }

    public boolean checkStrategy(int i) {
        return (i & this.mStrategy) != 0;
    }

    public int getMaxCount() {
        return this.mMaxCount;
    }

    @SearchConstants.OldNote
    public int getOldDocumentOption() {
        return this.mOldDocumentOption;
    }

    public int getPageMode() {
        return this.mPageMode;
    }

    @NonNull
    public String getQueryFolderName() {
        return this.mQueryFolderName;
    }

    @NonNull
    public String getQueryText() {
        return this.mQueryText;
    }

    public long getRequestedTime() {
        return this.mRequestedTime;
    }

    public int getSearchMode() {
        return this.mSearchMode;
    }

    public SortParam getSortParam() {
        return this.mSortParam;
    }

    @SearchConstants.Strategy
    public int getStrategy() {
        return this.mStrategy;
    }

    public boolean includeFolderName() {
        return this.mIncludeFolderName;
    }

    public boolean includeLockedNoteTitle() {
        return this.mIncludeLockedNoteTitle;
    }

    public boolean isCoEditMode() {
        return this.mIsCoEditMode;
    }

    public boolean isFavoriteNoteOnly() {
        return this.mFavoriteNoteOnly;
    }

    public boolean isLockedNoteOnly() {
        return this.mLockedNoteOnly;
    }

    public SearchParam removeStrategy(@SearchConstants.Strategy int i) {
        this.mStrategy = (~i) & this.mStrategy;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.param.BaseSearchParam
    public SearchParam self() {
        return this;
    }

    public SearchParam setCoEditMode(boolean z) {
        this.mIsCoEditMode = z;
        return this;
    }

    public SearchParam setFavoriteNoteOnly(boolean z) {
        this.mFavoriteNoteOnly = z;
        return this;
    }

    public SearchParam setIncludeFolderName(boolean z) {
        this.mIncludeFolderName = z;
        return this;
    }

    public SearchParam setIncludeLockedNoteTitle(boolean z) {
        this.mIncludeLockedNoteTitle = z;
        return this;
    }

    public SearchParam setLockedNoteOnly(boolean z) {
        this.mLockedNoteOnly = z;
        return this;
    }

    public SearchParam setMaxCount(int i) {
        this.mMaxCount = i;
        return this;
    }

    public SearchParam setOldDocumentOption(@SearchConstants.OldNote int i) {
        this.mOldDocumentOption = i;
        return this;
    }

    public SearchParam setPageMode(@PageMode int i) {
        this.mPageMode = i;
        return this;
    }

    public SearchParam setQueryFolderName(@NonNull String str) {
        this.mQueryFolderName = str;
        return this;
    }

    public SearchParam setSearchMode(@SearchConstants.Mode int i) {
        this.mSearchMode = i;
        setIncludeFolderName(i == 1);
        return this;
    }

    public SearchParam setSortParam(SortParam sortParam) {
        this.mSortParam = sortParam;
        return this;
    }

    public SearchParam setStrategy(@SearchConstants.Strategy int i) {
        this.mStrategy = i;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.param.BaseSearchParam
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("folderName: ");
        AbstractC11014a.m12336u(this.mQueryFolderName, sb, ", favoriteOnly: ");
        sb.append(this.mFavoriteNoteOnly);
        sb.append(", lockedNoteOnly: ");
        sb.append(this.mLockedNoteOnly);
        sb.append(", oldDocOption: ");
        sb.append(this.mOldDocumentOption);
        sb.append(", strategy: ");
        sb.append(this.mStrategy);
        sb.append(super.toString());
        return sb.toString();
    }

    public SearchParam(String str, long j) {
        this.mQueryFolderName = "";
        this.mSearchMode = 0;
        this.mStrategy = 1;
        this.mIncludeLockedNoteTitle = true;
        this.mPageMode = 0;
        this.mOldDocumentOption = 0;
        this.mQueryText = str != null ? QueryUtils.replaceInvalidCharacters(str) : "";
        this.mRequestedTime = j;
    }
}
