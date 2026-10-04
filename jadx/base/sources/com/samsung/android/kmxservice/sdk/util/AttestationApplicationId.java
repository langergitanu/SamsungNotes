package com.samsung.android.kmxservice.sdk.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.WarningType;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AttestationApplicationId implements Comparable<AttestationApplicationId> {
    private static final int PACKAGE_INFOS_INDEX = 0;
    private static final int SIGNATURE_DIGESTS_INDEX = 1;

    @Nullable
    private final List<AttestationPackageInfo> packageInfos;

    @Nullable
    private final List<byte[]> signatureDigests;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ByteArrayComparator implements Comparator<byte[]>, Serializable {
        public /* synthetic */ ByteArrayComparator(int i) {
            this();
        }

        private ByteArrayComparator() {
        }

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int iCompare = Integer.compare(bArr.length, bArr2.length);
            if (iCompare != 0) {
                return iCompare;
            }
            for (int i = 0; i < bArr.length; i++) {
                iCompare = Byte.compare(bArr[i], bArr2[i]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return iCompare;
        }
    }

    @SuppressLint({WarningType.NewApi})
    public AttestationApplicationId(Context context) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        PackageManager packageManager = context.getPackageManager();
        String[] packagesForUid = packageManager.getPackagesForUid(context.getApplicationInfo().uid);
        if (packagesForUid == null || packagesForUid.length == 0) {
            throw new PackageManager.NameNotFoundException("No names found for uid");
        }
        this.packageInfos = new ArrayList();
        int i = 0;
        for (String str : packagesForUid) {
            this.packageInfos.add(new AttestationPackageInfo(str, packageManager.getPackageInfo(str, 0).getLongVersionCode()));
        }
        this.packageInfos.sort(null);
        this.signatureDigests = new ArrayList();
        for (Signature signature : packageManager.getPackageInfo(packagesForUid[0], 134217728).signingInfo.getApkContentsSigners()) {
            this.signatureDigests.add(MessageDigest.getInstance("SHA-256").digest(signature.toByteArray()));
        }
        this.signatureDigests.sort(new ByteArrayComparator(i));
    }

    private List<AttestationPackageInfo> parseAttestationPackageInfos(ASN1Encodable aSN1Encodable) throws CertificateParsingException {
        if (!(aSN1Encodable instanceof ASN1Set)) {
            throw new CertificateParsingException("Expected set for AttestationApplicationsInfos, found ".concat(aSN1Encodable.getClass().getName()));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ASN1Set) aSN1Encodable).iterator();
        while (it.hasNext()) {
            arrayList.add(new AttestationPackageInfo((ASN1Encodable) it.next()));
        }
        return arrayList;
    }

    private List<byte[]> parseSignatures(ASN1Encodable aSN1Encodable) throws CertificateParsingException {
        if (!(aSN1Encodable instanceof ASN1Set)) {
            throw new CertificateParsingException("Expected set for Signature digests, found ".concat(aSN1Encodable.getClass().getName()));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ASN1Set) aSN1Encodable).iterator();
        while (it.hasNext()) {
            arrayList.add(Asn1Utils.getByteArrayFromAsn1((ASN1Encodable) it.next()));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AttestationApplicationId)) {
            return super.equals(obj) || compareTo((AttestationApplicationId) obj) == 0;
        }
        return false;
    }

    public List<AttestationPackageInfo> getAttestationPackageInfos() {
        return this.packageInfos;
    }

    public List<byte[]> getSignatureDigests() {
        return this.signatureDigests;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        if (this.packageInfos == null || this.signatureDigests == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = this.packageInfos.size();
        int i = 1;
        int i2 = 1;
        for (AttestationPackageInfo attestationPackageInfo : this.packageInfos) {
            sb.append("## Package info (");
            sb.append(i2);
            sb.append("/");
            sb.append(size);
            sb.append(") ##\n      ");
            sb.append(attestationPackageInfo);
            i2++;
        }
        int size2 = this.signatureDigests.size();
        for (byte[] bArr : this.signatureDigests) {
            sb.append("\n   ## Signature digest (");
            int i4 = i + 1;
            sb.append(i);
            AbstractC1974b.m1330w(size2, "/", ") ##\n   ", sb);
            int i5 = 0;
            for (byte b : bArr) {
                if (i5 != 0 && i5 % 16 == 0) {
                    sb.append("\n   ");
                }
                i5++;
                sb.append(String.format("%02X ", Byte.valueOf(b)));
            }
            i = i4;
        }
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(AttestationApplicationId attestationApplicationId) {
        List<AttestationPackageInfo> list = this.packageInfos;
        if (list == null || this.signatureDigests == null) {
            return -1;
        }
        int iCompare = Integer.compare(list.size(), attestationApplicationId.packageInfos.size());
        if (iCompare != 0) {
            return iCompare;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.packageInfos.size(); i2++) {
            int iCompareTo = this.packageInfos.get(i2).compareTo(attestationApplicationId.packageInfos.get(i2));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        int iCompare2 = Integer.compare(this.signatureDigests.size(), attestationApplicationId.signatureDigests.size());
        if (iCompare2 != 0) {
            return iCompare2;
        }
        ByteArrayComparator byteArrayComparator = new ByteArrayComparator(i);
        while (i < this.signatureDigests.size()) {
            iCompare2 = byteArrayComparator.compare(this.signatureDigests.get(i), attestationApplicationId.signatureDigests.get(i));
            if (iCompare2 != 0) {
                return iCompare2;
            }
            i++;
        }
        return iCompare2;
    }

    public AttestationApplicationId(ASN1Encodable aSN1Encodable) throws CertificateParsingException {
        if (Build.VERSION.SDK_INT < 28) {
            this.packageInfos = null;
            this.signatureDigests = null;
        } else {
            if (aSN1Encodable instanceof ASN1Sequence) {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Encodable;
                List<AttestationPackageInfo> attestationPackageInfos = parseAttestationPackageInfos(aSN1Sequence.getObjectAt(0));
                this.packageInfos = attestationPackageInfos;
                attestationPackageInfos.sort(null);
                List<byte[]> signatures = parseSignatures(aSN1Sequence.getObjectAt(1));
                this.signatureDigests = signatures;
                signatures.sort(new ByteArrayComparator(0));
                return;
            }
            throw new CertificateParsingException("Expected sequence for AttestationApplicationId, found ".concat(aSN1Encodable.getClass().getName()));
        }
    }
}
