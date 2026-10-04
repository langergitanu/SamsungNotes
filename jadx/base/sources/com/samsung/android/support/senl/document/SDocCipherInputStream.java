package com.samsung.android.support.senl.document;

import android.content.Context;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.samsung.android.support.senl.document.component.SDocEndTag;
import com.samsung.android.support.senl.document.exception.InvalidPasswordException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SDocCipherInputStream extends SDocCipher {
    private SDocCipherBlockInputStream mBis;
    private CipherInputStream mCis;
    private FileInputStream mFis;
    private int mOriginalSize;
    private int mTotalReadSize;

    private SDocCipherInputStream() {
        super(null);
        this.mFis = null;
        this.mBis = null;
        this.mCis = null;
        this.mTotalReadSize = 0;
        this.mOriginalSize = 0;
    }

    public void close() throws IOException {
        this.mCis.close();
        this.mBis.close();
        this.mFis.close();
    }

    public int getReservedSize() {
        return this.mOriginalSize;
    }

    public int read(byte[] bArr, int i) throws IOException {
        if (this.mTotalReadSize >= this.mOriginalSize) {
            return -1;
        }
        int i2 = this.mCis.read(bArr, 0, i);
        if (i2 != -1) {
            int i4 = this.mTotalReadSize + i2;
            this.mTotalReadSize = i4;
            int i5 = this.mOriginalSize;
            if (i4 > i5) {
                return i5 - (i4 - i2);
            }
        }
        return i2;
    }

    public SDocCipherInputStream(Context context, String str) throws IOException {
        super(context);
        this.mFis = null;
        this.mBis = null;
        this.mCis = null;
        this.mTotalReadSize = 0;
        this.mOriginalSize = 0;
        if (AbstractC2322a.m1607A(str)) {
            SDocEndTag sDocEndTag = new SDocEndTag(null);
            sDocEndTag.parse(str, true);
            if (sDocEndTag.isEncrypted()) {
                byte[] encryptionSalt = sDocEndTag.getEncryptionSalt();
                byte[] encryptionIv = sDocEndTag.getEncryptionIv();
                byte[] encryptionKey = sDocEndTag.getEncryptionKey();
                try {
                    try {
                        SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(this.mPassword.toCharArray(), encryptionSalt, 4000, 256));
                        try {
                            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                            IvParameterSpec ivParameterSpec = new IvParameterSpec(encryptionIv);
                            try {
                                cipher.init(4, secretKeyGenerateSecret, ivParameterSpec);
                                try {
                                    try {
                                        cipher.init(2, cipher.unwrap(encryptionKey, AES256KeyLoader.AES_ALGORITHM, 3), ivParameterSpec);
                                        try {
                                            this.mFis = new FileInputStream(str);
                                            this.mOriginalSize = sDocEndTag.getEncryptionSize();
                                            this.mBis = new SDocCipherBlockInputStream(this.mFis, this.mOriginalSize);
                                            this.mCis = new CipherInputStream(this.mBis, cipher);
                                            return;
                                        } catch (FileNotFoundException unused) {
                                            throw new InvalidPasswordException("decrypt() - fail12");
                                        }
                                    } catch (InvalidAlgorithmParameterException unused2) {
                                        throw new InvalidPasswordException("decrypt() - fail11");
                                    } catch (InvalidKeyException unused3) {
                                        throw new InvalidPasswordException("decrypt() - fail10");
                                    }
                                } catch (InvalidKeyException unused4) {
                                    throw new InvalidPasswordException("decrypt() - fail8");
                                } catch (NoSuchAlgorithmException unused5) {
                                    throw new InvalidPasswordException("decrypt() - fail9");
                                }
                            } catch (InvalidAlgorithmParameterException unused6) {
                                throw new InvalidPasswordException("decrypt() - fail6");
                            } catch (InvalidKeyException unused7) {
                                throw new InvalidPasswordException("decrypt() - fail7");
                            }
                        } catch (NoSuchAlgorithmException unused8) {
                            throw new InvalidPasswordException("decrypt() - fail4");
                        } catch (NoSuchPaddingException unused9) {
                            throw new InvalidPasswordException("decrypt() - fail5");
                        }
                    } catch (InvalidKeySpecException unused10) {
                        throw new InvalidPasswordException("decrypt() - fail2");
                    }
                } catch (NoSuchAlgorithmException unused11) {
                    throw new InvalidPasswordException("decrypt() - fail1");
                }
            }
            throw new IllegalStateException("SDocCipherInputStream() - this file is not locked");
        }
        throw new IOException("SDocCipherInputStream() - the file isn't exist");
    }
}
