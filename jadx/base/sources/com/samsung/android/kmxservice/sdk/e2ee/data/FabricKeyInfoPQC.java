package com.samsung.android.kmxservice.sdk.e2ee.data;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class FabricKeyInfoPQC {
    private final byte[] mPqcWrappedKey;
    private final byte[] mWrappedFabricKey;

    public FabricKeyInfoPQC(byte[] bArr, byte[] bArr2) {
        this.mWrappedFabricKey = bArr;
        this.mPqcWrappedKey = bArr2;
    }

    public byte[] getPqcWrappedKey() {
        return this.mPqcWrappedKey;
    }

    public byte[] getWrappedFabricKey() {
        return this.mWrappedFabricKey;
    }
}
