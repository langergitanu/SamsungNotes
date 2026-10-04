package io.netty.handler.ssl.util;

import androidx.appcompat.widget.AbstractC0541b;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class BouncyCastleSelfSignedCertGenerator {
    private static final Provider PROVIDER = new BouncyCastleProvider();

    private BouncyCastleSelfSignedCertGenerator() {
    }

    public static String[] generate(String str, KeyPair keyPair, SecureRandom secureRandom, Date date, Date date2, String str2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        PrivateKey privateKey = keyPair.getPrivate();
        X500Name x500Name = new X500Name(AbstractC0541b.m772n("CN=", str));
        X509Certificate certificate = new JcaX509CertificateConverter().setProvider(PROVIDER).getCertificate(new JcaX509v3CertificateBuilder(x500Name, new BigInteger(64, secureRandom), date, date2, x500Name, keyPair.getPublic()).build(new JcaContentSignerBuilder(str2.equalsIgnoreCase("EC") ? "SHA256withECDSA" : "SHA256WithRSAEncryption").build(privateKey)));
        certificate.verify(keyPair.getPublic());
        return SelfSignedCertificate.newSelfSignedCertificate(str, privateKey, certificate);
    }
}
