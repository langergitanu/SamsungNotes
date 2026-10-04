package com.samsung.android.support.senl.document;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.samsung.android.support.senl.document.component.SDocEndTag;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.exception.UnsupportedFileException;
import com.samsung.android.support.senl.document.exception.UnsupportedVersionException;
import com.samsung.android.support.senl.document.util.SDocUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SDocCipherOutputStream extends SDocCipher {
    private static final String TAG = "SDocCipherOutputStream";
    private byte[][] mBuf;
    private Cipher mCipher;
    private CipherOutputStream mCos;
    private int mCurWriteSize;
    private SecretKey mFEK;
    private String mFilePath;
    private FileOutputStream mFos;
    private byte[] mIV;
    private IvParameterSpec mIvParams;
    private int mTotalSize;
    private int mWriteCount;

    private SDocCipherOutputStream() {
        super(null);
        this.mFilePath = null;
        this.mFos = null;
        this.mCos = null;
        this.mCipher = null;
        this.mTotalSize = 0;
        this.mIV = null;
        this.mFEK = null;
        this.mBuf = null;
        this.mWriteCount = 0;
        this.mCurWriteSize = 0;
        this.mIvParams = null;
    }

    public void close() throws IOException {
        int i;
        this.mCos.close();
        this.mFos.close();
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        try {
            try {
                try {
                    this.mCipher.init(3, SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(this.mPassword.toCharArray(), bArr, 4000, 256)), this.mIvParams);
                    try {
                        byte[] bArrWrap = this.mCipher.wrap(this.mFEK);
                        int i2 = this.mWriteCount;
                        int i4 = i2 % 2;
                        if (i2 > 0 && (i = this.mCurWriteSize) < 4096) {
                            int i5 = 4096 - i;
                            char c = i4 == 0 ? (char) 1 : (char) 0;
                            byte[] bArr2 = this.mBuf[i4];
                            System.arraycopy(bArr2, 0, bArr2, i5, i);
                            byte[][] bArr3 = this.mBuf;
                            System.arraycopy(bArr3[c], 4096 - i5, bArr3[i4], 0, i5);
                            this.mCurWriteSize = 4096;
                        }
                        String strM1170p = AbstractC0622a.m1170p(this.mFilePath, ".tag", new StringBuilder());
                        try {
                            SDocEndTag.makeFile(this.mBuf[i4], this.mCurWriteSize, strM1170p);
                            SDocEndTag sDocEndTag = new SDocEndTag(null);
                            try {
                                sDocEndTag.parse(strM1170p, true);
                                sDocEndTag.setEncryptionInfo(this.mTotalSize, bArr, this.mIV, bArrWrap);
                                sDocEndTag.setCreatedTime(sDocEndTag.getCreatedTime());
                                sDocEndTag.setModifiedTime(sDocEndTag.getModifiedTime());
                                sDocEndTag.writeBytes(this.mFilePath, true);
                                File file = new File(strM1170p);
                                if (!file.exists() || file.delete()) {
                                    return;
                                }
                                DocumentLogger.m7178d(TAG, "encrypt() - fail to delete temporary tag file. [" + SDocUtil.logPath(strM1170p) + "]");
                            } catch (UnsupportedFileException unused) {
                                throw new IllegalStateException("encrypt() - invalid state 14");
                            } catch (UnsupportedVersionException unused2) {
                                throw new IllegalStateException("encrypt() - invalid state 15");
                            }
                        } catch (UnsupportedFileException unused3) {
                            throw new IllegalStateException("encrypt() - invalid state 13");
                        }
                    } catch (InvalidKeyException unused4) {
                        throw new IllegalStateException("encrypt() - invalid state 12");
                    } catch (IllegalBlockSizeException unused5) {
                        throw new IllegalStateException("encrypt() - invalid state 11");
                    }
                } catch (InvalidAlgorithmParameterException unused6) {
                    throw new IllegalStateException("encrypt() - invalid state 10");
                } catch (InvalidKeyException unused7) {
                    throw new IllegalStateException("encrypt() - invalid state 9");
                }
            } catch (InvalidKeySpecException unused8) {
                throw new IllegalStateException("encrypt() - invalid state 8");
            }
        } catch (NoSuchAlgorithmException unused9) {
            throw new IllegalStateException("encrypt() - invalid state 7");
        }
    }

    public void write(byte[] bArr, int i) throws IOException {
        this.mCos.write(bArr, 0, i);
        this.mTotalSize += i;
        int i2 = 0;
        while (i > 0) {
            int i4 = this.mCurWriteSize;
            int i5 = 4096 - i4;
            if (i5 <= i) {
                System.arraycopy(bArr, i2, this.mBuf[this.mWriteCount % 2], i4, i5);
                i -= i5;
                i2 += i5;
                this.mWriteCount++;
                this.mCurWriteSize = 0;
            } else {
                System.arraycopy(bArr, i2, this.mBuf[this.mWriteCount % 2], i4, i);
                this.mCurWriteSize += i;
                i = 0;
            }
        }
    }

    public SDocCipherOutputStream(Context context, String str) {
        super(context);
        this.mFilePath = null;
        this.mFos = null;
        this.mCos = null;
        this.mCipher = null;
        this.mTotalSize = 0;
        this.mIV = null;
        this.mFEK = null;
        this.mBuf = null;
        this.mWriteCount = 0;
        this.mCurWriteSize = 0;
        this.mIvParams = null;
        this.mFos = new FileOutputStream(str);
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AES256KeyLoader.AES_ALGORITHM);
            keyGenerator.init(256);
            this.mFEK = keyGenerator.generateKey();
            try {
                this.mCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                SecureRandom secureRandom = new SecureRandom();
                byte[] bArr = new byte[this.mCipher.getBlockSize()];
                this.mIV = bArr;
                secureRandom.nextBytes(bArr);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(this.mIV);
                this.mIvParams = ivParameterSpec;
                try {
                    this.mCipher.init(1, this.mFEK, ivParameterSpec);
                    this.mCos = new CipherOutputStream(this.mFos, this.mCipher);
                    this.mFilePath = str;
                    this.mBuf = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 2, 4096);
                } catch (InvalidAlgorithmParameterException unused) {
                    throw new IllegalStateException("init() - invalid state 5");
                } catch (InvalidKeyException unused2) {
                    throw new IllegalStateException("init() - invalid state 4");
                }
            } catch (NoSuchAlgorithmException unused3) {
                throw new IllegalStateException("init() - invalid state 2");
            } catch (NoSuchPaddingException unused4) {
                throw new IllegalStateException("init() - invalid state 3");
            }
        } catch (NoSuchAlgorithmException unused5) {
            throw new IllegalStateException("init() - invalid state 1");
        }
    }
}
