package org.apache.poi.java.awt.color;

import java.lang.reflect.Array;
import org.apache.poi.sun.java2d.cmm.ProfileDeferralInfo;

/* JADX INFO: loaded from: classes10.dex */
public class ICC_ProfileRGB extends ICC_Profile {
    public static final int BLUECOMPONENT = 2;
    public static final int GREENCOMPONENT = 1;
    public static final int REDCOMPONENT = 0;
    static final long serialVersionUID = 8505067385152579334L;

    public ICC_ProfileRGB(long j) {
        super(j);
    }

    @Override // org.apache.poi.java.awt.color.ICC_Profile
    public float getGamma(int i) {
        int i2;
        if (i == 0) {
            i2 = ICC_Profile.icSigRedTRCTag;
        } else if (i == 1) {
            i2 = ICC_Profile.icSigGreenTRCTag;
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("Must be Red, Green, or Blue");
            }
            i2 = ICC_Profile.icSigBlueTRCTag;
        }
        return super.getGamma(i2);
    }

    public float[][] getMatrix() {
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 3, 3);
        float[] xYZTag = getXYZTag(1918392666);
        fArr[0][0] = xYZTag[0];
        fArr[1][0] = xYZTag[1];
        fArr[2][0] = xYZTag[2];
        float[] xYZTag2 = getXYZTag(1733843290);
        fArr[0][1] = xYZTag2[0];
        fArr[1][1] = xYZTag2[1];
        fArr[2][1] = xYZTag2[2];
        float[] xYZTag3 = getXYZTag(1649957210);
        fArr[0][2] = xYZTag3[0];
        fArr[1][2] = xYZTag3[1];
        fArr[2][2] = xYZTag3[2];
        return fArr;
    }

    @Override // org.apache.poi.java.awt.color.ICC_Profile
    public float[] getMediaWhitePoint() {
        return super.getMediaWhitePoint();
    }

    @Override // org.apache.poi.java.awt.color.ICC_Profile
    public short[] getTRC(int i) {
        int i2;
        if (i == 0) {
            i2 = ICC_Profile.icSigRedTRCTag;
        } else if (i == 1) {
            i2 = ICC_Profile.icSigGreenTRCTag;
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("Must be Red, Green, or Blue");
            }
            i2 = ICC_Profile.icSigBlueTRCTag;
        }
        return super.getTRC(i2);
    }

    public ICC_ProfileRGB(ProfileDeferralInfo profileDeferralInfo) {
        super(profileDeferralInfo);
    }
}
