package org.apache.poi.sun.java2d.cmm;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ProfileDeferralInfo extends InputStream {
    public int colorSpaceType;
    public String filename;
    public int numComponents;
    public int profileClass;

    public ProfileDeferralInfo(String str, int i, int i2, int i4) {
        this.filename = str;
        this.colorSpaceType = i;
        this.numComponents = i2;
        this.profileClass = i4;
    }

    @Override // java.io.InputStream
    public int read() {
        return 0;
    }
}
