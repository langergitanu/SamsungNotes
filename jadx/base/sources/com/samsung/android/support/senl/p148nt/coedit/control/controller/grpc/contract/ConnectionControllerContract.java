package com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ConnectionControllerContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class JwtResultItem {
        final String mJwt;
        final String mRegionDomain;

        public JwtResultItem(String str, String str2) {
            this.mJwt = str;
            this.mRegionDomain = str2;
        }

        public String getJwt() {
            return this.mJwt;
        }

        public String getRegionDomain() {
            return this.mRegionDomain;
        }
    }

    JwtResultItem getJWT(String str, String str2, String str3, String str4);

    int getJwtMode(String str);

    String getUuid();

    boolean isAlreadySnapReleased();

    void onContentFileUploadError(int i);

    int pauseConcurrency(String str);

    void reconnect(String str);

    int resumeConcurrency(String str);
}
