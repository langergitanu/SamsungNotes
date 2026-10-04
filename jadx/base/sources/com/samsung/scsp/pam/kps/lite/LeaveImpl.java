package com.samsung.scsp.pam.kps.lite;

import android.annotation.SuppressLint;
import com.google.gson.JsonObject;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.AbstractApiControl;
import com.samsung.scsp.framework.core.api.ApiContext;
import com.samsung.scsp.framework.core.listeners.Listeners;
import com.samsung.scsp.framework.core.listeners.ListenersHolder;
import com.samsung.scsp.pam.kps.lite.KpsApiContract;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@SuppressLint({WarningType.NewApi})
class LeaveImpl extends AbstractApiControl.Request {
    private static final int CHALLENGE_PASSWORD_LENGTH = 20;
    private static final String ROOT_CERTIFICATE = "MIIDCzCCApKgAwIBAgIUaLBIADD1ETMu6BrpCldCqh2DWLAwCgYIKoZIzj0EAwMwgbsxCzAJBgNVBAYTAktSMRQwEgYDVQQIDAtHeWVvbmdnaS1kbzERMA8GA1UEBwwIU3V3b24tc2kxJDAiBgNVBAoMG1NBTVNVTkcgRUxFQ1RST05JQ1MgQ08sIExURDEdMBsGA1UECwwUQ2xvdWQgUGxhdGZvcm0gR3JvdXAxFjAUBgNVBAMMDVNhbXN1bmcgQ2xvdWQxJjAkBgkqhkiG9w0BCQEWF3NlY2NvcmUuc2VjQHNhbXN1bmcuY29tMCAXDTIzMDcyMDAxMjc1N1oYDzIwNTMwNzEyMDEyNzU3WjCBuzELMAkGA1UEBhMCS1IxFDASBgNVBAgMC0d5ZW9uZ2dpLWRvMREwDwYDVQQHDAhTdXdvbi1zaTEkMCIGA1UECgwbU0FNU1VORyBFTEVDVFJPTklDUyBDTywgTFREMR0wGwYDVQQLDBRDbG91ZCBQbGF0Zm9ybSBHcm91cDEWMBQGA1UEAwwNU2Ftc3VuZyBDbG91ZDEmMCQGCSqGSIb3DQEJARYXc2VjY29yZS5zZWNAc2Ftc3VuZy5jb20wdjAQBgcqhkjOPQIBBgUrgQQAIgNiAASmAkFwwInhuyXrRWHmNe6XlaqfYvNYqZYZffo9BOqjE9mJteAjxHr1x8c6o7cQQ6q2fOekfk1vebEPQGAVTYisYCW5OOj59GXiY9XE6rmxA6E88sbshzNpQ6CDxBYrEoujUzBRMB0GA1UdDgQWBBQjDrA2vENCxuVuplb7V/GyjtFB0DAfBgNVHSMEGDAWgBQjDrA2vENCxuVuplb7V/GyjtFB0DAPBgNVHRMBAf8EBTADAQH/MAoGCCqGSM49BAMDA2cAMGQCMGHOYWoR9/59DzNKb32W27ylngNif+dwR8GTY8MxhwTmqlGGpjKmSccl+zi7h8BkugIweeA6jYtl376A7QqLSTlkwEr/9FWEonY+clttSvLDHNX7DurQ8cUA/xN7XJqMBjz4";
    private final Logger logger;

    public LeaveImpl() {
        super(KpsApiContract.Control.LEAVE);
        this.logger = Logger.get("LeaveImpl");
    }

    private byte[] createChallengePassword() {
        byte[] bArr = new byte[20];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    private String encryptRecoveryCode(String str, PublicKey publicKey) throws ScspException {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey);
            return new String(Base64.getEncoder().encode(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8))));
        } catch (Throwable th) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, th.getMessage());
        }
    }

    private byte[] fromBase64(String str) {
        return Base64.getDecoder().decode(str);
    }

    private KpsCertificateChain getCertificateChain(ApiContext apiContext, byte[] bArr) {
        this.logger.m12934i("getCertificateChain");
        apiContext.name = KpsLiteApiSpec.GET_CERTIFICATE_CHAIN;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("challenge", toBase64(bArr));
        apiContext.payload = jsonObject.toString();
        ListenersHolder listenersHolderCreate = ListenersHolder.create();
        apiContext.api.execute(apiContext, listenersHolderCreate.getListeners());
        return (KpsCertificateChain) listenersHolderCreate.getResult();
    }

    private PublicKey getPublicKey() throws ScspException {
        try {
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(fromBase64(ROOT_CERTIFICATE)))).getPublicKey();
        } catch (Throwable th) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, th.getMessage());
        }
    }

    private void stateOff(ApiContext apiContext, String str) {
        this.logger.m12934i("stateOff");
        apiContext.name = KpsLiteApiSpec.STATE_OFF;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(KpsApiContract.Parameter.RECOVERY_CODE, str);
        apiContext.payload = jsonObject.toString();
        apiContext.api.execute(apiContext, ListenersHolder.create().getListeners());
    }

    private String toBase64(byte[] bArr) {
        return new String(Base64.getEncoder().encode(bArr));
    }

    private X509Certificate[] toX509Certificates(String[] strArr) throws ScspException {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            return new X509Certificate[]{(X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(fromBase64(strArr[0]))), (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(fromBase64(strArr[1])))};
        } catch (Exception e) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, e.getMessage());
        }
    }

    private void verify(X509Certificate[] x509CertificateArr, byte[] bArr, PublicKey publicKey) throws ScspException {
        if (!Arrays.equals(bArr, Arrays.copyOfRange(x509CertificateArr[0].getExtensionValue("1.2.840.113549.1.9.7"), 2, bArr.length + 2))) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "wrong challengePassword");
        }
        try {
            x509CertificateArr[0].checkValidity();
            x509CertificateArr[0].verify(publicKey);
        } catch (Throwable th) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, th.getMessage());
        }
    }

    @Override // com.samsung.scsp.framework.core.api.AbstractApiControl.Request
    public void execute(ApiContext apiContext, Listeners listeners) throws ScspException {
        byte[] bArrCreateChallengePassword = createChallengePassword();
        X509Certificate[] x509Certificates = toX509Certificates(getCertificateChain(apiContext, bArrCreateChallengePassword).certificateChain);
        verify(x509Certificates, bArrCreateChallengePassword, getPublicKey());
        stateOff(apiContext, encryptRecoveryCode(apiContext.parameters.getAsString(KpsApiContract.Parameter.RECOVERY_CODE), x509Certificates[0].getPublicKey()));
    }
}
