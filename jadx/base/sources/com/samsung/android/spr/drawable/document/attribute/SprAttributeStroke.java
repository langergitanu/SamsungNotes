package com.samsung.android.spr.drawable.document.attribute;

import com.samsung.android.spr.drawable.document.SprInputStream;
import com.samsung.android.spr.drawable.document.attribute.impl.SprGradientBase;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprAttributeStroke extends SprAttributeColor {
    public SprAttributeStroke() {
        super((byte) 35);
    }

    public SprAttributeStroke(byte b, int i) {
        super((byte) 35, b, i);
    }

    public SprAttributeStroke(byte b, SprGradientBase sprGradientBase) {
        super((byte) 35, b, sprGradientBase);
    }

    public SprAttributeStroke(SprInputStream sprInputStream) {
        super((byte) 35, sprInputStream);
    }
}
