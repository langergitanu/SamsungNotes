package com.vladsch.flexmark.util.html.p169ui;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FontStyle {
    public final int fontStyle;
    public static final FontStyle PLAIN = new FontStyle(0);
    public static final FontStyle BOLD = new FontStyle(1);
    public static final FontStyle ITALIC = new FontStyle(2);
    public static final FontStyle BOLD_ITALIC = new FontStyle(3);

    private FontStyle(int i) {
        this.fontStyle = i;
    }

    /* JADX INFO: renamed from: of */
    public static FontStyle m13380of(int i) {
        return (i & 3) == 3 ? BOLD_ITALIC : (i & 1) == 1 ? BOLD : (i & 2) == 2 ? ITALIC : PLAIN;
    }

    public boolean isBold() {
        return (this.fontStyle & 1) != 0;
    }

    public boolean isItalic() {
        return (this.fontStyle & 2) != 0;
    }
}
