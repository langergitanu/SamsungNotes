package com.vladsch.flexmark.util.format;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum TextAlignment {
    LEFT,
    CENTER,
    RIGHT,
    JUSTIFIED;

    public static TextAlignment getAlignment(String str) {
        for (TextAlignment textAlignment : values()) {
            if (textAlignment.name().equalsIgnoreCase(str)) {
                return textAlignment;
            }
        }
        return LEFT;
    }
}
