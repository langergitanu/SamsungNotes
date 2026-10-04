package com.samsung.android.sdk.mobileservice.social.share;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Quota {
    private boolean mIsUnlimited;
    private long mLimitCountUsage;
    private LimitType mLimitType;
    private long mLimitUsage;
    private long mTotalCountUsage;
    private long mTotalUsage;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum LimitType {
        SIZE("size"),
        COUNT("count"),
        UNLIMITED("unlimited");

        private String limitType;

        LimitType(String str) {
            this.limitType = str;
        }

        public static LimitType toLimitType(String str) {
            if (TextUtils.isEmpty(str)) {
                return SIZE;
            }
            for (LimitType limitType : values()) {
                if (str.equals(limitType.getLimitType())) {
                    return limitType;
                }
            }
            return SIZE;
        }

        public String getLimitType() {
            return this.limitType;
        }
    }

    public Quota(long j, long j2, boolean z) {
        this.mTotalCountUsage = -1L;
        this.mLimitCountUsage = -1L;
        this.mLimitType = LimitType.SIZE;
        this.mTotalUsage = j;
        this.mLimitUsage = j2;
        this.mIsUnlimited = z;
    }

    public long getLimitCountUsage() {
        return this.mLimitCountUsage;
    }

    public LimitType getLimitType() {
        return this.mLimitType;
    }

    public long getLimitUsage() {
        return this.mLimitUsage;
    }

    public long getTotalCountUsage() {
        return this.mTotalCountUsage;
    }

    public long getTotalUsage() {
        return this.mTotalUsage;
    }

    @Deprecated
    public boolean isUnlimited() {
        return this.mIsUnlimited;
    }

    public Quota(LimitType limitType, long j, long j2, long j3, long j5, boolean z) {
        this.mTotalCountUsage = -1L;
        this.mLimitCountUsage = -1L;
        LimitType limitType2 = LimitType.SIZE;
        this.mLimitType = limitType;
        this.mTotalUsage = j;
        this.mLimitUsage = j2;
        this.mTotalCountUsage = j3;
        this.mLimitCountUsage = j5;
        this.mIsUnlimited = z;
    }
}
