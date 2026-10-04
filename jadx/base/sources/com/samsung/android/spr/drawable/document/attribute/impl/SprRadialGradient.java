package com.samsung.android.spr.drawable.document.attribute.impl;

import android.graphics.Matrix;
import android.graphics.RadialGradient;
import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprRadialGradient extends SprGradientBase {

    /* JADX INFO: renamed from: cx */
    public float f5446cx;

    /* JADX INFO: renamed from: cy */
    public float f5447cy;

    /* JADX INFO: renamed from: r */
    public float f5448r;

    public SprRadialGradient() {
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.impl.SprGradientBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        this.f5446cx = sprInputStream.readFloat();
        this.f5447cy = sprInputStream.readFloat();
        this.f5448r = sprInputStream.readFloat();
        super.fromSPR(sprInputStream);
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.impl.SprGradientBase
    public int getSPRSize() {
        return super.getSPRSize() + 12;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.impl.SprGradientBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.f5446cx);
        dataOutputStream.writeFloat(this.f5447cy);
        dataOutputStream.writeFloat(this.f5448r);
        super.toSPR(dataOutputStream);
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.impl.SprGradientBase
    public void updateGradient() {
        float[] fArr;
        int[] iArr;
        int i;
        int[] iArr2;
        float[] fArr2 = this.positions;
        int length = fArr2.length;
        if (fArr2[length - 1] != 1.0f) {
            length++;
        }
        int i2 = 0;
        float f = fArr2[0];
        if (f != 0.0f) {
            length++;
        }
        int[] iArr3 = this.colors;
        if (length != fArr2.length) {
            int[] iArr4 = new int[length];
            float[] fArr3 = new float[length];
            if (f != 0.0f) {
                iArr4[0] = iArr3[0];
                fArr3[0] = 0.0f;
                i = 1;
            } else {
                i = 0;
            }
            while (true) {
                iArr2 = this.colors;
                if (i2 >= iArr2.length) {
                    break;
                }
                iArr4[i] = iArr2[i2];
                fArr3[i] = this.positions[i2];
                i2++;
                i++;
            }
            float[] fArr4 = this.positions;
            if (fArr4[fArr4.length - 1] != 1.0f) {
                int i4 = length - 1;
                iArr4[i4] = iArr2[fArr4.length - 1];
                fArr3[i4] = 1.0f;
            }
            iArr = iArr4;
            fArr = fArr3;
        } else {
            fArr = fArr2;
            iArr = iArr3;
        }
        RadialGradient radialGradient = new RadialGradient(this.f5446cx, this.f5447cy, this.f5448r, iArr, fArr, SprGradientBase.sTileModeArray[this.spreadMode]);
        this.shader = radialGradient;
        Matrix matrix = this.matrix;
        if (matrix != null) {
            radialGradient.setLocalMatrix(matrix);
        }
    }

    public SprRadialGradient(SprInputStream sprInputStream) throws IOException {
        fromSPR(sprInputStream);
    }
}
