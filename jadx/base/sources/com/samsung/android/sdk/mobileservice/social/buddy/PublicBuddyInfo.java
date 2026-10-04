package com.samsung.android.sdk.mobileservice.social.buddy;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PublicBuddyInfo {
    private ArrayList<Capability> mCapabilityList;
    private byte[] mImage;
    private String mImageType;
    private String mName;
    private String mPhoneNumber;
    private String mStatusMessage;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Capability {
        private String mAppId;
        private String mServiceId;

        public Capability(String str, String str2) {
            this.mAppId = str;
            this.mServiceId = str2;
        }

        public String getAppId() {
            return this.mAppId;
        }

        public String getServiceId() {
            return this.mServiceId;
        }
    }

    public PublicBuddyInfo(String str, String str2, String str3, byte[] bArr, String str4, ArrayList<Capability> arrayList) {
        this.mPhoneNumber = str;
        this.mName = str2;
        this.mStatusMessage = str3;
        this.mImage = bArr;
        this.mImageType = str4;
        this.mCapabilityList = arrayList;
    }

    public ArrayList<Capability> getCapabilityList() {
        return this.mCapabilityList;
    }

    public byte[] getImage() {
        return this.mImage;
    }

    public String getImageType() {
        return this.mImageType;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }
}
