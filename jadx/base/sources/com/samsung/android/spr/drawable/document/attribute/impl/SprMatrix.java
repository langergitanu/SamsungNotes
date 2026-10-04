package com.samsung.android.spr.drawable.document.attribute.impl;

import android.graphics.Matrix;
import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprMatrix {
    public static Matrix fromSPR(SprInputStream sprInputStream) {
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{sprInputStream.readFloat(), sprInputStream.readFloat(), sprInputStream.readFloat(), sprInputStream.readFloat(), sprInputStream.readFloat(), sprInputStream.readFloat(), 0.0f, 0.0f, 1.0f});
        return matrix;
    }

    public static void toSPR(DataOutputStream dataOutputStream, Matrix matrix) throws IOException {
        if (matrix == null) {
            dataOutputStream.writeFloat(1.0f);
            dataOutputStream.writeFloat(0.0f);
            dataOutputStream.writeFloat(0.0f);
            dataOutputStream.writeFloat(0.0f);
            dataOutputStream.writeFloat(1.0f);
            dataOutputStream.writeFloat(0.0f);
            return;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        dataOutputStream.writeFloat(fArr[0]);
        dataOutputStream.writeFloat(fArr[1]);
        dataOutputStream.writeFloat(fArr[2]);
        dataOutputStream.writeFloat(fArr[3]);
        dataOutputStream.writeFloat(fArr[4]);
        dataOutputStream.writeFloat(fArr[5]);
    }
}
