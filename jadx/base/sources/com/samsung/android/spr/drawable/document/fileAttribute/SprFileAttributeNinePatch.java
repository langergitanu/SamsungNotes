package com.samsung.android.spr.drawable.document.fileAttribute;

import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprFileAttributeNinePatch extends SprFileAttributeBase {
    public float[] xEnd;
    public int xSize;
    public float[] xStart;
    public float[] yEnd;
    public int ySize;
    public float[] yStart;

    public SprFileAttributeNinePatch() {
        super((byte) 1);
        this.xSize = 0;
        this.xStart = null;
        this.xEnd = null;
        this.ySize = 0;
        this.yStart = null;
        this.yEnd = null;
    }

    @Override // com.samsung.android.spr.drawable.document.fileAttribute.SprFileAttributeBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        int i = sprInputStream.readInt();
        this.xSize = i;
        this.xStart = new float[i];
        this.xEnd = new float[i];
        for (int i2 = 0; i2 < this.xSize; i2++) {
            this.xStart[i2] = sprInputStream.readFloat();
            this.xEnd[i2] = sprInputStream.readFloat();
        }
        int i4 = sprInputStream.readInt();
        this.ySize = i4;
        this.yStart = new float[i4];
        this.yEnd = new float[i4];
        for (int i5 = 0; i5 < this.ySize; i5++) {
            this.yStart[i5] = sprInputStream.readFloat();
            this.yEnd[i5] = sprInputStream.readFloat();
        }
    }

    @Override // com.samsung.android.spr.drawable.document.fileAttribute.SprFileAttributeBase
    public int getSPRSize() {
        return (this.ySize * 8) + (this.xSize * 8) + 8;
    }

    @Override // com.samsung.android.spr.drawable.document.fileAttribute.SprFileAttributeBase
    public boolean isValid() {
        return this.xSize * this.ySize >= 2;
    }

    @Override // com.samsung.android.spr.drawable.document.fileAttribute.SprFileAttributeBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.xSize);
        for (int i = 0; i < this.xSize; i++) {
            dataOutputStream.writeFloat(this.xStart[i]);
            dataOutputStream.writeFloat(this.xEnd[i]);
        }
        dataOutputStream.writeInt(this.ySize);
        for (int i2 = 0; i2 < this.ySize; i2++) {
            dataOutputStream.writeFloat(this.yStart[i2]);
            dataOutputStream.writeFloat(this.yEnd[i2]);
        }
    }

    public SprFileAttributeNinePatch(SprInputStream sprInputStream) throws IOException {
        super((byte) 1);
        this.xSize = 0;
        this.xStart = null;
        this.xEnd = null;
        this.ySize = 0;
        this.yStart = null;
        this.yEnd = null;
        fromSPR(sprInputStream);
    }
}
