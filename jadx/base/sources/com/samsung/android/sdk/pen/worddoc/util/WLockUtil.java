package com.samsung.android.sdk.pen.worddoc.util;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.document.SpenInvalidPasswordException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.util.CipherBlockInputStreamUtil;
import com.samsung.android.sdk.pen.document.util.LogUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
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
import java.util.Iterator;
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
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005J$\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005J0\u0010\u0011\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/util/WLockUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "CIPHER_BUF_SIZE", "", "CIPHER_INTERATION_COUNT", "CIPHER_KEY_BIT_LENGTH", "encrypt", "", "filePath", "password", "decrypt", "srcPath", "destPath", "decryptCore", "endTag", "Lcom/samsung/android/sdk/pen/worddoc/util/WEndTagUtil;", "forceRenameTo", "curPath", "newPath", "deleteFile", "dir", "Ljava/io/File;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWLockUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WLockUtil.kt\ncom/samsung/android/sdk/pen/worddoc/util/WLockUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,492:1\n1#2:493\n*E\n"})
public final class WLockUtil {
    private static final int CIPHER_BUF_SIZE = 4096;
    private static final int CIPHER_INTERATION_COUNT = 4000;
    private static final int CIPHER_KEY_BIT_LENGTH = 256;

    @NotNull
    public static final WLockUtil INSTANCE = new WLockUtil();

    @NotNull
    private static final String TAG = "WLockUtil";

    private WLockUtil() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bd, code lost:
    
