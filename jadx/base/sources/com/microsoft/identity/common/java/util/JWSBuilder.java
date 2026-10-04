package com.microsoft.identity.common.java.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.challengehandlers.IDeviceCertificate;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.logging.Logger;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.security.cert.CertificateEncodingException;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class JWSBuilder {
    protected static final String JWS_HEADER_ALG = "RS256";
    protected static final long SECONDS_MS = 1000;
    private static final String SIGNING_ALGORITHM = "SHA256withRSA";
    private static final String TAG = "JWSBuilder";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @SuppressFBWarnings({"URF_UNREAD_FIELD"})
    public static final class Claims {

        @SerializedName("aud")
        private String mAudience;

        @SerializedName("iat")
        private long mIssueAt;

        @SerializedName("nonce")
        private String mNonce;

        private Claims() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @SuppressFBWarnings({"URF_UNREAD_FIELD"})
    public static final class JwsHeader {

        @SerializedName("alg")
        private String mAlgorithm;

        @SerializedName("x5c")
        private String[] mCert;

        @SerializedName("typ")
        private String mType;

        private JwsHeader() {
        }
    }

    public String encodeUrlSafeString(byte[] bArr) {
        return StringUtil.encodeUrlSafeString(bArr);
    }

    public String generateSignedJWT(@NonNull String str, @NonNull String str2, @NonNull IDeviceCertificate iDeviceCertificate) throws ClientException {
        if (str == null) {
            throw new NullPointerException("nonce is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("audience is marked non-null but is null");
        }
        if (iDeviceCertificate == null) {
            throw new NullPointerException("deviceCert is marked non-null but is null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("nonce is an empty string.");
        }
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("audience is an empty string.");
        }
        Gson gson = new Gson();
        Claims claims = new Claims();
        claims.mNonce = str;
        claims.mAudience = str2;
        claims.mIssueAt = getCurrentTimeInSeconds();
        JwsHeader jwsHeader = new JwsHeader();
        jwsHeader.mAlgorithm = "RS256";
        jwsHeader.mType = "JWT";
        try {
            jwsHeader.mCert = new String[1];
            jwsHeader.mCert[0] = StringUtil.base64Encode(iDeviceCertificate.getX509().getEncoded());
            String json = gson.toJson(jwsHeader);
            String json2 = gson.toJson(claims);
            Logger.verbose("JWSBuilder:generateSignedJWT", "Generate client certificate challenge response JWS Header. ");
            String str3 = encodeUrlSafeString(StringUtil.toByteArray(json)) + Extension.DOT + encodeUrlSafeString(StringUtil.toByteArray(json2));
            return AbstractC0541b.m757C(str3, Extension.DOT, encodeUrlSafeString(iDeviceCertificate.sign(SIGNING_ALGORITHM, StringUtil.toByteArray(str3))));
        } catch (CertificateEncodingException e) {
            throw new ClientException(ErrorStrings.CERTIFICATE_ENCODING_ERROR, "Certificate encoding error", e);
        }
    }

    public long getCurrentTimeInSeconds() {
        return System.currentTimeMillis() / 1000;
    }
}
