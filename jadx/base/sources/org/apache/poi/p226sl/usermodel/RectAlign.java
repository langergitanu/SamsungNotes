package org.apache.poi.p226sl.usermodel;

import com.samsung.scsp.common.Header;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum RectAlign {
    TOP_LEFT("tl"),
    TOP("t"),
    TOP_RIGHT("tr"),
    LEFT("l"),
    CENTER("ctr"),
    RIGHT("r"),
    BOTTOM_LEFT("bl"),
    BOTTOM("b"),
    BOTTOM_RIGHT(Header.f8126BR);

    private final String dir;

    RectAlign(String str) {
        this.dir = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.dir;
    }
}
