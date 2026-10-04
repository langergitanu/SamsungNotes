package com.samsung.android.support.senl.p148nt.data.common.constants;

import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TimeSaveParam {
    private Long mCreatedTime;
    private boolean mForceUpdate;
    private Long mLastModifiedTime;

    public Long getCreatedTime(Long l) {
        Long l2 = this.mCreatedTime;
        return (l2 == null || l2.longValue() == 0) ? l : this.mCreatedTime;
    }

    public boolean getForceUpdate() {
        return this.mForceUpdate;
    }

    public Long getLastModifiedTime(Long l) {
        Long l2 = this.mLastModifiedTime;
        return (l2 == null || l2.longValue() == 0) ? l : this.mLastModifiedTime;
    }

    public void setCreatedTime(Long l) {
        this.mCreatedTime = l;
    }

    public void setForceUpdate(boolean z) {
        this.mForceUpdate = z;
    }

    public void setLastModifiedTime(Long l) {
        this.mLastModifiedTime = l;
    }

    public void setTime(Long l, Long l2) {
        this.mCreatedTime = l;
        this.mLastModifiedTime = l2;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("TimeSaveParam{mCreatedTime=");
        sb.append(this.mCreatedTime);
        sb.append(", mLastModifiedTime=");
        sb.append(this.mLastModifiedTime);
        sb.append(", mForceUpdate=");
        return AbstractC0622a.m1172r(sb, this.mForceUpdate, '}');
    }
}
