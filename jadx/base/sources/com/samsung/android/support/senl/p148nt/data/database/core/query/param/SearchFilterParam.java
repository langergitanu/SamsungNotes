package com.samsung.android.support.senl.p148nt.data.database.core.query.param;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SearchFilterParam {
    private int mContentType = 0;
    private String mCoverSticker = CoverStickerConstants.Category.NONE.UUID;
    private long mFromTime;
    private long mToTime;

    public int getContentType() {
        return this.mContentType;
    }

    @NonNull
    public String getCoverSticker() {
        return this.mCoverSticker;
    }

    public long getFromTime() {
        return this.mFromTime;
    }

    public long getToTime() {
        return this.mToTime;
    }

    public boolean isValid() {
        return this.mContentType != 0 || isValidTimeCondition();
    }

    public boolean isValidTimeCondition() {
        return SearchConstants.isValidTimeCondition(this.mFromTime, this.mToTime);
    }

    public SearchFilterParam setContentType(int i) {
        this.mContentType = i;
        return this;
    }

    public SearchFilterParam setCoverSticker(@NonNull String str) {
        this.mCoverSticker = str;
        return this;
    }

    public SearchFilterParam setFromTime(long j) {
        this.mFromTime = Math.max(j, 0L);
        return this;
    }

    public SearchFilterParam setToTime(long j) {
        this.mToTime = Math.max(j, 0L);
        return this;
    }

    @NonNull
    public String toString() {
        return "from: " + this.mFromTime + ", to: " + this.mToTime + ", content: " + this.mContentType + ", coverSticker: " + this.mCoverSticker;
    }
}
