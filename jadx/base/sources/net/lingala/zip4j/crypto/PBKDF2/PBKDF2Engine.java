package net.lingala.zip4j.crypto.PBKDF2;

import net.lingala.zip4j.util.Raw;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PBKDF2Engine {
    protected PBKDF2Parameters parameters;
    protected PRF prf;

    public PBKDF2Engine() {
        this.parameters = null;
        this.prf = null;
    }

    public void INT(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 / 16777216);
        bArr[i + 1] = (byte) (i2 / 65536);
        bArr[i + 2] = (byte) (i2 / 256);
        bArr[i + 3] = (byte) i2;
    }

    public byte[] PBKDF2(PRF prf, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        byte[] bArr2 = bArr;
        int hLen = prf.getHLen();
        int iCeil = ceil(i2, hLen);
        int i4 = i2 - ((iCeil - 1) * hLen);
        byte[] bArr3 = new byte[iCeil * hLen];
        int i5 = 0;
        for (int i6 = 1; i6 <= iCeil; i6++) {
            m14297_F(bArr3, i5, prf, bArr2, i, i6);
            i5 += hLen;
        }
        if (i4 >= hLen) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i2];
        System.arraycopy(bArr3, 0, bArr4, 0, i2);
        return bArr4;
    }

    /* JADX INFO: renamed from: _F */
    public void m14297_F(byte[] bArr, int i, PRF prf, byte[] bArr2, int i2, int i4) {
        int hLen = prf.getHLen();
        byte[] bArr3 = new byte[hLen];
        byte[] bArrDoFinal = new byte[bArr2.length + 4];
        System.arraycopy(bArr2, 0, bArrDoFinal, 0, bArr2.length);
        INT(bArrDoFinal, bArr2.length, i4);
        for (int i5 = 0; i5 < i2; i5++) {
            bArrDoFinal = prf.doFinal(bArrDoFinal);
            xor(bArr3, bArrDoFinal);
        }
        System.arraycopy(bArr3, 0, bArr, i, hLen);
    }

    public void assertPRF(byte[] bArr) {
        if (this.prf == null) {
            this.prf = new MacBasedPRF(this.parameters.getHashAlgorithm());
        }
        this.prf.init(bArr);
    }

    public int ceil(int i, int i2) {
        return (i / i2) + (i % i2 > 0 ? 1 : 0);
    }

    public byte[] deriveKey(char[] cArr) {
        return deriveKey(cArr, 0);
    }

    public PBKDF2Parameters getParameters() {
        return this.parameters;
    }

    public PRF getPseudoRandomFunction() {
        return this.prf;
    }

    public void setParameters(PBKDF2Parameters pBKDF2Parameters) {
        this.parameters = pBKDF2Parameters;
    }

    public void setPseudoRandomFunction(PRF prf) {
        this.prf = prf;
    }

    public boolean verifyKey(char[] cArr) {
        byte[] bArrDeriveKey;
        byte[] derivedKey = getParameters().getDerivedKey();
        if (derivedKey == null || derivedKey.length == 0 || (bArrDeriveKey = deriveKey(cArr, derivedKey.length)) == null || bArrDeriveKey.length != derivedKey.length) {
            return false;
        }
        for (int i = 0; i < bArrDeriveKey.length; i++) {
            if (bArrDeriveKey[i] != derivedKey[i]) {
                return false;
            }
        }
        return true;
    }

    public void xor(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    public byte[] deriveKey(char[] cArr, int i) {
        cArr.getClass();
        assertPRF(Raw.convertCharArrayToByteArray(cArr));
        if (i == 0) {
            i = this.prf.getHLen();
        }
        return PBKDF2(this.prf, this.parameters.getSalt(), this.parameters.getIterationCount(), i);
    }

    public PBKDF2Engine(PBKDF2Parameters pBKDF2Parameters) {
        this.parameters = pBKDF2Parameters;
        this.prf = null;
    }

    public PBKDF2Engine(PBKDF2Parameters pBKDF2Parameters, PRF prf) {
        this.parameters = pBKDF2Parameters;
        this.prf = prf;
    }
}
