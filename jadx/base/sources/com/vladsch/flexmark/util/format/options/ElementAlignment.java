package com.vladsch.flexmark.util.format.options;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum ElementAlignment {
    NONE,
    LEFT_ALIGN,
    RIGHT_ALIGN;

    public boolean isLeft() {
        return this == LEFT_ALIGN;
    }

    public boolean isNoChange() {
        return this == NONE;
    }

    public boolean isRight() {
        return this == RIGHT_ALIGN;
    }
}
