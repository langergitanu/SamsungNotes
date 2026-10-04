package com.samsung.android.kmxservice.sdk.util;

import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.common.net.HttpHeaders;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import com.samsung.android.kmxservice.sdk.e2ee.data.LogTag;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateParsingException;
import java.util.Date;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1TaggedObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AuthorizationList {
    private static final int KEYMASTER_TAG_TYPE_MASK = 268435455;
    private static final int KM_ALGORITHM_EC = 3;
    private static final int KM_ALGORITHM_RSA = 1;
    private static final int KM_BOOL = 1879048192;
    private static final int KM_BYTES = -1879048192;
    private static final int KM_DATE = 1610612736;
    private static final int KM_DIGEST_MD5 = 1;
    private static final int KM_DIGEST_NONE = 0;
    private static final int KM_DIGEST_SHA1 = 2;
    private static final int KM_DIGEST_SHA_2_224 = 3;
    private static final int KM_DIGEST_SHA_2_256 = 4;
    private static final int KM_DIGEST_SHA_2_384 = 5;
    private static final int KM_DIGEST_SHA_2_512 = 6;
    private static final int KM_ENUM = 268435456;
    private static final int KM_ENUM_REP = 536870912;
    public static final int KM_ORIGIN_GENERATED = 0;
    public static final int KM_ORIGIN_IMPORTED = 2;
    public static final int KM_ORIGIN_UNKNOWN = 3;
    private static final int KM_PAD_NONE = 1;
    private static final int KM_PAD_PKCS7 = 64;
    private static final int KM_PAD_RSA_OAEP = 2;
    private static final int KM_PAD_RSA_PKCS1_1_5_ENCRYPT = 4;
    private static final int KM_PAD_RSA_PKCS1_1_5_SIGN = 5;
    private static final int KM_PAD_RSA_PSS = 3;
    private static final int KM_PURPOSE_DECRYPT = 1;
    private static final int KM_PURPOSE_ENCRYPT = 0;
    private static final int KM_PURPOSE_SIGN = 2;
    private static final int KM_PURPOSE_VERIFY = 3;
    private static final int KM_PURPOSE_WRAP = 5;
    private static final int KM_TAG_ACTIVE_DATETIME = 1610613136;
    private static final int KM_TAG_ALGORITHM = 268435458;
    private static final int KM_TAG_ALLOW_WHILE_ON_BODY = 1879048698;
    private static final int KM_TAG_ALL_APPLICATIONS = 1879048792;
    private static final int KM_TAG_APPLICATION_ID = -1879047591;
    private static final int KM_TAG_ATTESTATION_APPLICATION_ID = -1879047483;
    private static final int KM_TAG_ATTESTATION_ID_BRAND = -1879047482;
    private static final int KM_TAG_ATTESTATION_ID_DEVICE = -1879047481;
    private static final int KM_TAG_ATTESTATION_ID_IMEI = -1879047478;
    private static final int KM_TAG_ATTESTATION_ID_MANUFACTURER = -1879047476;
    private static final int KM_TAG_ATTESTATION_ID_MEID = -1879047477;
    private static final int KM_TAG_ATTESTATION_ID_MODEL = -1879047475;
    private static final int KM_TAG_ATTESTATION_ID_PRODUCT = -1879047480;
    private static final int KM_TAG_ATTESTATION_ID_SERIAL = -1879047479;
    private static final int KM_TAG_AUTH_TIMEOUT = 805306873;
    private static final int KM_TAG_BOOT_PATCHLEVEL = 805307087;
    private static final int KM_TAG_CREATION_DATETIME = 1610613437;
    private static final int KM_TAG_DIGEST = 536870917;
    private static final int KM_TAG_EC_CURVE = 268435466;
    private static final int KM_TAG_KEY_SIZE = 805306371;
    private static final int KM_TAG_NO_AUTH_REQUIRED = 1879048695;
    private static final int KM_TAG_ORIGIN = 268436158;
    private static final int KM_TAG_ORIGINATION_EXPIRE_DATETIME = 1610613137;
    private static final int KM_TAG_OS_PATCHLEVEL = 805307074;
    private static final int KM_TAG_OS_VERSION = 805307073;
    private static final int KM_TAG_PADDING = 536870918;
    private static final int KM_TAG_PURPOSE = 536870913;
    private static final int KM_TAG_ROLLBACK_RESISTANT = 1879048895;
    private static final int KM_TAG_ROOT_OF_TRUST = -1879047488;
    private static final int KM_TAG_RSA_PUBLIC_EXPONENT = 1342177480;
    private static final int KM_TAG_USAGE_EXPIRE_DATETIME = 1610613138;
    private static final int KM_TAG_USER_AUTH_TYPE = 268435960;
    private static final int KM_TAG_VENDOR_PATCHLEVEL = 805307086;
    private static final int KM_UINT = 805306368;
    private static final int KM_ULONG = 1342177280;
    private static final String TAG = LogTag.getTag("AuthorizationList");
    private Date mActiveDateTime;
    private Integer mAlgorithm;
    private boolean mAllApplications;
    private boolean mAllowWhileOnBody;
    private byte[] mApplicationId;
    private AttestationApplicationId mAttestationApplicationId;
    private Integer mAuthTimeout;
    private Integer mBootPatchLevel;
    private String mBrand;
    private Date mCreationDateTime;
    private String mDevice;
    private Set<Integer> mDigest;
    private Integer mEcCurve;
    private Integer mKeySize;
    private String mManufacturer;
    private String mModel;
    private boolean mNoAuthRequired;
    private Integer mOrigin;
    private Date mOriginationExpireDateTime;
    private Integer mOsPatchLevel;
    private Integer mOsVersion;
    private Set<Integer> mPaddingMode;
    private String mProduct;
    private Set<Integer> mPurpose;
    private boolean mRollbackResistant;
    private RootOfTrust mRootOfTrust;
    private Long mRsaPublicExponent;
    private StringBuilder mSb = new StringBuilder();
    private Date mUsageExpireDateTime;
    private Integer mUserAuthType;
    private Integer mVendorPatchLevel;

    public AuthorizationList(ASN1Encodable aSN1Encodable) throws CertificateParsingException {
        if (!(aSN1Encodable instanceof ASN1Sequence)) {
            throw new CertificateParsingException("Expected sequence for authorization list, found ".concat(aSN1Encodable.getClass().getName()));
        }
        ASN1SequenceParser rVar = ((ASN1Sequence) aSN1Encodable).parser();
        for (ASN1TaggedObject asn1TaggedObject = parseAsn1TaggedObject(rVar); asn1TaggedObject != null; asn1TaggedObject = parseAsn1TaggedObject(rVar)) {
            int tagNo = asn1TaggedObject.getTagNo();
            ASN1Primitive object = asn1TaggedObject.getObject();
            String str = TAG;
            Log.i(str, "Parsing tag: [" + tagNo + "] = [" + object + "]");
            if (tagNo == 1) {
                this.mPurpose = Asn1Utils.getIntegersFromAsn1Set(object);
                addTagInfo(printTag(tagNo), printValue(tagNo, this.mPurpose));
            } else if (tagNo == 2) {
                this.mAlgorithm = Integer.valueOf(Asn1Utils.getIntegerFromAsn1(object));
                addTagInfo(printTag(tagNo), printValue(tagNo, this.mAlgorithm));
            } else if (tagNo == 3) {
                this.mKeySize = Integer.valueOf(Asn1Utils.getIntegerFromAsn1(object));
                addTagInfo(printTag(tagNo), this.mKeySize);
            } else if (tagNo == 5) {
                this.mDigest = Asn1Utils.getIntegersFromAsn1Set(object);
                addTagInfo(printTag(tagNo), printValue(tagNo, this.mDigest));
            } else if (tagNo == 6) {
                this.mPaddingMode = Asn1Utils.getIntegersFromAsn1Set(object);
                addTagInfo(printTag(tagNo), printValue(tagNo, this.mPaddingMode));
            } else if (tagNo == 10) {
                this.mEcCurve = Integer.valueOf(Asn1Utils.getIntegerFromAsn1(object));
                addTagInfo(printTag(tagNo), this.mEcCurve);
            } else if (tagNo == 200) {
                this.mRsaPublicExponent = Asn1Utils.getLongFromAsn1(object);
                addTagInfo(printTag(tagNo), this.mRsaPublicExponent);
            } else if (tagNo == 600) {
                this.mAllApplications = true;
                addTagInfo(printTag(tagNo), this.mAllApplications);
            } else if (tagNo != 601) {
                switch (tagNo) {
                    case 400:
                        this.mActiveDateTime = Asn1Utils.getDateFromAsn1(object);
                        addTagInfo(printTag(tagNo), this.mActiveDateTime.toString());
                        break;
                    case 401:
                        this.mOriginationExpireDateTime = Asn1Utils.getDateFromAsn1(object);
                        addTagInfo(printTag(tagNo), this.mOriginationExpireDateTime.toString());
                        break;
                    case 402:
                        this.mUsageExpireDateTime = Asn1Utils.getDateFromAsn1(object);
                        addTagInfo(printTag(tagNo), this.mUsageExpireDateTime.toString());
                        break;
                    default:
                        switch (tagNo) {
                            case 503:
                                this.mNoAuthRequired = true;
                                addTagInfo(printTag(tagNo), this.mNoAuthRequired);
                                break;
                            case 504:
                                this.mUserAuthType = Integer.valueOf(Asn1Utils.getIntegerFromAsn1(object));
                                addTagInfo(printTag(tagNo), this.mUserAuthType);
                                break;
                            case 505:
                                this.mAuthTimeout = Integer.valueOf(Asn1Utils.getIntegerFromAsn1(object));
                                addTagInfo(printTag(tagNo), this.mAuthTimeout);
                                break;
                            case 506:
                                this.mAllowWhileOnBody = true;
                                addTagInfo(printTag(tagNo), this.mAllowWhileOnBody);
                                break;
                            default:
                                switch (tagNo) {
                                    case 701:
                                        this.mCreationDateTime = Asn1Utils.getDateFromAsn1(object);
                                        addTagInfo(printTag(tagNo), this.mCreationDateTime.toString());
                                        break;
                                    case 702:
                                        this.mOrigin = Integer.valueOf(Asn1Utils.getIntegerFromAsn1(object));
                                        addTagInfo(printTag(tagNo), printValue(tagNo, this.mOrigin));
                                        break;
                                    case 703:
                                        this.mRollbackResistant = true;
                                        addTagInfo(printTag(tagNo), this.mRollbackResistant);
                                        break;
                                    case 704:
                                        this.mRootOfTrust = new RootOfTrust(object);
                                        addTagInfo(printTag(tagNo), this.mRootOfTrust.toString());
                                        break;
                                    case 705:
                                        this.mOsVersion = Integer.valueOf(Asn1Utils.getIntegerFromAsn1(object));
                                        addTagInfo(printTag(tagNo), this.mOsVersion);
                                        break;
                                    case 706:
                                        this.mOsPatchLevel = Integer.valueOf(Asn1Utils.getIntegerFromAsn1(object));
                                        addTagInfo(printTag(tagNo), this.mOsPatchLevel);
                                        break;
                                    default:
                                        switch (tagNo) {
                                            case 709:
                                                this.mAttestationApplicationId = new AttestationApplicationId(Asn1Utils.getAsn1EncodableFromBytes(Asn1Utils.getByteArrayFromAsn1(object)));
                                                addTagInfo(printTag(tagNo), this.mAttestationApplicationId.toString());
                                                break;
                                            case 710:
                                                this.mBrand = getStringFromAsn1Value(object);
                                                addTagInfo(printTag(tagNo), this.mBrand);
                                                break;
                                            case 711:
                                                this.mDevice = getStringFromAsn1Value(object);
                                                addTagInfo(printTag(tagNo), this.mDevice);
                                                break;
                                            case 712:
                                                this.mProduct = getStringFromAsn1Value(object);
                                                addTagInfo(printTag(tagNo), this.mProduct);
                                                break;
                                            case 713:
                                            case 714:
                                            case 715:
                                                AbstractC2322a.m1631u(tagNo, "Not support tag in SAK : ", str);
                                                break;
                                            case 716:
                                                this.mManufacturer = getStringFromAsn1Value(object);
                                                addTagInfo(printTag(tagNo), this.mManufacturer);
                                                break;
                                            case 717:
                                                this.mModel = getStringFromAsn1Value(object);
                                                addTagInfo(printTag(tagNo), this.mModel);
                                                break;
                                            case 718:
                                                this.mVendorPatchLevel = Integer.valueOf(Asn1Utils.getIntegerFromAsn1(object));
                                                addTagInfo(printTag(tagNo), this.mVendorPatchLevel);
                                                break;
                                            case 719:
                                                this.mBootPatchLevel = Integer.valueOf(Asn1Utils.getIntegerFromAsn1(object));
                                                addTagInfo(printTag(tagNo), this.mBootPatchLevel);
                                                break;
                                            default:
                                                AbstractC11014a.m12328m(tagNo, "Skip unkown tag [", "]", str);
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
            } else {
                this.mApplicationId = Asn1Utils.getByteArrayFromAsn1(object);
                addTagInfo(printTag(tagNo), new String(this.mApplicationId, StandardCharsets.UTF_8));
            }
        }
    }

    private void addTagInfo(String str, String str2) {
        Log.i(TAG, "Found [" + str + "] = " + str2);
        if (this.mSb.length() > 0) {
            this.mSb.append("\n");
        }
        this.mSb.append(str);
        this.mSb.append("\n   ");
        this.mSb.append(str2);
    }

    private String getStringFromAsn1Value(ASN1Primitive aSN1Primitive) throws CertificateParsingException {
        try {
            return Asn1Utils.getStringFromAsn1OctetStreamAssumingUTF8(aSN1Primitive);
        } catch (UnsupportedEncodingException e) {
            throw new CertificateParsingException("Error parsing ASN.1 value", e);
        }
    }

    private static ASN1Encodable parseAsn1Encodable(ASN1SequenceParser aSN1SequenceParser) throws CertificateParsingException {
        try {
            return aSN1SequenceParser.readObject();
        } catch (IOException e) {
            throw new CertificateParsingException("Failed to parse ASN1 sequence", e);
        }
    }

    private static ASN1TaggedObject parseAsn1TaggedObject(ASN1SequenceParser aSN1SequenceParser) throws CertificateParsingException {
        ASN1TaggedObject asn1Encodable = parseAsn1Encodable(aSN1SequenceParser);
        if (asn1Encodable == null || (asn1Encodable instanceof ASN1TaggedObject)) {
            return asn1Encodable;
        }
        throw new CertificateParsingException("Expected tagged object, found ".concat(asn1Encodable.getClass().getName()));
    }

    private String printTag(int i) {
        if (i == 1) {
            return HttpHeaders.PURPOSE;
        }
        if (i == 2) {
            return "Algorithm";
        }
        if (i == 3) {
            return "KeySize";
        }
        if (i == 5) {
            return "Digest";
        }
        if (i == 6) {
            return "Padding";
        }
        if (i == 10) {
            return "EC Curve";
        }
        if (i == 200) {
            return "Rsa Public Exponent";
        }
        if (i == 600) {
            return "All Applications";
        }
        if (i == 601) {
            return "Application ID";
        }
        switch (i) {
            case 400:
                return "Active Date Time";
            case 401:
                return "Origination Expire Date Time";
            case 402:
                return "Usage Expire Date Time";
            default:
                switch (i) {
                    case 503:
                        return "No auth Required";
                    case 504:
                        return "User Auth Type";
                    case 505:
                        return "Auth Timeout";
                    case 506:
                        return "Allow While On Body";
                    default:
                        switch (i) {
                            case 701:
                                return "Creation Date Time";
                            case 702:
                                return "Origin";
                            case 703:
                                return "Rollback Resistant";
                            case 704:
                                return "Root of Trust";
                            case 705:
                                return "OS Version";
                            case 706:
                                return "OS Patch Level";
                            default:
                                switch (i) {
                                    case 709:
                                        return "Attestation Application ID";
                                    case 710:
                                        return "Attestation ID Brand";
                                    case 711:
                                        return "Attestation ID Device";
                                    case 712:
                                        return "Attestation ID Product";
                                    default:
                                        switch (i) {
                                            case 716:
                                                return "Attestation ID Manufacturer";
                                            case 717:
                                                return "Attestation ID Model";
                                            case 718:
                                                return "Vendor Patch Level";
                                            case 719:
                                                return "Boot Patch Level";
                                            default:
                                                Log.i(TAG, "printTag() : Unknowm tag : " + i);
                                                return "Unknown tag : " + i;
                                        }
                                }
                        }
                }
        }
    }

    private String printValue(int i, Set<Integer> set) {
        StringBuilder sb = new StringBuilder();
        if (i == 1) {
            for (Integer num : set) {
                sb.append(num);
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    sb.append(" (Encrypt)");
                } else if (iIntValue == 1) {
                    sb.append(" (Decrypt)");
                } else if (iIntValue == 2) {
                    sb.append(" (Sign)");
                } else if (iIntValue == 3) {
                    sb.append(" (Verify)");
                } else if (iIntValue != 5) {
                    Log.w(TAG, "[printValue] Unknown Purpose Value : " + num);
                } else {
                    sb.append(" (WrapKey)");
                }
                sb.append(" / ");
            }
        } else if (i == 5) {
            for (Integer num2 : set) {
                switch (num2.intValue()) {
                    case 0:
                        sb.append("0 (NONE)");
                        break;
                    case 1:
                        sb.append("1 (MD5)");
                        break;
                    case 2:
                        sb.append("2 (SHA-1)");
                        break;
                    case 3:
                        sb.append("3 (SHA-224)");
                        break;
                    case 4:
                        sb.append("4 (SHA-256)");
                        break;
                    case 5:
                        sb.append("5 (SHA-384)");
                        break;
                    case 6:
                        sb.append("6 (SHA-512)");
                        break;
                    default:
                        Log.w(TAG, "[printValue] Unknown Digest Value : " + num2);
                        break;
                }
                sb.append(" / ");
            }
        } else if (i != 6) {
            Log.w(TAG, "[printValue] Unknown Padding Tag : " + i);
        } else {
            for (Integer num3 : set) {
                int iIntValue2 = num3.intValue();
                if (iIntValue2 == 1) {
                    sb.append("1 (NONE)");
                } else if (iIntValue2 == 2) {
                    sb.append("2 (RSA_OAEP)");
                } else if (iIntValue2 == 3) {
                    sb.append("3 (RSA_PSS)");
                } else if (iIntValue2 == 4) {
                    sb.append("4 (PKCS1_1_5_ENCRYPT)");
                } else if (iIntValue2 == 5) {
                    sb.append("5 (PKCS1_1_5_SIGN)");
                } else if (iIntValue2 != 64) {
                    Log.w(TAG, "[printValue] Unknown Padding Value : " + num3);
                } else {
                    sb.append("64 (PKCS7)");
                }
                sb.append(" / ");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 3) : sb.toString();
    }

    public Date getActiveDateTime() {
        return this.mActiveDateTime;
    }

    public Integer getAlgorithm() {
        return this.mAlgorithm;
    }

    public boolean getAllApplications() {
        return this.mAllApplications;
    }

    public boolean getAllowWhileOnBody() {
        return this.mAllowWhileOnBody;
    }

    public byte[] getApplicationId() {
        return this.mApplicationId;
    }

    public AttestationApplicationId getAttestationAppId() {
        return this.mAttestationApplicationId;
    }

    public Integer getAuthTimeout() {
        return this.mAuthTimeout;
    }

    public String getAuthorizationList() {
        return this.mSb.toString();
    }

    public Integer getBootPacthLevel() {
        return this.mBootPatchLevel;
    }

    public String getBrand() {
        return this.mBrand;
    }

    public Date getCreationDateTime() {
        return this.mCreationDateTime;
    }

    public String getDevice() {
        return this.mDevice;
    }

    public Set<Integer> getDigest() {
        return this.mDigest;
    }

    public Integer getEcCurve() {
        return this.mEcCurve;
    }

    public Integer getKeySize() {
        return this.mKeySize;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public String getModel() {
        return this.mModel;
    }

    public boolean getNoAuthRequired() {
        return this.mNoAuthRequired;
    }

    public Integer getOrigin() {
        return this.mOrigin;
    }

    public Date getOriginationExpireDateTime() {
        return this.mOriginationExpireDateTime;
    }

    public Integer getOsPatchLevel() {
        return this.mOsPatchLevel;
    }

    public Integer getOsVersion() {
        return this.mOsVersion;
    }

    public Set<Integer> getPaddingMode() {
        return this.mPaddingMode;
    }

    public String getProduct() {
        return this.mProduct;
    }

    public Set<Integer> getPurpose() {
        return this.mPurpose;
    }

    public boolean getRollBackResistant() {
        return this.mRollbackResistant;
    }

    public RootOfTrust getRootOfTrust() {
        return this.mRootOfTrust;
    }

    public Long getRsaPublicExponent() {
        return this.mRsaPublicExponent;
    }

    public Date getUsageExpireDateTime() {
        return this.mUsageExpireDateTime;
    }

    public Integer getUserAuthType() {
        return this.mUserAuthType;
    }

    public Integer getVendorPacthLevel() {
        return this.mVendorPatchLevel;
    }

    private void addTagInfo(String str, Integer num) {
        Log.i(TAG, "Found [" + str + "] = " + num);
        if (this.mSb.length() > 0) {
            this.mSb.append("\n");
        }
        this.mSb.append(str);
        this.mSb.append("\n   ");
        this.mSb.append(num);
    }

    private void addTagInfo(String str, boolean z) {
        Log.i(TAG, "Found [" + str + "] = " + z);
        if (this.mSb.length() > 0) {
            this.mSb.append("\n");
        }
        this.mSb.append(str);
        this.mSb.append("\n   ");
        this.mSb.append(z);
    }

    private void addTagInfo(String str, Long l) {
        Log.i(TAG, "Found [" + str + "] = " + l);
        if (this.mSb.length() > 0) {
            this.mSb.append("\n");
        }
        this.mSb.append(str);
        this.mSb.append("\n   ");
        this.mSb.append(l);
    }

    private String printValue(int i, Integer num) {
        if (i == 2) {
            int iIntValue = num.intValue();
            if (iIntValue == 1) {
                return AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA;
            }
            if (iIntValue != 3) {
                Log.w(TAG, "[printValue] Unknown Algorithm value : " + num);
            } else {
                return "EC";
            }
        } else if (i != 702) {
            Log.w(TAG, "[printValue] Unknown Tag : " + i);
        } else {
            int iIntValue2 = num.intValue();
            if (iIntValue2 == 0) {
                return "0 (Generated)";
            }
            if (iIntValue2 == 2) {
                return "2 (Imported)";
            }
            if (iIntValue2 != 3) {
                Log.w(TAG, "[printValue] Unknown Origin value : " + num);
            } else {
                return "3 (Unknown)";
            }
        }
        return num.toString();
    }
}
