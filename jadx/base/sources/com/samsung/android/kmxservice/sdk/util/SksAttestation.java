package com.samsung.android.kmxservice.sdk.util;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import com.samsung.android.kmxservice.sdk.e2ee.data.LogTag;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.security.keystore.AttestParameterSpec;
import com.samsung.android.security.keystore.AttestationUtils;
import com.samsung.android.security.keystore.DeviceIdAttestationException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.ProviderException;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import p099Y2.C0347a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SksAttestation {
    private static final int SAK_CERT_CHAIN_COUNT = 3;
    private static final String TAG = LogTag.getTag("SksAttestation");
    public static final String WRAPPING_KEY = "WRAPPING_KEY";

    @Nullable
    private final AttestationUtils mAttestationUtils;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {
        private static final SksAttestation INSTANCE = new SksAttestation(0);

        private LazyHolder() {
        }
    }

    public /* synthetic */ SksAttestation(int i) {
        this();
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ AttestationUtils m5530a() {
        return new AttestationUtils();
    }

    private boolean checkChallengeOfAttestationCert(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0) {
            Log.e(TAG, "No challenge in the certificate");
            return false;
        }
        if (Arrays.equals(bArr, bArr2)) {
            return true;
        }
        Log.e(TAG, "Challenge in different with certificate : ".concat(new String(bArr, StandardCharsets.UTF_8)));
        return false;
    }

    private int checkIntegrityStatus(IntegrityStatus integrityStatus) {
        if (integrityStatus != null && integrityStatus.isNormal()) {
            return integrityStatus.getStatus();
        }
        Log.e(TAG, "integrityStatus is abnormal : " + integrityStatus);
        return -1;
    }

    private boolean checkKeyOrigin(int i) {
        if (i == 0) {
            return true;
        }
        Log.e(TAG, "The key was not generated in hardware-backed keystore");
        return false;
    }

    private boolean checkRootOfTrust(RootOfTrust rootOfTrust) {
        if (rootOfTrust.getVerifiedBootState() != 0) {
            Log.e(TAG, "ROT : VerifiedBootState is invalid");
            return false;
        }
        if (rootOfTrust.isDeviceLocked()) {
            return true;
        }
        Log.e(TAG, "ROT : Device is unlocked");
        return false;
    }

    public static SksAttestation getInstance() {
        return LazyHolder.INSTANCE;
    }

    private byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) (Character.digit(str.charAt(i + 1), 16) + (Character.digit(str.charAt(i), 16) << 4));
        }
        return bArr;
    }

    private byte[] makeRandomChallenge() {
        byte[] bArr = new byte[4];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    private String parseSakUid(String str, boolean z) {
        if (!z) {
            int iIndexOf = str.indexOf("\"", str.indexOf("CN=")) + 1;
            return str.substring(iIndexOf, str.indexOf("\"", iIndexOf));
        }
        Log.i(TAG, "[parseSakUid] SAKm Model");
        int iIndexOf2 = str.indexOf(MarketingConstants.REFERRER_DELIMITER_U003D, str.indexOf("UID")) + 1;
        return str.substring(iIndexOf2, str.indexOf(":CA", iIndexOf2));
    }

    private boolean verifyCertChain(Certificate[] certificateArr, byte[] bArr) {
        if (certificateArr == null) {
            Log.e(TAG, "verifyCertChain certChain is null.");
            return false;
        }
        X509Certificate[] x509CertificateArr = new X509Certificate[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            x509CertificateArr[i] = (X509Certificate) certificateArr[i];
        }
        return verifyCertChain(x509CertificateArr, bArr);
    }

    public int getDeviceIntegrity() {
        byte[] bArrMakeRandomChallenge = makeRandomChallenge();
        AttestationUtils attestationUtils = this.mAttestationUtils;
        if (attestationUtils == null) {
            Log.e(TAG, "Not support attestation utils. Need to check build version :" + Build.VERSION.SDK_INT);
            return -1;
        }
        try {
            synchronized (attestationUtils) {
                try {
                    if (this.mAttestationUtils.getKey("integrity") == null) {
                        Log.i(TAG, "generated key for integrity checking");
                        this.mAttestationUtils.generateKeyPair("integrity", bArrMakeRandomChallenge);
                    }
                    this.mAttestationUtils.storeCertificateChain("integrity", this.mAttestationUtils.attestDevice(new AttestParameterSpec.Builder("integrity", bArrMakeRandomChallenge).setDeviceAttestation(true).setVerifiableIntegrity(true).build()));
                    Certificate[] certificateChain = this.mAttestationUtils.getCertificateChain("integrity");
                    if (certificateChain == null) {
                        Log.e(TAG, "getDeviceIntegrity certChain is null");
                        return -1;
                    }
                    try {
                        return checkIntegrityStatus(new AttestatedCertParser((X509Certificate) certificateChain[0]).getIngetrityStatus());
                    } catch (CertificateParsingException e) {
                        Log.e(TAG, "getDeviceIntegrity certificate Parsing Error : ", e);
                        return -1;
                    }
                } finally {
                }
            }
        } catch (DeviceIdAttestationException | KeyStoreException e2) {
            throw new RuntimeException((Throwable) e2);
        }
    }

    public String getSakUid() {
        String str = SystemProperties.get("ro.security.keystore.keytype");
        AttestationUtils attestationUtils = this.mAttestationUtils;
        if (attestationUtils == null) {
            Log.e(TAG, "Not support attestation utils. Need to check build version :" + Build.VERSION.SDK_INT);
            return null;
        }
        try {
            synchronized (attestationUtils) {
                try {
                    Certificate[] certificateChain = this.mAttestationUtils.getCertificateChain("sakUid");
                    if (certificateChain == null || certificateChain.length < 3) {
                        byte[] bArrMakeRandomChallenge = makeRandomChallenge();
                        this.mAttestationUtils.generateKeyPair("sakUid", bArrMakeRandomChallenge);
                        Certificate[] certificateChain2 = this.mAttestationUtils.getCertificateChain("sakUid");
                        if (!verifyCertChain(certificateChain2, bArrMakeRandomChallenge)) {
                            Log.e(TAG, "certificate chain verification failed.");
                            return null;
                        }
                        certificateChain = certificateChain2;
                    }
                    return parseSakUid(((X509Certificate) certificateChain[0]).getIssuerX500Principal().toString(), str.contains("sakm"));
                } finally {
                }
            }
        } catch (IllegalArgumentException | NullPointerException | ProviderException e) {
            e.printStackTrace();
            return null;
        }
    }

    public X509Certificate[] getWrapKey(String str, byte[] bArr) {
        if (this.mAttestationUtils == null) {
            Log.e(TAG, "Not support attestation utils. Need to check build version :" + Build.VERSION.SDK_INT);
            return null;
        }
        if (Build.VERSION.SDK_INT < 28) {
            Log.e(TAG, "You need to check os version ! Now under the Pos");
            return null;
        }
        AttestParameterSpec attestParameterSpecBuild = new AttestParameterSpec.Builder(str, bArr).setAlgorithm(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA).setKeyGenParameterSpec(new KeyGenParameterSpec.Builder(str, 32).setDigests("SHA-256", IDevicePopManager.SHA_1).setEncryptionPaddings("OAEPPadding").setBlockModes("ECB").build()).setVerifiableIntegrity(true).build();
        try {
            synchronized (this.mAttestationUtils) {
                try {
                    if (this.mAttestationUtils.getKey(str) == null) {
                        String str2 = TAG;
                        Log.i(str2, "generate key for wrap key. : " + str);
                        if (this.mAttestationUtils.generateKeyPair(attestParameterSpecBuild) == null) {
                            Log.e(str2, "getWrapKey generateKeyPair is null");
                            return null;
                        }
                    }
                    Certificate[] certificateChain = this.mAttestationUtils.getCertificateChain(str);
                    if (certificateChain == null) {
                        String str3 = TAG;
                        Log.e(str3, "getWrapKey certChain is NULL. Retry key generation.");
                        if (this.mAttestationUtils.generateKeyPair(attestParameterSpecBuild) == null) {
                            Log.e(str3, "getWrapKey retrying generateKeyPair is null");
                            return null;
                        }
                        Certificate[] certificateChain2 = this.mAttestationUtils.getCertificateChain(str);
                        if (certificateChain2 == null) {
                            Log.e(str3, "getWrapKey certChain is NULL.");
                            return null;
                        }
                        certificateChain = certificateChain2;
                    }
                    X509Certificate[] x509CertificateArr = new X509Certificate[certificateChain.length];
                    for (int i = 0; i < certificateChain.length; i++) {
                        x509CertificateArr[i] = (X509Certificate) certificateChain[i];
                    }
                    return x509CertificateArr;
                } finally {
                }
            }
        } catch (IllegalArgumentException | NullPointerException | KeyStoreException | ProviderException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void removeKey(String str) {
        AttestationUtils attestationUtils = this.mAttestationUtils;
        if (attestationUtils == null) {
            Log.e(TAG, "Not support attestation utils. Need to check build version :" + Build.VERSION.SDK_INT);
            return;
        }
        try {
            synchronized (attestationUtils) {
                this.mAttestationUtils.deleteKey(str);
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private SksAttestation() {
        this.mAttestationUtils = (AttestationUtils) KmxFaultBarrier.get(new C0347a(26), null);
    }

    private boolean verifyCertChain(X509Certificate[] x509CertificateArr, byte[] bArr) {
        if (x509CertificateArr == null) {
            Log.e(TAG, "verifyCertChain certChain is null.");
            return false;
        }
        if (x509CertificateArr.length != 3) {
            Log.e(TAG, "Invalid certification chain size : " + x509CertificateArr.length);
            return false;
        }
        try {
            AttestatedCertParser attestatedCertParser = new AttestatedCertParser(x509CertificateArr[0]);
            if (checkChallengeOfAttestationCert(attestatedCertParser.getChallenge(), bArr) && checkKeyOrigin(attestatedCertParser.getOrigin()) && checkRootOfTrust(attestatedCertParser.getRootOfTrust())) {
                try {
                    X509Certificate sakRoot = SamsungAttestationRootCert.getSakRoot(attestatedCertParser.getSakUID());
                    int length = x509CertificateArr.length - 1;
                    while (length >= 0) {
                        X509Certificate x509Certificate = x509CertificateArr[length];
                        x509Certificate.checkValidity();
                        x509Certificate.verify(sakRoot.getPublicKey());
                        length--;
                        sakRoot = x509Certificate;
                    }
                    return true;
                } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e) {
                    e.printStackTrace();
                    if (e instanceof CertificateNotYetValidException) {
                        Log.e(TAG, e.getMessage() + System.lineSeparator() + System.lineSeparator() + "Please set to the current time (Settings > General management > Date and time)");
                    } else {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        } catch (CertificateParsingException e2) {
            Log.e(TAG, "verifyCertChain certificate Parsing Error : ", e2);
            return false;
        }
    }
}
