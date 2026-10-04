package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class PkceChallenge implements Serializable {
    private static final String CHALLENGE_SHA256 = "S256";
    private static final int CODE_VERIFIER_BYTE_SIZE = 32;
    private static final String DIGEST_ALGORITHM = "SHA-256";
    private static final String ISO_8859_1 = "ISO_8859_1";
    private static final long serialVersionUID = 8549806628675994235L;

    @SerializedName("code_challenge")
    private final String mCodeChallenge;

    @SerializedName("code_challenge_method")
    private final String mCodeChallengeMethod = CHALLENGE_SHA256;

    @SuppressFBWarnings({"SE_TRANSIENT_FIELD_NOT_RESTORED"})
    private final transient String mCodeVerifier;

    private PkceChallenge(String str, String str2) {
        this.mCodeVerifier = str;
        this.mCodeChallenge = str2;
    }

    public static String generateCodeVerifier(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[32];
            new SecureRandom().nextBytes(bArr);
        }
        return StringUtil.encodeUrlSafeString(bArr);
    }

    public static String generateCodeVerifierChallenge(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(ISO_8859_1));
            return StringUtil.encodeUrlSafeString(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Every implementation of the Java platform is required to support ISO-8859-1.Consult the release documentation for your implementation.", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("Failed to generate the code verifier challenge", e2);
        }
    }

    public static PkceChallenge newPkceChallenge() {
        String strGenerateCodeVerifier = generateCodeVerifier(null);
        return new PkceChallenge(strGenerateCodeVerifier, generateCodeVerifierChallenge(strGenerateCodeVerifier));
    }

    public String getCodeChallenge() {
        return this.mCodeChallenge;
    }

    public String getCodeChallengeMethod() {
        return this.mCodeChallengeMethod;
    }

    public String getCodeVerifier() {
        return this.mCodeVerifier;
    }
}
