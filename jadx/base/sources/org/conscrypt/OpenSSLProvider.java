package org.conscrypt;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.exifinterface.media.ExifInterface;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.microsoft.identity.common.java.crypto.key.KeyUtil;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import io.netty.handler.ssl.SslProtocols;
import java.security.Provider;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class OpenSSLProvider extends Provider {
    private static final String PREFIX = OpenSSLProvider.class.getPackage().getName() + Extension.DOT;
    private static final String STANDARD_EC_PRIVATE_KEY_INTERFACE_CLASS_NAME = "java.security.interfaces.ECPrivateKey";
    private static final String STANDARD_RSA_PRIVATE_KEY_INTERFACE_CLASS_NAME = "java.security.interfaces.RSAPrivateKey";
    private static final String STANDARD_RSA_PUBLIC_KEY_INTERFACE_CLASS_NAME = "java.security.interfaces.RSAPublicKey";
    private static final long serialVersionUID = 2996752495318905136L;

    public OpenSSLProvider() {
        this(Platform.getDefaultProviderName());
    }

    private void putECDHKeyAgreementImplClass(String str) {
        StringBuilder sb = new StringBuilder();
        String str2 = PREFIX;
        putImplClassWithKeyConstraints("KeyAgreement.ECDH", AbstractC0541b.m756B(str2, str), AbstractC0622a.m1170p(str2, "OpenSSLKeyHolder|java.security.interfaces.ECPrivateKey", sb), "PKCS#8");
    }

    private void putImplClassWithKeyConstraints(String str, String str2, String str3, String str4) {
        put(str, str2);
        if (str3 != null) {
            put(str + " SupportedKeyClasses", str3);
        }
        if (str4 != null) {
            put(str + " SupportedKeyFormats", str4);
        }
    }

    private void putMacImplClass(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        String str3 = PREFIX;
        putImplClassWithKeyConstraints(AbstractC0541b.m772n("Mac.", str), AbstractC0541b.m756B(str3, str2), AbstractC0622a.m1170p(str3, "OpenSSLKeyHolder", sb), "RAW");
    }

    private void putRAWRSASignatureImplClass(String str) {
        StringBuilder sb = new StringBuilder();
        String str2 = PREFIX;
        putImplClassWithKeyConstraints("Signature.NONEwithRSA", AbstractC0541b.m756B(str2, str), AbstractC0541b.m776r(sb, str2, "OpenSSLRSAPrivateKey|java.security.interfaces.RSAPrivateKey|", str2, "OpenSSLRSAPublicKey|java.security.interfaces.RSAPublicKey"), null);
    }

    private void putRSACipherImplClass(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        String str3 = PREFIX;
        putImplClassWithKeyConstraints(AbstractC0541b.m772n("Cipher.", str), AbstractC0541b.m756B(str3, str2), AbstractC0541b.m776r(sb, str3, "OpenSSLRSAPrivateKey|java.security.interfaces.RSAPrivateKey|", str3, "OpenSSLRSAPublicKey|java.security.interfaces.RSAPublicKey"), null);
    }

    private void putSignatureImplClass(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        String str3 = PREFIX;
        putImplClassWithKeyConstraints(AbstractC0541b.m772n("Signature.", str), AbstractC0541b.m756B(str3, str2), AbstractC0622a.m1170p(str3, "OpenSSLKeyHolder|java.security.interfaces.RSAPrivateKey|java.security.interfaces.ECPrivateKey|java.security.interfaces.RSAPublicKey", sb), "PKCS#8|X.509");
    }

    private void putSymmetricCipherImplClass(String str, String str2) {
        putImplClassWithKeyConstraints(AbstractC0541b.m772n("Cipher.", str), AbstractC0622a.m1170p(PREFIX, str2, new StringBuilder()), null, "RAW");
    }

    public OpenSSLProvider(String str) {
        this(str, Platform.provideTrustManagerByDefault(), SslProtocols.TLS_v1_3);
    }

    public OpenSSLProvider(String str, boolean z, String str2) {
        String str3;
        super(str, 1.0d, "Android's OpenSSL-backed security provider");
        NativeCrypto.checkAvailability();
        Platform.setup();
        StringBuilder sb = new StringBuilder();
        String str4 = PREFIX;
        sb.append(str4);
        sb.append("OpenSSLContextImpl");
        String string = sb.toString();
        str2.getClass();
        if (str2.equals(SslProtocols.TLS_v1_2)) {
            str3 = "$TLSv12";
        } else {
            if (!str2.equals(SslProtocols.TLS_v1_3)) {
                throw new IllegalArgumentException("Choice of default protocol is unsupported: ".concat(str2));
            }
            str3 = "$TLSv13";
        }
        put("SSLContext.SSL", string + str3);
        put("SSLContext.TLS", string + str3);
        put("SSLContext.TLSv1", string + "$TLSv1");
        put("SSLContext.TLSv1.1", string + "$TLSv11");
        put("SSLContext.TLSv1.2", string + "$TLSv12");
        put("SSLContext.TLSv1.3", string + "$TLSv13");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str4);
        AbstractC12991c.m13979C(sb2, "DefaultSSLContextImpl", str3, this, "SSLContext.Default");
        if (z) {
            put("TrustManagerFactory.PKIX", TrustManagerFactoryImpl.class.getName());
            put("Alg.Alias.TrustManagerFactory.X509", "PKIX");
        }
        put("AlgorithmParameters.AES", str4 + "IvParameters$AES");
        put("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.1.2", AES256KeyLoader.AES_ALGORITHM);
        StringBuilder sbM13993n = AbstractC12991c.m13993n(this, "Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.1.22", AES256KeyLoader.AES_ALGORITHM, "Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.1.42", AES256KeyLoader.AES_ALGORITHM);
        sbM13993n.append(str4);
        sbM13993n.append("IvParameters$ChaCha20");
        put("AlgorithmParameters.ChaCha20", sbM13993n.toString());
        AbstractC12991c.m13979C(new StringBuilder(), str4, "IvParameters$DESEDE", this, "AlgorithmParameters.DESEDE");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.AlgorithmParameters.TDEA", "DESEDE", "Alg.Alias.AlgorithmParameters.1.2.840.113549.3.7", "DESEDE"), str4, "GCMParameters", this, "AlgorithmParameters.GCM");
        put("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.1.6", "GCM");
        StringBuilder sbM13993n2 = AbstractC12991c.m13993n(this, "Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.1.26", "GCM", "Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.1.46", "GCM");
        sbM13993n2.append(str4);
        sbM13993n2.append("OAEPParameters");
        put("AlgorithmParameters.OAEP", sbM13993n2.toString());
        put("AlgorithmParameters.PSS", str4 + "PSSParameters");
        put("AlgorithmParameters.EC", str4 + "ECParameters");
        AbstractC12991c.m13979C(new StringBuilder(), str4, "OpenSSLMessageDigestJDK$SHA1", this, "MessageDigest.SHA-1");
        put("Alg.Alias.MessageDigest.SHA1", IDevicePopManager.SHA_1);
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.MessageDigest.SHA", IDevicePopManager.SHA_1, "Alg.Alias.MessageDigest.1.3.14.3.2.26", IDevicePopManager.SHA_1), str4, "OpenSSLMessageDigestJDK$SHA224", this, "MessageDigest.SHA-224");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.MessageDigest.SHA224", "SHA-224", "Alg.Alias.MessageDigest.2.16.840.1.101.3.4.2.4", "SHA-224"), str4, "OpenSSLMessageDigestJDK$SHA256", this, "MessageDigest.SHA-256");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.MessageDigest.SHA256", "SHA-256", "Alg.Alias.MessageDigest.2.16.840.1.101.3.4.2.1", "SHA-256"), str4, "OpenSSLMessageDigestJDK$SHA384", this, "MessageDigest.SHA-384");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.MessageDigest.SHA384", "SHA-384", "Alg.Alias.MessageDigest.2.16.840.1.101.3.4.2.2", "SHA-384"), str4, "OpenSSLMessageDigestJDK$SHA512", this, "MessageDigest.SHA-512");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.MessageDigest.SHA512", "SHA-512", "Alg.Alias.MessageDigest.2.16.840.1.101.3.4.2.3", "SHA-512"), str4, "OpenSSLMessageDigestJDK$MD5", this, "MessageDigest.MD5");
        put("Alg.Alias.MessageDigest.1.2.840.113549.2.5", "MD5");
        put("KeyGenerator.ARC4", str4 + "KeyGeneratorImpl$ARC4");
        StringBuilder sbM13993n3 = AbstractC12991c.m13993n(this, "Alg.Alias.KeyGenerator.RC4", "ARC4", "Alg.Alias.KeyGenerator.1.2.840.113549.3.4", "ARC4");
        sbM13993n3.append(str4);
        sbM13993n3.append("KeyGeneratorImpl$AES");
        put("KeyGenerator.AES", sbM13993n3.toString());
        put("KeyGenerator.ChaCha20", str4 + "KeyGeneratorImpl$ChaCha20");
        AbstractC12991c.m13979C(new StringBuilder(), str4, "KeyGeneratorImpl$DESEDE", this, "KeyGenerator.DESEDE");
        put("Alg.Alias.KeyGenerator.TDEA", "DESEDE");
        put("KeyGenerator.HmacMD5", str4 + "KeyGeneratorImpl$HmacMD5");
        put("Alg.Alias.KeyGenerator.1.3.6.1.5.5.8.1.1", "HmacMD5");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.KeyGenerator.HMAC-MD5", "HmacMD5", "Alg.Alias.KeyGenerator.HMAC/MD5", "HmacMD5"), str4, "KeyGeneratorImpl$HmacSHA1", this, "KeyGenerator.HmacSHA1");
        put("Alg.Alias.KeyGenerator.1.2.840.113549.2.7", "HmacSHA1");
        put("Alg.Alias.KeyGenerator.1.3.6.1.5.5.8.1.2", "HmacSHA1");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.KeyGenerator.HMAC-SHA1", "HmacSHA1", "Alg.Alias.KeyGenerator.HMAC/SHA1", "HmacSHA1"), str4, "KeyGeneratorImpl$HmacSHA224", this, "KeyGenerator.HmacSHA224");
        put("Alg.Alias.KeyGenerator.1.2.840.113549.2.8", "HmacSHA224");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.KeyGenerator.HMAC-SHA224", "HmacSHA224", "Alg.Alias.KeyGenerator.HMAC/SHA224", "HmacSHA224"), str4, "KeyGeneratorImpl$HmacSHA256", this, "KeyGenerator.HmacSHA256");
        put("Alg.Alias.KeyGenerator.1.2.840.113549.2.9", KeyUtil.HMAC_ALGORITHM);
        put("Alg.Alias.KeyGenerator.2.16.840.1.101.3.4.2.1", KeyUtil.HMAC_ALGORITHM);
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.KeyGenerator.HMAC-SHA256", KeyUtil.HMAC_ALGORITHM, "Alg.Alias.KeyGenerator.HMAC/SHA256", KeyUtil.HMAC_ALGORITHM), str4, "KeyGeneratorImpl$HmacSHA384", this, "KeyGenerator.HmacSHA384");
        put("Alg.Alias.KeyGenerator.1.2.840.113549.2.10", "HmacSHA384");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.KeyGenerator.HMAC-SHA384", "HmacSHA384", "Alg.Alias.KeyGenerator.HMAC/SHA384", "HmacSHA384"), str4, "KeyGeneratorImpl$HmacSHA512", this, "KeyGenerator.HmacSHA512");
        put("Alg.Alias.KeyGenerator.1.2.840.113549.2.11", "HmacSHA512");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.KeyGenerator.HMAC-SHA512", "HmacSHA512", "Alg.Alias.KeyGenerator.HMAC/SHA512", "HmacSHA512"), str4, "OpenSSLRSAKeyPairGenerator", this, "KeyPairGenerator.RSA");
        put("Alg.Alias.KeyPairGenerator.1.2.840.113549.1.1.1", AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA);
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.KeyPairGenerator.1.2.840.113549.1.1.7", AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA, "Alg.Alias.KeyPairGenerator.2.5.8.1.1", AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA), str4, "OpenSSLECKeyPairGenerator", this, "KeyPairGenerator.EC");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.KeyPairGenerator.1.2.840.10045.2.1", "EC", "Alg.Alias.KeyPairGenerator.1.3.133.16.840.63.0.2", "EC"), str4, "OpenSSLRSAKeyFactory", this, "KeyFactory.RSA");
        put("Alg.Alias.KeyFactory.1.2.840.113549.1.1.1", AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA);
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.KeyFactory.1.2.840.113549.1.1.7", AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA, "Alg.Alias.KeyFactory.2.5.8.1.1", AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA), str4, "OpenSSLECKeyFactory", this, "KeyFactory.EC");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.KeyFactory.1.2.840.10045.2.1", "EC", "Alg.Alias.KeyFactory.1.3.133.16.840.63.0.2", "EC"), str4, "DESEDESecretKeyFactory", this, "SecretKeyFactory.DESEDE");
        put("Alg.Alias.SecretKeyFactory.TDEA", "DESEDE");
        putECDHKeyAgreementImplClass("OpenSSLECDHKeyAgreement");
        putSignatureImplClass("MD5withRSA", "OpenSSLSignature$MD5RSA");
        put("Alg.Alias.Signature.MD5withRSAEncryption", "MD5withRSA");
        put("Alg.Alias.Signature.MD5/RSA", "MD5withRSA");
        put("Alg.Alias.Signature.1.2.840.113549.1.1.4", "MD5withRSA");
        put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.4", "MD5withRSA");
        put("Alg.Alias.Signature.1.2.840.113549.2.5with1.2.840.113549.1.1.1", "MD5withRSA");
        putSignatureImplClass("SHA1withRSA", "OpenSSLSignature$SHA1RSA");
        put("Alg.Alias.Signature.SHA1withRSAEncryption", "SHA1withRSA");
        put("Alg.Alias.Signature.SHA1/RSA", "SHA1withRSA");
        put("Alg.Alias.Signature.SHA-1/RSA", "SHA1withRSA");
        put("Alg.Alias.Signature.1.2.840.113549.1.1.5", "SHA1withRSA");
        put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.5", "SHA1withRSA");
        put("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.113549.1.1.1", "SHA1withRSA");
        put("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.113549.1.1.5", "SHA1withRSA");
        put("Alg.Alias.Signature.1.3.14.3.2.29", "SHA1withRSA");
        put("Alg.Alias.Signature.OID.1.3.14.3.2.29", "SHA1withRSA");
        putSignatureImplClass("SHA224withRSA", "OpenSSLSignature$SHA224RSA");
        put("Alg.Alias.Signature.SHA224withRSAEncryption", "SHA224withRSA");
        put("Alg.Alias.Signature.SHA224/RSA", "SHA224withRSA");
        put("Alg.Alias.Signature.1.2.840.113549.1.1.14", "SHA224withRSA");
        put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.14", "SHA224withRSA");
        put("Alg.Alias.Signature.2.16.840.1.101.3.4.2.4with1.2.840.113549.1.1.1", "SHA224withRSA");
        put("Alg.Alias.Signature.2.16.840.1.101.3.4.2.4with1.2.840.113549.1.1.14", "SHA224withRSA");
        putSignatureImplClass("SHA256withRSA", "OpenSSLSignature$SHA256RSA");
        put("Alg.Alias.Signature.SHA256withRSAEncryption", "SHA256withRSA");
        put("Alg.Alias.Signature.SHA256/RSA", "SHA256withRSA");
        put("Alg.Alias.Signature.1.2.840.113549.1.1.11", "SHA256withRSA");
        put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.11", "SHA256withRSA");
        put("Alg.Alias.Signature.2.16.840.1.101.3.4.2.1with1.2.840.113549.1.1.1", "SHA256withRSA");
        put("Alg.Alias.Signature.2.16.840.1.101.3.4.2.1with1.2.840.113549.1.1.11", "SHA256withRSA");
        putSignatureImplClass("SHA384withRSA", "OpenSSLSignature$SHA384RSA");
        put("Alg.Alias.Signature.SHA384withRSAEncryption", "SHA384withRSA");
        put("Alg.Alias.Signature.SHA384/RSA", "SHA384withRSA");
        put("Alg.Alias.Signature.1.2.840.113549.1.1.12", "SHA384withRSA");
        put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.12", "SHA384withRSA");
        put("Alg.Alias.Signature.2.16.840.1.101.3.4.2.2with1.2.840.113549.1.1.1", "SHA384withRSA");
        putSignatureImplClass("SHA512withRSA", "OpenSSLSignature$SHA512RSA");
        put("Alg.Alias.Signature.SHA512withRSAEncryption", "SHA512withRSA");
        put("Alg.Alias.Signature.SHA512/RSA", "SHA512withRSA");
        put("Alg.Alias.Signature.1.2.840.113549.1.1.13", "SHA512withRSA");
        put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.13", "SHA512withRSA");
        put("Alg.Alias.Signature.2.16.840.1.101.3.4.2.3with1.2.840.113549.1.1.1", "SHA512withRSA");
        putRAWRSASignatureImplClass("OpenSSLSignatureRawRSA");
        putSignatureImplClass("NONEwithECDSA", "OpenSSLSignatureRawECDSA");
        putSignatureImplClass("SHA1withECDSA", "OpenSSLSignature$SHA1ECDSA");
        put("Alg.Alias.Signature.ECDSA", "SHA1withECDSA");
        put("Alg.Alias.Signature.ECDSAwithSHA1", "SHA1withECDSA");
        put("Alg.Alias.Signature.1.2.840.10045.4.1", "SHA1withECDSA");
        put("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10045.2.1", "SHA1withECDSA");
        putSignatureImplClass("SHA224withECDSA", "OpenSSLSignature$SHA224ECDSA");
        put("Alg.Alias.Signature.SHA224/ECDSA", "SHA224withECDSA");
        put("Alg.Alias.Signature.1.2.840.10045.4.3.1", "SHA224withECDSA");
        put("Alg.Alias.Signature.OID.1.2.840.10045.4.3.1", "SHA224withECDSA");
        put("Alg.Alias.Signature.2.16.840.1.101.3.4.2.4with1.2.840.10045.2.1", "SHA224withECDSA");
        putSignatureImplClass("SHA256withECDSA", "OpenSSLSignature$SHA256ECDSA");
        put("Alg.Alias.Signature.SHA256/ECDSA", "SHA256withECDSA");
        put("Alg.Alias.Signature.1.2.840.10045.4.3.2", "SHA256withECDSA");
        put("Alg.Alias.Signature.OID.1.2.840.10045.4.3.2", "SHA256withECDSA");
        put("Alg.Alias.Signature.2.16.840.1.101.3.4.2.1with1.2.840.10045.2.1", "SHA256withECDSA");
        putSignatureImplClass("SHA384withECDSA", "OpenSSLSignature$SHA384ECDSA");
        put("Alg.Alias.Signature.SHA384/ECDSA", "SHA384withECDSA");
        put("Alg.Alias.Signature.1.2.840.10045.4.3.3", "SHA384withECDSA");
        put("Alg.Alias.Signature.OID.1.2.840.10045.4.3.3", "SHA384withECDSA");
        put("Alg.Alias.Signature.2.16.840.1.101.3.4.2.2with1.2.840.10045.2.1", "SHA384withECDSA");
        putSignatureImplClass("SHA512withECDSA", "OpenSSLSignature$SHA512ECDSA");
        put("Alg.Alias.Signature.SHA512/ECDSA", "SHA512withECDSA");
        put("Alg.Alias.Signature.1.2.840.10045.4.3.4", "SHA512withECDSA");
        put("Alg.Alias.Signature.OID.1.2.840.10045.4.3.4", "SHA512withECDSA");
        put("Alg.Alias.Signature.2.16.840.1.101.3.4.2.3with1.2.840.10045.2.1", "SHA512withECDSA");
        putSignatureImplClass("SHA1withRSA/PSS", "OpenSSLSignature$SHA1RSAPSS");
        put("Alg.Alias.Signature.SHA1withRSAandMGF1", "SHA1withRSA/PSS");
        putSignatureImplClass("SHA224withRSA/PSS", "OpenSSLSignature$SHA224RSAPSS");
        put("Alg.Alias.Signature.SHA224withRSAandMGF1", "SHA224withRSA/PSS");
        putSignatureImplClass("SHA256withRSA/PSS", "OpenSSLSignature$SHA256RSAPSS");
        put("Alg.Alias.Signature.SHA256withRSAandMGF1", "SHA256withRSA/PSS");
        putSignatureImplClass("SHA384withRSA/PSS", "OpenSSLSignature$SHA384RSAPSS");
        put("Alg.Alias.Signature.SHA384withRSAandMGF1", "SHA384withRSA/PSS");
        putSignatureImplClass("SHA512withRSA/PSS", "OpenSSLSignature$SHA512RSAPSS");
        put("Alg.Alias.Signature.SHA512withRSAandMGF1", "SHA512withRSA/PSS");
        put("SecureRandom.SHA1PRNG", str4 + "OpenSSLRandom");
        put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
        putRSACipherImplClass("RSA/ECB/NoPadding", "OpenSSLCipherRSA$Raw");
        put("Alg.Alias.Cipher.RSA/None/NoPadding", "RSA/ECB/NoPadding");
        putRSACipherImplClass("RSA/ECB/PKCS1Padding", "OpenSSLCipherRSA$PKCS1");
        put("Alg.Alias.Cipher.RSA/None/PKCS1Padding", "RSA/ECB/PKCS1Padding");
        putRSACipherImplClass("RSA/ECB/OAEPPadding", "OpenSSLCipherRSA$OAEP$SHA1");
        put("Alg.Alias.Cipher.RSA/None/OAEPPadding", "RSA/ECB/OAEPPadding");
        putRSACipherImplClass("RSA/ECB/OAEPWithSHA-1AndMGF1Padding", "OpenSSLCipherRSA$OAEP$SHA1");
        put("Alg.Alias.Cipher.RSA/None/OAEPWithSHA-1AndMGF1Padding", "RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        putRSACipherImplClass("RSA/ECB/OAEPWithSHA-224AndMGF1Padding", "OpenSSLCipherRSA$OAEP$SHA224");
        put("Alg.Alias.Cipher.RSA/None/OAEPWithSHA-224AndMGF1Padding", "RSA/ECB/OAEPWithSHA-224AndMGF1Padding");
        putRSACipherImplClass("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", "OpenSSLCipherRSA$OAEP$SHA256");
        put("Alg.Alias.Cipher.RSA/None/OAEPWithSHA-256AndMGF1Padding", "RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        putRSACipherImplClass("RSA/ECB/OAEPWithSHA-384AndMGF1Padding", "OpenSSLCipherRSA$OAEP$SHA384");
        put("Alg.Alias.Cipher.RSA/None/OAEPWithSHA-384AndMGF1Padding", "RSA/ECB/OAEPWithSHA-384AndMGF1Padding");
        putRSACipherImplClass("RSA/ECB/OAEPWithSHA-512AndMGF1Padding", "OpenSSLCipherRSA$OAEP$SHA512");
        put("Alg.Alias.Cipher.RSA/None/OAEPWithSHA-512AndMGF1Padding", "RSA/ECB/OAEPWithSHA-512AndMGF1Padding");
        putSymmetricCipherImplClass("AES/ECB/NoPadding", "OpenSSLEvpCipherAES$AES$ECB$NoPadding");
        putSymmetricCipherImplClass("AES/ECB/PKCS5Padding", "OpenSSLEvpCipherAES$AES$ECB$PKCS5Padding");
        put("Alg.Alias.Cipher.AES/ECB/PKCS7Padding", "AES/ECB/PKCS5Padding");
        putSymmetricCipherImplClass("AES/CBC/NoPadding", "OpenSSLEvpCipherAES$AES$CBC$NoPadding");
        putSymmetricCipherImplClass("AES/CBC/PKCS5Padding", "OpenSSLEvpCipherAES$AES$CBC$PKCS5Padding");
        put("Alg.Alias.Cipher.AES/CBC/PKCS7Padding", "AES/CBC/PKCS5Padding");
        putSymmetricCipherImplClass("AES/CTR/NoPadding", "OpenSSLEvpCipherAES$AES$CTR");
        putSymmetricCipherImplClass("AES_128/ECB/NoPadding", "OpenSSLEvpCipherAES$AES_128$ECB$NoPadding");
        putSymmetricCipherImplClass("AES_128/ECB/PKCS5Padding", "OpenSSLEvpCipherAES$AES_128$ECB$PKCS5Padding");
        put("Alg.Alias.Cipher.AES_128/ECB/PKCS7Padding", "AES_128/ECB/PKCS5Padding");
        putSymmetricCipherImplClass("AES_128/CBC/NoPadding", "OpenSSLEvpCipherAES$AES_128$CBC$NoPadding");
        putSymmetricCipherImplClass("AES_128/CBC/PKCS5Padding", "OpenSSLEvpCipherAES$AES_128$CBC$PKCS5Padding");
        put("Alg.Alias.Cipher.AES_128/CBC/PKCS7Padding", "AES_128/CBC/PKCS5Padding");
        put("Alg.Alias.Cipher.PBEWithHmacSHA1AndAES_128", "AES_128/CBC/PKCS5PADDING");
        put("Alg.Alias.Cipher.PBEWithHmacSHA224AndAES_128", "AES_128/CBC/PKCS5PADDING");
        put("Alg.Alias.Cipher.PBEWithHmacSHA256AndAES_128", "AES_128/CBC/PKCS5PADDING");
        put("Alg.Alias.Cipher.PBEWithHmacSHA384AndAES_128", "AES_128/CBC/PKCS5PADDING");
        put("Alg.Alias.Cipher.PBEWithHmacSHA512AndAES_128", "AES_128/CBC/PKCS5PADDING");
        putSymmetricCipherImplClass("AES_256/ECB/NoPadding", "OpenSSLEvpCipherAES$AES_256$ECB$NoPadding");
        putSymmetricCipherImplClass("AES_256/ECB/PKCS5Padding", "OpenSSLEvpCipherAES$AES_256$ECB$PKCS5Padding");
        put("Alg.Alias.Cipher.AES_256/ECB/PKCS7Padding", "AES_256/ECB/PKCS5Padding");
        putSymmetricCipherImplClass("AES_256/CBC/NoPadding", "OpenSSLEvpCipherAES$AES_256$CBC$NoPadding");
        putSymmetricCipherImplClass("AES_256/CBC/PKCS5Padding", "OpenSSLEvpCipherAES$AES_256$CBC$PKCS5Padding");
        put("Alg.Alias.Cipher.AES_256/CBC/PKCS7Padding", "AES_256/CBC/PKCS5Padding");
        put("Alg.Alias.Cipher.PBEWithHmacSHA1AndAES_256", "AES_256/CBC/PKCS5PADDING");
        put("Alg.Alias.Cipher.PBEWithHmacSHA224AndAES_256", "AES_256/CBC/PKCS5PADDING");
        put("Alg.Alias.Cipher.PBEWithHmacSHA256AndAES_256", "AES_256/CBC/PKCS5PADDING");
        put("Alg.Alias.Cipher.PBEWithHmacSHA384AndAES_256", "AES_256/CBC/PKCS5PADDING");
        put("Alg.Alias.Cipher.PBEWithHmacSHA512AndAES_256", "AES_256/CBC/PKCS5PADDING");
        putSymmetricCipherImplClass("DESEDE/CBC/NoPadding", "OpenSSLEvpCipherDESEDE$CBC$NoPadding");
        putSymmetricCipherImplClass("DESEDE/CBC/PKCS5Padding", "OpenSSLEvpCipherDESEDE$CBC$PKCS5Padding");
        put("Alg.Alias.Cipher.DESEDE/CBC/PKCS7Padding", "DESEDE/CBC/PKCS5Padding");
        putSymmetricCipherImplClass("ARC4", "OpenSSLEvpCipherARC4");
        put("Alg.Alias.Cipher.ARCFOUR", "ARC4");
        put("Alg.Alias.Cipher.RC4", "ARC4");
        put("Alg.Alias.Cipher.1.2.840.113549.3.4", "ARC4");
        put("Alg.Alias.Cipher.OID.1.2.840.113549.3.4", "ARC4");
        putSymmetricCipherImplClass("AES/GCM/NoPadding", "OpenSSLAeadCipherAES$GCM");
        put("Alg.Alias.Cipher.GCM", "AES/GCM/NoPadding");
        put("Alg.Alias.Cipher.2.16.840.1.101.3.4.1.6", "AES/GCM/NoPadding");
        put("Alg.Alias.Cipher.2.16.840.1.101.3.4.1.26", "AES/GCM/NoPadding");
        put("Alg.Alias.Cipher.2.16.840.1.101.3.4.1.46", "AES/GCM/NoPadding");
        putSymmetricCipherImplClass("AES_128/GCM/NoPadding", "OpenSSLAeadCipherAES$GCM$AES_128");
        putSymmetricCipherImplClass("AES_256/GCM/NoPadding", "OpenSSLAeadCipherAES$GCM$AES_256");
        putSymmetricCipherImplClass("AES/GCM-SIV/NoPadding", "OpenSSLAeadCipherAES$GCM_SIV");
        putSymmetricCipherImplClass("AES_128/GCM-SIV/NoPadding", "OpenSSLAeadCipherAES$GCM_SIV$AES_128");
        putSymmetricCipherImplClass("AES_256/GCM-SIV/NoPadding", "OpenSSLAeadCipherAES$GCM_SIV$AES_256");
        putSymmetricCipherImplClass("ChaCha20", "OpenSSLCipherChaCha20");
        putSymmetricCipherImplClass("ChaCha20/Poly1305/NoPadding", "OpenSSLAeadCipherChaCha20");
        put("Alg.Alias.Cipher.ChaCha20-Poly1305", "ChaCha20/Poly1305/NoPadding");
        putMacImplClass("HmacMD5", "OpenSSLMac$HmacMD5");
        put("Alg.Alias.Mac.1.3.6.1.5.5.8.1.1", "HmacMD5");
        put("Alg.Alias.Mac.HMAC-MD5", "HmacMD5");
        put("Alg.Alias.Mac.HMAC/MD5", "HmacMD5");
        putMacImplClass("HmacSHA1", "OpenSSLMac$HmacSHA1");
        put("Alg.Alias.Mac.1.2.840.113549.2.7", "HmacSHA1");
        put("Alg.Alias.Mac.1.3.6.1.5.5.8.1.2", "HmacSHA1");
        put("Alg.Alias.Mac.HMAC-SHA1", "HmacSHA1");
        put("Alg.Alias.Mac.HMAC/SHA1", "HmacSHA1");
        putMacImplClass("HmacSHA224", "OpenSSLMac$HmacSHA224");
        put("Alg.Alias.Mac.1.2.840.113549.2.8", "HmacSHA224");
        put("Alg.Alias.Mac.HMAC-SHA224", "HmacSHA224");
        put("Alg.Alias.Mac.HMAC/SHA224", "HmacSHA224");
        put("Alg.Alias.Mac.PBEWITHHMACSHA224", "HmacSHA224");
        putMacImplClass(KeyUtil.HMAC_ALGORITHM, "OpenSSLMac$HmacSHA256");
        put("Alg.Alias.Mac.1.2.840.113549.2.9", KeyUtil.HMAC_ALGORITHM);
        put("Alg.Alias.Mac.2.16.840.1.101.3.4.2.1", KeyUtil.HMAC_ALGORITHM);
        put("Alg.Alias.Mac.HMAC-SHA256", KeyUtil.HMAC_ALGORITHM);
        put("Alg.Alias.Mac.HMAC/SHA256", KeyUtil.HMAC_ALGORITHM);
        put("Alg.Alias.Mac.PBEWITHHMACSHA256", KeyUtil.HMAC_ALGORITHM);
        putMacImplClass("HmacSHA384", "OpenSSLMac$HmacSHA384");
        put("Alg.Alias.Mac.1.2.840.113549.2.10", "HmacSHA384");
        put("Alg.Alias.Mac.HMAC-SHA384", "HmacSHA384");
        put("Alg.Alias.Mac.HMAC/SHA384", "HmacSHA384");
        put("Alg.Alias.Mac.PBEWITHHMACSHA384", "HmacSHA384");
        putMacImplClass("HmacSHA512", "OpenSSLMac$HmacSHA512");
        put("Alg.Alias.Mac.1.2.840.113549.2.11", "HmacSHA512");
        put("Alg.Alias.Mac.HMAC-SHA512", "HmacSHA512");
        AbstractC12991c.m13979C(AbstractC12991c.m13993n(this, "Alg.Alias.Mac.HMAC/SHA512", "HmacSHA512", "Alg.Alias.Mac.PBEWITHHMACSHA512", "HmacSHA512"), str4, "OpenSSLX509CertificateFactory", this, "CertificateFactory.X509");
        put("Alg.Alias.CertificateFactory.X.509", "X509");
    }
}
