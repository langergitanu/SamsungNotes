package com.samsung.android.sdk.mobileservice.social.buddy.request;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Fingerprint extends BuddyKey {
    private static final int FINGERPRINT = 1;

    public Fingerprint(String str) {
        super(str);
    }

    @Override // com.samsung.android.sdk.mobileservice.social.buddy.request.BuddyKey
    public int getType() {
        return 1;
    }
}
