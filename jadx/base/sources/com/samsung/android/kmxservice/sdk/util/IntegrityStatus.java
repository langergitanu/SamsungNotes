package com.samsung.android.kmxservice.sdk.util;

import android.util.Log;
import androidx.annotation.NonNull;
import com.samsung.android.kmxservice.sdk.e2ee.data.LogTag;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class IntegrityStatus {
    public static final int ABNORMAL_ICD = 4;
    public static final int ABNORMAL_KERNEL_STATUS = 8;
    public static final int ABNORMAL_SYSTEM_STATUS = 16;
    public static final int ABNORMAL_TRUST_BOOT = 1;
    public static final int ABNORMAL_WARRANTY = 2;
    private static final int AUTH_RESULT = 5;
    private static final int ICD = 2;
    private static final int KERNEL_STATUS = 3;
    public static final int STATUS_ABNORMAL = 1;
    public static final int STATUS_NORMAL = 0;
    public static final int STATUS_NOT_SUPPORT = 2;
    private static final int SYSTEM_STATUS = 4;
    private static final String TAG = LogTag.getTag("IntegrityStatus");
    private static final int TRUST_BOOT = 0;
    private static final int WARRANTY = 1;
    private int mIcd;
    private int mKernelStatus;
    private int mSystemStatus;
    private int mTrustBoot;
    private int mWarranty;

    public IntegrityStatus(ASN1Primitive aSN1Primitive) {
        this.mTrustBoot = -1;
        this.mWarranty = -1;
        this.mIcd = -1;
        this.mKernelStatus = -1;
        this.mSystemStatus = -1;
        Enumeration objects = ((ASN1Sequence) aSN1Primitive).getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.mTrustBoot = aSN1TaggedObject.getObject().getValue().intValue();
            } else if (tagNo == 1) {
                this.mWarranty = aSN1TaggedObject.getObject().getValue().intValue();
            } else if (tagNo == 2) {
                this.mIcd = aSN1TaggedObject.getObject().getValue().intValue();
            } else if (tagNo == 3) {
                this.mKernelStatus = aSN1TaggedObject.getObject().getValue().intValue();
            } else if (tagNo == 4) {
                this.mSystemStatus = aSN1TaggedObject.getObject().getValue().intValue();
            } else if (tagNo != 5) {
                Log.e(TAG, "invalid tag no : " + aSN1TaggedObject.getTagNo());
            }
        }
    }

    public int getIcd() {
        return this.mIcd;
    }

    public int getStatus() {
        int i = this.mTrustBoot;
        if (i == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.mWarranty == 1 ? 2 : 0) | (this.mIcd == 1 ? 4 : 0);
    }

    public int getTrustBoot() {
        return this.mTrustBoot;
    }

    public int getWarranty() {
        return this.mWarranty;
    }

    public boolean isNormal() {
        int i = this.mTrustBoot;
        if (i != 0 && i != 2) {
            return false;
        }
        int i2 = this.mWarranty;
        if (i2 != 0 && i2 != 2) {
            return false;
        }
        int i4 = this.mIcd;
        return i4 == 0 || i4 == 2;
    }

    public String statusToString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? Integer.toHexString(i) : "Not support" : "Abnormal" : "Normal";
    }

    @NonNull
    public String toString() {
        return "    TrustBoot : " + statusToString(this.mTrustBoot) + "\n    Warranty : " + statusToString(this.mWarranty) + "\n    ICD : " + statusToString(this.mIcd);
    }
}
