package com.samsung.android.kmxservice.sdk.util;

import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.kmxservice.sdk.e2ee.data.LogTag;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SamsungAttestationRootCert {
    public static final String ROOT_SAKmV1 = "-----BEGIN CERTIFICATE-----\nMIIDFTCCAnagAwIBAgIEXWYqIzAKBggqhkjOPQQDBDCBmjELMAkGA1UEBhMCS1IxDjAMBgNVBAcMBVN1d29uMSYwJAYDVQQKDB1TYW1zdW5nIEVsZWN0cm9uaWNzIENvLiwgTHRkLjEnMCUGA1UECwweTW9iaWxlIENvbW11bmljYXRpb25zIERpdmlzaW9uMSowKAYDVQQDDCFTYW1zdW5nIEF0dGVzdGF0aW9uIFJvb3QgQ0EgZm9yIE0wIBcNMTkwODI4MDcxNTQ3WhgPMjA1NDA4MTkwNzE1NDdaMIGaMQswCQYDVQQGEwJLUjEOMAwGA1UEBwwFU3V3b24xJjAkBgNVBAoMHVNhbXN1bmcgRWxlY3Ryb25pY3MgQ28uLCBMdGQuMScwJQYDVQQLDB5Nb2JpbGUgQ29tbXVuaWNhdGlvbnMgRGl2aXNpb24xKjAoBgNVBAMMIVNhbXN1bmcgQXR0ZXN0YXRpb24gUm9vdCBDQSBmb3IgTTCBmzAQBgcqhkjOPQIBBgUrgQQAIwOBhgAEAfV3hDfJYOqecbzFVhuNj9kIv2kSl9qz0TYCvdlJTvTv0yBQihwtQFgixYrT1RKMOVvshIAtsDomMYHqWPOUzqB9ALhJC6IgupXWxdrjVVN62GEsrVgCYNxhSndZfVSw5saMefB8sNiZnXeVUjmxokxUP0oCrJ9n20D7aRpTcYBH3emPo2MwYTAPBgNVHRMBAf8EBTADAQH/MA4GA1UdDwEB/wQEAwIBBjAdBgNVHQ4EFgQUkWGLTHho0EqkKg3vJYpw6PuCVSwwHwYDVR0jBBgwFoAUkWGLTHho0EqkKg3vJYpw6PuCVSwwCgYIKoZIzj0EAwQDgYwAMIGIAkIB3GIJQoKsaPAnV+JFz4htNinRTqduII6atHPHdCngvVz/NkV7XxrY4NCZpj3EW1wghAD4Umo22cflyjkg0563RpECQgEIcMHaehES+XUC+X7swC8pgEZs778d/Dm1LxcoXigqXdHrs8q+jYJJ6d4mSj3SF3ggOV5UjWfG3UpZQksdNkmhxA==\n-----END CERTIFICATE-----";
    public static final String ROOT_SAKv1 = "-----BEGIN CERTIFICATE-----\nMIICjzCCAfCgAwIBAgIEWQK/tDAKBggqhkjOPQQDAjBZMQswCQYDVQQGEwJLUjETMBEGA1UEBxMKU3V3b24gY2l0eTEXMBUGA1UECxMOU2Ftc3VuZyBNb2JpbGUxHDAaBgNVBAMTE1NhbXN1bmcgY29ycG9yYXRpb24wHhcNMTcwNDI4MDQwNjEyWhcNMzcwNDIzMDQwNjEyWjBZMQswCQYDVQQGEwJLUjETMBEGA1UEBxMKU3V3b24gY2l0eTEXMBUGA1UECxMOU2Ftc3VuZyBNb2JpbGUxHDAaBgNVBAMTE1NhbXN1bmcgY29ycG9yYXRpb24wgZswEAYHKoZIzj0CAQYFK4EEACMDgYYABAGz1COv/9ESGRdbuNSqNj0o3BZpzivn6R1QaT5NmNGjVgRrjsDHCPoAmxs6OjhCweJhGJZMQu8V6K4GwqrK4XTHIAAq8Oh8GqsSrX8KTGjabPtDg1B6zeDhqFKO2BRKHSTzl9jDAeMJ4vJnmQSqAcb06k4fnboUUAreyVJSALxE5tvHK6NjMGEwDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMCAQYwHQYDVR0OBBYEFA2g7yBXBWdctoFVFEkd9zyQ9BO6MB8GA1UdIwQYMBaAFA2g7yBXBWdctoFVFEkd9zyQ9BO6MAoGCCqGSM49BAMCA4GMADCBiAJCANEFD3SFc3gWkMbm142lCpvjV6bt++/mBUUJCsLiyECe/HESJNQpvebXssVai1h0AHGpVrENpGz3pqQuO00+HyRAAkIBU1Cou6PxjFSxJ0t2zrjv2g54tDXaxGaSH57QQa1cHTKuP5pjbXTkE+IQoAfA2chKOzpVkhgk3zRkRPonXPI1Usg=\n-----END CERTIFICATE-----";
    public static final String ROOT_SAKv2 = "-----BEGIN CERTIFICATE-----\nMIICjzCCAfCgAwIBAgIEXHYjDTAKBggqhkjOPQQDBDBZMQswCQYDVQQGEwJLUjETMBEGA1UEBxMKU3V3b24gY2l0eTEXMBUGA1UECxMOU2Ftc3VuZyBNb2JpbGUxHDAaBgNVBAMTE1NhbXN1bmcgY29ycG9yYXRpb24wHhcNMTkwMjI3MDU0MTMzWhcNMzkwMjIyMDU0MTMzWjBZMQswCQYDVQQGEwJLUjETMBEGA1UEBxMKU3V3b24gY2l0eTEXMBUGA1UECxMOU2Ftc3VuZyBNb2JpbGUxHDAaBgNVBAMTE1NhbXN1bmcgY29ycG9yYXRpb24wgZswEAYHKoZIzj0CAQYFK4EEACMDgYYABAGFsa4uumqXkjZYmasTmQRVk6j52ADjqYqtUl/+yDN/Oza7sz1zVj1mQISKJiSFMUT289tqyZR9fJvCBnYQzfQDUAE93XbifclsQN+wH/CcwfUByCwnIkU9sRNmLLjYWHCL7YEIDltwd7tKt2REhhKx0FFooGhmxqnEHSAA6zSNI9Ffk6NjMGEwDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMCAQYwHQYDVR0OBBYEFGbsTn+ECfTAKlYSkIP+hkA01S7/MB8GA1UdIwQYMBaAFGbsTn+ECfTAKlYSkIP+hkA01S7/MAoGCCqGSM49BAMEA4GMADCBiAJCAeGMgCL5SfTUycZWd+37+cQIFSn5E1AzLIDw1ps1heoWoTj0dM9SPmWBo/TlWZrbtD4GyH2VI7vz3wkpB9W7oT9RAkIAluAfQFNEqCoYndVEyGhu5RjG412BQdNbh8Y5NzZymu4/Zg7pC0ctus6hdJ8J5DjekOEh6tTy8poqNYC+wvHgAJg=\n-----END CERTIFICATE-----";
    public static final int SecurityLevel_TRUSTED_ENVIRONMENT = 1;
    private static final String TAG = LogTag.getTag("SamsungAttestationRootCert");
    public static final String VERSION_SAK_V1 = "SAK_V1";
    public static final String VERSION_SAK_V2 = "SAK_V2";
    public static final String VERSION_SAKm_V1 = "SAKmV1";

    public static X509Certificate getSakRoot(String str) throws CertificateException {
        ByteArrayInputStream byteArrayInputStream;
        if (TextUtils.isEmpty(str)) {
            throw new CertificateException("sakUID is empty");
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            if (str.contains(VERSION_SAK_V1)) {
                byteArrayInputStream = new ByteArrayInputStream(ROOT_SAKv1.getBytes(StandardCharsets.UTF_8));
            } else if (str.contains(VERSION_SAK_V2)) {
                byteArrayInputStream = new ByteArrayInputStream(ROOT_SAKv2.getBytes(StandardCharsets.UTF_8));
            } else {
                if (!str.contains(VERSION_SAKm_V1)) {
                    throw new CertificateException("invalid sakUID : ".concat(str));
                }
                byteArrayInputStream = new ByteArrayInputStream(ROOT_SAKmV1.getBytes(StandardCharsets.UTF_8));
            }
            return (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
        } catch (CertificateException e) {
            Log.e(TAG, "Occurred exception error while checking root cert of SAK", e);
            throw e;
        }
    }
}
