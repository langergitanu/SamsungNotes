package com.samsung.android.kmxservice.sdk.util;

import android.util.Log;
import com.samsung.android.kmxservice.sdk.e2ee.data.LogTag;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateParsingException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AttestationPackageInfo implements Comparable<AttestationPackageInfo> {
    private static final int PACKAGE_NAME_INDEX = 0;
    private static final String TAG = LogTag.getTag("AttestationPackageInfo");
    private static final int VERSION_INDEX = 1;
    private final String mPackageName;
    private final long mVersion;

    public AttestationPackageInfo(String str, long j) {
        this.mPackageName = str;
        this.mVersion = j;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AttestationPackageInfo)) {
            return super.equals(obj) || compareTo((AttestationPackageInfo) obj) == 0;
        }
        return false;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public long getVersion() {
        return this.mVersion;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "Package name: " + getPackageName() + "\n        Version: " + getVersion();
    }

    @Override // java.lang.Comparable
    public int compareTo(AttestationPackageInfo attestationPackageInfo) {
        int iCompareTo = this.mPackageName.compareTo(attestationPackageInfo.mPackageName);
        if (iCompareTo != 0) {
            Log.e(TAG, "PackageName is different : expect = " + this.mPackageName + ", compare with = " + attestationPackageInfo.mPackageName);
            return iCompareTo;
        }
        int iCompare = Long.compare(this.mVersion, attestationPackageInfo.mVersion);
        if (iCompare != 0) {
            Log.e(TAG, "Version is different : expect = " + this.mVersion + ", compare with = " + attestationPackageInfo.mVersion);
        }
        return iCompare;
    }

    public AttestationPackageInfo(ASN1Encodable aSN1Encodable) throws CertificateParsingException {
        if (aSN1Encodable instanceof ASN1Sequence) {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Encodable;
            try {
                this.mPackageName = Asn1Utils.getStringFromAsn1OctetStreamAssumingUTF8(aSN1Sequence.getObjectAt(0));
                this.mVersion = Asn1Utils.getLongFromAsn1(aSN1Sequence.getObjectAt(1)).longValue();
                return;
            } catch (UnsupportedEncodingException e) {
                throw new CertificateParsingException("Converting octet stream to String triggered an UnsupportedEncodingException", e);
            }
        }
        throw new CertificateParsingException("Expected sequence for AttestationPackageInfo, found ".concat(aSN1Encodable.getClass().getName()));
    }
}
