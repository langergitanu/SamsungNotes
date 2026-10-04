package com.samsung.android.support.senl.document.util;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.samsung.android.support.senl.document.SDocCipherBlockInputStream;
import com.samsung.android.support.senl.document.component.SDocEndTag;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.exception.InvalidPasswordException;
import com.samsung.android.support.senl.document.exception.UnsupportedFileException;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
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
public class LockUtil {
    private static final int CIPHER_BUF_SIZE = 4096;
    private static final int CIPHER_INTERATION_COUNT = 4000;
    private static final int CIPHER_KEY_BIT_LENGTH = 256;
    private static final String TAG = "LockUtil";

    public static void decrypt(String str, String str2) throws IOException {
        DocumentLogger.m7178d(TAG, "decrypt() - [" + SDocUtil.logPath(str) + "] start");
        String str3 = str + DiskFileUpload.postfix;
        SDocEndTag sDocEndTag = new SDocEndTag(null);
        sDocEndTag.parse(str, true);
        if (sDocEndTag.isEncrypted()) {
            decrypt(str, str3, str2);
            File file = new File(str3);
            if (!file.exists()) {
                throw new InvalidPasswordException("decrypt() - Invalid password.");
            }
            try {
                new SDocEndTag(null).parse(str3, true);
                FileUtil.forceRenameTo(str3, str);
                DocumentLogger.m7178d(TAG, "decrypt end");
            } catch (UnsupportedFileException unused) {
                if (!file.delete()) {
                    DocumentLogger.m7178d(TAG, "decrypt() - fail to delete temporary file. [" + SDocUtil.logPath(file.getPath()) + "]");
                }
                throw new InvalidPasswordException("decrypt() - Invalid password.");
            }
        }
    }

