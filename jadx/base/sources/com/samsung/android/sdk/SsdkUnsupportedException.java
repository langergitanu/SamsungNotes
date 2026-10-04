package com.samsung.android.sdk;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SsdkUnsupportedException extends Exception {
    public static final int DEVICE_NOT_SUPPORTED = 1;
    public static final int SDK_VERSION_MISMATCH = 2;
    public static final int VENDOR_NOT_SUPPORTED = 0;
    private String mPackageName;
    private int mType;
    private int mVersionCode;

    public SsdkUnsupportedException(String str, int i) {
        super(str);
        this.mVersionCode = 0;
        this.mPackageName = null;
        this.mType = i;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getType() {
        return this.mType;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public SsdkUnsupportedException(String str, int i, String str2, int i2) {
        super(str);
        this.mType = i;
        this.mPackageName = str2;
        this.mVersionCode = i2;
    }
}
