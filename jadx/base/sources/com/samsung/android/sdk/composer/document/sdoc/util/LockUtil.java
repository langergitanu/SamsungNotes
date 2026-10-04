package com.samsung.android.sdk.composer.document.sdoc.util;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocInvalidPasswordException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.pen.document.util.CipherBlockInputStreamUtil;
import com.samsung.android.sdk.pen.document.util.LogUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lingala.zip4j.util.InternalZipConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007J&\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007J,\u0010\u0013\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u001c\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/util/LockUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "CIPHER_BUF_SIZE", "", "CIPHER_INTERATION_COUNT", "CIPHER_KEY_BIT_LENGTH", "encrypt", "", "filePath", "password", "decrypt", "srcPath", "destPath", "isInvalidDecryption", "", "decryptCore", "endTag", "Lcom/samsung/android/sdk/composer/document/sdoc/util/EndTagUtil;", "forceRenameTo", "curPath", "newPath", "concatFile", "baseFilePath", "extraFilePath", "deleteFile", "dir", "Ljava/io/File;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLockUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockUtil.kt\ncom/samsung/android/sdk/composer/document/sdoc/util/LockUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,595:1\n1#2:596\n*E\n"})
public final class LockUtil {
    private static final int CIPHER_BUF_SIZE = 4096;
    private static final int CIPHER_INTERATION_COUNT = 4000;
    private static final int CIPHER_KEY_BIT_LENGTH = 256;

    @NotNull
    public static final LockUtil INSTANCE = new LockUtil();

    @NotNull
    private static final String TAG = "SpenSDocLockUtil";

    private LockUtil() {
    }

