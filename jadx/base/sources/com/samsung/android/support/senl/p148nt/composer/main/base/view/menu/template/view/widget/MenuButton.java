package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MenuButton extends ImageView {
    protected static final float DISABLED_ALPHA = 0.2f;
    protected static final float ENABLED_ALPHA = 0.6f;
    private Drawable mDrawable;
    private Matrix mMatrix;

    public MenuButton(Context context) {
        super(context);
    }

    public void rotateMatrix(float f) {
        Drawable drawable;
        Matrix matrix = this.mMatrix;
        if (matrix == null || (drawable = this.mDrawable) == null) {
            return;
        }
        matrix.postRotate(f, drawable.getIntrinsicWidth() / 2.0f, this.mDrawable.getIntrinsicHeight() / 2.0f);
        setImageMatrix(this.mMatrix);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setAlpha(z ? 0.6f : 0.2f);
    }

    public void setMatrix(boolean z) {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mDrawable = getDrawable();
        this.mMatrix = new Matrix();
        rotateMatrix(z ? 0.0f : 180.0f);
    }

    public MenuButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MenuButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
