package com.samsung.android.sdk.mobileservice.social.buddy.result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Buddy {
    private final String mBuddyId;
    private final Certificate mCertificate;
    private final SyncedContact mSyncedContact;

    public Buddy(String str, Certificate certificate, SyncedContact syncedContact) {
        this.mBuddyId = str;
        this.mCertificate = certificate;
        this.mSyncedContact = syncedContact;
    }

    public String getBuddyId() {
        return this.mBuddyId;
    }

    public Certificate getCertificate() {
        return this.mCertificate;
    }

    public SyncedContact getSyncedContact() {
        return this.mSyncedContact;
    }
}