    public static void encrypt(String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file;
        DocumentLogger.m7178d(TAG, "encrypt() - [" + SDocUtil.logPath(str) + "] start");
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("lock() - invalid argument");
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            throw new IOException("encrypt() - the file isn't exist");
        }
        SDocEndTag sDocEndTag = new SDocEndTag(null);
        sDocEndTag.parse(str, true);
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AES256KeyLoader.AES_ALGORITHM);
            keyGenerator.init(256);
            SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                SecureRandom secureRandom = new SecureRandom();
                byte[] bArr = new byte[cipher.getBlockSize()];
                secureRandom.nextBytes(bArr);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                try {
                    cipher.init(1, secretKeyGenerateKey, ivParameterSpec);
                    String strConcat = str.concat(DiskFileUpload.postfix);
                    File file3 = new File(strConcat);
                    if (file3.exists() && !file3.delete()) {
                        DocumentLogger.m7178d(TAG, "encrypt() - fail to delete temporary file. [" + SDocUtil.logPath(strConcat) + "]");
                    }
                    try {
                        fileInputStream = new FileInputStream(str);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                            CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
                            byte[] bArr2 = new byte[4096];
                            while (true) {
                                try {
                                    int i = fileInputStream.read(bArr2);
                                    file = file2;
                                    fileInputStream2 = fileInputStream;
                                    if (i != -1) {
                                        try {
                                            try {
                                                cipherOutputStream.write(bArr2, 0, i);
                                                file2 = file;
                                                fileInputStream = fileInputStream2;
                                            } catch (IOException e) {
                                                e = e;
                                                cipherOutputStream.close();
                                                fileInputStream2.close();
                                                fileOutputStream.close();
                                                throw e;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            try {
                                                cipherOutputStream.close();
                                                fileInputStream2.close();
                                                fileOutputStream.close();
                                            } catch (IOException unused) {
                                                DocumentLogger.m7179e(TAG, "encrypt() - fail to close lock stream.");
                                            }
                                            throw th;
                                        }
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException unused2) {
                                            DocumentLogger.m7179e(TAG, "encrypt() - fail to close lock stream.");
                                        }
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    fileInputStream2 = fileInputStream;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream2 = fileInputStream;
                                    cipherOutputStream.close();
                                    fileInputStream2.close();
                                    fileOutputStream.close();
                                    throw th;
                                }
                            }
                            cipherOutputStream.close();
                            fileInputStream2.close();
                            fileOutputStream.close();
                            byte[] bArr3 = new byte[32];
                            new SecureRandom().nextBytes(bArr3);
                            try {
                                try {
                                    try {
                                        cipher.init(3, SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str2.toCharArray(), bArr3, 4000, 256)), ivParameterSpec);
                                        try {
                                            sDocEndTag.setEncryptionInfo((int) file.length(), bArr3, bArr, cipher.wrap(secretKeyGenerateKey));
                                            sDocEndTag.setCreatedTime(sDocEndTag.getCreatedTime());
                                            sDocEndTag.setModifiedTime(sDocEndTag.getModifiedTime());
                                            String str3 = strConcat + ".tag";
                                            sDocEndTag.writeBytes(str3, false);
                                            FileUtil.concatFile(strConcat, str3);
                                            FileUtil.forceRenameTo(strConcat, str);
                                            File file4 = new File(str3);
                                            if (file4.exists() && !file4.delete()) {
                                                DocumentLogger.m7178d(TAG, "encrypt() - fail to delete temporary tag file. [" + SDocUtil.logPath(str3) + "]");
                                            }
                                            DocumentLogger.m7178d(TAG, "encrypt end");
                                        } catch (InvalidKeyException unused3) {
                                            throw new IllegalStateException("encrypt() - invalid state 12");
                                        } catch (IllegalBlockSizeException unused4) {
                                            throw new IllegalStateException("encrypt() - invalid state 11");
                                        }
                                    } catch (InvalidAlgorithmParameterException unused5) {
                                        throw new IllegalStateException("encrypt() - invalid state 10");
                                    } catch (InvalidKeyException unused6) {
                                        throw new IllegalStateException("encrypt() - invalid state 9");
                                    }
                                } catch (InvalidKeySpecException unused7) {
                                    throw new IllegalStateException("encrypt() - invalid state 8");
                                }
                            } catch (NoSuchAlgorithmException unused8) {
                                throw new IllegalStateException("encrypt() - invalid state 7");
                            }
                        } catch (FileNotFoundException unused9) {
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw new IllegalStateException("lock() - invalid state 6");
                        }
                    } catch (FileNotFoundException unused10) {
                        fileInputStream = null;
                    }
                } catch (InvalidAlgorithmParameterException unused11) {
                    throw new IllegalStateException("encrypt() - invalid state 5");
                } catch (InvalidKeyException unused12) {
                    throw new IllegalStateException("encrypt() - invalid state 4");
                }
            } catch (NoSuchAlgorithmException unused13) {
                throw new IllegalStateException("encrypt() - invalid state 2");
            } catch (NoSuchPaddingException unused14) {
                throw new IllegalStateException("encrypt() - invalid state 3");
            }
        } catch (NoSuchAlgorithmException unused15) {
            throw new IllegalStateException("encrypt() - invalid state 1");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00cd, code lost:
    
        r11.write(r14, 0, r0 - (r10 - r7));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void decrypt(String str, String str2, String str3) throws IOException {
        FileInputStream fileInputStream;
        int i;
        DocumentLogger.m7178d(TAG, "decrypt2() - [" + SDocUtil.logPath(str) + "] start");
        if (str != null && str3 != null) {
            if (AbstractC2322a.m1607A(str)) {
                SDocEndTag sDocEndTag = new SDocEndTag(null);
                sDocEndTag.parse(str, true);
                if (sDocEndTag.isEncrypted()) {
                    byte[] encryptionSalt = sDocEndTag.getEncryptionSalt();
                    byte[] encryptionIv = sDocEndTag.getEncryptionIv();
                    byte[] encryptionKey = sDocEndTag.getEncryptionKey();
                    try {
                        try {
                            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str3.toCharArray(), encryptionSalt, 4000, 256));
                            try {
                                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                                IvParameterSpec ivParameterSpec = new IvParameterSpec(encryptionIv);
                                try {
                                    cipher.init(4, secretKeyGenerateSecret, ivParameterSpec);
                                    try {
                                        try {
                                            cipher.init(2, cipher.unwrap(encryptionKey, AES256KeyLoader.AES_ALGORITHM, 3), ivParameterSpec);
                                            try {
                                                fileInputStream = new FileInputStream(str);
                                            } catch (FileNotFoundException e) {
                                                e = e;
                                                fileInputStream = null;
                                            }
                                            try {
                                                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                                                int encryptionSize = sDocEndTag.getEncryptionSize();
                                                DocumentLogger.m7178d(TAG, "decrypt2() - working.. [" + fileInputStream.available() + "], [" + encryptionSize + "]");
                                                SDocCipherBlockInputStream sDocCipherBlockInputStream = new SDocCipherBlockInputStream(fileInputStream, encryptionSize);
                                                CipherInputStream cipherInputStream = new CipherInputStream(sDocCipherBlockInputStream, cipher);
                                                int i2 = 4096;
                                                byte[] bArr = new byte[4096];
                                                int i4 = 0;
                                                while (true) {
                                                    try {
                                                        try {
                                                            i = cipherInputStream.read(bArr, 0, i2);
                                                        } catch (IOException e2) {
                                                            throw new IOException("decrypt2() - fail12. [" + e2.toString() + "]");
                                                        }
                                                    } finally {
                                                    }
                                                    if (i != -1) {
                                                        int i5 = i4 + i;
                                                        if (i5 > encryptionSize) {
                                                            break;
                                                        }
                                                        fileOutputStream.write(bArr, 0, i);
                                                        i4 = i5;
                                                        i2 = 4096;
                                                    }
                                                }
                                                try {
                                                    cipherInputStream.close();
                                                } catch (IOException unused) {
                                                    DocumentLogger.m7179e(TAG, "decrypt2() - fail to close unlock stream.(CipherInputStream)");
                                                }
                                                try {
                                                    sDocCipherBlockInputStream.close();
                                                } catch (IOException unused2) {
                                                    DocumentLogger.m7179e(TAG, "decrypt2() - fail to close unlock stream.(SDocCipherBlockInputStream)");
                                                }
                                                try {
                                                    fileInputStream.close();
                                                } catch (IOException unused3) {
                                                    DocumentLogger.m7179e(TAG, "decrypt2() - fail to close unlock stream.(FileInputStream)");
                                                }
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException unused4) {
                                                    DocumentLogger.m7179e(TAG, "decrypt2() - fail to close unlock stream.(FileOutputStream)");
                                                }
                                                if (AbstractC2322a.m1607A(str2)) {
                                                    SDocEndTag sDocEndTag2 = new SDocEndTag(null);
                                                    sDocEndTag2.parse(str2, true);
                                                    sDocEndTag2.setReminderData(sDocEndTag.getReminderData());
                                                    sDocEndTag2.setCreatedTime(sDocEndTag.getCreatedTime());
                                                    sDocEndTag2.setModifiedTime(sDocEndTag.getModifiedTime());
                                                    sDocEndTag2.update(str2);
                                                    DocumentLogger.m7178d(TAG, "decrypt2 end");
                                                    return;
                                                }
                                                throw new IOException("decrypt2() - the destFile isn't exist");
                                            } catch (FileNotFoundException e3) {
                                                e = e3;
                                                if (fileInputStream != null) {
                                                    fileInputStream.close();
                                                }
                                                throw new IOException("decrypt2() - fail11. [" + e.toString() + "]");
                                            }
                                        } catch (InvalidAlgorithmParameterException e5) {
                                            throw new InvalidPasswordException("decrypt2() - fail10. [" + e5.toString() + "]");
                                        } catch (InvalidKeyException e6) {
                                            throw new InvalidPasswordException("decrypt2() - fail9. [" + e6.toString() + "]");
                                        }
                                    } catch (InvalidKeyException e7) {
                                        throw new InvalidPasswordException("decrypt2() - fail7. [" + e7.toString() + "]");
                                    } catch (NoSuchAlgorithmException e8) {
                                        throw new InvalidPasswordException("decrypt2() - fail8. [" + e8.toString() + "]");
                                    }
                                } catch (InvalidAlgorithmParameterException e9) {
                                    throw new InvalidPasswordException("decrypt2() - fail5. [" + e9.toString() + "]");
                                } catch (InvalidKeyException e10) {
                                    throw new InvalidPasswordException("decrypt2() - fail6. [" + e10.toString() + "]");
                                }
                            } catch (NoSuchAlgorithmException e11) {
                                throw new InvalidPasswordException("decrypt2() - fail3. [" + e11.toString() + "]");
                            } catch (NoSuchPaddingException e12) {
                                throw new InvalidPasswordException("decrypt2() - fail4. [" + e12.toString() + "]");
                            }
                        } catch (InvalidKeySpecException e13) {
                            throw new InvalidPasswordException("decrypt2() - fail2. [" + e13.toString() + "]");
                        }
                    } catch (NoSuchAlgorithmException e14) {
                        throw new InvalidPasswordException("decrypt2() - fail1. [" + e14.toString() + "]");
                    }
                }
                throw new IllegalStateException("decrypt2() - this file is not locked");
            }
            throw new IOException("decrypt2() - the file isn't exist");
        }
        throw new IllegalArgumentException("decrypt2() - invalid argument");
    }
}
