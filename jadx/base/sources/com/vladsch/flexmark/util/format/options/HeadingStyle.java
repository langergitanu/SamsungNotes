package com.vladsch.flexmark.util.format.options;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum HeadingStyle {
    AS_IS,
    ATX_PREFERRED,
    SETEXT_PREFERRED;

    public boolean isAtx() {
        return this == ATX_PREFERRED;
    }

    public boolean isNoChange() {
        return this == AS_IS;
    }

    public boolean isSetext() {
        return this == SETEXT_PREFERRED;
    }

    public boolean isNoChange(boolean z, int i) {
        if (this == AS_IS) {
            return true;
        }
        if (this != SETEXT_PREFERRED || (!z && i <= 2)) {
            return this == ATX_PREFERRED && !z;
        }
        return true;
    }
}
