package io.netty.handler.ssl.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.apache.commons.text.lookup.StringLookupFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class SelfSignedCertificate {
    private final X509Certificate cert;
    private final File certificate;
    private final PrivateKey key;
    private final File privateKey;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SelfSignedCertificate.class);
    private static final Date DEFAULT_NOT_BEFORE = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotBefore", System.currentTimeMillis() - 31536000000L));
    private static final Date DEFAULT_NOT_AFTER = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotAfter", 253402300799000L));
    private static final int DEFAULT_KEY_LENGTH_BITS = SystemPropertyUtil.getInt("io.netty.handler.ssl.util.selfSignedKeyStrength", 2048);

    public SelfSignedCertificate() {
        this(DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA, DEFAULT_KEY_LENGTH_BITS);
    }

    public static String[] newSelfSignedCertificate(String str, PrivateKey privateKey, X509Certificate x509Certificate) throws IOException {
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(privateKey.getEncoded());
        try {
            ByteBuf byteBufEncode = Base64.encode(byteBufWrappedBuffer, true);
            try {
                StringBuilder sb = new StringBuilder("-----BEGIN PRIVATE KEY-----\n");
                Charset charset = CharsetUtil.US_ASCII;
                sb.append(byteBufEncode.toString(charset));
                sb.append("\n-----END PRIVATE KEY-----\n");
                String string = sb.toString();
                byteBufWrappedBuffer.release();
                String strReplaceAll = str.replaceAll("[^\\w.-]", "x");
                File fileCreateTempFile = PlatformDependent.createTempFile("keyutil_" + strReplaceAll + '_', ".key", null);
                fileCreateTempFile.deleteOnExit();
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    fileOutputStream.write(string.getBytes(charset));
                    fileOutputStream.close();
                    byteBufWrappedBuffer = Unpooled.wrappedBuffer(x509Certificate.getEncoded());
                    try {
                        try {
                            String str2 = "-----BEGIN CERTIFICATE-----\n" + Base64.encode(byteBufWrappedBuffer, true).toString(charset) + "\n-----END CERTIFICATE-----\n";
                            byteBufWrappedBuffer.release();
                            File fileCreateTempFile2 = PlatformDependent.createTempFile("keyutil_" + strReplaceAll + '_', ".crt", null);
                            fileCreateTempFile2.deleteOnExit();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(fileCreateTempFile2);
                            try {
                                fileOutputStream2.write(str2.getBytes(charset));
                                fileOutputStream2.close();
                                return new String[]{fileCreateTempFile2.getPath(), fileCreateTempFile.getPath()};
                            } catch (Throwable th) {
                                safeClose(fileCreateTempFile2, fileOutputStream2);
                                safeDelete(fileCreateTempFile2);
                                safeDelete(fileCreateTempFile);
                                throw th;
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    safeClose(fileCreateTempFile, fileOutputStream);
                    safeDelete(fileCreateTempFile);
                    throw th2;
                }
            } finally {
            }
        } finally {
        }
    }

    private static void safeClose(File file, OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to close a file: " + file, (Throwable) e);
            }
        }
    }

    private static void safeDelete(File file) {
        if (file.delete()) {
            return;
        }
        InternalLogger internalLogger = logger;
        if (internalLogger.isWarnEnabled()) {
            internalLogger.warn("Failed to delete a file: " + file);
        }
    }

    public X509Certificate cert() {
        return this.cert;
    }

    public File certificate() {
        return this.certificate;
    }

    public void delete() {
        safeDelete(this.certificate);
        safeDelete(this.privateKey);
    }

    public PrivateKey key() {
        return this.key;
    }

    public File privateKey() {
        return this.privateKey;
    }

    public SelfSignedCertificate(Date date, Date date2) {
        this(StringLookupFactory.KEY_LOCALHOST, date, date2, AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA, DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(Date date, Date date2, String str, int i) {
        this(StringLookupFactory.KEY_LOCALHOST, date, date2, str, i);
    }

    public SelfSignedCertificate(String str) {
        this(str, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA, DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(String str, String str2, int i) {
        this(str, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, str2, i);
    }

    public SelfSignedCertificate(String str, Date date, Date date2) {
        this(str, ThreadLocalInsecureRandom.current(), DEFAULT_KEY_LENGTH_BITS, date, date2, AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA);
    }

    public SelfSignedCertificate(String str, Date date, Date date2, String str2, int i) {
        this(str, ThreadLocalInsecureRandom.current(), i, date, date2, str2);
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, int i) {
        this(str, secureRandom, i, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA);
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, String str2, int i) {
        this(str, secureRandom, i, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, str2);
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, int i, Date date, Date date2) {
        this(str, secureRandom, i, date, date2, AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SelfSignedCertificate(String str, SecureRandom secureRandom, int i, Date date, Date date2, String str2) throws Throwable {
        CertificateException certificateException;
        String[] strArrGenerate;
        ?? r7;
        Throwable th;
        Exception exc;
        if (!"EC".equalsIgnoreCase(str2) && !AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA.equalsIgnoreCase(str2)) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("Algorithm not valid: ", str2));
        }
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(str2);
            keyPairGenerator.initialize(i, secureRandom);
            KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            try {
                strArrGenerate = BouncyCastleSelfSignedCertGenerator.generate(str, keyPairGenerateKeyPair, secureRandom, date, date2, str2);
            } finally {
                try {
                } catch (Throwable th2) {
                }
            }
            File file = new File(strArrGenerate[0]);
            this.certificate = file;
            this.privateKey = new File(strArrGenerate[1]);
            this.key = keyPairGenerateKeyPair.getPrivate();
            try {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        this.cert = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            if (logger.isWarnEnabled()) {
                                logger.warn("Failed to close a file: " + this.certificate, (Throwable) e);
                            }
                        }
                    } catch (Exception e2) {
                        exc = e2;
                        throw new CertificateEncodingException(exc);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r7 = keyPairGenerateKeyPair;
                    if (r7 == 0) {
                        try {
                            r7.close();
                            throw th;
                        } catch (IOException e3) {
                            if (logger.isWarnEnabled()) {
                                logger.warn("Failed to close a file: " + this.certificate, (Throwable) e3);
                                throw th;
                            }
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                exc = e5;
            } catch (Throwable th4) {
                r7 = 0;
                th = th4;
                if (r7 == 0) {
                }
            }
        } catch (NoSuchAlgorithmException e6) {
            throw new Error(e6);
        }
    }
}
