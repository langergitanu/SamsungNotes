package com.samsung.android.spr.drawable.document.attribute;

import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprAttributeStrokeWidth extends SprAttributeBase {
    public float strokeWidth;

    public SprAttributeStrokeWidth() {
        super((byte) 40);
        this.strokeWidth = 0.0f;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        float f = sprInputStream.readFloat();
        this.strokeWidth = f;
        if (f <= 0.0f || f >= 0.3f) {
            return;
        }
        this.strokeWidth = 0.3f;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public int getSPRSize() {
        return 4;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.strokeWidth);
    }

    public SprAttributeStrokeWidth(float f) {
        super((byte) 40);
        this.strokeWidth = f;
    }

    public SprAttributeStrokeWidth(SprInputStream sprInputStream) throws IOException {
        super((byte) 40);
        this.strokeWidth = 0.0f;
        fromSPR(sprInputStream);
    }
}
