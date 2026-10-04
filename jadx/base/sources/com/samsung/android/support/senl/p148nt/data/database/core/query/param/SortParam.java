package com.samsung.android.support.senl.p148nt.data.database.core.query.param;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.SortType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SortParam {
    private boolean mIsDesc;
    private boolean mIsPinFavorite;
    private boolean mLastIsDesc;

    @SortType
    private int mLastSortTimeType;

    @SortType
    private int mSortType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SortParamBuilder {
        private final SortParam mSortParam = new SortParam(0);

        public SortParam build() {
            return this.mSortParam;
        }

        public SortParamBuilder setIsDesc(boolean z) {
            this.mSortParam.setIsDesc(z);
            return this;
        }

        public SortParamBuilder setIsPinFavorite(boolean z) {
            this.mSortParam.setIsPinFavorite(z);
            return this;
        }

        public SortParamBuilder setLastIsDesc(boolean z) {
            this.mSortParam.setLastIsDesc(z);
            return this;
        }

        public SortParamBuilder setLastSortTimeType(@SortType int i) {
            this.mSortParam.setLastSortTimeType(i);
            return this;
        }

        public SortParamBuilder setSortType(@SortType int i) {
            this.mSortParam.setSortType(i);
            return this;
        }
    }

    public /* synthetic */ SortParam(int i) {
        this();
    }

    public boolean getIsDesc() {
        return this.mIsDesc;
    }

    public boolean getIsPinFavorite() {
        return this.mIsPinFavorite;
    }

    public boolean getLastIsDesc() {
        return this.mLastIsDesc;
    }

    public int getLastSortTimeType() {
        return this.mLastSortTimeType;
    }

    @SortType
    public int getSortType() {
        return this.mSortType;
    }

    public SortParam setIsDesc(boolean z) {
        this.mIsDesc = z;
        return this;
    }

    public SortParam setIsPinFavorite(boolean z) {
        this.mIsPinFavorite = z;
        return this;
    }

    public SortParam setLastIsDesc(boolean z) {
        this.mLastIsDesc = z;
        return this;
    }

    public SortParam setLastSortTimeType(int i) {
        this.mLastSortTimeType = i;
        return this;
    }

    public SortParam setSortType(@SortType int i) {
        this.mSortType = i;
        return this;
    }

    @NonNull
    public String toString() {
        return "sortType: " + this.mSortType + " mIsDesc: " + this.mIsDesc + " mIsPinFavorite: " + this.mIsPinFavorite;
    }

    private SortParam() {
        this.mSortType = 2;
        this.mLastSortTimeType = 2;
    }
}
