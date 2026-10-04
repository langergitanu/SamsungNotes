package com.samsung.android.support.senl.p148nt.coedit.control.serverspis;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class GetJwtItem {
    public static final int ERROR_ETC = 20;
    public static final int ERROR_LOCAL_ACCESS_TOKEN = 12;
    public static final int ERROR_LOCAL_AUTHORIZATION = 14;
    public static final int ERROR_LOCAL_AUTH_TOKEN_EXPIRED = 13;
    public static final int ERROR_LOCAL_NETWORK = 11;
    public static final int ERROR_LOCAL_NO_GROUP_ID = 10;
    public static final int ERROR_SERVER_MAINTENANCE = 3;
    public static final int ERROR_SERVER_UPDATE_APP_VERSION = 2;
    public static final int ERROR_SERVER_UPDATE_XML_VERSION = 1;
    private int mErrorCode;
    private final boolean mIsError = true;
    private String mJwt;
    private String mOwnerRegionDomain;

    public GetJwtItem(String str, String str2) {
        this.mJwt = str;
        this.mOwnerRegionDomain = str2;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getJwt() {
        return this.mJwt;
    }

    public String getOwnerRegionDomain() {
        return this.mOwnerRegionDomain;
    }

    public boolean isError() {
        return this.mIsError;
    }

    public GetJwtItem(int i) {
        this.mErrorCode = i;
    }
}
