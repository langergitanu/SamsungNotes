package com.samsung.android.kmxservice.sdk.util;

import androidx.annotation.NonNull;
import java.security.cert.CertificateParsingException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RootOfTrust {
    private static final int DEVICE_LOCKED_INDEX = 1;
    public static final int KM_VERIFIED_BOOT_FAILED = 3;
    public static final int KM_VERIFIED_BOOT_SELF_SIGNED = 1;
    public static final int KM_VERIFIED_BOOT_UNVERIFIED = 2;
    public static final int KM_VERIFIED_BOOT_VERIFIED = 0;
    private static final String LINE_BREAK_3SPACE = "\n   ";
    private static final int VERIFIED_BOOT_HASH_INDEX = 3;
    private static final int VERIFIED_BOOT_KEY_INDEX = 0;
    private static final int VERIFIED_BOOT_STATE_INDEX = 2;
    private final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private boolean mDeviceLocked;
    private byte[] mVerifiedBootHash;
    private byte[] mVerifiedBootKey;
    private int mVerifiedBootState;

    public RootOfTrust(ASN1Encodable aSN1Encodable) throws CertificateParsingException {
        if (!(aSN1Encodable instanceof ASN1Sequence)) {
            throw new CertificateParsingException("Expected sequence for root of trust, found ".concat(aSN1Encodable.getClass().getName()));
        }
        ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Encodable;
        this.mVerifiedBootKey = null;
        this.mDeviceLocked = false;
        this.mVerifiedBootState = -1;
        this.mVerifiedBootHash = null;
        for (int i = 0; i < aSN1Sequence.size(); i++) {
            if (i == 0) {
                this.mVerifiedBootKey = Asn1Utils.getByteArrayFromAsn1(aSN1Sequence.getObjectAt(0));
            } else if (i == 1) {
                this.mDeviceLocked = Asn1Utils.getBooleanFromAsn1(aSN1Sequence.getObjectAt(1));
            } else if (i == 2) {
                this.mVerifiedBootState = Asn1Utils.getIntegerFromAsn1(aSN1Sequence.getObjectAt(2));
            } else if (i == 3) {
                this.mVerifiedBootHash = Asn1Utils.getByteArrayFromAsn1(aSN1Sequence.getObjectAt(3));
            }
        }
    }

    public static String verifiedBootStateToString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "Unknown" : "Failed" : "Unverified" : "Self-signed" : "Verified";
    }

    public byte[] getVerifiedBootKey() {
        return this.mVerifiedBootKey;
    }

    public int getVerifiedBootState() {
        return this.mVerifiedBootState;
    }

    public boolean isDeviceLocked() {
        return this.mDeviceLocked;
    }

    public String toHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(this.DIGITS[(b >>> 4) & 15]);
            sb.append(this.DIGITS[b & 15]);
            sb.append(" ");
        }
        return sb.toString();
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("Verified boot Key :\n   ");
        byte[] bArr = this.mVerifiedBootKey;
        if (bArr != null) {
            sb.append(toHex(bArr));
        }
        sb.append("\n   Device locked : ");
        sb.append(this.mDeviceLocked);
        sb.append("\n   Verified boot state : ");
        sb.append(verifiedBootStateToString(this.mVerifiedBootState));
        if (this.mVerifiedBootHash != null) {
            sb.append("\n   Verified boot hash :\n   ");
            sb.append(toHex(this.mVerifiedBootHash));
        }
        return sb.toString();
    }
}
