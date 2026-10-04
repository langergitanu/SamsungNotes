package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class LeftCropImageScaleView extends ImageView {
    public LeftCropImageScaleView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i4, int i5) {
        if (getDrawable() != null) {
            float intrinsicHeight = (i5 - i2) / getDrawable().getIntrinsicHeight();
            Matrix imageMatrix = getImageMatrix();
            imageMatrix.setScale(intrinsicHeight, intrinsicHeight, 0.0f, 0.0f);
            setImageMatrix(imageMatrix);
        }
        return super.setFrame(i, i2, i4, i5);
    }

    public LeftCropImageScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LeftCropImageScaleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
