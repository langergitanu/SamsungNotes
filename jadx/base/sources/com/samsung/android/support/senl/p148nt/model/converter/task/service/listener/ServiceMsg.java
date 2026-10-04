package com.samsung.android.support.senl.p148nt.model.converter.task.service.listener;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ServiceMsg {
    private String mDstPath;
    private boolean mIsAvailableMemory;
    private boolean mIsContentEmpty;
    private final String mSrcPath;
    private String mUuid;

    public ServiceMsg(String str) {
        this.mIsAvailableMemory = true;
        this.mSrcPath = str;
    }

    public String getDstPath() {
        return this.mDstPath;
    }

    public String getSrcPath() {
        return this.mSrcPath;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public boolean isContentEmpty() {
        return this.mIsContentEmpty;
    }

    public boolean isMemoryAvailable() {
        return this.mIsAvailableMemory;
    }

    public ServiceMsg(String str, boolean z) {
        this(str);
        this.mIsAvailableMemory = z;
    }

    public ServiceMsg(String str, String str2, @NonNull String str3, boolean z) {
        this(str);
        this.mDstPath = str2;
        this.mUuid = str3;
        this.mIsContentEmpty = z;
    }
}
