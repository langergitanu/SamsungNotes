package com.samsung.android.spr.drawable.document.attribute;

import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprAttributeStrokeLinejoin extends SprAttributeBase {
    public static byte STROKE_LINEJOIN_TYPE_BEVEL = 3;
    public static byte STROKE_LINEJOIN_TYPE_MITER = 1;
    public static byte STROKE_LINEJOIN_TYPE_NONE = 0;
    public static byte STROKE_LINEJOIN_TYPE_ROUND = 2;
    public byte linejoin;

    public SprAttributeStrokeLinejoin() {
        super((byte) 38);
        this.linejoin = STROKE_LINEJOIN_TYPE_MITER;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void fromSPR(SprInputStream sprInputStream) {
        this.linejoin = sprInputStream.readByte();
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public int getSPRSize() {
        return 1;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.linejoin);
    }

    public SprAttributeStrokeLinejoin(byte b) {
        super((byte) 38);
        this.linejoin = b;
    }

    public SprAttributeStrokeLinejoin(SprInputStream sprInputStream) {
        super((byte) 38);
        this.linejoin = STROKE_LINEJOIN_TYPE_MITER;
        fromSPR(sprInputStream);
    }
}
