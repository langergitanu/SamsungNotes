package com.samsung.android.spr.drawable.document.attribute.impl;

import android.graphics.LinearGradient;
import android.graphics.Matrix;
import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprLinearGradient extends SprGradientBase {

    /* JADX INFO: renamed from: x1 */
    public float f5442x1;

    /* JADX INFO: renamed from: x2 */
    public float f5443x2;

    /* JADX INFO: renamed from: y1 */
    public float f5444y1;

    /* JADX INFO: renamed from: y2 */
    public float f5445y2;

    public SprLinearGradient() {
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.impl.SprGradientBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        this.f5442x1 = sprInputStream.readFloat();
        this.f5444y1 = sprInputStream.readFloat();
        this.f5443x2 = sprInputStream.readFloat();
        this.f5445y2 = sprInputStream.readFloat();
        super.fromSPR(sprInputStream);
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.impl.SprGradientBase
    public int getSPRSize() {
        return super.getSPRSize() + 16;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.impl.SprGradientBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.f5442x1);
        dataOutputStream.writeFloat(this.f5444y1);
        dataOutputStream.writeFloat(this.f5443x2);
        dataOutputStream.writeFloat(this.f5445y2);
        super.toSPR(dataOutputStream);
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.impl.SprGradientBase
    public void updateGradient() {
        LinearGradient linearGradient = new LinearGradient(this.f5442x1, this.f5444y1, this.f5443x2, this.f5445y2, this.colors, this.positions, SprGradientBase.sTileModeArray[this.spreadMode - 1]);
        this.shader = linearGradient;
        Matrix matrix = this.matrix;
        if (matrix != null) {
            linearGradient.setLocalMatrix(matrix);
        }
    }

    public SprLinearGradient(SprInputStream sprInputStream) throws IOException {
        fromSPR(sprInputStream);
    }
}
