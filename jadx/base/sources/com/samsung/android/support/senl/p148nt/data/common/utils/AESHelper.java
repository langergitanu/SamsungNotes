package com.samsung.android.support.senl.p148nt.data.common.utils;

import com.samsung.android.support.senl.p145cm.base.framework.constructor.JavaInstanceConstructor;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AESHelper {
    private static final String AES = "AES";
    private static final int BUFFER_SIZE = 10485760;
    private static final int BYTES_SIZE_16 = 16;
    private static final String CIPHER_BYTE_ARRAY_TRANSFORMATION = "AES/CBC/PKCS7Padding";
    private static final String CIPHER_FILE_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final String SHA_256 = "SHA-256";
    private static final String TAG = DataLogger.createTag("AESHelper");

    public static byte[] decrypt(byte[] bArr, String str) {
        try {
            return encryptOrDecryptByteArray(bArr, str, 2);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("decrypt, Could not decrypt byte[], e: "), TAG);
            return null;
        }
    }

    public static byte[] encrypt(byte[] bArr, String str) {
        try {
            return encryptOrDecryptByteArray(bArr, str, 1);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("encrypt, Could not encrypt byte[], e: "), TAG);
            return null;
        }
    }

    private static byte[] encryptOrDecryptByteArray(byte[] bArr, String str, int i) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance(CIPHER_BYTE_ARRAY_TRANSFORMATION);
        cipher.init(i, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr);
    }

    private static OutputStream encryptStream(OutputStream outputStream, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(CIPHER_FILE_TRANSFORMATION);
        byte[] bArr = new byte[cipher.getBlockSize()];
        JavaInstanceConstructor.getSecureRandom().nextBytes(bArr);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        outputStream.write(bArr);
        cipher.init(1, generateSHA256SecretKey(str), ivParameterSpec);
        return new CipherOutputStream(outputStream, cipher);
    }

    private static SecretKeySpec generateSHA256SecretKey(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
        byte[] bArr = new byte[16];
        System.arraycopy(messageDigest.digest(), 0, bArr, 0, 16);
        return new SecretKeySpec(bArr, "AES");
    }

    private static boolean updateFile(File file, File file2, InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[10485760];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                break;
            }
            outputStream.write(bArr, 0, i);
        }
        if (!file2.exists()) {
            DataLogger.m12303e(TAG, "updateFile, not exist output file.");
            return false;
        }
        if (!file.delete()) {
            DataLogger.m12303e(TAG, "updateFile, failed to delete inputFile.");
        }
        return file2.renameTo(file);
    }

    public static boolean decrypt(File file, String str, String str2) {
        if (!file.exists()) {
            DataLogger.m12303e(TAG, "decrypt, not exist input file.");
            return false;
        }
        File file2 = new File(file.getCanonicalPath() + str);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            InputStream inputStreamDecrypt = decrypt(fileInputStream, str2);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    boolean zUpdateFile = updateFile(file, file2, inputStreamDecrypt, fileOutputStream);
                    fileOutputStream.close();
                    if (inputStreamDecrypt != null) {
                        inputStreamDecrypt.close();
                    }
                    fileInputStream.close();
                    return zUpdateFile;
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static boolean encrypt(File file, String str, String str2) {
        if (!file.exists()) {
            DataLogger.m12303e(TAG, "encrypt, not exist input file.");
            return false;
        }
        File file2 = new File(file.getCanonicalPath() + str);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                OutputStream outputStreamEncryptStream = encryptStream(fileOutputStream, str2);
                try {
                    boolean zUpdateFile = updateFile(file, file2, fileInputStream, outputStreamEncryptStream);
                    if (outputStreamEncryptStream != null) {
                        outputStreamEncryptStream.close();
                    }
                    fileInputStream.close();
                    fileOutputStream.close();
                    return zUpdateFile;
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static InputStream decrypt(FileInputStream fileInputStream, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(CIPHER_FILE_TRANSFORMATION);
        byte[] bArr = new byte[cipher.getBlockSize()];
        if (fileInputStream.read(bArr) == -1) {
            DataLogger.m12303e(TAG, "decrypt, there is no more data because the end of the file has been reached.");
        }
        cipher.init(2, generateSHA256SecretKey(str), new IvParameterSpec(bArr));
        return new CipherInputStream(fileInputStream, cipher);
    }
}
