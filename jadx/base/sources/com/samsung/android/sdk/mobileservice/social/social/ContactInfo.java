package com.samsung.android.sdk.mobileservice.social.social;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContactInfo {
    private final String hash;
    private final String phoneNumber;
    private final long rawContactId;
    private final int result;

    public ContactInfo(int i, long j, String str, String str2) {
        this.result = i;
        this.rawContactId = j;
        this.phoneNumber = str;
        this.hash = str2;
    }

    public String getHash() {
        return this.hash;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public long getRawContactId() {
        return this.rawContactId;
    }

    public int getResult() {
        return this.result;
    }
}
