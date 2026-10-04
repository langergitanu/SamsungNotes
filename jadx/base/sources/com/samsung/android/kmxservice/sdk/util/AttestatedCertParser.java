package com.samsung.android.kmxservice.sdk.util;

import android.util.Log;
import com.samsung.android.kmxservice.sdk.e2ee.data.LogTag;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AttestatedCertParser {
    private static final int ATTESTATION_CHALLENGE_INDEX = 4;
    private static final int ATTESTATION_SECURITY_LEVEL_INDEX = 1;
    private static final int ATTESTATION_VERSION_INDEX = 0;
    private static final String DOUBLE_LINE = "\n\n";
    private static final int KEYMASTER_SECURITY_LEVEL_INDEX = 3;
    private static final int KEYMASTER_VERSION_INDEX = 2;
    private static final String KEY_DESCRIPTION_OID = "1.3.6.1.4.1.11129.2.1.17";
    private static final String KNOX_EXTENSION_OID = "1.3.6.1.4.1.236.11.3.23.7";
    private static final int KNOX_TEE_PROPERTIES_INTEGRITY_STATUS = 5;
    private static final String LINE_BREAK = "\n";
    private static final String LINE_BREAK_4SPACE = "\n    ";
    private static final int SW_ENFORCED_INDEX = 6;
    private static final String TAG = LogTag.getTag("AttestatedCertParser");
    private static final int TEE_ENFORCED_INDEX = 7;
    private static final int UNIQUE_ID_INDEX = 5;
    private final byte[] mAttestationChallenge;
    private final int mAttestationSecurityLevel;
    private final int mAttestationVersion;
    private IntegrityStatus mIntegrityStatus;
    private final int mKeymasterSecurityLevel;
    private final int mKeymasterVersion;
    private String mSakUID;
    private final AuthorizationList mSoftwareEnforced;
    private final AuthorizationList mTeeEnforced;
    private final byte[] mUniqueId;

    public AttestatedCertParser(X509Certificate x509Certificate) throws CertificateParsingException {
        ASN1Sequence attestationSequence = getAttestationSequence(x509Certificate);
        this.mAttestationVersion = Asn1Utils.getIntegerFromAsn1(attestationSequence.getObjectAt(0));
        this.mAttestationSecurityLevel = Asn1Utils.getIntegerFromAsn1(attestationSequence.getObjectAt(1));
        this.mKeymasterVersion = Asn1Utils.getIntegerFromAsn1(attestationSequence.getObjectAt(2));
        this.mKeymasterSecurityLevel = Asn1Utils.getIntegerFromAsn1(attestationSequence.getObjectAt(3));
        this.mAttestationChallenge = Asn1Utils.getByteArrayFromAsn1(attestationSequence.getObjectAt(4));
        this.mUniqueId = Asn1Utils.getByteArrayFromAsn1(attestationSequence.getObjectAt(5));
        this.mSoftwareEnforced = new AuthorizationList(attestationSequence.getObjectAt(6));
        this.mTeeEnforced = new AuthorizationList(attestationSequence.getObjectAt(7));
        this.mIntegrityStatus = parseIntegrityStatus(getKnoxExtensionSequence(x509Certificate));
        this.mSakUID = parseSakUID(x509Certificate.getIssuerDN());
    }

    private ASN1Sequence getAttestationSequence(X509Certificate x509Certificate) throws CertificateParsingException {
        byte[] extensionValue = x509Certificate.getExtensionValue(KEY_DESCRIPTION_OID);
        if (extensionValue == null || extensionValue.length == 0) {
            throw new CertificateParsingException("Did not find extension with OID 1.3.6.1.4.1.11129.2.1.17");
        }
        return Asn1Utils.getAsn1SequenceFromBytes(extensionValue);
    }

    private ASN1Sequence getKnoxExtensionSequence(X509Certificate x509Certificate) {
        byte[] extensionValue = x509Certificate.getExtensionValue(KNOX_EXTENSION_OID);
        if (extensionValue != null && extensionValue.length != 0) {
            return Asn1Utils.getAsn1SequenceFromBytes(extensionValue);
        }
        Log.w(TAG, "Not include extension with OID 1.3.6.1.4.1.236.11.3.23.7");
        return null;
    }

    private IntegrityStatus parseIntegrityStatus(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence == null) {
            Log.w(TAG, "parseIntegrityStatus : knoxExtSeq is null");
            return null;
        }
        for (int i = 0; i < aSN1Sequence.size(); i++) {
            ASN1TaggedObject objectAt = aSN1Sequence.getObjectAt(i);
            if (objectAt instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = objectAt;
                if (aSN1TaggedObject.getTagNo() == 5) {
                    return new IntegrityStatus(aSN1TaggedObject.getObject());
                }
            }
        }
        Log.w(TAG, "parseIntegrityStatus : Not include integrity status in knox extension");
        return null;
    }

    private String parseSakUID(Principal principal) {
        String str = "";
        if (principal == null) {
            Log.w(TAG, "parseSakUID : issuer is null");
            return "";
        }
        String[] strArrSplit = principal.toString().split(",");
        int length = strArrSplit.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str2 = strArrSplit[i];
            if (str2.contains("UID")) {
                str = str2;
                break;
            }
            i++;
        }
        Log.d(TAG, "parseSakUID : result = ".concat(str));
        return str;
    }

    private String printValue(int i, int i2) {
        if (i == 1 || i == 3) {
            if (i2 == 0) {
                return "0 (Software)";
            }
            if (i2 == 1) {
                return "1 (TrustedEnvironment)";
            }
            if (i2 == 2) {
                return "2 (StrongBox)";
            }
            Log.w(TAG, "[printValue] Unknown Attestation Security Level : " + this.mAttestationSecurityLevel);
        }
        Log.w(TAG, "[printValue] Unknown Tag : " + i);
        return Integer.toString(i2);
    }

    public AttestationApplicationId getAttestAppId() {
        return this.mSoftwareEnforced.getAttestationAppId();
    }

    public int getBootPatchLevel() {
        return this.mTeeEnforced.getBootPacthLevel().intValue();
    }

    public byte[] getChallenge() {
        return this.mAttestationChallenge;
    }

    public IntegrityStatus getIngetrityStatus() {
        return this.mIntegrityStatus;
    }

    public int getOrigin() {
        return this.mTeeEnforced.getOrigin().intValue();
    }

    public int getOsPatchLevel() {
        return this.mTeeEnforced.getOsPatchLevel().intValue();
    }

    public RootOfTrust getRootOfTrust() {
        return this.mTeeEnforced.getRootOfTrust();
    }

    public String getSakUID() {
        return this.mSakUID;
    }

    public int getSecurityLevel() {
        return this.mKeymasterSecurityLevel;
    }

    public int getVendorPatchLevel() {
        return this.mTeeEnforced.getVendorPacthLevel().intValue();
    }

    public String printExtData() {
        StringBuilder sb = new StringBuilder("*****************  Key Description  *****************\n\nAttestaion Version\n    ");
        sb.append(this.mAttestationVersion);
        sb.append("\nAttestaion Security Level\n    ");
        sb.append(printValue(1, this.mAttestationSecurityLevel));
        sb.append("\nKeymaster Version\n    ");
        sb.append(this.mKeymasterVersion);
        sb.append("\nKeymaster Security Level\n    ");
        sb.append(printValue(3, this.mKeymasterSecurityLevel));
        sb.append("\nAttestation Challenge\n    ");
        byte[] bArr = this.mAttestationChallenge;
        Charset charset = StandardCharsets.UTF_8;
        sb.append(new String(bArr, charset));
        sb.append("\nUnique ID\n    ");
        byte[] bArr2 = this.mUniqueId;
        if (bArr2 == null || bArr2.length <= 0) {
            sb.append("Only used by system apps");
        } else {
            sb.append(new String(bArr2, charset));
        }
        sb.append("\n\n****************  AuthorizationList  ****************\n\n");
        sb.append(this.mSoftwareEnforced.getAuthorizationList());
        sb.append("\n\n");
        sb.append(this.mTeeEnforced.getAuthorizationList());
        sb.append("\n\n****************  Knox Extension  ****************\n\n");
        sb.append(this.mIntegrityStatus);
        return sb.toString();
    }
}
