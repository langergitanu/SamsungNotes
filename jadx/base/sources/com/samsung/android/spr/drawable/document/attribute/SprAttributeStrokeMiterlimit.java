package com.samsung.android.spr.drawable.document.attribute;

import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprAttributeStrokeMiterlimit extends SprAttributeBase {
    public float miterLimit;

    public SprAttributeStrokeMiterlimit() {
        super((byte) 41);
        this.miterLimit = 0.0f;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void fromSPR(SprInputStream sprInputStream) {
        this.miterLimit = sprInputStream.readFloat();
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public int getSPRSize() {
        return 4;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.miterLimit);
    }

    public SprAttributeStrokeMiterlimit(SprInputStream sprInputStream) {
        super((byte) 41);
        this.miterLimit = 0.0f;
        fromSPR(sprInputStream);
    }
}
