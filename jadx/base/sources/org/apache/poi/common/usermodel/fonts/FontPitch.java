package org.apache.poi.common.usermodel.fonts;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum FontPitch {
    DEFAULT(0),
    FIXED(1),
    VARIABLE(2);

    private int nativeId;

    FontPitch(int i) {
        this.nativeId = i;
    }

    public static FontPitch valueOfPitchFamily(byte b) {
        return valueOf(b & 3);
    }

    public int getNativeId() {
        return this.nativeId;
    }

    public static byte getNativeId(FontPitch fontPitch, FontFamily fontFamily) {
        return (byte) (fontPitch.getNativeId() | (fontFamily.getFlag() << 4));
    }

    public static FontPitch valueOf(int i) {
        for (FontPitch fontPitch : values()) {
            if (fontPitch.nativeId == i) {
                return fontPitch;
            }
        }
        return null;
    }
}
