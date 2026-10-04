package net.lingala.zip4j.crypto.PBKDF2;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MacBasedPRF implements PRF {
    protected int hLen;
    protected Mac mac;
    protected String macAlgorithm;

    public MacBasedPRF(String str) {
        this.macAlgorithm = str;
        try {
            Mac mac = Mac.getInstance(str);
            this.mac = mac;
            this.hLen = mac.getMacLength();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // net.lingala.zip4j.crypto.PBKDF2.PRF
    public byte[] doFinal(byte[] bArr) {
        return this.mac.doFinal(bArr);
    }

    @Override // net.lingala.zip4j.crypto.PBKDF2.PRF
    public int getHLen() {
        return this.hLen;
    }

    @Override // net.lingala.zip4j.crypto.PBKDF2.PRF
    public void init(byte[] bArr) {
        try {
            this.mac.init(new SecretKeySpec(bArr, this.macAlgorithm));
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(byte[] bArr) {
        try {
            this.mac.update(bArr);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] doFinal() {
        return this.mac.doFinal();
    }

    public void update(byte[] bArr, int i, int i2) {
        try {
            this.mac.update(bArr, i, i2);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    public MacBasedPRF(String str, String str2) {
        this.macAlgorithm = str;
        try {
            Mac mac = Mac.getInstance(str, str2);
            this.mac = mac;
            this.hLen = mac.getMacLength();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e2) {
            throw new RuntimeException(e2);
        }
    }
}
