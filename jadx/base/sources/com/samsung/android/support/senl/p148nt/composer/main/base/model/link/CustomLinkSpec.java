package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CustomLinkSpec {
    public static final int HYPERLINK_TYPE_ADDRESS = 5;
    public static final int HYPERLINK_TYPE_DATETIME = 6;
    public static final int HYPERLINK_TYPE_EMAIL = 1;
    public static final int HYPERLINK_TYPE_FORMULA = 7;
    public static final int HYPERLINK_TYPE_NONE = 0;
    public static final int HYPERLINK_TYPE_PHONE = 2;
    public static final int HYPERLINK_TYPE_URL = 3;
    int end;
    int start;
    int type;

    public CustomLinkSpec(int i, int i2, int i4) {
        this.type = i;
        this.start = i2;
        this.end = i4;
    }

    public int getEnd() {
        return this.end;
    }

    public int getStart() {
        return this.start;
    }

    public int getType() {
        return this.type;
    }
}
