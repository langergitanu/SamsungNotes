package com.samsung.android.sdk.mobileservice.social.social.result;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ServiceNumber {
    private final boolean mContainsMyNumber;
    private final String mMyPhoneNumber;
    private final int mServiceNumberCnt;
    private final List<String> mServiceNumberList;

    public ServiceNumber(int i, boolean z, List<String> list, String str) {
        this.mServiceNumberCnt = i;
        this.mContainsMyNumber = z;
        if (list == null) {
            this.mServiceNumberList = new ArrayList(1);
        } else {
            this.mServiceNumberList = list;
        }
        this.mMyPhoneNumber = str;
    }

    public boolean containsMyNumber() {
        return this.mContainsMyNumber;
    }

    public String getMyPhoneNumber() {
        return this.mMyPhoneNumber;
    }

    public int getServiceNumberCnt() {
        return this.mServiceNumberCnt;
    }

    public List<String> getServiceNumberList() {
        return this.mServiceNumberList;
    }
}