        r12.write(r13, 0, r7 - (r15 - r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void decryptCore(String srcPath, String destPath, String password, WEndTagUtil endTag) throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        if (srcPath == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (endTag == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (password == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Log.d(TAG, "decryptCore() - [" + LogUtil.logPath(srcPath) + "] start");
        byte[] encryptionSalt = endTag.getEncryptionSalt();
        byte[] encryptionIv = endTag.getEncryptionIv();
        byte[] encryptionKey = endTag.getEncryptionKey();
        char[] charArray = password.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        try {
            try {
                SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(charArray, encryptionSalt, 4000, 256));
                try {
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(encryptionIv);
                    try {
                        cipher.init(4, secretKeyGenerateSecret, ivParameterSpec);
                        try {
                            try {
                                cipher.init(2, cipher.unwrap(encryptionKey, AES256KeyLoader.AES_ALGORITHM, 3), ivParameterSpec);
                                int encryptionSize = endTag.getEncryptionSize();
                                FileInputStream fileInputStream2 = null;
                                try {
                                    fileInputStream = new FileInputStream(srcPath);
                                    try {
                                        fileOutputStream = new FileOutputStream(destPath);
                                    } catch (IOException e) {
                                        e = e;
                                        fileOutputStream = null;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    fileOutputStream = null;
                                }
                                try {
                                    Log.d(TAG, "decryptCore() - working.. [" + fileInputStream.available() + "], [" + encryptionSize + "]");
                                    CipherBlockInputStreamUtil cipherBlockInputStreamUtil = new CipherBlockInputStreamUtil(fileInputStream, encryptionSize);
                                    CipherInputStream cipherInputStream = new CipherInputStream(cipherBlockInputStreamUtil, cipher);
                                    int i = 4096;
                                    byte[] bArr = new byte[4096];
                                    int i2 = 0;
                                    while (true) {
                                        try {
                                            try {
                                                int i4 = cipherInputStream.read(bArr, 0, i);
                                                if (i4 != -1) {
                                                    i2 += i4;
                                                    if (i2 > encryptionSize) {
                                                        break;
                                                    }
                                                    fileOutputStream.write(bArr, 0, i4);
                                                    i = 4096;
                                                }
                                            } finally {
                                            }
                                        } catch (IOException e3) {
                                            throw new IOException("decryptCore() - fail12. [" + e3 + "]");
                                        }
                                    }
                                    try {
                                        cipherInputStream.close();
                                    } catch (IOException unused) {
                                        Log.e(TAG, "decryptCore() - fail to close unlock stream.(CipherInputStream)");
                                    }
                                    try {
                                        cipherBlockInputStreamUtil.close();
                                    } catch (IOException unused2) {
                                        Log.e(TAG, "decryptCore() - fail to close unlock stream.(SDocCipherBlockInputStream)");
                                    }
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException unused3) {
                                        Log.e(TAG, "decryptCore() - fail to close unlock stream.(FileInputStream)");
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused4) {
                                        Log.e(TAG, "decryptCore() - fail to close unlock stream.(FileOutputStream)");
                                    }
                                    if (!AbstractC2322a.m1607A(destPath)) {
                                        throw new IOException("decryptCore() - the destFile isn't exist");
                                    }
                                    Log.d(TAG, "decryptCore end");
                                } catch (IOException e5) {
                                    e = e5;
                                    fileInputStream2 = fileInputStream;
                                    if (fileInputStream2 != null) {
                                        fileInputStream2.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw new IOException("decryptCore() - fail11. [" + e + "]");
                                }
                            } catch (InvalidAlgorithmParameterException e6) {
                                throw new SpenInvalidPasswordException("decryptCore() - fail10. [" + e6 + "]");
                            } catch (InvalidKeyException e7) {
                                throw new SpenInvalidPasswordException("decryptCore() - fail9. [" + e7 + "]");
                            }
                        } catch (InvalidKeyException e8) {
                            throw new SpenInvalidPasswordException("decryptCore() - fail7. [" + e8 + "]");
                        } catch (NoSuchAlgorithmException e9) {
                            throw new SpenInvalidPasswordException("decryptCore() - fail8. [" + e9 + "]");
                        }
                    } catch (InvalidAlgorithmParameterException e10) {
                        throw new SpenInvalidPasswordException("decryptCore() - fail5. [" + e10 + "]");
                    } catch (InvalidKeyException e11) {
                        throw new SpenInvalidPasswordException("decryptCore() - fail6. [" + e11 + "]");
                    }
                } catch (NoSuchAlgorithmException e12) {
                    throw new SpenInvalidPasswordException("decryptCore() - fail3. [" + e12 + "]");
                } catch (NoSuchPaddingException e13) {
                    throw new SpenInvalidPasswordException("decryptCore() - fail4. [" + e13 + "]");
                }
            } catch (InvalidKeySpecException e14) {
                throw new SpenInvalidPasswordException("decryptCore() - fail2. [" + e14 + "]");
            }
        } catch (NoSuchAlgorithmException e15) {
            throw new SpenInvalidPasswordException("decryptCore() - fail1. [" + e15 + "]");
        }
    }

    private final void deleteFile(File dir) throws IOException {
        File[] fileArrListFiles;
        if (dir == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (dir.isDirectory() && (fileArrListFiles = dir.listFiles()) != null) {
            Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
            while (it.hasNext()) {
                deleteFile((File) it.next());
            }
        }
        if (!dir.delete()) {
            throw new IOException(AbstractC0541b.m773o("Fail to delete [", LogUtil.logPath(dir.getPath()), "]"));
        }
    }

    private final void forceRenameTo(String curPath, String newPath) throws IOException {
        if (curPath == null || newPath == null) {
            Log.i(TAG, "forceRenameTo() - Invalid argument.");
            return;
        }
        File file = new File(curPath);
        if (!file.exists()) {
            throw new IOException(AbstractC0541b.m773o("forceRenameTo() - Fail to get current path File. [", LogUtil.logPath(curPath), "]"));
        }
        File file2 = new File(newPath);
        if (file2.exists()) {
            if (Intrinsics.areEqual(file, file2)) {
                return;
            } else {
                deleteFile(file2);
            }
        }
        if (!file.renameTo(file2)) {
            throw new IOException(AbstractC0541b.m775q("forceRenameTo() - Cannot rename temp file [", LogUtil.logPath(curPath), "] to [", LogUtil.logPath(newPath), "]"));
        }
    }

    public final void decrypt(@Nullable String filePath, @Nullable String password) {
        if (filePath == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        AbstractC6670b.m4757r("decrypt() - [", LogUtil.logPath(filePath), "] start", TAG);
        String strConcat = filePath.concat(DiskFileUpload.postfix);
        if (new WEndTagUtil(filePath).isEncrypted()) {
            decrypt(filePath, strConcat, password);
            File file = new File(strConcat);
            if (!file.exists()) {
                throw new SpenInvalidPasswordException("decrypt() - Invalid password.");
            }
            try {
                new WEndTagUtil(strConcat);
                forceRenameTo(strConcat, filePath);
                Log.d(TAG, "decrypt end");
            } catch (SpenUnsupportedTypeException unused) {
                if (!file.delete()) {
                    AbstractC6670b.m4757r("decrypt() - fail to delete temporary file. [", LogUtil.logPath(file.getPath()), "]", TAG);
                }
                throw new SpenInvalidPasswordException("decrypt() - Invalid password.");
            }
        }
    }

    public final void encrypt(@Nullable String filePath, @Nullable String password) {
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNull(filePath);
        AbstractC6670b.m4757r("encrypt() - [", LogUtil.logPath(filePath), "] start", TAG);
        if (password == null) {
            throw new IllegalArgumentException("lock() - invalid argument");
        }
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("encrypt() - the file isn't exist");
        }
        WEndTagUtil wEndTagUtil = new WEndTagUtil(filePath);
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AES256KeyLoader.AES_ALGORITHM);
            keyGenerator.init(256);
            SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                byte[] bArr = new byte[cipher.getBlockSize()];
                new SecureRandom().nextBytes(bArr);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                try {
                    cipher.init(1, secretKeyGenerateKey, ivParameterSpec);
                    String strM756B = AbstractC0541b.m756B(filePath, DiskFileUpload.postfix);
                    File file2 = new File(strM756B);
                    if (file2.exists() && !file2.delete()) {
                        AbstractC6670b.m4757r("encrypt() - fail to delete temporary file. [", LogUtil.logPath(strM756B), "]", TAG);
                    }
                    FileInputStream fileInputStream = null;
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(filePath);
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                            CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream2, cipher);
                            byte[] bArr2 = new byte[4096];
                            while (true) {
                                try {
                                    int i = fileInputStream2.read(bArr2);
                                    fileOutputStream = fileOutputStream2;
                                    if (i != -1) {
                                        try {
                                            cipherOutputStream.write(bArr2, 0, i);
                                            fileOutputStream2 = fileOutputStream;
                                        } catch (IOException e) {
                                            e = e;
                                            try {
                                                throw e;
                                            } catch (Throwable th) {
                                                th = th;
                                                try {
                                                    cipherOutputStream.close();
                                                } catch (IOException unused) {
                                                    Log.e(TAG, "encrypt() - fail to close lock stream.(CipherOutputStream - cos)");
                                                }
                                                try {
                                                    fileInputStream2.close();
                                                } catch (IOException unused2) {
                                                    Log.e(TAG, "encrypt() - fail to close lock stream.(FileInputStream - fis)");
                                                }
                                                try {
                                                    fileOutputStream.close();
                                                    throw th;
                                                } catch (IOException unused3) {
                                                    Log.e(TAG, "encrypt() - fail to close lock stream.(FileOutputStream - fos)");
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cipherOutputStream.close();
                                            fileInputStream2.close();
                                            fileOutputStream.close();
                                            throw th;
                                        }
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException unused4) {
                                            Log.e(TAG, "encrypt() - fail to close lock stream.(CipherOutputStream - cos)");
                                        }
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    fileOutputStream = fileOutputStream2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = fileOutputStream2;
                                }
                            }
                            cipherOutputStream.close();
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused5) {
                                Log.e(TAG, "encrypt() - fail to close lock stream.(FileInputStream - fis)");
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused6) {
                                Log.e(TAG, "encrypt() - fail to close lock stream.(FileOutputStream - fos)");
                            }
                            byte[] bArr3 = new byte[32];
                            new SecureRandom().nextBytes(bArr3);
                            char[] charArray = password.toCharArray();
                            Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
                            try {
                                try {
                                    try {
                                        cipher.init(3, SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(charArray, bArr3, 4000, 256)), ivParameterSpec);
                                        try {
                                            wEndTagUtil.setEncryptionInfo((int) file.length(), bArr3, bArr, cipher.wrap(secretKeyGenerateKey));
                                            wEndTagUtil.append(strM756B);
                                            forceRenameTo(strM756B, filePath);
                                            Log.d(TAG, "encrypt end");
                                        } catch (InvalidKeyException unused7) {
                                            throw new IllegalStateException("encrypt() - invalid state 12");
                                        } catch (IllegalBlockSizeException unused8) {
                                            throw new IllegalStateException("encrypt() - invalid state 11");
                                        }
                                    } catch (InvalidAlgorithmParameterException unused9) {
                                        throw new IllegalStateException("encrypt() - invalid state 10");
                                    } catch (InvalidKeyException unused10) {
                                        throw new IllegalStateException("encrypt() - invalid state 9");
                                    }
                                } catch (InvalidKeySpecException unused11) {
                                    throw new IllegalStateException("encrypt() - invalid state 8");
                                }
                            } catch (NoSuchAlgorithmException unused12) {
                                throw new IllegalStateException("encrypt() - invalid state 7");
                            }
                        } catch (FileNotFoundException unused13) {
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused14) {
                                    Log.e(TAG, "encrypt() - fail to close lock stream.(FileInputStream - fis)");
                                }
                            }
                            throw new IllegalStateException("encrypt() - invalid state 6");
                        }
                    } catch (FileNotFoundException unused15) {
                    }
                } catch (InvalidAlgorithmParameterException unused16) {
                    throw new IllegalStateException("encrypt() - invalid state 5");
                } catch (InvalidKeyException unused17) {
                    throw new IllegalStateException("encrypt() - invalid state 4");
                }
            } catch (NoSuchAlgorithmException unused18) {
                throw new IllegalStateException("encrypt() - invalid state 2");
            } catch (NoSuchPaddingException unused19) {
                throw new IllegalStateException("encrypt() - invalid state 3");
            }
        } catch (NoSuchAlgorithmException unused20) {
            throw new IllegalStateException("encrypt() - invalid state 1");
        }
    }

    public final void decrypt(@Nullable String srcPath, @Nullable String destPath, @Nullable String password) {
        Log.d(TAG, "decrypt2() - start");
        if (destPath == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (srcPath != null && password != null) {
            if (AbstractC2322a.m1607A(srcPath)) {
                WEndTagUtil wEndTagUtil = new WEndTagUtil(srcPath);
                if (wEndTagUtil.isEncrypted()) {
                    decryptCore(srcPath, destPath, password, wEndTagUtil);
                    try {
                        new WEndTagUtil(destPath);
                        wEndTagUtil.removeEncryptionInfo();
                        wEndTagUtil.replace(destPath);
                        Log.d(TAG, "decrypt2 end");
                        return;
                    } catch (SpenUnsupportedTypeException unused) {
                        throw new SpenInvalidPasswordException("decrypt2() - invalid file");
                    }
                }
                throw new IllegalStateException("decrypt2() - this file is not locked");
            }
            throw new IOException("decrypt2() - the file isn't exist");
        }
        throw new IllegalArgumentException("decrypt2() - invalid argument");
    }
}
