package io.grpc.util;

import com.google.common.p130io.BaseEncoding;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import io.grpc.ExperimentalApi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/8024")
public final class CertificateUtils {
    public static PrivateKey getPrivateKey(InputStream inputStream) throws InvalidKeySpecException, IOException {
        String line;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        do {
            line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
        } while (!"-----BEGIN PRIVATE KEY-----".equals(line));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line2 = bufferedReader.readLine();
            if (line2 == null || "-----END PRIVATE KEY-----".equals(line2)) {
                break;
            }
            sb.append(line2);
        }
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(BaseEncoding.base64().decode(sb.toString()));
        try {
            try {
                return KeyFactory.getInstance(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA).generatePrivate(pKCS8EncodedKeySpec);
            } catch (InvalidKeySpecException e) {
                throw new InvalidKeySpecException("Neither RSA nor EC worked", e);
            }
        } catch (InvalidKeySpecException unused) {
            return KeyFactory.getInstance("EC").generatePrivate(pKCS8EncodedKeySpec);
        }
    }

    public static X509Certificate[] getX509Certificates(InputStream inputStream) {
        return (X509Certificate[]) CertificateFactory.getInstance("X.509").generateCertificates(inputStream).toArray(new X509Certificate[0]);
    }
}