    private final void concatFile(String baseFilePath, String extraFilePath) throws Throwable {
        RandomAccessFile randomAccessFile;
        if (!AbstractC2322a.m1607A(baseFilePath)) {
            throw new IOException(AbstractC0541b.m773o("concatFile() - Fail to load base file. [", LogUtil.logPath(baseFilePath), "]"));
        }
        if (!AbstractC2322a.m1607A(extraFilePath)) {
            throw new IOException(AbstractC0541b.m773o("concatFile() - Fail to load extra file. [", LogUtil.logPath(extraFilePath), "]"));
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            RandomAccessFile randomAccessFile3 = new RandomAccessFile(baseFilePath, InternalZipConstants.WRITE_MODE);
            try {
                randomAccessFile = new RandomAccessFile(extraFilePath, InternalZipConstants.WRITE_MODE);
                try {
                    randomAccessFile3.seek(randomAccessFile3.length());
                    while (true) {
                        int i = randomAccessFile.read();
                        if (i != -1) {
                            randomAccessFile3.write(i);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                                Log.e(TAG, "concatFile() - fail to close RandomAccessFile - baseRaf");
                            }
                        }
                    }
                    randomAccessFile3.close();
                } catch (IOException unused2) {
                    randomAccessFile2 = randomAccessFile3;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException unused3) {
                            Log.e(TAG, "concatFile() - fail to close RandomAccessFile - baseRaf");
                        }
                    }
                    if (randomAccessFile == null) {
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile3;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException unused4) {
                            Log.e(TAG, "concatFile() - fail to close RandomAccessFile - baseRaf");
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused5) {
                        Log.e(TAG, "concatFile() - fail to close RandomAccessFile - extraRaf");
                        throw th;
                    }
                }
            } catch (IOException unused6) {
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
        } catch (IOException unused7) {
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
        try {
            randomAccessFile.close();
        } catch (IOException unused8) {
            Log.e(TAG, "concatFile() - fail to close RandomAccessFile - extraRaf");
        }
    }

    @JvmStatic
    public static final void decrypt(@NotNull String filePath, @NotNull String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(password, "password");
        Log.d(TAG, "decrypt() - [" + LogUtil.logPath(filePath) + "] start");
        String str = filePath + DiskFileUpload.postfix;
        EndTagUtil endTagUtil = new EndTagUtil(null);
        endTagUtil.parse(filePath, true);
        if (endTagUtil.isEncrypted()) {
            decrypt(filePath, str, password);
            File file = new File(str);
            if (!file.exists()) {
                throw new SpenSDocInvalidPasswordException("decrypt() - Invalid password.");
            }
            try {
                new EndTagUtil(null).parse(str, true);
                INSTANCE.forceRenameTo(str, filePath);
                Log.d(TAG, "decrypt end");
            } catch (SpenSDocUnsupportedFileException unused) {
                if (!file.delete()) {
                    AbstractC6670b.m4757r("decrypt() - fail to delete temporary file. [", LogUtil.logPath(file.getPath()), "]", TAG);
                }
                throw new SpenSDocInvalidPasswordException("decrypt() - Invalid password.");
            }
        }
    }

    private final void deleteFile(File dir) throws IOException {
        File[] fileArrListFiles;
        if (dir.isDirectory() && (fileArrListFiles = dir.listFiles()) != null) {
            Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
            while (it.hasNext()) {
                File file = (File) it.next();
                Intrinsics.checkNotNull(file);
                deleteFile(file);
            }
        }
        if (!dir.delete()) {
            throw new IOException(AbstractC0541b.m773o("Fail to delete [", LogUtil.logPath(dir.getPath()), "]"));
        }
    }

    @JvmStatic
    public static final void encrypt(@NotNull String filePath, @NotNull String password) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        String str;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(password, "password");
        Log.d(TAG, "encrypt() - [" + LogUtil.logPath(filePath) + "] start");
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("encrypt() - the file isn't exist");
        }
        EndTagUtil endTagUtil = new EndTagUtil(null);
        endTagUtil.parse(filePath, true);
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
                    String str2 = "]";
                    if (file2.exists() && !file2.delete()) {
                        AbstractC6670b.m4757r("encrypt() - fail to delete temporary file. [", LogUtil.logPath(strM756B), "]", TAG);
                    }
                    try {
                        fileInputStream2 = new FileInputStream(filePath);
                    } catch (FileNotFoundException unused) {
                        fileInputStream = null;
                    }
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            try {
                                int i = fileInputStream2.read(bArr2);
                                fileInputStream3 = fileInputStream2;
                                str = str2;
                                if (i != -1) {
                                    try {
                                        try {
                                            cipherOutputStream.write(bArr2, 0, i);
                                            fileInputStream2 = fileInputStream3;
                                            str2 = str;
                                        } catch (IOException e) {
                                            throw e;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            cipherOutputStream.close();
                                        } catch (IOException unused2) {
                                            Log.e(TAG, "encrypt() - fail to close lock stream.(CipherOutputStream - cos)");
                                        }
                                        try {
                                            fileInputStream3.close();
                                        } catch (IOException unused3) {
                                            Log.e(TAG, "encrypt() - fail to close lock stream.(FileInputStream - fis)");
                                        }
                                        try {
                                            fileOutputStream.close();
                                            throw th;
                                        } catch (IOException unused4) {
                                            Log.e(TAG, "encrypt() - fail to close lock stream.(FileOutputStream - fos)");
                                            throw th;
                                        }
                                    }
                                } else {
                                    try {
                                        break;
                                    } catch (IOException unused5) {
                                        Log.e(TAG, "encrypt() - fail to close lock stream.(CipherOutputStream - cos)");
                                    }
                                }
                            } catch (IOException e2) {
                                fileInputStream3 = fileInputStream2;
                                throw e2;
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream3 = fileInputStream2;
                                cipherOutputStream.close();
                                fileInputStream3.close();
                                fileOutputStream.close();
                                throw th;
                            }
                        }
                        cipherOutputStream.close();
                        try {
                            fileInputStream3.close();
                        } catch (IOException unused6) {
                            Log.e(TAG, "encrypt() - fail to close lock stream.(FileInputStream - fis)");
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused7) {
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
                                        endTagUtil.setEncryptionInfo((int) file.length(), bArr3, bArr, cipher.wrap(secretKeyGenerateKey));
                                        endTagUtil.setCreatedTime(endTagUtil.getMCreatedTime());
                                        endTagUtil.setModifiedTime(endTagUtil.getMModifiedTime());
                                        String str3 = strM756B + ".tag";
                                        endTagUtil.writeBytes(str3, false);
                                        LockUtil lockUtil = INSTANCE;
                                        lockUtil.concatFile(strM756B, str3);
                                        lockUtil.forceRenameTo(strM756B, filePath);
                                        File file3 = new File(str3);
                                        if (file3.exists() && !file3.delete()) {
                                            AbstractC6670b.m4757r("encrypt() - fail to delete temporary tag file. [", LogUtil.logPath(str3), str, TAG);
                                        }
                                        Log.d(TAG, "encrypt end");
                                    } catch (InvalidKeyException unused8) {
                                        throw new IllegalStateException("encrypt() - invalid state 12");
                                    } catch (IllegalBlockSizeException unused9) {
                                        throw new IllegalStateException("encrypt() - invalid state 11");
                                    }
                                } catch (InvalidAlgorithmParameterException unused10) {
                                    throw new IllegalStateException("encrypt() - invalid state 10");
                                } catch (InvalidKeyException unused11) {
                                    throw new IllegalStateException("encrypt() - invalid state 9");
                                }
                            } catch (InvalidKeySpecException unused12) {
                                throw new IllegalStateException("encrypt() - invalid state 8");
                            }
                        } catch (NoSuchAlgorithmException unused13) {
                            throw new IllegalStateException("encrypt() - invalid state 7");
                        }
                    } catch (FileNotFoundException unused14) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw new IllegalStateException("lock() - invalid state 6");
                    }
                } catch (InvalidAlgorithmParameterException unused15) {
                    throw new IllegalStateException("encrypt() - invalid state 5");
                } catch (InvalidKeyException unused16) {
                    throw new IllegalStateException("encrypt() - invalid state 4");
                }
            } catch (NoSuchAlgorithmException unused17) {
                throw new IllegalStateException("encrypt() - invalid state 2");
            } catch (NoSuchPaddingException unused18) {
                throw new IllegalStateException("encrypt() - invalid state 3");
            }
        } catch (NoSuchAlgorithmException unused19) {
            throw new IllegalStateException("encrypt() - invalid state 1");
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

    @JvmStatic
    public static final boolean isInvalidDecryption(@NotNull String srcPath, @NotNull String destPath, @NotNull String password) {
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        Intrinsics.checkNotNullParameter(destPath, "destPath");
        Intrinsics.checkNotNullParameter(password, "password");
        Log.d(TAG, "isInvalidDecryption() - start");
        if (!new File(srcPath).exists()) {
            Log.d(TAG, "isInvalidDecryption() - file isn't exist");
            return false;
        }
        EndTagUtil endTagUtil = new EndTagUtil(null);
        try {
            endTagUtil.parse(srcPath, true);
            if (!endTagUtil.isEncrypted()) {
                Log.d(TAG, "isInvalidDecryption() - this file is not locked");
                return false;
            }
            INSTANCE.decryptCore(srcPath, destPath, password, endTagUtil);
            try {
                new EndTagUtil(null).parse(destPath, true);
            } catch (SpenSDocUnsupportedFileException e) {
                Log.d(TAG, "isInvalidDecryption() - invalid file : " + e);
                return true;
            } catch (Exception e2) {
                Log.d(TAG, "isInvalidDecryption() - catch Exception : " + e2);
            }
            Log.d(TAG, "isInvalidDecryption end");
            return false;
        } catch (Exception e3) {
            Log.d(TAG, "isInvalidDecryption() - decrypt exception : " + e3);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c6, code lost:
    
        r13.write(r9, 0, r8 - (r15 - r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void decryptCore(@Nullable String srcPath, @Nullable String destPath, @Nullable String password, @NotNull EndTagUtil endTag) throws SpenSDocInvalidPasswordException, IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Intrinsics.checkNotNullParameter(endTag, "endTag");
        if (srcPath == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (destPath == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Log.d(TAG, "decryptCore() - [" + LogUtil.logPath(srcPath) + "] start");
        byte[] encryptionSalt = endTag.getEncryptionSalt();
        byte[] encryptionIv = endTag.getEncryptionIv();
        byte[] encryptionKey = endTag.getEncryptionKey();
        Intrinsics.checkNotNull(password);
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
                                            } catch (IOException e3) {
                                                throw new IOException("decryptCore() - fail12. [" + e3 + "]");
                                            }
                                        } finally {
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
                                throw new SpenSDocInvalidPasswordException("decryptCore() - fail10. [" + e6 + "]");
                            } catch (InvalidKeyException e7) {
                                throw new SpenSDocInvalidPasswordException("decryptCore() - fail9. [" + e7 + "]");
                            }
                        } catch (InvalidKeyException e8) {
                            throw new SpenSDocInvalidPasswordException("decryptCore() - fail7. [" + e8 + "]");
                        } catch (NoSuchAlgorithmException e9) {
                            throw new SpenSDocInvalidPasswordException("decryptCore() - fail8. [" + e9 + "]");
                        }
                    } catch (InvalidAlgorithmParameterException e10) {
                        throw new SpenSDocInvalidPasswordException("decryptCore() - fail5. [" + e10 + "]");
                    } catch (InvalidKeyException e11) {
                        throw new SpenSDocInvalidPasswordException("decryptCore() - fail6. [" + e11 + "]");
                    }
                } catch (NoSuchAlgorithmException e12) {
                    throw new SpenSDocInvalidPasswordException("decryptCore() - fail3. [" + e12 + "]");
                } catch (NoSuchPaddingException e13) {
                    throw new SpenSDocInvalidPasswordException("decryptCore() - fail4. [" + e13 + "]");
                }
            } catch (InvalidKeySpecException e14) {
                throw new SpenSDocInvalidPasswordException("decryptCore() - fail2. [" + e14 + "]");
            }
        } catch (NoSuchAlgorithmException e15) {
            throw new SpenSDocInvalidPasswordException("decryptCore() - fail1. [" + e15 + "]");
        }
    }

    @JvmStatic
    public static final void decrypt(@Nullable String srcPath, @Nullable String destPath, @Nullable String password) {
        Log.d(TAG, "decrypt2() - start");
        if (srcPath != null) {
            if (AbstractC2322a.m1607A(srcPath)) {
                EndTagUtil endTagUtil = new EndTagUtil(null);
                endTagUtil.parse(srcPath, true);
                if (endTagUtil.isEncrypted()) {
                    INSTANCE.decryptCore(srcPath, destPath, password, endTagUtil);
                    EndTagUtil endTagUtil2 = new EndTagUtil(null);
                    try {
                        endTagUtil2.parse(destPath, true);
                        endTagUtil2.setReminderData(endTagUtil.getReminderData());
                        endTagUtil2.setFavorite(endTagUtil.getMFavoriteFlag());
                        endTagUtil2.setCreatedTime(endTagUtil.getMCreatedTime());
                        endTagUtil2.setModifiedTime(endTagUtil.getMModifiedTime());
                        endTagUtil2.update(destPath);
                        Log.d(TAG, "decrypt2 end");
                        return;
                    } catch (SpenSDocUnsupportedFileException unused) {
                        throw new SpenSDocInvalidPasswordException("decrypt2() - invalid file");
                    }
                }
                throw new IllegalStateException("decrypt2() - this file is not locked");
            }
            throw new IOException("decrypt2() - the file isn't exist");
        }
        throw new IllegalArgumentException("Required value was null.");
    }
}
