package org.apache.poi.java.awt.color;

import org.apache.poi.sun.java2d.cmm.ProfileDeferralInfo;

/* JADX INFO: loaded from: classes10.dex */
public class ICC_ProfileGray extends ICC_Profile {
    static final long serialVersionUID = -1124721290732002649L;

    public ICC_ProfileGray(long j) {
        super(j);
    }

    public float getGamma() {
        return super.getGamma(ICC_Profile.icSigGrayTRCTag);
    }

    @Override // org.apache.poi.java.awt.color.ICC_Profile
    public float[] getMediaWhitePoint() {
        return super.getMediaWhitePoint();
    }

    public short[] getTRC() {
        return super.getTRC(ICC_Profile.icSigGrayTRCTag);
    }

    public ICC_ProfileGray(ProfileDeferralInfo profileDeferralInfo) {
        super(profileDeferralInfo);
    }
}
