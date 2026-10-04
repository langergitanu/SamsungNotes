package org.apache.poi.common.usermodel.fonts;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum FontFamily {
    FF_DONTCARE(0),
    FF_ROMAN(1),
    FF_SWISS(2),
    FF_MODERN(3),
    FF_SCRIPT(4),
    FF_DECORATIVE(5);

    private int nativeId;

    FontFamily(int i) {
        this.nativeId = i;
    }

    public static FontFamily valueOfPitchFamily(byte b) {
        return valueOf(b >>> 4);
    }

    public int getFlag() {
        return this.nativeId;
    }

    public static FontFamily valueOf(int i) {
        for (FontFamily fontFamily : values()) {
            if (fontFamily.nativeId == i) {
                return fontFamily;
            }
        }
        return null;
    }
}
