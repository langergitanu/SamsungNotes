package com.samsung.android.spr.drawable.document.attribute;

import com.samsung.android.spr.drawable.document.SprInputStream;
import com.samsung.android.spr.drawable.document.attribute.impl.SprGradientBase;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprAttributeFill extends SprAttributeColor {
    public SprAttributeFill() {
        super((byte) 32);
    }

    public SprAttributeFill(byte b, int i) {
        super((byte) 32, b, i);
    }

    public SprAttributeFill(byte b, SprGradientBase sprGradientBase) {
        super((byte) 32, b, sprGradientBase);
    }

    public SprAttributeFill(SprInputStream sprInputStream) {
        super((byte) 32, sprInputStream);
    }
}
