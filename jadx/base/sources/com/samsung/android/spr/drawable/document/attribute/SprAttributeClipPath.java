package com.samsung.android.spr.drawable.document.attribute;

import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprAttributeClipPath extends SprAttributeBase {
    public int link;

    public SprAttributeClipPath() {
        super((byte) 3);
        this.link = 0;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void fromSPR(SprInputStream sprInputStream) {
        this.link = sprInputStream.readInt();
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public int getSPRSize() {
        return 4;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.link);
    }

    public SprAttributeClipPath(int i) {
        super((byte) 3);
        this.link = i;
    }

    public SprAttributeClipPath(SprInputStream sprInputStream) {
        super((byte) 3);
        this.link = 0;
        fromSPR(sprInputStream);
    }
}
