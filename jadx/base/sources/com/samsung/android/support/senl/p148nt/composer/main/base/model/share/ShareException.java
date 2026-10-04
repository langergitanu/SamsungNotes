package com.samsung.android.support.senl.p148nt.composer.main.base.model.share;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareException extends Exception {
    private ShareErrorCode mErrorCode;

    public ShareException(ShareErrorCode shareErrorCode, String str) {
        super(shareErrorCode.name() + "# cause: " + str);
        ShareErrorCode shareErrorCode2 = ShareErrorCode.None;
        this.mErrorCode = shareErrorCode;
    }

    public ShareErrorCode getErrorCode() {
        return this.mErrorCode;
    }
}
