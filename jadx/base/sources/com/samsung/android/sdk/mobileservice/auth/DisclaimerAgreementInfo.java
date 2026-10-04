package com.samsung.android.sdk.mobileservice.auth;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DisclaimerAgreementInfo {
    public static final String ACCOUNT = "agreement_samsung_account";
    public static final String SOCIAL = "agreement_social_service";
    private HashMap<String, Boolean> mInfo = new HashMap<>();

    public void add(String str, boolean z) {
        this.mInfo.put(str, Boolean.valueOf(z));
    }

    public boolean contain(String str) {
        return this.mInfo.containsKey(str);
    }

    public boolean getValue(String str, boolean z) {
        return this.mInfo.containsKey(str) ? this.mInfo.get(str).booleanValue() : z;
    }
}
