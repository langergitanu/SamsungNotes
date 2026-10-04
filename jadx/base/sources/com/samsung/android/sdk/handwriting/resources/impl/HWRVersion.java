package com.samsung.android.sdk.handwriting.resources.impl;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HWRVersion implements Comparable<HWRVersion> {
    private static final String TAG = "HWRVersion";
    private final int[] mFields;
    private final String mString;

    public HWRVersion(String str) {
        if (str == null || str.length() == 0) {
            this.mString = "";
            this.mFields = new int[0];
            return;
        }
        this.mString = str;
        int length = str.length();
        int[] iArr = new int[length];
        int iIndexOf = -2;
        int i = 0;
        int i2 = 0;
        while (iIndexOf != -1) {
            iIndexOf = this.mString.indexOf(46, i);
            if (iIndexOf == -1) {
                try {
                    iArr[i2] = Integer.parseInt(this.mString.substring(i, length));
                } catch (NumberFormatException unused) {
                    Log.e(TAG, "Number version " + this.mString + " is corrupted");
                    iArr[i2] = 0;
                }
            } else {
                iArr[i2] = Integer.parseInt(this.mString.substring(i, iIndexOf));
            }
            i2++;
            i = iIndexOf + 1;
        }
        int[] iArr2 = new int[i2];
        this.mFields = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, i2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof HWRVersion) && compareTo((HWRVersion) obj) == 0;
    }

    public int hashCode() {
        return this.mString.hashCode();
    }

    public String toString() {
        return this.mString;
    }

    @Override // java.lang.Comparable
    public int compareTo(HWRVersion hWRVersion) {
        if (this.mString.equals(hWRVersion.mString)) {
            return 0;
        }
        int length = this.mFields.length;
        int length2 = hWRVersion.mFields.length;
        for (int i = 0; i < Math.min(length, length2); i++) {
            if (length == i) {
                return -1;
            }
            if (length2 == i) {
                return 1;
            }
            int i2 = hWRVersion.mFields[i];
            int i4 = this.mFields[i];
            if (i2 > i4) {
                return -1;
            }
            if (i4 > i2) {
                return 1;
            }
        }
        return 0;
    }

    public HWRVersion() {
        this.mString = "";
        this.mFields = new int[0];
    }

    public HWRVersion(HWRVersion hWRVersion) {
        this.mString = hWRVersion.mString;
        this.mFields = hWRVersion.mFields;
    }
}
