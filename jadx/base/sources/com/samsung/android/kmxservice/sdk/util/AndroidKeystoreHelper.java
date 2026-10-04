package com.samsung.android.kmxservice.sdk.util;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.WrappedKeyEntry;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.samsung.android.imagetranslation.util.AbstractC7150s;
import com.samsung.android.kmxservice.sdk.e2ee.CryptoProgressListener;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxErrorHandler;
import com.samsung.android.kmxservice.sdk.e2ee.data.LogTag;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Formatter;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AndroidKeystoreHelper {
    private static final String AEAD_BAD_TAG_EXCEPTION = "AEADBadTagException";
    private static final String ALGORITHM = "AES";
    private static final String BLOCK_MODE = "GCM";
    private static final int CHUNK_SIZE = 65536;
    private static final int CIPHER_MODE_AES_GCM_NOPADDING = 0;
    private static final String ENCRYPTION_PADDING = "NoPadding";
    private static final int GCM_IV_SIZE = 12;
    private static final int GCM_TAG_SIZE_BITS = 128;
    private static final int HEADER_SIZE = 16;
    private static final int IV_BUFFER_SIZE = 16;
    private static final int KMX_FLAG_BLOCK_TYPE_5MB = 80;
    private static final int KMX_FLAG_BLOCK_TYPE_NONE = 0;
    private static final int KMX_FLAG_CHECKSUM = 1;
    private static final String PROVIDER = "AndroidKeyStore";
    private static final int STREAM_CHUNK_SIZE = 65520;
    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private static final String TAG = LogTag.getTag("AndroidKeystoreHelper");
    private static String[][] digestList = {new String[]{"SHA-256"}, new String[]{IDevicePopManager.SHA_1}, new String[]{IDevicePopManager.SHA_1, "SHA-256"}};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Header {
        private static final int INDEX_BLOCK_TYPE = 4;
        private static final int INDEX_CHECKSUM = 15;
        private static final int INDEX_CIPHER_MODE = 5;
        private final byte[] MAGIC_CODE;
        private byte[] mHeader;

        public /* synthetic */ Header(int i) {
            this();
        }

        public boolean checkMagicCode() {
            int i = 0;
            while (true) {
                byte[] bArr = this.MAGIC_CODE;
                if (i >= bArr.length) {
                    return true;
                }
                if (this.mHeader[i] != bArr[i]) {
                    return false;
                }
                i++;
            }
        }

        public int getBlockType() {
            return this.mHeader[4] & CtapException.ERR_VENDOR_FIRST;
        }

        public byte getChecksum() {
            return this.mHeader[15];
        }

        public int getChecksumFlag() {
            return this.mHeader[4] & 15;
        }

        public int getCipherMode() {
            return this.mHeader[5];
        }

        public byte[] getHeader() {
            return this.mHeader;
        }

        public byte[] makeHeader(int i, int i2) {
            byte[] bArr = new byte[16];
            byte[] bArr2 = this.MAGIC_CODE;
            System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
            bArr[4] = (byte) i;
            bArr[5] = (byte) i2;
            this.mHeader = bArr;
            setChecksum();
            return bArr;
        }

        public void setChecksum() {
            setChecksumFlag();
            int i = 0;
            for (int i2 = 0; i2 < 15; i2++) {
                i += this.mHeader[i2];
            }
            this.mHeader[15] = (byte) ((~(i & 255)) + 1);
        }

        public void setChecksumFlag() {
            byte[] bArr = this.mHeader;
            bArr[4] = (byte) (bArr[4] | 1);
        }

        public void setHeader(byte[] bArr) {
            this.mHeader = bArr;
        }

        public boolean verifyChecksum() {
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                i += this.mHeader[i2];
            }
            return (i & 255) == 0;
        }

        private Header() {
            this.MAGIC_CODE = new byte[]{69, CtapException.ERR_PIN_BLOCKED, 69, 69};
            this.mHeader = null;
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        Formatter formatter = new Formatter(sb);
        for (byte b : bArr) {
            formatter.format("%02x", Byte.valueOf(b));
        }
        return sb.toString();
    }

    public static Key getKey(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(PROVIDER);
            keyStore.load(null);
            return keyStore.getKey(str, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void removeKey(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(PROVIDER);
            keyStore.load(null);
            keyStore.deleteEntry(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean secureKeyImport(String str, String str2, byte[] bArr) {
        WrappedKeyEntry wrappedKeyEntryM5509m;
        if (bArr == null) {
            Log.e(TAG, "secureKeyImport failed. wrappedKeyBlob is null");
            return false;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(PROVIDER);
            keyStore.load(null, null);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= 3) {
                    break;
                }
                try {
                    try {
                        String str3 = TAG;
                        Log.i(str3, "[" + i2 + "] digest ?" + Arrays.toString(digestList[i2]));
                        KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(str2, 32).setDigests(digestList[i2]).build();
                        if (Build.VERSION.SDK_INT >= 28) {
                            AbstractC7150s.m5514r();
                            wrappedKeyEntryM5509m = AbstractC7150s.m5509m(bArr, str2, keyGenParameterSpecBuild);
                        } else {
                            wrappedKeyEntryM5509m = null;
                        }
                        keyStore.setEntry(str, wrappedKeyEntryM5509m, null);
                        Log.i(str3, "Try cnt :" + i2 + " SUCCESS");
                        break;
                    } catch (KeyStoreException unused) {
                        String str4 = TAG;
                        Log.i(str4, "Fail set entry, Try again with another digest");
                        Log.i(str4, "finally failSetEntry : true | try :" + i2);
                        i2++;
                        i++;
                    }
                } catch (Throwable unused2) {
                    Log.i(TAG, "Try cnt :" + i2 + " SUCCESS");
                }
            }
            if (keyStore.getKey(str, null) != null) {
                Log.i(TAG, "secureKeyImport succeeded for " + str);
                return true;
            }
            Log.i(TAG, "secureKeyImport failed for " + str);
            return false;
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e) {
            e.printStackTrace();
            return false;
        }
    }

    public byte[] decryptData(String str, byte[] bArr) {
        return decryptData(getKey(str), bArr);
    }

    public boolean decryptStream(String str, InputStream inputStream, OutputStream outputStream) {
        return decryptStream(getKey(str), inputStream, outputStream);
    }

    public byte[] encryptData(String str, byte[] bArr) {
        return encryptData(getKey(str), bArr);
    }

    public boolean encryptStream(String str, InputStream inputStream, OutputStream outputStream) {
        return encryptStream(getKey(str), inputStream, outputStream);
    }

    public static byte[] decryptData(Key key, byte[] bArr) throws KmxException {
        byte[] bArr2 = new byte[12];
        Header header = new Header(0);
        if (key == null) {
            Log.e(TAG, "decryptData failed. no key data.");
            return null;
        }
        if (bArr != null && bArr.length >= 1) {
            try {
                byte[] bArr3 = new byte[16];
                System.arraycopy(bArr, 0, bArr3, 0, 16);
                header.setHeader(bArr3);
                if (!header.checkMagicCode()) {
                    Log.e(TAG, "decryptData failed. CIPHER_MAGIC_CODE is not correct");
                    return null;
                }
                System.arraycopy(bArr, 16, bArr2, 0, 12);
                Cipher cipher = Cipher.getInstance(TRANSFORMATION);
                cipher.init(2, key, new GCMParameterSpec(128, bArr2));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);
                int i = 32;
                int length = bArr.length - 32;
                while (length > 65536) {
                    cipherOutputStream.write(bArr, i, 65536);
                    i += 65536;
                    length -= 65536;
                }
                cipherOutputStream.write(bArr, i, length);
                cipherOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e) {
                KmxErrorHandler.throwIfContain(e, "Invalid operation handle (internal Keystore code: -28", "(decryptData) KEYSTORE_TOO_MANY_OPERATIONS", 250);
                e.printStackTrace();
                String str = TAG;
                Log.i(str, "gcmIv Len : 12 gcmIv : " + bytesToHexString(bArr2));
                Log.i(str, "cipherData Len : " + bArr.length + " cipherData : " + bytesToHexString(bArr));
                if (TextUtils.isEmpty(e.getMessage())) {
                    return null;
                }
                if (e.getMessage().contains(AEAD_BAD_TAG_EXCEPTION)) {
                    throw new KmxException(AbstractC2322a.m1619i(e, new StringBuilder("DecryptData Exception :")), 107);
                }
                throw new KmxException(AbstractC2322a.m1619i(e, new StringBuilder("DecryptData Exception :")), 202);
            }
        }
        Log.e(TAG, "decryptData failed. cipherData is null or Empty");
        return null;
    }

    public static boolean decryptStream(Key key, InputStream inputStream, OutputStream outputStream) {
        return decryptStream(key, inputStream, outputStream, null);
    }

    public static byte[] encryptData(Key key, byte[] bArr) throws KmxException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        int i = 0;
        Header header = new Header(i);
        byte[] byteArray = null;
        if (key == null) {
            Log.e(TAG, "encryptData failed. no key data.");
            return null;
        }
        if (bArr == null) {
            Log.e(TAG, "encryptData failed. plainData is null.");
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(1, key);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);
            byte[] iv = cipher.getIV();
            try {
                System.arraycopy(iv, 0, bArr3, 0, iv.length);
                byteArrayOutputStream.write(header.makeHeader(0, 0));
                byteArrayOutputStream.write(bArr3);
                int length = bArr.length;
                while (length > 65536) {
                    cipherOutputStream.write(bArr, i, 65536);
                    i += 65536;
                    length -= 65536;
                }
                cipherOutputStream.write(bArr, i, length);
                cipherOutputStream.close();
                byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e) {
                e = e;
                bArr2 = byteArray;
                byteArray = iv;
                KmxErrorHandler.throwIfContain(e, "Invalid operation handle (internal Keystore code: -28", "(encryptData) KEYSTORE_TOO_MANY_OPERATIONS", 250);
                if (byteArray != null) {
                    Log.i(TAG, "encrypt1 gcmIv Len : " + byteArray.length + " gcmIv : " + bytesToHexString(byteArray));
                } else {
                    Log.e(TAG, "encrypt1 gcmIv is NULL");
                }
                if (bArr2 != null) {
                    Log.i(TAG, "encrypt2 cipherData Len : " + bArr2.length + " cipherData : " + bytesToHexString(bArr2));
                } else {
                    Log.e(TAG, "encrypt2 cipherData is NULL");
                }
                if (TextUtils.isEmpty(e.getMessage())) {
                    return bArr2;
                }
                if (e.getMessage().contains(AEAD_BAD_TAG_EXCEPTION)) {
                    throw new KmxException(AbstractC2322a.m1619i(e, new StringBuilder("EncryptData Exception :")), 107);
                }
                throw new KmxException(AbstractC2322a.m1619i(e, new StringBuilder("EncryptData Exception :")), 201);
            }
        } catch (Exception e2) {
            e = e2;
            bArr2 = null;
        }
    }

    public static boolean encryptStream(Key key, InputStream inputStream, OutputStream outputStream) {
        return encryptStream(key, inputStream, outputStream, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00dc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean decryptStream(Key key, InputStream inputStream, OutputStream outputStream, @Nullable CryptoProgressListener cryptoProgressListener) throws KmxException {
        int i;
        byte[] bArr;
        int i2;
        Key key2 = key;
        InputStream inputStream2 = inputStream;
        boolean z = false;
        Object[] objArr = 0;
        if (key2 == null) {
            Log.e(TAG, "decryptStream failed. no key data.");
            return false;
        }
        int i4 = 16;
        byte[] bArr2 = new byte[16];
        int i5 = 12;
        byte[] bArr3 = new byte[12];
        int i6 = STREAM_CHUNK_SIZE;
        byte[] bArr4 = new byte[STREAM_CHUNK_SIZE];
        byte[] bArr5 = new byte[STREAM_CHUNK_SIZE];
        Header header = new Header(objArr == true ? 1 : 0);
        Cipher cipher = null;
        int i7 = 0;
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        int i10 = 0;
        int blockType = 1048576;
        while (true) {
            if (i8 == 0) {
                try {
                    bArr = new byte[i4];
                    i2 = inputStream2.read(bArr);
                } catch (Exception e) {
                    e = e;
                    i = i9;
                }
                if (i2 < 0) {
                    break;
                }
                int i11 = i8 + i2;
                header.setHeader(bArr);
                blockType = ((header.getBlockType() & 240) >> 4) * 1048576;
                if (!header.checkMagicCode()) {
                    Log.e(TAG, "decryptStream failed. CIPHER_MAGIC_CODE is not correct");
                    return z;
                }
                int i12 = inputStream2.read(bArr2);
                if (i12 < 0) {
                    break;
                }
                i8 = i11 + i12;
                System.arraycopy(bArr2, z ? 1 : 0, bArr3, z ? 1 : 0, i5);
                cipher = Cipher.getInstance(TRANSFORMATION);
                cipher.init(2, key2, new GCMParameterSpec(128, bArr3));
                int i13 = blockType;
                i = inputStream2.read(bArr4, z ? 1 : 0, Math.min(i13 - i8, i6));
                if (i == -1) {
                    if (z2) {
                        try {
                            byte[] bArrUpdate = cipher.update(bArr5, z ? 1 : 0, i7);
                            if (bArrUpdate != null) {
                                outputStream.write(bArrUpdate);
                            }
                            i8 += i;
                            if (i8 < i13) {
                                byte[] bArrDoFinal = cipher.doFinal(bArr4, z ? 1 : 0, i);
                                if (bArrDoFinal == null) {
                                    Log.e(TAG, "[2] output is NULL");
                                } else {
                                    outputStream.write(bArrDoFinal);
                                    int i14 = i10 + i8;
                                    if (cryptoProgressListener != null) {
                                        cryptoProgressListener.onProgressChanged(i14);
                                    }
                                    i10 = i14;
                                }
                                key2 = key;
                                inputStream2 = inputStream;
                                blockType = i13;
                                i9 = i;
                                z = false;
                                i4 = 16;
                                i5 = 12;
                                i6 = STREAM_CHUNK_SIZE;
                                i8 = 0;
                                z2 = false;
                            } else {
                                Object[] objArr2 = z ? 1 : 0;
                                try {
                                    System.arraycopy(bArr4, objArr2 == true ? 1 : 0, bArr5, objArr2 == true ? 1 : 0, i);
                                    inputStream2 = inputStream;
                                    z = objArr2 == true ? 1 : 0;
                                    blockType = i13;
                                    i7 = i;
                                    i9 = i7;
                                    z2 = true;
                                    i4 = 16;
                                    i5 = 12;
                                    i6 = STREAM_CHUNK_SIZE;
                                    key2 = key;
                                } catch (Exception e2) {
                                    e = e2;
                                    i7 = i;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } else {
                        i8 += i;
                        if (i8 < i13) {
                        }
                    }
                    KmxErrorHandler.throwIfContain(e, "Invalid operation handle (internal Keystore code: -28", "(decryptStream) KEYSTORE_TOO_MANY_OPERATIONS", 250);
                    e.printStackTrace();
                    String str = TAG;
                    Log.e(str, "DecryptStream Exception :" + e.getMessage());
                    Log.e(str, "DecryptStream offset : " + i8 + " readLen : " + i + " prevLen : " + i7);
                    if (TextUtils.isEmpty(e.getMessage())) {
                        return true;
                    }
                    if (e.getMessage().contains(AEAD_BAD_TAG_EXCEPTION)) {
                        throw new KmxException(AbstractC2322a.m1619i(e, new StringBuilder("DecryptData Exception :")), 107);
                    }
                    throw new KmxException(AbstractC2322a.m1619i(e, new StringBuilder("DecryptData IOException :")), 202);
                }
                if (z2) {
                    byte[] bArrDoFinal2 = cipher.doFinal(bArr5, z ? 1 : 0, i7);
                    if (bArrDoFinal2 == null) {
                        Log.e(TAG, "readLen == -1 output is NULL");
                    } else {
                        outputStream.write(bArrDoFinal2);
                        int i15 = i10 + i8;
                        if (cryptoProgressListener != null) {
                            cryptoProgressListener.onProgressChanged(i15);
                        }
                    }
                }
            } else {
                int i132 = blockType;
                i = inputStream2.read(bArr4, z ? 1 : 0, Math.min(i132 - i8, i6));
                if (i == -1) {
                }
            }
        }
        z = z2;
        Log.i(TAG, "[2] NFU :" + z);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0166 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean encryptStream(Key key, InputStream inputStream, OutputStream outputStream, @Nullable CryptoProgressListener cryptoProgressListener) throws KmxException {
        int i;
        Key key2 = key;
        InputStream inputStream2 = inputStream;
        int i2 = 0;
        if (key2 == null) {
            Log.e(TAG, "encryptStream failed. no key data.");
            return false;
        }
        if (inputStream2 == null) {
            Log.e(TAG, "encryptStream failed. inputStream is null");
            return false;
        }
        if (outputStream == null) {
            Log.e(TAG, "encryptStream failed. outputStream is null");
            return false;
        }
        byte[] bArr = new byte[16];
        int i4 = STREAM_CHUNK_SIZE;
        byte[] bArr2 = new byte[STREAM_CHUNK_SIZE];
        byte[] bArr3 = new byte[STREAM_CHUNK_SIZE];
        Header header = new Header(i2);
        Cipher cipher = null;
        int i5 = 0;
        boolean z = false;
        int i6 = 0;
        int length = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = i5;
            try {
                i = inputStream2.read(bArr2, 0, Math.min(5242832 - i5, i4));
                if (i == -1) {
                    break;
                }
                if (z) {
                    try {
                        byte[] bArrUpdate = cipher.update(bArr3, 0, i6);
                        if (bArrUpdate != null) {
                            length += bArrUpdate.length;
                            outputStream.write(bArrUpdate);
                        }
                    } catch (Exception e) {
                        e = e;
                        i5 = i9;
                        KmxErrorHandler.throwIfContain(e, "Invalid operation handle (internal Keystore code: -28", "(encryptStream) KEYSTORE_TOO_MANY_OPERATIONS", 250);
                        e.printStackTrace();
                        String str = TAG;
                        Log.e(str, "encryptStream Exception :" + e.getMessage());
                        Log.e(str, "encryptStream offset : " + i5 + " readLen : " + i);
                        if (!TextUtils.isEmpty(e.getMessage())) {
                            return true;
                        }
                        if (e.getMessage().contains(AEAD_BAD_TAG_EXCEPTION)) {
                            throw new KmxException(AbstractC2322a.m1619i(e, new StringBuilder("EncryptStream Exception :")), 107);
                        }
                        throw new KmxException(AbstractC2322a.m1619i(e, new StringBuilder("EncryptStream Exception :")), 201);
                    }
                }
                if (i9 == 0) {
                    Cipher cipher2 = Cipher.getInstance(TRANSFORMATION);
                    cipher2.init(1, key2);
                    byte[] iv = cipher2.getIV();
                    System.arraycopy(iv, 0, bArr, 0, iv.length);
                    outputStream.write(header.makeHeader(80, 0));
                    outputStream.write(bArr);
                    length = 32;
                    cipher = cipher2;
                }
                i5 = i9 + i;
                if (i5 < 5242832) {
                    i4 = STREAM_CHUNK_SIZE;
                    if (i >= STREAM_CHUNK_SIZE) {
                        try {
                            System.arraycopy(bArr2, 0, bArr3, 0, i);
                            i6 = i;
                            i8 = i6;
                            z = true;
                        } catch (Exception e2) {
                            e = e2;
                            KmxErrorHandler.throwIfContain(e, "Invalid operation handle (internal Keystore code: -28", "(encryptStream) KEYSTORE_TOO_MANY_OPERATIONS", 250);
                            e.printStackTrace();
                            String str2 = TAG;
                            Log.e(str2, "encryptStream Exception :" + e.getMessage());
                            Log.e(str2, "encryptStream offset : " + i5 + " readLen : " + i);
                            if (!TextUtils.isEmpty(e.getMessage())) {
                            }
                        }
                    }
                }
                byte[] bArrDoFinal = cipher.doFinal(bArr2, 0, i);
                if (bArrDoFinal == null) {
                    Log.e(TAG, "[2] output is NULL");
                } else {
                    length += bArrDoFinal.length;
                    i7 += length;
                    outputStream.write(bArrDoFinal);
                    if (cryptoProgressListener != null) {
                        cryptoProgressListener.onProgressChanged(i7);
                    }
                }
                key2 = key;
                inputStream2 = inputStream;
                i8 = i;
                i4 = STREAM_CHUNK_SIZE;
                i5 = 0;
                z = false;
            } catch (Exception e3) {
                e = e3;
                i = i8;
            }
        }
        if (!z) {
            return true;
        }
        byte[] bArrDoFinal2 = cipher.doFinal(bArr3, 0, i6);
        if (bArrDoFinal2 == null) {
            Log.e(TAG, "readLen == -1 output is NULL");
            return true;
        }
        outputStream.write(bArrDoFinal2);
        int length2 = length + bArrDoFinal2.length + i7;
        if (cryptoProgressListener == null) {
            return true;
        }
        cryptoProgressListener.onProgressChanged(length2);
        return true;
    }
}
